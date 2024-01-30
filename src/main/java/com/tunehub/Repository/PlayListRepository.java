package com.tunehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.Entity.PlayList;

public interface PlayListRepository extends JpaRepository<PlayList, Integer> {

}
