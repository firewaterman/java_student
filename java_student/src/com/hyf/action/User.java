package com.hyf.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
     
	 public   String username;
     public   String password;
     
     public User() {
    	 
     }
     public User(String username,String password ) {
    	 this.username=username;
    	 this.password=password;
     }
     
     public  String getUsername() {
		return username;
	}
	public  void setUsername(String username) {
		this.username = username;
	}
	public  String getPassword() {
		return password;
	}
	public  void setPassword(String password) {
		this.password = password;
	}

	List<User> list=new ArrayList<>();
     Scanner sc=new Scanner(System.in);
     public void yanzheng() throws Exception {
    	 System.out.print("ÇëµÇÂ¼\nÓÃ»§Ãû£º");
         String yuser=sc.next();
         System.out.print("ÃÜ    Âë£º");
         String ypwd=sc.next();
    	 String str="";
    	 File file=new File("D://user.txt");
    	 FileInputStream in=new FileInputStream(file); 
    	 BufferedReader br = new BufferedReader(new InputStreamReader(in));
         str=br.readLine();
         String[] s = str.split(" ");
         for(int i = 0; i < s.length; i++) {
        	 String[] ss = s[i].split("-");
        	 User user = new User(ss[0], ss[1]);
        	 list.add(user);
         }
         boolean flag = false;
         for(int i = 0; i < list.size(); i++) {
        	 if(yuser.equals(list.get(i).getUsername()) && ypwd.equals(list.get(i).getPassword())) {
        		 flag = true;
        	 }
         }
        
         if(flag == true) {
      		 System.out.println("»¶Ó­µÇÂ¼Ñ§Éú»­Ïñ¹ÜÀíÏµÍ³");
      	 }else {
      		 System.out.println("ÕËºÅÃÜÂë´íÎó");
      		 System.exit(0);
      	 }
     }
    	
     public void register() throws IOException {
    	 
    	 File file=new File("D://user.txt");
		 String ruser=this.username;
    	 String rpwd=this.password;
		 System.out.println("»¶Ó­×¢²á");
		 System.out.print("×¢²áÓÃ»§Ãû£º");
		 ruser=sc.next();
		 System.out.print("×¢²áÃÜÂë£º");
		 rpwd=sc.next();
		 FileWriter fw = new FileWriter(file,true);
		 fw.write(ruser+"-");
		 fw.write(rpwd+" ");
         fw.flush();
         fw.close();
     }
     
     
     
     
     public void yanzheng1() throws Exception {
    	 System.out.print("ÇëµÇÂ¼\nÓÃ»§Ãû£º");
         String yuser1=sc.next();
         System.out.print("ÃÜ    Âë£º");
         String ypwd1=sc.next();
    	 String str="";
    	 File file=new File("D://users.txt");
    	 FileInputStream in=new FileInputStream(file); 
    	 BufferedReader br = new BufferedReader(new InputStreamReader(in));
         str=br.readLine();
         String[] s = str.split(" ");
         for(int i = 0; i < s.length; i++) {
        	 String[] ss = s[i].split("-");
        	 User user = new User(ss[0], ss[1]);
        	 list.add(user);
         }
         boolean flag = false;
         for(int i = 0; i < list.size(); i++) {
        	 if(yuser1.equals(list.get(i).getUsername()) && ypwd1.equals(list.get(i).getPassword())) {
        		 flag = true;
        	 }
         }
        
         if(flag == true) {
      		 System.out.println("»¶Ó­¹ÜÀíÔ±µÇÂ¼Ñ§Éú»­Ïñ¹ÜÀíÏµÍ³");
      	 }else {
      		 System.out.println("ÕËºÅÃÜÂë´íÎó");
      		 System.exit(0);
      	 }
     }
     
     
     
     
}
