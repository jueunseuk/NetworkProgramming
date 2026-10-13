package week7;

import java.util.List;

import week7.JavaChatServer.UserService;

public class HelpCommand implements CommandStrategy {

	@Override
	public boolean supports(String name) {
		return name.equals(getName());
	}

	@Override
	public boolean execute(UserService sender, List<String> strs) {
		sender.WriteOne("**명령어 도움말**\n");
		
        for (CommandStrategy strategy : sender.getAllStrategies()) {
            sender.WriteOne(
                strategy.getName() + " : "
                + strategy.getDescription() + "\n"
            );
        }
		return false;
	}

	@Override
	public String getName() {
		return "/help";
	}

	@Override
	public String getDescription() {
		return "사용 가능한 명령어의 도움말을 표시합니다.";
	}
}
