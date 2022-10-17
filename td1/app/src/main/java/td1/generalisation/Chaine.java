package td1.generalisation;

public class Chaine implements Sommable<Chaine>, Comparable<Chaine>
{
    private String val;

    public Chaine(String _val)
    {
        this.val = _val;
    }

    @Override
    public Chaine sommer(final Chaine val)
    {
        return new Chaine(this.val + val.getValeur());
    }

    public String getValeur()
    {
        return val;
    }

    @Override
    public String toString()
    {
        return "Chaine[valeur='" + val + '\'' + ']';
    }

    @Override
    public int compareTo(Chaine c)
    {
        return this.val.compareTo(c.getValeur());
    }


}
