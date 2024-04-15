package Coding;

import java.util.HashMap;
import java.util.Map;

public final class Solulever {

    private String name;
    private final Map<String, String> map = new HashMap<>();

    public String getName() {
        return name;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public Solulever(String name, Map<String, String> map) {
        this.name = name;
        this.map.putAll(map);
    }

    @Override
    public String toString() {
        return "Solulever{" +
                "name='" + name + '\'' +
                ", map=" + map +
                '}';
    }
}
