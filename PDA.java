
import java.util.ArrayList;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robert
 */
public class PDA {
    private ArrayList<Tape> inputTape;
    private Stack<StackAlphabet> stack;
    
    public PDA(ArrayList<Tape> inputTape){
        this.inputTape = inputTape;
        stack = new Stack<StackAlphabet>();
    }
    
    public void run() throws Exception{
        
        State currentState = State.getState(1);
        
        for(Tape tape : inputTape){
            Transition transition = currentState.getTransitionFor(tape);
            
            if(transition.pop.equals(StackAlphabet.DOLLARSIGN)){
                break;
            }else if(!transition.pop.equals(StackAlphabet.EPSILON)){
                stack.pop();
            }
            
            if(!transition.push.equals(StackAlphabet.EPSILON) && transition.push.equals(StackAlphabet.DOLLARSIGN)){
                stack.push(transition.push);
            }
            
            currentState = State.getState(transition.stateNumber);
        }
        
        if(currentState.isAccepting()){
            System.out.println("Accepting!");
        }else{
            System.out.println("Not Accepting!");
        }
    }
}
