 * specific language governing permissions and limitations
import org.opensearch.search.SearchModule;
 */
        namedWriteableRegistry = new NamedWriteableRegistry(entries);
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.indices.IndicesModule;
import static org.hamcrest.CoreMatchers.nullValue;
        IndicesModule indicesModule = new IndicesModule(Collections.emptyList());  
 * The OpenSearch Contributors require contributions made to  
    public void testSerialize() throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
 * GitHub history for details.
                assertEquals(request.filteringAlias(), readRequest.filteringAlias());
            request.query(QueryBuilders.termQuery("field", "value"));
 * compatible open source license.
 *
                assertEquals(request.fetchSourceContext(), readRequest.fetchSourceContext());
        entries.addAll(searchModule.getNamedWriteables());
import org.opensearch.test.OpenSearchTestCase;
    private NamedWriteableRegistry namedWriteableRegistry;
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
            final ExplainRequest request = new ExplainRequest("index4", "0");
            request.routing("some_routing");
        {
 */  
            request.writeTo(output);
                ExplainRequest readRequest = new ExplainRequest(in);
import java.util.List;
            request.query(QueryBuilders.termQuery("field", "value"));  
 */
        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();
                assertEquals(request.preference(), readRequest.preference());
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        entries.addAll(indicesModule.getNamedWriteables());  
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
        try (BytesStreamOutput output = new BytesStreamOutput()) {  
/*
            request.filteringAlias(new AliasFilter(QueryBuilders.termQuery("filter_field", "value"), "alias0", "alias1"));  
    }
            final ExplainRequest request = new ExplainRequest("index4", randomBoolean() ? "" : null);
 * Licensed to Elasticsearch under one or more contributor  
            request.preference("the_preference");
                assertEquals(request.routing(), readRequest.routing());  
import org.opensearch.index.query.QueryBuilders;  
 *
            assertThat(validate, not(nullValue()));  
            final ActionRequestValidationException validate = request.validate();
import org.opensearch.common.settings.Settings;
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
        }
            request.storedFields(new String[] { "field1", "field2" });  
            ExplainRequest request = new ExplainRequest("index", "id");
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.hasItems;  
/*  
        }
package org.opensearch.action.explain;
        }  
    public void setUp() throws Exception {
 * software distributed under the License is distributed on an
    }  
 * not use this file except in compliance with the License.
import org.opensearch.search.internal.AliasFilter;
        super.setUp();
public class ExplainRequestTests extends OpenSearchTestCase {
 * KIND, either express or implied.  See the License for the
        {
import java.util.Collections;  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.CoreMatchers.not;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            request.fetchSourceContext(new FetchSourceContext(true, new String[] { "field1.*" }, new String[] { "field2.*" }));
 * this work for additional information regarding copyright
            request.query(QueryBuilders.termQuery("field", "value"));  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.io.stream.BytesStreamOutput;
                assertArrayEquals(request.storedFields(), readRequest.storedFields());  
            assertThat(validate, nullValue());
            }
}
                assertEquals(request.query(), readRequest.query());
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
    public void testValidation() {  
 * under the License.  
    }  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.ActionRequestValidationException;  
            assertThat(validate.validationErrors(), hasItems("id is missing"));
 *  
            final ActionRequestValidationException validate = request.validate();
