$(document).ready(function() {
    $("#add_new_dentist").submit(function(evt) {
        evt.preventDefault();
        
        let formData = {
            nombre : $("#name").val(),
            apellido :  $("#lastName").val(),
            matricula: $("#registration_number").val(),
        }

        $.ajax({
            url: '/newd',
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                let dentist = response
               console.log(response)
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> odontologo agregado </div>'
                $("#response").append(successAlert);
                $("#response").css({"display": "block"});

                resetUploadForm();
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error intente nuevamente</strong> </div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});

                resetUploadForm();
            }
        });
    });

    function resetUploadForm(){
        $("#name").val("");
        $("#lastname").val("");
        $("#registration_number").val("");
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/dentists.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});