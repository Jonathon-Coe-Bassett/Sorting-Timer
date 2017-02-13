import java.io.*;

public class WritingToFile {
    public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "LeaderBoard2.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.append('H');
            bufferedWriter.write(" Micsdfj");
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.append(" the text to the file.");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
    public void write()
    {
    	
    }
}