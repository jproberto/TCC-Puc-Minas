# TCC-Puc-Minas
Trabalho de conclusão de curso de pós graduação em Arquitetura de Sistemas Distribuídos, por João Paulo de Souza Roberto.

## Pré-requisitos
É necessário haver uma instância do MongoDB em execução.

## Instalação
Cada um dos projetos deve ser importado na IDE como um Maven Project.

## Execução
Por terem sidos desenvolvidos com Spring Boot, basta executar o método main da classe de lançamento. Essa classe está sempre localizada no caminho com o seguinte padrão:
```
/%nome-do-modulo%/src/main/java/br/com/joaopaulo/%nomedomodulo%/%NomeDoModulo%Application.java
```
É necessário que o projeto sica-discovery seja iniciado em primeiro lugar e em seguida o projeto sica-gateway. Os demais podem ser iniciados em qualquer ordem.

## Teste
Abaixo seguem as instruções para acessar os módulos e funcionalidades apresentados no vídeo de prova de conceito.

### Módulo de Controle de Processos Minerários
Esse módulo possui uma interface web. Para acessá-la, o caminho é http://localhost:8080/controleProcessos.

### Módulo de Controle de Barragens
As funcionalidades desse móduo devem ser acessadas por um REST Client. A URL de acesso é http://localhost:8080/controleBarragem e os endpoints liberados são os seguintes:

| Endpoint | Método | Descrição |
| -------- | ------ | ---- |
| /barragem/{idBarragem} | GET | Retorna as informações de uma barragem cadastrada, com seu nome, localização, leituras de seus sensores, etc. Se não for passado nenhum id de barragem, será retornada uma lista com todas as barragens cadastradas. |
| /checarBarragem/{idBarragem} | GET | Faz uma checagem nas leituras dos sensores de uma determinada barragem e, com base nessa informação, solicita ao módulo de Segurança e Comunicação que emita um alerta para as localidades próximas daquela barragem. A depender das leituras identificadas, o alerta pode ser de evacuação e deve incluir o plano cadastrado para cada localidade. Tais alertas podem ser enviados via e-mail ou enviando uma requisição HTTP GET para um endpoint, a depender das informações de cada destinatário cadastrado. |

Existem duas barragens cadastradas para teste e seus ids são BB1 e BB2.

### Módulo de Segurança e Comunicação
Conforme descrito acima, esse módulo é acionado diretamente pelo Controle de Barragens, sem necessidade de interferência externa.
