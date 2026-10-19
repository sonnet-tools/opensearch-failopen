    }
    }
    }  
    }
    /** RFC 3174 appendix A vector: {@code sha1("hello")} → aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d. */
        Map<String, Object> response = executePpl(ppl);
 * <p>Fixture row values (from {@code datasets/calcs/bulk.json}):  
/*  
    }
        assertFirstRowString(  
            DigestUtils.sha384Hex("FURNITURE")
        assertFirstRowString(
 * </ul>
import java.nio.charset.StandardCharsets;
            DatasetProvisioner.provision(client(), DATASET);  
        assertTrue("crc32 must be numeric, got: " + cell, cell instanceof Number);  
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
 *   <li>{@code sha2(x, bitLen)} — {@code Sha2FunctionAdapter} rewrites the call into
public class CryptoFunctionsIT extends AnalyticsRestTestCase {  
    }
 * The OpenSearch Contributors require contributions made to  
    }
        assertFirstRowString(
import org.opensearch.client.Request;
            DigestUtils.sha1Hex("OFFICE SUPPLIES")
    }  
            oneRow("key00") + "| eval v = sha2(str0, 384) | fields v",
    /** {@code sha1(str0)} on a different row to verify field-referenced evaluation. */
            0xCBF43926L
    }
    /** {@code sha2(str0, 512)}. Reference: {@link DigestUtils#sha512Hex(String)}. */  
    /** {@code md5(str0)} on row 0 (str0="FURNITURE"). */  
    private static boolean dataProvisioned = false;
    /** Base query template: filter to exactly one row (cardinality 1) keyed by {@code key}. */
        assertFirstRowString(
            DigestUtils.sha256Hex("OFFICE SUPPLIES")
            oneRow("key04") + "| eval v = sha2(str0, 256) | fields v",
        assertFirstRowString(
 *       lowercase 40-character hex string).</li>
            DigestUtils.sha256Hex("FURNITURE")
 *   <li>{@code sha1(x)} — Sig mapping {@code SqlLibraryOperators.SHA1 → "sha1"} resolves
    public void testMd5OnColumn() throws IOException {
import java.util.Map;
 *   <li>{@code crc32(x)} — Sig mapping {@code SqlLibraryOperators.CRC32 → "crc32"}
    /** {@code crc32} must be non-negative (zero-extended u32 → i64), even for inputs whose
        crc.update(input.getBytes(StandardCharsets.UTF_8));  
 *       {@code bitLen ∈ {224, 256, 384, 512}}.</li>
    // ── sha2 (adapter-driven: encode(digest(x, 'shaN'), 'hex')) ─────────────  
        assertFirstRowString(
     *  {@link java.util.zip.CRC32#getValue()} already returns the unsigned 32-bit value widened to long. */  
    /** {@code crc32('123456789')} → 0xCBF43926 — canonical IEEE 802.3 reference vector. */  
import java.io.IOException;
 */
    public void testSha2_384() throws IOException {
        assertFirstRowString(  
 *
        );
    public void testSha2_256_hello() throws IOException {  
        if (dataProvisioned == false) {
/**
    public void testSha2_256DifferentRow() throws IOException {
    private static long crc32Reference(String input) {
import org.apache.commons.codec.binary.Hex;
            oneRow("key04") + "| eval v = md5(str0) | fields v",  
            DigestUtils.md5Hex("FURNITURE")
            oneRow("key00") + "| eval v = sha2(str0, 224) | fields v",  
        );  
    /** {@code sha2(str0, 224)} — rewrites to {@code encode(digest(str0, 'sha224'), 'hex')}
        assertEquals(0xE8B7BE43L, value);
            "2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824"  
 *       IEEE 802.3 polynomial); returns BIGINT zero-extended from the u32 result so
        long value = ((Number) cell).longValue();
 *       resolves to the opensearch-datafusion Rust UDF (wraps {@code crc32fast},  
        );
            oneRow("key00") + "| eval v = sha2(str0, 512) | fields v",  
        );
 * Field references prevent Calcite's {@code ReduceExpressionsRule} from constant-folding the  
    public void testSha1OnColumn() throws IOException {
        CRC32 crc = new CRC32();
     *  row-0's value at plan time. */  
 * <ul>
 * DataFusion analytics backend:  
            oneRow("key04") + "| eval v = sha1(str0) | fields v",
        Object cell = firstRowFirstCell(ppl);
            oneRow("key00") + "| eval v = crc32(str0) | fields v",
    protected void onBeforeQuery() throws IOException {
            DigestUtils.md5Hex("OFFICE SUPPLIES")
    // ── md5 ─────────────────────────────────────────────────────────────────
        }
import java.util.zip.CRC32;
        return rows.get(0).get(0);
        assertTrue("crc32 must be non-negative (zero-extended u32), got: " + value, value >= 0);  
        );
package org.opensearch.analytics.qa;
    public void testSha2_512_hello() throws IOException {  
        );  
import org.apache.commons.codec.digest.DigestUtils;
            crc32Reference("FURNITURE")  
    public void testMd5Hello() throws IOException {  
            oneRow("key00") + "| eval v = sha2(str0, 256) | fields v",  
    /** Canonical RFC 1321 vector: {@code md5("abc")} → 5d41402abc4b2a76b9719d911017c592. */
            oneRow("key00") + "| eval v = sha1('hello') | fields v",
            oneRow("key00") + "| eval v = md5(str0) | fields v",  
    // ── crc32 ───────────────────────────────────────────────────────────────  
 * </ul>  
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
 *   <li>{@code key00}: str0="FURNITURE"</li>
    /** {@code sha1(str0)} on row 0. Returns 40-character lowercase hex string. */  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = crc32('a') | fields v");
        return crc.getValue();
            oneRow("key00") + "| eval v = sha2(\"hello\", 512) | fields v",
 * End-to-end coverage for PPL cryptographic hash functions executed through the
            oneRow("key00") + "| eval v = sha2(\"hello\", 256) | fields v",
 * SPDX-License-Identifier: Apache-2.0
    private void assertFirstRowString(String ppl, String expected) throws IOException {
        assertFirstRowString(  
 *       to the opensearch-datafusion Rust UDF (wraps the {@code sha1} crate; emits a  
    /** {@code sha2("hello", 256)} → 2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824 */
            "9b71d224bd62f3785d96d46ad3ea3d73319bfbc2890caadae2dff72519673ca72323c3d99ba5c11d7c7acc6e14b8c5da0c4663475c2e5c3adef46f73bcdec043"  
            DigestUtils.sha1Hex("FURNITURE")
            dataProvisioned = true;
    /** {@code sha2(str0, 256)}. Reference: {@link DigestUtils#sha256Hex(String)}. */  
            "aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d"  
 * compatible open source license.
        );
 */  
        @SuppressWarnings("unchecked")  
            Hex.encodeHexString(
    public void testSha2_256() throws IOException {
    }  
 *       the value is always non-negative, matching PPL's contract.</li>
    /** {@code crc32(str0)} matches {@link java.util.zip.CRC32}. */
 * <p>Each test pins a single row of the {@code calcs} dataset via {@code where key='keyNN'}.
        assertFirstRowLong(oneRow("key00") + "| eval v = crc32('') | fields v", 0L);  
    }
    }
        assertFirstRowString(
import java.util.List;  
        );
import org.apache.commons.codec.digest.MessageDigestAlgorithms;  
    // ── helpers ─────────────────────────────────────────────────────────────  
    public void testCrc32OnColumn() throws IOException {  
    /** Java-side CRC32 reference that matches the Rust UDF's zero-extended {@code u32 → i64} contract.
 * <ul>
        );
    }  
    }  
 * this file be licensed under the Apache-2.0 license or a
    }
    }
            oneRow("key00") + "| eval v = md5('hello') | fields v",
    }
    // ── sha1 ────────────────────────────────────────────────────────────────
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);  
 *
                DigestUtils.getDigest(MessageDigestAlgorithms.SHA_224).digest("FURNITURE".getBytes(StandardCharsets.UTF_8)))
    /** {@code crc32('')} → 0. Canonical IEEE 802.3 empty-message checksum. */
 *   <li>{@code md5(x)} — Sig mapping {@code SqlLibraryOperators.MD5 → "md5"} resolves  
    }
import org.opensearch.client.Response;
        assertFirstRowString(
        assertFirstRowLong(
 *
     *  u32 checksum has the high bit set. {@code "a"} → 0xE8B7BE43 qualifies. */  
    }
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);  
    }  
 *   <li>{@code key04}: str0="OFFICE SUPPLIES"</li>  
        );
            oneRow("key00") + "| eval v = sha1(str0) | fields v",  
 *       to DataFusion's built-in {@code md5} (Utf8 hex string output).</li>
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).longValue());
    public void testCrc32EmptyInput() throws IOException {
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    @Override  
    private void assertFirstRowLong(String ppl, long expected) throws IOException {
        );  
        assertFirstRowString(
        );
 *
    public void testCrc32StandardReferenceVector() throws IOException {
        );
            "5d41402abc4b2a76b9719d911017c592"  
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
        Object cell = firstRowFirstCell(ppl);
    }  
    }
    }
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        );  
}
 *       {@code encode(digest(x, 'shaN'), 'hex')} using DataFusion built-ins for  
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);  
    public void testCrc32AlwaysNonNegative() throws IOException {
    /** {@code sha2(str0, 384)}. Reference: {@link DigestUtils#sha384Hex(String)}. */
        assertFirstRowString(
            DigestUtils.sha512Hex("FURNITURE")
        );
    /** {@code sha2(str0, 512)} → 9b71d224bd62f3785d96d46ad3ea3d73319bfbc2890caadae2dff72519673ca72323c3d99ba5c11d7c7acc6e14b8c5da0c4663475c2e5c3adef46f73bcdec043 */
    public void testSha1Hello() throws IOException {  
    /** {@code sha2(str0, 256)} on a different row — guards against constant-folding. */
    private String oneRow(String key) {  
     *  on the DataFusion side. */  
        assertFirstRowLong(
    private Object firstRowFirstCell(String ppl) throws IOException {
    /** {@code md5(str0)} on a different row, proving the call wasn't constant-folded into
        assertFirstRowString(
    public void testSha2_512() throws IOException {
    public void testSha2_224() throws IOException {
    public void testMd5DifferentRow() throws IOException {
            oneRow("key00") + "| eval v = crc32('123456789') | fields v",  
 * crypto call on the coordinator, so the hash is actually computed by the DataFusion backend.
    public void testSha1DifferentRow() throws IOException {
