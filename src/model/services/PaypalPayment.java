/* Associando a interface à essa classe através do "implements".
 * Para criar uma variável exclusiva da classe e que se mantem a mesma durante a execução
 * se utiliza o private static final.
 * A classe atual tem o papel de instanciar o contrato da interface conforme a necessidade.*/

package model.services;

public class PaypalPayment implements OnlinePayment{

	private static final double TAX = 0.02;
	private static final double MONTHS_TAX = 0.01;
	
	@Override
	public double tax(double amount) {
		return amount * TAX;
	}

	@Override
	public double monthsTax(double amount, int months) {
		return amount * MONTHS_TAX * months;
	}
	
}
