package cn.mldn.travel.service.exception;

@SuppressWarnings("serial")
public class LevelNotEnoughException extends Exception {
	public LevelNotEnoughException(String msg) {
		super(msg);
	}
}
