
Feature: Buscar en la página web de eltiempo.es el tiempo de una localidad específica

  Scenario: Al introducir en el cuadro de búsqueda 'San Roque' debe aparecer la página del tiempo de tal localidad
    Given Un usuario se encuentra en la página principal de eltiempo.es
    And quiere encontrar el tiempo que hace en San Roque
    When Introduce "San Roque" en el cuadro de búsqueda
    And Clica en la primera opción
    Then Se muestra la página con el título de San Roque
