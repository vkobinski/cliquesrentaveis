
const cpf = document.getElementById("cpf");
const senha = document.getElementById("senha");

const botao = document.getElementById("entrarBtn");

botao.onclick = function(){
    let cpfString = cpf.value;
    let senhaString = cpf.value;

    fetch('/users/auth', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        cpf: cpfString,
        senha: senhaString
      })
    })
    .then(response => response.text())
    .then(data => {
        if(data === "ok") {
            window.location.href = "/principal.html"
        }
    })
    .catch(error => console.error(error));

}
