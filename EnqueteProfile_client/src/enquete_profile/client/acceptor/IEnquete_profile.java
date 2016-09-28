package enquete_profile.client.acceptor;

import org.robotservices.schemas.v02.common_profile.RetValue;

import enquete_profile.common.AnswerData;
import enquete_profile.common.EnqueteData;


public interface IEnquete_profile {

	public RetValue transferEnqueteData(long convId, String responder_id,EnqueteData enqueteData, AnswerData answerData);

}
