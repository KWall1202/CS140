package assignment04;

public class ParallelResonantCircuit extends ResonantCircuit {
    private double resistance;
    private double capacitance;
    private double inductance;
    
    static private double computeBandwidth(double r, double c) {
        if (r == 0 || c == 0) {
            throw new IllegalArgumentException("inputs cannot be zero");
        }
        return 1 / (r * c);
    }
    
    static private double computeFrequency(double c, double l) {
        if (c == 0 || l == 0) {
            throw new IllegalArgumentException("inputs cannot be zero");
        }
        return Math.sqrt(1 / (c * l));
    }
    
    public ParallelResonantCircuit(double aResistance, double aCapacitance, double anInductance) {
        super(computeFrequency(aCapacitance, anInductance), computeBandwidth(aResistance, aCapacitance), aResistance);
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