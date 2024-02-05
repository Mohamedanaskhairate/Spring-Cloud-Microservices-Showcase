# Spring Cloud Microservices Showcase

Ce projet démontre une mise en œuvre des architectures de microservices avec Spring Cloud.

## Architecture

![Eureka Discovery](https://github.com/Mohamedanaskhairate/Spring-Cloud-Microservices-Showcase/blob/master/img/Eureka.png)

**Eureka Discovery :** Cette image illustre le fonctionnement de Eureka, notre service de découverte.

## Fonctionnalités

- **Service Client :** Le service client gère les informations relatives aux clients de l'application. Il utilise une entité `Client` avec les attributs `id`, `nom`, et `email`. Les clients peuvent être récupérés via l'endpoint `/clients`.

- **Inventaire Service :** Le service d'inventaire gère les informations relatives aux produits de l'application. Il utilise une entité `Produit` avec les attributs `id`, `nom`, `prix`, et `quantité`. Les produits peuvent être récupérés via l'endpoint `/produits`.

- **Gateway Service :** Le service de passerelle est la porte d'entrée principale de notre architecture de microservices. Il gère le routage des requêtes vers les services appropriés, par exemple, `/clients/**` vers le service client et `/produits/**` vers le service d'inventaire.

- **Eureka Service :** Le service Eureka est notre service de découverte. Il permet aux microservices de s'enregistrer dynamiquement et de découvrir les autres services disponibles. Il assure une communication fluide et une résilience accrue en cas de défaillance.

- **Facturation Service :** Le service de facturation gère le processus de facturation. Il utilise les entités `Facture` et `ProduitFacture`. Les factures peuvent être récupérées via l'endpoint `/fullFacture/{id}` en utilisant Feign Client.

## Exemple d'utilisation avec Feign Client

![Feign Client Example](https://github.com/Mohamedanaskhairate/Spring-Cloud-Microservices-Showcase/blob/master/img/Foreing-impl.png)

Pour récupérer les données de la facture avec Feign Client, utilisez l'URL suivante :
`http://localhost:8888/FACTURATION-SERVICE/fullFacture/1`

## Installation

1. Clonez le projet localement :
   ```bash
   git clone https://github.com/Mohamedanaskhairate/Spring-Cloud-Microservices-Showcase.git
