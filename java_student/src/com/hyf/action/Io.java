package com.hyf.action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Io {
 
	private String fileName;

	private FileWriter fw = null;

	private BufferedWriter bw = null;

	private FileReader fr = null;

	private BufferedReader br = null;

	private List<Student> listStu = new ArrayList<Student>();
	
	private List<admin> listAd = new ArrayList<admin>();
	/**
	 * 获得输出流
	 * 
	 * @return
	 */
	public BufferedWriter getOutPutStream() {
			try {
				fw = new FileWriter(fileName, true);
				bw = new BufferedWriter(fw);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return bw;
	}
	
	/**
	 * 关闭输出流
	 */
	public void closeOutPutStream() {
		try {
			fw.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得输入流
	 */
	public BufferedReader getInPutStream() {
		
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return br;
	}
	
	/**
	 * 关闭输出流
	 */
	public void closeInPutStream() {
		try {
			fr.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 检查文件是否存在
	 * 
	 */
	public boolean checkFile() {
		File file = new File(fileName);
		File filePath = file.getParentFile();
		boolean flag = false;
		// 如果指定的文件不存在,则创建该文件
		if (!filePath.exists()) {
			// 先创建文件夹
			filePath.mkdirs();
		} 
	    if (filePath.exists()) {
				try {
					flag = file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				flag = true;
		}
		return flag;
	}
	
	/**
	 * 查询所有数据(初始化)
	 */
	public List<Student> initial() {
		// 首先清空集合
		if (listStu.size() != 0) {
			listStu.clear();
		}
		checkFile();
		BufferedReader br = getInPutStream();
		try {
			String strInfo = br.readLine();
			while (strInfo != null) {
				if (strInfo.indexOf("=") != -1) {
					String[] infos = strInfo.split("=");
					Student def = new Student();
					def.setName(infos[0]);
					def.setSex(infos[1]);
					def.setSno(infos[2]);
					def.setGrade(infos[3]);
					listStu.add(def);
					
				}
				strInfo = br.readLine();
			}
		} catch (IOException e) {
		} finally {
			closeInPutStream();
		}
		
		return listStu;
	}
	
	/**
	 * 查询一行
	 */
	public Student findByKey(String key) {
		// 读取所有文件信息
		listStu = this.initial();
		for (int i = 0; i < listStu.size(); i++) {
			if (key.equals(listStu.get(i).getSno())) {
				return listStu.get(i);
			}
		}
            return null;
	}
	/**
	 * 添加一条记录
	 * 
	 * @return
	 */
	public boolean addInfo(Student def) {
		boolean flag = false; // 添加失败标志变量
		// 读取所有文件信息
		listStu = this.initial();
		for (int i = 0; i < listStu.size(); i++) {
			if (def.getSno().equals(listStu.get(i).getSno())) {
				return flag;
			}
		}
		flag = true; // 添加记录成功
		// 加入集合类中
		listStu.add(def);
		// 写入文件
		
		this.updateFile();
		return flag;
	}
	
	/**
	 * 删除一行 根据ID
	 */
	public boolean deleteInfo(String key) {
		boolean flag = false;
		// 读取所有文件信息
		listStu = this.initial();
		for (int i = 0; i < listStu.size(); i++) {
			if (key.equals(listStu.get(i).getSno())) {
				listStu.remove(i); // 从集合中移出
				// 更新文件
				if (updateFile()) {
					flag = true; // 删除成功
				}
				break;
			}
		}
		return flag;
	}
	public boolean panduan(String key) { 
		listStu = this.initial();
		boolean flag = false;
		for(int i=0;i<listStu.size();i++) {
	    	  if(key.equals(listStu.get(i).sno)) {
		            System.out.println("学号存在"); 
		            flag = true;
		}else {
			
			flag = false;
		}
	   }
		return flag;
	}
	public boolean updateInfo(Student def) {
		boolean flag = false;
		// 读取所有文件信息
		listStu = this.initial();
		for (int i = 0; i < listStu.size(); i++) {
			if (def.getSno().equals(listStu.get(i).getSno())) {
				listStu.set(i, def); // 更新集合
				// 更新文件
				if (updateFile()) {
					flag = true; // 更新成功
				}
				break;
			}
		}
		return flag;
	}
	
	private boolean updateFile() {
		boolean flag = false;
		// 重写文件-->覆盖文件
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			for (int j = 0; j < listStu.size(); j++) {
				bufferedWriter.write(listStu.get(j).getName() + "="
						+ listStu.get(j).getSex()+"="+ listStu.get(j).getSno() 
						+"="+ listStu.get(j).getGrade()  + "\n");
				bufferedWriter.newLine();
			}
			bufferedWriter.flush(); // 清空缓冲
			flag = true; // 删除成功
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				fileWriter.close(); // 关闭流操作
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	public List<admin> ginitial() {
		// 首先清空集合
		if (listAd.size() != 0) {
			listAd.clear();
		}
		checkFile();
		BufferedReader br = getInPutStream();
		try {
			String strInfo = br.readLine();
			while (strInfo != null) {
				if (strInfo.indexOf("=") != -1) {
					String[] infos = strInfo.split("=");
					admin def = new admin();
					def.setName(infos[0]);
					def.setSex(infos[1]);
					def.setAno(infos[2]);
					def.setGrade(infos[3]);
					listAd.add(def);
					
				}
				strInfo = br.readLine();
			}
		} catch (IOException e) {
		} finally {
			closeInPutStream();
		}
		
		return listAd;
	}
	
	
	
	
}
