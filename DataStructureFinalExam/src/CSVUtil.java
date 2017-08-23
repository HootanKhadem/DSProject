import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class CSVUtil
{
    public static LinkedList<LinkedList<String>> readCSV(String fileName)
    {
        LinkedList<LinkedList<String>> res = new LinkedList<>();
        String line = null;

        try
        {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null)
            {
                String[] cells = line.split(",");
                res.add(new LinkedList<>(Arrays.asList(cells)));
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return res;
    }
}
