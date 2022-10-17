package td1.generalisation;

import java.util.Set;

public interface Arbre<T>
{
    int taille();

    boolean contient(final T val);

    Set<T> valeurs();

    T somme();

    T min();

    T max();

    boolean estTrie();
}
