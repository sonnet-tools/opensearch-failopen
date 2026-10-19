/*  
    /**
            if (threadName.contains(s)) {
        assert requestHeaders.isEmpty() || Task.REQUEST_HEADERS.containsAll(requestHeaders.keySet()) : "expected empty context but was "
            TEST_MOCK_TRANSPORT_THREAD_PREFIX
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final String threadName = t.getName();
public enum Transports {
 * Modifications Copyright OpenSearch Contributors. See
        return true;
            + Thread.currentThread().getName();
 * @opensearch.internal
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 */  
    public static boolean assertTransportThread() {
        assert isTransportThread(t) == false : "Expected current thread [" + t + "] to not be a transport thread. Reason: [" + reason + "]";
            HttpServerTransport.HTTP_SERVER_WORKER_THREAD_NAME_PREFIX,  
 * You may obtain a copy of the License at  
/*  
        final Map<String, String> requestHeaders = threadContext.getRequestHeadersOnly();  
 * this work for additional information regarding copyright
    ;
 */  
 * not use this file except in compliance with the License.
            + requestHeaders
 */
        final Thread t = Thread.currentThread();  
 *
 * under the License.  
     */
     * networking threads.
            + " on "  
    }  
/**
 *
import java.util.Arrays;
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
    }  
 * The OpenSearch Contributors require contributions made to  
        for (String s : Arrays.asList(
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    public static final String TEST_MOCK_TRANSPORT_THREAD_PREFIX = "__mock_network_thread";
        return true;
    public static boolean assertNotTransportThread(String reason) {
import java.util.Map;  
            }  
     * Utility method to detect whether a thread is a network thread. Typically
 */  
        return true;
                return true;
    public static boolean isTransportThread(Thread t) {  
    }  
        return false;
     * used in assertions to make sure that we do not call blocking code from  
        )) {  
    }  
        assert isTransportThread(t) : "Expected transport thread but got [" + t + "]";
        }
import org.opensearch.tasks.Task;  
 * Licensed to Elasticsearch under one or more contributor  
 * Utility class for transport  
import org.opensearch.http.HttpServerTransport;
 * compatible open source license.
    /** threads whose name is prefixed by this string will be considered network threads, even though they aren't */
 * specific language governing permissions and limitations
import org.opensearch.common.util.concurrent.ThreadContext;
            TcpTransport.TRANSPORT_WORKER_THREAD_NAME_PREFIX,
 * SPDX-License-Identifier: Apache-2.0
        final Thread t = Thread.currentThread();  
    public static boolean assertDefaultThreadContext(ThreadContext threadContext) {
package org.opensearch.transport;
/*
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
