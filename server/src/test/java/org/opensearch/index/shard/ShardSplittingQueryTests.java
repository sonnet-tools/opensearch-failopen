                        sequenceIDFields.primaryTerm
            searcher.setQueryCache(null);  
            for (final LeafReaderContext ctx : leaves) {  
import org.apache.lucene.document.Field;  
 */  
                        sequenceIDFields.primaryTerm
                );
                    Arrays.asList(
            .numberOfShards(2)  
                DocIdSetIterator iterator = scorer.iterator();
            .numberOfShards(numShards)
import java.util.ArrayList;
                    )
import org.opensearch.cluster.routing.OperationRouting;
                rootDoc = Arrays.asList(
                    docs.add(
        boolean hasNested = randomBoolean();
        writer.close();  
                } else {
        Directory dir = newFSDirectory(createTempDir());
            .numberOfReplicas(0)
            .build();
                    )  
                );
                sequenceIDFields.tombstoneField,
                        BytesRef id = reader.storedFields().document(doc).getBinaryValue("_id");  
                        }
                    );
import org.apache.lucene.search.ScoreMode;
                searcher.rewrite(new ShardSplittingQuery(metadata, 0, false)),
                        sequenceIDFields.primaryTerm  
            .setRoutingNumShards(2 * 1000000)
                Lucene.newSoftDeletesField()
                        new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),  
    public void testSplitOnID() throws IOException {  
import org.apache.lucene.index.DirectoryReader;
            .numberOfReplicas(0)
                            new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
            } else {  
                    if (targetShardId == shard_id.nextValue()) {  
                            new SortedNumericDocValuesField("shard_id", shardId)
                        new SortedNumericDocValuesField("shard_id", shardId),
        for (int j = 0; j < numDocs; j++) {
                int numExpected = 0;
                        new SortedNumericDocValuesField("shard_id", shardId),
        IndexMetadata metadata = IndexMetadata.builder("test")  
        for (int j = 0; j < numDocs; j++) {
        writer.close();
import org.opensearch.common.settings.Settings;  
 * Modifications Copyright OpenSearch Contributors. See  
            IndexSearcher searcher = new IndexSearcher(reader);
import org.apache.lucene.index.IndexableField;  
        writer.commit();
        dir.close();
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir);  
                docs.add(  
            searcher.setQueryCache(null);
 * license agreements. See the NOTICE file distributed with
                        // check the last docs in the segment and make sure they all have the right shard id
                            new StringField(NestedPathFieldMapper.NAME, "__nested", Field.Store.YES),
                            long shardID = shard_id.nextValue();  
                        new StringField(RoutingFieldMapper.NAME, routing, Field.Store.YES),
                        new SortedNumericDocValuesField("shard_id", shardId),  
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
                int numNested = randomIntBetween(0, 10);
 * Licensed to Elasticsearch under one or more contributor  
                }  
    public void testSplitOnRoutingPartitioned() throws IOException {
    public void testSplitOnRouting() throws IOException {
                ScoreMode.COMPLETE_NO_SCORES,  
                        new SortedNumericDocValuesField("shard_id", shardId),
                SortedNumericDocValues shard_id = ctx.reader().getSortedNumericDocValues("shard_id");  
 * this work for additional information regarding copyright
        Directory dir = newFSDirectory(createTempDir());
        final int numDocs = randomIntBetween(50, 100);  
}  
            .numberOfReplicas(0)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int numShards = randomIntBetween(2, 10);
        SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
            }
        sequenceIDFields.tombstoneField.setLongValue(1);  
        SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                rootDoc = Arrays.asList(
            }  
        final int numDocs = randomIntBetween(50, 100);
                    )  
                int numNested = randomIntBetween(0, 10);
                assertEquals(DocIdSetIterator.NO_MORE_DOCS, scorer.iterator().nextDoc());  
                    assertEquals(numExpected, numActual);
        final int numDocs = randomIntBetween(50, 100);
            .setRoutingNumShards(numShards * 1000000)
package org.opensearch.index.shard;
                new NumericDocValuesField(VersionFieldMapper.NAME, 1),  
                    }
        try (IndexReader reader = DirectoryReader.open(dir)) {
    }  
    }  
            } else {
 *
            IndexSearcher searcher = new IndexSearcher(reader);
                        assertEquals(shard_id.docID(), doc);
                    // all docs belong in this shard
import java.util.Arrays;
            final int shardId = OperationRouting.generateShardId(metadata, null, routing);  
        Directory dir = newFSDirectory(createTempDir());
import org.apache.lucene.search.Scorer;  
            int shardId = OperationRouting.generateShardId(metadata, Integer.toString(j), null);  
/*  
        }  
            final List<LeafReaderContext> leaves = reader.leaves();
import org.opensearch.test.OpenSearchTestCase;
                ScoreMode.COMPLETE_NO_SCORES,
 * this file be licensed under the Apache-2.0 license or a
/*
                        lastDoc = doc;
                int numNested = randomIntBetween(0, 10);  
                    sequenceIDFields.primaryTerm
            .build();
 * software distributed under the License is distributed on an
            .routingPartitionSize(randomIntBetween(1, 10))  
        assertSplit(dir, metadata, targetShardId, hasNested);
                        Arrays.asList(
            }  
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
                );
import org.apache.lucene.search.Weight;
                int numNested = randomIntBetween(0, 10);  
                }  
 * specific language governing permissions and limitations
            final int shardId = OperationRouting.generateShardId(metadata, Integer.toString(j), routing);
                    docs.add(
                assertNull(ctx.reader().terms(IdFieldMapper.NAME));
                String routing = randomRealisticUnicodeOfCodepointLengthBetween(1, 5);  
            .numberOfShards(numShards)
                            new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),  
                    );
            .numberOfReplicas(0)  
        for (int j = 0; j < numDocs; j++) {
                        new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
            if (hasNested) {
                            new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
                );
                docs.add(
                for (int i = 0; i < numNested; i++) {
    }
                        Arrays.asList(
                        numExpected++;
                writer.addDocument(
                    )
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        IndexMetadata metadata = IndexMetadata.builder("test")
        }
        assertSplit(dir, metadata, targetShardId, hasNested);
 * KIND, either express or implied.  See the License for the
        SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();  
        writer.commit();
                        long shardID = shard_id.nextValue();
 * ownership. Elasticsearch licenses this file to you under  
                Scorer scorer = splitWeight.scorer(ctx);
                        )  
 *  
        int targetShardId = randomIntBetween(0, numShards - 1);  
                        }  
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir);
                );
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
                        new StringField(RoutingFieldMapper.NAME, routing, Field.Store.YES),
                );
            final Weight splitWeight = searcher.createWeight(  
                    );  
import org.apache.lucene.index.LeafReaderContext;
                    new StringField(RoutingFieldMapper.NAME, routing, Field.Store.YES),
 *
            final int shardId;
                    if (lastDoc < ctx.reader().maxDoc()) {
                    new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),  
import org.apache.lucene.index.SortedNumericDocValues;
        assertSplit(dir, metadata, targetShardId, hasNested);
                if (numExpected == ctx.reader().maxDoc()) {
                    while ((doc = iterator.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {  
            Arrays.asList(
                        new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),  
        for (int j = 0; j < numDocs; j++) {
import org.apache.lucene.util.BytesRef;
                    Arrays.asList(
                        new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),  
        }
        dir.close();  
 */
                    int numActual = 0;
        dir.close();  
 * not use this file except in compliance with the License.
                    new SortedNumericDocValuesField("shard_id", shardId),  
        final int numDocs = randomIntBetween(50, 100);  
        int numShards = randomIntBetween(2, 10);
        boolean hasNested = randomBoolean();
                            new StringField(NestedPathFieldMapper.NAME, "__nested", Field.Store.YES),
        int numShards = randomIntBetween(2, 10);
                    int doc;  
            .setRoutingNumShards(numShards * 1000000)
                        new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),  
                writer.addDocuments(docs);  
                1f
import org.opensearch.index.mapper.NestedPathFieldMapper;
                        )
                    int lastDoc = 0;
        dir.close();
                            numActual++;
                Scorer scorer = splitWeight.scorer(ctx);
                for (int i = 0; i < numNested; i++) {
        boolean hasNested = randomBoolean();  
import org.apache.lucene.document.SortedNumericDocValuesField;
                            long shardID = shard_id.nextValue();
                            new StringField(NestedPathFieldMapper.NAME, "__nested", Field.Store.YES),  
                        new SortedNumericDocValuesField("shard_id", shardId),
                            new SortedNumericDocValuesField("shard_id", shardId)
            )
                            new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
import org.opensearch.index.mapper.Uid;
                    Arrays.asList(  
                    Arrays.asList(
import org.apache.lucene.search.DocIdSetIterator;  
        assertSplit(dir, metadata, targetShardId, hasNested);
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir);
                for (int i = 0; i < numNested; i++) {
import org.apache.lucene.search.IndexSearcher;
public class ShardSplittingQueryTests extends OpenSearchTestCase {
                List<Iterable<IndexableField>> docs = new ArrayList<>();
 *     http://www.apache.org/licenses/LICENSE-2.0
            .build();
                            numActual++;  
        IndexMetadata metadata = IndexMetadata.builder("test")  
                writer.addDocument(
                }
                docs.add(rootDoc);
                        new StringField(RoutingFieldMapper.NAME, routing, Field.Store.YES),
            .numberOfShards(numShards)
import org.apache.lucene.index.IndexReader;
            String routing = randomRealisticUnicodeOfCodepointLengthBetween(1, 5);  
                shardId = OperationRouting.generateShardId(metadata, null, routing);
                    Arrays.asList(
                1f  
            Iterable<IndexableField> rootDoc;  
                        String actualId = Uid.decodeId(id.bytes, id.offset, id.length);
                    Arrays.asList(
    }
 */
            if (hasNested) {
/*
 * GitHub history for details.
            for (LeafReaderContext ctx : reader.leaves()) {  
import java.util.List;  
import org.opensearch.cluster.metadata.IndexMetadata;  
        SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                        )
                    }  
    void assertSplit(Directory dir, IndexMetadata metadata, int targetShardId, boolean hasNested) throws IOException {
        writer.commit();
            if (hasNested) {  
                        )
            final Weight splitWeight = searcher.createWeight(
                    new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
        writer.commit();
        }
        dir.close();
        );  
                while (shard_id.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
                            new StringField(NestedPathFieldMapper.NAME, "__nested", Field.Store.YES),
        writer.addDocument(  
            } else {  
                }  
 * SPDX-License-Identifier: Apache-2.0
                sequenceIDFields.seqNoDocValue,  
            .numberOfShards(numShards)
                            new SortedNumericDocValuesField("shard_id", shardId)  
        int targetShardId = randomIntBetween(0, numShards - 1);
        writer.close();  
                        while (shard_id.nextDoc() < doc) {
            } else {
                List<Iterable<IndexableField>> docs = new ArrayList<>();
import java.io.IOException;  
                    docs.add(
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
                            assertEquals(shardID, targetShardId);
            if (hasNested) {
                writer.addDocuments(docs);  
            }
            }  
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir);  
                    )
        try (IndexReader reader = DirectoryReader.open(dir)) {  
            } else {
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir);
        writer.close();
    }  
        IndexMetadata metadata = IndexMetadata.builder("test")
        Directory dir = newFSDirectory(createTempDir());
import org.opensearch.Version;
        }
                            new SortedNumericDocValuesField("shard_id", shardId)  
import org.apache.lucene.document.NumericDocValuesField;
            .build();  
    public void testSplitOnNoopOnlySegment() throws IOException {
            }
                writer.addDocument(rootDoc);
            .setRoutingNumShards(numShards * 1000000)  
import org.opensearch.index.mapper.SeqNoFieldMapper;
        boolean hasNested = randomBoolean();  
            .setRoutingNumShards(numShards * 1000000)  
        }
                        new StringField(RoutingFieldMapper.NAME, routing, Field.Store.YES),  
                sequenceIDFields.primaryTerm,
                    shard_id = ctx.reader().getSortedNumericDocValues("shard_id");
                shardId = OperationRouting.generateShardId(metadata, Integer.toString(j), null);  
        int targetShardId = randomIntBetween(0, numShards - 1);  
                        while (shard_id.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {  
                        sequenceIDFields.primaryTerm
    }
            );
                searcher.rewrite(new ShardSplittingQuery(metadata, targetShardId, hasNested)),
        int targetShardId = randomIntBetween(0, numShards - 1);
                        new SortedNumericDocValuesField("shard_id", shardId),
                        Arrays.asList(  
                );
                for (int i = 0; i < numNested; i++) {  
                        Arrays.asList(  
                }
 * compatible open source license.
                writer.addDocuments(docs);
            }  
                    assertEquals(DocIdSetIterator.NO_MORE_DOCS, iterator.nextDoc());  
 * The OpenSearch Contributors require contributions made to  
        writer.commit();  
import org.opensearch.index.mapper.RoutingFieldMapper;  
            .build();
                    sequenceIDFields.primaryTerm  
        int numShards = randomIntBetween(2, 10);
                    }
 * under the License.  
                writer.addDocument(
                sequenceIDFields.seqNo,
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.store.Directory;
                List<Iterable<IndexableField>> docs = new ArrayList<>();
        IndexMetadata metadata = IndexMetadata.builder("test")
            if (randomBoolean()) {
                    )  
import org.apache.lucene.document.StringField;  
    public void testSplitOnIdOrRouting() throws IOException {  
                writer.addDocuments(docs);
                        assertNotEquals(ctx.reader() + " docID: " + doc + " actualID: " + actualId, shardID, targetShardId);
import org.opensearch.common.lucene.Lucene;
                docs.add(
                    );
            .numberOfReplicas(0)
                }
                        new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
            String routing = randomRealisticUnicodeOfCodepointLengthBetween(1, 5);
                List<Iterable<IndexableField>> docs = new ArrayList<>();  
import org.opensearch.index.mapper.IdFieldMapper;
import org.apache.lucene.tests.index.RandomIndexWriter;  
                        sequenceIDFields.primaryTerm
        Directory dir = newFSDirectory(createTempDir());
                    docs.add(  
        writer.close();
                            assertEquals(shardID, targetShardId);
                        sequenceIDFields.primaryTerm  
import org.opensearch.index.mapper.VersionFieldMapper;  
            );
        SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();  
                );  
                    new SortedNumericDocValuesField("shard_id", shardId),
