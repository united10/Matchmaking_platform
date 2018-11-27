package com.stackroute.tokenizer.service;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;

import java.util.LinkedList;
import java.util.List;

public class Lemmatization {

    public List<String> lemmatizedTokens(List<CoreLabel> tokens){

        List<String> lemmas=new LinkedList<>();
        for(CoreLabel token:tokens){

               String lemma=token.get(CoreAnnotations.LemmaAnnotation.class);
                lemmas.add(lemma);
        }
       return lemmas;

    }


}
