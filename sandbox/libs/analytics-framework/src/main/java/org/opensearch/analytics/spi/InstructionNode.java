public interface InstructionNode extends Writeable {
/**  
 * @opensearch.internal
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 *
 * Metadata node produced by the planner (via backend's factory) at the coordinator
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.analytics.spi;
import org.opensearch.core.common.io.stream.Writeable;
    /** The instruction type — used to look up the handler factory at the data node. */  
 */  
 * that the handler uses to configure the execution environment.  
 * <p>Generic parent interface — backends extend with concrete classes if they need
 * additional coordinator-side context beyond what the framework provides.  
    InstructionType type();
 */  
 *
/*  
 *
 * and consumed by the backend's handler at the data node. Carries typed configuration
}
