package shop.mall;

public class MallFactory {
	private MallFactory() {}
	private static MallFactory instance = new MallFactory();
	public static MallFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if (cmd.equals("/shop.mall")) {
			cmdIf = new ShopMall();
		} else if (cmd.equals("/cgProdList.mall")) {
			cmdIf = new CgProdList();
		} else if (cmd.equals("/prodView.mall")) {
			cmdIf = new ProdViewMall();
		} else if (cmd.equals("/cartList.mall")) {
			cmdIf = new CartListMall();
		} else if (cmd.equals("/cartAdd.mall")) {
			cmdIf = new CartAddMall();
		}else if (cmd.equals("/cartEdit.mall")) {
			cmdIf = new CartEditMall();
		}else if (cmd.equals("/cartDel.mall")) {
			cmdIf = new CartDelMall();
		}else if (cmd.equals("/order.mall")) {
			cmdIf = new OrderMall();
		}
		return cmdIf;
	}
}