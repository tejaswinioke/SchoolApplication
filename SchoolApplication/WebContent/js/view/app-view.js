define(['jquery', 'underscore', 'backbone', 'resthub', 'hbs!template/app', 'i18n!nls/labels', 'view/schoolrecords-view', 'view/stats-view', 'collection/schoolrecords'],
    function($, _, Backbone, Resthub, appTmpl, labels, schoolrecordsView, StatsView, schoolrecords){
        var AppView = Resthub.View.extend({

            events: {
                'keypress #new-schoolrecord':  'createOnEnter',
                'keyup #new-schoolrecord':     'showTooltip'
            },
            
            initialize: function() {
                this.collection = new schoolrecords();
                this.template = appTmpl;
                this.labels = labels;
                this.render();
                // this.$() is a shortcut for this.$el.find().
                this.input = this.$('#new-schoolrecord');
                new schoolrecordsView({root: this.$('#schoolrecords'), collection: this.collection});
                new StatsView({root: this.$('#schoolrecord-stats'), collection: this.collection});
            },

            // Generate the attributes for a new schoolrecord item.
            newAttributes: function() {
                return {
                    content: this.input.val(),
                    order:   this.collection.nextOrder(),
                    done:    false
                };
            },

            // If you hit return in the main input field, create new **schoolrecord** model,
            // persisting it to *localStorage*.
            createOnEnter: function(e) {
                if (e.keyCode != 13) return;
                this.collection.create(this.newAttributes());
                this.input.val('');
            },

            // Lazily show the tooltip that tells you to press `enter` to save
            // a new schoolrecord item, after one second.
            showTooltip: function(e) {
                var tooltip = this.$('.ui-tooltip-top');
                var val = this.input.val();
                tooltip.fadeOut();
                if (this.tooltipTimeout) clearTimeout(this.tooltipTimeout);
                if (val == '' || val == this.input.attr('placeholder')) return;
                var show = function(){ tooltip.show().fadeIn(); };
                this.tooltipTimeout = _.delay(show, 1000);
            }

        });
        return AppView;
    });