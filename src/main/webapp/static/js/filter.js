$(document).ready(
    function() {

      $('#filter').keyup(
          function() {
            var filter = $('#filter').val().toLowerCase();

            function check(text) {
              return text.toLowerCase().indexOf(filter) >= 0;
            }

            function textOf(parent, selector) {
              var elem = $(parent).find(selector);
              return elem.length > 0 ? elem.text() : "";
            }

            $('.row-employee').each(
                function() {
                  var name = textOf(this, '#name');
                  var position = textOf(this, '#position');
                  var mail = textOf(this, '#mail');
                  var phone = textOf(this, '#phone');
                  var skype = textOf(this, '#skype');

                  var matches = check(name) || check(position) || check(mail)
                      || check(phone) || check(skype);

                  if (matches) {
                    $(this).show();
                  } else {
                    $(this).hide();
                  }
                });
          });

    });
