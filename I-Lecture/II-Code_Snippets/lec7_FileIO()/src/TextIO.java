import java.io.*;

public class TextIO {
    public static void main(String[] args) throws IOException{
        File f = new File("output.txt");

        //Writing
        FileOutputStream fos = new FileOutputStream(f, true);
        PrintWriter pw = new PrintWriter(fos);
        pw.println("Test Output!");
        pw.close();

        //Reading
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            System.out.println(s);
        }
        br.close();
        //Remember to close all File Reference Types.
    }
}
