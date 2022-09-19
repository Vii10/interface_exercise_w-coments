package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalPayment;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter the contract data");
		System.out.print("Number: ");
		int contractNumber = sc.nextInt();
		System.out.println("Date (dd/MM/yy): ");
		Date contractDate = sdf.parse(sc.next());
		System.out.println("Contract value: ");
		double contractValue = sc.nextDouble();
		
		//Instanciando um contrato com o número, data e valor
		Contract contract = new Contract(contractNumber, contractDate, contractValue);
		
		System.out.println("Enter the number of installments: ");
		int n = sc.nextInt();
		
		//Precisamos chamar a classe de serviço para criar os installments. Por isso vamos chamar essa função.
		ContractService contractService = new ContractService(new PaypalPayment());
		/*A função de cima cria um serviço de contrato e passa a classe que calcula o valor do contrato como argumento.
		 *De inicio, essa linha de código apenas cria um serviço de contrato. Ainda precisamos adicionar os valores do
		 *contrato que serão usados para realizar o calculo.*/
		
		/*A funcao abaixo acessa o metodo para processar o contrato. Então adicionamos o contrato que criamos
		 * junto com a variavel "n", que significa a quantidade de parcelas.*/
		contractService.processContract(contract, n);
		
		System.out.println("Installments: ");
		
		//Percorre as parcelas dentro da classe installments que tem o contrato que passamos antes
		for(Installment x : contract.getInstallments()) {
			System.out.println(x);
		}
		
		sc.close();
	}

}
