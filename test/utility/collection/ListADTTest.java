package utility.collection;

import flyweight.Diamond;
import flyweight.GoldNugget;
import flyweight.Ruby;
import flyweight.T;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListADTTest {
    //Arrange
    ArrayList<T> myList = new ArrayList<T>();

    @BeforeEach
    public void clearTheEntireArrayList(){
        //Arrange
        //Act
        myList.clear();
        //Assert
        assertEquals(0, myList.size());
    }
    @Test
    public void addElementToArrayList(){
        //Arrange
        T element = new Diamond();
        //Act
        myList.add(element);
        //Assert
        assertEquals(1, myList.size());
    }

    @Test
    public void addMultipleElementsToArrayList(){
        //Arrange
        T element1 = new Diamond();
        T element2 = new Ruby();
        T element3 = new GoldNugget();
        //Act
        myList.add(element1);
        myList.add(element3);
        myList.add(element2);
        //Assert
        assertEquals(3, myList.size());
    }

    @Test
    public void addElementToArrayListInSpecificPosition(){
        //Arrange
        T element1 = new Diamond();
        T element2 = new Ruby();
        T element3 = new GoldNugget();
        T element4 = new GoldNugget();
        //Act
        myList.add(element1);
        myList.add(element3);
        myList.add(element2);
        myList.add(2, element4);
        //Assert
        assertEquals("GoldNugget", myList.get(2).getName());
    }

    @Test
    public void setElementInArrayList(){
        //Arrange
        T element1 = new Diamond();
        T element2 = new Ruby();
        T element3 = new GoldNugget();
        T element4 = new GoldNugget();
        //Act
        myList.add(element1);
        myList.add(element3);
        myList.add(element2);
        myList.set(0, element4);
        //Assert
        assertEquals("GoldNugget", myList.get(0).getName());
    }

    @Test
    public void sizeOfArrayList(){
        //Arrange
        T element1 = new Diamond();
        T element2 = new Ruby();
        T element3 = new GoldNugget();
        T element4 = new GoldNugget();
        T element5 = new Diamond();
        T element6 = new Ruby();
        T element7 = new Ruby();
        T element8 = new GoldNugget();
        //Act
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        myList.add(element5);
        myList.add(element6);
        myList.add(element7);
        myList.add(element8);
        //Assert
        assertEquals(8, myList.size());
    }

    @Test
    public void emptyArrayList(){
        //Arrange
        //Act
        //Assert
        assertEquals(true, myList.isEmpty());
    }

    /*@Test
    public void fullArrayList(){
        //Arrange
        int DEFAULT_CAPACITY = 5;
        T[] list;
        ArrayList<T> newArrayList = new ArrayList<T>();
        list = (T[]) new Object[DEFAULT_CAPACITY];

        T element1 = new Diamond();
        T element2 = new Ruby();
        T element3 = new GoldNugget();
        T element4 = new GoldNugget();
        T element5 = new Diamond();
        T element6 = new Ruby();
        //Act
        /*myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        myList.add(element5);
        myList.add(element6);


        list[list.length] = element1;
        list[list.length] = element2;
        list[list.length] = element3;
        list[list.length] = element4;
        list[list.length] = element5;
        if (list.length == 5){
            System.out.println("Full");
        }
        ArrayList<T> newArrayList =
        //Assert
        //assertEquals("Full");
    }
     */

    @Test
    public void containsArrayList(){
        //Arrange
        T element1 = new Diamond();
        T element2 = new Ruby();
        T element3 = new GoldNugget();
        T element4 = new GoldNugget();
        //Act
        myList.add(element1);
        myList.add(element3);
        myList.add(element2);
        myList.add(element4);
        //Assert
        assertEquals(true, myList.contains(element3));
    }

    @Test
    public void removeElementFromArrayList(){
        //Arrange
        T element1 = new Diamond();
        T element2 = new Ruby();
        T element3 = new GoldNugget();
        T element4 = new GoldNugget();
        //Act
        myList.add(element1);
        myList.add(element3);
        myList.add(element2);
        myList.add(element4);
        myList.remove(element2);
        //Assert
        assertEquals(false, myList.contains(element2));
    }

    @Test
    public void removeElementFromArrayListInSpecifiedIndex(){
        //Arrange
        T element1 = new Diamond();
        T element2 = new Ruby();
        T element3 = new GoldNugget();
        T element4 = new GoldNugget();
        //Act
        myList.add(element1);
        myList.add(element3);
        myList.add(element2);
        myList.add(element4);
        myList.remove(1);
        //Assert
        assertEquals(false, myList.contains(element3));
    }


    @Test
    public void indexOfElementInArrayList(){
        //Arrange
        T element1 = new Diamond();
        T element2 = new Ruby();
        T element3 = new GoldNugget();
        T element4 = new GoldNugget();
        //Act
        myList.add(element1);
        myList.add(element3);
        myList.add(element2);
        myList.add(element4);
        //Assert
        assertEquals(2, myList.indexOf(element2));
    }

    @Test
    public void getElementInSpecifiedIndexInArrayList(){
        //Arrange
        T element1 = new Diamond();
        T element2 = new Ruby();
        T element3 = new GoldNugget();
        T element4 = new GoldNugget();
        //Act
        myList.add(element1);
        myList.add(element3);
        myList.add(element2);
        myList.add(element4);
        //Assert
        assertEquals("Ruby", myList.get(2).getName());
    }
}
