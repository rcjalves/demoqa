package steps;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import screen.DemoWebTablesScreen;
import utils.YamlReader;

public class DemoWebTablesSteps {

    DemoWebTablesScreen demoWebTablesScreen;
    Map<String, String> usuario;

    @Dado("que o usuario acesse o sistema")
    public void que_o_usuario_acesse_o_sistema_na_url() {
        demoWebTablesScreen = new DemoWebTablesScreen(Base.driver);           
    }


    @Quando("o usuario preencher o formulario")
    public void o_usuario_preencher_o_formulario() {
    	
    	usuario = YamlReader.lerYamlUsuario("dados/usuario.yaml");
    	
        demoWebTablesScreen.clicarBotaoAdicionar();
        demoWebTablesScreen.preencherFormulario(
                usuario.get("nome"),
                usuario.get("sobrenome"),
                usuario.get("email"),
                usuario.get("idade"),
                usuario.get("salario"),
                usuario.get("departamento"));
        
        demoWebTablesScreen.clicarBotaoSubmit();
    }

    @Entao("o usuario é criado com sucesso")
    public void o_usuario_é_criado_com_sucesso() {
        demoWebTablesScreen.validarUsuarioNaTabela(usuario.get("nome"));
    }
    
    
    @Dado("que o usuario tenha sido criado previamente") 
    public void que_o_usuario_tenha_sido_criado_previamente() {
        demoWebTablesScreen = new DemoWebTablesScreen(Base.driver); 
        o_usuario_preencher_o_formulario();
    }


    @Quando("o sistema exibir a lista de usuarios")
    public void o_sistema_exibir_a_lista_de_usuarios() {
    	WebElement tabelaUsuarios = Base.driver.findElement(By.className("rt-table"));
        Assert.assertTrue("A tabela de usuários não está visível!", tabelaUsuarios.isDisplayed());
    }

    @Entao("o sistema exibe o nome do usuario na tabela")
    public void o_sistema_exibe_o_nome_do_usuario_na_tabela() {
    	 demoWebTablesScreen.validarUsuarioNaTabela(usuario.get("nome"));
    }

    @Quando("o usuario clicar no botao editar")
    public void o_usuario_clicar_no_botao_editar() {
    	demoWebTablesScreen.clicarEditarUsuario(usuario.get("nome"));
    }

    @E("alterar os dados do usuario")
    public void alterar_os_dados_do_usuario() {
        demoWebTablesScreen.editarUsuario(usuario.get("usuarioEstrangeiro"),usuario.get("departamentoTec"));
    }
    
    @Entao("os dados do usuario devem ser atualizados na tabela")
    public void os_dados_do_usuario_devem_ser_atualizados_na_tabela() {
    	demoWebTablesScreen.validarUsuarioNaTabela(usuario.get("usuarioEstrangeiro"));
    }
    
    @Quando("o usuario clicar no botao excluir")
    public void o_usuario_clicar_no_botao_excluir() {
        demoWebTablesScreen.clicarBotaoExcluir(usuario.get("nome"));
    }

    @Entao("o sistema remove o usuario da listagem")
    public void o_sistema_remove_o_usuario_da_listagem() {
        demoWebTablesScreen.validarUsuarioExcluido(usuario.get("nome"));
    }
}
