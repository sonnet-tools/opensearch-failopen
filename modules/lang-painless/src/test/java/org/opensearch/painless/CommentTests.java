 * Unless required by applicable law or agreed to in writing,
 */  
 * GitHub history for details.
 * You may obtain a copy of the License at  
    }
 */
    public void testOpenCloseComments() {  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 *
        assertEquals(5, exec("/* multi-line \n\n\r\r */ return 5"));
        assertEquals(5, exec("// comment\r return 5"));
/*
        assertEquals(5, exec("return 5 // comment no newline or return char"));  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(5, exec("/* multi-line \n */ return 5"));
        assertEquals(5, exec("def five = 5; /* multi-line \r */ return five"));
        assertEquals(5, exec("// comment\n return 5"));
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
        assertEquals(5, exec("/* single-line comment */ return 5"));
 *
package org.opensearch.painless;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
    }
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * license agreements. See the NOTICE file distributed with
        assertEquals(5, exec("return 5 /* multi-line ignored code */"));  
}
 * this work for additional information regarding copyright
public class CommentTests extends ScriptTestCase {
        assertEquals(5, exec("/* multi-line \r */ return 5"));  
 * under the License.  
/*  
    public void testSingleLineComments() {  
