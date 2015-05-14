package com.muthii.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.muthii.to.BarcodeTO;
import com.muthii.utility.BarcodeGenBarcode4J;
import com.muthii.utility.Constants;

@Path(Constants.BARCODE)
public class BarcodeService {

	@POST
	@Path(Constants.BAR)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getBarcode(List<BarcodeTO> codes){			

		if(codes.size() > 0){

			for (BarcodeTO item : codes)
			{
				int barType;
				//Default to 1 if no barcode type was sent
				if(item.getType() == null || item.getType().equals("")){
					barType = 0;}
				else{
					barType = Integer.valueOf(item.getType());}

				try
				{
					//Create an "<img src=\"data:image/png;base64>" tag to hold the base64 encoded image. 
					item.setBarcodeImage("<img src=\"data:image/png;base64,"+(new BarcodeGenBarcode4J().getBarcodeImage(barType,item.getCode()))+"\" alt=\""+item.getCode()+"\" />");
				}
				catch(Throwable e)
				{
					item.setBarcodeImage("<span class=\"appSpacer\">Error occured on Barcode "+item.getCode()+" Error: "+e.getMessage()+"</span>");
				}						
			}
		}																		

		return Response.status(Response.Status.OK).entity(codes).build();
	}	
}
