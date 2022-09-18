import java.util.Scanner;

import Common.ReadingroomFactory;
import Common.returnmessage;
import User.User;

public class SystemEx extends returnmessage{
	Scanner scan = new Scanner(System.in);
	
	ReadingroomFactory factory = new ReadingroomFactory();

	private String language;
	void run() {
		System.out.println("�ȳ��ϼ���. ������ �Դϴ�.");
		
		int key=0;

		while((key = selectMenu()) != 0){
			User user = factory.getUser();
			user.load(); //�α��� üũ�� ���� �α��� ������ ����� ������ �ҷ��ð��̴�
			switch (key) {
			case 1:
				int userStatus = user.login();
				if(userStatus==9) {//�������� ���
					
				}
				else if(userStatus==1) {//������� ���.
					
				}
				else if(userStatus==0) {
					System.out.println(message(language, "0000"));
					//System.out.println("�ش������ �����Ǿ����ϴ�.");
				}
				break;
			case 2:
				user.signUP();
				break;
			case 3:
				language = "kor";
				break;
			case 4:
				language = "en";
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
	
	int selectMenu() {
		System.out.println(message(language, "0001"));
		
		return Integer.parseInt(scan.nextLine());
	}
}
