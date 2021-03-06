package com.example.linkedlistimplementation

import org.junit.Test

import org.junit.Assert.*

class SinglyLinkedTest {


    @Test
    fun addFirst_addsTheFirstElement_returnsTheFirstNodeElement() {
        val linkyList = SinglyLinked<Int>()
        val head = linkyList.addFirst(8)

        val firstNode = linkyList.getFirst()

        assertEquals(8,firstNode)
    }

    @Test
    fun add_addsNodeAtSpecifiedIndex_returnElementAtIndex(){
        val linkyList = SinglyLinked<Int>()
        val head = linkyList.addFirst(10)
        val node1 = linkyList.addLast(5)
        val node2 = linkyList.addLast(9)
        val node3 = linkyList.add(1,7)

        val addedNode = linkyList.get(1)
        assertEquals(7,addedNode)
    }

    @Test
    fun addLast_addsNodeToTheLast_returnTheAddedElement(){
        val linkyList = SinglyLinked<Int>()
        val head = linkyList.addFirst(10)
        val node1 = linkyList.addLast(5)
        val node2 = linkyList.addLast(25)
        val lastNode = linkyList.getLast()

        assertEquals(25,lastNode)
    }

    @Test
    fun set_updatesTheElementOfTheNodeAtIndex_returnsOldValue(){
        val linkyList = SinglyLinked<Int>()
        val head = linkyList.addFirst(10)
        val node1 = linkyList.addLast(5)
        val node2 = linkyList.addLast(9)

        val oldValue = linkyList.set(1,25)
        assertEquals(5,oldValue)
    }

    @Test
    fun clear_removesAllNodeInTheList_returnSizeZero(){
        val linkyList = SinglyLinked<Int>()
        val head = linkyList.addFirst(10)
        val node1 = linkyList.addLast(5)
        val node2 = linkyList.addLast(9)
        val node3 = linkyList.add(1,7)

        linkyList.clear()
        assertEquals(0,linkyList.getSize())

    }

    @Test
    fun get_retrievesElementAtIndex_returnsNullIfInvalidIndex(){
        val linkedIn = SinglyLinked<Int>()
        val head = linkedIn.addFirst(35)
        val node1 = linkedIn.addLast(22)
        val node2 = linkedIn.addLast(10)

        val elementAtIndex = linkedIn.get(1)

        assertEquals(10,elementAtIndex)
        assertEquals(null,linkedIn.get(-7))
    }
    



}