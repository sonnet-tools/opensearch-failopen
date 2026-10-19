 * Licensed to Elasticsearch under one or more contributor  
        this.bytesDeleted = bytesDeleted;  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    public DeleteResult add(long blobs, long bytes) {  
public final class DeleteResult {  
    }
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 */
        return bytesDeleted;
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 *
    public DeleteResult add(DeleteResult other) {
 *
 * not use this file except in compliance with the License.
 * The result of deleting multiple blobs from a {@link BlobStore}.
        return blobsDeleted;
    private final long blobsDeleted;
 *  
/*  
    public long bytesDeleted() {
/*
    private final long bytesDeleted;
/*  
    public DeleteResult(long blobsDeleted, long bytesDeleted) {
    public static final DeleteResult ZERO = new DeleteResult(0, 0);
 * KIND, either express or implied.  See the License for the
 */  
}  
    }
 * @opensearch.internal
/**
        this.blobsDeleted = blobsDeleted;
    }
 */  
 * ownership. Elasticsearch licenses this file to you under  
        return new DeleteResult(blobsDeleted + blobs, bytesDeleted + bytes);
 * specific language governing permissions and limitations
 *  
 * GitHub history for details.
    }  
 */
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        return new DeleteResult(blobsDeleted + other.blobsDeleted(), bytesDeleted + other.bytesDeleted());  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    public long blobsDeleted() {  
package org.opensearch.common.blobstore;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
