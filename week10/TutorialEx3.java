package week10;

import java.util.LinkedHashMap;

public class TutorialEx3 {
    public static void main(String[] args) {
        // client code
        DataDisplay display = new ChartDisplay();
//    DataDisplay display = new ChartDisplay();
        display.addDataPoint("Group 1", 123);
        display.addDataPoint("Group 2", 456);
        display.addDataPoint("Group 3", 789);
        display.addDataPoint("Group 4", 1000);
        display.addDataPoint("Group 5", 1200);
        display.addDataPoint("Group 6", 800);
        display.display();
    }
}


abstract class DataDisplay {
    // Use LinkedHashMap instead of HashMap to keep insertion order
    protected LinkedHashMap<String, Integer> points;

    public DataDisplay() {
        points = new LinkedHashMap<String, Integer>();
    }

    public void addDataPoint(String groupLabel, int value) {
        points.put(groupLabel, value);
    }

    public abstract void display();
}

class TabularDisplay extends DataDisplay {
    static final String[] HEADERS = {"Group", "Value"};
    static final int COL_WIDTH = 20;
    // the format "%Xs" is used to create a string of at least X characters
    static final String CELL_FORMAT = "%" + COL_WIDTH + "s";
    public void display() {
        // Use a string buffer for better performance
        StringBuffer sb = new StringBuffer();

        // display header
        for (String header : HEADERS) {
            sb.append(String.format(CELL_FORMAT, header));
        }
        // new line
        sb.append("\n");

        // display separator
        for (int i = 0; i < COL_WIDTH * 2; i++) {
            sb.append("_");
        }
        // new line
        sb.append("\n");

        // display data
        for (String group : points.keySet()) {
            String value = String.valueOf(points.get(group).intValue());
            sb.append(String.format(CELL_FORMAT, group));
            sb.append(String.format(CELL_FORMAT, value));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

class ChartDisplay extends DataDisplay {
    static final String HEADER_X = "Group";
    static final String HEADER_Y = "Value";
    static final int X_MAX = 79;
    static final int Y_MAX = 24;

    char[][] displayArea = new char[Y_MAX + 1][X_MAX + 1];

    public ChartDisplay() {
        // all spaces
        for (int row = 0; row < Y_MAX + 1; row++) {
            for (int col = 0; col < X_MAX + 1; col++) {
                displayArea[row][col] = ' ';
            }
        }

        // X coordinate
        for (int col = 0; col < X_MAX + 1; col++) {
            displayArea[0][col] = '_';
        }

        // Y coordinate
        for (int row = 0; row < Y_MAX + 1; row++) {
            displayArea[row][0] = '|';
        }
    }

    public void display() {
        int startX = 1;
        int startY = 1;
        int xChartRange = X_MAX;
        int yChartRange = Y_MAX;
        int numRanges = points.size() - 1;
        int rangeWidth = xChartRange / numRanges;

        int minValue = minValue();
        int maxValue = maxValue();
        int valueRange = maxValue - minValue + 1;

        // put data points to correct positions
        for (String group : points.keySet()) {
            int value = points.get(group).intValue();
            int yValue = (int)((double)(value - minValue) / valueRange * yChartRange);
            yValue += startY;
            displayArea[yValue][startX] = '*';

            // proceed to next group X coordinate
            startX += rangeWidth;
        }

        // display the chart upside down because y coordinate is opposite
        // all spaces
        for (int row = Y_MAX; row >= 0; row--) {
            for (int col = 0; col <= X_MAX; col++) {
                System.out.print(displayArea[row][col]);
            }
            System.out.print("\n");
        }
    }

    private int minValue() {
        Integer[] values = points.values().toArray(new Integer[]{});
        int min = Integer.MAX_VALUE;
        for (int i : values) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    private int maxValue() {
        Integer[] values = points.values().toArray(new Integer[]{});
        int max = Integer.MIN_VALUE;
        for (int i : values) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
}