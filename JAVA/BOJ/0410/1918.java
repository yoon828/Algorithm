package ps;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(postFix(br.readLine()));
    }

    static String postFix(String eq){
        String[] tokens = eq.split("");
        StringBuilder sb = new StringBuilder();
        Stack<String> ops = new Stack<>();
        for(int i=0;i<eq.length(); i++){
            String tk = tokens[i];
            if(tk.equals("(")) { //괄호 시작
                ops.push(tk);
            }else if(tk.equals(")")){
                while(!ops.peek().equals("(")){
                    sb.append(ops.pop());
                }
                ops.pop();
            }else if(tk.equals("*")||tk.equals("/")){
                if(ops.isEmpty()) ops.push(tk);
                else{
                    String tmp = ops.peek();
                    if(tmp.equals("*")||tmp.equals("/")){
                        sb.append(ops.pop());
                    }
                    ops.push(tk);
                }
            }else if(tk.equals("+")||tk.equals("-")){
                if(ops.isEmpty()) ops.push(tk);
                else{
                    while(!ops.isEmpty()){
                        if(ops.peek().equals("(")) break;
                        sb.append(ops.pop());
                    }
                    ops.push(tk);
                }
            }else{
                sb.append(tk);
            }
        }
        while(!ops.isEmpty()){
            sb.append(ops.pop());
        }
        return sb.toString();
    }
}

