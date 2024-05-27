import dev.ikeepcalm.algorithms.Algorithm;
import dev.ikeepcalm.algorithms.impls.BubbleSort;
import dev.ikeepcalm.algorithms.impls.ModBubbleSort;
import dev.ikeepcalm.algorithms.impls.ShellSort;
import dev.ikeepcalm.analysis.ArrayGenerator;
import org.junit.jupiter.api.Test;

public class arrayIsSortedProperly {

    @Test
    public void testBubbleSort(){
        Algorithm algorithm = new BubbleSort();
        int[] sorted = algorithm.sort(ArrayGenerator.generateRandomScenario(100));
        assert sorted != null && isSorted(sorted);
    }

    @Test
    public void testModBubbleSort(){
        Algorithm algorithm = new ModBubbleSort();
        int[] sorted = algorithm.sort(ArrayGenerator.generateRandomScenario(100));
        assert sorted != null && isSorted(sorted);
    }

    @Test
    public void testShellSort(){
        Algorithm algorithm = new ShellSort();
        int[] sorted = algorithm.sort(ArrayGenerator.generateRandomScenario(100));
        assert sorted != null && isSorted(sorted);
    }

    boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

}
