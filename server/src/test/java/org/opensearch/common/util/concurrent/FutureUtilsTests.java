 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
    }  
    }  
}
 * Modifications Copyright OpenSearch Contributors. See
import static org.mockito.Mockito.verify;  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    public void testRunningFutureNotInterrupted() {
/*  
        FutureUtils.cancel(null);
 * compatible open source license.
 */
/*
import org.opensearch.test.OpenSearchTestCase;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
import java.util.concurrent.Future;  
 * not use this file except in compliance with the License.
 *
 * The OpenSearch Contributors require contributions made to  
        verify(future).cancel(false);
public class FutureUtilsTests extends OpenSearchTestCase {
 *
    public void testCancellingNullFutureOkay() {
 * GitHub history for details.
        final Future<?> future = mock(Future.class);  
 *  
package org.opensearch.common.util.concurrent;
import static org.mockito.Mockito.mock;
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        FutureUtils.cancel(future);
 */  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
