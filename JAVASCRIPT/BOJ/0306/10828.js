const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = parseInt(input.shift());
let ans =[];
let stack=[];
input.forEach(line=>{
  let tmp = line.split(" ");
  switch(tmp[0]){
    case "push" :
      stack.push(parseInt(tmp[1])); break;
    case "pop" :
      if(stack.length===0) ans.push(-1);
      else ans.push(stack.pop());
      break;
    case "size": 
      ans.push(stack.length); break;
    case "empty":
      ans.push(stack.length===0? 1: 0); break;
    case "top":
      if(stack.length===0) ans.push(-1);
      else ans.push(stack[stack.length-1]);
      break;
  }
});
console.log(ans.join("\n"));