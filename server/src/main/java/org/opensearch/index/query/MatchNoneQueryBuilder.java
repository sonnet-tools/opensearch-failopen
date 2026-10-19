    @Override
        MatchNoneQueryBuilder matchNoneQueryBuilder = new MatchNoneQueryBuilder();
    }
    public MatchNoneQueryBuilder() {}
    @Override
 * You may obtain a copy of the License at  
    public static MatchNoneQueryBuilder fromXContent(XContentParser parser) throws IOException {
    }
        matchNoneQueryBuilder.queryName(queryName);  
                    queryName = parser.text();
 * ownership. Elasticsearch licenses this file to you under  
        return 0;
                        "[" + MatchNoneQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"
                currentFieldName = parser.currentName();
                } else {
        builder.startObject(NAME);
 *
 * this work for additional information regarding copyright
        return matchNoneQueryBuilder;
/*  
 */  
                    );  
            } else if (token.isValue()) {  
        printBoostAndQueryName(builder);  
                        parser.getTokenLocation(),
        // all state is in the superclass  
 * Modifications Copyright OpenSearch Contributors. See
    public String getWriteableName() {
import org.apache.lucene.search.Query;
 * this file be licensed under the Apache-2.0 license or a
        return true;
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
public class MatchNoneQueryBuilder extends AbstractQueryBuilder<MatchNoneQueryBuilder> {
                if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected boolean doEquals(MatchNoneQueryBuilder other) {
 * not use this file except in compliance with the License.
                throw new ParsingException(  
        matchNoneQueryBuilder.boost(boost);
    }
    protected int doHashCode() {  
    }
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
     * Read from a stream.
                    throw new ParsingException(  
package org.opensearch.index.query;
    @Override  
 *  
        while (((token = parser.nextToken()) != XContentParser.Token.END_OBJECT && token != XContentParser.Token.END_ARRAY)) {  
/*
 * The OpenSearch Contributors require contributions made to  
        String currentFieldName = null;
            if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.core.xcontent.XContentBuilder;  
 */  
 */  
import java.io.IOException;  
/*  
import org.opensearch.core.xcontent.XContentParser;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.lucene.search.Queries;
        XContentParser.Token token;  
        super(in);
 * license agreements. See the NOTICE file distributed with
}
    public static final String NAME = "match_none";
 */
import org.opensearch.core.common.io.stream.StreamOutput;
                    boost = parser.floatValue();
/**
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.ParsingException;  
            } else {
        builder.endObject();
    public MatchNoneQueryBuilder(StreamInput in) throws IOException {  
        return Queries.newMatchNoDocsQuery("User requested \"" + this.getName() + "\" query.");  
 * specific language governing permissions and limitations
    }  
 * under the License.  
                );  
import org.opensearch.core.common.io.stream.StreamInput;
 *
 * the Apache License, Version 2.0 (the "License"); you may
     */
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
    }
                }
 * GitHub history for details.
                    "[" + MatchNoneQueryBuilder.NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
        }
 * Licensed to Elasticsearch under one or more contributor  
    }
                    parser.getTokenLocation(),
        return NAME;  
    /**  
    @Override
            }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    protected void doWriteTo(StreamOutput out) throws IOException {
 * A query that matches no document.  
        String queryName = null;
    @Override  
    protected Query doToQuery(QueryShardContext context) throws IOException {
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
    }
 * @opensearch.internal
