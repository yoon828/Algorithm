const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().split(' ');
const input = fs.readFileSync("input.txt").toString().split(" ");

let gap = input[0] - input[1];
if (gap === 7) gap = -1;
else if (gap === -7) gap = 1;
for (let i = 0; i < input.length - 1; i++) {
  let _gap = input[i] - input[i + 1];
  if (_gap === -7 || _gap === 7) continue;
  if (gap !== _gap) {
    console.log("mixed");
    return;
  }
}
if (gap === -1) console.log("ascending");
else console.log("descending");
