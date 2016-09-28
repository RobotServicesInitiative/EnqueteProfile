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
	"enquete_id",
	"responder_id",
	"answerData",

})
@XmlRootElement(name = "enquete_profile",namespace="http://www.robotservices.org/schemas/Enquete_profile_start_profile")
public class Enquete_profile_answer_enquete_profile {

    @XmlElement(name="robo_header", namespace = "http://www.robotservices.org/schemas/V02/Common_profile", required = true)
    protected RoboHeader roboHeader;


    public RoboHeader getRoboHeader() {
        return roboHeader;
    }
    public void setRoboHeader(RoboHeader value) {
        this.roboHeader = value;
    }

    /**
     * 答える対象のenquete_id
     */
    @XmlElement(name="enquete_id")
    private String enquete_id;

    /**
     * 答えた人
     * robot_idかもしれないし、ほかのIDかもしれない
     */
    @XmlElement(name="responder_id")
    private String responder_id;

    /**
     * 答え
     */
    @XmlElement(name="answerData")
    private AnswerData answerData;



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
	public AnswerData getAnswerData() {
		return answerData;
	}
	public void setAnswerData(AnswerData answerData) {
		this.answerData = answerData;
	}

}
