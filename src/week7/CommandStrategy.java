package week7;

import java.util.List;

import week7.JavaChatServer.UserService;

public interface CommandStrategy {
	boolean supports(String name);
	boolean execute(UserService sender, List<String> strs); // 스레드 유지 여부
	String getName();
    String getDescription();
}
