package de.szut.mylists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MyArrayListTest
{
    private MyArrayList arrayList;
    @BeforeEach
    public void setup()
    {
        arrayList = new MyArrayList();
    }

    private void addValuesToArrayList(Integer[] values)
    {
        for (Integer value : values)
        {
            arrayList.add(value);
        }
    }

    @Test
    public void testSizeEmptyList()
    {
        assertThat(arrayList.size()).isZero();
    }

    @Test
    public void testSizeListWith5Values()
    {
        Integer[] values = {15, 20, 25, 30, 35};
        addValuesToArrayList(values);
        assertThat(arrayList.size()).isEqualTo(5);
    }

    @Test
    public void testSizeWith10Values()
    {
        Integer[] values = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        addValuesToArrayList(values);
        assertThat(arrayList.size()).isEqualTo(10);
    }

    @Test
    public void testAdd1ValueToList()
    {
        arrayList.add(5);
        assertThat(arrayList.size()).isEqualTo(1);
        assertThat(arrayList.get(0)).isEqualTo(5);
    }

    @Test
    public void testAdd15ValuesToList()
    {
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        addValuesToArrayList(values);
        assertThat(arrayList.size()).isEqualTo(15);
        assertThat(arrayList.get(12)).isEqualTo(values[12]);
    }

    @Test
    public void testRemoveFromOutsideOfPossibleIndexes()
    {
        Integer[] values = {5, 7, 6, 9, 5};
        addValuesToArrayList(values);
        assertThat(arrayList.size()).isEqualTo(5);
        arrayList.remove(8);
        assertThat(arrayList.size()).isEqualTo(5);
        arrayList.remove(-23);
        assertThat(arrayList.size()).isEqualTo(5);
    }

    @Test
    public void testRemoveFromList()
    {
        Integer[] values = {5, 7, 6, 9, 5};
        addValuesToArrayList(values);
        assertThat(arrayList.size()).isEqualTo(5);
        arrayList.remove(1);
        assertThat(arrayList.size()).isEqualTo(4);
        arrayList.remove(3);
        assertThat(arrayList.size()).isEqualTo(3);
    }

    @Test
    public void testGetWithOutOfBoundsIndex()
    {
        Integer[] values = {5, 7, 6, 9, 5};
        addValuesToArrayList(values);
        assertThat(arrayList.get(7)).isEqualTo(-Integer.MAX_VALUE);
        assertThat(arrayList.get(-3)).isEqualTo(-Integer.MAX_VALUE);
    }

    @Test
    public void testGetFromArrayList()
    {
        Integer[] values = {5, 7, 6, 9, 5};
        addValuesToArrayList(values);
        assertThat(arrayList.get(2)).isEqualTo(6);
        assertThat(arrayList.get(4)).isEqualTo(5);
        assertThat(arrayList.get(0)).isEqualTo(5);
    }

    @Test
    public void testContainsWithValidValue()
    {
        Integer[] values = {5, 7, 6, 9, 5};
        addValuesToArrayList(values);
        assertThat(arrayList.contains(5)).isTrue();
        assertThat(arrayList.contains(9)).isTrue();
    }

    @Test
    public void testContainsWithInvalidValue()
    {
        Integer[] values = {5, 7, 6, 9, 5};
        addValuesToArrayList(values);
        assertThat(arrayList.contains(-1)).isFalse();
        assertThat(arrayList.contains(10)).isFalse();
    }
}

