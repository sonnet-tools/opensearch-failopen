import org.opensearch.search.SearchHit;
 * <p>Each row is one document: the plan row type's column names paired with the row's cells
import org.opensearch.core.common.bytes.BytesReference;
        for (int i = 0; i < parts.length - 1; i++) {
     * rendered {@code _source} matches the legacy document shape. Null cells are omitted —
     */
 * </ul>
 *       engine has no relevance scoring, matching legacy's non-scored (field-sorted) responses.</li>
        List<String> fieldNames = hitsResult.getFieldNames();
            : TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO;
 * compatible open source license.
        throws ConversionException {
}
 * <p>Legacy-compat choices, constrained by what the analytics engine exposes today:
 *   <li>{@code _score}/{@code max_score} are {@link Float#NaN} (rendered {@code null}): the
 *       ({@code eq}).</li>
        }
    /**
     */
import org.apache.lucene.search.TotalHits;
 *       omits the total. Without a count, the total is inferred from the returned page: a
        Map<String, Object> source = new LinkedHashMap<>();
            throw new ConversionException("Failed to serialize hit _source", e);
        if (threshold == SearchContext.TRACK_TOTAL_HITS_DISABLED) {
        Map<String, Object> current = root;
import org.opensearch.common.xcontent.json.JsonXContent;
        }
        Integer trackUpTo = source == null ? null : source.trackTotalHitsUpTo();
        SearchHit[] hits = new SearchHit[hitCount];
package org.opensearch.dsl.result;
        return new TotalHits(pageRows, relation);
            rows.add(row);
        }
        for (int i = 0; i < hitCount; i++) {
            }
        Map<String, Object> source = buildSourceMap(fieldNames, row);
            if (row[i] == null) {
        for (int i = 0; i < row.length; i++) {
            hit.sourceRef(BytesReference.bytes(builder));
                throw new ConversionException("Column '" + dottedName + "' conflicts with scalar column '" + parts[i] + "'");
 * null cells omitted — matching how object fields were flattened into schema columns).
                ? new TotalHits(count, TotalHits.Relation.EQUAL_TO)
 * Converts a HITS execution result into {@link SearchHits}.
 *       {@code COUNT(*)} (merged into {@link CountTotals}) is reported exact ({@code eq}) up
        } catch (IOException e) {
    @SuppressWarnings("unchecked")
 *       to the threshold and clamped to a {@code gte} lower bound past it; tracking disabled
        TotalHits.Relation relation = pageRows < resolveSize(request)
import org.opensearch.search.internal.SearchContext;
     * Resolves {@code hits.total} with classic {@code track_total_hits} semantics:
        }
    }
        List<Object[]> rows = new ArrayList<>();
        if (countTotals != null && countTotals.totalDocs() != null) {
        SearchSourceBuilder source = request.source();
    }
     * fields into {@code parent.child} leaf columns) are re-nested into object maps so the
            return count <= threshold
 * are re-assembled into a {@code _source} map (dotted column names re-nested into objects,
        return hit;
                hitsResult = result;
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
 * SPDX-License-Identifier: Apache-2.0
            hits[i] = buildHit(i, fieldNames, rows.get(i));
        // eq/gte page inference: see class javadoc.
    public static SearchHits build(List<ExecutionResult> results, SearchRequest request, CountTotals countTotals)
    private static TotalHits resolveTotal(SearchRequest request, CountTotals countTotals, Integer pageRows) {
import org.opensearch.dsl.executor.QueryPlans;
        return new SearchHits(hits, resolveTotal(request, countTotals, rows.size()), Float.NaN);
 * <ul>
                : new TotalHits(threshold, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
        for (ExecutionResult result : results) {
    private static SearchHit buildHit(int docId, List<String> fieldNames, Object[] row) throws ConversionException {
     * @param countTotals merged COUNT plan results supplying the {@code COUNT(*)} total, or null
import java.util.List;
        if (previous != null) {
            } else if (child instanceof Map) {
            return new TotalHits(0, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
     * @return the search hits section of the response
     * omitted when tracking is disabled; the COUNT plan's {@code COUNT(*)} rendered exact
            throw new ConversionException("Column '" + dottedName + "' conflicts with an object column of the same path");
     * @param results all execution results; at most one is a {@link QueryPlans.Type#HITS} result
                continue;
        Object previous = current.put(parts[parts.length - 1], value);
        return source != null && source.size() != -1 ? source.size() : SearchService.DEFAULT_SIZE;
        if (pageRows == null) {
 *       {@code _id} (and {@code _source}) parquet columns for HITS plans.</li>
            ? TotalHits.Relation.EQUAL_TO
/*
import java.util.ArrayList;
import org.opensearch.search.SearchService;
            if (result.getType() == QueryPlans.Type.HITS) {
    private static void insertNested(Map<String, Object> root, String dottedName, Object value) throws ConversionException {
            return new SearchHits(new SearchHit[0], resolveTotal(request, countTotals, null), Float.NaN);
            Object child = current.get(parts[i]);
    }
        hit.score(Float.NaN);
     *
        ExecutionResult hitsResult = null;
            builder.map(source);
import org.opensearch.dsl.converter.ConversionException;
    private HitsResponseBuilder() {}
     *        when no count plan ran
            insertNested(source, fieldNames.get(i), row[i]);
 *
     * Re-assembles a row into a source map. Dotted column names (the schema flattens object
        }
            } else {
        if (fieldNames.size() != row.length) {
     * @throws ConversionException if a row cannot be assembled into a source document
        for (Object[] row : hitsResult.getRows()) {
 *
                current.put(parts[i], next);
        // id=null renders the hit without an _id field (see class javadoc).
            );
 *   <li>{@code _id} is omitted (null): the engine schema exposes only mapped source fields,
    }
        int size = resolveSize(request);
        if (hitsResult == null) {
        SearchSourceBuilder source = request.source();
    /**
        }
            throw new ConversionException(
 *
     * Builds {@link SearchHits} from the HITS execution result, if any.
    private static int resolveSize(SearchRequest request) {
            // size=0 request: no hits were fetched. The COUNT plan's total supplies the exact
        }
import java.util.LinkedHashMap;
        }
        return source;
    static Map<String, Object> buildSourceMap(List<String> fieldNames, Object[] row) throws ConversionException {
            // match count like legacy; without one (tracking disabled, or results not produced
                current = (Map<String, Object>) child;
     * after the columnar round trip an absent field and an explicit null are indistinguishable.
            return null; // track_total_hits: false — total omitted, like classic search
    /**
    }
     * inference (short page exact / full page lower bound) when no count ran.
     * @param request the original search request ({@code size} drives truncation and the total relation)
        int threshold = trackUpTo == null ? SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO : trackUpTo;
            }
            long count = countTotals.totalDocs();
 * The OpenSearch Contributors require contributions made to
            }
            // by the converter, e.g. in tests) fall back to omitted / the honest lower bound.
        String[] parts = dottedName.split("\\.");
    }
 * this file be licensed under the Apache-2.0 license or a
        }
 *   <li>{@code hits.total}: classic {@code track_total_hits} semantics. The COUNT plan's
/**
            if (child == null) {
        }
                current = next;
     */
                "HITS row has " + row.length + " cells but the plan row type declares " + fieldNames.size() + " columns"
import java.util.Map;
 *       full page means "at least this many" ({@code gte}) and a short page is exact
        int hitCount = Math.min(rows.size(), size);
     * ({@code eq}) up to the threshold and as a {@code gte} lower bound past it; page
        SearchHit hit = new SearchHit(docId, null, null, null);
import org.opensearch.core.xcontent.XContentBuilder;
 */
import java.io.IOException;
        // The plan carries fetch=size, but truncate defensively in case the engine returned more.
import org.opensearch.action.search.SearchRequest;
import org.opensearch.search.builder.SearchSourceBuilder;
                Map<String, Object> next = new LinkedHashMap<>();
import org.opensearch.search.SearchHits;
            // size=0 without a count result (converter-independent callers, e.g. tests)
        }
public final class HitsResponseBuilder {
 */
 *       no metadata columns. TODO: populate once the engine can project the stored
        }
