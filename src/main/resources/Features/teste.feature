#language: pt
Funcionalidade: Logar no aplicativo

  Contexto: PDV Configurado

  Cenario: Realizar login na tela inicial
    Dado que eu configure o PDV
    E acesse a tela de login
    Quando preencho o campo de <usuario> e <senha>
    Então é exibido a tela de menu

    Exemplo:
      | usuario | senha |
      | "3"     | "1"   |


