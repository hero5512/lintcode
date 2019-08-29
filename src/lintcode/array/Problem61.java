package lintcode.array;

public class Problem61 {
    /**
     * @param A:      an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     * [-1,0,1,2,2,2,3,3,3,4,4,4,5,5,6,90,92,93,101]
     */
    public int[] searchRange(int[] A, int target) {
        if (A.length <= 0) {
            return new int[]{-1, -1};
        }
        int start, middle, end;
        start = 0;
        end = A.length - 1;
        int[] bound = new int[2];
        // 查询左边界
        while (start + 1 < end) {
            middle = (start + end) / 2;
            if (A[middle] == target) {
                end = middle;
            } else if (A[middle] < target) {
                start = middle;
            } else {
                end = middle;
            }
        }
        if (A[start] == target) {
            bound[0] = start;
        } else if (A[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        // 查询右边界
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            middle = (start + end) / 2;
            if (A[middle] == target) {
                start = middle;
            } else if (A[middle] < target) {
                start = middle;
            } else {
                end = middle;
            }
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        return bound;
    }

    public static void main(String[] args) {
        Problem61 p = new Problem61();
        int[] input = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] result = p.searchRange(input, 5);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
