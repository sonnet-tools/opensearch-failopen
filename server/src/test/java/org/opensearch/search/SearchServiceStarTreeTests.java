                starTreeFieldConfiguration,
        assertStarTreeContext(request, sourceBuilder, null, -1);  
        ShardSearchRequest request = new ShardSearchRequest(  
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, true).to(toDateString, false).format(DATE_FORMAT);
        baseQuery = new MatchAllQueryBuilder();  
        Instant startOfTodayUTC = now.truncatedTo(ChronoUnit.DAYS);  
        IndexShard indexShard = indexService.getShard(0);
            .build();  
        );
                -1,
        );  
                        MetricStat stat = getMetricStatFromAgg(metricAgg);
    public void testInvalidQueryParsingForDateHistogramAggregations() throws IOException {
            }  
        assertStarTreeContext(request, sourceBuilder, null, -1);
                starTreeFieldConfiguration,
            null  
            for (Supplier<ValuesSourceAggregationBuilder<?>> secondSupplier : aggregationSuppliers) {
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, true).format(DATE_FORMAT);
            new AliasFilter(null, Strings.EMPTY_ARRAY),
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0)
import org.opensearch.common.settings.Settings;  
            Collections.emptySet(),
        String STATUS = "status";
            new StarTreeField(
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        when(indexShard.segments(false)).thenReturn(List.of(segment, segment));  
    private void assertStarTreeContext(  
            sourceBuilder,
        assertStarTreeContext(  
                    .field(TIMESTAMP_FIELD, nowMillis)  
public class SearchServiceStarTreeTests extends OpenSearchSingleNodeTestCase {  
     * Test query parsing for range aggregations, with/without numeric term query
            indexShard.shardId(),
                    new Metric(TIMESTAMP_FIELD, List.of(MetricStat.SUM, MetricStat.MAX)),
    public void indexRandomDocuments(int totalDocs) throws IOException {  
                baseQuery,
                searchContext,
    /**
        long nowMillis = Instant.now().toEpochMilli();
        AggregatorFactory[] aggregatorFactoriesArray = sourceBuilder.aggregations().getAggregatorFactories().stream().map(af -> {
                sourceBuilder,
        SearchSourceBuilder sourceBuilder,
                        );  
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
        MultiTermsAggregationBuilder multiTermsAgg = multiTerms("multi_terms").terms(  
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
        rangeAggregationBuilder = range("range").field(TIMESTAMP_FIELD).addRange(0, 100).subAggregation(maxAggNoSub);
        baseQuery = new MatchAllQueryBuilder();
                searchContext,  
import java.util.Set;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
                assertThat(actualContext, notNullValue());  
        baseQuery = new MatchAllQueryBuilder();  
            getStarTreeQueryContext(
            1.0f,
        ShardSearchRequest request = new ShardSearchRequest(
    }
                "startree1",
                List.of(new OrdinalDimension("sndv")),  
                XContentFactory.jsonBuilder()
            } else {
 * For valid resolvable (with star-tree) cases, StarTreeQueryContext is created and populated with the SearchContext  
            .format("strict_date_optional_time||epoch_second");
            null,
                new MultiTermsValuesSourceConfig.Builder().setFieldName(NUMERIC_FIELD).build()
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(rangeAggregationBuilder);
            .subAggregation(sumAggSub);  
            1,
        QueryBuilder baseQuery;
            ),
        CreateIndexRequestBuilder builder = client().admin()
                List.of(new Metric("field", List.of(MetricStat.MAX, MetricStat.SUM))),  
            case 4 -> new OrdinalDimension(KEYWORD_FIELD);
        request.source(sourceBuilder);  
            .subAggregation(maxAggNoSub)
                } else {  
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
            () -> dateHistogram("by_day").field(TIMESTAMP_FIELD).calendarInterval(DateHistogramInterval.DAY),  
                        getStarTreeQueryContext(
        SearchContext searchContext = mock(SearchContext.class);
        String KEYWORD_FIELD = "clientip";
            request,
                baseQuery,
            .subAggregation(medianAgg);
                    ),
            .setSettings(starStreeEnabledIndexSettings)
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(rangeAggregationBuilder).aggregation(maxAggNoSub);
        // Case 6: Range Aggregation on non-numeric field, should not use star tree
        createIndex("test", builder);  
        );
            .indices()
        when(searchContext.aggregations()).thenReturn(searchContextAggregations);
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
            .query(new MatchAllQueryBuilder())  
                for (Supplier<ValuesSourceAggregationBuilder<?>> thirdSupplier : aggregationSuppliers) {  
 */
                                -1,  
            sourceBuilder,  
        assertStarTreeContext(request, sourceBuilder, null, -1);
     */  
        setStarTreeIndexSetting(null);  
                        .field(SIZE, random().nextBoolean() ? random().nextInt(100) : null) // Random size (0-99)  
     */  
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),  
import org.opensearch.index.query.TermQueryBuilder;
                        .field(STATUS, random().nextBoolean() ? random().nextInt(10) : null) // Random status (0-9)
            new AliasFilter(null, Strings.EMPTY_ARRAY),  
                    ),
    }
            -1,  
            new AliasFilter(null, Strings.EMPTY_ARRAY),
            new SearchRequest().allowPartialSearchResults(true),  
        searchContext.close();
                sourceBuilder,
            -1
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(multiTermsAgg);
import java.util.concurrent.TimeUnit;
                    ),
                1,  
        when(searchContext.indexShard()).thenReturn(indexShard);
            count("_count").field(FIELD_NAME), };
import org.opensearch.index.compositeindex.datacube.NumericDimension;  
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
            request,
        };  
        // Case 2: Numeric term query and a non-nested metric sub-aggregation, should use star tree
    private static Dimension getDimensionByIndex(int index) {  
        multiTermsAgg = multiTerms("multi_terms").terms(
            null  
        );  
        // Case 7: Valid range aggregation and valid metric aggregation, should use star tree & cache
            }
        ).subAggregation(sumAggSub);
            -1,
                "star_tree",  
                searchContext,
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
                "startree1",
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(rangeAggregationBuilder);
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
                "startree1",  
            1.0f,
        assertStarTreeContext(request, sourceBuilder, null, -1);
        when(aggregatorFactories.getFactories()).thenReturn(new AggregatorFactory[] { null, null });
        assertStarTreeContext(request, sourceBuilder, null, -1);
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(  
            searchContext.getQueryShardContext().setStarTreeQueryContext(starTreeQueryContext);  
                    new Metric(STATUS, List.of(MetricStat.MAX, MetricStat.SUM))  
        MaxAggregationBuilder maxAggNoSub = max("max").field(STATUS);
        baseQuery = new MatchAllQueryBuilder();
            getStarTreeQueryContext(  
    Settings starStreeEnabledIndexSettings = Settings.builder()  
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
                            sourceBuilder,  
        // 4-LEVELS [BUCKET -> BUCKET -> BUCKET -> METRIC]  
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
            if (expectedContext == null) {  
            Collections.emptySet(),  
                            metrics,
        setStarTreeIndexSetting("true");  
        when(mockAggregations.factories()).thenReturn(aggregatorFactories);
import org.opensearch.action.OriginalIndices;
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)  
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
        MaxAggregationBuilder sumAggNoSub = max("sum").field(STATUS);
        ).subAggregation(medianAgg);
    }  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        assertEquals(22, starTreeQueryContext.maybeGetCachedNodeIdsForSegment(0).length());  
                    false,
            );  
            .calendarInterval(DateHistogramInterval.DAY)
                sourceBuilder,
        if (name.contains("sum")) return MetricStat.SUM;
        assertStarTreeContext(request, sourceBuilder, null, -1);
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
                        ValuesSourceAggregationBuilder<?> firstBucket = firstSupplier.get().subAggregation(secondBucket);
            sourceBuilder,
            sourceBuilder,  
        ShardSearchRequest request = new ShardSearchRequest(  
        sourceBuilder = new SearchSourceBuilder().size(0).aggregation(dateHistogramAggregationBuilder);
        ShardSearchRequest request = new ShardSearchRequest(
        // Case 1: MatchAllQuery and non-nested metric aggregations is nested within keyword term aggregation, should use star tree
            .cluster()  
                -1,
        when(aggregatorFactories.getFactories()).thenReturn(aggregatorFactoriesArray);  
                    expectedContext.getBaseQueryStarTreeFilter().getDimensions(),
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD), new NumericDimension(STATUS)),
        termsAggregationBuilder = terms("term").field(NUMERIC_FIELD).subAggregation(maxAggNoSub);
                            -1
            null,
        MedianAbsoluteDeviationAggregationBuilder medianAgg = medianAbsoluteDeviation("median").field(STATUS);  
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);  
            1,  
                baseQuery,
        );
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
            -1  
        setStarTreeIndexSetting("true");
        // Case 6: Unsupported aggregations is nested within numeric term aggregation, should not use star tree
            0
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
                -1,
                true
            sourceBuilder,  
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            .prepareCreate("test")
        for (Supplier<ValuesSourceAggregationBuilder<?>> firstSupplier : aggregationSuppliers) {
            sourceBuilder,
        SumAggregationBuilder sumAggNoSub = sum("sum").field(STATUS);
    }  
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
        assertStarTreeContext(
        // Case 5: Range Aggregation on field not in ordered dimensions, should not use star tree
                    .field(SIZE, random().nextBoolean() ? random().nextInt(100) : null) // Random size (0-99)
        // Case 3: One of the terms is not an ordered dimension, should not use star tree  
        throw new IllegalArgumentException("Unknown metric aggregation: " + name);  
                searchContext,
        // valid date-range(gte) query
                    ValuesSourceAggregationBuilder<?> secondBucket = secondSupplier.get().subAggregation(metricAgg);  
        sourceBuilder = new SearchSourceBuilder().query(new MatchAllQueryBuilder());
                -1,
                "startree1",
                            .aggregation(firstBucket);  
            default -> new NumericDimension(STATUS);
        CreateIndexRequestBuilder builder = client().admin()
 * For non-resolvable (with star-tree) cases, StarTreeQueryContext is null
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).to(toDateString, false).format(DATE_FORMAT);  
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(multiTermsAgg);
                XContentFactory.jsonBuilder()  
        baseQuery = new MatchAllQueryBuilder();  
        // Case 7: Date histogram with non calendar interval: rounding is null for DateHistogramFactory - cannot use star-tree
        // Case 5: TermQuery and single aggregation, should use star tree, but not initialize query cache
     */
        sourceBuilder = new SearchSourceBuilder().size(0).query(termQueryBuilder).aggregation(sumAggNoSub);
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);  
            1.0f,  
            OriginalIndices.NONE,
            new AliasFilter(null, Strings.EMPTY_ARRAY),
        );  
        Segment segment = mock(Segment.class);
        assertStarTreeContext(  
        starTreeQueryContext.maybeSetCachedNodeIdsForSegment(-1, null);
                searchContext,  
        assertStarTreeContext(request, sourceBuilder, null, -1);  
            1,  
            null,
            .setMapping(
        String NUMERIC_FIELD_NOT_ORDERED_DIMENSION = "rank";
        dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)
                List.of(
            null,  
        );
            ),
import static org.opensearch.search.aggregations.AggregationBuilders.multiTerms;
        createIndex("test", builder);
        String NUMERIC_FIELD_NOT_ORDERED_DIMENSION = "city_name";  
    private static final String TIMESTAMP_FIELD = "@timestamp";  
            ),
        setStarTreeIndexSetting("true");
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
        List<Supplier<ValuesSourceAggregationBuilder<?>>> aggregationSuppliers = getAggregationSuppliers();
        // Case 5: Nested metric aggregations is nested within numeric term aggregation, should not use star tree
                        sourceBuilder,  
        createIndex("test", builder);
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
            .indices()
        QueryBuilder baseQuery;  
                assertEquals(expectedContext.getStarTree().getField(), actualContext.getStarTree().getField());
import org.opensearch.search.aggregations.AggregatorFactories;  
                baseQuery,
        searchContext.aggregations(mockAggregations);  
            indexRequest = client().prepareIndex("test")  
                                getDimensions(
                starTreeFieldConfiguration,
        dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)  
     * Test query parsing for bucket aggregations, with/without numeric term query
        CreateIndexRequestBuilder builder = client().admin()
                                "startree1",
        );
                List.of(new Metric("field", List.of(MetricStat.MAX))),
        assertStarTreeContext(  
 * SPDX-License-Identifier: Apache-2.0
        CompositeDataCubeFieldType compositeDataCubeFieldType = new StarTreeMapper.StarTreeFieldType(
        }
                    false,  
 * The OpenSearch Contributors require contributions made to  
            Collections.emptySet(),
    }  
        QueryBuilder baseQuery;  
        // Case 6: TermQuery and multiple aggregations present, should use star tree & initialize cache  
import org.opensearch.search.internal.AliasFilter;
        return starTreeQueryContext;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;  
            bulkRequest.add(indexRequest);
    private StarTreeQueryContext getStarTreeQueryContext(
                searchContext,
import java.util.Collections;
        when(searchContext.mapperService()).thenReturn(mapperService);
            // Create a document
import java.util.List;  
            .subAggregation(maxAggNoSub);
                );  
/**
            new SearchRequest().allowPartialSearchResults(true),
                "startree1",
        client().admin()
                List.of(new Metric("metricField", List.of(MetricStat.SUM, MetricStat.MAX))),
            List.of(  
            request,
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
            .prepareUpdateSettings()
                baseQuery,  
        rangeAggregationBuilder = range("range").field(NUMERIC_FIELD).addRange(0, 100).subAggregation(maxAggNoSub);
            new SearchRequest().allowPartialSearchResults(true),
        createIndex("test", builder);
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;  
            StarTreeQueryContext actualContext = context.getQueryShardContext().getStarTreeQueryContext();
            1,
            1.0f,
        baseQuery = new MatchAllQueryBuilder();  
                new NumericDimension(STATUS)
        assertStarTreeContext(request, sourceBuilder, null, -1);
                "startree1",  
        else if (name.contains("max")) return MetricStat.MAX;  
        // Adding 2 documents with minimum and maximum timestamp
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
        termsAggregationBuilder = terms("term").field(NUMERIC_FIELD).subAggregation(medianAgg);
            OriginalIndices.NONE,
                        -1  
            )  
                List.of(new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)),
        // Case 2: NumericTermsQuery and non-nested metric aggregations is nested within range aggregation, should use star tree
            1.0f,
                            "startree1",
            ),
                true
import org.opensearch.search.aggregations.startree.StarTreeFilterTests;
    /**  
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  
            -1
        baseQuery = new TermQueryBuilder("sndv", 1);
            .postFilter(new MatchAllQueryBuilder());
            .calendarInterval(DateHistogramInterval.SECOND)  
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, false).to(toDateString, false).format(DATE_FORMAT);  
            .calendarInterval(DateHistogramInterval.DAY)  
import org.opensearch.action.bulk.BulkRequestBuilder;
            );  
import org.opensearch.search.internal.ShardSearchRequest;
    ) throws IOException {
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
 */  
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
        ShardSearchRequest request = new ShardSearchRequest(
                    List.of(new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)),
        rangeAggregationBuilder = range("range").field(NUMERIC_FIELD).addRange(0, 100).subAggregation(sumAggSub);
            .setMapping(NumericTermsAggregatorTests.getExpandedMapping(1, false));
        sourceBuilder = new SearchSourceBuilder().size(0).query(new TermQueryBuilder(STATUS, 1)).aggregation(rangeAggregationBuilder);
                sourceBuilder,  
        // Case 2: MatchAllQuery present but no aggregations, should not use star tree  
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(rangeAggregationBuilder);
import java.io.IOException;  
            for (Supplier<ValuesSourceAggregationBuilder<?>> secondSupplier : aggregationSuppliers) {  
        createIndex("test", builder);  
            1,  
    public void testCacheCreationInStarTreeQueryContext() throws IOException {  
        return Arrays.stream(indices).mapToObj(SearchServiceStarTreeTests::getDimensionByIndex).toList();  
        else if (name.contains("min")) return MetricStat.MIN;
import static org.opensearch.search.aggregations.AggregationBuilders.medianAbsoluteDeviation;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
        assertStarTreeContext(
            List.of(
                List.of(new OrdinalDimension("sndv")),  
        setStarTreeIndexSetting(null);  
                sourceBuilder,  
        // Case 4: NumericTermsQuery and multiple non-nested metric aggregations is within numeric term aggregation, should use star tree
                ),
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),  
import org.apache.lucene.util.FixedBitSet;
            "star_tree",
        StarTreeQueryContext expectedContext,  
            -1  
            -1  
        final String DATE_FORMAT = "strict_date_optional_time||epoch_second";
                throw new RuntimeException(e);  
            case 2 -> new DateDimension(
        assertStarTreeContext(request, sourceBuilder, null, -1);  
                starTreeFieldConfiguration,  
     * Test query parsing for multi-terms aggregations, with/without numeric term query
        // Query resolves to MatchNoneQuery, star-tree query context will not be created
                searchContext,
                List.of(
            long date = nowMillis - random().nextLong(duration180DaysMillis); // Random date within last 180 days  
                "startree",
        String name = agg.getName();
                if (expectedCacheUsage > -1) {
import org.opensearch.search.aggregations.AggregatorFactory;
                new MultiTermsValuesSourceConfig.Builder().setFieldName(NUMERIC_FIELD).build()  
                assertEquals(  
        // Case 4: MatchAllQuery and nested-metric aggregations is nested within date-histogram aggregation, should not use star tree  
import org.opensearch.index.mapper.MapperService;  
import org.opensearch.search.startree.StarTreeQueryContext;  
        SumAggregationBuilder sumAggSub = sum("sum").field(STATUS).subAggregation(maxAggNoSub);  
        setStarTreeIndexSetting(null);
            ),  
                assertEquals(expectedContext.getStarTree().getType(), actualContext.getStarTree().getType());
                -1,
            .indices()  
import org.opensearch.index.shard.IndexShard;
        StarTreeQueryContext expectedContext = getStarTreeQueryContext(  
    ) {  
            -1  
        IndexShard indexShard = indexService.getShard(0);  
                true
            () -> terms("term_status").field(STATUS),
            request,
            } catch (IOException e) {
        assertStarTreeContext(request, sourceBuilder, null, -1);  
 *
 * compatible open source license.
                            searchContext,
            sourceBuilder,
                List.of(new OrdinalDimension("sndv")),
 * Tests for validating query shapes which can be resolved using star-tree index
                    for (ValuesSourceAggregationBuilder<?> metricAgg : aggBuilders) {
        // Case 3: MatchAllQuery and aggregations present, should use star tree
        IndexShard indexShard = indexService.getShard(0);
                true  
                assertThat(context.getQueryShardContext().getStarTreeQueryContext(), nullValue());
        indexRandomDocuments(100);  
                    .field(STATUS, random().nextBoolean() ? random().nextInt(10) : null) // Random status (0-9)
                sourceBuilder,
    private static final String FIELD_NAME = "status";
                        request,
            List.of(
        setStarTreeIndexSetting("true");
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    private void setStarTreeIndexSetting(String value) {
            OriginalIndices.NONE,
import org.opensearch.search.aggregations.AbstractAggregationBuilder;  
        // Case 5: Unsupported sub-aggregation, should not use star tree
        try (ReaderContext reader = searchService.createOrGetReaderContext(request, false)) {
            null
            .prepareCreate("test")
        QueryBuilder baseQuery,  
        sourceBuilder = new SearchSourceBuilder().size(0).query(new TermQueryBuilder(STATUS, 1)).aggregation(rangeAggregationBuilder);
                starTreeFieldConfiguration,
            case 0 -> new NumericDimension(SIZE);
        assertStarTreeContext(  
        ).subAggregation(maxAggNoSub);  
            "startree1",  
        Instant now = Instant.ofEpochMilli(nowMillis);
                -1,
        createIndex("test", builder);
                sourceBuilder,
 * this file be licensed under the Apache-2.0 license or a
                true  
        assertStarTreeContext(request, sourceBuilder, null, -1);
        );
                                sourceBuilder,
                true
            );
        // valid date-range(lt) query
        baseQuery = new TermQueryBuilder(STATUS, 1L);
            new SearchRequest().allowPartialSearchResults(true),  
            .subAggregation(maxAggNoSub);
                    1,
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(dateHistogramAggregationBuilder);
                "startree1",  
                )  
                        .query(new MatchAllQueryBuilder())
                                ),
                    StarTreeFilterTests.DIMENSION_TYPE_MAP,  
        sourceBuilder = new SearchSourceBuilder().size(0).query(new MatchAllQueryBuilder()).aggregation(termsAggregationBuilder);
                    assertStarTreeContext(
                    XContentFactory.jsonBuilder()
    }
                        ),
        assertStarTreeContext(request, sourceBuilder, null, -1);  
        assertStarTreeContext(
        when(aggregatorFactories.getFactories()).thenReturn(new AggregatorFactory[] { null, null });  
            sourceBuilder,  
        ShardSearchRequest request = new ShardSearchRequest(
        fromDateString = formatter.format(Instant.ofEpochMilli(from));
        setStarTreeIndexSetting("true");
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;  
            .prepareCreate("test")
        String compositeFieldName,
                starTreeFieldConfiguration,
            }  
                        List<Metric> metrics = List.of(new Metric(FIELD_NAME, List.of(stat)));  
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)
import org.opensearch.index.mapper.StarTreeMapper;
            getStarTreeQueryContext(
        MedianAbsoluteDeviationAggregationBuilder medianAgg = medianAbsoluteDeviation("median").field(STATUS);
            ),
                baseQuery,  
        QueryBuilder baseQuery;  
        sourceBuilder = new SearchSourceBuilder().size(0).query(new TermQueryBuilder(STATUS, 1)).aggregation(termsAggregationBuilder);
                    new DateDimension(
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));  
        QueryBuilder baseQuery;  
    }
        SearchContextAggregations searchContextAggregations = mock(SearchContextAggregations.class);  
                        .aggregation(firstBucket);
                            ),
                baseQuery,
    }
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
            getStarTreeQueryContext(
        ValuesSourceAggregationBuilder<?>[] aggBuilders = {
            Collections.emptySet(),
            1,  
        baseQuery = new TermQueryBuilder(STATUS, 1);
                searchContext,
        sourceBuilder = new SearchSourceBuilder().size(0).aggregation(dateHistogramAggregationBuilder);
    }
            ),
        assertStarTreeContext(request, sourceBuilder, null, -1);
            1,
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
                StarTreeFilterTests.getExpandedMapping(  
                        TIMESTAMP_FIELD,
                starTreeFieldConfiguration,
                    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0)  
        when(searchContextAggregations.factories()).thenReturn(aggregatorFactories);
                -1,
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(multiTermsAgg);  
        baseQuery = new MatchAllQueryBuilder();
        );  
        String NUMERIC_FIELD = "size";
        assertStarTreeContext(request, sourceBuilder, expectedContext, -1);
            null,
                baseQuery,
        assertStarTreeContext(request, sourceBuilder, null, -1);  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Case 2: MatchAllQuery and non-nested metric aggregations is nested within numeric term aggregation, should use star tree  
            sum("_sum").field(FIELD_NAME),
        baseQuery = null;
            null
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
        AggregatorFactories aggregatorFactories = mock(AggregatorFactories.class);
            OriginalIndices.NONE,  
        String SIZE = "size";  
            indexShard.shardId(),
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
                starTreeFieldConfiguration,
        // Case 4: Nested metric sub-aggregation, should not use star tree
        baseQuery = new TermQueryBuilder("sndv", 1);
            .setSettings(starStreeEnabledIndexSettings)  
                true
        rangeAggregationBuilder = range("range").field(NUMERIC_FIELD).addRange(0, 100).subAggregation(medianAgg);  
        CreateIndexRequestBuilder builder = client().admin()
            -1  
                List.of(
import static org.opensearch.search.aggregations.AggregationBuilders.max;
            -1,
                sourceBuilder,  
        // Case 2: MatchAllQuery present but no aggregations, should not use star tree  
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),  
            () -> range("range").field(STATUS).addRange(0, 10),
            getStarTreeQueryContext(
        // Case 1: MatchAllQuery and a non-nested metric sub-aggregation, should use star tree
            new StarTreeField(compositeFieldName, dimensions, metrics, starTreeFieldConfiguration)  
        );
            request,
     * Test query parsing for date histogram aggregations, with/without numeric term query
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD)),
        String TIMESTAMP_FIELD = "timestamp";
        multiTermsAgg = multiTerms("multi_terms").terms(  
                                true  
        SearchContext searchContext = createSearchContext(indexService);
        setStarTreeIndexSetting("true");
                    DateFieldMapper.Resolution.MILLISECONDS  
            getStarTreeQueryContext(  
                new DateDimension(  
        StarTreeQueryContext starTreeQueryContext = new StarTreeQueryContext(searchContext, baseQuery);
            ),
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
            );
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(dateHistogramAggregationBuilder);  
        setStarTreeIndexSetting("true");
        QueryBuilder baseQuery = new MatchAllQueryBuilder();
        // Case 9: Date histogram with no valid time interval to resolve aggregation - should not use star-tree
            1,  
        setStarTreeIndexSetting(null);
     */
        String KEYWORD_FIELD = "clientip";  
import org.opensearch.index.engine.Segment;  
            .indices()
            ),
        // Case 4: MatchAllQuery and metric aggregations present, but postFilter specified, should not use star tree  
            .subAggregation(maxAggNoSub);
            request,
        from = startOfTodayUTC.toEpochMilli() - TimeUnit.DAYS.toMillis(240);
            .setMapping(NumericTermsAggregatorTests.getExpandedMapping(1, false));
import org.opensearch.action.index.IndexRequestBuilder;
        SumAggregationBuilder sumAggSub = sum("sum").field(STATUS).subAggregation(maxAggNoSub);
        String STATUS = "status";
import org.opensearch.common.xcontent.XContentFactory;
                sourceBuilder,
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP  
            .indices()
        for (Supplier<ValuesSourceAggregationBuilder<?>> firstSupplier : aggregationSuppliers) {
        );
import java.util.Arrays;
import org.opensearch.search.aggregations.AggregationBuilders;
            sourceBuilder,  
        for (int i = 0; i < totalDocs; i++) {
            OriginalIndices.NONE,
        String toDateString = formatter.format(Instant.ofEpochMilli(to));
                sourceBuilder,
        dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)  
import org.opensearch.index.compositeindex.datacube.DateDimension;
        String NUMERIC_FIELD = "size";
            .aggregation(max("test").field("field"))  
                ),  
import static org.mockito.Mockito.mock;
import java.time.temporal.ChronoUnit;  
            indexShard.shardId(),  
        );  
                                    aggregationSuppliers.indexOf(firstSupplier),
import org.opensearch.index.compositeindex.datacube.MetricStat;
                    ValuesSourceAggregationBuilder<?> firstBucket = firstSupplier.get().subAggregation(secondBucket);
                starTreeFieldConfiguration,  
            OriginalIndices.NONE,
        assertStarTreeContext(request, sourceBuilder, null, -1);
    /**
            sourceBuilder,  
            assertTrue(consolidated);
import org.opensearch.search.internal.SearchContext;
            sourceBuilder,
        dateHistogramAggregationBuilder = dateHistogram("by_sec").field(TIMESTAMP_FIELD)
        QueryBuilder queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, true)
        starTreeQueryContext.maybeSetCachedNodeIdsForSegment(0, cachedValues);
import org.opensearch.search.aggregations.Aggregator;
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD)),
                            request,  
                        TIMESTAMP_FIELD,
    public void testDateRangeQuery() throws IOException {
        createIndex("test", builder);
        setStarTreeIndexSetting(null);  
                baseQuery,
        assertStarTreeContext(request, sourceBuilder, null, -1);
                searchContext,
                List.of(new Metric("field", List.of(MetricStat.MAX))),
            searchContext,
        SumAggregationBuilder sumAggSub = sum("sum").field(STATUS).subAggregation(maxAggNoSub);  
                    );
                                    aggregationSuppliers.indexOf(thirdSupplier)
import org.opensearch.common.Rounding;
        );
            OriginalIndices.NONE,  
        );
            indexShard.shardId(),
        );
            OriginalIndices.NONE,
        // Case 1: MatchAllQuery and non-nested metric aggregations is nested within range aggregation, should use star tree
                        ValuesSourceAggregationBuilder<?> thirdBucket = thirdSupplier.get().subAggregation(metricAgg);  
                true
            .setSettings(starStreeEnabledIndexSettings)  
        fromDateString = formatter.format(Instant.ofEpochMilli(from));  
    /**  
        Settings settings = Settings.builder()
            .indices()
        assertStarTreeContext(request, sourceBuilder, null, -1);
        client().admin().indices().prepareForceMerge("test").setMaxNumSegments(1).get();
        );
        termsAggregationBuilder = terms("term").field(KEYWORD_FIELD).subAggregation(maxAggNoSub);  
        );  
            request,
        sourceBuilder = new SearchSourceBuilder().size(0).aggregation(AggregationBuilders.max("test").field("field"));  
import java.time.format.DateTimeFormatter;
        assertStarTreeContext(request, sourceBuilder, null, -1);
                List.of(new NumericDimension(STATUS)),  
        assertStarTreeContext(request, sourceBuilder, null, -1);  
        AggregatorFactories aggregatorFactories = mock(AggregatorFactories.class);
                starTreeFieldConfiguration,
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(dateHistogramAggregationBuilder);
import static org.opensearch.search.aggregations.AggregationBuilders.min;  
        // 3-LEVELS [BUCKET -> BUCKET -> METRIC]
import org.opensearch.search.builder.SearchSourceBuilder;
            1,
            .aggregation(AggregationBuilders.max("test").field("field"))
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
        MaxAggregationBuilder maxAggNoSub = max("max").field(STATUS);
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        }
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, true).format(DATE_FORMAT);  
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder(TIMESTAMP_FIELD, fromDateString);  
        // Case 3: NumericTermsQuery and non-nested metric aggregations is nested within keyword term aggregation, should use star tree
        baseQuery = new MatchAllQueryBuilder();
        );  
            new SearchRequest().allowPartialSearchResults(true),  
import org.opensearch.search.aggregations.startree.DateHistogramAggregatorTests;
            request,  
        CompositeDataCubeFieldType compositeDataCubeFieldType = new StarTreeMapper.StarTreeFieldType(  
        CreateIndexRequestBuilder builder = client().admin()  
            1.0f,
    }
import static org.opensearch.search.aggregations.AggregationBuilders.range;
        }
                DateFieldMapper.Resolution.MILLISECONDS
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
        return switch (index) {  
                    .endObject()  
                sourceBuilder,  
        TermsQueryBuilder termsQueryBuilder = new TermsQueryBuilder(TIMESTAMP_FIELD, List.of(fromDateString, toDateString));
    public void testQueryParsingForRangeAggregations() throws IOException {  
                                starTreeFieldConfiguration,
                -1,
                starTreeFieldConfiguration,  
        assertStarTreeContext(
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX, MetricStat.VALUE_COUNT))),
        dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD).calendarInterval(DateHistogramInterval.DAY);  
                new MultiTermsValuesSourceConfig.Builder().setFieldName(NUMERIC_FIELD).build()  
            -1
import org.opensearch.cluster.metadata.IndexMetadata;
            sourceBuilder,
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
                searchContext,
import org.opensearch.index.query.QueryBuilder;  
            -1  
     */  
        indexRequest = client().prepareIndex("test")
        // Query resolves to MatchNoneQuery, star-tree query context will not be created
        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .calendarInterval(DateHistogramInterval.DAY)  
        setStarTreeIndexSetting(null);  
        ).subAggregation(maxAggNoSub);
        String NUMERIC_FIELD = "size";
        String fromDateString = formatter.format(Instant.ofEpochMilli(from));
                    List<Metric> metrics = List.of(new Metric(FIELD_NAME, List.of(stat)));
        IndexRequestBuilder indexRequest;  
            null
                "startree",
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(termsAggregationBuilder);
            getStarTreeQueryContext(
            getStarTreeQueryContext(  
                true
                        List.of(new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)),
        sourceBuilder = new SearchSourceBuilder().size(0)
                searchContext,
                    StarTreeFilterTests.METRIC_TYPE_MAP
        assertEquals(2, starTreeQueryContext.getAllCachedValues().length);
        // Case 7: No query, metric aggregations present, should use star tree
            new SearchRequest().allowPartialSearchResults(true),
                .setSource(
                                metrics,  
import org.opensearch.index.mapper.DateFieldMapper;
            new SearchRequest().allowPartialSearchResults(true),
        assertEquals(2, starTreeQueryContext.getAllCachedValues().length);  
                    assertEquals(expectedCacheUsage, actualContext.getAllCachedValues().length);
        assertStarTreeContext(
        );
            .execute();  
        String KEYWORD_FIELD = "clientip";
        ShardSearchRequest request = new ShardSearchRequest(
            -1,
            ),
            sourceBuilder,  
                    new DateDimension(  
            1,  
            request,
            1,
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(dateHistogramAggregationBuilder);
            .setSource(  
                    .startObject()
            -1,
        dateHistogramAggregationBuilder = dateHistogram("non_cal").field(TIMESTAMP_FIELD)
                -1,
            ),  
                -1,
    public void testQueryParsingForMultiTermsAggregations() throws IOException {
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, true).to(toDateString, true).format(DATE_FORMAT);
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        StarTreeFieldConfiguration starTreeFieldConfiguration,
        ShardSearchRequest request = new ShardSearchRequest(
                }
            getStarTreeQueryContext(  
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD)),
                        .endObject()
            indexShard.shardId(),
            .setSettings(starStreeEnabledIndexSettings)
        );
                        DateFieldMapper.Resolution.MILLISECONDS  
        );
            .subAggregation(maxAggNoSub);
            .fixedInterval(DateHistogramInterval.DAY)  
        toDateString = formatter.format(Instant.ofEpochMilli(to));
            .setMapping(DateHistogramAggregatorTests.getExpandedMapping(1, false));
            ),
        SearchContext searchContext = createSearchContext(indexService);  
            1,
                    .field(STATUS, random().nextBoolean() ? random().nextInt(10) : null) // Random status (0-9)  
        mapperService.close();
                searchContext,
        String KEYWORD_FIELD = "clientip";
            .aggregation(dateHistogramAggregationBuilder);
            getStarTreeQueryContext(  
        .build();
        from = startOfTodayUTC.toEpochMilli() + TimeUnit.DAYS.toMillis(40);
     */  
            1,
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));  
                );
        setStarTreeIndexSetting("true");
                true
        sourceBuilder = new SearchSourceBuilder().size(0).aggregation(dateHistogramAggregationBuilder);
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                baseQuery,
            .setMapping(NumericTermsAggregatorTests.getExpandedMapping(1, false));
                ),
            .prepareCreate("test")  
        MapperService mapperService = mock(MapperService.class);  
     * Test query parsing for date histogram aggregations on star-tree index when @timestamp field does not exist  
            sourceBuilder,
                List.of(new OrdinalDimension("field")),
        );  
            Collections.emptySet(),
                -1,
            -1
                "startree",
        assertStarTreeContext(request, sourceBuilder, null, -1);  
        );
import org.opensearch.index.query.RangeQueryBuilder;
            request,
        assertStarTreeContext(request, sourceBuilder, null, -1);
            .setMapping(NumericTermsAggregatorTests.getExpandedMapping(1, false));
                "startree1",  
        // Asserting null values are ignored
            new AliasFilter(null, Strings.EMPTY_ARRAY),  
import org.opensearch.search.aggregations.startree.NumericTermsAggregatorTests;  
            .query(baseQuery)  
import static org.hamcrest.CoreMatchers.notNullValue;
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;  
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(AggregationBuilders.max("test").field("field"));  
            max("_max").field(FIELD_NAME),  
                    .field(SIZE, random().nextBoolean() ? random().nextInt(100) : null) // Random size (0-99)
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(rangeAggregationBuilder);
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
            .setSettings(starStreeEnabledIndexSettings)
                    new DateDimension(  
            1.0f,
                                    aggregationSuppliers.indexOf(secondSupplier),  
        StarTreeQueryContext starTreeQueryContext = new StarTreeQueryContext(compositeDataCubeFieldType, baseQuery, cacheSize);
                starTreeFieldConfiguration,
            .aggregation(AggregationBuilders.sum("test2").field("field"));
        assertStarTreeContext(request, sourceBuilder, null, -1);
            queryBuilder,
        long duration180DaysMillis = TimeUnit.DAYS.toMillis(180);  
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
                                new MatchAllQueryBuilder(),
        TermsAggregationBuilder termsAggregationBuilder = terms("term").field(KEYWORD_FIELD).subAggregation(maxAggNoSub);  
                    StarTreeFilterTests.METRIC_TYPE_MAP
                baseQuery,
            true
        sourceBuilder = new SearchSourceBuilder().size(0).aggregation(dateHistogramAggregationBuilder);
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD), new NumericDimension(STATUS)),
            try {  
                baseQuery,
        SearchContext searchContext = createSearchContext(indexService);
        bulkRequest.add(indexRequest);
        bulkRequest.add(indexRequest);
                        List.of(new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)),
            List.of(
            .setMapping(  
import org.opensearch.index.compositeindex.datacube.Metric;
                return ((AbstractAggregationBuilder<?>) af).build(searchContext.getQueryShardContext(), null);
            () -> terms("term_keyword").field(KEYWORD_FIELD).collectMode(Aggregator.SubAggCollectionMode.BREADTH_FIRST)
        assertStarTreeContext(request, sourceBuilder, null, -1);
        FixedBitSet cachedValues = new FixedBitSet(22);  
        assertStarTreeContext(
    private static List<Dimension> getDimensions(int... indices) {
            -1,  
            .indices()
        SearchContext searchContext = createSearchContext(indexService);
        }
            getStarTreeQueryContext(
        assertStarTreeContext(  
            ),
            request,
    }
import org.opensearch.index.compositeindex.datacube.Dimension;  
            .setSource(
        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)  
            null
import java.time.Instant;
        );  
        assertStarTreeContext(  
        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        CreateIndexRequestBuilder builder = client().admin()  
            searchService.doStop();
import org.opensearch.search.internal.ReaderContext;  
            .prepareCreate("test")  
            .calendarInterval(DateHistogramInterval.DAY)
        assertStarTreeContext(
                sourceBuilder,  
            request,
                starTreeFieldConfiguration,  
        );
            .calendarInterval(DateHistogramInterval.DAY)
                true
            getStarTreeQueryContext(  
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
     * Test different aggregations with different combinations of date range query
        MedianAbsoluteDeviationAggregationBuilder medianAgg = medianAbsoluteDeviation("median").field(STATUS);
            -1
package org.opensearch.search;
            getStarTreeQueryContext(  
        assertNull(starTreeQueryContext.getAllCachedValues());  
    /**
        IndexShard indexShard = mock(IndexShard.class);
        // valid date-range(gte,lt) query
        // Case 3: Nested metric aggregations within range aggregation, should not use star tree  
                true  
            )
        SumAggregationBuilder sumAggSub = sum("sum").field(STATUS).subAggregation(maxAggNoSub);  
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
        );
                List.of(new Metric("field", List.of(MetricStat.MAX))),
        // Case 3: MatchAllQuery and non-nested metric aggregations is nested within date-histogram aggregation, should use star tree
            getStarTreeQueryContext(
                sourceBuilder,  
    public void testStarTreeNestedAggregations() throws IOException {
        baseQuery = new MatchAllQueryBuilder();  
            }  
                new MultiTermsValuesSourceConfig.Builder().setFieldName(NUMERIC_FIELD_NOT_ORDERED_DIMENSION).build()
    /**
                sourceBuilder,
            1.0f,  
                    new NumericDimension(STATUS)
                baseQuery,  
        rangeAggregationBuilder = range("range").field(NUMERIC_FIELD).addRange(0, 100).subAggregation(maxAggNoSub);  
        // Query resolves to MatchNoneQuery, star-tree query context will not be created  
        sourceBuilder = new SearchSourceBuilder().size(0).query(new TermQueryBuilder(STATUS, 1)).aggregation(termsAggregationBuilder);
                searchContext,
                -1,
import org.opensearch.index.compositeindex.CompositeIndexSettings;
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                        DateFieldMapper.Resolution.MILLISECONDS
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(multiTermsAgg);  
        // Case 1: No query or aggregations, should not use star tree
        sourceBuilder = new SearchSourceBuilder().size(0).query(new TermQueryBuilder(STATUS, 1)).aggregation(termsAggregationBuilder);  
import static org.hamcrest.CoreMatchers.nullValue;  
                        .field(TIMESTAMP_FIELD, date) // Random timestamp
                TIMESTAMP_FIELD,  
        starTreeQueryContext = new StarTreeQueryContext(searchContext, baseQuery);
                List.of(  
import org.opensearch.index.query.MatchAllQueryBuilder;
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
                }
                sourceBuilder,  
    private MetricStat getMetricStatFromAgg(ValuesSourceAggregationBuilder<?> agg) {  
        assertStarTreeContext(
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
                    }
            SearchContext context = searchService.createContext(reader, request, null, true);  
        baseQuery = new MatchAllQueryBuilder();  
        // Case 10: Date histogram nested with multiple non-nested metric aggregations - should use star-tree
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(multiTermsAgg);
                null,
import org.opensearch.action.search.SearchRequest;  
        // Case 5: MatchAllQuery and non-startree supported aggregation nested within date-histogram aggregation, should not use star tree
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).to(toDateString, false).format(DATE_FORMAT);
        sourceBuilder = new SearchSourceBuilder().size(0)
        int expectedCacheUsage
        );
        baseQuery = new TermQueryBuilder(STATUS, 1);
        );
        SearchService searchService = getInstanceFromNode(SearchService.class);
            sourceBuilder,
                -1,
        baseQuery = new MatchAllQueryBuilder();  
            .prepareCreate("test")  
        }
                            -1,
        if (assertConsolidation) {
                            getStarTreeQueryContext(
        assertStarTreeContext(request, sourceBuilder, null, -1);
        String KEYWORD_FIELD = "clientip";
    private static List<Supplier<ValuesSourceAggregationBuilder<?>>> getAggregationSuppliers() {  
        starTreeQueryContext = new StarTreeQueryContext(compositeDataCubeFieldType, new MatchAllQueryBuilder(), 2);
        CreateIndexRequestBuilder builder = client().admin()  
        );  
            new AliasFilter(null, Strings.EMPTY_ARRAY),  
            ),
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX, MetricStat.VALUE_COUNT))),
        to = startOfTodayUTC.toEpochMilli() - TimeUnit.DAYS.toMillis(200);  
        );
                -1,
        indexRequest = client().prepareIndex("test")
        baseQuery = new MatchAllQueryBuilder();  
                }
        IndexShard indexShard = indexService.getShard(0);  
        MedianAbsoluteDeviationAggregationBuilder medianAgg = medianAbsoluteDeviation("median").field(STATUS);
            )
        starTreeQueryContext = new StarTreeQueryContext(searchContext, baseQuery);
                searchContext,
            .subAggregation(maxAggNoSub);
                        TIMESTAMP_FIELD,
                for (ValuesSourceAggregationBuilder<?> metricAgg : aggBuilders) {
        }).toArray(AggregatorFactory[]::new);
        setStarTreeIndexSetting(null);
            request,  
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD)),  
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(termsAggregationBuilder);
        );
        assertStarTreeContext(request, sourceBuilder, expectedContext, -1);
                        assertStarTreeContext(
            -1,
            getStarTreeQueryContext(
            null
                true  
                "startree1",  
        assertStarTreeContext(  
        assertStarTreeContext(request, sourceBuilder, null, -1);  
            -1  
    }
        // Query cannot be resolved by star-tree
                        ValuesSourceAggregationBuilder<?> secondBucket = secondSupplier.get().subAggregation(thirdBucket);
            1,
            .prepareCreate("test")
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);  
    /**
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),  
        SearchContext searchContext,  
    }
        QueryBuilder baseQuery;  
            Collections.emptySet(),
        when(aggregatorFactories.getFactories()).thenReturn(new AggregatorFactory[] {});  
        SearchContext searchContext = createSearchContext(indexService);
                searchContext,
import org.opensearch.index.query.TermsQueryBuilder;  
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
        return List.of(  
                            new MatchAllQueryBuilder(),
        sourceBuilder = new SearchSourceBuilder().query(baseQuery);
            )
            0
        bulkRequest.get();
                baseQuery,
            -1
        IndexShard indexShard = indexService.getShard(0);
        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
import org.opensearch.indices.IndicesService;
            request,
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
            request,
                        .startObject()  
                starTreeFieldConfiguration,  
            -1,
        String SIZE = "size";  
            new SearchRequest().allowPartialSearchResults(true),  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        int cacheSize,  
                starTreeFieldConfiguration,  
                    .startObject()
    }
                    .endObject()
    }
/*  
            .setSettings(starStreeEnabledIndexSettings)  
            Collections.emptySet(),  
        termsAggregationBuilder = terms("term").field(NUMERIC_FIELD).subAggregation(sumAggSub);  
                "startree1",  
                    assertNull(actualContext.getAllCachedValues());
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(AggregationBuilders.max("test").field("field"));  
            .to(toDateString, false)  
import org.opensearch.search.aggregations.SearchContextAggregations;
                    actualContext.getBaseQueryStarTreeFilter().getDimensions()
        assertStarTreeContext(request, sourceBuilder, null, -1);
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
            null,  
            );  
                    new NumericDimension(STATUS)
    public void testQueryParsingForMetricAggregations() throws IOException {
        RangeAggregationBuilder rangeAggregationBuilder = range("range").field(NUMERIC_FIELD).addRange(0, 10).subAggregation(maxAggNoSub);
    public void testQueryParsingForDateHistogramAggregations() throws IOException {  
            -1,
        // Assert correct cached value is returned  
            indexShard.shardId(),
        assertStarTreeContext(request, sourceBuilder, null, -1);
                ),  
            null,  
        MaxAggregationBuilder maxAggNoSub = max("max").field(STATUS);
        // Case 1: No query or aggregations, should not use star tree
        boolean assertConsolidation
        assertStarTreeContext(request, sourceBuilder, null, -1);
                            starTreeFieldConfiguration,  
            1,
import static org.mockito.Mockito.when;
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
            .prepareCreate("test")  
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
                    MetricStat stat = getMetricStatFromAgg(metricAgg);
                                searchContext,  
    public void testQueryParsingForBucketAggregations() throws IOException {
        );
        IndexShard indexShard = indexService.getShard(0);  
            null,  
                true
            -1  
        assertStarTreeContext(request, sourceBuilder, expectedContext, -1);  
        baseQuery = new MatchAllQueryBuilder();
                true
import static org.opensearch.search.aggregations.AggregationBuilders.count;
        SearchSourceBuilder sourceBuilder,
        when(mapperService.getCompositeFieldTypes()).thenReturn(Set.of(compositeDataCubeFieldType));  
            ),
                starTreeFieldConfiguration  
        );
        boolean consolidated = starTreeQueryContext.consolidateAllFilters(searchContext);  
        else if (name.contains("count")) return MetricStat.VALUE_COUNT;
            sourceBuilder,  
        rangeAggregationBuilder = range("range").field(NUMERIC_FIELD_NOT_ORDERED_DIMENSION).addRange(0, 100).subAggregation(medianAgg);
            .setSettings(starStreeEnabledIndexSettings)
                "startree1",
        );  
        sourceBuilder = new SearchSourceBuilder().size(0).query(termsQueryBuilder).aggregation(sumAggNoSub);
        // Case 4: Unsupported aggregations within range aggregation, should not use star tree
            getStarTreeQueryContext(
        MaxAggregationBuilder maxAggNoSub = max("max").field(STATUS);
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;  
        String TIMESTAMP_FIELD = "timestamp";
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),  
        assertStarTreeContext(
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, false).to(toDateString, true).format(DATE_FORMAT);
            indexShard.shardId(),
        IndexShard indexShard = indexService.getShard(0);  
            .calendarInterval(DateHistogramInterval.DAY)
import org.opensearch.index.IndexService;  
     */
            .query(new MatchAllQueryBuilder())
        MaxAggregationBuilder sumAggNoSub = max("sum").field(STATUS);
        // Query cannot be resolved by star-tree
        termsAggregationBuilder = terms("term").field(NUMERIC_FIELD).subAggregation(maxAggNoSub).subAggregation(sumAggNoSub);  
                            sourceBuilder,
                List.of(new OrdinalDimension(KEYWORD_FIELD), new NumericDimension(NUMERIC_FIELD)),
     * Test query parsing for non-nested metric aggregations, with/without numeric term query
        long to = startOfTodayUTC.toEpochMilli() - TimeUnit.DAYS.toMillis(20);  
        SearchContextAggregations mockAggregations = mock(SearchContextAggregations.class);
        List<Metric> metrics,
            request,
        List<Dimension> dimensions,
import java.util.function.Supplier;  
        // Case 8: Date histogram with no metric aggregation - does not use star-tree
        client().admin().indices().prepareRefresh("test").get();  
    }
            .subAggregation(sumAggNoSub);  
                searchContext,
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  
        BulkRequestBuilder bulkRequest = client().prepareBulk();
    }
            ),  
                        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0)
            1,
        ShardSearchRequest request,
                )
        CreateIndexRequestBuilder builder = client().admin()
                    new NumericDimension(STATUS)  
                            true
        assertEquals(2, starTreeQueryContext.getAllCachedValues().length);  
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD), new NumericDimension(STATUS)),  
            () -> terms("term_size").field(SIZE),
            .setTransientSettings(Settings.builder().put(CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING.getKey(), value).build())
                        DateFieldMapper.Resolution.MILLISECONDS  
                            .query(new MatchAllQueryBuilder())
            Collections.emptySet(),  
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
                "startree1",
                sourceBuilder,  
        setStarTreeIndexSetting(null);  
        dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)
        baseQuery = new MatchAllQueryBuilder();
                            getDimensions(aggregationSuppliers.indexOf(firstSupplier), aggregationSuppliers.indexOf(secondSupplier)),  
            .indices()
            ),  
        MaxAggregationBuilder maxAggNoSub = max("max").field(STATUS);
            .setSettings(settings)
            min("_min").field(FIELD_NAME),
        baseQuery = new TermQueryBuilder(STATUS, 1);
    private static final String SIZE = "size";
                    .field(TIMESTAMP_FIELD, nowMillis - duration180DaysMillis)
        // Case 6: NumericTermQuery and date-histogram aggregation present, should use star tree
}
            starTreeFieldConfiguration,
            new AliasFilter(null, Strings.EMPTY_ARRAY),  
        IndexShard indexShard = indexService.getShard(0);
        SearchContext searchContext = createSearchContext(indexService);  
        multiTermsAgg = multiTerms("multi_terms").terms(
            new AliasFilter(null, Strings.EMPTY_ARRAY),
            List.of(
                        List.of(new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)),  
        SearchContext searchContext = createSearchContext(indexService);
                    StarTreeFilterTests.DIMENSION_TYPE_MAP,
            sourceBuilder,
        long from = startOfTodayUTC.toEpochMilli() - TimeUnit.DAYS.toMillis(80);
                starTreeFieldConfiguration,  
    private static final String STATUS = "status";
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
            .setMapping(DateHistogramAggregatorTests.getExpandedMapping(1, false));
        // invalid date-range(gte,lte) query  
            null
            compositeFieldName,
        final long nowMillis = System.currentTimeMillis();  
                    1,
                baseQuery,
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));  
                -1,  
            )
        createIndex("test", builder);
                List.of(new OrdinalDimension(KEYWORD_FIELD), new NumericDimension(NUMERIC_FIELD), new NumericDimension(STATUS)),  
            indexShard.shardId(),  
                true  
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
import org.opensearch.core.common.Strings;
                StarTreeFilterTests.getExpandedMapping(
        );  
                "startree",  
                ),
        assertNull(starTreeQueryContext.maybeGetCachedNodeIdsForSegment(0));
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
                    TIMESTAMP_FIELD,
import org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregationBuilder;  
