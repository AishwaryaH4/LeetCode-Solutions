class Solution {
    public double angleClock(int hour, int minutes) {
        final double minuteAngle = minutes * 6;
        final double hourAngle = (hour % 12) * 30 + minutes * 0.5;

        final double diff = Math.abs(hourAngle - minuteAngle);
        return Math.min(diff, 360 - diff);
    }
}