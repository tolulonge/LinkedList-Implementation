package com.example.linkedlistimplementation

import java.lang.IndexOutOfBoundsException

class SinglyLinked<E> {
    private var size = 0
    private var head : Node<E>? = null
    private var tail : Node<E>? = null

    private inner class Node<E>(internal var element : E, internal var next : Node<E>?)

    fun getSize() = size

    // Inserting a node at the 0th index
    fun addFirst(element : E){
       linkHead(element)
    }

    // Inserting a node at the last Index
    fun addLast(element: E){
        val t = tail
        val newNode = Node(element,null)
        tail = newNode
        if (t == null){
            head = newNode
        }else{
            t.next = newNode
        }
        size++
    }

    // Inserting a node at a given Index
    fun add(index : Int, element: E) : Int{
        try {
            validatePositionIndex(index)
        }catch (ex: IndexOutOfBoundsException){
            return index
        }
       if (index == 0)linkHead(element)
        else{
            var h = head
            val prevIndex = index - 1
           for (i in 0..prevIndex){
               h = h!!.next
           }
           val nextNode = h!!.next
           val newNode = Node(element,nextNode)
           h.next = newNode
           size++
        }
        return index
    }

    // Fetch a value from the first or last node
    fun getFirst() = head?.element
    fun getLast() = tail?.element

    // Fetching the value at a given index
    fun get(index: Int) : E?{
        try {
            validateElementIndex(index)
        }catch (ex: IndexOutOfBoundsException){
            return null
        }
        var h = head
        for (i in 0..index){
            h = h!!.next
        }
        return h!!.element
    }

    // Updating a node at a given index
    fun set(index: Int, element: E) : E? {
        try {
            validateElementIndex(index)
        }catch (ex: IndexOutOfBoundsException){
            return element
        }
            validateElementIndex(index)
        var h = head
        for (i in 0 until index){
            h = h!!.next
        }
        val oldVal = h!!.element
        h.element = element
        return oldVal
    }

    //Clearing the list
    fun clear(){
        var h = head
        while (h!=null){
           val next = h.next
            h.next = null
            h = next
        }
        tail = null
        head = tail
        size = 0
    }

    private fun linkHead(element: E){
        val h = head
        val newNode = Node(element,h)
        head = newNode
        if (h == null){
            tail = newNode
        }
        size++
    }

    private fun validatePositionIndex(index: Int) {
        if (index < 0 || index > size){
            throw IndexOutOfBoundsException("Index: $index Size: $size")
        }
    }

    private fun validateElementIndex(index: Int){
        if (index < 0 || index >= size){
            throw IndexOutOfBoundsException("Index: $index Size: $size")
        }
    }
}



