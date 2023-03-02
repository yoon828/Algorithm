const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let [N, M] = input[0].split(" ");
let arr = input[1].split(" ").map(val=>parseInt(val));
arr.sort((a,b)=>a-b);
let low = 0;
let high = arr[arr.length-1];

while(low<=high){
  let mid = Math.floor((low+high)/2);
  let sum=0;
  for(let i=0; i<N; i++){
    if(mid<arr[i]){
      sum+=arr[i]-mid;
    }
  }
  if(sum===M){
    break;
  }else if(sum < M ){
    high = mid-1;
  }else{
    low = mid+1;
  }
}
console.log(high)