/* A Classe Contract é exclusiva para receber dados do contrato, parcelas,
 * remoção e adição de parcelas. Todo o cálculo é feito por uma classe de serviço
 * chamada ContractSevice, que será chama no Programa principal.*/

package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	private Integer number; //Número do Contrato
	private Date Date; //Data do Contrato
	private Double totalValue; //Valor total do contrato
	
	//É necessário criar uma lista de parcelas para que possamos associa-la ao valor que digitaremos posteriormente
	List<Installment> installments = new ArrayList<>();
	
	public Contract() {}
	
	public Contract(Integer number, java.util.Date date, Double totalValue) {
		this.number = number;
		Date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}
	
	//Adiciona uma parcela na lista de parcelas
	public void addInstallment(Installment installment) {
		installments.add(installment);
	}
	
	//Remove uma percela da lista de parcelas
	public void removeInstallment(Installment installment) {
		installments.remove(installment);
	}
}