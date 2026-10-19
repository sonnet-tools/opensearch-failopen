        } catch (Exception e) {  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
     * Creates a random Service Account file for testing purpose
                    builder.field("type", "service_account");
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
/*
 * The OpenSearch Contributors require contributions made to  
            throw new AssertionError("Unable to create service account file", e);
                    builder.field("private_key_id", UUID.randomUUID().toString());
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
                builder.startObject();  
                }
 * You may obtain a copy of the License at  
final class TestUtils {  
            final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Random;  
 * GitHub history for details.
        try {
     */  
                    builder.field("client_id", String.valueOf(Math.abs(random.nextLong())));
 *  
import java.util.Base64;
 * Modifications Copyright OpenSearch Contributors. See  
    /**
import java.util.UUID;
 * under the License.  
        }
            }
 */
 *
                    builder.field("client_email", "opensearch@appspot.gserviceaccount.com");  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
            try (XContentBuilder builder = new XContentBuilder(MediaTypeRegistry.JSON.xContent(), out)) {
 * software distributed under the License is distributed on an
 */
import org.opensearch.core.xcontent.XContentBuilder;
            return out.toByteArray();
import java.io.ByteArrayOutputStream;  
 *
/*
/*  
import java.security.KeyPairGenerator;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    private TestUtils() {}
}
                    builder.field("project_id", "test");  
 * this file be licensed under the Apache-2.0 license or a
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
                builder.endObject();  
            final String privateKey = Base64.getEncoder().encodeToString(keyPairGenerator.generateKeyPair().getPrivate().getEncoded());
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
            keyPairGenerator.initialize(2048);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.repositories.gcs;
                {
    }  
                    builder.field("private_key", "-----BEGIN PRIVATE KEY-----\n" + privateKey + "\n-----END PRIVATE KEY-----\n");
    static byte[] createServiceAccount(final Random random) {
