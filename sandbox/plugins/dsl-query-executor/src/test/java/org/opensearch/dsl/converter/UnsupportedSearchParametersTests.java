        );
import org.opensearch.common.unit.TimeValue;
        params.put("fields", s -> s.fetchField("brand"));
        params.put("rescore", s -> s.addRescorer(new QueryRescorerBuilder(QueryBuilders.termQuery("brand", "a"))));
            "searchAfter",
            "rescores",
    }
    public void testExplicitFalseFlagsPass() throws Exception {
 * naming every offending parameter, instead of silently ignoring them.
/**
            .sort("price", SortOrder.DESC)
        ConversionException e = expectThrows(ConversionException.class, () -> converter().convert(source, "products"));
    }
            "suggest",
            "scriptFields",
        // Note: the sort field must survive the _source projection (the conversion pipeline
        params.put("suggest", s -> s.suggest(new SuggestBuilder()));
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
        params.put("profile", s -> s.profile(true));
    public void testEverySearchSourceGetterIsClassified() {
    /** Explicit false on flag parameters is not a use of the feature. */
        List<String> unclassified = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
            }
            }
            "SearchSourceBuilder getters "
 * this file be licensed under the Apache-2.0 license or a
            e.getValue().accept(source);
        params.put("slice", s -> s.slice(new SliceBuilder(0, 2)));
import org.opensearch.script.Script;
import org.opensearch.search.rescore.QueryRescorerBuilder;
import java.util.function.Consumer;
                unclassified.add(name);
     * production. (Public-API reflection only — forbidden-apis bans getDeclaredFields.)
            "includeNamedQueriesScore",
 * The unsupported-parameter allow-list: requests using features this path does not implement
    /** Deliberately ignored hints do not reject (documented in UnsupportedSearchParameters). */
            "minScore",
import org.opensearch.search.builder.PointInTimeBuilder;
        );
     * Every zero-arg public getter on {@code SearchSourceBuilder} must be classified:
 */
import org.opensearch.search.slice.SliceBuilder;
    public void testAllOffendersListedTogether() {
            .trackTotalHitsUpTo(1000);
     * ignored, or a non-feature utility. When core adds a new search feature this test fails,
            .trackScores(true)
        params.put("collapse", s -> s.collapse(new CollapseBuilder("brand")));
        params.put("seq_no_primary_term", s -> s.seqNoAndPrimaryTerm(true));
        for (java.lang.reflect.Method method : SearchSourceBuilder.class.getMethods()) {
        Map<String, String> mapping = new LinkedHashMap<>();
    // ── Aggregate behaviors ───────────────────────────────────────────────
        // projects before sorting — pre-existing behavior, independent of this check).
            "explain",
    /** All offenders are reported in one message, not first-fail. */
            "slice",
            "version",
            "pointInTimeBuilder",
import org.opensearch.search.aggregations.AggregationBuilders;
            "verbosePipeline"
        mapping.put("brand", "VARCHAR");
                || method.getParameterCount() != 0
     * forcing a decision instead of letting the new parameter be silently ignored in
            .size(10)
}
    // ── The allow-list enforcement ────────────────────────────────────────
import org.opensearch.test.OpenSearchTestCase;
        params.put("script_fields", s -> s.scriptField("x", new Script("doc['price'].value")));
        params.put("pit", s -> s.pointInTimeBuilder(new PointInTimeBuilder("pit-id")));
            );
import org.opensearch.search.fetch.subphase.FetchSourceContext;
import org.opensearch.dsl.golden.CalciteTestInfra;
            "pipeline",
                continue;
        params.put("version", s -> s.version(true));
public class UnsupportedSearchParametersTests extends OpenSearchTestCase {
    public void testEachRejectedParameter() {
        assertTrue(e.getMessage().contains("highlight"));
        SearchSourceBuilder source = new SearchSourceBuilder().query(QueryBuilders.termQuery("brand", "a"))
    }
        assertNotNull(converter().convert(source, "products"));
                + "then add it to the matching set in this test.",
        assertTrue(e.getMessage().contains("search_after"));
     * supported (converted), rejected ({@code UnsupportedSearchParameters}), deliberately
    public void testFullySupportedRequestPasses() throws Exception {
     */
                ex.getMessage().contains("not supported") && ex.getMessage().contains(e.getKey())
import java.util.Map;
        params.put("search_after", s -> s.searchAfter(new Object[] { 42 }));
                + unclassified
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
            "searchPipelineSource",
    }
        SearchSourceBuilder source = new SearchSourceBuilder().explain(false).version(false).seqNoAndPrimaryTerm(false).profile(false);
            SearchSourceBuilder source = new SearchSourceBuilder();
        Set<String> rejected = Set.of(
        params.put("derived", s -> s.derivedField("d", "keyword", new Script("emit('x')")));
            .stats(List.of("group1"));
            "ext",
        params.put("verbose_pipeline", s -> {
import java.util.List;
    }
    /** A request using the full supported surface converts without rejection. */
            assertTrue(
                + "UnsupportedSearchParameters, or document why ignoring it is safe - "
            "highlighter",
        Set<String> ignored = Set.of("timeout", "trackScores", "stats");
        params.put("explain", s -> s.explain(true));
 */
import org.opensearch.search.builder.SearchSourceBuilder;
            .aggregation(AggregationBuilders.terms("b").field("brand"))
    }
            .from(5)
        return new SearchSourceConverter(infra.schema());
import java.lang.reflect.Modifier;
    }
        });
            ConversionException ex = expectThrows(ConversionException.class, () -> converter().convert(source, "products"));
            "profile",
            "docValueFields",
            "collapse",
import org.opensearch.search.suggest.SuggestBuilder;
        params.put("min_score", s -> s.minScore(0.5f));
        Set<String> supported = Set.of("query", "from", "size", "sorts", "fetchSource", "aggregations", "trackTotalHitsUpTo");
        // Not search features: object plumbing, serialization, derived views of other getters.
        for (Map.Entry<String, Consumer<SearchSourceBuilder>> e : params.entrySet()) {
        Map<String, Consumer<SearchSourceBuilder>> params = new LinkedHashMap<>();
 * The OpenSearch Contributors require contributions made to
 *
 * compatible open source license.
        params.put("post_filter", s -> s.postFilter(QueryBuilders.termQuery("brand", "a")));
        }
        assertTrue(e.getMessage().contains("min_score"));
        params.put("search_pipeline", s -> s.pipeline("my-pipeline"));
            "getDerivedFields",
/*
            "fetchFields",
import org.opensearch.search.sort.SortOrder;
            .searchAfter(new Object[] { 1 })
            s.verbosePipeline(true);
            unclassified.isEmpty()
            if (!supported.contains(name) && !rejected.contains(name) && !ignored.contains(name) && !utility.contains(name)) {
            .fetchSource(new FetchSourceContext(true, new String[] { "brand", "price" }, null))
                "[" + e.getKey() + "] must be named in: " + ex.getMessage(),
        assertNotNull(converter().convert(source, "products"));
        params.put("highlight", s -> s.highlighter(new HighlightBuilder().field("brand")));
import org.opensearch.search.collapse.CollapseBuilder;
        params.put("docvalue_fields", s -> s.docValueField("price"));
import java.util.LinkedHashMap;
    /**
        params.put("indices_boost", s -> s.indexBoost("products", 2.0f));
            "storedFields",
            "postFilter",
            String name = method.getName();
                || Modifier.isStatic(method.getModifiers())) {
            .minScore(1.0f);
    public void testIgnoredHintsPass() throws Exception {
            s.pipeline("my-pipeline");
            "seqNoAndPrimaryTerm",
        SearchSourceBuilder source = new SearchSourceBuilder().highlighter(new HighlightBuilder().field("brand"))
import java.util.ArrayList;
        }
        Set<String> utility = Set.of("toString", "hashCode", "shallowCopy", "isSuggestOnly", "toXContent", "clearRescorers");
        assertNotNull(converter().convert(source, "products"));
    /** Every rejected parameter, table-driven: each must 400 with its REST name in the message. */
 * are rejected with a single {@link ConversionException} (mapped to HTTP 400 by the transport)
        params.put("include_named_queries_score", s -> s.includeNamedQueriesScores(true));
            "indexBoosts",
            "terminateAfter",
import java.util.Set;
            "getDerivedFieldsObject",
            if (method.getDeclaringClass() != SearchSourceBuilder.class
        params.put("stored_fields", s -> s.storedField("brand"));
        params.put("terminate_after", s -> s.terminateAfter(100));
        SearchSourceBuilder source = new SearchSourceBuilder().timeout(TimeValue.timeValueSeconds(30))
                + " are not classified as supported/rejected/ignored/utility. "
package org.opensearch.dsl.converter;
        assertTrue(
        mapping.put("price", "INTEGER");
                + "Decide how this search path treats each feature: convert it, reject it in "
    private SearchSourceConverter converter() {
import org.opensearch.index.query.QueryBuilders;
