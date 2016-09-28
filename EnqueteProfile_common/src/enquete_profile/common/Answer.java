package enquete_profile.common;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"question_id",
		"answer_block",
		"start_answer_date",
		"end_answer_date",
})
//@XmlRootElement(name = "enquete_profile",namespace="http://www.robotservices.org/schemas/EnqueteAnswer")
public class Answer {
	@XmlElement(name="question_id")
	private String question_id;

	@XmlElement(name="answer_block")
	private AnswerBlock answer_block;

	@XmlElement(name="start_answer_date")
	private Date start_answer_date;

	@XmlElement(name="end_answer_date")
	private Date end_answer_date;

	@Override
	public String toString() {
		return String.format("question_id[%s] answer_block[%s] start_answer_date[%s] end_answer_date[%s]", question_id,answer_block,start_answer_date,end_answer_date);
	}

	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}

	public AnswerBlock getAnswer_block() {
		return answer_block;
	}

	public void setAnswer_block(AnswerBlock answer_block) {
		this.answer_block = answer_block;
	}

	public Date getStart_answer_date() {
		return start_answer_date;
	}

	public void setStart_answer_date(Date start_answer_date) {
		this.start_answer_date = start_answer_date;
	}

	public Date getEnd_answer_date() {
		return end_answer_date;
	}

	public void setEnd_answer_date(Date end_answer_date) {
		this.end_answer_date = end_answer_date;
	}


}
