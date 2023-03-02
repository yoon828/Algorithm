const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().split(/\r\n|\r|\n/);
const input = fs
  .readFileSync("input.txt")
  .toString()
  .split(/\r\n|\r|\n/);
const tokens = input[0].split(" ");
const [x, y, w, h] = tokens;
console.log(Math.min(x, w-x, y, h-y));

