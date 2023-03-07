const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let [N, K] = input[0].split(" ").map(val=>parseInt(val));
let ans=[];
let cnt=0;
for(let i=1; ans.length!==N; i++){
  if(i>N) {i=0; continue;}
  if(!ans.includes(i)) cnt++;
  if(cnt === K){
    ans.push(i);
    cnt=0;
  }
}
console.log("<".concat(ans.join(", ").concat(">")));