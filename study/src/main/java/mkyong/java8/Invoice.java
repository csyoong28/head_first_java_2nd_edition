package mkyong.java8;

import java.math.BigDecimal;

public class Invoice {
	String no;
	BigDecimal unitPrice;
	Integer qty;
	
	
	public Invoice() {
		super();
	}

	public Invoice(String no, BigDecimal unitPrice, Integer qty) {
		super();
		this.no = no;
		this.unitPrice = unitPrice;
		this.qty = qty;
	}
	
	public Invoice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
}
