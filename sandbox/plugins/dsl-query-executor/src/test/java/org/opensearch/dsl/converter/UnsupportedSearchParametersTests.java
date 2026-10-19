    public void testFullySupportedRequestPasses() throws Exception {
import org.opensearch.script.Script;
            "pipeline",
import org.opensearch.index.query.QueryBuilders;  
        assertNotNull(converter().convert(source, "products"));
            .fetchSource(new FetchSourceContext(true, new String[] { "brand", "price" }, null))  
        params.put("search_after", s -> s.searchAfter(new Object[] { 42 }));  
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.search.slice.SliceBuilder;  
            }
            s.pipeline("my-pipeline");  
        // Not search features: object plumbing, serialization, derived views of other getters.  
        params.put("post_filter", s -> s.postFilter(QueryBuilders.termQuery("brand", "a")));
                "[" + e.getKey() + "] must be named in: " + ex.getMessage(),  
        for (java.lang.reflect.Method method : SearchSourceBuilder.class.getMethods()) {
    }  
                continue;
import java.util.Set;
            SearchSourceBuilder source = new SearchSourceBuilder();
        params.put("slice", s -> s.slice(new SliceBuilder(0, 2)));
        assertTrue(e.getMessage().contains("highlight"));
            .aggregation(AggregationBuilders.terms("b").field("brand"))
        SearchSourceBuilder source = new SearchSourceBuilder().highlighter(new HighlightBuilder().field("brand"))
        }  
            e.getValue().accept(source);  
            if (!supported.contains(name) && !rejected.contains(name) && !ignored.contains(name) && !utility.contains(name)) {
            "collapse",
                + unclassified
            "verbosePipeline"  
import java.util.function.Consumer;
/**
    // ── Aggregate behaviors ───────────────────────────────────────────────  
        Set<String> utility = Set.of("toString", "hashCode", "shallowCopy", "isSuggestOnly", "toXContent", "clearRescorers");
    /** Explicit false on flag parameters is not a use of the feature. */
    }
import java.util.Map;  
 *
            s.verbosePipeline(true);
import org.opensearch.common.unit.TimeValue;
        params.put("include_named_queries_score", s -> s.includeNamedQueriesScores(true));
import org.opensearch.search.rescore.QueryRescorerBuilder;
import org.opensearch.search.builder.PointInTimeBuilder;  
            "getDerivedFieldsObject",
            "indexBoosts",
            ConversionException ex = expectThrows(ConversionException.class, () -> converter().convert(source, "products"));
import org.opensearch.search.aggregations.AggregationBuilders;
            "SearchSourceBuilder getters "
        assertTrue(e.getMessage().contains("search_after"));  
                + "Decide how this search path treats each feature: convert it, reject it in "
        params.put("fields", s -> s.fetchField("brand"));
     * supported (converted), rejected ({@code UnsupportedSearchParameters}), deliberately  
import java.util.ArrayList;  
            .sort("price", SortOrder.DESC)
        params.put("min_score", s -> s.minScore(0.5f));
        params.put("explain", s -> s.explain(true));
    /** A request using the full supported surface converts without rejection. */
            "ext",  
    public void testIgnoredHintsPass() throws Exception {
                + "UnsupportedSearchParameters, or document why ignoring it is safe - "
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
import org.opensearch.search.sort.SortOrder;
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
import java.lang.reflect.Modifier;
 * The unsupported-parameter allow-list: requests using features this path does not implement
            }  
            "scriptFields",
            "highlighter",
        }
        Map<String, Consumer<SearchSourceBuilder>> params = new LinkedHashMap<>();  
        Set<String> rejected = Set.of(
     * ignored, or a non-feature utility. When core adds a new search feature this test fails,
public class UnsupportedSearchParametersTests extends OpenSearchTestCase {  
        params.put("suggest", s -> s.suggest(new SuggestBuilder()));
            "fetchFields",
                ex.getMessage().contains("not supported") && ex.getMessage().contains(e.getKey())
        assertTrue(e.getMessage().contains("min_score"));
    private SearchSourceConverter converter() {
    }
        assertTrue(  
            .minScore(1.0f);  
            String name = method.getName();
            "searchAfter",
        params.put("version", s -> s.version(true));  
            .from(5)  
    }  
        params.put("stored_fields", s -> s.storedField("brand"));
        params.put("indices_boost", s -> s.indexBoost("products", 2.0f));  
    /**
            .size(10)
        params.put("profile", s -> s.profile(true));
package org.opensearch.dsl.converter;
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);  
        Set<String> ignored = Set.of("timeout", "trackScores", "stats");
        for (Map.Entry<String, Consumer<SearchSourceBuilder>> e : params.entrySet()) {
import java.util.LinkedHashMap;
 */
        );
import org.opensearch.search.collapse.CollapseBuilder;
            assertTrue(
 * compatible open source license.
}
        params.put("pit", s -> s.pointInTimeBuilder(new PointInTimeBuilder("pit-id")));  
    /** All offenders are reported in one message, not first-fail. */
        assertNotNull(converter().convert(source, "products"));  
    /** Deliberately ignored hints do not reject (documented in UnsupportedSearchParameters). */  
            "storedFields",
            "explain",  
        Set<String> supported = Set.of("query", "from", "size", "sorts", "fetchSource", "aggregations", "trackTotalHitsUpTo");  
        params.put("docvalue_fields", s -> s.docValueField("price"));
    public void testEachRejectedParameter() {
        SearchSourceBuilder source = new SearchSourceBuilder().timeout(TimeValue.timeValueSeconds(30))
        params.put("search_pipeline", s -> s.pipeline("my-pipeline"));
     * production. (Public-API reflection only — forbidden-apis bans getDeclaredFields.)  
            "slice",
        });
            .trackScores(true)  
            .stats(List.of("group1"));
            "rescores",
            "docValueFields",  
import org.opensearch.search.suggest.SuggestBuilder;
            "searchPipelineSource",
     */
        params.put("verbose_pipeline", s -> {
            "seqNoAndPrimaryTerm",
        mapping.put("price", "INTEGER");
                unclassified.add(name);  
     * Every zero-arg public getter on {@code SearchSourceBuilder} must be classified:
        params.put("rescore", s -> s.addRescorer(new QueryRescorerBuilder(QueryBuilders.termQuery("brand", "a"))));
        Map<String, String> mapping = new LinkedHashMap<>();  
    }  
     * forcing a decision instead of letting the new parameter be silently ignored in
        // projects before sorting — pre-existing behavior, independent of this check).
            .searchAfter(new Object[] { 1 })
    }
        );
        SearchSourceBuilder source = new SearchSourceBuilder().explain(false).version(false).seqNoAndPrimaryTerm(false).profile(false);
import org.opensearch.dsl.golden.CalciteTestInfra;
            .trackTotalHitsUpTo(1000);
                || Modifier.isStatic(method.getModifiers())) {
            "includeNamedQueriesScore",  
 * SPDX-License-Identifier: Apache-2.0
        // Note: the sort field must survive the _source projection (the conversion pipeline  
            "pointInTimeBuilder",  
    public void testExplicitFalseFlagsPass() throws Exception {  
        List<String> unclassified = new ArrayList<>();
            );
        params.put("collapse", s -> s.collapse(new CollapseBuilder("brand")));
                + " are not classified as supported/rejected/ignored/utility. "  
            "getDerivedFields",  
/*  
 */  
        return new SearchSourceConverter(infra.schema());
import org.opensearch.search.builder.SearchSourceBuilder;
 * The OpenSearch Contributors require contributions made to  
        params.put("terminate_after", s -> s.terminateAfter(100));  
            "minScore",  
            "version",
 * are rejected with a single {@link ConversionException} (mapped to HTTP 400 by the transport)  
        SearchSourceBuilder source = new SearchSourceBuilder().query(QueryBuilders.termQuery("brand", "a"))
        ConversionException e = expectThrows(ConversionException.class, () -> converter().convert(source, "products"));
            if (method.getDeclaringClass() != SearchSourceBuilder.class
            "profile",
    public void testAllOffendersListedTogether() {  
 * this file be licensed under the Apache-2.0 license or a
            unclassified.isEmpty()
        params.put("highlight", s -> s.highlighter(new HighlightBuilder().field("brand")));  
        mapping.put("brand", "VARCHAR");
    public void testEverySearchSourceGetterIsClassified() {
                || method.getParameterCount() != 0  
    }
 * naming every offending parameter, instead of silently ignoring them.
        assertNotNull(converter().convert(source, "products"));
            "postFilter",
            "suggest",  
    /** Every rejected parameter, table-driven: each must 400 with its REST name in the message. */
        params.put("derived", s -> s.derivedField("d", "keyword", new Script("emit('x')")));
                + "then add it to the matching set in this test.",  
    // ── The allow-list enforcement ────────────────────────────────────────
        params.put("script_fields", s -> s.scriptField("x", new Script("doc['price'].value")));  
import java.util.List;
        params.put("seq_no_primary_term", s -> s.seqNoAndPrimaryTerm(true));
            "terminateAfter",
