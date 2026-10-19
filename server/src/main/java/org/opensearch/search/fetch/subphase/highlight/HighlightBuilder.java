                builder.startArray(FIELDS_FIELD.getPreferredName());  
            parser.declareInt(Field::fragmentOffset, FRAGMENT_OFFSET_FIELD);  
        if (highlighterBuilder.maxAnalyzerOffset != null) {  
        .fragmentCharSize(DEFAULT_FRAGMENT_CHAR_SIZE)
        parser.declareNamedObjects(  
    private static final BiFunction<XContentParser, HighlightBuilder, HighlightBuilder> PARSER;
        protected boolean doEquals(Field other) {  
    /** default for fragment size when there are no matches */  
import java.util.function.BiFunction;
            if (highlightQuery != null) {
     */
                }  
        encoder(in.readOptionalString());  
                builder.endObject();
        public void innerXContent(XContentBuilder builder) throws IOException {
        AbstractHighlighterBuilder highlighterBuilder,
     */
 *
 */  
    }
import org.opensearch.core.xcontent.XContentBuilder;
        @Override
        }  
import org.opensearch.core.xcontent.ObjectParser.NamedObjectParser;  
        this.fields.addAll(fields);
        }  
        }  
        return this;
     * @opensearch.api  
            PARSER = (XContentParser p, Void c, String name) -> decoratedParser.apply(p, new Field(name));  
import java.util.Collection;  
        "<em class=\"hlt10\">" };
            ObjectParser<Field, Void> parser = new ObjectParser<>("highlight_field");
        // first write common options
        List<Field> fields = Rewriteable.rewrite(this.fields, ctx);  
        .phraseLimit(DEFAULT_PHRASE_LIMIT)
            if (order.toUpperCase(Locale.ROOT).equals(SCORE.name())) {
            } else {  
     * @param numberOfFragments The (maximum) number of fragments
        return new SearchHighlightContext(fieldOptions);
import org.opensearch.core.xcontent.ObjectParser;
    /** default for whether {@code fvh} should provide highlighting on filter clauses */
     * a provided (maximum) number of fragments.  
     * @param schemaName The tag scheme name
     *
    /** the default closing tag  */
    /**  
    private String encoder;
import java.util.HashSet;
                break;
     */
         * Set the matched fields to highlight against this field data.  Default to null, meaning just  
            targetOptionsBuilder.forceSource(highlighterBuilder.forceSource);
    public static final String[] DEFAULT_PRE_TAGS = new String[] { "<em>" };
        /**
     * @throws IOException on errors parsing any optional nested highlight query
    /** default for whether to highlight fields based on the source even if stored separately */  
     * @param encoder name
        }
        return field(new Field(name).fragmentSize(fragmentSize).numOfFragments(numberOfFragments).fragmentOffset(fragmentOffset));
    static final FieldOptions defaultOptions = new SearchHighlightContext.FieldOptions.Builder().preTags(DEFAULT_PRE_TAGS)
    /** the default opening tag  */  
        "<em class=\"hlt3\">",  
     * @param fragmentOffset    The offset from the start of the fragment to the start of the highlight
        .boundaryScannerLocale(Locale.ROOT)  
     * Gets value set with {@link #useExplicitFieldOrder(boolean)}
import org.opensearch.core.xcontent.XContentParser;
                QueryBuilder rewrite = highlightQuery.rewrite(ctx);  
 * are summarized to show only selected snippets ("fragments") containing search terms.
            }
        public Field matchedFields(String... matchedFields) {
        }
     *
     */
 * You may obtain a copy of the License at  
    }
        return this;  
        SCORE;
                new SearchHighlightContext.Field(field.name(), fieldOptionsBuilder.merge(globalOptionsBuilder.build()).build())
        // create template global options that are later merged with any partial field options
            && Objects.equals(fields, other.fields);  
        final SearchHighlightContext.FieldOptions.Builder globalOptionsBuilder = new SearchHighlightContext.FieldOptions.Builder();  
        "<em class=\"hlt5\">",
    }  
        }
            targetOptionsBuilder.boundaryScannerLocale(highlighterBuilder.boundaryScannerLocale);
     */  
                if (useExplicitFieldOrder) {  
        Collection<SearchHighlightContext.Field> fieldOptions = new ArrayList<>();
    }
        parser.declareString(HighlightBuilder::tagsSchema, new ParseField("tags_schema"));
    protected void doWriteTo(StreamOutput out) throws IOException {
    public enum BoundaryScannerType implements Writeable {
                    builder.endObject();
        if (highlighterBuilder.forceSource != null) {  
        if (highlighterBuilder.order != null) {  
            targetOptionsBuilder.postTags(highlighterBuilder.postTags);
        @Override
    /**  
    public enum Order implements Writeable {  
        if (highlightQuery != null) {  
            // write common options  
                    return new Field(this, rewrite);
    ) throws IOException {
    /** the default number of fragments size in characters */
     */  
        return this.fields;  
        "<em class=\"hlt1\">",
    public HighlightBuilder rewrite(QueryRewriteContext ctx) throws IOException {
     */
            out.writeEnum(this);
        .numberOfFragments(DEFAULT_NUMBER_OF_FRAGMENTS)
        // create field options
/*  
            targetOptionsBuilder.phraseLimit(highlighterBuilder.phraseLimit);
        PARSER = setupParser(parser);  
            matchedFields(in.readOptionalStringArray());  
    public static final String[] DEFAULT_STYLED_PRE_TAG = {  
    /** default for the maximum number of phrases the fvh will consider */
            name = template.name;  
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            transferOptions(field, fieldOptionsBuilder, context);
import org.opensearch.common.annotation.PublicApi;  
        public void writeTo(StreamOutput out) throws IOException {  
            } else {
            }  
        if (highlighterBuilder.numOfFragments != null) {  
 * @opensearch.api
        if (highlighterBuilder.requireFieldMatch != null) {  
        }
                Set<String> matchedFields = new HashSet<>(field.matchedFields.length);
        if (highlighterBuilder.highlightFilter != null) {  
     * Set encoder for the highlighting
    public SearchHighlightContext build(QueryShardContext context) throws IOException {
    }
        public static BoundaryScannerType fromString(String boundaryScannerType) {
        if (highlighterBuilder.fragmenter != null) {  
        }
                }
    public static final int DEFAULT_NO_MATCH_SIZE = 0;
            return this;
        .noMatchSize(DEFAULT_NO_MATCH_SIZE)
        }  
            }
import org.opensearch.index.query.Rewriteable;  
    @Override  
        String[] matchedFields;
            }
     * @return this for chaining  
 *    http://www.apache.org/licenses/LICENSE-2.0
            highlightQuery = this.highlightQuery.rewrite(ctx);
    }
        parser.declareString(HighlightBuilder::encoder, ENCODER_FIELD);
        }  
            if (useExplicitFieldOrder) {
            targetOptionsBuilder.fragmenter(highlighterBuilder.fragmenter);
        }
 * @see org.opensearch.search.builder.SearchSourceBuilder#highlight()  
                return Order.SCORE;  
        return this;
        .forceSource(DEFAULT_FORCE_SOURCE)  
import org.apache.lucene.search.vectorhighlight.SimpleBoundaryScanner;
            this.matchedFields = matchedFields;
            FIELDS_FIELD
     *  
            return name;  
    public static final String DEFAULT_ENCODER = "default";  
        @Override  
        return field(new Field(name).fragmentSize(fragmentSize));
    /**
import java.util.List;  
        }
    }
        }  
            builder.endObject();  
        for (Field field : this.fields) {  
    public static final String[] DEFAULT_POST_TAGS = new String[] { "</em>" };  
 * compatible open source license.
    }
            targetOptionsBuilder.numberOfFragments(highlighterBuilder.numOfFragments);
     * Set a tag scheme that encapsulates a built in pre and post tags. The allowed schemes
public class HighlightBuilder extends AbstractHighlighterBuilder<HighlightBuilder> {
    public HighlightBuilder useExplicitFieldOrder(boolean useExplicitFieldOrder) {
    public static final int DEFAULT_FRAGMENT_CHAR_SIZE = 100;
    public static final boolean DEFAULT_SCORE_ORDERED = false;
            return this;  
     */
            targetOptionsBuilder.highlightFilter(highlighterBuilder.highlightFilter);
    public String encoder() {  
            if (fragmentOffset != -1) {  
            fragmentOffset = template.fragmentOffset;
    /**
        useExplicitFieldOrder(in.readBoolean());
        transferOptions(this, globalOptionsBuilder, context);
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext.FieldOptions;
     * @param fragmentSize      The size of a fragment in characters  
    /**
     */  
        NONE,
 * KIND, either express or implied.  See the License for the
            case "default":
        return builder;
    }  
    protected int doHashCode() {
        }
     * @param context needed to convert {@link QueryBuilder} to {@link Query}  
    /**
        @Override
            targetOptionsBuilder.options(highlighterBuilder.options);
}
        if (highlightQuery == this.highlightQuery && fields == this.fields) {
        static final NamedObjectParser<Field, Void> PARSER;  
import java.util.Set;  
    }  
        fields.add(field);  
        }  
     * @param fragmentSize      The size of a fragment in characters  
        .highlightFilter(DEFAULT_HIGHLIGHT_FILTER)
        public Field rewrite(QueryRewriteContext ctx) throws IOException {
        }  
         */
        super(in);
     * are {@code html} and {@code default}.  
                postTags(DEFAULT_POST_TAGS);
    static {
        /**
     * @param name         The field to highlight  
        return Objects.hash(encoder, useExplicitFieldOrder, fields);
    public HighlightBuilder field(String name, int fragmentSize, int numberOfFragments, int fragmentOffset) {
        CHARS,  
        if (highlighterBuilder.boundaryMaxScan != null) {  
    private static void transferOptions(
        if (highlighterBuilder.options != null) {  
        }
        .encoder(DEFAULT_ENCODER)  
     * default number of fragments of 5 using the default encoder  
            fragmentOffset(in.readVInt());
    }  
    public HighlightBuilder tagsSchema(String schemaName) {  
        }
    }  
        return this;
/*  
    }
    public List<Field> fields() {
        "<em class=\"hlt8\">",
        return this.encoder;
    public HighlightBuilder(HighlightBuilder template, QueryBuilder highlightQuery, List<Field> fields) {  
        }
 * Unless required by applicable law or agreed to in writing,
        }  
    protected boolean doEquals(HighlightBuilder other) {  
        }
            targetOptionsBuilder.noMatchSize(highlighterBuilder.noMatchSize);
        }
            }  
 */  
    public HighlightBuilder field(String name, int fragmentSize) {  
            targetOptionsBuilder.scoreOrdered(highlighterBuilder.order == Order.SCORE);
     *
    }
        super(template, highlightQuery);
     */  
        .scoreOrdered(DEFAULT_SCORE_ORDERED)  
        fields = new ArrayList<>();  
     * a provided (maximum) number of fragments.  
        if (highlighterBuilder.postTags != null) {  
 * the Apache License, Version 2.0 (the "License"); you may
            builder.startObject(name);
            case "styled":  
     * Adds a field to be highlighted with default fragment size of 100 characters, and
    @PublicApi(since = "1.0.0")
import static org.opensearch.core.xcontent.ObjectParser.fromList;  
    public static final boolean DEFAULT_HIGHLIGHT_FILTER = false;
        if (highlighterBuilder.preTags != null) {  
        @Override  
            matchedFields = template.matchedFields;
            return valueOf(boundaryScannerType.toUpperCase(Locale.ROOT));
    /** the default closing tags when {@code tag_schema = "styled"}  */
    @Override
     * Adds a field to be highlighted with a provided fragment size (in characters), and
            }
                && Objects.equals(fragmentOffset, other.fragmentOffset)
            assert this.equals(new Field(this, highlightQuery)) : "copy constructor is broken";
            this.name = name;
    }
    }
    /**
        QueryShardContext context
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    }  
        Character[] charArray = new Character[array.length];
 * A builder for search highlighting. Settings can control how large fields  
        if (highlighterBuilder.fragmentSize != null) {  
        .requireFieldMatch(DEFAULT_REQUIRE_FIELD_MATCH)
            return in.readEnum(BoundaryScannerType.class);
 * this work for additional information regarding copyright
    }  
            return null;
                Collections.addAll(matchedFields, field.matchedFields);
 */  
            default:
     */  
    }
        public static Order fromString(String order) {
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < array.length; i++) {
                builder.endArray();
     * Read from a stream.
    /**  
        .postTags(DEFAULT_POST_TAGS)
            out.writeOptionalStringArray(matchedFields);
    public static HighlightBuilder fromXContent(XContentParser p) {  
        return field(new Field(name).fragmentSize(fragmentSize).numOfFragments(numberOfFragments));
        return charArray;
import org.opensearch.core.common.io.stream.StreamOutput;  
    public HighlightBuilder field(String name, int fragmentSize, int numberOfFragments) {  
            }
import org.apache.lucene.search.Query;
package org.opensearch.search.fetch.subphase.highlight;
        WORD,
            charArray[i] = array[i];  
     * Field for highlight builder  
                throw new IllegalArgumentException("Unknown tag schema [" + schemaName + "]");
     *
        }  
            return Objects.equals(name, other.name)
        return new HighlightBuilder(this, highlightQuery, fields);
                field.innerXContent(builder);
    /**
        }
    public HighlightBuilder field(Field field) {
            super(template, builder);
        public static BoundaryScannerType readFromStream(StreamInput in) throws IOException {
        }  
        if (encoder != null) {
        }
     *
     * Getter for {@link #encoder(String)}
        return Objects.equals(encoder, other.encoder)
 * software distributed under the License is distributed on an
    @PublicApi(since = "1.0.0")
        if (highlighterBuilder.highlighterType != null) {  
    public static final boolean DEFAULT_REQUIRE_FIELD_MATCH = true;  
    }
import java.util.ArrayList;
            super(in);  
        private Field(Field template, QueryBuilder builder) {
        public Field(String name) {  
import org.opensearch.index.query.QueryBuilder;  
 * not use this file except in compliance with the License.
        if (highlighterBuilder.boundaryScannerType != null) {  
     * @param name              The field to highlight
        if (highlighterBuilder.boundaryChars != null) {  
    /** the default number of fragments for highlighting */
     * @param fragmentSize The size of a fragment in characters
            BiFunction<XContentParser, Field, Field> decoratedParser = setupParser(parser);
    /**
 * Licensed to Elasticsearch under one or more contributor  
        }
        }
        return field(new Field(name));
        commonOptionsToXContent(builder);
    /** the default encoder setting */
            return NONE;
                && Arrays.equals(matchedFields, other.matchedFields);  
        out.writeList(fields);
        public String toString() {  
        }
        }  
import java.util.Locale;
        public Field fragmentOffset(int fragmentOffset) {  
        int fragmentOffset = -1;
        private final String name;  
        // special options for top-level highlighter  
        if (fields.size() > 0) {
        );
     * @opensearch.api
import java.util.Collections;
     * Boundary scanner type  
     *
 * GitHub history for details.
            targetOptionsBuilder.fragmentCharSize(highlighterBuilder.fragmentSize);
            builder.field(ENCODER_FIELD.getPreferredName(), encoder);
            targetOptionsBuilder.highlighterType(highlighterBuilder.highlighterType);
    }  
                builder.array(MATCHED_FIELDS_FIELD.getPreferredName(), matchedFields);
                builder.field(FRAGMENT_OFFSET_FIELD.getPreferredName(), fragmentOffset);
        .boundaryChars(DEFAULT_BOUNDARY_CHARS)
     * default number of fragments of 5.
        .build();  
        assert this.equals(new HighlightBuilder(this, highlightQuery, fields)) : "copy constructor is broken";  
import java.util.Arrays;
        }
 *
        SearchHighlightContext.FieldOptions.Builder targetOptionsBuilder,  
        .boundaryMaxScan(SimpleBoundaryScanner.DEFAULT_MAX_SCAN)
            targetOptionsBuilder.boundaryScannerType(highlighterBuilder.boundaryScannerType);
        }
            return name().toLowerCase(Locale.ROOT);
        switch (schemaName) {
        "<em class=\"hlt4\">",
        }
            return this;
     * @param name              The field to highlight
        ObjectParser<HighlightBuilder, Void> parser = new ObjectParser<>("highlight");  
    }
            }
    public Boolean useExplicitFieldOrder() {
                preTags(DEFAULT_STYLED_PRE_TAG);
    public HighlightBuilder field(String name) {
                fieldOptionsBuilder.matchedFields(matchedFields);  
    @Override  
        }
import org.opensearch.core.ParseField;
            final SearchHighlightContext.FieldOptions.Builder fieldOptionsBuilder = new SearchHighlightContext.FieldOptions.Builder();
     * a {@link FieldOptions} with default settings
 * specific language governing permissions and limitations
     *
import org.opensearch.index.query.QueryShardContext;
        innerXContent(builder);
        static {
        "<em class=\"hlt7\">",
        }
        }  
     * Transfers field options present in the input {@link AbstractHighlighterBuilder} to the receiving
            targetOptionsBuilder.maxAnalyzerOffset(highlighterBuilder.maxAnalyzerOffset);
                }
            out.writeString(name);  
        public void writeTo(StreamOutput out) throws IOException {  
            name = in.readString();
    private final List<Field> fields;
        // overwrite unset global options by default values
                if (useExplicitFieldOrder) {
import org.opensearch.core.common.io.stream.StreamInput;
            targetOptionsBuilder.boundaryMaxScan(highlighterBuilder.boundaryMaxScan);
        if (array == null) {
            targetOptionsBuilder.boundaryChars(convertCharArray(highlighterBuilder.boundaryChars));
import org.opensearch.core.common.io.stream.Writeable;
            if (useExplicitFieldOrder) {
@PublicApi(since = "1.0.0")
            HighlightBuilder::fields,
     */  
        out.writeOptionalString(encoder);
         * Read from a stream.  
        @Override  
            );
            commonOptionsToXContent(builder);
            parser.declareStringArray(fromList(String.class, Field::matchedFields), MATCHED_FIELDS_FIELD);
/*
            return Objects.hash(name, fragmentOffset, Arrays.hashCode(matchedFields));
            out.writeVInt(fragmentOffset);
        @Override
        this.useExplicitFieldOrder = useExplicitFieldOrder;  
        public static Order readFromStream(StreamInput in) throws IOException {
            && Objects.equals(useExplicitFieldOrder, other.useExplicitFieldOrder)
         */  
        }  
     *
 * license agreements. See the NOTICE file distributed with
        if (highlighterBuilder.boundaryScannerLocale != null) {  
     */  
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })  
        }
        this.fields = in.readList(Field::new);
        out.writeBoolean(useExplicitFieldOrder);  
        }
            // write special field-highlighter options
     * @param highlighterBuilder highlight builder with the input options
    }
     * are {@code styled} and {@code default}.
            targetOptionsBuilder.highlightQuery(highlighterBuilder.highlightQuery.toQuery(context));
 * Modifications Copyright OpenSearch Contributors. See
     * Adds a field to be highlighted with a provided fragment size (in characters), and
                break;  
        }
 *
    @Override  
                if (rewrite != highlightQuery) {
 * under the License.  
    }
                builder.startObject(FIELDS_FIELD.getPreferredName());
     * Adds a field to be highlighted with a provided fragment size (in characters), and  
            (HighlightBuilder hb) -> hb.useExplicitFieldOrder(true),  
     * @opensearch.api
        globalOptionsBuilder.encoder(this.encoder);
            return in.readEnum(Order.class);
            for (Field field : fields) {
    public HighlightBuilder() {
    private boolean useExplicitFieldOrder = false;  
    static Character[] convertCharArray(char[] array) {  
        if (highlighterBuilder.highlightQuery != null) {  
            this.fragmentOffset = fragmentOffset;
         * it is not automatically included.
                    builder.startObject();  
 * The OpenSearch Contributors require contributions made to  
        public Field(StreamInput in) throws IOException {
    @Override
        this.encoder = encoder;
                postTags(DEFAULT_STYLED_POST_TAGS);
    @Override
     * Order for highlight builder
    public static final String[] DEFAULT_STYLED_POST_TAGS = { "</em>" };  
            targetOptionsBuilder.requireFieldMatch(highlighterBuilder.requireFieldMatch);
            fieldOptions.add(  
    public static final int DEFAULT_PHRASE_LIMIT = 256;
import org.opensearch.index.query.QueryRewriteContext;
    void fields(List<Field> fields) {
     * @param name The field to highlight
     */  
    /** default for highlight fragments being ordered by score */  
            return name().toLowerCase(Locale.ROOT);
            out.writeEnum(this);
        "<em class=\"hlt2\">",
        @Override
 */
         * the named field.  If you provide a list of fields here then don't forget to include name as
    @PublicApi(since = "1.0.0")
     * Send the fields to be highlighted using a syntax that is specific about the order in which they should be highlighted.
            if (field.matchedFields != null) {  
        }
    /**
    }  
     * {@link FieldOptions.Builder}, effectively overwriting existing settings  
        protected void doWriteTo(StreamOutput out) throws IOException {
    public static final int DEFAULT_NUMBER_OF_FRAGMENTS = 5;  
     */
        QueryBuilder highlightQuery = this.highlightQuery;
    /**
        }
        globalOptionsBuilder.merge(defaultOptions);
        }
import java.util.Objects;
        }  
        public String toString() {  
    /** default for whether a field should be highlighted only if a query matches that field */
    public static class Field extends AbstractHighlighterBuilder<Field> {
        }
    }
            fieldOptionsBuilder.fragmentOffset(field.fragmentOffset);
    static final Character[] DEFAULT_BOUNDARY_CHARS = HighlightBuilder.convertCharArray(SimpleBoundaryScanner.DEFAULT_BOUNDARY_CHARS);
        this.fields = fields;
        this.encoder = template.encoder;
 * SPDX-License-Identifier: Apache-2.0
            Field.PARSER,
import java.io.IOException;  
            return this;
    /**
    public static final boolean DEFAULT_FORCE_SOURCE = false;
        @Override
        builder.startObject();
        "<em class=\"hlt6\">",  
 * this file be licensed under the Apache-2.0 license or a
    /**
        return this.useExplicitFieldOrder;
    /**
     * @param targetOptionsBuilder the receiving options builder
/**
        }
        "<em class=\"hlt9\">",  
    public HighlightBuilder(StreamInput in) throws IOException {
        public String name() {
    }
    /** the default opening tags when {@code tag_schema = "styled"}  */
        return PARSER.apply(p, new HighlightBuilder());
        SENTENCE;
        protected int doHashCode() {
        if (highlighterBuilder.phraseLimit != null) {  
        if (highlighterBuilder.noMatchSize != null) {  
     * @param numberOfFragments The (maximum) number of fragments
 *
                preTags(DEFAULT_PRE_TAGS);  
 *  
    public HighlightBuilder encoder(String encoder) {
            if (matchedFields != null) {  
            targetOptionsBuilder.preTags(highlighterBuilder.preTags);
        builder.endObject();  
        this.useExplicitFieldOrder = template.useExplicitFieldOrder;  
    public void innerXContent(XContentBuilder builder) throws IOException {  
