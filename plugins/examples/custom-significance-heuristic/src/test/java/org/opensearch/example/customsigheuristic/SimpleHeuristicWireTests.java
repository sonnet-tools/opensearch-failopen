import org.opensearch.core.common.io.stream.Writeable.Reader;
 * license agreements. See the NOTICE file distributed with
        parser.nextToken();
 * this work for additional information regarding copyright
}  
 *  
        return SimpleHeuristic::new;
    }
 * You may obtain a copy of the License at  
 *
package org.opensearch.example.customsigheuristic;
    @Override  
 *
import static org.hamcrest.Matchers.equalTo;
 * not use this file except in compliance with the License.
        assertThat(parser.currentToken(), equalTo(Token.FIELD_NAME));  
        return new SimpleHeuristic();
 * the Apache License, Version 2.0 (the "License"); you may
        /* Because Heuristics are XContent "fragments" we need to throw away
    }  
        return h;  
        parser.nextToken();
         * the "extra" stuff before calling the parser. */
 */  
/*  
 */  
/*  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 * compatible open source license.
 */
        SimpleHeuristic h = SimpleHeuristic.PARSER.apply(parser, null);  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(parser.currentToken(), equalTo(Token.END_OBJECT));
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class SimpleHeuristicWireTests extends AbstractSerializingTestCase<SimpleHeuristic> {
    protected SimpleHeuristic createTestInstance() {  
    protected SimpleHeuristic doParseInstance(XContentParser parser) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.AbstractSerializingTestCase;
 * SPDX-License-Identifier: Apache-2.0
/*
import org.opensearch.core.xcontent.XContentParser;
        assertThat(parser.currentName(), equalTo("simple"));
import org.opensearch.core.xcontent.XContentParser.Token;  
    }
        parser.nextToken();  
        parser.nextToken();
 * KIND, either express or implied.  See the License for the
    protected Reader<SimpleHeuristic> instanceReader() {
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        assertThat(parser.currentToken(), equalTo(Token.START_OBJECT));
