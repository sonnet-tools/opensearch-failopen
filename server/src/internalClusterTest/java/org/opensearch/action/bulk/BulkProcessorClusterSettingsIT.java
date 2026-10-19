        bulkRequestBuilder.add(client().prepareIndex("willwork").setId("3").setSource("{\"foo\":3}", MediaTypeRegistry.JSON));  
import org.opensearch.common.settings.Settings;
 * license agreements. See the NOTICE file distributed with
 */  
        assertEquals("[wontwork] IndexNotFoundException[no such index [wontwork]]", responses[1].getFailureMessage());  
/*
        assertEquals(3, responses.length);  
 * not use this file except in compliance with the License.
        bulkRequestBuilder.add(client().prepareIndex("willwork").setId("1").setSource("{\"foo\":1}", MediaTypeRegistry.JSON));
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        createIndex("willwork");  
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BulkRequestBuilder bulkRequestBuilder = client().prepareBulk();  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        assertTrue("Missing index should have been flagged", responses[1].isFailed());
 */
        client().admin().cluster().prepareHealth("willwork").setWaitForGreenStatus().execute().actionGet();
        assertFalse("Operation on existing index should succeed", responses[2].isFailed());
 * the Apache License, Version 2.0 (the "License"); you may
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        bulkRequestBuilder.add(client().prepareIndex("wontwork").setId("2").setSource("{\"foo\":2}", MediaTypeRegistry.JSON));
 * GitHub history for details.
public class BulkProcessorClusterSettingsIT extends OpenSearchIntegTestCase {
    public void testBulkProcessorAutoCreateRestrictions() throws Exception {  
/*  
        BulkResponse br = bulkRequestBuilder.get();
 * Modifications Copyright OpenSearch Contributors. See
        internalCluster().startNode(settings);
 * You may obtain a copy of the License at  
 * compatible open source license.
 *
 */  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * this work for additional information regarding copyright
        BulkItemResponse[] responses = br.getItems();
        assertFalse("Operation on existing index should succeed", responses[0].isFailed());
import org.opensearch.test.OpenSearchIntegTestCase;  
        // See issue #8125
 * software distributed under the License is distributed on an
/*  
package org.opensearch.action.bulk;
    }
 * Unless required by applicable law or agreed to in writing,
        Settings settings = Settings.builder().put("action.auto_create_index", false).build();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * The OpenSearch Contributors require contributions made to  
 *
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
