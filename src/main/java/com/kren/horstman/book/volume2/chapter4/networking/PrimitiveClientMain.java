package com.kren.horstman.book.volume2.chapter4.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class PrimitiveClientMain {

    public static void main(String[] args) throws UnknownHostException, IOException {

        var socket = new Socket("time-a.nist.gov", 13);

        InputStream inputStream = socket.getInputStream();

        System.out.println("---");
        System.out.println(NetworkingUtil.inputStreamToString(inputStream));
        System.out.println("---");

        socket.close();
    }
}


class NetworkingUtil {
    private static final int BUFFER_SIZE = 1024;

    public static String inputStreamToString(InputStream inputStream) {
        var buffer = new char[BUFFER_SIZE];
        var out = new StringBuilder();
        var in = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        int charsRead;
        try {
            while ((charsRead = in.read(buffer, 0, buffer.length)) > 0) {
                out.append(buffer, 0, charsRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out.toString();
    }
}
