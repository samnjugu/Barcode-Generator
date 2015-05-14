/* namespaces - storing App-based facades, proxies, utils */
window.App = window.App || {};

requirejs.config( {
	
  paths : {
    backbone : '../lib/backbone-min',
    underscore : '../lib/underscore-min',
    jquery : '../lib/jquery-2.1.1.min',    
    domReady : '../lib/domReady',      
    text: '../lib/text'
  },

  // Insert to prevent caching of JS files  
  urlArgs : 'bust=' + (new Date()).getTime(),
  shim : {
    'backbone' : {
      deps : ['underscore', 'jquery'],
      exports : 'Backbone'
    },
    'underscore' : {
      exports : '_'
    }
  }
} );

require([

         // Load our app module and pass it to our definition function
         'app',         
       ], function(App){         
	console.debug("called main: initialize");
         App.initialize();
       });