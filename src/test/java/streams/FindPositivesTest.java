package streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FindPositivesTest {

    private NumberService numberService;

    @Before
    public void setup() {
        numberService = new NumberServiceImpl();
    }

    @Test
    public void findPositives_findSinglePositiveNumberInTheList() {
        List<Integer> integers = asList(1, -1);
        assertEquals(Collections.singletonList(1), numberService.findPositives(integers));
    }

    @Test
    public void findPositivesTest_findMultiplePositives() {
        List<Integer> integers = asList(1, -1, 2, -2, 0, 3, -3);

        assertThat(asList(3, 2, 1), is(numberService.findPositives(integers)));
    }

    @Test
    public void findPositivesTest_findNoPosititivesInTheListWithoutPositiveIntegers() {
        List<Integer> integers = asList(-1, 0);

        assertEquals(Collections.emptyList(), numberService.findPositives(integers));
    }
}
