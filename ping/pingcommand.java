import java.net.*;
import java.io.*;
import java.util.*;

class pingcommand{
public static void main(String args[])throws Exception{

  InetAddress ip ;
  String str1,str2="";
  
      //str=br.readLine();
      Scanner in = new Scanner(System.in);
      str1=in.nextLine();
      String[] part=str1.split(" ");
      ip = InetAddress.getByName(part[1]);
      str2=ip.getHostAddress();  
      if(part[0].equals("ping"))
      {
        System.out.println("Pinging "+part[1]+" ["+str2+"] ");
      }

      int i=4;
      int count=0;
      long min=100000000,max=0;
      long avg=0;
      while(i>0)
      {
        boolean p;
        long start = System.currentTimeMillis();
        p=ip.isReachable(2000);
        long end = System.currentTimeMillis();
        long t=end-start;

        if(t<min)
        {
          min=t;
        }
        if(t>max)
        {
          max=t;
        }

        if(p)
        {
          System.out.println("Reply from "+str2+" : time = "+t+"ms TTL = 55");
          count++;
          avg+=t;
        }
        else{
          System.out.println("Request time out");
        }
        i--;
      }

      System.out.println("");
      System.out.println("Ping statistics for "+str2+": ");
      System.out.println("\tPackets: Sent = 4, Recieved = "+count+", Lost = "+(4-count)+" ("+ (4-count)*25 +"% loss),");
      System.out.println("Approximate round trip times in milli-seconds:");
      System.out.println("\tMinimum = "+min+",ms Maximum = "+max+"ms, Average = "+avg);
      // dout.writeUTF(str);
      // dout.flush();
      // str2=din.readUTF();


     //  if(!str2.equals("stop") && !str2.equals("Invalid Host Name"))
    	// 	System.out.println("IP address of given host is: "+str2);

    	// else if(str2.equals("Invalid Host Name"))
    	//  	System.out.println(str2);

    	// else
    	//  	break;
  

}}
