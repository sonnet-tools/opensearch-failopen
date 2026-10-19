 */
    }  
 * Licensed to Elasticsearch under one or more contributor  
            }
public class CborXContentParserTests extends OpenSearchTestCase {
}
import org.opensearch.core.common.bytes.BytesReference;
 *  
        BytesReference ref = BytesReference.bytes(XContentFactory.cborBuilder().startObject().field("field", "").endObject());
 * Unless required by applicable law or agreed to in writing,
/*
        }
 * compatible open source license.
 */  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
package org.opensearch.common.xcontent.cbor;
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
            // Running this part twice triggers the issue.
 * not use this file except in compliance with the License.
/*  
 * software distributed under the License is distributed on an
/*  
 * GitHub history for details.
        for (int i = 0; i < 2; i++) {  
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
                while (parser.nextToken() != null) {
import org.opensearch.test.OpenSearchTestCase;
 *
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentParser;  
                }  
            // See https://github.com/elastic/elasticsearch/issues/8629
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
            try (XContentParser parser = createParser(CborXContent.cborXContent, ref)) {  
import org.opensearch.common.xcontent.XContentFactory;
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
                    parser.charBuffer();
 * ownership. Elasticsearch licenses this file to you under  
    public void testEmptyValue() throws IOException {  
