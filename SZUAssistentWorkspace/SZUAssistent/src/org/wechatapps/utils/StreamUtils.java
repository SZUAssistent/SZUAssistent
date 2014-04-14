package org.wechatapps.utils;

import java.io.*;

/*
 * @Description IO Stream Utilities
 * @author Charles Chen
 * @date 14-2-27
 * @version 1.0
 */
public class StreamUtils {
    /**
     * Convert string to input stream
     *
     * @param str     String
     * @param charset Charset
     * @return
     * @throws UnsupportedEncodingException
     */
    public static InputStream stringToInputStream(String str, String charset) throws UnsupportedEncodingException {
        return new ByteArrayInputStream(str.getBytes(charset));
    }

    /**
     * Convert input stream to string
     *
     * @param is Input stream
     * @return
     * @throws IOException
     */
    public static String inputStreamToString(InputStream is, String charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}
