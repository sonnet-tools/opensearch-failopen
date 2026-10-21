    }
            oneRow("key00") + "| eval v = crc32(str0) | fields v",
    /** {@code md5(str0)} on a different row, proving the call wasn't constant-folded into
    }
    }
        assertFirstRowString(
    }
    /** RFC 3174 appendix A vector: {@code sha1("hello")} → aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d. */
    protected void onBeforeQuery() throws IOException {
    public void testSha2_512() throws IOException {
        assertFirstRowString(
        assertFirstRowString(
import java.io.IOException;
    }
import java.util.List;
    public void testSha1Hello() throws IOException {
        }
 *       to the opensearch-datafusion Rust UDF (wraps the {@code sha1} crate; emits a
 * Field references prevent Calcite's {@code ReduceExpressionsRule} from constant-folding the
    public void testCrc32AlwaysNonNegative() throws IOException {
    private Object firstRowFirstCell(String ppl) throws IOException {
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
    }
    }
 *       {@code bitLen ∈ {224, 256, 384, 512}}.</li>
        );
            dataProvisioned = true;
 *   <li>{@code md5(x)} — Sig mapping {@code SqlLibraryOperators.MD5 → "md5"} resolves
        assertTrue("crc32 must be numeric, got: " + cell, cell instanceof Number);
        );
        assertFirstRowString(
 *   <li>{@code key04}: str0="OFFICE SUPPLIES"</li>
        Object cell = firstRowFirstCell(ppl);
        assertFirstRowLong(
 *       {@code encode(digest(x, 'shaN'), 'hex')} using DataFusion built-ins for
import org.opensearch.client.Request;
 *       resolves to the opensearch-datafusion Rust UDF (wraps {@code crc32fast},
 * <p>Fixture row values (from {@code datasets/calcs/bulk.json}):
        );
    @Override
    }
        if (dataProvisioned == false) {
        );
 * SPDX-License-Identifier: Apache-2.0
        assertFirstRowString(
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = crc32('a') | fields v");
import org.apache.commons.codec.binary.Hex;
    // ── md5 ─────────────────────────────────────────────────────────────────
    }
    // ── sha2 (adapter-driven: encode(digest(x, 'shaN'), 'hex')) ─────────────
    /** {@code sha2(str0, 256)} on a different row — guards against constant-folding. */
    }
    /** {@code crc32('123456789')} → 0xCBF43926 — canonical IEEE 802.3 reference vector. */
        );
    public void testSha1OnColumn() throws IOException {
    // ── crc32 ───────────────────────────────────────────────────────────────
            DigestUtils.md5Hex("OFFICE SUPPLIES")
    public void testSha2_256DifferentRow() throws IOException {
 *       lowercase 40-character hex string).</li>
            0xCBF43926L
    }
            "aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d"
    }
     *  on the DataFusion side. */
    public void testCrc32StandardReferenceVector() throws IOException {
    }
        assertFirstRowLong(oneRow("key00") + "| eval v = crc32('') | fields v", 0L);
    }
 *   <li>{@code crc32(x)} — Sig mapping {@code SqlLibraryOperators.CRC32 → "crc32"}
    /** {@code sha1(str0)} on row 0. Returns 40-character lowercase hex string. */
    }
            "2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824"
    private static long crc32Reference(String input) {
            oneRow("key00") + "| eval v = sha1('hello') | fields v",
    /** {@code sha2(str0, 256)}. Reference: {@link DigestUtils#sha256Hex(String)}. */
            oneRow("key00") + "| eval v = sha2(\"hello\", 256) | fields v",
 *   <li>{@code key00}: str0="FURNITURE"</li>
 * crypto call on the coordinator, so the hash is actually computed by the DataFusion backend.
        );
    public void testMd5OnColumn() throws IOException {
    /** {@code sha2(str0, 512)} → 9b71d224bd62f3785d96d46ad3ea3d73319bfbc2890caadae2dff72519673ca72323c3d99ba5c11d7c7acc6e14b8c5da0c4663475c2e5c3adef46f73bcdec043 */
        );
    /** {@code crc32('')} → 0. Canonical IEEE 802.3 empty-message checksum. */
            oneRow("key00") + "| eval v = sha1(str0) | fields v",
 *   <li>{@code sha1(x)} — Sig mapping {@code SqlLibraryOperators.SHA1 → "sha1"} resolves
        assertFirstRowString(
 * </ul>
    }
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
}
    public void testSha2_224() throws IOException {
 * <ul>
        );
package org.opensearch.analytics.qa;
        );
 * <p>Each test pins a single row of the {@code calcs} dataset via {@code where key='keyNN'}.
 *
 * DataFusion analytics backend:
        assertFirstRowString(
            oneRow("key00") + "| eval v = crc32('123456789') | fields v",
        assertFirstRowString(
            DatasetProvisioner.provision(client(), DATASET);
    /** {@code sha2(str0, 384)}. Reference: {@link DigestUtils#sha384Hex(String)}. */
        Map<String, Object> response = executePpl(ppl);
    }
        return crc.getValue();
import java.util.zip.CRC32;
    /** {@code sha2("hello", 256)} → 2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824 */
            DigestUtils.sha256Hex("FURNITURE")
    /** Java-side CRC32 reference that matches the Rust UDF's zero-extended {@code u32 → i64} contract.
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    }
    /** Canonical RFC 1321 vector: {@code md5("abc")} → 5d41402abc4b2a76b9719d911017c592. */
        assertFirstRowString(
        assertFirstRowString(
    private void assertFirstRowString(String ppl, String expected) throws IOException {
            DigestUtils.sha512Hex("FURNITURE")
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
public class CryptoFunctionsIT extends AnalyticsRestTestCase {
 *
            DigestUtils.sha384Hex("FURNITURE")
 *   <li>{@code sha2(x, bitLen)} — {@code Sha2FunctionAdapter} rewrites the call into
            DigestUtils.sha1Hex("OFFICE SUPPLIES")
 *       the value is always non-negative, matching PPL's contract.</li>
import java.util.Map;
        assertTrue("crc32 must be non-negative (zero-extended u32), got: " + value, value >= 0);
            DigestUtils.sha256Hex("OFFICE SUPPLIES")
    /** {@code crc32} must be non-negative (zero-extended u32 → i64), even for inputs whose
    public void testSha2_384() throws IOException {
        );
import java.nio.charset.StandardCharsets;
            oneRow("key00") + "| eval v = md5(str0) | fields v",
            oneRow("key00") + "| eval v = sha2(str0, 384) | fields v",
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
 * <ul>
        @SuppressWarnings("unchecked")
    public void testSha2_512_hello() throws IOException {
 */
            oneRow("key00") + "| eval v = md5('hello') | fields v",
        return rows.get(0).get(0);
 * End-to-end coverage for PPL cryptographic hash functions executed through the
    // ── helpers ─────────────────────────────────────────────────────────────
import org.opensearch.client.Response;
        assertFirstRowString(
    /** {@code sha2(str0, 224)} — rewrites to {@code encode(digest(str0, 'sha224'), 'hex')}
 * this file be licensed under the Apache-2.0 license or a
        Object cell = firstRowFirstCell(ppl);
    private String oneRow(String key) {
 *       IEEE 802.3 polynomial); returns BIGINT zero-extended from the u32 result so
    public void testMd5Hello() throws IOException {
    }
        assertEquals(0xE8B7BE43L, value);
     *  {@link java.util.zip.CRC32#getValue()} already returns the unsigned 32-bit value widened to long. */
/*
            oneRow("key04") + "| eval v = sha2(str0, 256) | fields v",
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).longValue());
        CRC32 crc = new CRC32();
            oneRow("key04") + "| eval v = sha1(str0) | fields v",
        );
            oneRow("key00") + "| eval v = sha2(str0, 512) | fields v",
            "5d41402abc4b2a76b9719d911017c592"
import org.apache.commons.codec.digest.DigestUtils;
            DigestUtils.sha1Hex("FURNITURE")
 * The OpenSearch Contributors require contributions made to
        assertFirstRowLong(
        );
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            oneRow("key00") + "| eval v = sha2(\"hello\", 512) | fields v",
    }
 * compatible open source license.
        crc.update(input.getBytes(StandardCharsets.UTF_8));
    /** {@code sha2(str0, 512)}. Reference: {@link DigestUtils#sha512Hex(String)}. */
    // ── sha1 ────────────────────────────────────────────────────────────────
        assertFirstRowString(
    private void assertFirstRowLong(String ppl, long expected) throws IOException {
    }
    /** {@code sha1(str0)} on a different row to verify field-referenced evaluation. */
     *  u32 checksum has the high bit set. {@code "a"} → 0xE8B7BE43 qualifies. */
 * </ul>
        );
 *
                DigestUtils.getDigest(MessageDigestAlgorithms.SHA_224).digest("FURNITURE".getBytes(StandardCharsets.UTF_8)))
    public void testMd5DifferentRow() throws IOException {
 */
/**
            "9b71d224bd62f3785d96d46ad3ea3d73319bfbc2890caadae2dff72519673ca72323c3d99ba5c11d7c7acc6e14b8c5da0c4663475c2e5c3adef46f73bcdec043"
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);
        );
    /** Base query template: filter to exactly one row (cardinality 1) keyed by {@code key}. */
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
        assertFirstRowString(
            oneRow("key00") + "| eval v = sha2(str0, 224) | fields v",
            oneRow("key04") + "| eval v = md5(str0) | fields v",
    public void testSha2_256() throws IOException {
    /** {@code crc32(str0)} matches {@link java.util.zip.CRC32}. */
    private static boolean dataProvisioned = false;
            oneRow("key00") + "| eval v = sha2(str0, 256) | fields v",
 *       to DataFusion's built-in {@code md5} (Utf8 hex string output).</li>
    /** {@code md5(str0)} on row 0 (str0="FURNITURE"). */
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
    public void testSha2_256_hello() throws IOException {
    public void testCrc32EmptyInput() throws IOException {
            Hex.encodeHexString(
    }
     *  row-0's value at plan time. */
    }
    public void testSha1DifferentRow() throws IOException {
            DigestUtils.md5Hex("FURNITURE")
 *
    public void testCrc32OnColumn() throws IOException {
        long value = ((Number) cell).longValue();
            crc32Reference("FURNITURE")
        );
