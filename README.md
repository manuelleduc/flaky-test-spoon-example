# Flaky test
## Context et motivation

Un bon cas de test est un cas de test qui fonctionne tous le temps.
Plus un cas de tes dépend des conditions exétieurs (état d'une base de donnée, date, heure, sens du vent...) plus les probabilités d'échec non reproductible des tests
d'une application augmentente.

Il est toute fois difficile de détecter les élements problématiques dans une base
de code volumineuse, mal maitrisée ou évoluant rapidement.

## Sujet
Nous vous proposons donc de développer un outils d'analyse statique ayant pour but de détecter les éléments provoquants des effets de bord non désirés dans le code source d'une application.

### Exemple d'effets de bord non désiré :
  * Présence de création d'objets de type date à la date courante (e.g new java.util.Date())
  * Présence d'opération d'écriture (INSERT/UPDATE/DELETE...) en base de données.
  * Accès a des services web
  * Accès a des services de mesure physique (termomètre, luxmètre...)
