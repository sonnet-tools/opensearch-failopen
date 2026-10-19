 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * GitHub history for details.
 *  
 *
import org.opensearch.core.common.bytes.BytesReference;
                1,
                    true,
            builder.field("field", 1);
 */
import static org.hamcrest.Matchers.equalTo;
 * license agreements. See the NOTICE file distributed with
        BytesReference insertRandomFieldsAndShuffle = RandomizedContext.current()
        XContentBuilder builder = XContentFactory.jsonBuilder();
}
public class AbstractXContentTestCaseTests extends OpenSearchTestCase {
import org.opensearch.core.xcontent.MediaTypeRegistry;
                )  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
                () -> AbstractXContentTestCase.insertRandomFieldsAndShuffle(
/*  
        builder.startObject();  
import org.opensearch.core.xcontent.XContentParser;
import static org.hamcrest.Matchers.not;  
 *
 * compatible open source license.
/*  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.XContentBuilder;  
 */  
        try (XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), insertRandomFieldsAndShuffle)) {
 * this file be licensed under the Apache-2.0 license or a
                    BytesReference.bytes(builder),  
                    this::createParser
import org.opensearch.common.xcontent.XContentFactory;  
        }  
import com.carrotsearch.randomizedtesting.RandomizedContext;
package org.opensearch.test;
            assertThat(mapOrdered.size(), equalTo(2));
            );
        builder.endObject();
 * Unless required by applicable law or agreed to in writing,
    }
    public void testInsertRandomFieldsAndShuffle() throws Exception {
 * this work for additional information regarding copyright
/*
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
        {
            assertThat(mapOrdered.keySet().iterator().next(), not(equalTo("field")));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
                    MediaTypeRegistry.JSON,
        }  
 * under the License.  
            Map<String, Object> mapOrdered = parser.mapOrdered();  
                    new String[] {},  
            .runWithPrivateRandomness(  
 * software distributed under the License is distributed on an
import java.util.Map;  
                    null,
