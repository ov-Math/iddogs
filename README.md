1) Arquitetura

Para o projeto em questão a arquitetura escolhida para estruturar o projeto foi a Clean Architecture. O projeto foi separado em 3 módulos: presentation, domain e data, representando as três camadas da arquitetura com baixo acoplamento entre elas, sendo independetes de frameworks e com altamente testáveis.

Presentation - A camada presentation é um módulo android que é responsável por lidar com as interações do usuário com o aplicativo. Nela estão presentes os MVPs de cada tela.

Domain - A camada domain é um módulo kotlin responsável por lidar com a lógica de negócio da aplicação e a comunicação entre a camada presentation e a camada data.

Data - A camada de data é a responsável por lidar com dados, armazenamento e comunicação com agentes externos.

Para exemplificar, no caso do fluxo de Login implementado no projeto em questão:
O usuário vê o layout e interage com ele. O layout é controlado por uma Activity que através da interface View se comunica com o Presenter que manipula os dados inseridos e solicita que os Interactors da camada domain realizem a ação de login. Depois de fazer as necessárias verificações, o Interactor pede então para o repository na camada data realize a requisição necessária para o serviço de login.

2) Requisições

Para tratar dos requests para os serviços da API, o projeto usa a lib Retrofit, que é amplamente utilizada. Através dela é possível especificar os serviços a serem chamados através de interfaces e anotações e mapear os retornos em objetos utilizando a lib Gson em conjunto para facilitar as conversões de objeto para json e vice-e-versa.

