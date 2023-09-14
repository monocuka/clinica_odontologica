window.addEventListener('load', function () {
    const url= '/odontologo/';
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
                for(odontologo of data) {
                    console.log(odontologo)
                    let table = document.getElementById("odontologoTable");
                    let odontologoRow = table.insertRow();
                    let tr_id = 'tr_' + odontologo.odontologo_id;
                    odontologoRow.id = tr_id;

                    let botonActualizar = '<button ' +
                        ' id=' + '\"' + 'btn_id_' + odontologo.odontologo_id + '\"' +
                        ' type="button" onclick="findBy('+odontologo.odontologo_id+')" data-bs-toggle="modal" data-bs-target="#exampleModal2" class="mx-2 btn btn-sm btn-primary"><i class="fa-solid fa-pencil"></i></button>';


                    let botonBorrar = '<button' +
                        ' id=' + '\"' + 'btn_delete_' + odontologo.odontologo_id + '\"' +
                        ' type="button" onclick="deleteBy('+odontologo.odontologo_id+')"class="btnBorrar btn btn-sm btn-danger"><i class="fa-solid fa-trash-can"></i></button>';

                    odontologoRow.innerHTML =
                        // '<td >' + botonActualizar + '</td>' +
                        // '<td class=\"td_id\">' + odontologo.id.toUpperCase() + '</td>' +
                        '<td class=\"td_id\">' + odontologo.odontologo_id + '</td>' +
                        '<td class=\"td_numeroMatricula\">' + odontologo.numeroMatricula.toUpperCase() + '</td>' +
                        '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>'+
                        '<td class=\"td_apellido\">' + odontologo.apellido.toUpperCase() + '</td>'+
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