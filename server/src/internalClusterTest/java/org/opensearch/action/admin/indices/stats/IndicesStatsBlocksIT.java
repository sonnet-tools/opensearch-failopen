        // Request is not blocked
 *  
            SETTING_READ_ONLY_ALLOW_DELETE
import java.util.Arrays;  
/*  
            SETTING_READ_ONLY,  
            } finally {
        for (String blockSetting : Arrays.asList(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchIntegTestCase;  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
                IndicesStatsResponse indicesStatsResponse = client().admin().indices().prepareStats("ro").execute().actionGet();
                assertNotNull(indicesStatsResponse.getIndex("ro"));  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
        )) {
            try {  
 * GitHub history for details.
 * under the License.  
            // Ok, a ClusterBlockException is expected  
 * compatible open source license.
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        } finally {
 * ownership. Elasticsearch licenses this file to you under  
public class IndicesStatsBlocksIT extends OpenSearchIntegTestCase {
 */  
 *
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        } catch (ClusterBlockException e) {
 */
}
            fail("Exists should fail when " + IndexMetadata.SETTING_BLOCKS_METADATA + " is true");
 * You may obtain a copy of the License at  
            }  
 *
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
            SETTING_BLOCKS_WRITE,
                disableIndexBlock("ro", blockSetting);
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
            SETTING_BLOCKS_READ,
        ensureGreen("ro");  
import org.opensearch.cluster.block.ClusterBlockException;
        try {
 * license agreements. See the NOTICE file distributed with
/*  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;  
        }  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
        }
                enableIndexBlock("ro", blockSetting);
            disableIndexBlock("ro", IndexMetadata.SETTING_BLOCKS_METADATA);
    public void testIndicesStatsWithBlocks() {
        // Request is blocked  
 * KIND, either express or implied.  See the License for the
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.IndexMetadata;
            client().admin().indices().prepareStats("ro").execute().actionGet();  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        createIndex("ro");
            enableIndexBlock("ro", IndexMetadata.SETTING_BLOCKS_METADATA);
 * software distributed under the License is distributed on an
 */  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.action.admin.indices.stats;
