    private void ensureHealth() throws IOException {
        assertThat("hits for " + field + ":" + term, hits, equalTo(expectedHits));  
    }  
        for (int i = 0; i < 3; i++) {
                ensureHealth();
 * this file be licensed under the Apache-2.0 license or a
    private void createDerivedSourceIndex() throws IOException {
                refreshIndex();
        Map<String, Object> doc = entityAsMap(client().performRequest(new Request("GET", "/" + INDEX + "/_doc/" + id)));  
 * parent text field still is). The forced store is a Lucene FieldType bit recomputed per node on
public class DerivedSourceUpgradeIT extends AbstractRollingTestCase {
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
 */
import org.opensearch.Version;
 * index.derived_source.enabled, text multi-fields/sub-fields are no longer force-stored, while the  
        switch (CLUSTER_TYPE) {
                indexTitles(0, "quick brown fox");   // ids 0,1,2
 * SPDX-License-Identifier: Apache-2.0
 */  
            "{"
 *
    }
        client().performRequest(new Request("POST", "/" + INDEX + "/_refresh"));
                assertMatchCount("title.sub", "dog", 3);
                // index mixed-phase docs once (MIXED runs once per node upgraded)
    private void assertMatchCount(String field, String term, int expectedHits) throws IOException {
                break;
    private static final String INDEX = "derived_src_mf_rolling";
    }
import org.opensearch.client.Request;
    }
                + "\"mappings\":{\"properties\":{\"title\":{\"type\":\"text\",\"fields\":{\"sub\":{\"type\":\"text\"}}}}}"  
        Map<String, Object> resp = entityAsMap(client().performRequest(search));
    private void indexTitles(int startId, String phrase) throws IOException {  
            client().performRequest(doc);
                // all three generations: GET _source + query
        client().performRequest(health);
                assertMatchCount("title.sub", "fox", 3);  
                assertMatchCount("title.sub", "dog", 3);
import java.io.IOException;
                break;  
                assertSourceTitle(200, "sleepy cat 200");
    private void refreshIndex() throws IOException {  
    public void testDerivedSourceMultiFieldStoreRolling() throws Exception {  
                indexTitles(200, "sleepy cat");      // ids 200,201,202  
                assertMatchCount("title.sub", "cat", 3);
        );
                assertMatchCount("title.sub", "fox", 3);  
                assertMatchCount("title.sub", "fox", 3);  
                assertSourceTitle(100, "lazy dog 100");
/**
        health.addParameter("wait_for_status", "yellow");  
        );
import static org.hamcrest.Matchers.equalTo;
                + "\"settings\":{\"number_of_shards\":2,\"number_of_replicas\":1,\"index.derived_source.enabled\":true},"
 * NOTE: derived_source (index.derived_source.enabled) is available from 3.3.0 onwards (#18565).  
 * compatible open source license.
        client().performRequest(req);  
                + "}"
                // old docs survive; mixed docs (served across old+new nodes) are correct
        assumeTrue(
 * Rolling-upgrade BWC for the derived-source multi-field store fix (TextFieldMapper: under
    private void assertSourceTitle(int id, String expectedTitle) throws IOException {
                    indexTitles(100, "lazy dog");    // ids 100,101,102
                    refreshIndex();
 * (query) stay correct for documents indexed in every phase: OLD, MIXED and UPGRADED.
            default:
    }
            doc.setJsonEntity("{\"title\":\"" + phrase + " " + id + "\"}");
            Request doc = new Request("PUT", "/" + INDEX + "/_doc/" + id);  
import java.util.Map;  
        }  
 *
                refreshIndex();  
        search.setJsonEntity("{\"track_total_hits\":true,\"query\":{\"match\":{\"" + field + "\":\"" + term + "\"}}}");  
package org.opensearch.upgrades;
                throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");  
    }
            case UPGRADED:
            case OLD:  
            case MIXED:  
 * The OpenSearch Contributors require contributions made to  
        int hits = ((Number) XContentMapValues.extractValue("hits.total.value", resp)).intValue();
 * every mapping parse, so during the MIXED phase some shard copies (written by old nodes) store the
                break;
                assertMatchCount("title", "sleepy", 3);  
                assertSourceTitle(100, "lazy dog 100");
                // GET _source + query on old docs (old cluster)
                if (firstMixedRound) {  
            int id = startId + i;
                assertMatchCount("title", "quick", 3);
        }
                assertSourceTitle(0, "quick brown fox 0");  
/*  
            "derived_source (index.derived_source.enabled) is available from 3.3.0 onwards",
}
                assertSourceTitle(0, "quick brown fox 0");
 * sub-field and others (new nodes) do not. This verifies _source reconstruction (GET) and search  
        Request search = new Request("GET", "/" + INDEX + "/_search");
                createDerivedSourceIndex();
        Request req = new Request("PUT", "/" + INDEX);
                }  
import org.opensearch.common.xcontent.support.XContentMapValues;  
                assertSourceTitle(0, "quick brown fox 0");
        health.addParameter("timeout", "90s");
        assertThat(XContentMapValues.extractValue("_source.title", doc), equalTo(expectedTitle));
            UPGRADE_FROM_VERSION.onOrAfter(Version.fromString("3.3.0"))  
                ensureHealth();
        req.setJsonEntity(  
    }
