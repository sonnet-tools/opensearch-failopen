 * software distributed under the License is distributed on an
}
import java.util.List;  
 *
            builder.endArray();  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testFromXContent() throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            builder.startArray("docs");
    }  
        List<TermVectorsResponse> responses = new ArrayList<>(numberOfResponses);
 *
        return new MultiTermVectorsResponse(responses);  
    protected MultiTermVectorsResponse createTestInstance() {
 * Unless required by applicable law or agreed to in writing,
 */
 * ownership. Elasticsearch licenses this file to you under  
        builder.endObject();
        List<TermVectorsResponse> termVectorsResponseList = response.getTermVectorsResponses();  
 * compatible open source license.
    }
 */  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 * under the License.  
import org.opensearch.core.xcontent.XContentBuilder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            TermVectorsResponse tvResponse = TermVectorsResponseTests.createTestInstance();  
                TermVectorsResponseTests.toXContent(tvr, builder);
package org.opensearch.client.core;
 */  
        xContentTester(this::createParser, this::createTestInstance, this::toXContent, MultiTermVectorsResponse::fromXContent)
            }
 * Licensed to Elasticsearch under one or more contributor  
            .supportsUnknownFields(true)
            for (TermVectorsResponse tvr : termVectorsResponseList) {  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;
 *  
            responses.add(tvResponse);
 * GitHub history for details.
            .test();
    }
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
            .randomFieldsExcludeFilter(field -> field.endsWith("term_vectors") || field.endsWith("terms") || field.endsWith("tokens"))  
import java.util.ArrayList;
        builder.startObject();
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < numberOfResponses; i++) {
/*  
    private void toXContent(MultiTermVectorsResponse response, XContentBuilder builder) throws IOException {
/*
/*  
 * specific language governing permissions and limitations
public class MultiTermVectorsResponseTests extends OpenSearchTestCase {
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;
        }
import java.io.IOException;
        if (termVectorsResponseList != null) {
 * You may obtain a copy of the License at  
        int numberOfResponses = randomIntBetween(0, 5);  
