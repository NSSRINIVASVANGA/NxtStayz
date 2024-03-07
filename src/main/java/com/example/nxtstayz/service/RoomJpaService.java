package com.example.nxtstayz.service;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.repository.*;

import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class RoomJpaService implements RoomRepository {
  @Autowired
  public RoomJpaRepository roomJpaRepository;

  @Autowired
  public HotelJpaRepository hotelJpaRepository;

  @Override
  public ArrayList<Room> getRooms() {
    List<Room> roomsList = roomJpaRepository.findAll();
    ArrayList<Room> rooms = new ArrayList<>(roomsList);
    return rooms;
  }

  @Override
  public Room addRoom(Room room) {
    try {
      Hotel hotel = room.getHotel();
      int hotelId = hotel.getHotelId();
      Hotel newHotel = hotelJpaRepository.findById(hotelId).get();
      room.setHotel(newHotel);
      Room savedRoom = roomJpaRepository.save(room);
      return savedRoom;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public Room getRoomById(int roomId) {
    try {
      Room room = roomJpaRepository.findById(roomId).get();
      return room;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public Room updateRoom(int roomId, Room room) {
    try {
      Room newRoom = roomJpaRepository.findById(roomId).get();
      if (room.getRoomNumber() != null) {
        newRoom.setRoomNumber(room.getRoomNumber());
      }
      if (room.getRoomType() != null) {
        newRoom.setRoomType(room.getRoomType());
      }
      if (room.getPrice() != 0) {
        newRoom.setPrice(room.getPrice());
      }
      if (room.getHotel() != null) {
        Hotel hotel = room.getHotel();
        int hotelId = hotel.getHotelId();
        Hotel newHotel = hotelJpaRepository.findById(hotelId).get();
        newRoom.setHotel(newHotel);
      }
      Room savedRoom = roomJpaRepository.save(newRoom);
      return savedRoom;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public void deleteRoom(int roomId) {
    try {
      roomJpaRepository.deleteById(roomId);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    throw new ResponseStatusException(HttpStatus.NO_CONTENT);
  }

  @Override
  public Hotel getRoomHotel(int roomId) {
    try {
      Room room = roomJpaRepository.findById(roomId).get();
      return room.getHotel();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }
}