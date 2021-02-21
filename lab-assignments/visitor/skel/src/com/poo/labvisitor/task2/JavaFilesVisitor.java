package com.poo.labvisitor.task2;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Counter for java files of a given directory using java.nio API
 */
public final class JavaFilesVisitor extends SimpleFileVisitor<Path> {

    private final ArrayList<Path> javaFiles = new ArrayList<>();

    public ArrayList<Path> getJavaFiles() {
        return javaFiles;
    }

    @Override
    public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) {
        Pattern pattern = Pattern.compile("\\.java|\\.class$");
        Matcher matcher = pattern.matcher(file.toString());
        if (matcher.find()) {
            javaFiles.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
}
