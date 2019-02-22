package com.company.comws.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderTbl")
public class Order extends AuditModel {
	
	private static final long serialVersionUID = -1160657992215424703L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	@Column
	private String productName;
	@Column
	private Float itemCost;
	//@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_Id", nullable=false)
	private Customer customer;
	
	public Order() {
		super();
	}

	public Order(Long id, String productName, Float itemCost, Customer customer) {
		super();
		this.id = id;
		this.productName = productName;
		this.itemCost = itemCost;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getItemCost() {
		return itemCost;
	}

	public void setItemCost(Float itemCost) {
		this.itemCost = itemCost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemCost == null) ? 0 : itemCost.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemCost == null) {
			if (other.itemCost != null)
				return false;
		} else if (!itemCost.equals(other.itemCost))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", itemCost=");
		builder.append(itemCost);
		builder.append("]");
		return builder.toString();
	}
	
}
