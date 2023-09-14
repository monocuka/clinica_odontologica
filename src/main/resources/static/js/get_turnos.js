window.addEventListener('load', function () {
    const url= '/turno/';
    const settings = {
        method: 'GET'
    }
    actualizarTabla();

    function actualizarTabla(){
        fetch(url,settings)
            .then(response => response.json())
            .then(data => {
                for(turno of data) {
                    console.log(turno)
                    let table = document.getElementById("odontologoTable");
                    let turnoRow = table.insertRow();
                    let tr_id = 'tr_' + turno.turno_id;
                    turnoRow.id = tr_id;
                    const [fecha,hora] = turno.fecha.split('T')

                    let botonActualizar = '<button ' +
                        ' id=' + '\"' + 'btn_id_' + turno.turno_id + '\"' +
                        ' type="button" onclick="findBy('+ turno.turno_id +')" data-bs-toggle="modal" data-bs-target="#exampleModal2" class="mx-2 btn btn-sm btn-primary"><i class="fa-solid fa-pencil"></i></button>';


                    let botonBorrar = '<button' +
                        ' id=' + '\"' + 'btn_delete_' + turno.turno_id + '\"' +
                        ' type="button" onclick="deleteBy('+turno.turno_id +')"class="btnBorrar btn btn-sm btn-danger"><i class="fa-solid fa-trash-can"></i></button>';

                    turnoRow.innerHTML =
                        // '<td >' + botonActualizar + '</td>' +
                        // '<td class=\"td_id\">' + odontologo.id.toUpperCase() + '</td>' +
                        '<td class=\"td_id\">' + turno.turno_id + '</td>' +
                        '<td class=\"td_fecha_turno\">' + fecha + '</td>'+
                        '<td class=\"td_hora_turno\">' + hora + '</td>'+
                        '<td class=\"td_id_paciente\">' + turno.paciente.paciente_id+ '</td>'+
                        '<td class=\"td_paciente_apellido\">' + turno.paciente.apellido.toUpperCase() + '</td>'+
                        '<td class=\"td_id_odontologo\">' + turno.odontologo.odontologo_id + '</td>'+
                        '<td class=\"td_apellido_odontologo\">' + turno.odontologo.apellido.toUpperCase() + '</td>'+
                        '<td >'+ botonActualizar + botonBorrar + '</td>' ;

                }

            });

    }


})