                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        if (stopWords != null) {
        MappedFieldType idField = context.fieldMapper(IdFieldMapper.NAME);
        }
    public MoreLikeThisQueryBuilder minWordLength(int minWordLength) {
        }
import java.util.Map;
            builder.endArray();
            this.fields = fields;
        // sets boost terms
    public String[] stopWords() {
                } else if (FAIL_ON_UNSUPPORTED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
            this.index = index;
    // document inputs
    private static final ParseField ANALYZER = new ParseField("analyzer");
        if (parser.currentToken().isValue()) {
            && Arrays.equals(unlikeItems, other.unlikeItems)
import java.util.ArrayList;
 * compatible open source license.
        String analyzer = null;
    public String getWriteableName() {
     * unbounded ({@code 0}).
import org.opensearch.core.common.ParsingException;
    /**
        builder.field(INCLUDE.getPreferredName(), include);
        int maxQueryTerms = MoreLikeThisQueryBuilder.DEFAULT_MAX_QUERY_TERMS;
        return minTermFreq;
        buildLikeField(builder, LIKE.getPreferredName(), likeTexts, likeItems);
            }
        }
        Item[] unlikeItems = new Item[this.unlikeItems.length];
            .boost(boost)
 * Unless required by applicable law or agreed to in writing,
            if (response.isFailed()) {
        super(in);
        // set similarity
        return include;
        return analyzer;
        Item[] unlikeItemsArray = unlikeItems.isEmpty() ? null : unlikeItems.toArray(new Item[0]);
            minTermFreq,
    @Override
        Arrays.asList(TextFieldType.class, KeywordFieldType.class)
    public static final String DEFAULT_MINIMUM_SHOULD_MATCH = MoreLikeThisQuery.DEFAULT_MINIMUM_SHOULD_MATCH;
        MediaType mediaType() {
    public int maxDocFreq() {
        public String routing() {
    public static final ParseField DOC = new ParseField("doc");
        builder.field(MAX_DOC_FREQ.getPreferredName(), maxDocFreq);
            return this;
        }
        minDocFreq = in.readVInt();
import org.opensearch.core.common.Strings;
     * in more than this many docs will be ignored. Defaults to unbounded.
        public Item version(long version) {
                if (fieldType != null && SUPPORTED_FIELD_TYPES.contains(fieldType.getClass()) == false) {
     * Set the set of stopwords.
        boolean useDefaultField = (fields == null);
         * @param id and its id
            version = in.readLong();
        private VersionType versionType = VersionType.INTERNAL;
 */
        List<String> moreLikeFields = new ArrayList<>();
    }
            return versionType;
import org.opensearch.index.mapper.MappedFieldType;
            if (token == XContentParser.Token.FIELD_NAME) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private Query handleItems(
            Arrays.hashCode(likeTexts),
        return Objects.hash(
    }
            }
package org.opensearch.index.query;
            }
            return;
        return NAME;
    }
        @Override
                        item.versionType = VersionType.fromString(parser.text());
                return "{ \"error\" : \"" + ExceptionsHelper.detailedMessage(e) + "\"}";
        return this;
            throw new IllegalArgumentException(NAME + " query requires 'fields' to be specified");
    }
        if (item.index() == null) {
    }
        List<String> fields = null;
                throw new OpenSearchParseException(
        }
        }
     */
import org.opensearch.core.xcontent.ToXContentObject;
        for (Item item : likeItems) {
    }
    /**
        }
        boostTerms = (Float) in.readGenericValue();
        public String[] fields() {
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
            if (in.getVersion().before(Version.V_2_0_0)) {
        }
            out.writeOptionalStringArray(fields);
                builder.value(text);
        } else if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
            minWordLength,
        this.minimumShouldMatch = minimumShouldMatch;
                } else {
        return this;
        // getting the Fields for liked items
            return fields;
                id = in.readString();
            builder.array(STOP_WORDS.getPreferredName(), stopWords);
    private static final ParseField VERSION_TYPE = new ParseField("version_type");
     * <p>
        public String index() {
    private static final ParseField INDEX = new ParseField("_index");
                // types no longer supported so ignore
    private float boostTerms = DEFAULT_BOOST_TERMS;
     * Sets the frequency at which words will be ignored which do not occur in at least this
    private static Fields[] getFieldsFor(MultiTermVectorsResponse responses) throws IOException {
        this.likeItems = Optional.ofNullable(likeItems).orElse(new Item[0]);
        }
        }
            this.index = index;
        if (maxQueryTerms <= 0) {
            boostTerms,
    private static final ParseField MINIMUM_SHOULD_MATCH = new ParseField("minimum_should_match");
                } else {
/*
        out.writeString(minimumShouldMatch);
            if (this.perFieldAnalyzer != null) {
 * Licensed to Elasticsearch under one or more contributor
        include = in.readBoolean();
     * @param likeItems the documents to use when generating the 'More Like This' query.
            }
                }
        boolean failOnUnsupportedField = MoreLikeThisQueryBuilder.DEFAULT_FAIL_ON_UNSUPPORTED_FIELDS;
                        stopWords.add(parser.text());
        if (!include) {
                    minDocFreq = parser.intValue();
        // getting the Fields for unliked items
            .failOnUnsupportedField(failOnUnsupportedField)
        /**
            throw new IllegalArgumentException("[" + NAME + "] requires minimum should match to be non-null");
            Query query = idField.termsQuery(ids, context);
            throw new ParsingException(parser.getTokenLocation(), "more_like_this requires 'like' to be specified");
            if (this.versionType != VersionType.INTERNAL) {
    public int minDocFreq() {
            }
        builder.field(FAIL_ON_UNSUPPORTED_FIELD.getPreferredName(), failOnUnsupportedField);
         * Sets the analyzer(s) to use at any given field.
    }
                builder.field(INDEX.getPreferredName(), this.index);
        }
            out.writeGenericValue(perFieldAnalyzer);
import org.opensearch.core.common.io.stream.Writeable;
    private static final ParseField ROUTING = new ParseField("routing");
     */
        }
            }
            throw new IllegalArgumentException("requires stopwords to be non-null");
        if (minimumShouldMatch == null) {
    private boolean include = DEFAULT_INCLUDE;
        out.writeVInt(minTermFreq);
        List<String> ids = new ArrayList<>();
                        + "set the [fields] option in the query."
    private int maxDocFreq = DEFAULT_MAX_DOC_FREQ;
        int maxDocFreq = MoreLikeThisQueryBuilder.DEFAULT_MAX_DOC_FREQ;
        this.analyzer = analyzer;
            // for artificial docs to make sure that the id has changed in the item too
        Throwable cause = ExceptionsHelper.unwrap(response.getFailure().getCause(), RoutingMissingException.class);
 *
            if (id == null) {
            if (item.id == null && item.doc == null) {
            minimumShouldMatch,
                } else if (ANALYZER.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if ("_name".equals(currentFieldName)) {
            items.add(Item.parse(parser, new Item()));
        }
            this.routing = routing;
        }
        /**
            if (doc == null) {
     */
            && Arrays.equals(unlikeTexts, other.unlikeTexts)
                builder.prettyPrint();
     */
    private static final ParseField FIELDS = new ParseField("fields");
        }
                    } else if (ID.match(currentFieldName, parser.getDeprecationHandler())) {
    public MoreLikeThisQueryBuilder include(boolean include) {
        if (likeItems.length > 0) {
    }
    @Override
            if (this.fields != null) {
    public MoreLikeThisQueryBuilder minTermFreq(int minTermFreq) {
        return moreLikeThisQueryBuilder;
        private long version = Versions.MATCH_ANY;
            }
        return minWordLength;
         */
import org.opensearch.ExceptionsHelper;
        maxWordLength = in.readVInt();
        public String id() {
            throw new ParsingException(parser.getTokenLocation(), "more_like_this requires 'fields' to be non-empty");
        private String[] fields;
                    minWordLength = parser.intValue();
            }
        return this.fields;
         *
                throw new IllegalArgumentException("Item requires id to be non-null");
            if (moreLikeFields.size() == 1 && moreLikeFields.get(0).equals("*") && (likeTexts.length > 0 || unlikeTexts.length > 0)) {
import org.opensearch.action.termvectors.TermVectorsResponse;
                if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
                    failOnUnsupportedField = parser.booleanValue();
        this.maxDocFreq = maxDocFreq;
            .include(include)
    /**
                    }
            .minTermFreq(minTermFreq)
            likeFields.add(getResponse.getFields());
        private BytesReference doc;
        builder.endObject();
            }
        if (boostTerms != 0) {
    }
            if (this.index != null) {
                if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
        List<String> unlikeTexts = new ArrayList<>();
                    }
    public MoreLikeThisQueryBuilder(StreamInput in) throws IOException {
import org.opensearch.action.RoutingMissingException;
        this.likeTexts = Optional.ofNullable(likeTexts).orElse(Strings.EMPTY_ARRAY);
            .maxWordLength(maxWordLength)
     */
     * Sets the minimum word length below which words will be ignored. Defaults
        analyzer = in.readOptionalString();
    public String[] unlikeTexts() {
        Item[] likeItems,
import org.opensearch.OpenSearchParseException;
            this.id = id;
            boolQuery.add(query, BooleanClause.Occur.MUST_NOT);
            && Objects.equals(boostTerms, other.boostTerms)
        return this;
     */
        mltQuery.setMinDocFreq(minDocFreq);
        return stopWords;
            return null;
                builder.value(item);
            minDocFreq,
            ids.add(item.id());
     * Sets the boost factor to use when boosting terms. Defaults to {@code 0} (deactivated).
 */
        MultiTermVectorsResponse likeItemsResponse = fetchResponse(context.getClient(), likeItems);
            } else {
        // set analyzer
 * SPDX-License-Identifier: Apache-2.0
        public Item perFieldAnalyzer(Map<String, String> perFieldAnalyzer) {
        public Map<String, String> perFieldAnalyzer() {
    /**
    }
            .minWordLength(minWordLength)
     */
        return likeTexts;
     *
    public static final float DEFAULT_BOOST_TERMS = 0;  // no boost terms
        minTermFreq = in.readVInt();
            return builder.endObject();
                );
            Arrays.hashCode(stopWords),
            return mediaType;
 * You may obtain a copy of the License at
                }
        this.unlikeTexts = Optional.ofNullable(unlikeTexts).orElse(Strings.EMPTY_ARRAY);
        public static Item parse(XContentParser parser, Item item) throws IOException {
}
                );
        }
            request.add(item.toTermVectorsRequest());
                    fields = new ArrayList<>();
    }
        Item[] likeItemsArray = likeItems.isEmpty() ? null : likeItems.toArray(new Item[0]);
                builder.field(ROUTING.getPreferredName(), this.routing);
        }
            if (this.version != Versions.MATCH_ANY) {
         * @param index the index where the document is located
         *
        stopWords = in.readOptionalStringArray();
            this.version = copy.version;
    public static final int DEFAULT_MAX_DOC_FREQ = XMoreLikeThis.DEFAULT_MAX_DOC_FREQ;
    private int maxQueryTerms = DEFAULT_MAX_QUERY_TERMS;
    }
    }
        return boolQuery.build();
            }
    private static void checkRoutingMissingException(MultiTermVectorsItemResponse response) {
        }
    }
            }
        mltQuery.setLikeFields(getFieldsFor(likeItemsResponse));
        MultiTermVectorsRequest request = new MultiTermVectorsRequest();
                .positions(false)  // ensures these following parameters are never set
        }
        return client.multiTermVectors(request).actionGet();
        if (stopWords == null) {
            XContentParser.Token token;
        if (unlikeItems.length > 0) {
    }
                    boostTerms = parser.floatValue();
            item.index(context.index().getName());
    public MoreLikeThisQueryBuilder(String[] likeTexts, Item[] likeItems) {
        for (int i = 0; i < likeItems.length; i++) {
    }
     * A single item to be used for a {@link MoreLikeThisQueryBuilder}.
    public int maxQueryTerms() {
            routing = in.readOptionalString();
        if ((item.fields() == null || item.fields().length == 0) && item.doc() == null) {
                        item.perFieldAnalyzer(TermVectorsRequest.readPerFieldAnalyzer(parser.map()));
            return routing;
            index = in.readOptionalString();
                } else {
import java.util.Locale;
                    }
        this.minTermFreq = minTermFreq;
        this.stopWords = stopWords.toArray(new String[0]);
        }
        Item(Item copy) {
    }
        out.writeList(Arrays.asList(likeItems));
        return minimumShouldMatch;
    }
        /**
            if (this.routing != null) {
                builder.field(VERSION.getPreferredName(), this.version);
 * under the License.
            return Objects.hash(index, id, doc, Arrays.hashCode(fields), perFieldAnalyzer, routing, version, versionType);
 *
        // set query parameters
    }
                        throw new OpenSearchParseException("failed to parse More Like This item. unknown field [{}]", currentFieldName);
import java.util.List;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        }
        MoreLikeThisQuery mltQuery = new MoreLikeThisQuery();
        public boolean equals(Object o) {
                }
        public void writeTo(StreamOutput out) throws IOException {
        failOnUnsupportedField = in.readBoolean();
            this.mediaType = copy.mediaType;
        Item[] likeItems = new Item[this.likeItems.length];
        }
 * not use this file except in compliance with the License.
                        + "you should update the [index.query.default_field] index setting to a field that exists in the mapping or "
    private int maxWordLength = DEFAULT_MAX_WORD_LENGTH;
        likeTexts = in.readStringArray();
        for (int i = 0; i < unlikeItems.length; i++) {
                out.writeOptionalString(null);
import org.opensearch.action.termvectors.MultiTermVectorsRequest;
        if (analyzer != null) {
            }
        // document inputs
                in.readOptionalString();
            }
        builder.field(MIN_DOC_FREQ.getPreferredName(), minDocFreq);
                            throw new OpenSearchParseException("failed to parse More Like This item. field [fields] must be an array");
        }
            return item;
     * @param likeItems the documents to use when generating the 'More Like This' query.
    // query formation parameters
        boolean useDefaultField
    public boolean include() {
                currentFieldName = parser.currentName();
        float boostTerms = MoreLikeThisQueryBuilder.DEFAULT_BOOST_TERMS;
 * <p>
    protected Query doToQuery(QueryShardContext context) throws IOException {
     */
        builder.field(MINIMUM_SHOULD_MATCH.getPreferredName(), minimumShouldMatch);
            }
        return this;
                if (LIKE.match(currentFieldName, parser.getDeprecationHandler())) {
            MultiTermVectorsResponse unlikeItemsResponse = fetchResponse(context.getClient(), unlikeItems);
            this.index = index;
                .routing(routing)
     */
                    } else if (ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {
         * Constructor for an artificial document request, that is not present in the index.
    @Override
        }
                        item.version = parser.longValue();
    public Item[] unlikeItems() {
            this.doc = BytesReference.bytes(doc);
    private static final ParseField UNLIKE = new ParseField("unlike");
     * The analyzer that will be used to analyze the text. Defaults to the analyzer associated with the field.
        }
    protected int doHashCode() {
        unlikeTexts = in.readStringArray();
        if (likeTexts.isEmpty() && likeItems.isEmpty()) {
     * reasonable to assume that "a stop word is never interesting".
    private static void parseLikeField(XContentParser parser, List<String> texts, List<Item> items) throws IOException {
        return failOnUnsupportedField;
        private Map<String, String> perFieldAnalyzer;
                    } else if (FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
        Item(StreamInput in) throws IOException {
        Item item,
            builder.startArray(fieldName);
    /**
                    mediaType = in.readEnum(XContentType.class);
        @Override
    private static final ParseField MIN_TERM_FREQ = new ParseField("min_term_freq");
    private String analyzer;
                    parseLikeField(parser, unlikeTexts, unlikeItems);
                    parseLikeField(parser, unlikeTexts, unlikeItems);
    private int minDocFreq = DEFAULT_MIN_DOC_FREQ;
                    maxDocFreq = parser.intValue();
     * @param likeTexts the text to use when generating the 'More Like This' query.
import org.opensearch.action.termvectors.MultiTermVectorsResponse;
                .version(version)
    /**
    /**
            && Objects.equals(analyzer, other.analyzer)
        }
            org.apache.lucene.index.Fields[] unlikeFields = getFieldsFor(unlikeItemsResponse);
            if (!getResponse.isExists()) {
            likeItems[i] = new Item(this.likeItems[i]);
        this(null, likeTexts, likeItems);
        public Item routing(String routing) {
            if (this.id != null) {
            }
    /**
                try (InputStream stream = this.doc.streamInput()) {
    }
    }
        return this;
        return this;
            mltQuery.setUnlikeText(unlikeTexts);
    public MoreLikeThisQueryBuilder stopWords(String... stopWords) {
import java.util.HashSet;
        TermVectorsRequest toTermVectorsRequest() {
    }
        }
            && Arrays.equals(likeTexts, other.likeTexts)
            } else {
     * Whether to include the input documents. Defaults to {@code false}
    ) {
            throw new IllegalArgumentException("requires 'maxQueryTerms' to be greater than 0");
        this.unlikeItems = Optional.ofNullable(unlikeItems).orElse(new Item[0]);
            .analyzer(analyzer)
            && Objects.equals(maxWordLength, other.maxWordLength)
     * frequency is {@code 2}.
                    minimumShouldMatch = parser.text();
        minWordLength = in.readVInt();
                    if (INDEX.match(currentFieldName, parser.getDeprecationHandler())) {
        }
        }
                        continue;
            return index;
        minimumShouldMatch = in.readString();
        @Override
            versionType = VersionType.readFromStream(in);
        this.stopWords = stopWords;
            }
                && Objects.equals(id, other.id)
    public int minTermFreq() {
            }
import org.opensearch.index.mapper.KeywordFieldMapper.KeywordFieldType;
                    throw new ParsingException(parser.getTokenLocation(), "[mlt] query does not support [" + currentFieldName + "]");
    }
    /**
            if (item.doc() != null) {
            builder.array(FIELDS.getPreferredName(), fields);
    private static final ParseField INCLUDE = new ParseField("include");
            if (item.id != null && item.doc != null) {
            && Objects.equals(minWordLength, other.minWordLength)
            if (this.doc != null) {
                } else if (currentFieldName != null) {
        if (analyzerObj == null) {
        if (useDefaultField) {
    public MoreLikeThisQueryBuilder minDocFreq(int minDocFreq) {
        }
        return maxQueryTerms;
    // term selection parameters
            return termVectorsRequest;
    private MultiTermVectorsResponse fetchResponse(Client client, Item[] items) throws IOException {
     */
    public MoreLikeThisQueryBuilder failOnUnsupportedField(boolean fail) {
    }
            return perFieldAnalyzer;
        public Item versionType(VersionType versionType) {
        String[] fieldsArray = fields == null ? null : fields.toArray(new String[0]);
    public static final boolean DEFAULT_INCLUDE = false;
     * might want to tell the MoreLikeThis code to ignore them, as for the purposes of document similarity it seems
    private static final ParseField PER_FIELD_ANALYZER = new ParseField("per_field_analyzer");
     *
            fields = in.readOptionalStringArray();
    public float boostTerms() {
        int minDocFreq = MoreLikeThisQueryBuilder.DEFAULT_MIN_DOC_FREQ;
     */
            mltQuery.setStopWords(new HashSet<>(Arrays.asList(stopWords)));
    }
            if (in.readBoolean()) {
        out.writeOptionalStringArray(stopWords);
import org.opensearch.action.termvectors.MultiTermVectorsItemResponse;
            if (!(o instanceof Item)) return false;
        mltQuery.setMaxDocFreq(maxDocFreq);
        List<Item> likeItems = new ArrayList<>();
import org.apache.lucene.analysis.Analyzer;
        public Item() {}
            texts.add(parser.text());
        maxQueryTerms = in.readVInt();
            builder.field(ANALYZER.getPreferredName(), analyzer);
                }
        builder.field(BOOST_TERMS.getPreferredName(), boostTerms);
     * The frequency below which terms will be ignored in the source doc. The default
            if (useDefaultField) {
                    } else if (DOC.match(currentFieldName, parser.getDeprecationHandler())) {
    @Override
            handleExclude(boolQuery, likeItems, context);
            out.writeOptionalString(routing);
                    throw new ParsingException(parser.getTokenLocation(), "[mlt] query does not support [" + currentFieldName + "]");
                } else if (STOP_WORDS.match(currentFieldName, parser.getDeprecationHandler())) {
 * the Apache License, Version 2.0 (the "License"); you may
            mltQuery.setBoostTermsFactor(boostTerms);
     */
import org.opensearch.core.common.io.stream.StreamOutput;
            .queryName(queryName);
        }
        builder.startObject(NAME);
        int minWordLength = MoreLikeThisQueryBuilder.DEFAULT_MIN_WORD_LENGTH;
        int minTermFreq = MoreLikeThisQueryBuilder.DEFAULT_MIN_TERM_FREQ;
        boolean include = MoreLikeThisQueryBuilder.DEFAULT_INCLUDE;
        private String index;
            Arrays.hashCode(fields),
        // artificial docs get assigned a random id and should be disregarded
            maxDocFreq,
    private static final ParseField MAX_DOC_FREQ = new ParseField("max_doc_freq");
                } else if (BOOST_TERMS.match(currentFieldName, parser.getDeprecationHandler())) {
                // types not supported so send an empty array to previous versions
            && Objects.equals(maxDocFreq, other.maxDocFreq)
            }
        private String routing;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
            .maxDocFreq(maxDocFreq)
        if (stopWords != null) {
        }
            perFieldAnalyzer = (Map<String, String>) in.readGenericValue();
         * Convert this to a {@link TermVectorsRequest} for fetching the terms of the document.
                        } else {
    private static final ParseField MAX_WORD_LENGTH = new ParseField("max_word_length");
                    }
        List<String> likeTexts = new ArrayList<>();
                    mediaType = in.readMediaType();
        return this;
        this.failOnUnsupportedField = fail;
                        item.doc = BytesReference.bytes(jsonBuilder().copyCurrentStructure(parser));
        }
            }
    }
            TermVectorsResponse getResponse = response.getResponse();
            this.id = copy.id;
                && Objects.equals(routing, other.routing)
    }
    private String[] unlikeTexts = Strings.EMPTY_ARRAY;
    @Override
    public static MoreLikeThisQueryBuilder fromXContent(XContentParser parser) throws IOException {
        // TODO this needs heavy cleanups before we can rewrite it
            .unlike(unlikeItemsArray)
        return this;
                    maxWordLength = parser.intValue();
            mltQuery.setBoostTerms(true);
                    include = parser.booleanValue();
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
                                fields.add(parser.text());
    }
    private int minTermFreq = DEFAULT_MIN_TERM_FREQ;
        this.maxWordLength = maxWordLength;
    public static final int DEFAULT_MIN_DOC_FREQ = XMoreLikeThis.DEFAULT_MIN_DOC_FREQ;
    public static final int DEFAULT_MAX_QUERY_TERMS = XMoreLikeThis.DEFAULT_MAX_QUERY_TERMS;
                builder.field(ID.getPreferredName(), this.id);
        private MediaType mediaType;
 * license agreements. See the NOTICE file distributed with
            versionType.writeTo(out);
         * Constructor for a given item / document request
            this.routing = copy.routing;
                } else if (MIN_TERM_FREQ.match(currentFieldName, parser.getDeprecationHandler())) {
        return unlikeItems;
        }
        public long version() {
    public boolean failOnUnsupportedField() {
            Arrays.hashCode(unlikeTexts),
    private final String[] fields;
    public static final int DEFAULT_MIN_TERM_FREQ = XMoreLikeThis.DEFAULT_MIN_TERM_FREQ;
     * Sets the maximum word length above which words will be ignored. Defaults to
                item.fields("*");
        mltQuery.setMinimumShouldMatch(minimumShouldMatch);
     * @opensearch.internal
            }
        this.boostTerms = boostTerms;
         */
                    }
         * @param doc the document specification
    public String minimumShouldMatch() {
    }
 * @opensearch.internal
     * to {@code 0}.
        return this;
        int maxWordLength = MoreLikeThisQueryBuilder.DEFAULT_MAX_WORD_LENGTH;
            for (String field : fields) {
     */
 * A more like this query that finds documents that are "like" the provided set of document(s).
        boolean include,
        }
     */
        mltQuery.setAnalyzer(analyzerObj);
    @Override
            this.doc = copy.doc;
        XContentParser.Token token;
        for (Item item : unlikeItems) {
            }
        public BytesReference doc() {
        }
     * Whether to fail or return no result when this query is run against a field which is not supported such as binary/numeric fields.
        }
    public MoreLikeThisQueryBuilder(@Nullable String[] fields, @Nullable String[] likeTexts, @Nullable Item[] likeItems) {
     * Read from a stream.
            // no mappings, nothing to exclude
        boolQuery.add(mltQuery, BooleanClause.Occur.SHOULD);
     * Sets the documents from which the terms should not be selected from.
            throw new IllegalArgumentException(NAME + " query requires either 'like' texts or items to be specified.");
            if (doc != null) {
                if (FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
            moreLikeThisQueryBuilder.stopWords(stopWords);
                } else if (UNLIKE.match(currentFieldName, parser.getDeprecationHandler())) {
        for (Item item : likeItems) {
            failOnUnsupportedField
    }
                    analyzer = parser.text();
        public String toString() {
        out.writeBoolean(include);
        }
import org.opensearch.core.xcontent.XContentParser;
    }
        // other parameters
            && Objects.equals(maxQueryTerms, other.maxQueryTerms)
                XContentBuilder builder = XContentFactory.jsonBuilder();
            && Objects.equals(include, other.include)
    }
         * Parses and returns the given item.
        }
     * common syntax for minimum should match. Defaults to {@code 30%}.
        return likeFields.toArray(new Fields[0]);
        out.writeVInt(minWordLength);
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                } else if (MAX_DOC_FREQ.match(currentFieldName, parser.getDeprecationHandler())) {
                MappedFieldType fieldType = context.fieldMapper(field);
            }
        @Override
     * @see    org.opensearch.common.lucene.search.Queries#calculateMinShouldMatch(int, String)
import org.opensearch.common.lucene.search.MoreLikeThisQuery;
     */
    protected boolean doEquals(MoreLikeThisQueryBuilder other) {
import org.opensearch.core.xcontent.MediaType;
        } else {
        // query formation parameters
            moreLikeFields = context.defaultFields();
import java.util.Objects;
import org.opensearch.index.VersionType;
    public String analyzer() {
                        // skip
        mltQuery.setMoreLikeFields(moreLikeFields.toArray(new String[0]));
import org.opensearch.action.termvectors.TermVectorsRequest;
    }
        public VersionType versionType() {
    public static final int DEFAULT_MIN_WORD_LENGTH = XMoreLikeThis.DEFAULT_MIN_WORD_LENGTH;
                    "failed to parse More Like This item. either [id] or [doc] can be specified, but not both!"
import org.apache.lucene.index.Fields;
                this.id = termVectorsRequest.id();
            } else {
import org.opensearch.core.common.io.stream.StreamInput;
        }
        /**
         * @param index the index to be used for parsing the doc
                    boost = parser.floatValue();
        builder.field(MAX_WORD_LENGTH.getPreferredName(), maxWordLength);
        out.writeVInt(maxDocFreq);
        public Item index(String index) {
     */
        boolean useDefaultField
                termVectorsRequest.doc(doc, true, mediaType);
            if (this == o) return true;
            return version;
        if (moreLikeFields.isEmpty()) {
                .offsets(false)
        // handle items
        out.writeOptionalString(analyzer);
                builder.field(PER_FIELD_ANALYZER.getPreferredName(), this.perFieldAnalyzer);
     * Sets the maximum number of query terms that will be included in any generated query.
            }
                if (LIKE.match(currentFieldName, parser.getDeprecationHandler())) {
                            List<String> fields = new ArrayList<>();
        unlikeItems = in.readList(Item::new).toArray(new Item[0]);
        + "queries. The type should no longer be specified in the [like] and [unlike] sections.";
        if (unlikeTexts.length > 0) {
            .minimumShouldMatch(minimumShouldMatch)
        }
        List<Item> unlikeItems = new ArrayList<>();
import org.opensearch.transport.client.Client;
    private static final ParseField STOP_WORDS = new ParseField("stop_words");
    public static final class Item implements ToXContentObject, Writeable {
            analyzer,
        this.include = include;
        return this;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            this.versionType = versionType;
        this.maxQueryTerms = maxQueryTerms;
                moreLikeFields.add(fieldType == null ? field : fieldType.name());
        return likeItems;
        List<String> moreLikeFields,
    private static final ParseField MIN_WORD_LENGTH = new ParseField("min_word_length");
     * Defaults to {@code 25}.
        // fetching the items with multi-termvectors API
            TermVectorsRequest termVectorsRequest = new TermVectorsRequest(index, id).selectedFields(fields)
        if (stopWords != null) {
    private String[] stopWords;
    /**
                            }
        return boostTerms;
        // set default index, type and fields if not specified
        );
    public MoreLikeThisQueryBuilder unlike(String[] unlikeTexts) {
        List<String> stopWords = null;
                        }
            this.versionType = copy.versionType;
                        if (token == XContentParser.Token.START_ARRAY) {
import org.opensearch.core.ParseField;
 * ownership. Elasticsearch licenses this file to you under
            } else if (token.isValue()) {
    public MoreLikeThisQueryBuilder maxWordLength(int maxWordLength) {
         */
    private static final ParseField VERSION = new ParseField("version");
                        parseLikeField(parser, likeTexts, likeItems);
    /**
        builder.field(MIN_WORD_LENGTH.getPreferredName(), minWordLength);
    }
        }
            && Arrays.equals(likeItems, other.likeItems)
                    } else if (PER_FIELD_ANALYZER.match(currentFieldName, parser.getDeprecationHandler())) {
    public static final int DEFAULT_MAX_WORD_LENGTH = XMoreLikeThis.DEFAULT_MAX_WORD_LENGTH;
                        parseLikeField(parser, unlikeTexts, unlikeItems);
                && Objects.equals(perFieldAnalyzer, other.perFieldAnalyzer)
        }
    }
        QueryShardContext context,
    private static void handleExclude(BooleanQuery.Builder boolQuery, Item[] likeItems, QueryShardContext context) {
         */
import org.apache.lucene.search.BooleanQuery;
            String currentFieldName = null;
        /**
            && Objects.equals(failOnUnsupportedField, other.failOnUnsupportedField);
 * GitHub history for details.
                if (token == XContentParser.Token.FIELD_NAME) {
import java.util.Arrays;
import java.util.Set;
                .perFieldAnalyzer(perFieldAnalyzer)
        }
    // other parameters
    private static final Set<Class<? extends MappedFieldType>> SUPPORTED_FIELD_TYPES = new HashSet<>(
                    if (failOnUnsupportedField) {
    public int minWordLength() {
    }
                        fields.add(parser.text());
                } else if (MIN_WORD_LENGTH.match(currentFieldName, parser.getDeprecationHandler())) {
        }
            return this;
                throw new IllegalArgumentException(
        public Item fields(String... fields) {
        this.minDocFreq = minDocFreq;
import org.opensearch.Version;
        likeItems = in.readList(Item::new).toArray(new Item[0]);
import java.io.IOException;
    private boolean failOnUnsupportedField = DEFAULT_FAIL_ON_UNSUPPORTED_FIELDS;
            return mltQuery;
    public static final String NAME = "more_like_this";
        String queryName = null;
                    }
        }
            return this;
        if (cause != null) {
        fields = in.readOptionalStringArray();
        return this;
        return minDocFreq;
 * this file be licensed under the Apache-2.0 license or a
    }
        MoreLikeThisQuery mltQuery,
        }
    static final String TYPES_DEPRECATION_MESSAGE = "[types removal] Types are deprecated in [more_like_this] "
 * specific language governing permissions and limitations
                out.writeString(id);
    public String[] fields() {
                continue;
        BooleanQuery.Builder boolQuery = new BooleanQuery.Builder();
            return this;
        }
                    out.writeEnum((XContentType) mediaType);
                }
        builder.field(MIN_TERM_FREQ.getPreferredName(), minTermFreq);
public class MoreLikeThisQueryBuilder extends AbstractQueryBuilder<MoreLikeThisQueryBuilder> {
                        item.id = parser.text();
    }
        MoreLikeThisQueryBuilder moreLikeThisQueryBuilder = new MoreLikeThisQueryBuilder(fieldsArray, likeTextsArray, likeItemsArray)
        } else {
        out.writeVInt(minDocFreq);
    private static final ParseField MAX_QUERY_TERMS = new ParseField("max_query_terms");
import org.apache.lucene.search.Query;
        }
     * Sets the field names that will be used when generating the 'More Like This' query.
                } else if ("boost".equals(currentFieldName)) {
                    } else if (VERSION.match(currentFieldName, parser.getDeprecationHandler())) {
            setDefaultIndexTypeFields(context, item, moreLikeFields, useDefaultField);
            } catch (Exception e) {
    public String[] likeTexts() {
            return Objects.equals(index, other.index)
        if (fields != null) {
                throw new OpenSearchParseException("failed to parse More Like This item. neither [id] nor [doc] is specified!");
        }
        out.writeBoolean(failOnUnsupportedField);
        if (fields != null && fields.isEmpty()) {
import org.opensearch.common.Nullable;
        } else {
    }
            } else if (token == XContentParser.Token.START_ARRAY) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        private String id;
            if (doc != null) {
        return this;
     * @param likeTexts the text to use when generating the 'More Like This' query.
        builder.field(MAX_QUERY_TERMS.getPreferredName(), maxQueryTerms);
        public int hashCode() {
            Arrays.hashCode(likeItems),
        mltQuery.setMaxQueryTerms(maxQueryTerms);
            mltQuery.setLikeText(likeTexts);
        }
            }
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    currentFieldName = parser.currentName();
                        item.index = parser.text();
    private int minWordLength = DEFAULT_MIN_WORD_LENGTH;
    }
 * Modifications Copyright OpenSearch Contributors. See
            && Objects.equals(minDocFreq, other.minDocFreq)
            .boostTerms(boostTerms)
    private final Item[] likeItems;
            this.version = version;
                    maxQueryTerms = parser.intValue();
            for (String text : texts) {
    }
/**
                && Objects.equals(versionType, other.versionType);
         */
        return unlikeTexts;
    /**
                    mediaType.writeTo(out);
 */
            out.writeLong(version);
                    parseLikeField(parser, likeTexts, likeItems);
        }
        if ((likeTexts == null || likeTexts.length == 0) && (likeItems == null || likeItems.length == 0)) {
        // term selection parameters
        return this;
                } else if (UNLIKE.match(currentFieldName, parser.getDeprecationHandler())) {
        mltQuery.setMinTermFrequency(minTermFreq);
            this.perFieldAnalyzer = copy.perFieldAnalyzer;
        // exclude the items from the search
        List<Fields> likeFields = new ArrayList<>();
import java.util.Optional;
            if (unlikeFields.length > 0) {
                    queryName = parser.text();
 * this work for additional information regarding copyright
     * Any word in this set is considered "uninteresting" and ignored. Even if your Analyzer allows stopwords, you
                } else {
            if (copy.id == null && copy.doc == null) {
                } else {
        }
                }
    public Item[] likeItems() {
     * Number of terms that must match the generated query expressed in the
            .maxQueryTerms(maxQueryTerms)
            return id;
                } else if (MIN_DOC_FREQ.match(currentFieldName, parser.getDeprecationHandler())) {
        return maxWordLength;
    public MoreLikeThisQueryBuilder unlike(Item[] unlikeItems) {
    /**
        if (idField == null) {
            out.writeOptionalString(index);
    private String minimumShouldMatch = DEFAULT_MINIMUM_SHOULD_MATCH;
                            item.fields(fields.toArray(new String[0]));
        }
            }
            throw new IllegalArgumentException("Content of 'like' parameter should either be a string or an object");
/*
                    } else {
    }
        for (MultiTermVectorsItemResponse response : responses) {
                    throw new ParsingException(parser.getTokenLocation(), "[mlt] query does not support [" + currentFieldName + "]");
                builder.array(FIELDS.getPreferredName(), this.fields);
                } else if (MAX_WORD_LENGTH.match(currentFieldName, parser.getDeprecationHandler())) {
 * KIND, either express or implied.  See the License for the
                } else if (INCLUDE.match(currentFieldName, parser.getDeprecationHandler())) {
     * Constructs a new more like this query which uses the default search field.
            return handleItems(context, mltQuery, likeItems, unlikeItems, include, moreLikeFields, useDefaultField);
        }
        String currentFieldName = null;
 */
                .fieldStatistics(false)
        mltQuery.setMinWordLen(minWordLength);
        String minimumShouldMatch = MoreLikeThisQueryBuilder.DEFAULT_MINIMUM_SHOULD_MATCH;
import org.opensearch.index.mapper.IdFieldMapper;
        }
                checkRoutingMissingException(response);
                }
    public MoreLikeThisQueryBuilder maxDocFreq(int maxDocFreq) {
        public Item(@Nullable String index, XContentBuilder doc) {
        }
        // set like text fields
            Arrays.hashCode(unlikeItems),
            try {
        }
            return this;
    ) throws IOException {
            analyzerObj = context.getMapperService().searchAnalyzer();
    /**
    public static final boolean DEFAULT_FAIL_ON_UNSUPPORTED_FIELDS = true;
                continue;
         */
     * Sets the text from which the terms should not be selected from.
    public MoreLikeThisQueryBuilder stopWords(List<String> stopWords) {
            this.perFieldAnalyzer = perFieldAnalyzer;
import org.opensearch.common.lucene.uid.Versions;
        maxDocFreq = in.readVInt();
     * Set the maximum frequency in which words may still appear. Words that appear
    }
            if (out.getVersion().before(Version.V_2_0_0)) {
            unlikeItems[i] = new Item(this.unlikeItems[i]);
                mltQuery.setUnlikeFields(unlikeFields);
     */
        public static final Item[] EMPTY_ARRAY = new Item[0];
     *
    }
        Item[] unlikeItems,
    private static final ParseField BOOST_TERMS = new ParseField("boost_terms");
    /**
        /**
                } else if (UNLIKE.match(currentFieldName, parser.getDeprecationHandler())) {
        String[] likeTextsArray = likeTexts.isEmpty() ? null : likeTexts.toArray(new String[0]);
    public MoreLikeThisQueryBuilder boostTerms(float boostTerms) {
            for (Item item : items) {
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
    protected void doWriteTo(StreamOutput out) throws IOException {
                out.writeGenericValue(doc);
    private static final ParseField LIKE = new ParseField("like");
                        item.mediaType = MediaTypeRegistry.JSON;
            maxWordLength,
 * The OpenSearch Contributors require contributions made to
 *    http://www.apache.org/licenses/LICENSE-2.0
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            }
        List<String> moreLikeFields,
 *
    private Item[] unlikeItems = new Item[0];
            this.index = copy.index;
                return builder.toString();
    public int maxWordLength() {
import org.apache.lucene.search.BooleanClause;
                    "[more_like_this] query cannot infer the field to analyze the free text, "
            return this;
            } else if (token == XContentParser.Token.START_OBJECT) {
                builder.field(VERSION_TYPE.getPreferredName(), this.versionType.toString().toLowerCase(Locale.ROOT));
import java.io.InputStream;
        }
                    parseLikeField(parser, likeTexts, likeItems);
                } else if (MINIMUM_SHOULD_MATCH.match(currentFieldName, parser.getDeprecationHandler())) {
        return Arrays.equals(fields, other.fields)
     * @param fields the field names that will be used when generating the 'More Like This' query.
    private static final ParseField MIN_DOC_FREQ = new ParseField("min_doc_freq");
        }
            return doc;
import org.opensearch.core.xcontent.XContentBuilder;
                toXContent(builder, EMPTY_PARAMS);
    public MoreLikeThisQueryBuilder minimumShouldMatch(String minimumShouldMatch) {
        if (!ids.isEmpty()) {
         * Read from a stream.
            }
    }
    }
import org.opensearch.common.xcontent.XContentType;
                throw new IllegalArgumentException("Item requires either id or doc to be non-null");
    }
    }
                } else if (MAX_QUERY_TERMS.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
    public MoreLikeThisQueryBuilder maxQueryTerms(int maxQueryTerms) {
        @Override
            && Objects.equals(minTermFreq, other.minTermFreq)
     */
        if (likeTexts.length > 0) {
        public Item(@Nullable String index, String id) {
                    } else if (VERSION_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {
                doc = (BytesReference) in.readGenericValue();
        mltQuery.setMaxWordLen(maxWordLength);
        out.writeOptionalStringArray(fields);
            include,
    private static final ParseField ID = new ParseField("_id");
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)
/*
                    stopWords = new ArrayList<>();
        for (Item item : items) {
    );
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) {
        // TODO we allow null here for the _all field, but this is forbidden in the parser. Re-check
                } else if (LIKE.match(currentFieldName, parser.getDeprecationHandler())) {
    private static void setDefaultIndexTypeFields(
    @Override
    private static final ParseField FAIL_ON_UNSUPPORTED_FIELD = new ParseField("fail_on_unsupported_field");
 *
        out.writeGenericValue(boostTerms);
                .termStatistics(false);
                throw new IllegalArgumentException("Item requires doc to be non-null");
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
            Item other = (Item) o;
    /**
        return this;
            .minDocFreq(minDocFreq)
                && Arrays.equals(fields, other.fields) // otherwise we are comparing pointers
        return maxDocFreq;
                            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
        out.writeStringArray(likeTexts);
        QueryShardContext context,
                && Objects.equals(doc, other.doc)
    }
 * The documents are provided as a set of strings and/or a list of {@link Item}.
            this.fields = copy.fields;
            && Arrays.equals(stopWords, other.stopWords) // otherwise we are comparing pointers
            .unlike(unlikeTextsArray)
import org.opensearch.core.common.bytes.BytesReference;
                .payloads(false)
            builder.startObject();
        // handle like texts
    /**
        buildLikeField(builder, UNLIKE.getPreferredName(), unlikeTexts, unlikeItems);
            maxQueryTerms,
            setDefaultIndexTypeFields(context, item, moreLikeFields, useDefaultField);
            out.writeBoolean(doc != null);
        this.fields = fields;
            this.mediaType = doc.contentType();
                        item.routing = parser.text();
                item.fields(moreLikeFields.toArray(new String[0]));
        return this;
        out.writeVInt(maxWordLength);
        out.writeVInt(maxQueryTerms);
        if (texts.length > 0 || items.length > 0) {
            }
 * software distributed under the License is distributed on an
                    } else {
                    minTermFreq = parser.intValue();
        // default fields if not present but don't override for artificial docs
        out.writeList(Arrays.asList(unlikeItems));
            }
            }
        out.writeStringArray(unlikeTexts);
    private static void buildLikeField(XContentBuilder builder, String fieldName, String[] texts, Item[] items) throws IOException {
    }
    }
        if (fields != null && fields.length == 0) {
    }
        mltQuery.setSimilarity(context.getSearchSimilarity());
                }
    public MoreLikeThisQueryBuilder analyzer(String analyzer) {
    private final String[] likeTexts;
                continue;
                && Objects.equals(version, other.version)
        return this;
                        throw new IllegalArgumentException("more_like_this only supports text/keyword fields: [" + field + "]");
            throw ((RoutingMissingException) cause);
        printBoostAndQueryName(builder);
import org.opensearch.common.xcontent.XContentFactory;
        String[] unlikeTextsArray = unlikeTexts.isEmpty() ? null : unlikeTexts.toArray(new String[0]);
        this.minWordLength = minWordLength;
     * many docs. Defaults to {@code 5}.
                    builder.rawField(DOC.getPreferredName(), stream, mediaType);
        Analyzer analyzerObj = context.getIndexAnalyzers().get(analyzer);
                .versionType(versionType)
import org.opensearch.common.lucene.search.XMoreLikeThis;
