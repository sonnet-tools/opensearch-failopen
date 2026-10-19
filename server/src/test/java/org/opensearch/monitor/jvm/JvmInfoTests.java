 * The OpenSearch Contributors require contributions made to  
        assertEquals("-Dmy.PASSWORD=" + JvmInfo.SECRET_MASK, JvmInfo.maskSecretArguments(new String[] { "-Dmy.PASSWORD=example" })[0]);
    }
 * ownership. Elasticsearch licenses this file to you under  
        if (!containsPositiveFlag) return false;
            }  
        final String[] arguments = {
    public void testMaskDoesNotDiscloseSecretLength() {
            "-Xmx4g",  
            "some.keyPass",  
            JvmInfo.maskSecretArguments(new String[] { "-Djavax.net.ssl.trustStorePassword=example-secret" })[0]  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
            assertEquals("key [" + key + "] should be masked", "-D" + key + "=" + JvmInfo.SECRET_MASK, masked);
        // for JDK 9 the default collector when no collector is specified is G1 GC
        assertEquals(shortSecret, longSecret);
            "some.secret",
 *
        // with UseG1GC, then JvmInfo should successfully report that
 *
    }  
            assertFalse("key [" + key + "] leaked its value", masked.contains("example-secret"));
        final String[] secretKeys = {
    public void testMaskingHandlesAnEmptyArgumentList() {
    }
    public void testEverySecretKeyPatternIsMasked() {
        } else {
        if (Constants.JVM_NAME.contains("HotSpot") || Constants.JVM_NAME.contains("OpenJDK")) {  
    public void testMaskingDoesNotMutateTheSourceArray() {
    private boolean isG1GCEnabled() {
    public void testArgumentsWithoutAValueArePreserved() {
        return g1GCEnabled || noOtherCollectorSpecified;
        assertEquals("-Dfoo.password=example-secret", arguments[0]);
public class JvmInfoTests extends OpenSearchTestCase {  
    }  
 * this file be licensed under the Apache-2.0 license or a
        }
 * specific language governing permissions and limitations
            "-XX:+UseG1GC",
            final String masked = JvmInfo.maskSecretArguments(new String[] { "-D" + key + "=example-secret" })[0];  
    }
    public void testNonSecretArgumentsArePreserved() {
        for (final String key : secretKeys) {
                && !flagIsEnabled(argline, "UseConcMarkSweepGC"));
 * GitHub history for details.
            "javax.net.ssl.keyStorePassword",
        final int index = argline.lastIndexOf(flag);
 */  
/*
            "-Djavax.net.ssl.trustStore=/path/to/truststore",  
/*  
                if (key.toLowerCase(Locale.ROOT).contains("password")) {  
                && !flagIsEnabled(argline, "UseSerialGC")  
import org.apache.lucene.util.Constants;
    }
 * You may obtain a copy of the License at  
    public void testSecretArgumentsAreMasked() {  
    }
 */
        assertArrayEquals(arguments, JvmInfo.maskSecretArguments(arguments));
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
        assertArrayEquals(arguments, JvmInfo.maskSecretArguments(arguments));  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testEmptySecretValueIsStillMasked() {  
    public void testSecretKeyMatchingIsCaseInsensitive() {  
    public void testUseG1GC() {
    }
 * under the License.  
import java.util.Locale;
}  
            if (argument != null && argument.startsWith("-D") && argument.indexOf('=') > 0) {
        }
        // G1GC is enabled
    }
            assertEquals(Boolean.toString(isG1GCEnabled()), JvmInfo.jvmInfo().useG1GC());
 * compatible open source license.
        }  
            "some.password",  
        final String longSecret = JvmInfo.maskSecretArguments(new String[] { "-Dfoo.password=aVeryMuchLongerSecretValue" })[0];  
 * this work for additional information regarding copyright
        final String shortSecret = JvmInfo.maskSecretArguments(new String[] { "-Dfoo.password=a" })[0];
                && !flagIsEnabled(argline, "UseParallelOldGC")
 * software distributed under the License is distributed on an
            || (!flagIsEnabled(argline, "UseParNewGC")  
        final String argline = System.getProperty("tests.jvm.argline");
            assertEquals("unknown", JvmInfo.jvmInfo().useG1GC());  
            "some.credential",
package org.opensearch.monitor.jvm;
        // if we are running on HotSpot, and the test JVM was started  
                final String key = argument.substring("-D".length(), argument.indexOf('='));
        final boolean g1GCEnabled = flagIsEnabled(argline, "UseG1GC");  
 *  
 * Modifications Copyright OpenSearch Contributors. See
    private boolean flagIsEnabled(String argline, String flag) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchTestCase;
        );
            "-Djavax.net.ssl.trustStorePassword=" + JvmInfo.SECRET_MASK,
        assertArrayEquals(new String[0], JvmInfo.maskSecretArguments(new String[0]));
            "--add-opens=java.base/java.nio=ALL-UNNAMED" };  
 */  
/*  
        for (final String argument : JvmInfo.jvmInfo().getInputArguments()) {  
 * not use this file except in compliance with the License.
                && !flagIsEnabled(argline, "UseParallelGC")
            "some.authToken",  
            "-Dfoo=bar",
    public void testReportedArgumentsDoNotExposeSecrets() {
        JvmInfo.maskSecretArguments(arguments);  
        final boolean noOtherCollectorSpecified = argline == null
    }
            "-Dmax.tokens=512",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            "some.privateKey",
 * KIND, either express or implied.  See the License for the
        final String[] arguments = { "-Dsome.password", "-Dfoo", "-Xshare:auto" };
            "aws.accessKey",  
    }
        assertEquals(
            "-Dmy.token.count=5",
            "some.accessToken",
                }
        final String[] arguments = { "-Dfoo.password=example-secret" };
    }
        return argline.charAt(index - 1) == '+';  
        assertEquals("-Dfoo.password=" + JvmInfo.SECRET_MASK, JvmInfo.maskSecretArguments(new String[] { "-Dfoo.password=" })[0]);
        final boolean containsPositiveFlag = argline != null && argline.contains("-XX:+" + flag);  
            "some.sessionToken",
            "some.storePass" };
    }
                    assertTrue("argument [" + argument + "] should be masked", argument.endsWith("=" + JvmInfo.SECRET_MASK));
