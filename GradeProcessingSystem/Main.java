
import java.io.*;

class GradeProcessingSystem{
    String delimeter = ",";
    public static void main(String[] args) throws Exception{
        String inputFile = "C:\\Users\\Andrew\\Documents\\CODING\\Projects\\JavaProjects-Repo\\GradeProcessingSystem\\database.csv";
        GradeProcessingSystem.read(inputFile);
    }
//
    public static void read(String inputFile){
        try{
            File file = new File(inputFile);
            FileReader fReader= new FileReader(file);
            BufferedReader bReader = new BufferedReader(fReader);
            String line = null;
            String tempArray[];
            String gpa = "";

            while((line = bReader.readLine()) != null){
                tempArray = line.split(",");
                gpa = GradeProcessingSystem.processGrade(tempArray);
                System.out.println(tempArray[0]+" "+gpa);
            }
            bReader.close();
        }
        catch(IOException e){
            e.getStackTrace();
        }
    }

    public static String processGrade(String[] grades){
        int sumTotal = 0;
        int numValues = 0;
        double average = 0.0;
        for (String num : grades) {
            if(Integer.parseInt(num)<=100){
                sumTotal+=Integer.parseInt(num);
                numValues++;
            }
        }
        average = sumTotal/numValues;
        if(average<50)  //F
            return "0";
        else if(average<53)  //D-
            return "0.7";
        else if(average<57)  //D
            return "1.0";
        else if(average<60)  //D+
            return "1.3";
        else if(average<63)  //C-
            return "1.7";
        else if (average<67)  //C
            return "2.0";
        else if (average<70)  //C+
            return "2.3";
        else if (average<73)  //B-
            return "2.7";
        else if (average<77)  //B
            return "3.0";
        else if (average<80)  //B+
            return "3.3";
        else if (average<85)  //A-
            return "3.7";
        else if (average<90)  //A
            return "4.0";
        
        return "4.3";  //A+
    }
}
