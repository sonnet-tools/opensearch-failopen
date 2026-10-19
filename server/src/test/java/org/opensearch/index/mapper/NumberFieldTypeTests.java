            new ApproximatePointRangeQuery(
        OutOfRangeSpec(NumberType t, Object v, String m) {
    public void testDocValueLongRange() throws Exception {  
 * software distributed under the License is distributed on an
    }  
                random().nextBoolean() ? null : valueSupplier.get(),
            byte[] bytes = new byte[Integer.BYTES];
        assertEquals((short) 5, NumberType.SHORT.parse("5.0", true));  
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
        );  
        MappedFieldType unsearchable = unsearchable();
import org.opensearch.core.common.bytes.BytesArray;
            type = t;
        );
            ftInt.rangeQuery(-0.5, 2.5, true, true, null, null, null, MOCK_QSC)
        );
            ftInt.rangeQuery(0, 0, true, true, null, null, null, MOCK_QSC),
            ft.bitmapQuery(bitmap)  
            Document doc = new Document();
/*
/*  
    public void testDocValueIntRange() throws Exception {
        assertEquals((byte) 3, NumberType.BYTE.parse(3.5, true));  
            ftLong.rangeQuery(-3.5, -2.5, false, false, null, null, null, MOCK_QSC)  
            null,  
            OutOfRangeSpec.of(NumberType.FLOAT, Float.NaN, "[float] supports only finite values"),
            OutOfRangeSpec.of(NumberType.SHORT, -32769, "is out of range for a short"),
            ft.termsQuery(Arrays.asList(1, 2.1), null)
        }
        );  
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;  
            ftLong.rangeQuery(-2.5, 0.5, false, false, null, null, null, MOCK_QSC)  
        );
    public void testIntegerTermsQueryWithDecimalPart() {  
import static org.hamcrest.Matchers.either;  
            ft.termsQuery(Arrays.asList(1.0, 2.1), null)
        Directory dir = newDirectory();  
import static org.apache.lucene.document.LongPoint.pack;  
        // make sure the accuracy loss of half floats only occurs at index time  
import org.opensearch.search.approximate.ApproximatePointRangeQuery;
            } else {
            message = m;
    public void testShortTermQueryWithDecimalPart() {
        assertEquals(expected, ft.rangeQuery("1", "3", true, true, null, null, null, MOCK_QSC));
            null,
        doTestDocValueRangeQueries(NumberType.BYTE, () -> (byte) random().nextInt(256));
    public void testIntegerTermQueryWithDecimalPart() {  
            ft.rangeQuery(1.1, 10, true, true, null, null, null, MOCK_QSC)  
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig());
            assertEquals(1, fetcher.docValueCount());  
        assertNotEquals(fieldType, otherFieldType);  
        MappedFieldType ft = new NumberFieldType("field", NumberType.INTEGER);
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
        );
                IndexOrDocValuesQuery indexOrDvQuery = (IndexOrDocValuesQuery) query;  
    public void testUnsignedLongRangeQueryWithDecimalParts() {
            }  
    }
        assertThrows(IllegalArgumentException.class, () -> finalFt.bitmapQuery(bitmap));
    }
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
 * not use this file except in compliance with the License.
        );
        );
            assertEquals(searcher.count(doubleQ), searcher.count(unsignedLongQ));
        assertEquals(expected, ft.rangeQuery("1", "3", true, true, null, null, null, MOCK_QSC));  
        // make sure the accuracy loss of half floats only occurs at index time
        }  
            ftInt.rangeQuery(-3, -3, true, true, null, null, null, MOCK_QSC),
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),  
                randomBoolean(),  
            ftInt.rangeQuery(-2.5, 0.5, false, false, null, null, null, MOCK_QSC)  
    }
        }  
        assertEquals(
        ft = new NumberFieldMapper.NumberFieldType("field", type);
import org.apache.lucene.index.IndexWriterConfig;
            ftLong.rangeQuery(-0.5, 0.5, true, true, null, null, null, MOCK_QSC)
            ftInt.rangeQuery(-3, -3, true, true, null, null, null, MOCK_QSC),
    public void testRangeQueryWithNegativeBounds() {
        Document doc = new Document();
            boolean includeUpper = randomBoolean();
    // the same ranges
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.BYTE);  
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
        );
    }
    public void testTermQuery() {
        assertEquals(
    NumberType type;
        assertEquals(Integer.MAX_VALUE, NumberType.INTEGER.parse(Integer.MAX_VALUE, true));  
        // Create index settings with an index sort.
        dir.close();  
        assertEquals("Value [2147483648] is out of range for an integer", e.getMessage());
    public void testLongTermsQueryWithDecimalPart() {
        assertEquals(
import java.io.DataOutputStream;  
import org.apache.lucene.document.Document;  
import org.apache.lucene.search.IndexOrDocValuesQuery;
            ftInt.rangeQuery(-3.5, -2.5, true, true, null, null, null, MOCK_QSC)
        assertEquals((byte) 5, NumberType.BYTE.parse((short) 5, true));
    }  
        );  
        );
        assertEquals(  
        assertEquals(  
            ftInt.rangeQuery(0, 2, true, true, null, null, null, MOCK_QSC),
            ftInt.rangeQuery(1, 2, true, true, null, null, null, MOCK_QSC),  
            OutOfRangeSpec.of(NumberType.INTEGER, "2147483648", "out of range for an integer"),
                true,  
        w.close();
            short value = randomShort();  
            DoublePoint.encodeDimension(value, bytes, 0);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.BYTE);
                fallbackQuery = ((IndexSortSortedNumericDocValuesRangeQuery) ((ApproximateScoreQuery) query).getOriginalQuery())
        // this test checks that searching half floats yields the same results as
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
                query,
            ft.bitmapQuery(bitmap)  
            ftLong.rangeQuery(0, 2, true, true, null, null, null, MOCK_QSC),
        }  
        NumberFieldType otherFieldType = new NumberFieldType("foo", otherType);
            float u = (randomFloat() * 2 - 1) * 65504;
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE).valueForDisplay(1.2)
        );
        Settings settings = Settings.builder()  
        assertEquals((byte) 5, NumberType.BYTE.parse("5", true));
            Long.valueOf(3),
                u,  
        );
        MappedFieldType ftLong = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
    public void testByteRangeQueryWithDecimalParts() {  
            () -> 0L,
        assertTrue(ft.termsQuery(Arrays.asList(1.1, 2.1), null) instanceof MatchNoDocsQuery);
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
            ftLong.rangeQuery(-3, -3, true, true, null, null, null, MOCK_QSC),
        );
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
import java.io.ByteArrayOutputStream;
        assertEquals(BigInteger.valueOf(5), NumberType.UNSIGNED_LONG.parse((byte) 5, true));  
        assertTrue(ft.termsQuery(Arrays.asList(1.1, 2.1), null) instanceof MatchNoDocsQuery);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);  
            IndexNumericFieldData fielddata = (IndexNumericFieldData) ft.fielddataBuilder(
}
        IllegalArgumentException e = expectThrows(
    }
 */  
            Double.valueOf(1.2),  
        assertEquals(
        assertEquals((long) 5, NumberType.LONG.parse("5.9", true));
    public void testDocValueByteRange() throws Exception {  
                NumericUtils.doubleToSortableLong(1),
            assertTrue(fetcher.advanceExact(0));
import org.opensearch.index.mapper.MappedFieldType.Relation;
        );  
    public void testDocValueShortRange() throws Exception {
        );  
import org.apache.lucene.index.DirectoryReader;  
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
            byte[] bytes = new byte[Integer.BYTES];
    public void testNegativeZero() {
 * The OpenSearch Contributors require contributions made to  
            IndexOrDocValuesQuery indexOrDvQuery = (IndexOrDocValuesQuery) fallbackQuery;  
        assertEquals(
            ftLong.rangeQuery(-2, -1, true, true, null, null, null, MOCK_QSC),  
        IOUtils.close(reader, dir);  
        assertEquals(  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        Directory dir = newDirectory();  
        }
        );
            double value = randomDouble();  
        assertEquals(5, NumberType.INTEGER.parse(new BytesRef("5.3".getBytes(StandardCharsets.UTF_8)), true));
            ftInt.rangeQuery(-2.5, -0.5, false, false, null, null, null, MOCK_QSC)
        assertEquals(1.1f, NumberType.HALF_FLOAT.parse(1.1, true));
        BytesArray bitmap = new BytesArray(array);
        );  
        dir.close();  
            .build(context)  
        byte[] array;
        );  
            SortedNumericDocValuesField.newSlowRangeQuery(  
    }
        assertEquals((short) 3, NumberType.SHORT.parse(3.5, true));
            null,  
            Query unsignedLongQ = NumberType.UNSIGNED_LONG.rangeQuery(  
import org.apache.lucene.sandbox.document.HalfFloatPoint;
    }
        );
    }  
        assertTrue(ft.termQuery(42.1, null) instanceof MatchNoDocsQuery);
    public void testCoercions() {  
        }
    }
        DirectoryReader reader = DirectoryReader.open(w);  
        DirectoryReader reader = DirectoryReader.open(w);
            OutOfRangeSpec.of(NumberType.DOUBLE, "1.7976931348623157E309", "[double] supports only finite values"),
        MappedFieldType nullValueMapper = new NumberFieldMapper.Builder("field", NumberType.FLOAT, false, true).nullValue(2.71f)
        assertEquals(
        doTestDocValueRangeQueries(NumberType.FLOAT, random()::nextFloat);
        assertEquals(
            NumberType.FLOAT.rangeQuery("field", null, +0f, true, false, false, true, MOCK_QSC)
            xContentRegistry(),
                randomBoolean(),
import org.opensearch.cluster.metadata.IndexMetadata;
            ft.rangeQuery(1, 10.1, true, true, null, null, null, MOCK_QSC)  
 * license agreements. See the NOTICE file distributed with
        assertEquals(  
import org.opensearch.index.document.SortedUnsignedLongDocValuesRangeQuery;
        assertEquals(3f, NumberType.FLOAT.parse(3d, true));  
                assertThat(fallbackQuery, instanceOf(IndexOrDocValuesQuery.class));
            // ends up being rounded to Infinity by halfFloatToSortableShort()  
            assertThat(NumberType.LONG.parsePoint(bytes), equalTo(value));
        );  
import org.opensearch.index.query.QueryShardContext;
            assertNull(fieldType.valueForDisplay(null));
import org.apache.lucene.document.FloatPoint;
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
    public void testUnsignedLongTermsQuery() {
            ftLong.rangeQuery(-3, -3, true, true, null, null, null, MOCK_QSC),
            boolean includeLower = randomBoolean();
    }
                true,  
        assertEquals(
import java.io.IOException;
        );
        assertEquals((short) 5, NumberType.SHORT.parse("5", true));
            Query doubleQ = NumberType.DOUBLE.rangeQuery("double", l, u, includeLower, includeUpper, false, true, MOCK_QSC);
            float value = (randomFloat() * 2 - 1) * 70000;
        );
    public void testUnsignedLongRange() throws IOException {  
                random().nextBoolean() ? null : valueSupplier.get(),
        RoaringBitmap r = new RoaringBitmap();
            null,
            OutOfRangeSpec.of(NumberType.FLOAT, -3.4028235E39d, "[float] supports only finite values"),  
            final Object value = fetcher.nextValue();
            new ApproximatePointRangeQuery("field", pack(1).bytes, pack(3).bytes, 1, ApproximatePointRangeQuery.LONG_FORMAT)
            IllegalArgumentException.class,
        // Create an index writer configured with the same index sort.
public class NumberFieldTypeTests extends FieldTypeTestCase {
    public void testLongRangeQuery() {
        final Object value;  
        );  
import org.opensearch.index.fielddata.IndexNumericFieldData;
        assertEquals(
        assertEquals(query, ft.termQuery("42", null));  
            NumberType.HALF_FLOAT.rangeQuery("field", null, -0f, true, true, false, true, MOCK_QSC),
        // searching floats that are rounded to the closest half float  
            } catch (IllegalArgumentException e) {
                NumericUtils.doubleToSortableLong(3)  
        assertEquals(Numbers.MAX_UNSIGNED_LONG_VALUE, NumberType.UNSIGNED_LONG.parse(Numbers.MAX_UNSIGNED_LONG_VALUE, true));
    static class OutOfRangeSpec {  
import org.apache.lucene.sandbox.document.BigIntegerPoint;  
 */  
    }  
 * SPDX-License-Identifier: Apache-2.0
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery("42", null));  
    }  
import java.math.BigDecimal;
            );
        }  
import java.io.ByteArrayInputStream;
        for (int i = 0; i < numDocs; ++i) {
        assertEquals(
        assertEquals(BigInteger.valueOf(5), NumberType.UNSIGNED_LONG.parse("5.0", true));
                DoublePoint.pack(new double[] { 3d }).bytes,
            }
    }
            assertThat(NumberType.DOUBLE.parsePoint(bytes), equalTo(value));
import org.opensearch.search.approximate.ApproximateScoreQuery;  
        );
    }  
        );
        assertEquals(
        NumberFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.INTEGER);  
            byte[] bytes = new byte[Long.BYTES];
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),  
import java.util.function.Supplier;  
    public void testEqualsWithDifferentNumberTypes() {
        assertEquals((long) 5, NumberType.LONG.parse("5", true));  
            ftLong.rangeQuery(-2.5, -0.5, true, true, null, null, null, MOCK_QSC)
        assertEquals(BigInteger.valueOf(5), NumberType.UNSIGNED_LONG.parse(new BytesRef("5.3".getBytes(StandardCharsets.UTF_8)), true));
            ftInt.rangeQuery(0.5, 2.5, true, true, null, null, null, MOCK_QSC)  
        final int numDocs = TestUtil.nextInt(random(), 100, 500);
            ftLong.rangeQuery(-2.5, -0.5, false, false, null, null, null, MOCK_QSC)
        doTestDocValueRangeQueries(NumberType.INTEGER, random()::nextInt);  
        // Ensure that the optimized index sort query gives the same results as a points query.  
import org.opensearch.search.DocValueFormat;  
            OutOfRangeSpec.of(NumberType.BYTE, -129, "is out of range for a byte"),
            value = v;  
        MappedFieldType unsearchable = unsearchable();
        }  
        DirectoryReader reader = DirectoryReader.open(w);
            new IndexOrDocValuesQuery(LongPoint.newSetQuery("field", 1), SortedNumericDocValuesField.newSlowSetQuery("field", 1)),
        {
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
        );
        reader.close();
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
            NumberType.DOUBLE.rangeQuery("field", null, -0d, true, true, false, true, MOCK_QSC),  
            ftLong.rangeQuery(1, 2, true, true, null, null, null, MOCK_QSC),  
        final int numDocs = 10000;  
        Query expected = new IndexOrDocValuesQuery(  
        reader.close();  
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
        assertEquals(
            Query query = type.rangeQuery(
            OutOfRangeSpec.of(NumberType.BYTE, "128", "out of range for a byte"),
        w.close();
        assertEquals(  
    }
                assertThat(fallbackQuery, instanceOf(IndexOrDocValuesQuery.class));  
            ftInt.rangeQuery(0.5, 2.5, false, false, null, null, null, MOCK_QSC)
            ft.rangeQuery(1.1, 10, true, true, null, null, null, MOCK_QSC)
        doc.add(new SortedNumericDocValuesField("ul", expectedValue.longValue()));
 * KIND, either express or implied.  See the License for the
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig());
import org.apache.lucene.document.DoublePoint;
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);  
                "field",
            if (value instanceof BigInteger) {
    public void testIndexSortIntRange() throws Exception {
    public void doTestDocValueRangeQueries(NumberType type, Supplier<Number> valueSupplier) throws Exception {
            ftLong.rangeQuery(-2, 0, true, true, null, null, null, MOCK_QSC),
            null,
        {
import org.opensearch.index.IndexSettings;
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
    }
import org.apache.lucene.util.NumericUtils;  
        assertEquals("Value [1.0E19] is out of range for a long", e.getMessage());
        assertEquals(BigInteger.valueOf(5), NumberType.UNSIGNED_LONG.parse("5.9", true));  
        static OutOfRangeSpec of(NumberType t, Object v, String m) {  
            );  
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
        }  
        // these will lose precision if they get treated as a double
 * specific language governing permissions and limitations
            DocValueFetcher.Leaf fetcher = fielddata.load(reader.leaves().get(0)).getLeafValueFetcher(DocValueFormat.UNSIGNED_LONG);
        for (NumberFieldMapper.NumberType type : NumberFieldMapper.NumberType.values()) {
            new IndexOrDocValuesQuery(IntPoint.newSetQuery("field", 1), SortedNumericDocValuesField.newSlowSetQuery("field", 1)),  
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),  
            assertThat(  
        e = expectThrows(IllegalArgumentException.class, () -> NumberType.UNSIGNED_LONG.parse(100000000000000000000d, true));
            )
        assertEquals(new Bitmap64DocValuesQuery("field", r), ft.bitmapQuery(bitmap));
        assertTrue(ft.termQuery(42.1, null) instanceof MatchNoDocsQuery);
            OutOfRangeSpec.of(NumberType.INTEGER, -2147483649L, "is out of range for an integer"),  
    }
        Query expected = new ApproximateScoreQuery(  
        NumberType otherType = randomValueOtherThan(type, () -> randomFrom(NumberType.values()));  
    }
    }
            if (query instanceof IndexSortSortedNumericDocValuesRangeQuery) {  
        assertEquals(5, NumberType.INTEGER.parse((byte) 5, true));
    }
        assertEquals(  
        );  
            byte[] bytes = new byte[Float.BYTES];
            null,
        );  
        {
        assertEquals(3f, NumberType.HALF_FLOAT.parse(3d, true));
            Query floatQ = NumberType.FLOAT.rangeQuery("float", l, u, includeLower, includeUpper, false, true, MOCK_QSC);
            assertThat(  
        assertEquals(Collections.singletonList(2.71f), fetchSourceValue(nullValueMapper, null));  
                "field",
            long value = randomLong();  
    }  
        assertEquals(  
            ft.rangeQuery(1, 10.1, true, false, null, null, null, MOCK_QSC)  
import java.util.Arrays;  
            ftLong.rangeQuery(-0.5, 2.5, true, true, null, null, null, MOCK_QSC)
        NumberType type = randomFrom(NumberType.values());  
    }
 * You may obtain a copy of the License at  
            ftInt.rangeQuery(-2, 0, true, true, null, null, null, MOCK_QSC),
        assertEquals(
        assertEquals(
import static org.hamcrest.Matchers.equalTo;
        ft = new NumberFieldType("field", NumberType.LONG, true, false, false, false, true, null, Collections.emptyMap());  
        doTestDocValueRangeQueries(NumberType.LONG, random()::nextLong);
            DoublePoint.newRangeQuery("field", 1d, 3d),
import org.opensearch.core.xcontent.XContentBuilder;  
            return new OutOfRangeSpec(t, v, m);
                "unsigned_long",
        IOUtils.close(reader, dir);
            w.addDocument(doc);  
        );  
            ft.rangeQuery(1.1, 10, false, true, null, null, null, MOCK_QSC)  
        doTestDocValueRangeQueries(NumberType.DOUBLE, random()::nextDouble);
        assertEquals((short) 5, NumberType.SHORT.parse(new BytesRef("5.3".getBytes(StandardCharsets.UTF_8)), true));
        assertEquals((short) 5, NumberType.SHORT.parse((byte) 5, true));
        reader.close();
import java.math.BigInteger;  
        assertEquals(new MatchNoDocsQuery(), ft.bitmapQuery(bitmap).rewrite(newSearcher(reader)));  
        );
            ft.rangeQuery(1.1, 10, true, true, null, null, null, MOCK_QSC)  
import org.apache.lucene.tests.util.TestUtil;
        assertEquals(3.5f, NumberType.FLOAT.parse(3.5, true));  
import org.opensearch.common.util.io.IOUtils;  
            null,  
            ftLong.rangeQuery(0, 2, true, true, null, null, null, MOCK_QSC),
        assertEquals(5, NumberType.INTEGER.parse("5.0", true));  
import org.junit.Before;
    }  
        Directory dir = newDirectory();  
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig());
            IntPoint.encodeDimension(value, bytes, 0);
import org.apache.lucene.index.IndexWriter;
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
        assertEquals((byte) 5, NumberType.BYTE.parse(new BytesRef("5.3".getBytes(StandardCharsets.UTF_8)), true));
        final int iters = 10;  
            w.addDocument(doc);
            ftLong.rangeQuery(0, 0, true, true, null, null, null, MOCK_QSC),  
            OutOfRangeSpec.of(NumberType.LONG, new BigInteger("9223372036854775808"), " is out of range for a long"),  
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.HALF_FLOAT).valueForDisplay(1.2)  
            )
        final int numDocs = TestUtil.nextInt(random(), 100, 500);
        reader.close();
            r.serializePortable(dos);
 * under the License.  
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.INTEGER).valueForDisplay(3)
            try {
            indexOrDvQuery,  
        byte[] array = new byte[r.serializedSizeInBytes()];
            ft.rangeQuery(1, 10.1, true, false, null, null, null, MOCK_QSC)
        );  
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
            ft.rangeQuery(1, 10.1, true, true, null, null, null, MOCK_QSC)
                DoublePoint.pack(new double[] { 1d }).bytes,
import org.opensearch.search.query.BitmapIndexQuery;
        );
 * this file be licensed under the Apache-2.0 license or a
            BigInteger value = randomUnsignedLong();  
        );
    }
                "field",  
            ftInt.rangeQuery(-2, -1, true, true, null, null, null, MOCK_QSC),  
        assertEquals(3.5d, NumberType.DOUBLE.parse(3.5, true));
        Query indexOrDvQuery = new IndexOrDocValuesQuery(
        assertEquals(  
        assertThrows(IllegalArgumentException.class, () -> finalFt.bitmapQuery(bitmap));
            Relation.INTERSECTS,
        assertTrue(ft.termQuery(42.1, null) instanceof MatchNoDocsQuery);
                NumberType.UNSIGNED_LONG.encodePoint(BigInteger.valueOf(3)),
        );
        assertEquals((byte) 3, NumberType.BYTE.parse(3d, true));  
        assertEquals(  
        assertEquals(
        );  
        assertEquals(BigInteger.valueOf(3L), NumberType.UNSIGNED_LONG.parse(3.5, true));
        Query expected = new ApproximateScoreQuery(  
                    .or(instanceOf(ApproximateScoreQuery.class))  
    // Make sure we construct the IndexOrDocValuesQuery objects with queries that match
        MappedFieldType unsearchable = unsearchable();  
            ft.isFieldWithinQuery(null, randomDouble(), randomDouble(), randomBoolean(), randomBoolean(), null, null, null)
import org.apache.lucene.util.BytesRef;
 * GitHub history for details.
        public void write(XContentBuilder b) throws IOException {
            OutOfRangeSpec.of(NumberType.BYTE, 128, "is out of range for a byte"),  
            float value = randomFloat();  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> NumberType.BYTE.parse(128, true));  
 *
        );
        assertEquals(3, NumberType.INTEGER.parse(3d, true));
                    containsString(item.message)  
        }  
        assertEquals("Value [65536] is out of range for a short", e.getMessage());  
 *
        Directory dir = newDirectory();
    public void testUnsignedLongRangeQuery() {
        NumberFieldType finalFt = ft;  
        );
 * compatible open source license.
import org.roaringbitmap.longlong.Roaring64NavigableMap;  
        Directory dir = newDirectory();  
        );
            OutOfRangeSpec.of(NumberType.INTEGER, 2147483648L, "is out of range for an integer"),
        );
        }
            assertEquals(searcher.count(query), searcher.count(indexOrDvQuery.getIndexQuery()));
        ft = new NumberFieldType("field", NumberType.INTEGER, false, false, true, true, true, null, Collections.emptyMap());  
        {
        IllegalArgumentException e = expectThrows(
        assertEquals((byte) 5, NumberType.BYTE.parse("5.9", true));
        assertEquals(
        NumberType type = randomValueOtherThan(NumberType.LONG, () -> randomFrom(NumberType.values()));
            OutOfRangeSpec.of(NumberType.DOUBLE, Double.POSITIVE_INFINITY, "[double] supports only finite values"),  
            ftInt.rangeQuery(-0.5, 0.5, false, false, null, null, null, MOCK_QSC)
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, Float.NEGATIVE_INFINITY, "[half_float] supports only finite values"),
        assertEquals(new Bitmap64IndexQuery("field", r), ft.bitmapQuery(bitmap));
            ft.rangeQuery(1.1, 10, true, true, null, null, null, MOCK_QSC)
            int value = randomInt();  
        for (int i = 0; i < numQueries; ++i) {  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                1,  
        r.serialize(ByteBuffer.wrap(array));  
    }
            Query fallbackQuery;
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.INTEGER);
            HalfFloatPoint.encodeDimension(value, bytes, 0);
        );  
    }
        NumberFieldType fieldType = new NumberFieldType("field", type);
            IllegalArgumentException.class,
                false,  
        );  
    public void testDocValueDoubleRange() throws Exception {
        );
            ftInt.rangeQuery(-2, -1, true, true, null, null, null, MOCK_QSC),
        dir.close();
        assertEquals((long) 5, NumberType.LONG.parse(new BytesRef("5.3".getBytes(StandardCharsets.UTF_8)), true));  
            ftLong.rangeQuery(-3.5, -2.5, true, true, null, null, null, MOCK_QSC)
        }  
            OutOfRangeSpec.of(NumberType.SHORT, 32768, "is out of range for a short"),
        doTestDocValueRangeQueries(NumberType.SHORT, () -> (short) random().nextInt(65536));
        MappedFieldType unsearchable = unsearchable();  
        assertEquals(
    }
                "field",  
            new IndexOrDocValuesQuery(new Bitmap64IndexQuery("field", r), new Bitmap64DocValuesQuery("field", r)),
        e = expectThrows(IllegalArgumentException.class, () -> NumberType.LONG.parse(10000000000000000000d, true));  
            );
import org.apache.lucene.search.IndexSortSortedNumericDocValuesRangeQuery;
            new IndexOrDocValuesQuery(new BitmapIndexQuery("field", r), new BitmapDocValuesQuery("field", r)),
        );  
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.BYTE).valueForDisplay(3)
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.INTEGER);
            ftLong.rangeQuery(-2, 0, true, true, null, null, null, MOCK_QSC),
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); DataOutputStream dos = new DataOutputStream(bos)) {  
        doTestIndexSortRangeQueries(NumberType.INTEGER, random()::nextInt);  
                randomBoolean(),  
        MappedFieldType ftInt = new NumberFieldMapper.NumberFieldType("field", NumberType.INTEGER);
            byte[] bytes = new byte[Integer.BYTES];
        Query indexOrDvQuery = new IndexOrDocValuesQuery(
            () -> unsearchable.rangeQuery("1", "3", true, true, null, null, null, MOCK_QSC)  
    public void doTestIndexSortRangeQueries(NumberType type, Supplier<Number> valueSupplier) throws IOException {
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.UNSIGNED_LONG);
            assertThat(NumberType.SHORT.parsePoint(bytes), equalTo(value));
        );  
                    e.getMessage(),
        assertEquals(
import org.opensearch.search.query.Bitmap64DocValuesQuery;
            SortedUnsignedLongDocValuesRangeQuery.newSlowRangeQuery("field", BigInteger.valueOf(1), BigInteger.valueOf(3))  
            indexOrDvQuery,
        Roaring64NavigableMap r = new Roaring64NavigableMap();  
import org.opensearch.search.query.BitmapDocValuesQuery;  
        assertEquals(
        );
        IllegalArgumentException e = expectThrows(  
        MappedFieldType unsearchable = unsearchable();  
        );
        doTestDocValueRangeQueries(NumberType.UNSIGNED_LONG, FieldTypeTestCase::randomUnsignedLong);
    public void testDocValueFloatRange() throws Exception {  
            ft.rangeQuery(1, 10.1, true, false, null, null, null, MOCK_QSC)
        }
            BigInteger l = randomUnsignedLong();
        assertEquals(  
    }
            ftLong.rangeQuery(0, 0, true, true, null, null, null, MOCK_QSC),
package org.opensearch.index.mapper;
        SortField sortField = fielddata.sortField(null, MultiValueMode.MIN, null, randomBoolean());  
            NumberType.FLOAT.rangeQuery("field", null, -0f, true, true, false, true, MOCK_QSC),
                item.type.parse(item.value, false);  
    }  
            NumberFieldMapper.NumberFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", type);  
            boolean includeLower = randomBoolean();  
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG).valueForDisplay(3L)
            ft.rangeQuery(1.1, 10, false, true, null, null, null, MOCK_QSC)
    public void testIndexSortLongRange() throws Exception {  
        final DirectoryReader reader = DirectoryReader.open(w);
        assertEquals(new MatchNoDocsQuery(), ft.bitmapQuery(bitmap).rewrite(newSearcher(reader)));
            w.addDocument(type.createFields("foo", valueSupplier.get(), true, true, false, false));
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
        );
        );
            0,
        }
    }
            ftLong.rangeQuery(-0.5, 0.5, false, false, null, null, null, MOCK_QSC)
            NumberType.DOUBLE.rangeQuery("field", null, +0d, true, false, false, true, MOCK_QSC)
        );
    public void testIsFieldWithinQuery() throws IOException {  
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, "65520", "[half_float] supports only finite values"),  
        assertEquals(3d, NumberType.DOUBLE.parse(3d, true));
        for (int i = 0; i < numDocs; ++i) {  
        NumberFieldType finalFt = ft;
import org.opensearch.index.document.SortedUnsignedLongDocValuesSetQuery;  
            ft.rangeQuery(1, 10.1, true, false, null, null, null, MOCK_QSC)
        assertEquals(
        assertEquals(  
        );
                query,
            assertThat(NumberType.BYTE.parsePoint(bytes), equalTo(value));
import java.nio.ByteBuffer;
        assertEquals(
                random().nextBoolean() ? null : valueSupplier.get(),
        assertEquals(Collections.singletonList(42), fetchSourceValue(mapper, "42.9"));  
        assertEquals(BigInteger.valueOf(3L), NumberType.UNSIGNED_LONG.parse(3d, true));
            doc.add(new BigIntegerPoint("unsigned_long", value));
            new IndexOrDocValuesQuery(IntPoint.newSetQuery("field", 1), SortedNumericDocValuesField.newSlowSetQuery("field", 1)),
            byte value = randomByte();  
            ft.rangeQuery(1.1, 10, true, true, null, null, null, MOCK_QSC)
            assertEquals(searcher.count(floatQ), searcher.count(halfFloatQ));
            ft.rangeQuery(1, 10.1, true, true, null, null, null, MOCK_QSC)
            ftLong.rangeQuery(0.5, 2.5, false, false, null, null, null, MOCK_QSC)
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
    public void testDisplayValue() {
    }
        return new NumberFieldType("field", NumberType.LONG, false, false, false, false, true, null, Collections.emptyMap());
            null,  
 * ownership. Elasticsearch licenses this file to you under  
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
        assertEquals(  
        );
                includeLower,
        );  
        writerConfig.setIndexSort(new Sort(sortField));  
            throw new UnsupportedOperationException();
        );
    public void testDoubleRangeQuery() {
import org.opensearch.common.util.BigArrays;
        }).build(null, null);
            null,
            assertThat(NumberType.HALF_FLOAT.parsePoint(bytes), equalTo(value));
    public void testFetchSourceValue() throws IOException {  
                b.field("field", value);
 *  
import org.apache.lucene.search.Sort;
            Short.valueOf((short) 3),
            }
import static org.hamcrest.Matchers.instanceOf;
import org.apache.lucene.search.Query;  
import org.apache.lucene.store.Directory;  
        IndexSearcher searcher = newSearcher(reader);
        ft = new NumberFieldMapper.NumberFieldType("field", type);  
        assertEquals(
        assertEquals(Collections.singletonList(3), fetchSourceValue(mapper, 3.14));
        IndexSearcher searcher = newSearcher(reader);
        assertEquals(5, NumberType.INTEGER.parse("5.9", true));
import java.nio.charset.StandardCharsets;
        assertEquals("Value [128] is out of range for a byte", e.getMessage());
    public void testFetchUnsignedLongDocValues() throws IOException {
            IllegalArgumentException.class,
            ft.termsQuery(Arrays.asList(1, 2.1), null)
        ft = new NumberFieldType("field", NumberType.INTEGER, true, false, false, false, true, null, Collections.emptyMap());  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertFalse(
            OutOfRangeSpec.of(NumberType.FLOAT, Float.POSITIVE_INFINITY, "[float] supports only finite values"),
        }  
        );  
/*  
        );
                context
            dos.flush();
        }
        );
        assertEquals(
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, 65520f, "[half_float] supports only finite values"),
                l,
            Integer.valueOf(3),  
    public void testBitmapQuery64() throws IOException {
            // Note: this test purposefully allows half-floats to be indexed over their dynamic range (65504), which
                ApproximatePointRangeQuery.DOUBLE_FORMAT
        w.addDocument(doc);
        assertEquals(3L, NumberType.LONG.parse(3.5, true));  
        IndexSearcher searcher = newSearcher(reader);
            doc.add(new FloatPoint("float", rounded));
    }  
        assertEquals(
        final int numDocs = 10000;
        {
        final BigInteger expectedValue = randomUnsignedLong();  
                    .getFallbackQuery();
    }
            ftLong.rangeQuery(-2.5, 0.5, true, true, null, null, null, MOCK_QSC)
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, Float.POSITIVE_INFINITY, "[half_float] supports only finite values"),
import org.apache.lucene.document.IntPoint;  
                assertThat(  
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
        }
 */
    public void testHalfFloatRange() throws IOException {
            OutOfRangeSpec.of(NumberType.FLOAT, "3.4028235E39", "[float] supports only finite values"),
    }  
        DirectoryReader reader = DirectoryReader.open(w);
        assertEquals(
    public void testShortRangeQueryWithDecimalParts() {
        assertEquals(
    }
            float value = 3f;  
        }
import org.opensearch.common.Numbers;  
        assertEquals(  
            boolean includeUpper = randomBoolean();
import org.roaringbitmap.RoaringBitmap;
            BigArrays.NON_RECYCLING_INSTANCE,
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),  
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.SHORT).valueForDisplay(3)  
        e = expectThrows(IllegalArgumentException.class, () -> NumberType.INTEGER.parse(2147483648L, true));
            w.addDocument(type.createFields("field", valueSupplier.get(), true, true, false, false));  
        );
                "index",  
                MOCK_QSC
                    "Incorrect error message for [" + item.type + "] with value [" + item.value + "]",
            OutOfRangeSpec.of(NumberType.FLOAT, 3.4028235E39d, "[float] supports only finite values"),
            byte[] bytes = new byte[Double.BYTES];
import org.opensearch.search.MultiValueMode;
            ft.rangeQuery(1.1, 10, false, true, null, null, null, MOCK_QSC)
    @Before  
            assertThat(NumberType.FLOAT.parsePoint(bytes), equalTo(value));
                random().nextBoolean() ? null : valueSupplier.get(),
        );
        IndexWriter w = new IndexWriter(dir, writerConfig);  
            OutOfRangeSpec.of(NumberType.FLOAT, Float.NEGATIVE_INFINITY, "[float] supports only finite values"),  
            OutOfRangeSpec.of(NumberType.DOUBLE, new BigDecimal("-1.7976931348623157E309"), "[double] supports only finite values"),
        assertEquals(-4115420654264075766L, NumberType.LONG.parse(-4115420654264075766L, true));
import java.util.Collections;
            Query halfFloatQ = NumberType.HALF_FLOAT.rangeQuery("half_float", l, u, includeLower, includeUpper, false, true, MOCK_QSC);  
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),  
            writableRegistry(),
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.UNSIGNED_LONG);  
        }
            } else {  
                includeUpper,
        assertFalse(NumberType.DOUBLE.termQuery("field", -0d, true, true).equals(NumberType.DOUBLE.termQuery("field", +0d, true, true)));  
        assertEquals(
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
            ft.rangeQuery(1, 10.1, true, true, null, null, null, MOCK_QSC)  
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
                MOCK_QSC
        for (int i = 0; i < numDocs; ++i) {
        assertEquals(
    public void testParseOutOfRangeValues() throws IOException {  
        assertEquals(  
            () -> true,
                NumberType.UNSIGNED_LONG.encodePoint(BigInteger.valueOf(1)),  
        assertEquals(
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);  
    }  
                ApproximatePointRangeQuery.UNSIGNED_LONG_FORMAT  
        for (int iter = 0; iter < iters; ++iter) {
    public void testDocValueHalfFloatRange() throws Exception {
        assertEquals(  
        );
        assertEquals(
                assertEquals(searcher.count(indexOrDvQuery.getIndexQuery()), searcher.count(indexOrDvQuery.getRandomAccessQuery()));
                either(instanceOf(IndexSortSortedNumericDocValuesRangeQuery.class)).or(instanceOf(ApproximateScoreQuery.class))
            OutOfRangeSpec.of(NumberType.DOUBLE, Double.NaN, "[double] supports only finite values"),
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, Float.NaN, "[half_float] supports only finite values"),  
            () -> unsearchable.rangeQuery("1", "3", true, true, null, null, null, MOCK_QSC)  
            }
            BigIntegerPoint.newRangeQuery("field", BigInteger.valueOf(1), BigInteger.valueOf(3)),
            .build();
            IllegalArgumentException.class,
        assertEquals(
        assertEquals(
            NumberType.HALF_FLOAT.termQuery("field", -0f, true, true).equals(NumberType.HALF_FLOAT.termQuery("field", +0f, true, true))  
        assertEquals(5, NumberType.INTEGER.parse("5", true));
        );
import org.apache.lucene.document.LongPoint;
        w.close();
            assertThat(NumberType.INTEGER.parsePoint(bytes), equalTo(value));
            )
            ft.rangeQuery(1.1, 10, false, true, null, null, null, MOCK_QSC)
            Byte.valueOf((byte) 3),
            null  
        assertEquals(Collections.singletonList(2.71f), fetchSourceValue(nullValueMapper, ""));
            ftInt.rangeQuery(-0.5, 0.5, true, true, null, null, null, MOCK_QSC)
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.SHORT);  
                randomBoolean(),
 * the Apache License, Version 2.0 (the "License"); you may
        }  
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
        assertEquals(expected, ft.rangeQuery("1", "3", true, true, null, null, null, MOCK_QSC));
        assertEquals(  
        );
            ftInt.rangeQuery(-2.5, 0.5, true, true, null, null, null, MOCK_QSC)
                true,
        );
        NumberFieldType fieldType = new NumberFieldType("foo", type);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.UNSIGNED_LONG);  
            assertEquals(IndexNumericFieldData.NumericType.UNSIGNED_LONG, fielddata.getNumericType());  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals((long) 5, NumberType.LONG.parse("5.0", true));
            doc.add(new HalfFloatPoint("half_float", value));  
            ftLong.rangeQuery(-2, -1, true, true, null, null, null, MOCK_QSC),
            OutOfRangeSpec.of(NumberType.LONG, new BigInteger("-9223372036854775809"), " is out of range for a long"),
        for (OutOfRangeSpec item : inputs) {
        MappedFieldType mapper = new NumberFieldMapper.Builder("field", NumberType.INTEGER, false, true).build(context).fieldType();
        assertEquals(
                either(instanceOf(IndexOrDocValuesQuery.class)).or(instanceOf(MatchNoDocsQuery.class))
            Double.valueOf(1.2),
        assertEquals((long) 5, NumberType.LONG.parse((byte) 5, true));
        w.close();
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),  
            BigInteger u = randomUnsignedLong();  
            .put("index.sort.field", "field")
        assertEquals(  
            ftLong.rangeQuery(1, 2, true, true, null, null, null, MOCK_QSC),
 * Modifications Copyright OpenSearch Contributors. See
    }  
        assertEquals(new BitmapIndexQuery("field", r), ft.bitmapQuery(bitmap));
import static org.hamcrest.Matchers.containsString;
            ftLong.rangeQuery(-0.5, 2.5, false, false, null, null, null, MOCK_QSC)  
            ftInt.rangeQuery(-0.5, 2.5, false, false, null, null, null, MOCK_QSC)  
            new IndexOrDocValuesQuery(LongPoint.newSetQuery("field", 1), SortedNumericDocValuesField.newSlowSetQuery("field", 1)),
            .fieldType();
    public void testByteTermQueryWithDecimalPart() {
        assertEquals(
        ft = new NumberFieldType("field", NumberType.LONG, false, false, true, true, true, null, Collections.emptyMap());  
                b.rawField("field", new ByteArrayInputStream(value.toString().getBytes("UTF-8")), MediaTypeRegistry.JSON);  
            byte[] bytes = new byte[Float.BYTES];
            OutOfRangeSpec.of(NumberType.DOUBLE, Double.NEGATIVE_INFINITY, "[double] supports only finite values")
        );  
            ft.rangeQuery(1.1, 10, false, true, null, null, null, MOCK_QSC)
        {
        assertEquals(  
            assertEquals(expectedValue, value);  
            SortedUnsignedLongDocValuesSetQuery.newSlowSetQuery("field", BigInteger.valueOf(1), BigInteger.valueOf(3))
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
                () -> { throw new UnsupportedOperationException(); }
        assertEquals(1.1d, NumberType.DOUBLE.parse(1.1, true));  
                "foo",  
        w.close();  
            OutOfRangeSpec.of(NumberType.DOUBLE, new BigDecimal("1.7976931348623157E309"), "[double] supports only finite values"),  
        IllegalArgumentException e = expectThrows(
        assertEquals((byte) 5, NumberType.BYTE.parse("5.0", true));  
        Directory dir = newDirectory();  
        QueryShardContext context = new QueryShardContext(
import org.apache.lucene.search.MatchNoDocsQuery;
        );  
        final int numQueries = 1000;
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
            FloatPoint.encodeDimension(value, bytes, 0);
    public void testIntegerRangeQueryWithDecimalParts() {
        IndexNumericFieldData fielddata = (IndexNumericFieldData) fieldType.fielddataBuilder("index", () -> {  
            ftLong.rangeQuery(0.5, 2.5, true, true, null, null, null, MOCK_QSC)  
        assertEquals(1.1f, NumberType.FLOAT.parse(1.1, true));
            array = bos.toByteArray();  
            ftInt.rangeQuery(-2.5, -0.5, true, true, null, null, null, MOCK_QSC)
import org.opensearch.common.settings.Settings;
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
            final NumberFieldType ft = new NumberFieldType("ul", NumberType.UNSIGNED_LONG);
            () -> unsearchable.rangeQuery("1", "3", true, true, null, null, null, MOCK_QSC)
        assertEquals(  
            BigIntegerPoint.newSetQuery("field", BigInteger.valueOf(1), BigInteger.valueOf(3)),
            assertTrue(value instanceof BigInteger);
    }
 * this work for additional information regarding copyright
            ft.rangeQuery(1, 10.1, true, false, null, null, null, MOCK_QSC)  
            new IndexOrDocValuesQuery(LongPoint.newRangeQuery("field", 1, 3), SortedNumericDocValuesField.newSlowRangeQuery("field", 1, 3)),
        assertEquals((short) 3, NumberType.SHORT.parse(3d, true));
        assertEquals((short) 5, NumberType.SHORT.parse("5.9", true));
    public void testDocValueUnsignedLongRange() throws Exception {
        assertEquals(3L, NumberType.LONG.parse(3d, true));  
            ftInt.rangeQuery(1, 2, true, true, null, null, null, MOCK_QSC),
        doTestIndexSortRangeQueries(NumberType.LONG, random()::nextLong);
        Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery("field", 42);
            Double.valueOf(1.2),
            IntPoint.encodeDimension(value, bytes, 0);
            ft.termsQuery(Arrays.asList(1.0, 2.1), null)  
        // current impl ignores args and should always return INTERSECTS
        assertEquals(3, NumberType.INTEGER.parse(3.5, true));
        assertEquals(
        assertEquals(BigInteger.valueOf(5), NumberType.UNSIGNED_LONG.parse("5", true));
        final List<OutOfRangeSpec> inputs = Arrays.asList(
    public void pickType() {
        // this test checks that searching half floats yields the same results as
            new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.FLOAT).valueForDisplay(1.2)
            ftInt.rangeQuery(-2, 0, true, true, null, null, null, MOCK_QSC),
        IndexSearcher searcher = newSearcher(reader);
            );
        assertTrue(ft.termQuery(42.1, null) instanceof MatchNoDocsQuery);  
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.INTEGER);
        assertEquals(-4115420654264075766L, NumberType.LONG.parse("-4115420654264075766", true));  
            ).build(null, null);
        IOUtils.close(w, dir);
        );  
            indexSettings,  
        e = expectThrows(IllegalArgumentException.class, () -> NumberType.SHORT.parse(65536, true));
            Document doc = new Document();
            ftInt.rangeQuery(-3.5, -2.5, false, false, null, null, null, MOCK_QSC)  
import org.apache.lucene.search.SortField;
        }
                true,
        );
        for (int i = 0; i < numDocs; ++i) {  
    public void testLongTermQueryWithDecimalPart() {
import org.apache.lucene.search.IndexSearcher;  
        );  
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),  
        for (int iter = 0; iter < iters; ++iter) {
            NumberType.HALF_FLOAT.rangeQuery("field", null, +0f, true, false, false, true, MOCK_QSC)  
    }  
    public void testBitmapQuery() throws IOException {  
        type = RandomPicks.randomFrom(random(), NumberFieldMapper.NumberType.values());
        assertEquals(new BitmapDocValuesQuery("field", r), ft.bitmapQuery(bitmap));
        for (int i = 0; i < numQueries; ++i) {
        final String message;
            ft.rangeQuery(1, 10, true, true, null, null, null, MOCK_QSC),
        assertFalse(NumberType.FLOAT.termQuery("field", -0f, true, true).equals(NumberType.FLOAT.termQuery("field", +0f, true, true)));
            float rounded = HalfFloatPoint.sortableShortToHalfFloat(HalfFloatPoint.halfFloatToSortableShort(value));
        try (DirectoryReader reader = DirectoryReader.open(w)) {  
    public void testLongRangeQueryWithDecimalParts() {  
            ft.rangeQuery(1, 10.1, true, true, null, null, null, MOCK_QSC)
import org.apache.lucene.document.SortedNumericDocValuesField;
            if (query instanceof IndexOrDocValuesQuery) {
import java.util.List;
            ftInt.rangeQuery(0, 0, true, true, null, null, null, MOCK_QSC),  
        w.close();
                fallbackQuery = ((IndexSortSortedNumericDocValuesRangeQuery) query).getFallbackQuery();
        assertEquals(  
                );
        assertEquals(  
        assertEquals(
        assertEquals(
            OutOfRangeSpec.of(NumberType.SHORT, "32768", "out of range for a short"),  
        );
import org.opensearch.search.query.Bitmap64IndexQuery;
        assertEquals(  
        // searching floats that are rounded to the closest half float
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
            new ApproximatePointRangeQuery(
        );
        dir.close();
            Query query = type.rangeQuery(
    private static MappedFieldType unsearchable() {
        final int iters = 10;  
 * Unless required by applicable law or agreed to in writing,
        Query expected = new ApproximateScoreQuery(
        assertEquals(
            IntPoint.encodeDimension(value, bytes, 0);
            ft.rangeQuery(2, 10, true, true, null, null, null, MOCK_QSC),
    }
            ftInt.rangeQuery(0, 2, true, true, null, null, null, MOCK_QSC),
        Directory dir = newDirectory();
    }  
import org.opensearch.Version;
                fail("Parsing exception expected for [" + item.type + "] with value [" + item.value + "]");
        IndexWriterConfig writerConfig = new IndexWriterConfig();
            float l = (randomFloat() * 2 - 1) * 65504;
        );  
        );
        assertEquals("Value [1.0E20] is out of range for an unsigned long", e.getMessage());  
        final int numQueries = 1000;  
        final DirectoryReader reader = DirectoryReader.open(w);
        assertEquals(  
    }  
            doc.add(new DoublePoint("double", value.doubleValue()));
    }
    }  
            LongPoint.encodeDimension(value, bytes, 0);
        BytesArray bitmap = new BytesArray(array);  
        NumberType type = randomValueOtherThan(NumberType.INTEGER, () -> randomFrom(NumberType.values()));
        NumberFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.SHORT);
        assertEquals(expected, ft.termsQuery(List.of("1", "3"), MOCK_QSC));
        doTestDocValueRangeQueries(NumberType.HALF_FLOAT, random()::nextFloat);  
    public void testParsePoint() {  
            OutOfRangeSpec.of(NumberType.LONG, "9223372036854775808", "out of range for a long"),
import org.opensearch.core.xcontent.MediaTypeRegistry;
        {
                true,
        }  
                1,
            () -> unsearchable.termsQuery(List.of("1", "3"), MOCK_QSC)  
        final NumberType type;
            );  
        Query query = new IndexOrDocValuesQuery(LongPoint.newExactQuery("field", 42), dvQuery);
    public void testConversions() {
            OutOfRangeSpec.of(NumberType.HALF_FLOAT, -65520f, "[half_float] supports only finite values"),
