package com.tunehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.Entity.Song;
import com.tunehub.Services.SongService;

@Controller
public class SongController
{
   @Autowired
   SongService service;
   @PostMapping("/addSong")
   public String addSong(@ModelAttribute Song song)
   {
	   boolean songStatus=service.songExixts(song.getName());
	   if(songStatus == false)
	   {
		 service.addSong(song);
		 System.out.println("Song added Successfully");
	   }
	   else
	   {
		   System.out.println("Song already Exists");
	   }
	   return "adminHome";
   }
   
   @GetMapping("/viewSongs")
   public String viewSongs(Model model)
   {
	   List<Song> songsList=service.fetchAllSongs();
	   model.addAttribute("songs",songsList);
	   return "displaysongs";
   }
   
   @GetMapping("/playSongs")
   public String playSongs(Model model)
   {
	   boolean premiumUser = false;
	   if(premiumUser == true)
	   {
	   List<Song> songsList=service.fetchAllSongs();
	   model.addAttribute("songs",songsList);
	   return "displaysongs";
	   }
	   else
	   {
		   return "makePayment";
	   }
   }
}
