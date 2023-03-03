const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let arr = [...input];
let ans=[]
while(true){
  let lengths = input.shift().split(" ").map(val=>parseInt(val));
  if(lengths[0]+lengths[1]+lengths[2]===0) break;
  lengths.sort((a,b)=>a-b);
  if(lengths[0]**2 + lengths[1]**2 === lengths[2]**2) ans.push("right");
  else ans.push("wrong");
}
console.log(ans.join("\n"));


