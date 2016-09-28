package enquete_profile.client.invoker;

import org.robotservices.schemas.v02.common_profile.RetValue;
import org.robotservices.v02.exception.RSiException;

import enquete_profile.common.AnswerData;
import enquete_profile.common.EnqueteData;

public interface IEnquete_profile {

	public RetValue startProfile() throws RSiException;
	public RetValue endProfile() throws RSiException;

	public EnqueteData getEnquete(String enquete_id, String ietfLanguageTag, String responder_id) throws RSiException;

	public RetValue answerEnquete(String enquete_id, String responder_id,AnswerData answerData) throws RSiException;

	public RetValue transferEnqueteData(String responder_id,EnqueteData enqueteData, AnswerData answerData) throws RSiException;

}
