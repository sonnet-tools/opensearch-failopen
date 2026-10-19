            }
 * FilePartWriter transfers the provided stream into the specified file path using a {@link FileChannel}
 * The OpenSearch Contributors require contributions made to  
                int bytesRead;
                    Channels.writeToChannel(buffer, 0, bytesRead, outputFileChannel, streamOffset);
 * this file be licensed under the Apache-2.0 license or a
                }  
/*  
    public static void write(Path fileLocation, InputStreamContainer stream, UnaryOperator<InputStream> rateLimiter) throws IOException {  
 * compatible open source license.
class FilePartWriter {
import java.nio.file.StandardOpenOption;  
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.InternalApi;
                while ((bytesRead = inputStream.read(buffer)) != -1) {  
import java.io.InputStream;  
import java.util.function.UnaryOperator;
import java.nio.file.Path;
package org.opensearch.common.blobstore.stream.read.listener;
    // 8 MB buffer for transfer  
}
import java.io.IOException;
import org.opensearch.common.io.Channels;
@InternalApi
                long streamOffset = stream.getOffset();  
            try (InputStream inputStream = rateLimiter.apply(stream.getInputStream())) {
                final byte[] buffer = new byte[BUFFER_SIZE];
 *
                    streamOffset += bytesRead;
import org.opensearch.common.io.InputStreamContainer;  
import java.nio.channels.FileChannel;
        }
    private static final int BUFFER_SIZE = 8 * 1024 * 2024;
        try (FileChannel outputFileChannel = FileChannel.open(fileLocation, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
 */  
/**  
 */  
 * instance.
