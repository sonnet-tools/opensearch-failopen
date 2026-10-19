 *  
    /**
    @Override
                    + "] is not supported by the DSL execution path — date bucket keys cannot yet be rendered with mapping formats"
 * {@code {"aggs": {"by_brand": {"terms": {"field": "brand"}}}}} becomes {@code GROUP BY brand}.
 * The OpenSearch Contributors require contributions made to  
    public GroupingInfo getGrouping(TermsAggregationBuilder agg) {  
     * Rejects {@code include}/{@code exclude}, {@code script}, {@code min_doc_count: 0}, and
import org.opensearch.dsl.aggregation.GroupingInfo;
    public int size(TermsAggregationBuilder agg) {
    public InternalAggregation toBucketAggregation(TermsAggregationBuilder agg, Iterable<BucketEntry> buckets) {
        long otherDocCount = sumOtherDocCount(kept, eligibleDocCount);
import org.opensearch.search.aggregations.BucketOrder;
    private InternalAggregation render(TermsAggregationBuilder agg, List<BucketEntry> kept, long eligibleDocCount) {
                    + agg.field()
            throw new ConversionException(  
        }
    @Override
    /** Resolves the group field's mapping, or null when the MapperService or field mapping is unavailable. */
        MappedFieldType fieldType = mapperService.fieldType(agg.field());
import org.opensearch.index.mapper.MapperService;
    static TermsAggregator.BucketCountThresholds thresholds(TermsAggregationBuilder agg) {  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
    public BucketOrder getBucketOrder(TermsAggregationBuilder agg) {  
     * bucket set or key rendering relative to classic search if ignored.
public class TermsBucketTranslator implements SizedBucketTranslator<TermsAggregationBuilder> {  
     * date-mapped fields: the translation implements none of them, and each would change the  
        this.mapperServiceSupplier = mapperServiceSupplier;  
     * list — as {@code eligibleDocCount − Σ(received doc counts)}, clamped at zero: root
import java.util.List;
            throw new IllegalStateException(  
            throw new ConversionException(  
    /**
            : new FieldGrouping(List.of(agg.field()), Map.of(agg.field(), agg.missing()));  
        MappedFieldType fieldType = requireFieldType(agg);  
            ? new FieldGrouping(List.of(agg.field()))
    }  
    }  
     */
     * eligible counts come from a separately executed COUNT plan, and a refresh landing between
        MapperService mapperService = mapperServiceSupplier.get();
        if (agg.includeExclude() != null) {
        if (agg.script() != null) {
        if (agg.minDocCount() == 0) {  
        return entries;
    }  
                    + agg.field()
     *        rendering  
     * {@code sum_other_doc_count} is {@code eligibleDocCount − Σ(received doc counts)}.
     *  
    private final Supplier<MapperService> mapperServiceSupplier;
     * reaches this method: every terms plan is bounded (root levels by a flat LIMIT, nested
        List<BucketEntry> entries = toList(buckets);
 * the mapping's {@link DocValueFormat} renders the keys. A field whose mapping cannot be  
    public Class<TermsAggregationBuilder> getAggregationType() {
                "terms aggregation ["
import org.opensearch.dsl.aggregation.FieldGrouping;
     */
    public TermsBucketTranslator(Supplier<MapperService> mapperServiceSupplier) {
     * total {@code sum_other_doc_count} is subtracted from (see {@link #sumOtherDocCount}).
        }
    }
    /**
        return new TermsAggregator.BucketCountThresholds(agg.minDocCount(), agg.shardMinDocCount(), agg.size(), agg.shardSize());
        return mapperService == null ? null : mapperService.fieldType(field);
            );  
        return agg.order();
            throw new IllegalStateException(
                    + "] — cannot resolve the key type for field ["  
        }
    }  
     * Creates a terms bucket translator.
                    + agg.getName()  
        TermsResponseStrategy strategy = TermsResponseStrategy.forType(fieldType.typeName());
        return strategy.build(agg, kept, otherDocCount, fieldType.docValueFormat(null, null));
    /**
     *        format resolution; supplying null skips {@link #validate} mapping checks and fails
 * compatible open source license.
            && (DateFieldMapper.CONTENT_TYPE.equals(fieldType.typeName())
                || DateFieldMapper.DATE_NANOS_CONTENT_TYPE.equals(fieldType.typeName()))) {
        if (mapperService == null) {
        MapperService mapperService = mapperServiceSupplier.get();
    }  
     */
        return agg.size();  
     * Computes {@code sum_other_doc_count} — docs belonging to groups not in the bucket  
            );
                    + agg.getName()
import java.util.ArrayList;  
 */  
 * Translates a {@link TermsAggregationBuilder} — single-field GROUP BY.
    /**
    }  
                    + "] received buckets on the unsized render path: every terms plan is bounded, so rendering must go through the sized path"
        }  
            throw new IllegalStateException(
package org.opensearch.dsl.aggregation.bucket;
        return agg.minDocCount();
        }
            throw new ConversionException(
     * the two queries can leave the eligible count smaller than the received sum. (Nested  
    }
    @Override  
        List<BucketEntry> entries = new ArrayList<>();  
                "field [" + agg.field() + "] of terms aggregation [" + agg.getName() + "] is not present in the index mapping"
import org.opensearch.search.DocValueFormat;
import org.opensearch.index.mapper.MappedFieldType;  
                    + "] is not supported by the DSL execution path — zero-count buckets require enumerating the index term "
    private MappedFieldType requireFieldType(TermsAggregationBuilder agg) {  
    /** Bundles the request's bucket-count knobs for the result constructors. */
            );
                    + "dictionary, which a GROUP BY over matching documents cannot produce"
}  
import org.opensearch.search.aggregations.AggregationBuilder;  
        MappedFieldType fieldType = resolveFieldType(agg.field());
 *
            throw new ConversionException(
            receivedDocCount += entry.docCount();  
 * the {@link TermsResponseStrategy} that builds the correct {@code InternalTerms} subclass, and
     * bucket set here means the sized dispatch was bypassed, and the method throws.
            );  
        }
    @Override
    public void validate(TermsAggregationBuilder agg) throws ConversionException {
import java.util.Collection;
 * resolved at render time fails the request.
     * Renders the plan's bucket set as received: the plan already excluded null keys, applied
    }
    /** Resolves the group field's mapping for rendering, failing loudly when it cannot be resolved. */
import org.opensearch.search.aggregations.InternalAggregation;
        return render(agg, toList(buckets), eligibleDocCount);
        return fieldType;
                "[include]/[exclude] on terms aggregation [" + agg.getName() + "] is not supported by the DSL execution path"
        if (fieldType != null  
    public Collection<AggregationBuilder> getSubAggregations(TermsAggregationBuilder agg) {
import java.util.function.Supplier;
        return agg.getSubAggregations();
                "index mapping unavailable for terms aggregation ["
    }
import org.opensearch.index.mapper.DateFieldMapper;
            );  
     * levels by the per-parent ROW_NUMBER window), so non-empty levels render through
 */
    @Override  
    }  
                    + "]"
        return agg.missing() == null
 * SPDX-License-Identifier: Apache-2.0
     */  
 * this file be licensed under the Apache-2.0 license or a
            );  
     * eligible counts ride the plan's own rows and cannot skew.)
     * and the {@link DocValueFormat} for key rendering. {@code eligibleDocCount} supplies the
                "[script] on terms aggregation [" + agg.getName() + "] is not supported by the DSL execution path"  
        for (BucketEntry entry : entries) {
    }  
     */
    }
        }  
    @Override  
    private static List<BucketEntry> toList(Iterable<BucketEntry> buckets) {
    private MappedFieldType resolveFieldType(String field) {  
                "terms aggregation ["
        return TermsAggregationBuilder.class;
    }
    public long minDocCount(TermsAggregationBuilder agg) {
import java.util.Map;  
                "[min_doc_count: 0] on terms aggregation ["
    private static long sumOtherDocCount(List<BucketEntry> entries, long eligibleDocCount) {  
/**  
    }  
    public InternalAggregation toBucketAggregation(TermsAggregationBuilder agg, Iterable<BucketEntry> buckets, long eligibleDocCount) {
        if (entries.isEmpty() == false) {  
     * {@link #toBucketAggregation(TermsAggregationBuilder, Iterable, long)}. A non-empty  
        long receivedDocCount = 0;
import org.opensearch.dsl.result.BucketEntry;
    @Override  
     * Builds the terms response: the field's mapping selects the {@link TermsResponseStrategy}  
        return Math.max(0, eligibleDocCount - receivedDocCount);
        return render(agg, entries, 0L);
     * {@code min_doc_count}, ordered, and truncated to the top {@code size}.  
        if (fieldType == null) {  
        buckets.forEach(entries::add);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
    /**
     * @param mapperServiceSupplier supplies the target index's MapperService for key type and
import org.opensearch.dsl.converter.ConversionException;  
                    + "] on date field ["  
     * Renders the empty aggregation for levels with no result rows — the only case that  
     */
 * <p>Response typing is mapping-resolved: the field's {@code MappedFieldType.typeName()} selects
        }
    @Override  
                    + agg.getName()  
    }
            );
    @Override  
                    + agg.getName()
/*  
