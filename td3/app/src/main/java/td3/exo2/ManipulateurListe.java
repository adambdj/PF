package td3.exo2;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface ManipulateurListe<T> {
    void manipuler(final List<T> liste, final T element);
    default List<T> creer() {
        return new ArrayList<T>();
    }
}
