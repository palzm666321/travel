package cn.mldn.travel.service.exception;

@SuppressWarnings("serial")
public class DeptManagerExistException extends RuntimeException{
	public DeptManagerExistException(String msg) {
		super(msg);
	}
}
