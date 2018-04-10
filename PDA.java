
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
        Transition trans = currentState.getTransitionFor(Tape.EPSILON);
        this.stack.push(trans.push);
        
        currentState = State.getState(trans.stateNumber);
        
        for(Tape tape : inputTape){
            System.out.println("CURRENT STATE: " + currentState);
            System.out.println("INPUT TAPE : " + tape);
            Transition transition = currentState.getTransitionFor(tape);
            System.out.println("TRANSITION : " + transition.toString());
            
            if(transition.pop.equals(StackAlphabet.DOLLARSIGN)){
                currentState = State.getState(transition.stateNumber);
                break;
            }else if(!transition.pop.equals(StackAlphabet.EPSILON)){
                stack.pop();
            }

            if(!transition.push.equals(StackAlphabet.DOLLARSIGN)){
                stack.push(transition.push);
            }

            currentState = State.getState(transition.stateNumber);
            
           
        }
        
        System.out.println(currentState);
        
        if(currentState.isAccepting()){
            System.out.println("Accepting!");
        }else{
            System.out.println("Not Accepting!");
        }
    }
}
