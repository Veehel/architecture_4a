#Système Initial


##Est-ce que les joueurs intéragiront en temps réel, ou au tour par tour et pourquoi ?
Dans la mesure où le jeu doit pouvoir faire intéragir 50 joueurs, il serait important qu'ils puissent tous jouer *simultanément*.
En effet, à supposer qu'ils jouent tour à tour, le 50ème joueur à beaucoup plus de chance de se faire éliminer avant même de pouvoir réaliser la moindre action.
Afin de réaliser des actions en simultané, l'utilisation des threads semble être la première solution.
On peut ainsi imaginer un système de session auquel chaque joueur se connecte. Pendant le cours du jeu, chacun pourra réaliser ses mouvements et actions sur "son" Thread.


##Comment sera stocké l'état (toutes les données permettant de représenter le jeu) ?
Le format le plus adapté pour stocker les différents états ainsi que toutes les données est le *JSON*.
Il s'agit d'un format standard reposant sur du texte et représentant une structure de donnée basée sur la syntaxe d'un objet JavaScript.
Il est le plus souvent utilisé pour transmettre des données sur les applications web.  Le programme est destiné à être joué en ligne.


##Comment seront stockées les informations confidentielles des joueurs (emails, etc.)
Toutes les données confidentielles sont initialement stockées à l'état brut dans une base de donnée. Laissé comme ça, ces données sont vulnérables.
Afin de les sécuriser il est nécessaire de les crypter.
La CNIL (Comission Nationale de l'Information et des Libertés) recommande pour les fichiers professionels nécessitant une protection d'utiliser des méthodes et des logiciels de cryptage.
Par exemple VeraCrytpt, logiciel opensource qui permet de créer un disque virtuel chiffré dans un fichier ou une partition.


##Comment gérer plusieurs parties en même temps ?
A supposer qu'une partie est "gérée" par un fichier JSON, cela veut dire qu'il comprend toutes les informations des utilisateurs de cette même partie.
Lorsqu'une partie commence, ou bien que le nombre maximum de joueurs est atteint le fichier JSON sera alors "fermé" et réservé aux joueurs inscrits.
Pour lancer une deuxième/nième partie, il faudra alors ouvrir et lancer un deuxième/nième fichier JSON avec les joueurs de la nouvelle partie.
La gestion des parties en simultanées dépend alors de la gestion des différents JSON.


##Comment gérer plusieurs parties par joueurs en même temps ?
Puisque les joueurs pourront se connecter à leur propre session au lancement du jeu. Un même joueur pourra, s'il le désire se connecter avec son compte sur deux parties différentes (et donc apparaître dans les deux fichiers JSON correspondant) simultanément.
Comme on peut le voir, pour un même compte YouTube, il est possible de lancer sur deux fenêtres deux vidéos différentes en même temps.
Dans notre jeu aussi, un utilisateur pourra se connecter via ses identifiants à deux parties sur deux fenêtres différentes.


##Que se passera-t-il si un serveur plante ? (considérer la machine / vm / conteneur éteint(e) et inaccessible)
Tout au long de la partie des sauvergardes sont réalisées. Celles-ci prennent en compte un système de points gagnés par les différents joueurs. On pourrait mettre en place un barème qui pour un certains nombre d'adversaires éliminés ou d'un rang atteint en fin de partie fait gagner des points aux joueurs.
Si un serveur plante, les parties en cours sont automatiquement arrétées et les joueurs déconnectés de leurs session.
Néanmoins, grâce au système de sauvegarde, les points gagnés lors de la partie pourront être récupérés lors de la reconnexion des joueurs.


##Comment les joueurs s'authentifieront et sauvegardent leur progression ?
Lors de la connexion d'un joueur à une partie il lui est demandé soit d'indiquer sa session utilisateur déjà existante, soit d'en créer une nouvelle.
Toutes les sessions son enregistrées dans une base de données (comme vu précédemment). Pour chaque joueur/pseudo, une table est associée. Celle-ci contient les informations nécessaires à la progression de celui-ci.
Typiquement, on pourra y trouver le loggin et le mot de passe des utilisateurs, ainsi que le nombre de parties et de points cumulés afin d'établir un classement.


##Comment gérer une charge imprévue ? (100x plus de joueurs que prévu par ex)
Si une charge imprévue se présente, par exemple un nombre trop important de joueur souhaitant se connecter au même momment, cela risuqe d'impacter le serveur.
Si le serveur plante, nous avons expliqué plus haut le système de sauvegardes.


