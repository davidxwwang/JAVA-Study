package com.example.rpcdemo;

import com.example.rpcdemo.Exception.CalculatorException;
import com.example.rpcdemo.provider.Calculator;
import com.example.rpcdemo.request.CalculatorRPCRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CalculatorRemoteImpl implements Calculator {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final int PORT = 9090;

    @Override
    public Integer add(Integer a, Integer b) {

        List<String> addressList = lookupProviders("Calculator.add");

        String address = null;
        try{
            address = chooseTarget(addressList);
        }catch (CalculatorException ex){
            return -1;
        }

        try {
            Socket socket = new Socket(address, PORT);

            // 将请求序列化
            CalculatorRPCRequest calculateRpcRequest = generateRequest(a, b);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            // 将请求发给服务提供方
            objectOutputStream.writeObject(calculateRpcRequest);

            // 将响应体反序列化
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object response = objectInputStream.readObject();

            if (response instanceof Integer) {
                return (Integer) response;
            } else {
                throw new InternalError();
            }

        } catch (Exception e) {
            logger.error("fail", e);
            throw new InternalError();
        }
    }

    private List<String> lookupProviders(String name){
        List<String> providersList = new ArrayList<>();
        providersList.add("127.0.0.1");
        return providersList;

    }

    private String chooseTarget(List<String> providersList) throws CalculatorException{
        if (providersList == null || providersList.size() == 0){
            throw new CalculatorException();
        }

        return providersList.get(0);
    }

    private CalculatorRPCRequest generateRequest(Integer a, Integer b){

        CalculatorRPCRequest request = new CalculatorRPCRequest();
        request.setA(a);
        request.setB(b);
        request.setMethod("add");

        return request;

    }
}
