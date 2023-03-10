const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let T = Number(input.shift());
let cabages =[];
let move =[[0,1],[0,-1],[1,0],[-1,0]];
let map;
let N, M;
let ans=[];

function dfs(i,j){
  map[i][j] = false; //방문 체크
  for(let d=0; d<4; d++){
    let p = i+move[d][0];
    let q = j+move[d][1];
    if(p>=0 && p<N && q>=0 && q<M &&
        map[p][q]){
      dfs(p,q);
    }
  }
}
for(let tc = 1; tc <= T; tc++){
  cabages = [];
  let info = input.shift().split(" ").map(Number);
  [M,N] = info;
  let K = info[2];
  map= new Array(N-1);
  for(let i=0; i<N; i++){
    map[i] = new Array(M-1).fill(false);
  }
  for(let i=0; i<K; i++){
    let [X,Y]=input.shift().split(" ").map(Number);
    map[Y][X] = true;
    cabages.push([Y,X]);
  }
  let cnt=0;
  while(cabages.length!==0){
    let [i,j] = cabages.shift();
    if(map[i][j]){
      cnt++;
      dfs(i,j);
    }
  }
  ans.push(cnt);
}
console.log(ans.join("\n"));

