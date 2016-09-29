package enquete_profile.common;
import java.util.ArrayList;
import java.util.Date;

import org.robotservices.custom_profile.lib.common.util.XMLUtil;


public class CreateAnswerXMLMain {

	public static void main(String[] args) {

		AnswerData answerData = new AnswerData();

		answerData.setEnquete_id("enquete_id");

		answerData.setIetf_language_tag("ja");
		answerData.setStart_answer_data_date(new Date());

		answerData.setAnswer_list(new ArrayList<Answer>());

		answerData.getAnswer_list().add(createAnswer("question_1","question_1_answer_3","question_1_アンサー_3",null,"question_2"));
		answerData.getAnswer_list().add(createAnswer("question_2","question_2_answer_2","question_1_アンサー_2",null,"question_3"));
		answerData.getAnswer_list().add(createAnswer("question_3","question_3_answer_1","question_1_アンサー_1","enquete_12",null));

		answerData.setEnd_answer_data_date(new Date());

		String xml = XMLUtil.marshal(answerData);
		System.out.println(xml);

		return ;
	}

	private static Answer createAnswer(String questionId,String answerId,String asnwerString,String nextEnqueteId,String nextQuestionId) {

		Answer answer = new Answer();

		answer.setQuestion_id(questionId);
		answer.setStart_answer_date(new Date());

		answer.setAnswer_block(new AnswerBlock());
		answer.getAnswer_block().setAnswer_id(answerId);
		answer.getAnswer_block().setAnswer_string(asnwerString);
		answer.getAnswer_block().setNext_enquete_id(nextEnqueteId);
		answer.getAnswer_block().setNext_question_id(nextQuestionId);

		answer.setEnd_answer_date(new Date());

		return answer;
	}

}
