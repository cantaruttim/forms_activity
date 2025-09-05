const formulario = document.querySelector('form');

// Selecionando os elementos corretos do formulário
const nome = formulario.querySelector('#nome');
const email = formulario.querySelector('#email');
const q1 = formulario.querySelector('#resposta1');
const q2 = formulario.querySelector('#resposta2');

function cadastrar() {
    // Validar comprimento mínimo das respostas
    if (q1.value.length < 300) {
        alert('A resposta 1 precisa ter pelo menos 300 caracteres.');
        return;
    }
    
    if (q2.value.length < 150) {
        alert('A resposta 2 precisa ter pelo menos 150 caracteres.');
        return;
    }

    fetch('http://localhost:8080/cadastrar', 
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify({
                nome: nome.value,
                email: email.value,
                q1: q1.value,
                q2: q2.value
                // Removidos matricula e modulo que não existem no formulário
            })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro na resposta do servidor');
            }
            return response.json();
        })
        .then(data => {
            console.log('Success:', data);
            alert('Respostas enviadas com sucesso!');
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('Erro ao enviar respostas. Tente novamente.');
        });
}

function resetForm() {
    nome.value = '';
    email.value = '';
    q1.value = '';
    q2.value = '';
}

formulario.addEventListener('submit', function(event) {
    event.preventDefault();
    cadastrar();
    resetForm();
});