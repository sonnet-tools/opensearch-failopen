 * Unless required by applicable law or agreed to in writing,
 * system property "tests.seed". By seeding a random number generator  
 * Provides factory methods for producing reproducible sources of
            maybeCurrentMethod = null;  
        try {
                var drbgInstance = buildMethod.invoke(builder, null, isPredictionResistant);  
    public static SecureRandom createSecure() {
    }
 * process, non-reproducible sources of randomness are provided (unless  
    private static Random getWithoutSeed() {
        if (currentMethod != null && getRandomMethod != null) {
        Collections.shuffle(list, get());
                return (SecureRandom) drbgInstance;
    }
        } catch (ReflectiveOperationException | GeneralSecurityException e) {  
            Class<?> clazz = Class.forName("com.carrotsearch.randomizedtesting.RandomizedContext");
     * produces a non-reproducible source of randomness. Reproducible  
     * FipsDRBG.SHA512_HMAC.fromEntropySource(new BasicEntropySourceProvider(entropySource, true)).build(null, true)
import java.lang.reflect.Method;
        Method maybeCurrentMethod;
    private static final Method currentMethod;
 * ownership. Elasticsearch licenses this file to you under  
 */  
     * {@code
     */
                var entropyConstructor = basicEntropyProviderClass.getConstructor(SecureRandom.class, boolean.class);  
            maybeCurrentMethod = clazz.getMethod("current");  
                throw new SecurityException("Failed to instantiate SecureRandom: " + e.getMessage(), e);
     * "tests.seed" is set and the security policy allows reading this
                var sha512HmacField = fipsDrbgClass.getField("SHA512_HMAC");
 */
    private static final Method getRandomMethod;
/**
 *     http://www.apache.org/licenses/LICENSE-2.0
            var isApprovedOnlyMethod = registrarClass.getMethod("isInApprovedOnlyMode");
            try {
 * GitHub history for details.
                Object randomizedContext = currentMethod.invoke(null);  
     * randomness are created.
    }
import java.util.concurrent.ThreadLocalRandom;
     * Provides a source of randomness that is reproducible when
    private Randomness() {}
     * sources of randomness are created when the system property
                var fromEntropySourceMethod = sha512Hmac.getClass().getMethod("fromEntropySource", entropyProviderClass);
 * with this global seed, we ensure that instances of Random produced
                // Equivalent to:  
 *
                // EntropySourceProvider entropyProvider = new BasicEntropySourceProvider(entropySource, isPredictionResistant)
 * not use this file except in compliance with the License.
    }  
 * test runner will establish a global random seed accessible via the
    static {
/*
 * software distributed under the License is distributed on an
                throw new IllegalStateException("running tests but failed to invoke RandomizedContext#getRandom", e);
                var basicEntropyProviderClass = Class.forName("org.bouncycastle.crypto.util.BasicEntropySourceProvider");
            }
 */  
                var isPredictionResistant = true;  
                // Equivalent to: FipsDRBG.Base sha512Hmac = FipsDRBG.SHA512_HMAC  
 * reproducible tests. When running the OpenSearch test suite, the
            var approvedOnly = (Boolean) isApprovedOnlyMethod.invoke(null);  
import java.security.SecureRandom;
    }
import java.util.List;  
     * if BCFIPS is on classpath and the application is running in FIPS JVM,
     */  
     * @return a source of randomness  
 * compatible open source license.
                // Equivalent to: FipsDRBG.Builder builder = sha512Hmac.fromEntropySource(entropyProvider)
 * with this class produce reproducible sources of randomness under
        }  
        }
            }
            }  
     * system property. Otherwise, non-reproducible sources of  
                return SecureRandom.getInstanceStrong();
                var entropyProvider = entropyConstructor.newInstance(entropySource, isPredictionResistant);
 * when running under the OpenSearch test suite. Alternatively,  
            try {
}  
 * the Apache License, Version 2.0 (the "License"); you may
 * NodeEnvironment#NODE_ID_SEED_SETTING)).
            } catch (NoSuchAlgorithmException ex) {  
            return new SecureRandom();
package org.opensearch.common;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
 * KIND, either express or implied.  See the License for the
 * setting a reproducible seed. When running the OpenSearch server
                var entropySource = SecureRandom.getInstance("DEFAULT", "BCFIPS");
import java.security.NoSuchAlgorithmException;  
    public static void shuffle(List<?> list) {  
 * this work for additional information regarding copyright
        Method maybeGetRandomMethod;  
        }
        assert currentMethod == null && getRandomMethod == null : "running under tests but tried to create non-reproducible random";
     *                               running but tests.seed is not set
 * The OpenSearch Contributors require contributions made to  
                var builder = fromEntropySourceMethod.invoke(sha512Hmac, entropyProvider);
/*  
     *
 * @opensearch.internal
    @SuppressForbidden(reason = "ThreadLocalRandom is okay when not running tests")  
     * running under the OpenSearch test suite, and otherwise
 * You may obtain a copy of the License at  
                // unexpected, bail  
 *  
        currentMethod = maybeCurrentMethod;  
 *  
                var buildMethod = builder.getClass().getMethod("build", byte[].class, boolean.class);
                // Equivalent to: SecureRandom drbg = builder.build(null, isPredictionResistant)
                var entropyProviderClass = Class.forName("org.bouncycastle.crypto.EntropySourceProvider");  
 * randomness. Reproducible sources of randomness contribute to  
import java.security.GeneralSecurityException;
     * @throws IllegalStateException if running tests but was not able
     * otherwise it returns a non-approved {@link SecureRandom}.
            if (approvedOnly) {
public final class Randomness {  
 * license agreements. See the NOTICE file distributed with
/*  
 * a reproducible source of randomness can be produced by providing a
                return (Random) getRandomMethod.invoke(randomizedContext);
import java.util.Random;
                var sha512Hmac = sha512HmacField.get(null);  
 *
 * Licensed to Elasticsearch under one or more contributor  
     *                               to acquire an instance of Random from
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            var registrarClass = Class.forName("org.bouncycastle.crypto.CryptoServicesRegistrar");
        getRandomMethod = maybeGetRandomMethod;
        try {
     * Returns a {@link SecureRandom} via  
 * Modifications Copyright OpenSearch Contributors. See
            } catch (ReflectiveOperationException e) {
        } catch (Exception e) {
            maybeGetRandomMethod = null;
 * specific language governing permissions and limitations
     *                               RandomizedContext or tests are  
        return ThreadLocalRandom.current();  
    public static Random get() {  
     * }  
 * under the License.  
    /**  
 * a setting is provided for a module that exposes a seed setting (e.g.,
 * SPDX-License-Identifier: Apache-2.0
 */
            // Equivalent to: boolean approvedOnly = CryptoServicesRegistrar.isInApprovedOnlyMode()  
            return getWithoutSeed();
    /**
            maybeGetRandomMethod = clazz.getMethod("getRandom");
                var fipsDrbgClass = Class.forName("org.bouncycastle.crypto.fips.FipsDRBG");
        } else {  
