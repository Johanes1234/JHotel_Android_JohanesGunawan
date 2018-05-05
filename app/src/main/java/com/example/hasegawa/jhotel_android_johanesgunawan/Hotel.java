package com.example.hasegawa.jhotel_android_johanesgunawan;

public class Hotel {
    private static String nama;
    private static Lokasi lokasi;
    private static int bintang;
    private static int id;

    public Hotel(int id, String nama, Lokasi lokasi, int bintang)
    {
        Hotel.nama = nama;
        Hotel.lokasi = lokasi;
        Hotel.bintang = bintang;
        Hotel.id = id;
    }

    /**
     * Method untuk memasukkan nilai bintang
     * @param bintang hotel bintang ...
     */
    public  void setBintang(int bintang)
    {
        Hotel.bintang = bintang;
    }

    /**
     * Method untuk memasukkan nilai nama
     * @param nama nama hotel
     */
    public  void setNama(String nama)
    {
        Hotel.nama = nama;
    }

    /**
     * Method untuk memasukkan nilai lokasi
     * @param lokasi lokasi hotel
     */
    public  void setLokasi(Lokasi lokasi)
    {
        Hotel.lokasi = lokasi;
    }

    public void SetID(int id)
    {
        Hotel.id = id;
    }

    /**
     * Method untuk mendapat nilai bintang
     * @return hotel bintang ...
     */
    public  int getBintang()
    {
        return bintang;
    }

    /**
     * Method untuk mendapat nilai nama
     * @return nama hotel
     */
    public  String getNama()
    {
        return nama;
    }

    /**
     * Method untuk mendapat nilai lokasi
     * @return lokasi hotel
     */
    public  Lokasi getLokasi()
    {
        return lokasi;
    }

    public int getID()
    {
        return id;
    }
}
