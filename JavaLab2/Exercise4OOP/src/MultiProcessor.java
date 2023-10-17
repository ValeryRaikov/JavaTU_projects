public class MultiProcessor {
    private int numberOfProcessors;
    private int numberOfCores;
    private double clockFrequency;

    public MultiProcessor(int numberOfProcessors, int numberOfCores, double clockFrequency) {
        this.numberOfProcessors = numberOfProcessors;
        this.numberOfCores = numberOfCores;
        this.clockFrequency = clockFrequency;
    }

    public int getNumberOfProcessors() {
        return numberOfProcessors;
    }

    public void setNumberOfProcessors(int numberOfProcessors) {
        this.numberOfProcessors = numberOfProcessors;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public double getClockFrequency() {
        return clockFrequency;
    }

    public void setClockFrequency(double clockFrequency) {
        this.clockFrequency = clockFrequency;
    }

    public double calculateEquivalentSingleProcessor() {
        if (numberOfProcessors > 1 && numberOfCores > 1) {
            return (0.7 * numberOfCores) * (0.8 * numberOfProcessors) * clockFrequency;
        } else {
            return numberOfCores * numberOfProcessors * clockFrequency;
        }
    }

    public double calculateExecutionTime(double sequentialTime) {
        return (sequentialTime * clockFrequency) / calculateEquivalentSingleProcessor();
    }

    @Override
    public String toString() {
        return "MultiProcessor [numberOfProcessors=" + numberOfProcessors + ", numberOfCores=" + numberOfCores +
                ", clockFrequency=" + clockFrequency + "]";
    }
}