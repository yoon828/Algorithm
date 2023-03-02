const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = parseInt(input[0]);

for(let i=1; i<=N; i++){
  if(i==N) {
    console.log(0);
    break;
  }
  let sum=i;
  sum+= String(i).split("").reduce((pre, cur)=>pre + parseInt(cur), 0);
  if(sum===N){
    console.log(i);
    break;
  }
}
