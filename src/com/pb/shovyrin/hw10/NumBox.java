package com.pb.shovyrin.hw10;

public class NumBox<T extends Number> {
    private T[] array;
    private int countFill = 0;

    public NumBox(int size) {
        this.array = (T[]) new Number[size];
    }

    public void add(int i, T num) {
        try {
            this.array[i] = num;
            this.countFill++;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив переполнен не возможно добавить элемент");
        }
    }

    public T get(int index) {
        try {
            return this.array[index];
        } catch (IndexOutOfBoundsException ex) {
            throw new ArrayIndexOutOfBoundsException("Индекс вне массива");
        }
    }

    public int length() {
        return this.array.length;
    }

    public double average() throws Exception {
        if(this.countFill == 0){
            throw new Exception("Массив пуст, заполните его вначале");
        }
        double average = 0F;
        for (T num : array) {
            if (num instanceof Integer) {
                average += num.intValue();
            }
            if (num instanceof Double) {
                average += num.doubleValue();
            }
            if (num instanceof Float) {
                average += num.floatValue();
            }
        }
        return average / this.array.length;
    }

    public double sum() {
        double sum = 0;
        for (T num : array) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public T max() throws Exception {
        if(this.countFill == 0){
            throw new Exception("Массив пуст, заполните его вначале");
        }
        T max = this.get(0);
        for (int i = 0; i < this.length(); i++) {
            if (this.array[i].doubleValue() > max.doubleValue()) {
                max = this.get(i);
            }
        }
        return max;
    }

    public String getArrayString(){
        StringBuilder str = new StringBuilder();
        for(T num: this.array){
            str.append(num.toString() + " ");
        }
        return str.toString();
    }
}
