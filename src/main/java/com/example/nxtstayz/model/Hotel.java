package com.example.nxtstayz.model;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int hotelId;
    @Column(name = "name")
    private String hotelName;
    @Column(name = "location")
    private String location;
    @Column(name = "rating")
    private int rating;

    public Hotel() {
    }

    public Hotel(int hotelId, String hotelName, String location, int rating) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.location = location;
        this.rating = rating;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getLocation() {
        return location;
    }

    public int getRating() {
        return rating;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}