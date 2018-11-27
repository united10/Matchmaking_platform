package com.stackroute.tokenizer.service;

import edu.stanford.nlp.ling.CoreLabel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StopWordRemoval {

    public  List<String> removeStopWords(List<String> words){

        int k=0,i=0,j;
        ArrayList<String> wordsList = new ArrayList<>();
        String sCurrentLine;
        List<String> stopwords = new ArrayList<>();
        StringBuilder output=new StringBuilder();
        try {
            FileReader fr = new FileReader("/home/cgi/NlpPipeline/src/main/resources/stopwords.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((sCurrentLine = br.readLine()) != null) {
                stopwords.add(sCurrentLine);
                k++;
            }


            for (String word:words) {

                if(stopwords.contains(word)){
                    words.remove(i);
                    i--;
                }
                i++;
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return words;

    }

}
