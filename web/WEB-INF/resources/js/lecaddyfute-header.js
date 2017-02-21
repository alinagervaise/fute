/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    $(".dropdown-menu.language li").each(function (e) {
        var value = $(this).find("ul li.selected").html();
        if($(this).hasClass("selected")){
            
            $(this).find(".dropdown-toggle").val(value);
            $(this).find(".dropdown-toggle").html(value);
           
            var target = $(this).children("a").children("div").html();
            $(this).parents('.dropdown').find('.dropdown-toggle div').html(target 
                    + ' <span class="caret"></span>');
            $(this).parents('.dropdown').find('.dropdown-toggle div').val(target 
                    + ' <span class="caret"></span>');
        }
    });
    $(".dropdown-menu.language li").change( function(e) {
        e.preventDefault();
        if(!$(this).hasClass("active")){
            $(".dropdown-menu.language li").not(this).each(function () {
                $(this).removeClass("active");
                $(this).removeClass("selected");
            });
        }    
        $(this).addClass("active");
        $(this).addClass("selected");
        var target = $(this).children("a").children("div").html();
        
        $(this).parents('.dropdown').find('.dropdown-toggle div').html(target 
                + ' <span class="caret"></span>');
        $(this).parents('.dropdown').find('.dropdown-toggle div').val(target 
                + ' <span class="caret"></span>');
        var brwsr_url = document.URL.split("?")[0];
        var redirecturl = brwsr_url + $(".dropdown-menu.language li a").attr("href");
        location.href = redirecturl;
        //window.history.pushState("$(this)","langageChange", $(".dropdown-menu.language li a").attr("href"));
         
    });


   
});
