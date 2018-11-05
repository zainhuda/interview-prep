class Solution {
    // we have an array to keep track of the courses that are prequsities
    // we also have a counter for number of courses that have no prereqs
    // we compare the prereqs we have to the courses that require no prereqs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
        int preqLength = prerequisites.length;
        for (int i = 0; i < preqLength; i++) {
            courses[prerequisites[i][0]]++; //increment to 1 for prereqs
        }
        LinkedList<Integer> courseQ = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (courses[i] == 0) {
                courseQ.add(i);
            }
        }
        int noPreQ = courseQ.size();
        while (!courseQ.isEmpty()) {
            int course = courseQ.remove();
            for (int i = 0; i < preqLength; i++) {
                if (prerequisites[i][1] == course) {
                    courses[prerequisites[i][0]]--;
                    if (courses[prerequisites[i][0]] == 0) {
                        noPreQ++;
                        courseQ.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return noPreQ == numCourses;
    }
}
