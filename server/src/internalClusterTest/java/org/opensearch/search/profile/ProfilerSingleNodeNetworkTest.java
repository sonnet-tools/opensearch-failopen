 * compatible open source license.
            QueryBuilder q = randomQueryBuilder(stringFields, numericFields, numDocs, 3);  
            logger.info("Query: {}", q);
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                .setProfile(true)  
                );
import java.util.Map;  
        List<String> stringFields = Arrays.asList("field1");
        }  
        for (int i = 0; i < numDocs; i++) {  
                );
        }
import org.apache.lucene.tests.util.English;  
                    is(0L)  
import org.opensearch.action.search.SearchResponse;
     * This test checks to make sure in a single node cluster, the network time  
        int iters = between(20, 100);
                .setTrackTotalHits(true)
 *
                .setSearchType(SearchType.QUERY_THEN_FETCH)
import java.util.List;
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import static org.hamcrest.Matchers.is;  
                assertThat(  
import org.opensearch.index.query.QueryBuilder;
/* SPDX-License-Identifier: Apache-2.0  
        for (int i = 0; i < iters; i++) {
                .setQuery(q)
            SearchResponse resp = client().prepareSearch()  
            assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
import org.opensearch.action.index.IndexRequestBuilder;
    public void testProfilerNetworkTime() throws Exception {  
 */
                    "Profile response inbound network time should be 0 in single node clusters",
 * this file be licensed under the Apache-2.0 license or a  
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
        ensureGreen();
import static org.opensearch.search.profile.query.RandomQueryGenerator.randomQueryBuilder;
    /**
package org.opensearch.search.profile;
public class ProfilerSingleNodeNetworkTest extends OpenSearchSingleNodeTestCase {  
import org.opensearch.action.search.SearchType;  
 * The OpenSearch Contributors require contributions made to
     */
    }
                .get();
     * is 0 as expected in the profiler for inbound an doutbound network time.
import java.util.Arrays;
                assertThat(
                    is(0L)
import static org.hamcrest.Matchers.not;
        int numDocs = randomIntBetween(100, 150);
        createIndex("test");
                    shard.getValue().getNetworkTime().getInboundNetworkTime(),  
            for (Map.Entry<String, ProfileShardResult> shard : resp.getProfileResults().entrySet()) {  
        List<String> numericFields = Arrays.asList("field2");
}
            assertNotNull("Profile response element should not be null", resp.getProfileResults());
                    "Profile response outbound network time should be 0 in single node clusters",
            }
                    shard.getValue().getNetworkTime().getOutboundNetworkTime(),
