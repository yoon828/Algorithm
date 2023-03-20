const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = Number(input.shift());
let arr = input.map(line => line.split("").map(Number));
let ans = [];
let four = [[0, 0], [0, 1], [1, 0], [1, 1]];


function quad(i, j, len) {
  let flag = false;
  let first = arr[i][j];
  outer:for (let p = i; p < i+len; p++){
    for (let q = j; q < j + len; q++) {
      if (arr[p][q] !== first) {
        flag = true;
        break outer;
      }
    }
  }
  if (flag) {
    let halfLen = Math.floor(len / 2);
    ans.push("(");
    for (let k = 0; k < 4; k++){
      quad(i + four[k][0] * halfLen, j + four[k][1] * halfLen, halfLen);
    }
    ans.push(")");
  }else ans.push(first);
}

quad(0, 0, N);
console.log(ans.join(""));