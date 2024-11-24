<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Alumni+Sans+Pinstripe&display=swap" rel="stylesheet">
    <link rel="icon" href="img/logo_00remove-removebg-preview.png">
    <link rel="stylesheet" href="css/estiloRegistro.css">
    <title>Registro</title>
</head>
<body>
    <header>
        
        <h1><i>ARTTECH</i></h1>
    </header>

    <div id="main">
        <form action="registrar-usuario" method="get">
            
            <label for="">Nombre</label>
            <input type="text" placeholder="Nombre" name="nombre" required>
            
            <label for="">Correo Electronico</label>
            <input type="email" placeholder="Email" name="mail" required>
            
            <label for="">Telefono</label>
            <input type="number" placeholder="Numero de Telefono" name="telefono" required>
            
            
            <label for="">Contraseña</label>
            <input type="password" placeholder="******" name="contrasenia" required>
            
            <label for="">Fecha De Nacimiento</label>
            <input type="date" name ="fecha" required>
            
            <button>Registrarse</button>
            <span class="error"></span>
        </form>
    </div>
    
    <footer>
        <img src="img/logo_00remove-removebg-preview.png" alt="">
    </footer>
	
	
</body>
</html>