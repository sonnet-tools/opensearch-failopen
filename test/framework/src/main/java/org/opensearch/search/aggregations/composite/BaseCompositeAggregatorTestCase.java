                continue;
        final Map<String, List<Object>> map = new HashMap<>();
        Query query,
                    return new SortedNumericSortField(type.name(), SortField.Type.LONG, false);
            indexSort = buildIndexSort(cab.sources(), types);
                    return null;
            builder.putList("index.sort.order", orders);
import java.util.stream.Collectors;
                            indexWriter.deleteDocuments(new Term("id", Integer.toString(id)));
    }
        return map;
    }
    protected MapperService mapperServiceMock() {
                } else if (value instanceof Double) {
                break;
import org.opensearch.index.mapper.KeywordFieldMapper;
        final Map<String, Object> map = new HashMap<>();
import java.util.Collections;
        DocumentMapper mapper = mock(DocumentMapper.class);
    protected static Map<String, Object> createAfterKey(Object... fields) {
import org.junit.Before;
 * The OpenSearch Contributors require contributions made to
     * @return boolean true or false, based on if value is added or not
import org.opensearch.search.aggregations.AggregationBuilder;
        FIELD_TYPES.add(new IpFieldMapper.IpFieldType("ip"));
    protected static SortField sortFieldFrom(MappedFieldType type) {
        } else if (type.unwrap() instanceof NumberFieldMapper.NumberFieldType) {
        if (aggregationBuilder instanceof CompositeAggregationBuilder && useIndexSort) {
                if (aggregation instanceof InternalComposite) {
     * composite aggregation. If you have added another Composite Aggregation Type then you must override this
import java.util.Map;
        when(mapper.type()).thenReturn("_doc");
            final String name = entry.getKey();
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        for (Map.Entry<String, List<Object>> entry : keys.entrySet()) {
            SortField sortField = sortFieldFrom(type);
import org.apache.lucene.search.SortedSetSortField;
    }
                doc.add(new NumericDocValuesField(name, (int) entry.getValue().get(0)));
        super.tearDown();
            CompositeAggregationBuilder cab = (CompositeAggregationBuilder) aggregationBuilder;
        Settings.Builder builder = Settings.builder();
        when(mapper.typeText()).thenReturn(new Text("_doc"));
                doc.add(new IntPoint(name, (int) entry.getValue().get(0)));
import static org.mockito.Mockito.mock;
import org.apache.lucene.document.NumericDocValuesField;
/*
                case "short":
        super.setUp();
                case "double":
                        "invalid object: " + value.getClass().getSimpleName()
import java.io.IOException;
        Consumer<InternalComposite> verify
        Supplier<CompositeAggregationBuilder> create,
                        }
                }
                    aggregationBuilder,
            } else {
    }
                if (forceMerge || rarely()) {
            remainingFieldTypes.remove(source.field());
            return new SortedSetSortField(type.name(), false);
    }
            String field = (String) fields[i];
        if (type == null) {
                        int numDeletes = randomIntBetween(1, 25);
                            indexWriter.addDocument(document);
import org.apache.lucene.index.IndexReader;
                    doc.add(new SortedNumericDocValuesField(name, (int) value));
                }
    protected static Sort buildIndexSort(List<CompositeValuesSourceBuilder<?>> sources, Map<String, MappedFieldType> fieldTypes) {
                case "float":
    protected static List<MappedFieldType> FIELD_TYPES;
    ) throws IOException {
import org.apache.lucene.document.IntPoint;
                }
 */
    }
    @Override
    @Override
            }
                } else {
                    query,
import org.opensearch.common.time.DateFormatter;
                    doc.add(new SortedNumericDocValuesField(name, (long) value));
            executeTestCase(false, true, query, dataset, create, verify);
import org.apache.lucene.document.DoublePoint;
        FIELD_TYPES = null;
import org.apache.lucene.tests.analysis.MockAnalyzer;
import org.apache.lucene.tests.util.TestUtil;
                            id = randomIntBetween(0, dataset.size() - 1);
    /**
            }
                } else if (value instanceof InetAddress) {
                    indexWriter.forceMerge(1);
import static org.mockito.Mockito.when;
        AggregationBuilder aggregationBuilder = create.get();
    protected boolean addValueToDocument(final Document doc, final String name, final Object value) {
import org.opensearch.core.index.Index;
                    }
                case "long":
import org.apache.lucene.search.Query;
import org.opensearch.core.common.text.Text;
    }
        FIELD_TYPES.add(new NumberFieldMapper.NumberFieldType("double", NumberFieldMapper.NumberType.DOUBLE));
import org.apache.lucene.document.SortedSetDocValuesField;
                        for (int i = 0; i < numDeletes; i++) {
import org.opensearch.search.aggregations.AggregatorTestCase;
import org.apache.lucene.index.IndexWriterConfig;
                            document.clear();
        }
import org.opensearch.index.mapper.MappedFieldType;
            switch (type.typeName()) {
                );
        assert fields.length % 2 == 0;
                case "byte":
                } else if (value instanceof String) {
                    return new SortedNumericSortField(type.name(), SortField.Type.INT, false);
import org.apache.lucene.document.LongPoint;
            executeTestCase(false, false, query, dataset, create, verify);
    }
                    // forceMerge randomly or if the collector-per-leaf testing stuff would break the tests.
        }
            String field = fields.get(between(0, fields.size() - 1));
            List<String> fields = new ArrayList<>(remainingFieldTypes.keySet());
        IndexSettings indexSettings = createIndexSettings(indexSort);
 * this file be licensed under the Apache-2.0 license or a
        }
     * @param value {@link Object} Field value
import org.apache.lucene.store.Directory;
        FIELD_TYPES.add(new NumberFieldMapper.NumberFieldType("long", NumberFieldMapper.NumberType.LONG));
                    doc.add(new InetAddressPoint(name, (InetAddress) value));
        Sort indexSort = null;
    protected static Map<String, List<Object>> createDocument(Object... fields) {
                    indexSearcher,
        for (Query query : queries) {
            if (indexSort != null) {
        for (int i = 0; i < fields.length; i += 2) {
import org.apache.lucene.search.SortedNumericSortField;
        try (Directory directory = newDirectory()) {
        }
            if (name.equals(DocCountFieldMapper.NAME)) {
        return map;
    protected void addToDocument(int id, Document doc, Map<String, List<Object>> keys) {
import java.util.function.Supplier;
import org.apache.lucene.document.SortedNumericDocValuesField;
            Collections.sort(fields);
        when(mapperService.documentMapper()).thenReturn(mapper);
        return IndexSettingsModule.newIndexSettings(new Index("_index", "0"), builder.build());
        return sortFields.size() > 0 ? new Sort(sortFields.toArray(new SortField[0])) : null;
import org.opensearch.test.IndexSettingsModule;
                    doc.add(new SortedNumericDocValuesField(name, NumericUtils.doubleToSortableLong((double) value)));
                default:
        FIELD_TYPES.add(new KeywordFieldMapper.KeywordFieldType("keyword"));
import java.util.HashMap;
    protected void executeTestCase(
                IndexSearcher indexSearcher = new IndexSearcher(indexReader);
import org.opensearch.index.mapper.IpFieldMapper;
    }
        List<Map<String, List<Object>>> dataset,
        List<Map<String, List<Object>>> dataset,
    }
            // Add extra unused sorts
                sortFields.add(sortField);
        for (int i = 0; i < fields.length; i += 2) {
     * @param name {@link String} Field Name
 * compatible open source license.
                    indexWriter.addDocument(document);
                    );
import org.opensearch.common.settings.Settings;
        }
        }
                    return new SortedNumericSortField(type.name(), SortField.Type.DOUBLE, false);
                for (Map<String, List<Object>> fields : dataset) {
        FIELD_TYPES.add(new DateFieldMapper.DateFieldType("date", DateFormatter.forPattern("yyyy-MM-dd||epoch_millis")));
        FIELD_TYPES.add(new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.INTEGER));
                            addToDocument(id, document, dataset.get(id));
    protected static long asLong(String dateTime) {
     * @param doc {@link Document}
    public void setUp() throws Exception {
        return false;
 *
            String[] fields = Arrays.stream(sort.getSort()).map(SortField::getField).toArray(String[]::new);
                    verify.accept((InternalComposite) aggregation);
        MapperService mapperService = mock(MapperService.class);
import org.opensearch.index.mapper.DocCountFieldMapper;
    protected void testSearchCase(
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(dateTime)).toInstant().toEpochMilli();
                map.put(field, Collections.singletonList(fields[i + 1]));
                    if (!addValueToDocument(doc, name, value)) throw new AssertionError(
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory, config)) {
                }
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
                    doc.add(new IntPoint(name, (int) value));
import org.apache.lucene.util.NumericUtils;
import org.apache.lucene.document.InetAddressPoint;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.IndexSearcher;
import org.opensearch.search.aggregations.bucket.composite.InternalComposite;
import org.apache.lucene.document.Field;
import org.apache.lucene.search.SortField;
            builder.putList("index.sort.field", fields);
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.apache.lucene.util.BytesRef;
            MappedFieldType type = fieldTypes.remove(source.field());
        return mapperService;
            if (sortField != null) {
            }
 * Base class for the Aggregator Tests which are registered under Composite Aggregation.
                // doc count field should be DocValuesType.NUMERIC
                    indexSettings,
                } else {
import java.util.function.Function;
import org.opensearch.index.mapper.NumberFieldMapper;
        List<SortField> sortFields = new ArrayList<>();
    }
    }
            return new SortedNumericSortField(type.name(), SortField.Type.LONG, false);
import org.opensearch.index.mapper.DateFieldMapper;
import org.opensearch.index.mapper.MapperService;
import org.opensearch.common.time.DateFormatters;
        for (CompositeValuesSourceBuilder<?> source : sources) {
/**
            for (Object value : entry.getValue()) {
import org.apache.lucene.search.Sort;
            }
            }
        return null;
import java.util.ArrayList;
        List<Query> queries,
import org.apache.lucene.index.DirectoryReader;
        FIELD_TYPES = new ArrayList<>();
            String[] orders = Arrays.stream(sort.getSort()).map((o) -> o.getReverse() ? "desc" : "asc").toArray(String[]::new);
        doc.add(new StringField("id", Integer.toString(id), Field.Store.NO));
            }
        Map<String, MappedFieldType> types = FIELD_TYPES.stream().collect(Collectors.toMap(MappedFieldType::name, Function.identity()));
            if (sortField == null) {
                    doc.add(new LongPoint(name, (long) value));
                    doc.add(new DoublePoint(name, (double) value));
            }
import java.util.Arrays;
                config.setCodec(TestUtil.getDefaultCodec());
        Supplier<? extends AggregationBuilder> create,
            IndexWriterConfig config = newIndexWriterConfig(random(), new MockAnalyzer(random()));
        if (sort != null) {
                case "integer":
    ) throws IOException {
import java.net.InetAddress;
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;
            sortFields.add(sortField);
                    id++;
    @Before
            }
import org.junit.After;
import org.apache.lucene.index.Term;
     */
    @After
            map.put(field, fields[i + 1]);
}
import org.opensearch.search.aggregations.InternalAggregation;
                    addToDocument(id, document, fields);
        }
import org.opensearch.index.mapper.DocumentMapper;
                    if (dataset.size() > 0) {
        Map<String, MappedFieldType> remainingFieldTypes = new HashMap<>(fieldTypes);
        FIELD_TYPES.add(new KeywordFieldMapper.KeywordFieldType("terms"));
            if (fields[i + 1] instanceof List) {
                    doc.add(new StringField(name, new BytesRef((String) value), Field.Store.NO));
                    doc.add(new SortedSetDocValuesField(name, new BytesRef((String) value)));
    @Override
import org.apache.lucene.document.StringField;
import org.opensearch.index.IndexSettings;
public class BaseCompositeAggregatorTestCase extends AggregatorTestCase {
                    document.clear();
                    doc.add(new SortedSetDocValuesField(name, new BytesRef(InetAddressPoint.encode((InetAddress) value))));
            String field = (String) fields[i];
        boolean forceMerge,
                    FIELD_TYPES.toArray(new MappedFieldType[0])
        Consumer<InternalComposite> verify
            return null;
            }
                if (value instanceof Integer) {
        boolean useIndexSort,
     * Override this function to handle any specific type of value you want to add in the document for doing the
        while (remainingFieldTypes.size() > 0 && randomBoolean()) {
        }
        } else if (type.unwrap() instanceof DateFieldMapper.DateFieldType) {
                } else if (value instanceof Long) {
import java.util.function.Consumer;
                Document document = new Document();
    }
import java.util.List;
                config.setIndexSort(indexSort);
        } else if (type.unwrap() instanceof KeywordFieldMapper.KeywordFieldType) {
            SortField sortField = sortFieldFrom(remainingFieldTypes.remove(field));
 */
 * SPDX-License-Identifier: Apache-2.0
    public void tearDown() throws Exception {
                int id = 0;
    protected static IndexSettings createIndexSettings(Sort sort) {
     * function so that your field value can be added in the document correctly.
        }
                InternalAggregation aggregation = searchAndReduce(
     *
        assert fields.length % 2 == 0;
                map.put(field, (List<Object>) fields[i + 1]);
package org.opensearch.search.aggregations.composite;
        }
