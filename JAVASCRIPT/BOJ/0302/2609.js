const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let [N, M] = input[0].split(" ");
let [a, b] =[parseInt(N),parseInt(M)];
while(b!==0){
  let n = a%b;
  a = b;
  b = n; 
}
console.log(a);
console.log(a*Math.floor(N/a)*Math.floor(M/a));

