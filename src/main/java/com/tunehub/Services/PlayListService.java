package com.tunehub.Services;

import java.util.List;

import com.tunehub.Entity.PlayList;

public interface PlayListService
{

	public  void addPlaylist(PlayList playlist);
	
	public List<PlayList> fetchAllplaylists();

}
