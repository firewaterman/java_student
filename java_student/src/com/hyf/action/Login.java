package com.hyf.action;

import java.util.List;
import java.util.Scanner;

public class Login {
	       Io io=new Io();
	       Scanner sc=new Scanner(System.in);
		   
		   User user=new User();
	       public void sshow() {
	    	 io.setFileName("D:\\people.txt");
	    	System.out.println("����������ѧ�ţ�");
	    	String key=sc.next();
	    	boolean flag = io.panduan(key);
	    	if(flag) {
	    	System.out.println("����\t"+"�Ա�\t"+"ѧ��\t"+"�꼶\t");
	    	Student stu = io.findByKey(key);
	    	System.out.println(stu);
	    }
	    
	    }
	    
	    
	    
	    public void gfindself() {
	    	 io.setFileName("D:\\admin.txt");
	    	 System.out.println("����\t"+"����\t"+"�Ա�\t"+"�ȼ�\t");
			 List<admin> list = io.ginitial();
			 for(int i = 0; i < list.size(); i++) {
				 System.out.println(list.get(i));
			 }
			  }
	    	
	    
	    
	   // gshow() gadd() gupdate() gdelete() Ϊ����Ա��ѧ������ɾ�Ĳ�
	 public void gshow() {
		 io.setFileName("D:\\people.txt");
		 System.out.println("����\t"+"�Ա�\t"+"ѧ��\t"+"�꼶\t");
		 List<Student> list = io.initial();
		 for(int i = 0; i < list.size(); i++) {
			 System.out.println(list.get(i));
		 }
		  }
	 public void gadd() {
		 io.setFileName("D:\\people.txt");
		 Student def = new Student();
		 System.out.print("������");
		 def.name=sc.next();
		 System.out.print("�Ա�");
		 def.sex=sc.next();
		 System.out.print("ѧ�ţ�");
		 def.sno=sc.next();
		 System.out.print("�꼶��");
		 def.grade=sc.next();
		 io.addInfo(def);
		 System.out.println("��ӳɹ�");
		 def=null;	 
	 }
	  
	 public void gupdate() {
		 io.setFileName("D:\\people.txt");
		 Student def = new Student();
		 System.out.println("��ѡ��ѧ��ѧ�ţ�������Ϣ�޸ģ�(ѧ�Ų������޸�)\nѧ�ţ�");	 
		 String key =sc.next();
		 boolean flag = io.panduan(key);
		 if(flag) {
	    		  System.out.println("���޸�������Ϣ��");
	    		     System.out.print("������");
	    			 def.name=sc.next();
	    			 System.out.print("�Ա�");
	    			 def.sex=sc.next();
	    			 System.out.print("ѧ�ţ�");
	    			 def.sno=sc.next();
	    			 System.out.print("�꼶��");
	    			 def.grade=sc.next();
	    			 io.updateInfo(def);
	    			 System.out.println("�޸ĳɹ�");
	    			 def=null;
		 }else {
			 System.out.println("�Ҳ���ѧ��");
		 }
	    	
	    	  }

	 public void gdelete() {
		 io.setFileName("D:\\people.txt");
		System.out.println("������Ҫɾ��ѧ����ѧ�ţ�");
		String key=sc.next();
		boolean flag = io.panduan(key);
	    if(flag == true) {
	    	io.deleteInfo(key);
	        System.out.println("ɾ���ɹ�");
	    }else if(flag == false) {
	    	System.out.println("�Ҳ�����ѧ��");
	    }
	 }


	   public void sjiemian() throws Exception {
		    System.out.println("-----ѧ����¼-----");
			System.out.println("1.ע��\n2.��¼\n��ѡ��");
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
		    System.out.println("*******��ӭ��¼*******");
	    	System.out.println("***��ѡ��Ҫ���еĲ���***");
	    	System.out.println("**|**1.�鿴��������**|**");
	    	System.out.println("**|***2.�ϴ�����*****|*");  	
	    	System.out.println("��ѡ��");
	    	int s2=sc.nextInt();
	    	switch(s2) {
	    	case 1:
            sshow();
            System.out.println("��0����");
  		     int fh=sc.nextInt();
  		     if(fh==0) {
  			  smenu();
  		     }
            break;
	    	case 2:
	    		
	    	
	    	}
	   }
	   
	   
	   public void gjiemian() throws Exception {
		   
			System.out.println("**|***1.����Ա����*****|*");
	    	System.out.println("**|***2.ѧ����Ϣ*****|*"); 
	    	System.out.println("**|***3.�鿴����*****|*"); 

	    	System.out.println("--��ѡ��--"); 
	    	int g1=sc.nextInt();
		   if(g1==1) {
			      gfindself();
	    		  System.out.println("��0����");
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
		   System.out.println("1.�鿴ѧ����Ϣ");
 		   System.out.println("2.�޸�");
 		   System.out.println("3.���");
 		   System.out.println("4.ɾ��");
 		   System.out.println("��ѡ��Ҫ���еĲ�����");
 		   int g2=sc.nextInt();
 		  switch(g2) {
		    case 1:
			 gshow();
			 System.out.println("��0����");
 		     int fh=sc.nextInt();
 		     if(fh==0) {
 			  gtos();
 		  }
			 break;
		   case 2:	    			
			 gupdate();
			 System.out.println("��0����");
 		     int fh1=sc.nextInt();
 		     if(fh1==0) {
 			  gtos();
 		  }
			 break;
		   case 3:	    			
			 gadd();	
			 System.out.println("��0����");
 		     int fh2=sc.nextInt();
 		     if(fh2==0) {
 			  gtos();
 		  }
			 break;
		   case 4:	
		      gdelete();
		      System.out.println("��0����");
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
		System.out.println("******��ӭ���뻭�����ϵͳ******");
		System.out.println("��ѡ���¼����\n1.ѧ��\n2.����Ա");
		Scanner sc=new Scanner(System.in);
		System.out.print("��ѡ��");
		int a=sc.nextInt();
		if(a==1) {
		    l.sjiemian();
		}else {
			System.out.println("-----����Ա��¼-----");
			user.yanzheng1();
		   	l.gjiemian();
		}
		
	}
	
}

