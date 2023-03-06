const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = parseInt(input.shift());
let ans =[];
let que=[];
input.forEach(line=>{
  let tmp = line.split(" ");
  switch(tmp[0]){
    case "push" :
      que.push(parseInt(tmp[1])); break;
    case "pop" :
      if(que.length===0) ans.push(-1);
      else ans.push(que.shift());
      break;
    case "size": 
      ans.push(que.length); break;
    case "empty":
      ans.push(que.length===0? 1: 0); break;
    case "front":
      if(que.length===0) ans.push(-1);
      else ans.push(que[0]);
      break;
    case "back":
      if(que.length===0) ans.push(-1);
      else ans.push(que[que.length-1]);
      break;
  }
});
console.log(ans.join("\n"));