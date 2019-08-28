import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static class Meeting {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Meeting)) {
                return false;
            }
            final Meeting meeting = (Meeting) o;
            return startTime == meeting.startTime && endTime == meeting.endTime;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + startTime;
            result = result * 31 + endTime;
            return result;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", startTime, endTime);
        }
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {
        // given tuples, overlap them
        // merge meetings ranges
        List<Meeting> sorted = new ArrayList<>();
        for (Meeting meeting: meetings) {
            Meeting copy = new Meeting(meeting.getStartTime(), meeting.getEndTime());
            sorted.add(copy);
        }
        
        // Sorting using comparator need to review!
        Collections.sort(sorted, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                return m1.getStartTime() - m2.getStartTime();
            }
        });
        
        List<Meeting> rets = new ArrayList<>();
        rets.add(sorted.get(0));
        for (Meeting curr : sorted) {
            Meeting merged = rets.get(rets.size()-1);
            if (curr.getStartTime() <= merged.getEndTime()) {
                merged.setEndTime(Math.max(merged.getEndTime(), curr.getEndTime()));
            } else {
                rets.add(curr);
            }
        }
        return rets;
        
    }