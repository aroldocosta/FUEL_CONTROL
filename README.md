# FUEL_CONTROL
Projeto desafio para gerenciamento de abastecimento

## Intruções
Há dois usuários configurado

### Admin:
- **login**: admin@fuelcontrol.com
- **senha**: 87654321

### Operador:
- **login**: oper@fuelcontrol.com
- **senha**: 87654321

### Banco de dados
- O banco utilizado foi o banco em memória H2
para dara carga inicial no banco foi utilizado o arquivo data.sql que se encontra na pasta resources
**FUEL_CONTROL/fuel/src/main/resources/**

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
     
### Versões
- **Java**: openjdk 17.0.8.1 2023-08-24
- **Angular CLI**: 16.2.3
- **Node**: 18.18.0
- **Package Manager**: npm 9.8.1
- **Bootstrap**: v5.3.1 
  
### Obsevações
- O crud completo foi implementado somente para a entidade Fueling(abastecimento)



   

