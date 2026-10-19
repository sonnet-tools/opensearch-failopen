 * The OpenSearch Contributors require contributions made to  
        return createRandomQueryExplanation(randomBoolean());
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
/*  
    }
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
import org.opensearch.core.common.io.stream.Writeable;
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
    protected QueryExplanation doParseInstance(XContentParser parser) throws IOException {
        return createRandomQueryExplanation();
 * software distributed under the License is distributed on an
 */  
        return new QueryExplanation(index, shard, valid, explanation, errorField);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
}  
 */  
        if (!valid) {
    static QueryExplanation createRandomQueryExplanation() {  
        String errorField = null;
 *
 * license agreements. See the NOTICE file distributed with
        int shard = randomInt(100);
    @Override  
        return QueryExplanation.fromXContent(parser);  
    protected Writeable.Reader<QueryExplanation> instanceReader() {  
 * the Apache License, Version 2.0 (the "License"); you may
        String index = "index_" + randomInt(1000);
    @Override
    protected QueryExplanation createTestInstance() {
    }
package org.opensearch.action.admin.indices.validate.query;
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 *  
        Boolean valid = isValid;  
    }  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.AbstractSerializingTestCase;  
 * KIND, either express or implied.  See the License for the
/*  
import org.opensearch.core.xcontent.XContentParser;
            errorField = randomAlphaOfLength(randomIntBetween(10, 100));  
    static QueryExplanation createRandomQueryExplanation(boolean isValid) {  
        return QueryExplanation::new;
        }
        String explanation = randomAlphaOfLength(randomIntBetween(10, 100));
    @Override
 */
    }
 * You may obtain a copy of the License at  
 *
    }
/*
public class QueryExplanationTests extends AbstractSerializingTestCase<QueryExplanation> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
