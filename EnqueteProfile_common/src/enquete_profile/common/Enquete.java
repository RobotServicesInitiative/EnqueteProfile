package enquete_profile.common;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"question_id",
		"before_question_annotation",
		"attract_mode_url",
		"after_question_annotation",
		"question",
		"answers",
		})

@XmlRootElement(name = "enquete_profile", namespace = "http://www.robotservices.org/schemas/EnqueteQuestionData")
public class Enquete {

	@XmlElement(name = "question_id")
	private String question_id;

	@XmlElement(name = "attract_mode_url")
	private String attract_mode_url;

	@XmlElement(name = "before_question_annotation")
	private String before_question_annotation;

	@XmlElement(name = "after_question_annotation")
	private String after_question_annotation;

	@XmlElement(name = "question")
	private String question;

	@XmlElement(name = "answerBlock")
	private List<AnswerBlock> answers;

	public String getQuestion() {
		return question;
	}

	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<AnswerBlock> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerBlock> answers) {
		this.answers = answers;
	}


	@Override
	public String toString() {
		String returnValue = String
				.format("question_id[%s] question[%s] beforeQuestionAnnotation[%s] afterQuestionAnnotation[%s] attract_mode_url[%s]",
						question_id, question, before_question_annotation,
						after_question_annotation,attract_mode_url);

		if (answers != null) {
			String answerStr = "";
			for (AnswerBlock answer : answers) {//以下はおかしい
				answerStr = String.format("%s [%s]", answerStr, answer.toString());
			}
			returnValue = String.format("%s answers=[%s]", returnValue,answerStr);
		} else {
			returnValue = String.format("%s , answers is null", returnValue);
		}

		return returnValue;
	}

	public String getAttract_mode_url() {
		return attract_mode_url;
	}

	public void setAttract_mode_url(String attract_mode_url) {
		this.attract_mode_url = attract_mode_url;
	}

	public String getBefore_question_annotation() {
		return before_question_annotation;
	}

	public void setBefore_question_annotation(String before_question_annotation) {
		this.before_question_annotation = before_question_annotation;
	}

	public String getAfter_question_annotation() {
		return after_question_annotation;
	}

	public void setAfter_question_annotation(String after_question_annotation) {
		this.after_question_annotation = after_question_annotation;
	}

}
