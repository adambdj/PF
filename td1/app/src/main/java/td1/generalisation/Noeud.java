package td1.generalisation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Noeud<T extends Sommable<T> & Comparable<T>> implements Arbre<T>
{
    private List<Arbre<T>> fils;

    public Noeud(List<Arbre<T>> fils)
    {
        this.fils = new ArrayList<>();
    }

    @Override
    public int taille()
    {
        return this.fils.stream().map(Arbre<T>::taille).reduce(0, (arg0, arg1) -> Integer.sum(arg0, arg1));
    }

    @Override
    public boolean contient(T val)
    {
        for ( Arbre<T> a : fils)
        {
            if (a.contient(val))
                return true;
        }
        return false;
    }

    @Override
    public Set<T> valeurs()
    {
        Set<T> total = new HashSet<>();
        for ( Arbre<T> a : fils)
        {
            total.addAll(a.valeurs());
        }
        return total;
    }

    @Override
    public T somme()
    {

        Iterator<Arbre<T>> element1 = fils.iterator();
        T t1 = element1.next().somme();
        T next;
        while (element1.hasNext())
        {
            next = element1.next().somme();
            t1 = t1.sommer(next);
        }
        return t1;
    }

    @Override
    public T min()
    {
        T x = fils.get(0).min();
        for(Arbre <T> minimum : fils)
        {
            T var = minimum.min();
            if(x.compareTo(minimum.min()) >0)
            {
                x=var;
            }
        }
        return x;
    }

    @Override
    public T max()
    {
        T x = fils.get(0).max();
        for(Arbre <T> maximum : fils)
        {
            T var = maximum.max();
            if(x.compareTo(maximum.max()) < 0)
            {
                x=var;
            }
        }
        return x;
    }

    @Override
    public boolean estTrie()
    {
        return condtionTrie1() && condtionTrie2();
    }

    private boolean condtionTrie2()
    {
        boolean total = true;
        for (int i = 0; i < fils.size() - 1; i++)
        {
            Arbre<T> fi = fils.get(i);
            if (!fi.estTrie())
                return false;
        }
        return total;
    }

    private boolean condtionTrie1()
    {
        boolean total = true;
        for( int i = 0; i < fils.size() - 1; i++)
        {
            Arbre<T> condi1 = fils.get(i);
            if(condi1.max().compareTo(fils.get(i+1).min())>0)
            {
                total = false;
            }
        }
        return total;
    }

}
