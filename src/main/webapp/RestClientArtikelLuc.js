/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var rootURL = "http://localhost:8080/Workshop7/webresources/artikel";

$(document).ready(function(){
findAll();});

function findAll() {
	console.log('findAll Artikel');
        $.getJSON(rootURL, function(result){
            renderList(result);
            });
}

function renderList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = data;
        $('#List').append("<tr><th>ID</th>\n\
                <th>Artikel</th>\n\
                <th>Prijs</th>\n\
                <th>Voorraad</th>\n\
                </tr>");
	$.each(list, function(index, artikel) {
		$('#List').append('<tr><td id="selectArtikel"><button id='+ artikel.artikelId +'>'+artikel.artikelId+'</td>\n\
                                    <td>'+artikel.artikelNaam+'</td>\n\
                                    <td>'+artikel.artikelPrijs+',-</td>\n\
                                    <td>'+artikel.artikelVoorraad+'</td>\n\
                                    </li>');
	});
}

$(document).on("click", "td#selectArtikel button", function(event){
    event.preventDefault();
    findById(event.target.id);
});

function findById(Id) {
    $.getJSON(rootURL+"/"+Id, function(result){
        $('#artikelId').val(result.artikelId);
        $('#artikelNaam').val(result.artikelNaam);
        $('#artikelVoorraad').val(result.artikelVoorraad);
        $('#artikelPrijs').val(result.artikelPrijs);
    });
}

$(document).on("click", "div#btnSave button", function(event){
    event.preventDefault();
    alert("Edit function not implemented");
//	if ($('#artikelId').val() === '')
//            alert("Edit function not implemented");
//		create();
//	else
//            alert("Edit function not implemented");
//		update();
//	return false;
});

function create(){
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL,
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Artikel created successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('addWine error: ' + textStatus);
		}
	});
        }
function formToJSON() {
	return JSON.stringify({
		"id": $('#artikelId').val() === "" ? null : $('#artikelId').val(), //<--klopt dit?
		"artikelNaam": $('#artikelNaam').val(), 
		"artikelVoorraad": $('#artikelVoorraad').val(),
		"artikelPrijs": $('#artikelPrijs').val()
		},
                alert("yay: \n\
                        "+$('#artikelId').val() +" \n\
                        "+$('#artikelNaam').val()+ " \n\
                        "+$('#artikelVoorraad').val()+ " \n\
                        "+$('#artikelPrijs').val())
                        );
}
