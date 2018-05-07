import java.util.*;

public class HackerRank {
    public static void main(String[] args) {
        String[][] workers = {
                {"1", "F", "7500"},
                {"2", "C", "100","20"},
                {"3", "M", "1,2"},
                {"4", "M", "5"},
                {"5", "C", "100", "10"}
        };

        // build map id -> String of worker
        Map<String, Worker> mapIdToWorker = new HashMap<>();

        // create the object of Worker
        for (String[] worker : workers) {
            mapIdToWorker.put(worker[0], new Worker(worker));
        }

        // create the edges between Worker and Manager
        for (String[] worker : workers) {
            if (worker[1].charAt(0) == 'M') {
                String[] workerIdList = worker[2].split(",");
                for (String e : workerIdList) {
                    Worker manager = mapIdToWorker.get(worker[0]);
                    manager.addWorker(mapIdToWorker.get(e));
                }
            }
        }

        // get salary
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<String, Worker> e : mapIdToWorker.entrySet()) {
            res.add(e.getValue().getSalary());
        }
        System.out.println(res);
    }

    static class Worker {
        private static int NUM_OF_WEEK_YEARLY = 52;
        private String id;
        private boolean isManager;
        private int salary;
        private List<Worker> workers;

        Worker(String[] worker) {
            this.id = worker[0];
            this.isManager = worker[1].charAt(0) == 'M';
            if (worker[1].charAt(0) == 'F') {
                this.salary = Integer.valueOf(worker[2]);
            } else if (worker[1].charAt(0) == 'C'){
                this.salary = Integer.valueOf(worker[2]) * Integer.valueOf(worker[3]) * NUM_OF_WEEK_YEARLY;
            } else {
                this.salary = 0;
                this.workers = new ArrayList<>();
            }
        }

        public void addWorker(Worker w) { this.workers.add(w); }

        public int getSalary() {
            if (isManager)
                for (Worker w: this.workers)
                    this.salary += w.getSalary();
            return this.salary;
        }
    }

}
