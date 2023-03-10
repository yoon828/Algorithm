const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let T = Number(input.shift());
let dp= new Array(41);
dp[0] = [1,0];
dp[1] = [0,1];
for(let i=2; i<dp.length; i++){
  dp[i] = [dp[i-1][0]+dp[i-2][0], dp[i-1][1]+dp[i-2][1]];
}
let ans = input.map(val=> {
  let v = dp[Number(val)];
  return v[0]+" "+v[1];
});
console.log(ans.join("\n"));