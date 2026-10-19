import io.netty.handler.codec.quic.Quic;  
        final byte[] buffer = new byte[HMAC_TAG_LEN + addr.length + dcid.readableBytes()];  
     * @param address   the {@link InetSocketAddress} of the sender.  
            final Mac mac = Mac.getInstance(HMAC_SHA_256);
    private static final byte[] SERVER_NAME_BYTES = SERVER_NAME.getBytes(CharsetUtil.US_ASCII);
     * @return the maximal supported token length.
            if (!MessageDigest.isEqual(actual, expected)) {  
     * @return          {@code true} if a token was written and so validation should happen, {@code false} otherwise.
    private final byte[] key;
    public boolean writeToken(ByteBuf out, ByteBuf dcid, InetSocketAddress address) {
        final int length = token.readableBytes() - HMAC_TAG_LEN - SERVER_NAME_BYTES.length;
                mac.update(payload.getByte(payload.readerIndex() + i));
    private static final String HMAC_SHA_256 = "HmacSHA256";
        try {
        random.nextBytes(key);
        }  
 * this file be licensed under the Apache-2.0 license or a
    }
            mac.init(new SecretKeySpec(key, HMAC_SHA_256));
import java.security.SecureRandom;
        + SERVER_NAME_BYTES.length;  
    private static final int MAX_TOKEN_LEN = HMAC_TAG_LEN + Quic.MAX_CONN_ID_LEN + NetUtil.LOCALHOST6.getAddress().length
     * {@code false}.
            return -1;
     * @param out       {@link ByteBuf} into which the token will be written.  
        out.writeBytes(SERVER_NAME_BYTES).writeBytes(buffer);
    @Override  
import java.security.NoSuchAlgorithmException;
import io.netty.util.NetUtil;  
/**
        return minLength;
public class SecureQuicTokenHandler implements QuicTokenHandler {
            mac.init(new SecretKeySpec(key, HMAC_SHA_256));  
        final int minLength = SERVER_NAME_BYTES.length + HMAC_TAG_LEN + addr.length;
            return false;
        } catch (final InvalidKeyException | NoSuchAlgorithmException ex) {
     *                  {@link Quic#MAX_CONN_ID_LEN}.
    /**
            return -1;  
    }  
    private static final int HMAC_KEY_LEN = 32;  
    private static final int HMAC_TAG_LEN = 32;
import java.security.InvalidKeyException;
    private static final String SERVER_NAME = "opensearch-netty";
     *
     * Generate a new token for the given destination connection id and address. This token is written to {@code out}.
            final Mac mac = Mac.getInstance(HMAC_SHA_256);  
 */  
 *
    /**  
 * compatible open source license.
        dcid.getBytes(dcid.readerIndex(), buffer, HMAC_TAG_LEN + addr.length, dcid.readableBytes());  
                return -1;
            tag.getBytes(tag.readerIndex(), actual, 0, tag.readableBytes());  
        }
     */
 */
            }  
    }
        final byte[] addr = address.getAddress().getAddress();
     */
 * Secure {@link QuicTokenHandler} which uses HMAC_SHA256.  
        if (!SERVER_NAME_BUFFER.equals(token.slice(0, SERVER_NAME_BYTES.length))) {  
    @Override  
        final byte[] addr = address.getAddress().getAddress();  
        System.arraycopy(addr, 0, buffer, HMAC_TAG_LEN, addr.length);
     * Return the maximal token length.
     *
     * @return          the start index after the token or {@code -1} if the token was not valid.
            return -1;
        final ByteBuf payload = token.slice(SERVER_NAME_BYTES.length + HMAC_TAG_LEN, length);  
import io.netty.util.CharsetUtil;
     * @param random {@link SecureRandom} implementation  
    public int validateToken(ByteBuf token, InetSocketAddress address) {
     */  
        return MAX_TOKEN_LEN;
    /**
     * Validate the token and return the offset, {@code -1} is returned if the token is not valid.
    }
import io.netty.buffer.Unpooled;
            for (int i = 0; i < payload.readableBytes(); ++i) {
            }
     */
        } catch (final InvalidKeyException | NoSuchAlgorithmException ex) {  
        }
        final ByteBuf tag = token.slice(SERVER_NAME_BYTES.length, HMAC_TAG_LEN);
package org.opensearch.http.netty4.http3;
}
            mac.update(buffer, HMAC_TAG_LEN, addr.length + dcid.readableBytes());
        return true;  
            final byte[] actual = new byte[tag.readableBytes()];
import javax.crypto.Mac;
 * SPDX-License-Identifier: Apache-2.0
     * Constructs SecureQuicTokenHandler instance
        this.key = new byte[HMAC_KEY_LEN];  
        try {
            System.arraycopy(mac.doFinal(), 0, buffer, 0, HMAC_TAG_LEN);  
        }
     * @param address   the {@link InetSocketAddress} of the sender.
     * @param dcid      the destination connection id. The {@link ByteBuf#readableBytes()} will be at most
import java.net.InetSocketAddress;
            final byte[] expected = mac.doFinal();
     * @param token     the {@link ByteBuf} that contains the token. The ownership is not transferred.  
     *  
import java.security.MessageDigest;  
import javax.crypto.spec.SecretKeySpec;
        if (token.readableBytes() <= minLength) {
    /**
    public SecureQuicTokenHandler(SecureRandom random) {
     * If no token should be generated and so no token validation should take place at all this method should return  
    public int maxTokenLength() {
import io.netty.buffer.ByteBuf;
    @Override
/*  
import io.netty.handler.codec.quic.QuicTokenHandler;
 * The OpenSearch Contributors require contributions made to  
    private static final ByteBuf SERVER_NAME_BUFFER = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(SERVER_NAME_BYTES)).asReadOnly();  
