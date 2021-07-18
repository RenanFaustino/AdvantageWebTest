# language: pt
Funcionalidade: Criar Conta

  Contexto:
    Dado que eu acesse o site "https://advantageonlineshopping.com/#/"

  @criarNovaConta
  Esquema do Cenario: Criacao de nova conta
    E clico no campo usuario
    E clico no campo create new account
    E digito o usuario para registro "<usuario>"
    E digito o email "<email>"
    E digito a senha para registro "<senha>"
    E confirmo a senha "<senhaConfirmacao>"
    E digito o primeiro nome "<primeironome>"
    E digito o ultimo nome "<ultimonome>"
    E digito o celular "<celular>"
    E seleciono o pais "<pais>"
    E digito a cidade "<cidade>"
    E digito o endereco "<endereco>"
    E digito a regiao "<regiao>"
    E digito o cep "<cep>"
    E clico em eu concordo
    Quando clico em register
    Entao verifico se o usuario esta logado "<usuario>" "<screenShotName>"

    Exemplos:
      |		usuario       | 		email		        | senha 	 | senhaConfirmacao | primeironome  | ultimonome  | celular    | pais   | cidade   | endereco                  | regiao | cep 	     | screenShotName |
      | RenanFaustino10    | renanfaustino10@gmail.com  |	Renan123 | Renan123         |	Renan	    | Faustino    | 991223344  | Brazil | Campinas | Rua Carlos Almeilda, 226  | SP     | 13058-111  | Create         |