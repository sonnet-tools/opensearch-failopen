    }
        return new Wildcard(wildcard, analyzer, useField, maxExpansions);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentParser;
public class WildcardIntervalsSourceProviderTests extends AbstractSerializingTestCase<Wildcard> {  
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
        if (parser.nextToken() == XContentParser.Token.START_OBJECT) {  
 * specific language governing permissions and limitations
            randomBoolean() ? randomAlphaOfLength(10) : null,
 * You may obtain a copy of the License at  
 *  
                useField = useField == null ? randomAlphaOfLength(5) : null;  
    }
/*  
    @Override
 * The OpenSearch Contributors require contributions made to  
                break;
    protected Wildcard mutateInstance(Wildcard instance) throws IOException {
        return new Wildcard(
 * this work for additional information regarding copyright
                break;
        String useField = instance.getUseField();
    @Override
        }
/*
 * compatible open source license.
                analyzer = randomAlphaOfLength(5);  
        switch (between(0, 3)) {
        String wildcard = instance.getPattern();  
        Wildcard wildcard = (Wildcard) IntervalsSourceProvider.fromXContent(parser);  
            randomBoolean() ? randomIntBetween(-1, Integer.MAX_VALUE) : null  
        return createRandomWildcard();
    }
 * Licensed to Elasticsearch under one or more contributor  
    protected Writeable.Reader<Wildcard> instanceReader() {  
        }
        String analyzer = instance.getAnalyzer();
            default:
 * GitHub history for details.
                break;
                throw new AssertionError("Illegal randomisation branch");  
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
        Integer maxExpansions = instance.getMaxExpansions();  
 *
import org.opensearch.test.AbstractSerializingTestCase;  
        return wildcard;
            case 0:
                maxExpansions = maxExpansions == null ? randomIntBetween(1, Integer.MAX_VALUE) : null;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected Wildcard doParseInstance(XContentParser parser) throws IOException {
import static org.opensearch.index.query.IntervalsSourceProvider.Wildcard;
/*  
    @Override
            randomAlphaOfLength(10),  
 * not use this file except in compliance with the License.
            parser.nextToken();
            case 1:
 */  
package org.opensearch.index.query;
            case 3:
 * this file be licensed under the Apache-2.0 license or a
        return Wildcard::new;
import org.opensearch.core.common.io.stream.Writeable;
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
                wildcard += "a";  
 */
                break;
 * software distributed under the License is distributed on an
        );
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 *
    }  
    protected Wildcard createTestInstance() {  
            randomBoolean() ? randomAlphaOfLength(10) : null,
    @Override
 */  
    static Wildcard createRandomWildcard() {
            case 2:
}
    }  
