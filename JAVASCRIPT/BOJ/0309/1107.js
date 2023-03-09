const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);


let N = Number(input.shift());
let M = Number(input.shift());
let brokenBtn = [];
let avail = Array.from({length:10},(_,idx)=>idx);
if(M>0){
  brokenBtn = input.shift().split(" ").map(Number);
  avail = avail.filter(v=>!brokenBtn.includes(v));
}
let cur=100;
let min = Math.abs(cur-N);
let result = [];

//n자리수 만들기 - 중복 순열
function combi(cur, n){
  if(cur===n){
    let num = Number(result.join(""));
    min = Math.min(min, n+Math.abs(num-N));
    return;
  } 
  for(let i=0; i<avail.length; i++){
    result[cur] = avail[i];
    combi(cur+1, n);
  }
}
if(min===0) console.log(0); 
else{
  for(let i=1; i<7; i++){ //자리수
    if(min < i) break;
    combi(0,i);
  }
  console.log(min);
}