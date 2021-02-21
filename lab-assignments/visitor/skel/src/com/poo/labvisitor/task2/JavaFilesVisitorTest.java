package com.poo.labvisitor.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class JavaFilesVisitorTest {
    private JavaFilesVisitorTest() { }

    public static void main(final String[] args) {
        // moved main to another class because of error
        // "non static field cannot be referenced from a static context"

        Path startingDir = Paths.get(".");
        JavaFilesVisitor filesVisitor = new JavaFilesVisitor();

        try {
            Files.walkFileTree(startingDir, filesVisitor);
            for (var file : filesVisitor.getJavaFiles()) {
                System.out.println(file + " (" + Files.size(file) + "bytes)");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
