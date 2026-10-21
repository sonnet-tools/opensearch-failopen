            .build();
            Arrays.asList(
                        assertEquals(shard_id.docID(), doc);
            final int shardId = OperationRouting.generateShardId(metadata, Integer.toString(j), routing);
                        while (shard_id.nextDoc() < doc) {
                            new SortedNumericDocValuesField("shard_id", shardId)
                    int doc;
                ScoreMode.COMPLETE_NO_SCORES,
                    docs.add(
                            assertEquals(shardID, targetShardId);
        for (int j = 0; j < numDocs; j++) {
                            numActual++;
                        }
                1f
        IndexMetadata metadata = IndexMetadata.builder("test")
        assertSplit(dir, metadata, targetShardId, hasNested);
                        new StringField(RoutingFieldMapper.NAME, routing, Field.Store.YES),
    }
            if (hasNested) {
import org.opensearch.index.mapper.VersionFieldMapper;
                    int numActual = 0;
                sequenceIDFields.seqNo,
import org.opensearch.cluster.routing.OperationRouting;
                rootDoc = Arrays.asList(
        final int numDocs = randomIntBetween(50, 100);
            .build();
import org.opensearch.common.lucene.Lucene;
 */
            }
                    if (lastDoc < ctx.reader().maxDoc()) {
                    new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
            } else {
            final int shardId = OperationRouting.generateShardId(metadata, null, routing);
import org.opensearch.index.mapper.SeqNoFieldMapper;
                            new StringField(NestedPathFieldMapper.NAME, "__nested", Field.Store.YES),
            .numberOfShards(numShards)
            .setRoutingNumShards(numShards * 1000000)
 * Licensed to Elasticsearch under one or more contributor
        dir.close();
                        Arrays.asList(
                            new SortedNumericDocValuesField("shard_id", shardId)
                        sequenceIDFields.primaryTerm
 * this file be licensed under the Apache-2.0 license or a
    }
                        new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
            }
                    docs.add(
        int numShards = randomIntBetween(2, 10);
        int targetShardId = randomIntBetween(0, numShards - 1);
                    assertEquals(DocIdSetIterator.NO_MORE_DOCS, iterator.nextDoc());
        }
        int targetShardId = randomIntBetween(0, numShards - 1);
        IndexMetadata metadata = IndexMetadata.builder("test")
                docs.add(
                    docs.add(
                    shard_id = ctx.reader().getSortedNumericDocValues("shard_id");
        for (int j = 0; j < numDocs; j++) {
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir);
                );
                writer.addDocument(
            }
                            new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
            } else {
        Directory dir = newFSDirectory(createTempDir());
            .numberOfShards(numShards)
package org.opensearch.index.shard;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                docs.add(
            .setRoutingNumShards(2 * 1000000)
 * SPDX-License-Identifier: Apache-2.0
        writer.commit();
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.document.NumericDocValuesField;
                    )
                assertNull(ctx.reader().terms(IdFieldMapper.NAME));
            .numberOfShards(2)
    public void testSplitOnRoutingPartitioned() throws IOException {
                    Arrays.asList(
import org.opensearch.index.mapper.RoutingFieldMapper;
                if (numExpected == ctx.reader().maxDoc()) {
                        BytesRef id = reader.storedFields().document(doc).getBinaryValue("_id");
                        )
        SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                        // check the last docs in the segment and make sure they all have the right shard id
                searcher.rewrite(new ShardSplittingQuery(metadata, targetShardId, hasNested)),
        dir.close();
                        sequenceIDFields.primaryTerm
                1f
                    );
                    );
            .numberOfReplicas(0)
            IndexSearcher searcher = new IndexSearcher(reader);
                    Arrays.asList(
                List<Iterable<IndexableField>> docs = new ArrayList<>();
                            new SortedNumericDocValuesField("shard_id", shardId)
    public void testSplitOnNoopOnlySegment() throws IOException {
            Iterable<IndexableField> rootDoc;
            if (hasNested) {
            int shardId = OperationRouting.generateShardId(metadata, Integer.toString(j), null);
import java.io.IOException;
        writer.commit();
                shardId = OperationRouting.generateShardId(metadata, Integer.toString(j), null);
                            new StringField(NestedPathFieldMapper.NAME, "__nested", Field.Store.YES),
                }
                        new SortedNumericDocValuesField("shard_id", shardId),
                for (int i = 0; i < numNested; i++) {
import org.apache.lucene.util.BytesRef;
            final Weight splitWeight = searcher.createWeight(
                    );
            );
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
}
                int numExpected = 0;
                int numNested = randomIntBetween(0, 10);
        assertSplit(dir, metadata, targetShardId, hasNested);
 * not use this file except in compliance with the License.
                    sequenceIDFields.primaryTerm
            .numberOfReplicas(0)
        boolean hasNested = randomBoolean();
                        Arrays.asList(
        writer.close();
                writer.addDocument(
                    Arrays.asList(
                    );
            for (LeafReaderContext ctx : reader.leaves()) {
                        sequenceIDFields.primaryTerm
import org.apache.lucene.document.Field;
            String routing = randomRealisticUnicodeOfCodepointLengthBetween(1, 5);
        boolean hasNested = randomBoolean();
                DocIdSetIterator iterator = scorer.iterator();
                            new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
import java.util.ArrayList;
 * Modifications Copyright OpenSearch Contributors. See
        final int numDocs = randomIntBetween(50, 100);
import org.opensearch.index.mapper.IdFieldMapper;
                        new SortedNumericDocValuesField("shard_id", shardId),
        writer.commit();
                Scorer scorer = splitWeight.scorer(ctx);
                sequenceIDFields.seqNoDocValue,
 *
                int numNested = randomIntBetween(0, 10);
                    )
import org.apache.lucene.document.StringField;
        for (int j = 0; j < numDocs; j++) {
                    // all docs belong in this shard
        int numShards = randomIntBetween(2, 10);
                docs.add(rootDoc);
            } else {
            )
            }
import org.apache.lucene.search.Weight;
        writer.close();
            final List<LeafReaderContext> leaves = reader.leaves();
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir);
        writer.close();
import org.apache.lucene.index.IndexReader;
                            long shardID = shard_id.nextValue();
        boolean hasNested = randomBoolean();
            final Weight splitWeight = searcher.createWeight(
        int targetShardId = randomIntBetween(0, numShards - 1);
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir);
 * software distributed under the License is distributed on an
 */
 * license agreements. See the NOTICE file distributed with
        Directory dir = newFSDirectory(createTempDir());
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir);
                );
                            new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
                        new SortedNumericDocValuesField("shard_id", shardId),
    public void testSplitOnIdOrRouting() throws IOException {
        try (IndexReader reader = DirectoryReader.open(dir)) {
                writer.addDocuments(docs);
    public void testSplitOnRouting() throws IOException {
        Directory dir = newFSDirectory(createTempDir());
                }
                }
                    while ((doc = iterator.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
                        numExpected++;
 *
        writer.close();
        writer.commit();
    }
                        sequenceIDFields.primaryTerm
                for (int i = 0; i < numNested; i++) {
                for (int i = 0; i < numNested; i++) {
            searcher.setQueryCache(null);
                    )
public class ShardSplittingQueryTests extends OpenSearchTestCase {
                List<Iterable<IndexableField>> docs = new ArrayList<>();
                        )
                        assertNotEquals(ctx.reader() + " docID: " + doc + " actualID: " + actualId, shardID, targetShardId);
                    )
                Lucene.newSoftDeletesField()
import org.apache.lucene.index.LeafReaderContext;
                List<Iterable<IndexableField>> docs = new ArrayList<>();
        int numShards = randomIntBetween(2, 10);
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        sequenceIDFields.tombstoneField.setLongValue(1);
                SortedNumericDocValues shard_id = ctx.reader().getSortedNumericDocValues("shard_id");
            .build();
import org.opensearch.Version;
            .routingPartitionSize(randomIntBetween(1, 10))
/*
        assertSplit(dir, metadata, targetShardId, hasNested);
 * You may obtain a copy of the License at
/*
            IndexSearcher searcher = new IndexSearcher(reader);
/*
                    new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
        boolean hasNested = randomBoolean();
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testSplitOnID() throws IOException {
 * compatible open source license.
        int numShards = randomIntBetween(2, 10);
                        new SortedNumericDocValuesField("shard_id", shardId),
            if (hasNested) {
        SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
            .numberOfShards(numShards)
                        new StringField(RoutingFieldMapper.NAME, routing, Field.Store.YES),
    }
                    new SortedNumericDocValuesField("shard_id", shardId),
            searcher.setQueryCache(null);
import org.apache.lucene.index.SortedNumericDocValues;
        SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
            .setRoutingNumShards(numShards * 1000000)
                writer.addDocuments(docs);
                for (int i = 0; i < numNested; i++) {
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
import org.opensearch.index.mapper.Uid;
            }
                            new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
                    }
                );
import org.apache.lucene.search.Scorer;
import org.apache.lucene.search.DocIdSetIterator;
            final int shardId;
                        Arrays.asList(
            }
                    new SortedNumericDocValuesField("shard_id", shardId),
                        long shardID = shard_id.nextValue();
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        dir.close();
                    int lastDoc = 0;
                        new StringField(RoutingFieldMapper.NAME, routing, Field.Store.YES),
                            numActual++;
                }
                        new SortedNumericDocValuesField("shard_id", shardId),
        Directory dir = newFSDirectory(createTempDir());
                new NumericDocValuesField(VersionFieldMapper.NAME, 1),
                assertEquals(DocIdSetIterator.NO_MORE_DOCS, scorer.iterator().nextDoc());
        final int numDocs = randomIntBetween(50, 100);
import java.util.List;
 * under the License.
                    sequenceIDFields.primaryTerm
 * ownership. Elasticsearch licenses this file to you under
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.DirectoryReader;
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        }
            }
                    Arrays.asList(
                            new StringField(NestedPathFieldMapper.NAME, "__nested", Field.Store.YES),
 * The OpenSearch Contributors require contributions made to
                writer.addDocuments(docs);
        );
            } else {
                            assertEquals(shardID, targetShardId);
        writer.close();
                } else {
                shardId = OperationRouting.generateShardId(metadata, null, routing);
import org.opensearch.common.settings.Settings;
        SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                );
            if (hasNested) {
                    )
                docs.add(
                searcher.rewrite(new ShardSplittingQuery(metadata, 0, false)),
                    if (targetShardId == shard_id.nextValue()) {
import org.opensearch.index.mapper.NestedPathFieldMapper;
            .numberOfReplicas(0)
        try (IndexReader reader = DirectoryReader.open(dir)) {
            .build();
                );
                        lastDoc = doc;
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir);
                    docs.add(
        writer.addDocument(
            .numberOfReplicas(0)
                        }
 * KIND, either express or implied.  See the License for the
                            long shardID = shard_id.nextValue();
                    }
                rootDoc = Arrays.asList(
import org.apache.lucene.search.IndexSearcher;
                writer.addDocuments(docs);
                }
                        Arrays.asList(
        SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                        sequenceIDFields.primaryTerm
        dir.close();
                            new SortedNumericDocValuesField("shard_id", shardId)
                        new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
        IndexMetadata metadata = IndexMetadata.builder("test")
                        )
                );
import java.util.Arrays;
                    Arrays.asList(
            .numberOfReplicas(0)
import org.opensearch.test.OpenSearchTestCase;
                    }
 * GitHub history for details.
import org.apache.lucene.document.SortedNumericDocValuesField;
                        new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
                    assertEquals(numExpected, numActual);
            .build();
    }
                        )
                int numNested = randomIntBetween(0, 10);
import org.apache.lucene.tests.index.RandomIndexWriter;
    }
                        new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
                        String actualId = Uid.decodeId(id.bytes, id.offset, id.length);
                        sequenceIDFields.primaryTerm
import org.opensearch.cluster.metadata.IndexMetadata;
                List<Iterable<IndexableField>> docs = new ArrayList<>();
                writer.addDocument(rootDoc);
                    new StringField(RoutingFieldMapper.NAME, routing, Field.Store.YES),
 * the Apache License, Version 2.0 (the "License"); you may
                Scorer scorer = splitWeight.scorer(ctx);
                    Arrays.asList(
        }
            .setRoutingNumShards(numShards * 1000000)
        }
            .numberOfShards(numShards)
                    )
                            new StringField(NestedPathFieldMapper.NAME, "__nested", Field.Store.YES),
                        new SortedNumericDocValuesField("shard_id", shardId),
            String routing = randomRealisticUnicodeOfCodepointLengthBetween(1, 5);
 *
    void assertSplit(Directory dir, IndexMetadata metadata, int targetShardId, boolean hasNested) throws IOException {
                        new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
 * this work for additional information regarding copyright
            .setRoutingNumShards(numShards * 1000000)
                int numNested = randomIntBetween(0, 10);
        }
                        while (shard_id.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
                writer.addDocument(
        dir.close();
                );
            } else {
                while (shard_id.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
                        new StringField(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(j)), Field.Store.YES),
        writer.commit();
        for (int j = 0; j < numDocs; j++) {
        int targetShardId = randomIntBetween(0, numShards - 1);
                String routing = randomRealisticUnicodeOfCodepointLengthBetween(1, 5);
        final int numDocs = randomIntBetween(50, 100);
            );
        assertSplit(dir, metadata, targetShardId, hasNested);
                ScoreMode.COMPLETE_NO_SCORES,
                );
                }
        Directory dir = newFSDirectory(createTempDir());
                        new StringField(RoutingFieldMapper.NAME, routing, Field.Store.YES),
        IndexMetadata metadata = IndexMetadata.builder("test")
            if (randomBoolean()) {
                sequenceIDFields.primaryTerm,
        IndexMetadata metadata = IndexMetadata.builder("test")
import org.apache.lucene.store.Directory;
 */
import org.apache.lucene.search.ScoreMode;
                sequenceIDFields.tombstoneField,
            for (final LeafReaderContext ctx : leaves) {
        }
