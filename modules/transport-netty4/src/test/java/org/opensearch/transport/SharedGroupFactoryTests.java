}
import org.opensearch.test.OpenSearchTestCase;  
            assertSame(httpGroup.getLowLevelGroup(), transportGroup.getLowLevelGroup());
            .build();
            .put(Netty4HttpServerTransport.SETTING_HTTP_WORKER_COUNT.getKey(), randomIntBetween(1, 10))
    }
 *
        SharedGroupFactory.SharedGroup httpGroup = sharedGroupFactory.getHttpGroup();
 * this file be licensed under the Apache-2.0 license or a
            assertFalse(transportGroup.getLowLevelGroup().terminationFuture().isDone());
            assertTrue(transportGroup.getLowLevelGroup().isTerminated());  
/*  
    }  
/*  
 * You may obtain a copy of the License at  
        }
        SharedGroupFactory.SharedGroup transportGroup = sharedGroupFactory.getTransportGroup();
            assertTrue(transportGroup.getLowLevelGroup().terminationFuture().isDone());
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
        SharedGroupFactory sharedGroupFactory = new SharedGroupFactory(Settings.EMPTY);
 */
            assertFalse(transportGroup.getLowLevelGroup().isShuttingDown());
        } finally {  
        }  
 *
 * compatible open source license.
            assertTrue(httpGroup.getLowLevelGroup().isShuttingDown());
            transportGroup.shutdown();  
 */  
            assertTrue(transportGroup.getLowLevelGroup().terminationFuture().isDone());
 * software distributed under the License is distributed on an
        SharedGroupFactory.SharedGroup transportGroup = sharedGroupFactory.getTransportGroup();
        } finally {  
package org.opensearch.transport;
import org.opensearch.http.netty4.Netty4HttpServerTransport;
        SharedGroupFactory.SharedGroup httpGroup = sharedGroupFactory.getHttpGroup();
 */  
            assertFalse(transportGroup.getLowLevelGroup().isShuttingDown());  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
            assertFalse(transportGroup.getLowLevelGroup().isTerminated());  
 * under the License.  
            transportGroup.shutdown();
            assertNotSame(httpGroup.getLowLevelGroup(), transportGroup.getLowLevelGroup());
 * Unless required by applicable law or agreed to in writing,
    public void testSharedEventLoops() throws Exception {
            assertFalse(httpGroup.getLowLevelGroup().isShuttingDown());
            assertTrue(transportGroup.getLowLevelGroup().isShuttingDown());
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;
/*
            httpGroup.shutdown();
            assertTrue(httpGroup.getLowLevelGroup().terminationFuture().isDone());
            assertTrue(transportGroup.getLowLevelGroup().isShuttingDown());  
            assertTrue(httpGroup.getLowLevelGroup().isShuttingDown());
        Settings settings = Settings.builder()  
        try {
 *  
 * Modifications Copyright OpenSearch Contributors. See
            assertFalse(transportGroup.getLowLevelGroup().terminationFuture().isDone());
 * specific language governing permissions and limitations
public final class SharedGroupFactoryTests extends OpenSearchTestCase {
            httpGroup.shutdown();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testNonSharedEventLoops() throws Exception {
        try {
        SharedGroupFactory sharedGroupFactory = new SharedGroupFactory(settings);  
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertFalse(transportGroup.getLowLevelGroup().isTerminated());
            assertTrue(transportGroup.getLowLevelGroup().isTerminated());
            assertTrue(httpGroup.getLowLevelGroup().isTerminated());  
 * the Apache License, Version 2.0 (the "License"); you may
