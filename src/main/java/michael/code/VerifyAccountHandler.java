package michael.code;

import org.apache.commons.lang3.StringUtils;

public class VerifyAccountHandler extends MyHandler {

	@Override
	public void doHandler(LoginUser loginUser) {
		if (StringUtils.isBlank(loginUser.getLoginName())){
            System.out.println("�û�������Ϊ��");
            return;
        }
        if (StringUtils.isBlank(loginUser.getPassword())){
            System.out.println("���벻��Ϊ��");
            return;
        }
        if (!loginUser.getPassword().equals("123456")){
            System.out.println("���벻��ȷ");
            return;
        }
        System.out.println("�˺�����У��ͨ��");
        
        next.doHandler(loginUser);
	}

}
