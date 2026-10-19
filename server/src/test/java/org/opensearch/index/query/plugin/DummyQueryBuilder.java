}
        builder.startObject(NAME).endObject();
    public DummyQueryBuilder(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
 */
    @Override
    }
    @Override  
    @Override  
        XContentParser.Token token = parser.nextToken();
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        return new DummyQueryBuilder();
 */  
 */  
import org.opensearch.core.xcontent.XContentBuilder;
        return true;
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
/*
    @Override
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
 * under the License.  
        return 0;
    public String getWriteableName() {
public class DummyQueryBuilder extends AbstractQueryBuilder<DummyQueryBuilder> {  
import org.opensearch.index.query.plugin.DummyQueryParserPlugin.DummyQuery;
        super(in);  
 * You may obtain a copy of the License at  
import org.opensearch.index.query.AbstractQueryBuilder;  
 * this work for additional information regarding copyright
    }
    public static DummyQueryBuilder fromXContent(XContentParser parser) throws IOException {
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;
    protected Query doToQuery(QueryShardContext context) throws IOException {
import org.apache.lucene.search.Query;
    }  
        return NAME;  
    }
package org.opensearch.index.query.plugin;
 *
    public DummyQueryBuilder() {}  
    protected int doHashCode() {
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
/*  
    }
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
    protected void doWriteTo(StreamOutput out) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new DummyQuery();  
    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
        assert token == XContentParser.Token.END_OBJECT;  
        // only the superclass has state
 * GitHub history for details.
/*  
 *  
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    protected boolean doEquals(DummyQueryBuilder other) {  
 * ownership. Elasticsearch licenses this file to you under  
 *
import org.opensearch.index.query.QueryShardContext;
    public static final String NAME = "dummy";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
