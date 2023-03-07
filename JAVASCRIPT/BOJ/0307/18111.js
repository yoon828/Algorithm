const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let [N,M,B] = input.shift().split(" ").map(Number);
let arr=[];
input.forEach(line=>arr.push(line.split(" ").map(Number)));

let minT = Infinity;
let maxH = 0;
arr=arr.flat();

let min = Math.min(...arr);
let max = Math.max(...arr);
for(let i=max; i>=min; i--){
  let more = 0; 
  let less = 0;
  
  for(let j=0; j<arr.length ; j++){
    let gap = arr[j]-i;
    gap > 0? more+=gap : less += -(gap);
  }
  // forEach로 할 시 시간초과
  // arr.forEach(val=>{
  //   let gap = val-i;
  //   gap > 0? more+=gap : less += -(gap);
  // })

  let inv= B + more-less;
  if(inv<0) continue;

  let time = (more*2 + less);
  if(time < minT){
    minT = time;
    maxH = i;
  }
}
console.log(minT, maxH);