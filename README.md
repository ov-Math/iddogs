1) Arquitetura

Para o projeto em questão a arquitetura escolhida para estruturar o projeto foi a Clean Architecture. O projeto foi separado em 3 módulos: presentation, domain e data, representando as três camadas da arquitetura com baixo acoplamento entre elas, sendo independetes de frameworks e com altamente testáveis.

Presentation - A camada presentation é um módulo android que é responsável por lidar com as interações do usuário com o aplicativo. Nela estão presentes os MVPs de cada tela.

Domain - A camada domain é um módulo kotlin responsável por lidar com a lógica de negócio da aplicação e a comunicação entre a camada presentation e a camada data.

Data - A camada de data é a responsável por lidar com dados, armazenamento e comunicação com agentes externos.

Para exemplificar, no caso do fluxo de Login implementado no projeto em questão:
O usuário vê o layout e interage com ele. O layout é controlado por uma Activity que através da interface View se comunica com o Presenter que manipula os dados inseridos e solicita que os Interactors da camada domain realizem a ação de login. Depois de fazer as necessárias verificações, o Interactor pede então para o repository na camada data realize a requisição necessária para o serviço de login.

2) Requisições

Para tratar dos requests para os serviços da API, o projeto usa a lib Retrofit, que é amplamente utilizada. Através dela é possível especificar os serviços a serem chamados através de interfaces e anotações e mapear os retornos em objetos utilizando a lib Gson em conjunto para facilitar as conversões de objeto para json e vice-e-versa.

3) Imagens

Para tratar das imagens, as duas mais usadas libs são o Picasso e o Glide. Ambos tem funcionalidades parecidas, com pequenas diferenças e de acordo com o seguinte artigo que compara ambas libs (https://medium.com/@multidots/glide-vs-picasso-930eed42b81d), o Glide tem algumas poucas funcionalidades a mais e consomo menos memória por armazenar a imagem apenas uma vez na memória e a redimensionar quando necessário enquanto por sua vez o Picasso armazena ela uma vez pra cada tamanho que for utilizado. No entanto, pelo mesmo motivo, o Glide demora um pouco mais para a exibição das imagens. Para este projeto o Glide foi escolhido. O próprio Glide já faz o cache das imagens sozinho.

4) Cache

Na camada data está a implementação das funções de armazenamento e leitura de cache usando leitura e escrita de arquivos simples. Os objetos que herdarem de CacheObject são elegíveis para serem armazenados em cache, com a ajuda da lib Gson, o objeto é transformado em um json e o texto do json então é armazenado em um arquivo e persistido. Dessa maneira seria possível implementar uma verificação antes de ser exibida a tela de login para que, caso haja um token válido em cache, não seja necessário o usuário realizar manualmente o login. Esse projeto não contempla nenhuma forma de criptografar esses arquivos cacheados.

5) Considerações finais

- Injeção de dependências poderia ser usada para instanciar os interactors e repositories;

- Devido a falta de tempo hábil para tal, os testes não foram implementados.
