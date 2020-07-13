Este projeto tem o intuito de apresentar o desenlvolvimento de um servidor e client TCP.

A comunicação é realizada atraves da porta (2222), podendo ser alterada.

As mensagens recebidas no servidor são salvas no banco de dados H2 em memória, usando
hibernate como framework objeto-relacional.

Também são salvos em arquivos as mensagens recebidas tanto do client quanto no servidor, onde 

seus nomes são respectivamente: messagesReceiverClient.log e messagesReceiverServer.log

As mensagens do client devem ser enviado no formato StringHexadecimal, conforme
definido no protocolo. 

Qualquer erro que o servidor detectar na mensagem ou seu processamento,
será notificado na console e enviado um frame de erro (0X50).

# Executar o Servidor
classe: mbs.server.MainServer

java version 7+

# Executar o Client
classe: mbs.client.MainClient

java version 7+

## Exemplos de requisição
0A0CA16d617263656c6fDC0D 								= FRAME 01

0A10A22650AB076d617263656c6f160D  						= FRAME 02

0A16A3416D65726963612F53616F5F5061756C6FCD0D			= FRAME 03

