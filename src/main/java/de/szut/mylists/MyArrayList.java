package de.szut.mylists;

public class MyArrayList
{
    private Integer[] array;

    public MyArrayList()
    {
        array = new Integer[10];
    }

    public int size()
    {
        int count = 0;
        for (Integer integer : array)
        {
            if (integer != null)
            {
                count += 1;
            }
            else
            {
                break;
            }
        }
        return count;
    }

    public void add(int value)
    {
        int size = size();
        if (size == array.length)
        {
            Integer[] newArray = new Integer[array.length + 10];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = value;
    }

    public int get(int index)
    {
        if (index < 0 || index > size())
        {
            return -Integer.MAX_VALUE;
        }
        return array[index];
    }

    public void remove(int index)
    {
        if (index < 0 || index > size())
        {
            return;
        }
        // Delete the value
        array[index] = null;
        // put every value after index one to the front.
        //Bsp: [0, 1, 2, 5, 7, null, null, null, null, null]
        // remove(0) -> deletes index 0
        // results in:
        // [1, 2, 5, 7, null, null, null, null, null, null]
        for (int i = index; i < array.length -1; i++)
        {
            array[i] = array[i + 1];
        }
    }

    public boolean contains(int value)
    {
        for (Integer integer : array)
        {
            if (integer == null)
            {
                continue;
            }
            else if (value == integer)
            {
                return true;
            }
        }
        return false;
    }
}
