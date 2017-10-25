package member;

public class MemberFactory {
	private MemberFactory() {}
	private static MemberFactory instance = new MemberFactory();
	public static MemberFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		
		if (cmd.equals("/index.member")) {
			cmdIf = new IndexMember();
		}else if (cmd.equals("/join.member")) {
			cmdIf = new JoinMember();
		}else if (cmd.equals("/check.member")) {
			cmdIf = new CheckMember();
		}else if (cmd.equals("/insert.member")) {
			cmdIf = new InsertMember();
		}else if (cmd.equals("/insertOk.member")) {
			cmdIf = new InsertOkMember();
		}else if (cmd.equals("/list.member")) {
			cmdIf = new ListMember();
		}else if (cmd.equals("/delete.member")) {
			cmdIf = new DeleteMember();
		}else if (cmd.equals("/editOk.member")) {
			cmdIf = new EditOkMember();
		}else if (cmd.equals("/edit.member")) {
			cmdIf = new EditMember();
		}else if (cmd.equals("/find.member")) {
			cmdIf = new FindMember();
		}
		
		return cmdIf;
	}
}
