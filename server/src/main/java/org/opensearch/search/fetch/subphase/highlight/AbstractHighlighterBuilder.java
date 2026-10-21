        if (obj == null || getClass() != obj.getClass()) {
            }
        this.boundaryMaxScan = boundaryMaxScan;
        return this.highlightQuery;
        if (hasBoundaryScannerLocale) {
import org.opensearch.index.query.QueryBuilder;
        out.writeOptionalBoolean(requireFieldMatch);
     * By default, fragments of a field are ordered by the order in the highlighted text.
     * @return this for chaining
 */
        if (phraseLimit != null) {
        return (HB) this;
     * @return the value set by {@link #highlightFilter(Boolean)}
    /**
     */
        fragmentSize = template.fragmentSize;
        }
            out.writeOptionalVInt(maxAnalyzerOffset);
/*
        return (HB) this;
                parser.parse(p, hb, null);
     * controls the locale to use by the BreakIterator, defaults to "root".
        if (in.getVersion().onOrAfter(Version.V_2_2_0)) {
        highlighterType(in.readOptionalString());
            builder.field(BOUNDARY_SCANNER_FIELD.getPreferredName(), boundaryScannerType.name());
     * @return the value set by {@link #preTags(String...)}
    }
    protected Integer noMatchSize;
    }
     * @return the value set by {@link #fragmentSize(Integer)}
 */
            out.writeNamedWriteable(highlightQuery);
     * if the query matches specifically on them.
    }
        parser.declareBoolean(HB::requireFieldMatch, REQUIRE_FIELD_MATCH_FIELD);
     */
     * Set to true to cause a field to be highlighted only if a query matches that field.
 */
        postTags = template.postTags;
     * Permitted values are "simple" or "span" relating to {@link SimpleFragmenter} and
        parser.declareObject(HB::highlightQuery, (XContentParser p, Void c) -> {
    }
            && Objects.equals(fragmenter, other.fragmenter)
     * @param noMatchSize integer to set or null to leave out of request.  default is null.
 * Modifications Copyright OpenSearch Contributors. See
    public static final ParseField FRAGMENT_OFFSET_FIELD = new ParseField("fragment_offset");
     * by score of the fragments, or {@code none}.
        return (HB) this;
     * @return the value set by {@link #highlightQuery(QueryBuilder)}
        }
     */
    @SuppressWarnings("unchecked")
        );
        phraseLimit = template.phraseLimit;
 * ownership. Elasticsearch licenses this file to you under
    }
     * @return the value set by {@link #fragmenter(String)}
        parser.declareString(HB::boundaryScannerLocale, BOUNDARY_SCANNER_LOCALE_FIELD);
     */
     * Set the fragment size in characters, defaults to {@link HighlightBuilder#DEFAULT_FRAGMENT_CHAR_SIZE}
    /**
    public HB noMatchSize(Integer noMatchSize) {
        numOfFragments = template.numOfFragments;
    public Integer noMatchSize() {
            && Objects.equals(requireFieldMatch, other.requireFieldMatch)
        return this.fragmenter;
 * under the License.
 * this file be licensed under the Apache-2.0 license or a
        return this.fragmentSize;
    public HB highlighterType(String highlighterType) {
        if (forceSource != null) {
            builder.field(REQUIRE_FIELD_MATCH_FIELD.getPreferredName(), requireFieldMatch);
    }
        return this.maxAnalyzerOffset;
     * @return the value set by {@link #noMatchSize(Integer)}
     * Set this to true when using the highlighterType {@code fvh}
     * fields only present in subclass should be checked for equality in the implementation
    protected Order order;
     */
import java.util.Objects;
import org.opensearch.core.xcontent.XContentParser;
            builder.field(NUMBER_OF_FRAGMENTS_FIELD.getPreferredName(), numOfFragments);
        }
    }
        }
        this.boundaryScannerType = boundaryScannerType;
     * Set the pre tags that will be used for highlighting.
        return Objects.hash(
    /**
    public static final ParseField POST_TAGS_FIELD = new ParseField("post_tags");
            boundaryScannerLocale(in.readString());
        numOfFragments(in.readOptionalVInt());
    }
    /**
        HB other = (HB) obj;
import java.util.Arrays;
    /**
 * Licensed to Elasticsearch under one or more contributor
            } catch (IOException e) {
            highlighterType,
        out.writeOptionalString(fragmenter);
            }
     */
    public static final ParseField BOUNDARY_SCANNER_LOCALE_FIELD = new ParseField("boundary_scanner_locale");
        options = template.options;
        return this.boundaryScannerLocale;
        fragmentSize(in.readOptionalVInt());
    }
        }
        }
    @Override
    @SuppressWarnings("unchecked")
    protected String[] postTags;
    public final void writeTo(StreamOutput out) throws IOException {
     */
     * controls which scanner to use for fragment boundaries, and defaults to "simple".
 *
    protected String[] preTags;
     * {@link SimpleSpanFragmenter} implementations respectively with the default being "span"
     * controls how far to look for boundary characters, and defaults to 20.
    /**
        requireFieldMatch(in.readOptionalBoolean());
        if (highlightFilter != null) {
    public Integer numOfFragments() {
        highlighterType = template.highlighterType;
        out.writeOptionalVInt(fragmentSize);
        parser.declareInt(HB::numOfFragments, NUMBER_OF_FRAGMENTS_FIELD);
    @SuppressWarnings("unchecked")
import org.opensearch.index.query.Rewriteable;
        }
    }
    public static final ParseField BOUNDARY_CHARS_FIELD = new ParseField("boundary_chars");
import org.opensearch.core.common.io.stream.StreamOutput;
     * @return the value set by {@link #phraseLimit(Integer)}
                throw new RuntimeException(e);
                throw new RuntimeException("Error parsing query", e);
        return this.highlightFilter;
 * KIND, either express or implied.  See the License for the
    public String toString() {
 * and provides the common setters, equality, hashCode calculation and common serialization
    protected abstract int doHashCode();
            options,
        }
        return this.preTags;
        return this.phraseLimit;
        if (hasQuery) {
    /**
    public final boolean equals(Object obj) {
            out.writeString(boundaryScannerLocale.toLanguageTag());
    }
        out.writeOptionalBoolean(highlightFilter);
        out.writeOptionalWriteable(order);
            doHashCode()
            try {
    public Integer maxAnalyzerOffset() {
import org.opensearch.core.ParseField;
     */
        }
        if (boundaryScannerLocale != null) {
        boolean hasBoundaryScannerLocale = boundaryScannerLocale != null;
     */
    public static final ParseField HIGHLIGHT_QUERY_FIELD = new ParseField("highlight_query");
     * write common parameters to {@link StreamOutput}
    public QueryBuilder highlightQuery() {
    @SuppressWarnings("unchecked")
            forceSource,
    @Override
     * @param phraseLimit maximum number of phrases the fvh will consider
        highlightQuery = queryBuilder;
    /**
import java.io.IOException;
        parser.declareString(HB::order, ORDER_FIELD);
    public HB postTags(String... postTags) {
    }
        parser.declareString(HB::fragmenter, FRAGMENTER_FIELD);
    }
        if (hasOptions) {
     */
        noMatchSize = template.noMatchSize;
    public HB maxAnalyzerOffset(Integer maxAnalyzerOffset) {
        out.writeBoolean(hasBoundaryScannerLocale);
            && Objects.equals(noMatchSize, other.noMatchSize)
     */
     */
        if (preTags != null) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.Writeable;
     */
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.BoundaryScannerType;
        return (HB) this;
                if (hb.preTags() != null && hb.postTags() == null) {
     * Forces the highlighting to highlight fields based on the source even if fields are stored separately.
    public final int hashCode() {
            boundaryChars(in.readString().toCharArray());
        @SuppressWarnings("unchecked")
            && Objects.equals(boundaryMaxScan, other.boundaryMaxScan)
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
    /**
 * SPDX-License-Identifier: Apache-2.0
        }
    public static final ParseField OPTIONS_FIELD = new ParseField("options");
            out.writeString(String.valueOf(boundaryChars));
        return (XContentParser p, HB hb) -> {
        return this.boundaryScannerType;
     */
import java.util.Map;
        parser.declareInt(HB::noMatchSize, NO_MATCH_SIZE_FIELD);
        if (out.getVersion().onOrAfter(Version.V_2_2_0)) {
    /**
        }
    public static final ParseField FRAGMENT_SIZE_FIELD = new ParseField("fragment_size");
            builder.field(FRAGMENT_SIZE_FIELD.getPreferredName(), fragmentSize);
        boundaryMaxScan = template.boundaryMaxScan;
     * If set to {@link Order#SCORE}, this changes order to score of the fragments.
        highlightFilter(in.readOptionalBoolean());
            && doEquals(other);
     * When using the highlighterType {@code fvh} this setting
     * highlight and the field doesn't also define noMatchSize.
        }
    }
    /**
        builder.endObject();
            phraseLimit,
    protected Integer maxAnalyzerOffset = null;
    public String[] postTags() {
            builder.field(HIGHLIGHT_FILTER_FIELD.getPreferredName(), highlightFilter);
    }
            options(in.readMap());
        this.highlightFilter = highlightFilter;
     * @return the value set by {@link #forceSource(Boolean)}
    }
     * Sets a query to be used for highlighting instead of the search query.
    public HB order(String order) {
     */
            boundaryScannerType,
        this.preTags = preTags;
    protected AbstractHighlighterBuilder(StreamInput in) throws IOException {
    public static final ParseField TYPE_FIELD = new ParseField("type");
    protected abstract void innerXContent(XContentBuilder builder) throws IOException;
    protected abstract void doWriteTo(StreamOutput out) throws IOException;
 * The OpenSearch Contributors require contributions made to
            && Objects.equals(fragmentSize, other.fragmentSize)
     * @return the value set by {@link #boundaryMaxScan(Integer)}
import org.opensearch.core.common.Strings;
            builder.field(PHRASE_LIMIT_FIELD.getPreferredName(), phraseLimit);
    public static final ParseField BOUNDARY_MAX_SCAN_FIELD = new ParseField("boundary_max_scan");
            return true;
        return (HB) this;
    /**
     */
        parser.declareStringArray(fromList(String.class, HB::preTags), PRE_TAGS_FIELD);
        if (in.readBoolean()) {
    protected QueryBuilder highlightQuery;
        if (fragmenter != null) {
    protected abstract boolean doEquals(HB other);
            builder.field(FORCE_SOURCE_FIELD.getPreferredName(), forceSource);
     * @return the value set by {@link #order(Order)}
    }
        innerXContent(builder);
     * Sets what fragmenter to use to break up text that is eligible for highlighting.
        parser.declareBoolean(HB::highlightFilter, HIGHLIGHT_FILTER_FIELD);
    }
        out.writeOptionalStringArray(preTags);
    }
    public HB forceSource(Boolean forceSource) {
            Arrays.hashCode(preTags),
    public HB fragmenter(String fragmenter) {
        parser.declareStringArray(fromList(String.class, HB::postTags), POST_TAGS_FIELD);
    /**
    }
        out.writeOptionalVInt(noMatchSize);
     */
    /**
        }
    public static final ParseField FIELDS_FIELD = new ParseField("fields");
        parser.declareString(HB::boundaryScannerType, BOUNDARY_SCANNER_FIELD);
    public static final ParseField MAX_ANALYZER_OFFSET_FIELD = new ParseField("max_analyzer_offset");
            && Objects.equals(boundaryScannerType, other.boundaryScannerType)
    public static final ParseField HIGHLIGHT_FILTER_FIELD = new ParseField("highlight_filter");
    @SuppressWarnings("unchecked")
        }
    public static final ParseField NO_MATCH_SIZE_FIELD = new ParseField("no_match_size");
    public Order order() {
        maxAnalyzerOffset = template.maxAnalyzerOffset;
        parser.declareString(HB::highlighterType, TYPE_FIELD);
            && Arrays.equals(boundaryChars, other.boundaryChars)
 * specific language governing permissions and limitations
    @SuppressWarnings("unchecked")
     * Details of the different highlighter types are covered in the reference guide.
        parser.declareObject(HB::options, (XContentParser p, Void c) -> {
        this.numOfFragments = numOfFragments;
        }
    protected Boolean requireFieldMatch;
        builder.startObject();
            && Objects.equals(phraseLimit, other.phraseLimit)
    @Override
        this.requireFieldMatch = requireFieldMatch;
    public HB requireFieldMatch(Boolean requireFieldMatch) {
    }
     * and you want to provide highlighting on filter clauses in your
    @SuppressWarnings("unchecked")
    protected String highlighterType;
        return (HB) this;
    /**
     * controls which scanner to use for fragment boundaries, and defaults to "simple".
    public Map<String, Object> options() {
        out.writeOptionalVInt(phraseLimit);
        parser.declareInt(HB::fragmentSize, FRAGMENT_SIZE_FIELD);
        fragmenter(in.readOptionalString());
     */
        }
            noMatchSize,
        out.writeOptionalVInt(boundaryMaxScan);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return hb;
    /**
    }
            fragmentSize,
    }
        return (HB) this;
        }
        this.options = options;
        return this.boundaryMaxScan;
    @SuppressWarnings("unchecked")
            builder.array(POST_TAGS_FIELD.getPreferredName(), postTags);
        return this.requireFieldMatch;
     * Sets the maximum number of phrases the fvh will consider if the field doesn't also define phraseLimit.
    public HB options(Map<String, Object> options) {
        if (hasBounaryChars) {
     * @return the value set by {@link #postTags(String...)}
    public HB boundaryChars(char[] boundaryChars) {
    /**
        Writeable,
            return false;
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.field(TYPE_FIELD.getPreferredName(), highlighterType);
    protected Boolean highlightFilter;
     * Allows to set custom options for custom highlighters.
            requireFieldMatch,
        boolean hasBounaryChars = boundaryChars != null;
        out.writeOptionalString(highlighterType);
        ToXContentObject {
     */
    public HB boundaryScannerType(String boundaryScannerType) {
        if (in.readBoolean()) {
        }, OPTIONS_FIELD);
    @Override
        this.noMatchSize = noMatchSize;
     */
    }
            builder.field(BOUNDARY_MAX_SCAN_FIELD.getPreferredName(), boundaryMaxScan);
    /**
        if (boundaryMaxScan != null) {
     */
    public Integer fragmentSize() {
        }
        if (maxAnalyzerOffset != null) {
    public Integer boundaryMaxScan() {
        this.postTags = postTags;
        order(in.readOptionalWriteable(Order::readFromStream));
    public HB boundaryScannerType(BoundaryScannerType boundaryScannerType) {
        return (HB) this;
            builder.field(ORDER_FIELD.getPreferredName(), order.toString());
     * Sets the maximum offset for the highlighter
        parser.declareInt(HB::maxAnalyzerOffset, MAX_ANALYZER_OFFSET_FIELD);
    /**
        out.writeBoolean(hasBounaryChars);
    }
    protected Map<String, Object> options;
        }
        out.writeOptionalWriteable(boundaryScannerType);
     */
 * @opensearch.internal
import static org.opensearch.core.xcontent.ObjectParser.fromList;
        }
        this.forceSource = forceSource;
    /**
    public AbstractHighlighterBuilder() {}
        return order(Order.fromString(order));
        if (requireFieldMatch != null) {
    /**
 * compatible open source license.
     * When using the highlighterType {@code fvh} this setting
    /**
    public String[] preTags() {
     * @return the value set by {@link #highlighterType(String)}
            && Objects.equals(order, other.order)
    public static final ParseField PHRASE_LIMIT_FIELD = new ParseField("phrase_limit");
            && Objects.equals(boundaryScannerLocale, other.boundaryScannerLocale)
    @SuppressWarnings("unchecked")
    }
        out.writeOptionalBoolean(forceSource);
        phraseLimit(in.readOptionalVInt());
    protected Integer numOfFragments;
     */
        fragmenter = template.fragmenter;
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.Order;
     */
                return parseInnerQueryBuilder(p);
    /**
                throw new RuntimeException("Error parsing options", e);
            boundaryScannerLocale,
        parser.declareString((HB hb, String bc) -> hb.boundaryChars(bc.toCharArray()), BOUNDARY_CHARS_FIELD);
import org.opensearch.core.common.io.stream.StreamInput;
     * @return the value set by {@link #numOfFragments(Integer)}
        preTags(in.readOptionalStringArray());
            numOfFragments,
import org.apache.lucene.search.highlight.SimpleFragmenter;
        return (HB) this;
    protected Locale boundaryScannerLocale;
     * When using the highlighterType {@code fvh} and boundaryScannerType {@code break_iterator}, this setting
    }
 * this work for additional information regarding copyright
    public static final ParseField BOUNDARY_SCANNER_FIELD = new ParseField("boundary_scanner");
            maxAnalyzerOffset(in.readOptionalVInt());
 * GitHub history for details.
     */
     * Set the number of fragments, defaults to {@link HighlightBuilder#DEFAULT_NUMBER_OF_FRAGMENTS}
     * Set type of highlighter to use. Out of the box supported types
     * This option is only applicable when using the plain highlighterType {@code highlighter}.
        return (HB) this;
     */
                    throw new ParsingException(p.getTokenLocation(), "pre_tags are set but post_tags are not set");
    /**
     * highlighted text. Can be {@code score}, which then it will be ordered
    }
import org.opensearch.core.common.ParsingException;
        boundaryScannerLocale = template.boundaryScannerLocale;
    }
    }
        preTags = template.preTags;
    public static final ParseField REQUIRE_FIELD_MATCH_FIELD = new ParseField("require_field_match");
        parser.declareBoolean(HB::forceSource, FORCE_SOURCE_FIELD);
        }
            this.boundaryScannerLocale = Locale.forLanguageTag(boundaryScannerLocale);
            builder.field(HIGHLIGHT_QUERY_FIELD.getPreferredName(), highlightQuery);
    }
     * @return this for chaining
    public static final ParseField MATCHED_FIELDS_FIELD = new ParseField("matched_fields");
        out.writeBoolean(hasOptions);
        return (HB) this;
    }
        this.fragmentSize = fragmentSize;
            } catch (IOException e) {
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    public Integer phraseLimit() {
    public BoundaryScannerType boundaryScannerType() {
        this.maxAnalyzerOffset = maxAnalyzerOffset;
     */
        this.boundaryChars = boundaryChars;
            highlightFilter,
    /**
            && Objects.equals(forceSource, other.forceSource)
     * are {@code unified}, {@code plain} and {@code fvh}.
     */
    /**
import org.opensearch.core.xcontent.XContentBuilder;
        return this.forceSource;
    protected String fragmenter;
        parser.declareInt(HB::boundaryMaxScan, BOUNDARY_MAX_SCAN_FIELD);
    /**
            builder.field(FRAGMENTER_FIELD.getPreferredName(), fragmenter);
    /**
    }
        this.fragmenter = fragmenter;
    public static final ParseField FRAGMENTER_FIELD = new ParseField("fragmenter");
     * defines what constitutes a boundary for highlighting. It’s a single string with
        return (HB) this;
    }
        return (HB) this;
     */
        this.order = scoreOrdered;
     * When using the highlighterType {@code fvh} this setting
    }
    /**
        if (this == obj) {
     */
     * When using the highlighterType {@code fvh} this setting
    protected char[] boundaryChars;
     * fields only present in subclass should contribute to hashCode in the implementation
    @SuppressWarnings("unchecked")
            out.writeMap(options);
        return (HB) this;
/*
    public HB preTags(String... preTags) {
        return (HB) this;
            builder.array(PRE_TAGS_FIELD.getPreferredName(), preTags);
    public Boolean forceSource() {
        if (postTags != null) {
        Rewriteable<HB>,
    }
        if (highlightQuery != null) {
    public Boolean highlightFilter() {
            boundaryMaxScan,
            && Objects.equals(highlightFilter, other.highlightFilter)
            builder.field(BOUNDARY_CHARS_FIELD.getPreferredName(), new String(boundaryChars));
    public HB order(Order scoreOrdered) {
        forceSource = template.forceSource;
            builder.field(MAX_ANALYZER_OFFSET_FIELD.getPreferredName(), maxAnalyzerOffset);
        return Arrays.equals(preTags, other.preTags)
        if (in.readBoolean()) {
        out.writeOptionalStringArray(postTags);
    /**
            try {
     * Set the post tags that will be used for highlighting.
 *
     */
        boundaryScannerType(in.readOptionalWriteable(BoundaryScannerType::readFromStream));
        out.writeBoolean(hasQuery);
    }
    @SuppressWarnings("unchecked")
    }
     */
            && Arrays.equals(postTags, other.postTags)
        return builder;
        boundaryChars = template.boundaryChars;
 * You may obtain a copy of the License at
    /**
    /**
            order,
     */
     */
        forceSource(in.readOptionalBoolean());
        return (HB) this;
        }
        postTags(in.readOptionalStringArray());
            Arrays.hashCode(boundaryChars),
    public static final ParseField FORCE_SOURCE_FIELD = new ParseField("force_source");
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        }
     * @return the value set by {@link #boundaryChars(char[])}
            builder.field(BOUNDARY_SCANNER_LOCALE_FIELD.getPreferredName(), boundaryScannerLocale.toLanguageTag());
            && Objects.equals(highlighterType, other.highlighterType)
    public HB phraseLimit(Integer phraseLimit) {
     */
                return p.map();
        order = template.order;
    protected Integer fragmentSize;
    public char[] boundaryChars() {
    /**
    static <HB extends AbstractHighlighterBuilder<HB>> BiFunction<XContentParser, HB, HB> setupParser(ObjectParser<HB, Void> parser) {
        return this.boundaryChars;
     */
    public HB highlightFilter(Boolean highlightFilter) {
        out.writeOptionalVInt(numOfFragments);
        }
        return this.numOfFragments;
        this.boundaryScannerType = BoundaryScannerType.fromString(boundaryScannerType);
    }
     * The order of fragments per field. By default, ordered by the order in the
        }
        return (HB) this;
     * Sets the size of the fragment to return from the beginning of the field if there are no matches to
        if (order != null) {
        return (HB) this;
                }
        }
        }
     * query. Default is {@code false}.
            Arrays.hashCode(postTags),
        this.phraseLimit = phraseLimit;
        parser.declareInt(HB::phraseLimit, PHRASE_LIMIT_FIELD);
        requireFieldMatch = template.requireFieldMatch;
     * Defaults to {@code unified}.
    public HB highlightQuery(QueryBuilder highlightQuery) {
     * @return the value set by {@link #boundaryScannerType(String)}
    }
    /**
            && Objects.equals(highlightQuery, other.highlightQuery)
     */
    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
        if (noMatchSize != null) {
     * Read from a stream.
import org.opensearch.Version;
     */
    @SuppressWarnings("unchecked")
            builder.field(OPTIONS_FIELD.getPreferredName(), options);
    protected BoundaryScannerType boundaryScannerType;
    public String highlighterType() {
    }
        if (fragmentSize != null) {
 * software distributed under the License is distributed on an
            && Objects.equals(options, other.options)
            && Objects.equals(numOfFragments, other.numOfFragments)
     */
        if (boundaryScannerLocale != null) {
            getClass(),
import org.opensearch.core.xcontent.ToXContentObject;
            highlightQuery,
    /**
        }
        if (boundaryChars != null) {
    }
     * @param maxAnalyzerOffset the maximum offset that the highlighter will consider
    /**
 *
/*
    void commonOptionsToXContent(XContentBuilder builder) throws IOException {
    public HB boundaryMaxScan(Integer boundaryMaxScan) {
        boundaryScannerType = template.boundaryScannerType;
    public Locale boundaryScannerLocale() {
    @SuppressWarnings("unchecked")
        };
    }
    @SuppressWarnings("unchecked")
    }
    @SuppressWarnings("unchecked")
        boolean hasOptions = options != null;
    public static final ParseField ORDER_FIELD = new ParseField("order");
 */
     * @return the value set by {@link #requireFieldMatch(Boolean)}
        if (boundaryScannerType != null) {
/**
    public HB boundaryScannerLocale(String boundaryScannerLocale) {
        return (HB) this;
    /**
     */
        }
    public static final ParseField NUMBER_OF_FRAGMENTS_FIELD = new ParseField("number_of_fragments");
public abstract class AbstractHighlighterBuilder<HB extends AbstractHighlighterBuilder<?>>
    /**
        this.highlighterType = highlighterType;
        boolean hasQuery = highlightQuery != null;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    /**
        return this.postTags;
        if (highlighterType != null) {
     * each boundary character defined in it. It defaults to .,!? \t\n
     * @return the value set by {@link #options(Map)}
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
    protected Boolean forceSource;
        doWriteTo(out);
 *
        if (numOfFragments != null) {
    public static final ParseField PRE_TAGS_FIELD = new ParseField("pre_tags");
    }
     */
    /**
        if (options != null && options.size() > 0) {
            highlightQuery(in.readNamedWriteable(QueryBuilder.class));
package org.opensearch.search.fetch.subphase.highlight;
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
    protected Integer boundaryMaxScan;
    /**
    }
        this.highlightQuery = highlightQuery;
            fragmenter,
     * @return this for chaining
 * This abstract class holds parameters shared by {@link HighlightBuilder} and {@link HighlightBuilder.Field}
    protected AbstractHighlighterBuilder(AbstractHighlighterBuilder<?> template, QueryBuilder queryBuilder) {
     * @return the value set by {@link #boundaryScannerLocale(String)}
    public String fragmenter() {
 * Unless required by applicable law or agreed to in writing,
    @Override
            }
    public HB fragmentSize(Integer fragmentSize) {
        return (HB) this;
            builder.field(NO_MATCH_SIZE_FIELD.getPreferredName(), noMatchSize);
    public static final ParseField ENCODER_FIELD = new ParseField("encoder");
}
        return this.noMatchSize;
     * Default is false meaning that terms are highlighted on all requested fields regardless
     */
     */
    implements
        noMatchSize(in.readOptionalVInt());
import java.util.function.BiFunction;
    public Boolean requireFieldMatch() {
        highlightFilter = template.highlightFilter;
        return this.options;
        }
        }
        boundaryMaxScan(in.readOptionalVInt());
import org.opensearch.core.xcontent.ObjectParser;
    /**
    @SuppressWarnings("unchecked")
import java.util.Locale;
            try {
        return this.order;
    @SuppressWarnings("unchecked")
    public HB numOfFragments(Integer numOfFragments) {
    @SuppressWarnings("unchecked")
        }, HIGHLIGHT_QUERY_FIELD);
            } catch (IOException e) {
    }
    protected Integer phraseLimit;
        if (in.readBoolean()) {
    }
        return this.highlighterType;
