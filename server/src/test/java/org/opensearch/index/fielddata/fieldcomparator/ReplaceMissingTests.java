 * not use this file except in compliance with the License.
        assertEquals(2, raw.getValueCount());  
        LeafReader ar = getOnlyLeafReader(reader);
        assertEquals(0, dv.ordValue());  
        assertTrue(dv.advanceExact(0));  
        assertTrue(dv.advanceExact(2));
 */
        assertEquals(0, dv.ordValue());  
        assertEquals(1, dv.ordValue());
 *
import org.opensearch.test.OpenSearchTestCase;
        SortedDocValues raw = ar.getSortedDocValues("field");
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.index.DirectoryReader;  
        assertEquals("cat", dv.lookupOrd(0).utf8ToString());
 * license agreements. See the NOTICE file distributed with
/*
/*  
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.LeafReader;  
 * Unless required by applicable law or agreed to in writing,
/*  
    }
        assertEquals("dog", dv.lookupOrd(1).utf8ToString());
        assertEquals(0, dv.ordValue());
        raw = ar.getSortedDocValues("field");
        IndexWriterConfig iwc = newIndexWriterConfig(null);
 * You may obtain a copy of the License at  
        assertEquals("apple", dv.lookupOrd(0).utf8ToString());
        raw = ar.getSortedDocValues("field");
        doc.add(new SortedDocValuesField("field", new BytesRef("dog")));
        assertEquals(2, dv.ordValue());
 * compatible open source license.
 * specific language governing permissions and limitations
import org.apache.lucene.document.SortedDocValuesField;
import org.apache.lucene.index.IndexWriterConfig;
        DirectoryReader reader = DirectoryReader.open(dir);  
        IndexWriter iw = new IndexWriter(dir, iwc);  
        assertEquals(2, dv.ordValue());
import org.apache.lucene.util.BytesRef;  
        Document doc = new Document();
 * under the License.  
        assertEquals(1, dv.ordValue());
 *
 * ownership. Elasticsearch licenses this file to you under  
        iw.addDocument(doc);
        iw.addDocument(doc);
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index.fielddata.fieldcomparator;
        assertEquals(3, dv.getValueCount());  
        assertEquals(0, dv.ordValue());  
        SortedDocValues dv = new BytesRefFieldComparatorSource.ReplaceMissing(raw, new BytesRef("cat"));  
        assertTrue(dv.advanceExact(0));
        assertTrue(dv.advanceExact(1));
        assertTrue(dv.advanceExact(2));
        doc = new Document();  
        assertTrue(dv.advanceExact(1));
import org.apache.lucene.store.Directory;
        iw.forceMerge(1);  
        assertEquals(2, dv.getValueCount());
        assertEquals("cat", dv.lookupOrd(1).utf8ToString());  
        assertEquals("ebay", dv.lookupOrd(2).utf8ToString());
        assertTrue(dv.advanceExact(0));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        raw = ar.getSortedDocValues("field");  
        assertEquals("dog", dv.lookupOrd(1).utf8ToString());  
        assertTrue(dv.advanceExact(1));
 *  
        assertEquals(1, dv.ordValue());
        assertTrue(dv.advanceExact(0));
public class ReplaceMissingTests extends OpenSearchTestCase {  
        dv = new BytesRefFieldComparatorSource.ReplaceMissing(raw, new BytesRef("dog"));
        dir.close();  
        assertEquals(0, dv.ordValue());
 */  
        assertTrue(dv.advanceExact(2));  
 * GitHub history for details.
        Directory dir = newDirectory();  
        doc = new Document();  
        assertEquals("dog", dv.lookupOrd(2).utf8ToString());
 * software distributed under the License is distributed on an
        assertEquals("cat", dv.lookupOrd(0).utf8ToString());  
        iw.close();
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(1, dv.ordValue());  
        assertEquals(1, dv.ordValue());
        iwc.setMergePolicy(newLogMergePolicy());
        assertTrue(dv.advanceExact(0));
        assertEquals(1, dv.ordValue());  
        assertEquals(3, dv.getValueCount());
        assertEquals("dog", dv.lookupOrd(1).utf8ToString());
import org.apache.lucene.document.Document;
        assertEquals("cat", dv.lookupOrd(0).utf8ToString());  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(3, dv.getValueCount());
        assertEquals("dog", dv.lookupOrd(2).utf8ToString());  
        // existing values
        assertTrue(dv.advanceExact(2));
        assertEquals("company", dv.lookupOrd(1).utf8ToString());
        // non-existing values
        dv = new BytesRefFieldComparatorSource.ReplaceMissing(raw, new BytesRef("apple"));  
}
        assertTrue(dv.advanceExact(2));  
        assertEquals(2, dv.getValueCount());
 */  
        dv = new BytesRefFieldComparatorSource.ReplaceMissing(raw, new BytesRef("ebay"));
        assertEquals("cat", dv.lookupOrd(0).utf8ToString());
        iw.addDocument(doc);
        raw = ar.getSortedDocValues("field");  
        reader.close();
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
        assertEquals(0, dv.ordValue());
 * this file be licensed under the Apache-2.0 license or a
    public void test() throws Exception {
        assertEquals(2, dv.ordValue());
import org.apache.lucene.index.SortedDocValues;
        assertTrue(dv.advanceExact(1));  
 * this work for additional information regarding copyright
        assertTrue(dv.advanceExact(1));
        dv = new BytesRefFieldComparatorSource.ReplaceMissing(raw, new BytesRef("company"));
        doc.add(new SortedDocValuesField("field", new BytesRef("cat")));  
