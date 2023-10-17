### **Teste prático registro de pedidos**
    
O projeto faz uso de serviços que estão em containers, sendo eles mysql 8.0 e rabbitmq 3.9.7, no entanto a aplicação está de forma local.

Para executar o projeto, deve-se subir os containers com o comando de **docker-compose up**

Em seguida executar o arquivo no formato .jar
para isso utilize o comando **mvn clean install spring-boot:run**

Em um gerenciador de banco de dados (MySql Community, Dbeaver... etc) será criado as tabelas relacionais do projeto.

Para acesso do banco de dados, foi definido um login e senha, sendo necessários para autenciar a conexão com o banco de dados. 
* username = *root*
* password = *pag123*

Além disso, vale notar que foi exposto a porta *3306* para acesso do banco.

O acesso a interface gráfica do RabbitMQ teve suas configurações alteradas também,
na qual foi definido um login e senha.
* host = *admin*
* port = *123456*

Explicitando também a porta *5672* para acessar o controlador.

Vale ressaltar que a API está intregada com o Swagger para facilitar as requisições.
sendo possível acessar através da url *http://localhost:8080/swagger-ui/index.html#/*