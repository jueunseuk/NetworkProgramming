package week7;

import java.util.List;

import week7.JavaChatServer.UserService;

public class ExitCommand implements CommandStrategy {

	@Override
	public boolean supports(String name) {
		return name.equals(getName());
	}

	@Override
	public boolean execute(UserService sender, List<String> strs) {
		return true;
	}

	@Override
	public String getName() {
		return "/exit";
	}

	@Override
	public String getDescription() {
		return "채팅 서버에서 로그아웃합니다.";
	}

}
