package screen;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebdriverUtils;

public class DemoWebTablesScreen {

	WebDriver driver;
	WebdriverUtils utils;

	public DemoWebTablesScreen(WebDriver driver) {
		this.driver = driver;
		this.utils = new WebdriverUtils(driver);
	}

	By btnAdd = By.id("addNewRecordButton");
	By inputFirstName = By.id("firstName");
	By inputLastName = By.id("lastName");
	By inputEmail = By.id("userEmail");
	By inputAge = By.id("age");
	By inputSalary = By.id("salary");
	By inputDepartment = By.id("department");
	By btnSubmit = By.xpath("//button[@id='submit']");
	By tabelaResultados = By.className("rt-tbody");

	String xpathEditarUsuario = "//div[@class='rt-tr-group']//div[contains(text(),'%s')]/following-sibling::div//span[@title='Edit']";
	String xpathExcluirUsuario = "//div[@class='rt-tr-group']//div[contains(text(),'%s')]/following-sibling::div//span[@title='Delete']";

	public By getBotaoEditar(String nome) {
		return By.xpath(String.format(xpathEditarUsuario, nome));
	}

	public By getBotaoExcluir(String nome) {
		return By.xpath(String.format(xpathExcluirUsuario, nome));
	}

	public void clicarBotaoAdicionar() {
		utils.scrollToElement(btnAdd);
		utils.clicar(btnAdd);
	}

	public void preencherFormulario(String nome, String sobrenome, String email, String idade, String salario,
			String departamento) {
		utils.inserirValor(inputFirstName, nome);
		utils.inserirValor(inputLastName, sobrenome);
		utils.inserirValor(inputEmail, email);
		utils.inserirValor(inputAge, idade);
		utils.inserirValor(inputSalary, salario);
		utils.inserirValor(inputDepartment, departamento);
	}

	public void clicarBotaoSubmit() {
		utils.scrollToElement(btnSubmit);
		utils.sleep();
		utils.clicarComJavaScript(btnSubmit);
	}

	public void validarUsuarioNaTabela(String nomeEsperado) {
		WebElement elemento = driver.findElement(By.xpath("//*[contains(text(),'" + nomeEsperado + "')]"));
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", elemento);

		String textoElemento = elemento.getText();
		if (!textoElemento.contains(nomeEsperado)) {
			throw new AssertionError("Usuário não encontrado na tabela: " + nomeEsperado);
		}

		utils.sleep(2000);
	}

	public void clicarEditarUsuario(String nome) {
		By botaoEditar = getBotaoEditar(nome);
		utils.scrollToElement(botaoEditar);
		utils.clicar(botaoEditar);
	}

	public void editarUsuario(String nome, String sobrenome, String email, String idade, String salario,
			String departamento) {

		if (nome != null && !nome.isEmpty()) {
			utils.inserirValorInputLimpaTab(inputFirstName, nome);
		}
		if (sobrenome != null && !sobrenome.isEmpty()) {
			utils.inserirValorInputLimpaTab(inputLastName, sobrenome);
		}
		if (email != null && !email.isEmpty()) {
			utils.inserirValorInputLimpaTab(inputEmail, email);
		}
		if (idade != null && !idade.isEmpty()) {
			utils.inserirValorInputLimpaTab(inputAge, idade);
		}
		if (salario != null && !salario.isEmpty()) {
			utils.inserirValorInputLimpaTab(inputSalary, salario);
		}
		if (departamento != null && !departamento.isEmpty()) {
			utils.inserirValorInputLimpaTab(inputDepartment, departamento);
		}

		clicarBotaoSubmit();
	}

	public void editarUsuario(String nome, String novoDepartamento) {
		editarUsuario(nome, null, null, null, null, novoDepartamento);
	}

	public void clicarBotaoExcluir(String nome) {
		By botaoExcluir = getBotaoExcluir(nome);
		utils.scrollToElement(botaoExcluir);
		utils.clicar(botaoExcluir);
		utils.sleep(1000);
	}

	public void validarUsuarioExcluido(String nome) {
		boolean usuarioAindaExiste = driver.findElements(By.xpath("//*[contains(text(),'" + nome + "')]")).size() > 0;
		if (usuarioAindaExiste) {
			throw new AssertionError("Usuário ainda está presente na tabela após exclusão: " + nome);
		}
	}

}
