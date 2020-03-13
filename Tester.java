import java.util.Iterator;

public class Tester {
    public static void main(String[] args) {
        LinkedList l = new LinkedList(); // create a new linked list object

        System.out.println("Is l empty? "+l.isEmpty());

        l.addFirst("KeyThree"); // add a couple nodes, using addFirst and addLast
        l.addFirst("KeyTwo");
        l.addLast("KeyThree");
        l.addLast("KeyFour");
        l.addFirst("KeyOne");

        System.out.println("Is l empty? "+l.isEmpty());

        System.out.println("These are all the items in the list in order: ");
        Iterator i = l.iterator();
        while(i.hasNext()){
            System.out.println("Item:" + i.next());
        }

        System.out.println("Does l contain 'KeyThree'? " + l.contains("KeyThree"));
        System.out.println("Does l contain 'KeyThee'? " + l.contains("KeyThee"));

        System.out.println("The first element of l is " + l.getFirst());
        System.out.println("The last element of l is " + l.getLastKey());

        l.delete("KeyThree"); // delete the all items with key 'KeyThree'
        System.out.println("Does l still contain 'KeyThree'? " + l.contains("KeyThree"));

        System.out.println("These are all the items in the list in order: ");
        i = l.iterator();
        while(i.hasNext()){
            System.out.println("Item:" + i.next());
        }
    }
}
