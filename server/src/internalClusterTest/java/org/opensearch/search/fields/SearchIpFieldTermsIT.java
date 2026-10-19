            .endObject()
        MatcherAssert.assertThat(field, hitsFound, equalTo(expectedMatches));
        for (int i = 0; i < fullBytes; i++) {
            .startObject("dv")
            if (ipBytes[i] != cidrIpBytes[i]) {
            .startObject()
        String[] firstThreeOctets = new String[3];
        Consumer<BoolQueryBuilder> addFilter
import java.util.ArrayList;
                boolean isCidr = termQ.contains("/");
        int prefixLength = Integer.parseInt(cidrParts[1]);
            for (String termQ : queryTermsSink) {
            .endObject()
            "addr.dv",
    private XContentBuilder createMapping() throws IOException {
        int cidrs = 0;
                }
}
            .field("type", "ip")
        Set<String> dedupeCidrs = new HashSet<>();
        // Compare full bytes
        for (int i = 0; ips <= 10240 && cidrs < numberOfMasks && i < 1000000; i++) {
import java.util.Set;
import org.apache.lucene.search.IndexSearcher;
            String ip;
        TermsQueryBuilder ipTerms = QueryBuilders.termsQuery(field, new ArrayList<>(toQuery));
        return ips + cidrs + addMatches;
        byte[] ipBytes = ipToBytes(ip);
            boolean mask;
        long expectedMatches,
        }
import java.util.List;
            boolean match = false;
public class SearchIpFieldTermsIT extends OpenSearchSingleNodeTestCase {
            .endObject()
            expectMatches,
                ips++;
    }
            }
    }
            .startObject("dummy_filter")
            final String termToQuery;
        ArrayList<String> toQuery = new ArrayList<>();
        assertTermsHitCount(indexName, "addr.dv", toQuery, expectMatches);
                break; // single mismatch is enough.
import java.util.Objects;
    }
                ip = generateRandomIPv4();
                client().prepareIndex(indexName).setSource(Map.of("addr", ip, "dummy_filter", randomSubsetOf(1, "1", "2", "3")))
import java.io.IOException;
                addMatches++;
    private String generateRandomIPv4() {
import org.opensearch.action.search.SearchResponse;
        );
            } while (mask && !dedupeCidrs.add(getFirstThreeOctets(ip)));
    private void assertTermsHitCount(String indexName, String field, Collection<String> toQuery, long expectedMatches) {
            return (ipBytes[fullBytes] & mask) == (cidrIpBytes[fullBytes] & mask);
            if (mask) {
        String[] cidrParts = cidr.split("/");
        assertTermsHitCount(indexName, field, toQuery, expectedMatches, (bqb) -> {});
import java.util.Collection;
            );
        }
        InetAddress inetAddress = InetAddresses.forString(ip);
            .field("doc_values", false)
import static org.hamcrest.Matchers.equalTo;
        return String.join(
        }
        String indexName,
import java.util.HashSet;
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        client().admin().indices().prepareCreate(indexName).setMapping(xcb).get();
import org.opensearch.common.xcontent.XContentFactory;
        int addMatches = 0;
import org.opensearch.common.network.InetAddresses;
                client().prepareIndex(indexName).setSource(Map.of("addr", ip, "dummy_filter", randomSubsetOf(1, "1", "2", "3")))
        addFilter.accept(boolQueryBuilder);
            .endObject();
import org.opensearch.index.query.TermsQueryBuilder;
        String[] octets = ipAddress.split("\\.");
            int mask = 0xFF << (8 - extraBits);
        if (extraBits > 0) {
    }
    }
        );
                mask = ips > 0 && random().nextBoolean();
            } else {
        // Calculate how many full bytes and how many bits are in the mask
        int expectMatches = createIndex(indexName, IndexSearcher.getMaxClauseCount() + (rarely() ? 0 : atLeast(10)), toQuery);
 * this file be licensed under the Apache-2.0 license or a
    }
            }
/*
        // .filter(QueryBuilders.termsQuery("dummy_filter", "a", "b"))
        long hitsFound = Objects.requireNonNull(result.getHits().getTotalHits()).value();
            String.valueOf(random().nextInt(256)),
                cidrs++;
            .startObject("properties")
        int expectMatches = createIndex(indexName, IndexSearcher.getMaxClauseCount() - 1, toQuery);
            .startObject("idx")
        return inetAddress.getAddress();
        // Take the first three octets
        ensureGreen();
import org.opensearch.index.query.BoolQueryBuilder;
            } else {
    private static boolean isIPInCIDR(String ip, String cidr) {
        int fullBytes = prefixLength / 8;
                termToQuery = ip;
            do {
    private void assertTermsHitCount(
            queryTermsSink.add(termToQuery);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
import org.opensearch.core.xcontent.XContentBuilder;
            bulkRequestBuilder.add(
        ArrayList<String> toQuery = new ArrayList<>();
            String.valueOf(random().nextInt(256)),
            .field("index", false)
            toQuery,
    public void testExceedMaxClauses() throws IOException {
        int extraBits = prefixLength % 8;
 * compatible open source license.
        XContentBuilder xcb = createMapping();
        String indexName = "small";
    private static String getFirstThreeOctets(String ipAddress) {
                    match = true;
            ".",
     * */
            String.valueOf(random().nextInt(256)),
        bulkRequestBuilder.setRefreshPolicy(IMMEDIATE).get();
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    }
import java.net.InetAddress;
        return XContentFactory.jsonBuilder()
        // Compare extra bits (if any)
    // Generate a random IPv4 address
        for (int i = 0; i < atLeast(100); i++) {
package org.opensearch.search.fields;
        assertTermsHitCount(indexName, "addr.idx", toQuery, expectMatches);
            );
            .field("type", "keyword")
            .endObject()
            String.valueOf(random().nextInt(256))
        // Join the first three octets back together with dots
        System.arraycopy(octets, 0, firstThreeOctets, 0, 3);
            indexName,
 * The OpenSearch Contributors require contributions made to
    }
            .field("type", "ip")
            ip = generateRandomIPv4();
    private int createIndex(String indexName, int numberOfMasks, List<String> queryTermsSink) throws IOException {
        BulkRequestBuilder bulkRequestBuilder = client().prepareBulk();
        return String.join(".", firstThreeOctets);
        // Split the IP address by the dot delimiter
        assertTermsHitCount(indexName, "addr.idx", toQuery, expectMatches);
    // Converts an IP string (either IPv4 or IPv6) to a byte array
            (boolBuilder) -> boolBuilder.filter(QueryBuilders.termsQuery("dummy_filter", "1", "2", "3"))
            if (match) {
        String indexName = "larger";
import java.util.Map;
    // Checks if an IP is within a given CIDR (works for both IPv4 and IPv6)
            bulkRequestBuilder.add(
                termToQuery = ip + "/" + prefix;
            .endObject()
        SearchResponse result = client().prepareSearch(indexName).setQuery(boolQueryBuilder.must(ipTerms)
            .field("type", "ip")
import org.opensearch.index.query.QueryBuilders;
        assertTermsHitCount(indexName, "addr.dv", toQuery, expectMatches);
        ).get();
    /**
import java.util.function.Consumer;
                return false;
    ) {
    }
        assertTermsHitCount(indexName, "addr", toQuery, expectMatches);
        int ips = 0;
            .startObject("fields")
 * SPDX-License-Identifier: Apache-2.0
    private static byte[] ipToBytes(String ip) {
        Collection<String> toQuery,
            int prefix;
                if ((isCidr && isIPInCIDR(ip, termQ)) || (!isCidr && termQ.equals(ip))) {
        assertTermsHitCount(
                .filter(QueryBuilders.termsQuery("dummy_filter", "1", "2", "3", "4", "5"))
            .startObject("addr")
                    break;
                .filter(QueryBuilders.termsQuery("dummy_filter", "1", "2", "3", "4"))
        String cidrIp = cidrParts[0];
     * @return number of expected matches
            }
    public void testLessThanMaxClauses() throws IOException {
                prefix = 24 + random().nextInt(8); // CIDR prefix for IPv4
    }
        byte[] cidrIpBytes = ipToBytes(cidrIp);
            .endObject()
import org.opensearch.action.bulk.BulkRequestBuilder;
            }
import org.hamcrest.MatcherAssert;
        String field,
        }
            final String ip;
        return true;
 *
 */
        assertTermsHitCount(indexName, "addr", toQuery, expectMatches);
