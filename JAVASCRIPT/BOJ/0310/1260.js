const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let [N,M,V] = input.shift().split(" ").map(Number);
let arr=Array.from({length:N+1},()=>[]); //인접 배열
input.forEach(edge=>{
  let ver = edge.split(" ").map(Number);
  arr[ver[0]].push(ver[1]);
  arr[ver[1]].push(ver[0]);
});

arr.forEach(line=>line.sort((a,b)=>a-b));

function bfs(num){
  let visit=[];
  let ans =[];
  let needVisit=[];
  needVisit.push(num);
  visit.push(num);
  while(needVisit.length!==0){
    let num = needVisit.shift();
    ans.push(num);
    for(let i =0; i<arr[num].length; i++){
      if(!visit.includes(arr[num][i])){
        needVisit.push(arr[num][i]); 
        visit.push(arr[num][i]);
      }
    }
  }
  console.log(ans.join(" "));
}

function dfs(num){
  let ans =[];
  let visit=[];
  visit.push(num);
  function fun(n){
    ans.push(n);
    for(let i =0; i<arr[n].length; i++){
      if(!visit.includes(arr[n][i])){
        visit.push(arr[n][i]);
        fun(arr[n][i]);
      }
    }
  }
  fun(num);
  console.log(ans.join(" "));
}

dfs(V);
bfs(V);