    @Override  
import org.apache.lucene.search.Query;
        super(in);  
import org.opensearch.core.xcontent.XContentParser;  
     */
        builder.field(QUERY_FIELD.getPreferredName(), source);  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        return NAME;  
 * specific language governing permissions and limitations
    }
import java.nio.charset.StandardCharsets;  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    protected void doWriteTo(StreamOutput out) throws IOException {
    @Override
        }  
import java.io.IOException;
        }  
     * Creates a query builder given a query provided as a string
 *
        return this.source;
    public byte[] source() {  
    }
        throw new UnsupportedOperationException("this query must be rewritten first");
 * @opensearch.internal
        source = in.readByteArray();
        if (source == null || source.length() == 0) {
    @Override  
 */
 * GitHub history for details.
        }
import org.opensearch.core.ParseField;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
 * <pre>  
 * Modifications Copyright OpenSearch Contributors. See
        return Arrays.equals(source, other.source);   // otherwise we compare pointers  
    }
        this.source = BytesRef.deepCopyOf(source.toBytesRef()).bytes;
    protected int doHashCode() {  
        return Arrays.hashCode(source);
 * to use the Java Builder API but still have JSON query strings at hand that you want to combine with other
    }
        try (
    }
        parser.nextToken();
        this.source = source;  
        out.writeByteArray(this.source);  
    @Override
 *      bool.must(new TermQueryBuilder("field2","value2"));
        return NAME;  
    protected QueryBuilder doRewrite(QueryRewriteContext context) throws IOException {
            throw new ParsingException(parser.getTokenLocation(), "wrapper query has no [query] specified");
        parser.nextToken();
    public static WrapperQueryBuilder fromXContent(XContentParser parser) throws IOException {
    public WrapperQueryBuilder(BytesReference source) {
     * Creates a query builder given a query provided as a bytes array  
 * Example usage in a boolean query :
 * </code>
import org.apache.lucene.util.BytesRef;
        if (token != XContentParser.Token.FIELD_NAME) {  
/*  
            throw new IllegalArgumentException("query source text cannot be null or empty");
    protected boolean doEquals(WrapperQueryBuilder other) {
package org.opensearch.index.query;
        if (Strings.isEmpty(source)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (!QUERY_FIELD.match(fieldName, parser.getDeprecationHandler())) {
/*  
        return new WrapperQueryBuilder(source);
import org.opensearch.core.common.io.stream.StreamInput;
    }  
 * query builders.  
 *      bool.must(new WrapperQueryBuilder("{\"term\": {\"field\":\"value\"}}"));  
     */  
 * <code>
        byte[] source = parser.binaryValue();  
/*
 */  
            throw new ParsingException(parser.getTokenLocation(), "[wrapper] query malformed");
        this.source = source.getBytes(StandardCharsets.UTF_8);
        XContentParser.Token token = parser.nextToken();
    }
    public WrapperQueryBuilder(StreamInput in) throws IOException {
    protected Query doToQuery(QueryShardContext context) throws IOException {
     * Read from a stream.  
    public WrapperQueryBuilder(String source) {  
 *  
    private final byte[] source;  
        }  
        String fieldName = parser.currentName();  
 *      BoolQueryBuilder bool = new BoolQueryBuilder();
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
    @Override
import org.opensearch.core.xcontent.MediaTypeRegistry;
            throw new IllegalArgumentException("query source text cannot be null or empty");  
 * not use this file except in compliance with the License.
    }  
        }
 * Licensed to Elasticsearch under one or more contributor  
     */
 */  
import org.opensearch.core.xcontent.XContentBuilder;
    public String getWriteableName() {
            return queryBuilder;
 * KIND, either express or implied.  See the License for the
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
        if (source == null) {
        ) {  
                return boolQueryBuilder;  
 * A Query builder which allows building a query given JSON string or binary data provided as input. This is useful when you want
     */
public class WrapperQueryBuilder extends AbstractQueryBuilder<WrapperQueryBuilder> {
        }  
            }
                .createParser(context.getXContentRegistry(), LoggingDeprecationHandler.INSTANCE, source)
    }
 *
 * You may obtain a copy of the License at  
                final BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
    /**
 * Unless required by applicable law or agreed to in writing,
    public WrapperQueryBuilder(byte[] source) {
 * compatible open source license.
    /**  
                .xContent()
 *
    }
    }
    private static final ParseField QUERY_FIELD = new ParseField("query");
            throw new ParsingException(parser.getTokenLocation(), "[wrapper] query malformed, expected `query` but was " + fieldName);
import org.opensearch.core.common.ParsingException;
    /**
    }
            final QueryBuilder queryBuilder = parseInnerQueryBuilder(qSourceParser).rewrite(context);
import org.opensearch.core.common.Strings;  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    @Override
        builder.startObject(NAME);
 * under the License.  
import java.util.Arrays;
    }
 * </pre>  
    public static final String NAME = "wrapper";
    /**
        builder.endObject();
 * <p>
import org.opensearch.core.common.bytes.BytesReference;
            if (boost() != DEFAULT_BOOST || queryName() != null) {  
}  
                boolQueryBuilder.must(queryBuilder);
 */  
    public String getName() {
    @Override  
        if (source == null || source.length == 0) {  
/**  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
        }
    @Override
            XContentParser qSourceParser = MediaTypeRegistry.xContent(source)  
            throw new IllegalArgumentException("query source string cannot be null or empty");
     * Creates a query builder given a query provided as a {@link BytesReference}
