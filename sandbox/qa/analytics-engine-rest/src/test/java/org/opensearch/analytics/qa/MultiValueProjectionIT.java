 * parity. Assertions compare exact LIST cells, so element order and in-document duplicates are  
        assertEquals(List.of("blue", "blue", "red"), strings(byId.get(1)));
        int tagsColumn = column(result, "tags");
        List<String> pairs = new ArrayList<>();  
        // Empty-array (4) contributes no rows; the absent-field document (5) passes through as one  
        }
        Map<String, Object> result = executeSql("SELECT id, tags FROM " + TWO_SHARD_INDEX + " WHERE latency >= 20 ORDER BY id");
    public void testSortHeadThenListProjection() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
    }
        assertEquals(Map.of(1, "us", 2, "eu", 3, "us", 4, "eu", 5, "us", 6, "ap"), regions);
    // ---- SQL parity -------------------------------------------------------------------------  
        assertEquals(sorted(List.of("1=blue", "2=red", "3=blue", "5=null", "6=" + UNICODE_A)), sorted(pairs));  
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | fields tags");  
        assertEquals("us documents", java.util.Set.of(1, 3, 5), byId.keySet());  
    }
            sorted(rendered)
 */  
        assertEquals(result.toString(), List.of("red", "green"), strings(byId.get(2)));  
    }
import java.util.List;
        // Placement-dependent: with some shard splits the fetched LIST for doc 2 comes back empty.
        // Three columns of mixed scalar/LIST types: the exact shape that produced the LIST child-name
    }
        }  
        assertEquals(List.of(UNICODE_A, UNICODE_B), strings(byId.get(6)));
                rendered.add(String.join(",", strings(cell)));
        }
    }  
            Object cell = row.get(tagsColumn);
    public void testWideProjectionWithScalarSiblings() throws Exception {
        assertFixtureTags(tagsById(result));  
        assertAbsentCell(byId.get(5));  
        for (List<Object> row : rows(result)) {  
/**
            Object tag = row.get(tagsColumn);
        }
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | sort latency | head 2 | fields id, tags");
    }
        int tagsColumn = column(result, "tags");
            pairs.add(row.get(idColumn) + "=" + tag);
        // mismatch (`element` vs `item`) across the shard -> coordinator schema boundary.  
        Map<Integer, Object> byId = tagsById(result);  
    public void testListOnlyProjection() throws Exception {
            sorted(List.of("blue,blue,red", "red,green", "blue", UNICODE_A + "," + UNICODE_B)),
        assertEquals(List.of("blue", "blue", "red"), strings(byId.get(1)));
        Map<Integer, Object> byId = tagsById(executePpl("source = " + TWO_SHARD_INDEX + " | fields id, tags"));
    // ---- direct LIST projection -------------------------------------------------------------
            assertFalse("mvexpand must yield scalar cells, got LIST in " + row, tag instanceof List);  
    public void testDuplicatesAndElementOrderArePreserved() throws Exception {  
 * part of the contract.
        }
    public void testNonAsciiElementsRoundTrip() throws Exception {  
    // ---- explicit row expansion -------------------------------------------------------------  
        int regionColumn = column(result, "region");  
            sorted(  
    public void testSortAscendingHeadThenListProjection() throws Exception {  
    public void testMvexpandProducesOneRowPerElement() throws Exception {
            if (cell == null || strings(cell).isEmpty()) {
        assertEquals(java.util.Set.of(1, 2), byId.keySet());
package org.opensearch.analytics.qa;
    }
    public void testOneShardAndTwoShardProjectionsAgree() throws Exception {
        assertEquals(  
 * The OpenSearch Contributors require contributions made to  
        int absent = 0;
        assertEquals("empty-array and absent-field documents", 2, absent);
        String ppl = " | fields id, tags, region | sort id";  
        for (List<Object> row : rows(result)) {
        assertEquals("in-document duplicate must survive with its position", List.of("blue", "blue", "red"), strings(byId.get(1)));
            }  
 */
        Map<Integer, Object> two = tagsById(executePpl("source = " + TWO_SHARD_INDEX + ppl));
        assertEquals(List.of("red", "green"), strings(byId.get(2)));
        assertFixtureTags(two);
    public void testMvexpandWithLimitKeepsLeadingElements() throws Exception {
        assertAbsentCell(byId.get(5));
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | mvexpand tags | fields id, tags");  
        int tagsColumn = column(result, "tags");
        for (List<Object> row : rows(result)) {
        Map<Integer, String> regions = new java.util.HashMap<>();
        Map<Integer, Object> byId = tagsById(result);
    }
                List.of("1=blue", "1=blue", "1=red", "2=red", "2=green", "3=blue", "5=null", "6=" + UNICODE_A, "6=" + UNICODE_B)
        List<String> pairs = new ArrayList<>();
            pairs.add(row.get(idColumn) + "=" + row.get(tagsColumn));
        for (List<Object> row : rows(result)) {  
        }
            assertEquals("id=" + id, strings(one.get(id)), strings(two.get(id)));  
            ),
        assertEquals(List.of(UNICODE_A, UNICODE_B), strings(byId.get(6)));  
    // ---- single-shard parity ----------------------------------------------------------------  
 * End-to-end projection coverage for {@code multi_value: true} keyword fields.
    public void testSingleElementIsStillAList() throws Exception {
}  
        for (Integer id : EXPECTED_TAGS.keySet()) {
 * fragments, Arrow FFI boundary, coordinator reduce) and, where noted, the one-shard index for
/*  
            ids.add(((Number) row.get(idColumn)).intValue());
            pairs.add(row.get(idColumn) + "=" + row.get(tagsColumn));
        assertEquals(List.of(), strings(byId.get(4)));
        int idColumn = column(result, "id");
        );  
    }  
        assertEquals(List.of("tags"), extractColumnNames(result));
        );
public class MultiValueProjectionIT extends MultiValueRestTestCase {  
        Map<String, Object> result = executeSql("SELECT id, tags FROM " + TWO_SHARD_INDEX + " ORDER BY id");  
        assertEquals(java.util.Set.of(2, 3, 4, 5, 6), byId.keySet());
        int idColumn = column(result, "id");  
        Map<Integer, Object> byId = tagsById(executePpl("source = " + TWO_SHARD_INDEX + " | fields id, tags"));  
    public void testOneShardMvexpandAgreesWithTwoShard() throws Exception {
    }
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | sort - latency | head 3 | fields id, tags");  
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | where region = 'us' | fields id, tags");
        assertEquals("top-3 by latency descending", List.of(6, 5, 4), ids);  
        for (List<Object> row : rows(result)) {  
        int idColumn = column(result, "id");
            } else {
            sorted(pairs)  
    }
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(List.of("id", "tags", "region"), extractColumnNames(result));
        assertEquals(List.of("blue"), strings(byId.get(3)));
        List<String> pairs = new ArrayList<>();  
    public void testSqlFilteredListProjection() throws Exception {
    }
        List<String> rendered = new ArrayList<>();
import java.util.ArrayList;  
    }  
            regions.put(((Number) row.get(idColumn)).intValue(), (String) row.get(regionColumn));  
        int idColumn = column(result, "id");
        String ppl = " | mvexpand tags | fields id, tags";
    // ---- LIST projection through other operators --------------------------------------------
    public void testSqlListProjection() throws Exception {
        assertFixtureTags(tagsById(result));
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/23061")
                absent++;  
        // fetched by doc id after the top-N is decided, so it crosses the fetch boundary as a payload.
    }
    public void testScalarFilterThenListProjection() throws Exception {  
 * compatible open source license.
        // sort + head + fields is the query-then-fetch (late materialization) shape: the LIST column is
        int tagsColumn = column(result, "tags");
        assertEquals("stored element order must be preserved", List.of("red", "green"), strings(byId.get(2)));  
        return sorted(pairs);
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | mvexpand tags limit=1 | fields id, tags");
        Map<Integer, Object> byId = tagsById(executePpl("source = " + TWO_SHARD_INDEX + " | fields id, tags"));
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | fields id, tags, region | sort id");
        List<Integer> ids = new ArrayList<>();
        // null row (unnest preserve_nulls, matching Splunk mvexpand).
        assertEquals("single-element documents must not collapse to a scalar", List.of("blue"), strings(byId.get(3)));
    public void testEmptyArrayAndAbsentFieldRendering() throws Exception {
        assertFixtureTags(one);  
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        Map<Integer, Object> byId = tagsById(result);
        Map<Integer, Object> byId = tagsById(result);  
        Map<Integer, Object> one = tagsById(executePpl("source = " + ONE_SHARD_INDEX + ppl));
        assertEquals("explicit empty array must project as an empty LIST", List.of(), strings(byId.get(4)));
        }
    }  
        assertEquals(
 *
        assertEquals(List.of(), strings(byId.get(4)));  
        int idColumn = column(result, "id");
    }
 * <p>Every query runs through the production PPL/SQL frontends against the two-shard index (shard
import java.util.Map;
 *  
        for (List<Object> row : rows(result)) {
        assertAbsentCell(byId.get(5));
        Map<Integer, Object> byId = tagsById(executePpl("source = " + TWO_SHARD_INDEX + " | fields id, tags"));  
    private static List<String> expandedPairs(Map<String, Object> result) {  
        assertEquals(expandedPairs(executePpl("source = " + ONE_SHARD_INDEX + ppl)), expandedPairs(executePpl("source = " + TWO_SHARD_INDEX + ppl)));  
