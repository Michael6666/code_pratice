package michael.code;

public class VerifyPermissionHanlder extends MyHandler {

	@Override
	public void doHandler(LoginUser loginUser) {
		if (!"admin".equals(loginUser.getPermission())){
            System.out.println("����Ȩ��");
            return;
        }
        System.out.println("Ȩ��У��ͨ������¼�ɹ�");
	}

}
