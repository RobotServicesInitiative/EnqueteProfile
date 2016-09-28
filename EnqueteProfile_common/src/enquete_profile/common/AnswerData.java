package enquete_profile.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"enquete_id",
		"answer_list",
		"start_answer_data_date",
		"end_answer_data_date",
})
@XmlRootElement(name = "enquete_profile",namespace="http://www.robotservices.org/schemas/EnqueteAnswerData")
public class AnswerData {

	@XmlElement(name="euquete_id")
	private String enquete_id;

	@XmlElement(name="ietf_language_tag")
	private String ietf_language_tag;

	@XmlElementWrapper(name = "answer_list")
    @XmlElement(name="answer")
    private List<Answer> answer_list = new ArrayList<Answer>();

	@XmlElement(name="start_answer_data_date")
	private Date start_answer_data_date;

	@XmlElement(name="end_answer_data_date")
	private Date end_answer_data_date;

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
		String startDate = sdf.format(this.getStart_answer_data_date());
		String endDate = sdf.format(this.getEnd_answer_data_date());
		String returnValue = String.format("enquete_id[%s] ietf_language_tag[%s] StartAnswerDate[%s] EndAnswerDate[%s]", enquete_id,ietf_language_tag,startDate,endDate);
		if(getAnswer_list() != null) {
			for(Answer answerBlock:getAnswer_list()) {
				returnValue = String.format("%s answerBlock[%s]]", returnValue,answerBlock.toString());
			}
		} else {
			returnValue = "answerList is null.";
		}
		return returnValue;
	}

	public String getEnquete_id() {
		return enquete_id;
	}

	public void setEnquete_id(String enquete_id) {
		this.enquete_id = enquete_id;
	}


	public List<Answer> getAnswer_list() {
		return answer_list;
	}

	public void setAnswer_list(List<Answer> answer_list) {
		this.answer_list = answer_list;
	}

	public String getIetf_language_tag() {
		return ietf_language_tag;
	}

	public void setIetf_language_tag(String ietf_language_tag) {
		this.ietf_language_tag = ietf_language_tag;
	}

	public Date getStart_answer_data_date() {
		return start_answer_data_date;
	}

	public void setStart_answer_data_date(Date start_answer_data_date) {
		this.start_answer_data_date = start_answer_data_date;
	}

	public Date getEnd_answer_data_date() {
		return end_answer_data_date;
	}

	public void setEnd_answer_data_date(Date end_answer_data_date) {
		this.end_answer_data_date = end_answer_data_date;
	}



}
