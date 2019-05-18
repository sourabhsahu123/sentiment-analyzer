
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentianalysis;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
public class SentiAnalysis {

    public String getMyTwitterScore(String name) {
        RConnection connection = null;

        try {
            /* Create a connection to Rserve instance running on default port
             * 6311
             */
            connection = new RConnection();

            /* Note four slashes (\\\\) in the path */
            connection.eval("source('D:\\\\sentimentanalyzer.R')");
           
            String score=connection.eval("getMyTwitterScore(\""+name+"\")").asString();
            System.out.println("The sum is=" + score);
            connection.close();
              return score;
        
          } catch (RserveException e) {
            e.printStackTrace();
        } catch (REXPMismatchException e) {
            e.printStackTrace();
        }
          return "";
          
          
        
    }
}