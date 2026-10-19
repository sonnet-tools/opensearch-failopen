 * the Apache License, Version 2.0 (the "License"); you may
        ensureGreen("test");  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.action.admin.indices.refresh;
        // Request is not blocked
/*  
 * this file be licensed under the Apache-2.0 license or a
            SETTING_READ_ONLY,
                assertThat(response.getSuccessfulShards(), equalTo(numShards.totalNumShards));
 *  
        )) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
 * specific language governing permissions and limitations
 */
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
import java.util.Arrays;
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
/*  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;  
 * under the License.  
        for (String blockSetting : Arrays.asList(
 * The OpenSearch Contributors require contributions made to  
public class RefreshBlocksIT extends OpenSearchIntegTestCase {  
            SETTING_BLOCKS_METADATA,  
            }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
    }  
import static org.hamcrest.Matchers.equalTo;  
                disableIndexBlock("test", blockSetting);  
                RefreshResponse response = client().admin().indices().prepareRefresh("test").execute().actionGet();
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
            try {  
 * Modifications Copyright OpenSearch Contributors. See
 */  
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
 * GitHub history for details.
    public void testRefreshWithBlocks() {
 *
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
        }
        NumShards numShards = getNumShards("test");
            } finally {
/*
 * compatible open source license.
 */  
 * KIND, either express or implied.  See the License for the
}
            SETTING_BLOCKS_WRITE,
import org.opensearch.test.OpenSearchIntegTestCase;
        createIndex("test");
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;  
            SETTING_BLOCKS_READ,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertNoFailures(response);  
            SETTING_READ_ONLY_ALLOW_DELETE
 * not use this file except in compliance with the License.
                enableIndexBlock("test", blockSetting);
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
