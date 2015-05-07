#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.*;

public class SampleComputeNode extends MbJavaComputeNode {

	private static Logger log = LogManager.getLogger(SampleComputeNode.class);

	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		log.entry();
		MbOutputTerminal out = getOutputTerminal("out");
		MbOutputTerminal alt = getOutputTerminal("alternate");

		MbMessage inMessage = inAssembly.getMessage();

		// create new message
		MbMessage outMessage = new MbMessage(inMessage);
		MbMessageAssembly outAssembly = new MbMessageAssembly(inAssembly,
				outMessage);

		try {
			// ----------------------------------------------------------
			// Add user code below

			// End of user code
			// ----------------------------------------------------------

			// The following should only be changed
			// if not propagating message to the 'out' terminal
			out.propagate(outAssembly);

		} finally {
			// clear the outMessage
			outMessage.clearMessage();
		}
	}

}
