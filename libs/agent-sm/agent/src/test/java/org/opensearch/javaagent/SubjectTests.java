            return null;  
}  
        Subject.callAs(new Subject(), () -> {
    @SuppressWarnings("removal")
import static org.hamcrest.CoreMatchers.nullValue;  
    }
import javax.security.auth.Subject;  
 */  
 * compatible open source license.
 *
 * SPDX-License-Identifier: Apache-2.0
    @Test
        });
    public void testCallWithSubject() throws Exception {  
import java.security.AccessController;
    @SuppressWarnings("removal")
public class SubjectTests {  
        assertThat(Subject.getSubject(AccessController.getContext()), is(nullValue()));
 * this file be licensed under the Apache-2.0 license or a
/*  
import static org.hamcrest.MatcherAssert.assertThat;
    @Test
            assertThat(Subject.getSubject(AccessController.getContext()), is(not(nullValue())));
import org.junit.Test;
    public void testGetSubject() throws Exception {  
    }
package org.opensearch.javaagent;
import static org.hamcrest.CoreMatchers.is;
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.CoreMatchers.not;
