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
	 * ��������
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
	 * �ر������
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
	 * ���������
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
	 * �ر������
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
	 * ����ļ��Ƿ����
	 * 
	 */
	public boolean checkFile() {
		File file = new File(fileName);
		File filePath = file.getParentFile();
		boolean flag = false;
		// ���ָ�����ļ�������,�򴴽����ļ�
		if (!filePath.exists()) {
			// �ȴ����ļ���
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
	 * ��ѯ��������(��ʼ��)
	 */
	public List<Student> initial() {
		// ������ռ���
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
	 * ��ѯһ��
	 */
	public Student findByKey(String key) {
		// ��ȡ�����ļ���Ϣ
		listStu = this.initial();
		for (int i = 0; i < listStu.size(); i++) {
			if (key.equals(listStu.get(i).getSno())) {
				return listStu.get(i);
			}
		}
            return null;
	}
	/**
	 * ���һ����¼
	 * 
	 * @return
	 */
	public boolean addInfo(Student def) {
		boolean flag = false; // ���ʧ�ܱ�־����
		// ��ȡ�����ļ���Ϣ
		listStu = this.initial();
		for (int i = 0; i < listStu.size(); i++) {
			if (def.getSno().equals(listStu.get(i).getSno())) {
				return flag;
			}
		}
		flag = true; // ��Ӽ�¼�ɹ�
		// ���뼯������
		listStu.add(def);
		// д���ļ�
		
		this.updateFile();
		return flag;
	}
	
	/**
	 * ɾ��һ�� ����ID
	 */
	public boolean deleteInfo(String key) {
		boolean flag = false;
		// ��ȡ�����ļ���Ϣ
		listStu = this.initial();
		for (int i = 0; i < listStu.size(); i++) {
			if (key.equals(listStu.get(i).getSno())) {
				listStu.remove(i); // �Ӽ������Ƴ�
				// �����ļ�
				if (updateFile()) {
					flag = true; // ɾ���ɹ�
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
		            System.out.println("ѧ�Ŵ���"); 
		            flag = true;
		}else {
			
			flag = false;
		}
	   }
		return flag;
	}
	public boolean updateInfo(Student def) {
		boolean flag = false;
		// ��ȡ�����ļ���Ϣ
		listStu = this.initial();
		for (int i = 0; i < listStu.size(); i++) {
			if (def.getSno().equals(listStu.get(i).getSno())) {
				listStu.set(i, def); // ���¼���
				// �����ļ�
				if (updateFile()) {
					flag = true; // ���³ɹ�
				}
				break;
			}
		}
		return flag;
	}
	
	private boolean updateFile() {
		boolean flag = false;
		// ��д�ļ�-->�����ļ�
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
			bufferedWriter.flush(); // ��ջ���
			flag = true; // ɾ���ɹ�
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				fileWriter.close(); // �ر�������
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
		// ������ռ���
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
