        task.cancel("test");
        FetchPhase fetchPhase = new FetchPhase(new ArrayList<>());  
        when(context.innerHits()).thenReturn(innerHitsContext);
 * You may obtain a copy of the License at  
        fieldsVisitor = fetchPhase.createStoredFieldsVisitor(mockSearchContext, null);
        assertArrayEquals(fieldsVisitor.excludes(), excludes);  
        // null | field1,field2 | null | source | -> [] full-source fetch drops all codec excludes
 * GitHub history for details.
     * _source includes/excludes are asserted to be the unmodified root request values.  
        assertArrayEquals(fieldsVisitor.includes(), includes);
        assertCodecExcludes(null, new String[] { "x.y.z.w", "secret" }, "x.y", true, new String[] { "secret" });
        when(innerHit.innerHits()).thenReturn(nestedInnerHitsContext);  
        // null | x.y,secret | x.y.z.w | source | -> [secret] deep descendant of exclude "x.y"  
import org.opensearch.core.index.shard.ShardId;
        assertArrayEquals(fieldsVisitor.excludes(), excludes);
 * ownership. Elasticsearch licenses this file to you under  
        when(context.hasFetchSourceContext()).thenReturn(true);  
            ++start;
import org.opensearch.test.TestSearchContext;  
        String[] excludes = new String[] { "field1", "field2" };
        assertArrayEquals(excludes, fieldsVisitor.excludes());  
        // null | field1,field2 | field2 | fetch | -> [field1] literal, fetch field  
        fieldsVisitor = fetchPhase.createStoredFieldsVisitor(mockSearchContext, Collections.emptyMap());
    }
        assertArrayEquals(new String[] { "field2" }, fieldsVisitor.codecExcludes());  
        assertNull(fieldsVisitor);
        when(mockSearchContext.fetchSourceContext()).thenReturn(mockFetchSourceContext);
        // Requested includes/excludes must not be mutated.
        when(context.storedFieldsContext()).thenReturn(null);  
        assertCodecExcludes(null, new String[] { "obj.sub", "secret" }, "obj", true, new String[] { "secret" });
package org.opensearch.search.fetch;
        FetchSourceContext mockFetchSourceContext = new FetchSourceContext(true, includes, excludes);
        when(context.storedFieldsContext()).thenReturn(null);
        InnerHitsContext.InnerHitSubContext innerHit = mock(InnerHitsContext.InnerHitSubContext.class);  
 *
        FetchPhase fetchPhase = new FetchPhase(new ArrayList<>());  
        SearchShardTarget target = new SearchShardTarget("node", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE);
        when(context.docIdsToLoadSize()).thenReturn(1);
/*  
    public void testFieldsVisitorsInFetchPhase() {
        when(task.isCancelled()).thenReturn(true);  
        when(context.docIdsToLoad()).thenReturn(new int[] { 0 });  
        // includes/excludes are never mutated. Inner-hit fields may be requested via _source  
        assertCodecExcludes(null, new String[] { "x.y" }, "x.*", true, Strings.EMPTY_ARRAY);
        storedToRequestedFields.put("test_field_key", Set.of("test_field_value"));
    }
        Map<String, Set<String>> storedToRequestedFields = new HashMap<>();
 */  
        // ["field3"] | field1,field2 | field1 | source | -> [field2] literal, source include
    }
            String[] innerIncludes = innerHitField != null ? new String[] { innerHitField } : null;
     * Builds a search context whose root source has {@code rootIncludes}/{@code excludes} and a single
        // A nested (grandchild) inner hit reads from the same root _source, so a field it requests
        when(context.fetchSourceContext(any(FetchSourceContext.class))).thenReturn(null);
        when(context.fetchFieldsContext()).thenReturn(null);
import static org.mockito.Mockito.when;
        assertCodecExcludes(null, new String[] { "x.*" }, "x.y", true, Strings.EMPTY_ARRAY);  
    public void testCodecSourceExcludes() {  
        for (int i = from; i < 10; i++) {
        InnerHitsContext.InnerHitSubContext innerHit = mock(InnerHitsContext.InnerHitSubContext.class);
        TestSearchContext context = new TestSearchContext(null, null, null);  
        SearchShardTask task = mock(SearchShardTask.class);
 * this work for additional information regarding copyright
        assertArrayEquals(expectedCodecExcludes, fieldsVisitor.codecExcludes());  
        when(context.shardTarget()).thenReturn(target);
import java.util.List;
     * fetch fields with source fetching disabled. A null {@code innerHitField} with {@code viaSource}
        SearchContext context = mock(SearchContext.class);
        when(context.innerHits()).thenReturn(innerHitsContext);
 *  
    }  
        // Hierarchical (path-prefix) overlap: source excludes/includes apply to whole subtrees.
        when(task.getReasonCancelled()).thenReturn("test reason");
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
 */  
        fieldsVisitor = fetchPhase.createStoredFieldsVisitor(mockSearchContext, storedToRequestedFields);
        assertCodecExcludes(null, new String[] { "x.y.a.z" }, "x.y.b.z", true, new String[] { "x.y.a.z" });
/*
        when(context.fetchFieldsContext()).thenReturn(null);  
        // null | x.y.a.z | x.y.b.z | source | -> [x.y.a.z] diverges at a deeper segment, exclude kept
 * software distributed under the License is distributed on an
import org.opensearch.search.SearchShardTarget;
        // Case 1
        // null | foo*,bar* | bar* | fetch | -> [foo*] identical wildcard patterns
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        SearchShardTask task = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());  
        FetchPhase fetchPhase = new FetchPhase(new ArrayList<>());
            docs[i] = new FetchPhase.DocIdToIndex(start, i);  
import org.opensearch.index.query.QueryShardContext;  
        innerHitsContext.getInnerHits().put("inner", innerHit);  
        boolean viaSource,  
        StoredFieldsContext storedFieldsContext = mock(StoredFieldsContext.class);
        when(context.hasFetchSourceContext()).thenReturn(true);
        }
 * specific language governing permissions and limitations
import org.opensearch.index.mapper.MapperService;
        assertEquals("cancelled task with reason: test reason", ex.getMessage());
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
        // null | x.y.z.w,secret | x.y | source | -> [secret] deep descendant of include "x.y"
        String[] excludes = new String[] { "field7", "field8" };  
        InnerHitsContext innerHitsContext = new InnerHitsContext();  
     * {@code viaSource} is true the field is an inner-hit source include; otherwise it is requested via  
 * license agreements. See the NOTICE file distributed with
        String[] excludes,
        when(nestedInnerHit.innerHits()).thenReturn(null);
        int start = randomIntBetween(0, Short.MAX_VALUE);
        FieldsVisitor fieldsVisitor = fetchPhase.createStoredFieldsVisitor(context, null);  
        when(mockSearchContext.innerHits()).thenReturn(new InnerHitsContext());
            when(innerHit.fetchFieldsContext()).thenReturn(new FetchFieldsContext(List.of(new FieldAndFormat(innerHitField, null))));  
            start += randomIntBetween(2, 10);
 * Modifications Copyright OpenSearch Contributors. See
        when(context.docIdsToLoadFrom()).thenReturn(0);
        SearchContext context = mock(SearchContext.class);
        // if storedFieldsContext is null
import org.opensearch.core.tasks.TaskCancelledException;
import org.opensearch.action.OriginalIndices;
        assertArrayEquals(fieldsVisitor.codecExcludes(), excludes);
 */
        assertCodecExcludes(null, new String[] { "field1", "field2" }, null, true, Strings.EMPTY_ARRAY);  
        // A user source exclude is dropped from the codec excludes when an inner hit requests an
        FetchPhase fetchPhase = new FetchPhase(Collections.emptyList());
 * SPDX-License-Identifier: Apache-2.0
        when(context.storedFieldsContext()).thenReturn(null);  
import org.opensearch.search.internal.SearchContext;  
import static org.mockito.ArgumentMatchers.any;  
import java.util.HashMap;
    }  
        // creates an instance of CustomFieldsVisitor  
        // null | obj,secret | obj.field | source | -> [secret] exclude "obj" is an ancestor of "obj.field"  
        SearchContext mockSearchContext = mock(SearchContext.class);
        assertCodecExcludes(null, new String[] { "obj.a", "obj.b" }, "obj.b", true, new String[] { "obj.a" });
        SearchContext context = mock(SearchContext.class);
        // null | secret* | public.field | source | -> [secret*] no overlap, exclude kept
        String[] includes = new String[] { "field1", "field2" };
        assertCodecExcludes(null, new String[] { "x.y", "secret" }, "x.y.z.w", true, new String[] { "secret" });  
    }
        when(innerHit.fetchSourceContext()).thenReturn(new FetchSourceContext(true, new String[] { "field3" }, null));
        // Requested includes/excludes must not be mutated.  
/*  
import java.util.Set;
 * compatible open source license.
        assertCodecExcludes(null, new String[] { "x.*" }, "x.y.z", true, Strings.EMPTY_ARRAY);
        when(nestedInnerHit.fetchFieldsContext()).thenReturn(null);  
 * the Apache License, Version 2.0 (the "License"); you may
     * inner hit requesting {@code innerHitField}, then asserts the resulting codec excludes. When
        innerHitsContext.getInnerHits().put("inner", innerHit);
        when(queryShardContext.newFetchLookup()).thenReturn(lookup);
        start = docs[from].docId;  
        assertCodecExcludes(new String[] { "field3" }, new String[] { "field1", "field2" }, "field1", true, new String[] { "field2" });  
    public void testSequentialDocs() {
        when(storedFieldsContext.fetchFields()).thenReturn(true);  
        when(context.hasFetchSourceContext()).thenReturn(false);  
        when(context.getQueryShardContext()).thenReturn(queryShardContext);
import java.util.Map;  
        // overlapping field (so it stays available at the codec level), while the returned _source
        // rootIncludes | excludes | innerField | viaSource | -> codecExcludes
        when(context.getTask()).thenReturn(task);  
        assertCodecExcludes(null, new String[] { "obj.*", "secret*" }, "obj.field", true, new String[] { "secret*" });
 * Unless required by applicable law or agreed to in writing,
        InnerHitsContext innerHitsContext = new InnerHitsContext();
        when(context.isCancelled()).thenReturn(false, true);
        }
    private void assertCodecExcludes(
        // Case 2
        FetchPhase fetchPhase = new FetchPhase(new ArrayList<>());
        // Case 3
        // must also be dropped from the codec excludes.
        SearchLookup lookup = new SearchLookup(mock(MapperService.class), (ft, sl) -> null);  
        assertCodecExcludes(null, new String[] { "obj", "secret" }, "obj.field", true, new String[] { "secret" });  
        assertCodecExcludes(null, new String[] { "foo*", "bar*" }, "bar*", false, new String[] { "foo*" });  
        when(storedFieldsContext.fieldNames()).thenReturn(List.of());
     */
 * KIND, either express or implied.  See the License for the
        }
        when(context.hasScriptFields()).thenReturn(false);
 * not use this file except in compliance with the License.
        // "field1" is requested by the nested inner hit so it is dropped; "field2" is not requested anywhere.
        when(context.fetchSourceContext()).thenReturn(FetchSourceContext.FETCH_SOURCE);  
 *
public class FetchPhaseTests extends OpenSearchTestCase {
    /**  
    ) {
import org.opensearch.search.fetch.subphase.InnerHitsContext;
        if (viaSource) {  
        assertCodecExcludes(null, new String[] { "field1", "field2" }, "field2", false, new String[] { "field1" });
        assertCodecExcludes(null, new String[] { "secret*" }, "public.field", true, new String[] { "secret*" });
        when(context.sourceRequested()).thenReturn(true);
}
import org.opensearch.index.fieldvisitor.FieldsVisitor;
 * under the License.  
        for (int i = 0; i < 10; i++) {
import java.util.Collections;  
        int from = randomIntBetween(0, 9);
        assertArrayEquals(excludes, fieldsVisitor.excludes());
 * The OpenSearch Contributors require contributions made to  
        assertArrayEquals(fieldsVisitor.includes(), includes);
import org.opensearch.index.fieldvisitor.CustomFieldsVisitor;  
import org.opensearch.search.fetch.subphase.FieldAndFormat;
    }
        when(mockSearchContext.docIdsToLoad()).thenReturn(new int[] { 1 });
        // if storedFieldsContext is not null  
    public void testExecuteCancelledTaskThrows() {
        when(mockSearchContext.hasFetchSourceContext()).thenReturn(true);  
        //  
        assertArrayEquals(Strings.EMPTY_ARRAY, fieldsVisitor.includes());
        FetchPhase.DocIdToIndex[] docs = new FetchPhase.DocIdToIndex[10];  
import org.opensearch.search.lookup.SearchLookup;
        // if storedFieldsContext is true but fieldNames are empty
        assertArrayEquals(fieldsVisitor.excludes(), excludes);
        // Case 4
        when(nestedInnerHit.fetchSourceContext()).thenReturn(new FetchSourceContext(true, new String[] { "field1" }, null));
        String[] rootIncludes,  
import java.util.ArrayList;
            when(innerHit.fetchSourceContext()).thenReturn(new FetchSourceContext(false));
        FetchSourceContext rootSource = new FetchSourceContext(true, rootIncludes, excludes);
        assertEquals("cancelled task with reason: test", ex.getMessage());
import static org.mockito.Mockito.mock;
        // both excludes and includes support simple-match wildcards.
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
        context.setTask(task);
        String innerHitField,
        assertArrayEquals(fieldsVisitor.codecExcludes(), excludes);  
        when(context.fetchSourceContext()).thenReturn(rootSource);
        assertArrayEquals(rootIncludes != null ? rootIncludes : Strings.EMPTY_ARRAY, fieldsVisitor.includes());
        when(mockSearchContext.storedFieldsContext()).thenReturn(storedFieldsContext);
        nestedInnerHitsContext.getInnerHits().put("nested", nestedInnerHit);
        assertArrayEquals(fieldsVisitor.includes(), includes);
        when(innerHit.fetchFieldsContext()).thenReturn(null);
     * true models a default full-source fetch (fetchSource=true, no explicit includes). The returned
        TaskCancelledException ex = expectThrows(TaskCancelledException.class, () -> fetchPhase.execute(context));
        FetchSourceContext rootSource = new FetchSourceContext(true, null, excludes);  
import org.opensearch.action.search.SearchShardTask;
            docs[i] = new FetchPhase.DocIdToIndex(start, i);  
        when(context.hasScriptFields()).thenReturn(false);
        InnerHitsContext nestedInnerHitsContext = new InnerHitsContext();  
        // null | foo*,x.y | *bar | source | -> [x.y] "foo*" overlaps "*bar" via "foobar"  
        when(context.sourceRequested()).thenReturn(true);  
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(FetchPhase.hasSequentialDocs(docs));
        FieldsVisitor fieldsVisitor = fetchPhase.createStoredFieldsVisitor(mockSearchContext, null);  
        FieldsVisitor fieldsVisitor = fetchPhase.createStoredFieldsVisitor(context, null);
        // null | obj.*,secret* | obj.field | source | -> [secret*] wildcard exclude vs literal
            when(innerHit.fetchSourceContext()).thenReturn(new FetchSourceContext(true, innerIncludes, null));
    public void testCodecSourceExcludesRemovesNestedInnerHitFields() {  
    public void testTaskCancellationDuringFetch() {  
        String[] expectedCodecExcludes
 * Licensed to Elasticsearch under one or more contributor  
        assertTrue(fieldsVisitor instanceof CustomFieldsVisitor);  
        assertCodecExcludes(null, new String[] { "x.*" }, "*", false, Strings.EMPTY_ARRAY);  
        // if storedToRequested Fields is not empty
        when(mockSearchContext.docIdsToLoadSize()).thenReturn(1);  
        TaskCancelledException ex = expectThrows(TaskCancelledException.class, () -> fetchPhase.execute(context));  
        // null | obj.sub,secret | obj | source | -> [secret] include "obj" is an ancestor of exclude "obj.sub"
        when(context.fetchSourceContext()).thenReturn(rootSource);
import org.opensearch.core.common.Strings;  
        // Child inner hit requests nothing overlapping, but its own nested inner hit requests "field1".  
 *     http://www.apache.org/licenses/LICENSE-2.0
        // null | obj.a,obj.b | obj.b | source | -> [obj.a] sibling leaves stay disjoint
        assertArrayEquals(fieldsVisitor.codecExcludes(), excludes);  
        assertTrue(FetchPhase.hasSequentialDocs(docs));  
        when(context.hasScriptFields()).thenReturn(false);
        InnerHitsContext.InnerHitSubContext nestedInnerHit = mock(InnerHitsContext.InnerHitSubContext.class);
 * this file be licensed under the Apache-2.0 license or a
        assertCodecExcludes(null, new String[] { "foo*", "x.y" }, "*bar", true, new String[] { "x.y" });
            when(innerHit.fetchFieldsContext()).thenReturn(null);  
        } else {
        // includes (viaSource=true) or via fetch fields with source disabled (viaSource=false), and
