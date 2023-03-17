const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

const [N, M] = input.shift().split(" ").map(Number);
const noh = input.splice(0, N);
const nos = input.splice(0);
let map = new Map();
for (let i = 0; i < N; i++){
  map.set(noh[i], i);  
}
let ans = [];
for (let i = 0; i < M; i++){
  if (map.has(nos[i]) && !ans.includes(nos[i])) { ans.push(nos[i]) };
}
ans.sort();
console.log(ans.length);
console.log(ans.join("\n"));

