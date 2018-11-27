//package com.stackroute.tokenizer.service;
//
//import com.stackroute.tokenizer.domain.Output;
//import edu.stanford.nlp.ling.CoreLabel;
//import edu.stanford.nlp.pipeline.Annotation;
//
//import java.util.List;
//
//public class TextProcessor {
//
//
//    public List<CoreLabel> getProcessedText(String input){
//        TextTokenizer textTokenizer=new TextTokenizer();;
//        Lemmatization lemmatization=new Lemmatization();
//        StopWordRemoval stopWordRemoval=new StopWordRemoval();
//        Annotation document=textTokenizer.generateDocument(input);
//        System.out.println(document);
//        List<CoreLabel> inputTokens=textTokenizer.tokenizeText(document);
//        System.out.println(inputTokens);
//        List<String> lemmas=lemmatization.lemmatizedTokens(inputTokens);
//        System.out.println(lemmas);
//        List<CoreLabel> processedTokens=stopWordRemoval.removeStopWords(lemmas,inputTokens);
//        System.out.println(processedTokens);
//        return processedTokens;
//    }
//
//
//}
