define(['underscore', 'backbone', 'resthub', 'hbs!template/schoolrecord'],
function(_, Backbone, Resthub, schoolrecordTmpl){
  var schoolrecordView = Resthub.View.extend({

    //... is a list tag.
    tagName:  'li',
    strategy: 'append',
    template: schoolrecordTmpl,

    // The DOM events specific to an item.
    events: {
      'click .check'              : 'toggleDone',
      'dblclick div.schoolrecord-content' : 'edit',
      'click span.schoolrecord-destroy'   : 'clear',
      'keypress .schoolrecord-input'      : 'updateOnEnter',
      'blur .schoolrecord-input'          : 'close'
    },

    // The schoolrecordView listens for changes to its model, re-rendering. Since there's
    // a one-to-one correspondence between a **schoolrecord** and a **schoolrecordView** in this
    // app, we set a direct reference on the model for convenience.
    initialize: function(options) {
      _.bindAll(this, 'render', 'close', 'remove');
      // Add this context in order to allow automatic removal of the calback with dispose()
      this.listenTo(this.model, 'change', this.render);
      this.listenTo(this.model, 'destroy', this.remove);
      this.render();
    },

    // Toggle the `'done'` state of the model.
    toggleDone: function() {
      this.model.toggle();
    },

    // Switch this view into `'editing'` mode, displaying the input field.
    edit: function() {
      this.$el.addClass('editing');
      // this.$() is a shortcut for this.$el.find()
      this.$('.schoolrecord-input').focus();
    },

    // Close the `'editing'` mode, saving changes to the schoolrecord.
    close: function() {
      this.model.save({content: this.$('.schoolrecord-input').val()});
      this.$el.removeClass('editing');
    },

    // If you hit `enter`, we're through editing the item.
    updateOnEnter: function(e) {
      if (e.keyCode == 13) this.close();
    },

    // Remove the item, destroy the model.
    clear: function() {
      this.model.clear();
    }

  });
  return schoolrecordView;
});
