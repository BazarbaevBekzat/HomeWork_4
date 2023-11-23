import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> listA = readLinesFromUser(5);

        System.out.println("-------------------------");
        System.out.println("Список A:");
        System.out.println("-------------------------");
        displayList(listA);

        List<String> listB = readLinesFromUser(5);

        System.out.println("--------------------------");
        System.out.println("Список B:");
        System.out.println("--------------------------");
        displayList(listB);

        List<String> listC = mergeLists(listA, listB);

        System.out.println("---------------------------");
        System.out.println("Список C:");
        System.out.println("---------------------------");
        displayList(listC);

        sortListByWordLength(listC);
        System.out.println("------------------------");
        System.out.println("Отсортированный список C:");
        System.out.println("------------------------");
        displayList(listC);
    }

    private static List<String> readLinesFromUser(int count) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        System.out.println("Введите " + count + " строк:");

        for (int i = 0; i < count; i++) {
            System.out.print("Строка " + (i + 1) + ": ");
            lines.add(scanner.nextLine());
        }

        return lines;
    }

    private static void displayList(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static List<String> mergeLists(List<String> listA, List<String> listB) {
        List<String> mergedList = new ArrayList<>();
        Iterator<String> iteratorA = listA.iterator();
        Iterator<String> iteratorB = listB.iterator();

        while (iteratorA.hasNext() || iteratorB.hasNext()) {
            if (iteratorA.hasNext()) {
                mergedList.add(iteratorA.next());
            }
            if (iteratorB.hasNext()) {
                mergedList.add(iteratorB.next());
            }
        }

        return mergedList;
    }

    private static void sortListByWordLength(List<String> list) {
        Collections.sort(list, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }
}
