# lojaMs
Projeto do Curso de Microservices com Spring Cloud da Alura

## Palavras-chave
Quebrar solução em ms, comunicação de ms entre si, load balance de requisições (perfomance), gestão de configuração, log de transações com auditoria, pendurar transações (commit/ rollback), expor os ms na internet, autenticação/autorização stateless.

## Ambiente de desenvolvimento
- Maria DB >= 10.3.15, HeidiSQL (cliente)
- Spring Tools 4 for Eclipse
- Java 1.8 (verificar pom)
- Spring Boot 2.1.5

## Domínio
- O Domínio da aplicação é quebrado em contextos menores utilizando DDD (Domain Driven Design)
- Cada contexto é uma implementação de ms diferente: Fornecedor, Loja e Transportador
- Cada contexto da modelagem possui necessidades específicas e sua independência do resto da aplicação induz ao baixo acoplamento.
![Contexto](https://github.com/j19791/lojaMs/blob/master/contexto.jpg)

## Requisição
![Contexto](https://github.com/j19791/lojaMs/blob/master/imagens/aula1_requisicao_json.jpg)

## RestTemplate
Resover o ip/porta passando apenas o id 

## Load Balancing 
Processo de distribuir as requisições vindas dos usuários para as várias instâncias disponíveis. A cada requisição, o Ribbon rotaciona para uma instância diferente.
