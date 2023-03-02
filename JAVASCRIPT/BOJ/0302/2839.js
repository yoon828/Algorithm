const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = parseInt(input[0]);
let dp=new Array(5001).fill(5000);
dp[3] = 1; dp[5] = 1;
for(let i=3; i<=N; i++){
  dp[i+5] = Math.min(dp[i+5], dp[i]+1);
  dp[i+3] = Math.min(dp[i+3], dp[i]+1);
}
if(dp[N]===5000) console.log(-1);
else console.log(dp[N]);
