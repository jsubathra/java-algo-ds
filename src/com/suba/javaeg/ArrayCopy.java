package com.suba.javaeg;

public class ArrayCopy {
    private int items[];
    private int count;

    public ArrayCopy(int length){
        items = new int[length];
    }

    public void print(){
        for(int i=0; i<count;i++) System.out.println(items[i]);
    }

    public void addItem(int addItem){
        items[count++] = addItem;
        if(count == items.length){
            int[] newArray = new int[count*2];
            for(int i=0;i < count;i++){
                newArray[i] = items[i];
            }
            items = newArray;
        }
    }

    public void removeAt(int index){
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        for(int i=index; i<count;i++){
            items[i] = items[i+1];
        }
        count--;
    }

    public int indexOf(int item){
        int realIndex= -1;
        for (int i=0;i<count;i++){
            if(items[i]==item) {
                realIndex = i;
                return realIndex;
            }
        }
        return -1;
    }

    public int lastIndex(int item){
        int realIndex= -1;
        for (int i=0;i<count;i++){
            if(items[i]==item) {
                realIndex = i;
            }

        }
        return realIndex;
    }
}
