const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = parseInt(input.shift());
let ans =[];
let deq=[];
input.forEach(line=>{
  let tmp = line.split(" ");
  switch(tmp[0]){
    case "push_front" :
      deq.splice(0,0,parseInt(tmp[1])); break;
    case "push_back" :
      deq.push(parseInt(tmp[1])); break;
    case "pop_front" :
      if(deq.length===0) ans.push(-1);
      else ans.push(deq.shift());
      break;
    case "pop_back" :
      if(deq.length===0) ans.push(-1);
      else ans.push(deq.pop());
      break;
    case "size": 
      ans.push(deq.length); break;
    case "empty":
      ans.push(deq.length===0? 1: 0); break;
    case "front":
      if(deq.length===0) ans.push(-1);
      else ans.push(deq[0]);
      break;
    case "back":
      if(deq.length===0) ans.push(-1);
      else ans.push(deq[deq.length-1]);
      break;
  }
});
console.log(ans.join("\n"));