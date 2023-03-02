class Solution {
    public int[] solution(int brown, int yellow) {
        int i=1; //세로길이
        int j = yellow; //가로 길이
        while(i<=j){
            if(i+i+j+j+4 == brown) break;
            i++;
            if(yellow%i != 0) continue;
            j = yellow/i;
        }
        return new int[]{j+2, i+2};
    }
}
