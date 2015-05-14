define(['backbone', 'underscore','jquery', 'text!templates/Barcode.html'], function(Backbone, _, $, tpl) {
	var BarcodeView = Backbone.View.extend({

		code : 'view test code',		

		initialize : function () {
			_.bindAll(this,'render','editCode','saveCode');
			this.tplFn = _.template( tpl );
			this.renderModel = _.extend(this.model.attributes);			
			console.debug('BarcodeView.initialize()');

		},
		
		events: {			
			'click span': 'editCode',
			'blur span': 'saveCode',
		},

		editCode : function(e){
			 e.preventDefault();//nothing really to prevent just using for experience
//			 var name = this.model.get("code");//use this to get current model value
//			 alert(name);
			this.$('span').attr('contenteditable',true);
//			console.debug('BarcodeView.editCode()'+name);
		},
		
		saveCode : function(){
			this.$('span').attr('contenteditable',false);
			this.model.set({'code' : this.$('span').text()})
//			console.debug('BarcodeView.saveCode()'+this.$('span').text());
		},
		
		render : function () {

        // Pass this.renderModel to this.tplFn and send the result
        // to this.$el.html
        // Put another way, run the template against the render model
        // and assign the results to this view's html        
//          this.$el.html(this.renderModel.get('code'));          
          this.$el.html(this.tplFn(this.renderModel));//to use a template             

        return this;
      }

	});
	return BarcodeView;
});

