package enquete_profile.service.acceptor;

import org.robotservices.schemas.v02.common_profile.RetValue;

import enquete_profile.common.AnswerData;
import enquete_profile.common.EnqueteData;

public interface IEnquete_profile {

	public RetValue startProfile(long convId);
	public RetValue endProfile(long convId);

	public EnqueteData getEnquete(long convId,String enquete_id,String ietf_language_tag,String responder_id);

	public RetValue answerEnquete(long convId,String enquete_id,String responder_id,AnswerData answerData);
	public RetValue transferEnqueteData(long convId,String responder_id,EnqueteData enqueteData, AnswerData answerData);

}
