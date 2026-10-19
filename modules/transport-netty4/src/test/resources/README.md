    -passin pass:"$PW"
# 1 Create a server & root (self-signed) CAs
    -sigopt rsa_padding_mode:pss \
keytool -importkeystore \
# 4. Import the certificate into BCFKS keystore
openssl pkcs12 -export \
    -days 8192 \
    -providername BCFIPS \
    -in server.csr \
    -provider org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider \
prompt             = no
    -srcstoretype PKCS12 \
    -destkeystore netty4-server-keystore.bcfks \
openssl req -new -nodes \
    -srckeystore netty4-client-truststore.p12 \
    -CA root.crt \
└── Server certificate
    -file root.crt \
    -srcstoretype PKCS12 \
subjectAltName = DNS:localhost, IP:127.0.0.1, IP:::1
openssl x509 -req \
```bash
    -provider org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider \
```bash
    -deststorepass "$PW" \
    -srckeystore netty4-server-keystore.p12 \
    -sigopt rsa_pss_saltlen:-1
    -passout pass:"$PW" \
    -srcstorepass "$PW" \
    -keystore netty4-client-truststore.p12 \
    -srcstoretype PKCS12 \
openssl req -x509 -new -nodes -keyout root.key -out root.crt -days 8192 -subj "/CN=Root CA"
# 2. Export the certificates in pkcs12 format
    -name netty4-server-keystore \
    -noprompt \
```
    -srcstoretype PKCS12 \
OU = opensearch
```
    -deststoretype BCFKS \
    -deststorepass "$PW"
" > openssl.conf
    -keyout server.key \
#
    -providerpath $LIB_PATH/bc-fips-2.0.0.jar
    -srcstorepass "$PW" \
#
    -storepass "$PW" \
keytool -import -trustcacerts \
    -srckeystore netty4-client-truststore.p12 \
```
    -noprompt
```bash
O  = org
    -out netty4-server-keystore.p12 \
    -CAcreateserial \
    -destkeystore netty4-client-truststore.jks \
    -in server.crt \
export PW='password'
```
    -deststoretype BCFKS \
    -destkeystore netty4-server-keystore.jks \
    -providername BCFIPS \
    -config openssl.conf
"[ req ]
# This is README describes how the certificates in this directory were created.
    -alias root-ca \
Root CA
    -deststorepass "$PW" \
# 3. Import the certificate into JDK keystore (PKCS12 type)
keytool -importkeystore \
    -inkey server.key \
default_bits       = 2048
keytool -importkeystore \
req_extensions     = SAN
    -out server.crt \
[ dn ]
#!/usr/bin/env bash
    -srckeystore netty4-server-keystore.p12 \
# This file can also be executed as a script
    -extfile openssl.conf \
    -noprompt \
    -destkeystore netty4-client-truststore.bcfks \
    -srcstorepass "$PW" \
distinguished_name = dn
export LIB_PATH="/path/to/lib/folder"
keytool -importkeystore \
CN = OpenSearch Test
    -out server.csr \
    -providerpath $LIB_PATH/bc-fips-2.0.0.jar
default_md         = sha256
    -deststorepass "$PW"
```
printf '%s\n' \
    -srcstorepass "$PW" \
    -extensions SAN \
```bash
    -CAkey root.key \
```bash
[ SAN ]
