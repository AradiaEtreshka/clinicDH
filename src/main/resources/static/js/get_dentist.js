$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/dentists",
            success: function(response){
              $.each(response, (i, odontologo) => {  


                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + dentist.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' + 
                                            dentist.id +
                                            '</button>';
                
                let tr_id = 'tr_' + dentist.id;
                let odontologoRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          '<td class=\"td_first_name\">' + dentist.name.toUpperCase() + '</td>' +
                          '<td class=\"td_last_name\">' + dentist.lastName + '</td>' +
                          '<td class=\"td_matricula\">' + dentist.registration_number + '</td>' +
                          '</tr>';                
                $('#odontologoTable tbody').append(odontologoRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();        
    
    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/dentists.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});