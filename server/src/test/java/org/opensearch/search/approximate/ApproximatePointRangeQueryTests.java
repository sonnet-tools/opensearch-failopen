                    Query exactValueQuery = numericType.rangeQuery(numericType.fieldName, searchAfterValue, searchAfterValue);
                    assertEquals(size, topDocs.scoreDocs.length);
                        assertEquals(
            @Override
                numericType.addDocValuesField(doc, numericType.fieldName, highValue);
                    numericType.addDocValuesField(doc, fieldName, fare);
                int dims = 1;
                    TopDocs topDocs1 = searcher.search(exactQuery, size, sort);
                    int expectedReturnSize = Math.min(size, totalDocs);
        when(mockContext.trackTotalHitsUpTo()).thenReturn(SearchContext.TRACK_TOTAL_HITS_ACCURATE);
        TopDocs approxDocs = searcher.search(approxQuery, size);
    }
                    Document doc = new Document();
                for (int i = range2Start; i <= range2End; i++) {
                }
        int from = RandomNumbers.randomIntBetween(random(), 0, 100);
                    numericType.addDocValuesField(doc, fieldName, value);
            numericType.encode(lower),
                    doc.add(new LongPoint(dateFieldType.name(), convertedTimestamp));
            }
                }
                        numericType.encode(upper),
    public void testApproximateRangeWithDefaultSize() throws IOException {
        },
            numericType.encode(upper),
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
                        numericType.encode(upper),
                    if (topDocs.totalHits.relation() == Relation.EQUAL_TO) {
                        null,
                    for (int i = 0; i < compareSize; i++) {
                    Document doc = new Document();
                int dims = 1;
                        null,
                    Query approximateQuery = new ApproximatePointRangeQuery(
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
            void addField(Document doc, String fieldName, Number value) {
    }
                    iw.forceMerge(1);
                                value.longValue() > searchAfterLong
            @Override
                    ApproximatePointRangeQuery approxQuery = new ApproximatePointRangeQuery(
            }
                try (IndexReader reader = iw.getReader()) {
import org.apache.lucene.store.Directory;
            "Should return exactly size value documents as regular query",
                    doc.add(new NumericDocValuesField(dateFieldType.name(), convertedTimestamp));
            @Override
            format
                if (random().nextBoolean()) {
                { NumericType.FLOAT },
                        numericType.fieldName,
            return;
    }
        // Verify the results match
                }
                    long upper = RandomNumbers.randomLongBetween(random(), lower + size * 2, Math.min(lower + 200, numPoints - 1));
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
        }
                        assertEquals(topDocs.totalHits.value(), size);
    public void testSize() {
        int trackTotalHitsUpTo = RandomNumbers.randomIntBetween(random(), 1000, 20000);
                        iw.flush();
            numericType.fieldName,
        };
                try (IndexReader reader = iw.getReader()) {
                    for (int j = 0; j < numValues; j++) {
 * this file be licensed under the Apache-2.0 license or a
            numericType.encode(upper),
                        numericType.format
                            "Sort value at position " + i + " should match",
import org.apache.lucene.search.ScoreDoc;
                    Document doc = new Document();
        try (Directory directory = newDirectory()) {
                    long lower = RandomNumbers.randomLongBetween(random(), 0, 1000);
                    long lower = RandomNumbers.randomLongBetween(random(), numPoints - 100, numPoints - 20);
                    int size = RandomNumbers.randomIntBetween(random(), 10, 50);
                    long expectedHits = upper - lower + 1;
                    assertEquals(size, topDocs1.scoreDocs.length);
                    // To test upper half of the data to test the DESC
        this.numericType = numericType;
        assertEquals("Should return exactly size value documents", size, approxDocsAsc.scoreDocs.length);
                    // Randomly flush
                    Document doc = new Document();
        if (numericType == NumericType.HALF_FLOAT) {
                }
        Number lower,
                        "Approximate and exact queries should return same number of docs",
                    iw.forceMerge(1);
                        size,
                return NumberFieldMapper.NumberType.UNSIGNED_LONG;
            void addField(Document doc, String fieldName, Number value) {
        Query exactQuery,
    // Test to cover the left child traversal in intersectRight with CELL_INSIDE_QUERY
                    testApproximateVsExactQuery(searcher, fieldName, 1000, 3000, 100, dims);
        }
                for (int i = 0; i < numPoints; i++) {
            assertFalse("Should not approximate with multiple sorts", query.canApproximate(mockContext));
    }
                numericType.addField(doc, numericType.fieldName, highValue);
                return DoublePoint.pack(new double[] { value.doubleValue() }).bytes;
                        size,
            void addDocValuesField(Document doc, String fieldName, Number value) {
                    Document doc = new Document();
            when(mockRequest.source()).thenReturn(source);
                    }
            1,
        },
        long lowerMillis = dateFieldType.resolution().convert(parser.parse(lowerBound, () -> nowInMillis));
            @Override
                    iw.addDocument(doc);
                }
                if (random().nextBoolean()) {
                    Query approximateQuery = new ApproximatePointRangeQuery(
                    int searchSize = RandomNumbers.randomIntBetween(random(), 10, 50);
                long highValue = RandomNumbers.randomLongBetween(random(), 900000000L, 999999999L);
                { NumericType.INT },
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
 *
                for (int i = 0; i < numPoints; i++) {
                    source.sort(new FieldSortBuilder(numericType.fieldName).order(sortOrder));
                    numericType.addField(doc, numericType.fieldName, sameValue);
                for (int i = 0; i < numPoints; i++) {
        assertTrue(query.canApproximate(mockContext));
                        size,
                int range2End = range2Start + RandomNumbers.randomIntBetween(random(), 50, 150);
                        dims,
                    long upper = RandomNumbers.randomLongBetween(random(), lower + 10, numPoints - 1);
                        size,
                iw.flush();
                int range1End = range1Start + RandomNumbers.randomIntBetween(random(), 1000, 15000);
                    numericType.addField(doc, numericType.fieldName, i);
        ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
                    if (random().nextInt(20) == 0) {
                    IndexSearcher searcher = new IndexSearcher(reader);
                }
                        numericType.encode(lower),
        ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
            numericType.format
        }
                iw.flush();
                    if (random().nextInt(20) == 0) {
                if (random().nextBoolean()) {
                doc.add(new BigIntegerPoint(fieldName, BigInteger.valueOf(value.longValue())));
                    TopDocs topDocs = searcher.search(query, size, sort);
            void addDocValuesField(Document doc, String fieldName, Number value) {
                    SearchSourceBuilder source = new SearchSourceBuilder();
        DateFieldType dateFieldType,
                    IndexSearcher searcher = new IndexSearcher(reader);
            numericType.encode(upper),
                    );
                for (long fare = 1000; fare <= 3000; fare++) {
            ShardSearchRequest mockRequest = mock(ShardSearchRequest.class);
                for (long fare = 250; fare <= 500; fare++) {
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
                            (exactFieldDoc.fields[0]),
        // Test with approximate query
                return FloatPoint.newRangeQuery(fieldName, lower.floatValue(), upper.floatValue());
            source.sort(new FieldSortBuilder("another_field").order(SortOrder.ASC));
        ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
        long upper = RandomNumbers.randomLongBetween(random(), lower + 10, lower + 1000);
                    numericType.addField(doc, numericType.fieldName, i);
            when(mockContext.from()).thenReturn(0);
                doc.add(new IntPoint(fieldName, value.intValue()));
        {
        }
            SortField.Type getSortFieldType() {
            @Override
        ApproximatePointRangeQuery approxQueryDesc = new ApproximatePointRangeQuery(
import org.apache.lucene.search.TopDocs;
                iw.flush();
        long upperMillis = dateFieldType.resolution().convert(parser.parse(upperBound, () -> nowInMillis));
            @Override
                    assertTrue("Should collect at least min(size, hits) documents", topDocs.totalHits.value() >= expectedReturnSize);
                        dims,
        Sort descSort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
import org.apache.lucene.document.FloatPoint;
        }
                    iw.addDocument(doc);
import org.apache.lucene.search.TotalHits.Relation;
                iw.flush();
                    Document doc = new Document();
                    iw.forceMerge(1);
                    numericType.addField(doc, numericType.fieldName, i);
        },
                    }
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
            @Override
                        SortOrder.DESC,
import java.math.BigInteger;
            NumberFieldMapper.NumberType getNumberType() {
                    }
                    IndexSearcher searcher = new IndexSearcher(reader);
            source.terminateAfter(SearchContext.DEFAULT_TERMINATE_AFTER);
            Query rangeQuery(String fieldName, Number lower, Number upper) {
            @Override
            SortField.Type getSortFieldType() {
                );
            }
import org.apache.lucene.sandbox.document.HalfFloatPoint;
        }
                    when(mockContext.aggregations()).thenReturn(null);
                try (IndexReader reader = iw.getReader()) {
                        null,
                return SortField.Type.FLOAT;
            @Override
        ;
        assertEquals("Should return same number of documents", exactDocsDesc.scoreDocs.length, approxDocsDesc.scoreDocs.length);
        SearchContext mockContext = mock(org.opensearch.search.internal.SearchContext.class);
                    Document doc = new Document();
                    numericType.addField(doc, fieldName, fare);
                        Document doc = new Document();
                    long lower = RandomNumbers.randomLongBetween(random(), numericType.getMinTestValue(), 200);
                        numericType.fieldName,
                }
                            );
                    TopDocs topDocs = searcher.search(approximateQuery, size);
            ascSort = new Sort(new SortField(field, SortField.Type.LONG));
        abstract void addField(Document doc, String fieldName, Number value);
    }
            void addField(Document doc, String fieldName, Number value) {
            @Override
    public void testNycTaxiDataDistribution() throws IOException {
        }
        // Parse the date expressions using the DateFieldType's resolution
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
    public void testApproximateRangeWithSizeDefault() throws IOException {
                if (random().nextBoolean()) {
        try (Directory directory = newDirectory()) {
            SearchSourceBuilder source = new SearchSourceBuilder();
                    }
                doc.add(new NumericDocValuesField(fieldName, value.intValue()));
    public void testApproximateRangeWithSearchAfterDesc() throws IOException {
                int dims = 1;
import java.time.Instant;
            ShardSearchRequest mockRequest = mock(ShardSearchRequest.class);
            }
            approxDocsAsc.scoreDocs.length
                        SortOrder.DESC,
            numericType.encode(upper),
                    int numValues = RandomNumbers.randomIntBetween(random(), 1, 10);
                    assertEquals("Should return min(size, hits) documents", expectedReturnSize, topDocs.scoreDocs.length);
            numericType.format
                    iw.forceMerge(1);
            );
        String getSortFieldName() {
                for (int i = 0; i < 5000; i++) {
                }
            @Override
            @Override
        }
                return SortField.Type.INT;
                }
        );
import org.apache.lucene.search.FieldDoc;
                        iw.flush();
        testApproximateRangeWithSearchAfter(SortOrder.ASC);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
        );
                    IndexSearcher searcher = new IndexSearcher(reader);
                int dataEnd = dataStart + RandomNumbers.randomIntBetween(random(), 1000, 2000);
                    TopDocs topDocs = searcher.search(approximateQuery, size);
    }
            void addDocValuesField(Document doc, String fieldName, Number value) {
            }
                return SortField.Type.DOUBLE;
    }
                { NumericType.UNSIGNED_LONG } }
        int dims
            Query rangeQuery(String fieldName, Number lower, Number upper) {
                { NumericType.LONG },
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                iw.addDocument(doc);
                try (IndexReader reader = iw.getReader()) {
            NumberFieldMapper.NumberType getNumberType() {
            descSort = new Sort(new SortField(field, SortField.Type.LONG, true));
            @Override
                }
                    Document doc = new Document();
                            (approxFieldDoc.fields[0])
                    for (int dup = 0; dup < 5; dup++) {
                    if (random().nextInt(20) == 0) {
                { NumericType.DOUBLE },
                    long lower = range1End + RandomNumbers.randomIntBetween(random(), 10, gapSize / 2);
                    );
                int numDocs = dataEnd - dataStart + 1;
                int numPoints = RandomNumbers.randomIntBetween(random(), 1000, 3000);
                    assertEquals(topDocs.totalHits, new TotalHits(1000, TotalHits.Relation.EQUAL_TO));
                        dims,
                        exactDocs.scoreDocs.length,
                    Query exactQuery = numericType.rangeQuery(numericType.fieldName, lower, upper);
                int dims = 1;
                int dims = 1;
                    Query approximateQuery = new ApproximatePointRangeQuery(
        assertEquals(
            @Override
            }
        when(mockContext.aggregations()).thenReturn(null);
                    long lower = RandomNumbers.randomLongBetween(random(), 0, numPoints / 2);
        int compareSize = Math.min(size, Math.min(approxDocsAsc.scoreDocs.length, exactDocsAsc.scoreDocs.length));
            @Override
                    // Test approximate query with searchAfter
                return NumberFieldMapper.NumberType.HALF_FLOAT;
                        numericType.addField(doc, fieldName, fare);
        DateFormatter formatter = dateFieldType.dateTimeFormatter();
                        numericType.encode(lower),
                        iw.flush();
                        numericType.fieldName,
                    testApproximateVsExactQueryWithDateField(searcher, dateFieldType, "now-1d", "now", 50, dims);
                try (IndexReader reader = iw.getReader()) {
        try (Directory directory = newDirectory()) {
                    boolean reverseSort = sortOrder == SortOrder.DESC;
                BigIntegerPoint.encodeDimension(BigInteger.valueOf(value.longValue()), bytes, 0);
    }
                        numericType.format
                        numericType.encode(upper),
        }
                for (int i = 0; i < numPoints; i++) {
                for (int i = dataStart; i <= dataEnd; i++) {
                }
                    iw.addDocument(doc);
            when(mockContext.aggregations()).thenReturn(null);
 * SPDX-License-Identifier: Apache-2.0
                    iw.forceMerge(1);
    ) throws IOException {
            @Override
                    Document doc = new Document();
                }
        TopDocs approxDocsAsc = searcher.search(approxQueryAsc, size, ascSort);
            @Override
                    Query exactQuery = numericType.rangeQuery(numericType.fieldName, lower, upper);
        assertEquals(expectedSize, query.getSize());
    public void testIntersectRightSingleChildNode() throws IOException {
                }
                    );
        int newSize = RandomNumbers.randomIntBetween(random(), 50, 500);
                iw.flush();
            SearchContext mockContext = mock(SearchContext.class);
                    testApproximateVsExactQuery(searcher, fieldName, 1000, 1500, 100, dims);
                    Query approximateQuery = new ApproximatePointRangeQuery(
                    }
                    if (i % 15 == 0) iw.flush();
                }
                    iw.addDocument(doc);
                    Document doc = new Document();
            // Add DocValues
            // Use NumericType.LONG for date fields
                }
        IndexSearcher searcher,
                    // Test dense region
        TopDocs exactDocsAsc = searcher.search(exactQuery, size, ascSort);
                    Query approximateQuery = new ApproximatePointRangeQuery(
            );
                // Typical fares: 1000-3000 (dense, 5 docs per value)
    }
            void addDocValuesField(Document doc, String fieldName, Number value) {
                            assertTrue(
                    TopDocs topDocs = searcher.search(approximateQuery, 10);
                        numericType.encode(lower),
            }
import org.opensearch.common.time.DateFormatter;
        INT("int_field", ApproximatePointRangeQuery.INT_FORMAT) {
        }
                for (int i = 0; i < numSameValueDocs; i++) {
                    long lower = RandomNumbers.randomLongBetween(random(), 0, 50);
                    TopDocs topDocs = searcher.search(query, size, sort);
        int size = RandomNumbers.randomIntBetween(random(), 10, 100);
            1,
                    long lower = 0;
                int range2Start = range1End + gapSize;
                // Dense range: 1000-1999 (5000 docs, 5 per value)
                    Document doc = new Document();
                return DoublePoint.newRangeQuery(fieldName, lower.doubleValue(), upper.doubleValue());
                        numericType.encode(upper),
            }
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
    public void testIntersectRightCellOutsideQuery() throws IOException {
    // Test to cover intersectRight with CELL_CROSSES_QUERY case
            numericType.encode(lower),
                    final int size = RandomNumbers.randomIntBetween(random(), 20, 100);
            void addDocValuesField(Document doc, String fieldName, Number value) {
import org.opensearch.search.sort.SortOrder;
        when(mockContext.from()).thenReturn(from);
                    final int size = RandomNumbers.randomIntBetween(random(), 30, 100);
                        numericType.encode(upper),
 * compatible open source license.
    }
                        numericType.encode(upper),
        }
                    );
                    long upper = RandomNumbers.randomLongBetween(random(), 3 * numPoints / 4, numPoints - 1);
    public ApproximatePointRangeQueryTests(NumericType numericType) {
                int dims = 1;
                iw.flush();
                        numericType.format
                        numericType.fieldName,
                    assertEquals(size, topDocs.scoreDocs.length);
                        iw.flush();
                try (IndexReader reader = iw.getReader()) {
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                    int compareSize = Math.min(size, Math.min(topDocs.scoreDocs.length, topDocs1.scoreDocs.length));
                }
            assertEquals(
                    }
                }
                    ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
                return NumberFieldMapper.NumberType.FLOAT;
            @Override
            }
                iw.flush();
        assertEquals(query.getSize(), 10_000);
            }
                }
        );
            @Override
                    when(mockContext.request()).thenReturn(mockRequest);
                        numericType.encode(lower),
                return bytes;
    }
                    long timestamp = startTimestamp + (i * minute);
        String upperBound,
                }
        TopDocs exactDocs = searcher.search(exactQuery, size);
            }
                int dims = 1;
    enum NumericType {
            when(mockContext.size()).thenReturn(10);
                for (int i = 0; i < numPoints; i++) {
import static org.mockito.Mockito.mock;
            @Override
                    // Test across regions
                try (IndexReader reader = iw.getReader()) {
                        numericType.format
                        numericType.encode(lower),
                    );
                    }
                doc.add(new LongPoint(fieldName, value.longValue()));
                        topDocs1.scoreDocs.length,
                doc.add(new NumericDocValuesField(fieldName, value.longValue()));
                    TopDocs topDocs = searcher.search(approximateQuery, searchSize);
                        numericType.encode(upper),
            numericType.fieldName,
                return HalfFloatPoint.newRangeQuery(fieldName, lower.floatValue(), upper.floatValue());
                    ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
    private void verifyRangeQueries(
import org.opensearch.search.internal.SearchContext;
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType()));
            }
    public void testApproximateRangeShortCircuitAscSort() throws IOException {
                    iw.addDocument(doc);
                int dims = 1;
        HALF_FLOAT("half_float_field", ApproximatePointRangeQuery.HALF_FLOAT_FORMAT) {
                    long upper = dataEnd + RandomNumbers.randomIntBetween(random(), 50, 200);
        Query exactQuery = numericType.rangeQuery(field, lower, upper);
        long lower = RandomNumbers.randomLongBetween(random(), 0, 100);
import org.opensearch.search.internal.ShardSearchRequest;
                        numericType.addField(doc, numericType.fieldName, randomValue);
            numericType.encode(upper),
        if (exactDocs.totalHits.value() <= size) {
            @Override
    private void testApproximateVsExactQuery(IndexSearcher searcher, String field, Number lower, Number upper, int size, int dims)
                    }
import org.apache.lucene.search.Query;
    public void testApproximateRangeShortCircuit() throws IOException {
                long minute = 60 * 1000L;
                // Create NYC taxi fare distribution with different ranges
                        numericType.encode(upper),
                int dims = 1;
                }
                    iw.addDocument(doc);
    // Following test replicates the nyx_taxis dataset
            }
                    BigInteger.valueOf(upper.longValue())
        // Test with exact query
                        numericType.fieldName,
                    }
                "DESC sorted results should match at position " + i,
                    iw.addDocument(doc);
                    );
                    source.searchAfter(searchAfterDoc.fields);
                byte[] bytes = new byte[BigIntegerPoint.BYTES];
            }
                int numPoints = RandomNumbers.randomIntBetween(random(), 1000, 3000);
            NumberFieldMapper.NumberType getNumberType() {
                    IndexSearcher searcher = new IndexSearcher(reader);
            }
    }
import java.util.Collection;
                    long lower = RandomNumbers.randomLongBetween(random(), 0, sameValue - 100);
                for (int i = 0; i < numDocs; i++) {
    public void testApproximateRangeShortCircuitDescSort() throws IOException {
        TopDocs approxDocsDesc = searcher.search(approxQueryDesc, size, descSort);
        }
        // Test with sorting (ASC and DESC)
                try (IndexReader reader = iw.getReader()) {
            byte[] encode(Number value) {
            source.sort(new FieldSortBuilder(numericType.fieldName).order(SortOrder.ASC));
                    assertEquals(
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
                    // Test 1: Query for typical fare range
                    iw.addDocument(doc);
                    ShardSearchRequest mockRequest = mock(ShardSearchRequest.class);
import org.apache.lucene.document.Document;
                    }
            size,
                    numericType.addField(doc, numericType.fieldName, i);
        return Arrays.asList(
                        numericType.encode(lower),
            when(mockRequest.source()).thenReturn(source);
    }
                    ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
    }
                    }
            byte[] encode(Number value) {
        Function<byte[], String> format = numericType.format;
        assertFalse(query.canApproximate(mockContext));
            }
        }
                int numPoints = RandomNumbers.randomIntBetween(random(), 3000, 10000);
                long startTimestamp = currentTime - (48 * 60 * minute); // Start 48 hours ago
            }
import org.opensearch.search.builder.SearchSourceBuilder;
        compareSize = Math.min(size, Math.min(approxDocsDesc.scoreDocs.length, exactDocsDesc.scoreDocs.length));
                }
    // Test to specifically cover the single child case in intersectRight
        long getMinTestValue() {
                byte[] bytes = new byte[HalfFloatPoint.BYTES];
                // 0-99 (100 docs)
        byte[] upperBytes = numericType.encode(upper);
        FLOAT("float_field", ApproximatePointRangeQuery.FLOAT_FORMAT) {
                iw.flush();
            this.format = format;
                    assertEquals(
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                for (int i = 0; i < numPoints; i++) {
                }
    }
                    // Query that will partially overlap with tree nodes (CELL_CROSSES_QUERY)
                    iw.addDocument(doc);
        int expectedSize = Math.max(from + size, trackTotalHitsUpTo) + 1;
                    if (random().nextInt(20) == 0) {
        // Verify results match
                        dims,
                    testApproximateVsExactQuery(searcher, fieldName, 0, 2000, 200, dims);
                int gapSize = RandomNumbers.randomIntBetween(random(), 200, 400);
            String getSortFieldName() {
            upperBytes,
                int dims = 1;
                        numericType.addDocValuesField(doc, fieldName, fare);
            }
                    IndexSearcher searcher = new IndexSearcher(reader);
                }
 * The OpenSearch Contributors require contributions made to
                    IndexSearcher searcher = new IndexSearcher(reader);
            return fieldName;
            }
                    Query exactQuery = numericType.rangeQuery(numericType.fieldName, lower, upper);
                        iw.flush();
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
            }
import static org.mockito.Mockito.when;
            lowerBytes,
            }
                        } else {
            SortField.Type getSortFieldType() {
            }
        assertFalse(query.canApproximate(null));
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
            }
                    Query exactQuery = numericType.rangeQuery(numericType.fieldName, lower, upper);
        assertEquals(query.getSize(), newSize);
                        iw.flush();
                approxDocsDesc.scoreDocs[i].doc
                        size,
            }
                    numericType.addField(doc, numericType.fieldName, i);
            }
        long upper = RandomNumbers.randomLongBetween(random(), lower + 10, lower + 1000);
                return FloatPoint.pack(new float[] { value.floatValue() }).bytes;
                                "Doc value " + value + " should be < searchAfterValue " + searchAfterLong,
            }
        try (Directory directory = newDirectory()) {
    }
                    // This ensures CELL_INSIDE_QUERY condition
                    assertEquals(
                    // Test 2: Query for high fare range
                    Query approximateQuery = new ApproximatePointRangeQuery(
                    testApproximateVsExactQueryWithDateField(searcher, dateFieldType, "now-1h", "now", 50, dims);
                    numericType.addDocValuesField(doc, fieldName, fare);
            numericType.encode(lower),
                    iw.addDocument(doc);
        query.setSortOrder(sortOrder);
            when(mockContext.size()).thenReturn(10);
                        numericType.encode(upper),
                    );
                int dims = 1;
        }
            }
            }
import java.util.function.Function;
                    ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
                int dims = 1;
        },
                doc.add(new NumericDocValuesField(fieldName, Float.floatToIntBits(value.floatValue())));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            @Override
        }
                    );
                    );
        Number upper,
                    long lower = dataStart - RandomNumbers.randomIntBetween(random(), 50, 200);
                final int size = RandomNumbers.randomIntBetween(random(), 5, 20);
                return NumberFieldMapper.NumberType.LONG;
            }
                return fieldName + "_sort";
    public void testApproximateRangeEqualsActualRange() throws IOException {
            numericType.fieldName,
                        numericType.fieldName,
                    iw.addDocument(doc);
                        Number value = (Number) fieldDoc.fields[0];
                    numericType.addField(doc, numericType.fieldName, i);
        // If exact query returns fewer docs than size, approximate should match
    }
                int numPoints = RandomNumbers.randomIntBetween(random(), 2000, 5000);
            NumberFieldMapper.NumberType getNumberType() {
            }
                            );
        };
import org.apache.lucene.search.TotalHits;
        ApproximatePointRangeQuery approxQueryAsc = new ApproximatePointRangeQuery(
            @Override
                        numericType.getNumberType()
        abstract NumberFieldMapper.NumberType getNumberType();
            NumberFieldMapper.NumberType getNumberType() {
            }
import java.util.Arrays;
            numericType.fieldName,
            @Override
        // Test 2: Single sort on the same field should allow approximation
                try (IndexReader reader = iw.getReader()) {
                        size,
                }
            @Override
                    assertEquals("Should return exactly all documents", numDocs, topDocs.scoreDocs.length);
                for (int i = 0; i < numPoints; i++) {
            // Skip - HALF_FLOAT uses different fields for storage vs sorting which causes issues with search_after boundary checking during
                        dims,
                    iw.addDocument(doc);
                doc.add(new NumericDocValuesField(fieldName, Double.doubleToLongBits(value.doubleValue())));
                int numPoints = RandomNumbers.randomIntBetween(random(), 2000, 5000);
                    long lower = RandomNumbers.randomLongBetween(random(), numPoints / 4, numPoints / 2);
public class ApproximatePointRangeQueryTests extends OpenSearchTestCase {
                    NumberFieldMapper.NumberFieldType fieldType = new NumberFieldMapper.NumberFieldType(
                try (IndexReader reader = iw.getReader()) {
        abstract SortField.Type getSortFieldType();
                try (IndexReader reader = iw.getReader()) {
        }
                    final int size = RandomNumbers.randomIntBetween(random(), 50, 200);
            assertEquals(
                        if (sortOrder == SortOrder.ASC) {
                        approxDocs.scoreDocs.length
                    iw.addDocument(doc);
            dims,
        // Verify approximate query returns correct number of results
                    }
                        iw.flush();
                        numericType.encode(lower),
                    Document doc = new Document();
            field,
                        dims,
                        (int) Math.min(size, (upper - lower + 1)),
                    // Test 3: Query for low fares
                        numericType.format
                    iw.forceMerge(1);
                    IndexSearcher searcher = new IndexSearcher(reader);
                        assertTrue(size <= topDocs.totalHits.value());
                    long upper = 1000;
    }
                    // Compare with exact query using Lucene's searchAfter
    public void testIntersectRightCellCrossesQuery() throws IOException {
                    iw.addDocument(doc);
        for (int i = 0; i < compareSize; i++) {
                return fieldName + "_sort";
    public void testCannotApproximateWithTrackTotalHits() {
                    numericType.addField(doc, numericType.fieldName, i);
        when(mockContext.size()).thenReturn(size);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                        numericType.fieldName,
                        iw.addDocument(doc);
 */
            numericType.encode(upper),
        long upper = RandomNumbers.randomLongBetween(random(), lower + 10, lower + 1000);
                if (random().nextBoolean()) {
    }
                }
        byte[] lowerBytes = numericType.encode(lower);
                        dims,
                    IndexSearcher searcher = new IndexSearcher(reader);
        testApproximateRangeWithSearchAfter(SortOrder.DESC);
                    numericType.addField(doc, numericType.fieldName, i);
                    );
            }
        byte[] lowerBytes = numericType.encode(lower);
        assertEquals("Should return exactly size value documents", size, approxDocsAsc.scoreDocs.length);
                    when(mockContext.from()).thenReturn(0);
            numericType.encode(lower),
    }
                return SortField.Type.LONG;
                String fieldName = numericType.fieldName;
                iw.forceMerge(1);
                    BigInteger.valueOf(lower.longValue()),
        );
                        numericType.fieldName,
        TopDocs exactDocs,
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
                        size,
                iw.flush();
        assertTrue("Approximate query should return at most " + size + " docs", approxDocs.scoreDocs.length <= size);
                    FieldDoc searchAfterDoc = (FieldDoc) searchAfterDocs.scoreDocs[0];
                    final int size = RandomNumbers.randomIntBetween(random(), 5, 20);
                    }
            }
            upperBytes,
        final String fieldName;
        try (Directory directory = newDirectory()) {
            this.fieldName = fieldName;
                }
            Query rangeQuery(String fieldName, Number lower, Number upper) {
            }
import java.io.IOException;
        long lower = RandomNumbers.randomLongBetween(random(), 0, 100);
    }
            }
        }
            source.sort(new FieldSortBuilder(numericType.fieldName).order(SortOrder.ASC));
        }
            }
                try (IndexReader reader = iw.getReader()) {
                    iw.addDocument(doc);
                        size,
                for (int i = range1Start; i <= range1End; i++) {
                    when(mockContext.size()).thenReturn(size);
        if (field.equals("@timestamp")) {
            numericType.format
                        long searchAfterLong = ((Number) searchAfterDoc.fields[0]).longValue();
                        size,
        );
                    final int size = RandomNumbers.randomIntBetween(random(), 5, 20);
        testApproximateVsExactQuery(searcher, dateFieldType.name(), lowerMillis, upperMillis, size, dims);
        long lower = RandomNumbers.randomLongBetween(random(), 0, 100);
                for (int i = 100; i < 200; i++) {
            }
                    final int size = RandomNumbers.randomIntBetween(random(), numDocs + 50, numDocs + 200);
        query.setSize(newSize);
            field,
            // Add to BKD
            Query rangeQuery(String fieldName, Number lower, Number upper) {
                        size,
            upperBytes = LongPoint.pack((long) upper).bytes;
            @Override
            exactQuery = LongPoint.newRangeQuery(field, (long) lower, (long) upper);
        long lower = RandomNumbers.randomLongBetween(random(), 0, 100);
                    TopDocs topDocs = searcher.search(query, size, sort);
                    final int size = RandomNumbers.randomIntBetween(random(), 20, 100);
                        size,
                    long actualHitsInRange = exactAllDocs.totalHits.value();
    }
                    // Verify results match
        // Test DESC sort
            new Object[][] {
                        iw.flush();
    public static Collection<Object[]> parameters() {
                for (long fare = 10000; fare <= 20000; fare += 100) {
            1,
import org.opensearch.common.time.DateMathParser;
                    iw.addDocument(doc);
                        numericType.format
                        numericType.encode(upper),
            }
                iw.flush();
                        long randomValue = RandomNumbers.randomLongBetween(random(), 0, 200);
                    assertTrue("Should be able to approximate", approxQuery.canApproximate(mockContext));
import org.opensearch.index.mapper.NumberFieldMapper;
                        dims,
                }
    ) throws IOException {
                iw.flush();
        SortOrder sortOrder = random().nextBoolean() ? SortOrder.ASC : SortOrder.DESC;
                }
                    TopDocs topDocs1 = searcher.search(exactQuery, searchSize);
        DateMathParser parser = formatter.toDateMathParser();
            SortField.Type getSortFieldType() {
            // Use NumericType.LONG for date fields
import org.apache.lucene.sandbox.document.BigIntegerPoint;
                    when(mockContext.trackTotalHitsUpTo()).thenReturn(10000);
            return this == UNSIGNED_LONG ? 0 : -100;
                    numericType.addDocValuesField(doc, numericType.fieldName, sameValue);
                        numericType.encode(lower),
        TopDocs exactDocsDesc = searcher.search(exactQuery, size, descSort);
            numericType.format
        for (int i = 0; i < compareSize; i++) {
                    TopDocs searchAfterDocs = searcher.search(exactValueQuery, 1, sort);
                    long convertedTimestamp = dateFieldType.resolution().convert(Instant.ofEpochMilli(timestamp));
            }
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), reverseSort));
                approxDocs.totalHits.value()
    public void testDateRangeIncludingNowQueryApproximation() throws IOException {
        IndexSearcher searcher,
                        numericType.format
        },
import org.apache.lucene.search.IndexSearcher;
                    for (ScoreDoc scoreDoc : approxDocs.scoreDocs) {
                    QueryShardContext queryShardContext = mock(QueryShardContext.class);
            @Override
                if (random().nextBoolean()) {
                        numericType.format
                    numericType.addField(doc, numericType.fieldName, i);
                if (random().nextBoolean()) {
        verifyRangeQueries(searcher, exactQuery, approxDocs, exactDocs, field, lower, upper, size, dims);
        ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
                    TopDocs topDocs = searcher.search(query, size, sort);
        try (Directory directory = newDirectory()) {
                        "Should return exactly min(size, hits) documents",
    }
            1,
        int size,
                    Sort sort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType(), true));
                    testApproximateVsExactQuery(searcher, fieldName, 10000, 20000, 50, dims);
        assertEquals(query.getSortOrder(), sortOrder);
                        FieldDoc approxFieldDoc = (FieldDoc) approxDocs.scoreDocs[i];
            when(mockContext.from()).thenReturn(0);
                int dims = 1;
        assertTrue(queryCanApproximate.canApproximate(searchContext));
                    );
                    iw.forceMerge(1);
                exactDocs.totalHits.value(),
                    long upper = RandomNumbers.randomLongBetween(random(), highValue, highValue + 1000000L);
                    TopDocs exactDocs = searcher.searchAfter(searchAfterDoc, exactQuery, size, sort);
                iw.flush();
                    iw.forceMerge(1);
        abstract void addDocValuesField(Document doc, String fieldName, Number value);
                    long upper = RandomNumbers.randomLongBetween(random(), lower + 10, Math.min(lower + 100, numPoints - 1));
                    }
                    fieldName,
                for (int i = 0; i < 100; i++) {
                int range1Start = RandomNumbers.randomIntBetween(random(), 0, 1000);
                    Document doc = new Document();
                    if (random().nextInt(20) == 0) {
            SearchContext mockContext = mock(SearchContext.class);
                        numericType.encode(lower),
                long sameValue = RandomNumbers.randomLongBetween(random(), 500, 2000);
                        assertEquals("Mismatch at doc index " + i, topDocs.scoreDocs[i].doc, topDocs1.scoreDocs[i].doc);
            }
            String getSortFieldName() {
                    // Create mock context for approximate query
            dims,
            }
                        numericType.fieldName,
                    );
                    Document doc = new Document();
    }
        ) {
                                value.longValue() < searchAfterLong
            numericType.encode(lower),
                    for (int i = 0; i < compareSize; i++) {
            numericType.format
        try (Directory directory = newDirectory()) {
            }
            public boolean canApproximate(SearchContext context) {
            }
            void addField(Document doc, String fieldName, Number value) {
        final Function<byte[], String> format;
            when(mockContext.aggregations()).thenReturn(null);
                    numericType.addField(doc, numericType.fieldName, i);
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
                    for (int i = 0; i < Math.min(approxDocs.scoreDocs.length, exactDocs.scoreDocs.length); i++) {
                    Query approximateQuery = new ApproximatePointRangeQuery(
        }
                }
        long nowInMillis = System.currentTimeMillis();
        );
                }
                int numSameValueDocs = RandomNumbers.randomIntBetween(random(), 1000, 3000);
                    iw.addDocument(doc);
                        numericType.encode(lower),
                int numPoints = 1000;
            byte[] encode(Number value) {
                        assertEquals("Doc at position " + i + " should match", exactFieldDoc.doc, approxFieldDoc.doc);
                    numericType.addField(doc, fieldName, i);
            numericType.encode(lower),
    }
            format
    public void testIntersectRightLeftChildTraversal() throws IOException {
    }
        LONG("long_field", ApproximatePointRangeQuery.LONG_FORMAT) {
            void addDocValuesField(Document doc, String fieldName, Number value) {
        // Test 1: Multiple sorts should prevent approximation
                    long upper = RandomNumbers.randomLongBetween(random(), numPoints / 2, 3 * numPoints / 4);
                    testApproximateVsExactQuery(searcher, fieldName, 100, 199, 50, dims);
        abstract Query rangeQuery(String fieldName, Number lower, Number upper);
            exactDocsAsc.scoreDocs.length,
            when(mockContext.trackTotalHitsUpTo()).thenReturn(10000);
                doc.add(new NumericDocValuesField(fieldName + "_sort", value.longValue()));
                doc.add(new NumericDocValuesField(fieldName + "_sort", value.longValue()));
                    IndexSearcher searcher = new IndexSearcher(reader);
                iw.forceMerge(1);
import org.opensearch.test.OpenSearchTestCase;
        try (Directory directory = newDirectory()) {
            numericType.fieldName,
                        numericType.fieldName,
                    IndexSearcher searcher = new IndexSearcher(reader);
            }
                long currentTime = System.currentTimeMillis();
            SortOrder.ASC,
                    }
                Document doc = new Document();
            lowerBytes = LongPoint.pack((long) lower).bytes;
            }
                    numericType.addField(doc, numericType.fieldName, i);
    private final NumericType numericType;
                    long upper = RandomNumbers.randomLongBetween(random(), lower + 100, numPoints - 1);
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
/*
                int dims = 1;
    private void testApproximateRangeWithSearchAfter(SortOrder sortOrder) throws IOException {
            numericType.format
            lowerBytes,
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
import org.apache.lucene.document.LongPoint;
                    IndexSearcher searcher = new IndexSearcher(reader);
                int dims = 1;
            byte[] encode(Number value) {
                int numPoints = RandomNumbers.randomIntBetween(random(), 1000, 3000);
        // Test ASC sort
        }
                for (int i = 0; i < 10000; i++) {
            byte[] encode(Number value) {
                iw.flush();
        assertNull(query.getSortOrder());
        }
            @Override
                HalfFloatPoint.encodeDimension(value.floatValue(), bytes, 0);
        }
                return NumberFieldMapper.NumberType.DOUBLE;
    public void testApproximateRangeWithSearchAfterAsc() throws IOException {
                    numericType.addField(doc, fieldName, value);
                        numericType.encode(upper),
                    IndexSearcher searcher = new IndexSearcher(reader);
                int numDocs = RandomNumbers.randomIntBetween(random(), 1500, 3000);
            }
    public void testApproximateVsExactQueryWithDateField(
import org.apache.lucene.document.NumericDocValuesField;
        when(mockContext.trackTotalHitsUpTo()).thenReturn(trackTotalHitsUpTo);
import org.apache.lucene.tests.index.RandomIndexWriter;
    public void testApproximateRangeWithSizeOverDefault() throws IOException {
}
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
        try (Directory directory = newDirectory()) {
                int numPoints = RandomNumbers.randomIntBetween(random(), 1000, 3000);
                "When exact results fit in size, approximate should match exactly",
                        FieldDoc exactFieldDoc = (FieldDoc) exactDocs.scoreDocs[i];
        abstract byte[] encode(Number value);
                    numericType.addDocValuesField(doc, fieldName, i);
                    if (i % RandomNumbers.randomIntBetween(random(), 50, 200) == 0) {
            NumberFieldMapper.NumberType getNumberType() {
                return IntPoint.newRangeQuery(fieldName, lower.intValue(), upper.intValue());
        int size,
    public void testApproximateWithSort() {
                }
                    );
                iw.flush();
                    } else {
                        numericType.encode(lower),
                return SortField.Type.LONG;
        TopDocs approxDocs,
        byte[] upperBytes = numericType.encode(upper);
                    long upper = range2Start - RandomNumbers.randomIntBetween(random(), 10, gapSize / 2);
                        numericType.encode(upper),
                        numericType.encode(lower),
                    Document doc = new Document();
                    Document doc = new Document();
                        numericType.fieldName,
                        sortOrder,
                    when(mockContext.getQueryShardContext()).thenReturn(queryShardContext);
                }
                    long value = 1000 + (i / 5); // Creates 5 docs per value from 1000-1999
                }
                { NumericType.HALF_FLOAT },
    // Test to cover pointTree.visitDocIDs(visitor) in CELL_INSIDE_QUERY leaf case for intersectRight
            exactDocsAsc.scoreDocs.length,
        assertEquals(
            when(mockContext.request()).thenReturn(mockRequest);
    public void testSortOrder() {
                    );
                    numericType.addField(doc, numericType.fieldName, i);
        ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
        }
                        numericType.format
                    long upper = RandomNumbers.randomLongBetween(random(), lower + size, Math.min(lower + size + 2000, numPoints - 1));
                return true;
                DateFieldType dateFieldType = new DateFieldType("@timestamp");
                        SortOrder.DESC,
                    IndexSearcher searcher = new IndexSearcher(reader);
        String field,
                    iw.forceMerge(1);
                                "Doc value " + value + " should be > searchAfterValue " + searchAfterLong,
        try (Directory directory = newDirectory()) {
        throws IOException {
                return LongPoint.pack(new long[] { value.longValue() }).bytes;
                for (int i = 0; i < numPoints; i++) {
                    long upper = RandomNumbers.randomLongBetween(random(), lower + size * 2, numPoints - 1);
        );
            @Override
        if (numericType != NumericType.LONG) {
                    Query exactQuery = numericType.rangeQuery(numericType.fieldName, lower, upper);
            }
                }
                    final int size = RandomNumbers.randomIntBetween(random(), 11000, 13000);
                }
            @Override
                }
                }
                    iw.forceMerge(1);
                        SortOrder.ASC,
        try (Directory directory = newDirectory()) {
                }
                }
                        dims,
                    long lower = RandomNumbers.randomLongBetween(random(), numPoints / 2, numPoints - 200);
                }
                    if (random().nextInt(20) == 0) {
                    Document doc = new Document();
        try (Directory directory = newDirectory()) {
                        iw.flush();
                    testApproximateVsExactQueryWithDateField(searcher, dateFieldType, "now-30m", "now+30m", 50, dims);
                        SortOrder.DESC,
import org.opensearch.index.query.QueryShardContext;
                    assertEquals("Should find no documents in the gap range", 0, topDocs.totalHits.value());
        }
        );
                }
            @Override
            format = ApproximatePointRangeQuery.LONG_FORMAT;
            }
                    Document doc = new Document();
                    // First, get a document at searchAfterValue to use as the searchAfter point
        long lower = RandomNumbers.randomLongBetween(random(), 0, 100);
                        topDocs.scoreDocs.length
                    Document doc = new Document();
            }
        SearchContext searchContext = mock(SearchContext.class);
                    testApproximateVsExactQuery(searcher, fieldName, 250, 500, 50, dims);
            source.terminateAfter(SearchContext.DEFAULT_TERMINATE_AFTER);
                    IndexSearcher searcher = new IndexSearcher(reader);
        int dims
                        topDocs.scoreDocs.length
        assertEquals("Should return same number of documents", exactDocsAsc.scoreDocs.length, approxDocsAsc.scoreDocs.length);
    @ParametersFactory
        DOUBLE("double_field", ApproximatePointRangeQuery.DOUBLE_FORMAT) {
        when(mockContext.request()).thenReturn(null);
                    final int size = RandomNumbers.randomIntBetween(random(), 5, 20);
                    TopDocs topDocs = searcher.search(approximateQuery, size);
            size,
                }
                }
            void addField(Document doc, String fieldName, Number value) {
            1,
import org.apache.lucene.search.Sort;
        {
                        );
        try (Directory directory = newDirectory()) {
package org.opensearch.search.approximate;
                // Create 10000 documents with 1 minute intervals
        );
import org.apache.lucene.document.DoublePoint;
import org.apache.lucene.index.IndexReader;
                        numericType.encode(lower),
                        dims,
                    if (random().nextInt(100) == 0) {
                try (IndexReader reader = iw.getReader()) {
            when(mockContext.trackTotalHitsUpTo()).thenReturn(10000);
            1,
            void addField(Document doc, String fieldName, Number value) {
                    iw.addDocument(doc);
                    int totalDocs = numSameValueDocs + 1;
                exactDocsDesc.scoreDocs[i].doc,
        Sort ascSort = new Sort(new SortField(numericType.getSortFieldName(), numericType.getSortFieldType()));
                for (int i = 0; i < numPoints; i++) {
                return NumberFieldMapper.NumberType.INTEGER;
            @Override
                    TopDocs approxDocs = searcher.search(approxQuery, size, sort);
            Query rangeQuery(String fieldName, Number lower, Number upper) {
        try (Directory directory = newDirectory()) {
                        dims,
import org.apache.lucene.search.SortField;
                        dims,
                doc.add(new HalfFloatPoint(fieldName, value.floatValue()));
                    // Create a query range that fully encompasses the data
                    when(queryShardContext.fieldMapper(numericType.fieldName)).thenReturn(fieldType);
                    TopDocs topDocs = searcher.search(approximateQuery, size, sort);
                        SortOrder.DESC,
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
            @Override
                        assertEquals("Mismatch at doc index " + i, topDocs.scoreDocs[i].doc, topDocs1.scoreDocs[i].doc);
                    long lower = RandomNumbers.randomLongBetween(random(), 0, numPoints / 4);
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
                    TopDocs exactAllDocs = searcher.search(exactQuery, numPoints);
                    assertEquals(actualHitsInRange, topDocs1.totalHits.value());
            }
                if (random().nextBoolean()) {
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                }
                    iw.forceMerge(1);
            "Should return exactly size value documents as regular query",
                    // Test sparse region
                return SortField.Type.LONG;
                        "Approximate and exact queries should return same number of docs",
                return LongPoint.newRangeQuery(fieldName, lower.longValue(), upper.longValue());
                        numericType.format
        }
            assertEquals("ASC sorted results should match at position " + i, exactDocsAsc.scoreDocs[i].doc, approxDocsAsc.scoreDocs[i].doc);
                        FieldDoc fieldDoc = (FieldDoc) scoreDoc;
        long upper = RandomNumbers.randomLongBetween(random(), lower + 10, lower + 1000);
            }
    public void testCanApproximate() {
                return BigIntegerPoint.newRangeQuery(
        try (Directory directory = newDirectory()) {
        ApproximatePointRangeQuery queryCanApproximate = new ApproximatePointRangeQuery(
        try (Directory directory = newDirectory()) {
            return;
                        numericType.encode(upper),
                // Sparse range: 100-199 (100 docs, one per value)
    public void testIntersectRightCellInsideQueryLeaf() throws IOException {
                        numericType.format
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                    Document doc = new Document();
                    when(mockRequest.source()).thenReturn(source);
        }
            }
                    numericType.addField(doc, fieldName, fare);
        }
            SortField.Type getSortFieldType() {
        }
                    int expectedReturnSize = (int) Math.min(size, expectedHits);
                        numericType.format
                    TopDocs topDocs = searcher.search(approximateQuery, size, sort);
                    assertEquals("Should return min(size, totalDocs) documents", expectedReturnSize, topDocs.scoreDocs.length);
                    long upper = RandomNumbers.randomLongBetween(random(), lower, lower + 150);
            numericType.fieldName,
                try (IndexReader reader = iw.getReader()) {
            @Override
            SortField.Type getSortFieldType() {
                }
                }
                    );
                    // Verify all returned docs are correctly ordered relative to searchAfterValue
                    iw.forceMerge(1);
            byte[] encode(Number value) {
    }
import org.apache.lucene.document.IntPoint;
                if (random().nextBoolean()) {
                            assertTrue(
    }
                int dataStart = RandomNumbers.randomIntBetween(random(), 5000, 15000);
        if (field.equals("@timestamp")) {
                    iw.addDocument(doc);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
            @Override
                    numericType.addDocValuesField(doc, fieldName, i);
                    long searchAfterValue = RandomNumbers.randomLongBetween(random(), lower, upper - size);
                if (random().nextBoolean()) {
        ApproximatePointRangeQuery approxQuery = new ApproximatePointRangeQuery(field, upperBytes, lowerBytes, dims, size, null, format);
                    assertTrue("Approximate query should find at least 'size' documents", topDocs.totalHits.value() >= size);
            Query rangeQuery(String fieldName, Number lower, Number upper) {
                    SearchContext mockContext = mock(SearchContext.class);
                    if (random().nextInt(100) == 0) {
        UNSIGNED_LONG("unsigned_long_field", ApproximatePointRangeQuery.UNSIGNED_LONG_FORMAT) {
    public void testHttpLogTimestampDistribution() throws IOException {
                // High fares: 10000-20000 (sparse, 1 doc every 100)
            }
                return IntPoint.pack(new int[] { value.intValue() }).bytes;
                    );
        Function<byte[], String> format = numericType.format;
                if (random().nextBoolean()) {
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
        );
        String lowerBound,
                iw.flush();
            when(mockContext.request()).thenReturn(mockRequest);
                    TopDocs topDocs1 = searcher.search(exactQuery, size);
                        numericType.fieldName,
    }
                    TopDocs topDocs = searcher.search(query, size, sort);
                    iw.addDocument(doc);
            }
            SearchSourceBuilder source = new SearchSourceBuilder();
                return bytes;
                        numericType.format
                    long lower = RandomNumbers.randomLongBetween(random(), 0, numPoints / 2);
                        }
                if (random().nextBoolean()) {
            @Override
            assertTrue("Should approximate with single sort on same field", query.canApproximate(mockContext));
                int dims = 1;
import org.opensearch.search.sort.FieldSortBuilder;
                iw.forceMerge(1);
                    assertEquals("Should find all documents", numDocs, topDocs.totalHits.value());
                    numericType.addField(doc, fieldName, i);
            // tests
                iw.flush();
            }
                // Low fares: 250-500 (sparse)
                }
        NumericType(String fieldName, Function<byte[], String> format) {
                doc.add(new FloatPoint(fieldName, value.floatValue()));
                }
                        dims,
                doc.add(new DoublePoint(fieldName, value.doubleValue()));
        long upper = RandomNumbers.randomLongBetween(random(), lower + 10, lower + 1000);
                    numericType.addDocValuesField(doc, numericType.fieldName, i);
                int numPoints = RandomNumbers.randomIntBetween(random(), 15000, 20000);
                    TopDocs topDocs1 = searcher.search(exactQuery, size, sort);
                    ApproximatePointRangeQuery query = new ApproximatePointRangeQuery(
            @Override
                try (IndexReader reader = iw.getReader()) {
                        SortOrder.DESC,
                String fieldName = numericType.fieldName;
                    }
                    int compareSize = Math.min(size, Math.min(topDocs.scoreDocs.length, topDocs1.scoreDocs.length));
                }
            SortOrder.DESC,
                    IndexSearcher searcher = new IndexSearcher(reader);
                    );
    // Test to cover CELL_OUTSIDE_QUERY break case for intersectRight
                try (IndexReader reader = iw.getReader()) {
                        numericType.fieldName,
            approxDocsAsc.scoreDocs.length
            @Override
                        numericType.fieldName,
