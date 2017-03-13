package pdi26671.CONTROL;

import pdi26671.VIEW.ViewTela;

public class main {

	public static void main(String[] args) {
		CtrlGeral ctrl = new CtrlGeral();
		ViewTela tela = new ViewTela(ctrl);
		ctrl.view(tela);

	}

}
