<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!doctype html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="<c:url value='/resources/css/estilo.css'/>" /> 

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Questão</title>
</head>
<body>
	 
<div class="perguntaCont">
	
	<h1>${questao.enunciado}</h1>
		
	<p>Responda: </p>	
    <form action="${linkTo[QuestaoController].responder}" method="POST">
    		
    	
        <div class="form-group">
            <label for="inputNome">Seu Nome:</label>
            <input type="text" id="inputNome" placeholder="Nome" name="respostaUsuario.nome">
        </div>
        <div class="form-group">
            <label for="inputEmail">Seu E-mail:</label>
            <input type="text" id="inputEmail" placeholder="Password" name="respostaUsuario.email">
        </div>
        
        <div class="form-group">
        	<label for="inputResposta">Resposta:</label>
        	<textarea rows="3" cols="60" name="respostaUsuario.resposta"></textarea>
        </div>
        
        <input type="hidden" name="respostaUsuario.idQuest" value="${questao.id}" />
        
        <button type="submit" class="btn btn-primary">Responder</button>
    </form>
</div>

	
</body>
</html>