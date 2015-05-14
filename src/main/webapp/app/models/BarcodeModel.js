define(['backbone'], function(Backbone) {
	var BarcodeModel = Backbone.Model.extend({
		
		defaults : {
			code : '123456789',
			type : '0',
			barcodeImage : ''
		},

		initialize: function() {
	      console.debug('BarcodeModel.initialize()');
	    }
		

	});
	return BarcodeModel;
});