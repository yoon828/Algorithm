const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

const R = 31;
const M = 1234567891;
const findIdx = 'abcdefghijklmnopqrstuvwxyz'.split("");
let N = parseInt(input[0]);
let hash = 0;
let arr = input[1].split("");
for(let i=0; i<N; i++){
  let mul=1;
  for(let j=1; j<=i; j++){
    mul*=R;
    mul%=M;
  }
  hash+= (findIdx.indexOf(arr[i])+1) * mul;
  hash %= M;
}

console.log(hash);