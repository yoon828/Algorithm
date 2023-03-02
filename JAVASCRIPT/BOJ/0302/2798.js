const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let [N, M] = input.shift().split(" ")
let arr = input[0].split(" ").map(val=>parseInt(val));
arr.sort((a,b)=>a-b);

let ans=0;
outer:for(let i=0; i<N; i++){
  for(let j =i+1; j<N; j++){
    for(let k = j+1; k<N; k++){
      let sum = arr[i]+arr[j]+arr[k];
      if(sum > M) break;
      if(M-sum < M-ans)  {
        ans = sum;
      }
    }
  }
}
console.log(ans);