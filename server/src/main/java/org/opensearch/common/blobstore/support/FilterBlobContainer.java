    }
        return delegate.readBlob(blobName);
        return delegate.listBlobs();  
    private final BlobContainer delegate;
    }  
    @Override
}  
    public void writeBlobAtomic(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
    @Override
    public DeleteResult delete() throws IOException {
        long blobSize,
        return delegate.children().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> wrapChild(e.getValue())));
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        String blobName,  
    }  
        @Nullable CryptoMetadata cryptoMetadata
        @Nullable Map<String, String> metadata,
        String blobName,
        boolean failIfAlreadyExists
        delegate.deleteBlobsIgnoringIfNotExists(blobNames);
        delegate.writeBlobWithMetadata(blobName, inputStream, blobSize, failIfAlreadyExists, metadata);
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
    }
    @Override
 * KIND, either express or implied.  See the License for the
        return delegate.readBlobPreferredLength();
 *  
    @Override
    public BlobPath path() {
    public InputStream readBlob(String blobName, long position, long length) throws IOException {
 * Filter blob container.
/*  
import java.util.Objects;
import java.util.Map;  
import java.util.List;
 */
        long blobSize,  
    }  
        return delegate.blobExists(blobName);
    public Map<String, BlobContainer> children() throws IOException {
    public void writeBlobWithMetadata(  
import org.opensearch.cluster.metadata.CryptoMetadata;
        InputStream inputStream,
        String blobName,  
    @Override
        delegate.writeBlobWithMetadata(blobName, inputStream, blobSize, failIfAlreadyExists, metadata, cryptoMetadata);
        InputStream inputStream,
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {  
 *
import org.opensearch.common.Nullable;
 */
import org.opensearch.common.blobstore.BlobContainer;  
 * Licensed to Elasticsearch under one or more contributor  
    public void writeBlobWithMetadata(
    public FilterBlobContainer(BlobContainer delegate) {
 * under the License.  
    protected abstract BlobContainer wrapChild(BlobContainer child);
    @Override
    }
        this.delegate = Objects.requireNonNull(delegate);
    }
import org.opensearch.common.blobstore.InputStreamWithMetadata;
public abstract class FilterBlobContainer implements BlobContainer {  
    @Override
        delegate.writeBlobAtomic(blobName, inputStream, blobSize, failIfAlreadyExists);  
 *  
    }
    public boolean blobExists(String blobName) throws IOException {
import java.io.IOException;  
 *
import java.util.stream.Collectors;
import org.opensearch.common.blobstore.BlobMetadata;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
package org.opensearch.common.blobstore.support;
    ) throws IOException {  
        return delegate.listBlobsByPrefix(blobNamePrefix);
 * ownership. Elasticsearch licenses this file to you under  
        @Nullable Map<String, String> metadata
        return delegate.readBlob(blobName, position, length);  
 * compatible open source license.
 * You may obtain a copy of the License at  
        boolean failIfAlreadyExists,
 * not use this file except in compliance with the License.
    @Override
    public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException {  
        @Nullable Map<String, String> metadata,
        long blobSize,  
    ) throws IOException {
    }
        return delegate.path();  
    @Override  
    }
        delegate.writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
    public long readBlobPreferredLength() {
/*
    }
import org.opensearch.common.blobstore.BlobPath;
    }  
 * this work for additional information regarding copyright
    public InputStream readBlob(String blobName) throws IOException {  
import java.io.InputStream;
        return delegate.readBlobWithMetadata(blobName);
 * software distributed under the License is distributed on an
    }
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
    @Override  
    public Map<String, BlobMetadata> listBlobsByPrefix(String blobNamePrefix) throws IOException {  
 * GitHub history for details.
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
        boolean failIfAlreadyExists,  
    @Override
    }
    public Map<String, BlobMetadata> listBlobs() throws IOException {
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * SPDX-License-Identifier: Apache-2.0
    public void writeBlobAtomicWithMetadata(
    }  
import org.opensearch.common.blobstore.DeleteResult;  
    ) throws IOException {  
    @Override  
        delegate.writeBlobAtomicWithMetadata(blobName, inputStream, metadata, blobSize, failIfAlreadyExists);  
    }
    @Override
        return delegate.delete();
 * The OpenSearch Contributors require contributions made to  
        InputStream inputStream,
    @Override  
/**
    public InputStreamWithMetadata readBlobWithMetadata(String blobName) throws IOException {
 * Unless required by applicable law or agreed to in writing,
