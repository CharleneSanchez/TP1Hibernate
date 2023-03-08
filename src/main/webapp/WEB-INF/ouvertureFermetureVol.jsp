<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ouvrir/Fermer Vol</title>
</head>
<body>

<form method="post">
		<div class="mb-3">
			<label for="idVol" class="form-label">Id du vol</label>
			<input type="number" name="idVol" class="form-control">
		</div>
		<div class="mb-3">
			<label for="ouvrirFermer" class="form-label">Ouvrir ou fermer le vol à la réservation </label>
			<input type="radio" name="ouvrirFermer" class="form-control" value="ouvrir">Ouvrir
			<input type="radio" name="ouvrirFermer" class="form-control" value="fermer">Fermer
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
		<button type="reset" class="btn btn-danger">Annuler</button>
	</form>

</body>
</html>