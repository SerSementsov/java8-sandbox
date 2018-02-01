package misc;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringOpsTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void testLastIndex() {
        String s = "Initial Margin|SWP|GBP|EOD|-3.00";
        int index = s.lastIndexOf("|") + 1;
        String result = s.substring(index);
        assertEquals("-3.00", result);
    }

    @Test
    public void testMiddle() {
        String s = "AUD|2018-01-09|2018-01-10";
        int from = s.indexOf("|") + 1;
        int to = s.lastIndexOf("|");
        String result = s.substring(from, to);
        assertEquals("2018-01-09", result);
    }

    @Test
    public void testNewIteratorIsReturnedEachTime() {
        List<String> strings = Arrays.asList("1");

        assertEquals("1", strings.iterator().next());
        assertEquals("1", strings.iterator().next());
        assertEquals("1", strings.iterator().next());
        assertEquals("1", strings.iterator().next());
    }


    @Test(expected = NullPointerException.class)
    public void testThatAssignNullToPrimitiveViaUnboxingLeadsToNPE() {
//        expected.expect(NullPointerException.class);
        int i = getSomeIntValue();
    }

    private Integer getSomeIntValue() {
        return null;
    }
}
