package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Data formatada em dia, mês e ano
	
	private Date dueDate; //Data da parcela
	private Double amount; //Quantidade da parcela
	
	public Installment(Date dueDate, Double amount) {
		//Sem super();, pois a classe é uma Super e não uma Sub
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return sdf.format(dueDate) + " - " + String.format("%.2f", amount);
		//Formatando data e parcelas conforme exemplo
	}
	
}
