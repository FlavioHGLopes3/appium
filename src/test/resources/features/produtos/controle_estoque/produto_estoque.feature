# language: pt

@Estoque
Funcionalidade: estoque de produto
  Permissão do funcionário: Se o funcionário tem permissão, a venda é permitida, independentemente das configurações do PDV e do produto.
  Configuração do PDV: Se o funcionário não tem permissão, mas o PDV permite, a venda pode ser permitida se o produto também estiver configurado para permitir.
  Configuração do produto: Se o funcionário não tem permissão e o PDV não permite, a configuração do produto não tem efeito.


  Contexto:
    Dado que o pay esteja conectado no servidor


  Cenario: funcionario com permissao para vender produtos com estoque negativo, pdv e produto sem permissao
    Dado um pdv sem permissao
    E um funcionario com permissao
    E um produto sem permissao
    Quando pressionado para informar a quantidade
    Entao é possível realizar o fluxo de venda



  Cenario: funcionario sem permissao para vender produtos com estoque negativo, pdv e produto com permissao
    Dado um pdv com permissao
    E um funcionario com permissao
    E um produto com permissao
    Quando pressionado para informar a quantidade
    Entao é possível realizar o fluxo de venda



  Cenario: funcionario e pdv sem permissao para vender produtos com estoque negativo, produto com permissao
    Dado um pdv sem permissao
    E um funcionario sem permissao
    E um produto com permissao
    Quando pressionado para informar a quantidade
    Entao é possível realizar o fluxo de venda