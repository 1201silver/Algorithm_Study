package programmers.Kit.Hash;

import java.util.HashMap;

class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> partcp = new HashMap<>();

        for(String name : participant) {
            if(partcp.containsKey(name)) {
                partcp.put(name, partcp.get(name) + 1);
            } else {
                partcp.put(name, 1);
            }
        }

        for(String name : completion) {
            if(partcp.containsKey(name)) {
                partcp.put(name, partcp.get(name) - 1);
            }
        }

        for(String name : partcp.keySet()) {
            if(partcp.get(name) != 0) answer = name;
        }

        return answer;
    }
}

/*
* ArrayList >> 효율성 통과 X
* HashMap >> 효율성 통과
* */