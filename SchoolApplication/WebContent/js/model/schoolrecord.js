define(['underscore', 'backbone'], function(_, Backbone) {
  var schoolrecord = Backbone.Model.extend({

    // Default attributes for the schoolrecord.
    defaults: {
    	//TODO Set the values to default
    },

    // Wait for server feedback to perform deletion
    wait: true,

    
    // Remove this schoolrecord from *localStorage*.
    clear: function() {
      this.destroy();
    }

  });
 
  return schoolrecord;
});
