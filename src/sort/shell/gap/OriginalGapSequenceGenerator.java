package sort.shell.gap;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by SUNAL4 on 12/20/13.
 */
public class OriginalGapSequenceGenerator implements GapSequenceGenerator {

    /**
     *
     * @param size
     * @return [1,..size/4, size/2]
     */
    public int[] generateGapSequences(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size should be larger than 0");
        }

        final int len = (int) (Math.log(size) / Math.log(2));
        int[] gapSeq = new int[len];

        for (int i = 0; i < len; i++)
            gapSeq[len-i-1] =  (size / (int)Math.pow(2, i+1));

        return gapSeq;
    }

    @Test
    public void testGenerateGapSequences() {
        GapSequenceGenerator gapSeqGenerator = new OriginalGapSequenceGenerator();
        int[] gapSeq = gapSeqGenerator.generateGapSequences(15);
        Assert.assertEquals(3, gapSeq.length);
        Assert.assertEquals(1, gapSeq[0]);
        Assert.assertEquals(3, gapSeq[1]);
        Assert.assertEquals(7, gapSeq[2]);

        gapSeq = gapSeqGenerator.generateGapSequences(10);
        Assert.assertEquals(3, gapSeq.length);
        Assert.assertEquals(1, gapSeq[0]);
        Assert.assertEquals(2, gapSeq[1]);
        Assert.assertEquals(5, gapSeq[2]);

        gapSeq = gapSeqGenerator.generateGapSequences(100);
        Assert.assertEquals(6, gapSeq.length);
        Assert.assertEquals(1, gapSeq[0]);
        Assert.assertEquals(3, gapSeq[1]);
        Assert.assertEquals(6, gapSeq[2]);
        Assert.assertEquals(12, gapSeq[3]);
        Assert.assertEquals(25, gapSeq[4]);
        Assert.assertEquals(50, gapSeq[5]);

        gapSeq = gapSeqGenerator.generateGapSequences(101);
        Assert.assertEquals(6, gapSeq.length);
        Assert.assertEquals(1, gapSeq[0]);
        Assert.assertEquals(3, gapSeq[1]);
        Assert.assertEquals(6, gapSeq[2]);
        Assert.assertEquals(12, gapSeq[3]);
        Assert.assertEquals(25, gapSeq[4]);
        Assert.assertEquals(50, gapSeq[5]);
    }
}
