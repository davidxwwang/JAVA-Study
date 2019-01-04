package com.example.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class MutliThread {

    private ServerSocket socket;

    private static final Executor exe = Executors.newFixedThreadPool(10);


    void xx(){
        try{
            socket = new ServerSocket(80);
            while (true){
                final Socket connect =socket.accept();
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        handlerequest(connect);
                    }
                };
                new Thread(task).start();
                exe.execute(task);
            }

        }catch (IOException ex){

        }
    }

    void handlerequest(Socket socket){

    }




}
