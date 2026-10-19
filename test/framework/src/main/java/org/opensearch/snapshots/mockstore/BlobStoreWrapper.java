        this.delegate = delegate;
 *
 * You may obtain a copy of the License at  
    }
}
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
        return delegate.blobContainer(path);
    }  
    private BlobStore delegate;
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * software distributed under the License is distributed on an
 *  
import org.opensearch.common.blobstore.BlobPath;
/*
        return delegate;
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.snapshots.mockstore;
    public void close() throws IOException {
        delegate.close();  
    public BlobContainer blobContainer(BlobPath path) {  
 * GitHub history for details.
import org.opensearch.common.blobstore.BlobStore;
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 *
import java.io.IOException;
 */  
    protected BlobStore delegate() {  
    public BlobStoreWrapper(BlobStore delegate) {
/*  
    @Override
 */
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.common.blobstore.BlobContainer;  
 * this work for additional information regarding copyright
    }
 * Unless required by applicable law or agreed to in writing,
 */
public class BlobStoreWrapper implements BlobStore {  
/*
