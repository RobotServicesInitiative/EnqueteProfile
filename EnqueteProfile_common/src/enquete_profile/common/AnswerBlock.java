package enquete_profile.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder ={
		"answer_id",
		"answer_string",
		"next_enquete_id",
		"next_question_id", })
@XmlRootElement(name = "enquete_profile", namespace = "http://www.robotservices.org/schemas/EnqueteAnswer")
public class AnswerBlock {


	@XmlElement(name="answer_id")
	private String answer_id;

	@XmlElement(name = "next_enquete_id")
	private String next_enquete_id;

	@XmlElement(name = "next_question_id")
	private String next_question_id;

	@XmlElement(name = "answer_string")
	private String answer_string;


	@Override
	public String toString() {
		String returnValue = null;

		returnValue = String.format(
				"answer_id[%s] AnswerString[%s] next_enquete_id[%s] next_question_id[%s]",
				answer_id,answer_string, next_enquete_id, next_question_id);

		return returnValue;
	}

	public String getNext_enquete_id() {
		return next_enquete_id;
	}

	public void setNext_enquete_id(String next_enquete_id) {
		this.next_enquete_id = next_enquete_id;
	}

	public String getNext_question_id() {
		return next_question_id;
	}

	public void setNext_question_id(String next_question_id) {
		this.next_question_id = next_question_id;
	}

	public String getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(String answer_id) {
		this.answer_id = answer_id;
	}

	public String getAnswer_string() {
		return answer_string;
	}

	public void setAnswer_string(String answer_string) {
		this.answer_string = answer_string;
	}

}
