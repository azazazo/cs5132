package Lab4.Q4;

import java.util.Arrays;

public class FourColor {

    int[][] map;

    enum Color {NONE, RED, YELLOW, GREEN, BLUE}

    Color NONE = Color.NONE;
    Color[] mapColors = {NONE, NONE, NONE, NONE, NONE, NONE, NONE};


    void createMap() {
        map = new int[7][];
        map[0] = new int[]{1, 4, 2, 5};
        map[1] = new int[]{0, 4, 6, 5};
        map[2] = new int[]{0, 4, 3, 6, 5};
        map[3] = new int[]{2, 4, 6};
        map[4] = new int[]{0, 1, 6, 3, 2};
        map[5] = new int[]{2, 6, 1, 0};
        map[6] = new int[]{2, 3, 4, 1, 5};
    }

    boolean explore(int country, Color color) {
        if (!okToColor(country, color)) return false;
        mapColors[country] = color;
        if (!Arrays.asList(mapColors).contains(NONE)) return true;
        for (int neighbour: map[country]) {
            if (mapColors[neighbour] == NONE) {
                for (Color c: Color.values()) {
                    if (c == NONE) continue;
                    if (explore(neighbour, c)) return true;
                }
            }
        }
        return false;
    }

    boolean okToColor(int country, Color color) {
        for (int neighbour: map[country]) {
            if (mapColors[neighbour] == color) return false;
        }
        return true;
    }

    void printMap() {
        for (int i = 0; i < mapColors.length; i++) {
            System.out.println("map[" + i + "] is " + mapColors[i]);
        }
    }


    public static void main(String[] args) {
        FourColor m = new FourColor();
        m.createMap();
        boolean result = m.explore(0, Color.RED);
        System.out.println(result);
        m.printMap();

    }
}
