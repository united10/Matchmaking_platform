package com.stackroute.tokenizer.service;

import com.stackroute.tokenizer.domain.Education;
import com.stackroute.tokenizer.domain.Experience;
import com.stackroute.tokenizer.domain.Output;
import com.stackroute.tokenizer.domain.Skills;
import com.stackroute.tokenizer.producer.DataSender;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import org.apache.kafka.common.protocol.types.Field;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ProcessQuery {

    @Autowired
    DataSender dataSender;

    static Tagging tagging;

    /*
     *  Query will be  tokenize and redundant tokens will be removed out.
     */
    public Output tokenizeQuery(String query) {

        Map<String,Double> tokens = DocProcessor.getInstance().performNGramAnalysis(query);
        List<String> inputTokens=Arrays.asList(query.split("\\s+"));
        Output output=null;
        try {
            output=tagProcessTokens(inputTokens,tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    /*
     *  tokens will be tagged and result will be send as output
     */
    public Output tagProcessTokens(List<String> inputTokens,Map<String,Double> tokens) throws IOException {

        Output output = new Tagging().tagProccesedTokens(inputTokens,tokens);

        //sendToKafka(output);
        return output;
    }
    public void sendToKafka(Output output){
        System.out.println("output12 "+output);
        dataSender.postData(output);
    }
}
