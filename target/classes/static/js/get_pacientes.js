window.addEventListener('load', function () {
    const url= '/pacientes/';
    const settings = {
        method: 'GET'
    }
    actualizarTabla();

    function actualizarTabla(){
        fetch(url,settings)
            .then(response => {
                if (!response.ok) {
                    throw response.status
                }
                return response.json()
            })
            .then(data => {
                for(paciente of data) {
                    console.log(paciente)
                    let table = document.getElementById("odontologoTable");
                    let odontologoRow = table.insertRow();
                    let tr_id = 'tr_' + paciente.paciente_id;
                    odontologoRow.id = tr_id;

                    let botonActualizar = '<button ' +
                        ' id=' + '\"' + 'btn_id_' + paciente.paciente_id + '\"' +
                        ' type="button" onclick="findBy('+paciente.paciente_id+')" data-bs-toggle="modal" data-bs-target="#exampleModal2" class="mx-2 btn btn-sm btn-primary"><i class="fa-solid fa-pencil"></i></button>';


                    let botonBorrar = '<button' +
                        ' id=' + '\"' + 'btn_delete_' + paciente.paciente_id + '\"' +
                        ' type="button" onclick="deleteBy('+paciente.paciente_id+')"class="btnBorrar btn btn-sm btn-danger"><i class="fa-solid fa-trash-can"></i></button>';

                    odontologoRow.innerHTML =
                        // '<td >' + botonActualizar + '</td>' +
                        // '<td class=\"td_id\">' + odontologo.id.toUpperCase() + '</td>' +
                        '<td class=\"td_id\">' + paciente.paciente_id + '</td>' +
                        '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>'+
                        '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>'+
                        '<td class=\"td_email\">' + paciente.email.toUpperCase() + '</td>'+
                        '<td class=\"td_email\">' + paciente.dni.toUpperCase() + '</td>'+
                        '<td class=\"td_email\">' + paciente.fechaNacimiento + '</td>'+
                        '<td class=\"td_domicilio_id\">' + paciente.domicilio.domicilio_id + '</td>'+
                        '<td class=\"td_domicilio_calle\">' + paciente.domicilio.calle.toUpperCase()  + '</td>'+
                        '<td class=\"td_domicilio_numero\">' + paciente.domicilio.numero+ '</td>'+
                        '<td class=\"td_domicilio_localidad\">' + paciente.domicilio.localidad.toUpperCase()  + '</td>'+
                        '<td class=\"td_domicilio_provincia\">' + paciente.domicilio.provincia.toUpperCase()  + '</td>'+

                        '<td >'+ botonActualizar + botonBorrar + '</td>' ;

                }

            })
            .catch(error => {
                let errorMessage = ''
                let icon = ''
                if (error === 401) {
                    errorMessage = 'Su usuario no está autorizado para realizar esta acción.'
                    icon = 'warning'
                } else if (error === 403) {
                    errorMessage = 'Su usuario no está autorizado para realizar esta acción.'
                    icon = 'warning'
                } else {
                    errorMessage = 'Algo salió mal al guardar el Odontólogo!'
                    icon= 'error'
                }
                Swal.fire({
                    icon: icon,
                    title: 'Oops...',
                    text: errorMessage
                })
            });

    }


})