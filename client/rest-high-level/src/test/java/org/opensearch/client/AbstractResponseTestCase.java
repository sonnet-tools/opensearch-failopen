    public final void testFromXContent() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See  
 * This case class facilitates generating server side response test instances and
/*  
 * You may obtain a copy of the License at  
            LoggingDeprecationHandler.INSTANCE,  
            bytes.streamInput()
    /**
package org.opensearch.client;
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
        final BytesReference bytes = toShuffledXContent(serverTestInstance, xContentType, getParams(), randomBoolean());
 * software distributed under the License is distributed on an
 * <p>
     * @return The params used when generated the xcontent from server side test instance as bytes
    /**  
     * @return The server side test instance to will be serialized as xcontent to be used to parse client side response class.
        final XContentType xContentType = randomFrom(XContentType.values());
        final XContent xContent = xContentType.xContent();  
    }
    protected abstract void assertInstances(S serverTestInstance, C clientInstance);
/**
        final XContentParser parser = xContent.createParser(
 * ownership. Elasticsearch licenses this file to you under  
 *
 * Licensed to Elasticsearch under one or more contributor  
     * @param xContentType The xcontent type that will be used to serialize the test instance.
     * Assert that the server instance and client instance contain the same content.
    protected ToXContent.Params getParams() {  
    protected abstract S createServerTestInstance(XContentType xContentType);
}  
 *
        final S serverTestInstance = createServerTestInstance(xContentType);  
 * the Apache License, Version 2.0 (the "License"); you may
     * @param clientInstance     The client side instance that was created by {@link #doParseToClientInstance(XContentParser)}
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 * @param <C> The class representing the response on the client side.  
/*
 * @param <S> The class representing the response on the server side.
        assertInstances(serverTestInstance, clientInstance);
import org.opensearch.core.xcontent.ToXContent;
 */
 * The OpenSearch Contributors require contributions made to  
     */  
    /**  
     */  
     * @return The client side instance that is parsed from the xcontent generated from the server side test instance.
        );
 * license agreements. See the NOTICE file distributed with
/*
     *  
 */  
     * @param serverTestInstance The server side instance that was created by {@link #createServerTestInstance(XContentType)}
     * @param parser The xcontent parser
import org.opensearch.core.xcontent.XContentParser;  
    protected abstract C doParseToClientInstance(XContentParser parser) throws IOException;
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.core.common.bytes.BytesReference;
            NamedXContentRegistry.EMPTY,
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 *
        final C clientInstance = doParseToClientInstance(parser);  
 *  
 */
     *                     This is parameter is needed if the test instance contains serialized xcontent as bytes or string.  
     * Typically by asserting whether each property of both instances are equal to each other.
        return ToXContent.EMPTY_PARAMS;
import java.io.IOException;  
import org.opensearch.test.OpenSearchTestCase;
 */
 * verifies that they are correctly parsed into HLRC response instances.  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Base class for HLRC response parsing tests.  
    /**  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
     *
     */  
 * compatible open source license.
import org.opensearch.core.xcontent.XContent;
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
 * KIND, either express or implied.  See the License for the
public abstract class AbstractResponseTestCase<S extends ToXContent, C> extends OpenSearchTestCase {
