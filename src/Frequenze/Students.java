package Frequenze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Students {
    String student;
    String materia;
    ArrayList<Integer> voti;
    HashMap<String, List<Integer>> materie;
    HashMap<String, HashMap<String, List<Integer>>> bag;

    public Students() {
        voti = new ArrayList();
        materie = new HashMap();
        bag = new HashMap();
    }

    public void addScore(String student, String materia, int voto) {
        voti.add(voto);
        materie.put(materia, voti);
        bag.put(student,materie);
    }

    public double getStudentAverage(String student){

        return 0;
    }

    public  String getTopStudent() {
        int max = 0;
        String top = "";
        for(String student : bag.keySet()){
            for(String materia : bag.get(student).keySet()){
                for(int voto : bag.get(student).get(materia)){
                    if(voto > max){
                        max = voto;
                        top = student;
                    }

                }
            }
        }

        return top;
    }

    public static void main(String[] args) {
        Students s = new Students();
        s.addScore("Alice", "Math", 85);
        s.addScore("Alice", "Math", 90);
        s.addScore("Bob", "Science", 95);

        System.out.println(s.getTopStudent());

    }

}
