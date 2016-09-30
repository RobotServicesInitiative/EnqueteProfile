package enquete_profile.common;
import java.util.ArrayList;

import org.robotservices.custom_profile.lib.common.util.XMLUtil;


public class CreateEnqueteXMLMain {

	public static void main(String[] args) {

		EnqueteData enqueteData = new EnqueteData();

		enqueteData.setEnquete_id("enquete_1");
		enqueteData.setBefore_enquete_annotation("アンケート前注釈");
		enqueteData.setAfter_enquete_annotation("アンケート後注釈");
		enqueteData.setIetf_language_tag("ja");
		enqueteData.setEnqueteList(new ArrayList<Enquete>());

		String questionId = "question_1";
		String nextEnqueteId = null;
		String nextQuestionId = "question_2";
		createEnquete(enqueteData,questionId,nextEnqueteId,nextQuestionId);

		questionId = "question_2";
		nextEnqueteId = null;
		nextQuestionId = "question_3";
		createEnquete(enqueteData,questionId,nextEnqueteId,nextQuestionId);

		questionId = "question_3";
		nextEnqueteId = "enquete_12";
		nextQuestionId = null;
		createEnquete(enqueteData,questionId,nextEnqueteId,nextQuestionId);

		String xml = XMLUtil.marshal(enqueteData);
		System.out.println(xml);

		return ;
	}

	private static void createEnquete(EnqueteData enqueteData,String questionId,String nextEnqueteId,String nextQuestionId) {

		Enquete enquete1 = new Enquete();
		enqueteData.getEnqueteList().add(enquete1);

		enquete1.setQuestion_id(questionId);
		enquete1.setBefore_question_annotation(String.format("%s前注釈",questionId));
		enquete1.setAfter_question_annotation(String.format("%s後注釈",questionId));
		enquete1.setQuestion(String.format("%sの質問",questionId));
		enquete1.setAnswers(new ArrayList<AnswerBlock>());
		enquete1.setAttract_mode_url(String.format("http://%s", questionId));


		{
			AnswerBlock answerBlock = new AnswerBlock();
			answerBlock.setAnswer_id(String.format("%s_answer_1",questionId));
			answerBlock.setAnswer_string(String.format("%s_アンサー_1",questionId));
			answerBlock.setNext_enquete_id(nextEnqueteId);
			answerBlock.setNext_question_id(nextQuestionId);
			enquete1.getAnswers().add(answerBlock);
		}

		{
			AnswerBlock answerBlock = new AnswerBlock();
			answerBlock.setAnswer_id(String.format("%s_answer_2",questionId));
			answerBlock.setAnswer_string(String.format("%s_アンサー_2",questionId));
			answerBlock.setNext_enquete_id(nextEnqueteId);
			answerBlock.setNext_question_id(nextQuestionId);
			enquete1.getAnswers().add(answerBlock);
		}

		{
			AnswerBlock answerBlock = new AnswerBlock();
			answerBlock.setAnswer_id(String.format("%s_answer_3",questionId));
			answerBlock.setAnswer_string(String.format("%s_アンサー_3",questionId));
			answerBlock.setNext_enquete_id(nextEnqueteId);
			answerBlock.setNext_question_id(nextQuestionId);
			enquete1.getAnswers().add(answerBlock);
		}

	}

}
