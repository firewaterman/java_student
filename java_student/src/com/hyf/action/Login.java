package com.hyf.action;

import java.util.List;
import java.util.Scanner;

public class Login {
	       Io io=new Io();
	       Scanner sc=new Scanner(System.in);
		   
		   User user=new User();
	       public void sshow() {
	    	 io.setFileName("D:\\people.txt");
	    	System.out.println("请输入您的学号：");
	    	String key=sc.next();
	    	boolean flag = io.panduan(key);
	    	if(flag) {
	    	System.out.println("姓名\t"+"性别\t"+"学号\t"+"年级\t");
	    	Student stu = io.findByKey(key);
	    	System.out.println(stu);
	    }
	    
	    }
	    
	    
	    
	    public void gfindself() {
	    	 io.setFileName("D:\\admin.txt");
	    	 System.out.println("姓名\t"+"工号\t"+"性别\t"+"等级\t");
			 List<admin> list = io.ginitial();
			 for(int i = 0; i < list.size(); i++) {
				 System.out.println(list.get(i));
			 }
			  }
	    	
	    
	    
	   // gshow() gadd() gupdate() gdelete() 为管理员对学生的增删改查
	 public void gshow() {
		 io.setFileName("D:\\people.txt");
		 System.out.println("姓名\t"+"性别\t"+"学号\t"+"年级\t");
		 List<Student> list = io.initial();
		 for(int i = 0; i < list.size(); i++) {
			 System.out.println(list.get(i));
		 }
		  }
	 public void gadd() {
		 io.setFileName("D:\\people.txt");
		 Student def = new Student();
		 System.out.print("姓名：");
		 def.name=sc.next();
		 System.out.print("性别：");
		 def.sex=sc.next();
		 System.out.print("学号：");
		 def.sno=sc.next();
		 System.out.print("年级：");
		 def.grade=sc.next();
		 io.addInfo(def);
		 System.out.println("添加成功");
		 def=null;	 
	 }
	  
	 public void gupdate() {
		 io.setFileName("D:\\people.txt");
		 Student def = new Student();
		 System.out.println("请选择学生学号，进行信息修改！(学号不可以修改)\n学号：");	 
		 String key =sc.next();
		 boolean flag = io.panduan(key);
		 if(flag) {
	    		  System.out.println("请修改以下信息：");
	    		     System.out.print("姓名：");
	    			 def.name=sc.next();
	    			 System.out.print("性别：");
	    			 def.sex=sc.next();
	    			 System.out.print("学号：");
	    			 def.sno=sc.next();
	    			 System.out.print("年级：");
	    			 def.grade=sc.next();
	    			 io.updateInfo(def);
	    			 System.out.println("修改成功");
	    			 def=null;
		 }else {
			 System.out.println("找不到学号");
		 }
	    	
	    	  }

	 public void gdelete() {
		 io.setFileName("D:\\people.txt");
		System.out.println("请输入要删除学生的学号：");
		String key=sc.next();
		boolean flag = io.panduan(key);
	    if(flag == true) {
	    	io.deleteInfo(key);
	        System.out.println("删除成功");
	    }else if(flag == false) {
	    	System.out.println("找不到该学号");
	    }
	 }


	   public void sjiemian() throws Exception {
		    System.out.println("-----学生登录-----");
			System.out.println("1.注册\n2.登录\n请选择：");
			int s1=sc.nextInt();
			if(s1==1) {
				user.register();
              user.yanzheng();
			}else {
				user.yanzheng();
			}
			smenu();
			
			
	   }
	   
	   public void smenu() {
		    System.out.println("*******欢迎登录*******");
	    	System.out.println("***请选择要进行的操作***");
	    	System.out.println("**|**1.查看个人资料**|**");
	    	System.out.println("**|***2.上传画像*****|*");  	
	    	System.out.println("请选择：");
	    	int s2=sc.nextInt();
	    	switch(s2) {
	    	case 1:
            sshow();
            System.out.println("按0继续");
  		     int fh=sc.nextInt();
  		     if(fh==0) {
  			  smenu();
  		     }
            break;
	    	case 2:
	    		
	    	
	    	}
	   }
	   
	   
	   public void gjiemian() throws Exception {
		   
			System.out.println("**|***1.管理员资料*****|*");
	    	System.out.println("**|***2.学生信息*****|*"); 
	    	System.out.println("**|***3.查看画像*****|*"); 

	    	System.out.println("--请选择--"); 
	    	int g1=sc.nextInt();
		   if(g1==1) {
			      gfindself();
	    		  System.out.println("按0继续");
	    		  int fh=sc.nextInt();
	    		  if(fh==0) {
	    			  gjiemian();
	    		  }
		   }else if(g1==2) {
			      gtos();
		   }else if(g1==3) {
		          
		   }
	   }
	   
	   public void gtos() {
		   System.out.println("1.查看学生信息");
 		   System.out.println("2.修改");
 		   System.out.println("3.添加");
 		   System.out.println("4.删除");
 		   System.out.println("请选择要进行的操作：");
 		   int g2=sc.nextInt();
 		  switch(g2) {
		    case 1:
			 gshow();
			 System.out.println("按0继续");
 		     int fh=sc.nextInt();
 		     if(fh==0) {
 			  gtos();
 		  }
			 break;
		   case 2:	    			
			 gupdate();
			 System.out.println("按0继续");
 		     int fh1=sc.nextInt();
 		     if(fh1==0) {
 			  gtos();
 		  }
			 break;
		   case 3:	    			
			 gadd();	
			 System.out.println("按0继续");
 		     int fh2=sc.nextInt();
 		     if(fh2==0) {
 			  gtos();
 		  }
			 break;
		   case 4:	
		      gdelete();
		      System.out.println("按0继续");
	   		     int fh3=sc.nextInt();
	   		     if(fh3==0) {
	   			  gtos();
	   		  }
			  break;
		
		}
	   }
	
	   
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Login l=new Login();
		Io io=new Io();
		User user=new User();
		System.out.println("******欢迎进入画像管理系统******");
		System.out.println("请选择登录类型\n1.学生\n2.管理员");
		Scanner sc=new Scanner(System.in);
		System.out.print("请选择：");
		int a=sc.nextInt();
		if(a==1) {
		    l.sjiemian();
		}else {
			System.out.println("-----管理员登录-----");
			user.yanzheng1();
		   	l.gjiemian();
		}
		
	}
	
}

