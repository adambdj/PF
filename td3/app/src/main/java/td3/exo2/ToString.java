package td2;

@FunctionalInterface
public interface ToString<T> {
    String convert(T source);
}
