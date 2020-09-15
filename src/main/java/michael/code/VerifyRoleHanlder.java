package michael.code;

public class VerifyRoleHanlder extends MyHandler {

	@Override
	public void doHandler(LoginUser loginUser) {
		if(!"admin".equals(loginUser.getRoleName())){
            System.out.println("角色信息有误");
            return;
        }
        System.out.println("角色信息校验通过");
        
        next.doHandler(loginUser);
	}

}
