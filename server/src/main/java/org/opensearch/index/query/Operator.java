 */
        return new IllegalArgumentException(
import org.apache.lucene.search.BooleanClause;
import org.opensearch.core.common.io.stream.Writeable;
 *
 * license agreements. See the NOTICE file distributed with
    OR,
/*
 *
 */
public enum Operator implements Writeable {  
    public BooleanClause.Occur toBooleanClauseOccur() {
        out.writeEnum(this);
                return BooleanClause.Occur.SHOULD;
    AND;
                return QueryParser.Operator.OR;  
/*  
 * specific language governing permissions and limitations
    }
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
/**
            case OR:
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
    public QueryParser.Operator toQueryParserOperator() {  
        );  
        switch (this) {
    public void writeTo(StreamOutput out) throws IOException {
 * Unless required by applicable law or agreed to in writing,
 * Boolean operators
    }
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            case AND:
            default:  
 * compatible open source license.
 */
}
import org.opensearch.core.common.io.stream.StreamInput;
 * not use this file except in compliance with the License.
    public static Operator readFromStream(StreamInput in) throws IOException {
    }  
 * The OpenSearch Contributors require contributions made to  
        }  
                return QueryParser.Operator.AND;
            case AND:
 * software distributed under the License is distributed on an
                throw Operator.newOperatorException(this.toString());
 *  
                throw Operator.newOperatorException(this.toString());
    public static Operator fromString(String op) {
/*
        return valueOf(op.toUpperCase(Locale.ROOT));  
    public static IllegalArgumentException newOperatorException(String op) {  
package org.opensearch.index.query;
 * this work for additional information regarding copyright
 */  
 * Modifications Copyright OpenSearch Contributors. See  
        return in.readEnum(Operator.class);  
    }
            case OR:  
 * SPDX-License-Identifier: Apache-2.0
            "operator needs to be either " + CollectionUtils.arrayAsArrayList(values()) + ", but not [" + op + "]"
import java.util.Locale;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
                return BooleanClause.Occur.MUST;  
import org.opensearch.core.common.util.CollectionUtils;
 * @opensearch.internal
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
            default:
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
        }
 * under the License.  
    @Override  
        switch (this) {
    }  
import org.apache.lucene.queryparser.classic.QueryParser;  
