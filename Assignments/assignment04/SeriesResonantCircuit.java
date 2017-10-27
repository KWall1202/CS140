package assignment04;

public class SeriesResonantCircuit extends ResonantCircuit {
    private double resistance;
    private double capacitance;
    private double inductance;
    
    static private double computeBandwidth(double r, double l) {
        if (r == 0 || l == 0) {
            throw new IllegalArgumentException("inputs cannot be zero");
        }
        return r / l;
    }
    
    static private double computeFrequency(double c, double l) {
        if (c == 0 || l == 0) {
            throw new IllegalArgumentException("inputs cannot be zero");
        }
        return Math.sqrt(1 / (c * l));
    }
    
    public SeriesResonantCircuit(double aResistance, double aCapacitance, double anInductance) {
        super(computeFrequency(aCapacitance, anInductance), computeBandwidth(aResistance, anInductance), 1 / aResistance);
        resistance = aResistance;
        capacitance = aCapacitance;
        inductance = anInductance;
    }
    
    public void display() {
        super.display();
        StringBuilder build = new StringBuilder();
        build.append("\tresistance: ");
        build.append(resistance);
        build.append("\n\tcapacitance: ");
        build.append(capacitance);
        build.append("\n\tinductance: ");
        build.append(inductance);
        System.out.println(build.toString());
    }
}