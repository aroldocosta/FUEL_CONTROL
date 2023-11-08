# FUEL_CONTROL
Projeto desafio para gerenciamento de abastecimento

## Instruções
Há dois usuários configurado

### Usuários
#### Admin:
- **login**: admin@fuelcontrol.com
- **senha**: 87654321

#### Operador:
- **login**: oper@fuelcontrol.com
- **senha**: 87654321

### Banco de dados
- O banco utilizado foi o banco em memória H2
para dara carga inicial no banco foi utilizado o arquivo data.sql que se encontra na pasta resources
**FUEL_CONTROL/fuel/src/main/resources/**

- Os preços unitários de cada produtos configurados em R$5,00 para gasolina e R$10 para diesel, para outros
valores deve-se mudar o campo unitPrice do comando insert da tabela tanks


### Menus
- **1 BOMBAS**: Exibe a lista de bombas cadastradas
- **2 TANQUES**: Exibe a lista de tanques cadastrados
- **3 RELATORIO**: Faz o download do aquivo pdf com os dados dos abastecimento. O relatório foi feito com Jasperreport

### Coluna lateral
- Exibe a totalização em tempo real (a cada mudança do banco) das quantidades e faturamento  por perído diário, mensal e anual
  para cada tipo de combustíve/tanque assim como a totalização geral.
  
### Backend
- Deesenvolvido em linguagem Java e RESt API
### Url base
O url base da aplicação é configurada no projeto Angular nos arquivos da environment.ts e enviroment.development.ts
pasta **FUEL_CONTROL/front/src/environments** por meio da variável de ambiente **API_BASE_URL**
  
### Frontend
 - Foram utilizados os frameworks Angular e Bootstrap

### Produção 
- Pode ser acessada no endereço http://microlet.com.br:4201 com login do usuario _Admin_ ou _Operador_ (ver item Usuarios)     

### Roles (Nivel de acesso)
- Há dois níveis de acesso ADMIN e OPERATOR. As funcoes de **_Editar_**, **_Remover_** abastecimento e **_Baixar_** relatório estão disponiveis apenas para
usuários com nível de acesso ADMIN. 

### Versões
- **Java**: openjdk 17.0.8.1 2023-08-24
- **Angular CLI**: 16.2.3
- **Node**: 18.18.0
- **Package Manager**: npm 9.8.1
- **Bootstrap**: v5.3.1 
  
### Obsevações
- O crud completo foi implementado somente para a entidade Fueling(abastecimento)



   

