                // pick lowest msm:
            boolean verified = isVerified(query);
                    msm += clauses.get(i);  
            return conjunctionsWithUnknowns.get(0);  
import org.apache.lucene.search.Query;
     *  - `matchAllDocs` is true
            this.verified = isVerified(parent);
                    return result2.unverify();  
        List<Result> conjunctions = conjunctionsWithUnknowns.stream().filter(r -> r.isUnknown() == false).collect(Collectors.toList());
        boolean matchAllDocs = true;
            return Integer.MIN_VALUE;
        // never match.  
        boolean hasTerm = false;
     * by picking up clauses that look most restrictive and making it unverified if  
    static class QueryExtraction {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // Keep track of the msm for each clause:
    }
            return result;
            }
        final Term term;  
        byte[] upperPoint = query.getUpperPoint();  
        boolean isUnknown() {
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (queryExtraction.range != null) {
                    break;
     * The query analyzer doesn't always extract all terms from the specified query. For example from a  
                    // in the CoveringQuery. Therefore right now the minimum should match is only incremented once per
     * @param indexVersion  The create version of the index containing the percolator queries.
            Result result = result1;
        Set<String> seenRangeFields = new HashSet<>();  
            }  
                result = conjunction  
            }  
                minimumShouldMatch = bq.getMinimumNumberShouldMatch();  
        }
        if (disjunctions.stream().anyMatch(Result::isUnknown)) {
    private static boolean isVerified(Query query) {  
        }
     */
                    // incrementing msm, because that could lead to valid matches not becoming candidate matches:
        query.visit(builder);
import org.opensearch.Version;
import org.opensearch.lucene.queries.BlendedTermQuery;
            return new Result(matchAllDocs, verified);
        final String fieldName;
        }  
import java.util.Arrays;
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
     * percolator queries that we know would otherwise never match.
                }
        if (conjunctionsWithUnknowns.size() == 1) {
    }
                } else {
        }
                    && bq.clauses().stream().anyMatch(c -> c.occur() == Occur.MUST || c.occur() == Occur.FILTER)) {  
     * When extracting the terms for the specified query, we can also determine if the percolator query is
                throw new IllegalArgumentException("Must have at least one conjunction sub result");
                } else if (extraction2SmallestRange == null) {
            this.range = range;
            // When there are duplicated query extractions, percolator can no longer reliably determine msm across this disjunction
                        verified = false;
            return result;  
        }  
            }
                    return result1.unverify();
        );
            }  
        @Override  
            }  
                    this.terms.add(new Result(true, qe, 1));
        public QueryVisitor getSubVisitor(Occur occur, Query parent) {
     * matches. This allows the percolate query to skip the expensive memory index verification step that
import java.util.List;
        final Set<QueryExtraction> extractions;
                if (clause.term != null) {
                this.terms.add(new Result(verified, qe, conjunction ? qe.size() : 1));
                    // previously processed extractions, and don't add to the seenRangeFields list until all
                return false;
        }
            @Override
                    ? handleConjunction(partialResults, version)
        // extracted term and field value from a percolator document may have more 'weight' than others.
     * always going to match. For example if a percolator query just contains a term query or a disjunction
                case null, default -> terms.add(Result.UNKNOWN);
                    }  
        @Override
                }
                return QueryVisitor.EMPTY_VISITOR;  
        // so for now lets not do it.
                }  
/*  
        boolean hasRange = false;
     * <p>
                        resultMsm = Math.max(0, resultMsm - 1);
        for (Result result : conjunctions) {
            boolean isMatchNoDocs() {
                && Arrays.equals(lowerPoint, range.lowerPoint)
        final BytesRef interval;
            return term != null ? term.bytes() : null;  
        int offset = BinaryRange.BYTES - original.length;  
        // If upper is really smaller than lower then we deal with like MatchNoDocsQuery. (verified and no extractions)  
            if (children.isEmpty() == false) {  
 * specific language governing permissions and limitations
            boolean onlyRangeBasedExtractions = true;  
            }
            return "Range{" + ", fieldName='" + fieldName + '\'' + ", interval=" + interval + '}';
            } else {
                return QueryVisitor.EMPTY_VISITOR;
        } else {  
            this(false, verified, extractions, minimumShouldMatch);
    private static Result handleConjunction(List<Result> conjunctionsWithUnknowns, Version version) {  
        int msm = 0;
            if (o == null || getClass() != o.getClass()) return false;
        return false;  
        byte[] lowerPoint = query.getLowerPoint();
                if (terms.add(extraction) == false) {
                    // extractions from this result are processed  
        };  
import org.apache.lucene.queries.spans.SpanTermQuery;
import org.apache.lucene.search.SynonymQuery;
            result.extractions.stream().map(e -> e.range).filter(Objects::nonNull).map(e -> e.fieldName).forEach(seenRangeFields::add);  
            if (conjunctionsWithUnknowns.isEmpty()) {  
            if (query instanceof TermInSetQuery q) {
import java.util.function.Supplier;
            if (hasRangeExtractions == false) {
        // In case that there are duplicate extracted terms / ranges then the msm should always be equal to the clause
        }  
                }
                || subResult.minimumShouldMatch > 1  
import org.opensearch.index.query.DateRangeIncludingNowQuery;
                    // number field when processing the percolator query at index time.
        Result(boolean matchAllDocs, boolean verified, Set<QueryExtraction> extractions, int minimumShouldMatch) {
        final Version version;  
            SpanOrQuery.class,  
                case PointRangeQuery pointRangeQuery -> terms.add(pointRangeQuery(pointRangeQuery));
        BytesRef bytes() {
/*
import org.apache.lucene.util.BytesRefIterator;
import org.apache.lucene.util.NumericUtils;  
    }  
                if (clause.term != null) {
        // If there are no terms but there are ranges, return Integer.MIN_VALUE  
            this.interval = new BytesRef(interval);
            if (subResult.matchAllDocs) {  
                    onlyRangeBasedExtractions = false;  
                    hasDuplicateTerms = true;
            int result = 1;
            return matchAllDocs == false && extractions.isEmpty();  
     *
    static class Range {
                return "UNKNOWN";
                    if (extractions.contains(queryExtraction)) {
        } else {
            Set<QueryExtraction> qe = Arrays.stream(terms).map(QueryExtraction::new).collect(Collectors.toSet());  
        public boolean equals(Object o) {  
        @Override
        for (Result subResult : conjunctions) {
                this.verified = false;  
            for (QueryExtraction clause : result1.extractions) {
        for (QueryExtraction qt : extractions) {
     * query then when the candidate query matches with that, we know the entire percolator query always  
import org.apache.lucene.search.QueryVisitor;  
            if (parent instanceof BooleanQuery bq) {
        for (QueryExtraction qt : terms) {
            ConstantScoreQuery.class,  
            if (cls.isAssignableFrom(query.getClass())) {
        @Override
        Result(boolean matchAllDocs, boolean verified) {
            if (qe.size() > 0) {
                int extraction2ShortestTerm = minTermLength(result2.extractions);
        // Example document2: value3  
                    // doc: field: val1 val2 val3  
            return term != null ? term.text() : null;
            }
            if (verified == false) {
                return subResult;
                    }
                    // minimum_should_match for that percolator query like for a term based extraction,
     *  - `extractions` and the document have `minimumShouldMatch` terms in common
                    : handleDisjunction(partialResults, minimumShouldMatch, version);
    }
        if (matchAllDocs) {  
     * Return an extraction for the conjunction of {@code result1} and {@code result2}
                    onlyRangeBasedExtractions = false;  
            this.term = term;
        for (int i = 0; i < disjunctions.size(); i++) {
import org.apache.lucene.queries.spans.SpanOrQuery;
                // Keep the clause with smallest range, this is likely to be the rarest.
     * @param query         The query to analyze.  
            }
            if (subResult.verified == false  
import org.apache.lucene.search.PointRangeQuery;
     * Sometimes the query analyzer can't always extract terms or ranges from a sub query, if that happens then
                int extraction1ShortestTerm = minTermLength(result1.extractions);  
                }
            return result1;  
                    return QueryVisitor.EMPTY_VISITOR;
        // In the above example query the extracted msm would be 3  
                terms.add(Result.UNKNOWN);
        }
 *
            }
     * this query in such a way that the PercolatorQuery always verifies if this query with the MemoryIndex.
            }
                for (int i = 0; i < limit; i++) {
package org.opensearch.percolator;
import java.util.Collections;  
 * Licensed to Elasticsearch under one or more contributor  
            for (QueryExtraction queryExtraction : result.extractions) {
        }  
        }
                    // query: (field:val1 AND field:val2) AND (field:val2 AND field:val3)
            result += 31 * fieldName.hashCode();  
                    // than term based queries.  
                return true;
                    verified = false;  
        }
        } else {
        )  
                verified = false;
        // Need to check whether upper is not smaller than lower, otherwise NumericUtils.subtract(...) fails IAE
                    if (seenRangeFields.contains(queryExtraction.range.fieldName)) {
    static Result analyze(Query query, Version indexVersion) {  
        return min;
            if (o == null || getClass() != o.getClass()) return false;
    }
            return Objects.equals(term, queryExtraction.term) && Objects.equals(range, queryExtraction.range);  
        final Range range;
            } else {
            if (verified) {  
            this.matchAllDocs = matchAllDocs;
            // Figure out what the combined msm is for this disjunction:
    static Result selectBestResult(Result result1, Result result2) {
                    }
            }  
            return result;  
                return true;  
                hasTerm = true;
        }
        }
            int minimumShouldMatch = 0;  
import java.util.stream.Collectors;  
            return disjunctions.get(0);  
        public int hashCode() {
import org.apache.lucene.search.TermQuery;  
    private static class ResultBuilder extends QueryVisitor {  
        public String toString() {  
     * since that those terms are likely to be the rarest. Boolean query's must_not clauses are always ignored.
        System.arraycopy(original, 0, result, offset, original.length);
            return extractions.toString();
 * under the License.  
        if (disjunctions.size() == 1) {
            BoostQuery.class,
        ResultBuilder builder = new ResultBuilder(indexVersion, false);
                // one of the sub queries requires more than one term to match, we can't
                && approximateScoreQuery.getOriginalQuery() instanceof DateRangeIncludingNowQuery) {
            Result result = result2;
        }  
 *  
 * compatible open source license.
                }  
        }
}  
        static final Result UNKNOWN = new Result(false, false, Collections.emptySet(), 0) {  
        boolean matchAllDocs = numMatchAllClauses > 0 && numMatchAllClauses >= requiredShouldClauses;  
                    return result2.unverify();  
        }
                if (extraction1ShortestTerm >= extraction2ShortestTerm) {  
 * Unless required by applicable law or agreed to in writing,
 */  
                case MatchAllDocsQuery ignored -> terms.add(new Result(true, true));
     */  
        if (!hasTerm && hasRange) {
        }
            return Objects.equals(fieldName, range.fieldName)
        final boolean matchAllDocs;
            return new Result(verified, extractions, msm);  
 * SPDX-License-Identifier: Apache-2.0
            this.term = null;  
            // (sum the lowest required clauses, otherwise we're too strict and queries may not match)
        byte[] result = new byte[BinaryRange.BYTES];
            return "QueryExtraction{" + "term=" + term + ",range=" + range + '}';
            return result;  
        Arrays.asList(
            if (qt.range != null) {
            extractions.addAll(result.extractions);  
                case MatchNoDocsQuery ignored -> terms.add(Result.MATCH_NONE);  
                    // more range queries on the same field, then the minimum should match can be higher than clauses  
        public void consumeTerms(Query query, Term... terms) {
     *
            }
     * Extracts terms and ranges from the provided query. These terms and ranges are stored with the percolator query and
                numMatchAllClauses++;
                partialResults.addAll(terms);
            SynonymQuery.class,
            }
 *
        }
        // With the msm and extracted terms this would match and is expected behaviour
 * Modifications Copyright OpenSearch Contributors. See  
                result = result.unverify();
     *
        public boolean equals(Object o) {
        return min;
import org.apache.lucene.search.ConstantScoreQuery;  
        public String toString() {
     * Query extraction result. A result is a candidate for a given document either if:  
                        verified = false;  
                    min = qt.range.interval;
                    BytesRef term;
        @Override  
            Result subResult = disjunctions.get(i);
                    break;
        }  
        final boolean conjunction;
        NumericUtils.subtract(16, 0, prepad(upperPoint), prepad(lowerPoint), interval);  
            BooleanQuery.class,
import org.opensearch.search.approximate.ApproximateScoreQuery;  
                hasRangeExtractions = subResult.extractions.stream().anyMatch(qe -> qe.range != null);
                } else {
        }  
                || result.minimumShouldMatch < result.extractions.size()) {
        for (Class<?> cls : verifiedQueries) {
        Set<QueryExtraction> extractions = new HashSet<>();
    /**  
        final byte[] upperPoint;  
import java.util.Objects;  
            if (result.verified == false
            int resultMsm = subResult.minimumShouldMatch;  
            matchAllDocs &= result.matchAllDocs;
                return verified ? Result.MATCH_NONE : Result.UNKNOWN;  
        return new Result(
                && Arrays.equals(upperPoint, range.upperPoint);  
        if (new BytesRef(lowerPoint).compareTo(new BytesRef(upperPoint)) > 0) {
            }  
            return Result.UNKNOWN;  
import java.io.IOException;
        Range(String fieldName, byte[] lowerPoint, byte[] upperPoint, byte[] interval) {  
        final int minimumShouldMatch;
            if (terms.size() > 0) {  
    }
        @Override  
                result = result.unverify();
    /**
                    // so that can lead to more false positives for percolator queries with range queries
import java.util.HashSet;
            this.lowerPoint = lowerPoint;
            children.add(child);
            msm = 1;
            clauses = clauses.stream().filter(val -> val > 0).sorted().collect(Collectors.toList());  
     * query analysis is stopped and an UnsupportedQueryException is thrown. So that the caller can mark  
        if (hasRangeExtractions == false) {
                min = Math.min(min, qt.bytes().length);
        String field() {
        if (query instanceof FunctionScoreQuery functionScoreQuery) {
            }
            return (conjunction ? "CONJ" : "DISJ") + children + terms + "~" + minimumShouldMatch;
     * used by the percolate query's candidate query as fields to be query by. The candidate query
            }  
            this.verified = verified;  
            this.range = null;
                int limit = Math.min(clauses.size(), Math.max(1, requiredShouldClauses));
        }  
import org.apache.lucene.util.BytesRef;
        } else if (result2.matchAllDocs) { // conjunction with match_all
    }
        @Override  
                children.add(builder);
            false,
 * GitHub history for details.
        Set<QueryExtraction> terms = new HashSet<>();  
                result = partialResults.get(0);
 * software distributed under the License is distributed on an
     * 6.0.0 indices which didn't use the terms_set query.
     *  Further more, the match doesn't need to be verified if `verified` is true, checking  
        public void consumeTermsMatching(Query query, String field, Supplier<ByteRunAutomaton> automaton) {
        if (conjunctions.isEmpty()) {
            Range range = (Range) o;  
            boolean isUnknown() {
    /**
            public String toString() {  
            }  
            BlendedTermQuery.class
final class QueryAnalyzer {
                    // percolated. Per field a single range is extracted and if a percolator query has two or
            for (QueryExtraction extraction : subResult.extractions) {
                msm = clauses.get(0);
        }  
        boolean hasRangeExtractions = false;  
        BytesRef min = null;  
                    "minimumShouldMatch can't be greater than the number of extractions: " + minimumShouldMatch + " > " + extractions.size()
                    // In case that there are duplicate term query extractions we need to be careful with  
        int min = Integer.MAX_VALUE;  
        Result unverify() {
            if (this == o) return true;
    );
import org.apache.lucene.search.TermInSetQuery;
            }
        // This document should match too (value3 appears in 3 clauses), but with msm set to 3 and the fact
                }
                } catch (final IOException ex) {
        public String toString() {
            return new Result(true, Collections.emptySet(), 0);
                    throw new UncheckedIOException(ex);  
            if (qt.term != null) {  
        }  
        boolean verified = conjunctionsWithUnknowns.size() == conjunctions.size();  
        } else if (result2 == null) {
        @Override
        }
    }
        }  
            result += Arrays.hashCode(upperPoint);
                    return result2.unverify();  
        boolean isMatchNoDocs() {
     * holds the terms from the document to be percolated and allows to the percolate query to ignore  
            }
            return child;
        public String toString() {  
        Result(boolean verified, Set<QueryExtraction> extractions, int minimumShouldMatch) {
        @Override
            }
            }
     *  
                if (bq.getMinimumNumberShouldMatch() == 0
            if (occur == Occur.MUST_NOT) {
        // Having ranges would mean we need to juggle with the msm and that complicates this logic a lot,  
            return conjunctionsWithUnknowns.get(0); // all conjunctions are unknown, so just return the first one  
        @Override
            return Objects.hash(term, range);
                return new Result(matchAllDocs, false, extractions, minimumShouldMatch);
        boolean verified = true;
 * this file be licensed under the Apache-2.0 license or a
            ResultBuilder child = new ResultBuilder(version, false);
        }
                // verify it with a single top-level min_should_match
                return this;  
            // Prefer term based extractions over range based extractions:
                if (extraction1SmallestRange.compareTo(extraction2SmallestRange) <= 0) {  
        boolean hasDuplicateTerms = false;
    }
import org.apache.lucene.search.BooleanClause.Occur;  
            this.fieldName = fieldName;
                    // then this will already have been taken care of, so we only check against fieldnames from
            TermQuery.class,
        // Example document1: value1 value2 value3
            DisjunctionMaxQuery.class,
import org.apache.lucene.util.automaton.ByteRunAutomaton;
                return builder;  
            return new Result(verified, terms, msm);  
                verified = false;
     * <p>
        int msm = 0;
        public int hashCode() {
        if (matchAllDocs) {  
                || (subResult.extractions.size() > 1 && requiredShouldClauses > 1)) {  
                );
     * the other clause is not null and doesn't match all documents. This is used by
        }
        List<ResultBuilder> children = new ArrayList<>();
        }  
            Collections.singleton(new QueryExtraction(new Range(query.getField(), lowerPoint, upperPoint, interval))),  
            1
                    while ((term = ti.next()) != null) {
            // calculated for subsequent Results
                super.consumeTermsMatching(query, field, automaton);  
            msm += resultMsm;
 */
        List<Integer> clauses = new ArrayList<>(disjunctions.size());  
        }  
                }
            clauses.add(resultMsm);
            for (QueryExtraction clause : result2.extractions) {
    private static byte[] prepad(byte[] original) {
                BytesRef extraction2SmallestRange = smallestRange(result2.extractions);
            }  
                if (extraction1SmallestRange == null) {
import java.util.Set;
     */
        static final Result MATCH_NONE = new Result(false, true, Collections.emptySet(), 0) {
            return Result.UNKNOWN;
        }
            if (partialResults.size() == 1) {  
    private QueryAnalyzer() {}
            }
            }  
        int minimumShouldMatch = 0;  
                    // This is because the way number fields are extracted from the document to be
            if (this == o) return true;  
            this.conjunction = conjunction;
                    // So lets be protective and decrease the msm:
            List<Result> partialResults = new ArrayList<>();
 */
            QueryExtraction queryExtraction = (QueryExtraction) o;
            return result2;
            }
        }  
import org.apache.lucene.search.DisjunctionMaxQuery;
                        resultMsm = Math.max(0, resultMsm - 1);  
    private static BytesRef smallestRange(Set<QueryExtraction> terms) {
        }
                try {  
            if (minimumShouldMatch > extractions.size()) {
            } else {  
            }
        // that fact that only distinct values are indexed in extracted terms field this document would
            this.upperPoint = upperPoint;  
            SpanTermQuery.class,
                    return result1.unverify();
            this.version = version;
            switch (query) {
import java.util.ArrayList;
            this.minimumShouldMatch = minimumShouldMatch;
            if (qt.range != null) {
                }
                        qe.add(new QueryExtraction(new Term(field, term)));
                partialResults.addAll(childResults);
            return new Result(matchAllDocs, verified);
        }  
    }  
 * KIND, either express or implied.  See the License for the
        } else if (result1.matchAllDocs) { // conjunction with match_all
        } else {
                List<Result> childResults = children.stream().map(ResultBuilder::getResult).collect(Collectors.toList());
            // using BytesRef here just to make use of its compareTo method.
            if (hasDuplicateTerms) {  
                // If some inner extractions are optional, the result can't be verified  
                hasRange = true;
            if (parent instanceof ApproximateScoreQuery approximateScoreQuery  
        }
            @Override
            if (result1.verified == false) {  
     * conjunction query).  
    private static int minTermLength(Set<QueryExtraction> extractions) {  
import org.apache.lucene.search.BooleanQuery;
                ResultBuilder builder = new ResultBuilder(version, true);
            return functionScoreQuery.getMinScore() == null;
        }
                }
                // One of the inner clauses has multiple extractions, we won't be able to
        }
        @Override  
            return false;
                    return result1.unverify();
                BytesRef extraction1SmallestRange = smallestRange(result1.extractions);  
        List<Result> terms = new ArrayList<>();
            }
        int numMatchAllClauses = 0;
    static class Result {  
    private static Result handleDisjunction(List<Result> disjunctions, int requiredShouldClauses, Version version) {
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;  
import org.apache.lucene.search.MatchAllDocsQuery;
     * <p>  
        }
import org.apache.lucene.search.BoostQuery;
            } else {
        boolean verified = true;
        }
            } else {
 * ownership. Elasticsearch licenses this file to you under  
            if (onlyRangeBasedExtractions) {
                    BytesRefIterator ti = q.getBytesRefIterator();
            result += Arrays.hashCode(lowerPoint);
            }  
        };
            this(matchAllDocs, verified, Collections.emptySet(), 0);  
        return builder.getResult();  
     * boolean query with no should clauses or phrase queries only the longest term are selected,
            }
            if (partialResults.isEmpty()) {
            if (occur == Occur.MUST || occur == Occur.FILTER) {  
        // with lowest msm, because the at percolate time there is no way to know the number of repetitions per  
            return term != null ? term.field() : null;
                throw new IllegalArgumentException(  
            this.extractions = extractions;
            @Override  
            if (result2.verified == false) {  
                // keep the clause with longest terms, this likely to be rarest.
                    // In case of range queries each extraction does not simply increment the  
                    Set<QueryExtraction> qe = new HashSet<>();  
        public void visitLeaf(Query query) {  
            // add range fields from this Result to the seenRangeFields set so that minimumShouldMatch is correctly
    }
    private static Result pointRangeQuery(PointRangeQuery query) {  
            }
            if (subResult.isMatchNoDocs()) {  
    }  
        }  
        final byte[] lowerPoint;
            Result result;
        final boolean verified;  
        }
        return result;  
            int resultMsm = result.minimumShouldMatch;  
        private ResultBuilder(Version version, boolean conjunction) {  
import org.apache.lucene.search.MatchNoDocsQuery;  
        Result getResult() {
            }  
            }  
            }  
            boolean isMatchNoDocs() {
     * it would otherwise have to execute (for example when a percolator query contains a phrase query or a
            child.minimumShouldMatch = minimumShouldMatch;  
 * The OpenSearch Contributors require contributions made to  
/*
 * the Apache License, Version 2.0 (the "License"); you may
                result = result.unverify();
        }
                if (min == null || qt.range.interval.compareTo(min) < 0) {  
                    // For multiple ranges within a single extraction (ie from an existing conjunction or disjunction)  
        }
                } else {
import java.io.UncheckedIOException;  
        if (result1 == null) {  
        QueryExtraction(Term term) {  
 * this work for additional information regarding copyright
                // verify it with a single top-level min_should_match
        @Override  
     *  `matchAllDocs` and `extractions` is enough.
        assert result1 != null || result2 != null;
        if (query.getNumDims() != 1) {
        QueryExtraction(Range range) {
        String text() {  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.index.Term;  
    private static final Set<Class<?>> verifiedQueries = new HashSet<>(  
            }
        byte[] interval = new byte[16];
            TermInSetQuery.class,  
    }  
                return true;  
            @Override  
            }  
        // Example percolator query: value1 OR value2 OR value2 OR value3 OR value3 OR value3 OR value4 OR value5 (msm set to 3)
        }
