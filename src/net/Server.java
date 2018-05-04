package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author:oldmanw
 * create at:2018-05-04 16:44
 * socket服务端
 */
public class Server {

    public static void main(String[] args) {
        Server server = new Server();
        server.createServer();
    }

    private void createServer() {
        ServerSocket serverSocket;
        Socket socket;
        try {
            int portNum = 12345;
            serverSocket = new ServerSocket(portNum);
            System.out.println("Server started at port: " + portNum);
            socket = serverSocket.accept();

            //业务代码
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //由Socket对象得到输入流，并构造相应的BufferedReader对象
            PrintWriter writer=new PrintWriter(socket.getOutputStream());
            //由Socket对象得到输出流，并构造PrintWriter对象
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            //由系统标准输入设备构造BufferedReader对象
            System.out.println("Client:"+in.readLine());
            //在标准输出上打印从客户端读入的字符串
            String line=br.readLine();
            //从标准输入读入一字符串
            //4、获取输出流，响应客户端的请求
            while(!line.equals("bye")){
                //如果该字符串为 "bye"，则停止循环
                writer.println(line);
                //向客户端输出该字符串
                writer.flush();
                //刷新输出流，使Client马上收到该字符串
                System.out.println("Server:"+line);
                //在系统标准输出上打印读入的字符串
                System.out.println("Client:"+in.readLine());
                //从Client读入一字符串，并打印到标准输出上
                line=br.readLine();
                //从系统标准输入读入一字符串
            }

            //关闭资源
            writer.close();
            in.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
