            final BulkScorer subQueryBulkScorer,
import java.io.IOException;  
            params.putAll(leafLookup.asMap());  
         * @return a BulkScorer, or null to fall back to default per-document scoring
 * KIND, either express or implied.  See the License for the
            params = new HashMap<>(params);
     * @return the score of the inner query
    private String indexName = null;
    public double get_score() {  
    /** Return the parameters for this script. */
     */  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
         */
     *  
    }  
import org.opensearch.search.lookup.SearchLookup;  
    public Map<String, Object> getParams() {  
            this.leafLookup = lookup.getLeafSearchLookup(leafContext);  
 * not use this file except in compliance with the License.
            float boost  
     * @return shard id or throws an exception if shard is not set up for this script instance
     * @return index name or throws an exception if the index name is not set up for this script instance
            }
import org.opensearch.index.fielddata.ScriptDocValues;
    /**
                return Explanation.match(score, description, subQueryExplanation);  
     * @opensearch.internal
import org.apache.lucene.search.BulkScorer;
 * compatible open source license.
    public int _getDocBaseId() {  
    }
    public void setScorer(Scorable scorer) {
            "score-script__doc",  
    private final LeafTermFrequencyLookup leafTermFrequencyLookup;
            throw new IllegalArgumentException("index name can not be looked up!");
     *  Starting a name with underscore, so that the user cannot access this function directly through a script
            if (subQueryExplanation != null) {
     */
         *
import org.apache.lucene.search.IndexSearcher;  
        }  
         * Explain the current score.
         *   <li>If this method returns a non-null {@link BulkScorer}, the caller uses it exclusively  
    public Map<String, ScriptDocValues<?>> getDoc() {
            this.leafLookup = null;
            "score-script_doc",  
    private int docId;  
 * license agreements. See the NOTICE file distributed with
 *  
     *  It is only used within predefined painless functions.
            throw new IllegalArgumentException("shard id can not be looked up!");
    }
 * The OpenSearch Contributors require contributions made to  
     *  
     * the per-document scoring path via {@link #newInstance(LeafReaderContext)}. Implementations must
import java.util.Map;  
            if (description == null) {
     * A factory to construct stateful {@link ScoreScript} factories for a specific index.
import org.opensearch.common.logging.DeprecationLogger;
    /** Set the current document to run the script on next. */
        if (indexVersion != null) {  
         *       and is responsible for driving or discarding it.</li>
         * @param context            the leaf reader context for this segment
    /**  
    /** A leaf lookup for the bound segment this script will operate on. */  
            this.description = description;
    /** A leaf term frequency lookup for the bound segment this script will operate on. */  
         *  
     * document, so that explain output accurately reflects actual query scores.  
    private Version indexVersion = null;  
    public ScoreScript(Map<String, Object> params, SearchLookup lookup, IndexSearcher indexSearcher, LeafReaderContext leafContext) {
            assert leafContext == null;  
import org.apache.lucene.search.Explanation;
    public static final ScriptContext<ScoreScript.Factory> CONTEXT = new ScriptContext<>("score", ScoreScript.Factory.class);  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DynamicMap.class);  
 *
            this.docBase = 0;
     * This enables optimizations such as batched I/O prefetch and vectorized distance computation.
    public void _setIndexName(String indexName) {
 */
        } else {
     *  It is only used within predefined painless functions.  
     * A helper to take in an explanation from a script and turn it into an {@link org.apache.lucene.search.Explanation}  
         * </ul>
    }
import java.util.function.DoubleSupplier;
     * @opensearch.internal
            final ScoreMode subQueryScoreMode,
    /**
    public interface BulkScoringLeafFactory extends LeafFactory {
    }, "_doc", value -> {
    public int _getShardId() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
     */
         *  
     *  Starting a name with underscore, so that the user cannot access this function directly through a script
        return value;
 */
    private static final Map<String, Function<Object, Object>> PARAMS_FUNCTIONS = Map.of("doc", value -> {
    /**
        private String description;
         * @throws IOException if an I/O error occurs  
        if (indexName != null) {
/*
    /** The generic runtime parameters for the script. */  
    }
        /**
         *   <li>{@code subQueryBulkScorer} is guaranteed non-null by the caller.</li>
        };
     *
            final LeafReaderContext context,  
         *       the fallback scorer.</li>
     */  
     * <p><b>Score mode contract:</b> The returned {@link BulkScorer} fully replaces the default
/*  
        leafLookup.setDocument(docid);
        }
    /** The doc lookup for the Lucene segment this script was created for. */
        }  
     * Starting a name with underscore, so that the user cannot access this function directly through a script
    private final LeafSearchLookup leafLookup;
    public interface Factory extends ScriptFactory {  
     */
 *  
     * score validation (non-negative, non-NaN) and applying the boost factor. The caller does not  
                + "is deprecated in favor of directly accessing [doc]."
import java.io.UncheckedIOException;
         * <p><b>Contract:</b>  
import java.util.function.Function;
    /**
        } else {
     *
     * @return index version or throws an exception if the index version is not set up for this script instance  
            this.leafTermFrequencyLookup = new LeafTermFrequencyLookup(indexSearcher, leafLookup);
     * @return the internal document ID with the base
    public Object getTermFrequency(TermFrequencyFunctionName functionName, String field, String val) throws IOException {  
        BulkScorer bulkScorer(
public abstract class ScoreScript {  
            } catch (IOException e) {
     */
            assert params == null;
import org.opensearch.Version;  
     * ensure that the per-doc scorer and the bulk scorer produce consistent scores for the same
         * @param boost              the boost factor to apply to scores
         *       scoring path. The {@code subQueryBulkScorer} remains unconsumed and will be used by
 * under the License.  
import org.apache.lucene.index.LeafReaderContext;  
        deprecationLogger.deprecate(
        return leafLookup.doc();  
    public String _getIndex() {
    }
        this.indexName = indexName;  
         * Create a BulkScorer that scores documents in batches for improved I/O efficiency.
    }, "_source", value -> ((SourceLookup) value).loadSourceIfNeeded());
     * It is only used within predefined painless functions.  
            try {  
import org.opensearch.search.lookup.LeafSearchLookup;
     * @return the internal document ID
 */  
    }
         * Return {@code true} if the script needs {@code _score} calculated, or {@code false} otherwise.  
        ScoreScript.LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup, IndexSearcher indexSearcher);
     *
            "Accessing variable [doc] via [params._doc] from within an score-script "
    /**
         */
         */
/*
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
        public Explanation get(double score, Explanation subQueryExplanation) {
    public void setDocument(int docid) {
        /**
     * {@code ScriptScoreBulkScorer}. It is responsible for honoring all scoring semantics including
        return value;  
         * @param description A textual description of how the score was calculated
    /**
    }
    public static final String[] PARAMETERS = new String[] { "explanation" };
     *  Starting a name with underscore, so that the user cannot access this function directly through a script  
 * ownership. Elasticsearch licenses this file to you under  
         * <ul>
        this.shardId = shardId;
            throw new IllegalArgumentException("index version can not be looked up!");  
                throw new UncheckedIOException(e);  
        this.scoreSupplier = () -> {
 * specific language governing permissions and limitations
     *  
         * @param subQueryScoreMode  the score mode of the sub-query  
     * Starting a name with underscore, so that the user cannot access this function directly through a script
        // null check needed b/c of expression engine subclass  
     * A factory to construct {@link ScoreScript} instances.
    public interface LeafFactory {  
        );  
    private final Map<String, Object> params;
     * Accessed as _score in the painless script  
        } else {
 * this work for additional information regarding copyright
    /**
         *   <li>If this method returns {@code null}, the caller falls back to the default per-document  
            }
        return leafTermFrequencyLookup.getTermFrequency(functionName, field, val, docId);
        boolean needs_score();
     */
     */  
 * this file be licensed under the Apache-2.0 license or a
    /**
    public void _setShard(int shardId) {
    }
import org.opensearch.search.lookup.SourceLookup;
    public int _getDocId() {  
    private int shardId = -1;
    public abstract double execute(ExplanationHolder explanation);  
         *   <li>The returned scorer must produce valid scores: non-negative, non-NaN, with the  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
     */
         *       provided {@code boost} applied.</li>
     *  Starting a name with underscore, so that the user cannot access this function directly through a script  
import org.apache.lucene.search.Scorable;
    /**
        if (shardId > -1) {
        this.docId = docid;  
        } else {  
         *       for this segment. The implementation takes ownership of {@code subQueryBulkScorer}
 * Unless required by applicable law or agreed to in writing,
     *  Starting a name with underscore, so that the user cannot access this function directly through a script
     */
 * You may obtain a copy of the License at  
            this.params = null;
            this.leafTermFrequencyLookup = null;  
    }
        }  
        ) throws IOException;
    /**
    }
        return params;
        if (lookup == null) {
import org.opensearch.index.query.functionscore.TermFrequencyFunctionFactory.TermFrequencyFunctionName;  
        }
 *
            this.docBase = leafContext.docBase;
        return docBase + docId;
     * <p><b>Explain contract:</b> The {@code explain()} path in {@code ScriptScoreQuery} always uses  
        this.indexVersion = indexVersion;
    public Version _getIndexVersion() {
     * apply any additional score transformations on top of the returned scorer's output.
     * Extension of {@link LeafFactory} that allows a script engine to provide a custom
    }  
            return indexName;  
     * @opensearch.internal
import java.util.HashMap;
import org.apache.lucene.search.ScoreMode;
                return scorer.score();
    }
    public static class ExplanationHolder {
    /**  
        deprecationLogger.deprecate(
    /**
        return docId;
                return null;  
    public void _setIndexVersion(Version indexVersion) {  
    private DoubleSupplier scoreSupplier = () -> 0.0;  
        }
 * @opensearch.internal
     * delegate to the returned bulk scorer instead of scoring documents one at a time.
    }
            }
     * @opensearch.internal
 */
        );
     */  
        return scoreSupplier.getAsDouble();
         * @param subQueryBulkScorer the sub-query's BulkScorer that drives document iteration (never null)
        public void set(String description) {  
        ScoreScript newInstance(LeafReaderContext ctx) throws IOException;
 * A script used for adjusting the score on a per document basis.
            this.params = new DynamicMap(params, PARAMS_FUNCTIONS);
    }
    }
     * It is only used within predefined painless functions.  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.script;
    }
}
            "Accessing variable [doc] via [params.doc] from within an score-script " + "is deprecated in favor of directly accessing [doc]."
 * software distributed under the License is distributed on an
            return indexVersion;
    private final int docBase;
        /**  
            return Explanation.match(score, description);
            return shardId;
     *  Starting a name with underscore, so that the user cannot access this function directly through a script
import org.opensearch.search.lookup.LeafTermFrequencyLookup;
    }
     *  It is only used within predefined painless functions.
     */
     * {@link BulkScorer} for batch scoring. When implemented, {@code ScriptScoreQuery} will  
/**
