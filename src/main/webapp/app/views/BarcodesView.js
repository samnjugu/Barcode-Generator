define(['backbone', 'underscore','jquery', 'models/BarcodeModel', 'views/BarcodeView', 'text!templates/Barcodes.html'], function(Backbone, _, $, BarcodeModel, BarcodeView,tpl) {
	var BarcodesView = Backbone.View.extend({		
		code : 'view test code',		

		initialize : function () {
			_.bindAll(this, 'render','addCode','addCodes','addAll','saveCodes','success');
			this.tplFn = _.template( tpl );//to use a template
			//store all models in rendermodel
			this.renderModel = _.extend(this.collection.models);
			console.debug('BarcodesView.initialize()');

		},
		
		events: {
			"click #addCode": "addCode",			
			"click #saveCodes": "saveCodes",
		},
		
		addCode : function(){			
			var code = new BarcodeModel({code :  this.$("#inputCode").val(), type : $('#barType option:selected').prop('index')});
			
			//render the model and attach to view
			this.addCodes(code);
			this.collection.add(code);
			this.$("#inputCode").val('');//clear input
		},
		
		addCodes : function(code){			
			this.$('#codesList').append(new BarcodeView({model : code}).render().$el);			
		},
		
		// if collection is empty this method below wont do anything
		addAll : function(){
			this.$('#codesList').html('');
			this.collection.each(this.addCodes,this);			
		},	
		
		saveCodes : function(){			
		$('#results').empty();
			if(this.collection.length > 0){
				$.ajax({
					type: "POST",
					url: this.collection.url,
					dataType: 'json',
					contentType: 'application/json',
					data: JSON.stringify(this.collection),
					success: this.success,
					error: function(XMLHttpRequest, textStatus, errorThrown) {
	                    alert("Could not access data source/service "+ errorThrown);}
				});
				this.render();
				console.debug('BarcodesView.saveCodes()'+this.collection.length);
				this.collection.reset();
			}
			else{
				alert("No barcodes entered");
			}			
		},
		
		success : function(data, textStatus, jqXHR ) {	
			if(data.length > 0){
				$('</br></br>').appendTo('#results');
			}
			for(var i = 0; i < data.length; i++) {
			    var obj = data[i];

			    console.log(obj.code);
			    $(obj.barcodeImage).appendTo('#results');
			    $('</br></br>').appendTo('#results');
			}				
		},

		render : function () {

        // Pass this.renderModel to this.tplFn and send the result
        // to this.$el.html
        // Put another way, run the template against the render model
        // and assign the results to this view's html                      
         this.$el.html(this.tplFn());            
         

        return this;
      }

	});
	return BarcodesView;
});

