package td1.generalisation;
import java.util.Set;

public class Feuille<T extends Sommable<T> & Comparable<T>> implements Arbre<T>
{
    private final T val;

    public Feuille(T val)
    {
        this.val = val;
    }

    @Override
    public int taille()
    {
        return 1;
    }

    @Override
    public boolean contient(final T val)
    {
        return val.equals(this.val);
    }

    @Override
    public Set<T> valeurs()
    {
        return Set.of(this.val);
    }

    @Override
    public T somme()
    {
        return val;
    }

    @Override
    public T min()
    {
        return val;
    }

    @Override
    public T max()
    {
        return val;
    }

    @Override
    public boolean estTrie()
    {
        return false;
    }
}
