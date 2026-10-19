                try (DirectoryReader reader = DirectoryReader.open(writer)) {
                    doc.add(new StoredField("source", "hello world"));
                    Document doc = new Document();  
                                    return new NullInfoStream();
                    if (i > 0 && randomBoolean()) {  
                    }
                    if (i > 0 && randomBoolean()) {  
                            assertEquals(2, document.getFields().size());  
                                }
                        // don't wrap if there is nothing to do
/*  
                }  
                    Document doc = new Document();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
                            assertEquals("true", document.getField("even").stringValue());  
 * software distributed under the License is distributed on an
import org.apache.lucene.search.DocIdSetIterator;
                writer.commit();
                    for (int i = 0; i < reader.maxDoc(); i++) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
                        }
                    StoredFields storedFields = reader.storedFields();  
                        assertSame(codecReader, forcedMerges.merges.get(0).wrapForMerge(codecReader));  
                    assertEquals(1, reader.leaves().size());
                                public int numDeletedDocs(SegmentCommitInfo info) {
 * this work for additional information regarding copyright
                        Set<String> collect = document.getFields().stream().map(IndexableField::name).collect(Collectors.toSet());  
                    assertEquals(DocIdSetIterator.NO_MORE_DOCS, extra_source.nextDoc());
import java.util.Set;  
                    }  
                    doc.add(new StoredField("source", "hello world"));
    }
                    doc.add(new NumericDocValuesField("extra_source", 1));  
                        assertEquals(1, document.getFields().size());
import org.apache.lucene.document.StoredField;
                    doc.add(new StringField("even", Boolean.toString(i % 2 == 0), Field.Store.YES));
                            assertEquals(i, extra_source.nextDoc());
                            }  
                    StoredFields storedFields = reader.storedFields();
                for (int i = 0; i < 20; i++) {
}
import org.apache.lucene.index.SegmentInfos;  
                writer.commit();
                        assertEquals("source", document.getFields().get(0).name());
                for (int i = 0; i < 20; i++) {
            IndexWriterConfig iwc = newIndexWriterConfig();
                    NumericDocValues extra_source = reader.leaves().get(0).reader().getNumericDocValues("extra_source");
import org.apache.lucene.store.Directory;
 */
import org.apache.lucene.search.MatchNoDocsQuery;  
                    NumericDocValues extra_source = leafReader.getNumericDocValues("extra_source");  
                "extra_source",  
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.index.MergePolicy;  
                        assertEquals(i, extra_source.nextDoc());  
        try (Directory dir = newDirectory()) {  
                    StoredFields storedFields = reader.storedFields();
                        assertTrue(collect.contains("even"));  
                    }  
import org.apache.lucene.index.Term;  
 */  
                    LeafReader leafReader = reader.leaves().get(0).reader();
                    writer.addDocument(doc);
            );  
                                }
                        assertTrue(collect.contains("source"));
                MatchNoDocsQuery::new,
 * not use this file except in compliance with the License.
                                public Set<SegmentCommitInfo> getMergingSegments() {  
import org.apache.lucene.util.InfoStream;
            );  
 * SPDX-License-Identifier: Apache-2.0
                        assertTrue(collect.contains("extra_source"));
                                    return info.info.maxDoc() - 1;  
                    }
                }
                }
 * specific language governing permissions and limitations
                        if (collect.size() == 3) {
                    assertNotNull(extra_source);
                    }
                    Document doc = new Document();
                        MergePolicy.MergeSpecification forcedMerges = mp.findForcedDeletesMerges(
            }
                }  
            iwc.setMergePolicy(new ShuffleForcedMergePolicy(mp));
                new RecoverySourcePruneMergePolicy("extra_source", () -> new TermQuery(new Term("even", "true")), iwc.getMergePolicy())
    }  
 *
import org.apache.lucene.index.CodecReader;  
            IndexWriterConfig iwc = newIndexWriterConfig();  
                    doc.add(new StoredField("extra_source", "hello world"));  
                    NumericDocValues extra_source = reader.leaves().get(0).reader().getNumericDocValues("extra_source");  
                    assertEquals(DocIdSetIterator.NO_MORE_DOCS, extra_source.nextDoc());  
/*  
import org.apache.lucene.index.NumericDocValues;
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
                        writer.flush();
                }  
                                }
import org.apache.lucene.index.LeafReader;
                writer.forceMerge(1);
import org.apache.lucene.index.IndexWriterConfig;  
                    assertNotNull(extra_source);  
import java.io.IOException;
                    writer.addDocument(doc);
import org.apache.lucene.index.DirectoryReader;
                                public int numDeletesToMerge(SegmentCommitInfo info) {  
                        CodecReader codecReader = (CodecReader) leafReader;
import org.apache.lucene.document.Field;
 * Modifications Copyright OpenSearch Contributors. See
        }
import org.apache.lucene.document.Document;
                        Document document = storedFields.document(i);  
import org.apache.lucene.index.IndexWriter;
                try (DirectoryReader reader = DirectoryReader.open(writer)) {  
                        StandardDirectoryReader sdr = (StandardDirectoryReader) reader;  
 * compatible open source license.
            iwc.setMergePolicy(new RecoverySourcePruneMergePolicy("extra_source", () -> new MatchAllDocsQuery(), iwc.getMergePolicy()));  
                        } else {
import org.apache.lucene.document.StringField;
            }  
    public void testPruneSome() throws IOException {
                        writer.flush();
                        Document document = storedFields.document(i);  
 * Unless required by applicable law or agreed to in writing,
                newLogMergePolicy()
                                @Override
                writer.forceMerge(1);  
                    doc.add(new NumericDocValuesField("extra_source", 1));
                writer.forceMerge(1);
                    assertEquals(1, reader.leaves().size());
                        Set<String> collect = document.getFields().stream().map(IndexableField::name).collect(Collectors.toSet());
                    if (leafReader instanceof CodecReader && reader instanceof StandardDirectoryReader) {
                            new MergePolicy.MergeContext() {
import org.apache.lucene.index.SegmentCommitInfo;
                    assertEquals(1, reader.leaves().size());
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
                try (DirectoryReader reader = DirectoryReader.open(writer)) {  
                    doc.add(new StoredField("extra_source", "hello world"));
package org.opensearch.index.engine;
                }
            IndexWriterConfig iwc = newIndexWriterConfig();
                        );
            RecoverySourcePruneMergePolicy mp = new RecoverySourcePruneMergePolicy(
                    for (int i = 0; i < reader.maxDoc(); i++) {
                            assertTrue(collect.contains("extra_source"));
 */  
                        writer.flush();
                        Document document = storedFields.document(i);
                                    return info.info.maxDoc() - 1;
            try (IndexWriter writer = new IndexWriter(dir, iwc)) {
                    if (extra_source != null) {
 *
import org.apache.lucene.search.MatchAllDocsQuery;
            try (IndexWriter writer = new IndexWriter(dir, iwc)) {
                    doc.add(new StoredField("extra_source", "hello world"));  
import org.apache.lucene.tests.util.NullInfoStream;  
                    doc.add(new StoredField("source", "hello world"));
 * this file be licensed under the Apache-2.0 license or a
            try (IndexWriter writer = new IndexWriter(dir, iwc)) {
                                @Override
            iwc.setMergePolicy(
                                public InfoStream getInfoStream() {
                    doc.add(new NumericDocValuesField("extra_source", 1));
                                }  
 * GitHub history for details.
                        assertEquals(DocIdSetIterator.NO_MORE_DOCS, extra_source.nextDoc());
                for (int i = 0; i < 20; i++) {  
import java.util.Collections;
    }
 * The OpenSearch Contributors require contributions made to  
        try (Directory dir = newDirectory()) {
                    }  
public class RecoverySourcePruneMergePolicyTests extends OpenSearchTestCase {  
                writer.commit();
                        SegmentInfos segmentInfos = sdr.getSegmentInfos();
        }  
 * under the License.  
                                @Override
import org.apache.lucene.document.NumericDocValuesField;  
 * the Apache License, Version 2.0 (the "License"); you may
        try (Directory dir = newDirectory()) {
import org.apache.lucene.index.IndexableField;
 *  
import org.apache.lucene.index.StandardDirectoryReader;
                    }
import java.util.stream.Collectors;
        }
    public void testPruneAll() throws IOException {
import org.apache.lucene.index.StoredFields;
                            segmentInfos,  
                                    return Collections.emptySet();
                    for (int i = 0; i < reader.maxDoc(); i++) {
import org.opensearch.test.OpenSearchTestCase;
                    if (i > 0 && randomBoolean()) {
    public void testPruneNone() throws IOException {  
                    writer.addDocument(doc);
                        assertTrue(collect.contains("source"));
/*
                                @Override  
                    }
