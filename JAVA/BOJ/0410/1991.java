package ps;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
    static class Node{
        int num, left, right;
        Node(int num, int left, int right){
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }
    static int N;
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];
        for(int i=0; i<N; i++){
            String[] tokens = br.readLine().split(" ");
            int num = (int)(tokens[0].charAt(0)-'A');
            int left = -1; int right = -1;
            if(!tokens[1].equals(".")){
             left = (int)(tokens[1].charAt(0)-'A');
            }
            if(!tokens[2].equals(".")){
             right = (int)(tokens[2].charAt(0)-'A');
            }
            nodes[num] = new Node(num, left, right);
        }
        //전위 순회
        System.out.println(preFix(nodes[0].num));
        //중위 순회
        System.out.println(middleFix(nodes[0].num));
        //후위 순회
        System.out.println(postFix(nodes[0].num));
    }
    static String preFix(int num){
        if(num == -1) return "";
        return  (char)(num+'A') + preFix(nodes[num].left) + preFix(nodes[num].right);
    }
    static String middleFix(int num){
        if(num == -1) return "";
        return middleFix(nodes[num].left) + (char)(num+'A') + middleFix(nodes[num].right);
    }
    static String postFix(int num){
        if(num == -1) return "";
        return postFix(nodes[num].left) + postFix(nodes[num].right) + (char)(num+'A') ;
    }
}

