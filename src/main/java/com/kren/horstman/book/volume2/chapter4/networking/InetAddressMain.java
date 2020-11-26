package com.kren.horstman.book.volume2.chapter4.networking;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.stream.Stream;

public class InetAddressMain {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("time-a.nist.gov");
        byte[] addressBytes = address.getAddress(); // 129.6.15.28

        System.out.println(address.getHostAddress()); // $ nslookup time-a.nist.gov
        System.out.println(address.getHostName());
        System.out.println(Arrays.toString(addressBytes));

        System.out.println("Google");

        InetAddress[] googleAddresses = InetAddress.getAllByName("google.com");

        Stream.of(googleAddresses)
              .map(InetAddress::getHostAddress)
              .forEach(System.out::println);
    }
}
