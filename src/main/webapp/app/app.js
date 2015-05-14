define([
  'jquery',
  'underscore',
  'backbone',
  'router', // Request router.js
], function($, _, Backbone, Router){
  var initialize = function(){
    // Pass in Router module and call it's initialize function
	  console.debug("called app: initialize");	  
    Router.initialize();
  }

  return {
    initialize: initialize
  };
});