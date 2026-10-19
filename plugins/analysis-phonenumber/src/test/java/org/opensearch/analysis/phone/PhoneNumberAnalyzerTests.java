    }
    }
        ts.close();
     * Unlike {@link #assertTokenStreamContents(TokenStream, String[])} this only asserts whether the generated tokens
    public void testLocalNumberWithCH() throws IOException {
    private void assertTokensAreInAnyOrder(final Analyzer analyzer, final String input, final List<String> expectedTokens)
                "441344",
     * contain the required ones but does not check for completeness or order.
    }
        assertTokensInclude("sip:222@autosbcpc", Arrays.asList("222"));
        phoneCHAnalyzer = analysis.indexAnalyzers.get("phone-ch");
    }
        assertTokensInclude(phoneCHAnalyzer, "0583161010", Arrays.asList("41", "41583161010", "583161010"));
     * This uses {@link #phoneAnalyzer}.
        assertTokensInclude(phoneCHAnalyzer, "+41583161010", Arrays.asList("41", "41583161010", "583161010"));
                "44134484",
        assertThat(allTokens, arrayContainingInAnyOrder(expectedTokens.toArray()));
                "13448",
}
     */
        assertTokensInclude("tel:+12177148350", Arrays.asList("1", "217", "2177", "2177148350", "12177148350"));
    public void testSipWithTelephoneExtension() throws IOException {
    @BeforeClass
                "44134",
    }
    private List<String> getAllTokens(final TokenStream ts) throws IOException {
        assertNotNull(phoneCHAnalyzer);
                "4413",
                "441344840400",
        // when omitting the international prefix swiss numbers must start with '0'
    }
import org.junit.BeforeClass;
        assertTokensAreInAnyOrder(phoneSearchAnalyzer, "+41583161010", Arrays.asList("+41583161010", "41583161010"));
    public void testSearchInternationalPrefixWithZZ() throws IOException {
    }
                "tel:+441344840400",
    }
    public void testSipWithoutDomainPart() throws IOException {
    }
    }
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
        assertTokensInclude("tel:+498362930830", Arrays.asList("49", "498362930830", "8362930830"));
    public void testEuropeDetailled() throws IOException {
    public void testSipWithNumericUsername() throws IOException {
                "44134484040"
 * compatible open source license.
/*
     * Test for all tokens which are emitted by the "phone" analyzer.
        );
    }
        final var ts = analyzer.tokenStream("test", input);
     * contain the required ones but does not check for completeness or order.
        return tokens;
            new PhoneNumberAnalysisPlugin()
    }
                "1344840",
        assertTokensInclude(phoneCHAnalyzer, "0041583161010", Arrays.asList("41", "41583161010", "583161010"));
     * Unlike {@link #assertTokenStreamContents(TokenStream, String[])} this only asserts whether the generated tokens
    public void testSipWithCountryCode() throws IOException {
            phoneAnalyzer,
                "44",
        this.assertTokensInclude(phoneAnalyzer, input, expectedTokens);
        assertTokensAreInAnyOrder(phoneSearchAnalyzer, "tel:+1228", Arrays.asList("tel:+1228", "1228"));
                "13",
 * The OpenSearch Contributors require contributions made to
    }
    public void testEurope() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    public void testPhoneNumberWithoutPrefix() throws IOException {
        assertTokensInclude("+1228", Arrays.asList("1228", "122", "228"));
 */
    private void assertTokensInclude(final Analyzer analyzer, final String input, final List<String> expectedTokens) throws IOException {
                "134484040",
        );
            tokens.add(termAtt.toString());
    }
        assertTokensAreInAnyOrder(phoneSearchAnalyzer, "tel:+441344840400", Arrays.asList("tel:+441344840400", "441344840400"));
                "134484",
        while (ts.incrementToken()) {
        assertTokensInclude("tel:+18337148350", Arrays.asList("1", "833", "8337", "8337148350", "18337148350"));
        for (final var expectedToken : expectedTokens) {
    }
    }
                "134",
            Arrays.asList(
            assertThat(allTokens, hasItemInArray(expectedToken));
    /**
    }
package org.opensearch.analysis.phone;
        }
    }
            "tel:+441344840400",
    }
    public void testCoffeeShopInIreland() throws IOException {
    public void testInternationalPrefixWithZZ() throws IOException {
    }
    public void testTelPrefixSearch() throws IOException {
        assertTokensAreInAnyOrder(phoneSearchCHAnalyzer, "0041583161010", Arrays.asList("0041583161010", "41583161010"));
    public void testTelPrefix() throws IOException {
                "tel:",
        assertTokensInclude("tel:+441344840400", Arrays.asList("44", "1344", "1344840400", "441344840400"));
        final var ts = analyzer.tokenStream("test", input);
    }
    private static Analyzer phoneSearchAnalyzer;
                "441",
import org.opensearch.index.analysis.AnalysisTestsHelper;
    public void testSearchNationalPrefixWithCH() throws IOException {
        assertTokensAreInAnyOrder(phoneSearchCHAnalyzer, "+41583161010", Arrays.asList("+41583161010", "41583161010"));
     * contain the required ones but does not check for order. Use {@link #assertTokensInclude} if completeness is not needed.
    public void testNewTollFreeNumber() throws IOException {
                "1",
    }
    public void testNationalPrefixWithCH() throws IOException {
        assertTokensInclude("tel:8177148350", Arrays.asList("817", "8177", "81771", "817714", "8177148350"));
                "13448404",
                "441344840",
    private static Analyzer phoneCHAnalyzer;
import org.apache.lucene.analysis.TokenStream;
        phoneSearchCHAnalyzer = analysis.indexAnalyzers.get("phone-search-ch");
        assertTokensInclude("tel:5551234", Arrays.asList("5551234"));
                "1344",
        assertNotNull(phoneSearchAnalyzer);
        // when omitting the international prefix swiss numbers must start with '0'
    public void testTruncatedNumber() throws IOException {
        assertTokensInclude("tel:+61293344555", Arrays.asList("61", "293344555", "61293344555"));
        assertTokensInclude("sip:JeffSIP@178.12.220.18", Arrays.asList("JeffSIP"));
        // + is equivalent to 00 in Switzerland
            )
        final var analysis = AnalysisTestsHelper.createTestAnalysisFromClassPath(
    /**
    }
    private void assertTokensInclude(final String input, final List<String> expectedTokens) throws IOException {
import org.opensearch.test.OpenSearchTokenStreamTestCase;
    }
    public static void beforeClass() throws IOException {
                "4413448",
import java.util.Arrays;
    }
    }
        assertTokensInclude("test", Arrays.asList("test"));
        assertTokensInclude("tel:+442890319416", Arrays.asList("44", "289", "2890319416", "442890319416"));
    public void testTelWithCountryCode() throws IOException {
    }
                "1344840400",
        assertTokensAreInAnyOrder(phoneSearchCHAnalyzer, "0583161010", Arrays.asList("0583161010", "41583161010"));
    }
 *
public class PhoneNumberAnalyzerTests extends OpenSearchTokenStreamTestCase {
            RESOURCE,
    public void testMissingCountryCode() throws IOException {
     */
     * Test for all tokens which are emitted by the "phone" analyzer.
        assertTokensAreInAnyOrder(
    }
    /**
                "4413448404",
    public void testTelWithCountryCode2() throws IOException {
        // + is equivalent to 00 in Switzerland
    }
    public void testGarbageInGarbageOut() throws IOException {
     */
    public void testSipWithAlphabeticUsername() throws IOException {
     * Unlike {@link #assertTokenStreamContents(TokenStream, String[])} this only asserts whether the generated tokens
        phoneAnalyzer = analysis.indexAnalyzers.get("phone");
        assertTokensInclude("+14177141363", Arrays.asList("14177141363", "417", "4177", "14177"));
    public void testNumberPrefix() throws IOException {
    /**
    }
        assertTokensInclude("sip:+13169410766;ext=2233@178.17.10.117:8060", Arrays.asList("316", "2233", "1316"));
        ts.end();
        final var termAtt = ts.getAttribute(CharTermAttribute.class);
    public void testBMWofSydney() throws IOException {
    public void testInternationalPrefixWithCH() throws IOException {
    }
        assertTokensInclude("sip:abc@autosbcpc", Arrays.asList("abc"));
        assertTokensInclude(phoneAnalyzer, "+41583161010", Arrays.asList("41", "41583161010", "583161010"));
    public void testSearchInternationalPrefixWithCH() throws IOException {
import org.apache.lucene.analysis.Analyzer;
    }
    public void testSearchLocalNumberWithCH() throws IOException {
        assertTokensInclude("tel:+17177158163", Arrays.asList("1", "717", "7177", "17177158163"));
        final var tokens = new ArrayList<String>();
     */
    }
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import java.util.List;
            createTempDir(),
    public void testEuropeDetailledSearch() throws IOException {
    }
    /**
import java.io.IOException;
    private static Analyzer phoneSearchCHAnalyzer;
        final var allTokens = getAllTokens(ts).toArray();
import static org.hamcrest.Matchers.hasItemInArray;
        assertNotNull(phoneSearchCHAnalyzer);
    public void testGermanCastle() throws IOException {
        throws IOException {
        assertTokensInclude("sip:+122882", Arrays.asList("122882", "122", "228", "1228", "2288", "12288"));
import java.util.ArrayList;
    private static final String RESOURCE = "/org/opensearch/analysis/phone/phone_analysis.json";
        assertNotNull(phoneAnalyzer);
        ts.reset();
    public void testSipWithUsername() throws IOException {
        final var allTokens = getAllTokens(ts).toArray();
        assertTokensInclude(phoneAnalyzer, "tel:+1228", Arrays.asList("tel:+1228", "tel:", "1228", "122", "228"));
        phoneSearchAnalyzer = analysis.indexAnalyzers.get("phone-search");
 * SPDX-License-Identifier: Apache-2.0
        }
        assertTokensInclude("sip:+14177141363@178.97.105.13;isup-oli=0;pstn-params=808481808882", Arrays.asList("417", "4177", "14177"));
    private static Analyzer phoneAnalyzer;
     */
