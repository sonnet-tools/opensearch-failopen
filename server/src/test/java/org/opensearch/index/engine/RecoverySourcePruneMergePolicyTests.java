                                @Override
                                public int numDeletesToMerge(SegmentCommitInfo info) {
    public void testPruneAll() throws IOException {
            IndexWriterConfig iwc = newIndexWriterConfig();
 * under the License.
    public void testPruneNone() throws IOException {
                    if (i > 0 && randomBoolean()) {
 *
 * The OpenSearch Contributors require contributions made to
 * KIND, either express or implied.  See the License for the
                        assertEquals("source", document.getFields().get(0).name());
                try (DirectoryReader reader = DirectoryReader.open(writer)) {
                }
                        assertTrue(collect.contains("even"));
import org.apache.lucene.tests.util.NullInfoStream;
                                @Override
            iwc.setMergePolicy(new ShuffleForcedMergePolicy(mp));
                }
import org.apache.lucene.search.MatchNoDocsQuery;
                        assertEquals(1, document.getFields().size());
import org.apache.lucene.index.IndexableField;
                                    return info.info.maxDoc() - 1;
                        writer.flush();
 * specific language governing permissions and limitations
            try (IndexWriter writer = new IndexWriter(dir, iwc)) {
import org.apache.lucene.index.MergePolicy;
                    assertNotNull(extra_source);
import org.apache.lucene.index.CodecReader;
import org.apache.lucene.index.IndexWriterConfig;
package org.opensearch.index.engine;
                    if (i > 0 && randomBoolean()) {
                    doc.add(new StoredField("source", "hello world"));
            try (IndexWriter writer = new IndexWriter(dir, iwc)) {
                                public InfoStream getInfoStream() {
                }
            }
                        Set<String> collect = document.getFields().stream().map(IndexableField::name).collect(Collectors.toSet());
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
            iwc.setMergePolicy(
 * this work for additional information regarding copyright
                    StoredFields storedFields = reader.storedFields();
 * software distributed under the License is distributed on an
                    LeafReader leafReader = reader.leaves().get(0).reader();
                        );
                writer.commit();
    }
                MatchNoDocsQuery::new,
                    StoredFields storedFields = reader.storedFields();
import org.apache.lucene.index.SegmentInfos;
                try (DirectoryReader reader = DirectoryReader.open(writer)) {
                        }
import java.util.Set;
        }
                    Document doc = new Document();
                    assertEquals(DocIdSetIterator.NO_MORE_DOCS, extra_source.nextDoc());
                        MergePolicy.MergeSpecification forcedMerges = mp.findForcedDeletesMerges(
 * Licensed to Elasticsearch under one or more contributor
                                public int numDeletedDocs(SegmentCommitInfo info) {
/*
import java.io.IOException;
                        assertTrue(collect.contains("source"));
                    assertNotNull(extra_source);
                                }
                    NumericDocValues extra_source = reader.leaves().get(0).reader().getNumericDocValues("extra_source");
/*
            RecoverySourcePruneMergePolicy mp = new RecoverySourcePruneMergePolicy(
                    doc.add(new StoredField("extra_source", "hello world"));
                            assertTrue(collect.contains("extra_source"));
 *
                    }
                for (int i = 0; i < 20; i++) {
                        writer.flush();
                        SegmentInfos segmentInfos = sdr.getSegmentInfos();
                for (int i = 0; i < 20; i++) {
                writer.forceMerge(1);
import org.apache.lucene.index.Term;
                        assertEquals(i, extra_source.nextDoc());
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
                    }
                    }
 * Modifications Copyright OpenSearch Contributors. See
                        } else {
                    if (i > 0 && randomBoolean()) {
import org.apache.lucene.index.StandardDirectoryReader;
                    doc.add(new StoredField("source", "hello world"));
 * GitHub history for details.
                                }
                    NumericDocValues extra_source = reader.leaves().get(0).reader().getNumericDocValues("extra_source");
                    for (int i = 0; i < reader.maxDoc(); i++) {
                        CodecReader codecReader = (CodecReader) leafReader;
                "extra_source",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
                    doc.add(new StoredField("extra_source", "hello world"));
import org.apache.lucene.util.InfoStream;
                            }
}
 * the Apache License, Version 2.0 (the "License"); you may
                    doc.add(new StringField("even", Boolean.toString(i % 2 == 0), Field.Store.YES));
            IndexWriterConfig iwc = newIndexWriterConfig();
import org.apache.lucene.store.Directory;
 * Unless required by applicable law or agreed to in writing,
/*
import org.apache.lucene.document.Document;
            );
import java.util.stream.Collectors;
                                }
                new RecoverySourcePruneMergePolicy("extra_source", () -> new TermQuery(new Term("even", "true")), iwc.getMergePolicy())
    }
                    writer.addDocument(doc);
                            assertEquals(2, document.getFields().size());
        try (Directory dir = newDirectory()) {
                    writer.addDocument(doc);
                    NumericDocValues extra_source = leafReader.getNumericDocValues("extra_source");
                                    return info.info.maxDoc() - 1;
import org.apache.lucene.index.StoredFields;
                    StoredFields storedFields = reader.storedFields();
                        assertSame(codecReader, forcedMerges.merges.get(0).wrapForMerge(codecReader));
                    writer.addDocument(doc);
                    }
        try (Directory dir = newDirectory()) {
                    if (leafReader instanceof CodecReader && reader instanceof StandardDirectoryReader) {
            }
 */
                    doc.add(new NumericDocValuesField("extra_source", 1));
                writer.forceMerge(1);
                    doc.add(new NumericDocValuesField("extra_source", 1));
                for (int i = 0; i < 20; i++) {
        }
import org.opensearch.test.OpenSearchTestCase;
                                }
                    }
                            assertEquals("true", document.getField("even").stringValue());
                    Document doc = new Document();
                            segmentInfos,
import org.apache.lucene.index.LeafReader;
 * compatible open source license.
import org.apache.lucene.index.DirectoryReader;
                        assertEquals(DocIdSetIterator.NO_MORE_DOCS, extra_source.nextDoc());
import org.apache.lucene.document.NumericDocValuesField;
                                    return new NullInfoStream();
                writer.commit();
                                @Override
            );
 * license agreements. See the NOTICE file distributed with
                        Document document = storedFields.document(i);
 * ownership. Elasticsearch licenses this file to you under
                newLogMergePolicy()
                            new MergePolicy.MergeContext() {
                    assertEquals(DocIdSetIterator.NO_MORE_DOCS, extra_source.nextDoc());
            }
                    for (int i = 0; i < reader.maxDoc(); i++) {
                        assertTrue(collect.contains("source"));
import org.apache.lucene.search.TermQuery;
                    doc.add(new NumericDocValuesField("extra_source", 1));
                                @Override
                    }
                    assertEquals(1, reader.leaves().size());
    public void testPruneSome() throws IOException {
        try (Directory dir = newDirectory()) {
                }
                writer.commit();
                        Set<String> collect = document.getFields().stream().map(IndexableField::name).collect(Collectors.toSet());
                        StandardDirectoryReader sdr = (StandardDirectoryReader) reader;
import org.apache.lucene.index.IndexWriter;
                    assertEquals(1, reader.leaves().size());
            iwc.setMergePolicy(new RecoverySourcePruneMergePolicy("extra_source", () -> new MatchAllDocsQuery(), iwc.getMergePolicy()));
                    Document doc = new Document();
import org.apache.lucene.document.Field;
import org.apache.lucene.index.SegmentCommitInfo;
                                    return Collections.emptySet();
        }
                        writer.flush();
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
                    doc.add(new StoredField("extra_source", "hello world"));
                    }
                    }
                    assertEquals(1, reader.leaves().size());
                    for (int i = 0; i < reader.maxDoc(); i++) {
                        assertTrue(collect.contains("extra_source"));
                            assertEquals(i, extra_source.nextDoc());
                    if (extra_source != null) {
                                public Set<SegmentCommitInfo> getMergingSegments() {
import org.apache.lucene.search.DocIdSetIterator;
                writer.forceMerge(1);
    }
                try (DirectoryReader reader = DirectoryReader.open(writer)) {
public class RecoverySourcePruneMergePolicyTests extends OpenSearchTestCase {
                        Document document = storedFields.document(i);
                        // don't wrap if there is nothing to do
 * not use this file except in compliance with the License.
                        Document document = storedFields.document(i);
            try (IndexWriter writer = new IndexWriter(dir, iwc)) {
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.MatchAllDocsQuery;
 */
import org.apache.lucene.index.NumericDocValues;
            IndexWriterConfig iwc = newIndexWriterConfig();
                    doc.add(new StoredField("source", "hello world"));
                }
                        if (collect.size() == 3) {
 */
                }
