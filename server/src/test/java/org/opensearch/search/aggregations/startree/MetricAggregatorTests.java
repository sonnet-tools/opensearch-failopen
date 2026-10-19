            rangeQueryBuilder,  
    ) throws IOException {  
        when(aggregatorFactory.getSubFactories()).thenReturn(AggregatorFactories.EMPTY);  
            testStarTreeDocValuesInternal(  
        );
            query,
import org.opensearch.index.query.QueryShardContext;
                );
        FLOAT(new NumericDimensionFieldDataSupplier() {  
            } else {  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
    private <T extends AggregationBuilder, V extends InternalAggregation> void testCase(
            new DimensionFieldData("double_field", () -> random().nextDouble(50), DimensionTypes.DOUBLE),
        IP(new DimensionFieldDataSupplier() {
        AggregatorFactories aggregatorFactories = mock(AggregatorFactories.class);
                    indexSearcher,  
            false
                    StarTreeFilterTests.METRIC_TYPE_MAP  
                shouldOnly.should(getRangeQueryBuilder());
        private final String fieldType;
                return new DoubleField(fieldName, (Double) valueSupplier.get(), Field.Store.YES);
            mapperService = StarTreeDocValuesFormatTests.createMapperService(  
import java.util.function.Function;
            null,
    }
            queryBuilder,
            indexSearcher,
            }
                return NumberFieldMapper.NumberType.FLOAT;
    private String asUnsignedDecimalString(long l) {  
        IndexSearcher searcher,
        Query query = null;  
import org.apache.lucene.document.DoubleField;
        public DimensionFieldDataSupplier getFieldDataSupplier() {  
import org.opensearch.search.aggregations.metrics.MetricAggregatorFactory;  
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions, // FIXME : Merge with the same input that goes to generating the
        }),  
        return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        // Case when sub aggregations are present
                    query,
        // Case when the field is not supported by star tree  
            supportedDimensions,  
import java.util.Collections;
            return new NumericDimension(fieldName);
            @Override
                shouldOnly.should(getTermQueryBuilder());  
    private interface DimensionFieldDataSupplier {
    private static class DimensionFieldData {
import org.opensearch.index.compositeindex.datacube.Metric;  
            aggregatorFactory,
        DOUBLE(new NumericDimensionFieldDataSupplier() {
import static org.opensearch.search.aggregations.AggregationBuilders.min;
        );
        IndexSearcher searcher,
import org.opensearch.index.mapper.MapperService;
        RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("keyword_field");
            queryBuilder,
            aggBuilder,
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,
                    verifyAggregation(InternalAvg::getValue)  
            @Override
                    valueCountAggregationBuilder,  
 * compatible open source license.
            indexSearcher,  
            public Dimension getDimension(String fieldName) {
            this.fieldType = dimensionType.name().toLowerCase(Locale.ROOT);
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
                return objectToUnsignedLong(asUnsignedDecimalString(queryValue), false);
            }  
        // Case when field and metric type in aggregation are fully supported by star tree.
import org.apache.lucene.sandbox.document.HalfFloatPoint;
                    avgAggregationBuilder,  
        // Case when aggregation factory is not metric aggregation
            @Override
        HALF_FLOAT(new NumericDimensionFieldDataSupplier() {
            }
        BigInteger b = BigInteger.valueOf(l);
                dimensionFieldDatum
        }
        public QueryBuilder getRangeQueryBuilder() {  
            DEFAULT_MAX_BUCKETS,
            aggregatorFactory,  
import org.opensearch.index.mapper.NumberFieldMapper;
            public MappedFieldType getMappedField(String fieldName) {
import org.opensearch.common.lucene.Lucene;
            verifyAggregation(InternalSum::getValue),  
 *
    private String randomIp() {
            NumberFieldMapper.NumberType numberType() {  
import org.apache.lucene.index.SegmentReader;  
            supportedDimensions,
        private final String fieldName;
        T aggBuilder,
                    ? 9223372036854775807L - random().nextInt(100000)
                testCase(
        ValueCountAggregationBuilder valueCountAggregationBuilder = count("_name").field(FIELD_NAME);
import java.io.IOException;  
            new DimensionFieldData("dv", () -> random().nextInt(20) - 10, DimensionTypes.INTEGER),
        Random random = RandomizedTest.getRandom();
        iw.close();
            sumAggregationBuilder,  
        final List<DimensionFieldData> dimensionFieldDatum = List.of(  
        );
import org.apache.lucene.store.Directory;
            BoolQueryBuilder mustWithShould = new BoolQueryBuilder().must(getTermQueryBuilder())
                }
        }
                return new OrdinalDimension(fieldName);
        // Keyword Range query with missing Low Ordinal  
            }  
import java.util.Map;
                    qb,
                    starTree,
                    minAggregationBuilder,  
            return dimensionFieldDataSupplier.getDimension(fieldName);  
            () -> randomIntBetween(2, 100),  
            @Override  
                .flatMap(  
                    supportedDimensions,
import org.apache.lucene.index.IndexWriterConfig;  
        MapperService mapperService;
        }  
        );
        CompositeIndexFieldInfo starTree,  
import org.opensearch.common.settings.Settings;
    protected Codec getCodec(
import org.opensearch.index.codec.composite.CompositeIndexReader;
            for (DimensionFieldData fieldData : dimensionFieldData) {  
        when(aggregatorFactory.getSubFactories()).thenReturn(aggregatorFactories);  
        SumAggregationBuilder sumAggregationBuilder = sum("_name").field(FIELD_NAME);
            }
            @Override  
        for (DimensionFieldData fieldData : dimensionFieldData) {
            rangeQueryBuilder.toQuery(queryShardContext),
                StarTreeFilterTests.getExpandedMapping(maxLeafDocsSupplier.get(), false, dimensionAndType, metricFieldAndType)
            new DimensionFieldData("float_field", () -> random().nextFloat(50), DimensionTypes.FLOAT),  
        for (int cases = 0; cases < 15; cases++) {  
        );
import org.apache.lucene.search.IndexSearcher;
            starTree,
        final Logger testLogger = LogManager.getLogger(MetricAggregatorTests.class);  
            return dimensionFieldDataSupplier.getMappedField(fieldName);
            sumAggregationBuilder,  
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
        );
import static org.opensearch.search.aggregations.AggregationBuilders.count;  
        private final Supplier<Object> valueSupplier;  
            this.fieldName = fieldName;
            }
                .toList();  
                } catch (Exception e) {
            );
        );
import static org.mockito.Mockito.when;  
            indexSearcher,
            starTree,
            new DimensionFieldData("unsigned_long_field", () -> {  
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
        );  
        for (Supplier<Integer> maxLeafDocsSupplier : MAX_LEAF_DOC_VARIATIONS) {
import org.opensearch.common.util.MockBigArrays;  
        }
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {  
            }
}  
            createIndexSettings(),  
            List<Object> values = new ArrayList<>(limit);
        });
                mustOnly.must(getTermQueryBuilder());
            query,
        AvgAggregationBuilder avgAggregationBuilder = avg("_name").field(FIELD_NAME);
                testCase(
        CompositeIndexFieldInfo starTree,  
        MappedFieldType getMappedField(String fieldName);
            }  
            sumAggregationBuilder,
import java.net.InetAddress;
                doc.add(new SortedNumericDocValuesField(FIELD_NAME, val));
        Random r = random();  
        }  
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
    }
        LinkedHashMap<String, String> dimensionAndType,  
                    x -> Stream.of(x.getTermQueryBuilder(), x.getTermsQueryBuilder(), x.getRangeQueryBuilder(), x.getBoolQueryBuilder())
        LONG(new NumericDimensionFieldDataSupplier() {
import org.opensearch.search.aggregations.AggregatorFactory;
    private enum DimensionTypes {
import org.opensearch.search.aggregations.metrics.InternalMax;
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.apache.logging.log4j.Logger;
import java.util.List;  
            query,
            sumAggregationBuilder,
            queryBuilder,  
        rangeQueryBuilder.from(Long.MAX_VALUE).includeLower(random().nextBoolean());
                return new KeywordField(fieldName, String.valueOf(valueSupplier.get()), Field.Store.YES);
        testCase(searcher, query, queryBuilder, aggBuilder, starTree, supportedDimensions, Collections.emptyList(), verify, null, true);
        testCase(  
                    verifyAggregation(InternalMin::getValue)  
import org.opensearch.search.aggregations.InternalAggregation;
import org.apache.lucene.document.Field;  
            }, DimensionTypes.UNSIGNED_LONG)  
        @Override
            when(mapperService.fieldType(fieldData.fieldName)).thenReturn(fieldData.getMappedField());  
            NumberFieldMapper.NumberType numberType() {
import org.apache.lucene.index.IndexableField;
        IndexWriterConfig conf = newIndexWriterConfig(null);  
                }
            queryBuilder,
                    : -9223372036854775808L + random().nextInt(100000);  
        QueryShardContext queryShardContext = queryShardContextMock(
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        );
                try {
        }),  
                    supportedDimensions,
        IndexableField getField(String fieldName, Supplier<Object> valueSupplier);  
        KEYWORD(new DimensionFieldDataSupplier() {
            queryBuilder,
                Collectors.toMap(DimensionFieldData::getDimension, DimensionFieldData::getMappedField, (v1, v2) -> v1, LinkedHashMap::new)  
        // Index 100 random documents  
import org.opensearch.index.query.BoolQueryBuilder;  
    private static final NumberFieldMapper.NumberType DEFAULT_FIELD_TYPE = NumberFieldMapper.NumberType.LONG;
            }  
            return dimensionFieldDataSupplier.getField(fieldName, valueSupplier);
    private <T extends AggregationBuilder, V extends InternalAggregation> void testCase(
            indexSearcher,  
    }  
            verifyAggregation(InternalSum::getValue),
    ) throws IOException {
            NumberFieldMapper.NumberType numberType() {
    <T, R extends Number> BiConsumer<T, T> verifyAggregation(Function<T, R> valueExtractor) {
        }  
        testCase(  
                    indexSearcher,  
        when(aggregatorFactories.getFactories()).thenReturn(new AggregatorFactory[] { mock(MetricAggregatorFactory.class) });
        conf.setCodec(codec);
        }
        testCase(
            () -> 1,
                    qb,
            for (int i = 0; i < limit; i++) {  
            @Override  
                queryBuilder = qb;
            DEFAULT_MAPPED_FIELD  
        public MappedFieldType getMappedField(String fieldName) {  
            starTree,
            null,
            invalidFieldSumAggBuilder.build(queryShardContext, null),
        for (DimensionFieldData fieldData : dimensionFieldData) {
            supportedDimensions,  
    }
import org.apache.lucene.document.Document;
                testCase(
            false  
        AggregatorFactory aggregatorFactory,
                    starTree,
                mustOnly.must(getRangeQueryBuilder());
        if (b.signum() < 0) {
            false
            @Override  
                return new SortedNumericDocValuesField(fieldName, HalfFloatPoint.halfFloatToSortableShort((Float) valueSupplier.get()));
            assertCollectorEarlyTermination,
                    qb,
            @Override
import org.apache.lucene.util.BytesRef;  
    }
                                LinkedHashMap::new  
        }
        V expectedAggregation = searchAndReduceStarTree(
        MetricAggregatorFactory aggregatorFactory = mock(MetricAggregatorFactory.class);
            }
import org.apache.lucene.index.DirectoryReader;
                return new BigIntegerField(fieldName, (BigInteger) valueSupplier.get(), Field.Store.YES);
        MinAggregationBuilder minAggregationBuilder = min("_name").field(FIELD_NAME);  
            true
        ir.close();
        when(aggregatorFactory.getField()).thenReturn(FIELD_NAME);
            indexSearcher,  
                return new LongField(fieldName, (Integer) valueSupplier.get(), Field.Store.YES);
            starTree,
                long queryValue = randomBoolean()
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;  
            }
            valueExtractor.apply(actualAggregation).doubleValue(),
        INTEGER(new NumericDimensionFieldDataSupplier() {  
import org.apache.lucene.document.LongField;
            DEFAULT_MAX_BUCKETS,
    }
        SegmentReader reader = Lucene.segmentReader(context.reader());
        Dimension getDimension(String fieldName);
            }  
            indexSearcher,
        CircuitBreakerService circuitBreakerService = new NoneCircuitBreakerService();  
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();  
            supportedMetrics,
                return NumberFieldMapper.NumberType.LONG;
            List.of(new Metric(FIELD_NAME, List.of(MetricStat.MAX, MetricStat.MIN, MetricStat.AVG))),
            starTree,
                                DimensionFieldData::getFieldType,
            sumAggregationBuilder,
                );
            return fieldType;  
import org.opensearch.index.compositeindex.datacube.NumericDimension;
            indexSearcher,
            }
                )
import org.opensearch.search.aggregations.metrics.InternalSum;  
        testCase(  
    }
                    maxAggregationBuilder,  
                .must(new BoolQueryBuilder().should(getTermQueryBuilder()).should(getTermQueryBuilder()));  
import org.apache.lucene.index.LeafReaderContext;
            indexSearcher,
                return new KeywordFieldMapper.KeywordFieldType(fieldName, Lucene.STANDARD_ANALYZER);  
            }
            BoolQueryBuilder mustOnly = new BoolQueryBuilder().must(getTermQueryBuilder());  
            Document doc = new Document();
        // codec.
            starTree,  
        public IndexableField getField() {
    private static final MappedFieldType DEFAULT_MAPPED_FIELD = new NumberFieldMapper.NumberFieldType(FIELD_NAME, DEFAULT_FIELD_TYPE);
                return NumberFieldMapper.NumberType.DOUBLE;
        LeafReaderContext context = ir.leaves().get(0);
import org.opensearch.index.mapper.MappedFieldType;  
import org.apache.lucene.document.KeywordField;
            when(queryShardContext.fieldMapper(fieldData.fieldName)).thenReturn(fieldData.getMappedField());
            @Override
                    starTree,
import org.opensearch.search.aggregations.metrics.InternalValueCount;
            circuitBreakerService,
            starTree,
                    return new SortedSetDocValuesField(fieldName, new BytesRef(InetAddressPoint.encode(address)));  
        UNSIGNED_LONG(new NumericDimensionFieldDataSupplier() {
            queryBuilder,  
                );
                    dimensionFieldDatum.stream()  
        }),  
import org.opensearch.search.aggregations.AggregatorTestCase;  
 * this file be licensed under the Apache-2.0 license or a
        }
                    throw new RuntimeException(e);  
            public Dimension getDimension(String fieldName) {
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
                return NumberFieldMapper.NumberType.INTEGER;  
public class MetricAggregatorTests extends AggregatorTestCase {
            () -> randomIntBetween(101, 10_000)
            List.of(new Metric("hello", List.of(MetricStat.MAX, MetricStat.MIN, MetricStat.AVG))),
            @Override
            }
        public Dimension getDimension(String fieldName) {
            if (fieldType.equals(DimensionTypes.KEYWORD.name().toLowerCase(Locale.ROOT))) {
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {  
        directory.close();
            }  
            // Get all types of queries (Term/Terms/Range) for all the given dimensions.
            sumAggregationBuilder,
            @Override
            supportedDimensions,
import java.util.stream.Stream;
            this.dimensionFieldDataSupplier = dimensionFieldDataSupplier;  
            valueExtractor.apply(expectedAggregation).doubleValue(),
        @Override  
            supportedDimensions,
        V starTreeAggregation = searchAndReduceStarTree(
            DEFAULT_MAPPED_FIELD  
import org.apache.lucene.document.FloatField;
                    maxLeafDocsSupplier,
            NumberFieldMapper.NumberType numberType() {
                    verifyAggregation(InternalMax::getValue)  
            createIndexSettings(),
            public MappedFieldType getMappedField(String fieldName) {
            return new RangeQueryBuilder(fieldName).from(valueSupplier.get())
            assertCollectorEarlyTermination,
        public String getFieldType() {
                getCodec(
            verifyAggregation(InternalSum::getValue),
            starTree,
            false,  
            throw new RuntimeException(e);
                return new IpFieldMapper.IpFieldType(fieldName);  
            null,  
            new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), circuitBreakerService).withCircuitBreaking()  
            supportedDimensions,
            );
    }  
            return randomFrom(mustOnly, mustWithShould, shouldOnly);
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;  
        initValuesSourceRegistry();
import org.apache.lucene.tests.index.RandomIndexWriter;
            searcher,
            List.of(new Metric(FIELD_NAME, List.of(MetricStat.SUM, MetricStat.MAX, MetricStat.MIN, MetricStat.AVG))),
import org.opensearch.search.aggregations.metrics.InternalAvg;  
                    query,
import static org.mockito.Mockito.mock;
            }
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);
    public void testStarTreeDocValues() throws IOException {  
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = dimensionFieldData.stream()
            }  
                    indexSearcher,  
        DimensionTypes(DimensionFieldDataSupplier dimensionFieldDataSupplier) {
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);  
        }
            new DimensionFieldData("sndv", () -> random().nextInt(10) - 5, DimensionTypes.INTEGER),
                    qb,
        private final DimensionFieldDataSupplier dimensionFieldDataSupplier;  
            }
            false // Invalid fields will return null StarTreeQueryContext which will not cause early termination by leaf collector  
        QueryBuilder queryBuilder = null;
        MaxAggregationBuilder maxAggregationBuilder = max("_name").field(FIELD_NAME);
            int limit = randomIntBetween(1, 20);
        public QueryBuilder getTermQueryBuilder() {
            }
    private static final String FIELD_NAME = "field";  
                            Collectors.toMap(
            List<QueryBuilder> allFieldQueries = dimensionFieldData.stream()
                    indexSearcher,  
                    qb,
import com.carrotsearch.randomizedtesting.RandomizedTest;
    private abstract static class NumericDimensionFieldDataSupplier implements DimensionFieldDataSupplier {
        DimensionFieldData(String fieldName, Supplier<Object> valueSupplier, DimensionTypes dimensionType) {
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {
            return new TermQueryBuilder(fieldName, valueSupplier.get());  
        final List<Supplier<Integer>> MAX_LEAF_DOC_VARIATIONS = List.of(
            );  
        if (randomBoolean()) {
        when(aggregatorFactory.getMetricStat()).thenReturn(MetricStat.SUM);
            .collect(
                .to(valueSupplier.get())
    private void testStarTreeDocValuesInternal(Codec codec, List<DimensionFieldData> dimensionFieldData) throws IOException {
                    query,
            mapperService,  
import java.util.Random;  
            query,
        );
            mock(ValuesSourceAggregatorFactory.class),
                values.add(valueSupplier.get());
package org.opensearch.search.aggregations.startree;
                return NumberFieldMapper.NumberType.HALF_FLOAT;  
                    sumAggregationBuilder,  
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {  
            verifyAggregation(InternalSum::getValue),
            null,  
import org.opensearch.search.aggregations.AggregatorFactories;
/*  
    }
            query,  
                return NumberFieldMapper.NumberType.UNSIGNED_LONG;
        testCase(
import java.util.function.Supplier;  
        // Case when metric type in aggregation is not supported by star tree but the field is supported.  
        Supplier<Integer> maxLeafDocsSupplier,
            false,  
        );
        }),
                );
            query,
                .includeLower(randomBoolean())  
            List.of(new Metric("hello", List.of(MetricStat.MAX, MetricStat.MIN, MetricStat.AVG))),  
        );
                    starTree,
                    starTree,
            supportedDimensions,  
import org.apache.logging.log4j.LogManager;  
            if (random.nextBoolean()) {  
    }  
            }  
            }
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            }
                    doc.add(fieldData.getField());  
        Directory directory = newDirectory();
                            )
        MapperService mapperService = mapperServiceMock();
        }  
import org.apache.lucene.document.SortedSetDocValuesField;
            aggregatorFactory,
        }
        }),
            if (fieldType.equals(DimensionTypes.KEYWORD.name().toLowerCase(Locale.ROOT))) {
            return new NumberFieldMapper.NumberFieldType(fieldName, numberType());
 */  
 * The OpenSearch Contributors require contributions made to  
                ),
        return b.toString();
        QueryBuilder queryBuilder,
                );
import org.apache.lucene.search.Query;  
            invalidFieldSumAggBuilder,  
        try {
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
            List.of(new Metric(FIELD_NAME, List.of(MetricStat.SUM, MetricStat.MAX, MetricStat.MIN, MetricStat.AVG))),  
        }
                val = random.nextInt(50); // Random long between 0 and 49
            Collections.emptyList(),  
                    query,
        DirectoryReader ir = DirectoryReader.open(directory);  
            this.dimensionFieldDataSupplier = dimensionType.getFieldDataSupplier();
import java.util.LinkedHashMap;
                        .collect(
            new DimensionFieldData("long_field", () -> random().nextInt(50), DimensionTypes.LONG),
        }
            verifyAggregation(InternalSum::getValue),
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {  
            @Override  
        public MappedFieldType getMappedField() {  
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);  
            @Override
import org.apache.lucene.codecs.Codec;
import org.apache.lucene.document.SortedNumericDocValuesField;  
    }
        public QueryBuilder getTermsQueryBuilder() {  
                return new IntField(fieldName, (Integer) valueSupplier.get(), Field.Store.YES);
                return new FloatField(fieldName, (Float) valueSupplier.get(), Field.Store.YES);  
            }  
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                .includeUpper(randomBoolean());
                    indexSearcher,  
            query,
        public QueryBuilder getBoolQueryBuilder() {
        List<Metric> supportedMetrics,  
        return (expectedAggregation, actualAggregation) -> assertEquals(  
            new DimensionFieldData("half_float_field", () -> random().nextFloat(50), DimensionTypes.HALF_FLOAT),
        verify.accept(expectedAggregation, starTreeAggregation);
import org.opensearch.search.aggregations.metrics.InternalMin;
            new DimensionFieldData("ip_field", this::randomIp, DimensionTypes.IP),
                                (v1, v2) -> v1,
            when(mapperService.fieldType(fieldData.fieldName)).thenReturn(fieldData.getMappedField());
            @Override  
                    verifyAggregation(InternalSum::getValue)  
import java.math.BigInteger;
        BiConsumer<V, V> verify
        testCase(
import java.util.stream.Collectors;
import org.opensearch.common.util.MockPageCacheRecycler;
            return dimensionFieldDataSupplier;
            @Override
            aggregatorFactory,
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {
            0.0f  
                    supportedDimensions,
                testCase(
                return new OrdinalDimension(fieldName);
            NumberFieldMapper.NumberType numberType() {
            // MUST with nested SHOULD on same dimension
import org.opensearch.index.query.TermsQueryBuilder;
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.objectToUnsignedLong;
                        ),
            BoolQueryBuilder shouldOnly = new BoolQueryBuilder().should(getTermQueryBuilder());  
import org.apache.lucene.document.IntField;  
        boolean assertCollectorEarlyTermination  
        private final DimensionFieldDataSupplier dimensionFieldDataSupplier;
            // MUST only
            @Override  
import org.opensearch.index.codec.composite.composite104.Composite104Codec;  
                // FIXME: Reduce the frequency of nulls to be with at least some non-null docs like after every 1-2 ?
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
            false
import org.opensearch.index.compositeindex.datacube.Dimension;
        for (int i = 0; i < totalDocs; i++) {
        }
            aggregatorFactory,  
        Map<String, String> metricFieldAndType
                    InetAddress address = InetAddress.getByName((String) valueSupplier.get());
                query = qb.toQuery(queryShardContext);  
        }),
            supportedDimensions,  
            public IndexableField getField(String fieldName, Supplier<Object> valueSupplier) {  
            verifyAggregation(InternalSum::getValue),
        Query query,  
        SumAggregationBuilder invalidFieldSumAggBuilder = sum("_name").field("hello");
 * SPDX-License-Identifier: Apache-2.0
            queryBuilder,  
                testCase(
            @Override
                if (random.nextBoolean()) {
            query,
            aggBuilder,
        Query query,  
import org.opensearch.search.aggregations.AggregationBuilder;  
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
            aggregatorFactory,
            verifyAggregation(InternalSum::getValue),
        // Case when field is not present in supported metrics
            createIndexSettings(),  
        testCase(
        int val;
                    verifyAggregation(InternalValueCount::getValue)  
        }
            // SHOULD only on same dimension
                    supportedDimensions,
        int totalDocs = 100;  
            b = b.add(BigInteger.ONE.shiftLeft(64));  
        IndexSearcher indexSearcher = newSearcher(reader, false, false);
                    supportedDimensions,
import java.util.Locale;
        );
        }  
        }  
            iw.addDocument(doc);
        QueryBuilder queryBuilder,
    }
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
import org.opensearch.index.mapper.IpFieldMapper;
            this.valueSupplier = valueSupplier;  
                    query,
        }),
import java.util.ArrayList;  
import org.opensearch.index.query.RangeQueryBuilder;  
        abstract NumberFieldMapper.NumberType numberType();
            NumberFieldMapper.NumberType numberType() {
        }  
import org.opensearch.index.query.TermQueryBuilder;
            iw.forceMerge(1);
        }
            new DimensionFieldData("keyword_field", () -> random().nextInt(50), DimensionTypes.KEYWORD),  
import org.opensearch.index.mapper.KeywordFieldMapper;
import org.opensearch.index.query.QueryBuilder;
            @Override
            } else {
import org.opensearch.index.compositeindex.datacube.MetricStat;
            queryBuilder,  
            List.of(new Metric("hello", List.of(MetricStat.MAX, MetricStat.MIN, MetricStat.AVG))),
        } catch (IOException e) {  
        T aggBuilder,
        BiConsumer<V, V> verify,
        }
        conf.setMergePolicy(newLogMergePolicy());
            return new TermsQueryBuilder(fieldName, values);  
        public Dimension getDimension() {
import java.util.function.BiConsumer;
import org.apache.lucene.document.InetAddressPoint;
            searcher,
            true  
                                df -> df.getDimension().getField(),  
    ) {
            for (QueryBuilder qb : allFieldQueries) {
