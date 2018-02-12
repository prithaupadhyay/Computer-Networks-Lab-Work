import java.net.*;
import java.io.*;
class MyClient{
public static void main(String args[])throws Exception{
  Socket s=new Socket("localhost",3333);
  DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

  String str="",str2="";
  String choice,ch;
  while(!str.equals("stop")){
      str=br.readLine();
      dout.writeUTF(str);
      dout.flush();
      str2=din.readUTF();

      if(!str2.equals("stop"))
      {
        System.out.println(str2);
      if(str2.equals("Select the case:\n1.Upper Case\n2.Lower Case"))
      {
        choice=br.readLine();
        dout.writeUTF(choice);
        ch=din.readUTF();
        System.out.println(ch);
      }
    }

    	else
    	 	break;
  }

  dout.close();
  s.close();
}}
