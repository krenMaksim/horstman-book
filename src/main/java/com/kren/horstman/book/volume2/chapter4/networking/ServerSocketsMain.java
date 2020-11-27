package com.kren.horstman.book.volume2.chapter4.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketsMain {

    public static void main(String[] args) throws IOException {

        var serverSocket = new ServerSocket(8189);

        Socket incoming = serverSocket.accept(); // The command tells the program to wait indefinitely until a client connects to that port.

    }

}
