
class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        while(true){
            if(A.equals(B))break;
            if(answer==A.length()-1) return -1;
            answer++;
            String end = A.substring(A.length()-1);
            A = end.concat(A.substring(0,A.length()-1));
        }
        return answer;
    }
}
