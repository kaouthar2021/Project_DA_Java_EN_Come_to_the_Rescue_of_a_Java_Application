package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
/**
 * AnalyticCounter permet de ;
 * lire la liste de symptoms du fichier symptoms.txt et remplir la list symptomsList avec la liste de symptoms
 * calculer le nombre d'occurences et remplir la map symptoms
 * ecrire le contenu de la map dans le fichier output
    */


public class AnalyticCounter {
    private  final  ISymptomReader reader;
    private  final TreeMap<String,Integer> symptoms ;//on peut toujours ajouter un objet
    private   List<String> symptomsList;
    private  final  String  output;
    public AnalyticCounter(String output){
        this.reader=new ReadSymptomDataFromFile("Project02Eclipse\\symptoms.txt");
        this.symptoms=new TreeMap<>();
        this.output= output;


    }
    public  void read(){

        //utiliser reader pour remplir symptoms list avec la liste des symptoms
        this.symptomsList = reader.getSymptoms();
    }
    public  void count() {
        //utiliser symptoms list pour compter et remplir la map de symptoms

      for(String symptom:symptomsList){
          String symptomName = symptom;
          Integer oldValue = symptoms.get(symptomName);
          boolean exist = oldValue !=null;
          if(!exist){
              symptoms.put(symptomName,1);
          }else{
             Integer value =  oldValue +1;
             symptoms.put(symptomName,value);
          }
      }


    }
    public void write() throws IOException {
        //ecrire le contenu de la map dans  le fichier output

        FileWriter fw=new FileWriter(output);
        BufferedWriter bw = new BufferedWriter(fw);
        for(Map.Entry mp:symptoms.entrySet()){
            try {
                bw.write(mp.getKey()+" "+mp.getValue() +  "\n");

            }catch (IOException e){
                e.printStackTrace();
            }
        }


        bw.close();

    }

}
