 * compatible open source license.
    @Override
    }
     *
    }  
        throw new UnsupportedOperationException("URL repository is read only");
        throw new UnsupportedOperationException();  
            readBlob(blobName);  
    @Override
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     * This operation is not supported by URLBlobContainer  
    protected final URLBlobStore blobStore;  
 */  
    /**
        try {
     */
    public InputStream readBlob(String name) throws IOException {  
    }
    /**
 *  
    public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) {
 */  
import java.nio.file.NoSuchFileException;  
     * @param blobStore blob store
        } catch (URISyntaxException e) {
 * Unless required by applicable law or agreed to in writing,
    /**
        }
}  
        throw new UnsupportedOperationException("URL repository doesn't support this operation");
        throw new UnsupportedOperationException("URL repository doesn't support this operation");
    @Override
        throw new UnsupportedOperationException("URL repository doesn't support this operation");
 * under the License.  
     * @param blobPath  blob path for this container
     *  
 * URL blob implementation of {@link BlobContainer}
 * Licensed to Elasticsearch under one or more contributor  
     * @param   blobName
/*
            throw new NoSuchFileException("[" + name + "] blob not found");
    @Override  
 * The OpenSearch Contributors require contributions made to  
        throw new UnsupportedOperationException("URL repository doesn't support this operation");
        super(blobPath);  
 * You may obtain a copy of the License at  
import org.opensearch.common.blobstore.BlobPath;
    @Override
import org.opensearch.common.blobstore.BlobContainer;
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
    public Map<String, BlobContainer> children() throws IOException {
 * KIND, either express or implied.  See the License for the
public class URLBlobContainer extends AbstractBlobContainer {
 * software distributed under the License is distributed on an
    public Map<String, BlobMetadata> listBlobsByPrefix(String blobNamePrefix) throws IOException {  
 *
    }
    @Override  
     * This operation is not supported by URLBlobContainer
 * this work for additional information regarding copyright
    @Override  
    public void writeBlobAtomic(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {  
/*  
     */
        try {
     * @return URL for this container
import org.opensearch.common.blobstore.DeleteResult;
import java.io.IOException;
        throw new UnsupportedOperationException("URL repository is read only");  
    }  
    public boolean blobExists(String blobName) throws IOException {
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    @Override  
    public InputStream readBlob(String blobName, long position, long length) throws IOException {
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
    }  
import java.io.InputStream;  
import java.io.BufferedInputStream;  
    private static InputStream getInputStream(URL url) throws IOException {
package org.opensearch.common.blobstore.url;
    @Override
    protected final URL path;
    /**
 */  
        return this.path;
/**
            throw new IOException(e);  
     * @param path      URL for this container  
    }
    @Override
    /**
    public URLBlobContainer(URLBlobStore blobStore, BlobPath blobPath, URL path) {
     * Tests whether a blob with the given blob name exists in the container.  
     */  
     */  
 * not use this file except in compliance with the License.
import org.opensearch.secure_sm.AccessController;
        } catch (FileNotFoundException fnfe) {  
    }
    public DeleteResult delete() {
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        this.blobStore = blobStore;
import org.opensearch.common.blobstore.support.AbstractBlobContainer;  
    }
            return new BufferedInputStream(getInputStream(this.path.toURI().resolve(name).toURL()), blobStore.bufferSizeInBytes());
    public URL url() {
     *
     * This operation is not supported by URLBlobContainer
import java.io.FileNotFoundException;
 * specific language governing permissions and limitations
import org.opensearch.common.SuppressForbidden;
        this.path = path;
    }  
 * ownership. Elasticsearch licenses this file to you under  
        }
     * @return  {@code true} if a blob exists in the {@link BlobContainer} with the given name, and {@code false} otherwise.
    @SuppressForbidden(reason = "We call connect in doPrivileged and provide SocketPermission")
 * license agreements. See the NOTICE file distributed with
    /**
    public Map<String, BlobMetadata> listBlobs() throws IOException {
     */
        } catch (FileNotFoundException e) {
 */
     */  
            return false;  
            return true;
        throw new UnsupportedOperationException("URL repository doesn't support this operation");  
     * Returns URL for this container  
import org.opensearch.common.blobstore.BlobMetadata;  
        return AccessController.doPrivilegedChecked(url::openStream);  
import java.net.URL;
     *          The name of the blob whose existence is to be determined.  
import java.net.URISyntaxException;
     * Constructs new URLBlobContainer
