package Common;
import java.util.HashMap;

public class returnmessage {
	
	
	HashMap<String, String> kor_message = new HashMap<String, String>();
	HashMap<String, String> en_message = new HashMap<String, String>();
	
	
	
	
	void init() {
		kor_message.put("0000", "�ش������ �����Ǿ����ϴ�.");
		kor_message.put("0001","1:�α��� 2:ȸ������ 3:�ѱ� 4:���� 0:����");
		en_message.put("0000", "This account has been suspended.");
		en_message.put("0001", "1:Login 2:Membership 3:Hangul 4:English 0:End");
	}
	
	
	public String message(String language, String key) {
		init();
		String message="";
		if(language=="kor")
		{
			message = kor_message.get(key);
		}
		else {
			message = en_message.get(key);
		}
		return message;
	}
	
}
