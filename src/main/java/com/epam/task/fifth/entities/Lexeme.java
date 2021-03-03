package com.epam.task.fifth.entities;

import java.util.Objects;

public class Lexeme implements Component{
    private enum LexemeType{
        WORD,EXPRESSION
    }
    private String lexeme;
    private LexemeType type;

    public Lexeme(String lexeme,LexemeType type){
        this.lexeme=lexeme;
        this.type=type;
    }

    public static Lexeme word(String lexeme){
        return new Lexeme(lexeme,LexemeType.WORD);
    }

    public static Lexeme expression(String lexeme){
        return new Lexeme(lexeme,LexemeType.EXPRESSION);
    }

    public String getLexeme(){
        return lexeme;
    }

    public LexemeType getType(){
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lexeme lexeme1 = (Lexeme) o;
        return Objects.equals(lexeme, lexeme1.lexeme) &&
                type == lexeme1.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lexeme, type);
    }

    @Override
    public String toString() {
        return "Lexeme{" +
                "lexeme='" + lexeme + '\'' +
                ", type=" + type +
                '}';
    }
}
