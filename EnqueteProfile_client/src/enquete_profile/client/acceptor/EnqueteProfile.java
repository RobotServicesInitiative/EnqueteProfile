package enquete_profile.client.acceptor;

import java.util.logging.Logger;

import org.robotservices.custom_profile.lib.client.acceptor.AcceptorCustomProfileBase;
import org.robotservices.custom_profile.lib.common.util.ClassUtil;
import org.robotservices.custom_profile.lib.common.util.XMLUtil;
import org.robotservices.schemas.v02.common_profile.RetValue;

import enquete_profile.common.AnswerData;
import enquete_profile.common.EnqueteData;
import enquete_profile.common.Enquete_profile_transfer_enquete_data_profile;

public class EnqueteProfile extends AcceptorCustomProfileBase {

	private static final Logger logger = Logger.getLogger(EnqueteProfile.class.toString());

	private IEnquete_profile enquete_profile = null;

	public String transferEnqueteData(long convId,String xml) {

		//XMLをクラスにマッピング
		Enquete_profile_transfer_enquete_data_profile enquete_profile_transfer_enquete_data_profile = XMLUtil.unmarshal(xml, Enquete_profile_transfer_enquete_data_profile.class);

		//インスタンスは使いまわす
		if(this.enquete_profile == null) {
			this.enquete_profile = ClassUtil.getCustomProfileImple("EnqueteProfileImpl");
		}

		String responder_id    = enquete_profile_transfer_enquete_data_profile.getResponder_id();
		EnqueteData enqueteData = enquete_profile_transfer_enquete_data_profile.getEnqueteData();
		AnswerData answerData  =  enquete_profile_transfer_enquete_data_profile.getAnswerData();

		RetValue retValue = this.enquete_profile.transferEnqueteData(convId,responder_id, enqueteData, answerData);

		String returnXml = XMLUtil.marshal(retValue);

		return returnXml;
	}

}