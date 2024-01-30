package com.tunehub.Services;

import java.util.List;

import com.tunehub.Entity.Song;

public interface SongService 
{
  public void addSong(Song song);
  public List<Song> fetchAllSongs();
  public boolean songExixts(String name);
  public void updateSong(Song s);
}
