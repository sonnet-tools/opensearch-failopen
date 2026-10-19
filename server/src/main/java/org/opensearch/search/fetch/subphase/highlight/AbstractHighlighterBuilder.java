     * @param noMatchSize integer to set or null to leave out of request.  default is null.  
        return (HB) this;
        return (HB) this;
        return (HB) this;  
    /**
        @SuppressWarnings("unchecked")
    public static final ParseField TYPE_FIELD = new ParseField("type");
     * @return the value set by {@link #order(Order)}
        boolean hasQuery = highlightQuery != null;
    public HB highlightFilter(Boolean highlightFilter) {
        parser.declareString(HB::highlighterType, TYPE_FIELD);
        if (numOfFragments != null) {
        if (postTags != null) {
/**  
     * @param phraseLimit maximum number of phrases the fvh will consider  
        };
            && Objects.equals(boundaryScannerType, other.boundaryScannerType)
        highlightQuery = queryBuilder;
        if (hasQuery) {
    @SuppressWarnings("unchecked")
            this.boundaryScannerLocale = Locale.forLanguageTag(boundaryScannerLocale);
        Rewriteable<HB>,  
    }
    }
        }  
        }
     */
    protected Boolean forceSource;
import java.util.Arrays;  
import org.opensearch.core.common.io.stream.StreamOutput;
     * Set to true to cause a field to be highlighted only if a query matches that field.
    @SuppressWarnings("unchecked")
 * license agreements. See the NOTICE file distributed with
    public static final ParseField HIGHLIGHT_FILTER_FIELD = new ParseField("highlight_filter");  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
    public static final ParseField MAX_ANALYZER_OFFSET_FIELD = new ParseField("max_analyzer_offset");  
        preTags = template.preTags;
        return this.options;  
        boundaryMaxScan = template.boundaryMaxScan;  
    protected abstract void doWriteTo(StreamOutput out) throws IOException;  
            builder.field(FRAGMENTER_FIELD.getPreferredName(), fragmenter);
        out.writeBoolean(hasOptions);
import org.opensearch.core.common.ParsingException;
        return (HB) this;
    public static final ParseField BOUNDARY_CHARS_FIELD = new ParseField("boundary_chars");
        out.writeOptionalVInt(noMatchSize);
    public HB preTags(String... preTags) {  
        }, HIGHLIGHT_QUERY_FIELD);
     * When using the highlighterType {@code fvh} this setting
        parser.declareString(HB::boundaryScannerLocale, BOUNDARY_SCANNER_LOCALE_FIELD);  
            builder.field(PHRASE_LIMIT_FIELD.getPreferredName(), phraseLimit);
    public QueryBuilder highlightQuery() {
        return this.boundaryChars;
            getClass(),
        return this.boundaryScannerLocale;
    /**
 * software distributed under the License is distributed on an
        if (in.readBoolean()) {  
    /**
    public HB forceSource(Boolean forceSource) {
        if (fragmentSize != null) {
    @SuppressWarnings("unchecked")
            && doEquals(other);  
        return builder;
     * fields only present in subclass should contribute to hashCode in the implementation
     * controls which scanner to use for fragment boundaries, and defaults to "simple".
     * controls the locale to use by the BreakIterator, defaults to "root".  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        if (highlightQuery != null) {
    public static final ParseField ENCODER_FIELD = new ParseField("encoder");
    }
     * @return the value set by {@link #boundaryScannerLocale(String)}
    protected Integer maxAnalyzerOffset = null;
     */
    }
            && Arrays.equals(boundaryChars, other.boundaryChars)  
        return this.forceSource;
    /**
                }
        return this.fragmentSize;
        parser.declareString((HB hb, String bc) -> hb.boundaryChars(bc.toCharArray()), BOUNDARY_CHARS_FIELD);
        boolean hasBoundaryScannerLocale = boundaryScannerLocale != null;
     * Permitted values are "simple" or "span" relating to {@link SimpleFragmenter} and
     */
 * this file be licensed under the Apache-2.0 license or a
        return this.highlighterType;
    /**
     * Read from a stream.
            builder.field(FRAGMENT_SIZE_FIELD.getPreferredName(), fragmentSize);
        if (in.getVersion().onOrAfter(Version.V_2_2_0)) {  
    public HB order(String order) {
 * not use this file except in compliance with the License.
    public static final ParseField NO_MATCH_SIZE_FIELD = new ParseField("no_match_size");  
     */  
    }
            builder.field(BOUNDARY_SCANNER_LOCALE_FIELD.getPreferredName(), boundaryScannerLocale.toLanguageTag());
     * Sets a query to be used for highlighting instead of the search query.  
     */  
            out.writeOptionalVInt(maxAnalyzerOffset);
        }  
    public static final ParseField BOUNDARY_SCANNER_LOCALE_FIELD = new ParseField("boundary_scanner_locale");  
        if (in.readBoolean()) {
        out.writeOptionalWriteable(boundaryScannerType);
    }
    }
        return this.fragmenter;
        highlighterType = template.highlighterType;
            highlightFilter,
     * Set the post tags that will be used for highlighting.
    public Integer noMatchSize() {  
        doWriteTo(out);  
    /**  
    public HB boundaryScannerType(BoundaryScannerType boundaryScannerType) {
    public static final ParseField BOUNDARY_SCANNER_FIELD = new ParseField("boundary_scanner");  
            phraseLimit,
        parser.declareInt(HB::numOfFragments, NUMBER_OF_FRAGMENTS_FIELD);
    /**
    public HB fragmenter(String fragmenter) {
    public Integer phraseLimit() {  
        parser.declareInt(HB::fragmentSize, FRAGMENT_SIZE_FIELD);  
     * Sets the maximum number of phrases the fvh will consider if the field doesn't also define phraseLimit.
     * @return the value set by {@link #requireFieldMatch(Boolean)}  
        if (highlighterType != null) {
        return (HB) this;  
            requireFieldMatch,
        if (in.readBoolean()) {
    public Integer numOfFragments() {
     */
    public final int hashCode() {
        return (HB) this;  
            && Objects.equals(options, other.options)
    /**
        highlighterType(in.readOptionalString());  
    public AbstractHighlighterBuilder() {}
     * When using the highlighterType {@code fvh} this setting  
        out.writeBoolean(hasBounaryChars);
            && Objects.equals(forceSource, other.forceSource)  
        }  
    public Boolean highlightFilter() {
     */
            boundaryMaxScan,
    protected abstract boolean doEquals(HB other);  
    public HB highlighterType(String highlighterType) {
        boundaryScannerType = template.boundaryScannerType;
    public String toString() {  
    public char[] boundaryChars() {  
        out.writeOptionalString(fragmenter);
    @Override
            try {
    }
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
    public Map<String, Object> options() {
     */  
            builder.field(NUMBER_OF_FRAGMENTS_FIELD.getPreferredName(), numOfFragments);
            options,  
                throw new RuntimeException("Error parsing query", e);  
        out.writeOptionalVInt(boundaryMaxScan);
    /**  
    public String[] postTags() {  
        return this.highlightFilter;
        return (XContentParser p, HB hb) -> {  
        return Objects.hash(  
     */
    protected Integer fragmentSize;  
    @SuppressWarnings("unchecked")
        return this.numOfFragments;  
    }
    }
    @SuppressWarnings("unchecked")
     */
     */  
    @SuppressWarnings("unchecked")  
    /**
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.BoundaryScannerType;
        return (HB) this;
     */
        }
        parser.declareObject(HB::options, (XContentParser p, Void c) -> {
            out.writeNamedWriteable(highlightQuery);
        this.forceSource = forceSource;  
     * controls which scanner to use for fragment boundaries, and defaults to "simple".
    }  
     */  
    }  
 * compatible open source license.
        out.writeOptionalString(highlighterType);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        parser.declareBoolean(HB::requireFieldMatch, REQUIRE_FIELD_MATCH_FIELD);
        this.fragmenter = fragmenter;  
                if (hb.preTags() != null && hb.postTags() == null) {  
        this.postTags = postTags;
    @SuppressWarnings("unchecked")  
     * @return the value set by {@link #noMatchSize(Integer)}
    public static final ParseField BOUNDARY_MAX_SCAN_FIELD = new ParseField("boundary_max_scan");
        this.boundaryChars = boundaryChars;
        }  
        this.boundaryScannerType = boundaryScannerType;  
     * @return the value set by {@link #fragmenter(String)}
    public String fragmenter() {
    @Override  
        this.highlightFilter = highlightFilter;  
import org.opensearch.core.common.Strings;  
    }
            && Arrays.equals(postTags, other.postTags)
     * @return this for chaining
     * Set the pre tags that will be used for highlighting.  
        fragmentSize(in.readOptionalVInt());
    public static final ParseField PRE_TAGS_FIELD = new ParseField("pre_tags");
 */  
     */  
        if (noMatchSize != null) {
    protected String fragmenter;  
     * This option is only applicable when using the plain highlighterType {@code highlighter}.  
     * @return the value set by {@link #boundaryChars(char[])}
    public static final ParseField PHRASE_LIMIT_FIELD = new ParseField("phrase_limit");
     * @return the value set by {@link #postTags(String...)}
    protected String highlighterType;
            highlightQuery(in.readNamedWriteable(QueryBuilder.class));  
    /**  
        order = template.order;
     * Default is false meaning that terms are highlighted on all requested fields regardless
    }
     */
     * highlighted text. Can be {@code score}, which then it will be ordered
    }
    public static final ParseField HIGHLIGHT_QUERY_FIELD = new ParseField("highlight_query");
            builder.field(ORDER_FIELD.getPreferredName(), order.toString());
        options = template.options;
        forceSource(in.readOptionalBoolean());
     */
     * {@link SimpleSpanFragmenter} implementations respectively with the default being "span"
        this.boundaryMaxScan = boundaryMaxScan;
        parser.declareStringArray(fromList(String.class, HB::postTags), POST_TAGS_FIELD);  
     * Set the number of fragments, defaults to {@link HighlightBuilder#DEFAULT_NUMBER_OF_FRAGMENTS}  
     */
 * Licensed to Elasticsearch under one or more contributor  
        this.order = scoreOrdered;  
    }
        }
            builder.array(POST_TAGS_FIELD.getPreferredName(), postTags);
    public final void writeTo(StreamOutput out) throws IOException {
        numOfFragments = template.numOfFragments;
            numOfFragments,
     * @return the value set by {@link #highlightFilter(Boolean)}
            out.writeMap(options);  
    }
     * Set the fragment size in characters, defaults to {@link HighlightBuilder#DEFAULT_FRAGMENT_CHAR_SIZE}
    /**
    }
    public HB postTags(String... postTags) {
        if (hasBounaryChars) {
            Arrays.hashCode(postTags),  
import org.opensearch.index.query.Rewriteable;
     * write common parameters to {@link StreamOutput}
        return (HB) this;  
        if (boundaryScannerType != null) {
    @SuppressWarnings("unchecked")  
                throw new RuntimeException(e);
            && Objects.equals(phraseLimit, other.phraseLimit)  
    @SuppressWarnings("unchecked")
     * query. Default is {@code false}.
            out.writeString(String.valueOf(boundaryChars));  
        return (HB) this;
            boundaryChars(in.readString().toCharArray());
    public HB highlightQuery(QueryBuilder highlightQuery) {  
    public static final ParseField FRAGMENT_OFFSET_FIELD = new ParseField("fragment_offset");
    /**
 * Unless required by applicable law or agreed to in writing,
        out.writeOptionalVInt(phraseLimit);
 * GitHub history for details.
    protected Order order;
        if (fragmenter != null) {
        return (HB) this;
        return this.highlightQuery;  
    }
        }  
    }
        builder.endObject();  
        requireFieldMatch(in.readOptionalBoolean());
    public static final ParseField OPTIONS_FIELD = new ParseField("options");  
        if (boundaryScannerLocale != null) {
import org.opensearch.core.xcontent.ObjectParser;
        if (options != null && options.size() > 0) {
     * Allows to set custom options for custom highlighters.  
        if (highlightFilter != null) {
    public static final ParseField REQUIRE_FIELD_MATCH_FIELD = new ParseField("require_field_match");
     */  
        return (HB) this;  
                return parseInnerQueryBuilder(p);
    public HB boundaryScannerLocale(String boundaryScannerLocale) {  
        out.writeOptionalWriteable(order);
            builder.array(PRE_TAGS_FIELD.getPreferredName(), preTags);
        }  
    protected Integer numOfFragments;
        numOfFragments(in.readOptionalVInt());
        if (obj == null || getClass() != obj.getClass()) {
            boundaryScannerLocale(in.readString());
        out.writeOptionalBoolean(highlightFilter);
            doHashCode()
    @SuppressWarnings("unchecked")  
     * fields only present in subclass should be checked for equality in the implementation
            boundaryScannerLocale,  
     * @return the value set by {@link #highlighterType(String)}
        parser.declareStringArray(fromList(String.class, HB::preTags), PRE_TAGS_FIELD);
     */
     */  
        parser.declareBoolean(HB::highlightFilter, HIGHLIGHT_FILTER_FIELD);
import org.opensearch.Version;  
            && Objects.equals(boundaryScannerLocale, other.boundaryScannerLocale)
        return this.boundaryMaxScan;
        if (boundaryScannerLocale != null) {
     * @return the value set by {@link #forceSource(Boolean)}
        fragmenter(in.readOptionalString());
    protected abstract void innerXContent(XContentBuilder builder) throws IOException;
            fragmenter,
    }
public abstract class AbstractHighlighterBuilder<HB extends AbstractHighlighterBuilder<?>>  
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        if (requireFieldMatch != null) {
    /**  
        phraseLimit = template.phraseLimit;
        noMatchSize = template.noMatchSize;  
     * @return the value set by {@link #preTags(String...)}  
        );  
     * @return this for chaining
        }  
        boundaryScannerType(in.readOptionalWriteable(BoundaryScannerType::readFromStream));
     */
            try {
    public HB phraseLimit(Integer phraseLimit) {
        out.writeOptionalBoolean(forceSource);  
    @SuppressWarnings("unchecked")
            builder.field(OPTIONS_FIELD.getPreferredName(), options);
        return (HB) this;
     * The order of fragments per field. By default, ordered by the order in the
    /**  
        boundaryChars = template.boundaryChars;
    /**
     * and you want to provide highlighting on filter clauses in your
    /**
        }  
    }  
            && Objects.equals(noMatchSize, other.noMatchSize)
    /**  
            && Objects.equals(highlightQuery, other.highlightQuery)  
            && Objects.equals(fragmentSize, other.fragmentSize)
package org.opensearch.search.fetch.subphase.highlight;
        if (preTags != null) {
     * @return the value set by {@link #boundaryScannerType(String)}
     * @return the value set by {@link #numOfFragments(Integer)}  
        }
        postTags(in.readOptionalStringArray());  
            && Objects.equals(order, other.order)
    /**
        this.phraseLimit = phraseLimit;
    protected String[] postTags;
    @SuppressWarnings("unchecked")
 * KIND, either express or implied.  See the License for the
    @SuppressWarnings("unchecked")
     * Set type of highlighter to use. Out of the box supported types
    public HB boundaryMaxScan(Integer boundaryMaxScan) {
     */
        this.requireFieldMatch = requireFieldMatch;
        return (HB) this;
    /**
        }  
        return this.order;
        }  
    public static final ParseField MATCHED_FIELDS_FIELD = new ParseField("matched_fields");
    protected AbstractHighlighterBuilder(StreamInput in) throws IOException {
        forceSource = template.forceSource;
        boolean hasBounaryChars = boundaryChars != null;  
    protected String[] preTags;
    protected Map<String, Object> options;
    }
    public Boolean requireFieldMatch() {
        out.writeBoolean(hasQuery);  
    @SuppressWarnings("unchecked")  
    public static final ParseField ORDER_FIELD = new ParseField("order");
    protected Boolean highlightFilter;  
    public static final ParseField NUMBER_OF_FRAGMENTS_FIELD = new ParseField("number_of_fragments");  
 *
     * Forces the highlighting to highlight fields based on the source even if fields are stored separately.
        }  
        }  
    public HB boundaryScannerType(String boundaryScannerType) {
     */
            && Objects.equals(requireFieldMatch, other.requireFieldMatch)
    /**
     */
    /**  
    public static final ParseField FRAGMENT_SIZE_FIELD = new ParseField("fragment_size");
            Arrays.hashCode(boundaryChars),
        parser.declareInt(HB::maxAnalyzerOffset, MAX_ANALYZER_OFFSET_FIELD);  
    }
        }, OPTIONS_FIELD);
        out.writeBoolean(hasBoundaryScannerLocale);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected abstract int doHashCode();  
/*  
    }  
     */  
     */
    /**  
     * by score of the fragments, or {@code none}.  
    public Locale boundaryScannerLocale() {
            && Objects.equals(numOfFragments, other.numOfFragments)  
        }  
        }  
    }
                parser.parse(p, hb, null);
 * This abstract class holds parameters shared by {@link HighlightBuilder} and {@link HighlightBuilder.Field}
        if (out.getVersion().onOrAfter(Version.V_2_2_0)) {  
     */  
    }
     * Defaults to {@code unified}.  
     * @return this for chaining
        return this.preTags;  
        parser.declareBoolean(HB::forceSource, FORCE_SOURCE_FIELD);
            } catch (IOException e) {
        parser.declareString(HB::fragmenter, FRAGMENTER_FIELD);
        HB other = (HB) obj;
    }  
        return (HB) this;  
    /**  
    }  
    public static final ParseField FORCE_SOURCE_FIELD = new ParseField("force_source");
    public static final ParseField FRAGMENTER_FIELD = new ParseField("fragmenter");
        Writeable,
 * and provides the common setters, equality, hashCode calculation and common serialization
    }
    /**
    }
     * If set to {@link Order#SCORE}, this changes order to score of the fragments.
        if (boundaryChars != null) {
        highlightFilter = template.highlightFilter;  
            try {  
    }
     */
    /**  
     */
    static <HB extends AbstractHighlighterBuilder<HB>> BiFunction<XContentParser, HB, HB> setupParser(ObjectParser<HB, Void> parser) {
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.index.query.QueryBuilder;  
     * Sets the maximum offset for the highlighter
    @SuppressWarnings("unchecked")  
    /**  
     */  
        }  
        parser.declareString(HB::order, ORDER_FIELD);
    public Integer maxAnalyzerOffset() {  
        if (this == obj) {
    @Override
            && Objects.equals(highlighterType, other.highlighterType)
    public HB boundaryChars(char[] boundaryChars) {
            forceSource,
        boundaryScannerLocale = template.boundaryScannerLocale;
 *
            } catch (IOException e) {
     */
    }
    public Boolean forceSource() {
    protected Locale boundaryScannerLocale;
 * this work for additional information regarding copyright
        }
    public HB maxAnalyzerOffset(Integer maxAnalyzerOffset) {
     * if the query matches specifically on them.  
import org.apache.lucene.search.highlight.SimpleFragmenter;
        parser.declareString(HB::boundaryScannerType, BOUNDARY_SCANNER_FIELD);  
        this.noMatchSize = noMatchSize;
     * are {@code unified}, {@code plain} and {@code fvh}.
    }  
    }  
        out.writeOptionalStringArray(preTags);
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.ToXContentObject;  
            }
    public HB noMatchSize(Integer noMatchSize) {
     */  
        return this.boundaryScannerType;
import static org.opensearch.core.xcontent.ObjectParser.fromList;  
            return true;
        preTags(in.readOptionalStringArray());
        this.highlightQuery = highlightQuery;
    protected Integer phraseLimit;
import java.util.function.BiFunction;
            && Objects.equals(boundaryMaxScan, other.boundaryMaxScan)
 * ownership. Elasticsearch licenses this file to you under  
     */  
            builder.field(HIGHLIGHT_QUERY_FIELD.getPreferredName(), highlightQuery);
     * each boundary character defined in it. It defaults to .,!? \t\n
        noMatchSize(in.readOptionalVInt());
     */
     */
     * @param maxAnalyzerOffset the maximum offset that the highlighter will consider  
     */
        this.numOfFragments = numOfFragments;
     * Sets the size of the fragment to return from the beginning of the field if there are no matches to
        }  
        this.options = options;
        out.writeOptionalBoolean(requireFieldMatch);
            maxAnalyzerOffset(in.readOptionalVInt());
     * @return the value set by {@link #fragmentSize(Integer)}
            builder.field(TYPE_FIELD.getPreferredName(), highlighterType);
        }  
     * Details of the different highlighter types are covered in the reference guide.
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.Order;  
        boundaryMaxScan(in.readOptionalVInt());  
        }
        return Arrays.equals(preTags, other.preTags)  
        innerXContent(builder);
            boundaryScannerType,  
     */
    @SuppressWarnings("unchecked")
            return false;
    }
        order(in.readOptionalWriteable(Order::readFromStream));
 *  
    @SuppressWarnings("unchecked")  
    public final boolean equals(Object obj) {  
        return this.phraseLimit;
    @Override
     * When using the highlighterType {@code fvh} this setting
        if (forceSource != null) {
            builder.field(BOUNDARY_MAX_SCAN_FIELD.getPreferredName(), boundaryMaxScan);
        if (hasBoundaryScannerLocale) {
        }  
    protected Integer boundaryMaxScan;  
    @SuppressWarnings("unchecked")
            return hb;  
            }
        parser.declareObject(HB::highlightQuery, (XContentParser p, Void c) -> {
    public String[] preTags() {
 * specific language governing permissions and limitations
    }  
            } catch (IOException e) {  
import org.opensearch.core.common.io.stream.Writeable;  
    protected QueryBuilder highlightQuery;
            }  
    @Override
    protected char[] boundaryChars;
    public static final ParseField POST_TAGS_FIELD = new ParseField("post_tags");  
        ToXContentObject {
        }  
        this.maxAnalyzerOffset = maxAnalyzerOffset;
    @SuppressWarnings("unchecked")
 * The OpenSearch Contributors require contributions made to  
        if (maxAnalyzerOffset != null) {
    implements
            highlightQuery,
        return (HB) this;
        this.fragmentSize = fragmentSize;  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
    protected Integer noMatchSize;  
        out.writeOptionalStringArray(postTags);  
    public HB fragmentSize(Integer fragmentSize) {
        }  
    public HB order(Order scoreOrdered) {
    public Integer fragmentSize() {
            Arrays.hashCode(preTags),
     * @return the value set by {@link #options(Map)}  
    }  
    /**
     */
    /**  
            order,  
     * Set this to true when using the highlighterType {@code fvh}  
        return this.maxAnalyzerOffset;
     */
        parser.declareInt(HB::noMatchSize, NO_MATCH_SIZE_FIELD);  
/*
        this.preTags = preTags;
     */
        if (in.readBoolean()) {
            options(in.readMap());
import java.util.Objects;  
    public Order order() {
        return (HB) this;  
        return this.noMatchSize;
     * @return the value set by {@link #boundaryMaxScan(Integer)}
            builder.field(NO_MATCH_SIZE_FIELD.getPreferredName(), noMatchSize);
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
            highlighterType,  
import java.util.Locale;
    /**  
import org.opensearch.core.ParseField;
            builder.field(FORCE_SOURCE_FIELD.getPreferredName(), forceSource);
    /**
        parser.declareInt(HB::phraseLimit, PHRASE_LIMIT_FIELD);
        postTags = template.postTags;
    }
            builder.field(MAX_ANALYZER_OFFSET_FIELD.getPreferredName(), maxAnalyzerOffset);
        return this.requireFieldMatch;  
        boolean hasOptions = options != null;  
     * Sets what fragmenter to use to break up text that is eligible for highlighting.
    }
 */
    public HB numOfFragments(Integer numOfFragments) {  
            && Objects.equals(fragmenter, other.fragmenter)
    public HB options(Map<String, Object> options) {  
        phraseLimit(in.readOptionalVInt());
        return (HB) this;
        requireFieldMatch = template.requireFieldMatch;  
     * When using the highlighterType {@code fvh} this setting  
     * @return the value set by {@link #phraseLimit(Integer)}
        out.writeOptionalVInt(fragmentSize);
    @SuppressWarnings("unchecked")  
    }  
        this.boundaryScannerType = BoundaryScannerType.fromString(boundaryScannerType);
 * You may obtain a copy of the License at  
    /**
            builder.field(HIGHLIGHT_FILTER_FIELD.getPreferredName(), highlightFilter);
                    throw new ParsingException(p.getTokenLocation(), "pre_tags are set but post_tags are not set");
    /**
        fragmentSize = template.fragmentSize;  
    public String highlighterType() {  
 *  
        if (order != null) {
        }  
        maxAnalyzerOffset = template.maxAnalyzerOffset;
     * highlight and the field doesn't also define noMatchSize.
    }
        highlightFilter(in.readOptionalBoolean());  
    }
        }  
    public static final ParseField FIELDS_FIELD = new ParseField("fields");
import org.opensearch.core.xcontent.XContentParser;
    /**
            builder.field(BOUNDARY_SCANNER_FIELD.getPreferredName(), boundaryScannerType.name());
import java.util.Map;
            fragmentSize,
/*  
        }  
    /**
        if (phraseLimit != null) {
        return order(Order.fromString(order));  
    public HB requireFieldMatch(Boolean requireFieldMatch) {  
 * Modifications Copyright OpenSearch Contributors. See
     * When using the highlighterType {@code fvh} and boundaryScannerType {@code break_iterator}, this setting
        return (HB) this;  
            out.writeString(boundaryScannerLocale.toLanguageTag());
    protected Boolean requireFieldMatch;  
     * By default, fragments of a field are ordered by the order in the highlighted text.
        out.writeOptionalVInt(numOfFragments);
    /**  
 * under the License.  
        parser.declareInt(HB::boundaryMaxScan, BOUNDARY_MAX_SCAN_FIELD);
    public Integer boundaryMaxScan() {  
        }  
import java.io.IOException;
     * controls how far to look for boundary characters, and defaults to 20.
import org.opensearch.core.xcontent.XContentBuilder;
        return (HB) this;
 */  
    void commonOptionsToXContent(XContentBuilder builder) throws IOException {  
        return this.postTags;
    }
    protected BoundaryScannerType boundaryScannerType;
        this.highlighterType = highlighterType;
        }  
     * @return the value set by {@link #highlightQuery(QueryBuilder)}  
        if (hasOptions) {
            builder.field(BOUNDARY_CHARS_FIELD.getPreferredName(), new String(boundaryChars));
            builder.field(REQUIRE_FIELD_MATCH_FIELD.getPreferredName(), requireFieldMatch);
    public BoundaryScannerType boundaryScannerType() {
    /**  
 * @opensearch.internal
    /**
    /**
    protected AbstractHighlighterBuilder(AbstractHighlighterBuilder<?> template, QueryBuilder queryBuilder) {  
        }  
    }
        builder.startObject();
     * defines what constitutes a boundary for highlighting. It’s a single string with  
    /**
                return p.map();  
        return (HB) this;
            noMatchSize,
    /**
    /**  
    }
}  
     */
        if (boundaryMaxScan != null) {
                throw new RuntimeException("Error parsing options", e);
            && Objects.equals(highlightFilter, other.highlightFilter)
    }
     */  
        fragmenter = template.fragmenter;  
     */
