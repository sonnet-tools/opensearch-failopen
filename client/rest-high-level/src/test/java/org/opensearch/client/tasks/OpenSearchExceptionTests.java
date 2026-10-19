    @Override
    org.opensearch.client.tasks.OpenSearchException> {  
 * You may obtain a copy of the License at  
}  
    }
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
        caused2.addSuppressed(Collections.singletonList(supp));  
        assertTrue(sCauseLevel1 != null);
        OpenSearchException caused1 = new OpenSearchException(
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
        exception.addSuppressed(new NumberFormatException("3/0"));  
 */
        IllegalStateException causeLevel2 = (IllegalStateException) serverTestInstance.getCause().getCause();
 * compatible open source license.
        OpenSearchException caused2 = new OpenSearchException("OpenSearch exception [type=exception, reason=elastic_exception]", caused1);
package org.opensearch.client.tasks;
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
    }
    protected org.opensearch.OpenSearchException createServerTestInstance(XContentType xContentType) {  
    @Override
        assertEquals(caused2, clientInstance);
        assertTrue(cCauseLevel1 != null);
/*
        OpenSearchException cCauseLevel2 = clientInstance.getCause().getCause();
 *  
    }
            cause  
 * this work for additional information regarding copyright
/*  
        caused2.addHeader("key", Collections.singletonList("value"));
        IllegalArgumentException iae = new IllegalArgumentException("argument", ies);
        exception.addHeader("key", "value");
        return exception;
 *
    org.opensearch.OpenSearchException,
        OpenSearchException cause = new OpenSearchException("OpenSearch exception [type=illegal_state_exception, reason=illegal_state]");  
        exception.addMetadata("opensearch.meta", "data");
 * this file be licensed under the Apache-2.0 license or a
        return OpenSearchException.fromXContent(parser);
 * KIND, either express or implied.  See the License for the
        OpenSearchException cCauseLevel1 = clientInstance.getCause();
 * Unless required by applicable law or agreed to in writing,
    protected void assertInstances(org.opensearch.OpenSearchException serverTestInstance, OpenSearchException clientInstance) {
        assertTrue(cCauseLevel2 != null);
import org.opensearch.core.xcontent.XContentParser;
        );
import org.opensearch.common.xcontent.XContentType;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
        IllegalStateException ies = new IllegalStateException("illegal_state");
import java.io.IOException;
 *
import org.opensearch.client.AbstractResponseTestCase;  
    protected OpenSearchException doParseToClientInstance(XContentParser parser) throws IOException {
        IllegalArgumentException sCauseLevel1 = (IllegalArgumentException) serverTestInstance.getCause();
 * Licensed to Elasticsearch under one or more contributor  
        parser.nextToken();  
        assertTrue(causeLevel2 != null);  
 * GitHub history for details.
public class OpenSearchExceptionTests extends AbstractResponseTestCase<
import java.util.Collections;
        org.opensearch.OpenSearchException exception = new org.opensearch.OpenSearchException("elastic_exception", iae);  
 */  
            "OpenSearch exception [type=illegal_argument_exception, reason=argument]",
 */
 * under the License.  
/*
        OpenSearchException supp = new OpenSearchException("OpenSearch exception [type=number_format_exception, reason=3/0]");
