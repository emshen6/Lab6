package ru.lab6.server.connection;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    private SocketChannel socketChannel;

    public void receiveRequest() throws IOException, ClassNotFoundException {
        socketChannel = createSocketChannel();
        ObjectInputStream objectInputStream = new ObjectInputStream(socketChannel.socket().getInputStream());
        JsonObject request = (JsonObject) objectInputStream.readObject(); //�������� ��������������� ������
        socketChannel.close();
    }

    private SocketChannel createSocketChannel() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open(); //����� ���������� ������
        serverSocketChannel.socket().bind(new InetSocketAddress(9100)); //������� �����-������ ��������� �����
        socketChannel = serverSocketChannel.accept(); //��������� �����������
        return socketChannel;
    }
}
