<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Health Track - BPM</title>
    <link href="/css/bpm.css" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
</head>

<body>
    <script src="js/home.js"></script>
    <div class="box">
        <div class="titulo">
            <p><b>HEALTH</b> TRACK</p>
        </div>
        <form class="card-body col-sm-4 text-color">

            <h2>Batimentos por minuto</h2>
    
                <div class="corpo">
                    <label>BPM mais recente:
                        <input type="number" class="form-input" id="peso"/>
                    </label>
                    <button type="button" class="btn btn-success">Atualizar</button><br>                  
                </div>
    
                <div>
                    <label for="data-nascimento">Data:</label><br>
                    <input class="form-input" type="date" id="data-nascimento" name="data-nascimento">
                </div><br>

                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Observação:</label>
                    <textarea class="form-control" id="observacao" rows="3"></textarea>
                  </div><br>

                <button type="button" class="btn btn-success">Salvar dados</button>
        </form>
    </div>
    
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
        </script>
    </body>
        <div class="conteudo">
            
        </div>

        <div class="painel">
            <div class="wrapper">
                
            </div>
        </div>
    </div>


</body>

</html>