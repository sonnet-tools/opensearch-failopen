                config.setCodec(TestUtil.getDefaultCodec());
        return null;  
                    );
            builder.putList("index.sort.field", fields);
            }
                doc.add(new NumericDocValuesField(name, (int) entry.getValue().get(0)));
import java.util.function.Supplier;
                    return null;  
        boolean forceMerge,  
        Consumer<InternalComposite> verify  
    }
                    if (dataset.size() > 0) {
    protected static SortField sortFieldFrom(MappedFieldType type) {
    protected static IndexSettings createIndexSettings(Sort sort) {  
import org.apache.lucene.search.IndexSearcher;  
                        for (int i = 0; i < numDeletes; i++) {  
                case "short":  
                            document.clear();  
            }  
import org.opensearch.index.mapper.DocumentMapper;
        when(mapper.typeText()).thenReturn(new Text("_doc"));  
import org.opensearch.common.settings.Settings;  
                map.put(field, Collections.singletonList(fields[i + 1]));
import org.apache.lucene.store.Directory;  
                } else {  
                    doc.add(new DoublePoint(name, (double) value));
import org.apache.lucene.index.IndexReader;  
        }
                } else if (value instanceof Double) {
import org.apache.lucene.search.SortField;  
    @Override
        }
            switch (type.typeName()) {
                    indexWriter.addDocument(document);  
        }  
import java.util.function.Consumer;
}  
        Consumer<InternalComposite> verify
 * this file be licensed under the Apache-2.0 license or a
                if (forceMerge || rarely()) {  
        return false;
                    query,
 * Base class for the Aggregator Tests which are registered under Composite Aggregation.
                } else {
     * composite aggregation. If you have added another Composite Aggregation Type then you must override this
        IndexSettings indexSettings = createIndexSettings(indexSort);
                        }  
    }
                sortFields.add(sortField);
    }  
        }
        List<Map<String, List<Object>>> dataset,
        } else if (type.unwrap() instanceof DateFieldMapper.DateFieldType) {
    protected void executeTestCase(
import org.opensearch.common.time.DateFormatter;
                    indexSettings,
        if (aggregationBuilder instanceof CompositeAggregationBuilder && useIndexSort) {
import java.io.IOException;  
                // doc count field should be DocValuesType.NUMERIC  
                    doc.add(new SortedNumericDocValuesField(name, (long) value));  
        return map;  
import org.opensearch.search.aggregations.AggregationBuilder;
    protected static Sort buildIndexSort(List<CompositeValuesSourceBuilder<?>> sources, Map<String, MappedFieldType> fieldTypes) {
                    indexWriter.forceMerge(1);
            }
            List<String> fields = new ArrayList<>(remainingFieldTypes.keySet());  
                    id++;
     * function so that your field value can be added in the document correctly.
public class BaseCompositeAggregatorTestCase extends AggregatorTestCase {
    protected boolean addValueToDocument(final Document doc, final String name, final Object value) {  
            String field = fields.get(between(0, fields.size() - 1));
    }  
                    return new SortedNumericSortField(type.name(), SortField.Type.INT, false);
package org.opensearch.search.aggregations.composite;
        FIELD_TYPES.add(new KeywordFieldMapper.KeywordFieldType("terms"));  
            sortFields.add(sortField);
        FIELD_TYPES.add(new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.INTEGER));
                    aggregationBuilder,
        return sortFields.size() > 0 ? new Sort(sortFields.toArray(new SortField[0])) : null;
        if (sort != null) {
import org.opensearch.index.mapper.MapperService;  
    @Before  
            if (fields[i + 1] instanceof List) {
        MapperService mapperService = mock(MapperService.class);
                            addToDocument(id, document, dataset.get(id));
import org.apache.lucene.index.IndexWriterConfig;
        } else if (type.unwrap() instanceof NumberFieldMapper.NumberFieldType) {  
                    }
    protected static Map<String, List<Object>> createDocument(Object... fields) {  
            if (name.equals(DocCountFieldMapper.NAME)) {
        final Map<String, Object> map = new HashMap<>();
        while (remainingFieldTypes.size() > 0 && randomBoolean()) {
                        "invalid object: " + value.getClass().getSimpleName()
        doc.add(new StringField("id", Integer.toString(id), Field.Store.NO));
            String field = (String) fields[i];
        boolean useIndexSort,
    ) throws IOException {
import org.apache.lucene.index.Term;
        Map<String, MappedFieldType> types = FIELD_TYPES.stream().collect(Collectors.toMap(MappedFieldType::name, Function.identity()));
        assert fields.length % 2 == 0;
    @Override
            if (sortField == null) {
        Settings.Builder builder = Settings.builder();
        return mapperService;  
                InternalAggregation aggregation = searchAndReduce(
    /**
    @Override
    protected void addToDocument(int id, Document doc, Map<String, List<Object>> keys) {  
            MappedFieldType type = fieldTypes.remove(source.field());
                continue;
import org.opensearch.index.IndexSettings;
        FIELD_TYPES.add(new KeywordFieldMapper.KeywordFieldType("keyword"));
        } else if (type.unwrap() instanceof KeywordFieldMapper.KeywordFieldType) {
                    addToDocument(id, document, fields);
            final String name = entry.getKey();  
import org.apache.lucene.document.SortedSetDocValuesField;  
import org.apache.lucene.document.DoublePoint;
        }
import org.apache.lucene.document.Field;  
import org.apache.lucene.tests.util.TestUtil;  
        try (Directory directory = newDirectory()) {  
import org.opensearch.search.aggregations.InternalAggregation;
import org.apache.lucene.index.DirectoryReader;
                if (aggregation instanceof InternalComposite) {
import org.apache.lucene.document.StringField;
                }
                    // forceMerge randomly or if the collector-per-leaf testing stuff would break the tests.
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;  
    protected MapperService mapperServiceMock() {  
import org.opensearch.index.mapper.NumberFieldMapper;
import org.apache.lucene.search.SortedSetSortField;
import org.opensearch.common.time.DateFormatters;
            for (Object value : entry.getValue()) {
                config.setIndexSort(indexSort);  
                    indexSearcher,  
                    return new SortedNumericSortField(type.name(), SortField.Type.DOUBLE, false);
    }
import org.apache.lucene.util.BytesRef;
/*  
        return IndexSettingsModule.newIndexSettings(new Index("_index", "0"), builder.build());
                case "integer":
import org.opensearch.index.mapper.KeywordFieldMapper;
        for (CompositeValuesSourceBuilder<?> source : sources) {
        List<Query> queries,  
        final Map<String, List<Object>> map = new HashMap<>();
        FIELD_TYPES.add(new DateFieldMapper.DateFieldType("date", DateFormatter.forPattern("yyyy-MM-dd||epoch_millis")));
import org.apache.lucene.document.IntPoint;
            }
                    doc.add(new StringField(name, new BytesRef((String) value), Field.Store.NO));
        Supplier<? extends AggregationBuilder> create,
        if (type == null) {  
            executeTestCase(false, true, query, dataset, create, verify);
                    doc.add(new SortedSetDocValuesField(name, new BytesRef(InetAddressPoint.encode((InetAddress) value))));  
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
        when(mapperService.documentMapper()).thenReturn(mapper);
            String[] orders = Arrays.stream(sort.getSort()).map((o) -> o.getReverse() ? "desc" : "asc").toArray(String[]::new);
                int id = 0;
                            indexWriter.addDocument(document);
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
     * @param value {@link Object} Field value  
import org.opensearch.index.mapper.DocCountFieldMapper;
            if (indexSort != null) {
import java.util.HashMap;
            }  
        FIELD_TYPES = null;
            String field = (String) fields[i];  
 */  
        AggregationBuilder aggregationBuilder = create.get();
     * @param doc {@link Document}
        for (int i = 0; i < fields.length; i += 2) {
            // Add extra unused sorts
            if (sortField != null) {
    @After
import static org.mockito.Mockito.mock;
import org.apache.lucene.document.NumericDocValuesField;
                }
import org.opensearch.core.index.Index;
        Map<String, MappedFieldType> remainingFieldTypes = new HashMap<>(fieldTypes);  
            String[] fields = Arrays.stream(sort.getSort()).map(SortField::getField).toArray(String[]::new);  
import java.util.ArrayList;
import org.opensearch.index.mapper.DateFieldMapper;  
    }
                            indexWriter.deleteDocuments(new Term("id", Integer.toString(id)));
    }  
                        int numDeletes = randomIntBetween(1, 25);
                case "double":  
    protected void testSearchCase(
                doc.add(new IntPoint(name, (int) entry.getValue().get(0)));
     *  
                );
import org.apache.lucene.tests.analysis.MockAnalyzer;
     * @param name {@link String} Field Name
        FIELD_TYPES = new ArrayList<>();  
                Document document = new Document();
        Sort indexSort = null;  
            }
import org.junit.Before;
    protected static long asLong(String dateTime) {  
import java.util.List;  
                }  
            SortField sortField = sortFieldFrom(type);
        super.setUp();
        }
            }  
    }
import java.util.Collections;
                } else if (value instanceof InetAddress) {
import org.apache.lucene.search.SortedNumericSortField;
            } else {
        }
    ) throws IOException {  
                    document.clear();
                    doc.add(new SortedNumericDocValuesField(name, (int) value));  
 * compatible open source license.
import static org.mockito.Mockito.when;
        }
        }
            }
    }  
     * Override this function to handle any specific type of value you want to add in the document for doing the  
import org.opensearch.core.common.text.Text;  
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(dateTime)).toInstant().toEpochMilli();
                    doc.add(new SortedSetDocValuesField(name, new BytesRef((String) value)));  
                for (Map<String, List<Object>> fields : dataset) {  
                    doc.add(new LongPoint(name, (long) value));
import java.util.function.Function;  
import org.opensearch.index.mapper.MappedFieldType;
    public void tearDown() throws Exception {  
     */
                break;  
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
                    return new SortedNumericSortField(type.name(), SortField.Type.LONG, false);
 * The OpenSearch Contributors require contributions made to  
        for (Query query : queries) {
                case "long":  
import org.opensearch.search.aggregations.AggregatorTestCase;  
    public void setUp() throws Exception {
import org.apache.lucene.document.Document;
import java.util.stream.Collectors;
 *
 */  
import java.net.InetAddress;
import org.apache.lucene.search.Sort;
    }
import org.opensearch.test.IndexSettingsModule;
                }  
        assert fields.length % 2 == 0;  
                if (value instanceof Integer) {
            Collections.sort(fields);
        }  
                default:
import org.apache.lucene.search.Query;
import org.opensearch.search.aggregations.bucket.composite.InternalComposite;
import org.apache.lucene.util.NumericUtils;
            SortField sortField = sortFieldFrom(remainingFieldTypes.remove(field));  
        FIELD_TYPES.add(new IpFieldMapper.IpFieldType("ip"));
                            id = randomIntBetween(0, dataset.size() - 1);
    protected static Map<String, Object> createAfterKey(Object... fields) {
        DocumentMapper mapper = mock(DocumentMapper.class);
                    if (!addValueToDocument(doc, name, value)) throw new AssertionError(  
    }  
        when(mapper.type()).thenReturn("_doc");
            map.put(field, fields[i + 1]);
        FIELD_TYPES.add(new NumberFieldMapper.NumberFieldType("long", NumberFieldMapper.NumberType.LONG));
/**
            return null;
        List<SortField> sortFields = new ArrayList<>();
                    doc.add(new SortedNumericDocValuesField(name, NumericUtils.doubleToSortableLong((double) value)));  
                case "byte":
        Supplier<CompositeAggregationBuilder> create,
                    FIELD_TYPES.toArray(new MappedFieldType[0])  
import java.util.Arrays;  
import org.junit.After;  
            indexSort = buildIndexSort(cab.sources(), types);  
            return new SortedSetSortField(type.name(), false);  
                IndexSearcher indexSearcher = new IndexSearcher(indexReader);  
            }
        for (int i = 0; i < fields.length; i += 2) {  
            return new SortedNumericSortField(type.name(), SortField.Type.LONG, false);
            IndexWriterConfig config = newIndexWriterConfig(random(), new MockAnalyzer(random()));
                    doc.add(new InetAddressPoint(name, (InetAddress) value));
            CompositeAggregationBuilder cab = (CompositeAggregationBuilder) aggregationBuilder;
        FIELD_TYPES.add(new NumberFieldMapper.NumberFieldType("double", NumberFieldMapper.NumberType.DOUBLE));  
                    doc.add(new IntPoint(name, (int) value));
import org.apache.lucene.document.InetAddressPoint;
            builder.putList("index.sort.order", orders);  
     * @return boolean true or false, based on if value is added or not
                } else if (value instanceof Long) {
import org.apache.lucene.document.SortedNumericDocValuesField;
                case "float":
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory, config)) {  
            remainingFieldTypes.remove(source.field());  
            executeTestCase(false, false, query, dataset, create, verify);  
import org.opensearch.index.mapper.IpFieldMapper;  
    protected static List<MappedFieldType> FIELD_TYPES;  
        List<Map<String, List<Object>>> dataset,  
                    verify.accept((InternalComposite) aggregation);  
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.apache.lucene.document.LongPoint;  
        return map;
        super.tearDown();
        Query query,
        for (Map.Entry<String, List<Object>> entry : keys.entrySet()) {
                map.put(field, (List<Object>) fields[i + 1]);  
    }  
                } else if (value instanceof String) {
