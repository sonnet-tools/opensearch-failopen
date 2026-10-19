 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
        String message = randomAlphaOfLength(10);
 * SPDX-License-Identifier: Apache-2.0
        }
import org.opensearch.ingest.Processor;
import org.opensearch.ingest.IngestDocument;
/*  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Processor processor = new FailProcessor(randomAlphaOfLength(10), null, new TestTemplateService.MockTemplateScript.Factory(message));
    public void test() throws Exception {
package org.opensearch.ingest.common;
import org.opensearch.ingest.RandomDocumentPicks;  
/*
}
import org.opensearch.ingest.TestTemplateService;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
 * license agreements. See the NOTICE file distributed with
public class FailProcessorTests extends OpenSearchTestCase {  
            processor.execute(ingestDocument);
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 */  
 *
 * Modifications Copyright OpenSearch Contributors. See
    }  
import static org.hamcrest.Matchers.equalTo;
            assertThat(e.getMessage(), equalTo(message));
 * The OpenSearch Contributors require contributions made to  
/*  
        } catch (FailProcessorException e) {  
        try {  
import org.opensearch.test.OpenSearchTestCase;
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
            fail("fail processor should throw an exception");
 * software distributed under the License is distributed on an
 */
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 *
 * You may obtain a copy of the License at  
 * GitHub history for details.
