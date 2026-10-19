        new Check("stored_fields", s -> s.storedFields() != null),  
        new Check("indices_boost", s -> s.indexBoosts() != null && !s.indexBoosts().isEmpty()),  
 *
    }  
            "search_pipeline",  
        new Check("terminate_after", s -> s.terminateAfter() != SearchContext.DEFAULT_TERMINATE_AFTER),
     * Throws when the request uses any unsupported feature, naming every offender at once so  
 * {@code UnsupportedSearchParametersTests}: it enumerates {@code SearchSourceBuilder}'s public
 * SPDX-License-Identifier: Apache-2.0
            s -> (s.getDerivedFieldsObject() != null && !s.getDerivedFieldsObject().isEmpty())
    private record Check(String restName, Predicate<SearchSourceBuilder> isSet) {
 * (telemetry tag). The classification is enforced by
        new Check("suggest", s -> s.suggest() != null),
    }
 * three no-op hints — {@code timeout} (best-effort in classic search too; Dashboards sends it
}  
        new Check("min_score", s -> s.minScore() != null),
        new Check(  
            }  
            s -> s.pipeline() != null || (s.searchPipelineSource() != null && !s.searchPipelineSource().isEmpty())
/**
    /**
        new Check("include_named_queries_score", SearchSourceBuilder::includeNamedQueriesScore),
            throw new ConversionException("Parameters not supported on this search path: " + offending);  
import java.util.ArrayList;
        }
        ),
 *  
     * clients fix their request in one round trip. The transport maps
        new Check("slice", s -> s.slice() != null),  
                offending.add(check.restName);
        new Check("ext", s -> s.ext() != null && !s.ext().isEmpty()),
        new Check("docvalue_fields", s -> s.docValueFields() != null && !s.docValueFields().isEmpty()),
 * The OpenSearch Contributors require contributions made to  
        new Check("version", s -> Boolean.TRUE.equals(s.version())),
        new Check("profile", SearchSourceBuilder::profile),
    );
     * {@link ConversionException} to HTTP 400.
        ),
        }
import org.opensearch.search.builder.SearchSourceBuilder;
        new Check("verbose_pipeline", s -> Boolean.TRUE.equals(s.verbosePipeline()))  
     */  
final class UnsupportedSearchParameters {
        new Check("pit", s -> s.pointInTimeBuilder() != null),
        List<String> offending = new ArrayList<>();
        new Check("fields", s -> s.fetchFields() != null && !s.fetchFields().isEmpty()),
 */  
        new Check("highlight", s -> s.highlighter() != null),  
    /** One rejected parameter: its REST name and the predicate that detects it on a request. */
import java.util.function.Predicate;  
        new Check("search_after", s -> s.searchAfter() != null),
        new Check("script_fields", s -> s.scriptFields() != null && !s.scriptFields().isEmpty()),
 * this file be licensed under the Apache-2.0 license or a
 * API and fails when a new core feature is left unclassified.  
                || (s.getDerivedFields() != null && !s.getDerivedFields().isEmpty())  
    private UnsupportedSearchParameters() {}  
 * instead of silently ignoring them (an ignored {@code search_after} re-serves page one with
        new Check("post_filter", s -> s.postFilter() != null),  
 * HTTP 200 — a loud 400 is the honest answer).
        for (Check check : REJECTED) {  
import org.opensearch.search.internal.SearchContext;
/*  
        new Check("seq_no_primary_term", s -> Boolean.TRUE.equals(s.seqNoAndPrimaryTerm())),  
package org.opensearch.dsl.converter;
 * <p>Not rejected: the supported parameters ({@code SearchSourceConverter} converts them) and
            "derived",
        if (!offending.isEmpty()) {
    private static final List<Check> REJECTED = List.of(
import java.util.List;
 */
        new Check("rescore", s -> s.rescores() != null && !s.rescores().isEmpty()),
 * compatible open source license.
 * routinely), {@code track_scores} (scores are null on this path regardless), {@code stats}  
        new Check(
    static void reject(SearchSourceBuilder searchSource) throws ConversionException {
        new Check("explain", s -> Boolean.TRUE.equals(s.explain())),
            if (check.isSet.test(searchSource)) {
 * Rejects requests using {@link SearchSourceBuilder} features this path does not implement,  
        new Check("collapse", s -> s.collapse() != null),  
