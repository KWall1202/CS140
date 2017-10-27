package assignment04;

public class CircuitTester {
    public static void main(String[] args) {
        ResonantCircuit r1 = new ResonantCircuit(10, 3, 70);
        System.out.println("Expected:\nResonant Circuit Characteristics:\n\tfrequency: 10.0\n\tbandwidth: 3.0\n\tgain: 70.0\nReceived:");
        r1.display();
        System.out.println("");
        SeriesResonantCircuit r2 = new SeriesResonantCircuit(10, 50, 60);
        System.out.println("Expected:\nResonant Circuit Characteristics:\n\tfrequency: 0.018257418583505537\n\tbandwidth: 0.16666666666666666\n\tgain: 0.1\n\tresistance: 10.0\n\tcapacitance:50.0\n\tinductance: 60.0\nReceived:");
        r2.display();
        System.out.println("");
        ParallelResonantCircuit r3 = new ParallelResonantCircuit(10, 50, 60);
        System.out.println("Expected:\nResonant Circuit Characteristics:\n\tfrequency: 0.018257418583505537\n\tbandwidth: 0.002\n\tgain: 10.0\n\tresistance: 10.0\n\tcapacitance:50.0\n\tinductance: 60.0\nReceived:");
        r3.display();
        System.out.println("");
        System.out.println("Expected: IllegalArgumentException");
        try {
            SeriesResonantCircuit r4 = new SeriesResonantCircuit(0, 1, 1);
            r4.display();
        } catch (IllegalArgumentException e) {
            System.out.println("Received: " + e);
        }
        System.out.println("Expected: IllegalArgumentException");
        try {
            SeriesResonantCircuit r5 = new SeriesResonantCircuit(1, 0, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Received: " + e);
        }
        System.out.println("Expected: IllegalArgumentException");
        try {
            SeriesResonantCircuit r6 = new SeriesResonantCircuit(1, 1, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Received: " + e);
        }
        System.out.println("Expected: IllegalArgumentException");
        try {
            ParallelResonantCircuit r7 = new ParallelResonantCircuit(0, 1, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Received: " + e);
        }
        System.out.println("Expected: IllegalArgumentException");
        try {
            ParallelResonantCircuit r8 = new ParallelResonantCircuit(1, 0, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Received: " + e);
        }
        System.out.println("Expected: IllegalArgumentException");
        try {
            ParallelResonantCircuit r9 = new ParallelResonantCircuit(1, 1, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Received: " + e);
        }
    }
}