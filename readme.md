
#Missão Marte

Orientações de uso
------------------

Baixando as depêndencias do projeto

O projeto utiliza o maven para o gerenciamento de dependencias, o primeiro passo que você precisa fazer
para brincar com o robo é baixar as dependecias do projeto, para isso execute o comando abaixo.
	
	
    mvn clean package

Para garantir que o robo não se perca sob a superfície de marte foram programados diversos testes que simulam sua operação em terreno marciano, para executar os testes rode o comando abaixo. 

    mvn clean test

 Para iniciar o nosso robo execute o comando abaixo

     mvn spring-boot:run


Enviando comandos para Marte
----------------------------

A interface de comunicação entre a terra e robo é através de uma API REST, então vamos brincar com o nosso robo.


Uma vez iniciado agora podemos enviar comandos para ele, para controlar cada robô, a NASA envia uma string simples, que pode conter as letras ‘L’, ‘R’ e ‘M’. As letras ‘L’ e ‘R’ fazem o robô rotacionar em seu próprio eixo 90 graus para esquerda ou para direita, respectivamente, sem se mover da sua posição atual. A letra ‘M’ faz o robô deslocar-se uma posição para frente.

**Movimento com rotações para direita:**

    curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
    Saída esperada: (2, 0, S)

**Movimento para esquerda:**

    Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML
    Saída esperada: (0, 2, W)

**Repetição da requisição com movimento para esquerda:**

    Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML
    Saída esperada: (0, 2, W)

**Comando inválido:**

    curl -s --request POST http://localhost:8080/rest/mars/AAA
    Saída esperada: 400 Bad Request

**Posição inválida:**

    curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM
    Saída esperada: 400 Bad Request


**Posição atual:**

    curl -s --request POST http://localhost:8080/rest/mars/robo/position
    Saída esperada: (2, 0, S)


Detalhes Técnicos
----------------------------
A partir do momento que a primeira requisição ao robô é realizada, a Classe RoboServiceImpl realiza uma consulta a base de dados H2 em memória para verificar se já existe um robô criado, caso exista um robô é utilizado o robô da base de dados, caso não seja encontrado um robô, um novo será criado na posição (0,0,N) com uma área de 5X5.

A partir do momento que um Robo é registrado na base de dados ele será utilizado durante todo o ciclo de vida da aplicação.

A cada requisição realizada com sucesso uma nova posição é registrada no Robo.

Para recuperar a ultima posição basta acessar a API abaixo:


    curl -s --request POST http://localhost:8080/rest/mars/robo/position
    Saída esperada: (2, 0, S)

Pontos de melhoria para próximas versões:

 - Permitir criar um novo robô via API
 - Alterar a area do terreno via API
 - Reiniciar posição atual
 - Relatório com todas as coordenadas enviadas

# Dúvidas e bugs
email: contato.raphaelinacio@gmail.com
telefone: 11-954950529

