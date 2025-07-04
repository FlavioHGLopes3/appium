# language: pt
# necessario que o pdv safrapay esteja com a chave transferencia bancaria 0


@Login
Funcionalidade: realizando login
  Somente será realizado login se tef_tipotef
  estiver corretamente configurada e se as credenciais
  de usuário estiverem corretas



  Cenario: Login após configuração incorreta do gerenciador_tef PDV
    Dado que o pdv esteja configurado incorretamente
    Quando informo o usuario e senha
    Então é exibido um toast de gerenciador tef incorreto


  Cenario: Login após configuração correta do gerenciador_tef PDV
    Dado que o pdv esteja configurado corretamente
    Quando informo o usuario e senha
    Então é exibido o menu inicial

  @Emulator
  Cenario: Login incorreto
    Dado que o pdv esteja configurado corretamente
    Quando informo usuario e senha incorretos
    Então é exibido um toast de Login ou Senha Inválido

  @Emulator
  Cenario: Login correto
    Dado que o pdv esteja configurado corretamente
    Quando informo usuario e senha correto
    Então é exibido o menu inicial


  Cenario: PDV não configurado com chave de transferencia bancaria
    Dado que o pdv não esteja configurado com a chave de transferência bancária
    Quando informo usuario e senha corretos e realizo o login
    Então é exibido um toast de verificar o prazo padrão