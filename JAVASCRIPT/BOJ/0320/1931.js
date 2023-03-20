const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

input.shift();

let list = [];
input.forEach(val => {
  let token = val.split(" ").map(Number);
  list.push(token);
})

list.sort((a, b) => {
  if ((a[1]=== b[1])) {
    return a[0] - b[0]; 
  } else return a[1] - b[1];
});
console.log(list)
let ans = 0;
let end = 0; 
list.forEach(meeting => {
  if (end <= meeting[0]) {
    ans++;
    end = meeting[1];
  }
})
console.log(ans);