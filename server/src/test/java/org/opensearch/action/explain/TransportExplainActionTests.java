        return lookup.toGetResult();
        try (Directory dir = newDirectory()) {
            }  
 * ownership. Elasticsearch licenses this file to you under  
    public void testNonPreMaterializedUsesDocIdAndVersion() throws Exception {  
 * Unit tests for {@link TransportExplainAction#resolveTopLevelDocId}, which resolves the top-level doc id used to
    }  
            try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE))) {
    }
    public void testPreMaterializedResolvesDocIdInSingleSegment() throws Exception {
        DocumentLookupResult lookup = new DocumentLookupResult(id, 1L, true, null, 0L, 1L, Map.of(), Map.of());
import org.opensearch.test.OpenSearchTestCase;
/*  
                int docId = TransportExplainAction.resolveTopLevelDocId(preMaterialized("1"), reader, idTerm("1"));  
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver;
 */  
        VersionsAndSeqNoResolver.DocIdAndVersion docIdAndVersion = new VersionsAndSeqNoResolver.DocIdAndVersion(3, 1L, 0L, 1L, null, 10);
/**  
import org.apache.lucene.document.Field;  
                assertEquals(13, docId);  
import org.apache.lucene.util.BytesRef;
        }
    // PreMaterialized + id term absent from the reader: helper returns NO_MATCH rather than erroring.  
    }
    }  
                assertEquals(Uid.encodeId("target"), stored);
                BytesRef stored = reader.storedFields().document(docId).getBinaryValue(IdFieldMapper.NAME);  
 */
    private static StringField idField(String id) {
import org.opensearch.index.get.DocumentLookupResult;
 * the Apache License, Version 2.0 (the "License"); you may
            }
                writer.commit();  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
    }
    }
            try (DirectoryReader reader = DirectoryReader.open(dir)) {
            }  
            }
                writer.addDocument(List.of(idField("present")));
            try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE))) {
            }
 */
import org.opensearch.index.mapper.IdFieldMapper;
    // PreMaterialized + single segment: id present, helper returns the leaf docId with docBase 0.
                for (int i = 0; i < 5; i++) {
 * GitHub history for details.
    private static Engine.GetResult preMaterialized(String id) {  
/*
            try (DirectoryReader reader = DirectoryReader.open(dir)) {
 * this file be licensed under the Apache-2.0 license or a
                Term term = idTerm("target");  
    // Non-PreMaterialized: helper reads docIdAndVersion (docId + docBase) and never touches the reader.
            try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE))) {  
package org.opensearch.action.explain;
 * explain a hit against the explain searcher's own reader.
 * Licensed to Elasticsearch under one or more contributor  
    public void testPreMaterializedMissingIdReturnsNoMatch() throws Exception {
                    writer.addDocument(List.of(idField("first-" + i)));
            try (DirectoryReader reader = DirectoryReader.open(dir)) {
import java.util.List;  
                assertTrue("target must land in a later segment to exercise the docBase lift", docId >= reader.leaves().get(1).docBase);  
        return new Term(IdFieldMapper.NAME, Uid.encodeId(id));
                writer.commit();
            }
import org.apache.lucene.index.Term;
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
            }
        Engine.GetResult result = new Engine.GetResult(null, docIdAndVersion, false);
        try (Directory dir = newDirectory()) {  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                int docId = TransportExplainAction.resolveTopLevelDocId(preMaterialized("absent"), reader, idTerm("absent"));
 * this work for additional information regarding copyright
    }  
            try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE))) {  
 * under the License.  
        return new StringField(IdFieldMapper.NAME, Uid.encodeId(id), Field.Store.YES);  
                writer.addDocument(List.of(idField("1")));
import org.opensearch.index.engine.Engine;  
                int docId = TransportExplainAction.resolveTopLevelDocId(preMaterialized("target"), reader, term);
                assertEquals(TransportExplainAction.NO_MATCH, docId);  
                writer.addDocument(List.of(idField("target")));
 * specific language governing permissions and limitations
                int docId = TransportExplainAction.resolveTopLevelDocId(result, reader, idTerm("ignored"));
public class TransportExplainActionTests extends OpenSearchTestCase {
        }  
import org.apache.lucene.index.NoMergePolicy;
                // Strongest proof the docBase lift is correct: the stored _id at the top-level docId is "target".
import java.util.Map;
        try (Directory dir = newDirectory()) {
    // PreMaterialized across segments: target lands in a later segment, helper lifts the leaf docId by its docBase.  
        try (Directory dir = newDirectory()) {  
import org.apache.lucene.store.Directory;  
import org.apache.lucene.index.IndexWriter;  
import org.opensearch.index.mapper.Uid;  
    public void testPreMaterializedAppliesDocBaseAcrossSegments() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.DirectoryReader;
                }  
import org.apache.lucene.document.StringField;
/*
            try (DirectoryReader reader = DirectoryReader.open(dir)) {
                assertEquals(0, docId);
                writer.commit();  
                writer.commit();
        }  
            }
 * software distributed under the License is distributed on an
 *  
}
 */  
 *
                writer.commit();
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
    private static Term idTerm(String id) {  
 * license agreements. See the NOTICE file distributed with
