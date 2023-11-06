# FUEL_CONTROL
Projeto desafio para gerenciamento de abastecimento

## Intruções
Ha dois usuários configurado
### Admin:
- login: admin@fuelcontrol.com
- senha: 87654321

### Operador:
- login: admin@fuelcontrol.com
- senha: 87654321

### Banco de dados
- O bando utilizado foi o banco em memória H2
para dara carga inicial no banco foi utilizado o 
arquivo data.sql que se encontra na pasta resources
FUEL_CONTROL/fuel/src/main/resources/

### Menus
- 1 BOMBAS: Exibe a lista de bombas cadastradas
- 2 TANQUES: Exibe a lista de tanques cadastrados
- 3 RELATORIO: Faz o download do aquivo pdf com os dados dos abastecimento. O relatório foi feito com Jasperreport

### Coluna lateral
- Exibe a totalização em tempo real (a cada mudança do banco) das quantidades e faturamento  por perído diário, mensal e anual
  para cada tipo de combustíve/tanque assim como a totalização geral.

### Obsevações
- O crud completo foi implementado somente para a entidade Fueling(abastecimento)



   

