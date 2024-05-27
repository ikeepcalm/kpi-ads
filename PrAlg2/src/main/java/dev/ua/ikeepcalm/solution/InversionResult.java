package dev.ua.ikeepcalm.solution;

public record InversionResult(int inversions, int index) {
    public static void mergeSortResults(InversionResult[] results, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortResults(results, left, mid);
            mergeSortResults(results, mid + 1, right);
            mergeResults(results, left, mid, right);
        }
    }

    private static void mergeResults(InversionResult[] results, int left, int mid, int right) {
        InversionResult[] merged = new InversionResult[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (results[i].inversions() <= results[j].inversions()) {
                merged[k++] = results[i++];
            } else {
                merged[k++] = results[j++];
            }
        }

        while (i <= mid) {
            merged[k++] = results[i++];
        }

        while (j <= right) {
            merged[k++] = results[j++];
        }

        System.arraycopy(merged, 0, results, left, merged.length);
    }
}
