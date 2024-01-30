package com.tunehub.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.Entity.PlayList;
import com.tunehub.Repository.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService
{
  @Autowired
  PlayListRepository repo;

@Override
public void addPlaylist(PlayList playlist) 
{
	 
		  repo.save(playlist);
	 
}

@Override
public List<PlayList> fetchAllplaylists() {
	return repo.findAll();
}
  
}

