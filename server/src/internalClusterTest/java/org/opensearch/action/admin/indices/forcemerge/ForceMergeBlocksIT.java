import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;  
 * ownership. Elasticsearch licenses this file to you under  
        ensureGreen("test");
public class ForceMergeBlocksIT extends OpenSearchIntegTestCase {
 *  
        } finally {
            setClusterReadOnly(true);  
 *
            try {
 * the Apache License, Version 2.0 (the "License"); you may
        // Request is blocked
        for (String blockSetting : Arrays.asList(SETTING_READ_ONLY, SETTING_BLOCKS_METADATA, SETTING_READ_ONLY_ALLOW_DELETE)) {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;  
        try {
import static org.hamcrest.Matchers.equalTo;
 * under the License.  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            assertNoFailures(response);  
 */  
import java.util.Arrays;
 * Licensed to Elasticsearch under one or more contributor  
 */  
package org.opensearch.action.admin.indices.forcemerge;
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)  
                enableIndexBlock("test", blockSetting);
        int docs = between(10, 100);  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
            ForceMergeResponse response = client().admin().indices().prepareForceMerge().execute().actionGet();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
 * GitHub history for details.
    public void testForceMergeWithBlocks() {  
/*  
        for (int i = 0; i < docs; i++) {
 * KIND, either express or implied.  See the License for the
        }
                assertThat(response.getSuccessfulShards(), equalTo(numShards.totalNumShards));
        }  
        }
            client().prepareIndex("test").setId("" + i).setSource("test", "init").execute().actionGet();
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
            } finally {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
                assertBlocked(client().admin().indices().prepareForceMerge("test"));  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
                disableIndexBlock("test", blockSetting);
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
            assertThat(response.getSuccessfulShards(), equalTo(numShards.totalNumShards));
                disableIndexBlock("test", blockSetting);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                ForceMergeResponse response = client().admin().indices().prepareForceMerge("test").execute().actionGet();  
 */
import org.opensearch.test.OpenSearchIntegTestCase;
 * Unless required by applicable law or agreed to in writing,
            }
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
/*
        // Merging all indices is blocked when the cluster is read-only  
        }  
            try {
 * SPDX-License-Identifier: Apache-2.0
/*  
 * software distributed under the License is distributed on an
        for (String blockSetting : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE)) {  
                assertNoFailures(response);
        createIndex("test");
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        NumShards numShards = getNumShards("test");
            } finally {
            setClusterReadOnly(false);  
}  
            }  
 *
        // Request is not blocked
                enableIndexBlock("test", blockSetting);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
 * this file be licensed under the Apache-2.0 license or a
            assertBlocked(client().admin().indices().prepareForceMerge());
