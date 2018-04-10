
import java.util.ArrayList;

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
    
    public static ArrayList<Tape> createTapeArray(String string) throws Exception{
        char[] chars = string.toCharArray();
        ArrayList<Tape> tapeArray = new ArrayList<>();
        
        for(int i = 0; i < chars.length; i++){
            Tape tape = Tape.convertString(String.valueOf(chars[i]));
            if(tape != null){
                tapeArray.add(tape);
            }else{
                throw new Exception("Input String is conversion error");
            }
        }
        
        return tapeArray;
    }
}
