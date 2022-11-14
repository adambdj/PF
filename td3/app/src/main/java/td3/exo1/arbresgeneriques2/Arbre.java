package td3.exo1.arbresgeneriques2;

import java.util.Set;
import td3.exo1.arbresgeneriques2.Sommable;

public interface Arbre<T extends Sommable<T> & Comparable<T>> {
    int taille();
    boolean contient(final T val);
    Set<T> valeurs();
    T somme();
    T min();
    T max();
    boolean estTrie();
}
