'use strict';
const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().split(/\r\n|\r|\n/);
const input = fs
  .readFileSync("input.txt")
  .toString()
  .split(/\r\n|\r|\n/);
let token = input.shift().split(" ");
const N = parseInt(token[0]);
const M = Number(token[1]);
const map = input.map((line) => line.split(""));

let min = 64;
//i,j는 시작 위치
for (let i = 0; i + 8 <= N; i++) {
  for (let j = 0; j + 8 <= M; j++) {
    const cases = ["W", "B"];
    cases.forEach((item) => {
      let start = item;
      let cnt = 0;
      for (let p = 0; p < 8; p++) {
        if (p !== 0) start = start === "B" ? "W" : "B";
        for (let q = 0; q < 8; q++) {
          if (q % 2 === 0 && map[i + p][j + q] !== start) cnt++;
          else if (q % 2 !== 0 && map[i + p][j + q] === start) cnt++;
        }
      }
      min = Math.min(min, cnt);
    });
  }
}
console.log(min);
