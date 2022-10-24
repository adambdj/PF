package td2;

// interface fonctionnelle toString (exercice 1)

@FunctionalInterface
public interface ToString<T>
{
    String show(T x);

}