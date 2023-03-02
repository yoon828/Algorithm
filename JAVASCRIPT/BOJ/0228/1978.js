const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().trim().split(/\r\n|\r|\n/);
const input = fs
  .readFileSync("input.txt")
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

// const isPrime = (val) => {
//   if (val === 1) return false;
//   for (let i = 2; i < Math.sqrt(val); i++) {
//     if (val % i === 0) return false;
//   }
//   return true;
// };

// let ans = input[1]
//   .split(" ")
//   .map((val) => isPrime(Number(val)))
//   .filter((val) => val);
// console.log(ans.length);

let prime = new Array(1001).fill(true); //true면 소수
for (let i = 0; i < prime.length; i++) {
  if (i < 2) {
    prime[i] = false;
    continue;
  }
  for (let j = 2; j <= Math.sqrt(i); j++) {
    if (i % j === 0) {
      prime[i] = false;
      break;
    }
  }
}

let cnt = 0;
input[1].split(" ").forEach((val) => {
  if (prime[val]) cnt++;
});

console.log(cnt);
