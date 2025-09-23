# 📚 NotesApp – Projeto Final de Programação Orientada por Objetos (POO)

## 📖 Introdução
Este projeto foi desenvolvido no âmbito da cadeira de **Programação Orientada por Objetos (POO)** do **1.º ano da Licenciatura em Engenharia Informática – FCT NOVA**.  

O objetivo principal foi **consolidar os fundamentos de programação orientada a objetos** adquiridos no primeiro ano, aplicando conceitos como **abstração, encapsulamento, polimorfismo, modularidade e tratamento de exceções** num sistema completo.  

O projeto foi avaliado com a nota de **18/20**, refletindo o rigor técnico, a robustez da implementação e a clareza do design.

---

## 🎯 Objetivos
A aplicação implementa uma **ferramenta de gestão de notas**, em modo **linha de comandos**, permitindo ao utilizador:

- Criar diferentes tipos de notas:
  - **Permanent Notes** – de caráter persistente e organizacional.  
  - **Literature Notes** – associadas a obras literárias, autores, citações e datas de publicação.  
- Executar operações de **CRUD** (Create, Read, Update, Delete) sobre notas.  
- Associar e remover **tags** em notas.  
- Estabelecer **links entre notas** para relacionar conteúdos.  
- Consultar **notas por intervalos de tempo** (data inicial → data final).  
- Identificar **notas em destaque (Trending)** com base no uso de tags.  
- Garantir a robustez através de um **conjunto de exceções personalizadas** (e.g., notas inexistentes, datas inválidas, duplicação de identificadores, etc.).  

---

## 🏗️ Estrutura do Projeto
O projeto encontra-se modularizado em diferentes pacotes, promovendo organização e separação de responsabilidades:

- **`Main.java`** → Ponto de entrada da aplicação e gestor da interface por comandos.  
- **`App/`** → Contém a lógica da aplicação (`notesAppClass` e interfaces associadas).  
- **`EnumClasses/`** → Define mensagens de saída e constantes da interface de utilizador.  
- **`Exceptions/`** → Implementa exceções específicas para gestão de erros.  

---

## 📌 Conclusão e Aprendizagens
Este projeto representou uma **síntese do primeiro ano de programação** na FCT NOVA, consolidando os seguintes pontos:

- Aplicação prática de **POO em Java** (interfaces, classes abstratas, herança e polimorfismo).  
- Estruturação de um projeto modular, escalável e de fácil manutenção.  
- Criação e gestão de **exceções personalizadas** para reforçar a robustez da aplicação.  
- Implementação de uma **interface de linha de comandos (CLI)** intuitiva, aproximando o sistema a cenários reais de software utilitário.  

O resultado final foi uma aplicação funcional, sólida e extensível, validando os conhecimentos adquiridos e demonstrando capacidade para projetos mais complexos no futuro.

---

✍️ Desenvolvido por **Guilherme Martins (71003)** e equipa.  
📊 Nota final: **18/20**.  
