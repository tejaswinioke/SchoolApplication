define([
  'underscore', 'backbone', 'resthub', 'hbs!template/schoolrecords', 'view/schoolrecord-view', 'i18n!nls/labels'],
  function(_, Backbone, Resthub, schoolrecordsTmpl, schoolrecordView, labels){
  var schoolrecordsView = Resthub.View.extend({

    // Delegated events for creating new items, and clearing completed ones.
    events: {
      'click .mark-all-done': 'toggleAllComplete'
    },
    
    template: schoolrecordsTmpl,
    labels : labels,

    // At initialization we bind to the relevant events on the `schoolrecords`
    // collection, when items are added or changed. Kick things off by
    // loading any preexisting schoolrecords that might be saved in *localStorage*.
    initialize: function(options) {
      _.bindAll(this, 'addOne', 'addAll', 'render', 'toggleAllComplete');

      // Add this context in order to allow automatic removal of the callback with dispose()
      this.listenTo(this.collection, 'add', this.addOne);
      this.listenTo(this.collection, 'reset', this.addAll);
      this.listenTo(this.collection, 'all', this.refresh);

      this.render();

      // Fetch unpaginated collection
      this.collection.fetch({ data: { page: 'no'} });
    },

    refresh: function() {
        var remaining = this.collection.remaining().length;
        // this.$() is a shortcut for this.$el.find()
        this.allCheckbox = this.$('.mark-all-done')[0];
        this.allCheckbox.checked = !remaining;
    },

    // Add a single schoolrecord item to the list by creating a view for it, and
    // appending its element to the `<ul>`.
    addOne: function(schoolrecord) {
      new schoolrecordView({root: $('#schoolrecord-list'), model: schoolrecord});
    },

    // Add all items in the **schoolrecords** collection at once.
    addAll: function() {
        this.collection.each(this.addOne);
    },

    // Change each schoolrecord so that it's `done` state matches the check all
    toggleAllComplete: function () {
      var done = this.allCheckbox.checked;
      this.collection.each(function (schoolrecord) { schoolrecord.save({'done': done}); });
    }

  });
  return schoolrecordsView;
});
