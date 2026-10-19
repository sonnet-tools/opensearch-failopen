        // should increase cache size by 1
import org.opensearch.Version;
        DirectoryReader reader = DirectoryReader.open(writer);
        doc.add(new Field(IdFieldMapper.NAME, "6", IdFieldMapper.Defaults.FIELD_TYPE));
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
 * KIND, either express or implied.  See the License for the
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));  
        directoryReader = reopen(directoryReader);
import java.io.IOException;  
        assertEquals(size, VersionsAndSeqNoResolver.lookupStates.size());
        writer.close();  
        doc.add(version);
        directoryReader = reopen(directoryReader);
        DirectoryReader directoryReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "_na_", 1));  
        int size = VersionsAndSeqNoResolver.lookupStates.size();  
        Field uid = new Field(IdFieldMapper.NAME, "1", IdFieldMapper.Defaults.FIELD_TYPE);
        Directory dir = newDirectory();
        // Root  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
    }
import org.opensearch.test.VersionUtils;
 * this file be licensed under the Apache-2.0 license or a
        version.setLongValue(6L);
        doc.add(version);
    }  
        writer.close();
        reader.close();  
        DirectoryReader newReader = DirectoryReader.openIfChanged(reader);  
        doc = new Document();  
            reader.close();
        List<Document> docs = new ArrayList<>();
/*  
        Version version = Version.fromString("2.1.50");
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
        directoryReader.close();
        assertEquals(VersionUtils.getFirstVersion().luceneVersion.major - 1, version.luceneVersion.major);  
        directoryReader = reopen(directoryReader);  
    public void testLuceneVersionOnUnknownVersions() {
        doc.add(version);  
        // should be cache hit
        writer.updateDocument(new Term(IdFieldMapper.NAME, "1"), doc);  
        assertEquals(87, loadDocIdAndVersion(reader, new Term(IdFieldMapper.NAME, "6"), randomBoolean(), null).version);  
        writer.updateDocument(new Term(IdFieldMapper.NAME, "1"), doc);
        writer.addDocument(doc);  
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        DirectoryReader reader = DirectoryReader.open(writer);
    /** Test that version map cache works, is evicted on close, etc */
        dir.close();
        version = Version.fromString(Version.CURRENT.major + ".77.1");  
    }
        doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, 87));  
        assertEquals(size, VersionsAndSeqNoResolver.lookupStates.size());  
        assertEquals(Version.CURRENT.luceneVersion, version.luceneVersion);
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.nullValue;  
import org.apache.lucene.index.IndexWriter;
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
        directoryReader = reopen(directoryReader);  
        dir.close();
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null).version, equalTo(5L));
        NumericDocValuesField version = new NumericDocValuesField(VersionFieldMapper.NAME, 5L);  
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));
        reader.close();
 *
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
    }  
import org.opensearch.index.mapper.IdFieldMapper;  
        writer.addDocument(doc);  
 * not use this file except in compliance with the License.
        Field version = new NumericDocValuesField(VersionFieldMapper.NAME, 2);
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.index.Term;  
        writer.updateDocuments(new Term(IdFieldMapper.NAME, "1"), docs);
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null).version, equalTo(1L));
        // core should be evicted from the map  
    }
        doc.add(new Field(IdFieldMapper.NAME, "1", IdFieldMapper.Defaults.FIELD_TYPE));
            doc.add(new Field(IdFieldMapper.NAME, "1", IdFieldMapper.Defaults.NESTED_FIELD_TYPE));  
    public void testNestedDocuments() throws IOException {
        assertEquals(size + 1, VersionsAndSeqNoResolver.lookupStates.size());
            // Nested
        assertEquals(VersionUtils.getPreviousVersion(Version.fromString("2.1.3")).luceneVersion, version.luceneVersion);
        docs.add(doc);
        } else {  
    }
        dir.close();
        // now wrap the reader
import org.opensearch.core.index.shard.ShardId;
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
import org.apache.lucene.index.DirectoryReader;  
        assertEquals(87, loadDocIdAndVersion(reader, new Term(IdFieldMapper.NAME, "6"), randomBoolean(), null).version);  
        Document doc = new Document();
 */
    public static DirectoryReader reopen(DirectoryReader reader) throws IOException {
import org.apache.lucene.store.Directory;
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));
        Document doc = new Document();
 * compatible open source license.
/*
            assertFalse(newReaderExpected);
        }
        Directory dir = newDirectory();
 * under the License.  
 */
        return newReader;  
        doc.add(new Field(IdFieldMapper.NAME, "1", IdFieldMapper.Defaults.FIELD_TYPE));
        return reopen(reader, true);
        writer.deleteDocuments(new Term(IdFieldMapper.NAME, "1"));
        doc = new Document();  
import static org.hamcrest.Matchers.equalTo;
        writer.close();  
        doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, 87));  
 */  
        // test reuse of uid field
import java.util.ArrayList;
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null).version, equalTo(3L));  
        directoryReader = reopen(directoryReader);
}  
            docs.add(doc);
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
        version.setLongValue(3);
        version = Version.fromString("1.2.1");
    public static DirectoryReader reopen(DirectoryReader reader, boolean newReaderExpected) throws IOException {
    public void testVersions() throws Exception {  
        for (int i = 0; i < 4; ++i) {  
    /** Test that version map cache behaves properly with a filtered reader */
        assertEquals(87, loadDocIdAndVersion(reader, new Term(IdFieldMapper.NAME, "6"), randomBoolean(), null).version);
    public void testCache() throws Exception {
        doc.add(uid);
        DirectoryReader wrapped = OpenSearchDirectoryReader.wrap(reader, new ShardId("bogus", "_na_", 5));
    }
        writer.updateDocuments(new Term(IdFieldMapper.NAME, "1"), docs);  
        Directory dir = newDirectory();
 * Modifications Copyright OpenSearch Contributors. See  
package org.opensearch.common.lucene.uid;
 * You may obtain a copy of the License at  
import org.apache.lucene.document.Document;  
        assertEquals(87, loadDocIdAndVersion(wrapped, new Term(IdFieldMapper.NAME, "6"), randomBoolean(), null).version);  
import org.apache.lucene.index.IndexWriterConfig;
        writer.close();
        assertEquals(size + 1, VersionsAndSeqNoResolver.lookupStates.size());
        doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, 1));
 *
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));
/*
            Document doc = new Document();
        if (newReader != null) {
import org.opensearch.common.lucene.Lucene;  
        writer.updateDocuments(new Term(IdFieldMapper.NAME, "1"), docs);
 * SPDX-License-Identifier: Apache-2.0
        dir.close();
        assertEquals(size + 1, VersionsAndSeqNoResolver.lookupStates.size());
import static org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.loadDocIdAndVersion;
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null), nullValue());
 * software distributed under the License is distributed on an
        writer.deleteDocuments(new Term(IdFieldMapper.NAME, "1"));
        Directory dir = newDirectory();
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
        // too old version, major should be the oldest supported lucene version minus 1
        int size = VersionsAndSeqNoResolver.lookupStates.size();  
        Document doc = new Document();
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));
import org.opensearch.index.mapper.VersionFieldMapper;
        Document doc = new Document();  
import org.opensearch.index.mapper.SeqNoFieldMapper;
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null), nullValue());
public class VersionsTests extends OpenSearchTestCase {
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null).version, equalTo(7L));  
        }
        directoryReader = reopen(directoryReader);  
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
import org.apache.lucene.document.Field;
        directoryReader.close();
 * The OpenSearch Contributors require contributions made to  
        doc.add(new Field(IdFieldMapper.NAME, "6", IdFieldMapper.Defaults.FIELD_TYPE));
        // between two known versions, should use the lucene version of the previous version  
import org.opensearch.test.OpenSearchTestCase;  
        DirectoryReader directoryReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "_na_", 1));
 * license agreements. See the NOTICE file distributed with
        // core should be evicted from the map
        doc.add(uid);  
        version.setLongValue(7L);  
 * this work for additional information regarding copyright
        // future version, should be the same version as today
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(size + 1, VersionsAndSeqNoResolver.lookupStates.size());  
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null).version, equalTo(2L));  
        // same size map: core cache key is shared
 * the Apache License, Version 2.0 (the "License"); you may
        writer.updateDocument(new Term(IdFieldMapper.NAME, "1"), doc);
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null), nullValue());
    public void testCacheFilterReader() throws Exception {
 *  
