 *
     * Read from a stream.
 */  
/*  
    @Override
    }
import org.opensearch.search.approximate.ApproximateScoreQuery;
public class MatchAllQueryBuilder extends AbstractQueryBuilder<MatchAllQueryBuilder> {
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
        try {
    private static final ObjectParser<MatchAllQueryBuilder, Void> PARSER = new ObjectParser<>(NAME, MatchAllQueryBuilder::new);
/**
        } catch (IllegalArgumentException e) {
    protected Query doToQuery(QueryShardContext context) {
    }
/*  
 * not use this file except in compliance with the License.
    @Override  
 */  
        }  
}
        return NAME;
 * GitHub history for details.
        printBoostAndQueryName(builder);  
 * Modifications Copyright OpenSearch Contributors. See
    }
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
        builder.endObject();
    }  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.ParsingException;  
    protected void doWriteTo(StreamOutput out) {
        builder.startObject(NAME);
 * SPDX-License-Identifier: Apache-2.0
        // only superclass has state  
        return new ApproximateScoreQuery(Queries.newMatchAllQuery(), new ApproximateMatchAllQuery());
    public MatchAllQueryBuilder(StreamInput in) throws IOException {  
    public static MatchAllQueryBuilder fromXContent(XContentParser parser) {
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
    /**  
     */
import org.opensearch.core.common.io.stream.StreamInput;
import org.apache.lucene.search.Query;
            throw new ParsingException(parser.getTokenLocation(), e.getMessage(), e);
import java.io.IOException;  
    public MatchAllQueryBuilder() {}
    }
 *
    protected int doHashCode() {
            return PARSER.apply(parser, null);  
    @Override  
 *  
import org.opensearch.common.lucene.search.Queries;
    }
    }  
    public static final String NAME = "match_all";
 * A query that matches on all documents.  
import org.opensearch.core.xcontent.ObjectParser;  
    }
import org.opensearch.search.approximate.ApproximateMatchAllQuery;  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        return 0;  
 * The OpenSearch Contributors require contributions made to  
    @Override
        super(in);
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
    @Override  
 *
 * the Apache License, Version 2.0 (the "License"); you may
    static {  
 * KIND, either express or implied.  See the License for the
        declareStandardFields(PARSER);
 * compatible open source license.
    }
    public String getWriteableName() {
package org.opensearch.index.query;
import org.opensearch.core.xcontent.XContentParser;
    protected boolean doEquals(MatchAllQueryBuilder other) {  
        return true;
 * software distributed under the License is distributed on an
 */
 * this work for additional information regarding copyright
