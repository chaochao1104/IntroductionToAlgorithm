package sort.shell.gap;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by SUNAL4 on 12/20/13.
 */
public class ShellSort {

    public static void sort(int[] array, GapSequenceGenerator gapSequenceGenerator) {
        int[] gapSequence = gapSequenceGenerator.generateGapSequences(array.length);

        for (int k = gapSequence.length - 1; k > -1; k--) {
            int gap = gapSequence[k];
            for (int i = gap; i < array.length; i = i + gap) {
                for (int j = i; j > 0 && array[j-gap] > array[j]; j = j-gap) {
                    swap(array, j, j-gap);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void testSort() {
        int[] array = {2, 1, 9, 6, 0, 5, 38, 3, 21, 2, 34, 4, 2, 5, 3, 12, 35, 57, 68, 5, 2, 5};
        int[] expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected);

        int[] copy = Arrays.copyOf(array, array.length);
        ShellSort.sort(copy, new OriginalGapSequenceGenerator());
        Assert.assertTrue(arrayEquals(expected, copy));

        copy = Arrays.copyOf(array, array.length);
        ShellSort.sort(copy, new HibbardGapSequenceGenerator());
        Assert.assertTrue(arrayEquals(expected, copy));
    }

    private boolean arrayEquals(int[] a1, int[] a2) {
        if (a1 == a2) {
            return true;
        }

        if (a1 == null || a2 == null) {
            return false;
        }

        if (a1.length != a2.length) {
            return false;
        }

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i])
                return false;
        }

        return true;
    }
}
