/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */


//import jakarta.enterprise.context.Dependent;
import com.JDBC;
import com.SummaryRow;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

/**
 *
 * @author shaba
 */
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author shaba
 * @param <T>
 */
@Named("userData")

@SessionScoped



public class UserData implements Serializable{

  
    private String username;
    private String password;
   

   // private ArrayList<String> array= new ArrayList<>();
    
    private Map<Long, String> answers = new HashMap<>();

    @Inject
    private JDBC dao;
   public String SaveSurvey() {
    int survey_id = dao.createSurvey();

    for (Map.Entry<Long, String> entry : answers.entrySet()) {
        // Force the key to int in case it is a Long at runtime
        
        String answer = entry.getValue();
        
        long questionId = entry.getKey(); 
        
        dao.insertResponse(survey_id, (int)questionId, answer);
    }

    return loadSummary(survey_id);
}

    

    private List<SummaryRow> summaryResults;

    public List<SummaryRow> getSummaryResults() {
        return summaryResults;
    }
    
    public String loadSummary(int survey_id){
    summaryResults = dao.results(survey_id);
    
    return "Summary.xhtml?faces-redirect=true" + survey_id;
    }
    
    
    public Map<Long, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Long, String> answers) {
        this.answers = answers;
    }

    public String submit(String newPage) {
        System.out.println("Collected answers: " + answers);
        return newPage;
    }

 
     public UserData() {
        System.out.println("UserDatas bean initialized");
    }
     
     public String validateAccount(){
        if("Ben".equals(username) && "pass".equals(password)){
        return "homePage.xhtml?faces-redirect=true";
        }
            return null;
    }
     
     public String selector(String selected){
         String option="";
         switch(selected){
             
             case "1":
                 option = "Strongly Agree";
                 
                 break;
                
             case "2":
                 option = "Agree";
                 break;
                 
             case "3":
                 option = "Neutral";
                 break;
                
             case "4":
                 option = "Disagree";
                 break;
                 
             case "5":
                 option = "Yes";
                 break;
             case "6":
                 option = "No";
                 
                 break;
                
             case "7":
                 option = "Excellent";
                 break;
                 
             case "8":
                 option = "Very Good";
                 break;
                
             case "9":
                 option = "Good";
                 break;
                 
             case "10":
                 option = "Fair";
                 break;
             case "11":
                 option = "Poor";
                 
                 break;
                
             case "12":
                 option = "A: 0-4h";
                 break;
                 
             case "13":
                 option = "B: 5-8h";
                 break;
                
             case "14":
                 option = "C: 9-12h";
                 break;
                 
             case "15":
                 option = "D: 12-16h";
                 break;
         }
         return option;
     }
    
    //Getters & Setters

  
     public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

   
    
   
}
