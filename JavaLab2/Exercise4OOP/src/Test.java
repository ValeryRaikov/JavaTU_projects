public class Test {
        public static void main(String[] args) {
            MultiProcessor processor = new MultiProcessor(2, 4, 2.4);

            System.out.println("Equivalent Single Processor Performance: " + processor.calculateEquivalentSingleProcessor() + " GHz");

            double sequentialTime = 10;
            double executionTime = processor.calculateExecutionTime(sequentialTime);
            System.out.println("Execution Time on MultiProcessor for " + sequentialTime + " seconds: " + executionTime + " seconds");

            System.out.println(processor.toString());
        }
    }