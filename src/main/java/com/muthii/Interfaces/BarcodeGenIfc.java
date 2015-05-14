package com.muthii.Interfaces;

public interface BarcodeGenIfc {
	
	/**
	 * 
	 * @param type - type of barode you want
	 * @param barValue - String value to be converted to a barcode
	 * @return - base 64 encoded string of barcode image
	 */
	public String getBarcodeImage(int type,String barValue);
	/**
	 * 
	 * @param value -String value to be converted to a barcode
	 * @return - base 64 encoded string of barcode image
	 */
	public String getBarcode128(String value);
	/**
	 * 
	 * @param value -String value to be converted to a barcode
	 * @return - base 64 encoded string of barcode image
	 */
	public String getBarcodeCodabar(String value);
	/**
	 * 
	 * @param value -String value to be converted to a barcode
	 * @return - base 64 encoded string of barcode image
	 */
	public String getBarcodeCode39(String value);
	/**
	 * 
	 * @param value -String value to be converted to a barcode
	 * @return - base 64 encoded string of barcode image
	 */
	public String getBarcodeInterleaved2Of5(String value);
	/**
	 * 
	 * @param value -String value to be converted to a barcode
	 * @return - base 64 encoded string of barcode image
	 */
	public String getBarcodePOSTNET(String value);
	/**
	 * 
	 * @param value -String value to be converted to a barcode
	 * @return - base 64 encoded string of barcode image
	 */
	public String getBarcodeUPCA(String value);
	/**
	 * 
	 * @param value -String value to be converted to a barcode
	 * @return - base 64 encoded string of barcode image
	 */
	public String getBarcodeUPCE(String value);
	/**
	 * 
	 * @param value -String value to be converted to a barcode
	 * @return - base 64 encoded string of barcode image
	 */
	public String getBarcodeEAN13(String value);
	/**
	 * 
	 * @param value -String value to be converted to a barcode
	 * @return - base 64 encoded string of barcode image
	 */
	public String getBarcodeEAN8(String value);
	/**
	 * 
	 * @param value -String value to be converted to a barcode
	 * @return - base 64 encoded string of barcode image
	 */
	public String getBarcodeQR(String value);

}
