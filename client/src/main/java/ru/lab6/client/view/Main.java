package ru.lab6.client.view;

public class Main {
    public static void main(String[] args){
        IO io = new Console(System.in, System.out);
        MyApplication app = new MyApplication(io);
        app.start();
    }
}
