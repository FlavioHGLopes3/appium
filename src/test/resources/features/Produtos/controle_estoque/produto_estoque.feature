# language: pt


Funcionalidade: estoque de produto
  No PDV mobile, é possível configurar no cadastro de produto se um determinado produto pode ou não ser vendido com estoque negativo.
  A validação é feita no momento em que o produto é pressionado.



  Contexto: pdv configurado e o usuario logado
    Dado que o pdv esteja configurado e logado
    Entao é exibido o menu inicial



  Cenario: produto que nao permite vender estoque negativo
    Dado um produto com estoque negativo
    Quando pressionado para informar a quantidade
    Entao é exibido um toast de estoque insuficiente

  Cenario: produto com estoque zerado
    Dado um produto com estoque zerado
    Quando pressionado para informar a quantidade
    Entao é exibido um toast de estoque insuficiente

  Cenario: produto que permite vender com estoque negativo
    Dado um produto que permite a venda com estoque negativo
    Quando pressionado para informar a quantidade
    Entao é exibido a tela de informar quantidade