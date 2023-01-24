package com.icloud.importer;

import com.icloud.model.Document;

import java.io.File;
import java.io.IOException;

public interface Importer {
    Document importFile(File file) throws IOException;

}
