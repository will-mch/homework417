
import java.util.ArrayList;
import java.util.EmptyStackException;
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
        
        inputTape.add(Tape.EPSILON);
        inputTape.add(0,Tape.EPSILON);
        
       State currentState = State.getState(1);
        
        try{
            for(Tape tape : inputTape){
                Transition transition = currentState.getTransitionFor(tape);
                System.out.println("Current State : " + currentState);
                System.out.println("Transition : " + transition);
                System.out.println("Stack Size : " + this.stack.size());
                System.out.println("Input Tape: " + tape + " " + inputTape);

                System.out.println();
                
                if(!transition.pop.equals(StackAlphabet.EPSILON)){
                    if(transition.pop.equals(StackAlphabet.DOLLARSIGN)){
                        if(State.getState(transition.stateNumber).isAccepting() && this.stack.peek().equals(StackAlphabet.DOLLARSIGN)){
                            System.out.println("Accepting!");
                        }else{
                            System.out.println("Not Accpeting!");
                        }
                        break;
                    }
                    
                    this.stack.pop();
                }
                
                if(!transition.push.equals(StackAlphabet.EPSILON)){
                    this.stack.push(transition.push);
                }
                
                currentState = State.getState(transition.stateNumber);
                
                
                
            }
            
        }catch(EmptyStackException e){
            System.out.println("Not Excepting");
            //System.out.println(e.getMessage());
           // System.out.println("Not Accepting!");
        }catch(TransitionException e){
            System.out.println("Not Excepting");
        }catch(Exception e){
            throw e;
        }
        
    }
}
