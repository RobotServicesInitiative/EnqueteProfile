# RSNP CustomProfile EnqueteProfile

##最新ライブラリ

<https://github.com/RobotServicesInitiative/EnqueteProfile/blob/master/EnqueteProfile_service/CutomProfile_EnqueteProfile_service_201609232121.jar>
<https://github.com/RobotServicesInitiative/EnqueteProfile/blob/master/EnqueteProfile_common/CutomProfile_EnqueteProfile_common_201609271538.jar>
<https://github.com/RobotServicesInitiative/EnqueteProfile/blob/master/EnqueteProfile_service/CutomProfile_EnqueteProfile_service_201609232121.jar>

##プロファイルの説明

####各値の説明

* enquete_id  
アンケート群の固有ID  

* ietfLanguageTag  
アンケートIDに付随する設問の言語  
enquete_idに対して1:Nになる  
<https://ja.wikipedia.org/wiki/IETF%E8%A8%80%E8%AA%9E%E3%82%BF%E3%82%B0>を参照  
例  
ja 日本語  
en 英語  
ja-jp 日本で使われている日本語  
en-us USAで使われている英語  
en-uk イギリスで使われている英語  

* question_id  
アンケートに付随するそれぞれの問に該当するid  
enquete_idとquestion_idは1:Nになる  

* answer_id  
question_idに対して回答可能な選択式回答のid question_idに対して1:Nになる  

* responder_id  
回答者が誰か識別するためのid このidはRSNP上規約があるわけではないため、プロファイル使用者側で仕様を決定する必要がある。  

* 日付について  
形式: yyyy-MM-dd hh:mm:ss.SSS z  
例:  
2016-09-29 17:02:48.504 JST  

###EnqueteDataの基本構造

##enquete_id アンケート群のID  
→ietfLanguageTag アンケート群の言語、複数言語存在する場合もある  
→question_id アンケート群の設問１  
→→answer_id　設問1の選択肢1  
→→answer_id 設問1の選択肢2  
→→answer_id 設問1の選択肢3  
→question_id 設問2  
→→answer_id 設問2の選択肢1  
→→answer_id 設問2の選択肢2  
→→answer_id 設問2の選択肢3  

##AnswerDataの基本構造  

enquete_id アンケート群のID
→ietfLanguageTag アンケート群の回答言語
→question_id アンケート群の設問１
→→answer_id　設問1回答
→question_id 設問2
→→answer_id 設問2の回答

Robot側Invokerインターフェース

public EnqueteData getEnquete(String enquete_id, String ietfLanguageTag, String responder_id)
RobotからサービスにEnqueteDataの問い合わせを行う。
enquete_id:取得したいenquete_id not null
取得したいenquete_idの言語 not null
取得したいresponder_id null可

public RetValue answerEnquete(String enquete_id, String responder_id,AnswerData answerData)
enquete_id:回答を行ったenquete_id 回答言語はanswer_data内に内包する not null
responder_id:回答者 not null
answerData 回答データ not null

public RetValue transferEnqueteData(String responder_id,EnqueteData enqueteData, AnswerData answerData)
回答者が回答したenqueteDataとanswerDataのセットを、 サービスへ転送する
responder_id not null
enqueteData not null
answerData not null

Service側Invokerインターフェース

public RetValue transferEnqueteData(String responder_id, EnqueteData enqueteData, AnswerData answerData)
使い方はRobot側と同じ
EnqueteDataサンプル


    <enqueteData>
       <enquete_id>enquete_1</enquete_id>
       <ietf_language_tag>ja</ietf_language_tag>
       <enqueteList class="java.util.ArrayList">
          <enquete>
             <question_id>question_1</question_id>
             <attract_mode_url>http://question_1</attract_mode_url>
             <before_question_annotation>question_1前注釈</before_question_annotation>
             <after_question_annotation>question_1後注釈</after_question_annotation>
             <question>question_1の質問</question>
             <answers class="java.util.ArrayList">
                <answerBlock>
                   <answer_id>question_1_answer_1</answer_id>
                   <next_question_id>question_2</next_question_id>
                   <answer_string>question_1_アンサー_1</answer_string>
                </answerBlock>
                <answerBlock>
                   <answer_id>question_1_answer_2</answer_id>
                   <next_question_id>question_2</next_question_id>
                   <answer_string>question_1_アンサー_2</answer_string>
                </answerBlock>
                <answerBlock>
                   <answer_id>question_1_answer_3</answer_id>
                   <next_question_id>question_2</next_question_id>
                   <answer_string>question_1_アンサー_3</answer_string>
                </answerBlock>
             </answers>
          </enquete>
          <enquete>
             <question_id>question_2</question_id>
             <attract_mode_url>http://question_2</attract_mode_url>
             <before_question_annotation>question_2前注釈</before_question_annotation>
             <after_question_annotation>question_2後注釈</after_question_annotation>
             <question>question_2の質問</question>
             <answers class="java.util.ArrayList">
                <answerBlock>
                   <answer_id>question_2_answer_1</answer_id>
                   <next_question_id>question_3</next_question_id>
                   <answer_string>question_2_アンサー_1</answer_string>
                </answerBlock>
                <answerBlock>
                   <answer_id>question_2_answer_2</answer_id>
                   <next_question_id>question_3</next_question_id>
                   <answer_string>question_2_アンサー_2</answer_string>
                </answerBlock>
                <answerBlock>
                   <answer_id>question_2_answer_3</answer_id>
                   <next_question_id>question_3</next_question_id>
                   <answer_string>question_2_アンサー_3</answer_string>
                </answerBlock>
             </answers>
          </enquete>
          <enquete>
             <question_id>question_3</question_id>
             <attract_mode_url>http://question_3</attract_mode_url>
             <before_question_annotation>question_3前注釈</before_question_annotation>
             <after_question_annotation>question_3後注釈</after_question_annotation>
             <question>question_3の質問</question>
             <answers class="java.util.ArrayList">
                <answerBlock>
                   <answer_id>question_3_answer_1</answer_id>
                   <next_enquete_id>enquete_12</next_enquete_id>
                   <answer_string>question_3_アンサー_1</answer_string>
                </answerBlock>
                <answerBlock>
                   <answer_id>question_3_answer_2</answer_id>
                   <next_enquete_id>enquete_12</next_enquete_id>
                   <answer_string>question_3_アンサー_2</answer_string>
                </answerBlock>
                <answerBlock>
                   <answer_id>question_3_answer_3</answer_id>
                   <next_enquete_id>enquete_12</next_enquete_id>
                   <answer_string>question_3_アンサー_3</answer_string>
                </answerBlock>
             </answers>
          </enquete>
       </enqueteList>
       <before_enquete_annotation>アンケート前注釈</before_enquete_annotation>
       <after_enquete_annotation>アンケート後注釈</after_enquete_annotation>
    </enqueteData>

AnswerDataサンプル


    <answerData>
       <enquete_id>enquete_id</enquete_id>
       <ietf_language_tag>ja</ietf_language_tag>
       <answer_list class="java.util.ArrayList">
          <answer>
             <question_id>question_1</question_id>
             <answer_block>
                <answer_id>question_1_answer_3</answer_id>
                <next_question_id>question_2</next_question_id>
                <answer_string>question_1_アンサー_3</answer_string>
             </answer_block>
             <start_answer_date>2016-09-29 17:02:48.503 JST</start_answer_date>
             <end_answer_date>2016-09-29 17:02:48.504 JST</end_answer_date>
          </answer>
          <answer>
             <question_id>question_2</question_id>
             <answer_block>
                <answer_id>question_2_answer_2</answer_id>
                <next_question_id>question_3</next_question_id>
                <answer_string>question_1_アンサー_2</answer_string>
             </answer_block>
             <start_answer_date>2016-09-29 17:02:48.504 JST</start_answer_date>
             <end_answer_date>2016-09-29 17:02:48.504 JST</end_answer_date>
          </answer>
          <answer>
             <question_id>question_3</question_id>
             <answer_block>
                <answer_id>question_3_answer_1</answer_id>
                <next_enquete_id>enquete_12</next_enquete_id>
                <answer_string>question_1_アンサー_1</answer_string>
             </answer_block>
             <start_answer_date>2016-09-29 17:02:48.504 JST</start_answer_date>
             <end_answer_date>2016-09-29 17:02:48.504 JST</end_answer_date>
          </answer>
       </answer_list>
       <start_answer_data_date>2016-09-29 17:02:48.502 JST</start_answer_data_date>
       <end_answer_data_date>2016-09-29 17:02:48.504 JST</end_answer_data_date>
    </answerData>
