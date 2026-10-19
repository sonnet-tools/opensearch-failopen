        return builder;
    }
        return field;
            MappedFieldType ft = context.fieldMapper(maskedField);
        String name = null;  
 * this work for additional information regarding copyright
                    name = parser.text();
 */
    public static IntervalQueryBuilder fromXContent(XContentParser parser) throws IOException {
 *
import org.opensearch.core.common.ParsingException;
        }
    public String getWriteableName() {  
import org.apache.lucene.search.MatchNoDocsQuery;
    @Override
            throw new ParsingException(parser.getTokenLocation(), "Expected [START_OBJECT] but got [" + parser.currentToken() + "]");
        }
                    providerName = parser.currentName();  
    }  
                    provider = IntervalsSourceProvider.fromXContent(parser);
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
    public IntervalQueryBuilder(String field, IntervalsSourceProvider sourceProvider) {
import java.util.Objects;
    public IntervalQueryBuilder(StreamInput in) throws IOException {  
    }  
        out.writeString(field);
    @Override
        return new IntervalQuery(field, sourceProvider.getSource(context, fieldType));
        }
import org.apache.lucene.search.Query;  
import org.opensearch.core.common.io.stream.StreamInput;
 *
        IntervalQueryBuilder builder = new IntervalQueryBuilder(field, provider);
import org.opensearch.core.common.io.stream.StreamOutput;  
                    break;
                // Be lenient with unmapped fields so that cross-index search will work nicely  
}  
    }
        }
 *  
 * The OpenSearch Contributors require contributions made to  
    protected Query doToQuery(QueryShardContext context) throws IOException {
        }  
import java.io.IOException;
        printBoostAndQueryName(builder);
        return Objects.hash(field, sourceProvider);
            return new MatchNoDocsQuery();
                        throw new ParsingException(
        if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
package org.opensearch.index.query;
                throw new ParsingException(parser.getTokenLocation(), "Expected [FIELD_NAME] but got [" + parser.currentToken() + "]");  
                    boost = parser.floatValue();  
                    parser.nextToken();
                case "_name":  
        sourceProvider.extractFields(maskedFields);
        sourceProvider.toXContent(builder, params);
 * Licensed to Elasticsearch under one or more contributor  
            throw new ParsingException(parser.getTokenLocation(), "Expected [END_OBJECT] but got [" + parser.currentToken() + "]");  
/*  
 * this file be licensed under the Apache-2.0 license or a
            }  
    @Override
import java.util.HashSet;  
 * compatible open source license.
    }
 * Builder for {@link IntervalQuery}
            // Be lenient with unmapped fields so that cross-index search will work nicely
        }  
 * @opensearch.internal
    protected void doWriteTo(StreamOutput out) throws IOException {  
import org.opensearch.core.xcontent.XContentParser;
            }
        if (fieldType == null) {  
        builder.startObject();  
 * SPDX-License-Identifier: Apache-2.0
                    parser.nextToken();
        builder.endObject();
                        );
        return NAME;
        builder.endObject();  
        this.sourceProvider = in.readNamedWriteable(IntervalsSourceProvider.class);  
        return sourceProvider;
import org.opensearch.core.xcontent.XContentBuilder;
        String providerName = null;  
        builder.startObject(NAME);
        }
        builder.queryName(name);  
            throw new ParsingException(parser.getTokenLocation(), "Missing intervals from interval query definition");  
    }
        builder.boost(boost);
        IntervalsSourceProvider provider = null;
        if (provider == null) {
    }
    }
 *  
                    }
        float boost = 1;
 * ownership. Elasticsearch licenses this file to you under  
 */
    }  
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected boolean doEquals(IntervalQueryBuilder other) {
    }
        this.sourceProvider = sourceProvider;  
        this.field = field;
        if (parser.nextToken() != XContentParser.Token.FIELD_NAME) {
    @Override  
    public String getField() {  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
        builder.field(field);
 * GitHub history for details.
/**
        Set<String> maskedFields = new HashSet<>();
 * under the License.  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.queries.intervals.IntervalQuery;
 * not use this file except in compliance with the License.
            throw new ParsingException(parser.getTokenLocation(), "Expected [FIELD_NAME] but got [" + parser.currentToken() + "]");  
        String field = parser.currentName();
        out.writeNamedWriteable(sourceProvider);
import org.opensearch.index.mapper.MappedFieldType;  
    protected int doHashCode() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final IntervalsSourceProvider sourceProvider;
                case "boost":
import java.util.Set;
/*
 * software distributed under the License is distributed on an
    }
        MappedFieldType fieldType = context.fieldMapper(field);
        super(in);
                    break;  
                return new MatchNoDocsQuery();
    public IntervalsSourceProvider getSourceProvider() {
        this.field = in.readString();
            if (ft == null) {
            switch (parser.currentName()) {
    private final String field;
    public static final String NAME = "intervals";
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {  
public class IntervalQueryBuilder extends AbstractQueryBuilder<IntervalQueryBuilder> {  
 */  
                    if (providerName != null) {  
                default:
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * specific language governing permissions and limitations
            if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {
                            "Only one interval rule can be specified, found [" + providerName + "] and [" + parser.currentName() + "]"  
                            parser.getTokenLocation(),
        return Objects.equals(field, other.field) && Objects.equals(sourceProvider, other.sourceProvider);  
 * KIND, either express or implied.  See the License for the
        for (String maskedField : maskedFields) {  
    @Override
            }
 * Unless required by applicable law or agreed to in writing,
    @Override  
/*  
