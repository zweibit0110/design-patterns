package com.deloitte.training.oodesignpatterns.behavioral.visitor;

public interface Visitor {

    int visit(Book book);

    int visit(Fruit fruit);

}
