    public void testMultiOperatorPlanOnlyRedactsFileGroupsSegment() {
    }
public class QueryProfileBuilderRedactionTests extends OpenSearchTestCase {
    public void testPlanWithoutFileGroupsIsUnchanged() {
 *
    public void testRedactsSingleGroupLocalPath() {
        String redacted = QueryProfileBuilder.redactPhysicalPlan(plan);
        // of local paths — the pattern must not special-case "looks like a filesystem path."
            + "  DataSourceExec: file_groups={1 group: [[/secret/path/segment.parquet]]}, "  
        // change; the SortExec line and every other field on the DataSourceExec line survive.
        String redacted = QueryProfileBuilder.redactPhysicalPlan(plan);  
        assertNull(QueryProfileBuilder.redactPhysicalPlan(null));
        assertTrue(redacted.contains("SortPreservingMergeExec: [num0@0 ASC]"));
        assertFalse(redacted.contains("/data/"));
 * this file be licensed under the Apache-2.0 license or a
/**  
        // Everything outside file_groups must be untouched
        String redacted = QueryProfileBuilder.redactPhysicalPlan(plan);  
        assertFalse(redacted.contains("s3://"));
package org.opensearch.analytics.exec.profile;
        String plan = "AggregateExec: mode=Final, gby=[], aggr=[avg(score)]\n" + "  SortExec: TopK(fetch=5), expr=[num0@0 ASC]";
    }  
        String plan = "DataSourceExec: file_groups={1 group: [[s3://my-bucket/indices/uuid/0/segment.parquet]]}, " + "file_type=parquet";
        assertFalse(redacted.contains("my-bucket"));  
        // must pass through byte-for-byte — the regex must not be overly aggressive.
 * Unit tests for {@link QueryProfileBuilder#redactPhysicalPlan}, which strips storage
 * plan text before it's surfaced in the {@code profile=true} API response.  
            + "projection=[__row_id__@9 + row_base@11 as __row_id__, str0, num1], file_type=parquet";
    }
        assertTrue(redacted.contains("projection=[__row_id__@9 + row_base@11 as __row_id__, str0, num1]"));  
/*  
        assertTrue(redacted.contains("predicate=num0 IS NOT NULL"));
    }  
        // Non-scan operators (aggregates, sorts, projections) carry no storage location and  
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(redacted.contains("file_type=parquet"));
        assertEquals(plan, QueryProfileBuilder.redactPhysicalPlan(plan));
        assertTrue(redacted.contains("file_groups={1 group: <redacted>}"));
    public void testRedactsObjectStoreUri() {
    }
        assertTrue(redacted.contains("file_groups={1 group: <redacted>}"));
        assertTrue(redacted.contains("file_type=parquet"));
import org.opensearch.test.OpenSearchTestCase;
        String plan = "DataSourceExec: file_groups={2 groups: "
        assertFalse("path must not survive redaction", redacted.contains("/home/ubuntu"));  
        // Object-store backed indices (S3/GCS/Azure) would leak bucket names/keys here instead  
    }  
        String plan = "DataSourceExec: file_groups={1 group: "
        String redacted = QueryProfileBuilder.redactPhysicalPlan(plan);
            + "projection=[num0, str0], predicate=num0 IS NOT NULL, file_type=parquet";
        assertTrue("plural group count must be preserved", redacted.contains("file_groups={2 groups: <redacted>}"));
 * locations (local filesystem paths or object-store URIs/keys) from DataFusion physical
        String plan = "SortPreservingMergeExec: [num0@0 ASC]\n"
            + "[[/data/a.parquet, /data/b.parquet], [/data/c.parquet]]}, file_type=parquet";  
        assertTrue("group count must be preserved", redacted.contains("file_groups={1 group: <redacted>}"));
        assertTrue(redacted.contains("projection=[num0, str0]"));  
        assertFalse(redacted.contains("/secret/path"));  
        assertFalse("path must not survive redaction", redacted.contains("parquet_file_generation"));
 * compatible open source license.
}  
        // Mirrors a real multi-node plan: only the DataSourceExec's file_groups segment should  
 */  
 * The OpenSearch Contributors require contributions made to  
 */
            + "[[home/ubuntu/data/indices/uuid/0/parquet/_parquet_file_generation_1.parquet]]}, "  
    public void testNullInputReturnsNull() {
    public void testRedactsMultipleGroups() {
