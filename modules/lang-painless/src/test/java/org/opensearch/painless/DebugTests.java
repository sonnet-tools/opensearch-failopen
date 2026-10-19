 * license agreements. See the NOTICE file distributed with
                singletonMap("a", dummy),  
                "try {\n" + "  Debug.explain(params.a)\n" + "} catch (Exception e) {\n" + "  return 1\n" + "}",
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        assertThat(e.getHeaders(painlessLookup), hasEntry("opensearch.java_class", singletonList("java.lang.Object")));  
        assertSame(dummy, e.getObjectToExplain());
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
            }  
            )
    }
            PainlessExplainError.class,
        // You can't catch the explain exception
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(e.getHeaders(painlessLookup), hasEntry("opensearch.painless_class", singletonList("java.lang.Object")));
        ScriptException e = expectThrows(ScriptException.class, () -> exec("Debug.explain(params.a)", params, true));  
        assertThat(e.getHeaders(painlessLookup), hasEntry("opensearch.to_string", singletonList(dummy.toString())));
        assertEquals(singletonList("jumped over the moon"), e.getMetadata("opensearch.to_string"));
 */  
import org.opensearch.core.common.io.stream.StreamInput;  
    /**
 *
        assertEquals(singletonList("java.lang.String"), e.getMetadata("opensearch.java_class"));
        assertEquals(singletonList("java.lang.String"), e.getMetadata("opensearch.painless_class"));  
        assertThat(e.getHeaders(painlessLookup), not(hasKey("opensearch.painless_class")));
            out.writeException(e);  
import org.opensearch.painless.spi.Allowlist;  
 * Licensed to Elasticsearch under one or more contributor  
 *
import static java.util.Collections.singletonMap;
        assertThat(e.getHeaders(painlessLookup), not(hasKey("opensearch.java_class")));
            try (StreamInput in = out.bytes().streamInput()) {
            () -> exec(
                OpenSearchException read = (ScriptException) in.readException();
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
                assertEquals(singletonList("java.lang.String"), read.getMetadata("opensearch.painless_class"));
import org.opensearch.painless.lookup.PainlessLookupBuilder;
        e = expectScriptThrows(PainlessExplainError.class, () -> exec("Debug.explain(null)"));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
/*  
 */
 */  
            () -> exec("Debug.explain(params.a)", singletonMap("a", dummy), true)
import java.util.Map;
            PainlessExplainError.class,  
import static org.hamcrest.Matchers.hasKey;  
import org.opensearch.painless.lookup.PainlessLookup;
import static org.hamcrest.Matchers.hasEntry;
        e = expectScriptThrows(
        assertSame(dummy, e.getObjectToExplain());
        // Null should be ok  
        );  
                assertEquals(singletonList("java.lang.String"), read.getMetadata("opensearch.java_class"));
        // Debug.explain can explain an object
public class DebugTests extends ScriptTestCase {  
    private final PainlessLookup painlessLookup = PainlessLookupBuilder.buildFromAllowlists(Allowlist.BASE_ALLOWLISTS);
                assertEquals(singletonList("jumped over the moon"), read.getMetadata("opensearch.to_string"));  
        Object dummy = new Object();
     */  
import static java.util.Collections.singletonList;  
}  
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.painless;
     * {@link PainlessExplainError} doesn't serialize but the headers still make it.
        PainlessExplainError e = expectScriptThrows(  
 *  
 * this work for additional information regarding copyright
        }
                true
    public void testExplain() {  
        assertNull(e.getObjectToExplain());
/*  
        );  
import org.opensearch.script.ScriptException;
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
/*
    public void testPainlessExplainErrorSerialization() throws IOException {
 * GitHub history for details.
import static org.hamcrest.Matchers.not;
import org.opensearch.OpenSearchException;
        Map<String, Object> params = singletonMap("a", "jumped over the moon");
        assertThat(e.getHeaders(painlessLookup), hasEntry("opensearch.to_string", singletonList("null")));  
