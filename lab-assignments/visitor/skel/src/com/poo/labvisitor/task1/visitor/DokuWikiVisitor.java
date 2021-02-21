package com.poo.labvisitor.task1.visitor;

import com.poo.labvisitor.task1.document.BoldTextSegment;
import com.poo.labvisitor.task1.document.ItalicTextSegment;
import com.poo.labvisitor.task1.document.PlainTextSegment;
import com.poo.labvisitor.task1.document.UrlSegment;

public final class DokuWikiVisitor implements DocumentVisitor {
    private final StringBuilder document = new StringBuilder();

    @Override
    public void visit(final ItalicTextSegment italicTextSegment) {
        document.append("//").append(italicTextSegment.getContent()).append("//");
    }

    @Override
    public void visit(final BoldTextSegment boldTextSegment) {
        document.append("**").append(boldTextSegment.getContent()).append("**");
    }

    @Override
    public void visit(final UrlSegment urlSegment) {
        document.append("[[").append(urlSegment.getUrl()).append("|")
                .append(urlSegment.getDescription()).append("]]");
    }

    @Override
    public void visit(final PlainTextSegment plainTextSegment) {
        document.append(plainTextSegment.getContent());
    }

    @Override
    public StringBuilder getDocument() {
        return document;
    }
}
