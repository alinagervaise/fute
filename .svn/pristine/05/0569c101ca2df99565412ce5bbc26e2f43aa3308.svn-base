"use strict";

jQuery(document).ready(function($){

	/************** Menu Content Opening *********************/
	$(".main_menu a, .responsive_menu a").click(function(){
		var id =  $(this).attr('class');
		id = id.split('-');
		id = id[1].split(' ');
                id = id[0];
		$("#menu-container .content").hide();
		$("#menu-container #menu-"+id).addClass("animated fadeInDown").show(1000);
		return false;
	});
        
	/************** Operations openning *********************/
	$(".menu-actions ul li #addnew").click(function(){
		$("#menu-container .pagecontent").hide(500);
		$("#menu-container .form-new").addClass("animated .fadeInUpBig").show(500);
		return false;
	});
        
        $("#menu-container .form-new").hide();
        
        $('.date').datepicker({
                    format: "dd-mm-yyyy"
                });
        
        $("#cst-all").click(function(){
            var checked = $(this).is(':checked');
            if(checked===true)
                $(".cst").attr("checked",true);
            else
                $(".cst").attr("checked",false);
        });
        
        $("#crt-all").click(function(){
            var checked = $(this).is(':checked');
            if(checked===true)
                $(".crt").attr("checked",true);
            else
                $(".crt").attr("checked",false);
        });
        
        $("#mdf-all").click(function(){
            var checked = $(this).is(':checked');
            if(checked===true)
                $(".mdf").attr("checked",true);
            else
                $(".mdf").attr("checked",false);
        });
        
        $("#dlt-all").click(function(){
            var checked = $(this).is(':checked');
            if(checked===true)
                $(".dlt").attr("checked",true);
            else
                $(".dlt").attr("checked",false);
        });
        
//        add new gestionnaire to a proprietaire
        $("#add_gestionnaire_form").hide(0);
        $("#add_gestionnaire a").click(function(){
		$("#add_gestionnaire").hide(1000);
		$("#add_gestionnaire_form").addClass("animated .fadeInLeftBig").show(1000);
		return false;
	});
        
        
        
        
    /************** LightBox *********************/
    $(function(){
            $('[data-rel="lightbox"]').lightbox();
    });


    $("a.menu-toggle-btn").click(function() {
      $(".responsive_menu").stop(true,true).slideToggle();
      return false;
    });
 
    $(".responsive_menu a").click(function(){
		$('.responsive_menu').hide();
	});

});
