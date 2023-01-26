package model;

import java.util.HashSet;
import java.util.List;

public class Hotel {
    String title;
    String city;
    int starRating;
    HashSet<String> roomTypeNames;
    List<RoomType> roomTypes;
    int noOfRoomsAvailable;
    List<Booking> bookings;

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public HashSet<String> getRoomTypeNames() {
        return roomTypeNames;
    }

    public void setRoomTypeNames(HashSet<String> roomTypeNames) {
        this.roomTypeNames = roomTypeNames;
    }

    public int getNoOfRoomsAvailable() {
        return noOfRoomsAvailable;
    }

    public void setNoOfRoomsAvailable(int noOfRoomsAvailable) {
        this.noOfRoomsAvailable = noOfRoomsAvailable;
    }
}
