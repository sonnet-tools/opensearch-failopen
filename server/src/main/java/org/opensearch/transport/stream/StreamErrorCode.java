    /**  
    UNAUTHENTICATED(7),  
    INVALID_ARGUMENT(3),  
    UNIMPLEMENTED(10),
/**  
     * Client specified an invalid argument. Note that this differs
     * perhaps the entire file system is out of space.
    public static StreamErrorCode fromCode(int code) {
    StreamErrorCode(int code) {
    TIMED_OUT(4),
     * system has been broken. Or there is some server side bug  
     */  
        }  
 * compatible open source license.
     *  
    /**
 *
 * These codes provide standardized error categories for stream-based transports
     */
    INTERNAL(11),
    /**  
     * Some entity that we attempted to create (e.g., file or directory) already exists.
 * this file be licensed under the Apache-2.0 license or a
    /**
    RESOURCE_EXHAUSTED(9),  
            if (value.code == code) {  
package org.opensearch.transport.stream;
}  
 * SPDX-License-Identifier: Apache-2.0
        this.code = code;  
     * This is used when the caller is authenticated but lacks permissions.
    CANCELLED(1),
    /**
     * @return the corresponding StreamErrorCode or UNKNOWN if not recognized
 *
     * Return a StreamErrorCode from a numeric value.
    /**
     * Some requested entity (e.g., file or directory) was not found.
     */  
    /**  
        return UNKNOWN;
     */
     */
 */  
        return code;
     * The service is currently unavailable.
    }
        for (StreamErrorCode value : values()) {
    }
     * Internal errors. Means some invariants expected by underlying
     */
    /**
/*  
    /**
     * an error-space that is not known in this address space.  
     */  
    UNAVAILABLE(12);
 * The OpenSearch Contributors require contributions made to  
     * Operation is not implemented or not supported/enabled in this service.  
     * Unknown error. An example of where this error may be returned is
    private final int code;  
    /**
import org.opensearch.common.annotation.ExperimentalApi;
    UNKNOWN(2),
     */
    ALREADY_EXISTS(6),  
 * Error codes for streaming transport operations, inspired by gRPC and Arrow Flight error codes.
     */
     * that are problematic regardless of the state of the system.
    /**
    /**
     * The caller does not have permission to execute the specified operation.  
     * from INVALID_ARGUMENT. INVALID_ARGUMENT indicates arguments  
     * This can be due to lack of authentication.
    NOT_FOUND(5),
     */
     * Deadline expired before operation could complete.  
     * @param code the numeric code
     * The caller does not have permission to execute the specified operation.  
     * Some resource has been exhausted, perhaps a per-user quota, or  
    /**
    public int code() {  
@ExperimentalApi  
    /**
     * Returns the numeric code of this status.
     */
     * if a Status value received from another address space belongs to
     */
            }
    }
     */  
 * like Arrow Flight RPC.  
    /**
    UNAUTHORIZED(8),  
     */
public enum StreamErrorCode {
     */
     * The operation was cancelled, typically by the caller.
    OK(0),
 */
     * Operation completed successfully.  
                return value;
