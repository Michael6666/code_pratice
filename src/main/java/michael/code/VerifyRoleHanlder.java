package michael.code;

public class VerifyRoleHanlder extends MyHandler {

	@Override
	public void doHandler(LoginUser loginUser) {
		if(!"admin".equals(loginUser.getRoleName())){
            System.out.println("��ɫ��Ϣ����");
            return;
        }
        System.out.println("��ɫ��ϢУ��ͨ��");
        
        next.doHandler(loginUser);
	}

}
