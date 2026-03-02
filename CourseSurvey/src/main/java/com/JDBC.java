/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import javax.sql.DataSource;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
/**
 *
 * @author shaba
 */import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped

public class JDBC {
    @Resource(lookup = "jdbc/course_survey")
    private DataSource dataSource;
    
public void insertResponse(int survey_id, int question_id, String answer_text){
    String sql = "INSERT INTO Answer (survey_id, question_id, answer_text) VALUES (?, ?, ?)";
           
    try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
        ps.setInt(1, survey_id);
        ps.setInt(2, question_id);
        ps.setString(3, answer_text);

        ps.executeUpdate();

    }
    catch(SQLException e){
    e.printStackTrace();
    }

}

public List<SummaryRow> results(int survey_id){
    List<SummaryRow> list = new ArrayList<>();
    String sql = 
    "SELECT q.question_id, q.question_text, a.answer_text FROM Answer a "
     + "JOIN Question q ON q.question_id = a.question_id "
     + "WHERE a.survey_id = ? "
     + "ORDER BY q.question_id";
          
    
        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            
        ps.setInt(1, survey_id);
       ResultSet rs = ps.executeQuery();
       
       while(rs.next()){
       list.add(new SummaryRow(rs.getInt("question_id"), rs.getString("question_text"), rs.getString("answer_text")
       
       ));
       }
    }
    catch(SQLException e){
        e.printStackTrace();
    }
    return list;
    }
    
    public int createSurvey() {
    String sql = "INSERT INTO Survey () VALUES ()";

    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) return rs.getInt(1);

    } catch (SQLException e) { e.printStackTrace(); }

    return -1;
}

    
    
}
