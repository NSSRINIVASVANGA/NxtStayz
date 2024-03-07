package com.example.nxtstayz.repository;

import com.example.nxtstayz.model.*;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomJpaRepository extends JpaRepository<Room, Integer> {
    ArrayList<Room> findByHotel(Hotel hotel);

}