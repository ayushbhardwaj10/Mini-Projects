// Java program to illustrate
// executing commands on cmd prompt
package  sample;

class cmd {
    public cmd() {
        try
        {
            // We are running "dir" and "ping" command on cmd

            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"F: && cd F:\\eclipse-workspace\\breastCancerDetection_Trial\\Breast cancer detection  && python Breast_cancer_Miniproj.py && exit \"");



        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
    }
}
