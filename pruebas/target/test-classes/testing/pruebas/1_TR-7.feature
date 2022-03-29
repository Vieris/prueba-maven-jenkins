@TR-25
@REQ_TR-7
Feature: Agregar productos de la tienda al ChopinCar

	@TEST_TR-24
	Scenario: Validar que se agregan productos de la tienda al ChopinCar
		Scenario Un usuario al elegir un producto del PLP se añade al chopincar correctamente
		
		Given el usuario está en el PLP
		
		When hace click en “Añadir al carrito”
		
		Then aparece un mensaje “añadiendo al carrito”
		
		And aparece el mensaje “añadido al carrito correctamente”
		
		And aparece un icono de carrito para ver los productos encima del listado de productos
		
		And dentro del mensaje hay un enlace en “ver carrito”
