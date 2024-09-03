package programmers.Kit.Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 베스트앨범 {

    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> cntMap = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            if(!music.containsKey(genres[i])) {
                cntMap.put(genres[i], plays[i]);

                HashMap<Integer, Integer> map = new HashMap<>(); // idx, plays
                map.put(i, plays[i]);
                music.put(genres[i], map);
            } else {
                cntMap.put(genres[i], cntMap.get(genres[i]) + plays[i]);
                music.get(genres[i]).put(i, plays[i]);
            }
        }

        ArrayList<String> genArr = new ArrayList(cntMap.keySet());
        Collections.sort(genArr, (s1, s2) -> cntMap.get(s2) - cntMap.get(s1));

        for(String s : genArr) {
            // System.out.println(s);
            HashMap<Integer, Integer> map = new HashMap(music.get(s));
            ArrayList<Integer> arr = new ArrayList(map.keySet());
            Collections.sort(arr, (s1, s2) -> map.get(s2) - map.get(s1));

            answer.add(arr.get(0));
            if(arr.size() > 1) answer.add(arr.get(1));
        }

        return answer;
    }
}
