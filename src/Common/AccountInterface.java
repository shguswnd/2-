package Common;

//��������

public interface AccountInterface {
	abstract public void signUP(); //ȸ������
	abstract public int login(); //�α���
	abstract public void delete(); //���� ����
	abstract public void resetPassword(); //�н����� �ʱ�ȭ
	abstract public void save(); //�������� ����
	abstract public void load(); //�������� �ε�
}
