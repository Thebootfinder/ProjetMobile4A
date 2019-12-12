Projet Martin GEILLON 4A

# Application Top Anime

## Présentation

Premier projet utilisant Android Studio. Projet démontrant l'utilisation d'une architecture MVC dans une application android codé en Java.

L'application affiche le Top des animes et le top des Mangas en se basant sur la note overall, affiche également une vue détaillé des animes en cliquant dessus. Utilisation d'une API.


## Prérequis


- Installation d'Android Studio

````
https://github.com/Thebootfinder/ProjetMobile4A.git
````

## Consignes respectées : 

- Appels API REST
- Affichage d'une liste dans un RecyclerView (2)
- Affichage des détails d'un item de la liste en cliquant dessus
- Architecture MVC 
- Utilisation des Fragments 
- GIT
- Fonctions supplémentaires :
  - Singleton
  - Fichier Constants
  - SplashScreen

## Fonctionnalités: 

### Premier écran 

- SplashScreen affichant une image d'introducton 

<img src="readme_img/splashscreen.JPG" alt="splash" width="250">

### Ecran Top Anime 

- Affichage de la liste Top Anime avec : 
  - Affiche de l'Anime
  - Nom de l'anime
  - Note avec un affichage étoile 
  - Date de sortie

<img src="readme_img/top_liste.JPG" alt="liste" width="250" class="centered">

### Ecran Top Manga

- Affichage de la liste Top Manga avec : 
  - Affiche de l'Anime
  - Nom de l'anime
  - Note avec un affichage étoile 
  - Genre


<img src="readme_img/detail_manga.JPG" alt="liste" width="250" class="centered">

### Ecran détail de l'anime

- Affiche de différente information sur l'anime :
  - Nom de l'anime
  - Age conseillé
  - Note
  - Rank
  - Synopsis 
- Utilisation d'une ScrollView si trop d'information 


<img src="readme_img/detail_anime.JPG" alt="détail" width="250" class="centered">

## Architecture MVC

<pre><code>
+-- app/
|   +-- manifests/
|   |   +-- AndroidManifest.xml
|   +-- java/
|   |   +-- com.example.projet4a/
|   |   |   +-- controller/
|   |   |   |   +-- animecontroller/
|   |   |   |   |   +-- (*.java)
|   |   |   |   +-- mangacontroller/
|   |   |   |   |   +-- (*.java)
|   |   |   +-- model/
|   |   |   |   +-- animemodel/
|   |   |   |   |   +-- (*.java)
|   |   |   |   +-- mangamodel/
|   |   |   |   |   +-- (*.java)
|   |   |   +-- restapi/
|   |   |   |   +-- (*.java)
|   |   |   +-- view/
|   |   |   |   +-- animeview/
|   |   |   |   |   +-- (*.java)
|   |   |   |   +-- mangaview/
|   |   |   |   |   +-- (*.java)
|   |   |   |   +-- activity3/
|   |   |   |   |   +-- (*.java)
|   +-- res/
|   |   +-- drawable/, font/, layout/, menu/, mipmap/, values/
|   |   |   +-- (*.xml)
|   |   |   +-- (*.png)
+-- Gradle Scripts/
</code></pre>


### Compétence apprise 

- IDE Android Studio
- Recycler_View
- Fragment
- Utilisation d'un API REST 
- Architecture MVC 
- Singleton 
