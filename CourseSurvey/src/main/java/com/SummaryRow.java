/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

/**
 *
 * @author shaba
 */
public class SummaryRow {
    private int question_id;
    private String questionText;
    private String answer;

    public SummaryRow(int question_id, String questionText, String answer) {
        this.question_id = question_id;
        this.questionText = questionText;
        this.answer = answer;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }

   }

