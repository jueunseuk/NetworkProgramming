package week7;

import java.util.List;

import week7.JavaChatServer.UserService;

public class CountCommand implements CommandStrategy {

	@Override
	public boolean supports(String name) {
		return name.equals(getName());
	}

	@Override
	public boolean execute(UserService sender, List<String> strs) {
        sender.WriteOne("현재 접속자는 "+sender.getConnectedUsers().size()+"명 입니다.\n");
		return false;
	}

	@Override
	public String getName() {
		return "/count";
	}

	@Override
	public String getDescription() {
		return "현재 접속한 사용자 수를 표시합니다.\n";
	}
}
