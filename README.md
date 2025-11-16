# Final-Proj-Design-Patterns-Testing-and-Deployment
# Inventory Management System

## Overview
Progetto realizzato durante il corso *Java: Design Patterns, Testing, and Deployment*.  
Si tratta di un sistema di gestione inventario da linea di comando, che utilizza i pattern Factory e Strategy, test unitari con JUnit, e deployment con Docker.

## Features
- Aggiunta, vendita e gestione prodotti con regole di business
- Calcolo sconti per studenti e acquisti in bulk
- Visualizzazione inventario e statistiche con alert per stock basso
- Test unitari per garantire la correttezza del codice
- Containerizzazione con Docker per facile distribuzione

## Tecnologie utilizzate
- Java 17
- Maven
- JUnit 5
- Docker

## Come eseguire
1. Compilare il progetto con Maven:
   ```bash
   mvn clean package
