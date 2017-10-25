package board;

public class BoardFactory {
	private BoardFactory() {}
	private static BoardFactory instance = new BoardFactory();
	public static BoardFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		
		if (cmd.equals("/list.board")) {
			cmdIf = new ListBoard();
		}else if (cmd.equals("/writeForm.board")) {
			cmdIf = new WriteFormBoard();
		}else if (cmd.equals("/writePro.board")) {
			cmdIf = new WriteProBoard();
		}else if (cmd.equals("/content.board")) {
			cmdIf = new ContentBoard();
		}else if (cmd.equals("/deleteForm.board")) {
			cmdIf = new DeleteFormBoard();
		}else if (cmd.equals("/deletePro.board")) {
			cmdIf = new DeleteProBoard();
		}else if (cmd.equals("/updateForm.board")) {
			cmdIf = new UpdateFormBoard();
		}else if (cmd.equals("/updatePro.board")) {
			cmdIf = new UpdateProBoard();
		}
		return cmdIf;
	}
}















