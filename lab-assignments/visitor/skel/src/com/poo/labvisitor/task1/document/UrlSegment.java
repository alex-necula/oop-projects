package com.poo.labvisitor.task1.document;

import com.poo.labvisitor.task1.visitor.DocumentVisitor;

public final class UrlSegment extends TextSegment {
    private final String url;
    private final String description;

    public UrlSegment(final String url, final String description) {
        super();
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void accept(final DocumentVisitor documentVisitor) {
        documentVisitor.visit(this);
    }
}
