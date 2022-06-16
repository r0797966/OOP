package domain;

public interface HeeftWaarde {

    int getWaarde();

    default boolean heeftMindereWaarde(HeeftWaarde o){
        return this.getWaarde() < o.getWaarde();
    }
}
