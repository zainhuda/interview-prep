class Solution {
    // check the 4^4 possibilities of time and find smallest one
    public String nextClosestTime(String time) {
        // read time into an array of ints
        int hours = 60*Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3));
        int targetTime = hours + minutes;
        int elapsed = 24*60;
        int answerTime = targetTime; // if nothing then this is closest time
        HashSet<Integer> possibilities = new HashSet<>();
        for (char t: time.toCharArray()) {
            if (t != ':') {
                possibilities.add(t - '0');
            }
        }

        for (int hour1:possibilities) for (int hour2: possibilities) {
            if (hour1*10 + hour2 < 24) {
                for (int min1:possibilities) for (int min2: possibilities) {
                    if (min1*10 + min2 < 60) {
                        int currentTime = 60*(hour1*10+hour2) + (min1*10+min2);
                        int currentElapsed = Math.floorMod(currentTime - targetTime, 24*60);
                        if (0 < currentElapsed && currentElapsed < elapsed) {
                            answerTime = currentTime;
                            elapsed = currentElapsed;
                        }
                    }
                }
            }
        }
        return String.format("%02d:%02d", answerTime / 60, answerTime % 60);
    }
}
