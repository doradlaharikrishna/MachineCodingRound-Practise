package model;

import java.util.HashMap;

public class RoomType {
    String id;
    String roomType;
    long nightlyPrice;
    int numberOfRoomsAvailable;
    HashMap<Integer, HashMap<Integer, HashMap<Integer, Boolean>>> availability;

    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Boolean>>> getAvailability() {
        return availability;
    }

    public void setAvailability(HashMap<Integer, HashMap<Integer, HashMap<Integer, Boolean>>> availability) {
        this.availability = availability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public long getNightlyPrice() {
        return nightlyPrice;
    }

    public void setNightlyPrice(long nightlyPrice) {
        this.nightlyPrice = nightlyPrice;
    }

    public int getNumberOfRoomsAvailable() {
        return numberOfRoomsAvailable;
    }

    public void setNumberOfRoomsAvailable(int numberOfRoomsAvailable) {
        this.numberOfRoomsAvailable = numberOfRoomsAvailable;
    }
}
