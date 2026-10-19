    public void testBinTimestampSpan7Days() throws IOException {
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());  
import java.util.Map;
                String label = "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl;
 * The OpenSearch Contributors require contributions made to  
            row(4L, "2004-07-08 00:00:00"),
 */  
 * End-to-end coverage for PPL {@code bin <ts_field> span=Nday} over the shared `calcs`
                }
    @Override  
            row(2L, "2004-07-15 00:00:00"),
            "source=" + DATASET.indexName + " | bin datetime0 span=7day | stats count() as cnt by datetime0 | sort datetime0",
/**  
        // Tie-break on datetime0 so cnt=1 buckets order deterministically.
        // unix epoch land on Mondays: 2004-06-28 + 7k. Bucket counts:
        );
 */
 *
    protected void onBeforeQuery() throws IOException {
        // calcs.datetime0 spans 2004-07-04..08-02 (17 rows). 7-day bins anchored at the  
                    assertEquals(label, ((Number) w).longValue(), ((Number) g).longValue());
        return Arrays.asList(values);
                    assertEquals(label, w, g);
    }  
 * SPDX-License-Identifier: Apache-2.0
        @SuppressWarnings("unchecked")  
    private static boolean dataProvisioned = false;
import java.io.IOException;
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, want.size(), got.size());
                // count() comes back as Integer when the value fits, Long otherwise; compare by magnitude.  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            row(7L, "2004-07-22 00:00:00"),  
    }
                if (w instanceof Number && g instanceof Number) {
        if (dataProvisioned == false) {
            row(2L, "2004-07-29 00:00:00")
/*  
    @SafeVarargs
                } else {  
    }
        assertNotNull("Response missing 'datarows' for query: " + ppl, actualRows);
    private static List<Object> row(Object... values) {
                Object g = got.get(j);
            dataProvisioned = true;
            row(3L, "2004-07-28 00:00:00"),
            }  
        }
        //   2004-07-01 → 2,  2004-07-08 → 4,  2004-07-15 → 2,
        // 1-day bins. 14 distinct days (some collapse — e.g. 2004-07-28 has 3 rows).  
 * the adapter folds the literal base into seconds and emits {@code from_unixtime(...)}  
import java.util.List;  
    }  
public class BinTimestampSpanIT extends AnalyticsRestTestCase {  
        for (int i = 0; i < expected.length; i++) {
        assertRowsEqual(
import java.util.Arrays;
            DatasetProvisioner.provision(client(), DATASET);  
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {
    public void testBinTimestampSpan1Day() throws IOException {
            List<Object> want = expected[i];
 * because DataFusion cannot multiply Int64 × Interval(DayTime) at runtime.
            row(2L, "2004-07-01 00:00:00"),  
package org.opensearch.analytics.qa;
    }  
        assertRowsEqual(
        //   2004-07-22 → 7,  2004-07-29 → 2.  
            row(1L, "2004-07-04 00:00:00")  
    @SuppressWarnings("varargs")  
}  
        Map<String, Object> response = executePpl(ppl);
            for (int j = 0; j < want.size(); j++) {
            List<Object> got = actualRows.get(i);  
            row(2L, "2004-07-14 00:00:00"),
            "source=" + DATASET.indexName + " | bin datetime0 span=1day | stats count() as cnt by datetime0 | sort - cnt, datetime0 | head 3",  
 * dataset. The lowering builds {@code ADDDATE(epoch_char_literal, days_since_epoch_expr)};
 * compatible open source license.
        }
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
                Object w = want.get(j);  
        );
 * this file be licensed under the Apache-2.0 license or a
