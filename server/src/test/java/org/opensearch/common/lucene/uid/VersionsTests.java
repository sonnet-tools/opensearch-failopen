        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
            doc.add(new Field(IdFieldMapper.NAME, "1", IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
        version = Version.fromString("1.2.1");
    }
        Directory dir = newDirectory();
        // should increase cache size by 1
    /** Test that version map cache behaves properly with a filtered reader */
        assertEquals(87, loadDocIdAndVersion(reader, new Term(IdFieldMapper.NAME, "6"), randomBoolean(), null).version);
        doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, 87));
        assertEquals(87, loadDocIdAndVersion(wrapped, new Term(IdFieldMapper.NAME, "6"), randomBoolean(), null).version);
import static org.hamcrest.Matchers.equalTo;
 * not use this file except in compliance with the License.
        writer.close();
        Field version = new NumericDocValuesField(VersionFieldMapper.NAME, 2);
        assertEquals(VersionUtils.getPreviousVersion(Version.fromString("2.1.3")).luceneVersion, version.luceneVersion);
        directoryReader = reopen(directoryReader);
    public void testVersions() throws Exception {
    }
        reader.close();
        int size = VersionsAndSeqNoResolver.lookupStates.size();
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));
import java.util.List;
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null), nullValue());
        assertEquals(VersionUtils.getFirstVersion().luceneVersion.major - 1, version.luceneVersion.major);
        // test reuse of uid field
import org.apache.lucene.index.IndexWriter;
import org.opensearch.index.mapper.SeqNoFieldMapper;
import org.apache.lucene.index.DirectoryReader;
        assertEquals(size, VersionsAndSeqNoResolver.lookupStates.size());
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null), nullValue());
public class VersionsTests extends OpenSearchTestCase {
        DirectoryReader reader = DirectoryReader.open(writer);
    /** Test that version map cache works, is evicted on close, etc */
 * this work for additional information regarding copyright
 */
        Document doc = new Document();
import org.apache.lucene.store.Directory;
 * Licensed to Elasticsearch under one or more contributor
            reader.close();
            // Nested
        return newReader;
        doc.add(version);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.VersionUtils;
        DirectoryReader wrapped = OpenSearchDirectoryReader.wrap(reader, new ShardId("bogus", "_na_", 5));
        // same size map: core cache key is shared
        // Root
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
        docs.add(doc);
    public void testLuceneVersionOnUnknownVersions() {
        Directory dir = newDirectory();
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
            Document doc = new Document();
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
        directoryReader = reopen(directoryReader);
 * KIND, either express or implied.  See the License for the
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));
        doc = new Document();
        Document doc = new Document();
    }
        assertEquals(size + 1, VersionsAndSeqNoResolver.lookupStates.size());
        directoryReader = reopen(directoryReader);
        writer.close();
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null), nullValue());
    public void testNestedDocuments() throws IOException {
        DirectoryReader directoryReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "_na_", 1));
 *
    public static DirectoryReader reopen(DirectoryReader reader, boolean newReaderExpected) throws IOException {
        writer.updateDocument(new Term(IdFieldMapper.NAME, "1"), doc);
        doc.add(uid);
        Document doc = new Document();
import static org.hamcrest.Matchers.nullValue;
        directoryReader = reopen(directoryReader);
        doc.add(version);
        Directory dir = newDirectory();
        doc.add(new Field(IdFieldMapper.NAME, "1", IdFieldMapper.Defaults.FIELD_TYPE));
 * ownership. Elasticsearch licenses this file to you under
        dir.close();
/*
    }
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null).version, equalTo(2L));
        }
        version.setLongValue(3);
        doc.add(version);
        writer.close();
 * license agreements. See the NOTICE file distributed with
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, 87));
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        writer.updateDocument(new Term(IdFieldMapper.NAME, "1"), doc);
 * Modifications Copyright OpenSearch Contributors. See
        version = Version.fromString(Version.CURRENT.major + ".77.1");
        directoryReader.close();
import java.util.ArrayList;
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null).version, equalTo(7L));
        DirectoryReader directoryReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "_na_", 1));
        doc.add(new Field(IdFieldMapper.NAME, "6", IdFieldMapper.Defaults.FIELD_TYPE));
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
        DirectoryReader newReader = DirectoryReader.openIfChanged(reader);
        writer.addDocument(doc);
        assertEquals(87, loadDocIdAndVersion(reader, new Term(IdFieldMapper.NAME, "6"), randomBoolean(), null).version);
        writer.close();
        directoryReader = reopen(directoryReader);
        // between two known versions, should use the lucene version of the previous version
        List<Document> docs = new ArrayList<>();
 *
        assertEquals(87, loadDocIdAndVersion(reader, new Term(IdFieldMapper.NAME, "6"), randomBoolean(), null).version);
package org.opensearch.common.lucene.uid;
        version.setLongValue(6L);
        int size = VersionsAndSeqNoResolver.lookupStates.size();
        reader.close();
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
        // future version, should be the same version as today
        // core should be evicted from the map
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
 * the Apache License, Version 2.0 (the "License"); you may
    }
        doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, 1));
        return reopen(reader, true);
 * specific language governing permissions and limitations
    public void testCacheFilterReader() throws Exception {
        directoryReader = reopen(directoryReader);
    public void testCache() throws Exception {
        writer.addDocument(doc);
        DirectoryReader reader = DirectoryReader.open(writer);
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
        dir.close();
        writer.updateDocuments(new Term(IdFieldMapper.NAME, "1"), docs);
        dir.close();
 *     http://www.apache.org/licenses/LICENSE-2.0
        doc.add(uid);
        Field uid = new Field(IdFieldMapper.NAME, "1", IdFieldMapper.Defaults.FIELD_TYPE);
    }
        directoryReader.close();
 * The OpenSearch Contributors require contributions made to
        assertEquals(Version.CURRENT.luceneVersion, version.luceneVersion);
 */
import static org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.loadDocIdAndVersion;
    }
 * You may obtain a copy of the License at
import java.io.IOException;
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null).version, equalTo(1L));
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
        dir.close();
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, randomNonNegativeLong()));
import org.opensearch.index.mapper.IdFieldMapper;
            docs.add(doc);
        // core should be evicted from the map
        writer.updateDocuments(new Term(IdFieldMapper.NAME, "1"), docs);
import org.apache.lucene.document.NumericDocValuesField;
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null).version, equalTo(3L));
        Version version = Version.fromString("2.1.50");
 * software distributed under the License is distributed on an
        Document doc = new Document();
 * this file be licensed under the Apache-2.0 license or a
        doc = new Document();
        } else {
        assertThat(loadDocIdAndVersion(directoryReader, new Term(IdFieldMapper.NAME, "1"), randomBoolean(), null).version, equalTo(5L));
import org.apache.lucene.index.Term;
        NumericDocValuesField version = new NumericDocValuesField(VersionFieldMapper.NAME, 5L);
import org.opensearch.common.lucene.Lucene;
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));
        writer.deleteDocuments(new Term(IdFieldMapper.NAME, "1"));
import org.apache.lucene.index.IndexWriterConfig;
        // too old version, major should be the oldest supported lucene version minus 1
import org.opensearch.Version;
        assertEquals(size + 1, VersionsAndSeqNoResolver.lookupStates.size());
import org.opensearch.core.index.shard.ShardId;
        doc.add(new Field(IdFieldMapper.NAME, "6", IdFieldMapper.Defaults.FIELD_TYPE));
            assertFalse(newReaderExpected);
 *
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        // now wrap the reader
        assertEquals(size, VersionsAndSeqNoResolver.lookupStates.size());
        for (int i = 0; i < 4; ++i) {
        // should be cache hit
}
        version.setLongValue(7L);
import org.opensearch.index.mapper.VersionFieldMapper;
        writer.updateDocument(new Term(IdFieldMapper.NAME, "1"), doc);
/*
        writer.updateDocuments(new Term(IdFieldMapper.NAME, "1"), docs);
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        }
        if (newReader != null) {
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));
        assertEquals(size + 1, VersionsAndSeqNoResolver.lookupStates.size());
        Directory dir = newDirectory();
        doc.add(new Field(IdFieldMapper.NAME, "1", IdFieldMapper.Defaults.FIELD_TYPE));
import org.apache.lucene.document.Document;
        assertEquals(size + 1, VersionsAndSeqNoResolver.lookupStates.size());
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, randomLongBetween(1, Long.MAX_VALUE)));
 * under the License.
    public static DirectoryReader reopen(DirectoryReader reader) throws IOException {
import org.apache.lucene.document.Field;
        writer.deleteDocuments(new Term(IdFieldMapper.NAME, "1"));
/*
