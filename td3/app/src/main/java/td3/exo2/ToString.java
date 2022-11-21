package td3.exo2;

@FunctionalInterface
public interface ToString<T> {
    String convert(T source);
}
