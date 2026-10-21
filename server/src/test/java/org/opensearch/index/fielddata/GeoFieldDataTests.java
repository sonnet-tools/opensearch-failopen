 * Unless required by applicable law or agreed to in writing,
        d = new Document();
                writer.commit();
            LeafFieldData fieldData = indexFieldData.load(readerContext);
 * this file be licensed under the Apache-2.0 license or a
    @Override
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
    }
    }
import org.opensearch.index.fielddata.plain.AbstractLeafGeoPointFieldData;
        final int maxDocs = randomInt(10);
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        }
            assertValues(fieldValues, 0);
        writer.addDocument(d);
        writer.addDocument(d);
            MultiGeoPointValues fieldValues = ((AbstractLeafGeoPointFieldData) fieldData).getGeoPointValues();
            assertValues(fieldValues, 0);
            assertValues(fieldValues, 1);
        d = new Document();
        writer.commit();
        for (int i = 0; i < maxDocs; ++i) {
 * not use this file except in compliance with the License.
        d = new Document();
/*
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
    @Override
        for (LeafReaderContext readerContext : readerContexts) {
        d = new Document();
            assertValues(fieldValues, 2);
        writer.addDocument(d);
        writer.addDocument(d);
import java.util.List;
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
 * specific language governing permissions and limitations
    protected void fillExtendedMvSet() throws Exception {
        Document d = new Document();
 * this work for additional information regarding copyright
    protected void fillMultiValueAllSet() throws Exception {
        writer.addDocument(d);
    @Override
            assertValues(fieldValues, 2);
 * software distributed under the License is distributed on an
        List<LeafReaderContext> readerContexts = refreshReader();
        for (LeafReaderContext readerContext : readerContexts) {
        }
            LeafFieldData fieldData = indexFieldData.load(readerContext);
        d.add(new StringField("_id", "1", Field.Store.NO));
            d = new Document();
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
 */
        d.add(new StringField("_id", "1", Field.Store.NO));
            MultiGeoPointValues fieldValues = ((AbstractLeafGeoPointFieldData) fieldData).getGeoPointValues();
        Document d = new Document();
 * GitHub history for details.
        fillMultiValueWithMissing();
        d.add(new StringField("_id", "2", Field.Store.NO));
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
 */
        return "geo_point";
    @Override
        List<LeafReaderContext> readerContexts = refreshReader();
    protected void fillSingleValueAllSet() throws Exception {
 * KIND, either express or implied.  See the License for the
    }
 * license agreements. See the NOTICE file distributed with
        Document d = new Document();
    }
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
            if (randomBoolean()) {
            }
        d.add(new StringField("_id", "3", Field.Store.NO));
            assertValues(fieldValues, 0);
        Document d;
        writer.deleteDocuments(new Term("_id", "1"));
        d.add(new StringField("_id", "3", Field.Store.NO));
    public void testMultiValueWithMissing() throws Exception {
        fillSingleValueAllSet();
/*
        fillSingleValueWithMissing();
    }
        List<LeafReaderContext> readerContexts = refreshReader();
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        d = new Document();
        IndexFieldData<?> indexFieldData = getForField("value");
    private static String FIELD_NAME = "value";
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        writer.addDocument(d);
            LeafFieldData fieldData = indexFieldData.load(readerContext);
        writer.addDocument(d);
    @Override
    }
        d.add(new StringField("_id", "1", Field.Store.NO));
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.YES));
        d = new Document();
            int maxVals = randomInt(5);
    public void testSingleValueWithMissing() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
            LeafFieldData fieldData = indexFieldData.load(readerContext);
        d.add(new StringField("_id", "2", Field.Store.NO));
public class GeoFieldDataTests extends AbstractGeoFieldDataTestCase {
    @Override
        // missing
        d = new Document();
 * You may obtain a copy of the License at
package org.opensearch.index.fielddata;
 * Licensed to Elasticsearch under one or more contributor
    }
    }
    protected String getFieldDataType() {
    }
            assertValues(fieldValues, 0);
 * the Apache License, Version 2.0 (the "License"); you may
    public void testMultiValueAllSet() throws Exception {
            for (int v = 0; v < maxVals; ++v) {
}
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.document.Field;
        d.add(new StringField("_id", "2", Field.Store.NO));
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
/**
                d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        }
 *
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        d.add(new StringField("_id", "3", Field.Store.NO));
        fillMultiValueAllSet();
            d.add(new StringField("_id", i + "", Field.Store.NO));
    @Override
    protected void fillMultiValueWithMissing() throws Exception {
        Document d = new Document();
    protected void fillSingleValueWithMissing() throws Exception {
            assertMissing(fieldValues, 1);
            assertValues(fieldValues, 1);
 */
        d = new Document();
        d = new Document();
            MultiGeoPointValues fieldValues = ((AbstractLeafGeoPointFieldData) fieldData).getGeoPointValues();
import org.apache.lucene.document.StringField;
            assertMissing(fieldValues, 1);
        writer.addDocument(d);
        d.add(new StringField("_id", "2", Field.Store.NO));
    protected void add2SingleValuedDocumentsAndDeleteOneOfThem() throws Exception {
        }
 * under the License.
import org.apache.lucene.index.Term;
    @Override
        writer.addDocument(d);
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
            writer.addDocument(d);
            assertValues(fieldValues, 2);
        for (LeafReaderContext readerContext : readerContexts) {
            assertValues(fieldValues, 2);
        for (LeafReaderContext readerContext : readerContexts) {
            MultiGeoPointValues fieldValues = ((AbstractLeafGeoPointFieldData) fieldData).getGeoPointValues();
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
            }
 *
        writer.addDocument(d);
    public void testSingleValueAllSet() throws Exception {
    }
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
    @Override
 * Basic Unit Test for GeoPointField data
    }
        IndexFieldData<?> indexFieldData = getForField("value");
    @Override
        // d.add(new StringField("value", one(), Field.Store.NO)); // MISSING....
        writer.addDocument(d);
        writer.addDocument(d);
 * todo include backcompat testing - see ISSUE #14562
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        IndexFieldData<?> indexFieldData = getForField("value");
 * SPDX-License-Identifier: Apache-2.0
 *
        d.add(new StringField("_id", "1", Field.Store.NO));
        d.add(new StringField("_id", "2", Field.Store.NO));
        d.add(new StringField("_id", "3", Field.Store.NO));
        Document d = new Document();
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
        IndexFieldData<?> indexFieldData = getForField("value");
        writer.addDocument(d);
 * ownership. Elasticsearch licenses this file to you under
        writer.addDocument(d);
/*
        }
        List<LeafReaderContext> readerContexts = refreshReader();
        d.add(new StringField("_id", "1", Field.Store.NO));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.document.Document;
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
 */
