const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let T = parseInt(input.shift());
let ans=[];
for(let tc=0; tc<T; tc++){
  let [H,W,N] = input.shift().split(" ").map(val=>parseInt(val));
  let floor = N%H===0? H : N%H;
  let ho = N%H===0 ?  Math.floor(N/H) : Math.floor(N/H)+1;
  ho = ho<10 ?"0"+ho : ho+"";
  ans.push(floor+ho+""); 
}
console.log(ans.join("\n"));
