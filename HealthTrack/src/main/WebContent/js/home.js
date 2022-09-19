window.onload=function(){
  const btnNovo = document.getElementById('btn-novo');
  const btnLogin = document.getElementById('btn-login');
  
  btnNovo.addEventListener("click", cenario1);
  btnLogin.addEventListener("click", cenario2);
}

function cenario1(){
  const urlBase = document.location.href.substring(0,document.location.href.lastIndexOf("/"));
  console.log(urlBase + '/novo-usuario.html');
  location.href = (urlBase + '/novo-usuario.html')
}

function cenario2(){
  const urlBase = document.location.href.substring(0,document.location.href.lastIndexOf("/"));
  console.log(urlBase + '/login.html');;
  location.href = (urlBase + '/login.html')
}
