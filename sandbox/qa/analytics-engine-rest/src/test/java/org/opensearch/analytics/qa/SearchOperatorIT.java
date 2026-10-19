    }
        @SuppressWarnings("unchecked")
            DatasetProvisioner.provision(client(), DATASET);
import java.util.Map;
        long[] actual = new long[rows.size()];
            "source=" + DATASET.indexName + " | where int0 in (1, 8, 10) | fields int0 | sort int0",
    }  
/*  
    public void testNotInListFoldsToSearchAndReturnsMatchingRows() throws IOException {
    @Override
            3, 4, 4, 4, 7, 11
    }
    /** Project-side Sarg: eval produces SEARCH in a projection expression, not a filter. */
import java.util.Arrays;
        assertInt0Values(
        );
            "source=" + DATASET.indexName + " | where int0 < 4 or int0 > 10 | fields int0 | sort int0",
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
                + " | sort int0",  
    public void testSargFoldInEvalProjectionReturnsMatchingRows() throws IOException {
    private static boolean dataProvisioned = false;
            Arrays.toString(expected),
 *
        );
    public void testRangeUnionFoldsToSearchAndReturnsAllMatchingRows() throws IOException {  
        assertInt0Values(
}
 */  
        if (dataProvisioned == false) {  
import org.opensearch.client.Request;
    }
                + " | eval is_match = int0 in (1, 8, 10)"  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, rows.size());
import java.util.List;  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
            "int0 values mismatch for query: " + ppl + " expected="  
        }
        );
/** End-to-end coverage for PPL queries that fold into {@code SEARCH(field, Sarg[...])}. */  
            "source="
 * this file be licensed under the Apache-2.0 license or a
            dataProvisioned = true;
            "source=" + DATASET.indexName + " | where int0 >= 4 and int0 <= 8 | fields int0 | sort int0",
    public void testBetweenFoldsToSearchAndReturnsRangeRows() throws IOException {
            1, 8, 8, 8, 10
    }  
                + " | fields int0"
                + Arrays.toString(expected) + " actual=" + Arrays.toString(actual),
        );
            "source=" + DATASET.indexName + " | where int0 not in (1, 8, 10) | fields int0 | sort int0",  
            1, 8, 8, 8, 10  
        for (int i = 0; i < rows.size(); i++) {  
    public void testInListFoldsToSearchAndReturnsMatchingRows() throws IOException {  
        );
        assertInt0Values(
            4, 4, 4, 7, 8, 8, 8
    protected void onBeforeQuery() throws IOException {
        assertInt0Values(  
import org.opensearch.client.Response;
            Object cell = rows.get(i).get(0);
    }
        assertInt0Values(  
        );  
            1, 3, 11  
                + DATASET.indexName
package org.opensearch.analytics.qa;
            assertNotNull("null int0 cell at row " + i + " for query: " + ppl, cell);
public class SearchOperatorIT extends AnalyticsRestTestCase {
                + " | where is_match = true"
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
    }
            Arrays.toString(actual)  
        }  
        assertEquals(
    private void assertInt0Values(String ppl, long... expected) throws IOException {
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        Map<String, Object> response = executePpl(ppl);  
            actual[i] = ((Number) cell).longValue();  
