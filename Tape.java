/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robert
 */
public enum Tape {
    ONE, ZERO, EPSILON;
    
    public static Tape convertString(String string){
        if(string.equals("0")){
            return Tape.ZERO;
        }else if(string.equals("1")){
            return Tape.ONE;
        }else if(string.equals("-1")){
            return Tape.EPSILON;
        }else{
            return null;
        }
    }
}
