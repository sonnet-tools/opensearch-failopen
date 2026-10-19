 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.hamcrest.Matchers.equalTo;  
 *  
        for (String blockSetting : Arrays.asList(
 * Unless required by applicable law or agreed to in writing,
            SETTING_BLOCKS_WRITE,  
/*  
            SETTING_BLOCKS_METADATA,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
            SETTING_READ_ONLY_ALLOW_DELETE  
public class FlushBlocksIT extends OpenSearchIntegTestCase {  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        // Request is not blocked  
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
 * KIND, either express or implied.  See the License for the
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;  
}  
 *
 */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
 * compatible open source license.
 * software distributed under the License is distributed on an
        ensureGreen("test");  
 * the Apache License, Version 2.0 (the "License"); you may
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
 */  
        NumShards numShards = getNumShards("test");
    }
import java.util.Arrays;
package org.opensearch.action.admin.indices.flush;
                assertNoFailures(response);
        }
/*  
        for (int i = 0; i < docs; i++) {
            } finally {
        }
            SETTING_READ_ONLY,
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            SETTING_BLOCKS_READ,
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
                assertThat(response.getSuccessfulShards(), equalTo(numShards.totalNumShards));  
    public void testFlushWithBlocks() {
            client().prepareIndex("test").setId("" + i).setSource("test", "init").execute().actionGet();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        )) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
            }  
                disableIndexBlock("test", blockSetting);
 */  
/*
        createIndex("test");
                enableIndexBlock("test", blockSetting);  
 * this work for additional information regarding copyright
                FlushResponse response = client().admin().indices().prepareFlush("test").execute().actionGet();
        int docs = between(10, 100);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            try {
