# API REST Spring Boot avec Frontend React

Application complète avec une API REST Spring Boot et un frontend React, implémentant une architecture multicouche avec gestion du CRUD, mise en cache, et gestion des erreurs.

## 🛠 Technologies Utilisées

### Backend
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Cache
- PostgreSQL
- Lombok
- MapStruct
- Maven

### Frontend
- React 18
- TypeScript
- Vite
- React Query
- React Router
- Tailwind CSS
- Axios
- React Hot Toast

## 📋 Prérequis

### Backend
- JDK 17 ou supérieur
- Maven 3.8+
- PostgreSQL
- Git

### Frontend
- Node.js 18+
- npm ou yarn

## 🚀 Installation et démarrage

### Backend

1. Cloner le repository
```bash
git clone https://github.com/Youssafouhba/test_technique.git
cd TestTechnique
```

2. Configurer les variables d'environnement
```bash
cp .env.example .env
```
Modifiez le fichier `.env` avec vos paramètres de base de données.

3. Compiler le projet
```bash
mvn clean install
```

4. Lancer l'application
```bash
mvn spring-boot:run
```

L'API sera accessible à l'adresse : `http://localhost:8080`

### Frontend

1. Naviguer vers le dossier frontend
```bash
cd frontend
```

2. Installer les dépendances
```bash
npm install
# ou
yarn install
```

3. Lancer l'application
```bash
npm run dev
# ou
yarn dev
```

Le frontend sera accessible à l'adresse : `http://localhost:8081`

## 🌐 Endpoints API

### Products

| Méthode | URL | Description |
|---------|-----|-------------|
| POST | `/api/products` | Créer un nouveau produit |
| GET | `/api/products/{id}` | Récupérer un produit par ID |
| GET | `/api/products` | Récupérer tous les produits |
| PUT | `/api/products/{id}` | Mettre à jour un produit |
| DELETE | `/api/products/{id}` | Supprimer un produit |

### Exemple de Payload (Product)

```json
{
  "name": "Wireless Headphones",
  "price": 99.99,
  "description": "High-quality wireless headphones with noise cancellation and premium sound quality.",
  "image": "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500&q=80"
}
```

## 🏗️ Architecture

### Backend
```
src/
  ├── main/
  │   ├── java/
  │   │   └── com/example/demo/
  │   │       ├── configuration/
  │   │       ├── controller/
  │   │       ├── dto/
  │   │       ├── entity/
  │   │       ├── exception/
  │   │       ├── mapper/
  │   │       ├── repository/
  │   │       └── service/
  │   └── resources/
  │       └── application.yml
```

### Frontend
```
frontend/
  ├── src/
  │   ├── api/ - Gestion des appels API et services
  │   ├── assets/ - Ressources statiques comme les images et les fichiers CSS
  │   ├── components/ - Composants réutilisables
  │   ├── hooks/ - Hooks personnalisés
  │   ├── lib/ - Bibliothèques et utilitaires
  │   ├── models/ - Définition des types et interfaces
  │   ├── pages/ - Pages principales de l'application
  │   ├── App.tsx - Composant principal de l'application
  │   ├── index.css - Fichier CSS global
  │   └── main.tsx - Point d'entrée de l'application
  ├── .gitignore - Fichier listant les fichiers à ignorer par Git
  ├── components.json - Configuration des composants
  ├── eslint.config.js - Configuration de l'outil ESLint
  ├── index.html - Fichier HTML de base
  ├── package.json - Dépendances et scripts du projet
  ├── package-lock.json - Version lock des dépendances
  ├── postcss.config.js - Configuration de PostCSS
  ├── README.md - Documentation principale du projet
  ├── tailwind.config.ts - Configuration de Tailwind CSS
  ├── tsconfig.app.json - Configuration TypeScript pour l'application
  ├── tsconfig.json - Configuration TypeScript générale
  ├── tsconfig.node.json - Configuration TypeScript spécifique à Node.js
  └── vite.config.ts - Configuration de Vite pour le build et le développement
```

## ⚙️ Configuration des environnements

L'application supporte différents environnements via les fichiers :
- `.env` : Configuration par défaut
- `.env.dev` : Environnement de développement
- `.env.prod` : Environnement de production

Pour activer un profil spécifique :
- option 1 : executer la commande suivante dans le terminal .
    ```bash
    export SPRING_PROFILES_ACTIVE=dev
    ```
- option 2 : modifier le fichier `application.yml`.
    ```yaml
    spring:
      profiles:
        active: dev # dev ou prod
    ```

## 🔐 Sécurité

- Les informations sensibles sont stockées dans les fichiers .env
- Les fichiers .env sont exclus du contrôle de version
- Validation des entrées utilisateur
- Gestion globale des exceptions

## 🧪 Tests

### Backend
```bash 
# Tous les tests
mvn test

# Tests spécifiques
mvn test -Dtest=ProductControllerTest
mvn test -Dtest=ProductServiceTest
mvn test -Dtest=ProductIntegrationTest
```

### Frontend
```bash
npm run test
# ou
yarn test
```

## 📝 Validation

Les DTOs incluent des validations avec des messages d'erreur clairs :
- Name : Ne peut pas être vide
- Image : Ne peut pas être vide
- Price : Doit être positif

## 🔄 Cache

La mise en cache est configurée pour les opérations de lecture des produits pour améliorer les performances.

## 📦 Build

### Backend
Pour créer un JAR exécutable :
```bash
mvn package
```

Le fichier JAR sera créé dans le dossier `target/`.

### Frontend
Pour créer une version de production :
```bash
npm run build
# ou
yarn build
```

Les fichiers de production seront créés dans le dossier `dist/`.

## 📦 Run project

### Backend
Pour executer le JAR taper cette cmd dans la racine de votre projet :
```bash
java -jar ./target/TestTechnique-0.0.1-SNAPSHOT.jar
```

### Frontend
Pour lancer la version de production :
```bash
npm run preview
# ou
yarn preview
```