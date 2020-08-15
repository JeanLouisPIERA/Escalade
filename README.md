# Escalade
Projet 6 OPENCLASSROOMS Créer un site associatif poru la promotion de l'escalade et la gestion du prêt des topos entre les adhérents

#TITRE DE L'APPLICATION : ESCALADE
#AUTEUR : Jean-Louis PIERA
CONTACT : jeanlouispiera@yahoo.fr
VERSION : 1.0
Mars-Avril 2020

#Présentation Générale :
Cette application est un projet académique dans le cadre du parcours développeur JAVA d'OPENCLASSROOMS.
En pratique, elle permet à un membre d'une associationd'escalade de créer gratuitement un compte, de créer des des fiches sur les sites 
d'escalade dans une base de données communautaires et d'apporter des commentaires. Elle permet aussi à chaque membre d'enregistrer ses 
topos pour les proposer en prêt aux autres membres à qui il peut demander d'emprunter leurs topos. L'application permet à chaque membre 
de suivre les réponses à ses demandes de réservation et de répondre aux sollicitations des autres membres à qui ses coordonnées sont 
communiquées en cas d'accord. Seuls les administrateurs ont la possibilité de supprimer un site ou un topo ou de modérer les 
commentaires déposés par les membres. Le site est sécurisé.

#Technologies : Ce projet a été écrit en Java avec JEE et la version 2.3.0.M2 de Springboot. Toutes les méthodes sont commentées en 
Javadoc.

#Prérequis : 
L'environnement d'installation minimum est :
- Apache Maven version 3.6.2
- JRE 1.8.0_231
- Database MySQL 8.0

#Installation :
- créer une base de données vide MySQL sous le nom amis_escalade
- récupérer le package à installer sur le dépôt GitHub https://github.com/JeanLouisPIERA/Escalade
- installer le package de l'application où vous le souhaitez sur votre disque dur
- ouvrir la commande en ligne dans la directory où vous avez copié l'application
- taper la commande "mvnw spring-boot:run" pour lancer la compilation de l'application
- une fois l'application lancée, taper http://localhost:8085/login dans votre navigateur.
- pour vous logger en tant qu'administrateur taper l'identifiant "admin10" et le mot de passe "jeanlouis". Pour vous logger en
tant qu'utilisateur, utiliser le lien prévu à cet effet sur la page d'accueil.

#Maj
 
