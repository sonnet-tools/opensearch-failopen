/**
 * the Apache License, Version 2.0 (the "License"); you may
                matchingDocs.set(i);
        @Override  
 * this file be licensed under the Apache-2.0 license or a
    private static final class RoutingPartitionedDocIdSetIterator extends TwoPhaseIterator {
        int result = indexMetadata.hashCode();
        return context -> {  
 * ownership. Elasticsearch licenses this file to you under  
final class ShardSplittingQuery extends Query {  
        @Override
                        }
        }
        int currentDeleted = 0;  
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, new BitSetIterator(bitSet, bitSet.length()));
            }  
    private static final class NestedRoutingPartitionedDocIdSetIterator extends TwoPhaseIterator {
 */  
        public float matchCost() {
 * Unless required by applicable law or agreed to in writing,
                            : new NestedRoutingPartitionedDocIdSetIterator(visitor, parentBitSet);  
     * this is used internally to obtain a bitset for parent documents. We don't cache this since we never access the same reader more
     * @opensearch.internal
                    } else {  
            @Override
     *
import org.apache.lucene.search.ConstantScoreScorer;  
                            return consumer;  
import org.apache.lucene.search.Query;
            int targetShardId = OperationRouting.generateShardId(indexMetadata, id, routing);
        }
            // order and that way we don't need to seek backwards as we do in other nested docs cases.
        return classHash() ^ result;
        }  
import org.opensearch.index.mapper.RoutingFieldMapper;  
    /* this class is a stored fields visitor that reads _id and/or _routing from the stored fields which is necessary in the case  
import org.apache.lucene.search.DocIdSetIterator;
        private String routing;  
                    if (indexMetadata.isRoutingPartitionedIndex()) {  
package org.opensearch.index.shard;
    }
                    throw new IllegalStateException("Unexpected field: " + fieldInfo.name);
        }
        private int nextParent = -1;
                    );
        private final BytesRef spare = new BytesRef();
    private final BitSetProducer nestedParentBitSetProducer;  
        }
            searcher.setQueryCache(null);
        result = 31 * result + shardId;  
            public boolean isCacheable(LeafReaderContext ctx) {  
import org.apache.lucene.search.Weight;
        while ((idTerm = iterator.next()) != null) {
    }
                    if (parentBitSet != null) {
                nextParentMatches = visitor.matches(nextParent);
    }
                            return shardId == targetShardId;
                        // if nested docs are involved we also need to mark all child docs that belong to a matching parent doc.
import org.opensearch.index.mapper.IdFieldMapper;
                    throw new IllegalStateException("Unexpected field: " + fieldInfo.name);
import org.apache.lucene.search.TwoPhaseIterator;  
                case RoutingFieldMapper.NAME:
                Terms terms = leafReader.terms(RoutingFieldMapper.NAME);
                        findSplitDocs(RoutingFieldMapper.NAME, ref -> {  
                            IntConsumer bitSetConsumer = maybeWrapConsumer.apply(bitSet::set);
            this.visitor = visitor;
import org.apache.lucene.util.BytesRef;
                default:  
            this.visitor = visitor;  
                    final BitSet parentBitSet;  
        public Status needsField(FieldInfo fieldInfo) throws IOException {  
            Scorer s = weight.scorer(context);  
     * executed on a recovery-private index writer. There is no point in caching it and it won't have a cache hit either.  
                    int targetShardId = OperationRouting.generateShardId(
                return "weight(delete docs query)";
import org.apache.lucene.util.BitSetIterator;
        private final Visitor visitor;
 *  
import org.opensearch.common.lucene.search.Queries;
            return s == null ? null : BitSet.of(s.iterator(), context.reader().maxDoc());
        final LeafReader leafReader;  
        if (shardId != that.shardId) return false;
            assert id != null : "docID must not be null - we might have hit a nested document";
            currentDeleted++;
    private final class Visitor extends StoredFieldVisitor {
                    // by ID and parent and nested all have the same id.
     * This TwoPhaseIterator marks all nested docs of matching parents as matches as well.  
        final Terms terms = leafReader.terms(idField);  
        throws IOException {
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
import org.apache.lucene.index.StoredFieldVisitor;  
     * @opensearch.internal
                        }
        private final BitSet parentDocs;  
                        if (terms.getDocCount() != leafReader.maxDoc()) {
        public boolean matches() throws IOException {
 * software distributed under the License is distributed on an
import org.apache.lucene.index.Terms;
                        Function<IntConsumer, IntConsumer> maybeWrapConsumer = consumer -> {
            final IndexSearcher searcher = new IndexSearcher(topLevelContext);  
        private int leftToVisit = 2;
import org.apache.lucene.search.ConstantScoreWeight;
            switch (fieldInfo.name) {
                        parentBitSet = null;
                        // this is the heaviest invariant. Here we have to visit all docs stored fields do extract _id and _routing
                        markChildDocs(parentBitSet, bitSet);  
import org.apache.lucene.index.ReaderUtil;
 * specific language governing permissions and limitations
        private boolean nextParentMatches;
                    leftToVisit--;
 *  
    public String toString(String field) {  
        Visitor(LeafReader leafReader) {  
            leftToVisit = 2;
                    }
                } else {
            return 42; // that's obvious, right?
                            }
                    }  
    public boolean equals(Object o) {
            switch (fieldInfo.name) {
                // anyway.
        return indexMetadata.equals(that.indexMetadata);  
    /**
import org.opensearch.index.mapper.Uid;
                        parentBitSet = nestedParentBitSetProducer.getBitSet(context);
        }
                return new DefaultScorerSupplier(scorer);
    /**
import org.apache.lucene.index.TermsEnum;
            if (includeInShard.test(idTerm) == false) {
    public int hashCode() {
            leafReader.storedFields().document(doc, this);  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
                        // we do a second pass to mark the corresponding children in markChildDocs  
import org.apache.lucene.search.IndexSearcher;  
 * GitHub history for details.
                            return null; // no matches  
import org.apache.lucene.index.LeafReaderContext;  
    @Override
import org.opensearch.cluster.routing.OperationRouting;  
            && (currentDeleted = matchingDocs.nextSetBit(currentDeleted)) != DocIdSetIterator.NO_MORE_DOCS) {
            return;
    @Override
 * license agreements. See the NOTICE file distributed with
    public void visit(QueryVisitor visitor) {  
            if (doc > nextParent) {  
                        // in the _routing case we first go and find all docs that have a routing value and mark the ones we have to delete
                        // with a routing value from the next iteration an delete / select based on the ID.  
 *    http://www.apache.org/licenses/LICENSE-2.0
                case RoutingFieldMapper.NAME:  
                Predicate<BytesRef> includeInShard = ref -> {  
                case IdFieldMapper.NAME:
        }
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) {  
        visitor.visitLeaf(this);
                                };
    }  
 *
    }
                        null
/*
        public void binaryField(FieldInfo fieldInfo, byte[] value) throws IOException {
                                }  
                                if (hasRoutingValue.get(docId) == false) {
        @Override
     * This two phase iterator visits every live doc and selects all docs that don't belong into this
        }
                    // this is the common case - no partitioning and no _routing values  
                    }
                        Visitor visitor = new Visitor(leafReader);  
                        indexMetadata,
                    } else {  
            @Override
                }
    private final IndexMetadata indexMetadata;
        private String id;
    /*  
                // we only check once per nested/parent set
            }
import org.apache.lucene.index.FieldInfo;  
            final Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
            public String toString() {  
                            ? new RoutingPartitionedDocIdSetIterator(visitor)
                    // in this case we also don't do anything special with regards to nested docs since we basically delete
 * @opensearch.internal
import org.apache.lucene.search.QueryVisitor;
     * than once. There is no point in using BitsetFilterCache#BitSetProducerWarmer since we use this only as a delete by query which is
    ShardSplittingQuery(IndexMetadata indexMetadata, int shardId, boolean hasNested) {
        NestedRoutingPartitionedDocIdSetIterator(Visitor visitor, BitSet parentDocs) {
 * KIND, either express or implied.  See the License for the
    private void markChildDocs(BitSet parentDocs, BitSet matchingDocs) {
                if (terms == null) {
 * not use this file except in compliance with the License.
                postingsEnum = iterator.postings(postingsEnum);  
        public void stringField(FieldInfo fieldInfo, String value) throws IOException {
    private static void findSplitDocs(String idField, Predicate<BytesRef> includeInShard, LeafReader leafReader, IntConsumer consumer)
       of a routing partitioned index sine otherwise we would need to un-invert the _id and _routing field which is memory heavy */
 * You may obtain a copy of the License at  
            Query query = Queries.newNonNestedFilter();
 * as deleted. See {@link org.apache.lucene.index.IndexWriter#deleteDocuments(Query...)}
                    break;
            int previousParent = parentDocs.prevSetBit(Math.max(0, currentDeleted - 1));  
            }  
 * under the License.  
        @Override  
            return nextParentMatches;  
        if (o == null || getClass() != o.getClass()) return false;
import java.io.IOException;  
            final IndexReaderContext topLevelContext = ReaderUtil.getTopLevelContext(context);
    private static BitSetProducer newParentDocBitSetProducer(Version indexVersionCreated) {
                            });
                        Uid.decodeId(ref.bytes, ref.offset, ref.length),  
            return 42; // that's obvious, right?
import java.util.function.Predicate;  
 * this work for additional information regarding copyright
        @Override
            int doc = approximation.docID();
 */
    @Override  
                        TwoPhaseIterator twoPhaseIterator = parentBitSet == null
        while (currentDeleted < matchingDocs.length()
        }  
import java.util.function.Function;
        ShardSplittingQuery that = (ShardSplittingQuery) o;  
            }
        }  
import org.apache.lucene.index.PostingsEnum;
import org.opensearch.Version;
            }  
                return false;  
            }  
     */  
                FixedBitSet bitSet = new FixedBitSet(leafReader.maxDoc());
import org.opensearch.cluster.metadata.IndexMetadata;
        };
 */
            }
     */
        RoutingPartitionedDocIdSetIterator(Visitor visitor) {
                    if (nestedParentBitSetProducer == null) {
    }
                    id = Uid.decodeId(value);
        public boolean matches() throws IOException {
    }  
            // the educated reader might ask why this works, it does because all live doc ids (root docs and nested docs) are evaluated in  
        PostingsEnum postingsEnum = null;  
                    assert indexMetadata.isRoutingPartitionedIndex() == false;  
 * It can be used to split a shard into N shards marking every document that doesn't belong into the shard
import java.util.function.IntConsumer;
                        // this index is routing partitioned.
 *
                            findSplitDocs(IdFieldMapper.NAME, includeInShard, leafReader, docId -> {  
                                    }  
        if (this == o) return true;  
import org.apache.lucene.util.FixedBitSet;  
                            int targetShardId = OperationRouting.generateShardId(indexMetadata, null, ref.utf8ToString());
            }
                        if (parentBitSet == null) {
        @Override  
            for (int i = previousParent + 1; i < currentDeleted; i++) {
        return new ConstantScoreWeight(this, boost) {
                        // this ensures that we are only marking root documents in the nested case and if necessary
                        }, leafReader, maybeWrapConsumer.apply(bitSet::set));  
/*  
import org.apache.lucene.search.join.BitSetProducer;
                    return leftToVisit == 0 ? Status.STOP : Status.NO;
    }  
        };
/*
            }
                                    bitSetConsumer.accept(docId);
            return targetShardId != shardId;  
import org.apache.lucene.index.LeafReader;
        public float matchCost() {  
    @Override
    private final int shardId;
                int doc;
 * A query that selects all docs that do NOT belong in the current shards this query is executed on.  
}  
                    return Status.YES;  
                default:
        this.nestedParentBitSetProducer = hasNested ? newParentDocBitSetProducer(indexMetadata.getCreationVersion()) : null;
        }  
        BytesRef idTerm;
     * shard based on their id and routing value. This is only used in a routing partitioned index.  
                            findSplitDocs(RoutingFieldMapper.NAME, ref -> false, leafReader, maybeWrapConsumer.apply(hasRoutingValue::set));
            super(DocIdSetIterator.all(visitor.leafReader.maxDoc())); // we iterate all live-docs
import org.apache.lucene.search.Scorer;
            super(DocIdSetIterator.all(visitor.leafReader.maxDoc())); // we iterate all live-docs
            return visitor.matches(approximation.docID());
    }
                        return new DefaultScorerSupplier(scorer);
import org.apache.lucene.util.BitSet;  
        if (terms == null) {
import org.apache.lucene.index.IndexReaderContext;
        this.indexMetadata = indexMetadata;  
        }
            this.leafReader = leafReader;
    }
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
        this.shardId = shardId;
                        // now if we have a mixed index where some docs have a _routing value and some don't we have to exclude the ones
                case IdFieldMapper.NAME:  
                            // this is a special case where some of the docs have no routing values this sucks but it's possible today
 */
                    return shardId == targetShardId;  
    }  
 * SPDX-License-Identifier: Apache-2.0
            // we don't support 5.x so no need for the uid field
                                    if (parentBitSet.get(docId)) {
            @Override
     *
                        final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, twoPhaseIterator);
                while ((doc = postingsEnum.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
                };
     */  
                LeafReader leafReader = context.reader();  
                }
                        };
        return "shard_splitting_query";
                default:
                    break;  
        boolean matches(int doc) throws IOException {  
        @Override
        private final Visitor visitor;
                        // here we potentially guard the docID consumers with our parent bitset if we have one.
                            FixedBitSet hasRoutingValue = new FixedBitSet(leafReader.maxDoc());  
        }
            this.parentDocs = parentDocs;  
    }  
                // never check a child document against the visitor, they neihter have _id nor _routing as stored fields  
import org.apache.lucene.search.ScoreMode;  
                    consumer.accept(doc);  
                            if (parentBitSet != null) {
        final TermsEnum iterator = terms.iterator();
            routing = id = null;
                                return docId -> {  
import org.apache.lucene.search.ScorerSupplier;
                    routing = value;
                // This is not a regular query, let's not cache it. It wouldn't help
            switch (fieldInfo.name) {  
                                        consumer.accept(docId);
                    findSplitDocs(IdFieldMapper.NAME, includeInShard, leafReader, bitSet::set);
                nextParent = parentDocs.nextSetBit(doc);
        }  
