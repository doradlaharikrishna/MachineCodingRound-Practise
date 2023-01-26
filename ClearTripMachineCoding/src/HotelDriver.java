import model.Booking;
import model.Hotel;
import model.RoomType;
import service.HotelManagementPlatform;
import service.HotelServiceInterface;
import service.impl.HotelServiceClient;

import java.util.*;

public class HotelDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelServiceInterface hotelServiceClient = new HotelServiceClient();
        HotelManagementPlatform hotelManagementPlatform = new HotelManagementPlatform(hotelServiceClient);

        while (true) {
            System.out.println("Welcome to Hotel Management Platform!");
            System.out.println("Enter the UserName");
            String user = scanner.next();
            System.out.println("Enter the command you want to execute");
            String command = scanner.next();

            if (command.equalsIgnoreCase("OnboardProperty")) {

                System.out.println("Enter Hotel Title with out Spaces in between words. keep \"_\" instead of space");
                String title = scanner.next();
                System.out.println("Enter City");
                String city = scanner.next();
                System.out.println("Enter Star Rating of Hotel");
                int starRating = scanner.nextInt();
                System.out.println("Enter no of room types available");
                int roomTypesCount = scanner.nextInt();
                HashSet<String> roomTypes = new HashSet<>();
                for (int i = 1; i <= roomTypesCount; i++) {
                    System.out.println("Enter Room Type: " + i);
                    String roomType = scanner.next();
                    roomTypes.add(roomType);
                }

                Hotel hotel = new Hotel();
                hotel.setRoomTypes(new ArrayList<>());
                hotel.setBookings(new ArrayList<>());
                hotel.setTitle(title);
                hotel.setCity(city);
                hotel.setStarRating(starRating);
                hotel.setRoomTypeNames(roomTypes);
                hotelManagementPlatform.executeOnboardProperty(hotel);
                System.out.println("Onboarded successfully.");
            } else if (command.equalsIgnoreCase("AddInventory")) {

                System.out.println("Enter Room Type details");
                System.out.println("Enter hotel title");
                String hotelTitle = scanner.next();
                System.out.println("Enter room type title");
                String roomTypeName = scanner.next();
                System.out.println("Enter price for room type: " + roomTypeName);
                long price = scanner.nextInt();
                System.out.println("Enter no of rooms available");
                int numberOfRoomsAvailable = scanner.nextInt();
                RoomType roomType = new RoomType();
                String id = UUID.randomUUID().toString();
                roomType.setId(id);
                roomType.setRoomType(roomTypeName);
                roomType.setNumberOfRoomsAvailable(numberOfRoomsAvailable);
                roomType.setNightlyPrice(price);

                HashMap<Integer, HashMap<Integer, HashMap<Integer, Boolean>>> availability = new HashMap<>();
//                fillAvailability availability for last 100 year all 12 months all days in a month using static init
                roomType.setAvailability(availability);
                hotelManagementPlatform.executeAddInventory(hotelTitle, roomType);
                System.out.println("Price and Inventory added Successfully.");
            } else if (command.equalsIgnoreCase("search")) {
                System.out.println("Enter CheckInDate");
                String checkInDate = scanner.next();
                System.out.println("Enter CheckOutDate");
                String checkOutDate = scanner.next();

                System.out.println("Enter city to search");
                String city = scanner.next();

                System.out.println("Enter price range in format 100-200");
                String priceRange = scanner.next();

                List<Hotel> hotels = hotelManagementPlatform.executeSearchWithCity(city, checkInDate, checkOutDate, priceRange);

                System.out.println("Do you want hotel sort by price? Enter yes or no");
                String requirePriceSort = scanner.next();
                if (requirePriceSort.equalsIgnoreCase("yes")) {
                    // sort logic here
                }

                System.out.println("Please find hotel search results below");
                for (Hotel hotel : hotels) {
                    System.out.println("Hotel Title: " + hotel.getTitle() + " rooms: " + hotel.getRoomTypes().toString() + "\n");
                }
            } else if (command.equalsIgnoreCase("book")) {
                System.out.println("Enter hotel title");
                String title = scanner.next();
                System.out.println("Enter room type");
                String roomType = scanner.next();
                System.out.println("Enter CheckInDate");
                String checkInDate = scanner.next();
                System.out.println("Enter CheckOutDate");
                String checkOutDate = scanner.next();

                String bookingId = UUID.randomUUID().toString();
                Booking booking = new Booking();
                booking.setBookingId(bookingId);
                booking.setHotelTitle(title);
                booking.setCheckInDate(checkInDate);
                booking.setCheckOutDate(checkOutDate);
                booking.setRoomType(roomType);
                hotelManagementPlatform.executeBooking(booking);
                System.out.println("Congratulations your booking is confirmed. BookingId: " + bookingId);
            } else if (command.equalsIgnoreCase("cancel_booking")) {
                System.out.println("Enter BookingId");
                String bookingId = scanner.next();
                hotelManagementPlatform.cancelBooking(bookingId);
                System.out.println("Id - " + bookingId + " Canceled successfully");
            }

            System.out.println("Enter 1 to continue executing commands or any other key to exit");
            int key = scanner.nextInt();
            if (key == 1) {
                continue;
            } else {
                break;
            }
        }
    }
}
