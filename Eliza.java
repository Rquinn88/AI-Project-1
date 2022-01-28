import java.util.*;
import java.util.Random;

public class Eliza
{
	public static boolean go = true;
	
	public static void main (String args[])
	{
		System.out.printf("\nHello, this is Eliza. I am your personal electronic Therapist. What would you like to discuss today?\n\n");
		
		while(go == true){
			conversation();
		}
	}
	
	public static void conversation(){
		
		Scanner in = new Scanner(System.in);
		ArrayList<String> responses = new ArrayList<>();
		String input = in.nextLine();
		String output, output1, output2;
		String[] word;
		Random rand = new Random();
		int choice, i, j;
		boolean cont = true;
		boolean exit = false;
		
		input = input.toLowerCase();
		word = input.split(" ");
		responses.clear();
			
		for (i = 0; i < word.length; i++){
			
			//Rule 1("Perhaps" / "Maybe")	
			if(word[i].equals("perhaps") | word[i].equals("maybe")){
				responses.add("Why the uncertain tone?");
			}
			
			//Rule 2(Short Input)	
			if(word.length < 15)	
				responses.add("Tell me more.");
			
			//rule 3 (you) + rule 5.1 ("you are") + rule 8 (You are like) 
			if(word[i].equals("you")){
				
				if(i < word.length - 1){
				
					if (word[i+1].equals("are") && !word[i+2].equals("like")){
					
						output1 = "Why are you interested in whether or not I am ";
						output2 = "What makes you think I am ";
					
						for (j=i+2; j < word.length; j++){
						
							if(j+1 != word.length)
							output1 = output1 + word[j] + " ";
							
							else
							output1 = output1 + word[j] + "?";
						
							if(j+1 != word.length)
							output2 = output2 + word[j] + " ";
							
							else
							output2 = output2 + word[j] + "?";
							
						}
					responses.add(output1);
					responses.add(output2);
					
				}
				
					if (word[i+1].equals("are") && word[i+2].equals("like") && (i < word.length - 3)){
					
					 responses.add("What resemblance do you see ");
					}
				}
				
				else
				responses.add("We were discussing you, not me. ");
				responses.add("You are not really talking about me, are you? ");
				
			}
			
			//Rule 4("Sorry")	
			if(word[i].equals("sorry")){
				responses.add("Please don't apologize.");
				responses.add("Apologies are not necessary.");
			}
			
			//rule 5.2 ("are you")
			if(word[i].equals("are")){
				
				if (word[i+1].equals("you")){
					
					output1 = "Why are you interested in whether or not I am ";
					output2 = "What makes you think I am ";
					
					for (j=i+2; j < word.length; j++){
						output1 = output1 + word[j] + " ";
						output2 = output2 + word[j] + " ";
					}
					responses.add(output1);
					responses.add(output2);
					
				}
			}
			
			//rule 6 ("I need / I want")
			if(word[i].equals("i")){
				
				if (word[i+1].equals("need") || word[i+1].equals("want")){
					
					output = "What would it mean if you got ";
					
					for (j=i+2; j < word.length; j++){
						output = output + word[j] + " ";
					}
					responses.add(output);
					
				}
			}
				
			//Rule 7("mother" / "father" / "brother" / "sister")
			if(word[i].equals("mother") || word[i].equals("father") || word[i].equals("sister") || word[i].equals("brother"))
				responses.add("Tell me more about your family.");
			
			//rule 8 ("You are like")
			if(word[i].equals("i")){
				
				if (word[i+1].equals("need") || word[i+1].equals("want")){
					
					output = "What would it mean if you got ";
					
					for (j=i+2; j < word.length; j++){
						output = output + word[j] + " ";
					}
					responses.add(output);
					
				}
			}
			
			//rule 9 ("X is Y")
			if(word[i].equals("is")){
				
				output = "What else comes to your mind when you think of ";
					
				for (j = i + 1; j < word.length; j++){
					
					if(j+1 != word.length)
						output = output + word[j] + " ";
					else
						output = output + word[j]+ "?";
				}
				
				responses.add(output);
				
			}
				 
			//Rule 10 (Anything ending with "?")		
			if(word[i].endsWith("?")){
				responses.add("Have you asked such questions before?");
				responses.add("What is it you really want to know?");
			}
			
			//rule 11 ("I don't")
			if(word[i].equals("i")){
				
				if (word[i+1].equals("dont") || word[i+1].equals("don't")){
					
					output = "Do you wish for ";
					
					for (j=i+2; j < word.length; j++){
						
						if(j+1 != word.length)
							output = output + word[j] + " ";
						else
							output = output + word[j]+ "?";
					}
					responses.add(output);
					
				}
			}
			
			//Rule 12 (Obscenities)	
			if(word[i].equals("darn") || word[i].equals("gosh"))
				responses.add("Does it make you feel strong to use that kind of language?");		
			
			//Rule 13 ("Yes" and "No" in the same sentance)
			if(word[i].equals("yes") && word[i].equals("no"))
				responses.add("You seem uncertain.");
			
			//Rule 14 ("Name" / "Names")
			if(word[i].equals("name") == true || word[i].equals("names") == true)
					responses.add("I am not interested in names.");
				
			//Exit
			if(word[i].equals("exit")){
				exit = true;
				System.out.printf("Have a nice life!");
				go = false;
			}
			
			//If none of the above suffice
			if(responses.size() == 0){
				responses.add("Interesting. Do go on.");
				responses.add("How do you feel about that?");
				responses.add("Please, please, elucidate your thoughts.");
			}
		
	}
	choice = rand.nextInt(responses.size());
	
	if(exit != true)
		System.out.println(responses.get(choice));
	}
	

}