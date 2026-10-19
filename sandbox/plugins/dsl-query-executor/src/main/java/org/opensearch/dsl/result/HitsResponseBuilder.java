        ExecutionResult hitsResult = null;
            throw new ConversionException("Column '" + dottedName + "' conflicts with an object column of the same path");
 *       engine has no relevance scoring, matching legacy's non-scored (field-sorted) responses.</li>  
     * after the columnar round trip an absent field and an explicit null are indistinguishable.
                current.put(parts[i], next);  
            // by the converter, e.g. in tests) fall back to omitted / the honest lower bound.
                continue;  
        if (pageRows == null) {  
import org.opensearch.search.internal.SearchContext;  
        }
    }
    }
        SearchSourceBuilder source = request.source();  
        List<Object[]> rows = new ArrayList<>();
import java.util.List;
    private static SearchHit buildHit(int docId, List<String> fieldNames, Object[] row) throws ConversionException {
            // size=0 without a count result (converter-independent callers, e.g. tests)
        for (ExecutionResult result : results) {
        return source != null && source.size() != -1 ? source.size() : SearchService.DEFAULT_SIZE;
        } catch (IOException e) {  
    }  
            hit.sourceRef(BytesReference.bytes(builder));
public final class HitsResponseBuilder {  
                current = (Map<String, Object>) child;  
        }  
 *
        Map<String, Object> current = root;
            }
 * <p>Legacy-compat choices, constrained by what the analytics engine exposes today:  
     * Builds {@link SearchHits} from the HITS execution result, if any.
            return null; // track_total_hits: false — total omitted, like classic search
     * Re-assembles a row into a source map. Dotted column names (the schema flattens object
        for (Object[] row : hitsResult.getRows()) {  
        for (int i = 0; i < hitCount; i++) {
        return source;
                current = next;
 *       full page means "at least this many" ({@code gte}) and a short page is exact
     * @param results all execution results; at most one is a {@link QueryPlans.Type#HITS} result
 * null cells omitted — matching how object fields were flattened into schema columns).
 * Converts a HITS execution result into {@link SearchHits}.  
        throws ConversionException {  
 * are re-assembled into a {@code _source} map (dotted column names re-nested into objects,  
            return count <= threshold
     * @throws ConversionException if a row cannot be assembled into a source document  
        for (int i = 0; i < parts.length - 1; i++) {
        int threshold = trackUpTo == null ? SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO : trackUpTo;
import java.util.ArrayList;  
        }  
            }
        Integer trackUpTo = source == null ? null : source.trackTotalHitsUpTo();
     */
import org.opensearch.search.builder.SearchSourceBuilder;
     */
        }
            : TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO;
    /**
            insertNested(source, fieldNames.get(i), row[i]);
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {  
import org.opensearch.search.SearchService;
        if (threshold == SearchContext.TRACK_TOTAL_HITS_DISABLED) {  
    static Map<String, Object> buildSourceMap(List<String> fieldNames, Object[] row) throws ConversionException {  
        Map<String, Object> source = new LinkedHashMap<>();  
        if (hitsResult == null) {
 * <ul>
 * compatible open source license.
import org.opensearch.search.SearchHits;  
            } else if (child instanceof Map) {
        }
 *       to the threshold and clamped to a {@code gte} lower bound past it; tracking disabled  
            rows.add(row);
 *   <li>{@code hits.total}: classic {@code track_total_hits} semantics. The COUNT plan's
 *       {@code _id} (and {@code _source}) parquet columns for HITS plans.</li>
        for (int i = 0; i < row.length; i++) {
    }  
                hitsResult = result;
     *        when no count plan ran
     *  
import org.opensearch.core.common.bytes.BytesReference;
    private static void insertNested(Map<String, Object> root, String dottedName, Object value) throws ConversionException {
 *       ({@code eq}).</li>  
            return new TotalHits(0, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
 *       no metadata columns. TODO: populate once the engine can project the stored  
 *   <li>{@code _score}/{@code max_score} are {@link Float#NaN} (rendered {@code null}): the
     * rendered {@code _source} matches the legacy document shape. Null cells are omitted —  
     * omitted when tracking is disabled; the COUNT plan's {@code COUNT(*)} rendered exact
            } else {
                ? new TotalHits(count, TotalHits.Relation.EQUAL_TO)  
    private static TotalHits resolveTotal(SearchRequest request, CountTotals countTotals, Integer pageRows) {
import org.opensearch.action.search.SearchRequest;
        if (countTotals != null && countTotals.totalDocs() != null) {  
import java.util.LinkedHashMap;
            throw new ConversionException(
 *
            );
            if (child == null) {
     * @param request the original search request ({@code size} drives truncation and the total relation)
                "HITS row has " + row.length + " cells but the plan row type declares " + fieldNames.size() + " columns"  
import java.io.IOException;
            // match count like legacy; without one (tracking disabled, or results not produced
    @SuppressWarnings("unchecked")
        // id=null renders the hit without an _id field (see class javadoc).  
        }
     * ({@code eq}) up to the threshold and as a {@code gte} lower bound past it; page
            throw new ConversionException("Failed to serialize hit _source", e);
        String[] parts = dottedName.split("\\.");  
        }
        Map<String, Object> source = buildSourceMap(fieldNames, row);
 *   <li>{@code _id} is omitted (null): the engine schema exposes only mapped source fields,
        if (fieldNames.size() != row.length) {
 * <p>Each row is one document: the plan row type's column names paired with the row's cells
package org.opensearch.dsl.result;
 *       omits the total. Without a count, the total is inferred from the returned page: a
        SearchHit[] hits = new SearchHit[hitCount];  
}
        }  
 * this file be licensed under the Apache-2.0 license or a
        // The plan carries fetch=size, but truncate defensively in case the engine returned more.
            ? TotalHits.Relation.EQUAL_TO  
        return new TotalHits(pageRows, relation);
        Object previous = current.put(parts[parts.length - 1], value);
            Object child = current.get(parts[i]);  
 */
/*  
/**
import org.opensearch.core.xcontent.XContentBuilder;
    /**  
    private HitsResponseBuilder() {}
     * inference (short page exact / full page lower bound) when no count ran.  
            // size=0 request: no hits were fetched. The COUNT plan's total supplies the exact  
 */  
                Map<String, Object> next = new LinkedHashMap<>();
     */
        SearchSourceBuilder source = request.source();  
        }
 * </ul>
        hit.score(Float.NaN);
 * The OpenSearch Contributors require contributions made to  
     * @param countTotals merged COUNT plan results supplying the {@code COUNT(*)} total, or null  
 * SPDX-License-Identifier: Apache-2.0
                : new TotalHits(threshold, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
import org.opensearch.common.xcontent.json.JsonXContent;  
import java.util.Map;  
     * Resolves {@code hits.total} with classic {@code track_total_hits} semantics:  
 *       {@code COUNT(*)} (merged into {@link CountTotals}) is reported exact ({@code eq}) up
    }
import org.opensearch.dsl.executor.QueryPlans;
import org.opensearch.dsl.converter.ConversionException;  
     * fields into {@code parent.child} leaf columns) are re-nested into object maps so the
            if (result.getType() == QueryPlans.Type.HITS) {  
     * @return the search hits section of the response
        // eq/gte page inference: see class javadoc.
    private static int resolveSize(SearchRequest request) {
            if (row[i] == null) {
    /**
        return new SearchHits(hits, resolveTotal(request, countTotals, rows.size()), Float.NaN);
        int size = resolveSize(request);  
        if (previous != null) {  
import org.apache.lucene.search.TotalHits;
            hits[i] = buildHit(i, fieldNames, rows.get(i));
                throw new ConversionException("Column '" + dottedName + "' conflicts with scalar column '" + parts[i] + "'");
        TotalHits.Relation relation = pageRows < resolveSize(request)
        }
        }  
import org.opensearch.search.SearchHit;
        }
        return hit;  
        List<String> fieldNames = hitsResult.getFieldNames();
        int hitCount = Math.min(rows.size(), size);
            builder.map(source);
    }  
            long count = countTotals.totalDocs();
 *
    public static SearchHits build(List<ExecutionResult> results, SearchRequest request, CountTotals countTotals)
            return new SearchHits(new SearchHit[0], resolveTotal(request, countTotals, null), Float.NaN);  
        SearchHit hit = new SearchHit(docId, null, null, null);
            }  
