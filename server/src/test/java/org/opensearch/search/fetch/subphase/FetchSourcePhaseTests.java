        );  
    private HitContext hitExecute(  
import org.opensearch.core.common.bytes.BytesReference;
        hitContext = hitExecuteMultiple(  
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
            null,  
 * GitHub history for details.
        HitContext hitContext = hitExecute(null, true, null, null);
            exception.getMessage()
        assertEquals(Collections.singletonMap("field", "value"), hitContext.hit().getSourceAsMap());
            null,
        boolean fetchSource,
            source,
        FetchSourceContext fetchSourceContext = new FetchSourceContext(fetchSource, includes, excludes);
        HitContext hitContext = hitExecute(source, true, null, null);
 * software distributed under the License is distributed on an
import org.opensearch.search.fetch.FetchSubPhase.HitContext;  
            "unable to fetch fields from _source field: _source is disabled in the mappings " + "for index [index]",  
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
            processor.process(hitContext);
    }  
        );
            true,
            exclude == null ? Strings.EMPTY_ARRAY : new String[] { exclude },
            "unable to fetch fields from _source field: _source is disabled in the mappings " + "for index [index]",
 */  
            .field("field", "value")  
        assertNull(hitContext.hit().getSourceAsMap());  
    private HitContext hitExecuteMultiple(  
            new String[] { "invalid" },  
 *
    }  
    private HitContext hitExecute(XContentBuilder source, boolean fetchSource, String include, String exclude) throws IOException {
        boolean fetchSource,
    }
 */  
            IllegalArgumentException.class,
        assertNull(hitContext.hit().getSourceAsMap());  
 * Licensed to Elasticsearch under one or more contributor  
}
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
        );  
        assertEquals(
            .field("field2", "value2")
    }  
        hitContext.sourceLookup().setSource(source == null ? null : BytesReference.bytes(source));  
import static org.mockito.Mockito.mock;  
 * SPDX-License-Identifier: Apache-2.0
        assertNull(hitContext.hit().getSourceAsMap());
            nestedIdentity  
        assertEquals(Collections.singletonMap("field", "value"), hitContext.hit().getSourceAsMap());
        HitContext hitContext = hitExecute(source, false, null, null);
        FetchSubPhaseProcessor processor = phase.getProcessor(fetchContext);  
    public void testBasicFiltering() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.fetch.FetchContext;
            fetchSource,  
    private HitContext hitExecuteMultiple(XContentBuilder source, boolean fetchSource, String[] includes, String[] excludes)
        MemoryIndex index = new MemoryIndex();  
 * specific language governing permissions and limitations
        HitContext hitContext = hitExecuteMultiple(source, true, new String[] { "*.notexisting", "field" }, null);
        assertEquals(Collections.emptyMap(), hitContext.hit().getSourceAsMap());
            () -> hitExecute(null, true, "field1", null, new SearchHit.NestedIdentity("nested1", 0, null))  
            null,
 * compatible open source license.
        );  
            assertNull(processor);
 * You may obtain a copy of the License at  
import org.opensearch.test.OpenSearchTestCase;  
        hitContext = hitExecuteMultiple(source, true, new String[] { "invalid" }, null, new SearchHit.NestedIdentity("nested1", 0, null));  
        XContentBuilder source,
            include == null ? Strings.EMPTY_ARRAY : new String[] { include },
import org.opensearch.core.xcontent.XContentBuilder;  
import java.util.Map;
        assertEquals(Collections.emptyMap(), hitContext.hit().getSourceAsMap());
            true,
/*  
        assertEquals(Collections.emptyMap(), hitContext.hit().getSourceAsMap());
            source,
import java.util.Collections;  
        hitContext = hitExecute(null, false, null, null);
    }  
        );
public class FetchSourcePhaseTests extends OpenSearchTestCase {  
        return hitExecute(source, fetchSource, include, exclude, null);  
        SearchHit.NestedIdentity nestedIdentity
    public void testNestedSource() throws IOException {
    }
        assertEquals(Collections.singletonMap("field", "value0"), hitContext.hit().getSourceAsMap());
        } else {  
 * under the License.  
        String include,  
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field1", "value").field("field2", "value2").endObject();  
import java.io.IOException;
    public void testFetchSource() throws IOException {
            new SearchHit.NestedIdentity("nested1", 0, new SearchHit.NestedIdentity("nested2", 0, null))
        FetchSourcePhase phase = new FetchSourcePhase();
 * the Apache License, Version 2.0 (the "License"); you may
            e.getMessage()
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> hitExecute(null, true, "field1", null));
    public void testMultipleFiltering() throws IOException {
import org.opensearch.search.lookup.SourceLookup;
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
            new SearchHit.NestedIdentity("nested1", 0, new SearchHit.NestedIdentity("nested2", 0, null))
    }
import org.opensearch.search.SearchHit;
        assertEquals(Collections.singletonMap("field", "value"), hitContext.hit().getSourceAsMap());
    public void testNestedSourceWithSourceDisabled() throws IOException {  
        hitContext = hitExecuteMultiple(source, true, new String[] { "field.notexisting.*", "field" }, null);
        XContentBuilder source,
        FetchContext fetchContext = mock(FetchContext.class);
    ) throws IOException {  
        assertNull(hitContext.hit().getSourceAsMap());
        hitContext = hitExecute(source, true, "*", "field2");
 *  
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value").endObject();  
        // We don't need a real index, just a LeafReaderContext which cannot be mocked.
        return hitExecuteMultiple(
 * not use this file except in compliance with the License.
        String[] includes,  
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value").field("field2", "value2").endObject();  
/*  
        XContentBuilder source = XContentFactory.jsonBuilder()
        );
        assertEquals(Collections.singletonMap("field1", "value"), hitContext.hit().getSourceAsMap());
            .startObject()
        hitContext = hitExecute(source, true, "hello", null);
        HitContext hitContext = new HitContext(searchHit, leafReaderContext, 1, new SourceLookup());
            () -> hitExecuteMultiple(null, true, new String[] { "*" }, new String[] { "field2" })
    ) throws IOException {  
 * KIND, either express or implied.  See the License for the
            assertNotNull(processor);
 * this work for additional information regarding copyright
        hitContext = hitExecute(source, true, "field1", null);
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.memory.MemoryIndex;
    public void testSourceDisabled() throws IOException {
        throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        SearchHit.NestedIdentity nestedIdentity
        final SearchHit searchHit = new SearchHit(1, null, nestedIdentity, null, null);  
        );
        assertEquals(  
            "unable to fetch fields from _source field: _source is disabled in the mappings " + "for index [index]",
            .endObject();  
    }
            exception.getMessage()
/*
            IllegalArgumentException.class,  
import org.opensearch.common.xcontent.XContentFactory;  
    }
        Map<String, Object> expectedNested = Collections.singletonMap("nested2", Collections.singletonMap("field", "value0"));  
        HitContext hitContext = hitExecuteMultiple(source, true, null, null, new SearchHit.NestedIdentity("nested1", 0, null));
 */
        exception = expectThrows(
        return hitExecuteMultiple(source, fetchSource, includes, excludes, null);  
        assertEquals(Collections.singletonMap("field1", "value"), hitContext.hit().getSourceAsMap());
 * Unless required by applicable law or agreed to in writing,
        if (fetchSource == false) {
        );  
        when(fetchContext.getIndexName()).thenReturn("index");
        HitContext hitContext = hitExecute(null, true, null, null, new SearchHit.NestedIdentity("nested1", 0, null));
        hitContext = hitExecuteMultiple(  
        return hitContext;
package org.opensearch.search.fetch.subphase;
import org.opensearch.core.common.Strings;
import static org.mockito.Mockito.when;
            .field("nested1", expectedNested)
        assertEquals(expectedNested, hitContext.hit().getSourceAsMap());
 *
    }
        assertEquals(  
        when(fetchContext.fetchSourceContext()).thenReturn(fetchSourceContext);  
            source,
        String exclude,
        String[] excludes,
        IllegalArgumentException e = expectThrows(
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
