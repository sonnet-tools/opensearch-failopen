    }
     * Gets value set with {@link #useExplicitFieldOrder(boolean)}
    ) throws IOException {
            targetOptionsBuilder.highlightFilter(highlighterBuilder.highlightFilter);
        useExplicitFieldOrder(in.readBoolean());
            transferOptions(field, fieldOptionsBuilder, context);
     * default number of fragments of 5.
     * Adds a field to be highlighted with a provided fragment size (in characters), and
        }
    }
            targetOptionsBuilder.boundaryMaxScan(highlighterBuilder.boundaryMaxScan);
                builder.startObject(FIELDS_FIELD.getPreferredName());
        @Override
        CHARS,
        public Field matchedFields(String... matchedFields) {
    /**
        for (int i = 0; i < array.length; i++) {
        // create template global options that are later merged with any partial field options
     *
            matchedFields(in.readOptionalStringArray());
    public void innerXContent(XContentBuilder builder) throws IOException {
        this.fields = in.readList(Field::new);
        .postTags(DEFAULT_POST_TAGS)
     * @param numberOfFragments The (maximum) number of fragments
     */
    public static final String[] DEFAULT_STYLED_POST_TAGS = { "</em>" };
import java.util.Locale;
        return Objects.equals(encoder, other.encoder)
        return builder;
     */
@PublicApi(since = "1.0.0")
        .boundaryChars(DEFAULT_BOUNDARY_CHARS)
     * @param name              The field to highlight
import java.util.Collection;
        this.useExplicitFieldOrder = template.useExplicitFieldOrder;
 *
        if (highlightQuery != null) {
     * Read from a stream.
            targetOptionsBuilder.boundaryScannerLocale(highlighterBuilder.boundaryScannerLocale);
        Character[] charArray = new Character[array.length];
        this.encoder = encoder;
    public static final String[] DEFAULT_POST_TAGS = new String[] { "</em>" };
        }
        .fragmentCharSize(DEFAULT_FRAGMENT_CHAR_SIZE)
    public HighlightBuilder encoder(String encoder) {
                break;
     */
 * specific language governing permissions and limitations
    /**
            fragmentOffset(in.readVInt());
        }
            return Objects.hash(name, fragmentOffset, Arrays.hashCode(matchedFields));
                fieldOptionsBuilder.matchedFields(matchedFields);
     * Send the fields to be highlighted using a syntax that is specific about the order in which they should be highlighted.
    private boolean useExplicitFieldOrder = false;
        protected void doWriteTo(StreamOutput out) throws IOException {
                Set<String> matchedFields = new HashSet<>(field.matchedFields.length);
        return new SearchHighlightContext(fieldOptions);
        }
        if (highlighterBuilder.numOfFragments != null) {
    }
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public String name() {
        // overwrite unset global options by default values
        globalOptionsBuilder.encoder(this.encoder);
    public static final String[] DEFAULT_STYLED_PRE_TAG = {
            targetOptionsBuilder.requireFieldMatch(highlighterBuilder.requireFieldMatch);
        "<em class=\"hlt10\">" };
    @Override
        if (highlighterBuilder.boundaryMaxScan != null) {
    /** default for whether {@code fvh} should provide highlighting on filter clauses */
        for (Field field : this.fields) {
        }
 * under the License.
    }
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
        // special options for top-level highlighter
        if (array == null) {
            }
    /** default for whether a field should be highlighted only if a query matches that field */
            case "styled":
                return Order.SCORE;
 * not use this file except in compliance with the License.
import java.util.Arrays;
            targetOptionsBuilder.highlighterType(highlighterBuilder.highlighterType);
                builder.field(FRAGMENT_OFFSET_FIELD.getPreferredName(), fragmentOffset);
            && Objects.equals(fields, other.fields);
    }
     * @throws IOException on errors parsing any optional nested highlight query
    @Override
            FIELDS_FIELD
        public void writeTo(StreamOutput out) throws IOException {
    }
    public HighlightBuilder tagsSchema(String schemaName) {
    public static final int DEFAULT_NUMBER_OF_FRAGMENTS = 5;
        super(template, highlightQuery);
     *
    /**
    /**
import java.util.ArrayList;
        }
     * @param encoder name
            if (fragmentOffset != -1) {
        private final String name;
        parser.declareNamedObjects(
        }
     * {@link FieldOptions.Builder}, effectively overwriting existing settings
        );
        @Override
    }
    static Character[] convertCharArray(char[] array) {
package org.opensearch.search.fetch.subphase.highlight;
            out.writeString(name);
        @Override
     * Adds a field to be highlighted with a provided fragment size (in characters), and
import java.util.HashSet;
    }
        commonOptionsToXContent(builder);
        }
 * license agreements. See the NOTICE file distributed with
    public static class Field extends AbstractHighlighterBuilder<Field> {
        // first write common options
        return field(new Field(name).fragmentSize(fragmentSize).numOfFragments(numberOfFragments));
            charArray[i] = array[i];
        }
     * default number of fragments of 5 using the default encoder
            fieldOptionsBuilder.fragmentOffset(field.fragmentOffset);
            targetOptionsBuilder.boundaryChars(convertCharArray(highlighterBuilder.boundaryChars));
        transferOptions(this, globalOptionsBuilder, context);
        final SearchHighlightContext.FieldOptions.Builder globalOptionsBuilder = new SearchHighlightContext.FieldOptions.Builder();
            highlightQuery = this.highlightQuery.rewrite(ctx);
import org.opensearch.index.query.QueryBuilder;
 */
            fragmentOffset = template.fragmentOffset;
    /** default for highlight fragments being ordered by score */
 */
            targetOptionsBuilder.noMatchSize(highlighterBuilder.noMatchSize);
                builder.endArray();
    public enum Order implements Writeable {
     */
            builder.endObject();
        if (highlighterBuilder.forceSource != null) {
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at
    public static final int DEFAULT_PHRASE_LIMIT = 256;
            }
        if (highlighterBuilder.requireFieldMatch != null) {
    }
        return this;
import java.io.IOException;
    }
        return this.fields;
        public static BoundaryScannerType readFromStream(StreamInput in) throws IOException {
            return null;
    }
/*
     * a provided (maximum) number of fragments.
    /**
        .build();
 * are summarized to show only selected snippets ("fragments") containing search terms.
        .scoreOrdered(DEFAULT_SCORE_ORDERED)
     * @param fragmentSize      The size of a fragment in characters
 * this work for additional information regarding copyright
            return name().toLowerCase(Locale.ROOT);
import org.apache.lucene.search.vectorhighlight.SimpleBoundaryScanner;
 * the Apache License, Version 2.0 (the "License"); you may
        }
    private final List<Field> fields;
    private static final BiFunction<XContentParser, HighlightBuilder, HighlightBuilder> PARSER;
            targetOptionsBuilder.highlightQuery(highlighterBuilder.highlightQuery.toQuery(context));
    @Override
        return this;
        public Field rewrite(QueryRewriteContext ctx) throws IOException {
        builder.endObject();
                builder.startArray(FIELDS_FIELD.getPreferredName());
        }
        /**
        }
        }
         * it is not automatically included.
    @Override
 * @opensearch.api
    public HighlightBuilder(StreamInput in) throws IOException {
        }
            this.matchedFields = matchedFields;
        return field(new Field(name).fragmentSize(fragmentSize));
        this.useExplicitFieldOrder = useExplicitFieldOrder;
    public HighlightBuilder useExplicitFieldOrder(boolean useExplicitFieldOrder) {
            targetOptionsBuilder.scoreOrdered(highlighterBuilder.order == Order.SCORE);
        PARSER = setupParser(parser);
        }
 *
     * @opensearch.api
            return name().toLowerCase(Locale.ROOT);
import org.opensearch.core.ParseField;
        .phraseLimit(DEFAULT_PHRASE_LIMIT)
        .encoder(DEFAULT_ENCODER)
            // write common options
         */
     */
        public static Order readFromStream(StreamInput in) throws IOException {
     * a provided (maximum) number of fragments.
        this.fields = fields;
        }
        .highlightFilter(DEFAULT_HIGHLIGHT_FILTER)
            return this;
    /**
        }
        }
        public void innerXContent(XContentBuilder builder) throws IOException {
    @PublicApi(since = "1.0.0")
        "<em class=\"hlt7\">",
            this.name = name;
                }
            } else {
    }
    }
import static org.opensearch.core.xcontent.ObjectParser.fromList;
        }
    /**
            BiFunction<XContentParser, Field, Field> decoratedParser = setupParser(parser);
     */
     */
            if (order.toUpperCase(Locale.ROOT).equals(SCORE.name())) {
    public static HighlightBuilder fromXContent(XContentParser p) {
                preTags(DEFAULT_PRE_TAGS);
 *
        // create field options
 */
     * Boundary scanner type
        if (highlighterBuilder.phraseLimit != null) {
    /** default for whether to highlight fields based on the source even if stored separately */
        if (highlighterBuilder.maxAnalyzerOffset != null) {
    /**
        if (highlighterBuilder.boundaryScannerType != null) {
     * Order for highlight builder
    public static final boolean DEFAULT_REQUIRE_FIELD_MATCH = true;
            && Objects.equals(useExplicitFieldOrder, other.useExplicitFieldOrder)
            Field.PARSER,
     * Transfers field options present in the input {@link AbstractHighlighterBuilder} to the receiving
        SCORE;
            targetOptionsBuilder.maxAnalyzerOffset(highlighterBuilder.maxAnalyzerOffset);
            targetOptionsBuilder.postTags(highlighterBuilder.postTags);
            return name;
        }
    /** default for fragment size when there are no matches */
import org.opensearch.common.annotation.PublicApi;
     */
                preTags(DEFAULT_STYLED_PRE_TAG);
        .boundaryScannerLocale(Locale.ROOT)
        if (highlighterBuilder.options != null) {
        out.writeBoolean(useExplicitFieldOrder);
            out.writeOptionalStringArray(matchedFields);
            out.writeEnum(this);
    }
        parser.declareString(HighlightBuilder::tagsSchema, new ParseField("tags_schema"));
            assert this.equals(new Field(this, highlightQuery)) : "copy constructor is broken";
            builder.field(ENCODER_FIELD.getPreferredName(), encoder);
        }
     * @opensearch.api
                postTags(DEFAULT_STYLED_POST_TAGS);
            }
    }
                    return new Field(this, rewrite);
    /**
    /**
    static final Character[] DEFAULT_BOUNDARY_CHARS = HighlightBuilder.convertCharArray(SimpleBoundaryScanner.DEFAULT_BOUNDARY_CHARS);
            targetOptionsBuilder.fragmenter(highlighterBuilder.fragmenter);
            name = in.readString();
    public HighlightBuilder field(String name, int fragmentSize, int numberOfFragments) {
            targetOptionsBuilder.forceSource(highlighterBuilder.forceSource);
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext.FieldOptions;
        return this;
/*
    public HighlightBuilder field(Field field) {
        /**
import java.util.function.BiFunction;
    private String encoder;
        }
        }
        return new HighlightBuilder(this, highlightQuery, fields);
 * GitHub history for details.
        fields = new ArrayList<>();
        return field(new Field(name));
    }
import org.opensearch.core.common.io.stream.Writeable;
        }
        String[] matchedFields;
                if (rewrite != highlightQuery) {
            targetOptionsBuilder.phraseLimit(highlighterBuilder.phraseLimit);
                postTags(DEFAULT_POST_TAGS);
            parser.declareInt(Field::fragmentOffset, FRAGMENT_OFFSET_FIELD);
        protected int doHashCode() {
            matchedFields = template.matchedFields;
        "<em class=\"hlt4\">",
        }
    /** the default number of fragments size in characters */
     * Adds a field to be highlighted with default fragment size of 100 characters, and
     */
        QueryBuilder highlightQuery = this.highlightQuery;
/**
            PARSER = (XContentParser p, Void c, String name) -> decoratedParser.apply(p, new Field(name));
         * Set the matched fields to highlight against this field data.  Default to null, meaning just
            (HighlightBuilder hb) -> hb.useExplicitFieldOrder(true),
                Collections.addAll(matchedFields, field.matchedFields);
            targetOptionsBuilder.boundaryScannerType(highlighterBuilder.boundaryScannerType);
    }
        .boundaryMaxScan(SimpleBoundaryScanner.DEFAULT_MAX_SCAN)
         * Read from a stream.
    }
            name = template.name;
    }
    private static void transferOptions(
        static {
     * @param highlighterBuilder highlight builder with the input options
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            super(in);
     * @param targetOptionsBuilder the receiving options builder
     *
        out.writeList(fields);
        @Override
        public Field(String name) {
     * @param context needed to convert {@link QueryBuilder} to {@link Query}
        if (fields.size() > 0) {
                }
     * are {@code html} and {@code default}.
        public void writeTo(StreamOutput out) throws IOException {
    /**
            parser.declareStringArray(fromList(String.class, Field::matchedFields), MATCHED_FIELDS_FIELD);
            out.writeEnum(this);
    public static final String[] DEFAULT_PRE_TAGS = new String[] { "<em>" };
    public static final boolean DEFAULT_SCORE_ORDERED = false;
        if (highlighterBuilder.noMatchSize != null) {
        switch (schemaName) {
        builder.startObject();
            builder.startObject(name);
            if (highlightQuery != null) {
        public static BoundaryScannerType fromString(String boundaryScannerType) {
     */
        protected boolean doEquals(Field other) {
         */
    }
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.XContentParser;
import java.util.Collections;
    public HighlightBuilder field(String name) {
 *
     * @return this for chaining
}
        }
            return this;
        int fragmentOffset = -1;
    @SuppressWarnings({ "rawtypes", "unchecked" })
    /**
        }
        }
        return PARSER.apply(p, new HighlightBuilder());
                field.innerXContent(builder);
 * KIND, either express or implied.  See the License for the
     * Adds a field to be highlighted with a provided fragment size (in characters), and
                if (useExplicitFieldOrder) {
     * @param name              The field to highlight
        if (encoder != null) {
import org.opensearch.core.common.io.stream.StreamInput;
        .noMatchSize(DEFAULT_NO_MATCH_SIZE)
                throw new IllegalArgumentException("Unknown tag schema [" + schemaName + "]");
     * @param name The field to highlight
        }
                QueryBuilder rewrite = highlightQuery.rewrite(ctx);
        }
        public Field(StreamInput in) throws IOException {
            this.fragmentOffset = fragmentOffset;
    /** the default number of fragments for highlighting */
        }
        if (highlighterBuilder.boundaryScannerLocale != null) {
     *
    }
    public HighlightBuilder(HighlightBuilder template, QueryBuilder highlightQuery, List<Field> fields) {
    }
    public HighlightBuilder field(String name, int fragmentSize, int numberOfFragments, int fragmentOffset) {
        if (highlighterBuilder.fragmenter != null) {
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.ObjectParser.NamedObjectParser;
        }
        .forceSource(DEFAULT_FORCE_SOURCE)
        if (highlighterBuilder.fragmentSize != null) {
    @Override
            if (matchedFields != null) {
            }
    /** the default opening tag  */
     * are {@code styled} and {@code default}.
        encoder(in.readOptionalString());
            targetOptionsBuilder.fragmentCharSize(highlighterBuilder.fragmentSize);
import java.util.List;
                    builder.endObject();
        .requireFieldMatch(DEFAULT_REQUIRE_FIELD_MATCH)
     *
     */
 * compatible open source license.
        assert this.equals(new HighlightBuilder(this, highlightQuery, fields)) : "copy constructor is broken";
     */
        if (highlighterBuilder.preTags != null) {
        @Override
    /**
    static {
            return valueOf(boundaryScannerType.toUpperCase(Locale.ROOT));
     * @param name         The field to highlight
    }
 * Licensed to Elasticsearch under one or more contributor
        }
        return this;
        }
    public static final String DEFAULT_ENCODER = "default";
            case "default":
    protected boolean doEquals(HighlightBuilder other) {
            fieldOptions.add(
    protected int doHashCode() {
                if (useExplicitFieldOrder) {
            return this;
        }
    }
        }
    /**
        }
        "<em class=\"hlt3\">",
                builder.array(MATCHED_FIELDS_FIELD.getPreferredName(), matchedFields);
 * SPDX-License-Identifier: Apache-2.0
    /** the default closing tags when {@code tag_schema = "styled"}  */
            if (useExplicitFieldOrder) {
     */
        NONE,
        @Override
    public HighlightBuilder() {
        }
            final SearchHighlightContext.FieldOptions.Builder fieldOptionsBuilder = new SearchHighlightContext.FieldOptions.Builder();
        }
            return NONE;
        @Override
    public enum BoundaryScannerType implements Writeable {
    public SearchHighlightContext build(QueryShardContext context) throws IOException {
        if (highlighterBuilder.postTags != null) {
        static final NamedObjectParser<Field, Void> PARSER;
            HighlightBuilder::fields,
        }
            default:
        }
            return in.readEnum(Order.class);
    public List<Field> fields() {
        private Field(Field template, QueryBuilder builder) {
        if (highlighterBuilder.highlighterType != null) {
            return Objects.equals(name, other.name)
        Collection<SearchHighlightContext.Field> fieldOptions = new ArrayList<>();
        }
import org.opensearch.index.query.QueryRewriteContext;
        return this.useExplicitFieldOrder;
            );
/*
            return this;
    @PublicApi(since = "1.0.0")
 *
            targetOptionsBuilder.numberOfFragments(highlighterBuilder.numOfFragments);
            targetOptionsBuilder.options(highlighterBuilder.options);
    public static final int DEFAULT_FRAGMENT_CHAR_SIZE = 100;
            }
        fields.add(field);
    /**
        return this.encoder;
    public static final int DEFAULT_NO_MATCH_SIZE = 0;
 *    http://www.apache.org/licenses/LICENSE-2.0
        public static Order fromString(String order) {
     * @param schemaName The tag scheme name
        super(in);
        ObjectParser<HighlightBuilder, Void> parser = new ObjectParser<>("highlight");
        public String toString() {
    }
        }
        }
    @PublicApi(since = "1.0.0")
        .numberOfFragments(DEFAULT_NUMBER_OF_FRAGMENTS)
     * @param fragmentSize      The size of a fragment in characters
        "<em class=\"hlt1\">",
    void fields(List<Field> fields) {
     * @param fragmentSize The size of a fragment in characters
        "<em class=\"hlt2\">",
        if (highlighterBuilder.highlightQuery != null) {
            out.writeVInt(fragmentOffset);
     * a {@link FieldOptions} with default settings
        if (highlighterBuilder.boundaryChars != null) {
            // write special field-highlighter options
     *
 */
import java.util.Objects;
            super(template, builder);
        return field(new Field(name).fragmentSize(fragmentSize).numOfFragments(numberOfFragments).fragmentOffset(fragmentOffset));
    static final FieldOptions defaultOptions = new SearchHighlightContext.FieldOptions.Builder().preTags(DEFAULT_PRE_TAGS)
        }
import org.opensearch.core.xcontent.ObjectParser;
     *
    public static final boolean DEFAULT_HIGHLIGHT_FILTER = false;
        if (highlighterBuilder.highlightFilter != null) {
                new SearchHighlightContext.Field(field.name(), fieldOptionsBuilder.merge(globalOptionsBuilder.build()).build())
        "<em class=\"hlt5\">",
    /** the default closing tag  */
        public String toString() {
            if (useExplicitFieldOrder) {
     *
 * ownership. Elasticsearch licenses this file to you under
            commonOptionsToXContent(builder);
     */
        "<em class=\"hlt9\">",
     * @param numberOfFragments The (maximum) number of fragments
    }
        if (highlightQuery == this.highlightQuery && fields == this.fields) {
import org.opensearch.index.query.QueryShardContext;
            } else {
    }
 * A builder for search highlighting. Settings can control how large fields
        "<em class=\"hlt6\">",
            targetOptionsBuilder.preTags(highlighterBuilder.preTags);
     *
     * Set a tag scheme that encapsulates a built in pre and post tags. The allowed schemes
     * Getter for {@link #encoder(String)}
     * @opensearch.api
    }
 * this file be licensed under the Apache-2.0 license or a
        return charArray;
    public Boolean useExplicitFieldOrder() {
import org.opensearch.core.common.io.stream.StreamOutput;
        parser.declareString(HighlightBuilder::encoder, ENCODER_FIELD);
            }
    /** the default opening tags when {@code tag_schema = "styled"}  */
        }
            for (Field field : fields) {
            ObjectParser<Field, Void> parser = new ObjectParser<>("highlight_field");
        List<Field> fields = Rewriteable.rewrite(this.fields, ctx);
            return in.readEnum(BoundaryScannerType.class);
    }
     * Field for highlight builder
     * Set encoder for the highlighting
    /** default for the maximum number of phrases the fvh will consider */
                && Objects.equals(fragmentOffset, other.fragmentOffset)
        globalOptionsBuilder.merge(defaultOptions);
        this.fields.addAll(fields);
     */
     * @param fragmentOffset    The offset from the start of the fragment to the start of the highlight
        AbstractHighlighterBuilder highlighterBuilder,
        this.encoder = template.encoder;
import java.util.Set;
        WORD,
        QueryShardContext context
import org.apache.lucene.search.Query;
    public static final boolean DEFAULT_FORCE_SOURCE = false;
        return Objects.hash(encoder, useExplicitFieldOrder, fields);
public class HighlightBuilder extends AbstractHighlighterBuilder<HighlightBuilder> {
        @Override
    @Override
                builder.endObject();
                && Arrays.equals(matchedFields, other.matchedFields);
    public String encoder() {
    public HighlightBuilder rewrite(QueryRewriteContext ctx) throws IOException {
                break;
        "<em class=\"hlt8\">",
                    builder.startObject();
    public HighlightBuilder field(String name, int fragmentSize) {
    /** the default encoder setting */
        innerXContent(builder);
        SENTENCE;
        out.writeOptionalString(encoder);
            }
        if (highlighterBuilder.order != null) {
            if (field.matchedFields != null) {
    protected void doWriteTo(StreamOutput out) throws IOException {
        }
            }
import org.opensearch.index.query.Rewriteable;
        SearchHighlightContext.FieldOptions.Builder targetOptionsBuilder,
        @Override
        public Field fragmentOffset(int fragmentOffset) {
         * the named field.  If you provide a list of fields here then don't forget to include name as
 * @see org.opensearch.search.builder.SearchSourceBuilder#highlight()
