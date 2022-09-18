package User;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDB1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		File file = new File("C:\\Users\\USER\\Desktop\\login\\UserDB.txt"); //ȸ�� ������ ���� ���� ����.
		String regex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}";
		boolean regexCheck;
		//^���ڿ� ���� : ���̵� �ϳ��� �����ϱ����Ͽ� ����Ҳ���
		//�տ��� ��(��/�ҹ���)�� ���� �������� 4~11�ڸ� ������ �������ڸ� ����Ұ�.
		//Matcher matcher = pattern.matcher(input)
		//matches() : ��� ���ڿ��� ������ ��ġ�ϴ� ��� true ��ȯ
	
		try {
			FileWriter filewriter = new FileWriter(file, true); //true �������� �̾���̴�. true�� ������ ���� ����.
			if(file.isFile() && file.canWrite()) //������ ��¥ �����̸�, ��밡���� �������� ���� �˻�.
			{
				System.out.println("ȸ�������� ���� ID�� �н����带 �Է��Ͻÿ�.");
				System.out.println("ID �Է� : ");
				String test = scan.nextLine();
				//���Խļ���!
				regexCheck = Pattern.matches(regex, test);
				System.out.println(regexCheck);
				
				
				filewriter.append(test); //���͸� ĥ������ ���̵� �Է� �����ϰ�
				
				
				filewriter.append("\t"); // ID�� �н����带 �����ϱ� ���� tabŰ�� �ٲ���. >> tab�� �迭������ ��������.
				System.out.println("�н����� �Է� : ");
				filewriter.append(scan.nextLine()); //���͸� ĥ������ �н����尪 �Է� �����ϰ�
				filewriter.append("\r"); //��������� ȸ������ �����ϰ� ���๮�ڸ� �־���. �����쿡�� \r ���� �޴µ� ??�����δ� \n�����ߴ�.
			}
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
