            encoder.quoteAsString((String) testQuery.value(), sb);  
    @Override
        boolean isString = testQuery.value() instanceof String;
 * under the License.  
 * KIND, either express or implied.  See the License for the
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (isString) {  
            + "    \""  
 * the Apache License, Version 2.0 (the "License"); you may
            + testQuery.getName()
 */  
            final StringBuilder sb = new StringBuilder();
        assertEquals("field name is null or empty", e.getMessage());
import java.util.Map;
            JsonStringEncoder encoder = JsonStringEncoder.getInstance();
            + testQuery.fieldName()
/*
        HashMap<String, QB> alternateVersions = new HashMap<>();
 * ownership. Elasticsearch licenses this file to you under  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createQueryBuilder(null, term));
            value = testQuery.value();  
        assertEquals("field name is null or empty", e.getMessage());  
package org.opensearch.index.query;
    protected Map<String, QB> getAlternateVersions() {  
 * license agreements. See the NOTICE file distributed with
            + "\n"
        QB testQuery = createQueryBuilder(tempQuery.fieldName(), tempQuery.value());  
            + "    }\n"
            value = "\"" + sb.toString() + "\"";
        return alternateVersions;
}
 *
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        String contentString = "{\n"
 * The OpenSearch Contributors require contributions made to  
        String term = randomAlphaOfLengthBetween(1, 30);
public abstract class AbstractTermQueryTestCase<QB extends BaseTermQueryBuilder<QB>> extends AbstractQueryTestCase<QB> {
        e = expectThrows(IllegalArgumentException.class, () -> createQueryBuilder("", term));
 * software distributed under the License is distributed on an
            + "\" : "
 *
import tools.jackson.core.io.JsonStringEncoder;  
import java.util.HashMap;  
 * GitHub history for details.
        }
        Object value;
/*  
    public void testIllegalArguments() throws QueryShardException {  
    }  
    }  
import org.opensearch.test.AbstractQueryTestCase;
 * You may obtain a copy of the License at  
        QB tempQuery = createTestQueryBuilder();
        } else {
            + "        \""  
            + "}";  
 */  
 * Unless required by applicable law or agreed to in writing,
    protected abstract QB createQueryBuilder(String fieldName, Object value);
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * this work for additional information regarding copyright
 */
            + "\" : {\n"
        alternateVersions.put(contentString, testQuery);
            + value  
