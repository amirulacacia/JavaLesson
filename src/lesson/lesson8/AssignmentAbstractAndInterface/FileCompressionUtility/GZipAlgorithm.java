package lesson.lesson8.assignmentabstractandinterface.FileCompressionUtility;

public class GZipAlgorithm extends CompressionAlgorithm {

    @Override
    void compress(String inputFile, String outputFile) {
        System.out.println("Compressing into GZip File: " + inputFile + "   ->   " + outputFile );
    }

}
