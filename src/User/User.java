package User;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Common.Account;
import Common.AccountInterface;

public class User implements AccountInterface{
	
	Scanner scan = new Scanner(System.in);
	
	//key ������ id ���� �ٰ��̸� id���� �ߺ��� �Ұ����ϴ�.
	HashMap<String, Account> account = new HashMap<String, Account>();
	boolean admin_check = true;
	private String id;
	private String password;

	
	//���� ����ȭ
	FileOutputStream fos = null;
	BufferedOutputStream bos = null;
	ObjectOutputStream out = null;
	
	//���� �� ����ȭ
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	ObjectInputStream in = null;
	
	
	Set<String> set;
	
	String filename = "C:\\Users\\USER\\Desktop\\login\\UserDB2.txt";	
	File file = new File(filename);
	

	@Override
	public void signUP(){
		String regex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}";
		boolean regexCheck;
		if(!admin_check) {
			System.out.println("������ ������ �����ϴ�. ������ ������ ������ּ���.");
			System.out.println("ID �Է� : ");
			String id = scan.nextLine();
			System.out.println("�н����� �Է� : ");
			String password = scan.nextLine();
			Account admin = new Account(id, "������", password, "00000000", "00000000", "99999999", 9);
			account.put(id, admin); 
			
			System.out.println("������ ������ �����Ͽ����ϴ�.\n");
			admin_check = true;
		}
		else {
			System.out.println("���̵�� �н����带 �Է��Ͻÿ�.");
			System.out.println("ID �Է� : ");
			String id = scan.nextLine();
			System.out.println("�н����� �Է� : ");
			String password = scan.nextLine();
			Account admin = new Account(id, "������", password, "00000000", "00000000", "99999999");
			account.put(id, admin);
		}
		save();
	}


	@Override
	public int login() {
		System.out.println("���̵�� �н����带 �Է��Ͻÿ�.");
		System.out.println("ID �Է� : ");
		String id = scan.nextLine();
		System.out.println("�н����� �Է� : ");
		String password = scan.nextLine();
		int returnValue=0;
		
		if((!account.containsKey(id))||(!account.get(id).getPassword().equals(password)))
		{
			//��ŷ�õ���, ���̵� Ʋ�ȴ��� �н����尡 Ʋ�ȴ��� Ȯ�ι���.
			System.out.println("���̵� �Ǵ� �н����尡 Ʋ�Ƚ��ϴ�.");
			returnValue = -1;
		}
		else if (account.get(id).getPassword().equals(password)) {
			returnValue = account.get(id).getStatus();
		}

		return returnValue;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetPassword() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void save(){
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			out = new ObjectOutputStream(bos);
			
			out.writeObject(account);
			System.out.println(out);
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				out.close();
				bos.close();
				fos.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}
	@Override
	public void load() {
		//������ȭ�� ������ ������ ����.

		try {
			// ������ ������� ����.
			if (!file.exists())
				file.createNewFile();

				fis = new FileInputStream(file);
//				if (fis.read() == -1) {
				if (fis.getChannel().size() == 0) {
					admin_check = false;
					signUP();
					// ������ ������ ������� ������ ���ָ� �Ʒ� fis�� ������ �ִ� ������ ���Ϸ� �����Ƿμ� ���ܹ߻� x
					fis = new FileInputStream(file);
				}
				bis = new BufferedInputStream(fis);
				in = new ObjectInputStream(bis);
				
				account = (HashMap)in.readObject();
//				System.out.println(account);
//				Set<String> test = account.keySet();
				
//				for(String value : test) {
//					String test1 = account.get(value).toString(); 
//				}
				
			
		} catch (FileNotFoundException e) {
			//User Ŭ���� �����ڶ� ���� ��ü�� �������� ���� ���� �����̳� �ٸ� �̻��������� ���� ������ �ȵɰ�� �޼��� ���
			System.out.println("������ �������� �ʾƿ�.");
		} catch (EOFException e) {
			System.out.println("�� " + e.getMessage());
		} catch (IOException e) {
			System.out.println("������ ���� �� �����."+ e.getMessage());	
		}  catch (Exception e) {
			System.out.println("������ ���� : " + e.getMessage());
		}finally {
			try {
				in.close();
				bis.close();
				fis.close();
			}catch (Exception e) {
			}
		}
		/*
		 * �������� �Ƚ����µ�?
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */	
	}
}
