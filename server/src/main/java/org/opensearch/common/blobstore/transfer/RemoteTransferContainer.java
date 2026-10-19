    private LocalStreamSupplier<InputStreamContainer> getMultipartStreamSupplier(
     *
    }
     * @param expectedChecksum               The expected checksum value for the file being uploaded  
package org.opensearch.common.blobstore.transfer;
        if (uploadSuccessful && Objects.nonNull(expectedChecksum)) {  
        });
        if (isRemoteDataIntegrityCheckPossible()) {
    private long partSize;
        this.fileName = fileName;
import org.opensearch.common.blobstore.transfer.stream.RateLimitingOffsetRangeInputStream;
        this.lastPartSize = (contentLength % partSize) != 0 ? contentLength % partSize : partSize;
        Map<String, String> metadata
        this.numberOfParts = (int) ((contentLength % partSize) == 0 ? contentLength / partSize : (contentLength / partSize) + 1);  
import java.io.Closeable;  
    private void finalizeUpload(boolean uploadSuccessful) throws IOException {
        this.cryptoMetadata = cryptoMetadata;
            } catch (IOException e) {
     */
            expectedChecksum,
        return JZlib.crc32_combine(storedChecksum, checksumOfChecksum.getValue(), checksumBytesLength);
    /**
        OffsetRangeInputStream get(long size, long position) throws IOException;  
                if (offsetRangeInputStream instanceof RateLimitingOffsetRangeInputStream) {  
        long contentLength,
import org.apache.logging.log4j.Logger;
        String fileName,
     */
    private final boolean failTransferIfFileExists;
import org.opensearch.common.blobstore.stream.write.WriteContext;
     * @param isRemoteDataIntegritySupported A boolean to signify whether the remote repository supports server side data integrity verification
    public RemoteTransferContainer(
    private final CryptoMetadata cryptoMetadata;  
            null
                    inputStream = resettableCheckedInputStream;
 * this file be licensed under the Apache-2.0 license or a
    }  
    private boolean isRemoteDataIntegrityCheckPossible() {  
        checksumSuppliers.set(suppliers);
     * @param expectedChecksum               The expected checksum value for the file being uploaded. This checksum will be used for local or remote data integrity checks
        this.expectedChecksum = expectedChecksum;
     * Construct a new RemoteTransferContainer object with metadata and CryptoMetadata.
import java.io.InputStream;
            try {
     * @param expectedChecksum               The expected checksum value for the file being uploaded. This checksum will be used for local or remote data integrity checks
            writePriority,  
        this.writePriority = writePriority;  
            .streamContextSupplier(this::supplyStreamContext)
            assert checksumSuppliers.get() != null : "expected container to be initialised";  
            fileName,
import org.opensearch.common.SetOnce;
            .failIfAlreadyExists(failTransferIfFileExists)  
        OffsetRangeInputStreamSupplier offsetRangeInputStreamSupplier,
     * @param contentLength                  Total content length of the file to be uploaded
                }
            isRemoteDataIntegritySupported,
                    RateLimitingOffsetRangeInputStream rangeIndexInputStream = (RateLimitingOffsetRangeInputStream) offsetRangeInputStream;
                    "Data integrity check done after upload for file "
    // package-private for testing
    private final Map<String, String> metadata;
            fileName,  
        WritePriority writePriority,
        return contentLength;
        checksumOfChecksum.update(ByteUtils.toByteArrayBE(storedChecksum));  
            checksum = JZlib.crc32_combine(checksum, ckSumSuppliers[numberOfParts - 1].get(), lastPartSize);  
     */
        );
                    ResettableCheckedInputStream resettableCheckedInputStream = new ResettableCheckedInputStream(  
     * Construct a new RemoteTransferContainer object with metadata.
import org.opensearch.common.blobstore.transfer.stream.ResettableCheckedInputStream;
    public RemoteTransferContainer(
     * to call {@link StreamContext#provideStream}  
    }
        );  
                    );  
                );
 */  
            .uploadFinalizer(this::finalizeUpload)
                throw new CorruptIndexException(  
            metadata,
    }
    StreamContext supplyStreamContext(long partSize) {
            throw new RuntimeException(e);  
     */
     * @param writePriority                  The {@link WritePriority} of current upload
        Supplier<Long>[] suppliers = new Supplier[numberOfParts];
                log.error("Failed to create input stream", e);  
 */  
    private final SetOnce<Supplier<Long>[]> checksumSuppliers = new SetOnce<>();
        long storedChecksum = CodecUtil.retrieveChecksum(indexInput);
import java.io.IOException;
            .metadata(metadata)
     * @param writePriority                  The {@link WritePriority} of current upload
     * open streams during uploads. Calling this method won't actually create the streams, for that the consumer needs
    private long getActualChecksum() {
     * @return The {@link StreamContext} object that will be used by the vendor plugin to retrieve streams during upload  
        WritePriority writePriority,
import org.apache.lucene.index.CorruptIndexException;
import java.util.Map;  
    }
    public WriteContext createWriteContext() {
     * @param fileName                       Name of the local file  
 * @opensearch.internal
                    rangeIndexInputStream.setReadBlock(readBlock);
    ) {  
     * @return The {@link  WriteContext} for the current upload  
     * @param isRemoteDataIntegritySupported A boolean to signify whether the remote repository supports server side data integrity verification
    /**
                    Objects.requireNonNull(checksumSuppliers.get())[streamIdx] = resettableCheckedInputStream::getChecksum;
     * @param contentLength                  Total content length of the file to be uploaded  
            long actualChecksum = getActualChecksum();
     * Construct a new RemoteTransferContainer object
        this.partSize = partSize;
    public static long checksumOfChecksum(IndexInput indexInput, int checksumBytesLength) throws IOException {  
        } catch (IOException e) {
        long checksum = ckSumSuppliers[0].get();
        boolean failTransferIfFileExists,
        }
     * @param metadata                       Object metadata to be stored with the file
        boolean failTransferIfFileExists,  
     * @param fileName                       Name of the local file
                throw e;
     * @param failTransferIfFileExists       A boolean to determine if upload has to be failed if file exists
    private long lastPartSize;
        return new WriteContext.Builder().fileName(remoteFileName)  
public class RemoteTransferContainer implements Closeable {
        CRC32 checksumOfChecksum = new CRC32();
        // Setting a read block on all streams ever created by the container.
 * RemoteTransferContainer is an encapsulation for managing file transfers.  
        Supplier<Long>[] ckSumSuppliers = Objects.requireNonNull(checksumSuppliers.get());  
    private CheckedTriFunction<Integer, Long, Long, InputStreamContainer, IOException> getTransferPartStreamSupplier() {
        this(
    private static final Logger log = LogManager.getLogger(RemoteTransferContainer.class);
            isRemoteDataIntegritySupported,  
}  
/*  
            return this.openMultipartStreams(partSize);
     *  
     * @return The total content length of current upload
            offsetRangeInputStreamSupplier,
        String remoteFileName,
     */
            remoteFileName,
            if (actualChecksum != expectedChecksum) {
    }
    private final String fileName;  
        return checksum;  
        if (checksumSuppliers.get() != null) {  
        Long expectedChecksum,  
        }
                return new InputStreamContainer(inputStream, size, position);
        if (numberOfParts > 1) {
            .build();
                } else {  
 *
     * @param partSize Part sizes of all parts apart from the last one, which is determined internally
    private final boolean isRemoteDataIntegritySupported;  
    private StreamContext openMultipartStreams(long partSize) throws IOException {
        final long size,  
        return ((partNo, size, position) -> {
    }
/**
        return isRemoteDataIntegritySupported && Objects.nonNull(expectedChecksum);
        this.offsetRangeInputStreamSupplier = offsetRangeInputStreamSupplier;
     * This method is called to create the {@link StreamContext} object that will be used by the vendor plugin to
                InputStream inputStream;
    /**
import org.opensearch.common.io.InputStreamContainer;  
        WritePriority writePriority,  
 * The OpenSearch Contributors require contributions made to  
            failTransferIfFileExists,
            checksum = JZlib.crc32_combine(checksum, ckSumSuppliers[checkSumIdx].get(), partSize);  
     *  
                    inputStream = offsetRangeInputStream;
    }  
    private final String remoteFileName;
    public void close() throws IOException {
     * OffsetRangeInputStreamSupplier is used to get the offset based input streams at runtime  
     * @param remoteFileName                 Name of the remote file
    /**
                }  
     * @param remoteFileName                 Name of the remote file
        this.isRemoteDataIntegritySupported = isRemoteDataIntegritySupported;  
     * @param offsetRangeInputStreamSupplier A supplier to create OffsetRangeInputStreams  
                        + ", expected checksum: "
     * @param indexInput IndexInput with checksum in footer
        this(
            }  
     * @param writePriority                  The {@link WritePriority} of current upload
    }  
     * @param fileName                       Name of the local file
            .fileSize(contentLength)
    }
    @Override  
        boolean isRemoteDataIntegritySupported  
    private final AtomicBoolean readBlock = new AtomicBoolean();
import org.apache.logging.log4j.LogManager;
import org.opensearch.cluster.metadata.CryptoMetadata;  
import java.util.function.Supplier;  
    private int numberOfParts;  
import java.util.concurrent.atomic.AtomicBoolean;
        CryptoMetadata cryptoMetadata  
        String remoteFileName,  
    public interface OffsetRangeInputStreamSupplier {
            .cryptoMetadata(cryptoMetadata)  
    public RemoteTransferContainer(
        this.contentLength = contentLength;
        for (int checkSumIdx = 1; checkSumIdx < ckSumSuppliers.length - 1; checkSumIdx++) {
                        + " failed, actual checksum: "  
        String fileName,  
    /**  
        return () -> {  
            expectedChecksum,  
                    fileName
    }
import com.jcraft.jzlib.JZlib;  
        OffsetRangeInputStreamSupplier offsetRangeInputStreamSupplier,
    private final long contentLength;
import org.opensearch.common.CheckedTriFunction;
        Stream get() throws IOException;
        };  
        }
                        + fileName
        long contentLength,
     * @param metadata                       Object metadata to be store with the file.  
    }
     * @return final computed checksum of entire indexInput
        long contentLength,
        final long position
import java.util.zip.CRC32;
     * @param failTransferIfFileExists       A boolean to determine if upload has to be failed if file exists
        readBlock.set(true);  
            offsetRangeInputStreamSupplier,
    public long getContentLength() {
            return;  
import java.util.Objects;
            .doRemoteDataIntegrityCheck(isRemoteDataIntegrityCheckPossible())  
        boolean failTransferIfFileExists,  
    ) {
            .expectedChecksum(isRemoteDataIntegrityCheckPossible() ? expectedChecksum : null)
                        offsetRangeInputStream,
import org.apache.lucene.store.IndexInput;
        }
            null,
    private final WritePriority writePriority;  
    /**  
        OffsetRangeInputStreamSupplier offsetRangeInputStreamSupplier,
            .writePriority(writePriority)
            return getMultipartStreamSupplier(partNo, size, position).get();
            contentLength,
            null  
                        + expectedChecksum,  
import org.opensearch.common.StreamContext;  
     * @param remoteFileName                 Name of the remote file
    ) {
        Long expectedChecksum,  
     * @param checksumBytesLength length of checksum bytes  
     */  
import org.opensearch.common.blobstore.stream.write.WritePriority;
        boolean isRemoteDataIntegritySupported,
            throw new IOException("Multi-part streams are already created.");
    }
     * @param contentLength                  Total content length of the file to be uploaded  
        this.failTransferIfFileExists = failTransferIfFileExists;
     */
        this.remoteFileName = remoteFileName;  
                OffsetRangeInputStream offsetRangeInputStream = offsetRangeInputStreamSupplier.get(size, position);
    private final OffsetRangeInputStreamSupplier offsetRangeInputStreamSupplier;
        try {  
    /**
                if (isRemoteDataIntegrityCheckPossible() == false) {
                        + actualChecksum
        return new StreamContext(getTransferPartStreamSupplier(), partSize, lastPartSize, numberOfParts);
    interface LocalStreamSupplier<Stream> {  
        }
    ) {
            writePriority,
            remoteFileName,  
        }
    private final Long expectedChecksum;
    @SuppressWarnings({ "unchecked" })
        boolean isRemoteDataIntegritySupported,
            contentLength,
        final int streamIdx,
    }
import org.apache.lucene.codecs.CodecUtil;  
     * @param isRemoteDataIntegritySupported A boolean to signify whether the remote repository supports server side data integrity verification
    /**  
     * Compute final checksum for IndexInput container checksum footer added by {@link CodecUtil}
     * @param cryptoMetadata                 CryptoMetadata for index-level encryption settings  
        Map<String, String> metadata,
 * compatible open source license.
import org.opensearch.common.util.ByteUtils;
     * @param offsetRangeInputStreamSupplier A supplier to create OffsetRangeInputStreams
        Long expectedChecksum,
     *
                        fileName
        String remoteFileName,
     */  
        String fileName,  
     * @param failTransferIfFileExists       A boolean to determine if upload has to be failed if file exists  
 *
            }
            failTransferIfFileExists,  
     * @param offsetRangeInputStreamSupplier A supplier to create OffsetRangeInputStreams  
    }
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeInputStream;  
        this.metadata = metadata;
    }
 * SPDX-License-Identifier: Apache-2.0
