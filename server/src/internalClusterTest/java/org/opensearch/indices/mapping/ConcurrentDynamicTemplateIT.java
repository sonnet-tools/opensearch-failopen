 *
package org.opensearch.indices.mapping;
            + "\": {"  
import java.util.Map;
            + "{ \""
            assertThat(throwable, emptyIterable());
 */
import java.util.concurrent.CountDownLatch;
 *
 * compatible open source license.
/*  
            + "\"analyzer\": \"whitespace\" } } } ] }";
        }  
 * Licensed to Elasticsearch under one or more contributor  
        final String mapping = "{ "
/*
/*  
            cluster().wipeIndices("test");
            assertAcked(prepareCreate("test").setMapping(mapping));  
 *  
                            latch.countDown();
    }
        final String fieldName = "field";
import static org.hamcrest.Matchers.emptyIterable;
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
                        @Override  
import java.util.HashMap;  
            + "\"type\": \"text\","  
            int currentID = 0;
 * software distributed under the License is distributed on an
                        public void onResponse(IndexResponse response) {
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.index.query.QueryBuilders;  
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
            + "\"mapping\": {"
                    });
 * You may obtain a copy of the License at  
                    .setSource(source)
            + "\"path_match\": \"*\","
            + fieldName
}
 * Unless required by applicable law or agreed to in writing,
                        @Override
 * KIND, either express or implied.  See the License for the
            final CountDownLatch latch = new CountDownLatch(numDocs);
        int iters = scaledRandomIntBetween(5, 15);  
 * this file be licensed under the Apache-2.0 license or a
            final List<Throwable> throwable = new CopyOnWriteArrayList<>();  
                source.put(fieldName, "test-user");
 * license agreements. See the NOTICE file distributed with
    // see #3544
 * SPDX-License-Identifier: Apache-2.0
        // after testing
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
import java.util.List;
                        }  
import org.opensearch.core.action.ActionListener;
            + "\"dynamic_templates\": ["  
            latch.await();  
 * this work for additional information regarding copyright
                            throwable.add(e);
                            latch.countDown();
 * under the License.  
            assertHitCount(client().prepareSearch("test").setQuery(QueryBuilders.matchQuery(fieldName, "test user")).get(), 0);
                        }  
import java.util.concurrent.CopyOnWriteArrayList;  
            int numDocs = scaledRandomIntBetween(10, 100);
import org.opensearch.action.index.IndexResponse;
                    .setId(Integer.toString(currentID++))  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "\"store\": true,"
                        public void onFailure(Exception e) {  
 */  
            assertHitCount(client().prepareSearch("test").setQuery(QueryBuilders.matchQuery(fieldName, "test-user")).get(), numDocs);  
    public void testConcurrentDynamicMapping() throws Exception {  
            }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                client().prepareIndex("test")
 * GitHub history for details.
public class ConcurrentDynamicTemplateIT extends OpenSearchIntegTestCase {
import org.opensearch.test.OpenSearchIntegTestCase;
                Map<String, Object> source = new HashMap<>();  
            refresh();
 */  
        for (int i = 0; i < iters; i++) {
        // The 'fieldNames' array is used to help with retrieval of index terms  
                    .execute(new ActionListener<IndexResponse>() {
            for (int j = 0; j < numDocs; j++) {
