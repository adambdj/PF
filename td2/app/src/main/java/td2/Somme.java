package td2;

// interface fonctionnelle Somme (exercice 1)

@FunctionalInterface
public interface Somme<T>
{
    T sommer(T x, T y);

}