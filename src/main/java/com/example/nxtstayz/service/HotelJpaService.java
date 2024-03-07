package com.example.nxtstayz.service;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.repository.*;

import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class HotelJpaService implements HotelRepository {
  @Autowired
  public HotelJpaRepository hotelJpaRepository;

  @Autowired
  public RoomJpaRepository roomJpaRepository;

  @Override
  public ArrayList<Hotel> getHotels() {
    List<Hotel> hotelsList = hotelJpaRepository.findAll();
    ArrayList<Hotel> hotels = new ArrayList<>(hotelsList);
    return hotels;
  }

  @Override
  public Hotel addHotel(Hotel hotel) {
    Hotel newHotel = hotelJpaRepository.save(hotel);
    return newHotel;
  }

  @Override
  public Hotel getHotelById(int hotelId) {
    try {
      Hotel hotel = hotelJpaRepository.findById(hotelId).get();
      return hotel;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public Hotel updateHotel(int hotelId, Hotel hotel) {
    try {
      Hotel newHotel = hotelJpaRepository.findById(hotelId).get();
      if (hotel.getHotelName() != null) {
        newHotel.setHotelName(hotel.getHotelName());
      }
      if (hotel.getLocation() != null) {
        newHotel.setLocation(hotel.getLocation());
      }
      if (hotel.getRating() != 0) {
        newHotel.setRating(hotel.getRating());
      }
      hotelJpaRepository.save(newHotel);
      return newHotel;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public void deleteHotel(int hotelId) {
    try {
      Hotel hotel = hotelJpaRepository.findById(hotelId).get();
      List<Room> roomsList = roomJpaRepository.findByHotel(hotel);
      for (Room room : roomsList) {
        room.setHotel(null);
      }
      roomJpaRepository.saveAll(roomsList);
      hotelJpaRepository.deleteById(hotelId);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    throw new ResponseStatusException(HttpStatus.NO_CONTENT);
  }

  @Override
  public ArrayList<Room> getHotelRooms(int hotelId) {
    try {
      Hotel hotel = hotelJpaRepository.findById(hotelId).get();
      return roomJpaRepository.findByHotel(hotel);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }
}