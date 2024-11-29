class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
       int a[][]  = new int[profits.length][2];
       PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
       for(int i=0;i<profits.length;i++){
           a[i][0]=capital[i];
           a[i][1]=profits[i];
       }
       Arrays.sort(a, Comparator.comparingInt(row -> row[0]));
       int j=0;
       for(int i=1;i<=k;i++){
         for(;j<a.length && a[j][0]<=w;j++){
            pq.offer(a[j][1]);
         }
          if(pq.isEmpty())
          break;
          w=w+pq.poll();
        //   if(a[j][0]<=w){
        //     pq.offer(a[j][1]);
        //   }
       }
       return w;
    }
}