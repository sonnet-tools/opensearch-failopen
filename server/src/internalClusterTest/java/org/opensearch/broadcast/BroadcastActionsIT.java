    public void testBroadcastOperations() throws IOException {
    }  
import java.io.IOException;  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(countResponse.getTotalShards(), equalTo(numShards.numPrimaries));
        client().index(indexRequest("test").id("1").source(source("1", "test"))).actionGet();
import static org.opensearch.transport.client.Requests.indexRequest;
            assertThat(countResponse.getSuccessfulShards(), equalTo(numShards.numPrimaries));
            SearchResponse countResponse = client().prepareSearch("test").setSize(0).setQuery(matchAllQuery()).get();
 * You may obtain a copy of the License at  
            // test successful
        refresh();
package org.opensearch.broadcast;
 */  
import org.opensearch.core.xcontent.XContentBuilder;  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        flush();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        client().index(indexRequest("test").id("2").source(source("2", "test"))).actionGet();
import org.opensearch.test.OpenSearchIntegTestCase;
        logger.info("Count");
/*
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * under the License.  
 *
import org.opensearch.common.xcontent.XContentFactory;
        logger.info("Running Cluster Health");
 *  
            assertThat(countResponse.getHits().getTotalHits().value(), equalTo(2L));  
import org.opensearch.action.search.SearchResponse;
        assertAcked(prepareCreate("test", 1));  
import static org.hamcrest.Matchers.equalTo;
        NumShards numShards = getNumShards("test");
}
public class BroadcastActionsIT extends OpenSearchIntegTestCase {
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // check count
    private XContentBuilder source(String id, String nameValue) throws IOException {
        return XContentFactory.jsonBuilder().startObject().field("id", id).field("name", nameValue).endObject();
 * Unless required by applicable law or agreed to in writing,
/*  
 *
 */
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
/*  
    protected int maximumNumberOfReplicas() {
        for (int i = 0; i < 5; i++) {  
    @Override  
            assertThat(countResponse.getFailedShards(), equalTo(0));  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
 */  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
        return 1;
    }
        }
