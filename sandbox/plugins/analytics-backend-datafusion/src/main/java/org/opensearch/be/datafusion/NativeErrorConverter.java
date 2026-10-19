    private static final Pattern POOL_LIMIT_PATTERN = Pattern.compile(  
        );  
    );
            }  
        // native consumer dump); never echo match.message() verbatim.  
     * Carries the matched message and original exception for converter functions.
     * Parses bytes_requested and limit from pool limit error message using regex.
            current = current.getCause();
import java.util.function.Function;  
import java.util.regex.Matcher;
     */
    /**
    /**
    private static long[] parsePoolLimitBytes(String msg) {
            if (msg != null) {  
            long limit = Long.parseLong(m.group(2));
     * Matches the pool limit error format from native_error.rs:  
        logRawNativeError(match, "pool limit exceeded");
                for (ErrorPattern pattern : PATTERNS) {
        }
        if (m.find() == false) {
 * @see <a href="sandbox/plugins/analytics-backend-datafusion/rust/src/native_error.rs">native_error.rs</a>  
     * Logs the verbose native allocator dump ("top memory consumers ... query_untracked(partitions=N,batch=8192)#id  
     * <p>Order matters: more-specific prefixes must precede less-specific ones.
        while (current != null && depth < MAX_CAUSE_CHAIN_DEPTH) {
                        return pattern.converter().apply(new MatchedError(msg, original));  
     */
            return new long[] { bytesRequested, limit };  
        new ErrorPattern("Query too deeply nested", NativeErrorConverter::convertRecursionLimit)
    }
    private static long[] parseControlledPoolLimitBytes(String msg) {  
/*  
        return new OpenSearchStatusException(ADMISSION_REJECTED_MSG, RestStatus.TOO_MANY_REQUESTS);
     * Returns the original exception unchanged if no pattern matches.
/**
    private static Exception convertAdmissionRejection(MatchedError match) {
        Throwable current = original;
        // Rebuild the message from the parsed numbers only (the matched message may carry an appended
        if (m.find() == false) {  
     * "[analytics_backend_datafusion] Failed to allocate {N} bytes (limit: {L})"  
    private static final List<ErrorPattern> PATTERNS = List.of(
        } catch (NumberFormatException e) {
                    }
        if (original instanceof CircuitBreakingException || original instanceof OpenSearchStatusException) {
    private static final Pattern CONTROLLED_POOL_LIMIT_PATTERN = Pattern.compile(
     * Returns [bytesRequested, limit] or null if the message doesn't match the expected format.
     * Key phrases include both the Rust-originated messages (for data-node local conversion)
     */
        logger.warn("[NativeErrorConverter] {} — raw native error: {}", label, match.message());  
        long[] parsed = parsePoolLimitBytes(match.message());
        logRawNativeError(match, "pool limit exceeded (controlled)");
            return original;  
        // No cause attached: the raw native error carries the allocator dump and stays in the server log only.
        }  
        new ErrorPattern("Memory Exhausted while", NativeErrorConverter::convertSpillPoolExhausted),
 *
 */
import org.apache.logging.log4j.LogManager;
public final class NativeErrorConverter {
            return null;
    /**  
    /**
    }
    private NativeErrorConverter() {}  
    private static void logRawNativeError(MatchedError match, String label) {
    }  
            return null;  
     * and the controlled output messages (for coordinator-side conversion after transport).
        String message = "[analytics_backend_datafusion] Failed to allocate " + parsed[0] + " bytes (limit: " + parsed[1] + ")";  
    /**
            0L,
    // ─── Converter functions ────────────────────────────────────────────────────
    /**  
        return new CircuitBreakingException(message, parsed[0], parsed[1], CircuitBreaker.Durability.TRANSIENT);
    }  
    private static final String ADMISSION_REJECTED_MSG = "Native query admission rejected: insufficient memory budget available";  
        return parseLongPair(m);
     * but must not reach the user, so the converted exception carries no cause — its own clean message is the
        return original;
import org.opensearch.OpenSearchStatusException;  
        new ErrorPattern("[analytics_backend_datafusion] Failed to allocate", NativeErrorConverter::convertPoolLimitFromControlled),
     * whole user-facing story. {@code label} identifies the conversion for the server log.  
    private static Exception convertPoolLimitFromControlled(MatchedError match) {
        // Don't re-convert if already a recognized exception type
            return null;
        // Raw prost decoder error when a Substrait plan exceeds the protobuf recursion limit  
    public static Exception convert(Exception original) {  
     * Walks the cause chain looking for messages matching registered patterns.  
    private record MatchedError(String message, Exception original) {  
        new ErrorPattern(ADMISSION_REJECTED_MSG, NativeErrorConverter::convertAdmissionRejection),  
        }  
        );
        int depth = 0;  
    private static long[] parseLongPair(Matcher m) {
     * "Failed to allocate {N} bytes for {consumer} ({reserved} already reserved) — {available} available out of {limit} limit"
    private record ErrorPattern(String keyPhrase, Function<MatchedError, Exception> converter) {  
     * {@code "Failed to allocate"}.  
     */
        "\\[analytics_backend_datafusion] Failed to allocate (\\d+) bytes \\(limit: (\\d+)\\)"  
    }
        return parseLongPair(m);  
     * Maximum depth to walk the exception cause chain when matching error patterns.  
     * {@code "[analytics_backend_datafusion] Failed to allocate"} must come before bare
        String message = "[analytics_backend_datafusion] Failed to allocate " + parsed[0] + " bytes (limit: " + parsed[1] + ")";
 * </ol>
 * this file be licensed under the Apache-2.0 license or a
    );
    );
 * <h2>Adding new error conversions</h2>  
 *
    }
        Matcher m = CONTROLLED_POOL_LIMIT_PATTERN.matcher(msg);
        if (parsed == null) {
}
    /**
import java.util.regex.Pattern;
    private static Exception convertRecursionLimit(MatchedError match) {
import org.apache.logging.log4j.Logger;
        logRawNativeError(match, "spill pool exhausted");  
        return new CircuitBreakingException(  
import org.opensearch.core.common.breaker.CircuitBreakingException;
 * This converter walks the exception cause chain, matches against known error
        // Semantically a memory-pressure error → CircuitBreakingException (HTTP 429).
    // ─── Message parsing ────────────────────────────────────────────────────────  
import org.opensearch.core.common.breaker.CircuitBreaker;
        }  
 * <p>Rust-side errors cross the FFM boundary as {@code RuntimeException(message)}.
     */
 */  
    }  
        logRawNativeError(match, "admission rejected");
     */
 *   <li>Add a {@link ErrorPattern} entry to {@link #PATTERNS} below</li>  
        return new CircuitBreakingException(message, parsed[0], parsed[1], CircuitBreaker.Durability.TRANSIENT);
        // DataFusion's own spill-path error when an operator can't allocate and DiskManager is disabled.  
                + "Simplify the query by reducing nested function calls."
 * The OpenSearch Contributors require contributions made to  
 *
            "[analytics_backend_datafusion] memory pool exhausted (spill unavailable)",
 * corresponding OpenSearch exception with correct HTTP status semantics.
    }
 *   <li>Add a factory function in Rust {@code native_error.rs} with a stable key phrase</li>
 * Converts native (Rust) errors into appropriate OpenSearch exception types.
    private static final Logger logger = LogManager.getLogger(NativeErrorConverter.class);
    }  
            return match.original();
     */
        // (deeply nested function calls). Converted at the FFM boundary into a clean 400.
            CircuitBreaker.Durability.TRANSIENT
            depth++;
package org.opensearch.be.datafusion;
        // Use a fixed clean message — the raw DataFusion text can carry operator internals.
     * Attempts to convert a native error into an appropriate OpenSearch exception.
        }
     * Registered error patterns, checked in order. First match wins.  
        if (parsed == null) {
 * compatible open source license.
        long[] parsed = parseControlledPoolLimitBytes(match.message());  
            "Query too deeply nested: the expression exceeds the maximum nesting depth supported by the execution engine. "
        "Failed to allocate (\\d+) bytes for .+ \\(\\d+ already reserved\\) — \\d+ available out of (\\d+) limit"
            0L,  
 * <ol>
        new ErrorPattern("Cannot reserve untracked memory budget", NativeErrorConverter::convertAdmissionRejection),
     */
                }
    }
 * SPDX-License-Identifier: Apache-2.0
    /**  
        }
     *  
        return new IllegalArgumentException(  
    static final int MAX_CAUSE_CHAIN_DEPTH = 10;
            String msg = current.getMessage();
import java.util.List;
            return match.original();  
    private static Exception convertPoolLimitExceeded(MatchedError match) {  
 *  
        try {  
    /**
    }  
            long bytesRequested = Long.parseLong(m.group(1));
        }
import org.opensearch.core.rest.RestStatus;  
    }
        // Controlled message, as a coordinator-side safety net if it arrives via StreamException.  
        new ErrorPattern("Failed to allocate", NativeErrorConverter::convertPoolLimitExceeded),
     * Matches the controlled pool limit message produced by this converter:
                    if (msg.contains(pattern.keyPhrase())) {
     * A pattern that matches a native error message and converts it to an OpenSearch exception.
 * patterns (defined in Rust's {@code native_error.rs}), and produces the  
        // Bytes/limit aren't part of this DataFusion message; surface 0/0 to keep the type contract.
        new ErrorPattern("recursion limit reached", NativeErrorConverter::convertRecursionLimit),
        Matcher m = POOL_LIMIT_PATTERN.matcher(msg);
        // Log the raw native budget detail server-side; don't attach it as a user-facing cause.  
     * consumed X MB", reservation ids, plan-operator internals) server-side at WARN. It is useful for operators
    private static Exception convertSpillPoolExhausted(MatchedError match) {
     */  
