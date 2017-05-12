/* 
    Document   : main
    Created on : Feb 23, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
*/

/* Function to add text boxes dynamically */
$(document).ready(function() {
    $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
    $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
});


