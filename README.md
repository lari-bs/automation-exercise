# Projeto Automation Exercise

Este projeto é um exemplo de automação de teste utilizando Selenium em Java e RestAssured para testar uma aplicação web e uma API REST, respectivamente.

## Estrutura do Projeto

```
Automation-exercise
├── screenshots
│   ├── 2023-07-12_19-25
│   │   └── test1
│   │       ├── 0.png
└── src
    └── test
        ├── java
        │   └── com
        │       └── automationexercise
        │           ├── data
        │           │   └── Products.java
        │           ├── driver
        │           │   └── DriverManager.java
        │           ├── pages
        │           │   ├── BasePage.java
        │           │   ├── CartPage.java
        │           │   └── HomePage.java
        │           └── tests
        │               ├── RestAssuredTest.java
        │               └── SeleniumTest.java
        └── resources
            ├── create-user-schema.json
            ├── get-user-list-schema.json
            ├── get-user-schema.json
            └── patch-user-schema.json
```

- A pasta `screenshots` contém capturas de tela tiradas durante a execução dos testes. As capturas de tela estão organizadas por data e cada teste possui uma pasta separada.

- A pasta `src/test/java` contém os arquivos de código-fonte dos testes e classes relacionadas.

- A pasta `src/test/resources` contém os arquivos JSON de esquema usados para validar as respostas da API.

## Configuração do Ambiente

### Selenium
O projeto utiliza o Selenium WebDriver para automação de testes de interface web. Para executar os testes, você precisa ter o ChromeDriver instalado. Certifique-se de ter a versão correta do ChromeDriver compatível com a versão do navegador Chrome instalado na sua máquina.

Você pode fazer o download do ChromeDriver no seguinte link: [https://sites.google.com/a/chromium.org/chromedriver/downloads](https://sites.google.com/a/chromium.org/chromedriver/downloads)

Após o download, extraia o arquivo e adicione o local do executável do ChromeDriver ao PATH do sistema operacional.

### Gradle
O projeto utiliza o Gradle como gerenciador de dependências e para executar os testes.

## Executando os Testes

Para executar os testes, abra o terminal na raiz do projeto e execute o seguinte comando:

```
./gradlew clean test
```

O comando acima limpará os resultados anteriores dos testes (pasta `build`) e executará todos os testes.

## Dependências

O projeto utiliza o Gerenciador de Dependências Gradle para gerenciar suas dependências. As dependências estão configuradas no arquivo `build.gradle` na raiz do projeto.

As principais dependências incluídas são:
- JUnit: Framework para escrever e executar testes unitários em Java.
- Selenium WebDriver: Biblioteca para automação de testes de interface web.
- RestAssured: Biblioteca para testes de API RESTful.
- io.rest-assured-json-schema: Biblioteca para validação de esquemas JSON.

Essas dependências são baixadas automaticamente pelo Gradle durante a execução dos testes.

## Outras Observações

- O projeto segue uma estrutura básica de Page Object Model (POM) para organizar as interações com as páginas web.
- Os testes do Selenium estão localizados no arquivo `SeleniumTest.java` e os testes do RestAssured estão no arquivo `RestAssuredTest.java`.
- Os arquivos JSON de esquema estão localizados na pasta `src/test/resources` e são usados para validar as respostas da API.
- Verificar versão do Java instalado na máquina, no momento da criação do projeto foi utilizado java 17.
- Os testes de selenium sofrem alguma demora devido aos ADs da página, qualquer problema é só rodar novamente o teste.
