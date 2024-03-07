package com.example.nxtstayz.repository;

import com.example.nxtstayz.model.*;

import java.util.*;

public interface HotelRepository {
  ArrayList<Hotel> getHotels();

  Hotel addHotel(Hotel hotel);

  Hotel getHotelById(int hotelId);

  Hotel updateHotel(int hotelId, Hotel hotel);

  void deleteHotel(int hotelId);

  ArrayList<Room> getHotelRooms(int hotelId);
}