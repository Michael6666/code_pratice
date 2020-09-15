package michael.code;

public class TestChain {

	public static void main(String[] args) {
		MyHandler accountHandler = new VerifyAccountHandler();
        MyHandler roleHanlder = new VerifyRoleHanlder();
        MyHandler permissionHanlder = new VerifyPermissionHanlder();

        accountHandler.next(roleHanlder);
        roleHanlder.next(permissionHanlder);

        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName("孤狼1号");
        loginUser.setPassword("123456");
        loginUser.setRoleName("admin");
        loginUser.setPermission("admin");
        accountHandler.doHandler(loginUser);//从起点开始调用
	}

}
