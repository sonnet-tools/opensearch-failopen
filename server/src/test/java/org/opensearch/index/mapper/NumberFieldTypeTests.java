        {
        Query expected = new ApproximateScoreQuery(
        assertEquals(1.1f, NumberType.HALF_FLOAT.parse(1.1, true));
            new IndexOrDocValuesQuery(new BitmapIndexQuery("field", r), new BitmapDocValuesQuery("field", r)),
    public void testUnsignedLongRangeQuery() {
        assertEquals(
        assertEquals(3.5f, NumberType.FLOAT.parse(3.5, true));
import org.opensearch.core.xcontent.XContentBuilder;
    public void testDocValueByteRange() throws Exception {
        );
            boolean includeUpper = randomBoolean();
        assertEquals((byte) 5, NumberType.BYTE.parse("5.9", true));
import java.util.function.Supplier;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        );
            type = t;
        IndexNumericFieldData fielddata = (IndexNumericFieldData) fieldType.fielddataBuilder("index", () -> {
                assertEquals(searcher.count(indexOrDvQuery.getIndexQuery()), searcher.count(indexOrDvQuery.getRandomAccessQuery()));
        assertEquals(3L, NumberType.LONG.parse(3.5, true));
        assertEquals(1.1d, NumberType.DOUBLE.parse(1.1, true));
        );
        assertEquals(BigInteger.valueOf(5), NumberType.UNSIGNED_LONG.parse("5.0", true));
import org.apache.lucene.document.SortedNumericDocValuesField;
        e = expectThrows(IllegalArgumentException.class, () -> NumberType.INTEGER.parse(2147483648L, true));
            boolean includeUpper = randomBoolean();
        }
    }
        final int numDocs = 10000;
        assertEquals(
            ft.rangeQuery(1.1, 10, false, true, null, null, null, MOCK_QSC)
        );
            if (value instanceof BigInteger) {
            ftLong.rangeQuery(0, 2, true, true, null, null, null, MOCK_QSC),
                DoublePoint.pack(new double[] { 3d }).bytes,
        assertEquals((short) 5, NumberType.SHORT.parse(new BytesRef("5.3".getBytes(StandardCharsets.UTF_8)), true));
            NumberType.FLOAT.rangeQuery("field", null, -0f, true, true, false, true, MOCK_QSC),
        assertEquals(new MatchNoDocsQuery(), ft.bitmapQuery(bitmap).rewrite(newSearcher(reader)));
    public void testUnsignedLongRangeQueryWithDecimalParts() {
            ft.rangeQuery(1.1, 10, false, true, null, null, null, MOCK_QSC)
            ftLong.rangeQuery(0, 0, true, true, null, null, null, MOCK_QSC),
        ft = new NumberFieldType("field", NumberType.INTEGER, true, false, false, false, true, null, Collections.emptyMap());
 * the Apache License, Version 2.0 (the "License"); you may
    public void testByteTermQueryWithDecimalPart() {
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.document.IntPoint;
        assertEquals(
        final Object value;
        assertEquals(
        assertEquals(expected, ft.rangeQuery("1", "3", true, true, null, null, null, MOCK_QSC));
        IllegalArgumentException e = expectThrows(
        for (OutOfRangeSpec item : inputs) {
import org.opensearch.index.document.SortedUnsignedLongDocValuesSetQuery;
        );
        );
            ftInt.rangeQuery(0, 2, true, true, null, null, null, MOCK_QSC),
    public void testDisplayValue() {
        Roaring64NavigableMap r = new Roaring64NavigableMap();
            }
        assertEquals(3.5d, NumberType.DOUBLE.parse(3.5, true));
        );
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, Float.POSITIVE_INFINITY, "[half_float] supports only finite values"),
    }
        final int iters = 10;
        }
            Double.valueOf(1.2),
        assertEquals((short) 5, NumberType.SHORT.parse("5", true));
                "field",
 * SPDX-License-Identifier: Apache-2.0
            IndexNumericFieldData fielddata = (IndexNumericFieldData) ft.fielddataBuilder(
            OutOfRangeSpec.of(NumberType.SHORT, -32769, "is out of range for a short"),
    }
        NumberFieldType fieldType = new NumberFieldType("field", type);
            r.serializePortable(dos);
        );
import org.opensearch.core.common.bytes.BytesArray;
        assertEquals(
    public void testBitmapQuery64() throws IOException {
            Query unsignedLongQ = NumberType.UNSIGNED_LONG.rangeQuery(
            ft.rangeQuery(1, 10.1, true, false, null, null, null, MOCK_QSC)
            ftLong.rangeQuery(-2, 0, true, true, null, null, null, MOCK_QSC),
                assertThat(
        reader.close();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Arrays;
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
        NumberFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
        for (int i = 0; i < numQueries; ++i) {
import java.util.Collections;
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
            } else {
                query,
            IllegalArgumentException.class,
        MappedFieldType unsearchable = unsearchable();
            assertThat(NumberType.LONG.parsePoint(bytes), equalTo(value));
import org.opensearch.common.settings.Settings;
        final List<OutOfRangeSpec> inputs = Arrays.asList(
        assertTrue(ft.termQuery(42.1, null) instanceof MatchNoDocsQuery);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
        );
        MappedFieldType ftInt = new NumberFieldMapper.NumberFieldType("field", NumberType.INTEGER);
            assertThat(NumberType.DOUBLE.parsePoint(bytes), equalTo(value));
    public void testDocValueLongRange() throws Exception {
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, Float.NEGATIVE_INFINITY, "[half_float] supports only finite values"),
            assertThat(NumberType.BYTE.parsePoint(bytes), equalTo(value));
        assertEquals(
        DirectoryReader reader = DirectoryReader.open(w);
        );
        // this test checks that searching half floats yields the same results as
                item.type.parse(item.value, false);
import static org.hamcrest.Matchers.instanceOf;
                ApproximatePointRangeQuery.DOUBLE_FORMAT
                "field",
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.HALF_FLOAT).valueForDisplay(1.2)
        reader.close();
import org.apache.lucene.search.MatchNoDocsQuery;
        doTestIndexSortRangeQueries(NumberType.LONG, random()::nextLong);
        final DirectoryReader reader = DirectoryReader.open(w);
        assertEquals(
        assertTrue(ft.termsQuery(Arrays.asList(1.1, 2.1), null) instanceof MatchNoDocsQuery);
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
import org.apache.lucene.document.LongPoint;
 * The OpenSearch Contributors require contributions made to
        Directory dir = newDirectory();
        doTestDocValueRangeQueries(NumberType.FLOAT, random()::nextFloat);
            // ends up being rounded to Infinity by halfFloatToSortableShort()
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.BYTE);
        Query expected = new ApproximateScoreQuery(
    }
        assertEquals((short) 5, NumberType.SHORT.parse((byte) 5, true));
            ft.rangeQuery(1.1, 10, true, true, null, null, null, MOCK_QSC)
        final int iters = 10;
            Byte.valueOf((byte) 3),
import static org.hamcrest.Matchers.either;
        assertEquals(
        assertFalse(NumberType.FLOAT.termQuery("field", -0f, true, true).equals(NumberType.FLOAT.termQuery("field", +0f, true, true)));
    }
        assertEquals(
        assertEquals(BigInteger.valueOf(5), NumberType.UNSIGNED_LONG.parse("5", true));
import org.opensearch.search.MultiValueMode;
            NumberType.DOUBLE.rangeQuery("field", null, -0d, true, true, false, true, MOCK_QSC),
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, "65520", "[half_float] supports only finite values"),
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
            OutOfRangeSpec.of(NumberType.DOUBLE, Double.NEGATIVE_INFINITY, "[double] supports only finite values")
    public void testShortTermQueryWithDecimalPart() {
            ft.isFieldWithinQuery(null, randomDouble(), randomDouble(), randomBoolean(), randomBoolean(), null, null, null)
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.SHORT).valueForDisplay(3)
    public void doTestIndexSortRangeQueries(NumberType type, Supplier<Number> valueSupplier) throws IOException {
            ft.termsQuery(Arrays.asList(1, 2.1), null)
        }
 * not use this file except in compliance with the License.
            )
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
    public void testDocValueShortRange() throws Exception {
import org.opensearch.search.query.BitmapIndexQuery;
        assertEquals(
    public void testFetchSourceValue() throws IOException {
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
        );
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.FLOAT).valueForDisplay(1.2)
 * specific language governing permissions and limitations
    public void testNegativeZero() {
            ftInt.rangeQuery(0, 0, true, true, null, null, null, MOCK_QSC),
        assertThrows(IllegalArgumentException.class, () -> finalFt.bitmapQuery(bitmap));
            new ApproximatePointRangeQuery(
            assertNull(fieldType.valueForDisplay(null));
public class NumberFieldTypeTests extends FieldTypeTestCase {
        // searching floats that are rounded to the closest half float
        );
        assertEquals(
        );
        );
            array = bos.toByteArray();
        assertEquals(
            SortedUnsignedLongDocValuesRangeQuery.newSlowRangeQuery("field", BigInteger.valueOf(1), BigInteger.valueOf(3))
        }
        assertEquals(5, NumberType.INTEGER.parse("5.9", true));
        assertEquals(BigInteger.valueOf(3L), NumberType.UNSIGNED_LONG.parse(3.5, true));
    public void testCoercions() {
        assertEquals(
        );
        Query indexOrDvQuery = new IndexOrDocValuesQuery(
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, -65520f, "[half_float] supports only finite values"),
        }
        );
            short value = randomShort();
        );
            ft.bitmapQuery(bitmap)
        }
            OutOfRangeSpec.of(NumberType.FLOAT, Float.NaN, "[float] supports only finite values"),
            value = v;
                random().nextBoolean() ? null : valueSupplier.get(),
        NumberFieldType otherFieldType = new NumberFieldType("foo", otherType);
        );
        doTestDocValueRangeQueries(NumberType.UNSIGNED_LONG, FieldTypeTestCase::randomUnsignedLong);
        IndexWriter w = new IndexWriter(dir, writerConfig);
    public void testLongTermQueryWithDecimalPart() {
    public void testLongRangeQuery() {
            new IndexOrDocValuesQuery(LongPoint.newSetQuery("field", 1), SortedNumericDocValuesField.newSlowSetQuery("field", 1)),
            NumberFieldMapper.NumberFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", type);
        assertThrows(IllegalArgumentException.class, () -> finalFt.bitmapQuery(bitmap));
import org.apache.lucene.search.SortField;
        assertEquals(
        ft = new NumberFieldMapper.NumberFieldType("field", type);
    public void testDocValueUnsignedLongRange() throws Exception {
            ftLong.rangeQuery(-2, -1, true, true, null, null, null, MOCK_QSC),
            ft.termsQuery(Arrays.asList(1.0, 2.1), null)
    }
        DirectoryReader reader = DirectoryReader.open(w);
        assertEquals(
            ftInt.rangeQuery(-2.5, 0.5, true, true, null, null, null, MOCK_QSC)
import org.roaringbitmap.RoaringBitmap;
import org.opensearch.search.DocValueFormat;
        assertEquals(new BitmapDocValuesQuery("field", r), ft.bitmapQuery(bitmap));
        NumberType type = randomValueOtherThan(NumberType.INTEGER, () -> randomFrom(NumberType.values()));
 *
        assertEquals((byte) 5, NumberType.BYTE.parse("5", true));
            ft.rangeQuery(1.1, 10, false, true, null, null, null, MOCK_QSC)
            ft.rangeQuery(1, 10.1, true, false, null, null, null, MOCK_QSC)
        assertEquals(
        e = expectThrows(IllegalArgumentException.class, () -> NumberType.LONG.parse(10000000000000000000d, true));
        assertEquals(5, NumberType.INTEGER.parse((byte) 5, true));
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
import org.apache.lucene.util.BytesRef;
            .fieldType();
        for (NumberFieldMapper.NumberType type : NumberFieldMapper.NumberType.values()) {
        assertEquals(3f, NumberType.FLOAT.parse(3d, true));
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.UNSIGNED_LONG);
            ft.rangeQuery(1, 10.1, true, false, null, null, null, MOCK_QSC)
        MappedFieldType mapper = new NumberFieldMapper.Builder("field", NumberType.INTEGER, false, true).build(context).fieldType();
        BytesArray bitmap = new BytesArray(array);
    // the same ranges
    public void testByteRangeQueryWithDecimalParts() {
import org.opensearch.search.approximate.ApproximatePointRangeQuery;
    }
        doTestDocValueRangeQueries(NumberType.SHORT, () -> (short) random().nextInt(65536));
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.SHORT);
            final Object value = fetcher.nextValue();
            ft.rangeQuery(1.1, 10, true, true, null, null, null, MOCK_QSC)
    }
                "field",
            OutOfRangeSpec.of(NumberType.SHORT, "32768", "out of range for a short"),
            float value = randomFloat();
        assertEquals(
            IndexOrDocValuesQuery indexOrDvQuery = (IndexOrDocValuesQuery) fallbackQuery;
        MappedFieldType unsearchable = unsearchable();
        type = RandomPicks.randomFrom(random(), NumberFieldMapper.NumberType.values());
                NumberType.UNSIGNED_LONG.encodePoint(BigInteger.valueOf(3)),
        );
import org.opensearch.Version;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
        dir.close();
    }
            w.addDocument(type.createFields("field", valueSupplier.get(), true, true, false, false));
        assertEquals(
import org.opensearch.common.util.io.IOUtils;
            OutOfRangeSpec.of(NumberType.DOUBLE, Double.POSITIVE_INFINITY, "[double] supports only finite values"),
        NumberType otherType = randomValueOtherThan(type, () -> randomFrom(NumberType.values()));
                true,
        );
    // Make sure we construct the IndexOrDocValuesQuery objects with queries that match
                randomBoolean(),
        MappedFieldType ft = new NumberFieldType("field", NumberType.INTEGER);
        assertEquals(
        Directory dir = newDirectory();
    }
        );
            Query fallbackQuery;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
            Double.valueOf(1.2),
    public void testIntegerTermQueryWithDecimalPart() {
            BigIntegerPoint.newSetQuery("field", BigInteger.valueOf(1), BigInteger.valueOf(3)),
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        );
        assertEquals((short) 5, NumberType.SHORT.parse("5.9", true));
 * GitHub history for details.
            OutOfRangeSpec.of(NumberType.DOUBLE, new BigDecimal("1.7976931348623157E309"), "[double] supports only finite values"),
        );
            } else {
        );
    }
            OutOfRangeSpec.of(NumberType.FLOAT, Float.POSITIVE_INFINITY, "[float] supports only finite values"),
        SortField sortField = fielddata.sortField(null, MultiValueMode.MIN, null, randomBoolean());
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
        assertEquals(
    public void testParsePoint() {
            byte[] bytes = new byte[Float.BYTES];
        }
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.UNSIGNED_LONG);
    }
        assertEquals((long) 5, NumberType.LONG.parse(new BytesRef("5.3".getBytes(StandardCharsets.UTF_8)), true));
        {
            double value = randomDouble();
            ft.rangeQuery(1, 10.1, true, true, null, null, null, MOCK_QSC)
        assertEquals(expected, ft.rangeQuery("1", "3", true, true, null, null, null, MOCK_QSC));
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
        assertEquals(BigInteger.valueOf(3L), NumberType.UNSIGNED_LONG.parse(3d, true));
    }
    public void testIndexSortLongRange() throws Exception {
        public void write(XContentBuilder b) throws IOException {
        assertEquals(-4115420654264075766L, NumberType.LONG.parse("-4115420654264075766", true));
        MappedFieldType unsearchable = unsearchable();
            doc.add(new BigIntegerPoint("unsigned_long", value));
        IOUtils.close(reader, dir);
            ftLong.rangeQuery(0.5, 2.5, false, false, null, null, null, MOCK_QSC)
            Query doubleQ = NumberType.DOUBLE.rangeQuery("double", l, u, includeLower, includeUpper, false, true, MOCK_QSC);
                DoublePoint.pack(new double[] { 1d }).bytes,
                "index",
 * this work for additional information regarding copyright
        assertEquals(Collections.singletonList(2.71f), fetchSourceValue(nullValueMapper, null));
        dir.close();
            int value = randomInt();
            OutOfRangeSpec.of(NumberType.INTEGER, -2147483649L, "is out of range for an integer"),
import org.opensearch.common.util.BigArrays;
        assertEquals(
                context
        assertEquals(
    }
        );
    public void testIntegerRangeQueryWithDecimalParts() {
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                "foo",
        for (int i = 0; i < numQueries; ++i) {
                true,
            OutOfRangeSpec.of(NumberType.INTEGER, 2147483648L, "is out of range for an integer"),
        IllegalArgumentException e = expectThrows(
        for (int i = 0; i < numDocs; ++i) {
            throw new UnsupportedOperationException();
            ftLong.rangeQuery(1, 2, true, true, null, null, null, MOCK_QSC),
            null,
            byte[] bytes = new byte[Integer.BYTES];
import org.apache.lucene.index.IndexWriterConfig;
        );
        );
        );
                    "Incorrect error message for [" + item.type + "] with value [" + item.value + "]",
        );
        assertEquals(BigInteger.valueOf(5), NumberType.UNSIGNED_LONG.parse((byte) 5, true));
        assertEquals(
    public void doTestDocValueRangeQueries(NumberType type, Supplier<Number> valueSupplier) throws Exception {
    }
        QueryShardContext context = new QueryShardContext(
            NumberType.FLOAT.rangeQuery("field", null, +0f, true, false, false, true, MOCK_QSC)
            ftInt.rangeQuery(-2.5, -0.5, true, true, null, null, null, MOCK_QSC)
    public void testIntegerTermsQueryWithDecimalPart() {
            NumberType.DOUBLE.rangeQuery("field", null, +0d, true, false, false, true, MOCK_QSC)
import java.io.ByteArrayInputStream;
        final NumberType type;
 * Modifications Copyright OpenSearch Contributors. See
        for (int iter = 0; iter < iters; ++iter) {
    }
            null
            ftLong.rangeQuery(-2.5, -0.5, false, false, null, null, null, MOCK_QSC)
        );
        );
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig());
        doTestDocValueRangeQueries(NumberType.BYTE, () -> (byte) random().nextInt(256));
    }
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); DataOutputStream dos = new DataOutputStream(bos)) {
                true,
        assertEquals(-4115420654264075766L, NumberType.LONG.parse(-4115420654264075766L, true));
import org.opensearch.index.fielddata.IndexNumericFieldData;
            xContentRegistry(),
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.BYTE).valueForDisplay(3)
            ft.rangeQuery(1, 10.1, true, true, null, null, null, MOCK_QSC)
        Query indexOrDvQuery = new IndexOrDocValuesQuery(
        assertEquals(
                IndexOrDocValuesQuery indexOrDvQuery = (IndexOrDocValuesQuery) query;
            OutOfRangeSpec.of(NumberType.FLOAT, Float.NEGATIVE_INFINITY, "[float] supports only finite values"),
            new IndexOrDocValuesQuery(LongPoint.newSetQuery("field", 1), SortedNumericDocValuesField.newSlowSetQuery("field", 1)),
        assertEquals(5, NumberType.INTEGER.parse(new BytesRef("5.3".getBytes(StandardCharsets.UTF_8)), true));
            ftInt.rangeQuery(0, 2, true, true, null, null, null, MOCK_QSC),
            0,
import java.util.List;
            Relation.INTERSECTS,
        // Create index settings with an index sort.
        assertEquals(Collections.singletonList(42), fetchSourceValue(mapper, "42.9"));
    }
        doc.add(new SortedNumericDocValuesField("ul", expectedValue.longValue()));
        }).build(null, null);
            ftInt.rangeQuery(-2, 0, true, true, null, null, null, MOCK_QSC),
        );
 */
            () -> unsearchable.termsQuery(List.of("1", "3"), MOCK_QSC)
            ftInt.rangeQuery(0, 0, true, true, null, null, null, MOCK_QSC),
            return new OutOfRangeSpec(t, v, m);
        assertEquals("Value [128] is out of range for a byte", e.getMessage());
    }
            ftInt.rangeQuery(-3, -3, true, true, null, null, null, MOCK_QSC),
        );
        assertEquals(
            doc.add(new DoublePoint("double", value.doubleValue()));
        assertEquals(
        assertEquals(
                includeLower,
    @Before
                NumberType.UNSIGNED_LONG.encodePoint(BigInteger.valueOf(1)),
        for (int i = 0; i < numDocs; ++i) {
import org.opensearch.search.query.BitmapDocValuesQuery;
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
import org.opensearch.search.query.Bitmap64DocValuesQuery;
        final String message;
        Document doc = new Document();
    public void testBitmapQuery() throws IOException {
            ftInt.rangeQuery(-0.5, 0.5, true, true, null, null, null, MOCK_QSC)
        assertEquals(
    public void testRangeQueryWithNegativeBounds() {
import org.opensearch.index.mapper.MappedFieldType.Relation;
        );
        doTestDocValueRangeQueries(NumberType.DOUBLE, random()::nextDouble);
                assertThat(fallbackQuery, instanceOf(IndexOrDocValuesQuery.class));
import org.opensearch.index.query.QueryShardContext;
        assertEquals(
import org.apache.lucene.index.DirectoryReader;
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, 65520f, "[half_float] supports only finite values"),
            ftLong.rangeQuery(-0.5, 2.5, false, false, null, null, null, MOCK_QSC)
            OutOfRangeSpec.of(NumberType.DOUBLE, "1.7976931348623157E309", "[double] supports only finite values"),
    public void testEqualsWithDifferentNumberTypes() {
        );
    }
            )
        assertEquals((long) 5, NumberType.LONG.parse("5.9", true));
        }
        );
            ftInt.rangeQuery(0.5, 2.5, true, true, null, null, null, MOCK_QSC)
        IndexSearcher searcher = newSearcher(reader);
 * license agreements. See the NOTICE file distributed with
            ftLong.rangeQuery(-2.5, -0.5, true, true, null, null, null, MOCK_QSC)
    public void testIsFieldWithinQuery() throws IOException {
            assertEquals(searcher.count(floatQ), searcher.count(halfFloatQ));
    }
                NumericUtils.doubleToSortableLong(3)
        );
import org.apache.lucene.store.Directory;
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
            assertThat(NumberType.SHORT.parsePoint(bytes), equalTo(value));
import org.opensearch.search.approximate.ApproximateScoreQuery;
            .put("index.sort.field", "field")
        assertEquals(Numbers.MAX_UNSIGNED_LONG_VALUE, NumberType.UNSIGNED_LONG.parse(Numbers.MAX_UNSIGNED_LONG_VALUE, true));
            );
                true,
        w.close();
        assertEquals(3f, NumberType.HALF_FLOAT.parse(3d, true));
 * ownership. Elasticsearch licenses this file to you under
        );
        w.close();
            ftInt.rangeQuery(1, 2, true, true, null, null, null, MOCK_QSC),
        assertEquals(
        MappedFieldType unsearchable = unsearchable();
            }
    public void testDocValueDoubleRange() throws Exception {
            OutOfRangeSpec.of(NumberType.LONG, "9223372036854775808", "out of range for a long"),
import org.junit.Before;
        NumberType type = randomFrom(NumberType.values());
            IllegalArgumentException.class,
        assertEquals(
                random().nextBoolean() ? null : valueSupplier.get(),
        assertEquals(
 *
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.INTEGER);
        {
        );
        );
        assertEquals(Integer.MAX_VALUE, NumberType.INTEGER.parse(Integer.MAX_VALUE, true));
        BytesArray bitmap = new BytesArray(array);
            OutOfRangeSpec.of(NumberType.BYTE, -129, "is out of range for a byte"),
        }
        );
            assertThat(
        assertEquals(
            assertEquals(IndexNumericFieldData.NumericType.UNSIGNED_LONG, fielddata.getNumericType());
        );
        doTestDocValueRangeQueries(NumberType.LONG, random()::nextLong);
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
 * under the License.
            ft.rangeQuery(1, 10.1, true, true, null, null, null, MOCK_QSC)
        assertEquals("Value [65536] is out of range for a short", e.getMessage());
        assertEquals(
        ft = new NumberFieldType("field", NumberType.LONG, false, false, true, true, true, null, Collections.emptyMap());
            assertThat(
    }
import java.io.ByteArrayOutputStream;
        assertEquals(3, NumberType.INTEGER.parse(3d, true));
            SortedNumericDocValuesField.newSlowRangeQuery(
            LongPoint.encodeDimension(value, bytes, 0);
    }
                1,
        // these will lose precision if they get treated as a double
            OutOfRangeSpec.of(NumberType.INTEGER, "2147483648", "out of range for an integer"),
                    containsString(item.message)
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE).valueForDisplay(1.2)
            byte[] bytes = new byte[Integer.BYTES];
        for (int iter = 0; iter < iters; ++iter) {
        assertFalse(NumberType.DOUBLE.termQuery("field", -0d, true, true).equals(NumberType.DOUBLE.termQuery("field", +0d, true, true)));
                either(instanceOf(IndexSortSortedNumericDocValuesRangeQuery.class)).or(instanceOf(ApproximateScoreQuery.class))
            );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery("42", null));
            null,
        assertEquals((long) 5, NumberType.LONG.parse("5", true));
        assertEquals(
                includeUpper,
    public void testIndexSortIntRange() throws Exception {
                    e.getMessage(),
            ft.rangeQuery(1.1, 10, true, true, null, null, null, MOCK_QSC)
        writerConfig.setIndexSort(new Sort(sortField));
        }
        );
import org.apache.lucene.document.Document;
/*
        IndexWriterConfig writerConfig = new IndexWriterConfig();
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, Float.NaN, "[half_float] supports only finite values"),
        );
        );
            indexOrDvQuery,
    public void testDocValueFloatRange() throws Exception {
        for (int i = 0; i < numDocs; ++i) {
    public void testUnsignedLongRange() throws IOException {
import org.opensearch.index.document.SortedUnsignedLongDocValuesRangeQuery;
        assertEquals(
        );
            Query floatQ = NumberType.FLOAT.rangeQuery("float", l, u, includeLower, includeUpper, false, true, MOCK_QSC);
            DocValueFetcher.Leaf fetcher = fielddata.load(reader.leaves().get(0)).getLeafValueFetcher(DocValueFormat.UNSIGNED_LONG);
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
            Document doc = new Document();
        assertEquals((byte) 5, NumberType.BYTE.parse((short) 5, true));
            OutOfRangeSpec.of(NumberType.LONG, new BigInteger("9223372036854775808"), " is out of range for a long"),
        // make sure the accuracy loss of half floats only occurs at index time
            ftInt.rangeQuery(1, 2, true, true, null, null, null, MOCK_QSC),
    }
            ftLong.rangeQuery(-3.5, -2.5, false, false, null, null, null, MOCK_QSC)
            OutOfRangeSpec.of(NumberType.FLOAT, "3.4028235E39", "[float] supports only finite values"),
    }
                true,
            () -> unsearchable.rangeQuery("1", "3", true, true, null, null, null, MOCK_QSC)
        );
import java.nio.charset.StandardCharsets;
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.INTEGER).valueForDisplay(3)
            byte value = randomByte();
            ftInt.rangeQuery(-2, -1, true, true, null, null, null, MOCK_QSC),
    public void testDocValueIntRange() throws Exception {
        assertTrue(ft.termQuery(42.1, null) instanceof MatchNoDocsQuery);
            ftInt.rangeQuery(-2.5, -0.5, false, false, null, null, null, MOCK_QSC)
        );
            new IndexOrDocValuesQuery(new Bitmap64IndexQuery("field", r), new Bitmap64DocValuesQuery("field", r)),
                fail("Parsing exception expected for [" + item.type + "] with value [" + item.value + "]");
        final int numDocs = TestUtil.nextInt(random(), 100, 500);
            assertThat(NumberType.INTEGER.parsePoint(bytes), equalTo(value));
            .build(context)
            null,
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
    }
    }
import java.math.BigInteger;
            SortedUnsignedLongDocValuesSetQuery.newSlowSetQuery("field", BigInteger.valueOf(1), BigInteger.valueOf(3))
        OutOfRangeSpec(NumberType t, Object v, String m) {
    public void testParseOutOfRangeValues() throws IOException {
/*
            w.addDocument(doc);
            float u = (randomFloat() * 2 - 1) * 65504;
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
        static OutOfRangeSpec of(NumberType t, Object v, String m) {
import java.math.BigDecimal;
        assertEquals(
        IOUtils.close(w, dir);
            doc.add(new HalfFloatPoint("half_float", value));
        e = expectThrows(IllegalArgumentException.class, () -> NumberType.UNSIGNED_LONG.parse(100000000000000000000d, true));
    }
        );
            boolean includeLower = randomBoolean();
        MappedFieldType nullValueMapper = new NumberFieldMapper.Builder("field", NumberType.FLOAT, false, true).nullValue(2.71f)
        assertEquals((long) 5, NumberType.LONG.parse((byte) 5, true));
            if (query instanceof IndexOrDocValuesQuery) {
        DirectoryReader reader = DirectoryReader.open(w);
        assertEquals(BigInteger.valueOf(5), NumberType.UNSIGNED_LONG.parse(new BytesRef("5.3".getBytes(StandardCharsets.UTF_8)), true));
        }
        );
import org.opensearch.search.query.Bitmap64IndexQuery;
            ftInt.rangeQuery(-2, -1, true, true, null, null, null, MOCK_QSC),
        reader.close();
            ftInt.rangeQuery(-0.5, 0.5, false, false, null, null, null, MOCK_QSC)
        assertEquals(BigInteger.valueOf(5), NumberType.UNSIGNED_LONG.parse("5.9", true));
            OutOfRangeSpec.of(NumberType.BYTE, "128", "out of range for a byte"),
        w.close();
            assertTrue(fetcher.advanceExact(0));
/*
            Integer.valueOf(3),
            ftLong.rangeQuery(-0.5, 0.5, true, true, null, null, null, MOCK_QSC)
        );
        assertEquals(new MatchNoDocsQuery(), ft.bitmapQuery(bitmap).rewrite(newSearcher(reader)));
        assertEquals(expected, ft.termsQuery(List.of("1", "3"), MOCK_QSC));
        IllegalArgumentException e = expectThrows(
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
        NumberFieldType fieldType = new NumberFieldType("foo", type);
            ftInt.rangeQuery(-2.5, 0.5, false, false, null, null, null, MOCK_QSC)
            }
        assertEquals(
    }
                u,
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
        ft = new NumberFieldType("field", NumberType.LONG, true, false, false, false, true, null, Collections.emptyMap());
    }
        );
        assertEquals(3d, NumberType.DOUBLE.parse(3d, true));
            OutOfRangeSpec.of(NumberType.BYTE, 128, "is out of range for a byte"),
 * KIND, either express or implied.  See the License for the
            OutOfRangeSpec.of(NumberType.DOUBLE, new BigDecimal("-1.7976931348623157E309"), "[double] supports only finite values"),
            ftLong.rangeQuery(0, 0, true, true, null, null, null, MOCK_QSC),
            ft.rangeQuery(1, 10.1, true, true, null, null, null, MOCK_QSC)
            OutOfRangeSpec.of(NumberType.LONG, new BigInteger("-9223372036854775809"), " is out of range for a long"),
        );
        );
            IntPoint.encodeDimension(value, bytes, 0);
        assertEquals((long) 5, NumberType.LONG.parse("5.0", true));
            Double.valueOf(1.2),
            null,
            assertEquals(searcher.count(query), searcher.count(indexOrDvQuery.getIndexQuery()));
        assertEquals((short) 3, NumberType.SHORT.parse(3.5, true));
            ft.termsQuery(Arrays.asList(1, 2.1), null)
    public void testDoubleRangeQuery() {
    public void pickType() {
            ftInt.rangeQuery(-0.5, 2.5, true, true, null, null, null, MOCK_QSC)
import static org.apache.lucene.document.LongPoint.pack;
            Document doc = new Document();
import java.nio.ByteBuffer;
            null,
        assertEquals("Value [1.0E20] is out of range for an unsigned long", e.getMessage());
            ft.rangeQuery(1, 10.1, true, true, null, null, null, MOCK_QSC)
            ftLong.rangeQuery(-2, 0, true, true, null, null, null, MOCK_QSC),
        RoaringBitmap r = new RoaringBitmap();
        assertTrue(ft.termQuery(42.1, null) instanceof MatchNoDocsQuery);
        Directory dir = newDirectory();
            null,
            ft.rangeQuery(1.1, 10, false, true, null, null, null, MOCK_QSC)
import java.io.DataOutputStream;
        Directory dir = newDirectory();
        doTestIndexSortRangeQueries(NumberType.INTEGER, random()::nextInt);
        assertEquals(
            ft.bitmapQuery(bitmap)
            () -> unsearchable.rangeQuery("1", "3", true, true, null, null, null, MOCK_QSC)
        dir.close();
        assertEquals(expected, ft.rangeQuery("1", "3", true, true, null, null, null, MOCK_QSC));
        assertTrue(ft.termQuery(42.1, null) instanceof MatchNoDocsQuery);
        }
        assertEquals(
            DoublePoint.encodeDimension(value, bytes, 0);
 * software distributed under the License is distributed on an
            OutOfRangeSpec.of(NumberType.FLOAT, 3.4028235E39d, "[float] supports only finite values"),
        final int numDocs = TestUtil.nextInt(random(), 100, 500);
        assertEquals(
            FloatPoint.encodeDimension(value, bytes, 0);
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
        // Ensure that the optimized index sort query gives the same results as a points query.
import static org.hamcrest.Matchers.equalTo;
            ftLong.rangeQuery(0.5, 2.5, true, true, null, null, null, MOCK_QSC)
            ft.rangeQuery(1, 10.1, true, false, null, null, null, MOCK_QSC)
import java.io.IOException;
            () -> true,
    }
                either(instanceOf(IndexOrDocValuesQuery.class)).or(instanceOf(MatchNoDocsQuery.class))
package org.opensearch.index.mapper;
            doc.add(new FloatPoint("float", rounded));
            byte[] bytes = new byte[Long.BYTES];
import org.apache.lucene.search.IndexSortSortedNumericDocValuesRangeQuery;
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(value instanceof BigInteger);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
            try {
            new IndexOrDocValuesQuery(IntPoint.newSetQuery("field", 1), SortedNumericDocValuesField.newSlowSetQuery("field", 1)),
        ft = new NumberFieldType("field", NumberType.INTEGER, false, false, true, true, true, null, Collections.emptyMap());
 *
        }
                randomBoolean(),
        doTestDocValueRangeQueries(NumberType.INTEGER, random()::nextInt);
            IllegalArgumentException.class,
            Query query = type.rangeQuery(
 *     http://www.apache.org/licenses/LICENSE-2.0
            ftInt.rangeQuery(-3.5, -2.5, false, false, null, null, null, MOCK_QSC)
            OutOfRangeSpec.of(NumberType.FLOAT, -3.4028235E39d, "[float] supports only finite values"),
            final NumberFieldType ft = new NumberFieldType("ul", NumberType.UNSIGNED_LONG);
        w.close();
            NumberType.HALF_FLOAT.termQuery("field", -0f, true, true).equals(NumberType.HALF_FLOAT.termQuery("field", +0f, true, true))
            ft.rangeQuery(1.1, 10, true, true, null, null, null, MOCK_QSC)
        assertEquals(3L, NumberType.LONG.parse(3d, true));
            ftInt.rangeQuery(-2, 0, true, true, null, null, null, MOCK_QSC),
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
            ftLong.rangeQuery(0, 2, true, true, null, null, null, MOCK_QSC),
        }
        final DirectoryReader reader = DirectoryReader.open(w);
    }
        // searching floats that are rounded to the closest half float
        assertEquals(
            if (query instanceof IndexSortSortedNumericDocValuesRangeQuery) {
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
            new IndexOrDocValuesQuery(LongPoint.newRangeQuery("field", 1, 3), SortedNumericDocValuesField.newSlowRangeQuery("field", 1, 3)),
                random().nextBoolean() ? null : valueSupplier.get(),
                randomBoolean(),
        );
        final int numDocs = 10000;
        byte[] array;
                fallbackQuery = ((IndexSortSortedNumericDocValuesRangeQuery) query).getFallbackQuery();
            ft.rangeQuery(1.1, 10, true, true, null, null, null, MOCK_QSC)
            NumberType.HALF_FLOAT.rangeQuery("field", null, -0f, true, true, false, true, MOCK_QSC),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            byte[] bytes = new byte[Double.BYTES];
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG).valueForDisplay(3L)
        );
        IndexSearcher searcher = newSearcher(reader);
        );
    }
            BigArrays.NON_RECYCLING_INSTANCE,
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig());
import org.opensearch.cluster.metadata.IndexMetadata;
            ft.rangeQuery(1.1, 10, false, true, null, null, null, MOCK_QSC)
        assertEquals(
        Settings settings = Settings.builder()
            );
    public void testHalfFloatRange() throws IOException {
        {
            );
        }
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig());
                );
            ftLong.rangeQuery(-3.5, -2.5, true, true, null, null, null, MOCK_QSC)
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.INTEGER);
        for (int i = 0; i < numDocs; ++i) {
            IllegalArgumentException.class,
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
            () -> 0L,
        assertEquals(
        NumberType type = randomValueOtherThan(NumberType.LONG, () -> randomFrom(NumberType.values()));
        assertEquals(
            ftInt.rangeQuery(0.5, 2.5, false, false, null, null, null, MOCK_QSC)
    }
                b.field("field", value);
            ftLong.rangeQuery(-0.5, 0.5, false, false, null, null, null, MOCK_QSC)
            indexSettings,
        assertEquals(3, NumberType.INTEGER.parse(3.5, true));
    public void testLongTermsQueryWithDecimalPart() {
        assertEquals(
    }
        );
        DirectoryReader reader = DirectoryReader.open(w);
        assertEquals(
    }
        );
import org.apache.lucene.index.IndexWriter;
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
        assertEquals(
        final int numQueries = 1000;
        w.addDocument(doc);
        }
            w.addDocument(doc);
    NumberType type;
        );
        IllegalArgumentException e = expectThrows(
        // Create an index writer configured with the same index sort.
                    .getFallbackQuery();
        assertNotEquals(fieldType, otherFieldType);
        );
            assertThat(NumberType.FLOAT.parsePoint(bytes), equalTo(value));
    }
            dos.flush();
            ftLong.rangeQuery(-2.5, 0.5, true, true, null, null, null, MOCK_QSC)
        }
            new IndexOrDocValuesQuery(IntPoint.newSetQuery("field", 1), SortedNumericDocValuesField.newSlowSetQuery("field", 1)),
            HalfFloatPoint.encodeDimension(value, bytes, 0);
        assertEquals(Collections.singletonList(3), fetchSourceValue(mapper, 3.14));
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
        }
        assertEquals((byte) 3, NumberType.BYTE.parse(3.5, true));
import org.apache.lucene.search.Query;
        assertEquals(
        );
        assertEquals(
            float value = (randomFloat() * 2 - 1) * 70000;
            ).build(null, null);
import org.apache.lucene.search.IndexOrDocValuesQuery;
        );
            );
                random().nextBoolean() ? null : valueSupplier.get(),
        NumberFieldType finalFt = ft;
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
                1,
            long value = randomLong();
            OutOfRangeSpec.of(NumberType.DOUBLE, Double.NaN, "[double] supports only finite values"),
            byte[] bytes = new byte[Integer.BYTES];
            null,
            } catch (IllegalArgumentException e) {
        IndexSearcher searcher = newSearcher(reader);
        return new NumberFieldType("field", NumberType.LONG, false, false, false, false, true, null, Collections.emptyMap());
        Directory dir = newDirectory();
        );
        assertEquals("Value [2147483648] is out of range for an integer", e.getMessage());
    public void testFetchUnsignedLongDocValues() throws IOException {
            ftLong.rangeQuery(-0.5, 2.5, true, true, null, null, null, MOCK_QSC)
        }
            )
        reader.close();
        NumberFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.INTEGER);
        }
            ftInt.rangeQuery(-0.5, 2.5, false, false, null, null, null, MOCK_QSC)
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.INTEGER);
        assertEquals(Collections.singletonList(2.71f), fetchSourceValue(nullValueMapper, ""));
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
                () -> { throw new UnsupportedOperationException(); }
        }
import org.roaringbitmap.longlong.Roaring64NavigableMap;
                fallbackQuery = ((IndexSortSortedNumericDocValuesRangeQuery) ((ApproximateScoreQuery) query).getOriginalQuery())
            DoublePoint.newRangeQuery("field", 1d, 3d),
            assertEquals(expectedValue, value);
import org.apache.lucene.document.FloatPoint;
        try (DirectoryReader reader = DirectoryReader.open(w)) {
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.SHORT);
        ft = new NumberFieldMapper.NumberFieldType("field", type);
            ftLong.rangeQuery(-2.5, 0.5, false, false, null, null, null, MOCK_QSC)
            boolean includeLower = randomBoolean();
            indexOrDvQuery,
        {
        IOUtils.close(reader, dir);
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
    public void testUnsignedLongTermsQuery() {
        assertEquals(
            BigInteger u = randomUnsignedLong();
                false,
        assertEquals(
    }
        assertFalse(
        byte[] array = new byte[r.serializedSizeInBytes()];
        assertEquals((short) 5, NumberType.SHORT.parse("5.0", true));
            IntPoint.encodeDimension(value, bytes, 0);
            ftLong.rangeQuery(-2, -1, true, true, null, null, null, MOCK_QSC),
import org.apache.lucene.util.NumericUtils;
        Query expected = new IndexOrDocValuesQuery(
        assertEquals((byte) 5, NumberType.BYTE.parse(new BytesRef("5.3".getBytes(StandardCharsets.UTF_8)), true));
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.BYTE);
        assertEquals(new BitmapIndexQuery("field", r), ft.bitmapQuery(bitmap));
                    .or(instanceOf(ApproximateScoreQuery.class))
                ApproximatePointRangeQuery.UNSIGNED_LONG_FORMAT
import org.apache.lucene.sandbox.document.HalfFloatPoint;
        }
    public void testTermQuery() {
        assertEquals("Value [1.0E19] is out of range for a long", e.getMessage());
            () -> unsearchable.rangeQuery("1", "3", true, true, null, null, null, MOCK_QSC)
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
        IndexSearcher searcher = newSearcher(reader);
    public void testConversions() {
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.document.DoublePoint;
            assertEquals(1, fetcher.docValueCount());
        Query expected = new ApproximateScoreQuery(
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
            float value = 3f;
        assertEquals(5, NumberType.INTEGER.parse("5.0", true));
        MappedFieldType ftLong = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
    }
            new ApproximatePointRangeQuery("field", pack(1).bytes, pack(3).bytes, 1, ApproximatePointRangeQuery.LONG_FORMAT)
            BigIntegerPoint.newRangeQuery("field", BigInteger.valueOf(1), BigInteger.valueOf(3)),
        dir.close();
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
        );
        assertTrue(ft.termsQuery(Arrays.asList(1.1, 2.1), null) instanceof MatchNoDocsQuery);
            float l = (randomFloat() * 2 - 1) * 65504;
import org.opensearch.common.Numbers;
            null,
                l,
            byte[] bytes = new byte[Float.BYTES];
                NumericUtils.doubleToSortableLong(1),
        );
            .build();
        MappedFieldType unsearchable = unsearchable();
        assertEquals(
            }
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.UNSIGNED_LONG);
 * Licensed to Elasticsearch under one or more contributor
        Query query = new IndexOrDocValuesQuery(LongPoint.newExactQuery("field", 42), dvQuery);
 * You may obtain a copy of the License at
            Query query = type.rangeQuery(
        doTestDocValueRangeQueries(NumberType.HALF_FLOAT, random()::nextFloat);
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
        assertEquals(5, NumberType.INTEGER.parse("5", true));
                query,
            OutOfRangeSpec.of(NumberType.SHORT, 32768, "is out of range for a short"),
            Short.valueOf((short) 3),
            ftLong.rangeQuery(1, 2, true, true, null, null, null, MOCK_QSC),
    public void testShortRangeQueryWithDecimalParts() {
                assertThat(fallbackQuery, instanceOf(IndexOrDocValuesQuery.class));
            Long.valueOf(3),
        r.serialize(ByteBuffer.wrap(array));
                b.rawField("field", new ByteArrayInputStream(value.toString().getBytes("UTF-8")), MediaTypeRegistry.JSON);
        assertEquals(
            ftInt.rangeQuery(-3.5, -2.5, true, true, null, null, null, MOCK_QSC)
            BigInteger l = randomUnsignedLong();
            BigInteger value = randomUnsignedLong();
    public void testLongRangeQueryWithDecimalParts() {
            new ApproximatePointRangeQuery(
        );
        w.close();
    }
            // Note: this test purposefully allows half-floats to be indexed over their dynamic range (65504), which
            ft.termsQuery(Arrays.asList(1.0, 2.1), null)
        final BigInteger expectedValue = randomUnsignedLong();
                randomBoolean(),
    }
        );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> NumberType.BYTE.parse(128, true));
        {
                MOCK_QSC
            IntPoint.encodeDimension(value, bytes, 0);
        assertEquals((byte) 5, NumberType.BYTE.parse("5.0", true));
        e = expectThrows(IllegalArgumentException.class, () -> NumberType.SHORT.parse(65536, true));
            ftInt.rangeQuery(-3, -3, true, true, null, null, null, MOCK_QSC),
import static org.hamcrest.Matchers.containsString;
            null,
 */
        );
        Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery("field", 42);
            ftLong.rangeQuery(-3, -3, true, true, null, null, null, MOCK_QSC),
            w.addDocument(type.createFields("foo", valueSupplier.get(), true, true, false, false));
        // current impl ignores args and should always return INTERSECTS
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
        );
        assertEquals(new Bitmap64DocValuesQuery("field", r), ft.bitmapQuery(bitmap));
        assertEquals((short) 3, NumberType.SHORT.parse(3d, true));
    public void testDocValueHalfFloatRange() throws Exception {
            float rounded = HalfFloatPoint.sortableShortToHalfFloat(HalfFloatPoint.halfFloatToSortableShort(value));
 */
import org.apache.lucene.search.Sort;
        assertEquals(
        w.close();
        final int numQueries = 1000;
        assertEquals(
            NumberType.HALF_FLOAT.rangeQuery("field", null, +0f, true, false, false, true, MOCK_QSC)
            ft.rangeQuery(1, 10.1, true, false, null, null, null, MOCK_QSC)
        // make sure the accuracy loss of half floats only occurs at index time
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
            Query halfFloatQ = NumberType.HALF_FLOAT.rangeQuery("half_float", l, u, includeLower, includeUpper, false, true, MOCK_QSC);
            message = m;
        assertEquals((byte) 3, NumberType.BYTE.parse(3d, true));
import org.opensearch.index.IndexSettings;
    }
        assertEquals(
        );
        assertEquals(
    }
    }
}
import org.apache.lucene.tests.util.TestUtil;
    }
            assertEquals(searcher.count(doubleQ), searcher.count(unsignedLongQ));
            ftLong.rangeQuery(-3, -3, true, true, null, null, null, MOCK_QSC),
        Directory dir = newDirectory();
        );
        );
        assertEquals(
        assertEquals(query, ft.termQuery("42", null));
    private static MappedFieldType unsearchable() {
    static class OutOfRangeSpec {
        NumberFieldType finalFt = ft;
                "unsigned_long",
        Directory dir = newDirectory();
        assertEquals(
 * compatible open source license.
    }
                MOCK_QSC
            writableRegistry(),
        // this test checks that searching half floats yields the same results as
        assertEquals(
            assertThat(NumberType.HALF_FLOAT.parsePoint(bytes), equalTo(value));
                "field",
        assertEquals(new Bitmap64IndexQuery("field", r), ft.bitmapQuery(bitmap));
        assertEquals(1.1f, NumberType.FLOAT.parse(1.1, true));
        {
import org.apache.lucene.sandbox.document.BigIntegerPoint;
