            // Use the same rounding logic for query bounds as used in indexing
            doubles[i] = rounded;
    }
        // Index the problematic value
                "index",
            }
import org.opensearch.common.util.io.IOUtils;
        );
        scaledFloatQ = ft.rangeQuery(null, 79.99, true, true, MOCK_QSC);
        );
    }
/*
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
        Document doc = new Document();
    }
import org.apache.lucene.document.Document;
    public void testLargeNumberIndexingAndQuerying() throws IOException {
        IndexSettings normal = IndexSettingsModule.newIndexSettings("normal", Settings.EMPTY);
 * GitHub history for details.
        long scaledValue2 = Math.round(value2 * ft.getScalingFactor());
            // multi-valued
            values = leafFieldData.getDoubleValues();
            false,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        scaledFloatQ = ft.rangeQuery(null, 0.095, true, false, MOCK_QSC);
import org.opensearch.test.IndexSettingsModule;
 *
import org.apache.lucene.index.IndexWriterConfig;
            "scaled_float",
        DirectoryReader reader = DirectoryReader.open(w);
        assertFalse(unindexedNoDocValues.isSearchableViaDocValues(pluggable));
            scalingFactor,
            assertEquals(2, values.docValueCount());
        MappedFieldType mapper = new ScaledFloatFieldMapper.Builder("field", false, false).scalingFactor(100).build(context).fieldType();
        ScaledFloatFieldMapper.ScaledFloatFieldType unindexedNoDocValues = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        Query rangeQuery = ft.rangeQuery(largeValue - 1, largeValue + 1, true, true, MOCK_QSC);
    /** Still searchable from doc values when the index uses a pluggable data format. */
import java.util.Arrays;
        long scaledValue1 = Math.round(value1 * ft.getScalingFactor());
                queryU = scaledU / ft.getScalingFactor();
            SortedNumericDoubleValues values = leafFieldData.getDoubleValues();
        try (DirectoryReader reader = DirectoryReader.open(w)) {
import org.opensearch.Version;
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
        }
        q = ft.rangeQuery(null, 9.99, true, true, MOCK_QSC);
                includeLower,
        long scaledValue = Math.round(value * ft.getScalingFactor());
 * license agreements. See the NOTICE file distributed with
        scaledFloatQ = ft.rangeQuery(-0.095, null, false, true, MOCK_QSC);
 * Licensed to Elasticsearch under one or more contributor
    }
            if (u != null) {
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        long scaledValue = Math.round(value * 100);
            assertEquals(12 / f2.getScalingFactor(), values.nextValue(), 10e-5);
        // Test 3: Exact range query (value to value) should find it
            );
                MOCK_QSC
 * compatible open source license.
        assertEquals("scaled_float:[-9223372036854775808 TO 9]", getQueryString(scaledFloatQ));
            false,
import java.util.Collections;
        w.addDocument(doc);
import org.apache.lucene.store.Directory;
            100,
                () -> { throw new UnsupportedOperationException(); }
        MappedFieldType nullValueMapper = new ScaledFloatFieldMapper.Builder("field", false, false).scalingFactor(100)
        assertTrue(indexedWithDocValues.isSearchable());
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType("scaled_float", 100);
    }
/*
 * software distributed under the License is distributed on an
            "scaled_float",
            fielddata = (IndexNumericFieldData) f2.fielddataBuilder("index", () -> { throw new UnsupportedOperationException(); })
        assertEquals("scaled_float:[-9 TO 9223372036854775807]", getQueryString(scaledFloatQ));
        DirectoryReader reader = DirectoryReader.open(w);
        double value1 = (randomDouble() * 2 - 1) * 10000;
            Query scaledFloatQ = ft.rangeQuery(queryL, queryU, includeLower, includeUpper, MOCK_QSC);
    private String getQueryString(Query query) {
        );
        assertEquals("scaled_float:[-9223372036854775808 TO 9]", getQueryString(scaledFloatQ));
        w.addDocument(doc);
            boolean includeLower = randomBoolean();
    }
            // System.out.println("l=" + l + " queryL=" + queryL + " u=" + u + " queryU=" + queryU + " scalingFactor=" +
 * the Apache License, Version 2.0 (the "License"); you may
            false,
        Query termQuery = ft.termQuery(largeValue, MOCK_QSC);
        assertEquals("scaled_float:[-9 TO 9223372036854775807]", getQueryString(scaledFloatQ));
            "pluggable",
            ScaledFloatFieldMapper.ScaledFloatFieldType f1 = new ScaledFloatFieldMapper.ScaledFloatFieldType(
            true,
            }
            long scaledValue = Math.round(value * ft.getScalingFactor());
            int expectedCount = searcher.count(doubleQ);
    public void testIsSearchableForFieldCapsOnPluggableIndex() {
        ScaledFloatFieldMapper.ScaledFloatFieldType indexedWithDocValues = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        Query query = new IndexOrDocValuesQuery(LongPoint.newExactQuery("scaled_float", scaledValue), dvQuery);
        final int numDocs = 1000;
        IOUtils.close(w, dir);
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
        IOUtils.close(reader, dir);
    }
    public void testRandomPriceValues() {
            assertTrue(values.advanceExact(0));
                "scaled_float1",
        assertEquals("Range query should find the large value", 1, searcher.count(rangeQuery));
        Query exactRangeQuery = ft.rangeQuery(largeValue, largeValue, true, true, MOCK_QSC);
        scaledFloatQ = ft.rangeQuery(null, 0.1, true, true, MOCK_QSC);
 * You may obtain a copy of the License at
        return ((IndexOrDocValuesQuery) ((ApproximateScoreQuery) query).getOriginalQuery()).getIndexQuery().toString();
        // An indexed field is searchable via the isSearchable() short-circuit, regardless of index settings.
        double[] doubles = new double[1000];
            LeafNumericFieldData leafFieldData = fielddata.load(reader.leaves().get(0));
            false,
        assertFalse(unindexedWithDocValues.isSearchableViaDocValues(null));
        assertEquals(LongField.newSetQuery("scaled_float", scaledValue1, scaledValue2), ft.termsQuery(Arrays.asList(value1, value2), null));
        assertEquals("scaled_float:[-9223372036854775808 TO 10]", getQueryString(scaledFloatQ));
                long scaledL = Math.round(l * ft.getScalingFactor());
                scalingFactor
        Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery("scaled_float", scaledValue);
            Query doubleQ = NumberFieldMapper.NumberType.DOUBLE.rangeQuery(
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
        assertEquals(1, searcher.count(rangeQ));
        IndexSearcher searcher = newSearcher(reader);
        }
        q = ft.rangeQuery(null, 99.99, true, true, MOCK_QSC);
    }
 * specific language governing permissions and limitations
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType("scaled_float", 100);
        assertEquals("price:[-9223372036854775808 TO 9999]", getQueryString(q));
            Document doc = new Document();
            doc.add(new LongPoint("scaled_float", scaledValue));
                queryL = scaledL / ft.getScalingFactor();
            0.1 + randomDouble() * 100
            null
import org.apache.lucene.document.LongField;
            false,
 * under the License.
            );
        Document doc = new Document();
        w.close();
            double rounded = scaledValue / ft.getScalingFactor();
            Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true).build()
        double otherValue = 1000.0;
        assertEquals("Term query should find exactly one document", 1, searcher.count(termQuery));
        scaledFloatQ = ft.rangeQuery(null, 0.105, true, false, MOCK_QSC);
            assertTrue(values.advanceExact(0));
        assertEquals("scaled_float:[-9223372036854775808 TO 10]", getQueryString(scaledFloatQ));
 */
        doc.add(new LongPoint("scaled_float", scaledValue));
            true,
            assertEquals(fielddata.getNumericType(), IndexNumericFieldData.NumericType.DOUBLE);
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType("scaled_float", 100);
            false,
            assertEquals(5 / f2.getScalingFactor(), values.nextValue(), 10e-5);
        assertEquals(Collections.singletonList(3.14), fetchSourceValue(mapper, "3.1415"));
                true,
        IndexSearcher searcher = newSearcher(reader);
        doc.add(new SortedNumericDocValuesField("scaled_float2", 12));
        assertEquals("scaled_float:[-9223372036854775808 TO 11]", getQueryString(scaledFloatQ));
        Query scaledFloatQ = ft.rangeQuery(-0.1, null, false, true, MOCK_QSC);
import org.apache.lucene.search.Query;
        assertTrue(indexedWithDocValues.isSearchableViaDocValues(pluggable));
        assertEquals("scaled_float:[-10 TO 9223372036854775807]", getQueryString(scaledFloatQ));
        double value2 = (randomDouble() * 2 - 1) * 10000;
                "double",
            true,
package org.opensearch.index.mapper;
import org.opensearch.index.IndexSettings;
    public void testRoundsUpperBoundCorrectly() {
        Query scaledFloatQ = ft.rangeQuery(null, 0.1, true, false, MOCK_QSC);
        double scalingFactor = 100.0;
        assertTrue(unindexedWithDocValues.isSearchableViaDocValues(pluggable));
        doc2.add(new SortedNumericDocValuesField("scaled_float", scaledValue2));
        // Exact range should find it
    public void testRangeQuery() throws IOException {
 * The OpenSearch Contributors require contributions made to
            0.1 + randomDouble() * 100
public class ScaledFloatFieldTypeTests extends FieldTypeTestCase {
    public void testTermsQuery() {
    }
        doc.add(new SortedNumericDocValuesField("scaled_float", scaledValue));
            null
            IndexNumericFieldData fielddata = (IndexNumericFieldData) f1.fielddataBuilder(
 */
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        IndexSettings pluggable = IndexSettingsModule.newIndexSettings(
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.document.LongPoint;
        Directory dir = newDirectory();
        );
        w.addDocument(doc);
        w.close();
            double value = (randomDouble() * 2 - 1) * 10000;
        Directory dir = newDirectory();
            Collections.emptyMap(),
        );
        assertEquals("Terms query should find both documents", 2, searcher.count(termsQuery));
            assertEquals(10 / f1.getScalingFactor(), values.nextValue(), 10e-5);
        scaledFloatQ = ft.rangeQuery(null, 0.095, true, true, MOCK_QSC);
                "scaled_float2",
            false,
        doc.add(new SortedNumericDocValuesField("scaled_float2", 5));
        assertEquals("scaled_float:[-9223372036854775808 TO 10]", getQueryString(scaledFloatQ));
            "scaled_float",
    }
        assertTrue(query instanceof ApproximateScoreQuery);
            100,
        ScaledFloatFieldMapper.ScaledFloatFieldType unindexedWithDocValues = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        assertEquals("scaled_float:[-10 TO 9223372036854775807]", getQueryString(scaledFloatQ));
            false,
        assertEquals("price:[-9223372036854775808 TO 999]", getQueryString(q));
            Collections.emptyMap(),
        Query rangeQ = ft.rangeQuery(79.0, 80.0, true, true, MOCK_QSC);
            leafFieldData = fielddata.load(reader.leaves().get(0));
            null
        assertEquals("Exclusive range should not find the document", 0, searcher.count(exclusiveRangeQuery));
                .build(null, null);
            "scaled_float",
        scaledFloatQ = ft.rangeQuery(null, 0.105, true, true, MOCK_QSC);
        double largeValue = 92233720368547750.0;
        long scaledValue = Math.round(largeValue * scalingFactor);
            );
    }
        // make sure the accuracy loss of scaled floats only occurs at index time
        );
            Collections.emptyMap(),
        scaledFloatQ = ft.rangeQuery(-0.105, null, false, true, MOCK_QSC);
        w.addDocument(doc2);
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals("scaled_float:[-9223372036854775808 TO 7999]", getQueryString(scaledFloatQ));
        // Add another doc with a different value to ensure we're finding the right one
        assertEquals(Collections.singletonList(3.14), fetchSourceValue(mapper, 3.1415926));
import org.apache.lucene.search.IndexSearcher;
            0.1 + randomDouble() * 100
        scaledFloatQ = ft.rangeQuery(-0.1, null, true, true, MOCK_QSC);
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(expectedCount, scaledCount);
            doc.add(new DoublePoint("double", rounded));
        Query termsQuery = ft.termsQuery(Arrays.asList(largeValue, otherValue), MOCK_QSC);
            true,
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        assertFalse(unindexedWithDocValues.isSearchable());
        assertFalse(unindexedWithDocValues.isSearchableViaDocValues(normal));
        long[] scaled_floats = new long[1000];
 *
                false,
                queryU,
        assertEquals("price:[-9223372036854775808 TO 1999]", getQueryString(q));
        Query q = ft.rangeQuery(null, 19.99, true, true, MOCK_QSC);
        // Test 5: Terms query with multiple values should work
            Double queryU = u;
        assertNull(ft.valueForDisplay(null));
        doc.add(new SortedNumericDocValuesField("scaled_float1", 10));
        assertEquals(query, ft.termQuery(value, null));
        for (int i = 0; i < numQueries; ++i) {
import org.opensearch.index.fielddata.IndexNumericFieldData;
        // Test 1: Term query should find the exact document
            Double u = randomBoolean() ? null : (randomDouble() * 2 - 1) * 10000;
            100,
    public void testFieldData() throws IOException {
import org.opensearch.index.fielddata.LeafNumericFieldData;
import org.opensearch.common.util.FeatureFlags;
 * this work for additional information regarding copyright
import org.apache.lucene.index.DirectoryReader;
            null
            .fieldType();
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
            boolean includeUpper = randomBoolean();
import org.apache.lucene.document.DoublePoint;
        // Test 4: Range query excluding the value should not find it
        Directory dir = newDirectory();
            false,
            false,
    }
        assertEquals("scaled_float:[-8 TO 9223372036854775807]", getQueryString(scaledFloatQ));
        double value = 79.99;
        final DirectoryReader reader = DirectoryReader.open(w);
        );
            if (l != null) {
            false,
                long scaledU = Math.round(u * ft.getScalingFactor());
        // this test checks that searching scaled floats yields the same results as
            0.1 + randomDouble() * 100,
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType("price", 100);
        assertEquals(1, searcher.count(exactQ));
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.approximate.ApproximateScoreQuery;
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        // Range query should find it
    public void testTermQuery() {
            false,
        // searching doubles that are rounded to the closest half float
        // Null index settings must fall back to isSearchable().
            int scaledCount = searcher.count(scaledFloatQ);
        );
 *
        double scalingFactor = 0.1 + randomDouble() * 100;
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        w.close();
    public void testIndexingQueryingConsistency() throws IOException {
        scaledFloatQ = ft.rangeQuery(-0.105, null, true, true, MOCK_QSC);
            .build(context)
        Directory dir = newDirectory();
            ).build(null, null);
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
            ScaledFloatFieldMapper.ScaledFloatFieldType f2 = new ScaledFloatFieldMapper.ScaledFloatFieldType(
import org.apache.lucene.search.IndexOrDocValuesQuery;
            Collections.emptyMap(),
 * ownership. Elasticsearch licenses this file to you under
        scaledFloatQ = ft.rangeQuery(-0.095, null, true, true, MOCK_QSC);
        Query exclusiveRangeQuery = ft.rangeQuery(largeValue, largeValue + 1, false, false, MOCK_QSC);
        IOUtils.close(reader, dir);
        assertTrue(indexedWithDocValues.isSearchableViaDocValues(normal));
            Double queryL = l;
            // ft.getScalingFactor() + " expected= "+ expectedCount + " count= " + scaledCount);
 * not use this file except in compliance with the License.
            scaled_floats[i] = scaledValue;
        assertEquals(Collections.emptyList(), fetchSourceValue(mapper, ""));
            assertEquals(1, values.docValueCount());
            "scaled_float",
                scalingFactor
            Collections.emptyMap(),
import java.io.IOException;
}
import org.apache.lucene.document.SortedNumericDocValuesField;
        assertEquals(10 / ft.getScalingFactor(), ft.valueForDisplay(10L));
        );
        Document doc = new Document();
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import org.apache.lucene.index.IndexWriter;
        // Test 2: Range query containing the value should find it
            true,
import org.opensearch.common.settings.Settings;
        doc2.add(new LongPoint("scaled_float", scaledValue2));
 * SPDX-License-Identifier: Apache-2.0
    public void testValueForSearch() {
            "scaled_float",
        for (int i = 0; i < numDocs; ++i) {
            .nullValue(2.71)
        assertEquals("scaled_float:[-9 TO 9223372036854775807]", getQueryString(scaledFloatQ));
        final int numQueries = 1000;
        long scaledValue2 = Math.round(otherValue * scalingFactor);
            true,
    public void testFetchSourceValue() throws IOException {
                includeUpper,
        assertEquals("Exact range query should find the document", 1, searcher.count(exactRangeQuery));
        assertTrue(pluggable.isPluggableDataFormatEnabled());
            // single-valued
            null
        Query exactQ = ft.rangeQuery(value, value, true, true, MOCK_QSC);
        IOUtils.close(reader, dir);
 *    http://www.apache.org/licenses/LICENSE-2.0
            w.addDocument(doc);
        doc.add(new LongPoint("scaled_float", scaledValue));
            "scaled_float",
            Double l = randomBoolean() ? null : (randomDouble() * 2 - 1) * 10000;
        IndexSearcher searcher = newSearcher(reader);
 */
        Document doc2 = new Document();
    }
        // Index the document with the large value
        assertEquals(Collections.singletonList(2.71), fetchSourceValue(nullValueMapper, ""));
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
/*
 * KIND, either express or implied.  See the License for the
        }
        double value = (randomDouble() * 2 - 1) * 10000;
                queryL,
    public void testRoundsLowerBoundCorrectly() {
            "scaled_float",
            true,
            false,
