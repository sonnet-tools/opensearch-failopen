    /**
 * compatible open source license.
import org.opensearch.core.xcontent.ToXContent;
            parser.nextToken();
     */
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.xcontent.XContentFactory;
public abstract class QueryContextTestCase<QC extends ToXContent> extends OpenSearchTestCase {  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
            QC fromXContext = fromXContent(parser);
 * KIND, either express or implied.  See the License for the
/*  
 */  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
            toXContent.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentParser;
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final int NUMBER_OF_RUNS = 20;
        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
import org.opensearch.core.xcontent.XContentBuilder;  
 */
 *
}
     */
 */  
    /**  
            QC toXContent = createTestModel();  
import org.opensearch.test.OpenSearchTestCase;
 * ownership. Elasticsearch licenses this file to you under  
    protected abstract QC fromXContent(XContentParser parser) throws IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.search.suggest.completion;
            XContentBuilder builder = XContentFactory.jsonBuilder();
/*  
            assertEquals(toXContent, fromXContext);  
 * under the License.  
     * read the context  
    }  
 * SPDX-License-Identifier: Apache-2.0
    protected abstract QC createTestModel();  
 *  
/*
 * The OpenSearch Contributors require contributions made to  
     * create random model that is put under test
 *
    public void testToXContext() throws IOException {
 * license agreements. See the NOTICE file distributed with
            assertEquals(toXContent.hashCode(), fromXContext.hashCode());
            XContentParser parser = createParser(builder);  
 * Unless required by applicable law or agreed to in writing,
        }
