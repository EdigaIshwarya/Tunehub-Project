package com.tunehub.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.Entity.Song;
import com.tunehub.Entity.Users;
import com.tunehub.Services.SongService;
import com.tunehub.Services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController 
{
	
  @Autowired
  UsersService service;
  @Autowired
  SongService srv;
  @PostMapping("/register")
  public String addUsers(@ModelAttribute Users user)
  {
	  boolean userStatus=service.emailExists(user.getEmail());
	  if(userStatus==false)
	  {
		  service.addUser(user);
		  System.out.println("user added");
	  }
	  else
	  {
		  System.out.println("user already exists");
	  }
	  
	  return "home";
  }
  @PostMapping("/validate")
  public String validate(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session,Model model)
  {
	 if(service.validateUser(email,password)==true)
	 {
		String role=service.getRole(email);
		session.setAttribute("email",email);
		if(role.equals("Admin"))
		{
			return "adminhome";
		}
			
		else
		{
			Users user=service.getUser(email);

			boolean userStatus=user.isPremium();

			List<Song>songsList=srv.fetchAllSongs();

			model.addAttribute("Songs",songsList);

			model.addAttribute("isPremium",userStatus);
			return "customerhome";
			
		}
		
     }
	 else
	 {
		 return "login";
	 }
}

  @GetMapping("/logout")
  public String logout(HttpSession session)
  {
	  session.invalidate();
	  return "login";
  }
}