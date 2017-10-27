package assignment04;

public class ResonantCircuit {
    private double frequency;
    private double bandwidth;
    private double gain;
    
    public ResonantCircuit(double aFreq, double aBand, double aGain) {
        frequency = aFreq;
        bandwidth = aBand;
        gain = aGain;
    }
    
    public void display() {
        StringBuilder build = new StringBuilder();
        build.append("Resonant Circuit Characteristics:");
        build.append("\n\tfrequency: ");
        build.append(frequency);
        build.append("\n\tbandwidth: ");
        build.append(bandwidth);
        build.append("\n\tgain: ");
        build.append(gain);
        System.out.println(build);
    }
}