package se.hernebring.day4;

public record RangePair(int leftMin, int leftMax, int rightMin, int rightMax) {

    public static RangePair parseRanges(String pair) {
        String[] ranges = pair.split(",");
        String[] numbers = ranges[0].split("-");
        int min1 = Integer.parseInt(numbers[0]);
        int max1 = Integer.parseInt(numbers[1]);
        numbers = ranges[1].split("-");
        int min2 = Integer.parseInt(numbers[0]);
        int max2 = Integer.parseInt(numbers[1]);
        return new RangePair(min1, max1, min2, max2);
    }

    public int leftLength() {
        return leftMax - leftMin;
    }

    public int rightLength() {
        return rightMax - rightMin;
    }
}
