package td1;

import java.util.HashSet;
import java.util.List;
import java.util.Collections;
import java.util.Set;


public class Noeud implements Arbre
{

    private final List<Arbre> fils;

    Noeud(List<Arbre> fils)
    {
        this.fils = fils;
    }

    @Override
    public int taille()
    {
        int total = 0;
        for (Arbre f : fils)
        {
            total += f.taille();
        }
        return total;
    }

    @Override
    public boolean contient(Integer val)
    {
        for (Arbre a : fils)
        {
            if (a.contient(val)) return true;
        }
        return false;
    }

    @Override
    public Set<Integer> valeurs()
    {
        Set<Integer> valeurs = new HashSet<>();

        for (Arbre a : fils)
        {
            valeurs.addAll(a.valeurs());
        }
        return valeurs;
    }

    @Override
    public Integer somme()
    {
        int total = 0;
        for (Arbre f : fils)
        {
            total += f.somme();
        }
        return total;
    }

    @Override
    public Integer min()
    {
        return Collections.min(this.valeurs());
    }

    @Override
    public Integer max()
    {
        return Collections.max(this.valeurs());
    }

    @Override
    public boolean estTrie()
    {
        return conditionTrie1() && conditionTrie2();
    }

    private boolean conditionTrie1()
    {
        boolean rtr = true;
        for (int i = 0; i < fils.size() - 1; i++)
        {
            final Arbre fi = fils.get(i);
            if (!fi.estTrie())
                return false;
        }
        return rtr;
    }

    private boolean conditionTrie2()
    {
        boolean rtr = true;
        for (int i = 0; i < fils.size() - 1; i++)
        {
            final Arbre fi = fils.get(i);
            final Arbre fj = fils.get(i+1);
                if (fi.max() > fj.min())
                    return false;
        }
        return rtr;
    }
    
    
}


    
