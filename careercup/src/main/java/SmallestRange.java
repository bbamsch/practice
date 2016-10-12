import java.util.List;

/**
 * SmallestRange
 * https://careercup.com/question?id=16759664
 * <p>
 * You have k lists of sorted integers. Find the smallest range that includes at least one number from each of the k lists.
 * <p>
 * For example,
 * List 1: [4, 10, 15, 24, 26]
 * List 2: [0, 9, 12, 20]
 * List 3: [5, 18, 22, 30]
 * <p>
 * The smallest range here would be [20, 24] as it contains 24 from list 1, 20 from list 2, and 22 from list 3.
 */
public class SmallestRange {
    public static Range<Integer> smallestRange(List<List<Integer>> lists) {
        return null;
    }
}

class Range<T> {
    private final T start;
    private final T end;

    public Range(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public T getStart() {
        return start;
    }

    public T getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Range<?> range = (Range<?>) o;

        if (start != null ? !start.equals(range.start) : range.start != null) return false;
        return end != null ? end.equals(range.end) : range.end == null;

    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }
}

class Ref {
    private final int listId;
    private final int listIndex;
    private final int value;

    public Ref(int listId, int listIndex, int value) {
        this.listId = listId;
        this.listIndex = listIndex;
        this.value = value;
    }

    public int getListId() {
        return listId;
    }

    public int getListIndex() {
        return listIndex;
    }

    public int getValue() {
        return value;
    }
}
