<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle réservation</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>

<form method="post">
		<div class="mb-3">
			<label for="pc" class="form-label">Deja client ? </label> <br/>
			<input type="radio" name="pc" value="client">Oui
			<input type="radio" name="pc" value="passager">Non
		
		</div>
		<div class="mb-3">
			<label for="idClient" class="form-label">Entrer l'id Client</label>
			<input type="text" name="idClient" class="form-control"id="inputidClient">
		</div>
		<div class="mb-3">
			<label for="nom" class="form-label">Nom :</label> 
			<input type="text" name="nom" class="form-control">
		</div>
		<br/><br/>
		<div class="mb-3">
			<label for="nom" class="form-label">Prenom :</label> 
			<input type="text" name="prenom" class="form-control">
		</div>
		<br/><br/>
		<div class="mb-3">
			<label for="inputNumVol" class="form-label">Entrer le numéro du vol</label>
			<input type="text" name="numVol" class="form-control"id="inputNumVol">
		</div>
		
		
	
		
		<button type="submit" class="btn btn-primary">Envoyer</button>
		<button type="reset" class="btn btn-danger">Annuler</button>
	</form>

</body>
</html>