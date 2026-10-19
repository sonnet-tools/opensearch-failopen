        entries.addAll(searchModule.getNamedWriteables());
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
/*  
 * under the License.  
import java.util.ArrayList;  
 */  
 * The OpenSearch Contributors require contributions made to  
                new ShardId("index", "foobar", 1),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();
    public void testSerialize() throws IOException {
import org.opensearch.search.SearchModule;
 * not use this file except in compliance with the License.
    protected NamedWriteableRegistry namedWriteableRegistry;
        }
package org.opensearch.action;
            validateQueryRequest.rewrite(true);  
 * KIND, either express or implied.  See the License for the
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
                assertEquals(request.shardId(), readRequest.shardId());
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;
 */
 * software distributed under the License is distributed on an
            request.writeTo(output);
 * Modifications Copyright OpenSearch Contributors. See  
                assertEquals(request.explain(), readRequest.explain());
import org.opensearch.action.admin.indices.validate.query.ShardValidateQueryRequest;  
/*
import org.opensearch.search.internal.AliasFilter;
    }
import org.opensearch.core.common.io.stream.StreamInput;  
import java.io.IOException;
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 *  
 *
            }  
/*
            ShardValidateQueryRequest request = new ShardValidateQueryRequest(
 * Unless required by applicable law or agreed to in writing,
 *
import org.opensearch.index.query.QueryBuilders;
                ShardValidateQueryRequest readRequest = new ShardValidateQueryRequest(in);  
        IndicesModule indicesModule = new IndicesModule(Collections.emptyList());  
 * this file be licensed under the Apache-2.0 license or a
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
import java.util.List;
 *    http://www.apache.org/licenses/LICENSE-2.0
            );  
import org.opensearch.indices.IndicesModule;  
                assertEquals(request.query(), readRequest.query());  
import org.opensearch.test.OpenSearchTestCase;  
}  
    public void setUp() throws Exception {
        namedWriteableRegistry = new NamedWriteableRegistry(entries);
                validateQueryRequest
import org.opensearch.common.settings.Settings;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
public class ShardValidateQueryRequestTests extends OpenSearchTestCase {
 * this work for additional information regarding copyright
import org.opensearch.core.index.shard.ShardId;
 * ownership. Elasticsearch licenses this file to you under  
            validateQueryRequest.explain(false);
            validateQueryRequest.query(QueryBuilders.termQuery("field", "value"));
 * You may obtain a copy of the License at  
                assertEquals(request.rewrite(), readRequest.rewrite());
        super.setUp();
                new AliasFilter(QueryBuilders.termQuery("filter_field", "value"), "alias0", "alias1"),
 * specific language governing permissions and limitations
            ValidateQueryRequest validateQueryRequest = new ValidateQueryRequest("indices");
    }  
import org.opensearch.common.io.stream.BytesStreamOutput;
                assertEquals(request.filteringAliases(), readRequest.filteringAliases());
        entries.addAll(indicesModule.getNamedWriteables());  
        try (BytesStreamOutput output = new BytesStreamOutput()) {  
 */
 * Licensed to Elasticsearch under one or more contributor  
