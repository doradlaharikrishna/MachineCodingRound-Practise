package service;

import model.Booking;
import model.Hotel;
import model.RoomType;

import java.util.List;

public interface HotelServiceInterface {

    void onboardHotel(Hotel hotel);

    void addInventory(String hotelTitle, RoomType roomType);

    List<Hotel> searchWithCity(String city, String checkInDate, String checkOutDate, String priceRange);

    void bookRoom(Booking booking);

    void cancelBooking(String bookingId);
}
