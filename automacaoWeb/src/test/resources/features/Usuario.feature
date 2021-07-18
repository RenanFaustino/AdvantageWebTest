#language: pt
Funcionalidade: Criar novo usuario

  Contexto:
    Dado que eu acesse o site "https://advantageonlineshopping.com/#/"

  @loginComSucesso
  Esquema do Cenario: Fazer login com um usuario valido
    E clico no campo usuario
    E digito o usuario "<usuario>"
    E digito a senha "<senha>"
    Quando clico em sign in
    Entao verifico se o usuario esta logado "<usuario>" "<screenShotName>"

    Exemplos:
      |		usuario       | senha 	 | screenShotName |
      | RenanFaustino4    |	Renan123 | LoginSuccess    |



  @usuarioOuSenhaInvalida
  Esquema do Cenario: Fazer login com um usuario invalido
    E clico no campo usuario
    E digito o usuario "<usuario>"
    E digito a senha "<senha>"
    Quando clico em sign in
    Entao verifico se a mensagem "<mensagem>" foi retornada "<screenShotName>"

    Exemplos:
      |		usuario       | senha 	 |  mensagem                           | screenShotName |
      | RenanFaustin44    |	Renan123 |  Incorrect user name or password.   | UserInvalid    |



  @usuarioBloqueado
  Esquema do Cenario: Bloquear temporariamente um usuario
    E clico no campo usuario
    E digito o usuario "<usuario>"
    E digito a senha "<senha>"
    E clico em sign in
    E espero alguns segundos para tentar logar novamente
    E verifico se a mensagem "<mensagemOR>" foi retornada "<screenShotName>"
    E clico em sign in
    E espero alguns segundos para tentar logar novamente
    E verifico se a mensagem "<mensagemOR>" foi retornada "<screenShotName>"
    E clico em sign in
    E espero alguns segundos para tentar logar novamente
    E verifico se a mensagem "<mensagemOR>" foi retornada "<screenShotName>"
    Quando clico em sign in
    Entao verifico se a mensagem "<mensagenBlocked>" foi retornada "<screenShotName>"

    Exemplos:
      |		usuario       | senha 	  |  mensagenBlocked                         | mensagemOR | screenShotName |
      | RenanFaustino3    |	Renan122  |  User is temporary blocked from login    | OR         | UserBlocked    |