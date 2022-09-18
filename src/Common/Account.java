
package Common;

import java.io.Serializable;

//��������

public class Account implements Serializable{
	private String id; //id
	private String name; //�̸�
	private String password; //�н�����
	private String birthday; //����
	private String startday; //������
	private String endday; //������
	private int status; //���� ���� (1 : �����  0 : ���� ����  9 : ������)
	private static final long serialVersionUID = (long)5746694569156904189.0;
	//serialversionuid ���� ������ ���ϸ� ���ð� Ŭ���̾�Ʈ���� �ڵ����� �����Ǵ� hash������ ���� �߻���.
	

	public Account(String id, String name, String password, String birthday, String startday, String endday) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.startday = startday;
		this.endday = endday;
	}
	public Account(String id, String name, String password, String birthday, String startday, String endday, int status) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.startday = startday;
		this.endday = endday;
		this.status = status;
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getStartday() {
		return startday;
	}
	public String getEndday() {
		return endday;
	}
	public int getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", password=" + password + ", birthday=" + birthday
				+ ", startday=" + startday + ", endday=" + endday + ", status=" + status + "]";
	}
	
	
	
	
}
