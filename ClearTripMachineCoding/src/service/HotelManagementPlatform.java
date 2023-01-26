package service;

import model.Booking;
import model.Hotel;
import model.RoomType;

import java.util.List;

public class HotelManagementPlatform {

    HotelServiceInterface hotelServiceInterface;

    public HotelManagementPlatform(HotelServiceInterface hotelServiceClient) {
        this.hotelServiceInterface = hotelServiceClient;
    }

    public void executeOnboardProperty(Hotel hotel) {
        this.hotelServiceInterface.onboardHotel(hotel);
    }

    public void executeAddInventory(String hotelTitle, RoomType roomType) {
        this.hotelServiceInterface.addInventory(hotelTitle, roomType);
    }

    public List<Hotel> executeSearchWithCity(String city, String checkInDate, String checkOutDate, String priceRange) {
        return this.hotelServiceInterface.searchWithCity(city, checkInDate, checkOutDate, priceRange);
    }

    public void executeBooking(Booking booking) {
        this.hotelServiceInterface.bookRoom(booking);
    }

    public void cancelBooking(String bookingId) {
        this.hotelServiceInterface.cancelBooking(bookingId);
    }
}
