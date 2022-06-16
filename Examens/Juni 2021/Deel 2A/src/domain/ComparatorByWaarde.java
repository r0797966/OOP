package domain;

import java.util.Comparator;

public class ComparatorByWaarde implements Comparator<HeeftWaarde> {

    @Override
    public int compare(HeeftWaarde o1, HeeftWaarde o2){
        return Integer.compare(o1.getWaarde(), o2.getWaarde());
    }
}
