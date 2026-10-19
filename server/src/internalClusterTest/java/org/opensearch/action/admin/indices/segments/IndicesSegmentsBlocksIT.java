 * compatible open source license.
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
                disableIndexBlock("test-blocks", blockSetting);
        // Request is not blocked
 * license agreements. See the NOTICE file distributed with
 *
 */  
            SETTING_READ_ONLY,  
 * under the License.  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;  
        } finally {
            enableIndexBlock("test-blocks", SETTING_BLOCKS_METADATA);
import java.util.Arrays;
        client().admin().indices().prepareFlush("test-blocks").get();  
        for (int i = 0; i < docs; i++) {  
}
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
        createIndex("test-blocks");
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchIntegTestCase;
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.action.admin.indices.segments;
 * this work for additional information regarding copyright
                enableIndexBlock("test-blocks", blockSetting);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                assertNoFailures(response);  
        // Request is blocked  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
 * SPDX-License-Identifier: Apache-2.0
    public void testIndicesSegmentsWithBlocks() {
        for (String blockSetting : Arrays.asList(  
        }
public class IndicesSegmentsBlocksIT extends OpenSearchIntegTestCase {  
            SETTING_READ_ONLY_ALLOW_DELETE
        ensureGreen("test-blocks");  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
        }
            SETTING_BLOCKS_WRITE,
            }  
 * The OpenSearch Contributors require contributions made to  
                IndicesSegmentResponse response = client().admin().indices().prepareSegments("test-blocks").execute().actionGet();
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
            disableIndexBlock("test-blocks", SETTING_BLOCKS_METADATA);
        }  
 * Unless required by applicable law or agreed to in writing,
/*  
            } finally {
            client().prepareIndex("test-blocks").setId("" + i).setSource("test", "init").execute().actionGet();
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        int docs = between(10, 100);
/*
 * this file be licensed under the Apache-2.0 license or a
 */  
            try {  
 */
/*  
        )) {
 *
        try {
            assertBlocked(client().admin().indices().prepareSegments("test-blocks"));  
            SETTING_BLOCKS_READ,
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
 * KIND, either express or implied.  See the License for the
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
