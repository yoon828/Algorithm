const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().trim().split(/\r\n|\r|\n/);
const input = fs
  .readFileSync("input.txt")
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

function solve(str) {
  const arr = [...new Set(str)];
  arr.sort((a, b) => {
    if (a.length === b.length) {
      return a < b ? -1 : 1;
    } else {
      return a.length - b.length;
    }
  });
  return arr.join("\n");
}
let str = input.splice(1, input.length);
console.log(solve(str));
