/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 console.log("HERE========================");
alert('alert1');
$(document).ready(function() {
       
        $('[data-toggle="tooltip"]').tooltip();
         $("#selectedForm").select(function(e){
              console.info()("HERE========================"+$("#selectedForm :selected").text());
         });
        var product = $("#selectedForm").text();
        console.log("HERE========================"+$("#selectedForm :selected").text());
        $('#addProductModal').on('shown.bs.modal', function (event) {
          var button = $(event.relatedTarget) ;// Button that triggered the modal
          console.log("HERE========================"+$("#selectedForm :selected").text());
          // Extract info from data-* attributes
          // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
          // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
          var modal = $(this);
          modal.find('#productDesignation ').text("hello");

        });

    });
