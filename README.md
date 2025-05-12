<!DOCTYPE html>
<html lang="pt-BR">
<body>

  <h1>🧪 Projeto DemoQA - Testes Automatizados</h1>
  <p>Este repositório contém a automação de testes da aplicação <strong>DemoQA</strong>, desenvolvida com Java, Cucumber e Selenium WebDriver. Os testes geram relatórios automaticamente e são executados por uma <strong>workflow do GitHub Actions</strong>, tanto manualmente quanto via push de commits.</p>

  <h2>📋 Descrição do Projeto</h2>
  <p>O objetivo é validar o comportamento da aplicação DemoQA com foco em <strong>BDD (Behavior Driven Development)</strong>. A estrutura foi pensada para oferecer:</p>
  <ul>
    <li>✅ Fácil manutenção e escalabilidade</li>
    <li>📖 Leitura fluida dos cenários de teste</li>
    <li>📊 Geração automática de relatórios</li>
    <li>⚙️ Integração contínua via GitHub Actions</li>
  </ul>

  <h2>🛠️ Tecnologias Utilizadas</h2>
  <ul>
    <li>☕ Java 11+</li>
    <li>🧪 Cucumber</li>
    <li>🧭 Selenium WebDriver</li>
    <li>✅ JUnit</li>
    <li>📦 Maven</li>
    <li>⚙️ GitHub Actions</li>
  </ul>

  <h2>📊 Relatórios HTML Cucumber</h2>
  <p>Após a execução, um relatório em HTML é gerado com um resumo dos testes:</p>
  <ul>
    <li>✅ Total de testes executados</li>
    <li>✔️ Testes que passaram</li>
    <li>❌ Testes que falharam</li>
    <li>🔎 Detalhes de cada passo</li>
  </ul>

  <h2>▶️ Como Executar os Testes</h2>

  <h3>🧪 Execução Local</h3>
  <p><strong>1.</strong> Clone o repositório:</p>
  <pre><code>git clone https://github.com/rcjalves/demoqa.git
cd demoqa</code></pre>

  <p><strong>2.</strong> Execute os testes com Maven:</p>
  <pre><code>mvn test</code></pre>
  <p><strong>📁 Relatórios disponíveis em:</strong> <code>target/cucumber-reports/</code></p>

  <h3>☁️ Execução via GitHub Actions</h3>
  <p>O pipeline está configurado para executar:</p>
  <ul>
    <li>📌 Ao fazer <code>push</code> para a branch principal (main ou master)</li>
    <li>🚀 Via execução manual</li>
  </ul>

  <p><strong>Para executar manualmente:</strong></p>
  <ol>
    <li>Acesse a aba <strong>Actions</strong> no repositório</li>
    <li>Selecione o workflow <code>run-tests</code></li>
    <li>Clique em <strong>Run workflow</strong></li>
  </ol>

  <h2>📦 Gerenciamento de Dependências</h2>
  <p>As dependências do projeto são gerenciadas via Maven. Consulte o arquivo <code>pom.xml</code> para detalhes de versões e bibliotecas utilizadas.</p>

  <h2>📌 Considerações</h2>
  <ul>
    <li>📂 Estrutura modular, coesa e desacoplada</li>
    <li>📘 Foco em boas práticas de automação com BDD</li>
    <li>🌐 Pronto para integração com outros ambientes e pipelines</li>
  </ul>

</body>
</html>
