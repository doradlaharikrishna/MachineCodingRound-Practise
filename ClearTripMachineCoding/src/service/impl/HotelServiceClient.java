package service.impl;

import model.Booking;
import model.Hotel;
import model.RoomType;
import service.HotelManagementPlatform;
import service.HotelServiceInterface;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class HotelServiceClient implements HotelServiceInterface {

    HashMap<String, Hotel> hotels;
    HashSet<String> hotelTitles;
    HashMap<String, Hotel> bookingList;

    public HotelServiceClient() {
        this.hotels = new HashMap<>();
        this.hotelTitles = new HashSet<>();
        this.bookingList = new HashMap<>();
    }

    @Override
    public void onboardHotel(Hotel hotel) {
        if (!this.hotelTitles.contains(hotel.getTitle())) {
            this.hotels.put(hotel.getTitle(), hotel);
            this.hotelTitles.add(hotel.getTitle());
        } else {
            System.out.println("Already a hotel with title: " + hotel.getTitle() + "is present in System. " +
                    "Please try different hotel title");
        }
    }

    @Override
    public void addInventory(String hotelTitle, RoomType roomType) {
        if (this.hotelTitles.contains(hotelTitle)) {
            this.hotels.get(hotelTitle).getRoomTypes().add(roomType);
        } else {
            System.out.println("Hotel with title: " +hotelTitle + "is not present in System. " +
                    "Please try with right hotel title");
        }
    }

    @Override
    public List<Hotel> searchWithCity(String city, String checkInDate, String checkOutDate, String priceRange) {
        List<Hotel> hotelresult = new ArrayList<>();
        long fromPrice = Integer.parseInt(priceRange.split("-")[0]);
        long toPrice = Integer.parseInt(priceRange.split("-")[1]);
        int fromDate = Integer.parseInt(checkInDate.split("-")[0]);
        int fromMonth = Integer.parseInt(checkInDate.split("-")[1]);
        int fromYear = Integer.parseInt(checkInDate.split("-")[2]);
        int toDate = Integer.parseInt(checkOutDate.split("-")[0]);
        int toMonth = Integer.parseInt(checkOutDate.split("-")[1]);
        int toYear = Integer.parseInt(checkOutDate.split("-")[2]);

        for (Hotel hotel : this.hotels.values()) {
            if (hotel.getNoOfRoomsAvailable() <= 0) continue;
            if (!hotel.getCity().equalsIgnoreCase(city)) continue;

            boolean dayNotAvailable = false;
            Hotel hoteltemp = new Hotel();
            List<RoomType> roomTypes = new ArrayList<>();
            hoteltemp.setRoomTypes(roomTypes);
            for (RoomType roomType : hotel.getRoomTypes()) {
                if (roomType.getNightlyPrice() >= fromPrice && roomType.getNightlyPrice() <= toPrice) {
                    for (int i = fromYear; i <= toYear; i++) {
                        for (int j = fromMonth; j <= toMonth; j++) {
                            for (int k = fromDate; k <= toDate; k++) {
                                if(!roomType.getAvailability().get(i).get(j).get(k)) {
                                    dayNotAvailable = true;
                                    break;
                                }
                            }
                            if (dayNotAvailable) {
                                break;
                            }
                        }
                        if (dayNotAvailable) {
                            break;
                        }
                    }

                    if (!dayNotAvailable)  {
                        hoteltemp.setTitle(hotel.getTitle());
                        hoteltemp.getRoomTypes().add(roomType);
                        hotelresult.add(hoteltemp);
                    }
                }
            }
        }

        return hotelresult;
    }

    @Override
    public void bookRoom(Booking booking) {
        Hotel hotel = this.hotels.get(booking.getHotelTitle());
        hotel.setNoOfRoomsAvailable(hotel.getNoOfRoomsAvailable() - 1);
        hotel.getBookings().add(booking);
        bookingList.put(booking.getBookingId(), hotel);
    }

    @Override
    public void cancelBooking(String bookingId) {
        Hotel hotel = this.bookingList.get(bookingId);
        List<Booking> bookings = hotel.getBookings();
        for (Booking booking : bookings) {
            if (booking.getBookingId().equalsIgnoreCase(bookingId)) {
                booking.setIsActive(false);
            }
        }
    }
}
