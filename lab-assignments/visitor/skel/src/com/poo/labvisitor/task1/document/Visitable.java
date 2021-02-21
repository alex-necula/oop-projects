package com.poo.labvisitor.task1.document;

import com.poo.labvisitor.task1.visitor.DocumentVisitor;

public interface Visitable {
    void accept(DocumentVisitor documentVisitor);
}
