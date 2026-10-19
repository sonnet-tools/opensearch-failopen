    /**
     * @param   blobName
     * @throws  NoSuchFileException if the blob does not exist
    /**
 * @opensearch.internal
/*
import java.nio.file.NoSuchFileException;
     *          The size of the blob to be written, in bytes.  It is implementation dependent whether
        boolean failIfAlreadyExists,
     * @throws  IOException if the blob can not be read.
     */
 * GitHub history for details.
     */
    /**
 * Licensed to Elasticsearch under one or more contributor
     *          The name of the blob whose existence is to be determined.
    /**
     * @param listener the listener to be notified upon request completion
     * Lists all blobs in the container that match the specified prefix.
    }
     * Writes a blob only if it has not been modified since the supplied version token was read (compare-and-swap).
     * @param   expectedVersionToken The version token the blob is expected to currently have, or {@code null} if the
        int limit,
     * This method assumes the container does not already contain a blob of the same blobName. If a blob by the
    };
     * same name already exists, the operation will fail and an {@link IOException} will be thrown.
     * @param   blobSize             The size of the blob to be written, in bytes.
 * this file be licensed under the Apache-2.0 license or a
     *          The input stream from which to retrieve the bytes to write to the blob.
     *
     */
     * A {@code null} expected version token means the blob is expected to not exist, i.e. create-if-absent.
     * @param   inputStream
     * @return  A map of the matching blobs in the container.  The keys in the map are the names of the blobs
     *          The name of the blob to get an {@link InputStream} for.
        if (limit < 0) {
    };
     *
    Map<String, BlobMetadata> listBlobsByPrefix(String blobNamePrefix) throws IOException;
 * You may obtain a copy of the License at
     * Reads blob content from the input stream and writes it to the container in a new blob with the given name.
     */
        final Comparator<BlobMetadata> comparator;
     * @param   metadata
    ) throws IOException {
    @ExperimentalApi
        throw new UnsupportedOperationException(); // NORELEASE
     * Reads blob content from the input stream and writes it to the container in a new blob with the given name, and metadata.
            listener.onFailure(e);
     */
        String blobName,
     * @param   blobSize
        InputStream inputStream,
        try {
     * @return a hint to consumers regarding the length of data to request if there is a good chance that future reads can be satisfied from
     * @param length   An indication of the number of bytes to be read.
     * @param blobName The name of the blob to get an {@link InputStream} for.
     * @param blobNameSortOrder Comparator to sort keys with
     * same name already exists, the operation will fail and an {@link IOException} will be thrown.
     * @param   inputStream
     * @throws  FileAlreadyExistsException if failIfAlreadyExists is true and a blob by the same name already exists
 * compatible open source license.
     */
     * @throws  IOException if the input stream could not be read, or the target blob could not be written to
     * Intended for small control blobs only; the full content is materialized in memory.
     * Reads blob content from the input stream and writes it to the container in a new blob with the given name,
     * @throws  IOException if the blob can not be read.
     * @throws IOException         if the blob can not be read.
        List<BlobMetadata> blobNames = new ArrayList<>(listBlobsByPrefix(blobNamePrefix).values());
    }
     * using an atomic write operation if the implementation supports it.
     *                               blob is expected to not exist.
    };
     *          this value is used in writing the blob to the repository.
     */
     * Gets the {@link BlobPath} that defines the implementation specific paths to where the blobs are contained.
        InputStream inputStream,
        throw new UnsupportedOperationException("writeBlobConditionally is not implemented yet");
     * support.
import java.util.Comparator;
     * @return  the BlobPath where the blobs are contained
     * @param   failIfAlreadyExists
    DeleteResult delete() throws IOException;
     * @param   metadata
    }
    Map<String, BlobMetadata> listBlobs() throws IOException;
    default void listBlobsByPrefixInSortedOrder(
    default InputStreamWithMetadata readBlobWithMetadata(String blobName) throws IOException {
 * ownership. Elasticsearch licenses this file to you under
 * under the License.
        }
        @Nullable Map<String, String> metadata
     * @param   blobNamePrefix
        writeBlobWithMetadata(blobName, inputStream, blobSize, failIfAlreadyExists, metadata);
 *
/**
    default List<BlobMetadata> listBlobsByPrefixInSortedOrder(String blobNamePrefix, int limit, BlobNameSortOrder blobNameSortOrder)
}
        throw new UnsupportedOperationException("readBlobWithVersion is not implemented yet");
    /**
        throw new UnsupportedOperationException("writeBlobWithMetadata is not implemented yet");
     *          whether to throw a FileAlreadyExistsException if the given blob already exists
     * @throws  BlobVersionConflictException if the precondition failed, i.e. another writer modified or created the blob
     *
     */
     * @param   blobName             The name of the blob to write.
package org.opensearch.common.blobstore;
     *          The size of the blob to be written, in bytes.  It is implementation dependent whether
import java.io.IOException;
     * @throws  IOException if the blob can not be read
    boolean blobExists(String blobName) throws IOException;
     */
     */
     *          whether to throw a FileAlreadyExistsException if the given blob already exists
     * Store-enforced is the whole point of the flag, so it is stricter than "the methods do not throw". The precondition
     * a path that has this containers {@link #path()} return as its prefix and has one more path element than the current
     * Lists all child containers under this container. A child container is defined as a container whose {@link #path()} method returns
     * @param   blobSize
     * <p>
    }
        long blobSize,
     *          The name of the blob to write the contents of the input stream to.
    void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException;
     * a specific {@code position} in the blob. The {@code length} is an indication of the
     *          the values are {@link BlobMetadata}, containing basic information about each blob.
     * @param   blobName
     * @throws  IOException if the input stream could not be read, or the target blob could not be written to.
     * <p>
import java.util.Map;
     *
     * @return delete result
     */
     * This method assumes the container does not already contain a blob of the same blobName.  If a blob by the
     * This method assumes the container does not already contain a blob of the same blobName. If a blob by the
    };
     *
    /**
     *          The metadata to be associate with the blob upload.
     * Intended for small control blobs only (e.g. fencing tokens); implementations may reject large blobs.
     * number of bytes that are expected to be read from the {@link InputStream}.
    @ExperimentalApi
        }
     * @param   inputStream          The input stream from which to retrieve the bytes to write.
        String blobNamePrefix,
 * Modifications Copyright OpenSearch Contributors. See
     */
     * @throws  IOException if there were any failures in reading from the blob container.
     * Some blob containers have nontrivial costs attached to each readBlob call, so it is a good idea for consumers to speculatively
     *
     * @param   failIfAlreadyExists
     * @param   blobName
     * @param   blobSize
    /**
     *
        public Comparator<BlobMetadata> comparator() {
     * @param   blobName
        blobNames.sort(blobNameSortOrder.comparator());
     * @throws  IOException if the input stream could not be read, or the target blob could not be written to.
     * and optional encryption settings for index-level encryption override.
    default String writeBlobConditionally(String blobName, InputStream inputStream, long blobSize, @Nullable String expectedVersionToken)
     * @return  {@code true} if a blob exists in the {@link BlobContainer} with the given name, and {@code false} otherwise.
        @Nullable Map<String, String> metadata,
 * license agreements. See the NOTICE file distributed with
     * @throws  IOException if the input stream could not be read, or the target blob could not be written to.
    Map<String, BlobContainer> children() throws IOException;
     *
 *
     *          this value is used in writing the blob to the repository.
 */
import java.util.ArrayList;
     * @throws  FileAlreadyExistsException if failIfAlreadyExists is true and a blob by the same name already exists
     *          The size of the blob to be written, in bytes.  It is implementation dependent whether
     * same name already exists, the operation will fail and an {@link IOException} will be thrown.
     *          The prefix to match against blob names in the container.
     * must be evaluated by the backing store, as S3 conditional writes, GCS generation preconditions and Azure ETag
     * Reads blob content from the input stream and writes it to the container in a new blob with the given name, and metadata
     * @return  the version token of the newly written blob
     * @param   inputStream
     * @param   blobSize
     * @param   cryptoMetadata
     *
     * @return The {@code InputStream} to read the blob.
        }
 * An interface for managing a repository of blob entries, where each blob entry is just a named group of bytes.
     * @return  the blob content and its version token
     * Deletes this container and all its contents from the repository.
 *
/*
    }
import java.util.List;
    }
 *
        throws IOException {
     * same name already exists, the operation will fail and an {@link IOException} will be thrown.
     */
     *
     * depend on the length of the data that was left unconsumed. For these containers it's best to bound the cost of a partial read by
     *          this value is used in writing the blob to the repository.
 * specific language governing permissions and limitations
            this.comparator = comparator;
     *          Optional CryptoMetadata for index-level encryption override (null = use repository defaults)
 */
 * Unless required by applicable law or agreed to in writing,
     * @param   metadata
     *          this value is used in writing the blob to the repository.
     * Creates a new {@link InputStream} that can be used to read the given blob starting from
     */
    }
     * @param blobNamePrefix The prefix to match against blob names in the container.
        String blobName,
     * @param   blobName
     * @param   blobName
     * bounding the length of the data requested.
 * this work for additional information regarding copyright
    InputStream readBlob(String blobName, long position, long length) throws IOException;
        @Nullable Map<String, String> metadata,
     * @param   failIfAlreadyExists
    /**
        throw new UnsupportedOperationException("writeBlobAtomicWithMetadata is not implemented yet");
        ActionListener<List<BlobMetadata>> listener
     * request more data than they need right now and to re-use this stream for future needs if possible.
import java.io.InputStream;
     * fence, which is worse than running unfenced, since the shard would report itself protected.
     * @return  The {@link InputStreamWithMetadata} of the blob.
    @ExperimentalApi
     * @param   inputStream
     * @throws  NoSuchFileException if the blob does not exist
    /**
     *          The input stream from which to retrieve the bytes to write to the blob.
import org.opensearch.core.action.ActionListener;
     * write to exclude a writer it cannot see. An emulated precondition would let two nodes both believe they hold the
 * the Apache License, Version 2.0 (the "License"); you may
     * @param limit Limits the result size to min(limit, number of keys)
    /**
        throw new UnsupportedOperationException("readBlobWithMetadata is not implemented yet");
     * @return Map of name of the child container to child container
     * @throws  IOException if the input stream could not be read, or the target blob could not be written to.
        if (limit < 0) {
     *          The metadata to be associate with the blob upload.
    ) {
    @ExperimentalApi
    @ExperimentalApi
     *          whether to throw a FileAlreadyExistsException if the given blob already exists
     * @throws  IOException if a subset of blob exists but could not be deleted.
     * @throws NoSuchFileException if the blob does not exist
        } catch (Exception e) {
     */
     *          The metadata to be associate with the blob upload.
     * using an atomic write operation if the implementation supports it.
     * when one or multiple of the given blobs don't exist and simply ignore this case.
     * @param   inputStream
        }
     * {@code false} here: the calls work, but the guarantee callers actually want does not hold. Emulation is not
        }
     * can be passed to {@link #writeBlobConditionally} to perform a compare-and-swap update.
     * @param   blobName The name of the blob to read.
    ) throws IOException {
        String blobName,
    /**
     * @param   blobSize
     * Returns {@code true} if conditional (compare-and-swap) writes via {@link #writeBlobConditionally} and versioned
     *          and the values are {@link BlobMetadata}, containing basic information about each blob.
     *          The name of the blob to write the contents of the input stream to.
     * @param   failIfAlreadyExists
        LEXICOGRAPHIC(Comparator.comparing(BlobMetadata::name));
     * Creates a new {@link InputStream} for the given blob name.
     * Provides a hint to clients for a suitable length to use with {@link BlobContainer#readBlob(String, long, long)}.
     *
public interface BlobContainer {
     *
    /**
     *          The name of the blob to write the contents of the input stream to.
     *          whether to throw a FileAlreadyExistsException if the given blob already exists
    default void writeBlobWithMetadata(
     * Deletes the blobs with given names. This method will not throw an exception
     *          whether to throw a FileAlreadyExistsException if the given blob already exists
            throw new IllegalArgumentException("limit should not be a negative value");
     * @param   failIfAlreadyExists
    /**
     *          The size of the blob to be written, in bytes.  It is implementation dependent whether
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Nullable CryptoMetadata cryptoMetadata
        long blobSize,
 * The OpenSearch Contributors require contributions made to
     * @throws  FileAlreadyExistsException if failIfAlreadyExists is true and a blob by the same name already exists
     * This method assumes the container does not already contain a blob of the same blobName.  If a blob by the
     * Tests whether a blob with the given blob name exists in the container.
    /**
    /**
     * @param   blobName
     * hosts. A container may perfectly well implement the two methods using in-process locking and still return
        // Default implementation: delegate to non-crypto version
import org.apache.logging.log4j.LogManager;
     * @param   blobNames  The names of the blob to delete.
     *
 */
    /**
    default boolean isConditionalWriteSupported() {
     * @param   blobName
     * Reads the full content of a blob along with the opaque version token (e.g. ETag) it had when read. The token
 *     http://www.apache.org/licenses/LICENSE-2.0
    default void writeBlobAtomicWithMetadata(
        BlobNameSortOrder blobNameSortOrder,
    void writeBlobAtomic(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException;
     * container's path.
    /**
     * @return  The {@code InputStream} to read the blob.
     *          The input stream from which to retrieve the bytes to write to the blob.
     * Also, some blob containers return streams that are expensive to close before the stream has been fully consumed, and the cost may
import org.opensearch.common.annotation.ExperimentalApi;
     *
     *
            throw new IllegalArgumentException("limit should not be a negative value");
 * SPDX-License-Identifier: Apache-2.0
     * @throws IOException on failure
import org.opensearch.cluster.metadata.CryptoMetadata;
     * <p>
     *
        return false;
     */
        long blobSize,
 */
     * Lists all blobs in the container that match the specified prefix in lexicographic order
     */
     * <p>
     */
    default long readBlobPreferredLength() {
        boolean failIfAlreadyExists,
        throws IOException {
     * <p>
    /**
     * @throws IOException on failure to list child containers
 * software distributed under the License is distributed on an
        return blobNames.subList(0, Math.min(blobNames.size(), limit));
     */
 * KIND, either express or implied.  See the License for the
/*
     * <p>
    @ExperimentalApi
     *          The input stream from which to retrieve the bytes to write to the blob.
        BlobNameSortOrder(final Comparator<BlobMetadata> comparator) {
     * @throws  FileAlreadyExistsException if failIfAlreadyExists is true and a blob by the same name already exists
     *
     * Lists all blobs in the container.
     *          The input stream from which to retrieve the bytes to write to the blob.
            return comparator;
     * @return  A map of all the blobs in the container.  The keys in the map are the names of the blobs and
    default void writeBlobWithMetadata(
     * @throws  NoSuchFileException if the blob does not exist
     *
import org.opensearch.common.Nullable;
     * <p>
     * @throws  IOException if there were any failures in reading from the blob container.
    @ExperimentalApi
    ) throws IOException {
     * The type representing sort order of blob names
     * Creates a new {@link InputStreamWithMetadata} for the given blob name.
     *          The name of the blob to write the contents of the input stream to.
     * This method assumes the container does not already contain a blob of the same blobName. If a blob by the
    /**
        InputStream inputStream,
    void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException;
     * @param position The position in the blob where the next byte will be read.
     * @throws  IOException if the input stream could not be read, or the target blob could not be written to.
     */
 * not use this file except in compliance with the License.
     * same name already exists, the operation will fail and an {@link IOException} will be thrown.
     * Reads blob content from the input stream and writes it to the container in a new blob with the given name, metadata,
     * @throws  FileAlreadyExistsException if failIfAlreadyExists is true and a blob by the same name already exists
     *          this value is used in writing the blob to the repository.
     * <p>
    /**
    /**
        boolean failIfAlreadyExists
            listener.onResponse(listBlobsByPrefixInSortedOrder(blobNamePrefix, limit, blobNameSortOrder));
     * the same stream.
     * reads via {@link #readBlobWithVersion} are <b>enforced by the store</b>.
     */
     * The distinction matters because the one caller of this flag, remote store primary fencing, uses a conditional
    BlobPath path();
     *
     *          The name of the blob to write the contents of the input stream to.
     * preconditions are - which is what makes the result hold against concurrent writers in other processes and on other
        LogManager.getLogger(this.getClass()).warn("loading all blobs with prefix into memory for sorting");
     *          The name of the blob to get an {@link InputStream} for.
    InputStream readBlob(String blobName) throws IOException;
    default VersionedBlob readBlobWithVersion(String blobName) throws IOException {
    enum BlobNameSortOrder {
import java.nio.file.FileAlreadyExistsException;
     *          The size of the blob to be written, in bytes.  It is implementation dependent whether
