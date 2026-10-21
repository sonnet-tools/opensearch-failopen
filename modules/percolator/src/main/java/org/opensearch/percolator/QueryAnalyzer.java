                return builder;
            boolean isMatchNoDocs() {
            }
                        verified = false;
    private static final Set<Class<?>> verifiedQueries = new HashSet<>(
            BlendedTermQuery.class
/*
    /**
        @Override
     * since that those terms are likely to be the rarest. Boolean query's must_not clauses are always ignored.
        boolean hasRangeExtractions = false;
                    }
     * @param query         The query to analyze.
        List<Result> terms = new ArrayList<>();
            children.add(child);
        }
     *
    }
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
                    if (seenRangeFields.contains(queryExtraction.range.fieldName)) {
        }
            matchAllDocs &= result.matchAllDocs;
        if (query.getNumDims() != 1) {
            return Result.UNKNOWN;
                return new Result(matchAllDocs, false, extractions, minimumShouldMatch);
final class QueryAnalyzer {
            if (subResult.matchAllDocs) {
            this.verified = verified;
        final Version version;
            child.minimumShouldMatch = minimumShouldMatch;
            this(matchAllDocs, verified, Collections.emptySet(), 0);
        assert result1 != null || result2 != null;
                if (extraction1SmallestRange == null) {
        System.arraycopy(original, 0, result, offset, original.length);
            return functionScoreQuery.getMinScore() == null;
            if (occur == Occur.MUST || occur == Occur.FILTER) {
            this.upperPoint = upperPoint;
                int extraction1ShortestTerm = minTermLength(result1.extractions);
        } else {
        }
    static class Result {
            SpanOrQuery.class,
                    return result2.unverify();
            result += Arrays.hashCode(lowerPoint);
        }
 * ownership. Elasticsearch licenses this file to you under
            if (occur == Occur.MUST_NOT) {
            this.range = range;
    }
        // This document should match too (value3 appears in 3 clauses), but with msm set to 3 and the fact
        int offset = BinaryRange.BYTES - original.length;
                return true;
            if (qt.term != null) {
        int min = Integer.MAX_VALUE;
                && Arrays.equals(lowerPoint, range.lowerPoint)
        public void consumeTermsMatching(Query query, String field, Supplier<ByteRunAutomaton> automaton) {
                }
    private static int minTermLength(Set<QueryExtraction> extractions) {
            for (QueryExtraction clause : result2.extractions) {
            }
                result = conjunction
                case MatchAllDocsQuery ignored -> terms.add(new Result(true, true));
        List<Result> conjunctions = conjunctionsWithUnknowns.stream().filter(r -> r.isUnknown() == false).collect(Collectors.toList());
        public int hashCode() {
        // Having ranges would mean we need to juggle with the msm and that complicates this logic a lot,
    }
            // When there are duplicated query extractions, percolator can no longer reliably determine msm across this disjunction
                    return result2.unverify();
        Result(boolean matchAllDocs, boolean verified) {
            }
                && Arrays.equals(upperPoint, range.upperPoint);
                    throw new UncheckedIOException(ex);
            return term != null ? term.text() : null;
        @Override
            clauses.add(resultMsm);
            for (QueryExtraction extraction : subResult.extractions) {
                return this;
                BytesRef extraction1SmallestRange = smallestRange(result1.extractions);
        final boolean conjunction;
                result = partialResults.get(0);
            int resultMsm = subResult.minimumShouldMatch;
                    // doc: field: val1 val2 val3
            if (verified == false) {
        }
 * GitHub history for details.
            switch (query) {
            this.version = version;
            if (subResult.verified == false
        }
        }
        }
        return min;
        if (new BytesRef(lowerPoint).compareTo(new BytesRef(upperPoint)) > 0) {
                        qe.add(new QueryExtraction(new Term(field, term)));
        public boolean equals(Object o) {
            return conjunctionsWithUnknowns.get(0);
                return true;
        if (conjunctions.isEmpty()) {
            if (o == null || getClass() != o.getClass()) return false;
    }
            this.minimumShouldMatch = minimumShouldMatch;
        }
        final byte[] upperPoint;
        }
            boolean isUnknown() {
import org.apache.lucene.search.QueryVisitor;
     *  `matchAllDocs` and `extractions` is enough.
import java.io.UncheckedIOException;
            }
     * 6.0.0 indices which didn't use the terms_set query.
                    while ((term = ti.next()) != null) {
            return Objects.hash(term, range);
     * Extracts terms and ranges from the provided query. These terms and ranges are stored with the percolator query and
 *
    private static BytesRef smallestRange(Set<QueryExtraction> terms) {
        return result;
        @Override
        );
                    ? handleConjunction(partialResults, version)
        };
            return child;
        if (disjunctions.size() == 1) {
        BytesRef bytes() {
                || subResult.minimumShouldMatch > 1
                    BytesRef term;
        boolean verified = true;
            boolean onlyRangeBasedExtractions = true;
            this.extractions = extractions;
        for (QueryExtraction qt : extractions) {
            boolean verified = isVerified(query);
            }
        int minimumShouldMatch = 0;
            msm = 1;
        // With the msm and extracted terms this would match and is expected behaviour
            this(false, verified, extractions, minimumShouldMatch);
        // Example percolator query: value1 OR value2 OR value2 OR value3 OR value3 OR value3 OR value4 OR value5 (msm set to 3)
                    break;
        @Override
                // Keep the clause with smallest range, this is likely to be the rarest.
        boolean hasRange = false;
 * under the License.
                }
            }
        }
                    this.terms.add(new Result(true, qe, 1));
                result = result.unverify();
    }
                if (queryExtraction.range != null) {
        public boolean equals(Object o) {
            return extractions.toString();
        // If upper is really smaller than lower then we deal with like MatchNoDocsQuery. (verified and no extractions)
                for (int i = 0; i < limit; i++) {
            if (parent instanceof ApproximateScoreQuery approximateScoreQuery
        boolean hasDuplicateTerms = false;
                // One of the inner clauses has multiple extractions, we won't be able to
import java.util.Arrays;
                return subResult;
                    return result1.unverify();
        Set<QueryExtraction> terms = new HashSet<>();
            }
 *
        int numMatchAllClauses = 0;
        Set<QueryExtraction> extractions = new HashSet<>();
import java.util.stream.Collectors;
import org.apache.lucene.search.DisjunctionMaxQuery;
        for (int i = 0; i < disjunctions.size(); i++) {
            }
        }
                }
    }
            if (parent instanceof BooleanQuery bq) {
            return result;
            int minimumShouldMatch = 0;
        Arrays.asList(
        static final Result UNKNOWN = new Result(false, false, Collections.emptySet(), 0) {
        }
     * The query analyzer doesn't always extract all terms from the specified query. For example from a
/*
                minimumShouldMatch = bq.getMinimumNumberShouldMatch();
                    // incrementing msm, because that could lead to valid matches not becoming candidate matches:
 * KIND, either express or implied.  See the License for the
     * When extracting the terms for the specified query, we can also determine if the percolator query is
        }
/*
     * matches. This allows the percolate query to skip the expensive memory index verification step that
     * <p>
            DisjunctionMaxQuery.class,
                if (min == null || qt.range.interval.compareTo(min) < 0) {
        }
        // extracted term and field value from a percolator document may have more 'weight' than others.
        }
                if (bq.getMinimumNumberShouldMatch() == 0
        return false;
    static class QueryExtraction {
                // one of the sub queries requires more than one term to match, we can't
        for (Result subResult : conjunctions) {
        // so for now lets not do it.
            return "QueryExtraction{" + "term=" + term + ",range=" + range + '}';
        }
        byte[] interval = new byte[16];
            return (conjunction ? "CONJ" : "DISJ") + children + terms + "~" + minimumShouldMatch;
            // calculated for subsequent Results
        QueryExtraction(Range range) {
import java.util.List;
            this.fieldName = fieldName;
        final Term term;
        }
import org.apache.lucene.search.ConstantScoreQuery;
                } catch (final IOException ex) {
            Result subResult = disjunctions.get(i);
                    // query: (field:val1 AND field:val2) AND (field:val2 AND field:val3)
        List<ResultBuilder> children = new ArrayList<>();
                BytesRef extraction2SmallestRange = smallestRange(result2.extractions);
                    }
        }
        // that fact that only distinct values are indexed in extracted terms field this document would
            }
        if (query instanceof FunctionScoreQuery functionScoreQuery) {
                result = result.unverify();
            }
                }
                    onlyRangeBasedExtractions = false;
        Result(boolean verified, Set<QueryExtraction> extractions, int minimumShouldMatch) {
     *  Further more, the match doesn't need to be verified if `verified` is true, checking
            if (query instanceof TermInSetQuery q) {
                    // extractions from this result are processed
        @Override
 * compatible open source license.
                return QueryVisitor.EMPTY_VISITOR;
    static Result selectBestResult(Result result1, Result result2) {
     * by picking up clauses that look most restrictive and making it unverified if
    private QueryAnalyzer() {}
            } else {
        }
        Result getResult() {
        Result(boolean matchAllDocs, boolean verified, Set<QueryExtraction> extractions, int minimumShouldMatch) {
                this.verified = false;
                return QueryVisitor.EMPTY_VISITOR;
        };
        } else {
            QueryExtraction queryExtraction = (QueryExtraction) o;
 * this file be licensed under the Apache-2.0 license or a
                }
                    msm += clauses.get(i);
            Set<QueryExtraction> qe = Arrays.stream(terms).map(QueryExtraction::new).collect(Collectors.toSet());
     *  - `matchAllDocs` is true
                }
import org.apache.lucene.search.PointRangeQuery;
            SynonymQuery.class,
        @Override
        Result unverify() {
            }
            }
                // pick lowest msm:
            }
            BooleanQuery.class,
                int extraction2ShortestTerm = minTermLength(result2.extractions);
     * holds the terms from the document to be percolated and allows to the percolate query to ignore
     */
     *
 *
                case PointRangeQuery pointRangeQuery -> terms.add(pointRangeQuery(pointRangeQuery));
            return Objects.equals(term, queryExtraction.term) && Objects.equals(range, queryExtraction.range);
            return new Result(true, Collections.emptySet(), 0);
                    // previously processed extractions, and don't add to the seenRangeFields list until all
                    BytesRefIterator ti = q.getBytesRefIterator();
        }
        }
                return true;
        // In the above example query the extracted msm would be 3
            }
        // Example document2: value3
                    break;
 */
                    : handleDisjunction(partialResults, minimumShouldMatch, version);
                    // then this will already have been taken care of, so we only check against fieldnames from
 * SPDX-License-Identifier: Apache-2.0
                try {
import java.util.ArrayList;
                verified = false;
            if (partialResults.isEmpty()) {
        return new Result(
                } else if (extraction2SmallestRange == null) {
            return new Result(matchAllDocs, verified);
import java.util.Set;
            if (qt.range != null) {
                    return result2.unverify();
            }
            int result = 1;
            }
                && approximateScoreQuery.getOriginalQuery() instanceof DateRangeIncludingNowQuery) {
            }
                    // This is because the way number fields are extracted from the document to be
    }
                    return QueryVisitor.EMPTY_VISITOR;
                partialResults.addAll(childResults);
import org.apache.lucene.search.SynonymQuery;
        int msm = 0;
                    // For multiple ranges within a single extraction (ie from an existing conjunction or disjunction)
                    if (extractions.contains(queryExtraction)) {
package org.opensearch.percolator;
            }
                || (subResult.extractions.size() > 1 && requiredShouldClauses > 1)) {
import java.util.HashSet;
            msm += resultMsm;
                        resultMsm = Math.max(0, resultMsm - 1);
        if (matchAllDocs) {
        if (conjunctionsWithUnknowns.size() == 1) {
     *
                    return result1.unverify();
        boolean matchAllDocs = numMatchAllClauses > 0 && numMatchAllClauses >= requiredShouldClauses;
            return result;
    private static boolean isVerified(Query query) {
        List<Integer> clauses = new ArrayList<>(disjunctions.size());
                    // number field when processing the percolator query at index time.
                if (clause.term != null) {
        } else {
        final BytesRef interval;
        byte[] result = new byte[BinaryRange.BYTES];
            return new Result(verified, terms, msm);
        return builder.getResult();
            @Override
            } else {
        if (!hasTerm && hasRange) {
     * query analysis is stopped and an UnsupportedQueryException is thrown. So that the caller can mark
                } else {
    private static class ResultBuilder extends QueryVisitor {
            this.interval = new BytesRef(interval);
            }
        }
                    // So lets be protective and decrease the msm:
            return "Range{" + ", fieldName='" + fieldName + '\'' + ", interval=" + interval + '}';
 *    http://www.apache.org/licenses/LICENSE-2.0
            SpanTermQuery.class,
 * this work for additional information regarding copyright
        byte[] lowerPoint = query.getLowerPoint();
            this.term = null;
        }
        for (Class<?> cls : verifiedQueries) {
            }
        if (matchAllDocs) {
                List<Result> childResults = children.stream().map(ResultBuilder::getResult).collect(Collectors.toList());
            return new Result(verified, extractions, msm);
            }
import java.io.IOException;
        final Range range;
            return disjunctions.get(0);
        }
    /**
                int limit = Math.min(clauses.size(), Math.max(1, requiredShouldClauses));
                    // more range queries on the same field, then the minimum should match can be higher than clauses
                return "UNKNOWN";
            extractions.addAll(result.extractions);
        }
        }
            return term != null ? term.field() : null;
import org.apache.lucene.util.BytesRefIterator;
                    && bq.clauses().stream().anyMatch(c -> c.occur() == Occur.MUST || c.occur() == Occur.FILTER)) {
            } else {
            TermInSetQuery.class,
 * not use this file except in compliance with the License.
        }
                    return result1.unverify();
        boolean hasTerm = false;
                    // than term based queries.
                this.terms.add(new Result(verified, qe, conjunction ? qe.size() : 1));
import org.apache.lucene.util.NumericUtils;
    }
    private static byte[] prepad(byte[] original) {
     * always going to match. For example if a percolator query just contains a term query or a disjunction
        } else if (result2.matchAllDocs) { // conjunction with match_all
    );
            }
import org.apache.lucene.queries.spans.SpanOrQuery;
                // verify it with a single top-level min_should_match
        String text() {
            Result result = result2;
     * it would otherwise have to execute (for example when a percolator query contains a phrase query or a
     * this query in such a way that the PercolatorQuery always verifies if this query with the MemoryIndex.
            if (verified) {
 */
                terms.add(Result.UNKNOWN);
        }
            }
     * conjunction query).
        boolean verified = conjunctionsWithUnknowns.size() == conjunctions.size();
        }
                verified = false;
            if (this == o) return true;
            // Figure out what the combined msm is for this disjunction:
     *
import org.apache.lucene.search.BooleanClause.Occur;
     * boolean query with no should clauses or phrase queries only the longest term are selected,
            for (QueryExtraction clause : result1.extractions) {
import org.apache.lucene.search.BoostQuery;
            // using BytesRef here just to make use of its compareTo method.
        )
            return result1;
            clauses = clauses.stream().filter(val -> val > 0).sorted().collect(Collectors.toList());
                }
    }
            }
        final boolean matchAllDocs;
                if (terms.add(extraction) == false) {
                if (extraction1ShortestTerm >= extraction2ShortestTerm) {
        BytesRef min = null;
                );
 */
                partialResults.addAll(terms);
                    "minimumShouldMatch can't be greater than the number of extractions: " + minimumShouldMatch + " > " + extractions.size()
            }
    }
            if (hasDuplicateTerms) {
        query.visit(builder);
        }
     * Return an extraction for the conjunction of {@code result1} and {@code result2}
                    }
            if (partialResults.size() == 1) {
            this.term = term;
        } else if (result1.matchAllDocs) { // conjunction with match_all
            // Prefer term based extractions over range based extractions:
            this.verified = isVerified(parent);
            }
        // never match.
        public String toString() {
            if (terms.size() > 0) {
            return result;
        boolean matchAllDocs = true;
            return result;
            this.lowerPoint = lowerPoint;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.util.automaton.ByteRunAutomaton;
        }
    }
            }
        if (hasRangeExtractions == false) {
            if (result1.verified == false) {
                min = Math.min(min, qt.bytes().length);
    private static Result handleConjunction(List<Result> conjunctionsWithUnknowns, Version version) {
                }
        }
            }
                }
 * You may obtain a copy of the License at
        boolean isUnknown() {
import org.opensearch.lucene.queries.BlendedTermQuery;
            result += Arrays.hashCode(upperPoint);
                    // minimum_should_match for that percolator query like for a term based extraction,
                hasTerm = true;
                case null, default -> terms.add(Result.UNKNOWN);
                hasRangeExtractions = subResult.extractions.stream().anyMatch(qe -> qe.range != null);
                children.add(builder);
            return Integer.MIN_VALUE;
            Collections.singleton(new QueryExtraction(new Range(query.getField(), lowerPoint, upperPoint, interval))),
        final String fieldName;
            if (this == o) return true;
import org.apache.lucene.search.Query;
            @Override
        for (Result result : conjunctions) {
                // verify it with a single top-level min_should_match
                }
                    // in the CoveringQuery. Therefore right now the minimum should match is only incremented once per
                ResultBuilder builder = new ResultBuilder(version, true);
        public String toString() {
            return new Result(matchAllDocs, verified);
            for (QueryExtraction queryExtraction : result.extractions) {
    }
            if (hasRangeExtractions == false) {
            return false;
                msm = clauses.get(0);
            if (minimumShouldMatch > extractions.size()) {
        }
        }
        }
        } else if (result2 == null) {
            }
        public int hashCode() {
        static final Result MATCH_NONE = new Result(false, true, Collections.emptySet(), 0) {
            if (onlyRangeBasedExtractions) {
    private static Result handleDisjunction(List<Result> disjunctions, int requiredShouldClauses, Version version) {
        final int minimumShouldMatch;
        // Keep track of the msm for each clause:
            // add range fields from this Result to the seenRangeFields set so that minimumShouldMatch is correctly
        final byte[] lowerPoint;
        NumericUtils.subtract(16, 0, prepad(upperPoint), prepad(lowerPoint), interval);
import org.apache.lucene.util.BytesRef;
            if (conjunctionsWithUnknowns.isEmpty()) {
            false,
        // In case that there are duplicate extracted terms / ranges then the msm should always be equal to the clause
     * <p>
                throw new IllegalArgumentException("Must have at least one conjunction sub result");
            } else {
            if (o == null || getClass() != o.getClass()) return false;
        return min;
            this.range = null;
            if (children.isEmpty() == false) {
            int resultMsm = result.minimumShouldMatch;
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.search.BooleanQuery;
        // If there are no terms but there are ranges, return Integer.MIN_VALUE
     * used by the percolate query's candidate query as fields to be query by. The candidate query
    static Result analyze(Query query, Version indexVersion) {
        String field() {
            Range range = (Range) o;
            }
import org.apache.lucene.queries.spans.SpanTermQuery;
        boolean verified = true;
        @Override
        } else {
import org.apache.lucene.search.TermInSetQuery;
                hasRange = true;
        }
 * Licensed to Elasticsearch under one or more contributor
        }
    /**
        byte[] upperPoint = query.getUpperPoint();
     *  - `extractions` and the document have `minimumShouldMatch` terms in common
            return matchAllDocs == false && extractions.isEmpty();
            if (result2.verified == false) {
import org.opensearch.search.approximate.ApproximateScoreQuery;
            Result result = result1;
            BoostQuery.class,
            TermQuery.class,
        public String toString() {
            }
            if (qt.range != null) {
     * Sometimes the query analyzer can't always extract terms or ranges from a sub query, if that happens then
        public void consumeTerms(Query query, Term... terms) {
                return verified ? Result.MATCH_NONE : Result.UNKNOWN;
        // Need to check whether upper is not smaller than lower, otherwise NumericUtils.subtract(...) fails IAE
        @Override
                        resultMsm = Math.max(0, resultMsm - 1);
import org.apache.lucene.search.MatchNoDocsQuery;
        final boolean verified;
                super.consumeTermsMatching(query, field, automaton);
            return Objects.equals(fieldName, range.fieldName)
        if (disjunctions.stream().anyMatch(Result::isUnknown)) {
                } else {
                if (extraction1SmallestRange.compareTo(extraction2SmallestRange) <= 0) {
                    verified = false;
            @Override
import org.apache.lucene.index.Term;
        // with lowest msm, because the at percolate time there is no way to know the number of repetitions per
            }
import org.opensearch.index.query.DateRangeIncludingNowQuery;
            ResultBuilder child = new ResultBuilder(version, false);
                // keep the clause with longest terms, this likely to be rarest.
                throw new IllegalArgumentException(
                    Set<QueryExtraction> qe = new HashSet<>();
import java.util.Objects;
        public String toString() {
        }
                result = result.unverify();
                if (clause.term != null) {
     * the other clause is not null and doesn't match all documents. This is used by
            ConstantScoreQuery.class,
    private static Result pointRangeQuery(PointRangeQuery query) {
        @Override
            if (qe.size() > 0) {
            return Result.UNKNOWN;
                    // so that can lead to more false positives for percolator queries with range queries
        final Set<QueryExtraction> extractions;
        // Example document1: value1 value2 value3
                return false;
            }
            if (cls.isAssignableFrom(query.getClass())) {
                    // In case that there are duplicate term query extractions we need to be careful with
            @Override
        boolean isMatchNoDocs() {
            this.conjunction = conjunction;
        }
            boolean isMatchNoDocs() {
     */
        @Override
            } else {
                case MatchNoDocsQuery ignored -> terms.add(Result.MATCH_NONE);
                || result.minimumShouldMatch < result.extractions.size()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.search.TermQuery;
}
                        verified = false;
        for (QueryExtraction qt : terms) {
        QueryExtraction(Term term) {
            this.matchAllDocs = matchAllDocs;
            result.extractions.stream().map(e -> e.range).filter(Objects::nonNull).map(e -> e.fieldName).forEach(seenRangeFields::add);
        @Override
     * query then when the candidate query matches with that, we know the entire percolator query always
            if (result.verified == false
                numMatchAllClauses++;
        public QueryVisitor getSubVisitor(Occur occur, Query parent) {
     * Query extraction result. A result is a candidate for a given document either if:
import java.util.Collections;
            return term != null ? term.bytes() : null;
        private ResultBuilder(Version version, boolean conjunction) {
            return result2;
        Range(String fieldName, byte[] lowerPoint, byte[] upperPoint, byte[] interval) {
            return conjunctionsWithUnknowns.get(0); // all conjunctions are unknown, so just return the first one
        @Override
    static class Range {
        Set<String> seenRangeFields = new HashSet<>();
        }
     */
            }
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.Version;
        int msm = 0;
            }
import java.util.function.Supplier;
    }
        }
 * specific language governing permissions and limitations
                }
            List<Result> partialResults = new ArrayList<>();
            Result result;
     * percolator queries that we know would otherwise never match.
                    // percolated. Per field a single range is extracted and if a percolator query has two or
            1
 * Modifications Copyright OpenSearch Contributors. See
        if (result1 == null) {
        ResultBuilder builder = new ResultBuilder(indexVersion, false);
            public String toString() {
            result += 31 * fieldName.hashCode();
        }
                } else {
        public void visitLeaf(Query query) {
        }
                    hasDuplicateTerms = true;
                    onlyRangeBasedExtractions = false;
            }
 * the Apache License, Version 2.0 (the "License"); you may
            if (subResult.isMatchNoDocs()) {
 * software distributed under the License is distributed on an
                    // In case of range queries each extraction does not simply increment the
     * @param indexVersion  The create version of the index containing the percolator queries.
     * <p>
                // If some inner extractions are optional, the result can't be verified
            // (sum the lowest required clauses, otherwise we're too strict and queries may not match)
                    min = qt.range.interval;
