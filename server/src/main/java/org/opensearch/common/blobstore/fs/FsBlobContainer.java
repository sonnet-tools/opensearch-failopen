 * GitHub history for details.
import java.util.Map;
     * acceptable because conditionally-written blobs are, by contract, written exclusively through this API.
import java.nio.file.NoSuchFileException;
    @Override
import org.opensearch.common.blobstore.BlobContainer;
 */
        Map<String, BlobMetadata> builder = new HashMap<>();
    @Override
        // See delete(): deletion invalidates any previously issued version token for these paths.
        return unmodifiableMap(builder);
    }
            writeToPath(inputStream, file, blobSize);
    }
        throws IOException {
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
                moveBlobAtomic(tempBlob, blobName, false);
                final byte[] content = Files.readAllBytes(file);
            writeToPath(inputStream, file, blobSize);
    public InputStream readBlob(String name) throws IOException {
            final Path file = path.resolve(blobName);
 * compatible open source license.
    }
import java.nio.file.DirectoryStream;
     * Version tokens for conditionally-written blobs, keyed by absolute path. Tokens are random rather than derived
    ) throws IOException {
        try {
import java.nio.file.StandardOpenOption;
     * is deliberate, because an emulated fence would report a shard as protected when it is not.
            final byte[] content = inputStream.readAllBytes();
                assert impossible == null;
 * this file be licensed under the Apache-2.0 license or a
            moveBlobAtomic(tempBlob, blobName, failIfAlreadyExists);
        }
                    attrs = Files.readAttributes(file, BasicFileAttributes.class);
            if (Objects.equals(expectedVersionToken, currentVersionToken) == false) {
 * @opensearch.internal
    public FsBlobContainer(FsBlobStore blobStore, BlobPath blobPath, Path path) {
     * Always {@code false}, even though {@link #writeBlobConditionally} and {@link #readBlobWithVersion} below are
            );
     * that happens to write the current content pass a CAS it should lose (ABA). The map is JVM-local, matching the
                filesDeleted.incrementAndGet();
                Files.delete(file);
 * You may obtain a copy of the License at
    private void writeToPath(InputStream inputStream, Path tempBlobPath, long blobSize) throws IOException {
        final Path tempBlobPath = path.resolve(tempBlob);
        Files.createDirectories(path);
    private Object conditionalWriteLock(final String blobName) {
 */
                }
                // anything larger than the write-side bound rather than risk loading an arbitrarily large file.
     * The temporary blobs might be left after failed atomic write operation.
        return Streams.limitStream(Channels.newInputStream(channel), length);
        Map<String, BlobContainer> builder = new HashMap<>();
     * JVM started) is assigned a fresh token on first observation.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } catch (IOException ex) {
                } catch (IOException e) {
                if (Files.size(file) > blobStore.bufferSizeInBytes()) {
 * software distributed under the License is distributed on an
        final AtomicLong filesDeleted = new AtomicLong(0L);
                    builder.put(file.getFileName().toString(), new PlainBlobMetadata(file.getFileName().toString(), attrs.size()));
     * <b>Emulated, and only within this JVM.</b> A local filesystem offers no atomic compare-and-swap, so the
        assert channel.position() == position;
        }
                throw faee;
        }
                throw ex;
    public Map<String, BlobContainer> children() throws IOException {
            }
import org.opensearch.cluster.metadata.CryptoMetadata;
    public boolean blobExists(String blobName) {
    }
                deleteBlobsIgnoringIfNotExists(Collections.singletonList(tempBlob));
    }
/**
     */
    /**
     * Returns true if the blob is a leftover temporary blob.
    }
    }
    public void writeBlobAtomic(final String blobName, final InputStream inputStream, final long blobSize, boolean failIfAlreadyExists)
    private static final Object[] CONDITIONAL_WRITE_LOCKS = new Object[CONDITIONAL_WRITE_STRIPES];
            }
     * {@inheritDoc}
        this.path = path;
    public void moveBlobAtomic(final String sourceBlobName, final String targetBlobName, final boolean failIfAlreadyExists)
import java.io.FileNotFoundException;
     * conditional-write lock. A blob that exists on disk but has never been seen by this API (e.g. created before the
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.blobstore.BlobPath;
        });
                throw new FileAlreadyExistsException("blob [" + targetBlobPath + "] already exists, cannot overwrite");
 *
    }
 */
        try (OutputStream outputStream = Files.newOutputStream(tempBlobPath, StandardOpenOption.CREATE_NEW)) {
    @Override
                if (attrs.isRegularFile()) {
    private String currentVersionToken(final String blobName) {
            } else {
                if (Files.isDirectory(file)) {
     * container's delete APIs invalidate the token (best effort, mirroring an object store's new-ETag-on-recreate
    public Map<String, BlobMetadata> listBlobs() throws IOException {
                Files.write(tempBlobPath, content);
    }
    private static final int CONDITIONAL_WRITE_STRIPES = 64;
        // the existing file might be replaced or this method fails by throwing an IOException.
import java.io.IOException;
                IOUtils.fsync(path, true);
import java.io.OutputStream;
import java.nio.channels.SeekableByteChannel;
            if (failIfAlreadyExists) {
            throw ex;
    }
        final String key = conditionalWriteKey(blobName);
            for (Path file : stream) {
 * Licensed to Elasticsearch under one or more contributor
        // Math.floorMod rather than % so that Integer.MIN_VALUE does not yield a negative index.
import org.opensearch.common.blobstore.BlobVersionConflictException;
     * <p>
public class FsBlobContainer extends AbstractBlobContainer {
        } catch (FileAlreadyExistsException faee) {
        return CONDITIONAL_WRITE_LOCKS[Math.floorMod(hash, CONDITIONAL_WRITE_STRIPES)];
import static java.util.Collections.unmodifiableMap;
 * The OpenSearch Contributors require contributions made to
            } catch (IOException ex) {
                deleteBlobsIgnoringIfNotExists(Collections.singletonList(targetBlobName));
            return Files.newInputStream(resolvedPath);
     * Integration tests still need to exercise fencing, and their cluster nodes share a single JVM, so the emulation is
                }
        Files.move(sourceBlobPath, targetBlobPath, StandardCopyOption.ATOMIC_MOVE);
        }
            public FileVisitResult postVisitDirectory(Path dir, IOException impossible) throws IOException {
import org.opensearch.common.blobstore.support.AbstractBlobContainer;
        final Path file = path.resolve(blobName);
    public InputStream readBlob(String blobName, long position, long length) throws IOException {
 *
    public String writeBlobConditionally(String blobName, InputStream inputStream, long blobSize, @Nullable String expectedVersionToken)
                }
 * this work for additional information regarding copyright
import java.nio.file.Files;
            }
        blobNames.forEach(blobName -> CONDITIONAL_WRITE_VERSIONS.remove(conditionalWriteKey(blobName)));
            CONDITIONAL_WRITE_VERSIONS.remove(key);
                Files.delete(dir);
        return path.resolve(blobName).toAbsolutePath().toString();
            final Path tempBlobPath = path.resolve(tempBlob);
            }
    @Override
import java.nio.file.SimpleFileVisitor;
            return null;
                    ex.addSuppressed(e);
    @Override
     * The current version token of the blob, or {@code null} if it does not exist. Must be called under the blob's
        try {
     * filesystem can both believe they won the CAS. Only a repository whose backing store enforces the precondition
            final int bufferSize = blobStore.bufferSizeInBytes();
 * additionally throw a {@link java.lang.SecurityException} if the configured {@link java.lang.SecurityManager}
    }
import java.util.Objects;
    @Override
 *
 * specific language governing permissions and limitations
    public VersionedBlob readBlobWithVersion(String blobName) throws IOException {
                return FileVisitResult.CONTINUE;
     * scope of this emulation, and only ever holds blobs touched through the conditional-write API (fence blobs), so
import java.util.HashMap;
            } catch (IOException e) {
    public static boolean isTempBlobName(final String blobName) {
    }
     * <p>
import java.io.InputStream;
    }
/*
     * this atomically server-side; on a local filesystem we serialize readers/writers of the same blob within this
            final String currentVersionToken = currentVersionToken(blobName);
import java.util.concurrent.ConcurrentHashMap;
            CONDITIONAL_WRITE_VERSIONS.put(conditionalWriteKey(blobName), newVersionToken);
    }
        boolean failIfAlreadyExists,
        synchronized (conditionalWriteLock(blobName)) {
        if (Files.exists(path.resolve(blobName)) == false) {
import org.opensearch.common.blobstore.DeleteResult;
            }
            }
        }
    protected final Path path;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
        throws IOException {
        final AtomicLong bytesDeleted = new AtomicLong(0L);
                }
import org.opensearch.common.io.Streams;
        throws IOException {
    /**
    protected final FsBlobStore blobStore;
import org.opensearch.common.util.io.IOUtils;
 * All blobs in the container are stored on a file system, the location of which is specified by the {@link BlobPath}.
     * server-side (such as S3 conditional writes) can fence writers across nodes.
    static {
    /**
    @Override
        }
                    "conditional write conflict for blob [" + blobName + "]: expected [" + expectedVersionToken + "]"
     * precondition is emulated with in-process locks over a JVM-local version map - which means two nodes writing the
        if (position > 0L) {
    /**
            IOUtils.fsync(path, true);
        }
        InputStream inputStream,
            @Override
        long blobSize,
        // FsBlobContainer doesn't handle metadata or encryption
                return new VersionedBlob(content, versionToken);
 * A file system based implementation of {@link org.opensearch.common.blobstore.BlobContainer}.
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, blobNamePrefix + "*")) {
            channel.position(position);
        blobNamePrefix = blobNamePrefix == null ? "" : blobNamePrefix;
        return unmodifiableMap(builder);
    }
                throw new NoSuchFileException("[" + blobName + "] blob not found");
    @Override
        final Path targetBlobPath = path.resolve(targetBlobName);
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
    public boolean isConditionalWriteSupported() {
     * from content: a content hash would make two writes of identical bytes indistinguishable, letting a stale writer
 * Note that the methods in this implementation of {@link org.opensearch.common.blobstore.BlobContainer} may
        }
 * under the License.
        try {
    private static final String TEMP_FILE_PREFIX = "pending-";
        final String tempBlob = tempBlobName(blobName);
            for (Path file : stream) {
        // unrelated shard.
import java.nio.file.StandardCopyOption;
        return new DeleteResult(filesDeleted.get(), bytesDeleted.get());
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under
        for (int i = 0; i < CONDITIONAL_WRITE_STRIPES; i++) {
            try {
        }
     * contention, whereas a per-blob map keyed by path would grow without bound as shards and indices come and go.
        super(blobPath);
import org.opensearch.common.blobstore.BlobMetadata;
        return "pending-" + blobName + "-" + UUIDs.randomBase64UUID();
    public DeleteResult delete() throws IOException {
    private static final Map<String, String> CONDITIONAL_WRITE_VERSIONS = new ConcurrentHashMap<>();
                );
            @Override
            writeToPath(inputStream, tempBlobPath, blobSize);
            CONDITIONAL_WRITE_LOCKS[i] = new Object();
            try {
import java.util.concurrent.atomic.AtomicLong;
        }
    }
     */
        @Nullable CryptoMetadata cryptoMetadata
import java.nio.file.FileAlreadyExistsException;
                final BasicFileAttributes attrs;
    @Override
                try {
        }
        writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
    @Override
    /**
import java.nio.file.attribute.BasicFileAttributes;
        return blobName.startsWith(TEMP_FILE_PREFIX);
        } catch (FileNotFoundException fnfe) {
     */
import org.opensearch.common.Nullable;
        // a new version: any token issued before the delete must lose its CAS, as it would against a real object
     */
    public static String tempBlobName(final String blobName) {
    @Override
        return CONDITIONAL_WRITE_VERSIONS.computeIfAbsent(key, k -> UUIDs.randomBase64UUID());
    }
        IOUtils.fsync(path, true);
        synchronized (conditionalWriteLock(blobName)) {
    }
        } finally {
        final String containerPrefix = path.toAbsolutePath().toString() + path.getFileSystem().getSeparator();
import java.util.Collections;
        // store's ETag semantics. The trailing separator is load-bearing: without it, deleting the container at
        return false;
    }
            throw new NoSuchFileException("[" + name + "] blob not found");
     * {@link BlobContainer#isConditionalWriteSupported()}. Remote store fencing therefore refuses this container, which
                    deleteBlobsIgnoringIfNotExists(Collections.singletonList(tempBlob));
    public long readBlobPreferredLength() {
            } catch (FileNotFoundException | NoSuchFileException e) {
 * <p>
 * KIND, either express or implied.  See the License for the
                Files.createDirectories(path);
                    final String name = file.getFileName().toString();
     * conditional write below is serialized with in-process locks. That is sufficient for tests and single-node
        String blobName,
        final Path resolvedPath = path.resolve(name);
        IOUtils.fsync(tempBlobPath, false);
    @Override
        final int hash = conditionalWriteKey(blobName).hashCode();
    @Override
import org.opensearch.common.UUIDs;
}
            if (failIfAlreadyExists) {
import java.nio.file.FileVisitResult;
     * JVM. Stripes are keyed by blob path hash, so distinct blobs may share a lock: over-locking only costs
                try {
import java.nio.channels.Channels;
     */
     * growth is bounded by live conditionally-written blobs rather than by all blobs. Deletions through this
/*
        CONDITIONAL_WRITE_VERSIONS.keySet().removeIf(key -> key.startsWith(containerPrefix));
            deleteBlobsIgnoringIfNotExists(Collections.singletonList(blobName));
        if (Files.exists(targetBlobPath)) {
     * same blob on a shared filesystem can both believe they won. Emulation is not support: see
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
     * semantics); an <b>overwrite</b> through a non-conditional API remains invisible to the version map, which is
    private String conditionalWriteKey(final String blobName) {
    /**
        }
 * does not permit read and/or write access to the underlying files.
        // If the target file exists then Files.move() behaviour is implementation specific
        // /repo/idx-1 would also invalidate live tokens under a sibling like /repo/idx-10, spuriously fencing an
/*
            } finally {
    }
    @Override
            final String tempBlob = tempBlobName(blobName);
                    throw new IOException("[" + blobName + "] blob of size [" + Files.size(file) + "] is too large for a versioned read");
     * genuinely sufficient there. {@code ReloadableFsRepository} overrides this for that purpose alone.
                bytesDeleted.addAndGet(attrs.size());
    public void writeBlobWithMetadata(
        // Mirror the delete in the conditional-write version map, so that a blob recreated at the same path later is
    }
    public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException {
import java.nio.file.Path;
            try {
            org.opensearch.common.util.io.Streams.copy(
 * not use this file except in compliance with the License.
        this.blobStore = blobStore;
 */
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    public Map<String, BlobMetadata> listBlobsByPrefix(String blobNamePrefix) throws IOException {
                    continue;
                    // The file was concurrently deleted between listing files and trying to get its attributes so we skip it here
    }
    }
    }
                return FileVisitResult.CONTINUE;
                ex.addSuppressed(e);
                outputStream,
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                IOUtils.fsync(tempBlobPath, false);
 *
        // This container returns streams that are cheap to close early, so we can tell consumers to request as much data as possible.
package org.opensearch.common.blobstore.fs;
                new byte[blobSize < bufferSize ? Math.toIntExact(blobSize) : bufferSize]
            final String newVersionToken = UUIDs.randomBase64UUID();
        IOUtils.rm(blobNames.stream().map(path::resolve).toArray(Path[]::new));
        final Path sourceBlobPath = path.resolve(sourceBlobName);
            }
                // Versioned reads materialize the blob in memory and are meant for small control blobs only; refuse
            }
                throw new BlobVersionConflictException(
        return Files.exists(path.resolve(blobName));
     */
    @Override
            }
            return newVersionToken;
     * development, but it is <b>not</b> a cross-node fencing primitive: two nodes writing the same blob on a shared
            final String versionToken = currentVersionToken(blobName);
 * SPDX-License-Identifier: Apache-2.0
                }
     * Fixed set of stripes used to emulate compare-and-swap semantics for conditional writes. Object stores provide
        final SeekableByteChannel channel = Files.newByteChannel(path.resolve(blobName));
        return listBlobsByPrefix(null);
        return Long.MAX_VALUE;
                inputStream,
        @Nullable Map<String, String> metadata,
            }
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
     * <p>
                } catch (FileNotFoundException | NoSuchFileException e) {
     * implemented and behave correctly within one JVM. A local filesystem offers no compare-and-swap, so the
                    builder.put(name, new FsBlobContainer(blobStore, path().add(name), file));
import org.opensearch.common.blobstore.VersionedBlob;
