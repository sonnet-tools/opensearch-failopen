    @ExperimentalApi
    default long readBlobPreferredLength() {
     *                               blob is expected to not exist.  
     */
            return comparator;
import java.util.Map;
     * @throws  NoSuchFileException if the blob does not exist  
 * Unless required by applicable law or agreed to in writing,
     * bounding the length of the data requested.
     *
     * and optional encryption settings for index-level encryption override.  
    void writeBlobAtomic(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException;
     *  
     * @return  The {@link InputStreamWithMetadata} of the blob.
        final Comparator<BlobMetadata> comparator;
     */  
 *
     * same name already exists, the operation will fail and an {@link IOException} will be thrown.
     */
import java.io.InputStream;
     * @return  {@code true} if a blob exists in the {@link BlobContainer} with the given name, and {@code false} otherwise.
 * SPDX-License-Identifier: Apache-2.0
     * @throws  IOException if there were any failures in reading from the blob container.  
     * reads via {@link #readBlobWithVersion} are <b>enforced by the store</b>.
     * Reads blob content from the input stream and writes it to the container in a new blob with the given name.
     */
    /**
    /**  
        @Nullable Map<String, String> metadata,
     */  
     * Also, some blob containers return streams that are expensive to close before the stream has been fully consumed, and the cost may  
 * license agreements. See the NOTICE file distributed with
     * The type representing sort order of blob names
            this.comparator = comparator;  
     * The distinction matters because the one caller of this flag, remote store primary fencing, uses a conditional
    /**
/**
        throw new UnsupportedOperationException("writeBlobConditionally is not implemented yet");
     *
     */
 *  
     */
    /**
     * Writes a blob only if it has not been modified since the supplied version token was read (compare-and-swap).  
     * This method assumes the container does not already contain a blob of the same blobName.  If a blob by the
import java.util.Comparator;  
    /**
     *
     */
        }
     *          The metadata to be associate with the blob upload.  
 * GitHub history for details.
     *  
     * Creates a new {@link InputStream} that can be used to read the given blob starting from
     * @throws  NoSuchFileException if the blob does not exist  
     *          The name of the blob to write the contents of the input stream to.
     * @param blobNamePrefix The prefix to match against blob names in the container.  
    void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException;
    /**  
     * fence, which is worse than running unfenced, since the shard would report itself protected.  
        }
    /**
     * @throws  FileAlreadyExistsException if failIfAlreadyExists is true and a blob by the same name already exists
     * @param   inputStream  
 * You may obtain a copy of the License at  
     *          The metadata to be associate with the blob upload.
        throw new UnsupportedOperationException("readBlobWithVersion is not implemented yet");
     * @throws  IOException if the blob can not be read.  
     * @param listener the listener to be notified upon request completion  
     * same name already exists, the operation will fail and an {@link IOException} will be thrown.
        // Default implementation: delegate to non-crypto version
    InputStream readBlob(String blobName) throws IOException;  
     * @throws  FileAlreadyExistsException if failIfAlreadyExists is true and a blob by the same name already exists
    default void writeBlobWithMetadata(  
     * {@code false} here: the calls work, but the guarantee callers actually want does not hold. Emulation is not
     *          The size of the blob to be written, in bytes.  It is implementation dependent whether  
        }  
    }
        long blobSize,  
     * This method assumes the container does not already contain a blob of the same blobName. If a blob by the
    default String writeBlobConditionally(String blobName, InputStream inputStream, long blobSize, @Nullable String expectedVersionToken)  
     * @throws IOException on failure  
        try {
     * @param   blobName
     * <p>
     * @throws  IOException if the input stream could not be read, or the target blob could not be written to.  
     * <p>  
     */  
     * @return Map of name of the child container to child container  
     */
     * @param   inputStream
    /**
     * @param   blobSize  
     * <p>
        LEXICOGRAPHIC(Comparator.comparing(BlobMetadata::name));  
    /**
     * Reads the full content of a blob along with the opaque version token (e.g. ETag) it had when read. The token
     * Some blob containers have nontrivial costs attached to each readBlob call, so it is a good idea for consumers to speculatively  
    /**
 * this work for additional information regarding copyright
     * same name already exists, the operation will fail and an {@link IOException} will be thrown.  
     * Lists all blobs in the container.
        ActionListener<List<BlobMetadata>> listener  
     * <p>  
     *
     * Reads blob content from the input stream and writes it to the container in a new blob with the given name, and metadata.
        throw new UnsupportedOperationException("readBlobWithMetadata is not implemented yet");
     * @param   inputStream  
     * @throws  IOException if the blob can not be read.
     * Store-enforced is the whole point of the flag, so it is stricter than "the methods do not throw". The precondition  
     *
package org.opensearch.common.blobstore;
    /**  
     *          The input stream from which to retrieve the bytes to write to the blob.  
    default InputStreamWithMetadata readBlobWithMetadata(String blobName) throws IOException {  
     *          whether to throw a FileAlreadyExistsException if the given blob already exists
     * the same stream.
     * @throws  IOException if the input stream could not be read, or the target blob could not be written to.  
    boolean blobExists(String blobName) throws IOException;
     * @param   blobName             The name of the blob to write.
     * @return  the BlobPath where the blobs are contained
    /**  
     *          The name of the blob to get an {@link InputStream} for.
     * Creates a new {@link InputStreamWithMetadata} for the given blob name.  
     * preconditions are - which is what makes the result hold against concurrent writers in other processes and on other
    };
import org.opensearch.cluster.metadata.CryptoMetadata;
     * @param blobName The name of the blob to get an {@link InputStream} for.  
        List<BlobMetadata> blobNames = new ArrayList<>(listBlobsByPrefix(blobNamePrefix).values());  
    /**
        int limit,
     * @return  A map of the matching blobs in the container.  The keys in the map are the names of the blobs
     *          The name of the blob to write the contents of the input stream to.  
    /**
     * @return  A map of all the blobs in the container.  The keys in the map are the names of the blobs and
     * Creates a new {@link InputStream} for the given blob name.
     * @param   blobName
     * @param   metadata
     * @param   inputStream  
public interface BlobContainer {  
     * can be passed to {@link #writeBlobConditionally} to perform a compare-and-swap update.  
 */
     * @param   blobNamePrefix
        blobNames.sort(blobNameSortOrder.comparator());
     * when one or multiple of the given blobs don't exist and simply ignore this case.  
    @ExperimentalApi
     * @param   inputStream          The input stream from which to retrieve the bytes to write.  
     *          this value is used in writing the blob to the repository.  
     *
     *
     * @param   inputStream
 */
     */
     */
     * @param   blobName  
     * @param   cryptoMetadata  
    /**
        writeBlobWithMetadata(blobName, inputStream, blobSize, failIfAlreadyExists, metadata);  
     *          this value is used in writing the blob to the repository.
 * under the License.  
     * write to exclude a writer it cannot see. An emulated precondition would let two nodes both believe they hold the
import java.util.List;
        String blobName,
     * support.
     *          The name of the blob to write the contents of the input stream to.
     * @throws  IOException if the blob can not be read
     * @param   blobSize
     * Reads blob content from the input stream and writes it to the container in a new blob with the given name,
import org.opensearch.core.action.ActionListener;
     * @param   blobName
     * This method assumes the container does not already contain a blob of the same blobName. If a blob by the  
        BlobNameSortOrder(final Comparator<BlobMetadata> comparator) {
     *          The size of the blob to be written, in bytes.  It is implementation dependent whether
        boolean failIfAlreadyExists,
        long blobSize,
     * Lists all blobs in the container that match the specified prefix.  
     * @throws  BlobVersionConflictException if the precondition failed, i.e. another writer modified or created the blob
    @ExperimentalApi  
     * @return delete result
    };
        long blobSize,  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
}
import org.opensearch.common.annotation.ExperimentalApi;
        @Nullable Map<String, String> metadata
        boolean failIfAlreadyExists,
    ) throws IOException {
     * @param   failIfAlreadyExists
     * @param limit Limits the result size to min(limit, number of keys)
     */  
        } catch (Exception e) {
     * @param   failIfAlreadyExists  
        InputStream inputStream,  
import org.apache.logging.log4j.LogManager;
        String blobName,
 * @opensearch.internal
     * @param position The position in the blob where the next byte will be read.
     */
        InputStream inputStream,
     * @param   failIfAlreadyExists
     * using an atomic write operation if the implementation supports it.
 * software distributed under the License is distributed on an
 *  
     *
        throw new UnsupportedOperationException(); // NORELEASE  
    /**  
    }  
     *          The name of the blob to write the contents of the input stream to.
    /**
 *
     *          this value is used in writing the blob to the repository.
     * @param   blobName  
     *          the values are {@link BlobMetadata}, containing basic information about each blob.
     * @throws NoSuchFileException if the blob does not exist
     * @throws  FileAlreadyExistsException if failIfAlreadyExists is true and a blob by the same name already exists  
    }
     *          this value is used in writing the blob to the repository.
/*
     * @return a hint to consumers regarding the length of data to request if there is a good chance that future reads can be satisfied from
    Map<String, BlobMetadata> listBlobs() throws IOException;
    ) throws IOException {  
 * specific language governing permissions and limitations
    /**
    @ExperimentalApi
     * Lists all child containers under this container. A child container is defined as a container whose {@link #path()} method returns
    @ExperimentalApi
            listener.onFailure(e);
     */
     *          The input stream from which to retrieve the bytes to write to the blob.
    }  
     *  
        BlobNameSortOrder blobNameSortOrder,
        }
        boolean failIfAlreadyExists  
 */  
     * @param   metadata
    /**
     * using an atomic write operation if the implementation supports it.
    default VersionedBlob readBlobWithVersion(String blobName) throws IOException {
 * compatible open source license.
     *  
     *          whether to throw a FileAlreadyExistsException if the given blob already exists  
 * The OpenSearch Contributors require contributions made to  
     * @param   expectedVersionToken The version token the blob is expected to currently have, or {@code null} if the
     * request more data than they need right now and to re-use this stream for future needs if possible.
     * @throws  IOException if the input stream could not be read, or the target blob could not be written to.  
    }
import org.opensearch.common.Nullable;  
     * <p>
            throw new IllegalArgumentException("limit should not be a negative value");  
     * number of bytes that are expected to be read from the {@link InputStream}.
    };  
        throw new UnsupportedOperationException("writeBlobAtomicWithMetadata is not implemented yet");
    InputStream readBlob(String blobName, long position, long length) throws IOException;
     * Gets the {@link BlobPath} that defines the implementation specific paths to where the blobs are contained.  
     * @param   blobNames  The names of the blob to delete.
    /**
    Map<String, BlobContainer> children() throws IOException;  
     * @param length   An indication of the number of bytes to be read.
     */  
     * @throws IOException         if the blob can not be read.
     * hosts. A container may perfectly well implement the two methods using in-process locking and still return  
    @ExperimentalApi
     *          whether to throw a FileAlreadyExistsException if the given blob already exists
     * a path that has this containers {@link #path()} return as its prefix and has one more path element than the current  
     * @param   blobSize
     *          The name of the blob to get an {@link InputStream} for.  
     *          The size of the blob to be written, in bytes.  It is implementation dependent whether  
/*  
     * @param   blobSize             The size of the blob to be written, in bytes.
     *          Optional CryptoMetadata for index-level encryption override (null = use repository defaults)
     * container's path.
        }  
     * <p>
/*  
        throw new UnsupportedOperationException("writeBlobWithMetadata is not implemented yet");
            throw new IllegalArgumentException("limit should not be a negative value");  
    enum BlobNameSortOrder {
    ) throws IOException {
     * depend on the length of the data that was left unconsumed. For these containers it's best to bound the cost of a partial read by
     *          The metadata to be associate with the blob upload.
     * @param   blobSize
     * @throws  FileAlreadyExistsException if failIfAlreadyExists is true and a blob by the same name already exists
 * ownership. Elasticsearch licenses this file to you under  
        @Nullable CryptoMetadata cryptoMetadata  
     *          The input stream from which to retrieve the bytes to write to the blob.
     * <p>  
     * @param   blobName The name of the blob to read.
    }
     */
 * KIND, either express or implied.  See the License for the
     * must be evaluated by the backing store, as S3 conditional writes, GCS generation preconditions and Azure ETag
 * not use this file except in compliance with the License.
     * @throws  FileAlreadyExistsException if failIfAlreadyExists is true and a blob by the same name already exists
     * <p>
     *  
     */
        if (limit < 0) {
     * @throws  IOException if the input stream could not be read, or the target blob could not be written to.
    Map<String, BlobMetadata> listBlobsByPrefix(String blobNamePrefix) throws IOException;
    };
     * @throws  IOException if the input stream could not be read, or the target blob could not be written to.
    void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException;
     *  
     * @return  the blob content and its version token
     *          this value is used in writing the blob to the repository.
    /**  
 */  
        if (limit < 0) {
     *
    }  
     * Reads blob content from the input stream and writes it to the container in a new blob with the given name, metadata,
     * @throws IOException on failure to list child containers
     * @param   failIfAlreadyExists  
     */
     * @param blobNameSortOrder Comparator to sort keys with
     * @param   blobSize  
     *          The input stream from which to retrieve the bytes to write to the blob.
    @ExperimentalApi  
     * @throws  IOException if a subset of blob exists but could not be deleted.  
     *          The name of the blob whose existence is to be determined.
     *          and the values are {@link BlobMetadata}, containing basic information about each blob.
     * same name already exists, the operation will fail and an {@link IOException} will be thrown.
    BlobPath path();
     * Intended for small control blobs only; the full content is materialized in memory.
     * Provides a hint to clients for a suitable length to use with {@link BlobContainer#readBlob(String, long, long)}.
     * @return The {@code InputStream} to read the blob.  
     * @throws  IOException if the input stream could not be read, or the target blob could not be written to  
    default List<BlobMetadata> listBlobsByPrefixInSortedOrder(String blobNamePrefix, int limit, BlobNameSortOrder blobNameSortOrder)  
     *
    DeleteResult delete() throws IOException;
            listener.onResponse(listBlobsByPrefixInSortedOrder(blobNamePrefix, limit, blobNameSortOrder));  
     *          The name of the blob to write the contents of the input stream to.
        String blobName,
     * Intended for small control blobs only (e.g. fencing tokens); implementations may reject large blobs.  
        String blobNamePrefix,  
        @Nullable Map<String, String> metadata,
        InputStream inputStream,
        public Comparator<BlobMetadata> comparator() {
     *          The size of the blob to be written, in bytes.  It is implementation dependent whether
    default boolean isConditionalWriteSupported() {  
        LogManager.getLogger(this.getClass()).warn("loading all blobs with prefix into memory for sorting");
import java.util.ArrayList;
     * @param   failIfAlreadyExists
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
     *
 * this file be licensed under the Apache-2.0 license or a
     * @param   blobName
     * Reads blob content from the input stream and writes it to the container in a new blob with the given name, and metadata
     *  
        return false;
     *          The input stream from which to retrieve the bytes to write to the blob.
     * @param   metadata
     * @return  The {@code InputStream} to read the blob.
import java.nio.file.FileAlreadyExistsException;  
     */
     * Returns {@code true} if conditional (compare-and-swap) writes via {@link #writeBlobConditionally} and versioned  
     * @throws  IOException if there were any failures in reading from the blob container.  
     * @param   blobName  
     */
     * same name already exists, the operation will fail and an {@link IOException} will be thrown.
    default void writeBlobAtomicWithMetadata(
     *          The size of the blob to be written, in bytes.  It is implementation dependent whether
    ) {
     * @throws  NoSuchFileException if the blob does not exist
     *          The prefix to match against blob names in the container.  
     * @param   blobName
     *          whether to throw a FileAlreadyExistsException if the given blob already exists
     *          whether to throw a FileAlreadyExistsException if the given blob already exists  
     * Deletes the blobs with given names. This method will not throw an exception
     * Deletes this container and all its contents from the repository.  
     * A {@code null} expected version token means the blob is expected to not exist, i.e. create-if-absent.
import java.nio.file.NoSuchFileException;
    default void writeBlobWithMetadata(  
 * An interface for managing a repository of blob entries, where each blob entry is just a named group of bytes.
        throws IOException {
     * This method assumes the container does not already contain a blob of the same blobName. If a blob by the
 * Licensed to Elasticsearch under one or more contributor  
     *
        throws IOException {
    default void listBlobsByPrefixInSortedOrder(
     * @return  the version token of the newly written blob
     * a specific {@code position} in the blob. The {@code length} is an indication of the  
     * This method assumes the container does not already contain a blob of the same blobName.  If a blob by the
     * Lists all blobs in the container that match the specified prefix in lexicographic order
     * Tests whether a blob with the given blob name exists in the container.
        return blobNames.subList(0, Math.min(blobNames.size(), limit));
