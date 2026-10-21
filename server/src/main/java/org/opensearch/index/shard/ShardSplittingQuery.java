    }
            this.visitor = visitor;
                    // in this case we also don't do anything special with regards to nested docs since we basically delete
        }
    }
 */
            searcher.setQueryCache(null);
            switch (fieldInfo.name) {
import java.util.function.IntConsumer;
                Predicate<BytesRef> includeInShard = ref -> {
                return false;
                if (terms == null) {
                    id = Uid.decodeId(value);
                case IdFieldMapper.NAME:
                        // if nested docs are involved we also need to mark all child docs that belong to a matching parent doc.
    }
 *
        if (this == o) return true;
            switch (fieldInfo.name) {
        public float matchCost() {
                        // this is the heaviest invariant. Here we have to visit all docs stored fields do extract _id and _routing
        return "shard_splitting_query";
        }
    public void visit(QueryVisitor visitor) {
                                    if (parentBitSet.get(docId)) {
                default:
            return;
/**
        if (shardId != that.shardId) return false;
        final LeafReader leafReader;
     * shard based on their id and routing value. This is only used in a routing partitioned index.
 * license agreements. See the NOTICE file distributed with
        }
    public String toString(String field) {
        public boolean matches() throws IOException {
    }
                            });
        final Terms terms = leafReader.terms(idField);
                    assert indexMetadata.isRoutingPartitionedIndex() == false;
                        // here we potentially guard the docID consumers with our parent bitset if we have one.
     */
/*
            int targetShardId = OperationRouting.generateShardId(indexMetadata, id, routing);
        };
        }
 *
        @Override
    }
                return new DefaultScorerSupplier(scorer);
    public int hashCode() {
        ShardSplittingQuery that = (ShardSplittingQuery) o;
                        // this index is routing partitioned.
 * You may obtain a copy of the License at
    /**
                Terms terms = leafReader.terms(RoutingFieldMapper.NAME);
                            // this is a special case where some of the docs have no routing values this sucks but it's possible today
import org.opensearch.common.lucene.search.Queries;
        PostingsEnum postingsEnum = null;
 * GitHub history for details.
            }
    @Override
    }
                        null
        private final Visitor visitor;
                        // this ensures that we are only marking root documents in the nested case and if necessary
                        };
    }
        Visitor(LeafReader leafReader) {
    }
    }
                    return leftToVisit == 0 ? Status.STOP : Status.NO;
    @Override
            this.leafReader = leafReader;
        private final BytesRef spare = new BytesRef();
            }
        visitor.visitLeaf(this);
import org.apache.lucene.util.FixedBitSet;
            if (doc > nextParent) {
        return context -> {
     */
    private static void findSplitDocs(String idField, Predicate<BytesRef> includeInShard, LeafReader leafReader, IntConsumer consumer)
 */
                    }
        int currentDeleted = 0;
                    leftToVisit--;
                    throw new IllegalStateException("Unexpected field: " + fieldInfo.name);
            && (currentDeleted = matchingDocs.nextSetBit(currentDeleted)) != DocIdSetIterator.NO_MORE_DOCS) {
import org.apache.lucene.search.IndexSearcher;
                    if (indexMetadata.isRoutingPartitionedIndex()) {
                                };
            }
        return classHash() ^ result;
                                if (hasRoutingValue.get(docId) == false) {
 * A query that selects all docs that do NOT belong in the current shards this query is executed on.
                        Function<IntConsumer, IntConsumer> maybeWrapConsumer = consumer -> {
                            return shardId == targetShardId;
                        // with a routing value from the next iteration an delete / select based on the ID.
            // we don't support 5.x so no need for the uid field
final class ShardSplittingQuery extends Query {
    }
        public void binaryField(FieldInfo fieldInfo, byte[] value) throws IOException {
            assert id != null : "docID must not be null - we might have hit a nested document";
                    // this is the common case - no partitioning and no _routing values
                                    }
            routing = id = null;
    private final IndexMetadata indexMetadata;
            int doc = approximation.docID();
        private final Visitor visitor;
import org.apache.lucene.search.Weight;
            @Override
            currentDeleted++;
import org.apache.lucene.search.ScoreMode;
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) {
                    if (parentBitSet != null) {
                    int targetShardId = OperationRouting.generateShardId(
            }
                            findSplitDocs(RoutingFieldMapper.NAME, ref -> false, leafReader, maybeWrapConsumer.apply(hasRoutingValue::set));
    private final int shardId;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.search.TwoPhaseIterator;
        }
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, new BitSetIterator(bitSet, bitSet.length()));
                    throw new IllegalStateException("Unexpected field: " + fieldInfo.name);
                            : new NestedRoutingPartitionedDocIdSetIterator(visitor, parentBitSet);
                return "weight(delete docs query)";
     */
 * Modifications Copyright OpenSearch Contributors. See
            this.visitor = visitor;
     *
        BytesRef idTerm;
import org.opensearch.cluster.metadata.IndexMetadata;
            leftToVisit = 2;
/*
            public String toString() {
            Query query = Queries.newNonNestedFilter();
import org.opensearch.cluster.routing.OperationRouting;
                                return docId -> {
import org.apache.lucene.search.ConstantScoreWeight;
        this.indexMetadata = indexMetadata;
                postingsEnum = iterator.postings(postingsEnum);
                };
     * executed on a recovery-private index writer. There is no point in caching it and it won't have a cache hit either.
                case RoutingFieldMapper.NAME:
            // order and that way we don't need to seek backwards as we do in other nested docs cases.
    private final BitSetProducer nestedParentBitSetProducer;
                    } else {
    private final class Visitor extends StoredFieldVisitor {
            @Override
                    return Status.YES;
            super(DocIdSetIterator.all(visitor.leafReader.maxDoc())); // we iterate all live-docs
package org.opensearch.index.shard;
import org.apache.lucene.search.ConstantScoreScorer;
            Scorer s = weight.scorer(context);
     * @opensearch.internal
            }
/*
     *
 * specific language governing permissions and limitations
import org.apache.lucene.index.LeafReaderContext;
                            FixedBitSet hasRoutingValue = new FixedBitSet(leafReader.maxDoc());
        return indexMetadata.equals(that.indexMetadata);
                    }
                while ((doc = postingsEnum.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
                        if (terms.getDocCount() != leafReader.maxDoc()) {
        NestedRoutingPartitionedDocIdSetIterator(Visitor visitor, BitSet parentDocs) {
                case RoutingFieldMapper.NAME:
                            }
        public boolean matches() throws IOException {
import org.opensearch.index.mapper.IdFieldMapper;
     * This TwoPhaseIterator marks all nested docs of matching parents as matches as well.
    }
        }
                        parentBitSet = null;
            return s == null ? null : BitSet.of(s.iterator(), context.reader().maxDoc());
        }
            int previousParent = parentDocs.prevSetBit(Math.max(0, currentDeleted - 1));
                            findSplitDocs(IdFieldMapper.NAME, includeInShard, leafReader, docId -> {
        if (terms == null) {
                case IdFieldMapper.NAME:
        if (o == null || getClass() != o.getClass()) return false;
                        return new DefaultScorerSupplier(scorer);
                        indexMetadata,
            }
                    return shardId == targetShardId;
                    findSplitDocs(IdFieldMapper.NAME, includeInShard, leafReader, bitSet::set);
                        // now if we have a mixed index where some docs have a _routing value and some don't we have to exclude the ones
            return nextParentMatches;
import org.apache.lucene.index.LeafReader;
    @Override
        result = 31 * result + shardId;
        }
import org.apache.lucene.util.BytesRef;
                    );
        @Override
import java.util.function.Function;
 * software distributed under the License is distributed on an
        }
            if (includeInShard.test(idTerm) == false) {
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
        while (currentDeleted < matchingDocs.length()
 * Licensed to Elasticsearch under one or more contributor
    @Override
import org.apache.lucene.search.join.BitSetProducer;
                                        consumer.accept(docId);
 * The OpenSearch Contributors require contributions made to
                        final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, twoPhaseIterator);
                FixedBitSet bitSet = new FixedBitSet(leafReader.maxDoc());
        private boolean nextParentMatches;
import org.apache.lucene.index.PostingsEnum;
                // we only check once per nested/parent set
            final IndexSearcher searcher = new IndexSearcher(topLevelContext);
        private String routing;
                    break;
 * KIND, either express or implied.  See the License for the
        private final BitSet parentDocs;
import org.opensearch.Version;
                    // by ID and parent and nested all have the same id.
            @Override
    @Override
                    }
        this.nestedParentBitSetProducer = hasNested ? newParentDocBitSetProducer(indexMetadata.getCreationVersion()) : null;
import java.util.function.Predicate;
                default:
        final TermsEnum iterator = terms.iterator();
                        if (parentBitSet == null) {
            return visitor.matches(approximation.docID());
                        findSplitDocs(RoutingFieldMapper.NAME, ref -> {
        @Override
        }
import java.io.IOException;
            leafReader.storedFields().document(doc, this);
                LeafReader leafReader = context.reader();
                        Visitor visitor = new Visitor(leafReader);
 * the Apache License, Version 2.0 (the "License"); you may
                }
     * than once. There is no point in using BitsetFilterCache#BitSetProducerWarmer since we use this only as a delete by query which is
        this.shardId = shardId;
                            IntConsumer bitSetConsumer = maybeWrapConsumer.apply(bitSet::set);
        }
        @Override
 * not use this file except in compliance with the License.
            switch (fieldInfo.name) {
                default:
 *
                nextParentMatches = visitor.matches(nextParent);
            this.parentDocs = parentDocs;
            super(DocIdSetIterator.all(visitor.leafReader.maxDoc())); // we iterate all live-docs
import org.opensearch.index.mapper.RoutingFieldMapper;
                        }
        public void stringField(FieldInfo fieldInfo, String value) throws IOException {
 */
        while ((idTerm = iterator.next()) != null) {
    private static final class RoutingPartitionedDocIdSetIterator extends TwoPhaseIterator {
                        // we do a second pass to mark the corresponding children in markChildDocs
 *    http://www.apache.org/licenses/LICENSE-2.0
     * this is used internally to obtain a bitset for parent documents. We don't cache this since we never access the same reader more
        }
 * under the License.
import org.apache.lucene.search.Query;
                        Uid.decodeId(ref.bytes, ref.offset, ref.length),
    private static BitSetProducer newParentDocBitSetProducer(Version indexVersionCreated) {
            return targetShardId != shardId;
                            if (parentBitSet != null) {
        @Override
 * compatible open source license.
                matchingDocs.set(i);
                            ? new RoutingPartitionedDocIdSetIterator(visitor)
        return new ConstantScoreWeight(this, boost) {
                // This is not a regular query, let's not cache it. It wouldn't help
import org.apache.lucene.index.IndexReaderContext;
import org.apache.lucene.index.FieldInfo;
        }
        public float matchCost() {
import org.apache.lucene.search.QueryVisitor;
import org.apache.lucene.search.ScorerSupplier;
        public Status needsField(FieldInfo fieldInfo) throws IOException {
        };
 *
            return 42; // that's obvious, right?
                int doc;
                        // in the _routing case we first go and find all docs that have a routing value and mark the ones we have to delete
 * SPDX-License-Identifier: Apache-2.0
                // anyway.
                    } else {
                // never check a child document against the visitor, they neihter have _id nor _routing as stored fields
    }
            final Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
            }
                        parentBitSet = nestedParentBitSetProducer.getBitSet(context);
        int result = indexMetadata.hashCode();
            return 42; // that's obvious, right?
import org.apache.lucene.index.ReaderUtil;
                }
                            return null; // no matches
 * this file be licensed under the Apache-2.0 license or a
                } else {
            final IndexReaderContext topLevelContext = ReaderUtil.getTopLevelContext(context);
        boolean matches(int doc) throws IOException {
     * This two phase iterator visits every live doc and selects all docs that don't belong into this
    ShardSplittingQuery(IndexMetadata indexMetadata, int shardId, boolean hasNested) {
     * @opensearch.internal
    /* this class is a stored fields visitor that reads _id and/or _routing from the stored fields which is necessary in the case
import org.apache.lucene.index.StoredFieldVisitor;
        }
import org.apache.lucene.index.Terms;
        private int nextParent = -1;
    /*
            public boolean isCacheable(LeafReaderContext ctx) {
import org.apache.lucene.search.DocIdSetIterator;
                    if (nestedParentBitSetProducer == null) {
            }
            for (int i = previousParent + 1; i < currentDeleted; i++) {
 * It can be used to split a shard into N shards marking every document that doesn't belong into the shard
import org.apache.lucene.util.BitSet;
import org.apache.lucene.util.BitSetIterator;
        @Override
                                }
                        }
 * ownership. Elasticsearch licenses this file to you under
                    routing = value;
        RoutingPartitionedDocIdSetIterator(Visitor visitor) {
                    consumer.accept(doc);
            // the educated reader might ask why this works, it does because all live doc ids (root docs and nested docs) are evaluated in
        @Override
    /**
}
        throws IOException {
                            return consumer;
                nextParent = parentDocs.nextSetBit(doc);
    private void markChildDocs(BitSet parentDocs, BitSet matchingDocs) {
        private String id;
import org.apache.lucene.index.TermsEnum;
       of a routing partitioned index sine otherwise we would need to un-invert the _id and _routing field which is memory heavy */
 */
 * @opensearch.internal
                            int targetShardId = OperationRouting.generateShardId(indexMetadata, null, ref.utf8ToString());
        private int leftToVisit = 2;
                    final BitSet parentBitSet;
 * this work for additional information regarding copyright
    private static final class NestedRoutingPartitionedDocIdSetIterator extends TwoPhaseIterator {
import org.apache.lucene.search.Scorer;
                        markChildDocs(parentBitSet, bitSet);
                    break;
    public boolean equals(Object o) {
                                    bitSetConsumer.accept(docId);
 * Unless required by applicable law or agreed to in writing,
                        }, leafReader, maybeWrapConsumer.apply(bitSet::set));
import org.opensearch.index.mapper.Uid;
                        TwoPhaseIterator twoPhaseIterator = parentBitSet == null
 * as deleted. See {@link org.apache.lucene.index.IndexWriter#deleteDocuments(Query...)}
            }
