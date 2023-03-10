const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let [N,M] = input.shift().split(" ").map(Number);
let arr=Array.from({length:N},()=>[]); //인접 배열
input.forEach(line=>{
  let node = line.split(" ").map(Number);
  arr[node[0]-1].push(node[1]-1);
  arr[node[1]-1].push(node[0]-1);
})

function bfs(num){
  let cnt=new Array(M);
  let needVisit = [];
  let visit = [];
  visit.push(num);
  let level=0;
  needVisit.push({num,level});
  while(needVisit.length!==0){
    let n = needVisit.shift();
    cnt[n.num] = n.level;
    for(let i=0; i<arr[n.num].length; i++){
      if(!visit.includes(arr[n.num][i])){
        needVisit.push({num : arr[n.num][i], level:n.level+1});
        visit.push(arr[n.num][i]);
      }
    }
  }
  return cnt.reduce((pre,cur)=>pre+cur,0);
}

let keven = new Array(N);
for(let i=0; i<N; i++){
  keven[i] = bfs(i);
}
let ans = keven.indexOf(Math.min(...keven));
console.log(ans+1); 