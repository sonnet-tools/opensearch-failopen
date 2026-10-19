    // TODO: See if we can get precise result reporting.
                fileContext -> new HDFSPrivilegedInputSteam(fileContext.open(new Path(path, blobName), bufferSize), securityContext)
        this.securityContext = hdfsSecurityContext;
 * KIND, either express or implied.  See the License for the
import java.util.EnumSet;  
    private static class HDFSPrivilegedInputSteam extends FilterInputStream {
            }
        store.execute((Operation<Void>) fileContext -> {
    @Override
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
import java.util.Map;  
                throw new NoSuchFileException("[" + blobName + "] blob not found");
    public Map<String, BlobMetadata> listBlobsByPrefix(@Nullable final String prefix) throws IOException {
            writeToPath(inputStream, blobSize, fileContext, tempBlobPath, EnumSet.of(CreateFlag.CREATE, CreateFlag.SYNC_BLOCK));
     */
                    ioe = e;
    @Override  
        HDFSPrivilegedInputSteam(InputStream in, HdfsSecurityContext hdfsSecurityContext) {  
        return Collections.unmodifiableMap(map);  
            } catch (org.apache.hadoop.fs.FileAlreadyExistsException faee) {  
/*  
        }
        }
    }
            } catch (FileNotFoundException fnfe) {  
                throw e;
    public Map<String, BlobContainer> children() throws IOException {  
            try {
        final byte[] buffer = new byte[blobSize < bufferSize ? Math.toIntExact(blobSize) : bufferSize];
    public void deleteBlobsIgnoringIfNotExists(final List<String> blobNames) throws IOException {
 * not use this file except in compliance with the License.
import org.opensearch.repositories.hdfs.HdfsBlobStore.Operation;  
            }
    private final Path path;
 *
import org.apache.hadoop.fs.FileContext;  
    private final int bufferSize;  
        return listBlobsByPrefix(null);
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.Collections;
            ? EnumSet.of(CreateFlag.CREATE, CreateFlag.SYNC_BLOCK)
    ) throws IOException {  
    /**  
        }  
import org.apache.hadoop.fs.Options.CreateOpts;  
                throw new FileAlreadyExistsException(blob.toString(), null, faee.getMessage());  
    @Override  
            return null;  
        return store.execute(fileContext -> fileContext.util().exists(new Path(path, blobName)));  
    @Override
        store.execute(fileContext -> fileContext.delete(path, true));
            securityContext.doPrivilegedOrThrow(() -> {
            int bytesRead;  
    @Override
        FileStatus[] files = store.execute(  
import java.util.LinkedHashMap;
import org.apache.hadoop.fs.Options;
import java.nio.file.NoSuchFileException;
 */  
 * under the License.  
        store.execute((Operation<Void>) fileContext -> {  
            if (file.isFile()) {
            } catch (IOException e) {
                in.reset();  
        Path blobPath,
 * GitHub history for details.
import java.io.FileNotFoundException;
            throw ioe;
import org.opensearch.common.annotation.ExperimentalApi;  
    private final HdfsSecurityContext securityContext;
        // HDFSPrivilegedInputSteam which will ensure that underlying methods will
            throw new NoSuchFileException("[" + blobName + "] blob not found");
            } catch (final FileNotFoundException ignored) {  
        writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
        this.store = store;
            try {
        Path blob = new Path(path, blobName);
            }  
        // we pass CREATE, which means it fails if a blob already exists.
    }
     * doPrivileged blocks. This is due to the way that hdfs client libraries might open
            try {
        });  
import java.nio.file.FileAlreadyExistsException;  
 * this file be licensed under the Apache-2.0 license or a
        public int read(byte b[], int off, int len) throws IOException {
        InputStream inputStream,
     * socket connections when you are reading from an InputStream.  
 */
                return null;
            this.securityContext = hdfsSecurityContext;
        }  
        return store.execute(fileContext -> {
            return securityContext.doPrivilegedOrThrow(() -> in.read(b, off, len));
    ) throws IOException {  
            return securityContext.doPrivilegedOrThrow(() -> in.read(b));
        return Collections.unmodifiableMap(map);  
/*
        }
        boolean failIfAlreadyExists,
     * Exists to wrap underlying InputStream methods that might make socket connections in
 * You may obtain a copy of the License at  
import java.util.List;
import org.opensearch.common.blobstore.support.AbstractBlobContainer;  
                writeToPath(inputStream, blobSize, fileContext, blob, flags);
        }
    public DeleteResult delete() throws IOException {
            try {  
            return securityContext.doPrivilegedOrThrow(() -> in.skip(n));  
        FileContext fileContext,  
import org.apache.hadoop.fs.CreateFlag;  
 * Licensed to Elasticsearch under one or more contributor  
final class HdfsBlobContainer extends AbstractBlobContainer {
                    ioe.addSuppressed(e);  
            }  
            // Seek to the desired start position, closing the stream if any error occurs  
        long blobSize,  
                if (ioe == null) {  
            super(in);
    }  
    }  
    @Override
    @Override
        for (FileStatus file : files) {
    @Override
import org.opensearch.common.Nullable;
                } else {
    @ExperimentalApi
 * compatible open source license.
        return DELETE_RESULT;  
import org.opensearch.common.blobstore.DeleteResult;
            }
            );  
            }
        final EnumSet<CreateFlag> flags = failIfAlreadyExists  
}
        if (ioe != null) {
        final Path blob = new Path(path, blobName);  
import java.io.FilterInputStream;  
import org.opensearch.common.blobstore.BlobPath;  
        );
                fileContext.rename(tempBlobPath, blob, failIfAlreadyExists ? Options.Rename.NONE : Options.Rename.OVERWRITE);
    public Map<String, BlobMetadata> listBlobs() throws IOException {
    @Override  
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {  
    HdfsBlobContainer(BlobPath blobPath, HdfsBlobStore store, Path path, int bufferSize, HdfsSecurityContext hdfsSecurityContext) {
                // This exception is ignored
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void writeBlobAtomic(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {  
        });
    }
        InputStream inputStream,
            });
    @Override  
        String blobName,
        }  
import org.opensearch.common.io.Streams;
 * Unless required by applicable law or agreed to in writing,
            } catch (org.apache.hadoop.fs.FileAlreadyExistsException faee) {
    private void writeToPath(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(blobPath);  
    }
                map.put(name, new HdfsBlobContainer(path().add(name), store, new Path(path, name), bufferSize, securityContext));  
    }
        Map<String, BlobMetadata> map = new LinkedHashMap<>();  
    }  
        try (FSDataOutputStream stream = fileContext.create(blobPath, createFlags, CreateOpts.bufferSize(buffer.length))) {
        }  
                stream.write(buffer, 0, bytesRead);
        final String tempBlob = FsBlobContainer.tempBlobName(blobName);
        // FSDataInputStream can open connections on read() or skip() so we wrap in  
                throw new FileAlreadyExistsException(blob.toString(), null, faee.getMessage());
        FileStatus[] files = store.execute(fileContext -> fileContext.util().listStatus(path));
        } catch (FileNotFoundException fnfe) {
 * The OpenSearch Contributors require contributions made to  
        public int available() throws IOException {  
            try {
        public int read(byte b[]) throws IOException {  
            return Streams.limitStream(new HDFSPrivilegedInputSteam(stream, securityContext), length);
/*
        }  
        Map<String, BlobContainer> map = new LinkedHashMap<>();
import org.apache.hadoop.fs.Path;
                map.put(file.getPath().getName(), new PlainBlobMetadata(file.getPath().getName(), file.getLen()));  
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
        long blobSize,
import org.opensearch.common.blobstore.fs.FsBlobContainer;
import java.io.IOException;
        final Path tempBlobPath = new Path(path, tempBlob);
            fileContext -> fileContext.util().listStatus(path, path -> prefix == null || path.getName().startsWith(prefix))
        // FSDataInputStream does buffering internally
                stream = fileContext.open(new Path(path, blobName), bufferSize);
    public InputStream readBlob(String blobName, long position, long length) throws IOException {
            return securityContext.doPrivilegedOrThrow(() -> in.available());
    }
            final FSDataInputStream stream;  
        public synchronized void reset() throws IOException {
                store.execute(fileContext -> fileContext.delete(new Path(path, blobName), true));
import org.apache.hadoop.fs.FSDataOutputStream;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
        }
                stream.seek(position);
        public int read() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
    public InputStream readBlob(String blobName) throws IOException {
        EnumSet<CreateFlag> createFlags
import org.apache.hadoop.fs.FileStatus;
    }
                final String name = file.getPath().getName();
 *  
    }
                stream.close();
        }  
    }
    public boolean blobExists(String blobName) throws IOException {
                }
            }
import org.opensearch.common.blobstore.BlobContainer;
        @Nullable Map<String, String> metadata
        try {  
        private final HdfsSecurityContext securityContext;
        }
            }
            } catch (Exception e) {  
        public long skip(long n) throws IOException {
        IOException ioe = null;
import org.apache.hadoop.fs.FSDataInputStream;
 */
            : EnumSet.of(CreateFlag.CREATE, CreateFlag.OVERWRITE, CreateFlag.SYNC_BLOCK);
import java.io.InputStream;
    }
        for (String blobName : blobNames) {  
            return securityContext.doPrivilegedOrThrow(in::read);  
    public void writeBlobWithMetadata(  
    @Override  
 *
        for (FileStatus file : files) {  
    private final HdfsBlobStore store;  
    }
            return store.execute(
            return null;
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
package org.opensearch.repositories.hdfs;
        // HDFS does not support custom metadata, so we just delegate to writeBlob
 * ownership. Elasticsearch licenses this file to you under  
            if (file.isDirectory()) {
        }
        // be called with the proper privileges.
        this.path = path;  
import org.opensearch.common.blobstore.BlobMetadata;
        });
        this.bufferSize = bufferSize;
    private static final DeleteResult DELETE_RESULT = new DeleteResult(1L, 0L);
