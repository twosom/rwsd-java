package com.icloud;

import com.icloud.model.Document;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DocumentManagementSystemTest {
    public static final String LETTER = "patient.letter";
    private DocumentManagementSystem system = new DocumentManagementSystem();

    @Test
    void should_import_file() throws IOException {
        system.importFile(getPathString(LETTER));
        final Document document = onlyDocument();
//        assertAttributeEquals(document, Attributes.PATH.toString(), LETTER);
    }

    private void assertAttributeEquals(
            final Document document,
            final String attributeName,
            final String expectedValue) {
        assertEquals(expectedValue, document.getAttribute(attributeName), "Document has the wrong value for " + attributeName);
    }

    private Document onlyDocument() {
        final List<Document> documents = system.contents();
        assertEquals(documents.size(), 1);
        return documents.get(0);
    }

    private String getPathString(final String resource) {
        return Objects.requireNonNull(getClass().getClassLoader()
                        .getResource(resource))
                .getPath();

    }
}