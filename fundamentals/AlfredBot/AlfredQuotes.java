import java.util.Date;


public class AlfredQuotes{

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello %s, lovely to see you. How are you?",name);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date today = new Date();
        return String.format("it is currently %s",today);
    }
    
    public String respondBeforeAlexis(String conversation) {
        String result;
        if(conversation.toLowerCase().indexOf("alexis")>=0){
             result = "Right away, sir. She certainly isn't sophisticated enough for that";
        }
        else if (conversation.toLowerCase().indexOf("alfred")>=0){
            result = "At your service. As you wish, naturally";
        }
        else{
            result = "Right. and with that I shall retire.";
        }
        return result;
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}













