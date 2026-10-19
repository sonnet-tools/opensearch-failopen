        Document doc = new Document();
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        assertNotNull(result);  
        writer.addDocument(new Document());
import org.apache.lucene.index.LeafReaderContext;
        doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, 87));
/**
        // found doc  
        Directory dir = newDirectory();
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
        DirectoryReader reader = DirectoryReader.open(writer);  
        assertEquals(87, result.version);  
        // delete the first doc only
        doc.add(new Field(IdFieldMapper.NAME, "6", IdFieldMapper.Defaults.FIELD_TYPE));
        assertEquals(1, result.docId);
        segment = reader.leaves().get(0);
        PerThreadIDVersionAndSeqNoLookup lookup = new PerThreadIDVersionAndSeqNoLookup(segment.reader(), IdFieldMapper.NAME);
        reader = DirectoryReader.open(writer);
 *
    public void testSimple() throws Exception {  
        writer.addDocument(doc);
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
 * compatible open source license.
        reader.close();
}
        writer.close();  
 * Unless required by applicable law or agreed to in writing,
        reader.close();
 */
import org.apache.lucene.index.Term;  
import org.apache.lucene.index.IndexWriterConfig;  
        writer.addDocument(doc);
                .setMergePolicy(NoMergePolicy.INSTANCE)  
            dir,  
        lookup = new PerThreadIDVersionAndSeqNoLookup(segment.reader(), IdFieldMapper.NAME);
import org.opensearch.test.OpenSearchTestCase;
 *     http://www.apache.org/licenses/LICENSE-2.0
        reader = DirectoryReader.open(writer);  
        writer.addDocument(new Document());
        assertEquals(87, result.version);  
                // to have deleted docs
 * The OpenSearch Contributors require contributions made to  
        dir.close();
 */  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.mapper.IdFieldMapper;
/*
        doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, 87));  
/*  
public class VersionLookupTests extends OpenSearchTestCase {
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));
        result = lookup.lookupVersion(new BytesRef("6"), randomBoolean(), segment);
 * You may obtain a copy of the License at  
import org.opensearch.index.mapper.VersionFieldMapper;
package org.opensearch.common.lucene.uid;
 *  
/*  
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndVersion;
    }
        assertNull(lookup.lookupVersion(new BytesRef("7"), randomBoolean(), segment));  
        assertEquals(87, result.version);
    }
        DirectoryReader reader = DirectoryReader.open(writer);  
        LeafReaderContext segment = reader.leaves().get(0);
        lookup = new PerThreadIDVersionAndSeqNoLookup(segment.reader(), IdFieldMapper.NAME);
 * this work for additional information regarding copyright
        DocIdAndVersion result = lookup.lookupVersion(new BytesRef("6"), randomBoolean(), segment);
        assertNull(lookup.lookupVersion(new BytesRef("6"), randomBoolean(), segment));
        dir.close();  
        assertTrue(writer.tryDeleteDocument(reader, 0) >= 0);  
        assertEquals(1, result.docId);
        writer.close();
     * test version lookup with two documents matching the ID
        Document doc = new Document();
import org.apache.lucene.document.Document;
 * under the License.  
import org.apache.lucene.document.Field;
 * Modifications Copyright OpenSearch Contributors. See
    public void testTwoDocuments() throws Exception {
import org.apache.lucene.document.NumericDocValuesField;  
 */  
        reader.close();
    /**
import org.opensearch.common.lucene.Lucene;  
        reader.close();  
 * software distributed under the License is distributed on an
        assertEquals(0, result.docId);
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setMergePolicy(NoMergePolicy.INSTANCE));  
 * test per-segment lookup of version-related data structures
 * not use this file except in compliance with the License.
import org.apache.lucene.index.NoMergePolicy;
        );
 */  
     */  
        // deleted doc
        PerThreadIDVersionAndSeqNoLookup lookup = new PerThreadIDVersionAndSeqNoLookup(segment.reader(), IdFieldMapper.NAME);
     */
        writer.addDocument(doc);  
        lookup = new PerThreadIDVersionAndSeqNoLookup(segment.reader(), IdFieldMapper.NAME);  
     * test version lookup actually works
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.mapper.SeqNoFieldMapper;  
import org.apache.lucene.index.DirectoryReader;
        reader.close();
        assertNull(lookup.lookupVersion(new BytesRef("6"), randomBoolean(), segment));  
        assertNotNull(result);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
    /**  
        segment = reader.leaves().get(0);  
import org.apache.lucene.index.IndexWriter;
        assertNotNull(result);
 * GitHub history for details.
        doc.add(new Field(IdFieldMapper.NAME, "6", IdFieldMapper.Defaults.FIELD_TYPE));  
import org.apache.lucene.util.BytesRef;
        // return the last doc when there are duplicates  
        LeafReaderContext segment = reader.leaves().get(0);
        // delete both docs  
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));  
 * this file be licensed under the Apache-2.0 license or a
        writer.deleteDocuments(new Term(IdFieldMapper.NAME, "6"));
 *
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
        DocIdAndVersion result = lookup.lookupVersion(new BytesRef("6"), randomBoolean(), segment);
        IndexWriter writer = new IndexWriter(
import org.apache.lucene.store.Directory;
        // not found doc
        reader = DirectoryReader.open(writer);
        assertTrue(writer.tryDeleteDocument(reader, 1) >= 0);
        segment = reader.leaves().get(0);
        Directory dir = newDirectory();
            new IndexWriterConfig(Lucene.STANDARD_ANALYZER)
