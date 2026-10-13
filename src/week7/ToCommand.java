package week7;

import java.util.List;

import week7.JavaChatServer.UserService;

public class ToCommand implements CommandStrategy {

	@Override
	public boolean supports(String name) {
		return name.equals(getName());
	}

	@Override
	public boolean execute(UserService sender, List<String> strs) {
		if (strs.size() < 2) {
            sender.WriteOne("사용법: /to [username] [message]\n");
            return false;
        }
		
		String targetUser = strs.get(0);
		strs.remove(0);
        String privateMessage = "";
        
        for(String str : strs) {
        	privateMessage += str+" ";
        }
        privateMessage = privateMessage.trim();
        
        boolean found = false;
        List<UserService> userList = sender.getConnectedUsers();
        for(UserService user : userList) {
        	if(user.getUserName().equals(targetUser)) {
        		found = true;
        		user.WriteOne("[" + user.getUserName() + "님의 귓속말] " + privateMessage + "\n");
        		sender.WriteOne("[" + user.getUserName() + "님의 귓속말] " + privateMessage + "\n");
        	}
        }
        if (!found) {
            sender.WriteOne("사용자 " + targetUser + "를 찾을 수 없습니다.\n");
        }
        
		return false;
	}

	@Override
	public String getName() {
		return "/to";
	}

	@Override
	public String getDescription() {
		return "특정 사용자에게 메세지를 전달합니다.\n사용법: /to username message\\n";
	}
}
