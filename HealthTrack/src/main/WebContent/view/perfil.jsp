<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Health Track - Perfil</title>
    <link href="/css/perfil.css" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
</head>

<body>

    <div class="box">
        <div class="titulo">
          <p><b>HEALTH</b> TRACK</p>
        </div>

    <form class="card-body col-sm-4 text-color">
        <h2>Informações Pessoais</h2>

            <div class="mb-3 col-sm-10">             
                <input type="text" class="form-input" id="nome" placeholder="Nome"><br>
                <input type="text" class="form-input" id="sobrenome" placeholder="Sobrenome">
            </div>

            <div class="corpo">
                <label>Peso (Kg):
                    <input type="number" class="form-input" id="peso"/>
                </label>
                <button type="button" class="btn-sm btn-success">Atualizar</button>
                <label>Altura (Cm):
                    <input type="number" class="form-input" id="altura"/>
                </label>
                <button type="button" class="btn-sm btn-success">Atualizar</button>
                <br>
            </div>

            <div>
                <label for="data-nascimento">Data de Nascimento:</label><br>
                <input type="date" id="data-nascimento" name="data-nascimento">
            </div><br>

            <div>
                <label for="Gênero">Gênero:</label><br>
                <input type="radio" id="masculino" name="genero" value="masculino">
                <label for="masculino">Masculino</label><br>
                <input type="radio" id="feminino" name="genero" value="feminino">
                <label for="feminino">Feminino</label><br>
                <input type="radio" id="outro" name="genero" value="outro">
                <label for="outro">Outro</label><br><br>
            </div>

            <button type="button" class="btn btn-success">Salvar dados</button>
    </form>
</div>

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>