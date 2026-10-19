                        c.getScript(),
 * @opensearch.internal
    private final boolean showTermDocCountError;
        );  
                .map(config -> queryShardContext.getValuesSourceRegistry().getAggregator(REGISTRY_KEY, config.v1()).build(config))  
                ValuesSource.Numeric valuesSource = ((ValuesSource.Numeric) valuesSourceConfig.getValuesSource());
            }
            true  
            collectMode,
        Aggregator parent,
            factories,
            metadata,
                    return MultiTermsAggregator.InternalValuesSourceFactory.doubleValueSource(valuesSource, longFilter);
 *
                        c.getUserValueTypeHint(),  
            cardinality,  
import org.opensearch.search.DocValueFormat;  
        return true;
            // The user has not made a shardSize selection. Use default  
                .collect(Collectors.toList()),
    }  
    private final List<String> requestFields;  
            return MultiTermsAggregator.InternalValuesSourceFactory.bytesValuesSource(config.v1().getValuesSource(), filter);
        builder.register(REGISTRY_KEY, List.of(CoreValuesSourceType.BYTES, CoreValuesSourceType.IP), config -> {  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        TermsAggregator.BucketCountThresholds bucketCountThresholds,  
        CardinalityUpperBound cardinality,  
            name,
                    return MultiTermsAggregator.InternalValuesSourceFactory.longValuesSource(valuesSource, longFilter);  
                }
        this.collectMode = collectMode;  
import org.opensearch.search.aggregations.BucketOrder;
                    if (includeExclude != null) {
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
            configs.stream()
            )
    }
            bucketCountThresholds,  
    public interface InternalValuesSourceSupplier {
import org.opensearch.common.collect.Tuple;
 * SPDX-License-Identifier: Apache-2.0
        builder.register(
        boolean showTermDocCountError
    public MultiTermsAggregationFactory(  
    protected Aggregator createInternal(  
        return requestFields;
 * compatible open source license.
            maxOrds[i] = ((ValuesSource.Bytes.WithOrdinals) vs).globalMaxOrd(searchContext.searcher());
    private final List<Tuple<ValuesSourceConfig, IncludeExclude>> configs;  
    }  
        String name,
    private static long[] resolveOrdinalMaxOrds(
import org.opensearch.search.aggregations.InternalOrder;  
 */  
     * @opensearch.internal
                c -> new Tuple<ValuesSourceConfig, IncludeExclude>(  
        BucketOrder order,
public class MultiTermsAggregationFactory extends AggregatorFactory {
import java.util.stream.Collectors;
        // TODO: Optimize passing too many value source config derived objects to aggregator
            return null;
                    }  
     *
     * {@code InternalValuesSource} collectors, which the ordinal collection path bypasses). The actual  
            .collect(Collectors.toList());
     * counts, so a constructor that fails cannot leak the BigArrays-backed ords.
                return null;
    /**
        this.order = order;
                        longFilter = includeExclude.convertToDoubleFilter();  
        SearchContext searchContext,
    private final List<DocValueFormat> formats;
import java.util.Map;  
    private final TermsAggregator.BucketCountThresholds bucketCountThresholds;
                        longFilter = includeExclude.convertToDoubleFilter();
        List<MultiTermsValuesSourceConfig> multiTermConfigs,  
        }, true);  
import org.opensearch.search.aggregations.AggregatorFactory;  
                    if (includeExclude != null) {  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.search.aggregations.Aggregator;
import org.opensearch.search.aggregations.CardinalityUpperBound;
            && bucketCountThresholds.getShardSize() == TermsAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS.getShardSize()) {
import org.opensearch.search.startree.StarTreeQueryHelper;
                        queryShardContext,
        if (InternalOrder.isKeyOrder(order) == false
     * {@code include}/{@code exclude} filter (those filters are applied by the per-field
            // heuristic to avoid any wrong-ranking caused by distributed
        MultiTermsAggregator.InternalValuesSource build(Tuple<ValuesSourceConfig, IncludeExclude> config);
            if ((vs instanceof ValuesSource.Bytes.WithOrdinals) == false) {
            List.of(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.DATE),
        bucketCountThresholds.ensureValidity();  
        }  
    }  
            ordinalMaxOrds
    public List<String> getRequestFields() {  
     * Fields inherent from Terms Aggregation Factory.  
import org.opensearch.search.aggregations.bucket.BucketUtils;
        // Star-tree path writes directly to BytesKeyedBucketOrds; skip ordinal path to avoid split storage.  
                    c.getIncludeExclude()
                IncludeExclude includeExclude = config.v2();
            // counting
import org.opensearch.search.aggregations.AggregatorFactories;
    protected boolean supportsConcurrentSegmentSearch() {
            searchContext,
                        c.getMissing(),  
    }
                    if (includeExclude != null) {
                return null;
        AggregatorFactory parent,  
            configs.stream().map(c -> c.v1().format()).collect(Collectors.toList()),  
            }  
    /**
            // ordinal path does not run; fall back so the filter is still honored.
        return maxOrds;  
            this.getRequestFields(),
            final IncludeExclude.StringFilter filter = config.v2() == null ? null : config.v2().convertToStringFilter(config.v1().format());
        Map<String, Object> metadata,
            showTermDocCountError,  
            parent,
                        longFilter = includeExclude.convertToLongFilter(valuesSourceConfig.format());
                IncludeExclude.LongFilter longFilter = null;  
        }
            // include/exclude is enforced by the byte-key InternalValuesSource collectors, which the
 */  
    }
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;  
        SearchContext searchContext,  
    }
    ) throws IOException {
            if (config.v2() != null) {  
 * Factory of {@link MultiTermsAggregator}.  
    private final Aggregator.SubAggCollectionMode collectMode;  
        List<Tuple<ValuesSourceConfig, IncludeExclude>> configs,
            order,
        if (StarTreeQueryHelper.getSupportedStarTree(searchContext.getQueryShardContext()) != null) {
     */  
import org.opensearch.index.query.QueryShardContext;
            config -> {
                    ValuesSourceConfig.resolveUnregistered(
    /**
                } else {
                    }
        List<ValuesSource> rawValuesSources = configs.stream().map(config -> config.v1().getValuesSource()).toList();
        TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(this.bucketCountThresholds);  
        Map<String, Object> metadata
                    ),
import org.opensearch.search.aggregations.support.ValuesSource;
        this.formats = this.configs.stream().map(c -> c.v1().format()).collect(Collectors.toList());
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
        this.bucketCountThresholds = bucketCountThresholds;
                } else if (valuesSource.isBigInteger()) {  
        builder.registerUsage(MultiTermsAggregationBuilder.NAME);  
            Tuple<ValuesSourceConfig, IncludeExclude> config = configs.get(i);  
    private final BucketOrder order;
     * {@link PackedOrdinalBucketOrds} is built inside the {@link MultiTermsAggregator} constructor from these
            REGISTRY_KEY,  
            rawValuesSources,
    ) throws IOException {
    ) throws IOException {
     * Returns the per-field global-ordinal counts ({@code maxOrds}) to pack for the given configs when the
        super(name, queryShardContext, parent, subFactoriesBuilder, metadata);  
import java.util.List;
                        c.getFormat(),
            ValuesSource vs = config.v1().getValuesSource();  
package org.opensearch.search.aggregations.bucket.terms;
                    }
import static org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder.REGISTRY_KEY;  
    @Override  
     * ordinal path is eligible, or {@code null} to fall back to the default byte-key path. Falls back when a  
     * star-tree index is active, when any field is not backed by global ordinals, or when any field carries an
        return new MultiTermsAggregator(  
    @Override
                        CoreValuesSourceType.BYTES  
        QueryShardContext queryShardContext,
        for (int i = 0; i < configs.size(); i++) {
            },
            bucketCountThresholds.setShardSize(BucketUtils.suggestShardSideQueueSize(bucketCountThresholds.getRequiredSize()));  
                if (valuesSource.isFloatingPoint()) {
        }
        AggregatorFactories.Builder subFactoriesBuilder,
                        c.getFieldName(),
        this.requestFields = multiTermConfigs.stream().map(MultiTermsValuesSourceConfig::getFieldName).toList();  
import java.io.IOException;
                ValuesSourceConfig valuesSourceConfig = config.v1();  
import org.opensearch.search.internal.SearchContext;
        this.configs = multiTermConfigs.stream()
/*  
        this.showTermDocCountError = showTermDocCountError;
                    return MultiTermsAggregator.InternalValuesSourceFactory.unsignedLongValuesSource(valuesSource, longFilter);
 * The OpenSearch Contributors require contributions made to  
                )  
}
        long[] maxOrds = new long[configs.size()];
     */
                        c.getTimeZone(),
     */  
 * this file be licensed under the Apache-2.0 license or a
        Aggregator.SubAggCollectionMode collectMode,
/**
        CardinalityUpperBound cardinality
 *
            .map(
        );
     * Supplier for internal values source  
        long[] ordinalMaxOrds = resolveOrdinalMaxOrds(configs, searchContext, cardinality);
