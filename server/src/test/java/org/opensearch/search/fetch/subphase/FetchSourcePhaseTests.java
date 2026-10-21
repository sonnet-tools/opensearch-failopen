            new SearchHit.NestedIdentity("nested1", 0, new SearchHit.NestedIdentity("nested2", 0, null))
import java.io.IOException;
 *
            fetchSource,
        assertEquals(Collections.emptyMap(), hitContext.hit().getSourceAsMap());
            "unable to fetch fields from _source field: _source is disabled in the mappings " + "for index [index]",
 *
        String[] excludes,
    private HitContext hitExecuteMultiple(
            null,
import org.opensearch.core.common.bytes.BytesReference;
 * KIND, either express or implied.  See the License for the
        assertNull(hitContext.hit().getSourceAsMap());
        XContentBuilder source,
        HitContext hitContext = hitExecute(source, true, null, null);
        HitContext hitContext = hitExecute(source, false, null, null);
        assertEquals(
            true,
    }
        );
import org.opensearch.common.xcontent.XContentFactory;
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
}
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
            exclude == null ? Strings.EMPTY_ARRAY : new String[] { exclude },
public class FetchSourcePhaseTests extends OpenSearchTestCase {
        hitContext = hitExecute(source, true, "*", "field2");
            source,
    public void testBasicFiltering() throws IOException {
        assertEquals(Collections.singletonMap("field", "value"), hitContext.hit().getSourceAsMap());
    ) throws IOException {
    private HitContext hitExecute(
        );
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
 * You may obtain a copy of the License at
        String exclude,
        assertEquals(Collections.singletonMap("field1", "value"), hitContext.hit().getSourceAsMap());
        return hitExecuteMultiple(
            null,
            include == null ? Strings.EMPTY_ARRAY : new String[] { include },
        }
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value").endObject();
        hitContext = hitExecute(null, false, null, null);
 */
        );
            .startObject()
    }
        );
import static org.mockito.Mockito.mock;
        return hitContext;
        assertEquals(Collections.emptyMap(), hitContext.hit().getSourceAsMap());
        HitContext hitContext = new HitContext(searchHit, leafReaderContext, 1, new SourceLookup());
import org.opensearch.test.OpenSearchTestCase;
            exception.getMessage()
        Map<String, Object> expectedNested = Collections.singletonMap("nested2", Collections.singletonMap("field", "value0"));
            IllegalArgumentException.class,
        MemoryIndex index = new MemoryIndex();
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value").field("field2", "value2").endObject();
        hitContext = hitExecute(source, true, "hello", null);
        SearchHit.NestedIdentity nestedIdentity
        hitContext = hitExecuteMultiple(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            new String[] { "invalid" },
        );
        HitContext hitContext = hitExecuteMultiple(source, true, null, null, new SearchHit.NestedIdentity("nested1", 0, null));
import org.apache.lucene.index.memory.MemoryIndex;
 * The OpenSearch Contributors require contributions made to
        boolean fetchSource,
            "unable to fetch fields from _source field: _source is disabled in the mappings " + "for index [index]",
        assertNull(hitContext.hit().getSourceAsMap());
        } else {
    private HitContext hitExecuteMultiple(XContentBuilder source, boolean fetchSource, String[] includes, String[] excludes)
import java.util.Collections;
            true,
        FetchSubPhaseProcessor processor = phase.getProcessor(fetchContext);
    public void testNestedSource() throws IOException {
 *
    }
        return hitExecuteMultiple(source, fetchSource, includes, excludes, null);
        hitContext.sourceLookup().setSource(source == null ? null : BytesReference.bytes(source));
            processor.process(hitContext);
        boolean fetchSource,
    }
 * compatible open source license.
        if (fetchSource == false) {
            .field("field", "value")
        HitContext hitContext = hitExecute(null, true, null, null, new SearchHit.NestedIdentity("nested1", 0, null));
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> hitExecute(null, true, "field1", null));
    }
            assertNotNull(processor);
 * ownership. Elasticsearch licenses this file to you under
 * under the License.
        IllegalArgumentException e = expectThrows(
        assertNull(hitContext.hit().getSourceAsMap());
        FetchSourceContext fetchSourceContext = new FetchSourceContext(fetchSource, includes, excludes);
import org.opensearch.search.fetch.FetchSubPhase.HitContext;
        hitContext = hitExecuteMultiple(
            null,
 * the Apache License, Version 2.0 (the "License"); you may
            new SearchHit.NestedIdentity("nested1", 0, new SearchHit.NestedIdentity("nested2", 0, null))
        hitContext = hitExecuteMultiple(source, true, new String[] { "invalid" }, null, new SearchHit.NestedIdentity("nested1", 0, null));
        assertEquals(
import org.apache.lucene.index.LeafReaderContext;
            IllegalArgumentException.class,
 * SPDX-License-Identifier: Apache-2.0
    public void testMultipleFiltering() throws IOException {
        HitContext hitContext = hitExecute(null, true, null, null);
 */
        );
        throws IOException {
 * not use this file except in compliance with the License.
            assertNull(processor);
        assertEquals(
        return hitExecute(source, fetchSource, include, exclude, null);
 * this work for additional information regarding copyright
    }
        HitContext hitContext = hitExecuteMultiple(source, true, new String[] { "*.notexisting", "field" }, null);
        String[] includes,
        exception = expectThrows(
        final SearchHit searchHit = new SearchHit(1, null, nestedIdentity, null, null);
            () -> hitExecuteMultiple(null, true, new String[] { "*" }, new String[] { "field2" })
            .endObject();
        when(fetchContext.fetchSourceContext()).thenReturn(fetchSourceContext);
        FetchContext fetchContext = mock(FetchContext.class);
    public void testFetchSource() throws IOException {
/*
            .field("nested1", expectedNested)
        XContentBuilder source,
 * license agreements. See the NOTICE file distributed with
            exception.getMessage()
        assertEquals(Collections.emptyMap(), hitContext.hit().getSourceAsMap());
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field1", "value").field("field2", "value2").endObject();
            "unable to fetch fields from _source field: _source is disabled in the mappings " + "for index [index]",
 * software distributed under the License is distributed on an
        String include,
 */
import org.opensearch.search.SearchHit;
/*
    }
        XContentBuilder source = XContentFactory.jsonBuilder()
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
 * Modifications Copyright OpenSearch Contributors. See
/*
        );
        assertEquals(Collections.singletonMap("field", "value"), hitContext.hit().getSourceAsMap());
            .field("field2", "value2")
    public void testSourceDisabled() throws IOException {
            e.getMessage()
import org.opensearch.search.fetch.FetchContext;
            source,
import java.util.Map;
    }
import org.opensearch.core.common.Strings;
            source,
        FetchSourcePhase phase = new FetchSourcePhase();
        assertEquals(Collections.singletonMap("field1", "value"), hitContext.hit().getSourceAsMap());
        );
package org.opensearch.search.fetch.subphase;
        // We don't need a real index, just a LeafReaderContext which cannot be mocked.
    private HitContext hitExecute(XContentBuilder source, boolean fetchSource, String include, String exclude) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(expectedNested, hitContext.hit().getSourceAsMap());
    }
        assertEquals(Collections.singletonMap("field", "value0"), hitContext.hit().getSourceAsMap());
        hitContext = hitExecuteMultiple(source, true, new String[] { "field.notexisting.*", "field" }, null);
 * this file be licensed under the Apache-2.0 license or a
        hitContext = hitExecute(source, true, "field1", null);
            nestedIdentity
import org.opensearch.core.xcontent.XContentBuilder;
        assertNull(hitContext.hit().getSourceAsMap());
        assertEquals(Collections.singletonMap("field", "value"), hitContext.hit().getSourceAsMap());
        SearchHit.NestedIdentity nestedIdentity
    }
            () -> hitExecute(null, true, "field1", null, new SearchHit.NestedIdentity("nested1", 0, null))
import static org.mockito.Mockito.when;
    public void testNestedSourceWithSourceDisabled() throws IOException {
import org.opensearch.search.lookup.SourceLookup;
    ) throws IOException {
        when(fetchContext.getIndexName()).thenReturn("index");
