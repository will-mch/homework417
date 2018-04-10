/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robert
 */
public class Transition {
    public Tape tape;
    public int stateNumber;
    public StackAlphabet pop;
    public StackAlphabet push;
    
    public Transition(Tape tape, int stateNumber, StackAlphabet pop, StackAlphabet push){
        this.tape = tape;
        this.stateNumber = stateNumber;
        this.pop = pop;
        this.push = push;
    }
    
    public boolean equals(Object obj){
        if(obj instanceof Transition){
            Transition objj = (Transition)obj;
            if(objj.pop.equals(this.pop) && objj.push.equals(this.push) && objj.tape.equals(this.tape) && objj.stateNumber == this.stateNumber){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return this.tape.name() + ", " + this.pop.name() + " -> " + this.push.name() + "[TO " + stateNumber + "]";
    }
}
