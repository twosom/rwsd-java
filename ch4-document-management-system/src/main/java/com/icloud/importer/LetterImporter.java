package com.icloud.importer;

import com.icloud.model.Document;
import com.icloud.model.TextFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.icloud.Attributes.*;

public class LetterImporter implements Importer {

    private static final String NAME_PREFIX = "Dear ";

    @Override
    public Document importFile(final File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX, PATIENT.toString());
        final int lineNumber = textFile.addLines(2, String::isEmpty, ADDRESS.toString());
        textFile.addLines(lineNumber + 1, line -> line.startsWith("regards"), BODY.toString());

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE.toString(), "LETTER");
        return new Document(attributes);
    }
}
