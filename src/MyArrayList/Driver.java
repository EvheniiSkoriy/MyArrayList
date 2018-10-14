package MyArrayList;

public class Driver {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyArrayList<String> list=new MyArrayList<String>();
        System.out.println("Is empty: "+list.isEmpty());
        System.out.println("Add objects:a,b,c,d,e,g");
        list.add(new String("a"));
        list.add(new String("b"));
        list.add(new String("c"));
        list.add(new String("d"));
        list.add(new String("e"));
        list.add(new String("g"));


        showList(list);
        System.out.println("size = "+list.size());
        System.out.println("Is empty: "+list.isEmpty());
        System.out.println("--------------------");
        System.out.println("Set the 2 element as Wolf");
        list.set(2,"Wolf");
        showList(list);
        System.out.println("size = "+list.size());
        System.out.println("--------------------");
        System.out.println("REMOVE RANGE(2,4)");
        list.removeRange(2,4);
        showList(list);
        System.out.println("size = "+list.size());
        System.out.println("--------------------");
        System.out.println("Remove object b");
        list.remove("b");
        showList(list);
        System.out.println("--------------------");
        System.out.println("Remove at index 1");
        list.remove(1);
        showList(list);
        System.out.println("--------------------");
        System.out.println("Clone of arrayList");
        MyArrayList<String> cloneList=list.clone();
        showList(cloneList);
        System.out.println("size = "+cloneList.size());
        System.out.println("--------------------");
        System.out.println("Add new 4 elements");
        list.add(new String("o"));
        list.add(new String("h"));
        list.add(new String("j"));
        list.add(new String("k"));
        showList(list);
        System.out.println("size = "+list.size());
        System.out.println("--------------------");
        System.out.println("Add element Mouse to position 3");
        list.add(3,"Mouse");
        showList(list);
        System.out.println("size = "+list.size());
        System.out.println("--------------------");

    }
    public static void showList(MyArrayList<String> l){
        for(int i=0;i<l.size();i++){
            System.out.println("get "+i+": "+ l.get(i));
        }

    }
}
