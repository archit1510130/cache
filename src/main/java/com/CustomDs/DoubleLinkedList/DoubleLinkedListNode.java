package com.CustomDs.DoubleLinkedList;

import javax.lang.model.element.Element;

public class DoubleLinkedListNode<E> {

        DoubleLinkedListNode<E> prev;
        DoubleLinkedListNode<E> next;

        E element;

        public DoubleLinkedListNode(E element)
        {
            this.element=element;
            this.prev=null;
            this.next=null;
        }

    
}
