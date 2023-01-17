package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
/**
  class Symptom instancie un objet de type AnalyticCounter et appel les méthodes de cet objet
 */
public class Symptom {



   public static void main(String[] args) throws Exception{
        // read the file
     AnalyticCounter counter= new AnalyticCounter("./Project02Eclipse/output");
     counter.read();
     counter.count();
     counter.write();




   }

}
