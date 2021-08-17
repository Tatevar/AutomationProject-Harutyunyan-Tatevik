import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Collections {
    @Test
    public void test() {
        List<Integer> list = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(0);
            add(-1);
            add(10);
            add(11);
            add(-20);
            add(40);
        }};
        List<Integer> list1 = new ArrayList<>() {{
            addAll(list.stream().filter(data -> data.intValue() > 0).collect(Collectors.toList()));
        }};
        System.out.println(list1);

        List<Integer> list2 = new ArrayList<>() {{
            addAll(list.stream().filter(data -> data.intValue() < 0).collect(Collectors.toList()));
        }};
        System.out.println(list2);

        List<Integer> list3 = new ArrayList<>() {{addAll(list.stream().filter(data->data.intValue() %5 == 0).collect(Collectors.toList()));}};
        System.out.println(list3);

        List<Integer> list4 = new ArrayList<>() {{addAll(list.stream().filter(data->data.intValue() % 10 == 0).collect(Collectors.toList()));}};
        System.out.println(list4);
    }
}


/*
Дополнительное задание
Создать коллекцию [1, 2, 3, 0, -1, 10, 11, -20, 40] 
Отфильтровать коллекцию по следующим критериям : 
	1. все элементы коллекции должны быть больше 0 
	2 .все элементы коллекции должны быть меньше 0 
	3. все элементы коллекции должны быть кратны 5
	4. все элементы коллекции должны быть кратны 10
Результат фильтрации вывести в консоль.

 */
