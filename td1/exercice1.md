# TD1 - Programmation fonctionnelle

- String::lowercase est fonctionnelle
- Math::max, Math::sin est fonctionnelle
- List::add, List::size, List::contains pas fonctionnelle car pas pure 
- Integer::valueOf n'est pas fonctionnelle car pas total (exception)
- File::length pas fonctionnelle car pas total (exception possible)

# Alors: 

m1 pas fonctionnel = effet de bord car modifification de l'état sur la valeur de a
m2 pas fonctionnel = si on l'appelle plusieurs fois, fonctionnel ssi a n'est pas modifié

m3 pas fonctionnelle = effet de bord

m4 fonctionnelle = retournera toujours la meme chose, pas d'effet de bord
m5 effet de bord avec a (a est public)
m6 pas fonctionnelle, variable b est public, peut être modifiée
m7 fonctionnelle = val en paramètre, C ne peut être modifié, donc pas d'effet de bord
m8 fonctionnelle
m9 pas fonctionnel = peut lever une exception
m10 fonctionnelle
m11 fonctionnelle = val variable locale, pas d'effet de bord

