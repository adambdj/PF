package td2.exo2;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

public class App<T>
{
    Predicate<Paire<Integer, Double>> tailleTropPetite = p -> p.fst < 100;
    Predicate<Paire<Integer, Double>> tailleTropGrande = p -> p.fst > 200;
    Predicate<Paire<Integer, Double>> tailleIncorrecte = p -> tailleTropPetite.test(p) || tailleTropGrande.test(p);
    Predicate<Paire<Integer, Double>> tailleCorrecte = Predicate.not(tailleIncorrecte);
    Predicate<Paire<Integer, Double>> tropLourd = p -> p.snd > 150.0;
    Predicate<Paire<Integer, Double>> poidsCorrect = Predicate.not(tropLourd);
    Predicate<Paire<Integer, Double>> accesAutorise = p -> tailleCorrecte.test(p) && poidsCorrect.test(p);

    public <T> List<T> filtragePredicatif(List<Predicate<T>> conditions, List<T> elements)
    {
        List<T> rtr = new ArrayList<>();

        //Récupération des prédicats :
        Predicate<T> predicat = x -> true;

        for(Predicate<T> p : conditions)
        {
            predicat = predicat.and(p);
        }
        for(T e : elements)
        {
            if (predicat.test(e))
            {
                rtr.add(e);
            }
        }
        return rtr;

    }

    public static void main(String[] args)
    {
        App app = new App<>();

        Paire client1 = new Paire(150, 100.0); // taille: 150cm & poids: 100.0kg -> caractéristiques valides
        Paire client2 = new Paire(150, 200.0); // taille: 150cm & poids: 200.0kg -> le poids est trop lourd
        Paire client3 = new Paire(210, 100.0); // taille: 210cm & poids: 100.0kg -> la taille est trop grande

        //filtrage prédicatif
        System.out.println(app.accesAutorise.test(client1));    //doit print true
        System.out.println(app.accesAutorise.test(client2));    //doit print false
        System.out.println(app.accesAutorise.test(client3));    //doit print false


    }

}
