 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
        }
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_TYPE_SETTING.getKey(), "noop")
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
 * specific language governing permissions and limitations
        return Settings.builder()  
        }  
        int docCount = scaledRandomIntBetween(300, 1000);  
import static org.opensearch.search.aggregations.AggregationBuilders.cardinality;
 * compatible open source license.
 *
 * Modifications Copyright OpenSearch Contributors. See
/*  
            .build();
}
            reqs.add(client.prepareIndex("cb-test").setId(Long.toString(id)).setSource("test", id));  
        client.prepareSearch("cb-test").setQuery(matchAllQuery()).addSort("test", SortOrder.DESC).get();
    }
 * The OpenSearch Contributors require contributions made to  
            // This is set low, because if the "noop" is not a noop, it will break
import org.opensearch.transport.client.Client;  
        // index some different terms so we have some field data for loading
 */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        for (long id = 0; id < docCount; id++) {
 *  
 *
        // A cardinality aggregation uses BigArrays and thus the REQUEST breaker
        // no exception because the breaker is a noop  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "10b")  
        client.prepareSearch("cb-test").setQuery(matchAllQuery()).addAggregation(cardinality("card").field("test")).get();
            reqs.add(client.prepareIndex("cb-test").setId(Long.toString(id)).setSource("test", id));
        // no exception because the breaker is a noop
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;  
 * under the License.  
        indexRandom(true, reqs);
        assertAcked(prepareCreate("cb-test", 1, Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))));
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        indexRandom(true, reqs);
public class CircuitBreakerNoopIT extends OpenSearchIntegTestCase {  
package org.opensearch.indices.memory.breaker;
 * license agreements. See the NOTICE file distributed with
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "10b")  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        // index some different terms so we have some field data for loading
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_TYPE_SETTING.getKey(), "noop")
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
    @Override
        assertAcked(prepareCreate("cb-test", 1, Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))));
        for (long id = 0; id < docCount; id++) {
 * the Apache License, Version 2.0 (the "License"); you may
            // This is set low, because if the "noop" is not a noop, it will break
        int docCount = scaledRandomIntBetween(300, 1000);
import java.util.ArrayList;
    public void testNoopRequestBreaker() throws Exception {
        Client client = client();  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
    protected Settings nodeSettings(int nodeOrdinal) {
 * You may obtain a copy of the License at  
    public void testNoopFielddataBreaker() throws Exception {  
        List<IndexRequestBuilder> reqs = new ArrayList<>();  
        Client client = client();
 * this work for additional information regarding copyright
    }  
 */  
 */  
 * KIND, either express or implied.  See the License for the
/*  
    }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 0)
/** Tests for the noop breakers, which are non-dynamic settings */
import java.util.List;  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.action.index.IndexRequestBuilder;
        // Sorting using fielddata and thus the FIELDDATA breaker  
import org.opensearch.search.sort.SortOrder;
