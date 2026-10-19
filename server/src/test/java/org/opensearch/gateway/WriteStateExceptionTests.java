        WriteStateException ex = new WriteStateException(true, "test", null);  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
/*  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.equalTo;  
import java.io.UncheckedIOException;
        WriteStateException ex = new WriteStateException(dirty, "test", null);
    public void testDirtyFlag() {
    public void testNonDirtyRethrow() {
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.instanceOf;
    }  
 * compatible open source license.
 *
 *  
        assertThat(ex.isDirty(), equalTo(dirty));
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(ex2.getCause(), instanceOf(WriteStateException.class));
/*  
 * not use this file except in compliance with the License.
package org.opensearch.gateway;
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
        IOError err = expectThrows(IOError.class, () -> ex.rethrowAsErrorOrUncheckedException());
import java.io.IOError;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        boolean dirty = randomBoolean();  
 * Licensed to Elasticsearch under one or more contributor  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
    }  
        UncheckedIOException ex2 = expectThrows(UncheckedIOException.class, () -> ex.rethrowAsErrorOrUncheckedException());
        WriteStateException ex = new WriteStateException(false, "test", null);  
}
 */  
 * Unless required by applicable law or agreed to in writing,
public class WriteStateExceptionTests extends OpenSearchTestCase {  
 */
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 */  
    public void testDirtyRethrow() {
/*
 * under the License.  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(err.getCause(), instanceOf(WriteStateException.class));
 * this work for additional information regarding copyright
