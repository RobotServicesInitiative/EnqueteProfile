package enquete_profile.service.invoker;

import org.robotservices.custom_profile.lib.common.util.CustomProfileConst;
import org.robotservices.custom_profile.lib.common.util.HeaderTimeStampUtil;
import org.robotservices.custom_profile.lib.common.util.XMLUtil;
import org.robotservices.custom_profile.lib.service.invoker.InvokerCustomProfileBase;
import org.robotservices.custom_profile.lib.service.invoker.PushDataCustomProfile;
import org.robotservices.schemas.v02.common_profile.RetValue;
import org.robotservices.schemas.v02.common_profile.RoboHeader;
import org.robotservices.v02.exception.RSiException;

import enquete_profile.common.AnswerData;
import enquete_profile.common.EnqueteData;
import enquete_profile.common.EnqueteProfileConst;
import enquete_profile.common.Enquete_profile_transfer_enquete_data_profile;

public class EnqueteProfile extends InvokerCustomProfileBase {

	/**
	 * SVtoCL
	 * @param responder_id
	 * @param enqueteData
	 * @param answerData
	 * @return
	 * @throws RSiException
	 */
	public RetValue transferEnqueteData(String responder_id,EnqueteData enqueteData, AnswerData answerData) throws RSiException {

		//XMLの作成
		RoboHeader roboHeader = new RoboHeader();
		roboHeader.setVersion(CustomProfileConst.ROBO_HEADER_VERSION);
		roboHeader.setDirection(CustomProfileConst.ROBO_HEADER_DIRECTION.CLtoSV.toString());
		roboHeader.setMessageType(CustomProfileConst.ROBO_HEADER_MESSAGE_TYPE.async.toString());
		roboHeader.setMessageId("MessageId");
		roboHeader.setReplyToMessageId("ReplyToMessageId");
		roboHeader.setLastReply(false);

		roboHeader.setTimestamp(HeaderTimeStampUtil.getHederTimeStampISO8601());

		Enquete_profile_transfer_enquete_data_profile enquete_profile_transfer_enquete_data_profile = new Enquete_profile_transfer_enquete_data_profile();
		enquete_profile_transfer_enquete_data_profile.setRoboHeader(roboHeader);
		enquete_profile_transfer_enquete_data_profile.setResponder_id(responder_id);
		enquete_profile_transfer_enquete_data_profile.setEnqueteData(enqueteData);
		enquete_profile_transfer_enquete_data_profile.setAnswerData(answerData);

		String xml = XMLUtil.marshal(enquete_profile_transfer_enquete_data_profile);


		PushDataCustomProfile pushDataCustomProfile = new PushDataCustomProfile(this.getConvId(),this.getInvokerProfileFactory());
		String returnXml = pushDataCustomProfile.pushDataCustomProfile(EnqueteProfileConst.CLIENT_ACCEPTOR_CUSTOM_PROFILE_NAME,EnqueteProfileConst.OPERATION_NAME_TRANSFER_ENQUTE_DATA, xml);

		RetValue retValue = XMLUtil.unmarshal(returnXml, RetValue.class);

		return retValue;
	}

}