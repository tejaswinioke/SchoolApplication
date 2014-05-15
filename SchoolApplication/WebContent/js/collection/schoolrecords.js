define(['backbone', 'model/schoolrecord'], function(Backbone, schoolrecord){
	  
    var schoolrecords = Backbone.Collection.extend({

    // Reference to this collection's model.
    model: schoolrecord,

    url: "/schoolservice?subject=numeracy",
    
  });
    //TODO test the fetch function to fetch the collection
    list=new schoolrecords;
    list.fetch({
        success:function(collection, response){alert(response);},

        error:function(){alert("error");}
    });
  return schoolrecords;
});




