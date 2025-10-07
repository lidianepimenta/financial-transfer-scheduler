 💸 Financial Transfer Scheduler

[![Vue.js](https://img.shields.io/badge/Vue.js-3-brightgreen?style=flat-square&logo=vue.js&logoColor=white)](https://vuejs.org/) 
[![Bootstrap](https://img.shields.io/badge/Bootstrap-5-purple?style=flat-square&logo=bootstrap&logoColor=white)](https://getbootstrap.com/) 
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.7-brightgreen?style=flat-square&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot) 
[![Java 11](https://img.shields.io/badge/Java-11-orange?style=flat-square&logo=java&logoColor=white)](https://www.java.com/)
[![JUnit 5](https://img.shields.io/badge/JUnit-5-red?style=flat-square&logo=junit5&logoColor=white)](https://junit.org/junit5/) 
[![Mockito](https://img.shields.io/badge/Mockito-4-orange?style=flat-square&logo=mockito&logoColor=white)](https://site.mockito.org/) 
[![Cypress](https://img.shields.io/badge/Cypress-15.3.0-brightgreen?style=flat-square&logo=cypress&logoColor=white)](https://www.cypress.io/)
[![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)](#license)

---

## 🇧🇷 Português

### ℹ️ Sobre o projeto

Aplicação **Vue.js 3** desenvolvida como **teste técnico para a go2Win**, simulando um sistema de agendamento e histórico de transferências financeiras.

Funcionalidades principais:

- Cadastro de transferências  
- Visualização do histórico completo  
- Filtro por conta ou data  
- Visualização de taxas calculadas  

### 🏗️ Decisões arquiteturais

- Arquitetura **cliente/servidor**, frontend separado do backend  
- **Componentização** em Vue.js 3 (`TransferForm.vue`, `TransferList.vue`)  
- Comunicação com backend via **Axios (REST API)**  
- Interface responsiva com **Bootstrap 5** e **Font Awesome**  
- Testes E2E no frontend com **Cypress**  
- Backend em **Spring Boot**, com testes unitários **JUnit/Mockito**  
- Uso de **Lombok** para reduzir boilerplate no backend  

### 🚀 Tecnologias e versões

- **Frontend:** Vue.js 3, Axios, Bootstrap 5, Font Awesome, Cypress  
- **Backend:** Java 11, Spring Boot, JUnit 5, Mockito, Lombok  

### ⚙️ Como executar

**Backend**

```bash
cd server
./mvnw spring-boot:run
Disponível em: http://localhost:8080
```

**Frontend**

```bash
cd client
npm install
npm run dev
Disponível em: http://localhost:5173

🧩 Estrutura do projeto (frontend)

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
const response = await axios.get("http://localhost:8080/transfers");
this.transfers = response.data;

🧰 Comandos úteis

|     Comando      |       Descrição              |
|------------------|------------------------------|
| npm run dev      |   Executa o frontend         |
| npm run build    |   Build para produção        |
| npm run test-e2e |   Executa testes Cypress     |
```

---

## 🇺🇸 English

### ℹ️ Project Overview

**Vue.js 3** application developed as a **technical test for go2Win**, simulating a financial transfer scheduler and history system.

Main features:

- Create transfers
- View full transfer history
- Filter by account or date
- Display calculated fees

### 🏗️ Architectural Decisions

- **Client/server** architecture, frontend separated from backend
- **Componentization** in Vue.js 3 (`TransferForm.vue, TransferList.vue`)
- Communication with backend via **Axios (REST API)**
- Responsive UI with **Bootstrap 5** and **Font Awesome**
- Frontend E2E testing with **Cypress**
- Backend in **Spring Boot**, unit tests with **JUnit/Mockito**
- **Lombok** used to reduce boilerplate in backend

### 🚀 Technologies & Versions

- **Frontend:** Vue.js 3, Axios, Bootstrap 5, Font Awesome, Cypress
- **Backend:** Java 11, Spring Boot, JUnit 5, Mockito, Lombok

### ⚙️ How to Run

**Backend**

```bash
cd server
./mvnw spring-boot:run
Available at: http://localhost:8080
```

**Frontend**

```bash
cd client
npm install
npm run dev
Available at: http://localhost:5173

🧩 Project Structure (Frontend)

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
   
🔗 Backend Communication

const response = await axios.get("http://localhost:8080/transfers");
this.transfers = response.data;

🧰 Useful Commands

|     Command      |       Description            |
|------------------|------------------------------|
| npm run dev      |   Executa o frontend         |
| npm run build    |   Build para produção        |
| npm run test-e2e |   Executa testes Cypress     |
```

### 👩‍💻 Developed by
**Lidiane Pimenta** | **Full Stack Developer**

### 📄 License
**This project is free to use for study, technical demonstration, and as a test for go2Win.**
