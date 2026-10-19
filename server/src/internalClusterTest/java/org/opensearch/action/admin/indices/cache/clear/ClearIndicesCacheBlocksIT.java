        NumShards numShards = getNumShards("test");
            SETTING_BLOCKS_WRITE,  
                enableIndexBlock("test", blockSetting);
 */  
import java.util.Collections;
        // Request is not blocked  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
        for (String blockSetting : Collections.singletonList(SETTING_BLOCKS_METADATA)) {
            SETTING_BLOCKS_WRITE,  
                    .execute()  
                disableIndexBlock("test", blockSetting);  
 * Unless required by applicable law or agreed to in writing,
 *
 *
                    .indices()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;  
                    .setQueryCache(true)
 * not use this file except in compliance with the License.
            }
            try {
        createIndex("test");
 *  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
                enableIndexBlock("test", blockSetting);
 * GitHub history for details.
 */  
        }
 * this work for additional information regarding copyright
public class ClearIndicesCacheBlocksIT extends OpenSearchIntegTestCase {
                assertNoFailures(clearIndicesCacheResponse);
                assertThat(clearIndicesCacheResponse.getSuccessfulShards(), equalTo(numShards.totalNumShards));  
        }  
import static org.hamcrest.Matchers.equalTo;
            } finally {
            SETTING_BLOCKS_READ,
        createIndex("test");
            try {
                assertThat(clearIndicesCacheResponse.getSuccessfulShards(), equalTo(numShards.totalNumShards));
 * Modifications Copyright OpenSearch Contributors. See
        ensureGreen("test");
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                    .actionGet();
                disableIndexBlock("test", blockSetting);
                assertBlocked(client().admin().indices().prepareClearCache("test").setQueryCache(true).setFileCache(true));
            SETTING_BLOCKS_READ,
                    .prepareClearCache("test")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        )) {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
package org.opensearch.action.admin.indices.cache.clear;
 * under the License.  
            try {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
    }  
/*  
            }  
            }
    public void testClearIndicesCacheWithBlocks() {  
        for (String blockSetting : Arrays.asList(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;  
                    .setFieldDataCache(true)  
                );
 * software distributed under the License is distributed on an
        ensureGreen("test");
 * The OpenSearch Contributors require contributions made to  
        // Request is not blocked  
                ClearIndicesCacheResponse clearIndicesCacheResponse = client().admin()  
                    .setFileCache(true)  
        }
/*  
                enableIndexBlock("test", blockSetting);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
                enableIndexBlock("test", blockSetting);
 * ownership. Elasticsearch licenses this file to you under  
    public void testClearIndicesFileCacheWithBlocks() {  
            SETTING_READ_ONLY,
            SETTING_READ_ONLY,
        for (String blockSetting : Arrays.asList(SETTING_BLOCKS_METADATA)) {  
                assertNoFailures(clearIndicesCacheResponse);  
            SETTING_READ_ONLY_ALLOW_DELETE
                disableIndexBlock("test", blockSetting);
        )) {  
 * license agreements. See the NOTICE file distributed with
            } finally {  
            } finally {
 * compatible open source license.
                    .actionGet();
                    .execute()
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
        for (String blockSetting : Arrays.asList(
                disableIndexBlock("test", blockSetting);  
        }
        // Request is blocked
            SETTING_READ_ONLY_ALLOW_DELETE
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
/*
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
            }
            try {
                    .setFieldDataCache(true)
        NumShards numShards = getNumShards("test");
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
                    .prepareClearCache("test")
                    client().admin().indices().prepareClearCache("test").setFieldDataCache(true).setQueryCache(true).setFieldDataCache(true)
import org.opensearch.test.OpenSearchIntegTestCase;
                ClearIndicesCacheResponse clearIndicesCacheResponse = client().admin()  
                    .indices()
            } finally {
 */
                assertBlocked(  
}
