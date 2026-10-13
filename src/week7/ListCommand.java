package week7;

import java.util.List;

import week7.JavaChatServer.UserService;

public class ListCommand implements CommandStrategy {

	@Override
	public boolean supports(String name) {
		return name.equals(getName());
	}

	@Override
	public boolean execute(UserService sender, List<String> strs) {
		sender.WriteOne("**현재 사용자 목록**\n");
        for (UserService user : sender.getConnectedUsers()) {
        	sender.WriteOne("- " + user.getUserName() + "\n");
        }
		return false;
	}

	@Override
	public String getName() {
		return "/list";
	}

	@Override
	public String getDescription() {
		return "현재 접속 중인 사용자 목록을 출력합니다.";
	}
}
