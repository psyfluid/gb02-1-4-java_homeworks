package gb.homework04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Реализуйте очередь с помощью LinkedList со следующими методами: <br/>
 * enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
 */

public class HW04_2 {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        testQueue(queue);
    }

    private static void testQueue(Queue queue) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            enqueue(queue, random.nextInt(100));
        }

        System.out.println("Current queue:");
        System.out.println(queue);
        System.out.printf("First element in queue with deletion: %d\n", dequeue(queue));
        System.out.println("Current queue:");
        System.out.println(queue);
        System.out.printf("First element in queue: %d\n", first(queue));
        System.out.println("Current queue:");
        System.out.println(queue);

    }

    private static void enqueue(Queue queue, int nextInt) {
        queue.add(nextInt);
    }

    private static Integer dequeue(Queue queue) {
        return (Integer) queue.remove();
    }

    private static Integer first(Queue queue) {
        return (Integer) queue.element();
    }
}
