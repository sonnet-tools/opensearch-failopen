        IndexSearcher searcher = newSearcher(reader);
        assertTrue(pluggable.isPluggableDataFormatEnabled());  
import org.apache.lucene.document.LongField;  
import org.opensearch.common.util.FeatureFlags;
            int expectedCount = searcher.count(doubleQ);
        long scaledValue1 = Math.round(value1 * ft.getScalingFactor());
        double scalingFactor = 100.0;  
            "scaled_float",
        long scaledValue = Math.round(value * 100);
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(2, values.docValueCount());  
            "scaled_float",  
            100,  
import org.opensearch.Version;
                queryU,  
            assertTrue(values.advanceExact(0));
        double otherValue = 1000.0;  
            "scaled_float",
 * this work for additional information regarding copyright
        try (DirectoryReader reader = DirectoryReader.open(w)) {  
        // Test 2: Range query containing the value should find it
            leafFieldData = fielddata.load(reader.leaves().get(0));  
        doc2.add(new LongPoint("scaled_float", scaledValue2));
            null
        double value2 = (randomDouble() * 2 - 1) * 10000;  
        Query termsQuery = ft.termsQuery(Arrays.asList(largeValue, otherValue), MOCK_QSC);  
            fielddata = (IndexNumericFieldData) f2.fielddataBuilder("index", () -> { throw new UnsupportedOperationException(); })
        DirectoryReader reader = DirectoryReader.open(w);
        MappedFieldType mapper = new ScaledFloatFieldMapper.Builder("field", false, false).scalingFactor(100).build(context).fieldType();
    }
        scaledFloatQ = ft.rangeQuery(-0.105, null, false, true, MOCK_QSC);
    }
            false,
        scaledFloatQ = ft.rangeQuery(null, 0.105, true, false, MOCK_QSC);
        for (int i = 0; i < numDocs; ++i) {  
            Collections.emptyMap(),
        // Index the problematic value
 * the Apache License, Version 2.0 (the "License"); you may
            null  
import org.opensearch.common.settings.Settings;  
            "scaled_float",
                queryU = scaledU / ft.getScalingFactor();  
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType("scaled_float", 100);
        assertEquals(Collections.singletonList(3.14), fetchSourceValue(mapper, "3.1415"));
            false,
    public void testRoundsLowerBoundCorrectly() {  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Collections.emptyMap(),
}
            // single-valued
                "double",
 */
        IOUtils.close(w, dir);
            null
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType("scaled_float", 100);
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
                includeUpper,
import java.util.Arrays;
        w.addDocument(doc);
        assertEquals(1, searcher.count(exactQ));  
        Query query = new IndexOrDocValuesQuery(LongPoint.newExactQuery("scaled_float", scaledValue), dvQuery);  
 */  
            }  
    public void testTermQuery() {
        // this test checks that searching scaled floats yields the same results as
        assertTrue(unindexedWithDocValues.isSearchableViaDocValues(pluggable));
        scaledFloatQ = ft.rangeQuery(null, 0.095, true, true, MOCK_QSC);
            long scaledValue = Math.round(value * ft.getScalingFactor());  
            Document doc = new Document();
        assertEquals("Exclusive range should not find the document", 0, searcher.count(exclusiveRangeQuery));
import org.apache.lucene.document.Document;
        scaledFloatQ = ft.rangeQuery(null, 0.105, true, true, MOCK_QSC);  
        IndexSettings normal = IndexSettingsModule.newIndexSettings("normal", Settings.EMPTY);
        w.addDocument(doc2);
import org.opensearch.index.IndexSettings;  
 * The OpenSearch Contributors require contributions made to  
        );
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType("price", 100);  
            doc.add(new DoublePoint("double", rounded));
        w.close();  
            LeafNumericFieldData leafFieldData = fielddata.load(reader.leaves().get(0));
import org.opensearch.cluster.metadata.IndexMetadata;
            true,  
                MOCK_QSC
        for (int i = 0; i < numQueries; ++i) {  
            Double queryU = u;
        assertEquals("Term query should find exactly one document", 1, searcher.count(termQuery));
        );
        assertEquals("scaled_float:[-9 TO 9223372036854775807]", getQueryString(scaledFloatQ));
                includeLower,
        w.addDocument(doc);  
        // Test 3: Exact range query (value to value) should find it
        double[] doubles = new double[1000];
        double value = 79.99;  
        Query scaledFloatQ = ft.rangeQuery(-0.1, null, false, true, MOCK_QSC);
        doc2.add(new SortedNumericDocValuesField("scaled_float", scaledValue2));  
        double value = (randomDouble() * 2 - 1) * 10000;  
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        assertEquals("scaled_float:[-9223372036854775808 TO 9]", getQueryString(scaledFloatQ));  
        MappedFieldType nullValueMapper = new ScaledFloatFieldMapper.Builder("field", false, false).scalingFactor(100)
/*  
        doc.add(new SortedNumericDocValuesField("scaled_float2", 12));
    public void testValueForSearch() {  
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));  
            ScaledFloatFieldMapper.ScaledFloatFieldType f1 = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        assertEquals("price:[-9223372036854775808 TO 999]", getQueryString(q));  
        long scaledValue = Math.round(largeValue * scalingFactor);  
import org.apache.lucene.index.IndexWriter;
        assertEquals("price:[-9223372036854775808 TO 9999]", getQueryString(q));
            .nullValue(2.71)
            scalingFactor,
        // Test 5: Terms query with multiple values should work
        w.close();  
                scalingFactor
    }
        IOUtils.close(reader, dir);
            assertEquals(10 / f1.getScalingFactor(), values.nextValue(), 10e-5);  
            // System.out.println("l=" + l + " queryL=" + queryL + " u=" + u + " queryU=" + queryU + " scalingFactor=" +
                () -> { throw new UnsupportedOperationException(); }
            values = leafFieldData.getDoubleValues();
 * ownership. Elasticsearch licenses this file to you under  
        scaledFloatQ = ft.rangeQuery(null, 0.1, true, true, MOCK_QSC);
 * license agreements. See the NOTICE file distributed with
            assertEquals(12 / f2.getScalingFactor(), values.nextValue(), 10e-5);
        scaledFloatQ = ft.rangeQuery(null, 79.99, true, true, MOCK_QSC);
            assertEquals(1, values.docValueCount());
            false,  
        IOUtils.close(reader, dir);
import java.util.Collections;  
            true,
            false,
        assertEquals(Collections.singletonList(2.71), fetchSourceValue(nullValueMapper, ""));
        );  
 * Unless required by applicable law or agreed to in writing,
        ScaledFloatFieldMapper.ScaledFloatFieldType unindexedNoDocValues = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        );
        assertEquals("Range query should find the large value", 1, searcher.count(rangeQuery));
import org.opensearch.common.util.io.IOUtils;
        // Null index settings must fall back to isSearchable().
 * this file be licensed under the Apache-2.0 license or a
            Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true).build()
        Query scaledFloatQ = ft.rangeQuery(null, 0.1, true, false, MOCK_QSC);
/*
        final int numQueries = 1000;
        assertFalse(unindexedNoDocValues.isSearchableViaDocValues(pluggable));
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());  
            ).build(null, null);  
            true,
            .fieldType();
            Query scaledFloatQ = ft.rangeQuery(queryL, queryU, includeLower, includeUpper, MOCK_QSC);
        ScaledFloatFieldMapper.ScaledFloatFieldType indexedWithDocValues = new ScaledFloatFieldMapper.ScaledFloatFieldType(
            0.1 + randomDouble() * 100  
        );
                false,  
        Directory dir = newDirectory();
            "scaled_float",  
import org.opensearch.index.fielddata.IndexNumericFieldData;
            w.addDocument(doc);  
        Query exactQ = ft.rangeQuery(value, value, true, true, MOCK_QSC);
 * under the License.  
import org.apache.lucene.search.IndexSearcher;
            0.1 + randomDouble() * 100
            100,  
import org.apache.lucene.document.DoublePoint;
            0.1 + randomDouble() * 100
 */  
        w.addDocument(doc);  
import java.io.IOException;
                "scaled_float1",  
        IndexSearcher searcher = newSearcher(reader);  
            doc.add(new LongPoint("scaled_float", scaledValue));
        // Index the document with the large value
        Query q = ft.rangeQuery(null, 19.99, true, true, MOCK_QSC);
    }  
        // Range query should find it
                long scaledL = Math.round(l * ft.getScalingFactor());
            assertEquals(5 / f2.getScalingFactor(), values.nextValue(), 10e-5);
            if (l != null) {  
            IndexNumericFieldData fielddata = (IndexNumericFieldData) f1.fielddataBuilder(  
    }
        return ((IndexOrDocValuesQuery) ((ApproximateScoreQuery) query).getOriginalQuery()).getIndexQuery().toString();  
        );
                queryL,
        assertTrue(query instanceof ApproximateScoreQuery);
        // Test 4: Range query excluding the value should not find it
            false,
            0.1 + randomDouble() * 100,
        );  
            // Use the same rounding logic for query bounds as used in indexing  
                queryL = scaledL / ft.getScalingFactor();
            "scaled_float",  
        // Test 1: Term query should find the exact document
        }
        Query rangeQ = ft.rangeQuery(79.0, 80.0, true, true, MOCK_QSC);
            false,
        long scaledValue2 = Math.round(value2 * ft.getScalingFactor());
        Directory dir = newDirectory();
        assertEquals("scaled_float:[-9223372036854775808 TO 10]", getQueryString(scaledFloatQ));
            Double l = randomBoolean() ? null : (randomDouble() * 2 - 1) * 10000;
            false,
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
        assertEquals(10 / ft.getScalingFactor(), ft.valueForDisplay(10L));  
        assertTrue(indexedWithDocValues.isSearchable());  
        assertEquals("Terms query should find both documents", 2, searcher.count(termsQuery));
        Document doc = new Document();
            true,
        IndexSettings pluggable = IndexSettingsModule.newIndexSettings(
        Document doc = new Document();
            boolean includeLower = randomBoolean();  
            true,  
        assertEquals("scaled_float:[-8 TO 9223372036854775807]", getQueryString(scaledFloatQ));
import org.opensearch.index.fielddata.SortedNumericDoubleValues;  
 * SPDX-License-Identifier: Apache-2.0
            if (u != null) {
            );
 * KIND, either express or implied.  See the License for the
        // searching doubles that are rounded to the closest half float
        assertEquals("scaled_float:[-9223372036854775808 TO 10]", getQueryString(scaledFloatQ));  
    public void testTermsQuery() {
            null
            false,
        double value1 = (randomDouble() * 2 - 1) * 10000;
                long scaledU = Math.round(u * ft.getScalingFactor());
            Collections.emptyMap(),  
            SortedNumericDoubleValues values = leafFieldData.getDoubleValues();  
        assertTrue(indexedWithDocValues.isSearchableViaDocValues(pluggable));
    }
            Double u = randomBoolean() ? null : (randomDouble() * 2 - 1) * 10000;
    public void testFetchSourceValue() throws IOException {
        assertTrue(indexedWithDocValues.isSearchableViaDocValues(normal));
        assertEquals(Collections.singletonList(3.14), fetchSourceValue(mapper, 3.1415926));  
        Query dvQuery = SortedNumericDocValuesField.newSlowExactQuery("scaled_float", scaledValue);
                "scaled_float2",
        // Exact range should find it
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType(
 * not use this file except in compliance with the License.
import org.apache.lucene.search.IndexOrDocValuesQuery;  
                true,
    }
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));  
        );
                .build(null, null);
import org.opensearch.index.fielddata.LeafNumericFieldData;
        Directory dir = newDirectory();
        doc.add(new SortedNumericDocValuesField("scaled_float", scaledValue));
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        }  
            false,
import org.apache.lucene.index.DirectoryReader;  
        IOUtils.close(reader, dir);  
        double largeValue = 92233720368547750.0;
            );  
        DirectoryReader reader = DirectoryReader.open(w);
    /** Still searchable from doc values when the index uses a pluggable data format. */
            Collections.emptyMap(),
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));  
        assertEquals(1, searcher.count(rangeQ));  
/*  
                scalingFactor
        doc.add(new LongPoint("scaled_float", scaledValue));
            false,
        assertNull(ft.valueForDisplay(null));
        assertEquals(Collections.emptyList(), fetchSourceValue(mapper, ""));
            Double queryL = l;
    public void testFieldData() throws IOException {  
            "scaled_float",
            100,
public class ScaledFloatFieldTypeTests extends FieldTypeTestCase {
        Query termQuery = ft.termQuery(largeValue, MOCK_QSC);  
        ScaledFloatFieldMapper.ScaledFloatFieldType unindexedWithDocValues = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        assertEquals("scaled_float:[-9223372036854775808 TO 11]", getQueryString(scaledFloatQ));
            boolean includeUpper = randomBoolean();
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType(  
        Query exclusiveRangeQuery = ft.rangeQuery(largeValue, largeValue + 1, false, false, MOCK_QSC);  
import org.apache.lucene.index.IndexWriterConfig;
            false,  
        assertFalse(unindexedWithDocValues.isSearchable());
            assertEquals(expectedCount, scaledCount);
        scaledFloatQ = ft.rangeQuery(-0.095, null, true, true, MOCK_QSC);
 *
        );
import org.apache.lucene.search.Query;
        scaledFloatQ = ft.rangeQuery(-0.1, null, true, true, MOCK_QSC);
        IndexSearcher searcher = newSearcher(reader);
            double rounded = scaledValue / ft.getScalingFactor();
            "pluggable",  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        Document doc = new Document();
        double scalingFactor = 0.1 + randomDouble() * 100;
        assertEquals(query, ft.termQuery(value, null));
import org.apache.lucene.document.SortedNumericDocValuesField;
        scaledFloatQ = ft.rangeQuery(null, 0.095, true, false, MOCK_QSC);  
            true,  
        w.close();
            // ft.getScalingFactor() + " expected= "+ expectedCount + " count= " + scaledCount);  
        assertEquals("scaled_float:[-10 TO 9223372036854775807]", getQueryString(scaledFloatQ));
        Document doc2 = new Document();
        assertEquals("Exact range query should find the document", 1, searcher.count(exactRangeQuery));
        assertEquals("scaled_float:[-10 TO 9223372036854775807]", getQueryString(scaledFloatQ));
        doc.add(new SortedNumericDocValuesField("scaled_float1", 10));
        assertEquals(LongField.newSetQuery("scaled_float", scaledValue1, scaledValue2), ft.termsQuery(Arrays.asList(value1, value2), null));
            "scaled_float",
    public void testLargeNumberIndexingAndQuerying() throws IOException {
 * GitHub history for details.
import org.apache.lucene.store.Directory;  
            true,  
        doc.add(new LongPoint("scaled_float", scaledValue));
        // An indexed field is searchable via the isSearchable() short-circuit, regardless of index settings.
        assertEquals("scaled_float:[-9223372036854775808 TO 9]", getQueryString(scaledFloatQ));
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType("scaled_float", 100);
        scaledFloatQ = ft.rangeQuery(-0.095, null, false, true, MOCK_QSC);  
    public void testRoundsUpperBoundCorrectly() {  
        // make sure the accuracy loss of scaled floats only occurs at index time  
        assertFalse(unindexedWithDocValues.isSearchableViaDocValues(null));
            doubles[i] = rounded;  
        long scaledValue2 = Math.round(otherValue * scalingFactor);
            // multi-valued
    private String getQueryString(Query query) {
 * You may obtain a copy of the License at  
        scaledFloatQ = ft.rangeQuery(-0.105, null, true, true, MOCK_QSC);  
            scaled_floats[i] = scaledValue;
        assertEquals("price:[-9223372036854775808 TO 1999]", getQueryString(q));
            );  
    }
            Query doubleQ = NumberFieldMapper.NumberType.DOUBLE.rangeQuery(  
    }
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType(  
    public void testRangeQuery() throws IOException {
        q = ft.rangeQuery(null, 9.99, true, true, MOCK_QSC);
        long[] scaled_floats = new long[1000];  
            ScaledFloatFieldMapper.ScaledFloatFieldType f2 = new ScaledFloatFieldMapper.ScaledFloatFieldType(  
    }  
    public void testRandomPriceValues() {
        // Add another doc with a different value to ensure we're finding the right one
        Query exactRangeQuery = ft.rangeQuery(largeValue, largeValue, true, true, MOCK_QSC);  
package org.opensearch.index.mapper;
 * software distributed under the License is distributed on an
            null  
            }
        assertEquals("scaled_float:[-9223372036854775808 TO 10]", getQueryString(scaledFloatQ));
 * Licensed to Elasticsearch under one or more contributor  
            Collections.emptyMap(),
    public void testIsSearchableForFieldCapsOnPluggableIndex() {  
 * specific language governing permissions and limitations
        final DirectoryReader reader = DirectoryReader.open(w);
    public void testIndexingQueryingConsistency() throws IOException {  
        ScaledFloatFieldMapper.ScaledFloatFieldType ft = new ScaledFloatFieldMapper.ScaledFloatFieldType(
        assertFalse(unindexedWithDocValues.isSearchableViaDocValues(normal));  
                "index",
        q = ft.rangeQuery(null, 99.99, true, true, MOCK_QSC);  
            double value = (randomDouble() * 2 - 1) * 10000;
        final int numDocs = 1000;
        assertEquals("scaled_float:[-9 TO 9223372036854775807]", getQueryString(scaledFloatQ));  
    }
        assertEquals("scaled_float:[-9 TO 9223372036854775807]", getQueryString(scaledFloatQ));  
        doc.add(new SortedNumericDocValuesField("scaled_float2", 5));  
        Directory dir = newDirectory();
            assertTrue(values.advanceExact(0));
        Query rangeQuery = ft.rangeQuery(largeValue - 1, largeValue + 1, true, true, MOCK_QSC);  
 *
        long scaledValue = Math.round(value * ft.getScalingFactor());
        assertEquals("scaled_float:[-9223372036854775808 TO 7999]", getQueryString(scaledFloatQ));  
            false,
            assertEquals(fielddata.getNumericType(), IndexNumericFieldData.NumericType.DOUBLE);
    }  
import org.apache.lucene.document.LongPoint;
            .build(context)  
        }
import org.opensearch.test.IndexSettingsModule;
            false,  
 *  
import org.opensearch.search.approximate.ApproximateScoreQuery;
            int scaledCount = searcher.count(scaledFloatQ);  
