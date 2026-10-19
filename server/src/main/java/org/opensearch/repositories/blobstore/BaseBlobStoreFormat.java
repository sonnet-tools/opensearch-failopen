    public BaseBlobStoreFormat(String blobNameFormat, boolean skipHeaderFooter) {
    private final boolean skipHeaderFooter;
        final String blobName = blobName(name);  
                        xContentType,
                    outputStream,
import org.apache.lucene.codecs.CodecUtil;
 * The OpenSearch Contributors require contributions made to  
    ) throws IOException {
     * <p>  
 *
        String codec,  
                    "ChecksumBlobStoreFormat.writeBlob(blob=\"" + blobName + "\")",  
                        compressor.threadLocalOutputStream(indexOutputOutputStream)  
                        // in order to write the footer we need to prevent closing the actual index input.
                OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput(
        this.blobNameFormat = blobNameFormat;
import org.opensearch.common.xcontent.XContentType;  
            return outputStream.bytes();
        return blobNameFormat;
import java.io.IOException;
        this.skipHeaderFooter = skipHeaderFooter;  
                    XContentBuilder builder = MediaTypeRegistry.contentBuilder(
        assert skipHeaderFooter || (Objects.nonNull(codec) && Objects.nonNull(version));
     * @param compressor    whether to use compression  
     * @param codec         codec used
     */
                    builder.startObject();  
    ) throws IOException {
 */  
import org.opensearch.core.common.bytes.BytesReference;
        final BytesReference bytes = serialize(obj, blobName, compressor, params, xContentType, codec, version);
    }
    /**
    private final String blobNameFormat;  
    private static final int BUFFER_SIZE = 4096;
}  
    protected String getBlobNameFormat() {  
        final Compressor compressor,
     * The blob will optionally by compressed.
                    public void close() {
        try (BytesStreamOutput outputStream = new BytesStreamOutput()) {  
                }  
 * Provides common methods, variables that can be used by the implementors.
            }
import org.opensearch.common.lucene.store.IndexOutputOutputStream;
    }
        return String.format(Locale.ROOT, blobNameFormat, name);
import org.opensearch.common.io.stream.BytesStreamOutput;
                if (skipHeaderFooter == false) {  
                    blobName,
     * @param blobContainer blob container
     */  
public class BaseBlobStoreFormat<T extends ToXContent> {
import java.io.OutputStream;
     * @param name          blob name
        Integer version
        Integer version  
                if (skipHeaderFooter == false) {
/**  
    public BytesReference serialize(
     * @param blobNameFormat format of the blobname in {@link String#format} format
                )
        final String blobName,
                }
        String codec,
    }
        final Compressor compressor,  
        final ToXContent.Params params,  
        final BlobContainer blobContainer,
    protected void write(
     * @param params        ToXContent params
        final T obj,  
    protected String blobName(String name) {  
import java.util.Objects;
 * this file be licensed under the Apache-2.0 license or a
        }  
 * compatible open source license.
                ) {
import org.opensearch.core.compress.Compressor;
                        // this is important since some of the XContentBuilders write bytes on close.  
     * @param obj           object to be serialized  
                    builder.endObject();
                    CodecUtil.writeHeader(indexOutput, codec, version);
    }  
import org.apache.lucene.store.OutputStreamIndexOutput;
                    }
                    obj.toXContent(builder, params);
/*  
    }
 * @opensearch.internal  
            ) {
        final T obj,  
     * @param version       version used  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                    CodecUtil.writeFooter(indexOutput);
import org.opensearch.core.xcontent.ToXContent;
     *
                };  
        XContentType xContentType,
                try (OutputStream indexOutputOutputStream = new IndexOutputOutputStream(indexOutput) {  
 */
package org.opensearch.repositories.blobstore;
    /**
import org.opensearch.common.blobstore.BlobContainer;  
        final ToXContent.Params params,
                }  
                    )
import java.util.Locale;  
                    @Override
            try (
     * Writes blob with resolving the blob name using {@link #blobName} method.
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;
        XContentType xContentType,
        blobContainer.writeBlob(blobName, bytes.streamInput(), bytes.length(), false);
                    BUFFER_SIZE  
        final String name,
