
import java.util.ArrayList;


public class State {
    
    private static ArrayList<State> STATES = new ArrayList<State>();
    
    public static State addState(int stateNumber) throws Exception{
        for(State state: STATES){
            if(state.num == stateNumber){
                throw new Exception("Error State Already Exists");
            }
        }
        
        State state = new State(stateNumber);
        STATES.add(state);
        return state;
        
    }
    
    public void printStates(){
        for(State state: STATES){
            System.out.println(state.toString());
        }
    }
    
    public static boolean doesStateExist(int stateNumber){
        for(State state: STATES){
            if(state.num == stateNumber){
                return true;
            }
        }
        
        return false;
    }
    
    public static State getState(int stateNumber) throws Exception{
          for(State state: STATES){
            if(state.num == stateNumber){
                return state;
            }
        }
          
          throw new Exception("Error State Doesn't Exist");
    }
    
    //END STATIC METHODS
            
    private int num;
    private boolean accepting;
    
    ArrayList<Transition> transitions;
    
    private State(int stateNumber){
        this.num = stateNumber;
        this.accepting = false;
        transitions = new ArrayList<Transition>();
    }
    
    public void setAccepting(boolean isAccepting){
        this.accepting = isAccepting;
    }
    
    public boolean isAccepting(){
        return this.accepting;
    }
    
    public Transition getTransitionFor(Tape tape) throws Exception{

        for(Transition transition: this.transitions){
            if(transition.tape.equals(tape)){
                return transition;
                
            }
        }
        
        throw new Exception("Transition Doesn't exist for Tape input");
    }
    
    public void addTransition(Transition transition) throws Exception{
        for(Transition trans: this.transitions){
            if(trans.tape.equals(transition.tape)){
                throw new Exception("Adding duplicate Transition for Tape input");
            }
        }
        
        this.transitions.add(transition);
    }
    
    public ArrayList<Transition> getTransitions(){
        return this.transitions;
    }
    
    public String toString(){
        
        String retString = this.num + " ";
        for(Transition trans : this.transitions){
            retString.concat("[" + trans.toString() + "]");
        }
        
        return retString;
    }
}