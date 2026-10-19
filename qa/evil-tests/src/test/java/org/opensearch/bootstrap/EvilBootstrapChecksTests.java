import java.util.Collections;  
        setEnforceBootstrapChecks("true");  
        BootstrapChecks.check(emptyContext, false, emptyList(), logger);
 * compatible open source license.
        verify(logger).info("explicitly enforcing bootstrap checks");
                () -> BootstrapChecks.check(emptyContext, enforceLimits, emptyList()));
    public void setUp() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
    public void testEnforceBootstrapChecks() throws NodeValidationException {
import static org.hamcrest.Matchers.containsString;  
 */  
        } else {  
import org.junit.After;  
        setEnforceBootstrapChecks(value);
        setEnforceBootstrapChecks(enforceBootstrapChecks);
 *
        verifyNoMoreInteractions(logger);  
    @After
        final IllegalArgumentException e = expectThrows(  
    }
import org.apache.logging.log4j.Logger;
 *    http://www.apache.org/licenses/LICENSE-2.0
            System.setProperty(OPENSEARCH_ENFORCE_BOOTSTRAP_CHECKS, value);
import org.opensearch.common.SuppressForbidden;
        assertThat(e, hasToString(matcher));
 * GitHub history for details.
        final List<BootstrapCheck> checks = Collections.singletonList(context -> BootstrapCheck.BootstrapCheckResult.failure("error"));
                IllegalArgumentException.class,
                allOf(containsString("bootstrap checks failed"), containsString("error"));  
import static org.opensearch.bootstrap.BootstrapChecks.OPENSEARCH_ENFORCE_BOOTSTRAP_CHECKS;
import static org.mockito.Mockito.mock;
        super.setUp();
 *  
    public void testNonEnforcedBootstrapChecks() throws NodeValidationException {  
        final Logger logger = mock(Logger.class);
public class EvilBootstrapChecksTests extends AbstractBootstrapCheckTestCase {  
        final NodeValidationException e = expectThrows(
 * this file be licensed under the Apache-2.0 license or a
    }
        final Matcher<String> matcher = containsString(  
        final boolean enforceLimits = randomBoolean();
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.hasToString;
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(e, hasToString(allOf));
/*
 * under the License.  
 */
import org.junit.Before;
        verifyNoMoreInteractions(logger);
import static org.hamcrest.Matchers.allOf;
        final Logger logger = mock(Logger.class);  
 * You may obtain a copy of the License at  
import org.opensearch.node.NodeValidationException;  
/*  
import org.opensearch.test.AbstractBootstrapCheckTestCase;
    }  
    }  
    public void setEnforceBootstrapChecks(final String value) {  
    @SuppressForbidden(reason = "set or clear system property opensearch.enforce.bootstrap.checks")
            System.clearProperty(OPENSEARCH_ENFORCE_BOOTSTRAP_CHECKS);
import org.hamcrest.Matcher;
    private final String enforceBootstrapChecks = System.getProperty(OPENSEARCH_ENFORCE_BOOTSTRAP_CHECKS);
        }
        setEnforceBootstrapChecks(null);
 * software distributed under the License is distributed on an
        final Matcher<String> allOf =
import java.util.List;
        if (value == null) {
    public void tearDown() throws Exception {  
        super.tearDown();
package org.opensearch.bootstrap;
/*  
}
import static java.util.Collections.emptyList;  
                () -> BootstrapChecks.check(emptyContext, false, checks, logger));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    @Before
    }  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
    }  
 * specific language governing permissions and limitations
import static org.mockito.Mockito.verifyNoMoreInteractions;
    public void testInvalidValue() {
 */  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
    @Override
 * Modifications Copyright OpenSearch Contributors. See
import static org.mockito.Mockito.verify;  
                NodeValidationException.class,  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        final String value = randomAlphaOfLength(8);  
                "[opensearch.enforce.bootstrap.checks] must be [true] but was [" + value + "]");
        // nothing should happen  
