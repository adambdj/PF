package td1;

/** EXERCICE 2**/

public class Paire<A,B>
{
    private A _fst;
    private B _snd;

    public Paire(final A fst, final B snd)
    {
        _fst = fst;
        _snd = snd;
    }

    public A fst()
    {
        return _fst;
    }

    public B snd()
    {
        return _snd; 
    }

    @Override
    public String toString()
    {
        return "(" + _fst + ", " + _snd + ") :: Paire[" + _fst.getClass().getSimpleName() + "," + _snd.getClass().getSimpleName() + "]";
    }

    public <D> Paire<D,B> changeFst(D val)
    {
    	return new Paire<>(val, this._snd);
    }

    public <D> Paire<A,D> changeSnd(D val)
    {
    	return new Paire<>(this._fst, val);
    }
    
    public static void main(String[] args)
    {
    	Paire <Integer, String> v1 = new Paire <> (5,"test");  
    	Paire <Double, String> v2 = new Paire <> (1.0, "UN"); 
    	Paire <Double, Paire <Integer, String>> v3 = new Paire<>(1.0, v1);
        Paire <Integer, String> v4 = new Paire <> (-2,"moins deux");  
  
    	System.out.println(v1.toString());     
    	System.out.println(v2.toString());    
    	System.out.println(v3.toString());
        System.out.println(v4.toString());

    }

}

