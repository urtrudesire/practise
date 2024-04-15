package Coding;

import java.util.Comparator;

public class Comp implements Comparator<Solulever> {
    @Override
    public int compare(Solulever o1, Solulever o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
