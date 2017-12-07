import org.zeromq.*;


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
        subscriber.connect("tcp://192.168.100.100:9999");
        sync.connect("tcp://192.168.100.100:9999");
        sync.send("".getBytes(), 0);

        // Get updates, expect random Ctrl-C death
        String msg = "";
        while (!msg.equalsIgnoreCase("END")) {
            msg = new String(subscriber.recv(0));
            System.out.println(msg);

	}
	}
}
