
const cpf = document.getElementById("cpf");
const senha = document.getElementById("senha");

const botao = document.getElementById("cadastrarBtn");

botao.onclick = function(){
    let cpfString = cpf.value;
    let senhaString = cpf.value;

    fetch('/users', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        cpf: cpfString,
        senha: senhaString
      })
    })
    .then(response => {

        if(response.status === 200) {
            window.location.href = "/"
        }
    })
    .catch(error => console.error(error));

}