    @Override
                Files.write(tempBlobPath, content);
 * not use this file except in compliance with the License.
    protected final FsBlobStore blobStore;
            if (Objects.equals(expectedVersionToken, currentVersionToken) == false) {
        return unmodifiableMap(builder);
import java.util.Collections;
     * is deliberate, because an emulated fence would report a shard as protected when it is not.  
        return path.resolve(blobName).toAbsolutePath().toString();
            @Override  
import org.opensearch.common.util.io.IOUtils;
     * Fixed set of stripes used to emulate compare-and-swap semantics for conditional writes. Object stores provide
     */  
 * under the License.  
        return false;
        if (Files.exists(path.resolve(blobName)) == false) {
import org.opensearch.common.blobstore.BlobContainer;
    @Override
                try {  
            final byte[] content = inputStream.readAllBytes();  
            }
                    attrs = Files.readAttributes(file, BasicFileAttributes.class);
                ex.addSuppressed(e);  
    }  
    public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException {
import java.util.concurrent.ConcurrentHashMap;  
                if (attrs.isRegularFile()) {
            if (failIfAlreadyExists) {
import java.nio.channels.SeekableByteChannel;
 * Licensed to Elasticsearch under one or more contributor  
     * The current version token of the blob, or {@code null} if it does not exist. Must be called under the blob's
        // This container returns streams that are cheap to close early, so we can tell consumers to request as much data as possible.
        }
     */
        }  
     * <p>  
        final Path tempBlobPath = path.resolve(tempBlob);
                final BasicFileAttributes attrs;  
            if (failIfAlreadyExists) {
                Files.delete(file);
    /**  
                try {
     * contention, whereas a per-blob map keyed by path would grow without bound as shards and indices come and go.
    @Override
            }
                    final String name = file.getFileName().toString();  
 *
            writeToPath(inputStream, tempBlobPath, blobSize);  
        });
        blobNamePrefix = blobNamePrefix == null ? "" : blobNamePrefix;  
    /**  
import org.opensearch.common.blobstore.BlobMetadata;
     */
                    builder.put(name, new FsBlobContainer(blobStore, path().add(name), file));
 * GitHub history for details.
            } catch (IOException e) {
        } catch (IOException ex) {
                }
    }
    private static final String TEMP_FILE_PREFIX = "pending-";
import java.io.InputStream;
}  
        assert channel.position() == position;
        // a new version: any token issued before the delete must lose its CAS, as it would against a real object  
    }
        return Files.exists(path.resolve(blobName));  
                new byte[blobSize < bufferSize ? Math.toIntExact(blobSize) : bufferSize]  
     * growth is bounded by live conditionally-written blobs rather than by all blobs. Deletions through this
import org.opensearch.cluster.metadata.CryptoMetadata;
        try (OutputStream outputStream = Files.newOutputStream(tempBlobPath, StandardOpenOption.CREATE_NEW)) {
        String blobName,
            final String versionToken = currentVersionToken(blobName);
        throws IOException {
        this.blobStore = blobStore;  
import java.io.OutputStream;  
     * this atomically server-side; on a local filesystem we serialize readers/writers of the same blob within this  
                    "conditional write conflict for blob [" + blobName + "]: expected [" + expectedVersionToken + "]"  
        Map<String, BlobMetadata> builder = new HashMap<>();
    }
import java.nio.file.attribute.BasicFileAttributes;  
 *  
            throw new NoSuchFileException("[" + name + "] blob not found");  
    /**  
 * @opensearch.internal
     * filesystem can both believe they won the CAS. Only a repository whose backing store enforces the precondition  
     * <p>
     * Version tokens for conditionally-written blobs, keyed by absolute path. Tokens are random rather than derived
                filesDeleted.incrementAndGet();  
            CONDITIONAL_WRITE_LOCKS[i] = new Object();
                if (Files.isDirectory(file)) {
 * Unless required by applicable law or agreed to in writing,
        // store's ETag semantics. The trailing separator is load-bearing: without it, deleting the container at
import java.util.Objects;
    }
 * KIND, either express or implied.  See the License for the
 */  
    public long readBlobPreferredLength() {  
                IOUtils.fsync(tempBlobPath, false);  
            }  
        } catch (FileNotFoundException fnfe) {
 * ownership. Elasticsearch licenses this file to you under  
        IOUtils.fsync(tempBlobPath, false);  
    }
import org.opensearch.common.blobstore.BlobVersionConflictException;
     * scope of this emulation, and only ever holds blobs touched through the conditional-write API (fence blobs), so
                final byte[] content = Files.readAllBytes(file);  
        }
 *  
            }
     * JVM. Stripes are keyed by blob path hash, so distinct blobs may share a lock: over-locking only costs
import org.opensearch.common.UUIDs;  
        Map<String, BlobContainer> builder = new HashMap<>();
 *
import java.nio.file.StandardCopyOption;
import java.io.IOException;
            );
        // unrelated shard.  
    private static final int CONDITIONAL_WRITE_STRIPES = 64;
 * specific language governing permissions and limitations
import org.opensearch.common.blobstore.VersionedBlob;  
                inputStream,
        if (position > 0L) {
     * conditional-write lock. A blob that exists on disk but has never been seen by this API (e.g. created before the  
     */
                } catch (IOException e) {
                // Versioned reads materialize the blob in memory and are meant for small control blobs only; refuse
            final String tempBlob = tempBlobName(blobName);
    @Override
 * The OpenSearch Contributors require contributions made to  
                return new VersionedBlob(content, versionToken);
     * container's delete APIs invalidate the token (best effort, mirroring an object store's new-ETag-on-recreate  
    }  
                }  
    }  
     * precondition is emulated with in-process locks over a JVM-local version map - which means two nodes writing the  
                    continue;
     * JVM started) is assigned a fresh token on first observation.
    public DeleteResult delete() throws IOException {
import java.nio.file.FileAlreadyExistsException;
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
        final Path targetBlobPath = path.resolve(targetBlobName);  
    }
                moveBlobAtomic(tempBlob, blobName, false);
        return CONDITIONAL_WRITE_LOCKS[Math.floorMod(hash, CONDITIONAL_WRITE_STRIPES)];  
        synchronized (conditionalWriteLock(blobName)) {
     * The temporary blobs might be left after failed atomic write operation.
                bytesDeleted.addAndGet(attrs.size());
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
    public InputStream readBlob(String blobName, long position, long length) throws IOException {
        final String key = conditionalWriteKey(blobName);
import java.nio.channels.Channels;
        }  
            channel.position(position);
        // the existing file might be replaced or this method fails by throwing an IOException.
            return null;
                IOUtils.fsync(path, true);
        }
        final String tempBlob = tempBlobName(blobName);  
     * <b>Emulated, and only within this JVM.</b> A local filesystem offers no atomic compare-and-swap, so the  
import java.nio.file.NoSuchFileException;
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {  
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
    @Override
        Files.createDirectories(path);  
    public static String tempBlobName(final String blobName) {  
            try {  
                }
import java.nio.file.DirectoryStream;  
    public VersionedBlob readBlobWithVersion(String blobName) throws IOException {
                deleteBlobsIgnoringIfNotExists(Collections.singletonList(tempBlob));
                    deleteBlobsIgnoringIfNotExists(Collections.singletonList(tempBlob));
        throws IOException {
import java.util.concurrent.atomic.AtomicLong;
            IOUtils.fsync(path, true);
        return "pending-" + blobName + "-" + UUIDs.randomBase64UUID();
    static {  
    public Map<String, BlobContainer> children() throws IOException {
     * Always {@code false}, even though {@link #writeBlobConditionally} and {@link #readBlobWithVersion} below are
     * conditional write below is serialized with in-process locks. That is sufficient for tests and single-node
    /**
            } catch (FileNotFoundException | NoSuchFileException e) {
     * genuinely sufficient there. {@code ReloadableFsRepository} overrides this for that purpose alone.  
        final String containerPrefix = path.toAbsolutePath().toString() + path.getFileSystem().getSeparator();
    }
            for (Path file : stream) {
    private Object conditionalWriteLock(final String blobName) {  
     * implemented and behave correctly within one JVM. A local filesystem offers no compare-and-swap, so the
            }
    public static boolean isTempBlobName(final String blobName) {  
 * additionally throw a {@link java.lang.SecurityException} if the configured {@link java.lang.SecurityManager}
        try {  
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, blobNamePrefix + "*")) {
                } catch (FileNotFoundException | NoSuchFileException e) {  
        final AtomicLong filesDeleted = new AtomicLong(0L);
    }
            writeToPath(inputStream, file, blobSize);  
    }
                outputStream,
import java.util.Map;
    @Override  
        return new DeleteResult(filesDeleted.get(), bytesDeleted.get());  
/*
            return Files.newInputStream(resolvedPath);
        IOUtils.rm(blobNames.stream().map(path::resolve).toArray(Path[]::new));
 * Note that the methods in this implementation of {@link org.opensearch.common.blobstore.BlobContainer} may  
    ) throws IOException {
                throw new FileAlreadyExistsException("blob [" + targetBlobPath + "] already exists, cannot overwrite");
        } finally {  
        IOUtils.fsync(path, true);
            final String currentVersionToken = currentVersionToken(blobName);  
        final AtomicLong bytesDeleted = new AtomicLong(0L);  
    private String conditionalWriteKey(final String blobName) {  
            moveBlobAtomic(tempBlob, blobName, failIfAlreadyExists);
            } catch (IOException ex) {
        }
                );
        throws IOException {
    public FsBlobContainer(FsBlobStore blobStore, BlobPath blobPath, Path path) {
        try {
package org.opensearch.common.blobstore.fs;
            final int bufferSize = blobStore.bufferSizeInBytes();
import org.opensearch.common.blobstore.BlobPath;  
        // FsBlobContainer doesn't handle metadata or encryption
            }
                    // The file was concurrently deleted between listing files and trying to get its attributes so we skip it here
            } finally {  
/*  
        final SeekableByteChannel channel = Files.newByteChannel(path.resolve(blobName));  
    public boolean blobExists(String blobName) {
     * acceptable because conditionally-written blobs are, by contract, written exclusively through this API.
import static java.util.Collections.unmodifiableMap;  
        synchronized (conditionalWriteLock(blobName)) {  
    public void writeBlobAtomic(final String blobName, final InputStream inputStream, final long blobSize, boolean failIfAlreadyExists)
    public boolean isConditionalWriteSupported() {  
    }
        }  
        if (Files.exists(targetBlobPath)) {  
    public Map<String, BlobMetadata> listBlobsByPrefix(String blobNamePrefix) throws IOException {  
                deleteBlobsIgnoringIfNotExists(Collections.singletonList(targetBlobName));
import java.util.List;  
     */
import java.nio.file.StandardOpenOption;
 * Modifications Copyright OpenSearch Contributors. See
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        }
import java.io.FileNotFoundException;  
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {  
        for (int i = 0; i < CONDITIONAL_WRITE_STRIPES; i++) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.Nullable;
            }  
    public void moveBlobAtomic(final String sourceBlobName, final String targetBlobName, final boolean failIfAlreadyExists)  
 * this work for additional information regarding copyright
            try {  
    }
            }
        // Math.floorMod rather than % so that Integer.MIN_VALUE does not yield a negative index.
                }  
        return Long.MAX_VALUE;
        InputStream inputStream,
                    throw new IOException("[" + blobName + "] blob of size [" + Files.size(file) + "] is too large for a versioned read");
import java.util.HashMap;
 * compatible open source license.
            }
            throw ex;
/**
            for (Path file : stream) {
     * from content: a content hash would make two writes of identical bytes indistinguishable, letting a stale writer
                throw new NoSuchFileException("[" + blobName + "] blob not found");  
            org.opensearch.common.util.io.Streams.copy(  
/*  
    }  
        final int hash = conditionalWriteKey(blobName).hashCode();
        try {
            CONDITIONAL_WRITE_VERSIONS.put(conditionalWriteKey(blobName), newVersionToken);
        }
        // Mirror the delete in the conditional-write version map, so that a blob recreated at the same path later is
        long blobSize,  
                    builder.put(file.getFileName().toString(), new PlainBlobMetadata(file.getFileName().toString(), attrs.size()));
        }
        // /repo/idx-1 would also invalidate live tokens under a sibling like /repo/idx-10, spuriously fencing an
        return unmodifiableMap(builder);  
    /**
            try {  
        return CONDITIONAL_WRITE_VERSIONS.computeIfAbsent(key, k -> UUIDs.randomBase64UUID());  
import org.opensearch.common.blobstore.support.AbstractBlobContainer;
    private static final Map<String, String> CONDITIONAL_WRITE_VERSIONS = new ConcurrentHashMap<>();
    }  
    protected final Path path;
        // See delete(): deletion invalidates any previously issued version token for these paths.  
        final Path resolvedPath = path.resolve(name);
        // If the target file exists then Files.move() behaviour is implementation specific
        final Path sourceBlobPath = path.resolve(sourceBlobName);
        } catch (FileAlreadyExistsException faee) {
     * Returns true if the blob is a leftover temporary blob.
                }
    public void writeBlobWithMetadata(  
 * does not permit read and/or write access to the underlying files.
            CONDITIONAL_WRITE_VERSIONS.remove(key);  
 * All blobs in the container are stored on a file system, the location of which is specified by the {@link BlobPath}.
import java.nio.file.Path;
    private String currentVersionToken(final String blobName) {  
        final Path file = path.resolve(blobName);
     * {@link BlobContainer#isConditionalWriteSupported()}. Remote store fencing therefore refuses this container, which
        }
        blobNames.forEach(blobName -> CONDITIONAL_WRITE_VERSIONS.remove(conditionalWriteKey(blobName)));
    }
 */
    }
                throw new BlobVersionConflictException(
        return Streams.limitStream(Channels.newInputStream(channel), length);
 * <p>
     * {@inheritDoc}
    @Override
     * development, but it is <b>not</b> a cross-node fencing primitive: two nodes writing the same blob on a shared
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
        }  
     * that happens to write the current content pass a CAS it should lose (ABA). The map is JVM-local, matching the  
    private void writeToPath(InputStream inputStream, Path tempBlobPath, long blobSize) throws IOException {
    @Override  
 * A file system based implementation of {@link org.opensearch.common.blobstore.BlobContainer}.  
        @Nullable Map<String, String> metadata,
                return FileVisitResult.CONTINUE;  
                throw faee;  
            writeToPath(inputStream, file, blobSize);  
 * software distributed under the License is distributed on an
            }
    /**
    @Override  
    }
        CONDITIONAL_WRITE_VERSIONS.keySet().removeIf(key -> key.startsWith(containerPrefix));
public class FsBlobContainer extends AbstractBlobContainer {  
     * Integration tests still need to exercise fencing, and their cluster nodes share a single JVM, so the emulation is
            deleteBlobsIgnoringIfNotExists(Collections.singletonList(blobName));
import org.opensearch.common.io.Streams;  
    @Override
            final Path file = path.resolve(blobName);
        this.path = path;
 */  
     * semantics); an <b>overwrite</b> through a non-conditional API remains invisible to the version map, which is
    public Map<String, BlobMetadata> listBlobs() throws IOException {
     * <p>
            final String newVersionToken = UUIDs.randomBase64UUID();  
     */  
    @Override  
        boolean failIfAlreadyExists,
        writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);  
                throw ex;
    private static final Object[] CONDITIONAL_WRITE_LOCKS = new Object[CONDITIONAL_WRITE_STRIPES];
     * server-side (such as S3 conditional writes) can fence writers across nodes.
                Files.createDirectories(path);
            public FileVisitResult postVisitDirectory(Path dir, IOException impossible) throws IOException {  
                return FileVisitResult.CONTINUE;
        Files.move(sourceBlobPath, targetBlobPath, StandardCopyOption.ATOMIC_MOVE);
            final Path tempBlobPath = path.resolve(tempBlob);
        super(blobPath);
                // anything larger than the write-side bound rather than risk loading an arbitrarily large file.
    }
            return newVersionToken;
 * You may obtain a copy of the License at  
                    ex.addSuppressed(e);  
                Files.delete(dir);
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    @Override
import java.nio.file.Files;  
    public String writeBlobConditionally(String blobName, InputStream inputStream, long blobSize, @Nullable String expectedVersionToken)  
            @Override
     * same blob on a shared filesystem can both believe they won. Emulation is not support: see
        return blobName.startsWith(TEMP_FILE_PREFIX);
import org.opensearch.common.blobstore.DeleteResult;
    }  
    @Override
        return listBlobsByPrefix(null);  
    public InputStream readBlob(String name) throws IOException {
import java.nio.file.FileVisitResult;
                if (Files.size(file) > blobStore.bufferSizeInBytes()) {  
                assert impossible == null;
    @Override
    @Override  
import java.nio.file.SimpleFileVisitor;  
            } else {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Nullable CryptoMetadata cryptoMetadata  
