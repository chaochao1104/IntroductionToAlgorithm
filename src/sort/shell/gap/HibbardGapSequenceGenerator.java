package sort.shell.gap;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUNAL4 on 12/20/13.
 */
public class HibbardGapSequenceGenerator implements GapSequenceGenerator {

    /**
     *
     * @param size
     * @return 1, 3, 7,.., 2^k - 1
     */
    public int[] generateGapSequences(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("size should be larger than 2.");
        }

        final int len = (int) (Math.log(size) / Math.log(2));
        int[] gapSequence = new int[len];

        gapSequence[0] = 1;
        for (int i = 1; i < len; i++)  {
            gapSequence[i] = gapSequence[i - 1] * 2 + 1;
        }

        return gapSequence;
    }

    @Test
    public void testGenerateGapSequences() {
        GapSequenceGenerator gapSeqGenerator = new HibbardGapSequenceGenerator();
        int[] gapSeq = gapSeqGenerator.generateGapSequences(15);
        Assert.assertEquals(3, gapSeq.length);
        Assert.assertEquals(1, gapSeq[0]);
        Assert.assertEquals(3, gapSeq[1]);
        Assert.assertEquals(7, gapSeq[2]);

        gapSeq = gapSeqGenerator.generateGapSequences(10);
        Assert.assertEquals(3, gapSeq.length);
        Assert.assertEquals(1, gapSeq[0]);
        Assert.assertEquals(3, gapSeq[1]);
        Assert.assertEquals(7, gapSeq[2]);

        gapSeq = gapSeqGenerator.generateGapSequences(100);
        Assert.assertEquals(6, gapSeq.length);
        Assert.assertEquals(1, gapSeq[0]);
        Assert.assertEquals(3, gapSeq[1]);
        Assert.assertEquals(7, gapSeq[2]);
        Assert.assertEquals(15, gapSeq[3]);
        Assert.assertEquals(31, gapSeq[4]);
        Assert.assertEquals(63, gapSeq[5]);

        gapSeq = gapSeqGenerator.generateGapSequences(101);
        Assert.assertEquals(6, gapSeq.length);
        Assert.assertEquals(1, gapSeq[0]);
        Assert.assertEquals(3, gapSeq[1]);
        Assert.assertEquals(7, gapSeq[2]);
        Assert.assertEquals(15, gapSeq[3]);
        Assert.assertEquals(31, gapSeq[4]);
        Assert.assertEquals(63, gapSeq[5]);

    }
}
