package Admin;




import java.util.Scanner;

import Common.ReadingroomFactory;
import Common.accountSystem;
import Common.returnmessage;
import User.User;


public class AdminSystem extends returnmessage implements accountSystem{
	Scanner scan = new Scanner(System.in);
	private String language="kor";
	ReadingroomFactory factory;
	
	
	public AdminSystem(String language) {
		this.language = language;
		this.factory = new ReadingroomFactory();
	}
	@Override
	public void run() {
		System.out.println("������ �������� �����Ͽ����ϴ�.");
		
		int key=0;
		while ((key = selectMenu()) != 0) {
			User user = factory.getUser();
			user.load(); // �α��� üũ�� ���� �α��� ������ ����� ������ �ҷ��ð��̴�
			switch (key) {
			case 1:
				
				break;
			case 2:
				user.signUP();
				break;
			case 0:
				System.out.println("����");
				System.exit(0);
				break;
			default:
				System.out.println("�߸� �����Ͽ����ϴ�.");
				break;
			}
		}

	}
	public void selectAccount(User id) {
		//Ư��ȸ�� ��ȸ
	}
	
	@Override
	public void selectAccount() {
		//ȸ�� ���� ��ȸ
		
	}

	@Override
	public void paymentCancel() {
		//�����ڴ� ȸ�� ���������� ������ �� �ִ�.
		
	}

	@Override
	public void checkSeat() {
		//��ü�¼��� Ȯ���� �� �ִ�.
		
	}
	@Override
	public int selectMenu() {
		System.out.println("1:ȸ������ ��ȸ 2:������� 3:�ڸ���ȸ 0:����");
		return Integer.parseInt(scan.nextLine());
	}
	
	
}
