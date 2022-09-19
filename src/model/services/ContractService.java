package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePayment onlinePayment;

	public ContractService(OnlinePayment onlinePayment) {
		this.onlinePayment = onlinePayment;
	}
	
	public void processContract(Contract contract, Integer months) {
	//Dividindo o valor total do contrato pela quantidade de meses
		double partialValue = contract.getTotalValue() / months;
		for(int i = 1; i <= months; i++) {
	//Chamamos a Classe Date e à atribuimos uma data com o mês atual do contrato e uma quantidade a ser adicionada
			Date date = addMonths(contract.getDate(), i);
	//Acessamos o valor base de pagamento e o aplicamos uma taxa com base nesse valor e uma quantidade de meses
			double basePartialValue = partialValue + onlinePayment.monthsTax(partialValue, i);
	//Acessamos o valor mensal com juros e o atribuimos a taxa de pagamento padrão de 2%
			double fullValue = basePartialValue + onlinePayment.tax(basePartialValue);
	//Com o mês acessado e os valores calculados, nós os adicionamos em uma nova parcela calculada
			contract.addInstallment(new Installment(date, fullValue));
		}
	}
	
	//Precisamos criar um método Date para adicionar um valor de meses a data de parcela
	private Date addMonths(Date date, int n) { //private, pois só será acessada por essa classe
		Calendar cal = Calendar.getInstance(); //Primeiro precisamos instanciar essa data com o Calendar
		cal.setTime(date); //Precisamos fazer essa instancia receber a data que passamos
		cal.add(Calendar.MONTH, n); //Precisamos acessar a função MONTH para adicionar os meses "n" vezes
		return cal.getTime(); //Essa função nos permite acessar a data redefinida
	}
}
