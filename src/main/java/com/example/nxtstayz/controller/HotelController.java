package com.example.nxtstayz.controller;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.service.*;
import com.example.nxtstayz.repository.*;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HotelController {
  @Autowired
  public HotelJpaService hotelJpaService;

  @GetMapping("/hotels")
  public ArrayList<Hotel> getHotels() {
    return hotelJpaService.getHotels();
  }

  @PostMapping("/hotels")
  public Hotel addHotel(@RequestBody Hotel hotel) {
    return hotelJpaService.addHotel(hotel);
  }

  @GetMapping("/hotels/{hotelId}")
  public Hotel getHotelById(@PathVariable("hotelId") int hotelId) {
    return hotelJpaService.getHotelById(hotelId);
  }

  @PutMapping("/hotels/{hotelId}")
  public Hotel updateHotel(@PathVariable("hotelId") int hotelId, @RequestBody Hotel hotel) {
    return hotelJpaService.updateHotel(hotelId, hotel);
  }

  @DeleteMapping("/hotels/{hotelId}")
  public void deeletHotel(@PathVariable("hotelId") int hotelId) {
    hotelJpaService.deleteHotel(hotelId);
  }

  @GetMapping("/hotels/{hotelId}/rooms")
  public ArrayList<Room> getHotelRooms(@PathVariable("hotelId") int hotelId) {
    return hotelJpaService.getHotelRooms(hotelId);
  }
}