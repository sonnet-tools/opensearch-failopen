        return new Prefix(prefix, analyzer, useField);
import java.io.IOException;
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
        return prefix;
 * not use this file except in compliance with the License.
            case 0:
            randomAlphaOfLength(10),
import org.opensearch.core.common.io.stream.Writeable;
    @Override
 * this work for additional information regarding copyright
    protected Prefix createTestInstance() {  
        return Prefix::new;
 */
}
    @Override
    }  
 */  
 * ownership. Elasticsearch licenses this file to you under  
                analyzer = randomAlphaOfLength(5);  
                break;
package org.opensearch.index.query;
 *
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.XContentParser;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                break;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.AbstractSerializingTestCase;  
    }  
            case 1:
/*  
            parser.nextToken();
 * under the License.  
    @Override
            randomBoolean() ? randomAlphaOfLength(10) : null,  
            case 2:
public class PrefixIntervalsSourceProviderTests extends AbstractSerializingTestCase<Prefix> {  
 * the Apache License, Version 2.0 (the "License"); you may
                prefix += "a";  
    }
 * compatible open source license.
        String prefix = instance.getPrefix();
        return new Prefix(
        );
 * Unless required by applicable law or agreed to in writing,
            default:
 * Modifications Copyright OpenSearch Contributors. See
 */  
    protected Writeable.Reader<Prefix> instanceReader() {  
 * this file be licensed under the Apache-2.0 license or a
                throw new AssertionError("Illegal randomisation branch");  
                useField = useField == null ? randomAlphaOfLength(5) : null;  
        if (parser.nextToken() == XContentParser.Token.START_OBJECT) {  
                break;
    protected Prefix mutateInstance(Prefix instance) throws IOException {  
 *
 * Licensed to Elasticsearch under one or more contributor  
        String analyzer = instance.getAnalyzer();
        assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
 * software distributed under the License is distributed on an
        String useField = instance.getUseField();  
 * GitHub history for details.
/*
            randomBoolean() ? randomAlphaOfLength(10) : null
/*  
import static org.opensearch.index.query.IntervalsSourceProvider.Prefix;
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        }
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
    @Override
    }  
        switch (between(0, 2)) {
        }
    protected Prefix doParseInstance(XContentParser parser) throws IOException {
        Prefix prefix = (Prefix) IntervalsSourceProvider.fromXContent(parser);  
