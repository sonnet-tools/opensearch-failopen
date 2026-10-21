            Object tag = row.get(tagsColumn);
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | sort latency | head 2 | fields id, tags");
        assertEquals("in-document duplicate must survive with its position", List.of("blue", "blue", "red"), strings(byId.get(1)));
        List<String> rendered = new ArrayList<>();
        assertEquals("top-3 by latency descending", List.of(6, 5, 4), ids);
    // ---- explicit row expansion -------------------------------------------------------------
        assertAbsentCell(byId.get(5));
            sorted(pairs)
    }
    public void testListOnlyProjection() throws Exception {
    }
        Map<Integer, Object> byId = tagsById(executePpl("source = " + TWO_SHARD_INDEX + " | fields id, tags"));
        int tagsColumn = column(result, "tags");
        assertAbsentCell(byId.get(5));
    public void testSortAscendingHeadThenListProjection() throws Exception {
        int tagsColumn = column(result, "tags");
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | mvexpand tags limit=1 | fields id, tags");
        assertEquals(Map.of(1, "us", 2, "eu", 3, "us", 4, "eu", 5, "us", 6, "ap"), regions);
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | fields tags");
            pairs.add(row.get(idColumn) + "=" + row.get(tagsColumn));
        assertFixtureTags(one);
        int tagsColumn = column(result, "tags");
        Map<String, Object> result = executeSql("SELECT id, tags FROM " + TWO_SHARD_INDEX + " WHERE latency >= 20 ORDER BY id");
            if (cell == null || strings(cell).isEmpty()) {
 * compatible open source license.
            ids.add(((Number) row.get(idColumn)).intValue());
    // ---- direct LIST projection -------------------------------------------------------------
        int idColumn = column(result, "id");
        );
    public void testDuplicatesAndElementOrderArePreserved() throws Exception {
        assertEquals(result.toString(), List.of("red", "green"), strings(byId.get(2)));
        assertEquals("us documents", java.util.Set.of(1, 3, 5), byId.keySet());
            assertEquals("id=" + id, strings(one.get(id)), strings(two.get(id)));
 * this file be licensed under the Apache-2.0 license or a
                rendered.add(String.join(",", strings(cell)));
        assertEquals(List.of("id", "tags", "region"), extractColumnNames(result));
 * fragments, Arrow FFI boundary, coordinator reduce) and, where noted, the one-shard index for
        Map<Integer, String> regions = new java.util.HashMap<>();
        for (List<Object> row : rows(result)) {
        assertEquals(java.util.Set.of(1, 2), byId.keySet());
        // null row (unnest preserve_nulls, matching Splunk mvexpand).
 * parity. Assertions compare exact LIST cells, so element order and in-document duplicates are
        assertEquals(List.of("blue", "blue", "red"), strings(byId.get(1)));
        Map<Integer, Object> byId = tagsById(executePpl("source = " + TWO_SHARD_INDEX + " | fields id, tags"));
}
 * SPDX-License-Identifier: Apache-2.0
    public void testOneShardAndTwoShardProjectionsAgree() throws Exception {
    }
    }
    // ---- single-shard parity ----------------------------------------------------------------
    }
    }
            regions.put(((Number) row.get(idColumn)).intValue(), (String) row.get(regionColumn));
        }
        }
        return sorted(pairs);
        assertAbsentCell(byId.get(5));
    }
    public void testOneShardMvexpandAgreesWithTwoShard() throws Exception {
            sorted(rendered)
    }
            pairs.add(row.get(idColumn) + "=" + tag);
        assertFixtureTags(tagsById(result));
        assertFixtureTags(tagsById(result));
        // Placement-dependent: with some shard splits the fetched LIST for doc 2 comes back empty.
        assertEquals(List.of("tags"), extractColumnNames(result));
                List.of("1=blue", "1=blue", "1=red", "2=red", "2=green", "3=blue", "5=null", "6=" + UNICODE_A, "6=" + UNICODE_B)
    public void testScalarFilterThenListProjection() throws Exception {
        assertFixtureTags(two);
        List<String> pairs = new ArrayList<>();
            sorted(List.of("blue,blue,red", "red,green", "blue", UNICODE_A + "," + UNICODE_B)),
        // Empty-array (4) contributes no rows; the absent-field document (5) passes through as one
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        int absent = 0;
    public void testWideProjectionWithScalarSiblings() throws Exception {
        Map<Integer, Object> one = tagsById(executePpl("source = " + ONE_SHARD_INDEX + ppl));
        for (Integer id : EXPECTED_TAGS.keySet()) {
    }
        Map<Integer, Object> byId = tagsById(executePpl("source = " + TWO_SHARD_INDEX + " | fields id, tags"));
        // sort + head + fields is the query-then-fetch (late materialization) shape: the LIST column is
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | where region = 'us' | fields id, tags");
        int tagsColumn = column(result, "tags");
        Map<Integer, Object> byId = tagsById(result);
        String ppl = " | mvexpand tags | fields id, tags";
        int idColumn = column(result, "id");
    public void testMvexpandWithLimitKeepsLeadingElements() throws Exception {
        assertEquals(List.of("red", "green"), strings(byId.get(2)));
    // ---- SQL parity -------------------------------------------------------------------------
        assertEquals(List.of(), strings(byId.get(4)));
        assertEquals("empty-array and absent-field documents", 2, absent);
        for (List<Object> row : rows(result)) {
            }
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | mvexpand tags | fields id, tags");
 *
 */
        assertEquals(List.of(UNICODE_A, UNICODE_B), strings(byId.get(6)));
            assertFalse("mvexpand must yield scalar cells, got LIST in " + row, tag instanceof List);
        );
 * part of the contract.
import java.util.List;
        int regionColumn = column(result, "region");
 */
        assertEquals(java.util.Set.of(2, 3, 4, 5, 6), byId.keySet());
        assertEquals(List.of(UNICODE_A, UNICODE_B), strings(byId.get(6)));
    }
        for (List<Object> row : rows(result)) {
    }
        assertEquals("stored element order must be preserved", List.of("red", "green"), strings(byId.get(2)));
import java.util.Map;
    public void testEmptyArrayAndAbsentFieldRendering() throws Exception {
    public void testSortHeadThenListProjection() throws Exception {
import java.util.ArrayList;
        for (List<Object> row : rows(result)) {
    }
 * The OpenSearch Contributors require contributions made to
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | sort - latency | head 3 | fields id, tags");
        int idColumn = column(result, "id");
                absent++;
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | fields id, tags, region | sort id");
 *
        assertEquals("single-element documents must not collapse to a scalar", List.of("blue"), strings(byId.get(3)));
            pairs.add(row.get(idColumn) + "=" + row.get(tagsColumn));
 * <p>Every query runs through the production PPL/SQL frontends against the two-shard index (shard
    public void testSingleElementIsStillAList() throws Exception {
        Map<Integer, Object> two = tagsById(executePpl("source = " + TWO_SHARD_INDEX + ppl));
    private static List<String> expandedPairs(Map<String, Object> result) {
        assertEquals(List.of(), strings(byId.get(4)));
        for (List<Object> row : rows(result)) {
    public void testNonAsciiElementsRoundTrip() throws Exception {
        Map<Integer, Object> byId = tagsById(result);
        List<String> pairs = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        assertEquals(
    public void testSqlListProjection() throws Exception {
        }
 * End-to-end projection coverage for {@code multi_value: true} keyword fields.
        // fetched by doc id after the top-N is decided, so it crosses the fetch boundary as a payload.
        assertEquals(List.of("blue"), strings(byId.get(3)));
public class MultiValueProjectionIT extends MultiValueRestTestCase {
    }
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/23061")
        Map<Integer, Object> byId = tagsById(executePpl("source = " + TWO_SHARD_INDEX + " | fields id, tags"));
        assertEquals(expandedPairs(executePpl("source = " + ONE_SHARD_INDEX + ppl)), expandedPairs(executePpl("source = " + TWO_SHARD_INDEX + ppl)));
            ),
        int idColumn = column(result, "id");
        Map<String, Object> result = executeSql("SELECT id, tags FROM " + TWO_SHARD_INDEX + " ORDER BY id");
        String ppl = " | fields id, tags, region | sort id";
        assertEquals("explicit empty array must project as an empty LIST", List.of(), strings(byId.get(4)));
    // ---- LIST projection through other operators --------------------------------------------
            sorted(
        int idColumn = column(result, "id");
        assertEquals(sorted(List.of("1=blue", "2=red", "3=blue", "5=null", "6=" + UNICODE_A)), sorted(pairs));
    public void testSqlFilteredListProjection() throws Exception {
        }
package org.opensearch.analytics.qa;
        }
        for (List<Object> row : rows(result)) {
/**
        Map<Integer, Object> byId = tagsById(result);
        assertEquals(List.of("blue", "blue", "red"), strings(byId.get(1)));
        }
    public void testMvexpandProducesOneRowPerElement() throws Exception {
        Map<Integer, Object> byId = tagsById(result);
        assertEquals(
        List<String> pairs = new ArrayList<>();
            } else {
/*
        // Three columns of mixed scalar/LIST types: the exact shape that produced the LIST child-name
        // mismatch (`element` vs `item`) across the shard -> coordinator schema boundary.
    }
        }
            Object cell = row.get(tagsColumn);
    }
    }
