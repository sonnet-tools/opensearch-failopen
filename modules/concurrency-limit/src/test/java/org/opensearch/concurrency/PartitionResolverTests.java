import org.opensearch.action.ActionRequest;
    }
    }  
    private static SearchRequest aggSearch() {
        PartitionResolver r = new PartitionResolver.BySearchTypePartitionResolver(Settings.EMPTY);  
    public void testQueryWithAggregationsCountsAsAggregation() {
        assertEquals("aggregation", r.resolve(ctxFor(aggSearch())));  
        // bare SearchRequest has a null source
        return new LimiterRequestContext(null, "indices:data/read/search", request);
import org.opensearch.action.ActionRequestValidationException;
        assertEquals("filter", r.resolve(ctxFor(plainSearch())));
    // -------------------------------------------------------------------------  
        assertNull(r.resolve(ctxFor(aggSearch())));
    }
 * compatible open source license.
        assertEquals("premium", r.resolve(ctxFor(plainSearch())));  
    public void testFactoryBuildsBySearchType() {
        PartitionResolver r = new PartitionResolver.BySearchTypePartitionResolver(Settings.EMPTY);
    private static LimiterRequestContext ctxFor(ActionRequest request) {
    }
        PartitionResolver r = new PartitionResolver.BySearchTypePartitionResolver(Settings.EMPTY);  
        assertEquals("aggregation", r.resolve(ctxFor(req)));
import org.opensearch.action.search.SearchRequest;  
        PartitionResolver r = new PartitionResolver.BySearchTypePartitionResolver(Settings.EMPTY);  
    public void testCustomPartitionNames() {
import org.opensearch.index.query.MatchAllQueryBuilder;  
        assertNull(r.resolve(ctxFor(plainSearch())));  
        assertEquals("aggregation", r.resolve(ctxFor(aggSearch())));
            }
 * The OpenSearch Contributors require contributions made to  
}  
    public void testByHeaderReturnsNullWhenHeaderMissing() {  
        );
        PartitionResolver r = PartitionResolver.build(ConcurrencyLimitResolverType.BY_HEADER, Settings.EMPTY, threadContext);
    }
            new SearchSourceBuilder().query(new MatchAllQueryBuilder()).aggregation(AggregationBuilders.terms("t").field("f"))
                return null;  
    }
    // byHeader
        assertTrue(r instanceof PartitionResolver.BySearchTypePartitionResolver);  
        assertEquals("light", r.resolve(ctxFor(plainSearch())));
    // -------------------------------------------------------------------------  
    }  
    private static SearchRequest plainSearch() {  
    }
        Settings config = Settings.builder().put("aggregation", "heavy").put("filter", "light").build();
            public ActionRequestValidationException validate() {
/*  
 * this file be licensed under the Apache-2.0 license or a
    public void testAggregationSearchRoutesToAggregationPartition() {
        PartitionResolver r = new PartitionResolver.BySearchTypePartitionResolver(Settings.EMPTY);
    }
        PartitionResolver r = PartitionResolver.build(ConcurrencyLimitResolverType.BY_HEADER, Settings.EMPTY, threadContext);
        PartitionResolver r = PartitionResolver.build(ConcurrencyLimitResolverType.NONE, Settings.EMPTY, null);  
    }
            @Override
    // -------------------------------------------------------------------------
import org.opensearch.search.builder.SearchSourceBuilder;
 * SPDX-License-Identifier: Apache-2.0
    }  
        assertNull(r.resolve(ctxFor(notASearch)));
        assertEquals("heavy", r.resolve(ctxFor(aggSearch())));
        assertEquals("filter", r.resolve(ctxFor(plainSearch())));
        assertEquals("filter", r.resolve(ctxFor(new SearchRequest())));
import org.opensearch.common.util.concurrent.ThreadContext;
    // -------------------------------------------------------------------------
        PartitionResolver r = PartitionResolver.build(ConcurrencyLimitResolverType.BY_SEARCH_TYPE, Settings.EMPTY, null);
 */  
        PartitionResolver r = new PartitionResolver.BySearchTypePartitionResolver(config);  
public class PartitionResolverTests extends OpenSearchTestCase {
        };
import org.opensearch.search.aggregations.AggregationBuilders;
        ActionRequest notASearch = new ActionRequest() {  
    public void testNullSourceRoutesToFilter() {
    }  
    // bySearchType
    }  
        return new SearchRequest().source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));
        return new SearchRequest().source(new SearchSourceBuilder().aggregation(AggregationBuilders.max("m").field("f")));  
package org.opensearch.concurrency;
import org.opensearch.common.settings.Settings;
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
    public void testByHeaderReadsTierHeader() {
import org.opensearch.test.OpenSearchTestCase;  
    public void testNonSearchRequestResolvesToNull() {
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        SearchRequest req = new SearchRequest().source(  
        threadContext.putHeader(ActionConcurrencyLimitPlugin.TIER_HEADER, "premium");
    public void testFactoryNoneTypeResolvesToNull() {
 *
    public void testPlainQuerySearchRoutesToFilterPartition() {  
