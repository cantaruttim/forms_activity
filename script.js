const formulario = document.querySelector('form');

// Selecionando os elementos corretos do formulário
const name = formulario.querySelector('#nome');
const email = formulario.querySelector('#email');
const module = formulario.querySelector('#modulo');
const registrationNumber = formulario.querySelector('#matricula');
const questionOne = formulario.querySelector('#resposta1');
const questionTwo = formulario.querySelector('#resposta2');

function cadastrar() {
    // Validar comprimento mínimo das respostas
    if (questionOne.value.length < 300) {
        alert('A resposta 1 precisa ter pelo menos 300 caracteres.');
        return;
    }

    if (questionTwo.value.length < 150) {
        alert('A resposta 2 precisa ter pelo menos 150 caracteres.');
        return;
    }

    
    // Simular envio bem-sucedido para teste (comente o fetch e descomente estas linhas para testar sem servidor)
    // alert('Dados simulados no console! Verifique o console do navegador (F12)');
    // resetForm();
    // return;

    fetch('http://localhost:8080/api/activities/v1/response', 
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify({
                name: nome.value,
                email: email.value,
                registrationNumber: matricula.value,
                module: modulo.value,
                questionOne: q1.value,
                questionTwo: q2.value
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
    matricula.value = '';
    modulo.value = '';
    q1.value = '';
    q2.value = '';

    // Focar no primeiro campo para facilitar novo preenchimento
    setTimeout(() => {
        email.focus();
    }, 100);
    
    // Resetar mensagens de validação do navegador
    formulario.reset();
    
    // Remover mensagens de erro personalizadas se existirem
    const errorElements = formulario.querySelectorAll('.error-message');
    errorElements.forEach(element => element.remove());
    
    // Remover classes de validação se existirem
    const inputs = formulario.querySelectorAll('input, textarea');
    inputs.forEach(input => {
        input.classList.remove('is-invalid');
        input.classList.remove('is-valid');
    });
    
    console.log('Formulário resetado com sucesso');
}

formulario.addEventListener('submit', function(event) {
    event.preventDefault();
    cadastrar();
    // Não chame resetForm() aqui, pois deve ser chamado apenas após sucesso
    // resetForm(); // Remova esta linha
});