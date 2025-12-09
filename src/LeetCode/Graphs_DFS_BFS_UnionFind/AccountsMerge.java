package LeetCode.Graphs_DFS_BFS_UnionFind;

import java.util.*;

class AccountsMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // Build the graph
        for (List<String> account : accounts) {
            String name = account.getFirst();

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);

                graph.putIfAbsent(email, new HashSet<>());
                if (i == 1) {
                    continue;  // first is assumed unique
                }
                graph.get(email).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(email);
            }
        }

        // DFS to find connected components
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> component = new ArrayList<>();
                dfs(email, graph, visited, component);

                Collections.sort(component);
                component.addFirst(emailToName.get(email));
                result.add(component);
            }
        }

        return result;
    }

    private static void dfs(String email, Map<String, Set<String>> graph,
                            Set<String> visited, List<String> component) {
        visited.add(email);
        component.add(email);

        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("Mary", "mary@mail.com"),
                List.of("John", "johnnybravo@mail.com")
        );

        List<List<String>> res = accountsMerge(accounts);
        System.out.println(res);
    }
}
