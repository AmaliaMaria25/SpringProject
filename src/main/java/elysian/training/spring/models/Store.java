package elysian.training.spring.models;

import java.util.Objects;
import java.util.Set;

public class Store extends AbstractEntity{

    private final int id;
    private final String name;
    private final String location;
    private final Set<Section> storeSections;

    public Store(int id, String name, String location, Set<Section> storeSections) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.storeSections = storeSections;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getLocation() { return location; }

    public Set<Section> getStoreSections() { return storeSections; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return id == store.id &&
                Objects.equals(name, store.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n\nStore is called ");
        sb.append(name).append(" (id = ").append(id).append(") and has the sections:  ");
        for (Section section: storeSections) {
            sb.append("\n\n ").append(section);
        }

        return sb.toString();
    }
}
