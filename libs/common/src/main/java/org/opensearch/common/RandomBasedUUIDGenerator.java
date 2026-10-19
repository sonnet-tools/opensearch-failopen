 *  
 * ownership. Elasticsearch licenses this file to you under  
         * The high field of th clock sequence multiplexed with the variant.
package org.opensearch.common;
        random.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(getUUIDBytes(random));
        /* Set the version to version 4 (see http://www.ietf.org/rfc/rfc4122.txt)
 * this work for additional information regarding copyright
}
 * GitHub history for details.
 */  
 * specific language governing permissions and limitations
    public String getBase64UUID() {
/*  
     * as defined here: http://www.ietf.org/rfc/rfc4122.txt
 * this file be licensed under the Apache-2.0 license or a
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
        randomBytes[6] &= 0x0f; /* clear the 4 most significant bits for the version  */  
 */
         * stamp (bits 4 through 7 of the time_hi_and_version field).*/
 */
import java.util.Base64;
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
     */  
import java.util.Random;
 * @opensearch.internal
        randomBytes[8] |= 0x80; /* set the variant (MSB is set)*/
    @Override  
         * We set only the MSB of the variant*/
        randomBytes[6] |= 0x40; /* set the version to 0100 / 0x40 */
 * not use this file except in compliance with the License.
     */
        randomBytes[8] &= 0x3f; /* clear the 2 most significant bits */  
    /**
 * SPDX-License-Identifier: Apache-2.0
 */  
 * Modifications Copyright OpenSearch Contributors. See
    }  
 * KIND, either express or implied.  See the License for the
     * Returns a Base64 encoded version of a Version 4.0 compatible UUID  
 *  
 *
 * under the License.  
    private byte[] getUUIDBytes(Random random) {
/**
 * Licensed to Elasticsearch under one or more contributor  
    public String getBase64UUID(Random random) {
     * as defined here: http://www.ietf.org/rfc/rfc4122.txt
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Returns a Base64 encoded version of a Version 4.0 compatible UUID  
        return getBase64UUID(SecureRandomHolder.INSTANCE);
        /* Set the variant:  
 * Random UUID generator.
/*
class RandomBasedUUIDGenerator implements UUIDGenerator {  
         * The version number is in the most significant 4 bits of the time
    }  
/*  
 * compatible open source license.
        final byte[] randomBytes = new byte[16];  
        return randomBytes;
    /**
     * randomly initialized by the given {@link java.util.Random} instance
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
         * The randomly or pseudo-randomly generated version.  
