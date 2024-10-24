package Adapter;

public class MessageAdapter implements ModernMessageSender {

	private OldMessageSender oldMessageSender;

	public MessageAdapter(OldMessageSender oldMessageSender) {
		this.oldMessageSender = oldMessageSender;
	}

	@Override
	public void sendMessage(String message, String recipient) {
		String[] messageData = {message, recipient};
		int result = oldMessageSender.send(messageData);
		if (result != 1) {
			System.out.println("메시지 전송에 실패했습니다.");
		}
	}
}
