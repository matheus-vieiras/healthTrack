<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Health Track - Dieta</title>
    <link href="../css/dieta.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>
    <script src="js/home.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

    <div class="box">
        <div class="titulo">
            <p><b>HEALTH</b> TRACK</p>
        </div>

        <div class="painel">
            <select class="form-select" aria-label="Default select example">
                <option selected>Selecione horário da refeição</option>
                <option value="1">Café da Manhã</option>
                <option value="2">Almoço</option>
                <option value="3">Jantar</option>
            </select>
        </div>
        <div class="aliment-campo">
            <div class="input-group input-group-sm mb-3">
                <span class="input-group-text" id="inputGroup-sizing-sm">Digite o nome do seu alimento</span>
                <input type="text" class="form-control" aria-label="Sizing example input"
                    aria-describedby="inputGroup-sizing-sm">
            </div>
        </div>
        <div>
            <div class="input-group input-group-sm mb-3">
                <span class="input-group-text" id="inputGroup-sizing-sm">Dia de consumo do alimento</span>
                <input type="date" class="form-control" aria-label="Sizing example input"
                    aria-describedby="inputGroup-sizing-sm">
            </div>
        </div>
        <div>
            <a href="../dashboard.jsp"><input class="btn btn-primary" type="button" value="Cadastrar"></a>
        </div>
    </div>
    <div>
        <a href="../dashboard.jsp"><input class="btn btn-primary" type="button" value="Cadastrar"></a>
    </div>
</body>

</html>