import java.net.InetAddress;
                socket = new Socket(InetAddress.getByName(host), port);
        /**
                        e.getMessage()
 * @see <a href="https://github.com/opensearch-project/security/blob/d526c9f6c2a438c14db8b413148204510b9fe2e2/src/main/java/org/opensearch/security/ssl/util/SSLConnectionTestUtil.java">SSLConnectionTestUtil</a>
                pingSucceeded = true;
        this.host = host;
            outputStreamWriter.write(DUAL_MODE_CLIENT_HELLO_MSG);
import java.io.IOException;
        this.testInputStreamReader = testInputStreamReader;
            int byteBufIndex = 0;
 * SPDX-License-Identifier: Apache-2.0
            byte[] response = new byte[6];
}
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.Logger;
import java.io.InputStream;
            return SSLConnectionTestResult.SSL_NOT_AVAILABLE;
    }
    private OutputStreamWriter testOutputStreamWriter = null;
            socket.setSoTimeout(SOCKET_TIMEOUT_MILLIS);
    enum SSLConnectionTestResult {
            logger.debug("Closing DualSSL check client socket for {}", host);
        (byte) 'E',
import java.net.Socket;
    private static final Logger logger = LogManager.getLogger(SecureConnectionTestUtil.class);
        }
        SSL_AVAILABLE
                }
                }
        if (sendDualSSLClientHello()) {
            logger.debug("Sending OpenSearch Ping to {}", host);
    protected SecureConnectionTestUtil(
            } else {
            } else {
        try {
        final int port,
                inputStreamReader = testInputStreamReader;
    ) {
        try {
            return SSLConnectionTestResult.SSL_AVAILABLE;
        } finally {
                inputStreamReader = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
                socket = overriddenSocket;
        final Socket overriddenSocket,
         */
            }
                try {
        final String host,
                response[byteBufIndex] = (byte) currentByte;
                    }
     * Test connection to server by performing the below steps:
        this.testOutputStreamWriter = testOutputStreamWriter;
            if (overriddenSocket != null) {
            }
            if (socket != null) {
        boolean pingSucceeded = false;
                sb.append((char) currentChar);
            if (byteBufIndex == 6) {
            outputStream.flush();
        return SSLConnectionTestResult.OPENSEARCH_PING_FAILED;
        } finally {
            int currentByte;
                        break;
                byteBufIndex++;
     * Return codes for SSLConnectionTestUtil.testConnection()
        (byte) 'S',
            while ((currentChar = inputStreamReader.read()) != -1) {
                } catch (IOException e) {
                } catch (IOException e) {
import org.apache.logging.log4j.LogManager;
    public static final String DUAL_MODE_SERVER_HELLO_MSG = "DUALSM";
            StringBuilder sb = new StringBuilder();
        (byte) 0xFF };
        return pingSucceeded;
        this.port = port;
        logger.debug("dualSslClient check with server {}, server supports ssl = {}", host, dualSslSupported);
                        // Unexpected byte in response
         */
         */
import java.io.OutputStream;
        this.overriddenSocket = overriddenSocket;
    /**
            socket.setSoTimeout(SOCKET_TIMEOUT_MILLIS);
            }
            }
                socket = overriddenSocket;
    private static final int SOCKET_TIMEOUT_MILLIS = 10 * 1000;
                    );
            }
        (byte) 0xFF,
        (byte) 0xFF,
 *
                dualSslSupported = true;
            }
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
                        "Exception occurred while closing DualSSL check client socket for {}. Exception: {}",
    private boolean sendOpenSearchPing() {
    /**
 */
            outputStream.write(OPENSEARCH_PING_MSG);
     * @return SSLConnectionTestResult i.e. OPENSEARCH_PING_FAILED or SSL_NOT_AVAILABLE or SSL_AVAILABLE
    }
     * - Send Client Hello to check if the server replies with Server Hello which indicates that Server understands SSL
            logger.error("OpenSearch Ping failed for {}, exception: {}", host, ex.getMessage());
            logger.debug("DualSSL client check failed for {}, exception {}", host, e.getMessage());
                outputStreamWriter = testOutputStreamWriter;
    private InputStreamReader testInputStreamReader = null;
    public static final String DUAL_MODE_CLIENT_HELLO_MSG = "DUALCM";
 *
import java.io.OutputStreamWriter;
            if (overriddenSocket != null) {
         * Server supports SSL.
class SecureConnectionTestUtil {
            InputStreamReader inputStreamReader;
            if (socket != null) {
         * OpenSearch Ping to the server failed.
        this.host = host;
        /**
        }
     */
    }
                        logger.error("Received unexpected byte in OpenSearch Ping reply from {}", host);
        boolean dualSslSupported = false;
        final OutputStreamWriter testOutputStreamWriter,
                socket = new Socket(InetAddress.getByName(host), port);
    public SecureConnectionTestUtil(final String host, final int port) {
            int currentChar;
                    if (response[i] != OPENSEARCH_PING_MSG[i]) {
 * compatible open source license.
        /**
 * Modifications Copyright OpenSearch Contributors. See
     * - Send OpenSearch Ping to check if the server replies to the OpenSearch Ping message
            OutputStream outputStream = socket.getOutputStream();
     *
            logger.debug("Closing OpenSearch Ping client socket for connection to {}", host);
        if (sendOpenSearchPing()) {
            InputStream inputStream = socket.getInputStream();
        Socket socket = null;
                logger.debug("Received DualSSL Server Hello msg from {}", host);
            OutputStreamWriter outputStreamWriter;
        }
package org.opensearch.transport.netty4.ssl;
                logger.debug("Received reply for OpenSearch Ping. from {}", host);
    public static final byte[] OPENSEARCH_PING_MSG = new byte[] {
     */
                }
                try {
    }
import java.nio.charset.StandardCharsets;
    private final String host;
import java.io.InputStreamReader;
                    socket.close();
 */
        } catch (IOException e) {
            logger.debug("Sent DualSSL Client Hello msg to {}", host);
    private final int port;
        }
                for (int i = 0; i < 6; i++) {
                    logger.error(
/*
 *
                        host,
            if (sb.toString().equals(DUAL_MODE_SERVER_HELLO_MSG)) {
    }
            outputStreamWriter.flush();
 * GitHub history for details.
                    socket.close();
        logger.debug("OpenSearch Ping check to server {} result = {}", host, pingSucceeded);
    }
    private boolean sendDualSSLClientHello() {
            }
        return dualSslSupported;
 * Utility class to test if the server supports SSL connections.
 * side has OpenSearchPortUnificationHandler it will reply with server hello message.
                    logger.error("Exception occurred while closing socket for {}. Exception: {}", host, e.getMessage());
 * The OpenSearch Contributors require contributions made to
        Socket socket = null;
        OPENSEARCH_PING_FAILED,
/**
        } catch (IOException ex) {
        (byte) 0xFF,
 * SSL Check will be done by sending an OpenSearch Ping to see if server is replying to pings.
        this.port = port;
                        pingSucceeded = false;
    public SSLConnectionTestResult testConnection() {
    private Socket overriddenSocket = null;
        final InputStreamReader testInputStreamReader
         * Server does not support SSL.
 * Following that a custom client hello message will be sent to the server, if the server
            while ((byteBufIndex < 6) && ((currentByte = inputStream.read()) != -1)) {
            }
        SSL_NOT_AVAILABLE,
