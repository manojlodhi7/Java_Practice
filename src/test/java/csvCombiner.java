import java.io.*;

public class csvCombiner {

    public void mergeCsv() throws IOException {
        String inputFilePath = "C:\\Users\\mlodhi\\Desktop\\Tuning\\csvMerge\\";
        String outputFilePath = "C:\\Users\\mlodhi\\Desktop\\Tuning\\csvMerge\\outPut\\outPut.csv";
        File folder = new File(inputFilePath);
        File[] listOfFile = folder.listFiles();
        String header = null;
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, true));
        for(File file : listOfFile) {
            if(file.isFile()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                header = reader.readLine();
                break;
            }
        }

        writer.write(header);
        writer.newLine();
        for(File file : listOfFile) {
            if(file.isFile()) {
                int count = 0;
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String br = null;
                while((br = reader.readLine()) != null) {
                    if(!br.contains(header)) {
                        writer.write(br);
                        writer.newLine();
                    }
                }
                reader.close();
            }
        }
        writer.close();
    }


    public static void main(String[] a) throws IOException {
        csvCombiner obj = new csvCombiner();
        obj.mergeCsv();


//        Scanner in = new Scanner(System.in);
//        Scanner scanner = new Scanner(new File("/Users/pankaj/abc.csv"));
//        scanner.useDelimiter(",");
//        while(scanner.hasNext()){
    }
}
