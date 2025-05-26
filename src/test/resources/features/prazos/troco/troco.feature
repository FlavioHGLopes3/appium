# language: pt


Funcionalidade: PDV possui duas validações de troco, sendo uma no cadastro de prazo de forma percentual e a outra
  através da chave PDV-Valor Máximo de troco em Cartao apenas para os prazos do tipo CARTAO.
  Se o cadastro de prazo estiver = 0, não há limites de troco.
  Se a chave = 0, não será possível conceder desconto. Valor da chave é em valor real, ou seja, 10 = R$ 10,00
  Caso as duas estiverem configuradas, o PDV irá validar a configuração de menor valor após realizar calculo.




# Para o seguinte cenario foi configurado o campo pra_vl_pr_max_troco = 20 do prazo 001

  Cenario: cadastro de prazo configurado com limite percentual de troco
    Dado que o pdv esteja na tela de prazos
    Quando selecionado o prazo com percentual definido
    Entao o campo ira permitir informar um valor de ate X% maior que o exibido pelo prazo




# Para o seguinte cenario foi configurado a chave com o valor = 20 do pdv 001

  Cenario: chave configurada com limite de troco no cartao
    Dado um pdv configurado para conceder descontos de ate determinado valor no cartao
    E que o pdv esteja na tela de prazos
    Quando selecionado o prazo cartao
    Entao o campo ira permitir informar um valor de ate X reais maior que o exibido pelo prazo





# Para o seguinte cenario foi configurado o pdv 002 e o prazo 011

  Cenario: cadastro de prazo do tipo cartao definido com valor acima de 0 e chave configurada com 0
    Dado um pdv configurado para nao conceder descontos em prazos do tipo cartao
    E que o pdv esteja na tela de prazos
    Quando selecionado um prazo do tipo cartao
    Entao o campo nao ira permitir informar um valor maior que o exibido pelo prazo

