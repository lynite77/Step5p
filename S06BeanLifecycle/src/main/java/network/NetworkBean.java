package network;


public class NetworkBean {
	
	Network network = new Network();
	
	public void open() {
		System.out.println("NetworkBean open()");
		network.connect("http://ez.edu");
	}

	public void send(String msg) {
		System.out.println("NetworkBean send()");
		int len = network.send(msg);
		System.out.printf("msg len(%d) succeed.\n", len);
	}

	public void close() {
		System.out.println("NetworkBean close()");
		network.disconnect();
	}
}
