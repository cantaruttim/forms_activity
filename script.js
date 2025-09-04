const formulario = document.querySelector('form');

const nome = formulario.querySelector('.nome');
const matricula = formulario.querySelector('.matricula');
const modulo = formulario.querySelector('.modulo');
const email = formulario.querySelector('.email');
const q1 = formulario.querySelector('.q1');
const q2 = formulario.querySelector('.q2');

function cadastrar() {

    fetch('http://localhost:8080/cadastrar', 
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(
            {
                nome: nome.value,
                matricula: matricula.value,
                modulo: modulo.value,
                email: email.value,
                q1: q1.value,
                q2: q2.value
            })
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

function resetForm() {
    nome.value = '';
    matricula.value = '';
    modulo.value = '';
    email.value = '';
    q1.value = '';
    q2.value = '';
}

formulario.addEventListener('submit', function(event) {
    event.preventDefault();

    cadastrar();
    resetForm();
});