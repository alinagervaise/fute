<%-- 
    Document   : visitor_search
    Created on : 15-Jan-2016, 12:35:59
    Author     : Z
--%>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>

<section id="search" class="row">
    <div class="col-xs-12">
        <div class="favicon">
            <a href="<c:url value="/home"/>">
                <img  src="<c:url value="/resources/images/favicon.png"/>" style="float:left"/>
            </a>
        </div>
    
        <form id="form-search">
            <div class="form-group input-group">
                <div class="form-group col-xs-3">
                    <spring:message code="label.search.critera" var="search-critera"/>
                    <input id="criteria" class="form-control" placeholder="${search-critera}" />
                </div>
                <div class="form-group col-xs-3">
                    <div id="div-category" class="input-group-btn">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Categories <span class="caret"></span></button>
                    <ul class="multi-dropdown-menu dropdown-menu multi-column columns-3">
                        <div class="row">
                            <div class="col-sm-4">
                                <ul class="multi-column-dropdown">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">One more separated link</a></li>
                                </ul>
                            </div>
                                <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <li><a href="#">Action</a></li>
                                            <li><a href="#">Another action</a></li>
                                            <li><a href="#">Something else here</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">One more separated link</a></li>
                                        </ul>
                                </div>
                                <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <li><a href="#">Action</a></li>
                                            <li><a href="#">Another action</a></li>
                                            <li><a href="#">Something else here</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">One more separated link</a></li>
                                        </ul>
                                </div>
                        </div>
                    </ul>
                </div>
                </div>
                <div class="form-group col-xs-3">
                    <spring:message code="label.place" var="place"/>
                    <input class="form-control typeahead tt-query" id="place" placeholder="${place}" 
                            autocomplete="off" spellcheck="false"
                           data-provide="typeahead"/>
                <div id="resultplace">
                    
                </div>
               
                
                </div>
                <div class="form-group col-xs-3">
                    <span id="span-button-search" class="input-group-btn">
                        <button id="button-search" class="btn btn-default" type="button">
                            <spring:message code="search"/> 
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </span>
                </div>
        </div>
    </form>
    </div>
   <!-- <div class="nav-button">
        <ul class="nav nav-pills">
        </ul>
    </div>-->
</section>

<script>    
    $(document).ready(function() {
        console.log("BEFore toautocomplete");
      
        $('#place').change(function() {  
            
            $.ajax({ // ajax call starts
              url: '${pageContext.request.contextPath}/search/locations', // JQuery loads serverside.php
              data: 'lterm=' + $(this).val(), // Send value of the clicked button
              dataType: 'json',      // Choosing a JSON datatype
              type:"GET" 
            })
            .done(function(data) { // Variable data contains the data we get from serverside
                var result = [];
                $.each(data, function(index, item)
                {
                    console.log(item.name + "___"+ item.city);
                    result.push(item.name + ", "+ item.city);
                });
                // Constructing the suggestion engine
                result = new Bloodhound({
                    datumTokenizer: Bloodhound.tokenizers.whitespace,
                    queryTokenizer: Bloodhound.tokenizers.whitespace,
                    local: result
                });

                // Initializing the typeahead
                $('#place').typeahead({
                    hint: true,
                    highlight: true, /* Enable substring highlighting */
                    minLength: 1 /* Specify minimum characters required for showing result */
                },
                {
                    name: 'locations',
                    source: result
                });
                });
            });
            //return false; // keeps the page from not refreshing 
          });
     

</script>