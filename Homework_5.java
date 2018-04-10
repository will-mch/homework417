import java.util.ArrayList;
import java.util.Scanner;

public class Homework_5 {

	public static void main(String [] args) throws Exception
	{
		boolean flag=true;
		boolean valid = true;
		Scanner s = new Scanner(System.in);
		while(flag)
		{
                    try{
                        int oldState;
                        int newState;
                        Tape tapeSymbol = null;
                        StackAlphabet oldStackSymbol = null;
                        StackAlphabet newStackSymbol = null;
                    
			System.out.println("Please enter your tuple");
			
			System.out.print("Old State(1-20): ");
			String a = s.next();
                        oldState = Integer.valueOf(a);
                        
                        if(oldState > 20 || oldState <= 0){
                            throw new Exception("oldState input error");
                        }
			
                        //Read
			System.out.print("Tape-symbol (-1(Epsilon), 0, 1): ");
			tapeSymbol = Tape.convertString(s.next());
                        if(tapeSymbol == null){
                            throw new Exception("TapeSymbol input error");
                        }
                        
                        //Pop
			System.out.print("Old-stack-symbol(-1(Epsilon),0,1,$): ");
			oldStackSymbol = StackAlphabet.convertString(s.next());
                        if(oldStackSymbol == null){
                            throw new Exception("Error inputing oldStackSymbol");
                        }
			
                        //New State
			System.out.print("New-state(1-20): ");
			newState = Integer.valueOf(s.next());                       
                        if(newState > 20 || newState <= 0){
                            throw new Exception("newState input error");
                        }
			
	
                        //Pushed
			System.out.print("New-stack(-1(Epsilon),0,1,$): ");
			newStackSymbol = StackAlphabet.convertString(s.next());
                        if(newStackSymbol == null){
                            throw new Exception("Error inputing newStackSymol");
                        }
						
                        
                        State oldStateObj = null;
                        State newStateObj = null;
                        
                        if(!State.doesStateExist(oldState)){
                            oldStateObj = State.addState(oldState);
                        }else{
                            oldStateObj = State.getState(oldState);
                        }
                        
                        if(!State.doesStateExist(newState)){
                            newStateObj = State.addState(newState);
                        }else{
                            newStateObj = State.getState(newState);
                        }
                        
                        oldStateObj.addTransition(new Transition(tapeSymbol, newState, oldStackSymbol, newStackSymbol));
                        
                        
                        System.out.print("Would you like to enter another tuple? (y/n): ");
			String ans = s.next();
                        
                        if(ans.equals("n")){
                           flag=false;
                        }
                        
                        //Add transition

                    }catch(Exception e){
                        System.out.println(e.getMessage());
                        System.out.println("Reinput last tuple plox\n");
                    }
                        
		}
                
                System.out.println("Input Accepting states separated by a space. ex(1 2 3 4)");
                String[] acceptingStates = s.next().split("\\s+");
                
                for(String acceptState : acceptingStates){
                    State st = State.getState(Integer.valueOf(acceptState));
                    st.setAccepting(true);
                }	
		
                PDA pda = new PDA();
                pda.run();
                
		
	}
}
