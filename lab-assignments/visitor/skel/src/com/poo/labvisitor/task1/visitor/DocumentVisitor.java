package com.poo.labvisitor.task1.visitor;

import com.poo.labvisitor.task1.document.BoldTextSegment;
import com.poo.labvisitor.task1.document.ItalicTextSegment;
import com.poo.labvisitor.task1.document.PlainTextSegment;
import com.poo.labvisitor.task1.document.UrlSegment;

public interface DocumentVisitor {
    void visit(ItalicTextSegment italicTextSegment);

    void visit(BoldTextSegment boldTextSegment);

    void visit(UrlSegment urlSegment);

    void visit(PlainTextSegment plainTextSegment);

    StringBuilder getDocument();
}
