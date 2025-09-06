package Graph;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {

//        int [][] preq = {{0,1}, {1,0}};
//        int[][] preq = {{1,4}, {2,4},{3,1}, {3,2} , {4,3}};
//        int[][] preq = {{2,0}, {1,0},{3,1}, {3,2} , {1,3}};
        int[][] preq = {{1,0}, {0,2},{2,1}};
        int n = 3;
        System.out.println(canFinish(n , preq));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer , List<Integer>> adjList = new HashMap<>();
        Queue <Integer> q = new LinkedList<>();
        for (int[] prerequisite : prerequisites) {
            int key = prerequisite[1];
            int value = prerequisite[0];
            List<Integer> tempList = new ArrayList<>();
            if (adjList.containsKey(key)) {
                tempList = adjList.get(key);
            }
            tempList.add(value);
            adjList.put(key, tempList);
        }

        for ( Map.Entry<Integer , List<Integer>> o : adjList.entrySet()){

            int key = o.getKey();
            List<Integer> value = o.getValue();
            q.addAll(value);
            boolean[] visited = new boolean[numCourses];
            while (! q.isEmpty()){
                int newKey = q.poll();
                if(adjList.containsKey(newKey) && !visited[newKey]) {
                    List <Integer> tempList2 = adjList.get(newKey);
                    q.addAll(tempList2);
                    for (int subject : tempList2){
                        if (subject == key )
                            return false;
//                       visited[subject] = true;
                    }
                    visited[newKey] = true;
                }
            }
        }
        return true;
    }
}
