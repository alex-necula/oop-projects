package com.poo.labvisitor.task1;

import com.poo.labvisitor.task1.document.TextSegment;
import com.poo.labvisitor.task1.visitor.DokuWikiVisitor;
import com.poo.labvisitor.task1.visitor.MarkDownVisitor;

import java.util.List;

/**
 * Uses visitors to parse documents and provide dokuwiki and markdown outputs.
 */
public final class WikiGenerator {

    private final List<TextSegment> textSegments;

    public WikiGenerator(final List<TextSegment> textSegments) {
        this.textSegments = textSegments;
    }

    public StringBuilder getDokuWikiDocument() {
        DokuWikiVisitor dokuWikiVisitor = new DokuWikiVisitor();
        for (var segment : textSegments) {
            segment.accept(dokuWikiVisitor);
        }
        return dokuWikiVisitor.getDocument();
    }

    public StringBuilder getMarkdownDocument() {
        MarkDownVisitor markDownVisitor = new MarkDownVisitor();
        for (var segment : textSegments) {
            segment.accept(markDownVisitor);
        }
        return markDownVisitor.getDocument();
    }
}
