<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Health Track - Home</title>
  <link href="./css/novoUsuario-style.css" rel="stylesheet">
</head>

<body>
  <script src="js/home.js"></script>
  <p id="gfg"></p>

  <div class="titulo">
    <p><b>HEALTH</b> TRACK</p>
  </div>

  <div class="conteudo">
    <div>Que bom que escolheu cuidar de você! :)<br>Forneça as informações necessárias para realizar o seu cadastro</div>
  </div>

  <div class="painel">
    <div class="wrapper">
      <form action="CadastroController" method="post">
        <span class="form-titulo">Novo usuário</span>
        <div class="wrapper-input margin-top-40 margin-bottom-35">
          <input class="form-input" type="text" name="nome" autocomplete="off" required="" />
          <label class="focus-form-input" data-placeholder="Nome completo"></label>
        </div>
        <div class="wrapper-input margin-top-40 margin-bottom-35">
          <input class="form-input" type="email" name="email" autocomplete="off" required="" />
          <label class="focus-form-input" data-placeholder="E-mail"></label>
        </div>
        <div class="wrapper-input margin-bottom-35">
          <input class="form-input" type="password" name="senha" autocomplete="off" required="" />
          <label class="focus-form-input" data-placeholder="Senha"></label>
        </div>
        <div class="container-form-login-btn">
          <button class="login-btn" id="cadastro">Cadastrar e entrar</button>
        </div>
      </form>
    </div>
  </div>
</body>

</html>