package com.learning.treesandgraphs;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void shouldReturnTreeSize() {
        //Given
        var expectedSize = 7;
        BinaryTree binaryTree = createBinaryTree();
        //Then
        assertEquals(expectedSize, binaryTree.getSize());
    }

    @Test
    public void shouldReturnTrueWhenCheckingExistingValueUsingDeepSearch() {
        //Given
        var searchValue = 4;
        BinaryTree binaryTree = createBinaryTree();
        //When
        boolean containsValue = binaryTree.containsValueDeepSearch(searchValue);
        //Then
        assertTrue(containsValue);
    }

    @Test
    public void shouldReturnFalseWhenValueNotExistsUsingDeepSearch() {
        //Given
        var searchValue = 100;
        BinaryTree binaryTree = createBinaryTree();
        //When
        boolean containsValue = binaryTree.containsValueDeepSearch(searchValue);
        //Then
        assertFalse(containsValue);
    }

    @Test
    public void shouldReturnTrueWhenCheckingExistingValueUsingBreadthSearch() {
        //Given
        var searchValue = 4;
        BinaryTree binaryTree = createBinaryTree();
        //When
        boolean containsValue = binaryTree.containsValueBreadthSearch(searchValue);
        //Then
        assertTrue(containsValue);
    }

    @Test
    public void shouldReturnFalseWhenValueNotExistsUsingBreadthSearch() {
        //Given
        var searchValue = 100;
        BinaryTree binaryTree = createBinaryTree();
        //When
        boolean containsValue = binaryTree.containsValueBreadthSearch(searchValue);
        //Then
        assertFalse(containsValue);
    }

    @Test
    public void shouldReturnTrueWhenDeletingExistingValue() {
        //Given
        var value = 4;
        BinaryTree binaryTree = createBinaryTree();
        //When
        binaryTree.printNumbersInOrder();
        binaryTree.deleteNode(value);
        //Then
        assertFalse(binaryTree.containsValueDeepSearch(value));
    }

    private BinaryTree createBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addValue(6);
        binaryTree.addValue(4);
        binaryTree.addValue(8);
        binaryTree.addValue(3);
        binaryTree.addValue(5);
        binaryTree.addValue(7);
        binaryTree.addValue(9);
        return binaryTree;
    }

    @Nested
    class PrintNumbersTest {

        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final PrintStream originalOut = System.out;

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outContent));
        }

        @AfterEach
        public void tearDown() {
            System.setOut(originalOut);
        }

        @Test
        public void shouldPrintNumbersInOrder() {
            //Given
            BinaryTree binaryTreeTest = new BinaryTreeTest().createBinaryTree();
            var expectedPrintOrder = "3 4 5 6 7 8 9 ";
            //When
            binaryTreeTest.printNumbersInOrder();
            //Then
            assertEquals(expectedPrintOrder, outContent.toString());
        }

        @Test
        public void shouldPrintInPreOrder() {
            //Given
            var expectedPrintOrder = "6 4 3 5 8 7 9 ";
            BinaryTree binaryTree = new BinaryTreeTest().createBinaryTree();
            //When
            binaryTree.printNumbersInPreOrder();
            //Then
            assertEquals(expectedPrintOrder, outContent.toString());
        }

        @Test
        public void shouldPrintInPostOrder() {
            //Given
            var expectedPrintOrder = "3 5 4 7 9 8 6 ";
            BinaryTree binaryTree = new BinaryTreeTest().createBinaryTree();
            //When
            binaryTree.printNumbersInPostOrder();
            //Then
            assertEquals(expectedPrintOrder, outContent.toString());
        }
    }
}