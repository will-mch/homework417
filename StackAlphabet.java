/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robert
 */
public enum StackAlphabet {
    ZERO, ONE, DOLLARSIGN, EPSILON;
    
    public static StackAlphabet convertString(String string){
        if(string.equals("-1")){
            return StackAlphabet.EPSILON;
        }else if(string.equals("0")){
            return StackAlphabet.ZERO;
        }else if(string.equals("1")){
            return StackAlphabet.ONE;
        }else if(string.equals("$")){
            return StackAlphabet.DOLLARSIGN;
        }else{
            return null;
        }
    }
}
