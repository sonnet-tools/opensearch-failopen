 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
import com.google.cloud.storage.Storage;
import java.util.Arrays;
                }
 * GitHub history for details.
                } else {
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
            }).when(resultA).notify(any(StorageBatchResult.Callback.class));  
import org.opensearch.common.blobstore.BlobStore;
import static org.mockito.Mockito.doNothing;
            doReturn(resultB).when(batch).delete(eq(BlobId.of("bucket", "blobB")));  
import org.opensearch.common.blobstore.BlobContainer;
        when(storage.get("bucket")).thenReturn(mock(Bucket.class));  
import static org.mockito.Mockito.eq;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            doNothing().when(batch).submit();
                StorageException storageException = new StorageException(new IOException("Batched delete throws a storage exception"));  
            doThrow(new StorageException(new IOException("Batch submit throws a storage exception"))).when(batch).submit();
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 * under the License.  
import com.google.cloud.storage.BlobId;
 * Licensed to Elasticsearch under one or more contributor  
            final BlobContainer container = store.blobContainer(new BlobPath());
    @SuppressWarnings("unchecked")
            assertThat(e.getCause(), instanceOf(StorageException.class));
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
                ((BatchResult.Callback) invocation.getArguments()[0]).error(storageException);
 * specific language governing permissions and limitations
                return null;
 * SPDX-License-Identifier: Apache-2.0
import static org.mockito.Mockito.any;  
}
 * compatible open source license.
 * this work for additional information regarding copyright
            IOException e = expectThrows(IOException.class, () -> container.deleteBlobsIgnoringIfNotExists(blobs));  
import static org.mockito.Mockito.doAnswer;
        }  
            }).when(resultB).notify(any(StorageBatchResult.Callback.class));  
import java.io.IOException;
import com.google.cloud.storage.StorageBatchResult;  
 */  
        try (BlobStore store = new GoogleCloudStorageBlobStore("bucket", "test", "repo", storageService, randomIntBetween(1, 8) * 1024)) {  
import org.opensearch.common.blobstore.BlobPath;  
 * software distributed under the License is distributed on an
        final GoogleCloudStorageService storageService = mock(GoogleCloudStorageService.class);  
            doAnswer(invocation -> {
        } else {
                return null;
        final Storage storage = mock(Storage.class);
            doReturn(resultA).when(batch).delete(eq(BlobId.of("bucket", "blobA")));
import com.google.cloud.BatchResult;
        }
/*  
package org.opensearch.repositories.gcs;
                    ((BatchResult.Callback) invocation.getArguments()[0]).success(randomBoolean());  
        when(storage.batch()).thenReturn(batch);
import com.google.cloud.storage.Bucket;  
/*
                if (randomBoolean()) {
 *
        if (randomBoolean()) {
 */  
    public void testDeleteBlobsIgnoringIfNotExistsThrowsIOException() throws Exception {  
 * Modifications Copyright OpenSearch Contributors. See
 *
        final List<String> blobs = Arrays.asList("blobA", "blobB");
import org.opensearch.test.OpenSearchTestCase;
                    ((BatchResult.Callback) invocation.getArguments()[0]).error(storageException);
public class GoogleCloudStorageBlobStoreContainerTests extends OpenSearchTestCase {  
        when(storageService.client(any(String.class), any(String.class), any(GoogleCloudStorageOperationsStats.class))).thenReturn(storage);
            StorageBatchResult<Boolean> result = mock(StorageBatchResult.class);
 * KIND, either express or implied.  See the License for the
import static org.mockito.Mockito.doThrow;
            StorageBatchResult<Boolean> resultA = mock(StorageBatchResult.class);  
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.mock;  
import static org.mockito.Mockito.when;
import java.util.List;  
import com.google.cloud.storage.StorageBatch;
        final StorageBatch batch = mock(StorageBatch.class);  
                    StorageException storageException = new StorageException(new IOException("Batched delete throws a storage exception"));  
 * ownership. Elasticsearch licenses this file to you under  
    }  
            StorageBatchResult<Boolean> resultB = mock(StorageBatchResult.class);
            doAnswer(invocation -> {
 */
/*  
            when(batch.delete(any(BlobId.class))).thenReturn(result);  
import static org.mockito.Mockito.doReturn;  
import com.google.cloud.storage.StorageException;
 * the Apache License, Version 2.0 (the "License"); you may
