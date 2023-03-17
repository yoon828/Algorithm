const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

const N = Number(input.shift());
const arr = input.map((line) => line.split(" ").map(Number));
const ans = [0, 0, 0]; //-1, 0, 1의 개수

function solution(i, j, len) {
  if (!check(i, j, len)) {
    //값이 다르면 9등분해서 재귀
    let m = Math.floor(len / 3);
    for (let p = i; p <i+len; p += m){
      for (let q = j; q <j+ len; q += m){
        solution(p,q, m);
      }
    }
    return;
  }
  ans[arr[i][j] + 1]++;
}

function check(i, j, len) {
  let first = arr[i][j];
  for (let p = i; p < i+len; p++) {
    for (let q = j; q < j+len; q++) {
      if (arr[p][q] !== first) { 
        return false;
      }
    }
  }
  return true;
}

solution(0,0, N);
console.log(ans.join("\n"));

