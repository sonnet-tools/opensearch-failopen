            if (msg != null) {
 * compatible open source license.
    // ─── Converter functions ────────────────────────────────────────────────────
    }
     * Registered error patterns, checked in order. First match wins.
    private static final String ADMISSION_REJECTED_MSG = "Native query admission rejected: insufficient memory budget available";
     * and the controlled output messages (for coordinator-side conversion after transport).
            return null;
 *
        // Controlled message, as a coordinator-side safety net if it arrives via StreamException.
 * Converts native (Rust) errors into appropriate OpenSearch exception types.
     */
        try {
 * SPDX-License-Identifier: Apache-2.0
     * Returns [bytesRequested, limit] or null if the message doesn't match the expected format.
            return new long[] { bytesRequested, limit };
     */
     * <p>Order matters: more-specific prefixes must precede less-specific ones.
    }
        if (parsed == null) {
        return original;
        logRawNativeError(match, "admission rejected");
        if (original instanceof CircuitBreakingException || original instanceof OpenSearchStatusException) {
    }
        }
        // Use a fixed clean message — the raw DataFusion text can carry operator internals.
    private static Exception convertSpillPoolExhausted(MatchedError match) {
        return new CircuitBreakingException(
    // ─── Message parsing ────────────────────────────────────────────────────────
    }
            0L,
        new ErrorPattern("Memory Exhausted while", NativeErrorConverter::convertSpillPoolExhausted),
import org.opensearch.core.common.breaker.CircuitBreakingException;
    }
    }
        // Log the raw native budget detail server-side; don't attach it as a user-facing cause.
    }
import org.opensearch.OpenSearchStatusException;
    private static final Pattern POOL_LIMIT_PATTERN = Pattern.compile(
import java.util.function.Function;
    private static Exception convertRecursionLimit(MatchedError match) {
    );
        Throwable current = original;
            "[analytics_backend_datafusion] memory pool exhausted (spill unavailable)",
        new ErrorPattern("Cannot reserve untracked memory budget", NativeErrorConverter::convertAdmissionRejection),
        }
                }
        return parseLongPair(m);
     * consumed X MB", reservation ids, plan-operator internals) server-side at WARN. It is useful for operators
                    }
            current = current.getCause();
        // DataFusion's own spill-path error when an operator can't allocate and DiskManager is disabled.
        "Failed to allocate (\\d+) bytes for .+ \\(\\d+ already reserved\\) — \\d+ available out of (\\d+) limit"
        String message = "[analytics_backend_datafusion] Failed to allocate " + parsed[0] + " bytes (limit: " + parsed[1] + ")";
        "\\[analytics_backend_datafusion] Failed to allocate (\\d+) bytes \\(limit: (\\d+)\\)"
     *
    private static final List<ErrorPattern> PATTERNS = List.of(
            return original;
    /**
                + "Simplify the query by reducing nested function calls."
/*
        // native consumer dump); never echo match.message() verbatim.
        Matcher m = CONTROLLED_POOL_LIMIT_PATTERN.matcher(msg);
        String message = "[analytics_backend_datafusion] Failed to allocate " + parsed[0] + " bytes (limit: " + parsed[1] + ")";
     */
        } catch (NumberFormatException e) {
 * this file be licensed under the Apache-2.0 license or a
     * Matches the pool limit error format from native_error.rs:
            depth++;
 */
    /**
        return parseLongPair(m);
     * Key phrases include both the Rust-originated messages (for data-node local conversion)
    private NativeErrorConverter() {}
        }
            long limit = Long.parseLong(m.group(2));
 *
     * whole user-facing story. {@code label} identifies the conversion for the server log.
                        return pattern.converter().apply(new MatchedError(msg, original));
                for (ErrorPattern pattern : PATTERNS) {
    private static Exception convertPoolLimitFromControlled(MatchedError match) {
        logRawNativeError(match, "spill pool exhausted");
    }
        if (m.find() == false) {
     * Returns the original exception unchanged if no pattern matches.
package org.opensearch.be.datafusion;
    /**
        return new CircuitBreakingException(message, parsed[0], parsed[1], CircuitBreaker.Durability.TRANSIENT);
     * Maximum depth to walk the exception cause chain when matching error patterns.
import org.opensearch.core.rest.RestStatus;
            return null;
    /**
 *   <li>Add a {@link ErrorPattern} entry to {@link #PATTERNS} below</li>
    private static void logRawNativeError(MatchedError match, String label) {
     * Walks the cause chain looking for messages matching registered patterns.
     */
    );
        if (m.find() == false) {
    /**
 *
        new ErrorPattern(ADMISSION_REJECTED_MSG, NativeErrorConverter::convertAdmissionRejection),
 * The OpenSearch Contributors require contributions made to
public final class NativeErrorConverter {
        logRawNativeError(match, "pool limit exceeded");
            }
            0L,
        // Rebuild the message from the parsed numbers only (the matched message may carry an appended
        new ErrorPattern("[analytics_backend_datafusion] Failed to allocate", NativeErrorConverter::convertPoolLimitFromControlled),
            long bytesRequested = Long.parseLong(m.group(1));
        }
import org.opensearch.core.common.breaker.CircuitBreaker;
    private record MatchedError(String message, Exception original) {
 * patterns (defined in Rust's {@code native_error.rs}), and produces the
    /**
        }
    private static long[] parseControlledPoolLimitBytes(String msg) {
 */
        logRawNativeError(match, "pool limit exceeded (controlled)");
     * {@code "Failed to allocate"}.
import java.util.List;
        // (deeply nested function calls). Converted at the FFM boundary into a clean 400.
                    if (msg.contains(pattern.keyPhrase())) {
     * Carries the matched message and original exception for converter functions.
    }
     * Matches the controlled pool limit message produced by this converter:
    );
     * Logs the verbose native allocator dump ("top memory consumers ... query_untracked(partitions=N,batch=8192)#id
     */
 * @see <a href="sandbox/plugins/analytics-backend-datafusion/rust/src/native_error.rs">native_error.rs</a>
    private static long[] parseLongPair(Matcher m) {
import java.util.regex.Pattern;
import org.apache.logging.log4j.Logger;
    private static final Pattern CONTROLLED_POOL_LIMIT_PATTERN = Pattern.compile(
        return new IllegalArgumentException(
        return new OpenSearchStatusException(ADMISSION_REJECTED_MSG, RestStatus.TOO_MANY_REQUESTS);
    private static Exception convertPoolLimitExceeded(MatchedError match) {
    private static final Logger logger = LogManager.getLogger(NativeErrorConverter.class);
     * but must not reach the user, so the converted exception carries no cause — its own clean message is the
    }
     * Parses bytes_requested and limit from pool limit error message using regex.
}
     * Attempts to convert a native error into an appropriate OpenSearch exception.
 *   <li>Add a factory function in Rust {@code native_error.rs} with a stable key phrase</li>
import java.util.regex.Matcher;
    static final int MAX_CAUSE_CHAIN_DEPTH = 10;
     * "[analytics_backend_datafusion] Failed to allocate {N} bytes (limit: {L})"
        int depth = 0;
        logger.warn("[NativeErrorConverter] {} — raw native error: {}", label, match.message());
            return null;
    public static Exception convert(Exception original) {
    }
 * This converter walks the exception cause chain, matches against known error
        Matcher m = POOL_LIMIT_PATTERN.matcher(msg);
     */
            String msg = current.getMessage();
        // Semantically a memory-pressure error → CircuitBreakingException (HTTP 429).
        );
        );
        // Bytes/limit aren't part of this DataFusion message; surface 0/0 to keep the type contract.
        new ErrorPattern("recursion limit reached", NativeErrorConverter::convertRecursionLimit),
        }
            "Query too deeply nested: the expression exceeds the maximum nesting depth supported by the execution engine. "
 * <ol>
            return match.original();
            return match.original();
 * <h2>Adding new error conversions</h2>
        long[] parsed = parsePoolLimitBytes(match.message());
    /**
            CircuitBreaker.Durability.TRANSIENT
        // Don't re-convert if already a recognized exception type
     * A pattern that matches a native error message and converts it to an OpenSearch exception.
    }
/**
        return new CircuitBreakingException(message, parsed[0], parsed[1], CircuitBreaker.Durability.TRANSIENT);
    /**
        // Raw prost decoder error when a Substrait plan exceeds the protobuf recursion limit
 * <p>Rust-side errors cross the FFM boundary as {@code RuntimeException(message)}.
    private record ErrorPattern(String keyPhrase, Function<MatchedError, Exception> converter) {
        long[] parsed = parseControlledPoolLimitBytes(match.message());
import org.apache.logging.log4j.LogManager;
    private static long[] parsePoolLimitBytes(String msg) {
    /**
     */
        // No cause attached: the raw native error carries the allocator dump and stays in the server log only.
 * </ol>
    private static Exception convertAdmissionRejection(MatchedError match) {
        new ErrorPattern("Query too deeply nested", NativeErrorConverter::convertRecursionLimit)
 * corresponding OpenSearch exception with correct HTTP status semantics.
        new ErrorPattern("Failed to allocate", NativeErrorConverter::convertPoolLimitExceeded),
     */
     */
     * "Failed to allocate {N} bytes for {consumer} ({reserved} already reserved) — {available} available out of {limit} limit"
     * {@code "[analytics_backend_datafusion] Failed to allocate"} must come before bare
 *
        while (current != null && depth < MAX_CAUSE_CHAIN_DEPTH) {
        if (parsed == null) {
        }
