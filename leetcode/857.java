class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);
        Queue<Integer> store = new PriorityQueue<>();
        int sumQual = 0;
        double ret = Double.MAX_VALUE;
        for (Worker worker: workers) {
            store.offer(-worker.quality);
            sumQual += worker.quality;
            if (store.size() > K) {
                sumQual += store.poll(); // add because stored as negative
            }
            if (store.size() == K) {
                ret = Math.min(ret, sumQual * worker.ratio());
            }
        }
        return ret;
    }

    public class Worker implements Comparable<Worker> {
        int quality;
        int wage;
        public Worker(int qual, int wage) {
            this.quality = qual;
            this.wage = wage;
        }
        public double ratio() {
            return (double)this.wage/this.quality;
        }
        @Override
        public int compareTo(Worker second) {
            return Double.compare(this.ratio(), second.ratio());
        }
    }
}
