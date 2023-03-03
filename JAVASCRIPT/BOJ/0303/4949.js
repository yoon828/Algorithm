const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let arrays = input.map(line=>line.split("").filter(val=>val==="("||val===")"||val==="["||val==="]"));
let res=[];
arrays.slice(0, arrays.length-1).map(arr=>{
  let stack = []; // 1이면 ( 2이면 [
  let ans = "yes";
  for(let i=0; i<arr.length; i++){
    let el = arr[i];
    if(el ==="("||el ==="[") stack.push(el);
    else if(stack.length>0){
      if((el===")" && stack[stack.length-1]==="(")
      || (el==="]" && stack[stack.length-1]==="["))stack.pop();
      else{
        ans = "no";
        break;
      }
    }else{
      ans = "no";
      break;
    }
  }
  if(stack.length>0) ans ="no";
  res.push(ans);
})

console.log(res.join("\n")); 
