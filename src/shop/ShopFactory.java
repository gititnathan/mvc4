package shop;


public class ShopFactory {
	public ShopFactory() {}
	private static ShopFactory instance = new ShopFactory();
	public static ShopFactory getInstance() {
		return instance;
	}
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		
		if (cmd.equals("/admin.shop")) {
			cmdIf = new ShopMain();
		}else if (cmd.equals("/input.shop")) {
			cmdIf = new InsertCate();
		}else if (cmd.equals("/inputOk.shop")) {
			cmdIf = new InsertOkCate();
		}else if (cmd.equals("/list.shop")) {
			cmdIf = new ListCate();
		}else if (cmd.equals("/delete.shop")) {
			cmdIf = new DeleteCate();
		}else if (cmd.equals("/list_prod.shop")) {
			cmdIf = new ListProd();
		}else if (cmd.equals("/input_prod.shop")) {
			cmdIf = new InsertProduct();
		}else if (cmd.equals("/input_ok_prod.shop")) {
			cmdIf = new InsertOkProduct();
		}else if (cmd.equals("/prod_view.shop")) {
			cmdIf = new ViewProduct();
		}else if (cmd.equals("/delete_prod.shop")) {
			cmdIf = new DeleteProd();
		}else if (cmd.equals("/prod_update_ok.shop")) {
			cmdIf = new ProdUpdateOk();
		}else if (cmd.equals("/prod_update.shop")) {
			cmdIf = new UpdateProd();
		}
			
			
		return cmdIf;
	}
}




