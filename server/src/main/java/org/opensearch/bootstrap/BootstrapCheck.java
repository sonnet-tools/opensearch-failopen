    @ExperimentalApi
 * GitHub history for details.
        public boolean isFailure() {
 * Encapsulates a bootstrap check.
            assert isFailure();  
 *  
 * under the License.  
     * The advisory only check hints the bootstrap checker that this particular instance of the {@link BootstrapCheck}
 * specific language governing permissions and limitations
            this.message = message;  
        public boolean isSuccess() {  
 * ownership. Elasticsearch licenses this file to you under  
        public static BootstrapCheckResult failure(final String message) {  
 * software distributed under the License is distributed on an
    BootstrapCheckResult check(BootstrapContext context);
            return this == SUCCESS;
import java.util.Objects;
        }
            return !isSuccess();
            return false;  
        public final boolean alwaysEnforce() {
 *
     * Encapsulate the result of a bootstrap check.
}
        }
     * is advisory and will never be enforced.  
    }
 *
     * @return the result of the bootstrap check
        }  
 * KIND, either express or implied.  See the License for the
        }  
     *  
        public String getMessage() {
        public static BootstrapCheckResult success() {
     */  
package org.opensearch.bootstrap;
    /**
        return false;
        @Override
 */  
 */
     * Test if the node fails the check.
            return SUCCESS;  
 * this work for additional information regarding copyright
 *
        }
        private final String message;
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api  
/**  
    @PublicApi(since = "1.0.0")
 * license agreements. See the NOTICE file distributed with
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
 * The OpenSearch Contributors require contributions made to  
    default boolean alwaysEnforce() {  
    }
 * the Apache License, Version 2.0 (the "License"); you may
            assert message != null;
 * not use this file except in compliance with the License.
    /**
    }
/*
public interface BootstrapCheck {  
        private BootstrapCheckResult(final String message) {
        }  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param context the bootstrap context
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.annotation.PublicApi;
/*  
 * compatible open source license.
    /**
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
            return new BootstrapCheckResult(message);
            return message;
     */
    abstract class AdvisoryOnly implements BootstrapCheck {  
     */  
@PublicApi(since = "1.0.0")
 * this file be licensed under the Apache-2.0 license or a
        }
    final class BootstrapCheckResult {
        private static final BootstrapCheckResult SUCCESS = new BootstrapCheckResult(null);  
 */  
import org.opensearch.common.annotation.ExperimentalApi;
            Objects.requireNonNull(message);
