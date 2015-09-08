<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!doctype html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Questionário</title>
</head>
<body>
	
	${respostaValida}
	${emailInvalido}
	
	<table class="table table-striped"  >
        <thead>
            <tr>
            	<th>Id</th>
                <th>Questão</th>
                <th>Aberta</th>
                <th>Link</th>
            </tr>
        </thead>
        <tbody>
       		<c:forEach items="${questoes}" var="questao" >
       			<tr> 
       				<td>${questao.id}</td>
       				<td>${questao.enunciado}</td>
       				<td>${questao.aberta ? 'Sim' : 'Não'}</td>
       				
       				<td><a href="<c:if test='${questao.aberta}'> ${linkTo[QuestaoController].visualizaQuestAberta(questao)} </c:if> 
       							 <c:if test='${!questao.aberta}'> ${linkTo[QuestaoController].visualizaQuestFechada(questao)} </c:if>"  class="btn btn-info btn-sm" role="button">Visualizar</a></td>
       			</tr>
       		</c:forEach>
        </tbody>
    </table>
	
	
</body>
</html>