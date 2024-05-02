#Ctrl+Art+Suppr

made by *Sénéchal Louis* & *Esslinger Harry* 

est une application Java d'édition et de calcul de formes géométriques. 
L'interface utilisateur est composée de :

- canva (zone de dessin)

- menu déroulant "File" pour la sauvegarde/restauration de fichier XML à partir d'un fichier ou
  d'un serveur rmi 

- menu déroulant "Help" qui ouvre la page web du projet Github

- bouton "**Select**" qui donne les coordonnées d'une forme et les compositions d'une forme complexe

- bouton "**Move**" qui permet de déplacer une forme ou un groupe de formes

- bouton "**Delete**" qui permet de supprimer une forme ou un groupe de formes

- bouton "**Rectangle**" qui permet de créer un rectangle à partir des coordonnées de 2 points
  (n'importe quel coin du rectangle en diagonale)

- bouton "**Cercle**" qui permet de créer un cercle à partir des coordonnées du centre (premier point) 
  et du rayon (distance entre le centre et le deuxième point)

- bouton "**Union**"

- bouton "**Intersection**"

- bouton "**Différence**"

Des raccourcis clavier sont présents dans l'interface. (Ctrl+S pour enregistrer une scène par exemple)

La fonctionnalité originale proposée est une pile de sauvegarde (représentée par des flêches 
retour/suivant) qui permet de revenir avant la modification de la scène et d'aller après modification.
La pile est modifiée lors de la création, déplacement ou modification d'une forme.

Un "bug" prit en compte dans le code est la possibilité de créer une forme complexe avec une seule
forme ce qui effaçait la forme sélectionné. Ce bug a été patch par l'ajout d'une condition d'unicité 
sur les 2 formes sélectionnées pour la création d'une forme complexe.

Lien vers les cours :

- [cours Java](https://java.laurent-thiry.fr/page/summary)

- [cours UML](https://uml2.laurent-thiry.fr/page/index)


