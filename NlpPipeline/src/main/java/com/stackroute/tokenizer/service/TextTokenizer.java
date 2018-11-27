package com.stackroute.tokenizer.service;


import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


public class TextTokenizer {

    public Annotation generateDocument(String input){

        // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution

        Properties props = new Properties();

        props.setProperty("annotators", "tokenize, ssplit, pos, lemma");
        //props.put("regexner.mapping", "/home/cgi/NlpPipeline/src/main/resources/jg-regexner.txt");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // create an empty Annotation just with the given text

        Annotation document = new Annotation(input);

        // run all Annotators on this text

        pipeline.annotate(document);
        return document;

    }

    public List<CoreLabel> tokenizeText(Annotation document) {

        // these are all the sentences in this document

// a CoreMap is essentially a Map that uses class objects as keys and has values with custom types

        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        List<CoreLabel> tokenList=new LinkedList<>();



        for (CoreMap sentence : sentences) {

            // traversing the words in the current sentence

            // a CoreLabel is a CoreMap with additional token-specific methods
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {

                tokenList.add(token);
            }

        }


        return tokenList;
    }
}
