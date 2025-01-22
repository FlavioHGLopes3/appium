# language: pt


Funcionalidade: realizando login
  Somente será realizado login se tef_tipotef
  estiver corretamente configurada e se as credenciais
  de usuário estiverem corretas




  Cenario: Login após configuração incorreta do gerenciador_tef PDV
    Dado que o pdv esteja configurado incorretamente
    Quando informo o usuario e senha
    Então é exibido um toast de "gerenciador tef incorreto"


  Cenario: login valido mas tef incorreto
    Dado que eu esteja na tela de login
    Quando pressiono o botão de alterar configuracoes
    E configuro IP
    E seleciono o PDV incorreto
    