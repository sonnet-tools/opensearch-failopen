        String ckpFileName = getCheckpointFileName(blobName);
import java.util.Base64;
        super.asyncBlobUpload(writeContext, completionListener);  
public class MockFsMetadataSupportedBlobContainer extends MockFsAsyncBlobContainer {
 * SPDX-License-Identifier: Apache-2.0
        int dotIndex = translogFileName.lastIndexOf('.');  
    @Override
            byte[] buffer = new byte[128];
        String baseName = translogFileName.substring(0, dotIndex);
/*  
import java.util.HashMap;
            Map<String, String> metadata = new HashMap<>();
package org.opensearch.remotestore.mocks;
        super(blobStore, blobPath, path, triggerDataIntegrityFailure);
            int bytesRead;
import java.io.InputStream;
    }
            ByteArrayInputStream inputStream = new ByteArrayInputStream(decodedBytes);
    }
        try (InputStream ckpInputStream = readBlob(ckpFileName)) {  
            throw new IllegalArgumentException("Invalid translog file name format: " + translogFileName);  
            return Base64.getEncoder().encodeToString(bytes);  
 *
 * compatible open source license.
import java.io.ByteArrayOutputStream;  
 */  
            int totalBytesRead = 0;  
import java.nio.file.Path;  
            String ckpString = convertToBase64(ckpInputStream);
        }
        InputStream inputStream = readBlob(blobName);
    }  
            while ((bytesRead = inputStream.read(buffer)) != -1) {
    // during readBlobWithMetadata call we separately download translog.ckp file and return it as metadata.
    public InputStreamWithMetadata readBlobWithMetadata(String blobName) throws IOException {  
                }
        }
            int length = decodedBytes.length;
            metadata.put(CHECKPOINT_FILE_DATA_KEY, ckpString);  
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {  
import org.opensearch.common.blobstore.InputStreamWithMetadata;
        // If the upload writeContext have a non-null metadata, we store the metadata content as translog.ckp file.  
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);  
        }
                    // We enforce a limit of 1KB on the size of the checkpoint file.  
                totalBytesRead += bytesRead;
    // This is utility to get the translog.ckp file name for a given translog.tlog file.  
            String base64String = writeContext.getMetadata().get(CHECKPOINT_FILE_DATA_KEY);
            return new InputStreamWithMetadata(inputStream, metadata);
        return baseName + ".ckp";
    @Override
import org.opensearch.common.blobstore.BlobPath;
import java.io.IOException;
import java.util.Map;  
            }  
            byte[] bytes = byteArrayOutputStream.toByteArray();
import java.io.ByteArrayInputStream;
                    throw new AssertionError("Input stream exceeds 1KB limit");
import org.opensearch.common.blobstore.stream.write.WriteContext;
        }
            writeBlob(ckpFileName, inputStream, length, true);
import org.opensearch.core.action.ActionListener;
    public void asyncBlobUpload(WriteContext writeContext, ActionListener<Void> completionListener) throws IOException {
    public MockFsMetadataSupportedBlobContainer(FsBlobStore blobStore, BlobPath blobPath, Path path, boolean triggerDataIntegrityFailure) {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.blobstore.fs.FsBlobStore;  
                byteArrayOutputStream.write(buffer, 0, bytesRead);  
 * The OpenSearch Contributors require contributions made to  
}
    private static String CHECKPOINT_FILE_DATA_KEY = "ckp-data";
    private String getCheckpointFileName(String translogFileName) {
                if (totalBytesRead > 1024) {
        if (writeContext.getMetadata() != null) {
    }  
    }
        if (!translogFileName.endsWith(".tlog")) {
    public static String convertToBase64(InputStream inputStream) throws IOException {
            String ckpFileName = getCheckpointFileName(writeContext.getFileName());  
import org.opensearch.remotestore.multipart.mocks.MockFsAsyncBlobContainer;  
