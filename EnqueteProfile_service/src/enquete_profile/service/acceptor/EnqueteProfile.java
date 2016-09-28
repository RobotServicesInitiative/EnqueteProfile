package enquete_profile.service.acceptor;

import org.robotservices.custom_profile.lib.common.util.XMLUtil;
import org.robotservices.custom_profile.lib.service.acceptor.AcceptorCustomProfileBase;
import org.robotservices.custom_profile.lib.service.util.ClassUtil;
import org.robotservices.schemas.v02.common_profile.AttachedFile;
import org.robotservices.schemas.v02.common_profile.AttachedFiles;
import org.robotservices.schemas.v02.common_profile.RetValue;

import enquete_profile.common.AnswerData;
import enquete_profile.common.EnqueteData;
import enquete_profile.common.Enquete_profile_answer_enquete_profile;
import enquete_profile.common.Enquete_profile_end_profile;
import enquete_profile.common.Enquete_profile_get_enquete_profile;
import enquete_profile.common.Enquete_profile_start_profile;
import enquete_profile.common.Enquete_profile_transfer_enquete_data_profile;

public class EnqueteProfile extends AcceptorCustomProfileBase {

	private IEnquete_profile enqueteProfile = null;

	/**
	 * CLtoSV
	 * @param xml
	 * @return
	 */
	public String startProfile(long convId,String xml) {
		//XMLをもとに戻す
		@SuppressWarnings("unused")
		Enquete_profile_start_profile enquete_profile_start_profile = XMLUtil.unmarshal(xml, Enquete_profile_start_profile.class);
		//設定ファイル
		this.enqueteProfile = ClassUtil.getCustomProfileImple("EnqueteProfileImpl");

		RetValue retValue = enqueteProfile.startProfile(convId);
		String returnXml = XMLUtil.marshal(retValue);

		return returnXml;
	}

	/**
	 * CLtoSV
	 * @param xml
	 * @return
	 */
	public String endProfile(long convId,String xml) {
		@SuppressWarnings("unused")
		Enquete_profile_end_profile enquete_profile_end_profile = XMLUtil.unmarshal(xml, Enquete_profile_end_profile.class);
		//インスタンスは使いまわす

		RetValue retValue = this.enqueteProfile.endProfile(convId);
		String returnXml = XMLUtil.marshal(retValue);

		return returnXml;

	}

	/**
	 * CLtoSV
	 * @param xml
	 * @return
	 */
	public String getEnquete(long convId,String xml) {
		Enquete_profile_get_enquete_profile enquete_profile_get_enquete_profile = XMLUtil.unmarshal(xml, Enquete_profile_get_enquete_profile.class);
		//インスタンスは使いまわす

		String enquete_id    = enquete_profile_get_enquete_profile.getEnquete_id();
		String ietf_language_tag = enquete_profile_get_enquete_profile.getIetf_language_tag();
		String responder_id  = enquete_profile_get_enquete_profile.getResponder_id();

		EnqueteData enqueteData = this.enqueteProfile.getEnquete(convId,enquete_id,ietf_language_tag,responder_id);

		String enqueteXml = XMLUtil.marshal(enqueteData);

		AttachedFiles attachedFiles = new AttachedFiles();
		AttachedFile attachedFile = new AttachedFile();

		attachedFile.setByteArray(enqueteXml);
		attachedFiles.getAttachedFile().add(attachedFile);

		RetValue retValue = new RetValue();
		/*
		 * XMLをファイルとして戻す
		 */
		retValue.setAttachedFiles(attachedFiles);

		String returnXml = XMLUtil.marshal(retValue);
		return returnXml;

	}

	/**
	 * CLtoSV
	 * @param xml
	 * @return
	 */
	public String answerEnquete(long convId,String xml) {
		Enquete_profile_answer_enquete_profile enquete_profile_answer_enquete_profile = XMLUtil.unmarshal(xml, Enquete_profile_answer_enquete_profile.class);

		//インスタンスは使いまわす
		String enquete_id = enquete_profile_answer_enquete_profile.getEnquete_id();
		String responder_id = enquete_profile_answer_enquete_profile.getResponder_id();
		AnswerData answerData = enquete_profile_answer_enquete_profile.getAnswerData();

		RetValue retValue = enqueteProfile.answerEnquete(convId,enquete_id, responder_id, answerData);
		String returnXml = XMLUtil.marshal(retValue);

		return returnXml;

	}

	/**
	 * CLtoSV
	 * @param xml
	 * @return
	 */
	public String transferEnqueteData(long convId,String xml) {

		//XMLをクラスにマッピング
		Enquete_profile_transfer_enquete_data_profile enquete_profile_transfer_enquete_data_profile = XMLUtil.unmarshal(xml, Enquete_profile_transfer_enquete_data_profile.class);


		String responder_id    = enquete_profile_transfer_enquete_data_profile.getResponder_id();
		EnqueteData enqueteData = enquete_profile_transfer_enquete_data_profile.getEnqueteData();
		AnswerData answerData  =  enquete_profile_transfer_enquete_data_profile.getAnswerData();

		RetValue retValue = this.enqueteProfile.transferEnqueteData(convId,responder_id, enqueteData, answerData);

		String returnXml = XMLUtil.marshal(retValue);

		return returnXml;
	}



}