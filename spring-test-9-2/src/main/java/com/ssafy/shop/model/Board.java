package com.ssafy.shop.model;

public class Board {
	private String code;
	private String model;
	private Integer price;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Board [code=" + code + ", model=" + model + ", price=" + price + "]";
	}

}
