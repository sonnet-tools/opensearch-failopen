            // First page: _shard_doc DESC, grab the SMALLEST key (last hit on the page)
    }
                    assertThat("not strictly decreasing at i=" + i, shardDocKeys.get(i), lessThan(shardDocKeys.get(i - 1)));
        List<String> ids,
        }
            List<String> idsAsc = new ArrayList<>();
        try {
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
            closePit(pitId);
        }
        refresh();
        try {
            SearchSourceBuilder p1 = new SearchSourceBuilder().size(7)
            long prev = ((Number) hits[i - 1].getSortValues()[0]).longValue();
                Object[] after = hits[hits.length - 1].getSortValues();
    }
    // Boundary equality: using the exact last sort tuple as search_after should not duplicate the boundary doc.
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
                .pointInTimeBuilder(pit(pitId));
            SearchHit[] hits = resp.getHits().getHits();
import org.opensearch.test.OpenSearchIntegTestCase;
                assertNotNull("every hit must have sort", sv);
        List<Long> shardDocKeys = new ArrayList<>();
/*
    private void collectIdsAndSortKeys(
            client().prepareIndex(INDEX).setId(Integer.toString(i)).setSource("val", 123).get();
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
            SearchResponse r2 = client().search(new SearchRequest(INDEX).source(p2)).actionGet();
            assertThat(first.getHits().getHits().length, equalTo(5));
            SearchResponse resp0 = client().search(new SearchRequest(INDEX).source(ssb)).actionGet();
            if (hits2.length > 0) {
    private void indexSequentialDocs(int count) {
                Object[] sv = hit.getSortValues();
            SearchSourceBuilder ssb = new SearchSourceBuilder().size(5)
            assertThat(resp.getHits().getTotalHits().value(), equalTo(0L));
            collectIdsAndSortKeys(INDEX, pitId, 17, 0, idsDesc, shardDocKeys, SortBuilders.shardDocSort().order(SortOrder.DESC));
        SearchSourceBuilder ssb = new SearchSourceBuilder().size(pageSize).pointInTimeBuilder(pit(pitId));
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
            // ASC
        }
                    ids.add(hit.getId());
            pitId = openPit(bigIdx, TimeValue.timeValueMinutes(1));
        } finally {
                long k = (Long) sv[shardDocIndex];
            } finally {
        request.setIndices(new String[] { index });
    // - sorts: the full sort list to apply (e.g., only _shard_doc, or primary then _shard_doc)
                allKeys.add(((Number) sv[0]).longValue());
    public void testLargeCorpusInterleaving_ASC() throws Exception {
                    assertThat(keys.get(i), greaterThan(keys.get(i - 1)));
            SearchHit[] hits = resp.getHits().getHits();
            assertThat(shardDocKeys.size(), equalTo(30));
            SearchSourceBuilder ssb = new SearchSourceBuilder().size(5)
            List<Long> keys = new ArrayList<>();
            for (int i = 1; i < shardDocKeys.size(); i++) {
            assertThat(r1.getHits().getHits().length, equalTo(10));
    }
        SearchResponse resp = client().search(new SearchRequest(INDEX).source(ssb)).actionGet();
        refresh();
        final String bigIdx = INDEX + "_big";
        }
            assertThat(idsDesc.size(), equalTo(123));
            SearchResponse resp = client().search(new SearchRequest(INDEX).source(probe)).actionGet();
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
        SearchHit[] hits = resp.getHits().getHits();
            assertThat(new HashSet<>(idsAsc).size(), equalTo(idsAsc.size()));
        ensureGreen(TimeValue.timeValueSeconds(60), bigIdx);
        String pitId = null;
        // force ties on primary
import org.opensearch.search.builder.PointInTimeBuilder;
        return new PointInTimeBuilder(pitId).setKeepAlive(TimeValue.timeValueMinutes(1));
        try {
    }
                    .searchAfter(after);
            SearchResponse r1 = client().search(new SearchRequest(INDEX).source(p1)).actionGet();
        }
            for (var s : sorts) {
            SearchResponse resp = client().search(new SearchRequest(INDEX).source(next)).actionGet();
                ssb.sort(s);
                } else {
            long globalMax = allKeys.get(allKeys.size() - 1);
        indexSequentialDocs(60);
 */
        refresh();
        for (int i = 1; i <= 2000; i++) {
            collectIdsAndSortKeys(
            }
package org.opensearch.search.sort;
            // stop if last page
        }
        refresh();
            pitId = openPit(repIdx, TimeValue.timeValueMinutes(1));
            }
    }
    }
        } finally {
                if (hits.length < 10) break;
                .searchAfter(new Object[] { globalMax + 1 });
            Object[] nextAfter = hits[hits.length - 1].getSortValues();
            .pointInTimeBuilder(pit(pitId));
                closePit(pitId);
                .sort(SortBuilders.shardDocSort().order(SortOrder.DESC))
            // shardDocIndex = 0 because we're only sorting by _shard_doc here
                assertThat(keys.size(), equalTo(41));
        refresh();
        }
import static org.hamcrest.Matchers.instanceOf;
        String pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
                }
            resp = client().search(new SearchRequest(index).source(ssb)).actionGet();
    }
            SearchResponse first = client().search(new SearchRequest(INDEX).source(ssb)).actionGet();
    private static PointInTimeBuilder pit(String pitId) {
            ssb = new SearchSourceBuilder().size(pageSize).pointInTimeBuilder(pit(pitId));
        CreatePitRequest request = new CreatePitRequest(keepAlive, true);
                List<Long> keys = new ArrayList<>();
            closePit(pitId);
    public void testPrimaryFieldSortThenShardDocTieBreaker() throws Exception {
        }
                keys.add(k);
import org.opensearch.action.search.CreatePitRequest;
            assertThat(new HashSet<>(ids).size(), equalTo(ids.size()));
        String pitId,
            closePit(pitId);
            closePit(pitId);
            long cur = ((Number) hits[i].getSortValues()[0]).longValue();
        try {
            collectIdsAndSortKeys(INDEX, pitId, pageSize, 0, null, shardDocKeys, SortBuilders.shardDocSort().order(order));
            SearchResponse resp = client().search(new SearchRequest(INDEX).source(resume)).actionGet();
            // Should cover all 60 docs exactly once
    }
            SearchHit[] hits2 = r2.getHits().getHits();
            }
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
        indexSequentialDocs(5);
            }
    @Before
        } finally {
            assertThat(keys.size(), equalTo(100));
                .searchAfter(midSort);
        try {
        }
        DeletePitRequest del = new DeletePitRequest(Collections.singletonList(pitId));
                if (order == SortOrder.ASC) {
    }
            ssb.sort(s);
                resp = client().search(new SearchRequest(INDEX).source(resume)).actionGet();
            }
        SearchSourceBuilder ssb = new SearchSourceBuilder().size(10)
            closePit(pitId);
            assertThat(shardDocKeys.size(), equalTo(totalDocs));
            for (int i = 1; i < shardDocKeys.size(); i++) {
        }
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
        refresh();
    // Large corpus, odd page sizes, multi-shard interleaving stress.
            if (hits.length < pageSize) break;
            );
        for (int i = 1; i < hits.length; i++) {
    }
            List<Long> shardDocKeys = new ArrayList<>();
                .pointInTimeBuilder(pit(pitId));
                collectIdsAndSortKeys(INDEX, pitId, sz, 0, null, keys, SortBuilders.shardDocSort().order(SortOrder.ASC));
            }
        }
    }
            List<String> idsDesc = new ArrayList<>();
                SortBuilders.shardDocSort().order(SortOrder.ASC)
import java.util.HashSet;
        String pitId = null;
    public void testSearchAfterBeyondEndYieldsNoHits_DESC() throws Exception {
        indexSequentialDocs(totalDocs);
        return pitResponse.getId();
    // Generic paginator: works for 1 or many sort keys.
import org.opensearch.search.builder.SearchSourceBuilder;
            for (int sz : sizes) {
                .setId(Integer.toString(i))
        } finally {
        }
import org.opensearch.action.search.CreatePitAction;
                .get();
                    assertThat("not strictly increasing at i=" + i, shardDocKeys.get(i), greaterThan(shardDocKeys.get(i - 1)));
            SearchHit[] hits = resp.getHits().getHits();
                assertThat(shardDocKeys.get(i), greaterThan(shardDocKeys.get(i - 1)));
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
        } finally {
            // no hits at all
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
            // odd page sizes to stress boundaries
import org.opensearch.common.unit.TimeValue;
            // DESC
 * this file be licensed under the Apache-2.0 license or a
        refresh();
            String pitId = null;
    private String openPit(String index, TimeValue keepAlive) throws Exception {
                .setSource("val", i)
        indexSequentialDocs(5);
    public void testEmptyIndex() throws Exception {
import org.opensearch.action.search.SearchRequest;
            .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
import org.opensearch.search.SearchHit;
    // Tiny page sizes (size=1 and size=2) with strict monotonicity & no dupes.
            ssb.searchAfter(nextAfter);
        ensureGreen(INDEX);
            client().prepareIndex(INDEX)
            assertThat(ids.size(), equalTo(60));
            long minKey = ((Number) first.getHits().getHits()[4].getSortValues()[0]).longValue(); // smallest in DESC page
                .pointInTimeBuilder(pit(pitId))
                .pointInTimeBuilder(pit(pitId));
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
        }
                .pointInTimeBuilder(pit(pitId))
    public void testOrderingAscAndPagination() throws Exception {
            SearchSourceBuilder next = new SearchSourceBuilder().size(3)
                Object[] sv = hit.getSortValues();
        String pitId = null;
                if (ids != null) {
import org.junit.Before;
                List<Long> keys = new ArrayList<>();
                // shardDocIndex=0 since only shard_doc is sorted
                }
            assertThat(idsAsc.size(), equalTo(123));
                10,
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
import static org.hamcrest.Matchers.greaterThan;
    }
    }
import java.util.Collections;
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
            assertThat(hits.length, equalTo(0));
    // Replicas enabled: still strict order and no dupes.
    }
        } finally {
import static org.hamcrest.Matchers.lessThan;
            while (true) {
                resume = new SearchSourceBuilder().size(10)
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
            SearchSourceBuilder p2 = new SearchSourceBuilder().size(7)
        String pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
import org.opensearch.action.search.DeletePitAction;
                new FieldSortBuilder("val").order(SortOrder.ASC),
                    .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
        for (var s : sorts) {
            collectIdsAndSortKeys(INDEX, pitId, 13, 0, idsAsc, shardDocKeys, SortBuilders.shardDocSort().order(SortOrder.ASC));
                // the content doesn't matter for _shard_doc
            assertThat("regression at i=" + i, cur, greaterThan(prev));
        indexSequentialDocs(30);
            // use the FULL last sortValues[] as search_after for correctness
                }
                .sort(SortBuilders.shardDocSort().order(SortOrder.DESC))
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
import org.opensearch.common.action.ActionFuture;
            assertThat(resp.getHits().getHits().length, equalTo(0));
        String pitId = null;
        assertShardDocOrdering(SortOrder.DESC);
    }
        indexSequentialDocs(20);
            List<String> ids = new ArrayList<>();
    public void testTinyPageSizes_ASC() throws Exception {
            }
                INDEX,
                shardDocKeys,
            assertThat(resp.getHits().getHits()[0].getId(), equalTo("42"));
            }
                .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
import org.opensearch.common.settings.Settings;
    // - shardDocIndex: which position in sortValues[]
        try {
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
        for (int i = 1; i <= 30; i++) {
            closePit(pitId);
            }
        for (int i = 1; i <= 100; i++) {
        String pitId = null;
        String index,
        SortBuilder<?>... sorts
            SearchSourceBuilder probe = new SearchSourceBuilder().size(3)
        for (int i = 1; i <= count; i++) {
                assertThat(keys.size(), equalTo(2000));
            SearchResponse r1 = client().search(new SearchRequest(INDEX).source(firstPage)).actionGet();
            // Collect IDs = first page up to 'mid' (inclusive), then resume from mid sort tuple
        String pitId = null;
    // - pageSize: page size
        assertShardDocOrdering(SortOrder.ASC);
    public void testSearchAfterBeyondEndYieldsNoHits() throws Exception {
            // List<String> ids = collectAllIds(repIdx, pitId, 11, SortBuilders.shardDocSort().order(SortOrder.ASC));
            pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
        ensureGreen(repIdx);
        int shardDocIndex,
        List<Long> keys,
        }
        int totalDocs = randomIntBetween(73, 187);
        } finally {
                    ids.add(h.getId());
        client().prepareIndex(INDEX).setId("42").setSource("foo", "bar").get();
            // Probe strictly beyond the end for DESC: use search_after < min (min - 1) => expect 0 hits
            SearchResponse resp = client().search(new SearchRequest(INDEX).source(ssb)).actionGet();
            closePit(pitId);
        } finally {
    public void testSingleDocument() throws Exception {
 * compatible open source license.
            for (SearchHit hit : hits) {
            assertThat(new HashSet<>(ids).size(), equalTo(60));
            closePit(pitId);
        CreatePitResponse pitResponse = execute.get();
            assertThat(hits.length, equalTo(0));
            Object[] midSort = r1.getHits().getHits()[mid].getSortValues();
            closePit(pitId);
        }
        if (pitId == null) return;
                pitId,
                .pointInTimeBuilder(pit(pitId))
    }
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 2, supportsDedicatedMasters = false)
        indexSequentialDocs(41);
        List<Long> allKeys = new ArrayList<>();
import static org.hamcrest.Matchers.equalTo;
    }
        } finally {
import org.opensearch.action.search.DeletePitRequest;
            List<Long> shardDocKeys = new ArrayList<>();
        String pitId = null;
            }
            List<String> ids = new ArrayList<>();
        }
            // collect first page
        while (true) {
import java.util.List;
                null,
    }
import org.opensearch.action.search.CreatePitResponse;
        createIndex(INDEX, Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
                SearchHit[] hits = resp.getHits().getHits();
        int pageSize = randomIntBetween(5, 23);
        SearchResponse resp = client().search(new SearchRequest(index).source(ssb)).actionGet();
        closePit(pitId);
}
            SearchSourceBuilder ssb = new SearchSourceBuilder().size(10)
            int[] sizes = new int[] { 13, 17, 19, 23, 31 };
            client().prepareIndex(repIdx).setId(Integer.toString(i)).setSource("v", i).get();
                collectIdsAndSortKeys(INDEX, pitId, pageSize, 0, null, keys, SortBuilders.shardDocSort().order(SortOrder.ASC));
    // No duplicates across the whole scan (ASC & DESC).
        refresh();
                for (int i = 1; i < keys.size(); i++) {
            assertThat(new HashSet<>(idsDesc).size(), equalTo(idsDesc.size()));
        try {
            SearchHit lastOfPage1 = hits1[hits1.length - 1];
    public void testWithReplicasEnabled_ASC() throws Exception {
        for (int pageSize : new int[] { 1, 2 }) {
                    assertThat(keys.get(i), greaterThan(keys.get(i - 1)));
            SearchSourceBuilder ssb = new SearchSourceBuilder().size(5)
        String pitId = null;
    }
                .pointInTimeBuilder(pit(pitId))
                ids.add(r1.getHits().getHits()[i].getId());
                // should start strictly after the anchor
                .pointInTimeBuilder(pit(pitId));
        String pitId = null;
    private void assertShardDocOrdering(SortOrder order) throws Exception {
        client().execute(DeletePitAction.INSTANCE, del).actionGet();
        String pitId = null;
                for (int i = 1; i < keys.size(); i++) {
        }
            SearchSourceBuilder resume = new SearchSourceBuilder().size(10)
            int mid = 4;
            SearchHit[] hits1 = r1.getHits().getHits();
                }
                    .pointInTimeBuilder(pit(pitId))
        refresh(bigIdx);
    }
            // also IDs unique
        } finally {
                assertNotEquals("no overlap with boundary", lastOfPage1.getId(), hits2[0].getId());
                .pointInTimeBuilder(pit(pitId));
import org.opensearch.action.search.SearchResponse;
                .pointInTimeBuilder(pit(pitId));
import java.util.ArrayList;
    }
public class ShardDocFieldComparatorSourceIT extends OpenSearchIntegTestCase {
        try {
    public void testPageLocalMonotonicity_ASC() throws Exception {
    public void testBoundaryEqualityNoOverlap_ASC() throws Exception {
            SearchSourceBuilder firstPage = new SearchSourceBuilder().size(10)
    public void testResumeFromMiddleOfPage_ASC() throws Exception {
            try {
            collectIdsAndSortKeys(repIdx, pitId, 11, 0, ids, keys, SortBuilders.shardDocSort().order(SortOrder.ASC));
        final String repIdx = INDEX + "_repl";
        createIndex(repIdx, Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 1).build());
        try {
        }
        refresh();
        createIndex(bigIdx, Settings.builder().put("index.number_of_shards", 5).put("index.number_of_replicas", 1).build());
            closePit(pitId);
    public void testOrderingDescAndPagination() throws Exception {
    // Resume from the middle of a page (ASC).
                1,
        try {
    private static final String INDEX = "test_shard_doc";
                pitId = openPit(INDEX, TimeValue.timeValueMinutes(1));
        }
        } finally {
    private void closePit(String pitId) {
                .searchAfter(lastOfPage1.getSortValues());
            client().prepareIndex(bigIdx).setId(Integer.toString(i)).setSource("v", i).get();
                assertTrue("shard_doc should be present", shardDocIndex < sv.length);
    public void setupIndex() {
            // First page to pick a middle anchor
            closePit(pitId);
        indexSequentialDocs(123);
        refresh(repIdx);
 *
            assertThat(resp.getHits().getTotalHits().value(), equalTo(1L));
 * The OpenSearch Contributors require contributions made to
        try {
    ) {
    public void testNoDuplicatesAcrossScan_ASC_DESC() throws Exception {
            for (int i = 0; i <= mid; i++) {
                assertThat("sort key must be a Long", sv[shardDocIndex], instanceOf(Long.class));
                assertThat(keys.get(i), greaterThan(keys.get(i - 1)));
            }
                .searchAfter(new Object[] { minKey - 1 });
            for (SearchHit hit : resp0.getHits().getHits()) {
        int pageSize,
        refresh();
 * SPDX-License-Identifier: Apache-2.0
                for (SearchHit h : hits)
            for (int i = 1; i < keys.size(); i++) {
            SearchResponse resp = client().search(new SearchRequest(INDEX).source(ssb)).actionGet();
