package com.muthii.utility;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.AbstractBarcodeBean;
import org.krysalis.barcode4j.impl.codabar.CodabarBean;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.impl.int2of5.Interleaved2Of5Bean;
import org.krysalis.barcode4j.impl.postnet.POSTNETBean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.impl.upcean.EAN8Bean;
import org.krysalis.barcode4j.impl.upcean.UPCABean;
import org.krysalis.barcode4j.impl.upcean.UPCEBean;
import org.krysalis.barcode4j.impl.qr.QRCodeBean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.MimeTypes;

import com.muthii.Interfaces.BarcodeGenIfc;

/**
 * This implementation uses Barcode4J a similar implementation can be 
 * done using iText or some other barcode library
 * @author Samnjugu
 *
 */
public class BarcodeGenBarcode4J implements BarcodeGenIfc{
	public String getBarcodeImage(int type,String barValue)
	{
		switch(type)
		{
		case 0:
			return getBarcode128(barValue);
		case 1:
			return getBarcodeCodabar(barValue);
		case 2:
			return getBarcodeCode39(barValue);
		case 3:
			return getBarcodeInterleaved2Of5(barValue);
		case 4:
			return getBarcodePOSTNET(barValue);
		case 5:
			return getBarcodeUPCA(barValue);
		case 6:
			return getBarcodeUPCE(barValue);
		case 7:
			return getBarcodeEAN13(barValue);
		case 8:
			return getBarcodeEAN8(barValue);
		case 9:
			return getBarcodeQR(barValue);
		default:
			return getBarcode128(barValue);

		}

	}	

	public String getBarcode128(String value) {        
		return getImage(value, new Code128Bean(), true); 
	}	
	public String getBarcodeCodabar(String value) {        
		return getImage(value, new CodabarBean(), true); 
	}
	public String getBarcodeCode39(String value) {        
		return getImage(value, new Code39Bean(), true); 
	}
	public String getBarcodeInterleaved2Of5(String value) {        
		return getImage(value, new Interleaved2Of5Bean(), true); 
	}
	public String getBarcodePOSTNET(String value) {        
		return getImage(value, new POSTNETBean(), true); 
	}
	public String getBarcodeUPCA(String value) {        
		return getImage(value, new UPCABean(), true); 
	}
	public String getBarcodeUPCE(String value) {        
		return getImage(value, new UPCEBean(), true); 
	}
	public String getBarcodeEAN13(String value) {        
		return getImage(value, new EAN13Bean(), true); 
	}
	public String getBarcodeEAN8(String value) {        
		return getImage(value, new EAN8Bean(), true); 
	}
	public String getBarcodeQR(String value){

		QRCodeBean bean = new QRCodeBean();
		//set custom settings for QRCodes
		bean.setModuleWidth(0.30);  
		bean.setHeight(15);  
		bean.doQuietZone(false);                 
		bean.setFontSize(1);  
		bean.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);  
		return getImage(value, bean, false);
	}


	private String getImage(String str, AbstractBarcodeBean bean, boolean useDefaults)
	{		
		//Set image resolution 
		final int dpi = 300; 

		if(useDefaults){
			bean.setModuleWidth(0.16);  
			bean.setHeight(8);  
			bean.doQuietZone(false);
			//human-readable          
			bean.setFontSize(1);  
			bean.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);  
		}                          

		//Byte stream to store data in
		ByteArrayOutputStream bout = new ByteArrayOutputStream(4096);
		BitmapCanvasProvider bitmap = new BitmapCanvasProvider(bout, MimeTypes.MIME_PNG, dpi, BufferedImage.TYPE_BYTE_GRAY, true, 0);
		bean.generateBarcode(bitmap, str);
		try {
			bitmap.finish();
		} catch (IOException e) {
			e.printStackTrace();
		}           		

		//Convert byte array to string using java native instead of Apache commons as am not using any extra features provided by commons library
		return javax.xml.bind.DatatypeConverter.printBase64Binary(bout.toByteArray());		
	}

}
