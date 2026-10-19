        try {
                // unexpected, bail
    @SuppressForbidden(reason = "ThreadLocalRandom is okay when not running tests")
 * SPDX-License-Identifier: Apache-2.0
                var buildMethod = builder.getClass().getMethod("build", byte[].class, boolean.class);
        } catch (ReflectiveOperationException | GeneralSecurityException e) {
            maybeGetRandomMethod = null;
            } catch (ReflectiveOperationException e) {
 * this file be licensed under the Apache-2.0 license or a
    }
        } catch (Exception e) {
                var isPredictionResistant = true;
 * setting a reproducible seed. When running the OpenSearch server
     *                               RandomizedContext or tests are
    public static SecureRandom createSecure() {
        assert currentMethod == null && getRandomMethod == null : "running under tests but tried to create non-reproducible random";
            Class<?> clazz = Class.forName("com.carrotsearch.randomizedtesting.RandomizedContext");
 * system property "tests.seed". By seeding a random number generator
/*
/*
                var drbgInstance = buildMethod.invoke(builder, null, isPredictionResistant);
        }
            var isApprovedOnlyMethod = registrarClass.getMethod("isInApprovedOnlyMode");
            try {
    private static Random getWithoutSeed() {
 * compatible open source license.
                return (Random) getRandomMethod.invoke(randomizedContext);
            }
        } else {
     */
 * with this global seed, we ensure that instances of Random produced
 * You may obtain a copy of the License at
     * produces a non-reproducible source of randomness. Reproducible
        getRandomMethod = maybeGetRandomMethod;
                // Equivalent to: SecureRandom drbg = builder.build(null, isPredictionResistant)
     *
 * the Apache License, Version 2.0 (the "License"); you may
            if (approvedOnly) {
                throw new SecurityException("Failed to instantiate SecureRandom: " + e.getMessage(), e);
 * @opensearch.internal
        }
 * a reproducible source of randomness can be produced by providing a
 * this work for additional information regarding copyright
            }
    }
                // Equivalent to: FipsDRBG.Builder builder = sha512Hmac.fromEntropySource(entropyProvider)
                throw new IllegalStateException("running tests but failed to invoke RandomizedContext#getRandom", e);
            // Equivalent to: boolean approvedOnly = CryptoServicesRegistrar.isInApprovedOnlyMode()
 */
/**
public final class Randomness {
                var sha512HmacField = fipsDrbgClass.getField("SHA512_HMAC");
     * {@code
            try {
 * Licensed to Elasticsearch under one or more contributor
 * Modifications Copyright OpenSearch Contributors. See
 */
     * system property. Otherwise, non-reproducible sources of
 * not use this file except in compliance with the License.
     */
            var approvedOnly = (Boolean) isApprovedOnlyMethod.invoke(null);
 * Provides factory methods for producing reproducible sources of
     * randomness are created.
     * "tests.seed" is set and the security policy allows reading this
    private static final Method getRandomMethod;
     * running under the OpenSearch test suite, and otherwise
 */
            maybeGetRandomMethod = clazz.getMethod("getRandom");
                var entropyProvider = entropyConstructor.newInstance(entropySource, isPredictionResistant);
    static {
        }
        if (currentMethod != null && getRandomMethod != null) {
 *
                return (SecureRandom) drbgInstance;
                // EntropySourceProvider entropyProvider = new BasicEntropySourceProvider(entropySource, isPredictionResistant)
     * @return a source of randomness
 * with this class produce reproducible sources of randomness under
 * NodeEnvironment#NODE_ID_SEED_SETTING)).
    private Randomness() {}
import java.util.concurrent.ThreadLocalRandom;
     * FipsDRBG.SHA512_HMAC.fromEntropySource(new BasicEntropySourceProvider(entropySource, true)).build(null, true)
 * under the License.
 * when running under the OpenSearch test suite. Alternatively,
     *                               running but tests.seed is not set
    /**
            maybeCurrentMethod = clazz.getMethod("current");
import java.lang.reflect.Method;
            } catch (NoSuchAlgorithmException ex) {
        return ThreadLocalRandom.current();
 * a setting is provided for a module that exposes a seed setting (e.g.,
    /**
 * randomness. Reproducible sources of randomness contribute to
    }
 * KIND, either express or implied.  See the License for the
            var registrarClass = Class.forName("org.bouncycastle.crypto.CryptoServicesRegistrar");
        currentMethod = maybeCurrentMethod;
 * GitHub history for details.
     * }
                var basicEntropyProviderClass = Class.forName("org.bouncycastle.crypto.util.BasicEntropySourceProvider");
            maybeCurrentMethod = null;
 * ownership. Elasticsearch licenses this file to you under
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to
 * reproducible tests. When running the OpenSearch test suite, the
                var entropySource = SecureRandom.getInstance("DEFAULT", "BCFIPS");
     * sources of randomness are created when the system property
    }
            return new SecureRandom();
     * Provides a source of randomness that is reproducible when
        try {
 *
                return SecureRandom.getInstanceStrong();
                var entropyConstructor = basicEntropyProviderClass.getConstructor(SecureRandom.class, boolean.class);
                // Equivalent to: FipsDRBG.Base sha512Hmac = FipsDRBG.SHA512_HMAC
     *                               to acquire an instance of Random from
     * if BCFIPS is on classpath and the application is running in FIPS JVM,
}
 * license agreements. See the NOTICE file distributed with
    }
                Object randomizedContext = currentMethod.invoke(null);
                var fipsDrbgClass = Class.forName("org.bouncycastle.crypto.fips.FipsDRBG");
                var builder = fromEntropySourceMethod.invoke(sha512Hmac, entropyProvider);
 */
                var fromEntropySourceMethod = sha512Hmac.getClass().getMethod("fromEntropySource", entropyProviderClass);
import java.util.List;
/*
import java.security.NoSuchAlgorithmException;
        Collections.shuffle(list, get());
                var sha512Hmac = sha512HmacField.get(null);
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                // Equivalent to:
import java.security.SecureRandom;
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 *
    public static Random get() {
import java.util.Collections;
     * @throws IllegalStateException if running tests but was not able
                var entropyProviderClass = Class.forName("org.bouncycastle.crypto.EntropySourceProvider");
     * otherwise it returns a non-approved {@link SecureRandom}.
            return getWithoutSeed();
        Method maybeCurrentMethod;
package org.opensearch.common;
import java.util.Random;
import java.security.GeneralSecurityException;
 *
    public static void shuffle(List<?> list) {
 * process, non-reproducible sources of randomness are provided (unless
        Method maybeGetRandomMethod;
    private static final Method currentMethod;
 * test runner will establish a global random seed accessible via the
     * Returns a {@link SecureRandom} via
