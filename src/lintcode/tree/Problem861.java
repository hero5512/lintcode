package lintcode.tree;

import java.util.TreeSet;

public class Problem861 {
    /**
     * @param flowers: the place where the flower will open in that day
     * @param k:       an integer
     * @return: in which day meet the requirements
     */
    /**
     * 暴力破解
     *
     * @param flowers
     * @param k
     * @return
     */
//    public int kEmptySlots(int[] flowers, int k) {
//        if (flowers == null || flowers.length == 0 || k >= flowers.length) {
//            return -1;
//        }
//
//        int length = flowers.length;
//
//        boolean[] slots = new boolean[length + 1];
//        for (int i = 0; i < length; i++) {
//            if (isValid(flowers[i], k, slots, length)) {
//                return i + 1;
//            }
//        }
//        return -1;
//    }
//
//    public boolean isValid(int flower, int k, boolean[] slots, int length) {
//        slots[flower] = true;
//        if (flower + k + 1 <= length && slots[flower + k + 1]) {
//            boolean valid = true;
//            for (int i = 1; i <= k; i++) {
//                if (slots[flower + i]) {
//                    valid = false;
//                    break;
//                }
//            }
//            if (valid) {
//                return true;
//            }
//        }
//
//        if (flower - k - 1 >= 1 && slots[flower - k - 1]) {
//            for (int i = 1; i <= k; i++) {
//                if (slots[flower - i]) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> active = new TreeSet();
        int day = 0;
        for (int flower : flowers) {
            day++;
            active.add(flower);
            Integer lower = active.lower(flower);
            Integer higher = active.higher(flower);
            if (lower != null && flower - lower - 1 == k ||
                    higher != null && higher - flower - 1 == k)
                return day;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {3, 9, 2, 8, 1, 6, 10, 5, 4, 7};
        Problem861 p = new Problem861();
        System.out.println(p.kEmptySlots(input, 1));

    }
}
