package com.icloud.importer;

import com.icloud.model.Document;
import com.icloud.model.TextFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.icloud.Attributes.*;

public class InvoiceImporter implements Importer {
    private static final String NAME_PREFIX = "Dear ";
    private static final String AMOUNT_PREFIX = "Amount: ";

    @Override
    public Document importFile(final File file) throws IOException {
        final TextFile textFile = new TextFile(file);

        textFile.addLineSuffix(NAME_PREFIX, PATIENT.toString());
        textFile.addLineSuffix(AMOUNT_PREFIX, AMOUNT.toString());

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE.toString(), "INVOICE");
        return new Document(attributes);
    }
}
