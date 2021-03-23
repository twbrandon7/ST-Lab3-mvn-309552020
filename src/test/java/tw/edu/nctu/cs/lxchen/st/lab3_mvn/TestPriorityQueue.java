package tw.edu.nctu.cs.lxchen.st.lab3_mvn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class TestPriorityQueue {
    @ParameterizedTest
    @MethodSource("getParameters")
    public void parameterizedTest(int[] input, int[] expected) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : input) {
            queue.offer(n);
        }

        for (int n : expected) {
            assertEquals(n, queue.poll());
        }
    }

    private static Stream<Arguments> getParameters() {
        return Stream.of(
                Arguments.of(new int[] {5, 4, 3, 2, 1}, new int[] {1 ,2, 3, 4, 5}),
                Arguments.of(new int[] {1, 2, 7, 3, 5}, new int[] {1, 2, 3, 5, 7}),
                Arguments.of(new int[] {9, 1, 8, 3, 2}, new int[] {1, 2, 3, 8, 9}),
                Arguments.of(new int[] {5, 5, 2, 0, 2}, new int[] {0, 2, 2, 5, 5}),
                Arguments.of(new int[] {3, 0, 9, 5, 5}, new int[] {0, 3, 5, 9, 5})
        );
    }

    @Test
    public void classCastExceptionTest() {
        PriorityQueue queue = new PriorityQueue();
        queue.offer(3);
        assertThrows(ClassCastException.class, ()->{
            queue.add("String");
        });
    }

    @Test
    public void nullPointerExceptionTest() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        assertThrows(NullPointerException.class, ()->{
            queue.add(null);
        });
    }

    @Test
    public void illegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, ()->{
            new PriorityQueue<>(0);
        });
    }
}