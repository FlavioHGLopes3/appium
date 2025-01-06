Feature: Realizar login com um funcionário ativo

  Scenario Outline: Realizar login na tela inicial
    Given que eu configure o PDV
    And acesse a tela de login
    When preencho o campo de <usuario> e <senha>
    Then é exibido a tela de menu
    Examples:
      | usuario | senha |
      | "3"     | "1"   |


