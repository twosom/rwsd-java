package com.icloud.importer;

import com.icloud.model.Document;
import com.icloud.model.TextFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.icloud.Attributes.*;

public class ReportImporter implements Importer {

    private static final String NAME_PREFIX = "Patient: ";

    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX, PATIENT.toString());
        textFile.addLines(2, line -> false, BODY.toString());

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE.toString(), "REPORT");
        return new Document(attributes);
    }
}
