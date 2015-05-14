package com.muthii.to;

public class BarcodeTO {
	
	/** Barcode text/code **/
	private String code;
	/** Barcode type **/
	private String type;
	/** Barcode image **/
	private String barcodeImage;
	
	/** Get Barcode text/code **/
	public String getCode() {
		return code;
	}
	/** Set Barcode text/code **/
	public void setCode(String code) {
		this.code = code;
	}
	/** Get Barcode image **/
	public String getBarcodeImage() {
		return barcodeImage;
	}
	/** Set Barcode image **/
	public void setBarcodeImage(String barcodeImage) {
		this.barcodeImage = barcodeImage;
	}
	/**Get  Barcode type **/
	public String getType() {
		return type;
	}
	/**Set Barcode type **/
	public void setType(String type) {
		this.type = type;
	}

}
