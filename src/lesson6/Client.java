package lesson6;

import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        final int PORT = 8189;
        final String IP_ADDRESS = "localhost";
        Socket socket;
        DataInputStream in;
        DataOutputStream out;
        Scanner sc;

        try {
            socket = new Socket(IP_ADDRESS, PORT);
            sc = new Scanner(System.in);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        System.out.println(str);

                        if (str.equals("/end")) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        sc.close();
                        in.close();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(() -> {
                try {
                    while (true) {
                        String str = sc.nextLine();
                        out.writeUTF("Клиент: " + str);

                        if (str.equals("/end")) {
                            break;
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

