const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let [N, M] = input[0].split(" ").map(Number);
let map = new Map();
for (let i = 1; i <= N; i++){
  map.set(i, input[i]);
  map.set(input[i], i);
}

let ans=[];
for (let i = N+1; i < input.length; i++){
  let inp = input[i];
  if (/[0-9]/.test(inp)) {
    ans.push(map.get(Number(inp)));
  } else {
    ans.push(map.get(inp));
  }
}
console.log(ans.join("\n"));


