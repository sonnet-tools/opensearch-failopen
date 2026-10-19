                    IndexSearcher searcher = new IndexSearcher(reader);
                iw.flush();
            @Override
        );
                if (random().nextBoolean()) {
                            (approxFieldDoc.fields[0])  
                    long upper = RandomNumbers.randomLongBetween(random(), highValue, highValue + 1000000L);
                int dims = 1;
        );
                    assertEquals(topDocs.totalHits, new TotalHits(1000, TotalHits.Relation.EQUAL_TO));  
        int size,
                    TopDocs exactDocs = searcher.searchAfter(searchAfterDoc, exactQuery, size, sort);
            }
            "Should return exactly size value documents as regular query",
                    iw.forceMerge(1);  
                iw.forceMerge(1);  
                try (IndexReader reader = iw.getReader()) {
    }  
                        numericType.encode(lower),  
                }
        assertTrue(query.canApproximate(mockContext));
                    int compareSize = Math.min(size, Math.min(topDocs.scoreDocs.length, topDocs1.scoreDocs.length));
                    BigInteger.valueOf(lower.longValue()),  
            @Override
            numericType.encode(upper),
    enum NumericType {
                int numPoints = RandomNumbers.randomIntBetween(random(), 3000, 10000);
                for (int i = 0; i < 100; i++) {
                return LongPoint.newRangeQuery(fieldName, lower.longValue(), upper.longValue());  
            upperBytes = LongPoint.pack((long) upper).bytes;
        );
        long lower = RandomNumbers.randomLongBetween(random(), 0, 100);
        },
                        iw.flush();
                    long upper = RandomNumbers.randomLongBetween(random(), lower, lower + 150);
            }
                    iw.forceMerge(1);
                    long expectedHits = upper - lower + 1;
            approxDocsAsc.scoreDocs.length  
                numericType.addField(doc, numericType.fieldName, highValue);
        assertEquals("Should return exactly size value documents", size, approxDocsAsc.scoreDocs.length);  
        TopDocs approxDocsAsc = searcher.search(approxQueryAsc, size, ascSort);  
        when(mockContext.from()).thenReturn(from);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {  
import org.opensearch.search.internal.ShardSearchRequest;
                    Query approximateQuery = new ApproximatePointRangeQuery(  
        }
                }  
                        dims,
                        size,
                    numericType.addField(doc, numericType.fieldName, i);  
        byte[] lowerBytes = numericType.encode(lower);
                    TopDocs topDocs = searcher.search(approximateQuery, size);
                        numericType.addField(doc, numericType.fieldName, randomValue);  
                }
                    // Test sparse region  
                    testApproximateVsExactQuery(searcher, fieldName, 100, 199, 50, dims);
                    // Test 1: Query for typical fare range  
                    numericType.addField(doc, numericType.fieldName, i);
                "DESC sorted results should match at position " + i,  
            source.sort(new FieldSortBuilder(numericType.fieldName).order(SortOrder.ASC));  
                    long upper = RandomNumbers.randomLongBetween(random(), lower + size * 2, numPoints - 1);  
                    iw.addDocument(doc);
            1,  
                return IntPoint.pack(new int[] { value.intValue() }).bytes;  
        Function<byte[], String> format = numericType.format;
        );
                    TopDocs exactAllDocs = searcher.search(exactQuery, numPoints);
            }
                    }
    public void testNycTaxiDataDistribution() throws IOException {  
                String fieldName = numericType.fieldName;  
                    ShardSearchRequest mockRequest = mock(ShardSearchRequest.class);  
        UNSIGNED_LONG("unsigned_long_field", ApproximatePointRangeQuery.UNSIGNED_LONG_FORMAT) {
                    when(mockContext.from()).thenReturn(0);  
            @Override  
                    final int size = RandomNumbers.randomIntBetween(random(), 20, 100);
                    // Query that will partially overlap with tree nodes (CELL_CROSSES_QUERY)  
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                return NumberFieldMapper.NumberType.DOUBLE;
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
        TopDocs exactDocs,
                    iw.forceMerge(1);  
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
                    Query exactQuery = numericType.rangeQuery(numericType.fieldName, lower, upper);
    }  
                        numericType.format
            numericType.encode(upper),  
                    );
                int numPoints = RandomNumbers.randomIntBetween(random(), 1000, 3000);
                        size,
    // Test to cover intersectRight with CELL_CROSSES_QUERY case
import org.apache.lucene.search.IndexSearcher;  
                }  
                doc.add(new LongPoint(fieldName, value.longValue()));
                        numericType.encode(lower),
                            "Sort value at position " + i + " should match",
            // tests
                }
                    Document doc = new Document();
                    numericType.addField(doc, numericType.fieldName, i);
                }
                        numericType.fieldName,
        HALF_FLOAT("half_float_field", ApproximatePointRangeQuery.HALF_FLOAT_FORMAT) {
                    for (int i = 0; i < Math.min(approxDocs.scoreDocs.length, exactDocs.scoreDocs.length); i++) {
                Document doc = new Document();  
        assertFalse(query.canApproximate(mockContext));
                try (IndexReader reader = iw.getReader()) {
                    );
                return DoublePoint.newRangeQuery(fieldName, lower.doubleValue(), upper.doubleValue());
            }  
            @Override
                    long upper = 1000;
                int dims = 1;  
                int numPoints = 1000;
        );
                    numericType.addDocValuesField(doc, fieldName, fare);
import org.apache.lucene.search.Sort;  
                    TopDocs topDocs = searcher.search(query, size, sort);  
                iw.flush();
                return SortField.Type.LONG;
            numericType.encode(upper),
        return Arrays.asList(  
            numericType.fieldName,
                int numPoints = RandomNumbers.randomIntBetween(random(), 2000, 5000);
                    Document doc = new Document();
                int numPoints = RandomNumbers.randomIntBetween(random(), 1000, 3000);  
                    }
                    Document doc = new Document();  
                doc.add(new BigIntegerPoint(fieldName, BigInteger.valueOf(value.longValue())));  
                    long upper = RandomNumbers.randomLongBetween(random(), lower + 100, numPoints - 1);
                int dataEnd = dataStart + RandomNumbers.randomIntBetween(random(), 1000, 2000);
                    assertEquals("Should return exactly all documents", numDocs, topDocs.scoreDocs.length);  
                        numericType.fieldName,
        ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
            @Override
        try (Directory directory = newDirectory()) {
                    testApproximateVsExactQuery(searcher, fieldName, 10000, 20000, 50, dims);  
            descSort = new Sort(new SortField(field, SortField.Type.LONG, true));  
            }
                    iw.addDocument(doc);
        }
                        numericType.format
            assertEquals("ASC sorted results should match at position " + i, exactDocsAsc.scoreDocs[i].doc, approxDocsAsc.scoreDocs[i].doc);
                return SortField.Type.FLOAT;
                int dims = 1;
                    );  
                        dims,
            exactDocsAsc.scoreDocs.length,
                    numericType.addDocValuesField(doc, fieldName, value);
                            );
            numericType.fieldName,  
        }
                iw.flush();  
            numericType.fieldName,  
            }
                return SortField.Type.DOUBLE;  
                    );
                    when(mockContext.request()).thenReturn(mockRequest);
        throws IOException {
            }  
                for (int i = 0; i < numPoints; i++) {
                    numericType.addField(doc, numericType.fieldName, i);
                doc.add(new NumericDocValuesField(fieldName + "_sort", value.longValue()));
            @Override
                try (IndexReader reader = iw.getReader()) {
    }
                        size,  
                }  
                    iw.addDocument(doc);  
                        null,
        Query exactQuery,
        when(mockContext.request()).thenReturn(null);  
            @Override  
                        null,  
                    // Create a query range that fully encompasses the data  
import java.io.IOException;
                    Query exactQuery = numericType.rangeQuery(numericType.fieldName, lower, upper);
        ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(  
                        assertEquals("Doc at position " + i + " should match", exactFieldDoc.doc, approxFieldDoc.doc);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                    long timestamp = startTimestamp + (i * minute);  
                    IndexSearcher searcher = new IndexSearcher(reader);
            byte[] encode(Number value) {  
                    for (ScoreDoc scoreDoc : approxDocs.scoreDocs) {
        try (Directory directory = newDirectory()) {
                    numericType.addField(doc, fieldName, i);
                        numericType.encode(lower),
                    final int size = RandomNumbers.randomIntBetween(random(), 30, 100);
                        dims,
        assertNull(query.getSortOrder());
            when(mockContext.from()).thenReturn(0);
                        dims,
                                "Doc value " + value + " should be > searchAfterValue " + searchAfterLong,
                    TopDocs searchAfterDocs = searcher.search(exactValueQuery, 1, sort);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                        dims,  
                    assertEquals(size, topDocs.scoreDocs.length);  
            @Override
                    int compareSize = Math.min(size, Math.min(topDocs.scoreDocs.length, topDocs1.scoreDocs.length));
        ApproximatePointRangeQuery queryCanApproximate = new ApproximatePointRangeQuery(
                    }
    public void testApproximateRangeEqualsActualRange() throws IOException {
        TopDocs approxDocs,  
                }  
                iw.flush();
                int range2End = range2Start + RandomNumbers.randomIntBetween(random(), 50, 150);  
                    Query exactQuery = numericType.rangeQuery(numericType.fieldName, lower, upper);
    }
                int dims = 1;
                try (IndexReader reader = iw.getReader()) {
            void addField(Document doc, String fieldName, Number value) {  
                    when(mockContext.trackTotalHitsUpTo()).thenReturn(10000);
        assertFalse(query.canApproximate(null));  
            @Override  
                );
            format
            }
                for (int i = 0; i < numSameValueDocs; i++) {
        abstract void addField(Document doc, String fieldName, Number value);
            }
                    long lower = RandomNumbers.randomLongBetween(random(), 0, numPoints / 2);
    // Test to cover CELL_OUTSIDE_QUERY break case for intersectRight  
                        assertEquals("Mismatch at doc index " + i, topDocs.scoreDocs[i].doc, topDocs1.scoreDocs[i].doc);  
                    iw.addDocument(doc);
            SortOrder.ASC,  
                }  
                return FloatPoint.pack(new float[] { value.floatValue() }).bytes;  
                    TopDocs topDocs = searcher.search(approximateQuery, size, sort);
                    TopDocs topDocs = searcher.search(query, size, sort);
                    ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
                    }
    }
        try (Directory directory = newDirectory()) {
                for (int i = 0; i < numPoints; i++) {
                    iw.addDocument(doc);
                        assertEquals(topDocs.totalHits.value(), size);  
                long sameValue = RandomNumbers.randomLongBetween(random(), 500, 2000);
            }
                    numericType.addField(doc, fieldName, i);
            @Override  
            NumberFieldMapper.NumberType getNumberType() {  
                    assertEquals("Should find no documents in the gap range", 0, topDocs.totalHits.value());
            }
            field,
            }  
            }
                return SortField.Type.LONG;
    public void testApproximateRangeShortCircuitAscSort() throws IOException {  
                final int size = RandomNumbers.randomIntBetween(random(), 5, 20);  
                    TopDocs topDocs = searcher.search(query, size, sort);  
                }  
                iw.forceMerge(1);
        when(mockContext.size()).thenReturn(size);
                        iw.flush();
            format = ApproximatePointRangeQuery.LONG_FORMAT;  
                            assertTrue(
            void addField(Document doc, String fieldName, Number value) {
    // Test to cover the left child traversal in intersectRight with CELL_INSIDE_QUERY  
    private void verifyRangeQueries(  
            SearchSourceBuilder source = new SearchSourceBuilder();
                    long lower = RandomNumbers.randomLongBetween(random(), numPoints / 4, numPoints / 2);
                        exactDocs.scoreDocs.length,
                    IndexSearcher searcher = new IndexSearcher(reader);
            }  
        ApproximatePointRangeQuery approxQueryAsc = new ApproximatePointRangeQuery(  
            lowerBytes,
                try (IndexReader reader = iw.getReader()) {
        compareSize = Math.min(size, Math.min(approxDocsDesc.scoreDocs.length, exactDocsDesc.scoreDocs.length));  
                long highValue = RandomNumbers.randomLongBetween(random(), 900000000L, 999999999L);
                }
                    ApproximatePointRangeQuery approxQuery = new ApproximatePointRangeQuery(  
        }
                    final int size = RandomNumbers.randomIntBetween(random(), 5, 20);
                    final int size = RandomNumbers.randomIntBetween(random(), 20, 100);
        int expectedSize = Math.max(from + size, trackTotalHitsUpTo) + 1;
                byte[] bytes = new byte[BigIntegerPoint.BYTES];
            @Override  
                    if (random().nextInt(20) == 0) {
                if (random().nextBoolean()) {
                return NumberFieldMapper.NumberType.UNSIGNED_LONG;
        TopDocs exactDocsDesc = searcher.search(exactQuery, size, descSort);
        }
            numericType.encode(lower),  
                return DoublePoint.pack(new double[] { value.doubleValue() }).bytes;
import org.apache.lucene.search.SortField;
                    if (random().nextInt(20) == 0) {
                // Low fares: 250-500 (sparse)  
                        size,
        assertEquals(  
        ApproximatePointRangeQuery approxQueryDesc = new ApproximatePointRangeQuery(  
        assertEquals(
                    }
                    numericType.addDocValuesField(doc, numericType.fieldName, i);  
    public void testIntersectRightCellInsideQueryLeaf() throws IOException {  
                    Document doc = new Document();
                    Query exactQuery = numericType.rangeQuery(numericType.fieldName, lower, upper);  
                    Document doc = new Document();  
            }
                iw.flush();
                        numericType.format
        long upper = RandomNumbers.randomLongBetween(random(), lower + 10, lower + 1000);
                    int totalDocs = numSameValueDocs + 1;  
            when(mockContext.request()).thenReturn(mockRequest);  
                doc.add(new NumericDocValuesField(fieldName + "_sort", value.longValue()));
            }
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
                    assertTrue("Should collect at least min(size, hits) documents", topDocs.totalHits.value() >= expectedReturnSize);
            }
        );
                    long lower = 0;
                        numericType.format
            lowerBytes = LongPoint.pack((long) lower).bytes;
        },  
                    long searchAfterValue = RandomNumbers.randomLongBetween(random(), lower, upper - size);  
            NumberFieldMapper.NumberType getNumberType() {  
            SearchContext mockContext = mock(SearchContext.class);
                    TopDocs topDocs1 = searcher.search(exactQuery, size);
    public void testApproximateRangeWithSizeOverDefault() throws IOException {  
            @Override
                try (IndexReader reader = iw.getReader()) {  
                        (int) Math.min(size, (upper - lower + 1)),  
                }
                if (random().nextBoolean()) {
                    TopDocs topDocs = searcher.search(query, size, sort);  
        for (int i = 0; i < compareSize; i++) {
                try (IndexReader reader = iw.getReader()) {
                    QueryShardContext queryShardContext = mock(QueryShardContext.class);
            numericType.encode(lower),  
        Sort ascSort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType()));  
                        numericType.getNumberType()  
                        numericType.format
                                value.longValue() > searchAfterLong  
                    long lower = RandomNumbers.randomLongBetween(random(), 0, numPoints / 2);
                    Query approximateQuery = new ApproximatePointRangeQuery(
                if (random().nextBoolean()) {
                for (int i = 0; i < numPoints; i++) {
                    long upper = range2Start - RandomNumbers.randomIntBetween(random(), 10, gapSize / 2);
                        "Should return exactly min(size, hits) documents",
            numericType.encode(upper),
                    if (random().nextInt(20) == 0) {
                    iw.forceMerge(1);
            }
    }  
            ShardSearchRequest mockRequest = mock(ShardSearchRequest.class);  
            @Override
                    Query approximateQuery = new ApproximatePointRangeQuery(
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                    numericType.addField(doc, numericType.fieldName, i);
                return bytes;  
                    final int size = RandomNumbers.randomIntBetween(random(), numDocs + 50, numDocs + 200);
                        numericType.fieldName,
                        size,
                            );  
            upperBytes,  
        TopDocs exactDocs = searcher.search(exactQuery, size);
                    testApproximateVsExactQueryWithDateField(searcher, dateFieldType, "now-1h", "now", 50, dims);  
                    long lower = RandomNumbers.randomLongBetween(random(), 0, 50);
            }
                        long randomValue = RandomNumbers.randomLongBetween(random(), 0, 200);
                    iw.addDocument(doc);
            }  
            }
                    Query exactValueQuery = numericType.rangeQuery(numericType.fieldName, searchAfterValue, searchAfterValue);
                    boolean reverseSort = sortOrder == SortOrder.DESC;  
                        SortOrder.DESC,  
                for (int i = 0; i < 10000; i++) {
                return SortField.Type.LONG;
import org.apache.lucene.search.Query;
            this.fieldName = fieldName;
        },  
 */  
            numericType.encode(upper),
                        iw.flush();  
            dims,
                    // Test across regions
    public void testApproximateWithSort() {
                numericType.addDocValuesField(doc, numericType.fieldName, highValue);
                doc.add(new NumericDocValuesField(fieldName, Double.doubleToLongBits(value.doubleValue())));
    }  
            numericType.fieldName,
                }
                return SortField.Type.INT;
                    when(queryShardContext.fieldMapper(numericType.fieldName)).thenReturn(fieldType);  
import java.util.Collection;
        // Test with approximate query  
        query.setSortOrder(sortOrder);
        query.setSize(newSize);  
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
        testApproximateVsExactQuery(searcher, dateFieldType.name(), lowerMillis, upperMillis, size, dims);
            SortField.Type getSortFieldType() {  
                    // Test 3: Query for low fares
            when(mockContext.trackTotalHitsUpTo()).thenReturn(10000);  
        }
            when(mockRequest.source()).thenReturn(source);
                    when(mockContext.aggregations()).thenReturn(null);
                    iw.forceMerge(1);  
            ShardSearchRequest mockRequest = mock(ShardSearchRequest.class);
                }  
                HalfFloatPoint.encodeDimension(value.floatValue(), bytes, 0);
        }  
            assertEquals(
                    long upper = RandomNumbers.randomLongBetween(random(), lower + size * 2, Math.min(lower + 200, numPoints - 1));
                }  
    // Test to specifically cover the single child case in intersectRight
        // Verify results match
            1,
import java.time.Instant;  
                long currentTime = System.currentTimeMillis();
                }
                        numericType.encode(lower),
            Query rangeQuery(String fieldName, Number lower, Number upper) {
                    }
                    long upper = RandomNumbers.randomLongBetween(random(), 3 * numPoints / 4, numPoints - 1);
 * SPDX-License-Identifier: Apache-2.0
                int dims = 1;
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), reverseSort));
            }
        try (Directory directory = newDirectory()) {
        int dims  
                int dataStart = RandomNumbers.randomIntBetween(random(), 5000, 15000);
    }  
                    TopDocs topDocs1 = searcher.search(exactQuery, size, sort);  
            this.format = format;
                    long upper = RandomNumbers.randomLongBetween(random(), lower + 10, numPoints - 1);  
                    }  
            size,
                doc.add(new NumericDocValuesField(fieldName, value.intValue()));
                }
                    if (random().nextInt(20) == 0) {  
                    if (i % 15 == 0) iw.flush();  
                        long searchAfterLong = ((Number) searchAfterDoc.fields[0]).longValue();
        ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
                for (int i = 0; i < numPoints; i++) {  
            @Override  
            byte[] encode(Number value) {  
                int gapSize = RandomNumbers.randomIntBetween(random(), 200, 400);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
            @Override
                        numericType.encode(lower),
        long lower = RandomNumbers.randomLongBetween(random(), 0, 100);  
                    int searchSize = RandomNumbers.randomIntBetween(random(), 10, 50);
                    SearchContext mockContext = mock(SearchContext.class);
            numericType.encode(lower),
                    long lower = RandomNumbers.randomLongBetween(random(), numericType.getMinTestValue(), 200);  
                int dims = 1;  
            }
            lowerBytes,
                    iw.forceMerge(1);  
        // Verify approximate query returns correct number of results  
        try (Directory directory = newDirectory()) {
                    if (random().nextInt(100) == 0) {  
                iw.flush();
            @Override
                    );
            }  
            public boolean canApproximate(SearchContext context) {
                    }
                    numericType.addDocValuesField(doc, numericType.fieldName, i);  
public class ApproximatePointRangeQueryTests extends OpenSearchTestCase {
            upperBytes,  
                    );
        Query exactQuery = numericType.rangeQuery(field, lower, upper);
            @Override
                        SortOrder.DESC,
            }
                }
    }
            }
                        numericType.encode(upper),
                    for (int i = 0; i < compareSize; i++) {
    public void testHttpLogTimestampDistribution() throws IOException {
    public void testIntersectRightSingleChildNode() throws IOException {
                    );
        }  
        long upper = RandomNumbers.randomLongBetween(random(), lower + 10, lower + 1000);
                    ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(  
                return BigIntegerPoint.newRangeQuery(
            // Skip - HALF_FLOAT uses different fields for storage vs sorting which causes issues with search_after boundary checking during
        }  
            @Override
                    }
            @Override
                iw.forceMerge(1);  
                    IndexSearcher searcher = new IndexSearcher(reader);  
                        SortOrder.DESC,
            }
                    numericType.addField(doc, numericType.fieldName, i);
                for (int i = 0; i < numPoints; i++) {  
                        numericType.encode(lower),
                    final int size = RandomNumbers.randomIntBetween(random(), 50, 200);  
                    iw.forceMerge(1);
                return fieldName + "_sort";  
    public void testApproximateRangeShortCircuitDescSort() throws IOException {
                    Document doc = new Document();  
                    testApproximateVsExactQuery(searcher, fieldName, 1000, 1500, 100, dims);  
 *
                    if (random().nextInt(20) == 0) {
        };
                    Query exactQuery = numericType.rangeQuery(numericType.fieldName, lower, upper);  
                doc.add(new HalfFloatPoint(fieldName, value.floatValue()));
                    }
                int numDocs = dataEnd - dataStart + 1;  
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {  
                    // Test approximate query with searchAfter
        {
                for (int i = 0; i < 5000; i++) {  
                    );
                    iw.addDocument(doc);  
                        iw.flush();
            }
                for (int i = 0; i < numPoints; i++) {
                    // This ensures CELL_INSIDE_QUERY condition
                    );  
                        topDocs.scoreDocs.length
            void addDocValuesField(Document doc, String fieldName, Number value) {  
                    IndexSearcher searcher = new IndexSearcher(reader);  
                }  
            exactQuery = LongPoint.newRangeQuery(field, (long) lower, (long) upper);
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
                    // To test upper half of the data to test the DESC
                int dims = 1;
                doc.add(new FloatPoint(fieldName, value.floatValue()));
        assertEquals("Should return same number of documents", exactDocsAsc.scoreDocs.length, approxDocsAsc.scoreDocs.length);
import org.apache.lucene.sandbox.document.HalfFloatPoint;
                    numericType.addField(doc, numericType.fieldName, i);
        }
            dims,
                    when(mockContext.getQueryShardContext()).thenReturn(queryShardContext);
        abstract Query rangeQuery(String fieldName, Number lower, Number upper);
            1,
            NumberFieldMapper.NumberType getNumberType() {
        }
            when(mockContext.size()).thenReturn(10);
                    IndexSearcher searcher = new IndexSearcher(reader);
                iw.addDocument(doc);  
                    numericType.addField(doc, numericType.fieldName, i);  
            numericType.encode(lower),
                    // First, get a document at searchAfterValue to use as the searchAfter point
            NumberFieldMapper.NumberType getNumberType() {
                    numericType.addField(doc, numericType.fieldName, sameValue);
                    assertEquals("Should return min(size, totalDocs) documents", expectedReturnSize, topDocs.scoreDocs.length);
                try (IndexReader reader = iw.getReader()) {
                    } else {
            @Override
            }
                        numericType.format
        }
        try (Directory directory = newDirectory()) {
    private final NumericType numericType;
                    final int size = RandomNumbers.randomIntBetween(random(), 11000, 13000);  
        }  
                    long lower = RandomNumbers.randomLongBetween(random(), numPoints / 2, numPoints - 200);  
            return this == UNSIGNED_LONG ? 0 : -100;
        assertEquals("Should return same number of documents", exactDocsDesc.scoreDocs.length, approxDocsDesc.scoreDocs.length);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {  
                        sortOrder,  
                        numericType.encode(upper),
                }
import org.opensearch.search.sort.FieldSortBuilder;  
            }
            @Override
                    for (int j = 0; j < numValues; j++) {
import java.util.Arrays;
        TopDocs exactDocsAsc = searcher.search(exactQuery, size, ascSort);
            numericType.format  
                if (random().nextBoolean()) {
                    long lower = RandomNumbers.randomLongBetween(random(), 0, sameValue - 100);  
    }  
                        if (sortOrder == SortOrder.ASC) {  
                    IndexSearcher searcher = new IndexSearcher(reader);
        this.numericType = numericType;
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                    assertEquals(size, topDocs1.scoreDocs.length);
                    testApproximateVsExactQuery(searcher, fieldName, 0, 2000, 200, dims);
                        numericType.encode(upper),  
        }  
                    assertTrue("Approximate query should find at least 'size' documents", topDocs.totalHits.value() >= size);  
import org.opensearch.common.time.DateFormatter;
                    IndexSearcher searcher = new IndexSearcher(reader);
                int dims = 1;  
                    if (topDocs.totalHits.relation() == Relation.EQUAL_TO) {
                iw.flush();
                        numericType.fieldName,
                        }
                        numericType.fieldName,
                        iw.flush();  
        assertEquals(query.getSize(), newSize);
                    assertEquals(actualHitsInRange, topDocs1.totalHits.value());
import org.apache.lucene.search.TotalHits;  
            1,
                    Document doc = new Document();
                int numPoints = RandomNumbers.randomIntBetween(random(), 1000, 3000);
                    doc.add(new LongPoint(dateFieldType.name(), convertedTimestamp));
                    ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(  
                    when(mockRequest.source()).thenReturn(source);  
                    }
                    IndexSearcher searcher = new IndexSearcher(reader);
                }
        byte[] upperBytes = numericType.encode(upper);
            }
                // Typical fares: 1000-3000 (dense, 5 docs per value)
        long upper = RandomNumbers.randomLongBetween(random(), lower + 10, lower + 1000);
                // Sparse range: 100-199 (100 docs, one per value)
        FLOAT("float_field", ApproximatePointRangeQuery.FLOAT_FORMAT) {  
                    );
                    IndexSearcher searcher = new IndexSearcher(reader);  
                    assertEquals("Should find all documents", numDocs, topDocs.totalHits.value());
package org.opensearch.search.approximate;
                    Document doc = new Document();
            Query rangeQuery(String fieldName, Number lower, Number upper) {
import org.opensearch.index.mapper.NumberFieldMapper;
        final String fieldName;  
        long nowInMillis = System.currentTimeMillis();  
        String getSortFieldName() {
        when(mockContext.trackTotalHitsUpTo()).thenReturn(SearchContext.TRACK_TOTAL_HITS_ACCURATE);  
                    long lower = RandomNumbers.randomLongBetween(random(), numPoints - 100, numPoints - 20);
                    ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
        DateFieldType dateFieldType,
                int range1End = range1Start + RandomNumbers.randomIntBetween(random(), 1000, 15000);  
    public void testCannotApproximateWithTrackTotalHits() {
import org.apache.lucene.document.IntPoint;
            }
                }
                    source.searchAfter(searchAfterDoc.fields);  
    public void testApproximateVsExactQueryWithDateField(
                approxDocsDesc.scoreDocs[i].doc
            );  
                iw.flush();  
                doc.add(new DoublePoint(fieldName, value.doubleValue()));  
                        FieldDoc approxFieldDoc = (FieldDoc) approxDocs.scoreDocs[i];  
        DateMathParser parser = formatter.toDateMathParser();
        abstract byte[] encode(Number value);
import org.apache.lucene.sandbox.document.BigIntegerPoint;  
                    int size = RandomNumbers.randomIntBetween(random(), 10, 50);
            }  
        int from = RandomNumbers.randomIntBetween(random(), 0, 100);
        long upper = RandomNumbers.randomLongBetween(random(), lower + 10, lower + 1000);  
            }  
                        numericType.fieldName,  
        if (field.equals("@timestamp")) {
                        numericType.fieldName,
    public void testIntersectRightLeftChildTraversal() throws IOException {
    ) throws IOException {
                        size,
                    int expectedReturnSize = (int) Math.min(size, expectedHits);
                    Document doc = new Document();  
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                if (random().nextBoolean()) {
                        dims,
                    iw.forceMerge(1);
    private void testApproximateRangeWithSearchAfter(SortOrder sortOrder) throws IOException {
            void addDocValuesField(Document doc, String fieldName, Number value) {
                }
            Query rangeQuery(String fieldName, Number lower, Number upper) {  
            }  
                    iw.addDocument(doc);
                        approxDocs.scoreDocs.length  
            when(mockContext.request()).thenReturn(mockRequest);  
                    assertEquals(  
            SortField.Type getSortFieldType() {
        );
        long lower = RandomNumbers.randomLongBetween(random(), 0, 100);
                    long upper = RandomNumbers.randomLongBetween(random(), lower + size, Math.min(lower + size + 2000, numPoints - 1));
                    IndexSearcher searcher = new IndexSearcher(reader);
        LONG("long_field", ApproximatePointRangeQuery.LONG_FORMAT) {
                            (exactFieldDoc.fields[0]),
                if (random().nextBoolean()) {  
                    );
    public void testIntersectRightCellOutsideQuery() throws IOException {
                    );  
import org.apache.lucene.store.Directory;
                int dims = 1;
                }  
                if (random().nextBoolean()) {
    // Following test replicates the nyx_taxis dataset
                        null,  
                        dims,
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {  
            assertTrue("Should approximate with single sort on same field", query.canApproximate(mockContext));
                int numPoints = RandomNumbers.randomIntBetween(random(), 1000, 3000);
                int numDocs = RandomNumbers.randomIntBetween(random(), 1500, 3000);  
                    IndexSearcher searcher = new IndexSearcher(reader);
            String getSortFieldName() {
                    );  
                    // Verify results match
        );
                return NumberFieldMapper.NumberType.INTEGER;
            }
                return bytes;
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
        assertTrue("Approximate query should return at most " + size + " docs", approxDocs.scoreDocs.length <= size);
        try (Directory directory = newDirectory()) {
                        numericType.fieldName,
    public void testIntersectRightCellCrossesQuery() throws IOException {
        ;  
            byte[] encode(Number value) {
        }  
                        iw.flush();  
                int range2Start = range1End + gapSize;
                DateFieldType dateFieldType = new DateFieldType("@timestamp");
        try (Directory directory = newDirectory()) {  
        when(mockContext.aggregations()).thenReturn(null);
        long lowerMillis = dateFieldType.resolution().convert(parser.parse(lowerBound, () -> nowInMillis));  
                    SearchSourceBuilder source = new SearchSourceBuilder();
                for (int i = 0; i < numPoints; i++) {  
        SearchContext mockContext = mock(org.opensearch.search.internal.SearchContext.class);
                    }
            void addField(Document doc, String fieldName, Number value) {
    }
            byte[] encode(Number value) {
        },  
            @Override  
                doc.add(new IntPoint(fieldName, value.intValue()));
                        numericType.encode(upper),  
/*  
        int size = RandomNumbers.randomIntBetween(random(), 10, 100);  
            return;  
                        topDocs1.scoreDocs.length,
                    iw.addDocument(doc);
                    Document doc = new Document();  
        DOUBLE("double_field", ApproximatePointRangeQuery.DOUBLE_FORMAT) {
                if (random().nextBoolean()) {
                        numericType.encode(upper),
            SearchSourceBuilder source = new SearchSourceBuilder();
            @Override
                { NumericType.FLOAT },
        // Test ASC sort
                    source.sort(new FieldSortBuilder(numericType.fieldName).order(sortOrder));
                try (IndexReader reader = iw.getReader()) {
        DateFormatter formatter = dateFieldType.dateTimeFormatter();
                        numericType.fieldName,
                        numericType.fieldName,  
            NumberFieldMapper.NumberType getNumberType() {  
            new Object[][] {
    public void testApproximateRangeWithSearchAfterAsc() throws IOException {  
                int dims = 1;  
                    BigInteger.valueOf(upper.longValue())
    }
import org.opensearch.search.builder.SearchSourceBuilder;  
                    Query approximateQuery = new ApproximatePointRangeQuery(  
    }
    }
        abstract NumberFieldMapper.NumberType getNumberType();  
                    iw.addDocument(doc);  
    }  
                    numericType.addDocValuesField(doc, numericType.fieldName, i);  
                }
                    numericType.addField(doc, numericType.fieldName, i);
import static org.mockito.Mockito.mock;
import org.opensearch.test.OpenSearchTestCase;
    public void testSize() {  
                int dims = 1;
    }
                        "Approximate and exact queries should return same number of docs",
                    }
            SortField.Type getSortFieldType() {  
                    fieldName,
            Query rangeQuery(String fieldName, Number lower, Number upper) {
        ApproximatePointRangeQuery approxQuery = new ApproximatePointRangeQuery(field, upperBytes, lowerBytes, dims, size, null, format);
        long upper = RandomNumbers.randomLongBetween(random(), lower + 10, lower + 1000);  
            }
                        iw.flush();  
            1,
        SearchContext searchContext = mock(SearchContext.class);  
            numericType.encode(upper),
                { NumericType.UNSIGNED_LONG } }
    public void testCanApproximate() {
                        numericType.format  
                    iw.forceMerge(1);
            numericType.format  
                    Document doc = new Document();  
        // Test 2: Single sort on the same field should allow approximation
                    iw.addDocument(doc);
            }
                    );
        }
                int range1Start = RandomNumbers.randomIntBetween(random(), 0, 1000);
        abstract SortField.Type getSortFieldType();
                return IntPoint.newRangeQuery(fieldName, lower.intValue(), upper.intValue());  
                }
import java.math.BigInteger;
        }
                    if (i % RandomNumbers.randomIntBetween(random(), 50, 200) == 0) {
                    numericType.addField(doc, fieldName, fare);  
        };
            numericType.encode(lower),
                        numericType.encode(upper),  
        String upperBound,  
                iw.flush();  
            }
    }
                                "Doc value " + value + " should be < searchAfterValue " + searchAfterLong,
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                        numericType.fieldName,  
    public void testApproximateRangeWithDefaultSize() throws IOException {  
                int numSameValueDocs = RandomNumbers.randomIntBetween(random(), 1000, 3000);  
import static org.mockito.Mockito.when;  
            @Override
                        numericType.encode(lower),
import org.apache.lucene.search.TopDocs;
                for (long fare = 1000; fare <= 3000; fare++) {
            SortField.Type getSortFieldType() {
            @Override  
                    numericType.addField(doc, numericType.fieldName, i);
                    }  
                        numericType.encode(upper),
            @Override  
                        numericType.encode(lower),  
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;  
        }
        }  
        if (numericType == NumericType.HALF_FLOAT) {  
                }
            @Override  
                        size,
                        numericType.fieldName,
                try (IndexReader reader = iw.getReader()) {  
            when(mockContext.from()).thenReturn(0);
                    testApproximateVsExactQueryWithDateField(searcher, dateFieldType, "now-30m", "now+30m", 50, dims);
    }
 * this file be licensed under the Apache-2.0 license or a
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
                int dims = 1;
                    final int size = RandomNumbers.randomIntBetween(random(), 5, 20);  
                    Document doc = new Document();  
                    for (int i = 0; i < compareSize; i++) {
                        iw.flush();
import java.util.function.Function;  
                for (int i = range1Start; i <= range1End; i++) {
                        numericType.encode(upper),  
                return HalfFloatPoint.newRangeQuery(fieldName, lower.floatValue(), upper.floatValue());
            }  
                        SortOrder.ASC,
                        dims,
                    iw.addDocument(doc);  
                    long upper = dataEnd + RandomNumbers.randomIntBetween(random(), 50, 200);  
                }
        assertEquals(query.getSortOrder(), sortOrder);
    }
                }
            NumberFieldMapper.NumberType getNumberType() {
                    testApproximateVsExactQueryWithDateField(searcher, dateFieldType, "now-1d", "now", 50, dims);
    }  
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                        numericType.addField(doc, fieldName, fare);
                int numPoints = RandomNumbers.randomIntBetween(random(), 15000, 20000);
                        dims,
                    iw.addDocument(doc);
                    testApproximateVsExactQuery(searcher, fieldName, 1000, 3000, 100, dims);
                    long lower = dataStart - RandomNumbers.randomIntBetween(random(), 50, 200);
            @Override
            numericType.format
                    long lower = range1End + RandomNumbers.randomIntBetween(random(), 10, gapSize / 2);  
            @Override
                    numericType.addField(doc, numericType.fieldName, i);  
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));  
                int dims = 1;  
                    TopDocs topDocs1 = searcher.search(exactQuery, searchSize);
                return FloatPoint.newRangeQuery(fieldName, lower.floatValue(), upper.floatValue());  
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.opensearch.search.internal.SearchContext;
                    int expectedReturnSize = Math.min(size, totalDocs);
                    // Verify all returned docs are correctly ordered relative to searchAfterValue  
            when(mockContext.aggregations()).thenReturn(null);
                }
        }
        // Verify the results match
                        numericType.format
                    numericType.addField(doc, numericType.fieldName, i);  
                    TopDocs topDocs = searcher.search(approximateQuery, searchSize);  
            }
        try (Directory directory = newDirectory()) {  
                        dims,
                }  
            void addField(Document doc, String fieldName, Number value) {
                    // Compare with exact query using Lucene's searchAfter
                        );
        try (Directory directory = newDirectory()) {
            }  
            when(mockContext.aggregations()).thenReturn(null);
                    );
                    // Test dense region
import org.apache.lucene.search.ScoreDoc;
        Sort descSort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
                    TopDocs approxDocs = searcher.search(approxQuery, size, sort);
            @Override
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
import org.opensearch.index.query.QueryShardContext;
    public ApproximatePointRangeQueryTests(NumericType numericType) {  
        assertEquals("Should return exactly size value documents", size, approxDocsAsc.scoreDocs.length);
            }
            }
        Number lower,  
                exactDocsDesc.scoreDocs[i].doc,
                for (int i = 0; i < numPoints; i++) {
                    }
                    TopDocs topDocs = searcher.search(query, size, sort);
                }
        long lower = RandomNumbers.randomLongBetween(random(), 0, 100);  
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
                        numericType.fieldName,
        assertEquals(expectedSize, query.getSize());  
        testApproximateRangeWithSearchAfter(SortOrder.ASC);
                    TopDocs topDocs = searcher.search(approximateQuery, size, sort);
        int trackTotalHitsUpTo = RandomNumbers.randomIntBetween(random(), 1000, 20000);
                    IndexSearcher searcher = new IndexSearcher(reader);  
        verifyRangeQueries(searcher, exactQuery, approxDocs, exactDocs, field, lower, upper, size, dims);  
                    numericType.addDocValuesField(doc, numericType.fieldName, sameValue);
            source.terminateAfter(SearchContext.DEFAULT_TERMINATE_AFTER);
        long lower = RandomNumbers.randomLongBetween(random(), 0, 100);
                        dims,
 * compatible open source license.
                        numericType.encode(lower),
                for (int i = 0; i < numPoints; i++) {  
                iw.flush();
                        size,  
        assertTrue(queryCanApproximate.canApproximate(searchContext));
                        numericType.encode(lower),
                }
                        numericType.fieldName,
    ) throws IOException {  
                        numericType.encode(lower),
                    if (random().nextInt(20) == 0) {  
                return LongPoint.pack(new long[] { value.longValue() }).bytes;
            @Override
                    iw.forceMerge(1);  
        try (Directory directory = newDirectory()) {  
            @Override  
                return NumberFieldMapper.NumberType.FLOAT;
                    long upper = RandomNumbers.randomLongBetween(random(), lower + 10, Math.min(lower + 100, numPoints - 1));  
    @ParametersFactory
                { NumericType.DOUBLE },  
            );
        try (Directory directory = newDirectory()) {
                // High fares: 10000-20000 (sparse, 1 doc every 100)
            @Override  
                        SortOrder.DESC,  
import org.apache.lucene.search.TotalHits.Relation;
        if (numericType != NumericType.LONG) {  
                }  
            numericType.encode(lower),  
                    iw.addDocument(doc);
            SortOrder.DESC,  
                }
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
import org.apache.lucene.document.NumericDocValuesField;
                // Create 10000 documents with 1 minute intervals
            return;
                    numericType.addField(doc, fieldName, value);  
                for (long fare = 250; fare <= 500; fare++) {
                }  
            SearchContext mockContext = mock(SearchContext.class);  
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
    // Test to cover pointTree.visitDocIDs(visitor) in CELL_INSIDE_QUERY leaf case for intersectRight
    }
import org.opensearch.common.time.DateMathParser;
                byte[] bytes = new byte[HalfFloatPoint.BYTES];
        assertEquals(query.getSize(), 10_000);
                        numericType.format
                // 0-99 (100 docs)
import org.apache.lucene.tests.index.RandomIndexWriter;  
            source.sort(new FieldSortBuilder("another_field").order(SortOrder.ASC));  
        for (int i = 0; i < compareSize; i++) {
                    Document doc = new Document();
            void addDocValuesField(Document doc, String fieldName, Number value) {  
                return NumberFieldMapper.NumberType.HALF_FLOAT;  
        long getMinTestValue() {  
            void addDocValuesField(Document doc, String fieldName, Number value) {  
                    long value = 1000 + (i / 5); // Creates 5 docs per value from 1000-1999
                for (int i = 100; i < 200; i++) {
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
            Query rangeQuery(String fieldName, Number lower, Number upper) {  
                    iw.addDocument(doc);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
            SortField.Type getSortFieldType() {
                    IndexSearcher searcher = new IndexSearcher(reader);
                // Dense range: 1000-1999 (5000 docs, 5 per value)
                    TopDocs topDocs = searcher.search(approximateQuery, size);
        {
                    Document doc = new Document();  
                    iw.addDocument(doc);
                }  
    public void testApproximateRangeShortCircuit() throws IOException {  
                    assertEquals("Should return min(size, hits) documents", expectedReturnSize, topDocs.scoreDocs.length);  
                        size,
                return fieldName + "_sort";  
            }
        }
        String field,
                // Create NYC taxi fare distribution with different ranges
    }
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {  
                    numericType.addDocValuesField(doc, fieldName, i);
                        numericType.format  
                int dims = 1;
            @Override
        if (field.equals("@timestamp")) {  
            }  
            format
        byte[] lowerBytes = numericType.encode(lower);  
                    Document doc = new Document();
                    TopDocs topDocs = searcher.search(approximateQuery, 10);
        INT("int_field", ApproximatePointRangeQuery.INT_FORMAT) {  
        // Test DESC sort
    }  
                if (random().nextBoolean()) {
        }  
                    Document doc = new Document();
        Number upper,
                        size,  
            }
    }
import org.apache.lucene.document.LongPoint;  
        IndexSearcher searcher,  
                for (int i = dataStart; i <= dataEnd; i++) {
    }  
                }  
            }  
            when(mockRequest.source()).thenReturn(source);
        }  
                        dims,  
            exactDocsAsc.scoreDocs.length,  
                    iw.forceMerge(1);  
            numericType.fieldName,
                long minute = 60 * 1000L;
                        numericType.addDocValuesField(doc, fieldName, fare);  
                                value.longValue() < searchAfterLong
                    Document doc = new Document();
                    NumberFieldMapper.NumberFieldType fieldType = new NumberFieldMapper.NumberFieldType(
                        Number value = (Number) fieldDoc.fields[0];  
                for (int i = 0; i < numDocs; i++) {
                    Document doc = new Document();
        );
    private void testApproximateVsExactQuery(IndexSearcher searcher, String field, Number lower, Number upper, int size, int dims)
            void addDocValuesField(Document doc, String fieldName, Number value) {  
                    doc.add(new NumericDocValuesField(dateFieldType.name(), convertedTimestamp));  
            void addField(Document doc, String fieldName, Number value) {
                return true;  
                int dims = 1;  
        // If exact query returns fewer docs than size, approximate should match
        if (exactDocs.totalHits.value() <= size) {  
}
            source.terminateAfter(SearchContext.DEFAULT_TERMINATE_AFTER);
        byte[] upperBytes = numericType.encode(upper);
                    assertEquals(
                        iw.flush();
    public void testApproximateRangeWithSearchAfterDesc() throws IOException {
        final Function<byte[], String> format;
                    long lower = RandomNumbers.randomLongBetween(random(), 0, 1000);
            when(mockContext.trackTotalHitsUpTo()).thenReturn(10000);  
            numericType.fieldName,
        int dims
                    long lower = RandomNumbers.randomLongBetween(random(), 0, numPoints / 4);  
import org.apache.lucene.index.IndexReader;
                        numericType.encode(lower),  
                    int numValues = RandomNumbers.randomIntBetween(random(), 1, 10);
                try (IndexReader reader = iw.getReader()) {
                String fieldName = numericType.fieldName;
                BigIntegerPoint.encodeDimension(BigInteger.valueOf(value.longValue()), bytes, 0);  
                }  
            assertFalse("Should not approximate with multiple sorts", query.canApproximate(mockContext));
        }
                    Query approximateQuery = new ApproximatePointRangeQuery(  
                }  
                { NumericType.HALF_FLOAT },
                for (long fare = 10000; fare <= 20000; fare += 100) {
                    assertTrue("Should be able to approximate", approxQuery.canApproximate(mockContext));  
            }
        // Test 1: Multiple sorts should prevent approximation  
                    // Test 2: Query for high fare range
                    }
                    numericType.addDocValuesField(doc, fieldName, i);
            numericType.format
            String getSortFieldName() {
                    iw.forceMerge(1);  
import org.apache.lucene.search.FieldDoc;
                long startTimestamp = currentTime - (48 * 60 * minute); // Start 48 hours ago
    public void testSortOrder() {
        ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
        try (Directory directory = newDirectory()) {
                    long actualHitsInRange = exactAllDocs.totalHits.value();  
        IndexSearcher searcher,
        TopDocs approxDocsDesc = searcher.search(approxQueryDesc, size, descSort);  
                    FieldDoc searchAfterDoc = (FieldDoc) searchAfterDocs.scoreDocs[0];  
        int compareSize = Math.min(size, Math.min(approxDocsAsc.scoreDocs.length, exactDocsAsc.scoreDocs.length));  
        int newSize = RandomNumbers.randomIntBetween(random(), 50, 500);
                        numericType.encode(upper),
        ) {
 * The OpenSearch Contributors require contributions made to  
                int numPoints = RandomNumbers.randomIntBetween(random(), 2000, 5000);
            assertEquals(
        TopDocs approxDocs = searcher.search(approxQuery, size);  
            Query rangeQuery(String fieldName, Number lower, Number upper) {
                        topDocs.scoreDocs.length
    public void testApproximateRangeWithSizeDefault() throws IOException {
                        FieldDoc fieldDoc = (FieldDoc) scoreDoc;
            }
            1,  
            void addField(Document doc, String fieldName, Number value) {
            }  
                return NumberFieldMapper.NumberType.LONG;
            void addDocValuesField(Document doc, String fieldName, Number value) {
        int size,
            // Add to BKD
                }
                    long upper = RandomNumbers.randomLongBetween(random(), numPoints / 2, 3 * numPoints / 4);
                        Document doc = new Document();
        }  
            // Add DocValues
        Function<byte[], String> format = numericType.format;  
                        numericType.encode(lower),
                try (IndexReader reader = iw.getReader()) {
                        dims,  
                        numericType.encode(upper),  
                        SortOrder.DESC,
                    Document doc = new Document();  
                    long convertedTimestamp = dateFieldType.resolution().convert(Instant.ofEpochMilli(timestamp));
                }
                        numericType.encode(upper),  
                exactDocs.totalHits.value(),  
            source.sort(new FieldSortBuilder(numericType.fieldName).order(SortOrder.ASC));
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType()));
            byte[] encode(Number value) {  
                    if (random().nextInt(100) == 0) {  
        }
        SortOrder sortOrder = random().nextBoolean() ? SortOrder.ASC : SortOrder.DESC;  
    }
                    final int size = RandomNumbers.randomIntBetween(random(), 5, 20);
        long upperMillis = dateFieldType.resolution().convert(parser.parse(upperBound, () -> nowInMillis));
                }
                    assertEquals(
    public void testDateRangeIncludingNowQueryApproximation() throws IOException {
    }
        },
                }
        }  
                try (IndexReader reader = iw.getReader()) {
                    );  
            approxDocsAsc.scoreDocs.length
        try (Directory directory = newDirectory()) {
                    numericType.addField(doc, fieldName, fare);
                iw.flush();  
                    Document doc = new Document();
                for (int i = range2Start; i <= range2End; i++) {
                    testApproximateVsExactQuery(searcher, fieldName, 250, 500, 50, dims);
                    );  
                { NumericType.LONG },  
                        SortOrder.DESC,
                    numericType.addDocValuesField(doc, fieldName, fare);
            }  
                    IndexSearcher searcher = new IndexSearcher(reader);
        testApproximateRangeWithSearchAfter(SortOrder.DESC);
                    // Create mock context for approximate query
                try (IndexReader reader = iw.getReader()) {
                        numericType.format  
                try (IndexReader reader = iw.getReader()) {
            return fieldName;  
                        "Approximate and exact queries should return same number of docs",  
            }
    }
                    IndexSearcher searcher = new IndexSearcher(reader);
            // Use NumericType.LONG for date fields
                        numericType.format
            }  
                        size,
                    iw.addDocument(doc);  
    public static Collection<Object[]> parameters() {
                iw.flush();
            @Override
                    Query approximateQuery = new ApproximatePointRangeQuery(
                            assertTrue(  
                    iw.addDocument(doc);
                iw.flush();
                }
                }  
                        FieldDoc exactFieldDoc = (FieldDoc) exactDocs.scoreDocs[i];
            @Override
                        numericType.encode(upper),  
                iw.flush();
import org.apache.lucene.document.FloatPoint;
            @Override
                        numericType.format
        );  
                }
                    iw.addDocument(doc);
            // Use NumericType.LONG for date fields  
                    TopDocs topDocs = searcher.search(approximateQuery, size);
            field,
            @Override
            size,
        // Test with exact query
                approxDocs.totalHits.value()
                        assertEquals("Mismatch at doc index " + i, topDocs.scoreDocs[i].doc, topDocs1.scoreDocs[i].doc);  
        when(mockContext.trackTotalHitsUpTo()).thenReturn(trackTotalHitsUpTo);  
                    assertEquals(size, topDocs.scoreDocs.length);  
            SortField.Type getSortFieldType() {
                if (random().nextBoolean()) {
        // Parse the date expressions using the DateFieldType's resolution
                    ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
                        assertTrue(size <= topDocs.totalHits.value());
                int dims = 1;
                doc.add(new NumericDocValuesField(fieldName, Float.floatToIntBits(value.floatValue())));
                        assertEquals(  
                    for (int dup = 0; dup < 5; dup++) {  
                        numericType.encode(upper),
                    when(mockContext.size()).thenReturn(size);
                { NumericType.INT },
                        } else {
    }  
            ascSort = new Sort(new SortField(field, SortField.Type.LONG));
import org.apache.lucene.document.Document;
                try (IndexReader reader = iw.getReader()) {
import org.apache.lucene.document.DoublePoint;  
            numericType.format  
                iw.flush();
        try (Directory directory = newDirectory()) {  
                doc.add(new NumericDocValuesField(fieldName, value.longValue()));
                }  
                    // Randomly flush
            numericType.format
        ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
                    Query approximateQuery = new ApproximatePointRangeQuery(  
                    iw.addDocument(doc);  
            when(mockContext.size()).thenReturn(10);
        String lowerBound,
        }
        abstract void addDocValuesField(Document doc, String fieldName, Number value);  
                        iw.addDocument(doc);
import org.opensearch.search.sort.SortOrder;
            }
            "Should return exactly size value documents as regular query",
        try (Directory directory = newDirectory()) {  
                    TopDocs topDocs1 = searcher.search(exactQuery, size, sort);  
                iw.flush();
                "When exact results fit in size, approximate should match exactly",
            byte[] encode(Number value) {
        // Test with sorting (ASC and DESC)
        NumericType(String fieldName, Function<byte[], String> format) {  
                }  
                if (random().nextBoolean()) {
