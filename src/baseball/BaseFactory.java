package baseball;

public class BaseFactory {
	public BaseFactory() {}
	public static BaseFactory instance = new BaseFactory();
	public static BaseFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		
		if (cmd.equals("/main.base")) {
			cmdIf = new BaseballMain();
		} else if (cmd.equals("/input.base")) {
			cmdIf = new InsertPlayer();
		} else if (cmd.equals("/list.base")) {
			cmdIf = new ListPlayer();
		} else if (cmd.equals("/input_ok_player.base")) {
			cmdIf = new InsertOkPlayer();
		} else if (cmd.equals("/list.base")) {
			cmdIf = new ListPlayer();
		} else if (cmd.equals("/list_byteam.base")) {
			cmdIf = new ListByTeam();
		} else if (cmd.equals("/list_byspec.base")) {
			cmdIf = new ListBySpec();
		} else if (cmd.equals("/searchTeam.base")) {
			cmdIf = new SearchTeam();
		}
			
		return cmdIf;
	}
}
