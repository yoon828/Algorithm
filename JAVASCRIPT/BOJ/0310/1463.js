const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N= Number(input.shift());
let dp=Array.from({length:N+1},()=>Number.MAX_VALUE);

let list = [];
list.push(N);
dp[N] = 0;
while(list.length!==0){
  let num = list.shift();
  if(num%3===0 && dp[parseInt(num/3)]> dp[num]+1){
    list.push(parseInt(num/3));
    dp[parseInt(num/3)] = dp[num]+1;
  }
  if(num%2===0 && dp[parseInt(num/2)]> dp[num]+1){
    list.push(parseInt(num/2));
    dp[parseInt(num/2)] = dp[num]+1;
  }
  if(num-1>=1 && dp[num-1]> dp[num]+1){
    list.push(num-1);
    dp[num-1] = dp[num]+1;
  }
}
console.log(dp[1]);



