            }
    public MoreLikeThisQueryBuilder(@Nullable String[] fields, @Nullable String[] likeTexts, @Nullable Item[] likeItems) {  
            fields = in.readOptionalStringArray();  
    public int maxWordLength() {  
        if (stopWords != null) {
            if (this.versionType != VersionType.INTERNAL) {
 * this file be licensed under the Apache-2.0 license or a
                // types no longer supported so ignore
        }
        Item[] unlikeItems = new Item[this.unlikeItems.length];
     * might want to tell the MoreLikeThis code to ignore them, as for the purposes of document similarity it seems
                continue;  
    /**
    private static final ParseField MIN_WORD_LENGTH = new ParseField("min_word_length");
                } else if (STOP_WORDS.match(currentFieldName, parser.getDeprecationHandler())) {
        List<String> moreLikeFields,
            throw new IllegalArgumentException(NAME + " query requires 'fields' to be specified");  
 * A more like this query that finds documents that are "like" the provided set of document(s).
package org.opensearch.index.query;
            return doc;
        boolean useDefaultField  
            throw new IllegalArgumentException(NAME + " query requires either 'like' texts or items to be specified.");  
        builder.field(MIN_DOC_FREQ.getPreferredName(), minDocFreq);
        analyzer = in.readOptionalString();  
 * ownership. Elasticsearch licenses this file to you under  
            }
    public MoreLikeThisQueryBuilder(StreamInput in) throws IOException {
    /**  
    }
            Query query = idField.termsQuery(ids, context);  
            this.index = index;  
                    failOnUnsupportedField = parser.booleanValue();
        mltQuery.setMinDocFreq(minDocFreq);
         * Constructor for an artificial document request, that is not present in the index.  
            this.versionType = copy.versionType;  
            this.routing = copy.routing;  
        private long version = Versions.MATCH_ANY;
        // getting the Fields for liked items
    private static final ParseField ANALYZER = new ParseField("analyzer");
    public boolean failOnUnsupportedField() {  
            return termVectorsRequest;  
            } else {  
        private Map<String, String> perFieldAnalyzer;
    public boolean include() {  
        Item[] likeItemsArray = likeItems.isEmpty() ? null : likeItems.toArray(new Item[0]);
        public Item routing(String routing) {
        this.maxDocFreq = maxDocFreq;  
                    minTermFreq = parser.intValue();
     * reasonable to assume that "a stop word is never interesting".  
                && Objects.equals(versionType, other.versionType);
                        + "set the [fields] option in the query."  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // set like text fields  
                    fields = new ArrayList<>();
            .minDocFreq(minDocFreq)  
    private final Item[] likeItems;
    private final String[] likeTexts;
        if (stopWords != null) {  
        /**
                .versionType(versionType)  
        }  
        }
        }
                continue;
        for (MultiTermVectorsItemResponse response : responses) {  
        super(in);
        boolean include = MoreLikeThisQueryBuilder.DEFAULT_INCLUDE;
                    parseLikeField(parser, likeTexts, likeItems);
        String currentFieldName = null;
        this.boostTerms = boostTerms;
        List<String> stopWords = null;
            builder.field(ANALYZER.getPreferredName(), analyzer);
                        item.routing = parser.text();  
            this.versionType = versionType;  
            Arrays.hashCode(unlikeTexts),
         * Sets the analyzer(s) to use at any given field.  
     * Read from a stream.
        }
        List<Item> likeItems = new ArrayList<>();
        }  
    public MoreLikeThisQueryBuilder boostTerms(float boostTerms) {
                        }
 * KIND, either express or implied.  See the License for the
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
import java.io.IOException;
                && Objects.equals(perFieldAnalyzer, other.perFieldAnalyzer)
        unlikeTexts = in.readStringArray();  
                    throw new ParsingException(parser.getTokenLocation(), "[mlt] query does not support [" + currentFieldName + "]");
            }
                    minDocFreq = parser.intValue();  
    public String[] stopWords() {  
            .unlike(unlikeTextsArray)
            throw new ParsingException(parser.getTokenLocation(), "more_like_this requires 'like' to be specified");
        } else {
        private String[] fields;
            && Objects.equals(failOnUnsupportedField, other.failOnUnsupportedField);
        out.writeVInt(maxWordLength);
     */
                } else if (UNLIKE.match(currentFieldName, parser.getDeprecationHandler())) {
                && Objects.equals(doc, other.doc)
        List<Fields> likeFields = new ArrayList<>();
                builder.value(text);
    private MultiTermVectorsResponse fetchResponse(Client client, Item[] items) throws IOException {  
        float boostTerms = MoreLikeThisQueryBuilder.DEFAULT_BOOST_TERMS;
        return maxDocFreq;
        boostTerms = (Float) in.readGenericValue();
    private static final ParseField MAX_QUERY_TERMS = new ParseField("max_query_terms");  
        builder.field(MIN_TERM_FREQ.getPreferredName(), minTermFreq);
        }  
        // getting the Fields for unliked items
            out.writeOptionalString(routing);  
        List<String> likeTexts = new ArrayList<>();
            return perFieldAnalyzer;
        public Item fields(String... fields) {
    }  
    private static final ParseField UNLIKE = new ParseField("unlike");
         */
                        continue;
import org.apache.lucene.search.BooleanQuery;
    private static final ParseField INDEX = new ParseField("_index");
        this.minTermFreq = minTermFreq;
                continue;
                termVectorsRequest.doc(doc, true, mediaType);  
                builder.value(item);
import org.opensearch.core.common.bytes.BytesReference;  
            && Objects.equals(boostTerms, other.boostTerms)
        out.writeOptionalString(analyzer);  
    }
                    maxWordLength = parser.intValue();  
    }
            }
import org.opensearch.index.VersionType;  
        }
            org.apache.lucene.index.Fields[] unlikeFields = getFieldsFor(unlikeItemsResponse);
    private static final ParseField MAX_WORD_LENGTH = new ParseField("max_word_length");
            Arrays.hashCode(likeTexts),  
    }
    }
            }
                    }
            return item;  
                    } else {
                    parseLikeField(parser, unlikeTexts, unlikeItems);
    public static final float DEFAULT_BOOST_TERMS = 0;  // no boost terms
        if (minimumShouldMatch == null) {
            include,
            }
                    minimumShouldMatch = parser.text();
            .boost(boost)  
        return this;  
        // TODO this needs heavy cleanups before we can rewrite it  
    }
            if (this.fields != null) {
                    analyzer = parser.text();
            index = in.readOptionalString();  
                && Objects.equals(routing, other.routing)
        return this;
                throw new IllegalArgumentException("Item requires either id or doc to be non-null");
        for (int i = 0; i < likeItems.length; i++) {
                .offsets(false)  
            Arrays.hashCode(fields),
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        // document inputs  
     */  
         * Convert this to a {@link TermVectorsRequest} for fetching the terms of the document.  
        } else if (parser.currentToken() == XContentParser.Token.START_OBJECT) {  
    private static final ParseField PER_FIELD_ANALYZER = new ParseField("per_field_analyzer");
                    boost = parser.floatValue();  
        if (moreLikeFields.isEmpty()) {  
import org.opensearch.core.common.io.stream.StreamInput;
        public boolean equals(Object o) {
        }  
     * Number of terms that must match the generated query expressed in the
     * The analyzer that will be used to analyze the text. Defaults to the analyzer associated with the field.
            minTermFreq,
        minWordLength = in.readVInt();  
        @Override
         */
        builder.field(FAIL_ON_UNSUPPORTED_FIELD.getPreferredName(), failOnUnsupportedField);  
    }
            if (response.isFailed()) {
                    }  
                        throw new OpenSearchParseException("failed to parse More Like This item. unknown field [{}]", currentFieldName);  
        // set similarity
            versionType = VersionType.readFromStream(in);
            routing = in.readOptionalString();
        boolean include,
        }
     * <p>  
        // set default index, type and fields if not specified  
    private static final ParseField VERSION = new ParseField("version");  
    private boolean failOnUnsupportedField = DEFAULT_FAIL_ON_UNSUPPORTED_FIELDS;
import org.opensearch.common.lucene.search.MoreLikeThisQuery;
        return this;
            }
import org.opensearch.index.mapper.MappedFieldType;  
        }
        this.likeTexts = Optional.ofNullable(likeTexts).orElse(Strings.EMPTY_ARRAY);  
     * Set the maximum frequency in which words may still appear. Words that appear
    public static final class Item implements ToXContentObject, Writeable {  
    public MoreLikeThisQueryBuilder minTermFreq(int minTermFreq) {  
 * this work for additional information regarding copyright
        include = in.readBoolean();  
                    if (INDEX.match(currentFieldName, parser.getDeprecationHandler())) {
        this.minWordLength = minWordLength;
    /**  
        return this;
        fields = in.readOptionalStringArray();  
            return Objects.hash(index, id, doc, Arrays.hashCode(fields), perFieldAnalyzer, routing, version, versionType);
     * Sets the boost factor to use when boosting terms. Defaults to {@code 0} (deactivated).
                id = in.readString();
        }  
    private boolean include = DEFAULT_INCLUDE;
                doc = (BytesReference) in.readGenericValue();  
    private String[] stopWords;
        if (useDefaultField) {  
            }  
            TermVectorsRequest termVectorsRequest = new TermVectorsRequest(index, id).selectedFields(fields)  
    public MoreLikeThisQueryBuilder minimumShouldMatch(String minimumShouldMatch) {
            this.index = index;
 *
        Item item,
            this.doc = copy.doc;
            } else {
                    } else {  
                            throw new OpenSearchParseException("failed to parse More Like This item. field [fields] must be an array");
import org.opensearch.index.mapper.KeywordFieldMapper.KeywordFieldType;
                    } else if (VERSION.match(currentFieldName, parser.getDeprecationHandler())) {
        public String routing() {
            mltQuery.setBoostTerms(true);
                    } else if (FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
            out.writeBoolean(doc != null);
        if (unlikeItems.length > 0) {
        Arrays.asList(TextFieldType.class, KeywordFieldType.class)  
                }
            if (in.readBoolean()) {
            if (doc != null) {  
            if (!(o instanceof Item)) return false;
    }
        int minTermFreq = MoreLikeThisQueryBuilder.DEFAULT_MIN_TERM_FREQ;  
                }  
 * specific language governing permissions and limitations
        return maxQueryTerms;
            if (token == XContentParser.Token.FIELD_NAME) {  
        return this;  
            maxWordLength,  
            maxQueryTerms,
 * software distributed under the License is distributed on an
    public String[] fields() {
            .failOnUnsupportedField(failOnUnsupportedField)
            this.routing = routing;  
        String minimumShouldMatch = MoreLikeThisQueryBuilder.DEFAULT_MINIMUM_SHOULD_MATCH;  
                throw new OpenSearchParseException("failed to parse More Like This item. neither [id] nor [doc] is specified!");
                .fieldStatistics(false)
        /**  
        out.writeVInt(maxQueryTerms);
    @Override
        builder.field(INCLUDE.getPreferredName(), include);
    @Override
        /**
    @Override
import org.apache.lucene.index.Fields;
    }
        return this;  
                    maxQueryTerms = parser.intValue();
import java.util.List;  
                return builder.toString();
        mltQuery.setMaxWordLen(maxWordLength);
    public MoreLikeThisQueryBuilder minDocFreq(int minDocFreq) {
        if (analyzer != null) {  
            MultiTermVectorsResponse unlikeItemsResponse = fetchResponse(context.getClient(), unlikeItems);  
            this.version = version;  
            analyzer,
        private VersionType versionType = VersionType.INTERNAL;
                    mediaType = in.readEnum(XContentType.class);
                } else if (LIKE.match(currentFieldName, parser.getDeprecationHandler())) {  
    }
         */
        mltQuery.setLikeFields(getFieldsFor(likeItemsResponse));
            for (String field : fields) {
                } else if (INCLUDE.match(currentFieldName, parser.getDeprecationHandler())) {
                // types not supported so send an empty array to previous versions
import org.opensearch.Version;
        likeTexts = in.readStringArray();
        MoreLikeThisQuery mltQuery = new MoreLikeThisQuery();  
import org.opensearch.core.common.io.stream.Writeable;  
        builder.field(BOOST_TERMS.getPreferredName(), boostTerms);
    public MoreLikeThisQueryBuilder analyzer(String analyzer) {
    protected int doHashCode() {  
    /**
    }
    // document inputs  
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) {
        return client.multiTermVectors(request).actionGet();  
        // exclude the items from the search
        if (stopWords != null) {
        return stopWords;
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
        }  
        public Item(@Nullable String index, XContentBuilder doc) {
    private int minDocFreq = DEFAULT_MIN_DOC_FREQ;
    public int minWordLength() {
import org.apache.lucene.search.BooleanClause;  
            Arrays.hashCode(likeItems),
    public static final String DEFAULT_MINIMUM_SHOULD_MATCH = MoreLikeThisQuery.DEFAULT_MINIMUM_SHOULD_MATCH;  
    /**
        );
    public MoreLikeThisQueryBuilder include(boolean include) {
                    builder.rawField(DOC.getPreferredName(), stream, mediaType);
            return this;
            if (item.id != null && item.doc != null) {
        private String id;
    }
            .include(include)
    private static void parseLikeField(XContentParser parser, List<String> texts, List<Item> items) throws IOException {  
            && Objects.equals(minTermFreq, other.minTermFreq)  
    public MoreLikeThisQueryBuilder maxWordLength(int maxWordLength) {
            }
                    currentFieldName = parser.currentName();
            item.index(context.index().getName());  
            && Objects.equals(include, other.include)  
    }
    public String[] unlikeTexts() {  
        return this.fields;
        int minDocFreq = MoreLikeThisQueryBuilder.DEFAULT_MIN_DOC_FREQ;
            return Objects.equals(index, other.index)  
    /**
import org.opensearch.index.mapper.IdFieldMapper;
        }
    private static void checkRoutingMissingException(MultiTermVectorsItemResponse response) {
        }  
        }  
                out.writeGenericValue(doc);
 */
                builder.field(INDEX.getPreferredName(), this.index);
     */
import org.opensearch.core.xcontent.XContentParser;
    /**
     */
import java.util.Set;
        }  
     * common syntax for minimum should match. Defaults to {@code 30%}.  
            .minWordLength(minWordLength)
                }  
        MappedFieldType idField = context.fieldMapper(IdFieldMapper.NAME);
        return this;
import java.util.ArrayList;  
            moreLikeFields = context.defaultFields();
            && Arrays.equals(stopWords, other.stopWords) // otherwise we are comparing pointers
        }
        QueryShardContext context,
            if (out.getVersion().before(Version.V_2_0_0)) {
                        parseLikeField(parser, likeTexts, likeItems);
        // artificial docs get assigned a random id and should be disregarded  
     * Constructs a new more like this query which uses the default search field.  
        // query formation parameters
                        item.index = parser.text();
                && Objects.equals(id, other.id)
                out.writeOptionalString(null);  
            return this;
        List<String> moreLikeFields = new ArrayList<>();
                    parseLikeField(parser, likeTexts, likeItems);  
                MappedFieldType fieldType = context.fieldMapper(field);
                if (fieldType != null && SUPPORTED_FIELD_TYPES.contains(fieldType.getClass()) == false) {  
            throw new IllegalArgumentException("requires 'maxQueryTerms' to be greater than 0");
            if (copy.id == null && copy.doc == null) {
 */  
            return fields;
    @Override
            maxDocFreq,
    public static final boolean DEFAULT_INCLUDE = false;
                        stopWords.add(parser.text());
        }
         * @param index the index where the document is located  
        if (boostTerms != 0) {  
        if (stopWords == null) {
                } else if (BOOST_TERMS.match(currentFieldName, parser.getDeprecationHandler())) {
        }  
         * @param index the index to be used for parsing the doc
    ) throws IOException {
        return this;
        public static final Item[] EMPTY_ARRAY = new Item[0];
        out.writeOptionalStringArray(fields);  
            throw new IllegalArgumentException("requires stopwords to be non-null");  
            return versionType;
        }
     * A single item to be used for a {@link MoreLikeThisQueryBuilder}.
        return likeFields.toArray(new Fields[0]);
    private int minTermFreq = DEFAULT_MIN_TERM_FREQ;  
     */  
        builder.startObject(NAME);  
            mltQuery.setLikeText(likeTexts);
    public String analyzer() {  
/*
import java.util.HashSet;
/**  
    public String minimumShouldMatch() {  
        }
 *
    }  
            }
                } else if (MIN_TERM_FREQ.match(currentFieldName, parser.getDeprecationHandler())) {  
            if (this.version != Versions.MATCH_ANY) {
            if (!getResponse.isExists()) {  
                .termStatistics(false);  
                throw new OpenSearchParseException(
                .routing(routing)
                .payloads(false)
        return minDocFreq;
                        + "you should update the [index.query.default_field] index setting to a field that exists in the mapping or "
            this.perFieldAnalyzer = perFieldAnalyzer;  
                }
                } else if (currentFieldName != null) {  
            if (item.doc() != null) {  
    private String analyzer;  
                XContentBuilder builder = XContentFactory.jsonBuilder();
            }
            builder.array(STOP_WORDS.getPreferredName(), stopWords);
 * GitHub history for details.
        }  
            return;
 * SPDX-License-Identifier: Apache-2.0
        }
                this.id = termVectorsRequest.id();
            perFieldAnalyzer = (Map<String, String>) in.readGenericValue();
            } else {  
        int minWordLength = MoreLikeThisQueryBuilder.DEFAULT_MIN_WORD_LENGTH;  
    public MoreLikeThisQueryBuilder maxQueryTerms(int maxQueryTerms) {
}  
            // for artificial docs to make sure that the id has changed in the item too
            minimumShouldMatch,  
            throw new ParsingException(parser.getTokenLocation(), "more_like_this requires 'fields' to be non-empty");
     * Sets the field names that will be used when generating the 'More Like This' query.  
 *  
        }
        return unlikeItems;
    }
            for (String text : texts) {
                    } else if (PER_FIELD_ANALYZER.match(currentFieldName, parser.getDeprecationHandler())) {  
            }  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
 * license agreements. See the NOTICE file distributed with
        /**  
import org.opensearch.ExceptionsHelper;  
        if (maxQueryTerms <= 0) {  
    }  
     * @param fields the field names that will be used when generating the 'More Like This' query.
            return null;
            return routing;
    public static final ParseField DOC = new ParseField("doc");  
            out.writeLong(version);
        List<String> ids = new ArrayList<>();
    /**
            this.id = id;
                } else {
            }
    }
    // other parameters
            }
                            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
                throw new IllegalArgumentException("Item requires id to be non-null");
        }
        return this;  
        failOnUnsupportedField = in.readBoolean();
                                fields.add(parser.text());  
            if (this.doc != null) {  
            builder.startObject();
    private static final ParseField MINIMUM_SHOULD_MATCH = new ParseField("minimum_should_match");
        // default fields if not present but don't override for artificial docs
    }
        public void writeTo(StreamOutput out) throws IOException {
        int maxWordLength = MoreLikeThisQueryBuilder.DEFAULT_MAX_WORD_LENGTH;
        return Objects.hash(
public class MoreLikeThisQueryBuilder extends AbstractQueryBuilder<MoreLikeThisQueryBuilder> {
        if (!ids.isEmpty()) {
            }  
    }
     * Whether to fail or return no result when this query is run against a field which is not supported such as binary/numeric fields.
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)
    }  
            }
     * @param likeTexts the text to use when generating the 'More Like This' query.  
            this.mediaType = doc.contentType();
import java.util.Arrays;
 * <p>
        @Override  
        // term selection parameters
            moreLikeThisQueryBuilder.stopWords(stopWords);  
        this.stopWords = stopWords.toArray(new String[0]);
    }  
    /**
            out.writeGenericValue(perFieldAnalyzer);
     * Any word in this set is considered "uninteresting" and ignored. Even if your Analyzer allows stopwords, you
        }
        boolQuery.add(mltQuery, BooleanClause.Occur.SHOULD);
        MultiTermVectorsRequest request = new MultiTermVectorsRequest();
        if (likeTexts.length > 0) {  
        public static Item parse(XContentParser parser, Item item) throws IOException {  
            } else if (token == XContentParser.Token.START_OBJECT) {
                            item.fields(fields.toArray(new String[0]));
            this.index = copy.index;
            .minTermFreq(minTermFreq)
            this.version = copy.version;
            ids.add(item.id());  
import org.opensearch.common.xcontent.XContentFactory;
        String[] unlikeTextsArray = unlikeTexts.isEmpty() ? null : unlikeTexts.toArray(new String[0]);  
            try {
            && Objects.equals(maxQueryTerms, other.maxQueryTerms)
    }
                    stopWords = new ArrayList<>();  
    public MoreLikeThisQueryBuilder(String[] likeTexts, Item[] likeItems) {
        // fetching the items with multi-termvectors API
            return version;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
                } else if (MAX_QUERY_TERMS.match(currentFieldName, parser.getDeprecationHandler())) {
        unlikeItems = in.readList(Item::new).toArray(new Item[0]);
        TermVectorsRequest toTermVectorsRequest() {
            Arrays.hashCode(unlikeItems),  
    private static final ParseField BOOST_TERMS = new ParseField("boost_terms");  
                } else if (MAX_DOC_FREQ.match(currentFieldName, parser.getDeprecationHandler())) {
        this.unlikeTexts = Optional.ofNullable(unlikeTexts).orElse(Strings.EMPTY_ARRAY);
                    maxDocFreq = parser.intValue();
    }
                builder.field(PER_FIELD_ANALYZER.getPreferredName(), this.perFieldAnalyzer);  
    private static final ParseField INCLUDE = new ParseField("include");
         */
    }
        out.writeVInt(minWordLength);  
import org.opensearch.transport.client.Client;
            likeFields.add(getResponse.getFields());  
                mltQuery.setUnlikeFields(unlikeFields);  
                builder.field(ID.getPreferredName(), this.id);
        return analyzer;
            if (item.id == null && item.doc == null) {  
import org.opensearch.core.ParseField;  
        mltQuery.setSimilarity(context.getSearchSimilarity());  
    }
    public Item[] unlikeItems() {  
                throw new IllegalArgumentException(  
    }
                } else if ("boost".equals(currentFieldName)) {
            throw ((RoutingMissingException) cause);
    }
    }
     * Sets the minimum word length below which words will be ignored. Defaults  
                .version(version)
        }
        public String[] fields() {
        return moreLikeThisQueryBuilder;  
    }  
    public MoreLikeThisQueryBuilder stopWords(List<String> stopWords) {
        boolean useDefaultField = (fields == null);
                    boostTerms = parser.floatValue();  
                } else if (UNLIKE.match(currentFieldName, parser.getDeprecationHandler())) {
        public VersionType versionType() {
                if (token == XContentParser.Token.FIELD_NAME) {
                } else {  
            && Arrays.equals(likeTexts, other.likeTexts)
            builder.startArray(fieldName);  
        if ((likeTexts == null || likeTexts.length == 0) && (likeItems == null || likeItems.length == 0)) {
import org.apache.lucene.analysis.Analyzer;
            throw new IllegalArgumentException("[" + NAME + "] requires minimum should match to be non-null");  
        @Override
        }  
                toXContent(builder, EMPTY_PARAMS);
            return this;
            minDocFreq,  
            return mediaType;
     * in more than this many docs will be ignored. Defaults to unbounded.  
        public Item versionType(VersionType versionType) {
            unlikeItems[i] = new Item(this.unlikeItems[i]);  
            this.mediaType = copy.mediaType;
        // handle like texts
    /**
                } else {  
                    }  
         * @param id and its id
        // set analyzer
        if (unlikeTexts.length > 0) {  
import org.opensearch.common.xcontent.XContentType;
    public static final int DEFAULT_MAX_DOC_FREQ = XMoreLikeThis.DEFAULT_MAX_DOC_FREQ;  
        }
        return this;
            request.add(item.toTermVectorsRequest());  
        builder.endObject();
                item.fields(moreLikeFields.toArray(new String[0]));
            .queryName(queryName);
                } else if (MINIMUM_SHOULD_MATCH.match(currentFieldName, parser.getDeprecationHandler())) {  
        String[] fieldsArray = fields == null ? null : fields.toArray(new String[0]);
    @Override
        this.fields = fields;
        // sets boost terms
        this.maxWordLength = maxWordLength;
                builder.field(ROUTING.getPreferredName(), this.routing);  
        int maxQueryTerms = MoreLikeThisQueryBuilder.DEFAULT_MAX_QUERY_TERMS;
    /**
                    throw new ParsingException(parser.getTokenLocation(), "[mlt] query does not support [" + currentFieldName + "]");
                        parseLikeField(parser, unlikeTexts, unlikeItems);  
     * Set the set of stopwords.
            analyzerObj = context.getMapperService().searchAnalyzer();
            this.perFieldAnalyzer = copy.perFieldAnalyzer;
        return include;
                    parseLikeField(parser, unlikeTexts, unlikeItems);  
    private String[] unlikeTexts = Strings.EMPTY_ARRAY;  
     */  
        if ((item.fields() == null || item.fields().length == 0) && item.doc() == null) {  
    }  
            mltQuery.setBoostTermsFactor(boostTerms);
            this.fields = fields;  
            }
     * Sets the text from which the terms should not be selected from.
            throw new IllegalArgumentException("Content of 'like' parameter should either be a string or an object");  
        XContentParser.Token token;  
    }
import org.opensearch.core.xcontent.ToXContentObject;  
    private static Fields[] getFieldsFor(MultiTermVectorsResponse responses) throws IOException {  
        }
        public String toString() {  
            this.doc = BytesReference.bytes(doc);
    public String[] likeTexts() {
                    } else if (ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        return Arrays.equals(fields, other.fields)  
                        throw new IllegalArgumentException("more_like_this only supports text/keyword fields: [" + field + "]");
    private static final ParseField MIN_DOC_FREQ = new ParseField("min_doc_freq");
    /**
     * Sets the documents from which the terms should not be selected from.
            && Objects.equals(maxDocFreq, other.maxDocFreq)
         *
            this.index = index;
        String analyzer = null;  
    public MoreLikeThisQueryBuilder unlike(String[] unlikeTexts) {
        QueryShardContext context,  
                .positions(false)  // ensures these following parameters are never set
 * @opensearch.internal
    private final String[] fields;
        }  
    }
    private Query handleItems(  
import org.opensearch.action.RoutingMissingException;  
     * Sets the maximum number of query terms that will be included in any generated query.
        }
     * Sets the frequency at which words will be ignored which do not occur in at least this
    /**
        }
            Arrays.hashCode(stopWords),
    public int maxDocFreq() {
                } else if (MAX_WORD_LENGTH.match(currentFieldName, parser.getDeprecationHandler())) {
                        item.doc = BytesReference.bytes(jsonBuilder().copyCurrentStructure(parser));  
        MoreLikeThisQueryBuilder moreLikeThisQueryBuilder = new MoreLikeThisQueryBuilder(fieldsArray, likeTextsArray, likeItemsArray)
        }
            return index;  
            out.writeOptionalString(index);  
            .unlike(unlikeItemsArray)  
        mltQuery.setMinTermFrequency(minTermFreq);
                    include = parser.booleanValue();
        private String index;  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
            if (doc == null) {  
        public BytesReference doc() {  
import java.util.Optional;
            builder.endArray();
    /**
            builder.array(FIELDS.getPreferredName(), fields);
    }
        for (Item item : items) {
     * @opensearch.internal
import java.io.InputStream;
    }
        Item[] unlikeItemsArray = unlikeItems.isEmpty() ? null : unlikeItems.toArray(new Item[0]);
         * Constructor for a given item / document request
        for (int i = 0; i < unlikeItems.length; i++) {
    public String getWriteableName() {  
        + "queries. The type should no longer be specified in the [like] and [unlike] sections.";
            .maxQueryTerms(maxQueryTerms)
    }
        Item(Item copy) {  
                    throw new ParsingException(parser.getTokenLocation(), "[mlt] query does not support [" + currentFieldName + "]");
    private static void handleExclude(BooleanQuery.Builder boolQuery, Item[] likeItems, QueryShardContext context) {  
        if (item.index() == null) {
     * @param likeTexts the text to use when generating the 'More Like This' query.
/*  
        public long version() {
        minimumShouldMatch = in.readString();
    }  
        for (Item item : likeItems) {
        return failOnUnsupportedField;
        this.stopWords = stopWords;  
            handleExclude(boolQuery, likeItems, context);  
 * not use this file except in compliance with the License.
        mltQuery.setMaxDocFreq(maxDocFreq);  
    }  
        this.unlikeItems = Optional.ofNullable(unlikeItems).orElse(new Item[0]);
                if (LIKE.match(currentFieldName, parser.getDeprecationHandler())) {  
    /**
        }
    private static void setDefaultIndexTypeFields(
    // term selection parameters
import java.util.Map;
            if (useDefaultField) {
            setDefaultIndexTypeFields(context, item, moreLikeFields, useDefaultField);
        }
            boostTerms,
        if (likeItems.length > 0) {
            && Objects.equals(analyzer, other.analyzer)  
     * Whether to include the input documents. Defaults to {@code false}
            failOnUnsupportedField  
        }  
            && Objects.equals(minDocFreq, other.minDocFreq)
        if (cause != null) {
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    /**
                    }  
        return likeItems;
        return likeTexts;  
    private static final ParseField FAIL_ON_UNSUPPORTED_FIELD = new ParseField("fail_on_unsupported_field");
        builder.field(MAX_WORD_LENGTH.getPreferredName(), maxWordLength);
            items.add(Item.parse(parser, new Item()));
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.termvectors.TermVectorsResponse;
            return this;
        Item[] likeItems,  
                    minWordLength = parser.intValue();
     */  
            return handleItems(context, mltQuery, likeItems, unlikeItems, include, moreLikeFields, useDefaultField);  
 * You may obtain a copy of the License at  
    public MoreLikeThisQueryBuilder unlike(Item[] unlikeItems) {
        @Override
            mltQuery.setStopWords(new HashSet<>(Arrays.asList(stopWords)));
        out.writeStringArray(likeTexts);
                            List<String> fields = new ArrayList<>();
        }
                    mediaType.writeTo(out);  
        }
        mltQuery.setMinimumShouldMatch(minimumShouldMatch);  
            if (moreLikeFields.size() == 1 && moreLikeFields.get(0).equals("*") && (likeTexts.length > 0 || unlikeTexts.length > 0)) {
        }
                out.writeString(id);
import org.opensearch.action.termvectors.MultiTermVectorsRequest;
                    } else if (ID.match(currentFieldName, parser.getDeprecationHandler())) {  
        }
     * Defaults to {@code 25}.  
            }  
    protected boolean doEquals(MoreLikeThisQueryBuilder other) {
        public String id() {
            boolQuery.add(query, BooleanClause.Occur.MUST_NOT);
    private int minWordLength = DEFAULT_MIN_WORD_LENGTH;  
        MultiTermVectorsResponse likeItemsResponse = fetchResponse(context.getClient(), likeItems);  
        }  
            }
        mltQuery.setMinWordLen(minWordLength);
            this.fields = copy.fields;  
                        fields.add(parser.text());
                    } else if (VERSION_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {  
    protected void doWriteTo(StreamOutput out) throws IOException {
                && Objects.equals(version, other.version)  
        this.analyzer = analyzer;
import org.opensearch.common.Nullable;  
     * @see    org.opensearch.common.lucene.search.Queries#calculateMinShouldMatch(int, String)
    public static MoreLikeThisQueryBuilder fromXContent(XContentParser parser) throws IOException {
import org.opensearch.common.lucene.search.XMoreLikeThis;
                        // skip
 *    http://www.apache.org/licenses/LICENSE-2.0
    static final String TYPES_DEPRECATION_MESSAGE = "[types removal] Types are deprecated in [more_like_this] "  
 * under the License.  
    private float boostTerms = DEFAULT_BOOST_TERMS;
     * to {@code 0}.
import java.util.Objects;  
    private Item[] unlikeItems = new Item[0];
            } catch (Exception e) {  
        return minTermFreq;  
                    "failed to parse More Like This item. either [id] or [doc] can be specified, but not both!"  
        builder.field(MIN_WORD_LENGTH.getPreferredName(), minWordLength);
        /**
 * The OpenSearch Contributors require contributions made to  
                moreLikeFields.add(fieldType == null ? field : fieldType.name());
            return this;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    "[more_like_this] query cannot infer the field to analyze the free text, "
 * Unless required by applicable law or agreed to in writing,
/*  
        MoreLikeThisQuery mltQuery,
                    }
        return unlikeTexts;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BooleanQuery.Builder boolQuery = new BooleanQuery.Builder();
        if (parser.currentToken().isValue()) {
    public int minDocFreq() {  
            if (id == null) {
     */  
                        } else {  
    }
        this.include = include;
        return this;  
                        item.id = parser.text();
                } else if (MIN_DOC_FREQ.match(currentFieldName, parser.getDeprecationHandler())) {
            }  
    ) {
        minDocFreq = in.readVInt();
            } else if (token.isValue()) {
            }  
        }  
    public static final int DEFAULT_MAX_QUERY_TERMS = XMoreLikeThis.DEFAULT_MAX_QUERY_TERMS;  
                } else if (FAIL_ON_UNSUPPORTED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        likeItems = in.readList(Item::new).toArray(new Item[0]);
        out.writeOptionalStringArray(stopWords);
            && Objects.equals(minWordLength, other.minWordLength)  
    public float boostTerms() {  
     * unbounded ({@code 0}).
        Analyzer analyzerObj = context.getIndexAnalyzers().get(analyzer);  
import org.opensearch.common.lucene.uid.Versions;  
        // handle items
            // no mappings, nothing to exclude  
        }  
        printBoostAndQueryName(builder);
                builder.prettyPrint();  
        return minimumShouldMatch;
    }  
    private int maxWordLength = DEFAULT_MAX_WORD_LENGTH;
            likeItems[i] = new Item(this.likeItems[i]);
    public MoreLikeThisQueryBuilder stopWords(String... stopWords) {
    }
         */
        return this;  
                    queryName = parser.text();
     * Sets the maximum word length above which words will be ignored. Defaults to
import org.opensearch.core.common.ParsingException;
            if (unlikeFields.length > 0) {
            if (in.getVersion().before(Version.V_2_0_0)) {
        if (fields != null) {
import org.opensearch.OpenSearchParseException;
            .maxDocFreq(maxDocFreq)
     * many docs. Defaults to {@code 5}.
                } else if (UNLIKE.match(currentFieldName, parser.getDeprecationHandler())) {
        return this;  
        if (analyzerObj == null) {
        List<String> moreLikeFields,  
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                } else if (ANALYZER.match(currentFieldName, parser.getDeprecationHandler())) {
    private static final ParseField ID = new ParseField("_id");
            }  
        maxWordLength = in.readVInt();
            }
    public MoreLikeThisQueryBuilder minWordLength(int minWordLength) {  
     * @param likeItems the documents to use when generating the 'More Like This' query.
        public int hashCode() {  
                        item.mediaType = MediaTypeRegistry.JSON;
     * The frequency below which terms will be ignored in the source doc. The default  
            TermVectorsResponse getResponse = response.getResponse();
 */  
    private String minimumShouldMatch = DEFAULT_MINIMUM_SHOULD_MATCH;  
        return boostTerms;
            minWordLength,
        if (likeTexts.isEmpty() && likeItems.isEmpty()) {  
            && Arrays.equals(likeItems, other.likeItems)  
                if (LIKE.match(currentFieldName, parser.getDeprecationHandler())) {
                    if (failOnUnsupportedField) {
            }
         */
        mltQuery.setAnalyzer(analyzerObj);
            }
            if (this.routing != null) {
import java.util.Locale;
        return this;  
        /**
                checkRoutingMissingException(response);
    /**
        mltQuery.setMaxQueryTerms(maxQueryTerms);  
     */  
    }
                } else if ("_name".equals(currentFieldName)) {
        public Item(@Nullable String index, String id) {  
                builder.field(VERSION_TYPE.getPreferredName(), this.versionType.toString().toLowerCase(Locale.ROOT));  
import org.opensearch.core.common.Strings;
        out.writeVInt(minTermFreq);  
        public Item version(long version) {
        }  
        }
                        item.versionType = VersionType.fromString(parser.text());
        private BytesReference doc;
        return boolQuery.build();
    }
        List<String> fields = null;
     * frequency is {@code 2}.
            } else if (token == XContentParser.Token.START_ARRAY) {  
            if (this.perFieldAnalyzer != null) {
        }
                    mediaType = in.readMediaType();
            .maxWordLength(maxWordLength)  
        }
        }  
        }
            return mltQuery;
    private static final ParseField ROUTING = new ParseField("routing");
    private int maxDocFreq = DEFAULT_MAX_DOC_FREQ;
    public static final int DEFAULT_MIN_WORD_LENGTH = XMoreLikeThis.DEFAULT_MIN_WORD_LENGTH;
import org.opensearch.core.xcontent.XContentBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
        List<String> unlikeTexts = new ArrayList<>();  
        Item(StreamInput in) throws IOException {
    }  
                            }
     *
    }
    public MoreLikeThisQueryBuilder maxDocFreq(int maxDocFreq) {
        public Item() {}
        @Override
     *
     */  
    public static final String NAME = "more_like_this";
        builder.field(MAX_QUERY_TERMS.getPreferredName(), maxQueryTerms);  
import org.opensearch.action.termvectors.MultiTermVectorsResponse;  
            if (this == o) return true;  
                    }
        }
            .boostTerms(boostTerms)  
        private MediaType mediaType;  
        boolean useDefaultField
                    out.writeEnum((XContentType) mediaType);
                && Arrays.equals(fields, other.fields) // otherwise we are comparing pointers  
         * @param doc the document specification  
            && Arrays.equals(unlikeTexts, other.unlikeTexts)
        builder.field(MINIMUM_SHOULD_MATCH.getPreferredName(), minimumShouldMatch);  
     * @param likeItems the documents to use when generating the 'More Like This' query.
    private static final ParseField VERSION_TYPE = new ParseField("version_type");
         * Parses and returns the given item.
                }
    public static final int DEFAULT_MAX_WORD_LENGTH = XMoreLikeThis.DEFAULT_MAX_WORD_LENGTH;
                } else if (MIN_WORD_LENGTH.match(currentFieldName, parser.getDeprecationHandler())) {  
            if (this.index != null) {  
            }
                .perFieldAnalyzer(perFieldAnalyzer)
        }
        maxQueryTerms = in.readVInt();
                if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
        buildLikeField(builder, LIKE.getPreferredName(), likeTexts, likeItems);
        }  
        this(null, likeTexts, likeItems);
                return "{ \"error\" : \"" + ExceptionsHelper.detailedMessage(e) + "\"}";
        // TODO we allow null here for the _all field, but this is forbidden in the parser. Re-check
    }
                );
            String currentFieldName = null;
            return this;
                in.readOptionalString();  
            for (Item item : items) {
        return NAME;
 * The documents are provided as a set of strings and/or a list of {@link Item}.  
    }
        minTermFreq = in.readVInt();  
        Item[] unlikeItems,
    private static final ParseField MIN_TERM_FREQ = new ParseField("min_term_freq");
                }
 * compatible open source license.
    public int minTermFreq() {
        MediaType mediaType() {
    @Override
        out.writeStringArray(unlikeTexts);  
    }
            && Arrays.equals(unlikeItems, other.unlikeItems)
            }
     */  
    public Item[] likeItems() {  
        for (Item item : unlikeItems) {
        out.writeString(minimumShouldMatch);
                builder.array(FIELDS.getPreferredName(), this.fields);  
            && Objects.equals(maxWordLength, other.maxWordLength)
        return this;  
        List<Item> unlikeItems = new ArrayList<>();
        mltQuery.setMoreLikeFields(moreLikeFields.toArray(new String[0]));  
    public static final boolean DEFAULT_FAIL_ON_UNSUPPORTED_FIELDS = true;  
                }  
     */
                } else {  
import org.opensearch.core.xcontent.MediaType;
        for (Item item : likeItems) {
            out.writeOptionalStringArray(fields);
        String queryName = null;
            return builder.endObject();
        if (fields != null && fields.length == 0) {
         * Read from a stream.  
         *
        private String routing;  
        out.writeBoolean(include);  
        if (texts.length > 0 || items.length > 0) {
    private static final ParseField MAX_DOC_FREQ = new ParseField("max_doc_freq");  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;  
                );
        out.writeBoolean(failOnUnsupportedField);
            }
        public Map<String, String> perFieldAnalyzer() {
            setDefaultIndexTypeFields(context, item, moreLikeFields, useDefaultField);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 */  
        return this;  
                    } else if (DOC.match(currentFieldName, parser.getDeprecationHandler())) {
        public Item index(String index) {  
        if (!include) {
                        if (token == XContentParser.Token.START_ARRAY) {  
    private static final ParseField STOP_WORDS = new ParseField("stop_words");  
    public static final int DEFAULT_MIN_TERM_FREQ = XMoreLikeThis.DEFAULT_MIN_TERM_FREQ;
    }  
        out.writeVInt(maxDocFreq);
            .analyzer(analyzer)
        }
            Item other = (Item) o;
                try (InputStream stream = this.doc.streamInput()) {
                        item.perFieldAnalyzer(TermVectorsRequest.readPerFieldAnalyzer(parser.map()));
    protected Query doToQuery(QueryShardContext context) throws IOException {
            XContentParser.Token token;
        return minWordLength;  
import org.apache.lucene.search.Query;
                item.fields("*");
        builder.field(MAX_DOC_FREQ.getPreferredName(), maxDocFreq);  
        this.likeItems = Optional.ofNullable(likeItems).orElse(new Item[0]);
    private static void buildLikeField(XContentBuilder builder, String fieldName, String[] texts, Item[] items) throws IOException {
                builder.field(VERSION.getPreferredName(), this.version);  
    private static final ParseField LIKE = new ParseField("like");
        }
                }
        out.writeGenericValue(boostTerms);
            return id;  
        buildLikeField(builder, UNLIKE.getPreferredName(), unlikeTexts, unlikeItems);
        this.minimumShouldMatch = minimumShouldMatch;
        return maxWordLength;
import org.opensearch.action.termvectors.MultiTermVectorsItemResponse;
    private static final Set<Class<? extends MappedFieldType>> SUPPORTED_FIELD_TYPES = new HashSet<>(
            versionType.writeTo(out);
     */  
     *  
        stopWords = in.readOptionalStringArray();
                if (FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
        }  
        public Item perFieldAnalyzer(Map<String, String> perFieldAnalyzer) {
    /**
            }  
        }
        this.failOnUnsupportedField = fail;
     */  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamOutput;
    private int maxQueryTerms = DEFAULT_MAX_QUERY_TERMS;
        }
        String[] likeTextsArray = likeTexts.isEmpty() ? null : likeTexts.toArray(new String[0]);
                } else {
                        item.version = parser.longValue();
        }
     */
        this.maxQueryTerms = maxQueryTerms;  
        if (idField == null) {
                currentFieldName = parser.currentName();
        out.writeList(Arrays.asList(likeItems));
        int maxDocFreq = MoreLikeThisQueryBuilder.DEFAULT_MAX_DOC_FREQ;
        }
    }
    }
    private static final ParseField FIELDS = new ParseField("fields");  
import org.opensearch.action.termvectors.TermVectorsRequest;
        out.writeList(Arrays.asList(unlikeItems));
                if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
 *
        boolean failOnUnsupportedField = MoreLikeThisQueryBuilder.DEFAULT_FAIL_ON_UNSUPPORTED_FIELDS;
        // set query parameters
        if (fields != null && fields.isEmpty()) {  
            this.id = copy.id;
        } else {  
    public int maxQueryTerms() {
        Item[] likeItems = new Item[this.likeItems.length];  
        } else {
            .minimumShouldMatch(minimumShouldMatch)
            }
    );
     */  
    public static final int DEFAULT_MIN_DOC_FREQ = XMoreLikeThis.DEFAULT_MIN_DOC_FREQ;
    // query formation parameters
        maxDocFreq = in.readVInt();
            if (doc != null) {
            texts.add(parser.text());
        public String index() {
        out.writeVInt(minDocFreq);
     */
        // other parameters
        this.minDocFreq = minDocFreq;
    public MoreLikeThisQueryBuilder failOnUnsupportedField(boolean fail) {
            mltQuery.setUnlikeText(unlikeTexts);
            version = in.readLong();  
        Throwable cause = ExceptionsHelper.unwrap(response.getFailure().getCause(), RoutingMissingException.class);  
            if (this.id != null) {  
                throw new IllegalArgumentException("Item requires doc to be non-null");
     */
        }  
