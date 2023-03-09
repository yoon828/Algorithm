const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let [N,r,c] = input.shift().split(" ").map(Number);
let four =[[0,0], [0,1],[1,0],[1,1]]; //분할했을 때 각 시작 좌표 구하기
function div(N, start, cnt){
  if(N===1){
    console.log(cnt);
    return;
  }
  let mid = N/2;
  for(let d=3; d>=0; d--){
    let p = start[0]+four[d][0]*mid;
    let q = start[1]+four[d][1]*mid;
    if(p<= r && q <=c){
      div(mid, [p,q], cnt+(mid**2)*d);
      break;
    }
  }
}
div(2**N, [0,0], 0);