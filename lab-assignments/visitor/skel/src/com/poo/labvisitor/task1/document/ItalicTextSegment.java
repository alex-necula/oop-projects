package com.poo.labvisitor.task1.document;

import com.poo.labvisitor.task1.visitor.DocumentVisitor;

public final class ItalicTextSegment extends TextSegment {

    public ItalicTextSegment(final String content) {
        super(content);
    }

    @Override
    public void accept(final DocumentVisitor documentVisitor) {
        documentVisitor.visit(this);
    }
}
