class Solution {
    class Tuple {
        double val;
        String chr;
        public Tuple(double val, String chr) {
            this.val = val;
            this.chr = chr;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, HashSet<Tuple>> graph = new HashMap<>();
        Set<String> chars = new HashSet<>();
        for (int i = 0; i < equations.size(); i++) {
            chars.add(equations.get(i).get(0));
            chars.add(equations.get(i).get(1));
            graph.putIfAbsent(equations.get(i).get(0), new HashSet<>());
            graph.putIfAbsent(equations.get(i).get(1), new HashSet<>());
            graph.get(equations.get(i).get(0)).add(new Tuple(values[i], equations.get(i).get(1)));
            graph.get(equations.get(i).get(1)).add(new Tuple(1/values[i], equations.get(i).get(0)));
        }
        // now we do the good old DFS 
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if (!chars.contains(queries.get(i).get(0)) || !chars.contains(queries.get(i).get(1))) {
                res[i] = -1.0;
            } else if (queries.get(i).get(0) == queries.get(i).get(1)) {
                res[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, graph, visited);
            }
        }
        return res;
    }
    public double dfs(String start, String end, double result, Map<String, HashSet<Tuple>> graph, Set<String> visited) {
        // Had to fix this part of the DFS, only needed to see if we have visited the string before
        if (visited.contains(start)) return -1.0;
        if (start.equals(end)) return result;
        visited.add(start);
        
        double val = -1.0;
        for (Tuple group : graph.get(start)) {
            if (!visited.contains(group.chr)) {
                val = dfs(group.chr, end, result*group.val, graph, visited);
                if (val != -1.0) break;
            }
        }
        return val;
    }
}