            writeBlob(ckpFileName, inputStream, length, true);
                if (totalBytesRead > 1024) {
    private String getCheckpointFileName(String translogFileName) {
import java.util.Base64;
            throw new IllegalArgumentException("Invalid translog file name format: " + translogFileName);  
    // This is utility to get the translog.ckp file name for a given translog.tlog file.  
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);  
}
            Map<String, String> metadata = new HashMap<>();
            }  
        }
        int dotIndex = translogFileName.lastIndexOf('.');  
            String ckpFileName = getCheckpointFileName(writeContext.getFileName());  
            return Base64.getEncoder().encodeToString(bytes);  
    // during readBlobWithMetadata call we separately download translog.ckp file and return it as metadata.
        String ckpFileName = getCheckpointFileName(blobName);
                byteArrayOutputStream.write(buffer, 0, bytesRead);  
 * this file be licensed under the Apache-2.0 license or a
        }
            metadata.put(CHECKPOINT_FILE_DATA_KEY, ckpString);  
 * SPDX-License-Identifier: Apache-2.0
                totalBytesRead += bytesRead;
 * The OpenSearch Contributors require contributions made to  
import java.util.HashMap;
public class MockFsMetadataSupportedBlobContainer extends MockFsAsyncBlobContainer {
        super.asyncBlobUpload(writeContext, completionListener);  
            int totalBytesRead = 0;  
            int length = decodedBytes.length;
 *
import org.opensearch.common.blobstore.fs.FsBlobStore;  
    public InputStreamWithMetadata readBlobWithMetadata(String blobName) throws IOException {  
import org.opensearch.common.blobstore.BlobPath;
    }
        super(blobStore, blobPath, path, triggerDataIntegrityFailure);
import java.nio.file.Path;  
            String ckpString = convertToBase64(ckpInputStream);
        }
                    throw new AssertionError("Input stream exceeds 1KB limit");
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {  
import org.opensearch.core.action.ActionListener;
import java.io.IOException;
/*  
import org.opensearch.common.blobstore.InputStreamWithMetadata;
import java.io.ByteArrayInputStream;
    public void asyncBlobUpload(WriteContext writeContext, ActionListener<Void> completionListener) throws IOException {
package org.opensearch.remotestore.translogmetadata.mocks;
    }
import java.io.InputStream;
    public MockFsMetadataSupportedBlobContainer(FsBlobStore blobStore, BlobPath blobPath, Path path, boolean triggerDataIntegrityFailure) {  
        if (writeContext.getMetadata() != null) {
import java.io.ByteArrayOutputStream;  
            int bytesRead;
        String baseName = translogFileName.substring(0, dotIndex);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(decodedBytes);
        // If the upload writeContext have a non-null metadata, we store the metadata content as translog.ckp file.  
        if (!translogFileName.endsWith(".tlog")) {
        InputStream inputStream = readBlob(blobName);
            String base64String = writeContext.getMetadata().get(CHECKPOINT_FILE_DATA_KEY);
    }  
    private static String CHECKPOINT_FILE_DATA_KEY = "ckp-data";
        try (InputStream ckpInputStream = readBlob(ckpFileName)) {  
    }
            return new InputStreamWithMetadata(inputStream, metadata);
import java.util.Map;  
import org.opensearch.common.blobstore.stream.write.WriteContext;
            byte[] bytes = byteArrayOutputStream.toByteArray();
    public static String convertToBase64(InputStream inputStream) throws IOException {
 * compatible open source license.
            byte[] buffer = new byte[128];
                    // We enforce a limit of 1KB on the size of the checkpoint file.  
        return baseName + ".ckp";
            while ((bytesRead = inputStream.read(buffer)) != -1) {
        }
    @Override
 */  
    }  
import org.opensearch.remotestore.multipart.mocks.MockFsAsyncBlobContainer;  
                }
    @Override
