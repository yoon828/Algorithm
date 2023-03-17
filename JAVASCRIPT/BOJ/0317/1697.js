const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

const [N, K] = input[0].split(" ").map(Number); 

function solution(n) {
  if(K <= n ){
    return n-K;
  }
  const dp = Array.from({ length: 100001 }, (_, idx) => Math.abs(idx - n));
  for (let i = n + 1; i <= K; i++){
    if(i%2){
      dp[i] =  1 + Math.min(dp[i-1], dp[Math.floor((i+1)/2)]+1); 
    }else{
      dp[i]= 1+ Math.min(dp[Math.floor(i/2)], dp[i-1]);
    }
  }
  return dp[K];
}

console.log(solution(N));

