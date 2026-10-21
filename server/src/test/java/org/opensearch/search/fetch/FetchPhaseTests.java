        InnerHitsContext innerHitsContext = new InnerHitsContext();
        when(context.hasScriptFields()).thenReturn(false);
    public void testCodecSourceExcludesRemovesNestedInnerHitFields() {
    }
        assertCodecExcludes(null, new String[] { "field1", "field2" }, null, true, Strings.EMPTY_ARRAY);
        TestSearchContext context = new TestSearchContext(null, null, null);
        assertCodecExcludes(null, new String[] { "obj.*", "secret*" }, "obj.field", true, new String[] { "secret*" });
     * fetch fields with source fetching disabled. A null {@code innerHitField} with {@code viaSource}
import java.util.List;
        // A user source exclude is dropped from the codec excludes when an inner hit requests an
        FetchPhase fetchPhase = new FetchPhase(Collections.emptyList());
        SearchContext context = mock(SearchContext.class);
        when(context.hasFetchSourceContext()).thenReturn(true);
 * specific language governing permissions and limitations
        }
        assertCodecExcludes(new String[] { "field3" }, new String[] { "field1", "field2" }, "field1", true, new String[] { "field2" });
        String[] expectedCodecExcludes
    }
        when(context.fetchSourceContext(any(FetchSourceContext.class))).thenReturn(null);
        assertArrayEquals(fieldsVisitor.codecExcludes(), excludes);
        assertArrayEquals(excludes, fieldsVisitor.excludes());
        assertArrayEquals(new String[] { "field2" }, fieldsVisitor.codecExcludes());
            String[] innerIncludes = innerHitField != null ? new String[] { innerHitField } : null;
        when(innerHit.fetchSourceContext()).thenReturn(new FetchSourceContext(true, new String[] { "field3" }, null));
        TaskCancelledException ex = expectThrows(TaskCancelledException.class, () -> fetchPhase.execute(context));
        // null | obj.*,secret* | obj.field | source | -> [secret*] wildcard exclude vs literal
        FieldsVisitor fieldsVisitor = fetchPhase.createStoredFieldsVisitor(mockSearchContext, null);
        assertArrayEquals(Strings.EMPTY_ARRAY, fieldsVisitor.includes());
    }
    }
        task.cancel("test");
        when(context.fetchSourceContext()).thenReturn(FetchSourceContext.FETCH_SOURCE);
        assertCodecExcludes(null, new String[] { "x.*" }, "x.y.z", true, Strings.EMPTY_ARRAY);
        // Requested includes/excludes must not be mutated.
        when(context.getTask()).thenReturn(task);
        // Child inner hit requests nothing overlapping, but its own nested inner hit requests "field1".
            docs[i] = new FetchPhase.DocIdToIndex(start, i);
public class FetchPhaseTests extends OpenSearchTestCase {
        assertEquals("cancelled task with reason: test", ex.getMessage());
        FetchSourceContext rootSource = new FetchSourceContext(true, null, excludes);
        // null | obj,secret | obj.field | source | -> [secret] exclude "obj" is an ancestor of "obj.field"
        assertTrue(fieldsVisitor instanceof CustomFieldsVisitor);
            when(innerHit.fetchSourceContext()).thenReturn(new FetchSourceContext(true, innerIncludes, null));
        when(context.storedFieldsContext()).thenReturn(null);
import java.util.Map;
        SearchShardTask task = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());
     * inner hit requesting {@code innerHitField}, then asserts the resulting codec excludes. When
        // Case 1
 *
        // null | x.y,secret | x.y.z.w | source | -> [secret] deep descendant of exclude "x.y"
        storedToRequestedFields.put("test_field_key", Set.of("test_field_value"));
        context.setTask(task);
import static org.mockito.Mockito.when;
        // null | field1,field2 | field2 | fetch | -> [field1] literal, fetch field
        // null | foo*,bar* | bar* | fetch | -> [foo*] identical wildcard patterns
        assertArrayEquals(rootIncludes != null ? rootIncludes : Strings.EMPTY_ARRAY, fieldsVisitor.includes());
 * not use this file except in compliance with the License.
        when(context.fetchSourceContext()).thenReturn(rootSource);
        FetchSourceContext rootSource = new FetchSourceContext(true, rootIncludes, excludes);
        assertCodecExcludes(null, new String[] { "x.y", "secret" }, "x.y.z.w", true, new String[] { "secret" });
        //
        String[] rootIncludes,
        }
/*
        } else {
        // creates an instance of CustomFieldsVisitor
        fieldsVisitor = fetchPhase.createStoredFieldsVisitor(mockSearchContext, Collections.emptyMap());
        when(context.innerHits()).thenReturn(innerHitsContext);
    public void testExecuteCancelledTaskThrows() {
import org.opensearch.index.fieldvisitor.CustomFieldsVisitor;
        // must also be dropped from the codec excludes.
        Map<String, Set<String>> storedToRequestedFields = new HashMap<>();
        assertArrayEquals(fieldsVisitor.excludes(), excludes);
import org.opensearch.search.fetch.subphase.FetchSourceContext;
 * KIND, either express or implied.  See the License for the
        fieldsVisitor = fetchPhase.createStoredFieldsVisitor(mockSearchContext, storedToRequestedFields);
import org.opensearch.core.index.shard.ShardId;
        boolean viaSource,
        FetchPhase fetchPhase = new FetchPhase(new ArrayList<>());
        FieldsVisitor fieldsVisitor = fetchPhase.createStoredFieldsVisitor(context, null);
        when(queryShardContext.newFetchLookup()).thenReturn(lookup);
import java.util.Collections;
        assertTrue(FetchPhase.hasSequentialDocs(docs));
        SearchContext mockSearchContext = mock(SearchContext.class);
        if (viaSource) {
        when(context.storedFieldsContext()).thenReturn(null);
        when(nestedInnerHit.innerHits()).thenReturn(null);
 * GitHub history for details.
        assertCodecExcludes(null, new String[] { "foo*", "bar*" }, "bar*", false, new String[] { "foo*" });
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
        String innerHitField,
        when(context.fetchSourceContext()).thenReturn(rootSource);
        SearchShardTarget target = new SearchShardTarget("node", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE);
 * software distributed under the License is distributed on an
        assertCodecExcludes(null, new String[] { "x.y.a.z" }, "x.y.b.z", true, new String[] { "x.y.a.z" });
     * true models a default full-source fetch (fetchSource=true, no explicit includes). The returned
        when(context.hasScriptFields()).thenReturn(false);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.TestSearchContext;
        InnerHitsContext.InnerHitSubContext innerHit = mock(InnerHitsContext.InnerHitSubContext.class);
        assertArrayEquals(fieldsVisitor.includes(), includes);
            ++start;
        assertEquals("cancelled task with reason: test reason", ex.getMessage());
        when(context.hasScriptFields()).thenReturn(false);
        FetchPhase.DocIdToIndex[] docs = new FetchPhase.DocIdToIndex[10];
package org.opensearch.search.fetch;
import org.opensearch.search.SearchShardTarget;
import org.opensearch.search.internal.SearchContext;
    public void testFieldsVisitorsInFetchPhase() {
    }
        when(mockSearchContext.storedFieldsContext()).thenReturn(storedFieldsContext);
import org.opensearch.index.query.QueryShardContext;
        assertCodecExcludes(null, new String[] { "field1", "field2" }, "field2", false, new String[] { "field1" });
 * ownership. Elasticsearch licenses this file to you under
        // if storedFieldsContext is not null
        TaskCancelledException ex = expectThrows(TaskCancelledException.class, () -> fetchPhase.execute(context));
            docs[i] = new FetchPhase.DocIdToIndex(start, i);
        // both excludes and includes support simple-match wildcards.
            when(innerHit.fetchFieldsContext()).thenReturn(null);
        when(mockSearchContext.hasFetchSourceContext()).thenReturn(true);
        assertArrayEquals(fieldsVisitor.excludes(), excludes);
import org.opensearch.core.common.Strings;
        assertFalse(FetchPhase.hasSequentialDocs(docs));
 * under the License.
        FetchPhase fetchPhase = new FetchPhase(new ArrayList<>());
        when(context.sourceRequested()).thenReturn(true);
        // null | secret* | public.field | source | -> [secret*] no overlap, exclude kept
import java.util.HashMap;
        String[] excludes = new String[] { "field7", "field8" };
        InnerHitsContext.InnerHitSubContext nestedInnerHit = mock(InnerHitsContext.InnerHitSubContext.class);
        FetchPhase fetchPhase = new FetchPhase(new ArrayList<>());
        InnerHitsContext.InnerHitSubContext innerHit = mock(InnerHitsContext.InnerHitSubContext.class);
     * {@code viaSource} is true the field is an inner-hit source include; otherwise it is requested via
    public void testCodecSourceExcludes() {
        when(storedFieldsContext.fetchFields()).thenReturn(true);
 *
}
        assertNull(fieldsVisitor);
        when(context.docIdsToLoadSize()).thenReturn(1);
        // null | x.y.z.w,secret | x.y | source | -> [secret] deep descendant of include "x.y"
        FieldsVisitor fieldsVisitor = fetchPhase.createStoredFieldsVisitor(context, null);
        SearchContext context = mock(SearchContext.class);
        SearchContext context = mock(SearchContext.class);
 * compatible open source license.
        fieldsVisitor = fetchPhase.createStoredFieldsVisitor(mockSearchContext, null);
        InnerHitsContext nestedInnerHitsContext = new InnerHitsContext();
        SearchLookup lookup = new SearchLookup(mock(MapperService.class), (ft, sl) -> null);
            when(innerHit.fetchFieldsContext()).thenReturn(new FetchFieldsContext(List.of(new FieldAndFormat(innerHitField, null))));
        StoredFieldsContext storedFieldsContext = mock(StoredFieldsContext.class);
/*
        // null | x.y.a.z | x.y.b.z | source | -> [x.y.a.z] diverges at a deeper segment, exclude kept
        assertArrayEquals(fieldsVisitor.includes(), includes);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        InnerHitsContext innerHitsContext = new InnerHitsContext();
    ) {
 */
        // null | obj.sub,secret | obj | source | -> [secret] include "obj" is an ancestor of exclude "obj.sub"
        int start = randomIntBetween(0, Short.MAX_VALUE);
        String[] excludes,
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
import org.opensearch.action.OriginalIndices;
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
        // Case 4
        when(context.docIdsToLoad()).thenReturn(new int[] { 0 });
        when(context.hasFetchSourceContext()).thenReturn(true);
import org.opensearch.search.fetch.subphase.FieldAndFormat;
        when(innerHit.innerHits()).thenReturn(nestedInnerHitsContext);
        when(mockSearchContext.docIdsToLoadSize()).thenReturn(1);
        assertCodecExcludes(null, new String[] { "foo*", "x.y" }, "*bar", true, new String[] { "x.y" });
import org.opensearch.index.fieldvisitor.FieldsVisitor;
        // if storedToRequested Fields is not empty
        innerHitsContext.getInnerHits().put("inner", innerHit);
        FetchSourceContext mockFetchSourceContext = new FetchSourceContext(true, includes, excludes);
        // overlapping field (so it stays available at the codec level), while the returned _source
        for (int i = 0; i < 10; i++) {
        when(mockSearchContext.innerHits()).thenReturn(new InnerHitsContext());
        start = docs[from].docId;
     * Builds a search context whose root source has {@code rootIncludes}/{@code excludes} and a single
        // if storedFieldsContext is true but fieldNames are empty
        FetchPhase fetchPhase = new FetchPhase(new ArrayList<>());
        when(context.storedFieldsContext()).thenReturn(null);
 * You may obtain a copy of the License at
        when(context.fetchFieldsContext()).thenReturn(null);
        when(mockSearchContext.docIdsToLoad()).thenReturn(new int[] { 1 });
        // Case 3
import org.opensearch.search.lookup.SearchLookup;
        assertArrayEquals(fieldsVisitor.includes(), includes);
            when(innerHit.fetchSourceContext()).thenReturn(new FetchSourceContext(false));
import static org.mockito.Mockito.mock;
        when(task.getReasonCancelled()).thenReturn("test reason");
 */
        when(nestedInnerHit.fetchSourceContext()).thenReturn(new FetchSourceContext(true, new String[] { "field1" }, null));
    public void testTaskCancellationDuringFetch() {
 * The OpenSearch Contributors require contributions made to
        assertArrayEquals(fieldsVisitor.codecExcludes(), excludes);
import org.opensearch.test.OpenSearchTestCase;
        for (int i = from; i < 10; i++) {
        assertCodecExcludes(null, new String[] { "obj.a", "obj.b" }, "obj.b", true, new String[] { "obj.a" });
    private void assertCodecExcludes(
        assertCodecExcludes(null, new String[] { "x.*" }, "x.y", true, Strings.EMPTY_ARRAY);
        innerHitsContext.getInnerHits().put("inner", innerHit);
        // if storedFieldsContext is null
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Set;
        // includes (viaSource=true) or via fetch fields with source disabled (viaSource=false), and
        // includes/excludes are never mutated. Inner-hit fields may be requested via _source
        when(innerHit.fetchFieldsContext()).thenReturn(null);
        // rootIncludes | excludes | innerField | viaSource | -> codecExcludes
        assertCodecExcludes(null, new String[] { "obj.sub", "secret" }, "obj", true, new String[] { "secret" });
 * license agreements. See the NOTICE file distributed with
        assertCodecExcludes(null, new String[] { "obj", "secret" }, "obj.field", true, new String[] { "secret" });
import org.opensearch.action.search.SearchShardTask;
 * this work for additional information regarding copyright
        assertCodecExcludes(null, new String[] { "secret*" }, "public.field", true, new String[] { "secret*" });
        when(context.getQueryShardContext()).thenReturn(queryShardContext);
     */
     * _source includes/excludes are asserted to be the unmodified root request values.
import org.opensearch.core.tasks.TaskCancelledException;
        }
        when(storedFieldsContext.fieldNames()).thenReturn(List.of());
    /**
        assertArrayEquals(fieldsVisitor.codecExcludes(), excludes);
        assertArrayEquals(fieldsVisitor.excludes(), excludes);
        // ["field3"] | field1,field2 | field1 | source | -> [field2] literal, source include
import org.opensearch.search.fetch.subphase.InnerHitsContext;
        when(context.sourceRequested()).thenReturn(true);
        when(nestedInnerHit.fetchFieldsContext()).thenReturn(null);
/*
        // null | field1,field2 | null | source | -> [] full-source fetch drops all codec excludes
        int from = randomIntBetween(0, 9);
    }
        // null | foo*,x.y | *bar | source | -> [x.y] "foo*" overlaps "*bar" via "foobar"
        when(context.isCancelled()).thenReturn(false, true);
        assertArrayEquals(excludes, fieldsVisitor.excludes());
        // A nested (grandchild) inner hit reads from the same root _source, so a field it requests
        when(context.docIdsToLoadFrom()).thenReturn(0);
        // null | obj.a,obj.b | obj.b | source | -> [obj.a] sibling leaves stay disjoint
        // Requested includes/excludes must not be mutated.
        String[] includes = new String[] { "field1", "field2" };
 *
        when(task.isCancelled()).thenReturn(true);
    public void testSequentialDocs() {
        when(context.innerHits()).thenReturn(innerHitsContext);
 * SPDX-License-Identifier: Apache-2.0
        when(context.shardTarget()).thenReturn(target);
        assertCodecExcludes(null, new String[] { "x.y.z.w", "secret" }, "x.y", true, new String[] { "secret" });
        SearchShardTask task = mock(SearchShardTask.class);
        assertArrayEquals(expectedCodecExcludes, fieldsVisitor.codecExcludes());
        assertCodecExcludes(null, new String[] { "x.*" }, "*", false, Strings.EMPTY_ARRAY);
        // "field1" is requested by the nested inner hit so it is dropped; "field2" is not requested anywhere.
import static org.mockito.ArgumentMatchers.any;
        // Hierarchical (path-prefix) overlap: source excludes/includes apply to whole subtrees.
        // Case 2
        assertCodecExcludes(null, new String[] { "x.y" }, "x.*", true, Strings.EMPTY_ARRAY);
 * Modifications Copyright OpenSearch Contributors. See
        when(context.fetchFieldsContext()).thenReturn(null);
    }
 */
        nestedInnerHitsContext.getInnerHits().put("nested", nestedInnerHit);
        String[] excludes = new String[] { "field1", "field2" };
        when(context.hasFetchSourceContext()).thenReturn(false);
        when(mockSearchContext.fetchSourceContext()).thenReturn(mockFetchSourceContext);
import java.util.ArrayList;
            start += randomIntBetween(2, 10);
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.mapper.MapperService;
