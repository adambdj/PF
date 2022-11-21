package td3.exo2.universite;

import td3.exo1.paires.Paire;

import td3.exo2.App;
import java.util.List;
import java.util.Map.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;
import static td3.exo2.App.aDEF;

public class Refactoring
{
    // matières d'une année
    public static final Function < Annee, Stream < Matiere >> matieresA = a ->
            a.ues().stream().flatMap(e -> e.ects().keySet().stream());

    // matières d'un étudiant
    public static final Function < Etudiant, Stream < Matiere >> matieresE = e ->
            e.notes().keySet().stream();

    // matières coefficientées d'un étudiant (version Entry)
    public static final Function < Etudiant, Stream < Entry < Matiere, Integer >>> matieresCoefE_ = e ->
            e.annee().ues().stream().flatMap(f -> f.ects().entrySet().stream());

    // transformation d'une Entry en une Paire
    public static final Function < Entry < Matiere, Integer > , Paire< Matiere, Integer >> entry2paire = e ->
            new Paire<>(e.getKey(), e.getValue());

    // matières coefficientées d'un étudiant (version Paire)
    public static final Function < Etudiant, Stream < Paire < Matiere, Integer >>> matieresCoefE = e ->
            matieresCoefE_.apply(e).map(entry2paire);

    // accumulateur pour calcul de la moyenne
    // ((asomme, acoefs), (note, coef)) -> (asomme+note*coef, acoef+coef)
    public static final BinaryOperator < Paire < Double, Integer >> accumulateurMoyenne = (a, b) ->
            new Paire<>(a._fst + b._fst * b._snd, a._snd+ b._snd);

    // zero (valeur initiale pour l'accumulateur)
    public static final Paire < Double, Integer > zero = new Paire<>(0.0,0);

    // obtention de la liste de (note, coef) pour les matières d'un étudiant
    // 1. obtenir les (matière, coef)s
    // 2. mapper pour obtenir les (note, coef)s, null pour la note si l'étudiant est DEF dans cette matière
    public static final Function < Etudiant, List < Paire < Double, Integer >>>notesPonderees = ?? ?

    // obtention de la liste de (note, coef) pour les matières d'un étudiant
    // 1. obtenir les (matière, coef)s
    // 2. mapper pour obtenir les (note, coef)s, 0.0 pour la note si l'étudiant est DEF dans cette matière
    public static final Function < Etudiant, List < Paire < Double, Integer >>>notesPondereesIndicatives = ???

    // replie avec l'accumulateur spécifique
    public static final Function < List < Paire < Double, Integer >> , Paire < Double, Integer >>reduit = ???

    // calcule la moyenne à partir d'un couple (somme pondérée, somme coefs)
    public static final Function < Paire < Double, Integer > , Double > divise = ???

    // calcul de moyenne fonctionnel
    // composer notesPonderees, reduit et divise
    // exception en cas de matière DEF
    public static final Function < Etudiant, Double > computeMoyenne = ???

    // calcul de moyenne fonctionnel
    // composer notesPondereesIndicatives, reduit et divise
    // pas d'exception en cas de matière DEF
    public static final Function < Etudiant, Double > computeMoyenneIndicative = ???

    // calcul de moyenne
    public static final Function < Etudiant, Double > moyenne = e -> (e == null || aDEF.test(e)) ? null : computeMoyenne.apply(e);

    // calcul de moyenne indicative
    public static final Function < Etudiant, Double > moyenneIndicative = computeMoyenneIndicative

}