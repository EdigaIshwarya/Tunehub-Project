package com.tunehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.Entity.Song;
import com.tunehub.Entity.Users;

public interface SongRepository extends JpaRepository<Song,Integer>
{
 public Song findByName(String name);
}
