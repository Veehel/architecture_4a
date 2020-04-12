# Mise à jour système

## Comment faire pour éviter la coupure de service ?

Pour éviter la coupure de service, il ne faudrait pas faire de mise à jour automatique sur tous les serveurs et toutes les parties immédiatemment.
Il faudrait conserver l'ancienne version de l'application pour tous les jeux en cours, et la mettre à jour uniquement pour les nouveaux joueurs et à la fin des parties terminées.

## Que faire des parties en cours ?

Si on suit le modèle proposé à la question précédente, les parties en cours seront maintenues car la mise à jour ne pourra pas se faire en cours de jeu.
Ce n'est que lorsque le joueur relancera le jeu que la mise à jour lui sera proposée.

## Comment changer l'API pour que les joueurs utilisant une vieille version du client web puissent toujours jouer ? (rétro-compatibilité)

Il faudrait s'assurer de la retro-compatibilité au moment du développement des nouvelles fonctionnalités et suivre un système de version compatible avec le plus large panel d'appareils possible.
Si une version possède des fonctionnalités incompatibles avec la version du client web du joueur il faudrait empêcher la mise à jour de se réaliser sur son appareil et lui permettre de garder la version qui lui est compatible même en cas de mise à jour à répétition.
Cette solution peut cependant devenir problématique si le joueur avec une ancienne version se retrouve face à un joueur pouvant user de nouvelles fonctionnalités. Il faudrait donc rendre les parties entre joueurs possibles uniquement entre les joueurs ayant accès aux mêmes fonctionnalités.

## Comment avertir les joueurs de la nouveauté une unique fois ?

Lorsqu'une nouvelle mise à jour est disponible, on pourrait écrire un message d'information qui s'afficherait sur l'écran du joueur à la prochaine ouverture de l'application et nécessiterait une validation de lecture par le joueur pour pouvoir disparaitre et laisser place au jeu. 

