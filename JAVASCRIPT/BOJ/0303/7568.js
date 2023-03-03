const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = parseInt(input.shift());
let arr = input.map(per=> per.split(" ").map(val=>parseInt(val)));
let ans=new Array(arr.length).fill(0);
for(let i=0; i<ans.length; i++){
  for(let j=i+1; j<ans.length; j++){
    if(arr[i][0]>arr[j][0] &&arr[i][1]>arr[j][1] ) ans[j]++;
    else if(arr[i][0]<arr[j][0] &&arr[i][1]<arr[j][1]) ans[i]++;
  }
}
ans = ans.map(val=>val+1);
console.log(ans.join(" "));
