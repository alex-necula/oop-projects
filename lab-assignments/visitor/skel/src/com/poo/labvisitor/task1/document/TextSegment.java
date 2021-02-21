package com.poo.labvisitor.task1.document;

import com.poo.labvisitor.task1.visitor.DocumentVisitor;

/**
 * Represents a text segment of a document that needs to be parsed.
 */
public abstract class TextSegment implements Visitable {
    private String content;

    public TextSegment(final String content) {
        this.content = content;
    }

    public TextSegment() {
    }

    public String getContent() {
        return content;
    }

    public abstract void accept(DocumentVisitor documentVisitor);
}
