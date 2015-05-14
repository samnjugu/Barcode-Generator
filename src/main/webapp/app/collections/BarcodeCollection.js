define(['backbone', 'models/BarcodeModel'], function(Backbone, BarcodeModel) {
  var BarcodeCollection = Backbone.Collection.extend({

  	model : BarcodeModel,
  	url: 'rs/barcode/getBar',

  	initialize: function () {
      console.debug('BarcodeCollection.initialize()');
    }
  });

  return BarcodeCollection;
});
