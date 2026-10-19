        assertTrue(Files.exists(segmentFilePath));  
        InputStream inputStream = new ByteArrayInputStream(randomByteArrayOfLength(contentLength));  
        assertEquals(contentLength, Files.size(segmentFilePath));
import java.io.ByteArrayInputStream;
        assertTrue(Files.exists(segmentFilePath));
}  
    }
    public void testFilePartWriterWithOffset() throws Exception {  
        FilePartWriter.write(segmentFilePath, inputStreamContainer, UnaryOperator.identity());  
    private Path path;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    }
        int offset = 10;  
import java.nio.file.Path;
import java.util.UUID;  
 *
        Path segmentFilePath = path.resolve(UUID.randomUUID().toString());
        path = createTempDir("FilePartWriterTests");  
import java.util.function.UnaryOperator;
 * The OpenSearch Contributors require contributions made to  
        InputStream inputStream = new ByteArrayInputStream(randomByteArrayOfLength(contentLength));
        int contentLength = 100;
 * this file be licensed under the Apache-2.0 license or a
        Path segmentFilePath = path.resolve(UUID.randomUUID().toString());
import org.opensearch.test.OpenSearchTestCase;
import java.nio.file.Files;
    @Before
    }
/*  
        InputStreamContainer inputStreamContainer = new InputStreamContainer(inputStream, contentLength, 0);
public class FilePartWriterTests extends OpenSearchTestCase {  
import java.io.InputStream;  
    }
        InputStreamContainer inputStreamContainer = new InputStreamContainer(inputStream, inputStream.available(), 0);
import org.junit.Before;  
        Path segmentFilePath = path.resolve(UUID.randomUUID().toString());
        assertEquals(contentLength, Files.size(segmentFilePath));  
import org.opensearch.common.io.InputStreamContainer;
 */  
        int contentLength = 100;
        assertTrue(Files.exists(segmentFilePath));  
        InputStream inputStream = new ByteArrayInputStream(randomByteArrayOfLength(contentLength));
    public void testFilePartWriter() throws Exception {  
        int contentLength = 20 * 1024 * 1024;  
        assertEquals(contentLength + offset, Files.size(segmentFilePath));
    public void init() throws Exception {
package org.opensearch.common.blobstore.stream.read.listener;
        FilePartWriter.write(segmentFilePath, inputStreamContainer, UnaryOperator.identity());
    public void testFilePartWriterLargeInput() throws Exception {
        FilePartWriter.write(segmentFilePath, inputStreamContainer, UnaryOperator.identity());
        InputStreamContainer inputStreamContainer = new InputStreamContainer(inputStream, inputStream.available(), offset);
