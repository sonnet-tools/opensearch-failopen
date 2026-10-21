import org.opensearch.index.compositeindex.datacube.Dimension;
        rangeAggregationBuilder = range("range").field(NUMERIC_FIELD).addRange(0, 100).subAggregation(maxAggNoSub);
        IndexShard indexShard = indexService.getShard(0);
    }
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
            } else {
            .subAggregation(maxAggNoSub);
            sourceBuilder,
            sourceBuilder,
    }
import static org.opensearch.search.aggregations.AggregationBuilders.min;
            new SearchRequest().allowPartialSearchResults(true),
            -1
        dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)
                assertEquals(
            ),
        List<Supplier<ValuesSourceAggregationBuilder<?>>> aggregationSuppliers = getAggregationSuppliers();
import org.opensearch.search.internal.SearchContext;
        assertStarTreeContext(
            searchContext,
import org.opensearch.index.IndexService;
                -1,
                return ((AbstractAggregationBuilder<?>) af).build(searchContext.getQueryShardContext(), null);
            new SearchRequest().allowPartialSearchResults(true),
import static org.hamcrest.CoreMatchers.notNullValue;
            ),
        baseQuery = new MatchAllQueryBuilder();
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(termsAggregationBuilder);
                    new DateDimension(
            ),
            getStarTreeQueryContext(
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD)),
            case 0 -> new NumericDimension(SIZE);
            .format("strict_date_optional_time||epoch_second");
                    .field(SIZE, random().nextBoolean() ? random().nextInt(100) : null) // Random size (0-99)
    public void testStarTreeNestedAggregations() throws IOException {
        );
            null
        SearchService searchService = getInstanceFromNode(SearchService.class);
    }
        );
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
            sourceBuilder,
        // Query cannot be resolved by star-tree
                        .aggregation(firstBucket);
        QueryBuilder baseQuery = new MatchAllQueryBuilder();
        StarTreeQueryContext starTreeQueryContext = new StarTreeQueryContext(searchContext, baseQuery);
        // Case 2: MatchAllQuery present but no aggregations, should not use star tree
                                getDimensions(
        assertStarTreeContext(request, sourceBuilder, null, -1);
        Segment segment = mock(Segment.class);
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
                true
                baseQuery,
            1,
                            ),
                    .field(TIMESTAMP_FIELD, nowMillis)
        );
        String KEYWORD_FIELD = "clientip";
            request,
        assertEquals(2, starTreeQueryContext.getAllCachedValues().length);
                    DateFieldMapper.Resolution.MILLISECONDS
        indexRequest = client().prepareIndex("test")
        // Case 3: NumericTermsQuery and non-nested metric aggregations is nested within keyword term aggregation, should use star tree
        assertStarTreeContext(
                ),
            ),
            sourceBuilder,
            new SearchRequest().allowPartialSearchResults(true),
        assertStarTreeContext(request, sourceBuilder, null, -1);
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        bulkRequest.get();
import java.time.temporal.ChronoUnit;
                    expectedContext.getBaseQueryStarTreeFilter().getDimensions(),
        assertStarTreeContext(
            null,
            ),
        );
import static org.opensearch.search.aggregations.AggregationBuilders.max;
    }
            OriginalIndices.NONE,
    public void testQueryParsingForMetricAggregations() throws IOException {
                    StarTreeFilterTests.METRIC_TYPE_MAP
                List.of(new Metric("field", List.of(MetricStat.MAX))),
        Instant startOfTodayUTC = now.truncatedTo(ChronoUnit.DAYS);
        if (assertConsolidation) {
        assertStarTreeContext(
        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
                List.of(new OrdinalDimension("sndv")),
            null
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
        CompositeDataCubeFieldType compositeDataCubeFieldType = new StarTreeMapper.StarTreeFieldType(
        // Case 1: No query or aggregations, should not use star tree
                        List.of(new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)),
        MedianAbsoluteDeviationAggregationBuilder medianAgg = medianAbsoluteDeviation("median").field(STATUS);
        );
        createIndex("test", builder);
        long nowMillis = Instant.now().toEpochMilli();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(termsAggregationBuilder);
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
        );
        setStarTreeIndexSetting(null);
            }
                baseQuery,
        // Case 4: MatchAllQuery and metric aggregations present, but postFilter specified, should not use star tree
        MaxAggregationBuilder sumAggNoSub = max("sum").field(STATUS);
            indexShard.shardId(),
        assertStarTreeContext(request, sourceBuilder, null, -1);
                -1,
            null,
                    StarTreeFilterTests.DIMENSION_TYPE_MAP,
                List.of(new Metric("metricField", List.of(MetricStat.SUM, MetricStat.MAX))),
            -1
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX, MetricStat.VALUE_COUNT))),
        String toDateString = formatter.format(Instant.ofEpochMilli(to));
            sourceBuilder,
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).to(toDateString, false).format(DATE_FORMAT);
            ),
        String compositeFieldName,
            1,
        client().admin()
        MedianAbsoluteDeviationAggregationBuilder medianAgg = medianAbsoluteDeviation("median").field(STATUS);
                sourceBuilder,
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
import java.io.IOException;
            )
                        TIMESTAMP_FIELD,
            assertTrue(consolidated);
    }
        );
        multiTermsAgg = multiTerms("multi_terms").terms(
import org.opensearch.index.compositeindex.CompositeIndexSettings;
 */
        createIndex("test", builder);
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD), new NumericDimension(STATUS)),
    /**
                                    aggregationSuppliers.indexOf(secondSupplier),
            request,
                starTreeFieldConfiguration,
            try {
 *
            );
        baseQuery = new MatchAllQueryBuilder();
            sourceBuilder,
import org.opensearch.index.compositeindex.datacube.DateDimension;
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, true).format(DATE_FORMAT);
                            searchContext,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        TIMESTAMP_FIELD,
            }
        assertStarTreeContext(request, sourceBuilder, expectedContext, -1);
                    List.of(new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)),
                        .query(new MatchAllQueryBuilder())
                    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0)
        }
        termsAggregationBuilder = terms("term").field(NUMERIC_FIELD).subAggregation(maxAggNoSub);
                                    aggregationSuppliers.indexOf(thirdSupplier)
     */
            sourceBuilder,
        dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD).calendarInterval(DateHistogramInterval.DAY);
    }
            sourceBuilder,
                starTreeFieldConfiguration,
            request,
            .calendarInterval(DateHistogramInterval.DAY)
        // Case 3: One of the terms is not an ordered dimension, should not use star tree
                starTreeFieldConfiguration
            sum("_sum").field(FIELD_NAME),
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
import org.opensearch.action.index.IndexRequestBuilder;
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        // Assert correct cached value is returned
            .calendarInterval(DateHistogramInterval.DAY)
        // Case 1: No query or aggregations, should not use star tree
import org.opensearch.search.aggregations.AggregationBuilders;
        }
            StarTreeQueryContext actualContext = context.getQueryShardContext().getStarTreeQueryContext();
                sourceBuilder,
        termsAggregationBuilder = terms("term").field(NUMERIC_FIELD).subAggregation(medianAgg);
            new SearchRequest().allowPartialSearchResults(true),
            // Create a document
            request,
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
            null,
            1.0f,
        sourceBuilder = new SearchSourceBuilder().size(0).query(new TermQueryBuilder(STATUS, 1)).aggregation(rangeAggregationBuilder);
            1,
import org.opensearch.cluster.metadata.IndexMetadata;
            -1,
                "startree1",
                sourceBuilder,
            );
        SearchContext searchContext = createSearchContext(indexService);
                sourceBuilder,
                true
        return List.of(
            () -> dateHistogram("by_day").field(TIMESTAMP_FIELD).calendarInterval(DateHistogramInterval.DAY),
        assertStarTreeContext(request, sourceBuilder, null, -1);
        assertNull(starTreeQueryContext.getAllCachedValues());
                                "startree1",
import org.opensearch.search.aggregations.startree.DateHistogramAggregatorTests;
            ),
import org.opensearch.search.aggregations.AggregatorFactories;
        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Case 2: MatchAllQuery and non-nested metric aggregations is nested within numeric term aggregation, should use star tree
        );
            -1
    }
            new StarTreeField(compositeFieldName, dimensions, metrics, starTreeFieldConfiguration)
        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
                assertThat(actualContext, notNullValue());
            -1,
        SearchSourceBuilder sourceBuilder,
                baseQuery,
                new DateDimension(
        createIndex("test", builder);
        else if (name.contains("count")) return MetricStat.VALUE_COUNT;
        baseQuery = new TermQueryBuilder(STATUS, 1L);
        SearchContext searchContext = createSearchContext(indexService);
        IndexShard indexShard = mock(IndexShard.class);
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
            .setMapping(NumericTermsAggregatorTests.getExpandedMapping(1, false));
        return Arrays.stream(indices).mapToObj(SearchServiceStarTreeTests::getDimensionByIndex).toList();
import org.opensearch.common.xcontent.XContentFactory;
                List.of(new OrdinalDimension("sndv")),
            List.of(
            .subAggregation(sumAggNoSub);
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
        StarTreeQueryContext expectedContext = getStarTreeQueryContext(
            true
import java.time.Instant;
        );
        // Case 3: MatchAllQuery and non-nested metric aggregations is nested within date-histogram aggregation, should use star tree
        AggregatorFactory[] aggregatorFactoriesArray = sourceBuilder.aggregations().getAggregatorFactories().stream().map(af -> {
                    new DateDimension(
        MultiTermsAggregationBuilder multiTermsAgg = multiTerms("multi_terms").terms(
            "star_tree",
            request,
        sourceBuilder = new SearchSourceBuilder().size(0).query(new TermQueryBuilder(STATUS, 1)).aggregation(rangeAggregationBuilder);
        QueryBuilder baseQuery;
        }
                    ValuesSourceAggregationBuilder<?> secondBucket = secondSupplier.get().subAggregation(metricAgg);
                List.of(new NumericDimension(STATUS)),
            1,
            new SearchRequest().allowPartialSearchResults(true),
                null,
    }
        // Case 6: NumericTermQuery and date-histogram aggregation present, should use star tree
        rangeAggregationBuilder = range("range").field(NUMERIC_FIELD).addRange(0, 100).subAggregation(sumAggSub);
                new NumericDimension(STATUS)
                sourceBuilder,
            -1
        SumAggregationBuilder sumAggNoSub = sum("sum").field(STATUS);
                            .aggregation(firstBucket);
                TIMESTAMP_FIELD,
                -1,
        // Case 4: Nested metric sub-aggregation, should not use star tree
        StarTreeQueryContext starTreeQueryContext = new StarTreeQueryContext(compositeDataCubeFieldType, baseQuery, cacheSize);
                baseQuery,
                    .startObject()
                            -1
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD)),
        // Case 3: MatchAllQuery and aggregations present, should use star tree
import org.opensearch.search.internal.AliasFilter;
                starTreeFieldConfiguration,
        baseQuery = new MatchAllQueryBuilder();
        baseQuery = new MatchAllQueryBuilder();
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
        assertStarTreeContext(request, sourceBuilder, null, -1);
        assertStarTreeContext(
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, false).to(toDateString, true).format(DATE_FORMAT);
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
import org.opensearch.index.query.QueryBuilder;
                sourceBuilder,
            .setSettings(starStreeEnabledIndexSettings)
                            request,
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)
            request,
        when(aggregatorFactories.getFactories()).thenReturn(new AggregatorFactory[] {});
            List.of(
                    List<Metric> metrics = List.of(new Metric(FIELD_NAME, List.of(stat)));
                                sourceBuilder,
        baseQuery = new MatchAllQueryBuilder();
import java.util.List;
                baseQuery,
                "startree1",
                                metrics,
            .setSettings(starStreeEnabledIndexSettings)
                            sourceBuilder,
            .query(new MatchAllQueryBuilder())
            indexShard.shardId(),
            .setMapping(DateHistogramAggregatorTests.getExpandedMapping(1, false));
        sourceBuilder = new SearchSourceBuilder().size(0).query(termsQueryBuilder).aggregation(sumAggNoSub);
        mapperService.close();
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(rangeAggregationBuilder);
            getStarTreeQueryContext(
        StarTreeQueryContext expectedContext,
                new MultiTermsValuesSourceConfig.Builder().setFieldName(NUMERIC_FIELD).build()
        // Case 7: No query, metric aggregations present, should use star tree
            getStarTreeQueryContext(
                searchContext,
        SearchContext searchContext = createSearchContext(indexService);
                    ),
                "star_tree",
            starTreeFieldConfiguration,
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(rangeAggregationBuilder);
            Collections.emptySet(),
        ShardSearchRequest request,
        boolean consolidated = starTreeQueryContext.consolidateAllFilters(searchContext);
        }).toArray(AggregatorFactory[]::new);
                        MetricStat stat = getMetricStatFromAgg(metricAgg);
                "startree",
            request,
                starTreeFieldConfiguration,
                }
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(dateHistogramAggregationBuilder);
        starTreeQueryContext = new StarTreeQueryContext(searchContext, baseQuery);
     * Test different aggregations with different combinations of date range query
        IndexShard indexShard = indexService.getShard(0);
                new MultiTermsValuesSourceConfig.Builder().setFieldName(NUMERIC_FIELD_NOT_ORDERED_DIMENSION).build()
        starTreeQueryContext.maybeSetCachedNodeIdsForSegment(0, cachedValues);
                "startree1",
        SumAggregationBuilder sumAggSub = sum("sum").field(STATUS).subAggregation(maxAggNoSub);
import org.opensearch.index.compositeindex.datacube.Metric;
        assertStarTreeContext(request, sourceBuilder, null, -1);
            case 2 -> new DateDimension(
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
                "startree1",
            1.0f,
                                -1,
        assertStarTreeContext(request, sourceBuilder, null, -1);
import java.util.Arrays;
                                searchContext,
        );
        SearchContext searchContext,
            1,
        TermsQueryBuilder termsQueryBuilder = new TermsQueryBuilder(TIMESTAMP_FIELD, List.of(fromDateString, toDateString));
        );
        setStarTreeIndexSetting(null);
        assertStarTreeContext(
        assertStarTreeContext(request, sourceBuilder, null, -1);
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
 * compatible open source license.
            getStarTreeQueryContext(
        createIndex("test", builder);
            default -> new NumericDimension(STATUS);
        MedianAbsoluteDeviationAggregationBuilder medianAgg = medianAbsoluteDeviation("median").field(STATUS);
        sourceBuilder = new SearchSourceBuilder().size(0).query(new TermQueryBuilder(STATUS, 1)).aggregation(termsAggregationBuilder);
                true
            -1,
                }
                        request,
    }
        assertStarTreeContext(request, sourceBuilder, null, -1);
        if (name.contains("sum")) return MetricStat.SUM;
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
        IndexRequestBuilder indexRequest;
                    .endObject()
        SearchContext searchContext = createSearchContext(indexService);
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
        setStarTreeIndexSetting(null);
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(dateHistogramAggregationBuilder);
                sourceBuilder,
            .indices()
            1.0f,
        baseQuery = new MatchAllQueryBuilder();
                -1,
        }
            .subAggregation(medianAgg);
            1,
                "startree1",
import java.util.concurrent.TimeUnit;
            searchService.doStop();
            -1
        request.source(sourceBuilder);
                "startree",
                );
            .prepareCreate("test")
 * Tests for validating query shapes which can be resolved using star-tree index
            );
        multiTermsAgg = multiTerms("multi_terms").terms(
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
    /**
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
                true
        setStarTreeIndexSetting(null);
            Collections.emptySet(),
        // Case 2: Numeric term query and a non-nested metric sub-aggregation, should use star tree
        rangeAggregationBuilder = range("range").field(NUMERIC_FIELD_NOT_ORDERED_DIMENSION).addRange(0, 100).subAggregation(medianAgg);
    }
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(multiTermsAgg);
            .indices()
        dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)
            null
        assertStarTreeContext(
                XContentFactory.jsonBuilder()
        assertStarTreeContext(request, sourceBuilder, expectedContext, -1);
                -1,
import org.opensearch.common.settings.Settings;
        MaxAggregationBuilder maxAggNoSub = max("max").field(STATUS);
            long date = nowMillis - random().nextLong(duration180DaysMillis); // Random date within last 180 days
        baseQuery = new MatchAllQueryBuilder();
                -1,
                    assertEquals(expectedCacheUsage, actualContext.getAllCachedValues().length);
                1,
        );
            -1
        ).subAggregation(maxAggNoSub);
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
    public void testCacheCreationInStarTreeQueryContext() throws IOException {
        String SIZE = "size";
import org.opensearch.index.query.MatchAllQueryBuilder;
            getStarTreeQueryContext(
                -1,
            request,
                        ValuesSourceAggregationBuilder<?> thirdBucket = thirdSupplier.get().subAggregation(metricAgg);
                true
                ),
                List.of(new OrdinalDimension(KEYWORD_FIELD), new NumericDimension(NUMERIC_FIELD)),
        setStarTreeIndexSetting("true");
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
    /**
        bulkRequest.add(indexRequest);
            1,
                    new NumericDimension(STATUS)
        // Case 1: MatchAllQuery and non-nested metric aggregations is nested within range aggregation, should use star tree
            .setMapping(NumericTermsAggregatorTests.getExpandedMapping(1, false));
            1,
import static org.opensearch.search.aggregations.AggregationBuilders.medianAbsoluteDeviation;
        );
        sourceBuilder = new SearchSourceBuilder().size(0).query(new TermQueryBuilder(STATUS, 1)).aggregation(termsAggregationBuilder);
            List.of(
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD)),
                sourceBuilder,
            .to(toDateString, false)
                sourceBuilder,
            OriginalIndices.NONE,
                StarTreeFilterTests.getExpandedMapping(
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(rangeAggregationBuilder);
            ),
        );
        String fromDateString = formatter.format(Instant.ofEpochMilli(from));
                searchContext,
                searchContext,
            List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
        from = startOfTodayUTC.toEpochMilli() + TimeUnit.DAYS.toMillis(40);
            max("_max").field(FIELD_NAME),
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
        // Asserting null values are ignored
            indexShard.shardId(),
            OriginalIndices.NONE,
                starTreeFieldConfiguration,
                    actualContext.getBaseQueryStarTreeFilter().getDimensions()
        assertStarTreeContext(request, sourceBuilder, null, -1);
            .calendarInterval(DateHistogramInterval.DAY)
        );
        // 3-LEVELS [BUCKET -> BUCKET -> METRIC]
            .setTransientSettings(Settings.builder().put(CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING.getKey(), value).build())
                List.of(new Metric("field", List.of(MetricStat.MAX))),
            new AliasFilter(null, Strings.EMPTY_ARRAY),
            indexShard.shardId(),
    public void testQueryParsingForDateHistogramAggregations() throws IOException {
                assertEquals(expectedContext.getStarTree().getType(), actualContext.getStarTree().getType());
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
        );
        baseQuery = new TermQueryBuilder(STATUS, 1);
        setStarTreeIndexSetting("true");
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            OriginalIndices.NONE,
        QueryBuilder baseQuery;
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(rangeAggregationBuilder);
                        getStarTreeQueryContext(
import org.apache.lucene.util.FixedBitSet;
     */
                searchContext,
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD)),
            .query(new MatchAllQueryBuilder())
        String TIMESTAMP_FIELD = "timestamp";
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
import org.opensearch.search.aggregations.startree.StarTreeFilterTests;
        );
        setStarTreeIndexSetting(null);
            sourceBuilder,
            getStarTreeQueryContext(
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
                        -1
                baseQuery,
                            "startree1",
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(rangeAggregationBuilder).aggregation(maxAggNoSub);
            new AliasFilter(null, Strings.EMPTY_ARRAY),
        // Case 8: Date histogram with no metric aggregation - does not use star-tree
import java.util.Set;
        SumAggregationBuilder sumAggSub = sum("sum").field(STATUS).subAggregation(maxAggNoSub);
                        DateFieldMapper.Resolution.MILLISECONDS
                baseQuery,
        // Case 5: Nested metric aggregations is nested within numeric term aggregation, should not use star tree
            .prepareCreate("test")
            getStarTreeQueryContext(
                List.of(
                        sourceBuilder,
                )
                -1,
                baseQuery,
import static org.opensearch.search.aggregations.AggregationBuilders.range;
    /**
        when(searchContext.mapperService()).thenReturn(mapperService);
            0
import static org.opensearch.search.aggregations.AggregationBuilders.count;
            ),
    private static final String FIELD_NAME = "status";
            new SearchRequest().allowPartialSearchResults(true),
                            getDimensions(aggregationSuppliers.indexOf(firstSupplier), aggregationSuppliers.indexOf(secondSupplier)),
        // Case 2: NumericTermsQuery and non-nested metric aggregations is nested within range aggregation, should use star tree
import java.util.function.Supplier;
        sourceBuilder = new SearchSourceBuilder().size(0).query(new TermQueryBuilder(STATUS, 1)).aggregation(termsAggregationBuilder);
        client().admin().indices().prepareRefresh("test").get();
    public void indexRandomDocuments(int totalDocs) throws IOException {
    public void testQueryParsingForBucketAggregations() throws IOException {
            .prepareCreate("test")
            1.0f,
            "startree1",
                starTreeFieldConfiguration,
                -1,
        );
    /**
    }
        ShardSearchRequest request = new ShardSearchRequest(
                                new MatchAllQueryBuilder(),
        multiTermsAgg = multiTerms("multi_terms").terms(
        MaxAggregationBuilder maxAggNoSub = max("max").field(STATUS);
        MaxAggregationBuilder maxAggNoSub = max("max").field(STATUS);
        // valid date-range(lt) query
import org.opensearch.search.aggregations.startree.NumericTermsAggregatorTests;
                starTreeFieldConfiguration,
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
import org.opensearch.action.OriginalIndices;
                List.of(
            null
        toDateString = formatter.format(Instant.ofEpochMilli(to));
            .setSettings(starStreeEnabledIndexSettings)
            .setMapping(
            .aggregation(AggregationBuilders.sum("test2").field("field"));
        setStarTreeIndexSetting(null);
        setStarTreeIndexSetting("true");
                searchContext,
            request,
        baseQuery = new MatchAllQueryBuilder();
            } catch (IOException e) {
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
            Collections.emptySet(),
            .setSettings(starStreeEnabledIndexSettings)
            new AliasFilter(null, Strings.EMPTY_ARRAY),
            () -> terms("term_status").field(STATUS),
            null,
        assertStarTreeContext(
        QueryBuilder baseQuery;
import org.opensearch.indices.IndicesService;
        );
        );
            null
            )
        throw new IllegalArgumentException("Unknown metric aggregation: " + name);
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
    private static final String STATUS = "status";
            .subAggregation(maxAggNoSub)
        ).subAggregation(sumAggSub);
        assertStarTreeContext(
import java.util.Collections;
        Instant now = Instant.ofEpochMilli(nowMillis);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    ),
import org.opensearch.search.startree.StarTreeQueryContext;
        fromDateString = formatter.format(Instant.ofEpochMilli(from));
            -1
        QueryBuilder baseQuery;
            .subAggregation(maxAggNoSub);
import org.opensearch.common.Rounding;
        SumAggregationBuilder sumAggSub = sum("sum").field(STATUS).subAggregation(maxAggNoSub);
                sourceBuilder,
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
        CreateIndexRequestBuilder builder = client().admin()
        SearchSourceBuilder sourceBuilder,
/*
            ),
            if (expectedContext == null) {
            request,
                    .endObject()
        // 4-LEVELS [BUCKET -> BUCKET -> BUCKET -> METRIC]
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
        ShardSearchRequest request = new ShardSearchRequest(
        when(mockAggregations.factories()).thenReturn(aggregatorFactories);
            for (Supplier<ValuesSourceAggregationBuilder<?>> secondSupplier : aggregationSuppliers) {
            .subAggregation(sumAggSub);
            ),
                "startree1",
        Settings settings = Settings.builder()
            -1
        setStarTreeIndexSetting(null);
import org.opensearch.index.mapper.StarTreeMapper;
                            -1,
            getStarTreeQueryContext(
import org.opensearch.index.compositeindex.datacube.NumericDimension;
        // Case 1: MatchAllQuery and a non-nested metric sub-aggregation, should use star tree
 */
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
        assertStarTreeContext(
        // Case 4: MatchAllQuery and nested-metric aggregations is nested within date-histogram aggregation, should not use star tree
        // Case 1: MatchAllQuery and non-nested metric aggregations is nested within keyword term aggregation, should use star tree
            -1,
                starTreeFieldConfiguration,
     * Test query parsing for non-nested metric aggregations, with/without numeric term query
            -1
        rangeAggregationBuilder = range("range").field(NUMERIC_FIELD).addRange(0, 100).subAggregation(maxAggNoSub);
            count("_count").field(FIELD_NAME), };
            getStarTreeQueryContext(
        );
            getStarTreeQueryContext(
        baseQuery = new TermQueryBuilder("sndv", 1);
        // Query cannot be resolved by star-tree
                }
        searchContext.close();
        sourceBuilder = new SearchSourceBuilder().query(baseQuery);
 * SPDX-License-Identifier: Apache-2.0
                -1,
        baseQuery = new TermQueryBuilder("sndv", 1);
        long from = startOfTodayUTC.toEpochMilli() - TimeUnit.DAYS.toMillis(80);
        sourceBuilder = new SearchSourceBuilder().size(0).aggregation(dateHistogramAggregationBuilder);
        String KEYWORD_FIELD = "clientip";
        // Case 6: Unsupported aggregations is nested within numeric term aggregation, should not use star tree
import org.opensearch.search.internal.ReaderContext;
        assertStarTreeContext(
        assertStarTreeContext(request, sourceBuilder, null, -1);
            .indices()
        assertStarTreeContext(request, sourceBuilder, null, -1);
        int cacheSize,
                true
        boolean assertConsolidation
                    XContentFactory.jsonBuilder()
            .prepareCreate("test")
            indexShard.shardId(),
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
    private static final String TIMESTAMP_FIELD = "@timestamp";
import org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregationBuilder;
            () -> range("range").field(STATUS).addRange(0, 10),
        rangeAggregationBuilder = range("range").field(NUMERIC_FIELD).addRange(0, 100).subAggregation(medianAgg);
                    new Metric(STATUS, List.of(MetricStat.MAX, MetricStat.SUM))
        QueryBuilder queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, true)
                XContentFactory.jsonBuilder()
    public void testInvalidQueryParsingForDateHistogramAggregations() throws IOException {
            .prepareCreate("test")
        TermsAggregationBuilder termsAggregationBuilder = terms("term").field(KEYWORD_FIELD).subAggregation(maxAggNoSub);
                true
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
        assertStarTreeContext(
                true
            .query(baseQuery)
            getStarTreeQueryContext(
                baseQuery,
                DateFieldMapper.Resolution.MILLISECONDS
        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
     */
            ),
        indexRandomDocuments(100);
                    StarTreeFilterTests.DIMENSION_TYPE_MAP,
            queryBuilder,
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        when(indexShard.segments(false)).thenReturn(List.of(segment, segment));
        // Query resolves to MatchNoneQuery, star-tree query context will not be created
                    for (ValuesSourceAggregationBuilder<?> metricAgg : aggBuilders) {
                        List<Metric> metrics = List.of(new Metric(FIELD_NAME, List.of(stat)));
                        ValuesSourceAggregationBuilder<?> firstBucket = firstSupplier.get().subAggregation(secondBucket);
        }
        // Case 6: Range Aggregation on non-numeric field, should not use star tree
                baseQuery,
            .setSource(
            request,
            .calendarInterval(DateHistogramInterval.DAY)
            .setMapping(NumericTermsAggregatorTests.getExpandedMapping(1, false));
                starTreeFieldConfiguration,
                sourceBuilder,
        // Case 4: Unsupported aggregations within range aggregation, should not use star tree
        sourceBuilder = new SearchSourceBuilder().size(0).query(new MatchAllQueryBuilder()).aggregation(termsAggregationBuilder);
        );
        CreateIndexRequestBuilder builder = client().admin()
        when(mapperService.getCompositeFieldTypes()).thenReturn(Set.of(compositeDataCubeFieldType));
        assertEquals(2, starTreeQueryContext.getAllCachedValues().length);
                    false,
        QueryBuilder baseQuery;
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
            bulkRequest.add(indexRequest);
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
        baseQuery = new MatchAllQueryBuilder();
                for (Supplier<ValuesSourceAggregationBuilder<?>> thirdSupplier : aggregationSuppliers) {
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
     * Test query parsing for bucket aggregations, with/without numeric term query
    /**
            () -> terms("term_size").field(SIZE),
                );
        setStarTreeIndexSetting("true");
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
        for (int i = 0; i < totalDocs; i++) {
        // Case 3: Nested metric aggregations within range aggregation, should not use star tree
            request,
    Settings starStreeEnabledIndexSettings = Settings.builder()
        );
                "startree1",
                List.of(
            sourceBuilder,
            searchContext.getQueryShardContext().setStarTreeQueryContext(starTreeQueryContext);
        assertStarTreeContext(request, sourceBuilder, null, -1);
            case 4 -> new OrdinalDimension(KEYWORD_FIELD);
        String KEYWORD_FIELD = "clientip";
        String NUMERIC_FIELD_NOT_ORDERED_DIMENSION = "city_name";
                "startree1",
        when(searchContext.aggregations()).thenReturn(searchContextAggregations);
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX, MetricStat.VALUE_COUNT))),
     * Test query parsing for range aggregations, with/without numeric term query
                    new Metric(TIMESTAMP_FIELD, List.of(MetricStat.SUM, MetricStat.MAX)),
                    );
        assertStarTreeContext(request, sourceBuilder, null, -1);
        );
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
            1,
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
    }
            ),
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
                searchContext,
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(multiTermsAgg);
        setStarTreeIndexSetting("true");
                            true
                        DateFieldMapper.Resolution.MILLISECONDS
        // Case 6: TermQuery and multiple aggregations present, should use star tree & initialize cache
                new MultiTermsValuesSourceConfig.Builder().setFieldName(NUMERIC_FIELD).build()
                sourceBuilder,
            request,
            );
        // Case 5: Range Aggregation on field not in ordered dimensions, should not use star tree
        // Case 5: Unsupported sub-aggregation, should not use star tree
        IndexShard indexShard = indexService.getShard(0);
            .calendarInterval(DateHistogramInterval.DAY)
        baseQuery = new MatchAllQueryBuilder();
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD), new NumericDimension(STATUS)),
            1,
            .fixedInterval(DateHistogramInterval.DAY)
import org.opensearch.search.aggregations.AggregatorFactory;
            .indices()
        MedianAbsoluteDeviationAggregationBuilder medianAgg = medianAbsoluteDeviation("median").field(STATUS);
                List.of(new OrdinalDimension("sndv")),
}
            OriginalIndices.NONE,
        termsAggregationBuilder = terms("term").field(NUMERIC_FIELD).subAggregation(maxAggNoSub).subAggregation(sumAggNoSub);
            new AliasFilter(null, Strings.EMPTY_ARRAY),
                sourceBuilder,
    private void setStarTreeIndexSetting(String value) {
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
        List<Metric> metrics,
            1.0f,
        ShardSearchRequest request = new ShardSearchRequest(
        String NUMERIC_FIELD = "size";
        MapperService mapperService = mock(MapperService.class);
            )
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
        final long nowMillis = System.currentTimeMillis();
 * this file be licensed under the Apache-2.0 license or a
                    .startObject()
            sourceBuilder,
        // Case 4: NumericTermsQuery and multiple non-nested metric aggregations is within numeric term aggregation, should use star tree
            .aggregation(max("test").field("field"))
                    1,
    }
        starTreeQueryContext.maybeSetCachedNodeIdsForSegment(-1, null);
            .postFilter(new MatchAllQueryBuilder());
import org.opensearch.index.mapper.DateFieldMapper;
        else if (name.contains("max")) return MetricStat.MAX;
    }
        SearchContext searchContext = mock(SearchContext.class);
        // Case 7: Date histogram with non calendar interval: rounding is null for DateHistogramFactory - cannot use star-tree
        baseQuery = new TermQueryBuilder(STATUS, 1);
                baseQuery,
            sourceBuilder,
        setStarTreeIndexSetting("true");
                        assertStarTreeContext(
    public void testQueryParsingForMultiTermsAggregations() throws IOException {
            .aggregation(AggregationBuilders.max("test").field("field"))
     * Test query parsing for date histogram aggregations on star-tree index when @timestamp field does not exist
        long duration180DaysMillis = TimeUnit.DAYS.toMillis(180);
        setStarTreeIndexSetting("true");
        IndexShard indexShard = indexService.getShard(0);
import org.opensearch.index.mapper.MapperService;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
            OriginalIndices.NONE,
                baseQuery,
                for (ValuesSourceAggregationBuilder<?> metricAgg : aggBuilders) {
    private static Dimension getDimensionByIndex(int index) {
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, true).to(toDateString, false).format(DATE_FORMAT);
import java.time.format.DateTimeFormatter;
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
                        .field(STATUS, random().nextBoolean() ? random().nextInt(10) : null) // Random status (0-9)
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
        client().admin().indices().prepareForceMerge("test").setMaxNumSegments(1).get();
        bulkRequest.add(indexRequest);
            1,
                starTreeFieldConfiguration,
                starTreeFieldConfiguration,
                true
                searchContext,
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
            indexShard.shardId(),
            new AliasFilter(null, Strings.EMPTY_ARRAY),
        // Query resolves to MatchNoneQuery, star-tree query context will not be created
        );
    ) {
            .setMapping(
        to = startOfTodayUTC.toEpochMilli() - TimeUnit.DAYS.toMillis(200);
            .setSettings(starStreeEnabledIndexSettings)
            -1
            new AliasFilter(null, Strings.EMPTY_ARRAY),
        String NUMERIC_FIELD = "size";
            null,
            getStarTreeQueryContext(
        SearchContext searchContext = createSearchContext(indexService);
                List.of(
            }
                searchContext,
import static org.mockito.Mockito.mock;
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(multiTermsAgg);
                )
                        ),
        assertStarTreeContext(request, sourceBuilder, null, -1);
            null,
            compositeFieldName,
                searchContext,
                assertThat(context.getQueryShardContext().getStarTreeQueryContext(), nullValue());
                List.of(new OrdinalDimension(KEYWORD_FIELD), new NumericDimension(NUMERIC_FIELD), new NumericDimension(STATUS)),
        StarTreeFieldConfiguration starTreeFieldConfiguration,
                baseQuery,
                    assertNull(actualContext.getAllCachedValues());
                true
        sourceBuilder = new SearchSourceBuilder().size(0).aggregation(dateHistogramAggregationBuilder);
                starTreeFieldConfiguration,
            Collections.emptySet(),
                            sourceBuilder,
                true
        dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)
            new SearchRequest().allowPartialSearchResults(true),
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
        baseQuery = null;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                searchContext,
        when(searchContextAggregations.factories()).thenReturn(aggregatorFactories);
            new AliasFilter(null, Strings.EMPTY_ARRAY),
            List.of(
    }
                    MetricStat stat = getMetricStatFromAgg(metricAgg);
     * Test query parsing for date histogram aggregations, with/without numeric term query
        // Case 7: Valid range aggregation and valid metric aggregation, should use star tree & cache
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, false).to(toDateString, false).format(DATE_FORMAT);
                sourceBuilder,
        SearchContextAggregations searchContextAggregations = mock(SearchContextAggregations.class);
        assertStarTreeContext(
    private StarTreeQueryContext getStarTreeQueryContext(
            Collections.emptySet(),
                starTreeFieldConfiguration,
                    new NumericDimension(STATUS)
            )
                    assertStarTreeContext(
        // invalid date-range(gte,lte) query
        AggregatorFactories aggregatorFactories = mock(AggregatorFactories.class);
                        );
                searchContext,
import static org.opensearch.search.aggregations.AggregationBuilders.multiTerms;
        );
            1,
        return starTreeQueryContext;
        sourceBuilder = new SearchSourceBuilder().size(0).aggregation(dateHistogramAggregationBuilder);
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
        String TIMESTAMP_FIELD = "timestamp";
        ShardSearchRequest request = new ShardSearchRequest(
import org.opensearch.index.query.TermsQueryBuilder;
            .indices()
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)
                    StarTreeFilterTests.METRIC_TYPE_MAP
                -1,
     */
            request,
                                starTreeFieldConfiguration,
            Collections.emptySet(),
            -1
            -1,
            .prepareCreate("test")
        );
        );
        rangeAggregationBuilder = range("range").field(TIMESTAMP_FIELD).addRange(0, 100).subAggregation(maxAggNoSub);
        assertStarTreeContext(request, sourceBuilder, expectedContext, -1);
        IndexShard indexShard = indexService.getShard(0);
            sourceBuilder,
            .calendarInterval(DateHistogramInterval.DAY)
            );
        assertStarTreeContext(request, sourceBuilder, null, -1);
                            new MatchAllQueryBuilder(),
            -1
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
        sourceBuilder = new SearchSourceBuilder().size(0).query(termQueryBuilder).aggregation(sumAggNoSub);
    private static List<Dimension> getDimensions(int... indices) {
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(AggregationBuilders.max("test").field("field"));
                "startree",
        ).subAggregation(maxAggNoSub);
                true
        String STATUS = "status";
                "startree1",
                searchContext,
                        .startObject()
        IndexShard indexShard = indexService.getShard(0);
        String name = agg.getName();
        long to = startOfTodayUTC.toEpochMilli() - TimeUnit.DAYS.toMillis(20);
        baseQuery = new MatchAllQueryBuilder();
        int expectedCacheUsage
            null,
            .build();
            sourceBuilder,
        assertEquals(22, starTreeQueryContext.maybeGetCachedNodeIdsForSegment(0).length());
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("test"));
            }
            .subAggregation(maxAggNoSub);
            .indices()
            .setMapping(DateHistogramAggregatorTests.getExpandedMapping(1, false));
                                ),
                        .endObject()
            getStarTreeQueryContext(
        );
        SearchContext searchContext = createSearchContext(indexService);
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).to(toDateString, false).format(DATE_FORMAT);
                StarTreeFilterTests.getExpandedMapping(
        CreateIndexRequestBuilder builder = client().admin()
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
            .setSettings(starStreeEnabledIndexSettings)
     */
        for (Supplier<ValuesSourceAggregationBuilder<?>> firstSupplier : aggregationSuppliers) {
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
        assertStarTreeContext(request, sourceBuilder, null, -1);
            -1,
import static org.hamcrest.CoreMatchers.nullValue;
        FixedBitSet cachedValues = new FixedBitSet(22);
        assertStarTreeContext(request, sourceBuilder, null, -1);
        baseQuery = new TermQueryBuilder(STATUS, 1);
                baseQuery,
                    false,
import org.opensearch.search.aggregations.Aggregator;
            -1,
                new MultiTermsValuesSourceConfig.Builder().setFieldName(NUMERIC_FIELD).build()
import static org.mockito.Mockito.when;
        // valid date-range(gte,lt) query
import org.opensearch.index.compositeindex.datacube.MetricStat;
                List.of(new Metric("field", List.of(MetricStat.MAX, MetricStat.SUM))),
        createIndex("test", builder);
    private MetricStat getMetricStatFromAgg(ValuesSourceAggregationBuilder<?> agg) {
                } else {
                    .field(SIZE, random().nextBoolean() ? random().nextInt(100) : null) // Random size (0-99)
                true
    private void assertStarTreeContext(
        SumAggregationBuilder sumAggSub = sum("sum").field(STATUS).subAggregation(maxAggNoSub);
        // Query resolves to MatchNoneQuery, star-tree query context will not be created
                searchContext,
        for (Supplier<ValuesSourceAggregationBuilder<?>> firstSupplier : aggregationSuppliers) {
                "startree1",
            -1,
                sourceBuilder,
                List.of(new Metric("field", List.of(MetricStat.MAX))),
                    .field(STATUS, random().nextBoolean() ? random().nextInt(10) : null) // Random status (0-9)
        QueryBuilder baseQuery,
                    1,
            null,
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(dateHistogramAggregationBuilder);
                -1,
        sourceBuilder = new SearchSourceBuilder().size(0)
            1,
            .subAggregation(maxAggNoSub);
            OriginalIndices.NONE,
            -1
            request,
                    new DateDimension(
import org.opensearch.index.query.RangeQueryBuilder;
                assertEquals(expectedContext.getStarTree().getField(), actualContext.getStarTree().getField());
        MaxAggregationBuilder sumAggNoSub = max("sum").field(STATUS);
        assertStarTreeContext(
        assertStarTreeContext(request, sourceBuilder, null, -1);
import org.opensearch.core.common.Strings;
        termsAggregationBuilder = terms("term").field(KEYWORD_FIELD).subAggregation(maxAggNoSub);
                starTreeFieldConfiguration,
        baseQuery = new MatchAllQueryBuilder();
            new SearchRequest().allowPartialSearchResults(true),
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
    private static List<Supplier<ValuesSourceAggregationBuilder<?>>> getAggregationSuppliers() {
        dateHistogramAggregationBuilder = dateHistogram("non_cal").field(TIMESTAMP_FIELD)
        when(searchContext.indexShard()).thenReturn(indexShard);
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
            new StarTreeField(
            getStarTreeQueryContext(
            1.0f,
            .setSettings(starStreeEnabledIndexSettings)
        when(aggregatorFactories.getFactories()).thenReturn(aggregatorFactoriesArray);
                searchContext,
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
            -1
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
        ShardSearchRequest request = new ShardSearchRequest(
import org.opensearch.action.bulk.BulkRequestBuilder;
import org.opensearch.index.engine.Segment;
        // Adding 2 documents with minimum and maximum timestamp
                -1,
            null
            1.0f,
        RangeAggregationBuilder rangeAggregationBuilder = range("range").field(NUMERIC_FIELD).addRange(0, 10).subAggregation(maxAggNoSub);
                        ValuesSourceAggregationBuilder<?> secondBucket = secondSupplier.get().subAggregation(thirdBucket);
public class SearchServiceStarTreeTests extends OpenSearchSingleNodeTestCase {
        starTreeQueryContext = new StarTreeQueryContext(compositeDataCubeFieldType, new MatchAllQueryBuilder(), 2);
        assertEquals(2, starTreeQueryContext.getAllCachedValues().length);
    /**
            getStarTreeQueryContext(
        // Case 5: MatchAllQuery and non-startree supported aggregation nested within date-histogram aggregation, should not use star tree
import org.opensearch.search.aggregations.SearchContextAggregations;
        );
                List.of(new NumericDimension(NUMERIC_FIELD), new OrdinalDimension(KEYWORD_FIELD), new NumericDimension(STATUS)),
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(dateHistogramAggregationBuilder);
        final String DATE_FORMAT = "strict_date_optional_time||epoch_second";
        // valid date-range(gte) query
        assertStarTreeContext(request, sourceBuilder, null, -1);
                "startree1",
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
                            .query(new MatchAllQueryBuilder())
        List<Dimension> dimensions,
                    ValuesSourceAggregationBuilder<?> firstBucket = firstSupplier.get().subAggregation(secondBucket);
 * For valid resolvable (with star-tree) cases, StarTreeQueryContext is created and populated with the SearchContext
            SearchContext context = searchService.createContext(reader, request, null, true);
        assertStarTreeContext(request, sourceBuilder, null, -1);
                -1,
        createIndex("test", builder);
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        MaxAggregationBuilder maxAggNoSub = max("max").field(STATUS);
        assertStarTreeContext(request, sourceBuilder, null, -1);
        ShardSearchRequest request = new ShardSearchRequest(
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
            1,
        baseQuery = new MatchAllQueryBuilder();
            .cluster()
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                                    aggregationSuppliers.indexOf(firstSupplier),
            min("_min").field(FIELD_NAME),
                true
            .calendarInterval(DateHistogramInterval.SECOND)
        SearchContext searchContext = createSearchContext(indexService);
        setStarTreeIndexSetting(null);
            -1,
        assertStarTreeContext(
package org.opensearch.search;
            .subAggregation(maxAggNoSub);
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder(TIMESTAMP_FIELD, fromDateString);
                searchContext,
                starTreeFieldConfiguration,
                            metrics,
                List.of(new OrdinalDimension("field")),
        return switch (index) {
                    TIMESTAMP_FIELD,
        // Case 2: MatchAllQuery present but no aggregations, should not use star tree
        assertStarTreeContext(
            .setSource(
    public void testDateRangeQuery() throws IOException {
                                true
        String SIZE = "size";
    public void testQueryParsingForRangeAggregations() throws IOException {
        assertStarTreeContext(request, sourceBuilder, null, -1);
     * Test query parsing for multi-terms aggregations, with/without numeric term query
/**
            1,
        dateHistogramAggregationBuilder = dateHistogram("by_sec").field(TIMESTAMP_FIELD)
                    ),
            .aggregation(dateHistogramAggregationBuilder);
            request,
            OriginalIndices.NONE,
        ShardSearchRequest request = new ShardSearchRequest(
                "startree",
 * For non-resolvable (with star-tree) cases, StarTreeQueryContext is null
        };
        );
        CreateIndexRequestBuilder builder = client().admin()
            Collections.emptySet(),
            .indices()
        fromDateString = formatter.format(Instant.ofEpochMilli(from));
        CreateIndexRequestBuilder builder = client().admin()
        );
        CreateIndexRequestBuilder builder = client().admin()
        assertStarTreeContext(request, sourceBuilder, null, -1);
            ),
        from = startOfTodayUTC.toEpochMilli() - TimeUnit.DAYS.toMillis(240);
import org.opensearch.search.internal.ShardSearchRequest;
                if (expectedCacheUsage > -1) {
                            starTreeFieldConfiguration,
        assertStarTreeContext(request, sourceBuilder, null, -1);
        IndexShard indexShard = indexService.getShard(0);
    private static final String SIZE = "size";
                .setSource(
        MaxAggregationBuilder maxAggNoSub = max("max").field(STATUS);
            .prepareUpdateSettings()
                        List.of(new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)),
        QueryBuilder baseQuery;
        baseQuery = new MatchAllQueryBuilder();
        dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)
            indexShard.shardId(),
        sourceBuilder = new SearchSourceBuilder().size(0).query(queryBuilder).aggregation(sumAggNoSub);
        when(aggregatorFactories.getFactories()).thenReturn(new AggregatorFactory[] { null, null });
        String STATUS = "status";
                        TIMESTAMP_FIELD,
        // Case 9: Date histogram with no valid time interval to resolve aggregation - should not use star-tree
            .execute();
        );
                    .field(TIMESTAMP_FIELD, nowMillis - duration180DaysMillis)
import org.opensearch.index.shard.IndexShard;
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(AggregationBuilders.max("test").field("field"));
 * The OpenSearch Contributors require contributions made to
            sourceBuilder,
        );
        String NUMERIC_FIELD = "size";
                ),
            .indices()
        String KEYWORD_FIELD = "clientip";
            1.0f,
            ),
        .build();
        searchContext.aggregations(mockAggregations);
    ) throws IOException {
        String NUMERIC_FIELD_NOT_ORDERED_DIMENSION = "rank";
                        .field(SIZE, random().nextBoolean() ? random().nextInt(100) : null) // Random size (0-99)
     */
                            getStarTreeQueryContext(
            ),
        IndexShard indexShard = indexService.getShard(0);
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;
            for (Supplier<ValuesSourceAggregationBuilder<?>> secondSupplier : aggregationSuppliers) {
                "startree1",
        else if (name.contains("min")) return MetricStat.MIN;
    }
        ShardSearchRequest request = new ShardSearchRequest(
        );
            ),
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
        CreateIndexRequestBuilder builder = client().admin()
                ),
            null
        // Case 5: TermQuery and single aggregation, should use star tree, but not initialize query cache
            new AliasFilter(null, Strings.EMPTY_ARRAY),
        when(aggregatorFactories.getFactories()).thenReturn(new AggregatorFactory[] { null, null });
            sourceBuilder,
                throw new RuntimeException(e);
            null
        starTreeQueryContext = new StarTreeQueryContext(searchContext, baseQuery);
                        List.of(new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)),
        sourceBuilder = new SearchSourceBuilder().size(0).aggregation(AggregationBuilders.max("test").field("field"));
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0)
import org.opensearch.index.query.TermQueryBuilder;
            .setMapping(NumericTermsAggregatorTests.getExpandedMapping(1, false));
                baseQuery,
        termsAggregationBuilder = terms("term").field(NUMERIC_FIELD).subAggregation(sumAggSub);
        BulkRequestBuilder bulkRequest = client().prepareBulk();
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(multiTermsAgg);
            )
            0
                sourceBuilder,
            List.of(
        sourceBuilder = new SearchSourceBuilder().size(0).aggregation(dateHistogramAggregationBuilder);
        CreateIndexRequestBuilder builder = client().admin()
                true
            .setSettings(settings)
        createIndex("test", builder);
                searchContext,
            .prepareCreate("test")
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, true).format(DATE_FORMAT);
        // Case 10: Date histogram nested with multiple non-nested metric aggregations - should use star-tree
    }
import org.opensearch.search.builder.SearchSourceBuilder;
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        );
            getStarTreeQueryContext(
        String KEYWORD_FIELD = "clientip";
import org.opensearch.action.search.SearchRequest;
        assertStarTreeContext(request, sourceBuilder, null, -1);
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
                        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0)
        assertStarTreeContext(request, sourceBuilder, null, -1);
        SearchContextAggregations mockAggregations = mock(SearchContextAggregations.class);
        sourceBuilder = new SearchSourceBuilder().size(0)
                ),
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
        CompositeDataCubeFieldType compositeDataCubeFieldType = new StarTreeMapper.StarTreeFieldType(
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(0).query(baseQuery).aggregation(multiTermsAgg);
        ValuesSourceAggregationBuilder<?>[] aggBuilders = {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                List.of(new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)),
        indexRequest = client().prepareIndex("test")
        AggregatorFactories aggregatorFactories = mock(AggregatorFactories.class);
        setStarTreeIndexSetting("true");
        assertNull(starTreeQueryContext.maybeGetCachedNodeIdsForSegment(0));
            .prepareCreate("test")
                    .field(STATUS, random().nextBoolean() ? random().nextInt(10) : null) // Random status (0-9)
                        .field(TIMESTAMP_FIELD, date) // Random timestamp
                        DateFieldMapper.Resolution.MILLISECONDS
        assertStarTreeContext(request, sourceBuilder, null, -1);
        queryBuilder = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString, true).to(toDateString, true).format(DATE_FORMAT);
                List.of(new Metric(STATUS, List.of(MetricStat.SUM, MetricStat.MAX))),
                -1,
            1,
     */
            () -> terms("term_keyword").field(KEYWORD_FIELD).collectMode(Aggregator.SubAggCollectionMode.BREADTH_FIRST)
        try (ReaderContext reader = searchService.createOrGetReaderContext(request, false)) {
                    }
            indexRequest = client().prepareIndex("test")
        sourceBuilder = new SearchSourceBuilder().query(new MatchAllQueryBuilder());
            indexShard.shardId(),
        createIndex("test", builder);
        ).subAggregation(medianAgg);
                starTreeFieldConfiguration,
            sourceBuilder,
                    new NumericDimension(STATUS)
                true
            Collections.emptySet(),
