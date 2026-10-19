        );
            } else {  
            indexName,  
        );
            expectMatches,  
     * @return number of expected matches  
                .filter(QueryBuilders.termsQuery("dummy_filter", "1", "2", "3", "4", "5"))  
        int fullBytes = prefixLength / 8;
        addFilter.accept(boolQueryBuilder);
    // Converts an IP string (either IPv4 or IPv6) to a byte array
            String.valueOf(random().nextInt(256)),
        client().admin().indices().prepareCreate(indexName).setMapping(xcb).get();
                if ((isCidr && isIPInCIDR(ip, termQ)) || (!isCidr && termQ.equals(ip))) {
        int ips = 0;
        return XContentFactory.jsonBuilder()  
    public void testLessThanMaxClauses() throws IOException {  
import org.opensearch.index.query.BoolQueryBuilder;
import java.net.InetAddress;
        for (int i = 0; i < fullBytes; i++) {  
            .startObject()
        }  
        return String.join(".", firstThreeOctets);
        Set<String> dedupeCidrs = new HashSet<>();  
import java.io.IOException;
            if (ipBytes[i] != cidrIpBytes[i]) {
                termToQuery = ip;
        // Split the IP address by the dot delimiter
            int mask = 0xFF << (8 - extraBits);
            .field("type", "ip")
            .endObject();
        String[] cidrParts = cidr.split("/");  
            String ip;
            .endObject()
import org.hamcrest.MatcherAssert;
            if (mask) {
                client().prepareIndex(indexName).setSource(Map.of("addr", ip, "dummy_filter", randomSubsetOf(1, "1", "2", "3")))  
        return String.join(
    private String generateRandomIPv4() {
import java.util.ArrayList;  
            ip = generateRandomIPv4();
        int addMatches = 0;
                termToQuery = ip + "/" + prefix;
                    break;
        ArrayList<String> toQuery = new ArrayList<>();
                addMatches++;
                .filter(QueryBuilders.termsQuery("dummy_filter", "1", "2", "3", "4"))
        }
                ip = generateRandomIPv4();
        String indexName = "small";
            do {
        assertTermsHitCount(indexName, "addr", toQuery, expectMatches);
    private static String getFirstThreeOctets(String ipAddress) {
import org.opensearch.action.bulk.BulkRequestBuilder;
            } else {
            .endObject()  
        return true;  
        String cidrIp = cidrParts[0];
        // Compare full bytes
            final String termToQuery;  
                break; // single mismatch is enough.
    }
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;  
        }
        String field,
                }
        int prefixLength = Integer.parseInt(cidrParts[1]);
            .field("index", false)  
            String.valueOf(random().nextInt(256)),  
            .startObject("dv")
                ips++;  
import java.util.List;  
            if (match) {
            String.valueOf(random().nextInt(256)),
                return false;
            );
            toQuery,
import org.opensearch.common.xcontent.XContentFactory;
            .endObject()
        String[] octets = ipAddress.split("\\.");  
        XContentBuilder xcb = createMapping();  
        assertTermsHitCount(
        return inetAddress.getAddress();
            );
    private static boolean isIPInCIDR(String ip, String cidr) {
 *
import java.util.function.Consumer;
        // .filter(QueryBuilders.termsQuery("dummy_filter", "a", "b"))
            }  
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
    }
    ) {
            .startObject("addr")  
import java.util.Objects;
     * */
        Consumer<BoolQueryBuilder> addFilter
        MatcherAssert.assertThat(field, hitsFound, equalTo(expectedMatches));
        // Take the first three octets
    private XContentBuilder createMapping() throws IOException {
    private static byte[] ipToBytes(String ip) {
            queryTermsSink.add(termToQuery);
    }
        // Join the first three octets back together with dots  
        int extraBits = prefixLength % 8;  
                cidrs++;  
        byte[] cidrIpBytes = ipToBytes(cidrIp);
        String indexName,  
        for (int i = 0; i < atLeast(100); i++) {
        }  
        // Compare extra bits (if any)  
            "addr.dv",
        int cidrs = 0;
        InetAddress inetAddress = InetAddresses.forString(ip);  
import java.util.Collection;
        byte[] ipBytes = ipToBytes(ip);
            .startObject("idx")  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import org.opensearch.index.query.TermsQueryBuilder;  
        long hitsFound = Objects.requireNonNull(result.getHits().getTotalHits()).value();  
            .endObject()
import java.util.HashSet;
            ".",  
import org.opensearch.action.search.SearchResponse;  
import org.opensearch.common.network.InetAddresses;
    }  
import org.opensearch.core.xcontent.XContentBuilder;  
        assertTermsHitCount(indexName, "addr.dv", toQuery, expectMatches);
    }  
        // Calculate how many full bytes and how many bits are in the mask
            bulkRequestBuilder.add(
            .startObject("fields")
                prefix = 24 + random().nextInt(8); // CIDR prefix for IPv4
        int expectMatches = createIndex(indexName, IndexSearcher.getMaxClauseCount() + (rarely() ? 0 : atLeast(10)), toQuery);
            String.valueOf(random().nextInt(256))
 * compatible open source license.
                client().prepareIndex(indexName).setSource(Map.of("addr", ip, "dummy_filter", randomSubsetOf(1, "1", "2", "3")))  
        assertTermsHitCount(indexName, "addr.dv", toQuery, expectMatches);
/*  
        assertTermsHitCount(indexName, field, toQuery, expectedMatches, (bqb) -> {});
        ).get();
            }
        Collection<String> toQuery,
 * SPDX-License-Identifier: Apache-2.0
        BulkRequestBuilder bulkRequestBuilder = client().prepareBulk();
import java.util.Map;
    }
 * The OpenSearch Contributors require contributions made to  
            .startObject("properties")
            boolean mask;
        long expectedMatches,  
            int prefix;  
import java.util.Set;  
                mask = ips > 0 && random().nextBoolean();  
        for (int i = 0; ips <= 10240 && cidrs < numberOfMasks && i < 1000000; i++) {
    }
    /**
        ensureGreen();
        assertTermsHitCount(indexName, "addr.idx", toQuery, expectMatches);  
        TermsQueryBuilder ipTerms = QueryBuilders.termsQuery(field, new ArrayList<>(toQuery));  
        if (extraBits > 0) {
            boolean match = false;
        String[] firstThreeOctets = new String[3];  
import org.opensearch.index.query.QueryBuilders;
            .endObject()  
        SearchResponse result = client().prepareSearch(indexName).setQuery(boolQueryBuilder.must(ipTerms)  
public class SearchIpFieldTermsIT extends OpenSearchSingleNodeTestCase {  
    private int createIndex(String indexName, int numberOfMasks, List<String> queryTermsSink) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    // Checks if an IP is within a given CIDR (works for both IPv4 and IPv6)
        bulkRequestBuilder.setRefreshPolicy(IMMEDIATE).get();
        ArrayList<String> toQuery = new ArrayList<>();
            }  
            .endObject()  
    public void testExceedMaxClauses() throws IOException {
package org.opensearch.search.fields;
    private void assertTermsHitCount(
            bulkRequestBuilder.add(
    }  
}
            final String ip;  
    private void assertTermsHitCount(String indexName, String field, Collection<String> toQuery, long expectedMatches) {
            .field("type", "ip")
        String indexName = "larger";  
            .field("doc_values", false)
            .field("type", "keyword")
                boolean isCidr = termQ.contains("/");
            }
            for (String termQ : queryTermsSink) {  
            return (ipBytes[fullBytes] & mask) == (cidrIpBytes[fullBytes] & mask);  
            (boolBuilder) -> boolBuilder.filter(QueryBuilders.termsQuery("dummy_filter", "1", "2", "3"))
import static org.hamcrest.Matchers.equalTo;
        assertTermsHitCount(indexName, "addr.idx", toQuery, expectMatches);  
        System.arraycopy(octets, 0, firstThreeOctets, 0, 3);
    // Generate a random IPv4 address  
    }
    }
        int expectMatches = createIndex(indexName, IndexSearcher.getMaxClauseCount() - 1, toQuery);  
import org.apache.lucene.search.IndexSearcher;
        return ips + cidrs + addMatches;  
                    match = true;  
            .startObject("dummy_filter")
 */  
            .field("type", "ip")
        assertTermsHitCount(indexName, "addr", toQuery, expectMatches);
            } while (mask && !dedupeCidrs.add(getFirstThreeOctets(ip)));  
