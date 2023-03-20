const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/).map(Number);

const N = input.shift();

//최소힙 구현
class MinHeap{
  constructor() {
    this.heap = [];
  }
  //추가
  insert(val) {
    this.heap.push(val);
    let idx = this.heap.length-1;
    while (idx > 0) {
      let parentIdx = Math.floor((idx-1) / 2);
      if (this.heap[parentIdx] > this.heap[idx]) {
        let tmp = this.heap[idx];
        this.heap[idx] = this.heap[parentIdx];
        this.heap[parentIdx] = tmp;
        idx = parentIdx;
      } else break;
    }
  }

  //삭제
  delete() {
    if (!this.heap.length) return 0;
    let root = this.heap[0];
    let end = this.heap.pop();
    if (this.heap.length) {
      this.heap[0] = end;
      //재정렬하기
      let idx = 0;
      while (true) {
        let leftIdx = idx * 2 + 1;
        let rightIdx = (idx + 1) * 2;
        //변경할 인덱스 세팅
        let changeIdx = leftIdx;
        if (rightIdx < this.heap.length) {
          let m = Math.min(this.heap[leftIdx], this.heap[rightIdx]);
          if (m === this.heap[rightIdx]) changeIdx = rightIdx;
        } else if (leftIdx > this.heap.length) break;
        if (this.heap[idx] > this.heap[changeIdx]) {
          let tmp = this.heap[idx]
          this.heap[idx] = this.heap[changeIdx];
          this.heap[changeIdx] = tmp;
          idx = changeIdx;
        } else break;
      }
    } 
    return root;
  }

}

let ans = [];
let heap = new MinHeap();
input.forEach(val => {
  if (val) {
    heap.insert(val);
  } else {
    ans.push(heap.delete());
  }
})
console.log(ans.join("\n"));