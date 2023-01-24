package com.icloud.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.icloud.Attributes.PATH;

public class TextFile {
    private final Map<String, String> attributes;
    private final List<String> lines;

    public TextFile(final File file) throws IOException {
        this.attributes = new HashMap<>();
        this.attributes.put(PATH.toString(), file.getPath());
        try (Stream<String> lines1 = Files.lines(file.toPath())) {
            this.lines = lines1.toList();
        }
    }


    public void addLineSuffix(final String prefix, final String attributeName) {
        lines.stream()
                .filter(line -> line.startsWith(prefix))
                .findFirst()
                .ifPresent(line -> attributes.put(attributeName, line.substring(prefix.length())));
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public int addLines(final int start, final Predicate<String> isEnd, final String attributeName) {
        final StringBuilder accumulator = new StringBuilder();
        int lineNumber;
        for (lineNumber = start; lineNumber < this.lines.size(); lineNumber++) {
            final String line = this.lines.get(lineNumber);
            if (isEnd.test(line)) {
                break;
            }

            accumulator.append(line);
            accumulator.append("\n");
        }
        this.attributes.put(attributeName, accumulator.toString().trim());
        return lineNumber;
    }
}
