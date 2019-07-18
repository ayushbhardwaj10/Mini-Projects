

package sample;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class writeCsv {
    public writeCsv(String filePath,String s1,String s2, String s3,String s4, String s5, String s6, String s7, String s8,String s9) {
        File file = new File(filePath);

        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = new String[]{"Radius", "Texture", "Perimeter","area","smoothness","compactness","concavity","Concave points","Symmetry","Cancer Level"};
            writer.writeNext(header);
            String[] data1 = new String[]{s1,s2,s3,s4,s5,s6,s7,s8,s9,"0"};
            writer.writeNext(data1);
            //String[] data2 = new String[]{"Suhas", "112", "630"};
            //writer.writeNext(data2);
            writer.close();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }
}
