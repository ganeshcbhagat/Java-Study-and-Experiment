package com.atmosphere.gotcha.spring.dto;

public class ItemDTOExtra extends ItemDTO {

	private Boolean imported;
	private String message;
	private Integer port;
	
	public ItemDTOExtra() {

	}

	public ItemDTOExtra(Long id) {
		super(id);
	}
	
	public ItemDTOExtra(String name, String category) {
		super(name, category);
	}

	public ItemDTOExtra(Long id, String name, String category) {
		super(id, name, category);
	}

	public Boolean getImported() {
		return imported;
	}

	public void setImported(Boolean imported) {
		this.imported = imported;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemDTOExtra [imported=");
		builder.append(imported);
		builder.append(", message=");
		builder.append(message);
		builder.append(", port=");
		builder.append(port);
		builder.append("]");
		return builder.toString();
	}

}