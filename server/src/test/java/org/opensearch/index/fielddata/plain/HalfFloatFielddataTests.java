    public void testSingleValued() throws IOException {
        assertEquals(3f, values.nextValue(), 0f);
        }  
/*  
 * software distributed under the License is distributed on an
 */  
import org.apache.lucene.index.DirectoryReader;
 * under the License.  
package org.opensearch.index.fielddata.plain;
import org.apache.lucene.index.IndexWriter;  
        for (IndexableField f : NumberFieldMapper.NumberType.HALF_FLOAT.createFields("half_float", 3f, false, true, false, false)) {  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
        w.addDocument(doc);
 * SPDX-License-Identifier: Apache-2.0
 */
        SortedNumericDoubleValues values = new SortedNumericIndexFieldData.SortedNumericHalfFloatFieldData(reader, "half_float")  
    }  
    }
import java.io.IOException;  
        assertNull(FieldData.unwrapSingleton(values));  
 * You may obtain a copy of the License at  
        assertEquals(2f, values.nextValue(), 0f);  
        LeafReader reader = getOnlyLeafReader(dirReader);
 * Licensed to Elasticsearch under one or more contributor  
 */  
        }  
import org.apache.lucene.index.IndexWriterConfig;
        Directory dir = newDirectory();
        }
import org.opensearch.index.fielddata.FieldData;
 * this work for additional information regarding copyright
            .getDoubleValues();
        for (IndexableField f : NumberFieldMapper.NumberType.HALF_FLOAT.createFields("half_float", 3f, false, true, false, false)) {
        assertTrue(values.advanceExact(0));
        assertEquals(3f, values.nextValue(), 0f);
        final DirectoryReader dirReader = DirectoryReader.open(w);
 * the Apache License, Version 2.0 (the "License"); you may
            doc.add(f);
 *
        assertEquals(2, values.docValueCount());
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertNotNull(FieldData.unwrapSingleton(values));
import org.apache.lucene.index.IndexableField;
 *  
 * compatible open source license.
import org.apache.lucene.store.Directory;
        IOUtils.close(dirReader, w, dir);
 * not use this file except in compliance with the License.
            doc.add(f);
import org.apache.lucene.index.LeafReader;  
        // we need the default codec to check for singletons  
}
        Document doc = new Document();
        for (IndexableField f : NumberFieldMapper.NumberType.HALF_FLOAT.createFields("half_float", 2f, false, true, false, false)) {
        SortedNumericDoubleValues values = new SortedNumericIndexFieldData.SortedNumericHalfFloatFieldData(reader, "half_float")
    public void testMultiValued() throws IOException {  
import org.opensearch.test.OpenSearchTestCase;
public class HalfFloatFielddataTests extends OpenSearchTestCase {
        assertEquals(1, values.docValueCount());
        Directory dir = newDirectory();
 * GitHub history for details.
/*
        IOUtils.close(dirReader, w, dir);  
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null).setCodec(TestUtil.getDefaultCodec()));
            doc.add(f);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.util.io.IOUtils;  
 * license agreements. See the NOTICE file distributed with
/*  
        final DirectoryReader dirReader = DirectoryReader.open(w);
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
        LeafReader reader = getOnlyLeafReader(dirReader);  
 * specific language governing permissions and limitations
            .getDoubleValues();
import org.apache.lucene.tests.util.TestUtil;
import org.apache.lucene.document.Document;
        Document doc = new Document();  
        assertTrue(values.advanceExact(0));  
        w.addDocument(doc);  
 *
import org.opensearch.index.mapper.NumberFieldMapper;  
