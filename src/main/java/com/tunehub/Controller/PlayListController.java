package com.tunehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.Entity.PlayList;
import com.tunehub.Entity.Song;
import com.tunehub.Services.PlayListService;
import com.tunehub.Services.SongService;

@Controller
public class PlayListController
{
	@Autowired
	SongService songService;
	@Autowired
    PlayListService playlistService;
	@GetMapping("/createPlaylist")
	public String createplaylist(Model model)
	{
		List<Song>songList=songService.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "createplaylist";
	}
	@PostMapping("/addPlaylist")
	public String addPlayList(@ModelAttribute PlayList  playlist)
	{
		playlistService.addPlaylist(playlist);
		//updating the song table
		List<Song> songList=playlist.getSongs();
		for(Song s: songList)
		{
			s.getPlaylists().add(playlist);
			songService.updateSong(s);
		}
		return "adminhome";
	}
	@GetMapping("/viewPlaylist")
	public String viewPlaylists(Model model)
	{
	List<PlayList> allPlaylist=playlistService.fetchAllplaylists();
	model.addAttribute("allPlaylist",allPlaylist);
	return "displayPlaylist";
	}
}
