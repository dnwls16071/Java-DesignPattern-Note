package Adapter;

public class AdapterClient {
	public static void main(String[] args) {
		OldMessageSender sender = new OldMessageSystem();
		ModernMessageSender adapter = new MessageAdapter(sender);
		adapter.sendMessage("Hello World!", "john@example.com");

		//

		DisplayAdapter usbAdapter = new USBAdapter(new USB(), "Hello World!");
		DisplayAdapter hdmiAdapter = new HDMIAdapter(new HDMI(), 1080);
		DisplayAdapter vgaAdapter = new VGAAdapter(new VGA(), true);

		DisplayAdapter[] displayAdapters = {usbAdapter, hdmiAdapter, vgaAdapter};

		for (DisplayAdapter displayAdapter : displayAdapters) {
			displayAdapter.display();
		}
	}
}
