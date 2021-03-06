/**
 * UnsealTheSafe Problem from TopCoder
 * https://community.topcoder.com/stat?c=problem_statement&pm=4471
 */
public class UnsealTheSafe {
    // Lookup for all adjacent keys to specified key
    private static int[][] adjacentKeyLookup = new int[][]{
            new int[]{7},           // 0
            new int[]{2, 4},        // 1
            new int[]{1, 3, 5},     // 2
            new int[]{2, 6},        // 3
            new int[]{1, 5, 7},     // 4
            new int[]{2, 4, 6, 8},  // 5
            new int[]{3, 5, 9},     // 6
            new int[]{0, 4, 8},     // 7
            new int[]{5, 7, 9},     // 8
            new int[]{6, 8}         // 9
    };

    private static long NO_CACHED_VALUE = -1L;

    long[][] comboLookup;

    public long countPasswords(int N) {
        initComboLookup(N);

        long totalCombos = 0L;
        for (int firstKey = 0; firstKey <= 9; firstKey++) {
            totalCombos += countPasswordCombos(N - 1, firstKey);
        }
        return totalCombos;
    }

    private long countPasswordCombos(int N, int key) {
        if (N == 0) {
            return 1L;
        } else {
            long cachedCombos = getCachedCombos(N, key);
            if (cachedCombos != NO_CACHED_VALUE) {
                return cachedCombos;
            }

            long calculatedCombos = 0L;
            int[] adjacentKeyList = getAdjacentKeys(key);
            for (int nextKey : adjacentKeyList) {
                calculatedCombos += countPasswordCombos(N - 1, nextKey);
            }
            setCachedCombos(N, key, calculatedCombos);
            return calculatedCombos;
        }
    }

    private void initComboLookup(int N) {
        comboLookup = new long[N][10];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                comboLookup[i][j] = NO_CACHED_VALUE;
            }
        }
    }

    long getCachedCombos(int N, int key) {
        return comboLookup[N - 1][key];
    }

    void setCachedCombos(int N, int key, long combos) {
        comboLookup[N - 1][key] = combos;
    }

    int[] getAdjacentKeys(int key) {
        return adjacentKeyLookup[key];
    }
}
