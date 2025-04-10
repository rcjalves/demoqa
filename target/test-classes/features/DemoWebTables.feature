#language: pt
#Author: riancarlosjesus@gmail.com
#Descrição: Este arquivo contém os cenários de teste BDD para operações CRUD na tabela Web da DemoQA.

@crud
Funcionalidade: CRUD de usuários na Web Tables da DemoQA
  Como um usuário do sistema
  Quero realizar as operações de CRUD na tabela Web
  Para gerenciar os dados dos usuários de forma eficiente
  
  @criar
  Cenario: Criar um usuario com sucesso na tabela 
    Dado que o usuario acesse o sistema
    Quando o usuario preencher o formulario  
    Entao o usuario é criado com sucesso 
    
	@visualizar
  Cenario: Visualizar usuario criado 
    Dado que o usuario tenha sido criado previamente
    Quando o sistema exibir a lista de usuarios
    Entao o sistema exibe o nome do usuario na tabela

  @editar
  Cenario: Editar usuario e salvar edição
    Dado que o usuario tenha sido criado previamente
    Quando o usuario clicar no botao editar
    E alterar os dados do usuario
    Entao os dados do usuario devem ser atualizados na tabela

  @excluir
  Cenario: Excluir usuario criado e validar exclusão
    Dado que o usuario tenha sido criado previamente
    Quando o usuario clicar no botao excluir
    Entao o sistema remove o usuario da listagem
    
    
    
    