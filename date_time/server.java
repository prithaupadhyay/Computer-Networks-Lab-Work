import java.net.*;
import java.io.*;
import java.util.*;

class server{
public static void main(String args[])throws Exception{
  ServerSocket ss=new ServerSocket(3333);
  Socket s=ss.accept();
  DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  InetAddress ip ;
  String str="",str2="",str3="";
  Date d=new Date();

  dout.writeUTF(d.toString());

              dout.flush();
  }
 
}
