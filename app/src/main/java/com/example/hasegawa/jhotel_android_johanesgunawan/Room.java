package com.example.hasegawa.jhotel_android_johanesgunawan;

public class Room {
    static double dailyTariff;
    static String statusKamar;
    private static String tipekamar;
    static String roomNumber;

    public Room(String roomNumber, String statusKamar, double dailyTariff, String tipekamar)
    {
        this.roomNumber = roomNumber;
        this.statusKamar = statusKamar;
        this.dailyTariff = dailyTariff;
        this.tipekamar = tipekamar;
    }

    public String getNomorKamar()
    {
        return roomNumber;
    }

    public String getTipekamar()
    {
        return tipekamar;
    }

    public double getDailyTariff()
    {
        return dailyTariff;
    }

    public static String getStatusKamar()
    {
        return statusKamar;
    }

    public void setDailyTariff(double dailyTariff)
    {
        Room.dailyTariff = dailyTariff;
    }

    public void setStatusKamar(String statusKamar)
    {
        Room.statusKamar = statusKamar;
    }

    public void setNomorKamar(String roomNumber)
    {
        Room.roomNumber = roomNumber;
    }

    public void setTipekamar(String tipekamar)
    {
        Room.tipekamar = tipekamar;
    }
}
