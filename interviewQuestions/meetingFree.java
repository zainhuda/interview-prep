/*
We are writing a tool to help users manage their calendars. Given an unordered list of times of day when people are busy, write a function that tells us the intervals during the day when ALL of them are available.

Sample input:

p1_meetings = [
  (1230, 1300),
  ( 845, 900),
  (1300, 1500),
]
    
p2_meetings = [
  ( 930, 1200),
  (1515, 1546),
  (1600, 2359),
]

p3_meetings = [
  ( 845, 915),
  (1515, 1545),
  (1235, 1245),
]

schedules1 = [p1_meetings, p2_meetings, p3_meetings]
schedules2 = [p1_meetings, p3_meetings]

Expected output:

findAvailableTime(schedules1)
 => [    0,  845 ],
    [  915,  930 ],
    [ 1200, 1230 ],
    [ 1500, 1515 ],
    [ 1546, 1600 ]

findAvailableTime(schedules2)
 => [    0,  845 ],
    [  915, 1230 ],
    [ 1500, 1515 ],
    [ 1545, 2359 ]

n = number of meetings

*/


import java.io.*;
import java.util.*;

public class Solution {
  public int[][] findAvailableTime(List<int[][]> schedules) {
    // Merge all of these meetings
    // n time
    // n space
    List<int[]> meetings = new ArrayList<>();
    for (int i = 0; i < schedules.size(); i++) {
      int[][] schedule = schedules.get(i);
      for (int [] meeting : schedule) {
        meetings.add(meeting);
      }
    }
    
    // logn
    Collections.sort(meetings, new Comparator<int[]>() {
      @Override 
      public int compare(int[] m1, int[] m2) {
        return m1[0] - m2[0];
      }
    });
    
    // n space
    // n time
    List<int[]> merged = new ArrayList<>();
    merged.add(meetings.get(0));
    for (int i = 1; i < meetings.size(); i++) {
      int[] meeting = meetings.get(i);
      if (meeting[0] <= merged.get(merged.size()-1)[1]) {
        int[] temp = merged.remove(merged.size()-1);
        temp[1] = Math.max(temp[1], meeting[1]);
        merged.add(temp);
      } else {
        merged.add(meeting);
      }
    }
  
    // n time 
    List<int[]> res = new ArrayList<>();
    res.add(new int[] {0, merged.get(0)[0]});
    for (int i = 1; i < merged.size(); i++) {
      if (merged.get(i-1)[1] == merged.get(i)[0]) {
        continue;
      } else {
        int[] temp = new int[] {merged.get(i-1)[1], merged.get(i)[0]};
        res.add(temp);
      }
    }
    if (merged.get(merged.size()-1)[1] < 2359) {
        res.add(new int[] {merged.get(merged.size()-1)[1], 2359});
    }      
    return res.toArray(new int[res.size()][]);
  }
  
  // On time and  O1 space
  public boolean canSlot(int[][] meetings, int start, int end) {
    // logn
    Arrays.sort(meetings, new Comparator<>() {
      @Override 
      public int compare(int[] m1, int[] m2) {
        return m1[0] - m2[0];
      }
    });
    
    // n
    for (int[] meeting : meetings) {
      // Start conflict
      if (meeting[0] <= start && meeting[1] > start) {
        return false;
      }
      // End conflict
      if (meeting[0] < end && meeting[1] >= end) {
        return false;
      }
      // Longer than current meeting conflict
      if (meeting[0] >= start && meeting[1] <= end) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] argv) {
    Solution sol = new Solution();
    int[][] meetings1 = {
        {1230, 1300},
        { 845,  900},
        {1300, 1500}
    };
    int[][] meetings2 = {
        { 930, 1200},
        {1515, 1546},
        {1600, 2359}
    };
    int[][] meetings3 = {
        { 845,  915},
        {1515, 1545},
        {1235, 1245}
    };
  
List<int[][]> schedules1 = Arrays.asList(meetings1, meetings2, meetings3);
List<int[][]> schedules2 = Arrays.asList(meetings1, meetings3);

    
    int[][] res = sol.findAvailableTime(schedules1);
    
    
    for (int i = 0; i < res.length; i++) {
      System.out.println(java.util.Arrays.toString(res[i]));
    }
    
    res = sol.findAvailableTime(schedules2);
    
    for (int i = 0; i < res.length; i++) {
      System.out.println(java.util.Arrays.toString(res[i]));
    }
    

  
    //System.out.println(sol.canSlot(schedules2));

  }
}
