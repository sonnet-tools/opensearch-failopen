        } finally {
            assertThat(hits.length, equalTo(0));  
        }
        }
public class ShardDocFieldComparatorSourceIT extends OpenSearchIntegTestCase {
        } finally {
        refresh();
        } finally {  
package org.opensearch.search.sort;
            client().prepareIndex(bigIdx).setId(Integer.toString(i)).setSource("v", i).get();
        String pitId = null;  
        String pitId,
        DeletePitRequest del = new DeletePitRequest(Collections.singletonList(pitId));
        } finally {
        CreatePitRequest request = new CreatePitRequest(keepAlive, true);
        ensureGreen(TimeValue.timeValueSeconds(60), bigIdx);
        try {
            }
import static org.hamcrest.Matchers.instanceOf;  
    }
        client().prepareIndex(INDEX).setId("42").setSource("foo", "bar").get();
    }
            }  
            closePit(pitId);
    public void testSearchAfterBeyondEndYieldsNoHits() throws Exception {
            String pitId = null;
import org.opensearch.common.settings.Settings;  
    }
        refresh(bigIdx);  
                .pointInTimeBuilder(pit(pitId))
        try {
        try {  
            long prev = ((Number) hits[i - 1].getSortValues()[0]).longValue();
    public void setupIndex() {  
            assertThat(resp.getHits().getTotalHits().value(), equalTo(0L));
            } finally {  
                closePit(pitId);
    private static final String INDEX = "test_shard_doc";  
        int totalDocs = randomIntBetween(73, 187);  
        }  
                assertThat(keys.size(), equalTo(2000));
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
        SearchResponse resp = client().search(new SearchRequest(INDEX).source(ssb)).actionGet();
    public void testEmptyIndex() throws Exception {
                for (int i = 1; i < keys.size(); i++) {  
        } finally {  
                SortBuilders.shardDocSort().order(SortOrder.ASC)
            List<Long> shardDocKeys = new ArrayList<>();
            for (int sz : sizes) {
        for (var s : sorts) {  
        try {  
            // shardDocIndex = 0 because we're only sorting by _shard_doc here
                    assertThat(keys.get(i), greaterThan(keys.get(i - 1)));
 *
            // no hits at all
 * this file be licensed under the Apache-2.0 license or a
        client().execute(DeletePitAction.INSTANCE, del).actionGet();  
                    assertThat(keys.get(i), greaterThan(keys.get(i - 1)));
            SearchSourceBuilder firstPage = new SearchSourceBuilder().size(10)  
                // the content doesn't matter for _shard_doc
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))  
        return pitResponse.getId();  
                    ids.add(hit.getId());  
            assertThat(keys.size(), equalTo(100));
        String pitId = null;
            // odd page sizes to stress boundaries
            assertThat(new HashSet<>(idsAsc).size(), equalTo(idsAsc.size()));
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))  
    private void closePit(String pitId) {  
            // stop if last page  
            }
        SearchHit[] hits = resp.getHits().getHits();  
    }
            // First page: _shard_doc DESC, grab the SMALLEST key (last hit on the page)
        indexSequentialDocs(41);
            List<String> ids = new ArrayList<>();
import java.util.HashSet;
            assertThat(first.getHits().getHits().length, equalTo(5));
            try {  
            SearchSourceBuilder ssb = new SearchSourceBuilder().size(5)  
            SearchHit[] hits = resp.getHits().getHits();
        }
                .pointInTimeBuilder(pit(pitId));
import org.opensearch.common.unit.TimeValue;
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
            .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));  
            SearchResponse first = client().search(new SearchRequest(INDEX).source(ssb)).actionGet();
        } finally {  
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));  
                .setId(Integer.toString(i))  
import static org.hamcrest.Matchers.equalTo;
                List<Long> keys = new ArrayList<>();
            closePit(pitId);
            }
    public void testLargeCorpusInterleaving_ASC() throws Exception {
                }
            assertThat("regression at i=" + i, cur, greaterThan(prev));
        while (true) {
    public void testOrderingAscAndPagination() throws Exception {
            SearchSourceBuilder resume = new SearchSourceBuilder().size(10)  
                .pointInTimeBuilder(pit(pitId));
        }
            }
        for (int i = 1; i <= 30; i++) {  
                resume = new SearchSourceBuilder().size(10)
import org.opensearch.action.search.CreatePitResponse;  
    public void testBoundaryEqualityNoOverlap_ASC() throws Exception {  
            assertThat(new HashSet<>(ids).size(), equalTo(60));
            SearchResponse resp = client().search(new SearchRequest(INDEX).source(next)).actionGet();
        } finally {  
        List<Long> allKeys = new ArrayList<>();
    ) {
            SearchSourceBuilder ssb = new SearchSourceBuilder().size(5)
            SearchResponse resp = client().search(new SearchRequest(INDEX).source(probe)).actionGet();
                    ids.add(h.getId());
        refresh();
            SearchSourceBuilder next = new SearchSourceBuilder().size(3)
                Object[] sv = hit.getSortValues();
            if (hits.length < pageSize) break;
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
        refresh();
    // Boundary equality: using the exact last sort tuple as search_after should not duplicate the boundary doc.
                    assertThat("not strictly increasing at i=" + i, shardDocKeys.get(i), greaterThan(shardDocKeys.get(i - 1)));  
            assertThat(idsAsc.size(), equalTo(123));
                shardDocKeys,  
        SearchResponse resp = client().search(new SearchRequest(index).source(ssb)).actionGet();  
    }  
            assertThat(resp.getHits().getHits()[0].getId(), equalTo("42"));
    }
                .pointInTimeBuilder(pit(pitId))
                    .searchAfter(after);
import java.util.Collections;  
            SearchSourceBuilder ssb = new SearchSourceBuilder().size(10)
        indexSequentialDocs(5);  
import org.junit.Before;  
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
        }
        String pitId = null;
        String pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));  
        assertShardDocOrdering(SortOrder.DESC);
        String pitId = null;
    private void indexSequentialDocs(int count) {  
            if (hits2.length > 0) {
/*  
            collectIdsAndSortKeys(repIdx, pitId, 11, 0, ids, keys, SortBuilders.shardDocSort().order(SortOrder.ASC));
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
            SearchSourceBuilder ssb = new SearchSourceBuilder().size(5)
                .pointInTimeBuilder(pit(pitId));
        String pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));  
        }
 * compatible open source license.
            assertThat(ids.size(), equalTo(60));
    }
import static org.hamcrest.Matchers.greaterThan;
                .pointInTimeBuilder(pit(pitId));  
                assertThat(keys.size(), equalTo(41));
                null,
        for (int i = 1; i < hits.length; i++) {
        String pitId = null;
            SearchResponse resp = client().search(new SearchRequest(INDEX).source(ssb)).actionGet();
            // First page to pick a middle anchor
            for (int i = 1; i < shardDocKeys.size(); i++) {  
                assertNotEquals("no overlap with boundary", lastOfPage1.getId(), hits2[0].getId());
        if (pitId == null) return;
            }
                .setSource("val", i)
import org.opensearch.action.search.SearchResponse;
        int pageSize = randomIntBetween(5, 23);
        refresh();  
            assertThat(shardDocKeys.size(), equalTo(totalDocs));
            assertThat(shardDocKeys.size(), equalTo(30));
import org.opensearch.search.builder.SearchSourceBuilder;
    public void testPrimaryFieldSortThenShardDocTieBreaker() throws Exception {
        refresh();  
            pitId = openPit(bigIdx, TimeValue.timeValueMinutes(1));
            SearchResponse r2 = client().search(new SearchRequest(INDEX).source(p2)).actionGet();
            client().prepareIndex(repIdx).setId(Integer.toString(i)).setSource("v", i).get();
        } finally {  
                }
    }
                .get();  
            }
        // force ties on primary
            SearchHit[] hits1 = r1.getHits().getHits();  
        } finally {
            }  
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))  
            for (SearchHit hit : resp0.getHits().getHits()) {
                1,
            collectIdsAndSortKeys(INDEX, pitId, 13, 0, idsAsc, shardDocKeys, SortBuilders.shardDocSort().order(SortOrder.ASC));  
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
                new FieldSortBuilder("val").order(SortOrder.ASC),
            int mid = 4;  
            closePit(pitId);
        refresh();  
                long k = (Long) sv[shardDocIndex];  
        String pitId = null;
                .searchAfter(new Object[] { minKey - 1 });  
            int[] sizes = new int[] { 13, 17, 19, 23, 31 };  
            // DESC
            long cur = ((Number) hits[i].getSortValues()[0]).longValue();  
    private String openPit(String index, TimeValue keepAlive) throws Exception {
        for (int pageSize : new int[] { 1, 2 }) {
                .pointInTimeBuilder(pit(pitId))
    // - pageSize: page size
            closePit(pitId);  
        }
    }  
            // ASC
    }
    }  
                .sort(SortBuilders.shardDocSort().order(SortOrder.DESC))
    public void testPageLocalMonotonicity_ASC() throws Exception {
            SearchResponse resp = client().search(new SearchRequest(INDEX).source(resume)).actionGet();
    }  
            SearchResponse resp = client().search(new SearchRequest(INDEX).source(ssb)).actionGet();
    private void collectIdsAndSortKeys(
import java.util.List;
        int shardDocIndex,  
            pitId = openPit(repIdx, TimeValue.timeValueMinutes(1));
    private static PointInTimeBuilder pit(String pitId) {  
        refresh();
    // - shardDocIndex: which position in sortValues[]  
 * The OpenSearch Contributors require contributions made to  
                assertThat("sort key must be a Long", sv[shardDocIndex], instanceOf(Long.class));
    public void testNoDuplicatesAcrossScan_ASC_DESC() throws Exception {
                .pointInTimeBuilder(pit(pitId));
            assertThat(resp.getHits().getHits().length, equalTo(0));  
            closePit(pitId);  
        int pageSize,
    // Large corpus, odd page sizes, multi-shard interleaving stress.  
        createIndex(bigIdx, Settings.builder().put("index.number_of_shards", 5).put("index.number_of_replicas", 1).build());  
        String pitId = null;
        request.setIndices(new String[] { index });  
            SearchResponse r1 = client().search(new SearchRequest(INDEX).source(p1)).actionGet();
                assertNotNull("every hit must have sort", sv);  
    public void testResumeFromMiddleOfPage_ASC() throws Exception {  
        } finally {  
            SearchHit[] hits2 = r2.getHits().getHits();
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
        try {
                assertThat(shardDocKeys.get(i), greaterThan(shardDocKeys.get(i - 1)));
    // Generic paginator: works for 1 or many sort keys.
            closePit(pitId);
                }  
            List<Long> shardDocKeys = new ArrayList<>();  
            // Should cover all 60 docs exactly once  
    }
            client().prepareIndex(INDEX)
            for (int i = 0; i <= mid; i++) {
        }
    // Replicas enabled: still strict order and no dupes.  
        indexSequentialDocs(30);
                if (order == SortOrder.ASC) {
            }
            ssb.searchAfter(nextAfter);  
        }
            SearchSourceBuilder p1 = new SearchSourceBuilder().size(7)
        try {  
            ssb.sort(s);
    }
            // also IDs unique  
    public void testWithReplicasEnabled_ASC() throws Exception {
import org.opensearch.action.search.DeletePitRequest;
            Object[] nextAfter = hits[hits.length - 1].getSortValues();
import static org.hamcrest.Matchers.lessThan;
            SearchHit[] hits = resp.getHits().getHits();
                .searchAfter(lastOfPage1.getSortValues());  
        try {  
            for (var s : sorts) {  
    }
            SearchResponse r1 = client().search(new SearchRequest(INDEX).source(firstPage)).actionGet();  
        }  
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));  
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))  
import org.opensearch.action.search.CreatePitRequest;
            assertThat(idsDesc.size(), equalTo(123));
    // - sorts: the full sort list to apply (e.g., only _shard_doc, or primary then _shard_doc)
                    assertThat("not strictly decreasing at i=" + i, shardDocKeys.get(i), lessThan(shardDocKeys.get(i - 1)));
                .pointInTimeBuilder(pit(pitId))
            collectIdsAndSortKeys(  
        refresh();  
import org.opensearch.test.OpenSearchIntegTestCase;
        SortBuilder<?>... sorts  
            // Collect IDs = first page up to 'mid' (inclusive), then resume from mid sort tuple  
    }  
import org.opensearch.action.search.CreatePitAction;
        final String bigIdx = INDEX + "_big";
        indexSequentialDocs(123);
            resp = client().search(new SearchRequest(index).source(ssb)).actionGet();
        assertShardDocOrdering(SortOrder.ASC);  
            SearchHit[] hits = resp.getHits().getHits();  
                ssb.sort(s);
            collectIdsAndSortKeys(INDEX, pitId, 17, 0, idsDesc, shardDocKeys, SortBuilders.shardDocSort().order(SortOrder.DESC));  
            while (true) {  
                }
        List<String> ids,
                    .pointInTimeBuilder(pit(pitId))
        for (int i = 1; i <= count; i++) {
                Object[] sv = hit.getSortValues();
            long globalMax = allKeys.get(allKeys.size() - 1);  
    private void assertShardDocOrdering(SortOrder order) throws Exception {
        List<Long> shardDocKeys = new ArrayList<>();
            for (int i = 1; i < keys.size(); i++) {  
        for (int i = 1; i <= 2000; i++) {  
            List<Long> keys = new ArrayList<>();
        try {
            assertThat(new HashSet<>(idsDesc).size(), equalTo(idsDesc.size()));
                .searchAfter(midSort);  
            assertThat(resp.getHits().getTotalHits().value(), equalTo(1L));
                resp = client().search(new SearchRequest(INDEX).source(resume)).actionGet();  
        indexSequentialDocs(60);
        try {
            assertThat(r1.getHits().getHits().length, equalTo(10));
    public void testSearchAfterBeyondEndYieldsNoHits_DESC() throws Exception {
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 2, supportsDedicatedMasters = false)  
                    .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))  
            // use the FULL last sortValues[] as search_after for correctness  
                keys.add(k);
                // should start strictly after the anchor
            SearchSourceBuilder p2 = new SearchSourceBuilder().size(7)  
 * SPDX-License-Identifier: Apache-2.0
        String pitId = null;
                ids.add(r1.getHits().getHits()[i].getId());  
        SearchSourceBuilder ssb = new SearchSourceBuilder().size(10)
        try {
            collectIdsAndSortKeys(INDEX, pitId, pageSize, 0, null, shardDocKeys, SortBuilders.shardDocSort().order(order));  
                // shardDocIndex=0 since only shard_doc is sorted  
            Object[] midSort = r1.getHits().getHits()[mid].getSortValues();
                collectIdsAndSortKeys(INDEX, pitId, sz, 0, null, keys, SortBuilders.shardDocSort().order(SortOrder.ASC));
        refresh();
                List<Long> keys = new ArrayList<>();
    public void testTinyPageSizes_ASC() throws Exception {  
        }
                if (ids != null) {
 */  
    // Resume from the middle of a page (ASC).
                for (int i = 1; i < keys.size(); i++) {  
        createIndex(INDEX, Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
                pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
    // Tiny page sizes (size=1 and size=2) with strict monotonicity & no dupes.
            }
        String index,  
                Object[] after = hits[hits.length - 1].getSortValues();  
        return new PointInTimeBuilder(pitId).setKeepAlive(TimeValue.timeValueMinutes(1));
        }  
            assertThat(hits.length, equalTo(0));  
                pitId,
                SearchHit[] hits = resp.getHits().getHits();
            ssb = new SearchSourceBuilder().size(pageSize).pointInTimeBuilder(pit(pitId));
    @Before
        List<Long> keys,
import org.opensearch.search.SearchHit;
                allKeys.add(((Number) sv[0]).longValue());  
    public void testSingleDocument() throws Exception {
        }  
            );  
        indexSequentialDocs(5);
            List<String> idsDesc = new ArrayList<>();
    public void testOrderingDescAndPagination() throws Exception {  
        } finally {
        ensureGreen(INDEX);
                10,  
    }
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
            .pointInTimeBuilder(pit(pitId));  
                if (hits.length < 10) break;
            // collect first page  
            long minKey = ((Number) first.getHits().getHits()[4].getSortValues()[0]).longValue(); // smallest in DESC page
        }
        }
        refresh(repIdx);  
            SearchSourceBuilder probe = new SearchSourceBuilder().size(3)  
        CreatePitResponse pitResponse = execute.get();
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
            }
    // No duplicates across the whole scan (ASC & DESC).  
        }
            SearchResponse resp0 = client().search(new SearchRequest(INDEX).source(ssb)).actionGet();
                .searchAfter(new Object[] { globalMax + 1 });
            List<String> ids = new ArrayList<>();  
            closePit(pitId);
                assertThat(keys.get(i), greaterThan(keys.get(i - 1)));
        createIndex(repIdx, Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 1).build());  
        ensureGreen(repIdx);
import java.util.ArrayList;
import org.opensearch.action.search.DeletePitAction;
            SearchHit lastOfPage1 = hits1[hits1.length - 1];
        try {  
import org.opensearch.search.builder.PointInTimeBuilder;  
        String pitId = null;
                for (SearchHit h : hits)  
            // List<String> ids = collectAllIds(repIdx, pitId, 11, SortBuilders.shardDocSort().order(SortOrder.ASC));
            closePit(pitId);
            closePit(pitId);  
        closePit(pitId);  
import org.opensearch.common.action.ActionFuture;
            // Probe strictly beyond the end for DESC: use search_after < min (min - 1) => expect 0 hits
            List<String> idsAsc = new ArrayList<>();
        }
        indexSequentialDocs(20);  
    }  
            closePit(pitId);
            for (int i = 1; i < shardDocKeys.size(); i++) {
                collectIdsAndSortKeys(INDEX, pitId, pageSize, 0, null, keys, SortBuilders.shardDocSort().order(SortOrder.ASC));  
        }
            client().prepareIndex(INDEX).setId(Integer.toString(i)).setSource("val", 123).get();
            assertThat(new HashSet<>(ids).size(), equalTo(ids.size()));
            for (SearchHit hit : hits) {
                assertTrue("shard_doc should be present", shardDocIndex < sv.length);
                .pointInTimeBuilder(pit(pitId));
    }
        SearchSourceBuilder ssb = new SearchSourceBuilder().size(pageSize).pointInTimeBuilder(pit(pitId));
import org.opensearch.action.search.SearchRequest;  
    }
}
                } else {
        for (int i = 1; i <= 100; i++) {  
        refresh();
        String pitId = null;
        final String repIdx = INDEX + "_repl";
    }  
            closePit(pitId);
                INDEX,
                .sort(SortBuilders.shardDocSort().order(SortOrder.DESC))
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));  
        indexSequentialDocs(totalDocs);
