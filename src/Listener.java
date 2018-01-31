import org.zeromq.*;
import com.google.gson.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;



public class Listener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZMQ.Context context = ZMQ.context(1);

        // Connect our subscriber socket
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.setIdentity("hello".getBytes());

        // Synchronize with the publisher
        ZMQ.Socket sync = context.socket(ZMQ.PUSH);

        subscriber.subscribe("".getBytes());
        subscriber.connect("tcp://129.13.82.251:9999");
        sync.connect("tcp://129.13.82.251:9999");
        sync.send("".getBytes(), 0);

        // Get updates, expect random Ctrl-C death
        String msg = "";
        try {
			Robot robot = new Robot();
			
	        while (!msg.equalsIgnoreCase("END")) {

	            msg = new String(subscriber.recv(0));
	        	Gson gson = new Gson();
	        	Event event = gson.fromJson(msg, Event.class);

	        	
	        	if(event.getType().equals("Gesture")){
        			System.out.println("Gesture");     			
	        		if(event.getParameters().getName().equals("Swipe R")){
	        			System.out.println("Right Swipe");
	        			robot.keyPress(KeyEvent.VK_ENTER);
	        			robot.keyRelease(KeyEvent.VK_ENTER);
	        		}else if(event.getParameters().getName().equals("Swipe L")){
	        			System.out.println("Left Swipe");
	        			robot.keyPress(KeyEvent.VK_LEFT);
	        			robot.keyRelease(KeyEvent.VK_LEFT);
	        		}else if(event.getParameters().getName().equals("Check Mark")){
	        			System.out.println("Check Mark");
	        			robot.keyPress(KeyEvent.VK_ENTER);
	        			robot.keyRelease(KeyEvent.VK_ENTER);
	        		}else if(event.getParameters().getName().equals("X Mark")){
	        			System.out.println("X Mark");
	        			robot.keyPress(KeyEvent.VK_TAB);
	        			robot.keyRelease(KeyEvent.VK_TAB);
	        			robot.keyPress(KeyEvent.VK_TAB);
	        			robot.keyRelease(KeyEvent.VK_TAB);
	        			robot.keyPress(KeyEvent.VK_ENTER);
	        			robot.keyRelease(KeyEvent.VK_ENTER);
	        		}else if(event.getParameters().getName().equals("Rotate RL")){
	        			System.out.println("Rotate RL");
	        			robot.keyPress(KeyEvent.VK_TAB);
	        			robot.keyRelease(KeyEvent.VK_TAB);
	        		}
	        		

	        		
	        		
	        		
	        	}
	        	
	            System.out.println(msg);

		}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
