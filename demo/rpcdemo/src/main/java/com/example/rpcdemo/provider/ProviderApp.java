package com.example.rpcdemo.provider;

import com.example.rpcdemo.CalculatorRemoteImpl;
import com.example.rpcdemo.Exception.CalculatorException;
import com.example.rpcdemo.RpcdemoApplication;
import com.example.rpcdemo.request.CalculatorRPCRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ProviderApp {

    private static Logger log = LoggerFactory.getLogger(ProviderApp.class);

    private static final int PORT = 9090;


    public static void main(String[] args) throws IOException {
        new ProviderApp().run();
    }

    void run(){

        ServerSocket listener = null;
        try {
            listener = new ServerSocket(9090);
        }catch (IOException ex){
        }

        while (true){

            try{

                Socket socket = listener.accept();

                // 读取数据
                ObjectInputStream objectInputStream =
                        new ObjectInputStream(socket.getInputStream());
                Object object = objectInputStream.readObject();

                if (object instanceof CalculatorRPCRequest){
                    CalculatorRPCRequest request = (CalculatorRPCRequest) object;
                    if (request.getMethod().equals("add"));

                    // 计算数据
                    CalculatorImpl calculator = new CalculatorImpl();
                    Integer result = calculator.add(request.getA(), request.getB());

                    // 返回结果
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(result);

                }else{
                    throw new CalculatorException();
                }


            }catch (Exception ex){

            }
            finally {
                try{
                    listener.close();
                }catch (IOException ex){
                }

            }


        }

    }
}
