# 💸 Financial Transfer Scheduler — Frontend

---

## 🇧🇷 Português

Aplicação **Vue.js 3** desenvolvida como **teste técnico para a empresa go2Win**, simulando um sistema de agendamento e histórico de transferências financeiras.  
Permite cadastrar transferências, visualizar histórico e filtrar por conta ou data, com interface moderna e responsiva.

### ℹ️ Contexto do projeto

Este projeto foi criado como **teste técnico para a go2Win**, demonstrando habilidades em:

- Desenvolvimento Frontend com **Vue.js 3**
- Consumo de **APIs REST** via Axios
- Interface responsiva com **Bootstrap 5** e **Font Awesome**
- Testes automatizados com **Cypress** (frontend) e **JUnit/Mockito** (backend)
- Integração com **Spring Boot** e uso de **Lombok**

### 🚀 Tecnologias utilizadas

**Frontend:** Vue.js 3, Axios, Bootstrap 5, Font Awesome, Cypress  
**Backend:** Spring Boot, JUnit 5, Mockito, Lombok

### ⚙️ Pré-requisitos

- Node.js (LTS)
- npm ou yarn
- Backend rodando em `http://localhost:8080`

### ▶️ Como executar

```bash
git clone https://github.com/lidianepimenta/financial-transfer-scheduler.git
cd financial-transfer-scheduler/client
npm install
npm run dev

O app ficará disponível em: http://localhost:5173

🧩 Estrutura de pastas
cypress/
 ├── e2e/           
 └── support/       

public/
 ├── index.html     
 └── favicon.ico    

src/
 ├── components/    
 ├── App.vue        
 └── main.js        

 🔗 Comunicação com backend
GET  http://localhost:8080/transfers
POST http://localhost:8080/transfers

Exemplo:

const response = await axios.get("http://localhost:8080/transfers");
this.transfers = response.data;

🧠 Funcionalidades
Cadastrar transferências
Visualizar histórico completo
Filtrar por conta ou data
Exibir taxas calculadas
Testes com Cypress e JUnit/Mockito

🧰 Comandos úteis
Comando	            Descrição
npm run dev	        Executa frontend
npm run build	    Build para produção
npm run test-e2e	Executa testes Cypress
```

## 🇺🇸 English

**Vue.js 3** application developed as a **technical test for go2Win**, simulating a financial transfer scheduler and history system.
Allows users to create transfers, view history, and filter by account or date, with a modern and responsive interface.

### ℹ️ Project Context

This project was created as a **technical assessment for go2Win**, showcasing skills in:

- Frontend development with **Vue.js 3**
- Consuming **REST APIs** via Axios
- Responsive interface with **Bootstrap 5** and **Font Awesome**
- Automated testing with **Cypress** (frontend) and **JUnit/Mockito** (backend)
- Integration with **Spring Boot** and usage of **Lombok**

### 🚀 Technologies

**Frontend:** Vue.js 3, Axios, Bootstrap 5, Font Awesome, Cypress
**Backend:** Spring Boot, JUnit 5, Mockito, Lombok

### ⚙️ Prerequisites

- Node.js (LTS)
- npm or yarn
- Backend running at `http://localhost:8080`

### ▶️ How to run

```bash
git clone https://github.com/lidianepimenta/financial-transfer-scheduler.git
cd financial-transfer-scheduler/client
npm install
npm run dev

The app will be available at: http://localhost:5173

🧩 Folder structure
cypress/
 ├── e2e/           
 └── support/       

public/
 ├── index.html     
 └── favicon.ico    

src/
 ├── components/    
 ├── App.vue        
 └── main.js 

🔗 Backend communication
GET  http://localhost:8080/transfers
POST http://localhost:8080/transfers

Example:
const response = await axios.get("http://localhost:8080/transfers");
this.transfers = response.data;

🧠 Features
Create transfers
View full transfer history
Filter by account or date
Display calculated fees
Testing with Cypress and JUnit/Mockito

🧰 Useful commands
Command	            Description
npm run dev	        Runs the frontend
npm run build	    Production build
npm run test-e2e	Runs Cypress tests
```


### 👩‍💻 Developed by

Lidiane Pimenta
Full Stack Developer | Java • C# • Spring Boot • Vue.js • React.js • Docker • Kubernetes • CI/CD • AWS

### 📄 License
This project is free to use for study and technical demonstration.
