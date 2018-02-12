import java.net.*;
import java.io.*;
import java.util.*;

class MyServer{
public static void main(String args[])throws Exception{
  ServerSocket ss=new ServerSocket(3333);
  Socket s=ss.accept();
  DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  InetAddress ip ;
  String str="",str2="",str3="";
  int lower=1,upper=1;
  while(!str.equals("stop")){
      str=din.readUTF();
      if(!str.equals("stop"))
        {
          try{

            if(str.equals(str.toUpperCase()))          //means all are upper case
            {
              dout.writeUTF("new string:"+ str.toLowerCase());
            }

            else if(str.equals(str.toLowerCase()))
            {
              dout.writeUTF("new string:"+ str.toUpperCase());
            }
            else   //mixed case
            {
              dout.writeUTF("Select the case:\n1.Upper Case\n2.Lower Case");
              String choice1=din.readUTF();
              if(choice1.equals("1"))
              {
                dout.writeUTF("new string:"+ str.toUpperCase());
              }
              else
              {
              dout.writeUTF("new string:"+ str.toLowerCase());
              }
            }
           
            }
          catch (Exception e) {
                    dout.writeUTF("Invalid Host Name");
           }
     }

      else
       {
          dout.writeUTF("stop");
          break;
       }
              dout.flush();
  }
  din.close();
  s.close();
  ss.close();
}}
