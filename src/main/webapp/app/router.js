// Filename: router.js
define(['jquery',  'underscore',  'backbone' ], function($, _, Backbone, ProjectListView, UserListView){
  var AppRouter = Backbone.Router.extend({
    routes: {
      // Define some URL routes
    	"/*": "barFormView",//only one route has been defined so make it default
      'barForm': 'barFormView',      
      // Default
      '*actions': 'defaultAction'
    },
    
    
    initialize: function () {
    	_.bindAll(this,'barFormView','defaultAction');
        console.debug("called Router: initialize");
    },
    
    defaultAction: function (action){
    	console.debug('Unhundled route'+action);      	
    },
    
    barFormView: function(){
    	require( ['views/BarcodesView', 'collections/BarcodeCollection'],

    			  function (BarcodesView, BarcodeCollection ) {    

    			    var d = $('#barForm');    			   
    			    
    			    var list = new BarcodeCollection();

    			    var vw = new BarcodesView({collection : list } );       
    			    vw.render().$el.appendTo(d);       
    			    vw.addAll();
    			  });
    }                      
    
  });

  var initialize = function(){
	  console.debug("called Router2: initialize");  	         
    var app_router = new AppRouter;    
    Backbone.history.start();
  };
  return {
    initialize: initialize
  };
});