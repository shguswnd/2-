package User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class User1 {

	public static void main(String[] args) {
		boolean pass = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("���̵�� �н����带 �Է��Ͻÿ�.");
		System.out.println("ID �Է� : ");
		String id = scan.nextLine();
		System.out.println("�н����� �Է� : ");
		String pw = scan.nextLine();
		File file = new File("C:\\Users\\USER\\Desktop\\login\\UserDB.txt");
		try {
			FileReader filereader = new FileReader(file); //file�� ������ �о��ش�.
			BufferedReader bufReader = new BufferedReader(filereader); // filereader�� ������ ������ �ִ� Ŭ����
			String line = "";
			try {
				while((line = bufReader.readLine()) != null) //line��  bufReader���� �޸����� �� ���ε��� Ȯ����. null�� �ƴѰ��̿�����.
				{
					System.out.println(line.indexOf(id) + "\t" + line.indexOf(pw)); //���̵�� �н����� ����غ�����.
					int passId = line.indexOf(id); //��ġ���� �ٲ���
					int passPw = line.indexOf(pw);
					if(passId != -1 && passPw != -1) {
						System.out.println("�α��� ����");
					pass = true;
					}
					if(pass == false)
					{
						System.out.println("�α��� ����");
					}
				}
				bufReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

}
