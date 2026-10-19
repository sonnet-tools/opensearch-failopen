            assertThat(parser.currentToken(), nullValue());  
 * license agreements. See the NOTICE file distributed with
 */  
import static org.hamcrest.Matchers.nullValue;  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
            assertThat(parser.nextToken(), nullValue());
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
    public void tearDown() throws Exception {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 *
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
    protected XContentParser parser;  
/*  
/**
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
    }
        if (parser != null) {
 *  
            parser.close();  
/*  
public abstract class AbstractClientYamlTestFragmentParserTestCase extends OpenSearchTestCase {
    @After  
import org.junit.After;
    }
 * this file be licensed under the Apache-2.0 license or a
        super.tearDown();
        }
        // test may be skipped so we did not create a parser instance  
    @Override
import org.opensearch.test.OpenSearchTestCase;  
        return ExecutableSection.XCONTENT_REGISTRY;  
/*
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.test.rest.yaml.section;
 * GitHub history for details.
            // next token can be null even in the middle of the document (e.g. with "---"), but not too many consecutive times
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.NamedXContentRegistry;
    protected NamedXContentRegistry xContentRegistry() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentParser;
 */  
 */
    @Override
 */
 *
 * You may obtain a copy of the License at  
}
 * Superclass for tests that parse parts of the test suite.  
            assertThat(parser.nextToken(), nullValue());
