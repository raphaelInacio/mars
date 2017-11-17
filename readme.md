
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
    Saída esperada: 400 Bad Request


# Dúvidas 

