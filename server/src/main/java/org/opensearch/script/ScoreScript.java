                return Explanation.match(score, description, subQueryExplanation);
        return value;
        return docBase + docId;
    /** A leaf lookup for the bound segment this script will operate on. */
 *
            this.leafLookup = null;
        }
        } else {
    }
 * GitHub history for details.
     */
 * Licensed to Elasticsearch under one or more contributor
     * delegate to the returned bulk scorer instead of scoring documents one at a time.
 * this file be licensed under the Apache-2.0 license or a
    public static final String[] PARAMETERS = new String[] { "explanation" };
     * A factory to construct stateful {@link ScoreScript} factories for a specific index.
        private String description;
import java.util.function.DoubleSupplier;
         * @param boost              the boost factor to apply to scores
     *
    }
    /**
 * A script used for adjusting the score on a per document basis.
            return Explanation.match(score, description);
         *       for this segment. The implementation takes ownership of {@code subQueryBulkScorer}
    /**
    /**
        // null check needed b/c of expression engine subclass
    }
package org.opensearch.script;
    /**
    private static final Map<String, Function<Object, Object>> PARAMS_FUNCTIONS = Map.of("doc", value -> {
    }
 * SPDX-License-Identifier: Apache-2.0
        }
        public void set(String description) {
    }
            return indexName;
    public Map<String, ScriptDocValues<?>> getDoc() {
    public static class ExplanationHolder {
        deprecationLogger.deprecate(
        if (shardId > -1) {
    }
    /**
        this.shardId = shardId;
 * not use this file except in compliance with the License.
    /** Return the parameters for this script. */
        this.indexName = indexName;
        leafLookup.setDocument(docid);
    public double get_score() {
     */
            "Accessing variable [doc] via [params.doc] from within an score-script " + "is deprecated in favor of directly accessing [doc]."
            return shardId;
 * Modifications Copyright OpenSearch Contributors. See
            this.leafTermFrequencyLookup = null;
import org.opensearch.Version;
         * @param description A textual description of how the score was calculated
            throw new IllegalArgumentException("index name can not be looked up!");
        }
         *
 * under the License.
    /** A leaf term frequency lookup for the bound segment this script will operate on. */
 * license agreements. See the NOTICE file distributed with
     * Extension of {@link LeafFactory} that allows a script engine to provide a custom
     *  Starting a name with underscore, so that the user cannot access this function directly through a script
            float boost
            if (description == null) {
    }
        public Explanation get(double score, Explanation subQueryExplanation) {
     * @return the internal document ID with the base
            if (subQueryExplanation != null) {
        return params;
     *  Starting a name with underscore, so that the user cannot access this function directly through a script
        }
        }
            params.putAll(leafLookup.asMap());
     * @opensearch.internal
 */
            throw new IllegalArgumentException("shard id can not be looked up!");
    private int shardId = -1;
        ScoreScript.LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup, IndexSearcher indexSearcher);
     */
import org.apache.lucene.search.IndexSearcher;
import java.util.function.Function;
     * Starting a name with underscore, so that the user cannot access this function directly through a script
    public Version _getIndexVersion() {
         *   <li>{@code subQueryBulkScorer} is guaranteed non-null by the caller.</li>
         */
            params = new HashMap<>(params);
     *  It is only used within predefined painless functions.
    public void _setIndexName(String indexName) {
    }
     */
    /**
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
     *  Starting a name with underscore, so that the user cannot access this function directly through a script
        /**
/**
public abstract class ScoreScript {
            this.description = description;
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }, "_source", value -> ((SourceLookup) value).loadSourceIfNeeded());
    public Map<String, Object> getParams() {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DynamicMap.class);
     * {@code ScriptScoreBulkScorer}. It is responsible for honoring all scoring semantics including
/*
     */
    public int _getDocBaseId() {
/*
        return docId;
    private final int docBase;
import java.io.IOException;
    /**
         *       scoring path. The {@code subQueryBulkScorer} remains unconsumed and will be used by
         * Return {@code true} if the script needs {@code _score} calculated, or {@code false} otherwise.
     * A factory to construct {@link ScoreScript} instances.
        this.scoreSupplier = () -> {
            "score-script__doc",
import org.apache.lucene.index.LeafReaderContext;
            final ScoreMode subQueryScoreMode,
        if (indexName != null) {
     *
 * KIND, either express or implied.  See the License for the
 *
     * A helper to take in an explanation from a script and turn it into an {@link org.apache.lucene.search.Explanation}
        ) throws IOException;
import org.opensearch.index.fielddata.ScriptDocValues;
}
 * You may obtain a copy of the License at
import org.opensearch.search.lookup.SourceLookup;
    }
                throw new UncheckedIOException(e);
            "score-script_doc",
 */
        }
         *       provided {@code boost} applied.</li>
         *
    public interface LeafFactory {
     *  Starting a name with underscore, so that the user cannot access this function directly through a script
     * the per-document scoring path via {@link #newInstance(LeafReaderContext)}. Implementations must
         *       the fallback scorer.</li>
    /** Set the current document to run the script on next. */
     * It is only used within predefined painless functions.
    /**
 */
     *  Starting a name with underscore, so that the user cannot access this function directly through a script
    /**
        return value;
         * Explain the current score.
 * ownership. Elasticsearch licenses this file to you under
    }
    /**
    public void _setShard(int shardId) {
 */
            final LeafReaderContext context,
    public void _setIndexVersion(Version indexVersion) {
        ScoreScript newInstance(LeafReaderContext ctx) throws IOException;
import java.util.Map;
     */
    /**
         */
         * @param context            the leaf reader context for this segment
     *  Starting a name with underscore, so that the user cannot access this function directly through a script
                return null;
 * @opensearch.internal
    private final LeafSearchLookup leafLookup;
    public interface BulkScoringLeafFactory extends LeafFactory {
        this.docId = docid;
     * ensure that the per-doc scorer and the bulk scorer produce consistent scores for the same
        } else {
         * Create a BulkScorer that scores documents in batches for improved I/O efficiency.
     */
            this.leafTermFrequencyLookup = new LeafTermFrequencyLookup(indexSearcher, leafLookup);
     * @return the score of the inner query
            final BulkScorer subQueryBulkScorer,
     *
            try {
            }
     * This enables optimizations such as batched I/O prefetch and vectorized distance computation.
         * @return a BulkScorer, or null to fall back to default per-document scoring
        return leafTermFrequencyLookup.getTermFrequency(functionName, field, val, docId);
            this.docBase = 0;
         *       and is responsible for driving or discarding it.</li>
import org.apache.lucene.search.Explanation;
         *   <li>If this method returns a non-null {@link BulkScorer}, the caller uses it exclusively
import org.opensearch.search.lookup.LeafTermFrequencyLookup;
            this.leafLookup = lookup.getLeafSearchLookup(leafContext);
 * software distributed under the License is distributed on an
    }
    public void setDocument(int docid) {
     * Accessed as _score in the painless script
    public String _getIndex() {
            this.params = new DynamicMap(params, PARAMS_FUNCTIONS);
     * @return shard id or throws an exception if shard is not set up for this script instance
        deprecationLogger.deprecate(
import org.apache.lucene.search.Scorable;
        /**
        return leafLookup.doc();
            }
            }
     * <p><b>Score mode contract:</b> The returned {@link BulkScorer} fully replaces the default
    public int _getShardId() {
            this.docBase = leafContext.docBase;
import org.opensearch.search.lookup.SearchLookup;
     * score validation (non-negative, non-NaN) and applying the boost factor. The caller does not
     * @return index version or throws an exception if the index version is not set up for this script instance
 *
    }
         * @param subQueryBulkScorer the sub-query's BulkScorer that drives document iteration (never null)
    private String indexName = null;
 * the Apache License, Version 2.0 (the "License"); you may
     * <p><b>Explain contract:</b> The {@code explain()} path in {@code ScriptScoreQuery} always uses
 * Unless required by applicable law or agreed to in writing,
         * @param subQueryScoreMode  the score mode of the sub-query
     * @opensearch.internal
        this.indexVersion = indexVersion;
     */
         * </ul>
        /**
         * <ul>
     * @return index name or throws an exception if the index name is not set up for this script instance
        if (lookup == null) {
     */
    private final Map<String, Object> params;
import org.opensearch.search.lookup.LeafSearchLookup;
     * @return the internal document ID
 * The OpenSearch Contributors require contributions made to
         *   <li>The returned scorer must produce valid scores: non-negative, non-NaN, with the
    public static final ScriptContext<ScoreScript.Factory> CONTEXT = new ScriptContext<>("score", ScoreScript.Factory.class);
     * @opensearch.internal
    }
                + "is deprecated in favor of directly accessing [doc]."
import org.apache.lucene.search.ScoreMode;
    public int _getDocId() {
    /** The doc lookup for the Lucene segment this script was created for. */
    public void setScorer(Scorable scorer) {
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
         */
         * <p><b>Contract:</b>
     * apply any additional score transformations on top of the returned scorer's output.
    public abstract double execute(ExplanationHolder explanation);
    }
    private Version indexVersion = null;
     */
    public Object getTermFrequency(TermFrequencyFunctionName functionName, String field, String val) throws IOException {
    /**
    private final LeafTermFrequencyLookup leafTermFrequencyLookup;
        };
            "Accessing variable [doc] via [params._doc] from within an score-script "
    private int docId;
         * @throws IOException if an I/O error occurs
        } else {
     * Starting a name with underscore, so that the user cannot access this function directly through a script
     *  It is only used within predefined painless functions.
 *
     *
    }, "_doc", value -> {
import org.apache.lucene.search.BulkScorer;
         *   <li>If this method returns {@code null}, the caller falls back to the default per-document
    public ScoreScript(Map<String, Object> params, SearchLookup lookup, IndexSearcher indexSearcher, LeafReaderContext leafContext) {
import java.util.HashMap;
    private DoubleSupplier scoreSupplier = () -> 0.0;
        BulkScorer bulkScorer(
    }
import org.opensearch.common.logging.DeprecationLogger;
    }
     * {@link BulkScorer} for batch scoring. When implemented, {@code ScriptScoreQuery} will
import java.io.UncheckedIOException;
            this.params = null;
 * compatible open source license.
                return scorer.score();
     *
    }
     * It is only used within predefined painless functions.
        );
    /** The generic runtime parameters for the script. */
         *
     * @opensearch.internal
            assert params == null;
/*
     * document, so that explain output accurately reflects actual query scores.
        );
            throw new IllegalArgumentException("index version can not be looked up!");
            return indexVersion;
            } catch (IOException e) {
        return scoreSupplier.getAsDouble();
import org.opensearch.index.query.functionscore.TermFrequencyFunctionFactory.TermFrequencyFunctionName;
    }
            assert leafContext == null;
    public interface Factory extends ScriptFactory {
        } else {
        if (indexVersion != null) {
     */
        boolean needs_score();
     */
    /**
    }
     *  It is only used within predefined painless functions.
