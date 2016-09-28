package enquete_profile.common;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "enquete_id", "before_enquete_annotation",
		"after_enquete_annotation", "enqueteList",
})
@XmlRootElement(name = "enquete_profile", namespace = "http://www.robotservices.org/schemas/EnqueteQuestionData")
public class EnqueteData {

	@XmlElement(name = "euquete_id")
	private String enquete_id;

	@XmlElement(name = "ietf_language_tag")
	private String ietf_language_tag;

	@XmlElementWrapper(name = "enqueteList")
	@XmlElement(name = "enquete")
	private List<Enquete> enqueteList = new ArrayList<Enquete>();

	@XmlElement(name = "before_enquete_annotation")
	private String before_enquete_annotation;

	@XmlElement(name = "after_enquete_annotation")
	private String after_enquete_annotation;

	public List<Enquete> getEnqueteList() {
		return enqueteList;
	}

	public void setEnqueteList(List<Enquete> enqueteList) {
		this.enqueteList = enqueteList;
	}

	public String getEnquete_id() {
		return enquete_id;
	}

	public void setEnquete_id(String enquete_id) {
		this.enquete_id = enquete_id;
	}


	@Override
	public String toString() {
		String returnValue = String
				.format("enquete_id[%s] ietf_language_tag[%s] beforeEnqueteAnnotation[%s] afterEnqueteAnnotation[%s]",
						enquete_id,ietf_language_tag, before_enquete_annotation,
						after_enquete_annotation);
		if (getEnqueteList() != null) {
			for (Enquete enquete : getEnqueteList()) {
				returnValue = String.format("%s[%s]", returnValue,
						enquete.toString());
			}
		} else {
			returnValue = "enqueteList is null.";
		}
		return returnValue;
	}

	public String getBefore_enquete_annotation() {
		return before_enquete_annotation;
	}

	public void setBefore_enquete_annotation(String before_enquete_annotation) {
		this.before_enquete_annotation = before_enquete_annotation;
	}

	public String getAfter_enquete_annotation() {
		return after_enquete_annotation;
	}

	public void setAfter_enquete_annotation(String after_enquete_annotation) {
		this.after_enquete_annotation = after_enquete_annotation;
	}

	public String getIetf_language_tag() {
		return ietf_language_tag;
	}

	public void setIetf_language_tag(String ietf_language_tag) {
		this.ietf_language_tag = ietf_language_tag;
	}
}
