Este projeto tem o intuito de apresentar o desenlvolvimento de um servidor e client TCP.

A comunicação é realizada atraves da porta (2222), podendo ser alterada.

As mensagens recebidas no servidor são salvas no banco de dados H2 em memória, usando
hibernate como framework objeto-relacional.

Também são salvo em arquivos as mensagens recebidas tanto no client quanto no servidor.
Os nomes são: messagesReceiverClient.log e messagesReceiverServer.log

As mensagens do client devem ser enviado no formato StringHexadecimal, conforme
definido no protocolo. 

Qualquer erro que o servidor detectar na mensagem ou seu processamento,
será notificado na console e enviado um frame de erro (0X50).

# Executar o Servidor
classe: mbs.server.MainServer

# Executar o Client
classe: mbs.client.MainClient

