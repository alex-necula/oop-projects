package com.poo.labvisitor.task1.document;

import com.poo.labvisitor.task1.visitor.DocumentVisitor;

public final class BoldTextSegment extends TextSegment {

    public BoldTextSegment(final String content) {
        super(content);
    }

    @Override
    public void accept(final DocumentVisitor documentVisitor) {
        documentVisitor.visit(this);
    }
}
