package enquete_profile.client.invoker;

import java.util.logging.Logger;

import org.robotservices.custom_profile.lib.client.AbstractCustomProfile;
import org.robotservices.custom_profile.lib.client.InvokerCustomProfileFactory;
import org.robotservices.custom_profile.lib.client.PushDataCustomProfile;
import org.robotservices.custom_profile.lib.common.util.CustomProfileConst;
import org.robotservices.custom_profile.lib.common.util.HeaderTimeStampUtil;
import org.robotservices.custom_profile.lib.common.util.XMLUtil;
import org.robotservices.schemas.v02.common_profile.RetValue;
import org.robotservices.schemas.v02.common_profile.RoboHeader;
import org.robotservices.v02.exception.RSiException;

import enquete_profile.common.AnswerData;
import enquete_profile.common.EnqueteData;
import enquete_profile.common.EnqueteProfileConst;
import enquete_profile.common.Enquete_profile_answer_enquete_profile;
import enquete_profile.common.Enquete_profile_end_profile;
import enquete_profile.common.Enquete_profile_get_enquete_profile;
import enquete_profile.common.Enquete_profile_start_profile;
import enquete_profile.common.Enquete_profile_transfer_enquete_data_profile;

public class EnqueteProfile extends AbstractCustomProfile implements IEnquete_profile {

	private static final Logger logger = Logger.getLogger(EnqueteProfile.class.toString());

	@SuppressWarnings("rawtypes")
	public RetValue startProfile() throws RSiException {

		//XMLの作成
		RoboHeader roboHeader = new RoboHeader();
		roboHeader.setVersion(CustomProfileConst.ROBO_HEADER_VERSION);
		roboHeader.setDirection(CustomProfileConst.ROBO_HEADER_DIRECTION.CLtoSV.toString());
		roboHeader.setMessageType(CustomProfileConst.ROBO_HEADER_MESSAGE_TYPE.async.toString());
		roboHeader.setMessageId("MessageId");
		roboHeader.setReplyToMessageId("ReplyToMessageId");
		roboHeader.setLastReply(false);

		roboHeader.setTimestamp(HeaderTimeStampUtil.getHederTimeStampISO8601());

		Enquete_profile_start_profile enquete_profile_start_profile = new Enquete_profile_start_profile();

		enquete_profile_start_profile.setRoboHeader(roboHeader);

		String xml = XMLUtil.marshal(enquete_profile_start_profile);

		//カスタムプロファイル送信
		InvokerCustomProfileFactory invokerCustomProfileFactory = this.getInvokerCustomProfileFactory();
		PushDataCustomProfile pushDataCustomProfile = invokerCustomProfileFactory.getPushDataCustomProfile();

		String receiveXML = pushDataCustomProfile.pushDataCustomProfile(EnqueteProfileConst.SERVICE_ACCEPTOR_CUSTOM_PROFILE_NAME,EnqueteProfileConst.OPERATION_START_PROFILE, xml);
		RetValue retValue = XMLUtil.unmarshal(receiveXML, RetValue.class);

		return retValue;
	}

	@Override
	public RetValue endProfile() throws RSiException {
		//XMLの作成
		RoboHeader roboHeader = new RoboHeader();
		roboHeader.setVersion(CustomProfileConst.ROBO_HEADER_VERSION);
		roboHeader.setDirection(CustomProfileConst.ROBO_HEADER_DIRECTION.CLtoSV.toString());
		roboHeader.setMessageType(CustomProfileConst.ROBO_HEADER_MESSAGE_TYPE.async.toString());
		roboHeader.setMessageId("MessageId");
		roboHeader.setReplyToMessageId("ReplyToMessageId");
		roboHeader.setLastReply(false);

		roboHeader.setTimestamp(HeaderTimeStampUtil.getHederTimeStampISO8601());

		Enquete_profile_end_profile enquete_profile_end_profile = new Enquete_profile_end_profile();

		enquete_profile_end_profile.setRoboHeader(roboHeader);

		String xml = XMLUtil.marshal(enquete_profile_end_profile);

		//カスタムプロファイル送信
		@SuppressWarnings("rawtypes")
		InvokerCustomProfileFactory invokerCustomProfileFactory = this.getInvokerCustomProfileFactory();
		PushDataCustomProfile pushDataCustomProfile = invokerCustomProfileFactory.getPushDataCustomProfile();

		String receiveXML = pushDataCustomProfile.pushDataCustomProfile(EnqueteProfileConst.SERVICE_ACCEPTOR_CUSTOM_PROFILE_NAME,EnqueteProfileConst.OPERATION_NAME_END_PROFILE, xml);

		RetValue retValue = XMLUtil.unmarshal(receiveXML, RetValue.class);
		return retValue;
	}

	@Override
	public EnqueteData getEnquete(String enquete_id,String ietf_language_tag,String responder_id) throws RSiException {

		//XMLの作成
		RoboHeader roboHeader = new RoboHeader();
		roboHeader.setVersion(CustomProfileConst.ROBO_HEADER_VERSION);
		roboHeader.setDirection(CustomProfileConst.ROBO_HEADER_DIRECTION.CLtoSV.toString());
		roboHeader.setMessageType(CustomProfileConst.ROBO_HEADER_MESSAGE_TYPE.async.toString());
		roboHeader.setMessageId("MessageId");
		roboHeader.setReplyToMessageId("ReplyToMessageId");
		roboHeader.setLastReply(false);

		roboHeader.setTimestamp(HeaderTimeStampUtil.getHederTimeStampISO8601());

		Enquete_profile_get_enquete_profile enquete_profile_get_enquete_profile = new Enquete_profile_get_enquete_profile();

		enquete_profile_get_enquete_profile.setEnquete_id(enquete_id);
		enquete_profile_get_enquete_profile.setIetf_language_tag(ietf_language_tag);
		enquete_profile_get_enquete_profile.setResponder_id(responder_id);

		String xml = XMLUtil.marshal(enquete_profile_get_enquete_profile);

		//カスタムプロファイル送信
		@SuppressWarnings("rawtypes")
		InvokerCustomProfileFactory invokerCustomProfileFactory = this.getInvokerCustomProfileFactory();
		PushDataCustomProfile pushDataCustomProfile = invokerCustomProfileFactory.getPushDataCustomProfile();

		String receiveXML = pushDataCustomProfile.pushDataCustomProfile(EnqueteProfileConst.SERVICE_ACCEPTOR_CUSTOM_PROFILE_NAME,EnqueteProfileConst.OPERATION_NAME_GET_ENQUETE, xml);

		RetValue retValue = XMLUtil.unmarshal(receiveXML, RetValue.class);

		//1番目のファイルがEnqueteData
		String enqueteXml = retValue.getAttachedFiles().getAttachedFile().get(0).getByteArray();

//		logger.info(String.format("enqueteXml:%s", enqueteXml));

		EnqueteData enqueteData = XMLUtil.unmarshal(enqueteXml, EnqueteData.class);

		return enqueteData;
	}


	@Override
	public RetValue answerEnquete(String enquete_id,String responder_id,AnswerData answerData) throws RSiException {

		//XMLの作成
		RoboHeader roboHeader = new RoboHeader();
		roboHeader.setVersion(CustomProfileConst.ROBO_HEADER_VERSION);
		roboHeader.setDirection(CustomProfileConst.ROBO_HEADER_DIRECTION.CLtoSV.toString());
		roboHeader.setMessageType(CustomProfileConst.ROBO_HEADER_MESSAGE_TYPE.async.toString());
		roboHeader.setMessageId("MessageId");
		roboHeader.setReplyToMessageId("ReplyToMessageId");
		roboHeader.setLastReply(false);

		roboHeader.setTimestamp(HeaderTimeStampUtil.getHederTimeStampISO8601());

		Enquete_profile_answer_enquete_profile enquete_profile_answer_enquete_profile = new Enquete_profile_answer_enquete_profile();

		enquete_profile_answer_enquete_profile.setEnquete_id(enquete_id);
		enquete_profile_answer_enquete_profile.setResponder_id(responder_id);
		enquete_profile_answer_enquete_profile.setAnswerData(answerData);

		String xml = XMLUtil.marshal(enquete_profile_answer_enquete_profile);

		//カスタムプロファイル送信
		@SuppressWarnings("rawtypes")
		InvokerCustomProfileFactory invokerCustomProfileFactory = this.getInvokerCustomProfileFactory();
		PushDataCustomProfile pushDataCustomProfile = invokerCustomProfileFactory.getPushDataCustomProfile();

		String receiveXML = pushDataCustomProfile.pushDataCustomProfile(EnqueteProfileConst.SERVICE_ACCEPTOR_CUSTOM_PROFILE_NAME,EnqueteProfileConst.OPERATION_NAME_ANSWER_ENQUETE, xml);

		RetValue retValue = XMLUtil.unmarshal(receiveXML, RetValue.class);
		return retValue;
	}

	@Override
	public RetValue transferEnqueteData(String responder_id, EnqueteData enqueteData, AnswerData answerData) throws RSiException {

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

		//カスタムプロファイル送信
		@SuppressWarnings("rawtypes")
		InvokerCustomProfileFactory invokerCustomProfileFactory = this.getInvokerCustomProfileFactory();
		PushDataCustomProfile pushDataCustomProfile = invokerCustomProfileFactory.getPushDataCustomProfile();

		String returnXml = pushDataCustomProfile.pushDataCustomProfile(EnqueteProfileConst.SERVICE_ACCEPTOR_CUSTOM_PROFILE_NAME,EnqueteProfileConst.OPERATION_NAME_TRANSFER_ENQUTE_DATA, xml);

		RetValue retValue = XMLUtil.unmarshal(returnXml, RetValue.class);

		return retValue;
	}


}