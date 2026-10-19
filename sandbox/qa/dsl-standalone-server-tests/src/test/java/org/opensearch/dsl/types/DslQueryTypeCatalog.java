         * skipped by {@link DslQueryTypesIT}. Unmodifiable and insertion-ordered.  
import java.util.List;
            // ── term-level ──
 * Catalog of DSL query types, one entry per {@code resources/datasets/<type>/} folder.  
            // ── single-valued-tags variants (probe parquet's multi-value keyword limitation) ──
 *
/**
 * an <b>independent</b> parameterized test that provisions the type's parquet index, runs the query,
        }  
            e("bool", "compound").tagged(TAG_MULTI_VALUED_KEYWORD),
import java.util.LinkedHashSet;
    /**
        public final String family;
    public static final String TAG_MULTI_VALUED_KEYWORD = "multi-valued-keyword";
import java.util.Set;  
 * + {@code dsl/q{N}.json}). {@link DslQueryTypesIT} turns every {@code (entry, queryNumber)} pair into  
 * The OpenSearch Contributors require contributions made to  
        /**  
    }  
 * <p>The suite's purpose is to map what the parquet/composite engine can and cannot serve. Every type
        /** Dataset descriptor: folder name == index name == {@link #type}. */
            this.dataset = new Dataset(type, type);
        /** Query family (term-level, full-text, compound, scoring, span, relational, geo, specialized). */  
 * is the single source of truth.  
     */  
         * Tags marking known engine gaps (e.g. {@link #TAG_MULTI_VALUED_KEYWORD}); tagged entries are
            Collections.addAll(union, moreTags);  
        );
            e("term", "term-level").tagged(TAG_MULTI_VALUED_KEYWORD),  
 * SPDX-License-Identifier: Apache-2.0
 */  
            this(type, family, Collections.emptySet());
        public final Set<String> tags;
    }  
 */
        public final Dataset dataset;  
 *  
package org.opensearch.dsl.types;
        return new Entry(type, family);
         */  
 *
            this.tags = Collections.unmodifiableSet(new LinkedHashSet<>(tags));  
    private static Entry e(String type, String family) {
    /** All catalogued query types, aligned 1:1 with the {@code resources/datasets/<type>/} folders. */
         * so nothing is mutated in place.
        /** True when this entry carries at least one tag (a known engine gap). */
            this.family = family;
        }
        /** Query-type key == folder name under {@code resources/datasets/}. */
            // Exercises term queries returning multiple docs, a single doc, and no docs against a  
            e("bool_scalar", "compound")
        public final String type;
        public Entry tagged(String... moreTags) {
 * <p>Each entry names a query-type folder (its {@link Dataset}: {@code mapping.json} + {@code bulk.json}
}
         */
     * Marks datasets whose {@code tags} keyword field is a multi-valued array, which the parquet  
 * {@link DslQueryTypesIT} then reports those parameters as skipped-with-reason instead of red, so the  
            this.type = type;  
     * {@link DslQueryTypesIT} until the engine supports them — remove the tag to reactivate the test.
import org.opensearch.analytics.qa.Dataset;
/*  
         * Returns a NEW entry with {@code moreTags} unioned into this entry's tags. Fields are final,
        public boolean hasTags() {
            return tags.isEmpty() == false;  
    private DslQueryTypeCatalog() {}  
            // array to a bare scalar. The parent types fail on parquet at ingest — "Cannot accept multiple  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;  
        /**
 * compatible open source license.
            // values for field [tags] of type [keyword]" — so these variants isolate that as the sole
 * suite stays green while the finding stays visible — remove the tag to reactivate the test.
        }
 * multi-valued keyword arrays (rejected at ingest) — therefore surface as <b>red</b>, which is the
 * finding we want to expose, not hide. There is no per-type "expected outcome" guesswork: the golden
    }
            // cause: with scalar tags the docs ingest and the parent's query is exercised normally.
        }
    /** One query-type entry: its dataset folder/index and query family. */
            e("term_scalar", "term-level"),  
        return List.of(
            // Same mapping + same query as the parent type, but with `tags` reduced from a multi-valued
        Entry(String type, String family, Set<String> tags) {
            // ── general keyword dataset (people: 5 docs; keyword/int/double/text fields) ──
 * <p>Known engine gaps can be tagged on their {@link Entry} (see {@link #TAG_MULTI_VALUED_KEYWORD});
            // ── compound ──
        Entry(String type, String family) {
 * and validates the response against a golden file ({@code dsl/expected/q{N}.json}).
            e("people", "term-level"),
    public static List<Entry> all() {  
     * backend rejects at ingest / fails at query today. Entries carrying this tag are skipped by
 * Types the engine cannot handle today — geo/nested field mappings (rejected at index creation),  
 *
 * is treated as <b>expected-to-work</b>: a type is green only when its live response matches its golden.
            return new Entry(this.type, this.family, union);
            // plain (non-tags) keyword dataset. Golden answers are the true Lucene results.
            Set<String> union = new LinkedHashSet<>(this.tags);
    public static final class Entry {  
public final class DslQueryTypeCatalog {  
