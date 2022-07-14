Feature: interactuar con la app calculadora
yo como usuario quiero automatizar la app
y realizar operaciones matematicas

  @Operaciones
  Scenario: Realizar operaciones matematicas
    Given que abro la apicacion de la calculadora
    When Cuando ingreso los parametros de la operacion <parm1>,<parm2>,<tipope>
    And hago clic en la tecla igual
    Then valido el resultado de la operacion <parm1>,<parm2>,<tipope>

    Examples: 
      | parm1  | parm2 | tipope	|
      |  8 		 |   9   |   * 		|