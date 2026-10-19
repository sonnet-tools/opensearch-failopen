        @Override
        @Override
            return generation;  
     * Snapshot of a single .ckp file that gets transferred
/*  
            this.translogContentChecksum = translogContentChecksum;
            return Objects.hash(generation, minTranslogGeneration, super.hashCode());  
        public boolean equals(Object o) {
            .append("]")  
        /**
            return metadataFileInputStream;
         *
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeFileInputStream;  
        public CheckpointFileSnapshot(long primaryTerm, long generation, long minTranslogGeneration, Path path, Long checksum)  
        }
            .toString();
    }
            .append(", path = ")
/**
        public long getGeneration() {  
    }  
        @Nullable  
        @Override  
                if (getClass() != o.getClass()) return false;
            super(name, content);
        }
        public Long getChecksum() {
    }
    private final FileChannel fileChannel;
 * @opensearch.internal
        public long getGeneration() {
         * Default implementation returns -1 for non-generational files.  
                return Objects.equals(this.primaryTerm, other.primaryTerm);
        }  
                if (this == o) return true;
            this.minTranslogGeneration = minTranslogGeneration;  
        public TranslogFileSnapshot(long primaryTerm, long generation, Path path, Long checksum, Long translogContentChecksum)
    private final String name;  
        public boolean equals(Object o) {
     */
import java.nio.channels.Channels;
    /**
     */
        Objects.requireNonNull(name);
import java.nio.file.StandardOpenOption;
 */  
 * this file be licensed under the Apache-2.0 license or a
                if (this == o) return true;  
        this.content = content;  
        return fileChannel != null
    }
         * @return the generation number, or -1 if not applicable  
    private Path path;
        // inherited checksum, which covers the whole file and is used to verify the upload, this one is published
            return -1;  
        }
        public long getMinTranslogGeneration() {  
            final Path filePath = path;  
    @Nullable  
            ? new BufferedInputStream(Channels.newInputStream(fileChannel))  
            return minTranslogGeneration;
    public InputStream inputStream() throws IOException {
    private FileSnapshot(Path path) throws IOException {
        // Checksum of the translog content (header + operations) as recorded in the file footer. Unlike the  
                    && Objects.equals(this.generation, other.generation);
            this.generation = generation;
            super(path, primaryTerm, checksum);
            this.primaryTerm = primaryTerm;
import java.io.IOException;
    /**
            throws IOException {
    }
 *
        public boolean equals(Object o) {
        this.fileChannel = null;
     */  
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;
        IOUtils.close(fileChannel);  
    @Nullable
            super(path);
    @Override
        }
            if (super.equals(o)) {  
            return primaryTerm;
            : new InputStreamIndexInput(new ByteArrayIndexInput(this.name, content), content.length);
            this.primaryTerm = primaryTerm;
        public int hashCode() {
     *  
                TransferFileSnapshot other = (TransferFileSnapshot) o;  
        this.fileChannel = FileChannel.open(path, StandardOpenOption.READ);  
    @Override
        return new StringBuilder("FileInfo [").append(" name = ")
import java.nio.file.Path;  
    }
     * Supplies the offset-ranged streams that a multipart (async) upload reads its parts from.
        }
    public void close() throws IOException {
     * @return a supplier of offset-ranged streams over the bytes to be uploaded
        public int hashCode() {  
            return checksum;  
        public long getGeneration() {
        this.name = path.getFileName().toString();
        public TransferFileSnapshot(Path path, long primaryTerm, Long checksum) throws IOException {  
            return Objects.hash(primaryTerm, super.hashCode());
        public long getPrimaryTerm() {  
        public TranslogFileSnapshot(long primaryTerm, long generation, Path path, Long checksum) throws IOException {  
        public void setMetadataFileInputStream(InputStream inputStream) {  
        FileSnapshot other = (FileSnapshot) o;
        final byte[] bytes = this.content;
            return translogContentChecksum;
        }
     * @opensearch.internal
        return fileChannel == null ? content.length : fileChannel.size();
import java.io.InputStream;  
                if (getClass() != o.getClass()) return false;
import java.util.Arrays;
            return (size, position) -> new OffsetRangeFileInputStream(filePath, size, position);
        final String resourceDescription = this.name;  
    }
    public String toString() {
 * compatible open source license.
package org.opensearch.index.translog.transfer;
            return Objects.hash(generation, super.hashCode());
    public String getName() {
        }
            return false;  
            if (super.equals(o)) {
        if (o == null || getClass() != o.getClass()) return false;
        Objects.requireNonNull(path);  
    }
    @Override  
 */  
    }
    public static class TranslogFileSnapshot extends TransferFileSnapshot {  
        }  
        @Override
            }
            .append(path.toUri())
     * Snapshot of a single .tlg file that gets transferred
            }
        public int hashCode() {  
     *  The default implementation reads directly from the backing file (or the in-memory content, for
     * @opensearch.internal  
            .append(name)  
        private Long checksum;
     *
 * The OpenSearch Contributors require contributions made to  
     *
        private InputStream metadataFileInputStream;
         * Returns the generation number.
    }
        @Override
            return generation;
            }
        }
        }
        }
    public static final class CheckpointFileSnapshot extends TransferFileSnapshot {  
        return Objects.equals(this.name, other.name) && Arrays.equals(this.content, other.content) && Objects.equals(this.path, other.path);  
        public TransferFileSnapshot(String name, byte[] content, long primaryTerm) throws IOException {  
     * Snapshot of a single file with primary term that gets transferred
        }
    /**  
    public boolean equals(Object o) {
import java.io.BufferedInputStream;  
        this.path = path;
    public static class TransferFileSnapshot extends FileSnapshot {
    public Path getPath() {
                if (getClass() != o.getClass()) return false;
    }  
        public InputStream getMetadataFileInputStream() {
import org.opensearch.common.Nullable;
        return Objects.hash(name, content, path);
 * Snapshot of a single file that gets transferred  
        private final long generation;
        private final long minTranslogGeneration;
        return path;
    }
        }
        if (this == o) return true;  
                if (this == o) return true;
import java.util.Objects;  
        @Override
public class FileSnapshot implements Closeable {
            throws IOException {
         * Subclasses should override this to return the actual generation.
    public long getContentLength() throws IOException {  
        @Override
import org.opensearch.common.blobstore.transfer.RemoteTransferContainer;
        }
            super(path, primaryTerm, checksum);  
import org.opensearch.common.lucene.store.InputStreamIndexInput;  
            this.generation = generation;
    /**
            this.metadataFileInputStream = inputStream;
        }
 * SPDX-License-Identifier: Apache-2.0
     * <p>  
        }
            this.checksum = checksum;  
                return Objects.equals(this.minTranslogGeneration, other.minTranslogGeneration)  
    public RemoteTransferContainer.OffsetRangeInputStreamSupplier offsetRangeInputStreamSupplier() {
    }
import java.nio.channels.FileChannel;
    }
         */
            if (super.equals(o)) {  
                return Objects.equals(this.generation, other.generation);
        @Override
    public int hashCode() {  
     * content-backed snapshots), so no part of the file is ever held on heap.
     * translog) must override this in addition to {@link #inputStream()}, and must keep the supplier
     * @opensearch.internal
        // in the translog transfer metadata so a downloader can recognise a generation it already holds locally.
            return false;  
import java.io.Closeable;
        private final Long translogContentChecksum;
        if (path != null) {
    @Override
        }
        private final long primaryTerm;
        this.name = name;
 *
        public Long getTranslogContentChecksum() {
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
     */
}  
import org.opensearch.common.util.io.IOUtils;
    private FileSnapshot(String name, byte[] content) {  
     * Subclasses that transform the bytes on the way out (for example decrypting a client-side encrypted
            return false;  
                CheckpointFileSnapshot other = (CheckpointFileSnapshot) o;
     *  
        return name;  
            this(primaryTerm, generation, path, checksum, null);
     * <p>  
    @Nullable
        }  
        @Nullable  
    private byte[] content;  
        }
        }  
     * random-access.  
                TranslogFileSnapshot other = (TranslogFileSnapshot) o;  
        return (size, position) -> new OffsetRangeIndexInputStream(new ByteArrayIndexInput(resourceDescription, bytes), size, position);
        private final long generation;
