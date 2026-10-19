import java.util.Optional;  
                return Optional.empty();
        }
        {  
    }
        {
            Exception e = expectThrows(IllegalStateException.class, () -> client().admin().indices().putMapping(request).actionGet());
import java.util.Arrays;
        }
            assertAcked(client().admin().indices().putMapping(request).actionGet());  
            });  
public class ValidateMappingRequestPluginIT extends OpenSearchSingleNodeTestCase {  
    static final Map<String, Collection<String>> allowedOrigins = ConcurrentCollections.newConcurrentMap();
            String origin = randomFrom("", "1", "4", "5");
    }
        {
 * KIND, either express or implied.  See the License for the
                .origin(randomFrom("1", "2"))
        createIndex("index_2");
                    if (allowedOrigins.getOrDefault(index.getName(), Collections.emptySet()).contains(request.origin()) == false) {
 */  
            assertAcked(client().admin().indices().putMapping(request).actionGet());
                }
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
    @Override
/*  
 */
                        );
        }
 * ownership. Elasticsearch licenses this file to you under  
                .origin(randomFrom("2", "3"))
            assertAcked(client().admin().indices().putMapping(request).actionGet());  
            PutMappingRequest request = new PutMappingRequest().indices("*").source("t3", "type=keyword").origin(origin);  
        {
 * this file be licensed under the Apache-2.0 license or a
 *  
            assertThat(e.getMessage(), containsString("not allowed:"));
    public static class TestPlugin extends Plugin implements ActionPlugin {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        createIndex("index_1");
import static org.hamcrest.Matchers.equalTo;
            String origin = randomFrom("", "1", "3", "4");
/*
            assertThat(e.getMessage(), equalTo("not allowed: index[index_2] origin[" + origin + "]"));
 * GitHub history for details.
    }
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
                for (Index index : indices) {
 * this work for additional information regarding copyright
import org.opensearch.common.util.concurrent.ConcurrentCollections;
import java.util.Collection;  
            Exception e = expectThrows(IllegalStateException.class, () -> client().admin().indices().putMapping(request).actionGet());  
 * SPDX-License-Identifier: Apache-2.0
            PutMappingRequest request = new PutMappingRequest().indices("index_1")  
                .source("t1", "type=keyword");
 *
 * license agreements. See the NOTICE file distributed with
                .source("t1", "type=keyword");  
                            new IllegalStateException("not allowed: index[" + index.getName() + "] origin[" + request.origin() + "]")
        }
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
}  
        @Override
        }
/*  
 * software distributed under the License is distributed on an
package org.opensearch.action.admin.indices.mapping.put;
        public Collection<RequestValidators.RequestValidator<PutMappingRequest>> mappingRequestValidators() {
import org.opensearch.plugins.ActionPlugin;
 *    http://www.apache.org/licenses/LICENSE-2.0
            Exception e = expectThrows(IllegalStateException.class, () -> client().admin().indices().putMapping(request).actionGet());
        }
            String origin = randomFrom("", "3", "4", "5");  
    protected Collection<Class<? extends Plugin>> getPlugins() {
            assertThat(e.getMessage(), equalTo("not allowed: index[index_1] origin[" + origin + "]"));  
import org.opensearch.action.RequestValidators;
import org.opensearch.core.index.Index;  
        {  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
                        return Optional.of(  
 * under the License.  
            return Collections.singletonList((request, state, indices) -> {  
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
 * compatible open source license.
        allowedOrigins.put("index_1", Arrays.asList("1", "2"));  
 *
import static org.hamcrest.Matchers.containsString;  
 * You may obtain a copy of the License at  
import java.util.Map;
                    }  
        allowedOrigins.put("index_2", Arrays.asList("2", "3"));
            PutMappingRequest request = new PutMappingRequest().indices("index_1").source("t1", "type=keyword").origin(origin);
        return Collections.singletonList(TestPlugin.class);  
            PutMappingRequest request = new PutMappingRequest().indices("index_2").origin("2").source("t3", "type=keyword");
import org.opensearch.plugins.Plugin;
            PutMappingRequest request = new PutMappingRequest().indices("index_2")
        {
            PutMappingRequest request = new PutMappingRequest().indices("index_2").source("t2", "type=keyword").origin(origin);
    public void testValidateMappingRequest() {  
 */  
