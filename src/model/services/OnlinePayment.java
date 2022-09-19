/* Criando interface com os métodos não instanciados: tax e monthsTax.
 * Sempre deve-se definir o tipo do método e o tipo de parâmetro que será passado.*/

package model.services;

public interface OnlinePayment {
	
	double tax(double amount);
	double monthsTax(double amount, int months);
}