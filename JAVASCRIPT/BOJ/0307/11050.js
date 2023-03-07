const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let [N,K] = input.shift().split(" ").map(val=>parseInt(val));

function fact(num) {
  if(num<2) return num;
  return num * fact(num-1);
}

if(K===0||K===N) console.log(1);
else console.log(Math.floor(fact(N)/(fact(K)*fact(N-K))));