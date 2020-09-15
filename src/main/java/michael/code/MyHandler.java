package michael.code;

public abstract class MyHandler {
	protected MyHandler next;

    public void next(MyHandler handler){
        this.next = handler;
    }

    public abstract void doHandler(LoginUser loginUser);
}
