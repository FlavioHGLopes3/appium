# language: pt


@Rateio
Funcionalidade: Pay possui a condição de realizar pagamentos de forma pacial
  É possivel realizar a venda de X produtos selecionados


  Contexto:
    Dado que o pdv esteja configurado com a chave ECF-Trunca valores Totais igual a SIM e logado
    Entao é exibido o menu inicial


  Cenario: venda de dois produtos com mais de uma forma de pagamento
    Dado um produto no valor de 10 reais
    E outro produto no valor de 8 reais
    Quando pressionado para ir em tela de prazos
    E efetuar pagamento de 5 reais
    Entao o saldo restante deve exibir 13 reais
    E demais prazos devem exibir 13 reais
    E deve ser possivel finalizar a venda lançando o pagamento exibido