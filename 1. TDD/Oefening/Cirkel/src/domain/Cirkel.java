package domain;

import java.awt.geom.Point2D;

public class Cirkel {
    private Point2D.Double middelpunt; // niet leeg
    private double straal; // positief en niet groter dan coordinaten van middelpunt

    // constructor
    public Cirkel(Point2D.Double middelpunt, double straal){
        this.setMiddelpunt(middelpunt);
        this.setStraal(straal);
    }

    // getters
    public Point2D.Double getMiddelpunt(){return this.middelpunt;}

    public double getStraal(){return this.straal;}

    // setters
    public void setMiddelpunt(Point2D.Double middelpunt){
        if(middelpunt == null) throw new IllegalArgumentException();
        this.middelpunt = middelpunt;
    }

    public void setStraal(double straal){
        if(straal <= 0) throw new IllegalArgumentException();
        if(straal > this.middelpunt.getX() || straal > this.middelpunt.getY()) throw new IllegalArgumentException();
        this.straal = straal;
    }

    // methodes
    public double berekenOppervlakte(){
        return Math.PI * this.straal * this.straal;
    }

    public boolean puntInCirkel(Point2D.Double punt){
        if(punt == null) throw new IllegalArgumentException();
        double afstand = this.middelpunt.distance(punt);
        return afstand < straal;
    }

    public void vergrootCirkel(double factor){
        if(factor <= 0) throw new IllegalArgumentException();
        double nieuweStraal = this.straal * factor;
        if(nieuweStraal > this.middelpunt.getX() || nieuweStraal > this.middelpunt.getY()) throw new IllegalArgumentException();
        this.straal = nieuweStraal;
    }
}
