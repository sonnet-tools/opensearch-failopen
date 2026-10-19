        Document d = new Document();
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        }  
import org.apache.lucene.document.Document;  
            writer.addDocument(d);  
import java.util.List;
 * not use this file except in compliance with the License.
            assertMissing(fieldValues, 1);
        fillMultiValueWithMissing();  
    }
 * software distributed under the License is distributed on an
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));  
 * license agreements. See the NOTICE file distributed with
            d.add(new StringField("_id", i + "", Field.Store.NO));
    protected void add2SingleValuedDocumentsAndDeleteOneOfThem() throws Exception {  
        // d.add(new StringField("value", one(), Field.Store.NO)); // MISSING....  
    }
    }
 * Basic Unit Test for GeoPointField data  
        Document d = new Document();
import org.apache.lucene.document.StringField;
        List<LeafReaderContext> readerContexts = refreshReader();  
        d.add(new StringField("_id", "3", Field.Store.NO));
 * The OpenSearch Contributors require contributions made to  
        writer.deleteDocuments(new Term("_id", "1"));
        writer.addDocument(d);
    }  
        writer.addDocument(d);  
                d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        List<LeafReaderContext> readerContexts = refreshReader();
            assertValues(fieldValues, 2);
            assertValues(fieldValues, 0);  
    }
        d = new Document();
    protected void fillMultiValueWithMissing() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
        d = new Document();
        return "geo_point";
            int maxVals = randomInt(5);
        }
        d.add(new StringField("_id", "3", Field.Store.NO));
        Document d = new Document();
    protected void fillSingleValueAllSet() throws Exception {
    @Override  
        d = new Document();
        d.add(new StringField("_id", "3", Field.Store.NO));
            MultiGeoPointValues fieldValues = ((AbstractLeafGeoPointFieldData) fieldData).getGeoPointValues();
            assertValues(fieldValues, 2);  
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
    }  
        d = new Document();  
    @Override
import org.apache.lucene.index.Term;
        writer.addDocument(d);  
        writer.addDocument(d);  
 * compatible open source license.
 */
 */
    protected void fillSingleValueWithMissing() throws Exception {
        IndexFieldData<?> indexFieldData = getForField("value");
 * Licensed to Elasticsearch under one or more contributor  
        }
public class GeoFieldDataTests extends AbstractGeoFieldDataTestCase {  
 *
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        }
 * GitHub history for details.
        writer.commit();  
 *  
        writer.addDocument(d);
 *     http://www.apache.org/licenses/LICENSE-2.0
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        List<LeafReaderContext> readerContexts = refreshReader();
            LeafFieldData fieldData = indexFieldData.load(readerContext);
    public void testMultiValueWithMissing() throws Exception {
import org.apache.lucene.document.Field;
    }  
        List<LeafReaderContext> readerContexts = refreshReader();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));  
            assertValues(fieldValues, 1);
        d = new Document();  
    @Override  
        fillSingleValueWithMissing();
        d.add(new StringField("_id", "3", Field.Store.NO));
    @Override
            if (randomBoolean()) {
    protected void fillExtendedMvSet() throws Exception {
            for (int v = 0; v < maxVals; ++v) {  
    }
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
    public void testMultiValueAllSet() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));  
        }  
/*  
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));  
        writer.addDocument(d);
        writer.addDocument(d);
 * You may obtain a copy of the License at  
    protected void fillMultiValueAllSet() throws Exception {
        d = new Document();
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        Document d;  
        for (LeafReaderContext readerContext : readerContexts) {  
    @Override
    }
        IndexFieldData<?> indexFieldData = getForField("value");
import org.opensearch.index.fielddata.plain.AbstractLeafGeoPointFieldData;
 * this file be licensed under the Apache-2.0 license or a
            MultiGeoPointValues fieldValues = ((AbstractLeafGeoPointFieldData) fieldData).getGeoPointValues();
    @Override
/*
    }
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.YES));
        d.add(new StringField("_id", "2", Field.Store.NO));  
            MultiGeoPointValues fieldValues = ((AbstractLeafGeoPointFieldData) fieldData).getGeoPointValues();  
    @Override
}
 */  
 * this work for additional information regarding copyright
        writer.addDocument(d);
            d = new Document();  
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));  
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
        Document d = new Document();
        // missing
            LeafFieldData fieldData = indexFieldData.load(readerContext);
        for (LeafReaderContext readerContext : readerContexts) {
        d.add(new StringField("_id", "1", Field.Store.NO));  
        Document d = new Document();
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
 * KIND, either express or implied.  See the License for the
            assertValues(fieldValues, 0);  
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
        for (LeafReaderContext readerContext : readerContexts) {
        d = new Document();  
 * ownership. Elasticsearch licenses this file to you under  
        d = new Document();
        fillMultiValueAllSet();
 * Unless required by applicable law or agreed to in writing,
        writer.addDocument(d);
    }
 *
 * under the License.  
package org.opensearch.index.fielddata;
        writer.addDocument(d);
    @Override  
            assertValues(fieldValues, 0);
        d.add(new StringField("_id", "1", Field.Store.NO));  
            LeafFieldData fieldData = indexFieldData.load(readerContext);
        final int maxDocs = randomInt(10);
        d.add(new StringField("_id", "2", Field.Store.NO));
            MultiGeoPointValues fieldValues = ((AbstractLeafGeoPointFieldData) fieldData).getGeoPointValues();
        d.add(new StringField("_id", "1", Field.Store.NO));
            assertMissing(fieldValues, 1);
    public void testSingleValueAllSet() throws Exception {
        writer.addDocument(d);  
 * todo include backcompat testing - see ISSUE #14562
import org.apache.lucene.index.LeafReaderContext;  
    public void testSingleValueWithMissing() throws Exception {  
            }  
        d.add(new StringField("_id", "2", Field.Store.NO));
        d.add(randomGeoPointField(FIELD_NAME, Field.Store.NO));
            assertValues(fieldValues, 2);
        IndexFieldData<?> indexFieldData = getForField("value");
        writer.addDocument(d);
        for (int i = 0; i < maxDocs; ++i) {
        writer.addDocument(d);
    @Override  
        d.add(new StringField("_id", "1", Field.Store.NO));  
                writer.commit();
    protected String getFieldDataType() {
            assertValues(fieldValues, 1);  
        d.add(new StringField("_id", "2", Field.Store.NO));  
    private static String FIELD_NAME = "value";
            assertValues(fieldValues, 0);
        d = new Document();
 * specific language governing permissions and limitations
 */
        writer.addDocument(d);
            assertValues(fieldValues, 2);
            }
/*
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
/**
            LeafFieldData fieldData = indexFieldData.load(readerContext);  
        d.add(new StringField("_id", "2", Field.Store.NO));
 * Modifications Copyright OpenSearch Contributors. See  
        fillSingleValueAllSet();  
    @Override  
        for (LeafReaderContext readerContext : readerContexts) {  
    @Override
        d.add(new StringField("_id", "1", Field.Store.NO));  
        IndexFieldData<?> indexFieldData = getForField("value");  
