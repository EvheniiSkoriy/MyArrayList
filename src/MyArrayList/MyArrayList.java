package MyArrayList;

import java.util.Collection;

public class MyArrayList<T> implements Cloneable{

    private T[] array;
    private int currentItems;
    private final int MIN_CAPASITY = 10;

    public MyArrayList(){
        array=(T[])new Object[MIN_CAPASITY];
        currentItems=0;
    }

    public MyArrayList(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }else{
            array=(T[])new Object[initialCapacity];
        }
        currentItems=0;
    }


    private void ensureCapacity(int minCapacity){
        T[] arrCopy=(T[]) new Object[minCapacity];
        if(minCapacity > array.length) {
            System.arraycopy(array, 0, arrCopy, 0, array.length);
        }
        array=arrCopy;
    }

    public T get(int index){
        if(index<0 || index >= size()){
            throw new IllegalArgumentException();
        }else{
            return array[index];
        }
    }

    public int size(){
        return currentItems;
    }

    public boolean isEmpty(){
        return currentItems==0;
    }

    public boolean add(T element){
        if(currentItems < array.length){
            array[currentItems]=element;
            currentItems++;
            return true;
        }else{
            ensureCapacity(array.length*2);
            add(element);
            return true;
        }
    }
    public boolean add(int index,T element){
        if(index<0 || index >= size()){
            throw new IllegalArgumentException();
        }
        if(currentItems < array.length){
            System.arraycopy(array,index,array,index+1,size()-index);
            array[index]=element;
            currentItems++;
            return true;
        }else{
            ensureCapacity(array.length*2);
            add(index,element);
            return true;
        }
    }

    public boolean remove(T object) {
        for(int i=0;i<array.length;i++){
            if(array[i].equals(object)){
                if((i+1)==size()){
                    currentItems--;
                }else{
                    System.arraycopy(array,i+1,array,i,size()-1-i);
                    currentItems--;
                }
                break;
            }
        }
        return true;
    }
    public void removeRange(int fromIndex,int toIndex) {
        if((fromIndex < 0 || fromIndex >= size() || toIndex > size() || toIndex < fromIndex)){
            throw new IndexOutOfBoundsException();
        }

        if(fromIndex==0){
            System.arraycopy(array,toIndex+1,array,fromIndex,size()-toIndex-1);
        }else if(toIndex==size()){
            System.arraycopy(array,0,array,fromIndex,fromIndex-1);
        }else{
            System.arraycopy(array,0,array,fromIndex,fromIndex-1);
            System.arraycopy(array,toIndex+1,array,fromIndex,size()-toIndex-1);
        }

        currentItems=size()-(toIndex-fromIndex)-1;

    }
    public boolean remove(int index){
        if(index<0 || index >= size()){
            throw new IllegalArgumentException();
        }

        if((index+1)==size()){
            currentItems--;
            return true;
        } else
            {
                System.arraycopy(array,index+1,array,index,size()-1-index);
                currentItems--;
        return true;
            }
    }
    public T set(int index,T element){
        if(index < 0 || index >= size()) {
            throw new IllegalArgumentException();
        }else{
            array[index]=element;
        }
        return array[index];

    }
    public MyArrayList<T> clone() throws CloneNotSupportedException {
        return (MyArrayList<T>)super.clone();
    }
    public String toString(){
        String sb="[";
        for(int i=0;i<currentItems;i++){
            sb+=" "+array[i]+" ";
        }
        sb+="]";
        return sb;
    }
}
