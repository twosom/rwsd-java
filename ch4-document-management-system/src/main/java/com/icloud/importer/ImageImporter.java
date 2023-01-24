package com.icloud.importer;

import com.icloud.model.Document;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static com.icloud.Attributes.*;

public class ImageImporter implements Importer {

    @Override
    public Document importFile(final File file) throws IOException {
        final var attributes = new HashMap<String, String>();
        attributes.put(PATH.toString(), file.getPath());

        final BufferedImage image = ImageIO.read(file);
        attributes.put(WIDTH.toString(), String.valueOf(image.getWidth()));
        attributes.put(HEIGHT.toString(), String.valueOf(image.getHeight()));
        attributes.put(TYPE.toString(), "IMAGE");

        return new Document(attributes);
    }
}
