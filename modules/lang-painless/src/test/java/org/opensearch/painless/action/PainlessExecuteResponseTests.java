import org.opensearch.core.xcontent.XContentParser;
 * KIND, either express or implied.  See the License for the
 *
            case 0:
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.painless.action;
                result = parser.doubleValue();
 * ownership. Elasticsearch licenses this file to you under  
        Object result;  
                throw new IOException("invalid response");
import java.io.IOException;
    @Override
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
                break;
    }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        switch (randomIntBetween(0, 2)) {
 * this work for additional information regarding copyright
                break;
 * SPDX-License-Identifier: Apache-2.0
                throw new IllegalStateException("invalid branch");  
 * under the License.  
import org.opensearch.test.AbstractSerializingTestCase;
                result = randomDoubleBetween(-10, 10, true);  
            case 1:
/*
    @Override
                result = parser.booleanValue();
    }  
    protected PainlessExecuteAction.Response createTestInstance() {
 * the Apache License, Version 2.0 (the "License"); you may
/*
            case 2:
        switch (token) {
        XContentParser.Token token = parser.nextToken(); // result value  
 */
}
    protected Writeable.Reader<PainlessExecuteAction.Response> instanceReader() {  
 */  
 * compatible open source license.
 * GitHub history for details.
    @Override
        parser.nextToken(); // START-OBJECT
/*  
                result = randomAlphaOfLength(10);  
        return PainlessExecuteAction.Response::new;
                break;
            case VALUE_BOOLEAN:  
                break;
            default:
                break;
 * Modifications Copyright OpenSearch Contributors. See  
        return new PainlessExecuteAction.Response(result);
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            case VALUE_STRING:  
                break;
        parser.nextToken(); // FIELD-NAME
        }
        Object result;
            default:  
 * You may obtain a copy of the License at  
    }
    protected PainlessExecuteAction.Response doParseInstance(XContentParser parser) throws IOException {  
 * specific language governing permissions and limitations
                result = randomBoolean();  
        return new PainlessExecuteAction.Response(result);  
 *  
import org.opensearch.core.common.io.stream.Writeable;  
 * software distributed under the License is distributed on an
            case VALUE_NUMBER:  
                result = parser.text();
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 */
public class PainlessExecuteResponseTests extends AbstractSerializingTestCase<PainlessExecuteAction.Response> {  
