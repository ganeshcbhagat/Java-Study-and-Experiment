package com.company.comws.dto;

public class OrderDTO {

	private Long  id;
	private String productName;
	private Float itemCost;
	private CustomerDTO customer;
	
	public OrderDTO() {
		super();
	}

	public OrderDTO(Long id, String productName, Float itemCost, CustomerDTO customer) {
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

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
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
		OrderDTO other = (OrderDTO) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
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
		builder.append("CustomerOrderDTO [id=");
		builder.append(id);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", itemCost=");
		builder.append(itemCost);
		builder.append(", customer=");
		builder.append(customer);
		builder.append("]");
		return builder.toString();
	}
	
}
