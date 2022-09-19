<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Health Track - Home</title>
  <link href="${pageContext.request.contextPath}/css/home-style.css" rel="stylesheet">
</head>

<body>
  <script src="js/home.js"></script>
  <div class="box">
    <div class="titulo">
      <p><b>HEALTH</b> TRACK</p>
    </div>

    <div class="conteudo">
      <div>Seja bem-vindo ao seu companheiro fitness</div>
    </div>

    <div class="painel">
      <form action="novo-usuario" method="post" class="wrapper">
        <div class="novo">
          <button id="btn-novo" type="submit">Novo usuário</button>
        </div>
        <div class="login">
          <button id="btn-login" type="submit" formaction="login">Entrar</button>
        </div>
      </form>
    </div>
  </div>


</body>

</html>