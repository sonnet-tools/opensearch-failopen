                return objectToUnsignedLong(asUnsignedDecimalString(queryValue), false);
        }),
            .collect(
                return NumberFieldMapper.NumberType.HALF_FLOAT;
            starTree,
            for (QueryBuilder qb : allFieldQueries) {
import java.util.Collections;
                    StarTreeFilterTests.METRIC_TYPE_MAP
            supportedMetrics,
            new DimensionFieldData("ip_field", this::randomIp, DimensionTypes.IP),
        }
                    starTree,
        // Case when field is not present in supported metrics
            // Get all types of queries (Term/Terms/Range) for all the given dimensions.
import org.opensearch.search.aggregations.AggregatorFactories;
            BoolQueryBuilder mustWithShould = new BoolQueryBuilder().must(getTermQueryBuilder())
            queryBuilder,
            );
        T aggBuilder,
        if (randomBoolean()) {
        FLOAT(new NumericDimensionFieldDataSupplier() {
            @Override
                );
            return dimensionFieldDataSupplier.getField(fieldName, valueSupplier);
                );
            sumAggregationBuilder,
                testCase(
        Random r = random();
    private String randomIp() {
import java.net.InetAddress;
import org.apache.lucene.codecs.Codec;
                    sumAggregationBuilder,
                    verifyAggregation(InternalAvg::getValue)
    private static final String FIELD_NAME = "field";
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
            new DimensionFieldData("keyword_field", () -> random().nextInt(50), DimensionTypes.KEYWORD),
        );
                values.add(valueSupplier.get());
import org.opensearch.search.aggregations.metrics.InternalValueCount;
        MapperService mapperService = mapperServiceMock();
        MapperService mapperService;
                    minAggregationBuilder,
            List.of(new Metric("hello", List.of(MetricStat.MAX, MetricStat.MIN, MetricStat.AVG))),
                return new KeywordField(fieldName, String.valueOf(valueSupplier.get()), Field.Store.YES);
        directory.close();
        public MappedFieldType getMappedField() {
import org.opensearch.index.query.QueryBuilder;
            for (DimensionFieldData fieldData : dimensionFieldData) {
            }
        CompositeIndexFieldInfo starTree,
    }
            for (int i = 0; i < limit; i++) {
                    starTree,
    private abstract static class NumericDimensionFieldDataSupplier implements DimensionFieldDataSupplier {
            false
            aggBuilder,
            return dimensionFieldDataSupplier;
            query,
        }
            Collections.emptyList(),
            aggregatorFactory,
                testCase(
        // Case when metric type in aggregation is not supported by star tree but the field is supported.
            @Override
            return randomFrom(mustOnly, mustWithShould, shouldOnly);
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {
        );
                query = qb.toQuery(queryShardContext);
        AggregatorFactories aggregatorFactories = mock(AggregatorFactories.class);
    private static class DimensionFieldData {
            supportedDimensions,
            queryBuilder,
        testCase(
        KEYWORD(new DimensionFieldDataSupplier() {
    }
                    supportedDimensions,
            }
        );
import org.opensearch.index.mapper.MappedFieldType;
                    indexSearcher,
            indexSearcher,
                    ? 9223372036854775807L - random().nextInt(100000)
/*
        // codec.
import org.apache.lucene.document.SortedNumericDocValuesField;
                    verifyAggregation(InternalMin::getValue)
            // MUST with nested SHOULD on same dimension
import static org.opensearch.search.aggregations.AggregationBuilders.count;
            new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), circuitBreakerService).withCircuitBreaking()
        Supplier<Integer> maxLeafDocsSupplier,
        // Case when sub aggregations are present
        LONG(new NumericDimensionFieldDataSupplier() {
import org.opensearch.search.aggregations.AggregatorTestCase;
                .flatMap(
 * compatible open source license.
            public Dimension getDimension(String fieldName) {
    private static final NumberFieldMapper.NumberType DEFAULT_FIELD_TYPE = NumberFieldMapper.NumberType.LONG;
        );
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        }
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
            when(queryShardContext.fieldMapper(fieldData.fieldName)).thenReturn(fieldData.getMappedField());
import org.opensearch.common.lucene.Lucene;
        // Keyword Range query with missing Low Ordinal
        // Case when aggregation factory is not metric aggregation
        }
                    InetAddress address = InetAddress.getByName((String) valueSupplier.get());
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
            aggregatorFactory,
            @Override
                    query,
            false,
        for (int cases = 0; cases < 15; cases++) {
import org.apache.logging.log4j.LogManager;
            invalidFieldSumAggBuilder,
                dimensionFieldDatum
            createIndexSettings(),
import org.opensearch.search.aggregations.metrics.InternalAvg;
        }
import java.io.IOException;
            }
            invalidFieldSumAggBuilder.build(queryShardContext, null),
        UNSIGNED_LONG(new NumericDimensionFieldDataSupplier() {
        rangeQueryBuilder.from(Long.MAX_VALUE).includeLower(random().nextBoolean());
                }
            return new NumericDimension(fieldName);
            query,
        );
import org.opensearch.index.query.TermsQueryBuilder;
import org.opensearch.index.mapper.NumberFieldMapper;
                }
        when(aggregatorFactory.getSubFactories()).thenReturn(aggregatorFactories);
            new DimensionFieldData("half_float_field", () -> random().nextFloat(50), DimensionTypes.HALF_FLOAT),
                                DimensionFieldData::getFieldType,
        INTEGER(new NumericDimensionFieldDataSupplier() {
import org.apache.lucene.store.Directory;
import static org.mockito.Mockito.mock;
                return new FloatField(fieldName, (Float) valueSupplier.get(), Field.Store.YES);
import org.opensearch.core.indices.breaker.CircuitBreakerService;
                shouldOnly.should(getRangeQueryBuilder());
            @Override
                    valueCountAggregationBuilder,
import org.apache.lucene.document.KeywordField;
        }
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
            searcher,
                    maxAggregationBuilder,
            }
            @Override
            verifyAggregation(InternalSum::getValue),
            }
                return new LongField(fieldName, (Integer) valueSupplier.get(), Field.Store.YES);
import org.apache.lucene.search.IndexSearcher;
        List<Metric> supportedMetrics,
            @Override
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
                    indexSearcher,
            int limit = randomIntBetween(1, 20);
            aggregatorFactory,
            circuitBreakerService,
            new DimensionFieldData("sndv", () -> random().nextInt(10) - 5, DimensionTypes.INTEGER),
                    indexSearcher,
                    : -9223372036854775808L + random().nextInt(100000);
        public QueryBuilder getRangeQueryBuilder() {
                );
        HALF_FLOAT(new NumericDimensionFieldDataSupplier() {
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        iw.close();
        try {
            valueExtractor.apply(actualAggregation).doubleValue(),
        BiConsumer<V, V> verify,
import org.apache.lucene.document.Field;
    }
                .toList();
            // MUST only
            verifyAggregation(InternalSum::getValue),
                .includeUpper(randomBoolean());
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {
            starTree,
            () -> 1,
        verify.accept(expectedAggregation, starTreeAggregation);
            sumAggregationBuilder,
import java.util.function.BiConsumer;
            b = b.add(BigInteger.ONE.shiftLeft(64));
import org.apache.lucene.tests.index.RandomIndexWriter;
            indexSearcher,
        SegmentReader reader = Lucene.segmentReader(context.reader());
    private <T extends AggregationBuilder, V extends InternalAggregation> void testCase(
        }),
    private void testStarTreeDocValuesInternal(Codec codec, List<DimensionFieldData> dimensionFieldData) throws IOException {
            }
                mustOnly.must(getRangeQueryBuilder());
        private final DimensionFieldDataSupplier dimensionFieldDataSupplier;
        );
        // Case when field and metric type in aggregation are fully supported by star tree.
public class MetricAggregatorTests extends AggregatorTestCase {
        for (int i = 0; i < totalDocs; i++) {
            @Override
            }
            @Override
                    qb,
        } catch (IOException e) {
    private String asUnsignedDecimalString(long l) {
            supportedDimensions,
            supportedDimensions,
            @Override
                    verifyAggregation(InternalMax::getValue)
            queryBuilder,
            return new TermsQueryBuilder(fieldName, values);
        public String getFieldType() {
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {
        MaxAggregationBuilder maxAggregationBuilder = max("_name").field(FIELD_NAME);
    }
            DEFAULT_MAPPED_FIELD
    ) {
            true
            @Override
                    x -> Stream.of(x.getTermQueryBuilder(), x.getTermsQueryBuilder(), x.getRangeQueryBuilder(), x.getBoolQueryBuilder())
import org.opensearch.search.aggregations.metrics.InternalMax;
            }
            sumAggregationBuilder,
        final Logger testLogger = LogManager.getLogger(MetricAggregatorTests.class);
            NumberFieldMapper.NumberType numberType() {
                return new IpFieldMapper.IpFieldType(fieldName);
            rangeQueryBuilder,
import org.opensearch.common.util.MockBigArrays;
        );
import org.opensearch.search.aggregations.metrics.InternalSum;
            if (fieldType.equals(DimensionTypes.KEYWORD.name().toLowerCase(Locale.ROOT))) {
            aggregatorFactory,
    protected Codec getCodec(
            return new NumberFieldMapper.NumberFieldType(fieldName, numberType());
            throw new RuntimeException(e);
                .must(new BoolQueryBuilder().should(getTermQueryBuilder()).should(getTermQueryBuilder()));
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.objectToUnsignedLong;
                    supportedDimensions,
                return new IntField(fieldName, (Integer) valueSupplier.get(), Field.Store.YES);
import org.opensearch.search.aggregations.metrics.MetricAggregatorFactory;
        }
        );
                );
            false
            verifyAggregation(InternalSum::getValue),
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions, // FIXME : Merge with the same input that goes to generating the
import org.apache.lucene.document.FloatField;
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {
            return fieldType;
                StarTreeFilterTests.getExpandedMapping(maxLeafDocsSupplier.get(), false, dimensionAndType, metricFieldAndType)
            indexSearcher,
        IndexWriterConfig conf = newIndexWriterConfig(null);
            starTree,
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
            false // Invalid fields will return null StarTreeQueryContext which will not cause early termination by leaf collector
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
import org.apache.lucene.search.Query;
            () -> randomIntBetween(2, 100),
import org.apache.lucene.sandbox.document.HalfFloatPoint;
            verifyAggregation(InternalSum::getValue),
            }
                    doc.add(fieldData.getField());
                    verifyAggregation(InternalValueCount::getValue)
        conf.setMergePolicy(newLogMergePolicy());
                    throw new RuntimeException(e);
            @Override
    }
            query,
import java.math.BigInteger;
        }
            null,
            @Override
            );
        public QueryBuilder getTermsQueryBuilder() {
        }),
                                df -> df.getDimension().getField(),
    }
        testCase(
                    supportedDimensions,
            supportedDimensions,
            } else {
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {
            mapperService,
            starTree,
            false
            null,
        }
            @Override
            assertCollectorEarlyTermination,
            sumAggregationBuilder,
            } else {
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
import org.apache.lucene.document.SortedSetDocValuesField;
        }),
    private <T extends AggregationBuilder, V extends InternalAggregation> void testCase(
        LinkedHashMap<String, String> dimensionAndType,
            DEFAULT_MAX_BUCKETS,
        ValueCountAggregationBuilder valueCountAggregationBuilder = count("_name").field(FIELD_NAME);
    private enum DimensionTypes {
        );
        V expectedAggregation = searchAndReduceStarTree(
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,
            }
import java.util.ArrayList;
                doc.add(new SortedNumericDocValuesField(FIELD_NAME, val));
        T aggBuilder,
            indexSearcher,
            iw.addDocument(doc);
import org.opensearch.index.compositeindex.datacube.Dimension;
import org.apache.lucene.util.BytesRef;
        );
            queryBuilder,
        );
 * this file be licensed under the Apache-2.0 license or a
            queryBuilder,
        public DimensionFieldDataSupplier getFieldDataSupplier() {
                    query,
            createIndexSettings(),
                    return new SortedSetDocValuesField(fieldName, new BytesRef(InetAddressPoint.encode(address)));
                return new DoubleField(fieldName, (Double) valueSupplier.get(), Field.Store.YES);
                    qb,
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {
        public Dimension getDimension() {
        CircuitBreakerService circuitBreakerService = new NoneCircuitBreakerService();
        BigInteger b = BigInteger.valueOf(l);
            this.dimensionFieldDataSupplier = dimensionFieldDataSupplier;
import org.opensearch.index.query.BoolQueryBuilder;
                return new OrdinalDimension(fieldName);
        QueryBuilder queryBuilder,
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
            Document doc = new Document();
            query,
        }
        abstract NumberFieldMapper.NumberType numberType();
        public QueryBuilder getTermQueryBuilder() {
                Collectors.toMap(DimensionFieldData::getDimension, DimensionFieldData::getMappedField, (v1, v2) -> v1, LinkedHashMap::new)
import org.opensearch.common.util.MockPageCacheRecycler;
                    starTree,
        testCase(
import org.opensearch.index.query.RangeQueryBuilder;
            return dimensionFieldDataSupplier.getDimension(fieldName);
 *
        IndexableField getField(String fieldName, Supplier<Object> valueSupplier);
    private interface DimensionFieldDataSupplier {
        final List<DimensionFieldData> dimensionFieldDatum = List.of(
}
                    supportedDimensions,
                    supportedDimensions,
import org.apache.lucene.index.IndexableField;
            sumAggregationBuilder,
                return new BigIntegerField(fieldName, (BigInteger) valueSupplier.get(), Field.Store.YES);
        testCase(searcher, query, queryBuilder, aggBuilder, starTree, supportedDimensions, Collections.emptyList(), verify, null, true);
                mustOnly.must(getTermQueryBuilder());
                    qb,
            0.0f
                val = random.nextInt(50); // Random long between 0 and 49
import org.opensearch.index.query.QueryShardContext;
            queryBuilder,
            new DimensionFieldData("long_field", () -> random().nextInt(50), DimensionTypes.LONG),
            starTree,
        public IndexableField getField() {
import org.opensearch.index.codec.composite.CompositeIndexReader;
        private final DimensionFieldDataSupplier dimensionFieldDataSupplier;
                long queryValue = randomBoolean()
            List<QueryBuilder> allFieldQueries = dimensionFieldData.stream()
        }
import org.apache.lucene.index.LeafReaderContext;
                ),
    }
        }
            }
        Query query,
            NumberFieldMapper.NumberType numberType() {
            }
            query,
            null,
import java.util.function.Supplier;
            this.fieldType = dimensionType.name().toLowerCase(Locale.ROOT);
            NumberFieldMapper.NumberType numberType() {
            supportedDimensions,
        for (Supplier<Integer> maxLeafDocsSupplier : MAX_LEAF_DOC_VARIATIONS) {
            public MappedFieldType getMappedField(String fieldName) {
import org.opensearch.index.compositeindex.datacube.NumericDimension;
            // SHOULD only on same dimension
        DirectoryReader ir = DirectoryReader.open(directory);
        int val;
                return NumberFieldMapper.NumberType.LONG;
                    maxLeafDocsSupplier,
            queryBuilder,
                return NumberFieldMapper.NumberType.DOUBLE;
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
    <T, R extends Number> BiConsumer<T, T> verifyAggregation(Function<T, R> valueExtractor) {
                            )
        DimensionFieldData(String fieldName, Supplier<Object> valueSupplier, DimensionTypes dimensionType) {
                    verifyAggregation(InternalSum::getValue)
 * SPDX-License-Identifier: Apache-2.0
            DEFAULT_MAX_BUCKETS,
                            Collectors.toMap(
            supportedDimensions,
            List.of(new Metric("hello", List.of(MetricStat.MAX, MetricStat.MIN, MetricStat.AVG))),
import org.opensearch.common.settings.Settings;
            this.valueSupplier = valueSupplier;
        }
                    query,
        if (b.signum() < 0) {
        public MappedFieldType getMappedField(String fieldName) {
        boolean assertCollectorEarlyTermination
import org.opensearch.index.mapper.MapperService;
            starTree,
                // FIXME: Reduce the frequency of nulls to be with at least some non-null docs like after every 1-2 ?
                queryBuilder = qb;
            indexSearcher,
            }
            return new TermQueryBuilder(fieldName, valueSupplier.get());
                )
                    starTree,
import org.apache.lucene.document.DoubleField;
                        .collect(
        IndexSearcher searcher,
import org.opensearch.index.mapper.KeywordFieldMapper;
        }),
            rangeQueryBuilder.toQuery(queryShardContext),
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {
        V starTreeAggregation = searchAndReduceStarTree(
import org.opensearch.search.aggregations.metrics.InternalMin;
        int totalDocs = 100;
import java.util.stream.Stream;
import org.apache.lucene.document.IntField;
package org.opensearch.search.aggregations.startree;
            new DimensionFieldData("dv", () -> random().nextInt(20) - 10, DimensionTypes.INTEGER),
        final List<Supplier<Integer>> MAX_LEAF_DOC_VARIATIONS = List.of(
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
        when(aggregatorFactories.getFactories()).thenReturn(new AggregatorFactory[] { mock(MetricAggregatorFactory.class) });
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
        testCase(
import java.util.Map;
                shouldOnly.should(getTermQueryBuilder());
                getCodec(
            }
            when(mapperService.fieldType(fieldData.fieldName)).thenReturn(fieldData.getMappedField());
        }
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
import java.util.LinkedHashMap;
        IndexSearcher searcher,
import java.util.function.Function;
                    qb,
            searcher,
        }
        IP(new DimensionFieldDataSupplier() {
            @Override
                return NumberFieldMapper.NumberType.UNSIGNED_LONG;
            DEFAULT_MAPPED_FIELD
        SumAggregationBuilder sumAggregationBuilder = sum("_name").field(FIELD_NAME);
import java.util.stream.Collectors;
        testCase(
            starTree,
        }
import org.opensearch.index.compositeindex.datacube.Metric;
        return b.toString();
                    dimensionFieldDatum.stream()
            new DimensionFieldData("float_field", () -> random().nextFloat(50), DimensionTypes.FLOAT),
            false
            }
        when(aggregatorFactory.getSubFactories()).thenReturn(AggregatorFactories.EMPTY);
        }
        return (expectedAggregation, actualAggregation) -> assertEquals(
            new DimensionFieldData("double_field", () -> random().nextDouble(50), DimensionTypes.DOUBLE),
import org.opensearch.search.aggregations.AggregationBuilder;
            aggregatorFactory,
        Map<String, String> metricFieldAndType
        private final Supplier<Object> valueSupplier;
                    qb,
import org.apache.lucene.index.SegmentReader;
            public Dimension getDimension(String fieldName) {
            NumberFieldMapper.NumberType numberType() {
            supportedDimensions,
import org.opensearch.search.aggregations.AggregatorFactory;
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = dimensionFieldData.stream()
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
        public Dimension getDimension(String fieldName) {
        AvgAggregationBuilder avgAggregationBuilder = avg("_name").field(FIELD_NAME);
            assertCollectorEarlyTermination,
            public MappedFieldType getMappedField(String fieldName) {
        QueryShardContext queryShardContext = queryShardContextMock(
                );
            starTree,
        initValuesSourceRegistry();
            List.of(new Metric(FIELD_NAME, List.of(MetricStat.MAX, MetricStat.MIN, MetricStat.AVG))),
                testCase(
            List.of(new Metric(FIELD_NAME, List.of(MetricStat.SUM, MetricStat.MAX, MetricStat.MIN, MetricStat.AVG))),
        MetricAggregatorFactory aggregatorFactory = mock(MetricAggregatorFactory.class);
        QueryBuilder queryBuilder = null;
            null,
            query,
        Query query = null;
        testCase(
                    avgAggregationBuilder,
                return NumberFieldMapper.NumberType.INTEGER;
            }
        @Override
            indexSearcher,
        }),
        SumAggregationBuilder invalidFieldSumAggBuilder = sum("_name").field("hello");
                return new OrdinalDimension(fieldName);
    public void testStarTreeDocValues() throws IOException {
    }
import org.opensearch.index.compositeindex.datacube.MetricStat;
                                LinkedHashMap::new
            sumAggregationBuilder,
            verifyAggregation(InternalSum::getValue),
        DOUBLE(new NumericDimensionFieldDataSupplier() {
                } catch (Exception e) {
        public QueryBuilder getBoolQueryBuilder() {
            }
            }
            }
import org.apache.lucene.document.Document;
            BoolQueryBuilder mustOnly = new BoolQueryBuilder().must(getTermQueryBuilder());
        BiConsumer<V, V> verify
                try {
        );
    private static final MappedFieldType DEFAULT_MAPPED_FIELD = new NumberFieldMapper.NumberFieldType(FIELD_NAME, DEFAULT_FIELD_TYPE);
            BoolQueryBuilder shouldOnly = new BoolQueryBuilder().should(getTermQueryBuilder());
    }
            }
                    indexSearcher,
            false,
            testStarTreeDocValuesInternal(
import org.opensearch.index.query.TermQueryBuilder;
            iw.forceMerge(1);
            mock(ValuesSourceAggregatorFactory.class),
        private final String fieldType;
            supportedDimensions,
                return new KeywordFieldMapper.KeywordFieldType(fieldName, Lucene.STANDARD_ANALYZER);
        private final String fieldName;
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {
                    indexSearcher,
import org.apache.lucene.document.LongField;
            if (fieldType.equals(DimensionTypes.KEYWORD.name().toLowerCase(Locale.ROOT))) {
            List.of(new Metric("hello", List.of(MetricStat.MAX, MetricStat.MIN, MetricStat.AVG))),
                    query,
            List<Object> values = new ArrayList<>(limit);
        }
    }
        when(aggregatorFactory.getMetricStat()).thenReturn(MetricStat.SUM);
            if (random.nextBoolean()) {
        testCase(
            aggregatorFactory,
            @Override
import java.util.List;
    ) throws IOException {
            }
import org.apache.lucene.index.IndexWriterConfig;
                .includeLower(randomBoolean())
            List.of(new Metric(FIELD_NAME, List.of(MetricStat.SUM, MetricStat.MAX, MetricStat.MIN, MetricStat.AVG))),
import org.opensearch.index.mapper.IpFieldMapper;
            @Override
        RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("keyword_field");
        Query query,
        }
        }),
            @Override
                if (random.nextBoolean()) {
            return new RangeQueryBuilder(fieldName).from(valueSupplier.get())
        Random random = RandomizedTest.getRandom();
            () -> randomIntBetween(101, 10_000)
            when(mapperService.fieldType(fieldData.fieldName)).thenReturn(fieldData.getMappedField());
        return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
        for (DimensionFieldData fieldData : dimensionFieldData) {
        Dimension getDimension(String fieldName);
                testCase(
            }, DimensionTypes.UNSIGNED_LONG)
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
        LeafReaderContext context = ir.leaves().get(0);
        conf.setCodec(codec);
            valueExtractor.apply(expectedAggregation).doubleValue(),
import static org.mockito.Mockito.when;
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
        @Override
        ir.close();
            mapperService = StarTreeDocValuesFormatTests.createMapperService(
            new DimensionFieldData("unsigned_long_field", () -> {
        CompositeIndexFieldInfo starTree,
        MappedFieldType getMappedField(String fieldName);
 */
        // Case when the field is not supported by star tree
        for (DimensionFieldData fieldData : dimensionFieldData) {
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;
import com.carrotsearch.randomizedtesting.RandomizedTest;
            aggBuilder,
import static org.opensearch.search.aggregations.AggregationBuilders.min;
        QueryBuilder queryBuilder,
                .to(valueSupplier.get())
        });
            @Override
        DimensionTypes(DimensionFieldDataSupplier dimensionFieldDataSupplier) {
            }
            return dimensionFieldDataSupplier.getMappedField(fieldName);
            verifyAggregation(InternalSum::getValue),
            true
            verifyAggregation(InternalSum::getValue),
                        ),
import org.apache.lucene.document.InetAddressPoint;
                                (v1, v2) -> v1,
            this.dimensionFieldDataSupplier = dimensionType.getFieldDataSupplier();
            indexSearcher,
    }
        IndexSearcher indexSearcher = newSearcher(reader, false, false);
            NumberFieldMapper.NumberType numberType() {
            NumberFieldMapper.NumberType numberType() {
            this.fieldName = fieldName;
        MinAggregationBuilder minAggregationBuilder = min("_name").field(FIELD_NAME);
        when(aggregatorFactory.getField()).thenReturn(FIELD_NAME);
            indexSearcher,
        AggregatorFactory aggregatorFactory,
        }
import org.opensearch.search.aggregations.InternalAggregation;
        }
import org.apache.logging.log4j.Logger;
        Directory directory = newDirectory();
        );
    }
            query,
            );
    ) throws IOException {
import java.util.Locale;
            }
            }
                    query,
            queryBuilder,
        // Index 100 random documents
                return new SortedNumericDocValuesField(fieldName, HalfFloatPoint.halfFloatToSortableShort((Float) valueSupplier.get()));
import java.util.Random;
                testCase(
            createIndexSettings(),
                return NumberFieldMapper.NumberType.FLOAT;
                    starTree,
            query,
