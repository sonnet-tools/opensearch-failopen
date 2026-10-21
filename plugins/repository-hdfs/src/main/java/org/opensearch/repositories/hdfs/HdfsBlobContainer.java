        public long skip(long n) throws IOException {
            }
            return securityContext.doPrivilegedOrThrow(() -> in.skip(n));
    }
    }
        for (FileStatus file : files) {
 * You may obtain a copy of the License at
                throw new FileAlreadyExistsException(blob.toString(), null, faee.getMessage());
                store.execute(fileContext -> fileContext.delete(new Path(path, blobName), true));
                map.put(name, new HdfsBlobContainer(path().add(name), store, new Path(path, name), bufferSize, securityContext));
import org.opensearch.common.annotation.ExperimentalApi;
                writeToPath(inputStream, blobSize, fileContext, blob, flags);
            try {
            if (file.isFile()) {
 * The OpenSearch Contributors require contributions made to
     * doPrivileged blocks. This is due to the way that hdfs client libraries might open
    @Override
    @Override
        public int read() throws IOException {
        HDFSPrivilegedInputSteam(InputStream in, HdfsSecurityContext hdfsSecurityContext) {
        }
    private static final DeleteResult DELETE_RESULT = new DeleteResult(1L, 0L);
        return store.execute(fileContext -> fileContext.util().exists(new Path(path, blobName)));
        final Path blob = new Path(path, blobName);
    }
                fileContext.rename(tempBlobPath, blob, failIfAlreadyExists ? Options.Rename.NONE : Options.Rename.OVERWRITE);
            fileContext -> fileContext.util().listStatus(path, path -> prefix == null || path.getName().startsWith(prefix))
        Path blob = new Path(path, blobName);
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
    ) throws IOException {
        });
        // we pass CREATE, which means it fails if a blob already exists.
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
        public int available() throws IOException {
import java.util.List;
    }
            }
        InputStream inputStream,
            }
 * compatible open source license.
     * Exists to wrap underlying InputStream methods that might make socket connections in
 * under the License.
    }
    public Map<String, BlobMetadata> listBlobs() throws IOException {
     * socket connections when you are reading from an InputStream.
import org.opensearch.common.blobstore.BlobPath;
            return null;
            } catch (org.apache.hadoop.fs.FileAlreadyExistsException faee) {
        store.execute((Operation<Void>) fileContext -> {
    ) throws IOException {
        }
    @Override
        writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
        return store.execute(fileContext -> {
 * GitHub history for details.
        Map<String, BlobContainer> map = new LinkedHashMap<>();
import org.opensearch.common.blobstore.support.AbstractBlobContainer;
    }
        final EnumSet<CreateFlag> flags = failIfAlreadyExists
import org.opensearch.common.blobstore.BlobMetadata;
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void deleteBlobsIgnoringIfNotExists(final List<String> blobNames) throws IOException {
        }
            ? EnumSet.of(CreateFlag.CREATE, CreateFlag.SYNC_BLOCK)
        FileContext fileContext,
        InputStream inputStream,
                }
        }
import org.apache.hadoop.fs.Options.CreateOpts;
        boolean failIfAlreadyExists,
                throw e;
            // Seek to the desired start position, closing the stream if any error occurs
    public Map<String, BlobContainer> children() throws IOException {
    }
 * license agreements. See the NOTICE file distributed with
                stream.close();
    @Override
            } catch (FileNotFoundException fnfe) {
import java.nio.file.NoSuchFileException;
import java.util.Map;
        return DELETE_RESULT;
        EnumSet<CreateFlag> createFlags
final class HdfsBlobContainer extends AbstractBlobContainer {
import java.util.LinkedHashMap;
import org.opensearch.common.io.Streams;
    }
        public synchronized void reset() throws IOException {
            throw ioe;
        String blobName,
    public void writeBlobWithMetadata(
}
                in.reset();
        // be called with the proper privileges.
import org.apache.hadoop.fs.FileContext;
 */
            try {
        store.execute(fileContext -> fileContext.delete(path, true));
    private void writeToPath(
import org.opensearch.common.blobstore.BlobContainer;
import org.apache.hadoop.fs.FSDataInputStream;
                throw new NoSuchFileException("[" + blobName + "] blob not found");
 */
        final byte[] buffer = new byte[blobSize < bufferSize ? Math.toIntExact(blobSize) : bufferSize];
        } catch (FileNotFoundException fnfe) {
    private final HdfsBlobStore store;
            });
            return securityContext.doPrivilegedOrThrow(() -> in.read(b, off, len));
        }
        return listBlobsByPrefix(null);
    public Map<String, BlobMetadata> listBlobsByPrefix(@Nullable final String prefix) throws IOException {
import org.opensearch.repositories.hdfs.HdfsBlobStore.Operation;
 *
            return securityContext.doPrivilegedOrThrow(in::read);
            super(in);
        // HDFS does not support custom metadata, so we just delegate to writeBlob
            }
package org.opensearch.repositories.hdfs;
        // HDFSPrivilegedInputSteam which will ensure that underlying methods will
import org.apache.hadoop.fs.Options;
                } else {
        for (String blobName : blobNames) {
    public InputStream readBlob(String blobName) throws IOException {
            try {
        });
            int bytesRead;
    /**
            } catch (Exception e) {
        try (FSDataOutputStream stream = fileContext.create(blobPath, createFlags, CreateOpts.bufferSize(buffer.length))) {
    public InputStream readBlob(String blobName, long position, long length) throws IOException {
        this.path = path;
            return securityContext.doPrivilegedOrThrow(() -> in.available());
    }
                // This exception is ignored
import org.opensearch.common.Nullable;
                stream.seek(position);
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            } catch (org.apache.hadoop.fs.FileAlreadyExistsException faee) {
    HdfsBlobContainer(BlobPath blobPath, HdfsBlobStore store, Path path, int bufferSize, HdfsSecurityContext hdfsSecurityContext) {
 * software distributed under the License is distributed on an
        this.store = store;
            );
import org.opensearch.common.blobstore.DeleteResult;
            }
            try {
            while ((bytesRead = inputStream.read(buffer)) != -1) {
    }
        if (ioe != null) {
        });
            : EnumSet.of(CreateFlag.CREATE, CreateFlag.OVERWRITE, CreateFlag.SYNC_BLOCK);
import org.apache.hadoop.fs.FileStatus;
            return store.execute(
            return Streams.limitStream(new HDFSPrivilegedInputSteam(stream, securityContext), length);
                    ioe.addSuppressed(e);
            } catch (final FileNotFoundException ignored) {
        for (FileStatus file : files) {
        IOException ioe = null;
        this.bufferSize = bufferSize;
    @Override
import java.util.EnumSet;
        }
            throw new NoSuchFileException("[" + blobName + "] blob not found");
            return securityContext.doPrivilegedOrThrow(() -> in.read(b));
    @Override
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;
            this.securityContext = hdfsSecurityContext;
            return null;
        }
        long blobSize,
        long blobSize,
import java.nio.file.FileAlreadyExistsException;
 *
    }
            if (file.isDirectory()) {
import java.io.IOException;
    public void writeBlobAtomic(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
        FileStatus[] files = store.execute(fileContext -> fileContext.util().listStatus(path));
 * Modifications Copyright OpenSearch Contributors. See
    }
/*
        );
                if (ioe == null) {
    @Override
        this.securityContext = hdfsSecurityContext;
                stream = fileContext.open(new Path(path, blobName), bufferSize);
                stream.write(buffer, 0, bytesRead);
            }
    }
        return Collections.unmodifiableMap(map);
    @Override
import org.apache.hadoop.fs.Path;
 * specific language governing permissions and limitations
    @Override
    public boolean blobExists(String blobName) throws IOException {
import org.apache.hadoop.fs.CreateFlag;
    private final HdfsSecurityContext securityContext;
    @Override
        private final HdfsSecurityContext securityContext;
        }
import java.io.FilterInputStream;
        public int read(byte b[]) throws IOException {
        super(blobPath);
                final String name = file.getPath().getName();
            try {
        store.execute((Operation<Void>) fileContext -> {
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
 *
                    ioe = e;
    private final Path path;
            final FSDataInputStream stream;
        @Nullable Map<String, String> metadata
        final String tempBlob = FsBlobContainer.tempBlobName(blobName);
        return Collections.unmodifiableMap(map);
import java.io.InputStream;
                fileContext -> new HDFSPrivilegedInputSteam(fileContext.open(new Path(path, blobName), bufferSize), securityContext)
        // FSDataInputStream does buffering internally
        public int read(byte b[], int off, int len) throws IOException {
    @ExperimentalApi
            writeToPath(inputStream, blobSize, fileContext, tempBlobPath, EnumSet.of(CreateFlag.CREATE, CreateFlag.SYNC_BLOCK));
    private static class HDFSPrivilegedInputSteam extends FilterInputStream {
                map.put(file.getPath().getName(), new PlainBlobMetadata(file.getPath().getName(), file.getLen()));
 * not use this file except in compliance with the License.
import java.io.FileNotFoundException;
        final Path tempBlobPath = new Path(path, tempBlob);
 * ownership. Elasticsearch licenses this file to you under
        // FSDataInputStream can open connections on read() or skip() so we wrap in
        try {
import org.opensearch.common.blobstore.fs.FsBlobContainer;
 */
/*
    public DeleteResult delete() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    // TODO: See if we can get precise result reporting.
        FileStatus[] files = store.execute(
        }
        }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.hadoop.fs.FSDataOutputStream;
            } catch (IOException e) {
    private final int bufferSize;
            securityContext.doPrivilegedOrThrow(() -> {
        Path blobPath,
                throw new FileAlreadyExistsException(blob.toString(), null, faee.getMessage());
 * this work for additional information regarding copyright
    }
     */
        }
            }
            }
 * Licensed to Elasticsearch under one or more contributor
        }
        }
        Map<String, BlobMetadata> map = new LinkedHashMap<>();
                return null;
