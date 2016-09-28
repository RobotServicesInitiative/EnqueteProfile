package enquete_profile.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.robotservices.schemas.v02.common_profile.RoboHeader;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"roboHeader",
	"ietf_language_tag",
	"enquete_id",
	"responder_id",
})
@XmlRootElement(name = "enquete_profile",namespace="http://www.robotservices.org/schemas/Enquete_profile_start_profile")
public class Enquete_profile_get_enquete_profile {

    @XmlElement(name="robo_header", namespace = "http://www.robotservices.org/schemas/V02/Common_profile", required = true)
    protected RoboHeader roboHeader;

    public RoboHeader getRoboHeader() {
        return roboHeader;
    }

    public void setRoboHeader(RoboHeader value) {
        this.roboHeader = value;
    }

    /**
     * 問い合わせを行うenquete_id
     */
    @XmlElement(name="enquete_id")
    private String enquete_id;

    @XmlElement(name="responder_id")
    private String responder_id;

    /**
     * IETF言語タグ
     * https://ja.wikipedia.org/wiki/IETF%E8%A8%80%E8%AA%9E%E3%82%BF%E3%82%B0
     */
    @XmlElement(name="ietf_language_tag")
    private String ietf_language_tag;

	public String getEnquete_id() {
		return enquete_id;
	}

	public void setEnquete_id(String enquete_id) {
		this.enquete_id = enquete_id;
	}
	public String getResponder_id() {
		return responder_id;
	}
	public void setResponder_id(String responder_id) {
		this.responder_id = responder_id;
	}

	public String getIetf_language_tag() {
		return ietf_language_tag;
	}

	public void setIetf_language_tag(String ietf_language_tag) {
		this.ietf_language_tag = ietf_language_tag;
	}



}
