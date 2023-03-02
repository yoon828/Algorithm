const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let T = parseInt(input.shift());

//0층부터, 1호부터
//0층 i호는 i명 거주
let ans=[];
for(let tc = 0; tc<T; tc++){
  let k = parseInt(input.shift());//층
  let n = parseInt(input.shift());//호
  let arr = []; //아파트 
  //0층
  let tmp=[];
  for(let i =1; i<=14; i++){
    tmp.push(i);
  }
  arr.push(tmp);
  for(let i =1; i<=k ;i++){
    //i는 층
    let floor = [];
    for(let j=1; j<=n ;j++){ //j는 호
      floor.push(arr[i-1].slice(0,j).reduce((pre, cur)=>pre+cur));
    }
    arr.push(floor);
  }
  ans.push(arr[k][n-1]);
}
console.log(ans.join("\n"));
