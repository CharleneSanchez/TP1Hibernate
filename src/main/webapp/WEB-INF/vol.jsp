<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vol</title>
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
			<label for="exampleInputPassword1" class="form-label">Date du départ </label>
			<input type="date" name="dateD" class="form-control"id="exampleInputPassword1">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Heure du départ </label>
			<input type="text" name="heureD" class="form-control"id="exampleInputPassword1">
		</div>
		<div class="mb-3">
			<label for="aeroportD" class="form-label">ID Aeroport de départ :</label>
			<input type="text" name="aeroportD" class="form-control">
		</div>
		<div class="mb-3">
			<label for="aeroportA" class="form-label">ID Aeroport d'arrivé :</label>
			<input type="text" name="aeroportA" class="form-control">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Date d'arrivée </label>
			<input type="date" name="dateA" class="form-control"id="exampleInputPassword1">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Heure d'arrivée </label>
			<input type="text" name="heureA" class="form-control"id="exampleInputPassword1">
		</div>
	
		
		<button type="submit" class="btn btn-primary">Submit</button>
		<button type="reset" class="btn btn-danger">Annuler</button>
	</form>


</body>
</html>