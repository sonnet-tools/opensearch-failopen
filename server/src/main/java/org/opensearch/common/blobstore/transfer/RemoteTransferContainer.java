        boolean isRemoteDataIntegritySupported,
        checksumOfChecksum.update(ByteUtils.toByteArrayBE(storedChecksum));
        this(
        }
        Long expectedChecksum,
                OffsetRangeInputStream offsetRangeInputStream = offsetRangeInputStreamSupplier.get(size, position);
     * @param checksumBytesLength length of checksum bytes
     * Compute final checksum for IndexInput container checksum footer added by {@link CodecUtil}
        final int streamIdx,
    }
import org.opensearch.common.io.InputStreamContainer;
        return checksum;
            remoteFileName,
            .writePriority(writePriority)
    }
    private final CryptoMetadata cryptoMetadata;
        this.writePriority = writePriority;
            contentLength,
    }
        this.metadata = metadata;
        }
                        fileName
        }
    private final OffsetRangeInputStreamSupplier offsetRangeInputStreamSupplier;
    }
import org.opensearch.common.CheckedTriFunction;
    private final boolean failTransferIfFileExists;
 * SPDX-License-Identifier: Apache-2.0
        try {
            .cryptoMetadata(cryptoMetadata)
                if (isRemoteDataIntegrityCheckPossible() == false) {
            }
     *
     * @param remoteFileName                 Name of the remote file
                }
import java.util.zip.CRC32;
     * @param contentLength                  Total content length of the file to be uploaded
    private final WritePriority writePriority;
     * open streams during uploads. Calling this method won't actually create the streams, for that the consumer needs
                return new InputStreamContainer(inputStream, size, position);
            writePriority,
        this.partSize = partSize;
        }
            } catch (IOException e) {
import java.io.IOException;
            failTransferIfFileExists,
import java.util.Objects;
            checksum = JZlib.crc32_combine(checksum, ckSumSuppliers[checkSumIdx].get(), partSize);
        OffsetRangeInputStream get(long size, long position) throws IOException;
 * this file be licensed under the Apache-2.0 license or a
     * @param failTransferIfFileExists       A boolean to determine if upload has to be failed if file exists
    /**
import java.util.Map;
    public long getContentLength() {
 *
        if (isRemoteDataIntegrityCheckPossible()) {
import com.jcraft.jzlib.JZlib;
    /**
     * @param failTransferIfFileExists       A boolean to determine if upload has to be failed if file exists
import org.opensearch.cluster.metadata.CryptoMetadata;
        boolean isRemoteDataIntegritySupported
                    inputStream = offsetRangeInputStream;
        long checksum = ckSumSuppliers[0].get();
        OffsetRangeInputStreamSupplier offsetRangeInputStreamSupplier,
        Supplier<Long>[] suppliers = new Supplier[numberOfParts];
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeInputStream;
            .failIfAlreadyExists(failTransferIfFileExists)
     * @param offsetRangeInputStreamSupplier A supplier to create OffsetRangeInputStreams
    private long partSize;
    // package-private for testing
        this.numberOfParts = (int) ((contentLength % partSize) == 0 ? contentLength / partSize : (contentLength / partSize) + 1);
     * This method is called to create the {@link StreamContext} object that will be used by the vendor plugin to
        this.offsetRangeInputStreamSupplier = offsetRangeInputStreamSupplier;
     * @param writePriority                  The {@link WritePriority} of current upload
        boolean failTransferIfFileExists,
            .doRemoteDataIntegrityCheck(isRemoteDataIntegrityCheckPossible())
        final long position
            .build();
     * Construct a new RemoteTransferContainer object with metadata.
     * Construct a new RemoteTransferContainer object with metadata and CryptoMetadata.
                );
        WritePriority writePriority,
        this.fileName = fileName;
        long contentLength,
    private void finalizeUpload(boolean uploadSuccessful) throws IOException {
        this.expectedChecksum = expectedChecksum;
        if (uploadSuccessful && Objects.nonNull(expectedChecksum)) {
import java.io.InputStream;
        String fileName,
     *
                        offsetRangeInputStream,
        String fileName,
import org.opensearch.common.blobstore.transfer.stream.ResettableCheckedInputStream;
     * to call {@link StreamContext#provideStream}
        this.cryptoMetadata = cryptoMetadata;
     * @param metadata                       Object metadata to be store with the file.
        return () -> {
     */
            remoteFileName,
            metadata,
    }
     * @param isRemoteDataIntegritySupported A boolean to signify whether the remote repository supports server side data integrity verification
        CryptoMetadata cryptoMetadata
     */
                    ResettableCheckedInputStream resettableCheckedInputStream = new ResettableCheckedInputStream(
    public RemoteTransferContainer(
            try {
    StreamContext supplyStreamContext(long partSize) {
     */
     *
                        + " failed, actual checksum: "
        long contentLength,
     * @param indexInput IndexInput with checksum in footer
                log.error("Failed to create input stream", e);
     * @param isRemoteDataIntegritySupported A boolean to signify whether the remote repository supports server side data integrity verification
            expectedChecksum,
        this.isRemoteDataIntegritySupported = isRemoteDataIntegritySupported;
        boolean failTransferIfFileExists,
                InputStream inputStream;
import org.opensearch.common.SetOnce;
        return new WriteContext.Builder().fileName(remoteFileName)
import org.apache.lucene.codecs.CodecUtil;
                        + fileName
 * RemoteTransferContainer is an encapsulation for managing file transfers.
                }
                throw e;
        Map<String, String> metadata
     * @param expectedChecksum               The expected checksum value for the file being uploaded. This checksum will be used for local or remote data integrity checks
                if (offsetRangeInputStream instanceof RateLimitingOffsetRangeInputStream) {
    public RemoteTransferContainer(
            if (actualChecksum != expectedChecksum) {
import org.opensearch.common.util.ByteUtils;
    }
        return isRemoteDataIntegritySupported && Objects.nonNull(expectedChecksum);
     * @return The {@link StreamContext} object that will be used by the vendor plugin to retrieve streams during upload
     * @param expectedChecksum               The expected checksum value for the file being uploaded. This checksum will be used for local or remote data integrity checks
        this.lastPartSize = (contentLength % partSize) != 0 ? contentLength % partSize : partSize;
        WritePriority writePriority,
     * @param metadata                       Object metadata to be stored with the file
     */
            assert checksumSuppliers.get() != null : "expected container to be initialised";
            .expectedChecksum(isRemoteDataIntegrityCheckPossible() ? expectedChecksum : null)
    /**
     * @param contentLength                  Total content length of the file to be uploaded
     * @param remoteFileName                 Name of the remote file
                    Objects.requireNonNull(checksumSuppliers.get())[streamIdx] = resettableCheckedInputStream::getChecksum;
    ) {
     * @param remoteFileName                 Name of the remote file
    private final boolean isRemoteDataIntegritySupported;
     * OffsetRangeInputStreamSupplier is used to get the offset based input streams at runtime
    private final AtomicBoolean readBlock = new AtomicBoolean();
        this.remoteFileName = remoteFileName;
            throw new IOException("Multi-part streams are already created.");
        for (int checkSumIdx = 1; checkSumIdx < ckSumSuppliers.length - 1; checkSumIdx++) {
        CRC32 checksumOfChecksum = new CRC32();
    private final Long expectedChecksum;
     */
     * @param contentLength                  Total content length of the file to be uploaded
                    fileName
    private LocalStreamSupplier<InputStreamContainer> getMultipartStreamSupplier(
                    rangeIndexInputStream.setReadBlock(readBlock);
        if (checksumSuppliers.get() != null) {
    }
            .fileSize(contentLength)
        Long expectedChecksum,
    /**
    public WriteContext createWriteContext() {
        long contentLength,
        }
            failTransferIfFileExists,
    private final String fileName;
    }
                } else {
            throw new RuntimeException(e);
        String remoteFileName,
        return JZlib.crc32_combine(storedChecksum, checksumOfChecksum.getValue(), checksumBytesLength);
    @SuppressWarnings({ "unchecked" })
    }
                    inputStream = resettableCheckedInputStream;
            offsetRangeInputStreamSupplier,
        String remoteFileName,
            null,
 *
 * The OpenSearch Contributors require contributions made to
    private final String remoteFileName;
        WritePriority writePriority,
            contentLength,
import org.apache.logging.log4j.Logger;
            }
    }
            null
        checksumSuppliers.set(suppliers);
                        + actualChecksum
    private final long contentLength;
        this.failTransferIfFileExists = failTransferIfFileExists;
     */
    private long getActualChecksum() {
            isRemoteDataIntegritySupported,
    /**
     * Construct a new RemoteTransferContainer object
        );
    private final SetOnce<Supplier<Long>[]> checksumSuppliers = new SetOnce<>();
    private boolean isRemoteDataIntegrityCheckPossible() {
            expectedChecksum,
        return ((partNo, size, position) -> {
 * compatible open source license.
            offsetRangeInputStreamSupplier,
import java.util.concurrent.atomic.AtomicBoolean;
    }
            fileName,
        if (numberOfParts > 1) {
 * @opensearch.internal
/**
import org.opensearch.common.blobstore.stream.write.WriteContext;
/*
        String remoteFileName,
import org.apache.lucene.index.CorruptIndexException;
package org.opensearch.common.blobstore.transfer;
    @Override
            .streamContextSupplier(this::supplyStreamContext)
        return contentLength;
     * @param offsetRangeInputStreamSupplier A supplier to create OffsetRangeInputStreams
    /**
    }
        Stream get() throws IOException;
    /**
        boolean isRemoteDataIntegritySupported,
    public static long checksumOfChecksum(IndexInput indexInput, int checksumBytesLength) throws IOException {
            return getMultipartStreamSupplier(partNo, size, position).get();
     * @param writePriority                  The {@link WritePriority} of current upload
                        + ", expected checksum: "
     * @param isRemoteDataIntegritySupported A boolean to signify whether the remote repository supports server side data integrity verification
import org.opensearch.common.blobstore.transfer.stream.RateLimitingOffsetRangeInputStream;
     * @param writePriority                  The {@link WritePriority} of current upload
            .uploadFinalizer(this::finalizeUpload)
        OffsetRangeInputStreamSupplier offsetRangeInputStreamSupplier,
    private CheckedTriFunction<Integer, Long, Long, InputStreamContainer, IOException> getTransferPartStreamSupplier() {
        }
     * @param offsetRangeInputStreamSupplier A supplier to create OffsetRangeInputStreams
            .metadata(metadata)
import org.apache.lucene.store.IndexInput;
     */
     * @param expectedChecksum               The expected checksum value for the file being uploaded
    private long lastPartSize;
    }
                    );
        } catch (IOException e) {
                    RateLimitingOffsetRangeInputStream rangeIndexInputStream = (RateLimitingOffsetRangeInputStream) offsetRangeInputStream;
        Long expectedChecksum,
            writePriority,
        Map<String, String> metadata,
     * @param fileName                       Name of the local file
            checksum = JZlib.crc32_combine(checksum, ckSumSuppliers[numberOfParts - 1].get(), lastPartSize);
    ) {
        this(
    public interface OffsetRangeInputStreamSupplier {
        );
    interface LocalStreamSupplier<Stream> {
    }
                throw new CorruptIndexException(
    private static final Logger log = LogManager.getLogger(RemoteTransferContainer.class);
     * @param cryptoMetadata                 CryptoMetadata for index-level encryption settings
            isRemoteDataIntegritySupported,
    }
    /**
        return new StreamContext(getTransferPartStreamSupplier(), partSize, lastPartSize, numberOfParts);
        readBlock.set(true);
import java.io.Closeable;
        boolean failTransferIfFileExists,
                        + expectedChecksum,
import java.util.function.Supplier;
public class RemoteTransferContainer implements Closeable {
}
        String fileName,
            return;
            null
    private final Map<String, String> metadata;
        OffsetRangeInputStreamSupplier offsetRangeInputStreamSupplier,
    ) {
     */
import org.opensearch.common.blobstore.stream.write.WritePriority;
        long storedChecksum = CodecUtil.retrieveChecksum(indexInput);
    private int numberOfParts;
            long actualChecksum = getActualChecksum();
            return this.openMultipartStreams(partSize);
     * @return The {@link  WriteContext} for the current upload
     * @param partSize Part sizes of all parts apart from the last one, which is determined internally
        final long size,
     * @return The total content length of current upload
                    "Data integrity check done after upload for file "
 */
import org.opensearch.common.StreamContext;
    public void close() throws IOException {
    ) {
    public RemoteTransferContainer(
        this.contentLength = contentLength;
        Supplier<Long>[] ckSumSuppliers = Objects.requireNonNull(checksumSuppliers.get());
     *
            fileName,
     * @return final computed checksum of entire indexInput
     * @param failTransferIfFileExists       A boolean to determine if upload has to be failed if file exists
        // Setting a read block on all streams ever created by the container.
     * @param fileName                       Name of the local file
    private StreamContext openMultipartStreams(long partSize) throws IOException {
    }
        });
import org.apache.logging.log4j.LogManager;
     * @param fileName                       Name of the local file
        };
 */
