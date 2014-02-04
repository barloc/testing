import java.util.Map;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.yaml.snakeyaml.Yaml;


public class TimeServerHandler implements IoHandler {

	@Override
	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String str = message.toString();
		
        Yaml yaml = new Yaml();
        Map<String, Integer> object = (Map<String, Integer>) yaml.load(str);
        
        System.out.println(str);
        System.out.println(object.toString());
        System.out.println(object.get("quit").toString());
        
        if(object.get("quit").intValue() == 1) {
            session.close(true);
            return;
        }

        System.out.println("Message written...");
	}

	@Override
	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionCreated(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		
		System.out.println("IDLE "+session.getIdleCount(status));
	}

	@Override
	public void sessionOpened(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
