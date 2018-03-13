package com.app.core.util;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@Log4j2
public abstract class GZipUtil {
    /**
     * 压缩GZip
     *
     * @return
     */
    public static String gZip(String input) {
        byte[] bytes = null;
        GZIPOutputStream gzip = null;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            gzip = new GZIPOutputStream(bos);
            gzip.write(input.getBytes(CharEncoding.UTF_8));
            gzip.finish();
            gzip.close();
            bytes = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            log.error("压缩出错：", e);
        } finally {
            IOUtils.closeQuietly(gzip);
            IOUtils.closeQuietly(bos);
        }
        return Base64.encodeBase64String(bytes);
    }

    /**
     * 解压GZip
     *
     * @return
     */
    public static String unGZip(String input) {
        byte[] bytes = null;
        String out = input;
        GZIPInputStream gzip = null;
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        try {
            bis = new ByteArrayInputStream(Base64.decodeBase64(input));
            gzip = new GZIPInputStream(bis);
            byte[] buf = new byte[1024];
            int num = -1;
            bos = new ByteArrayOutputStream();
            while ((num = gzip.read(buf, 0, buf.length)) != -1) {
                bos.write(buf, 0, num);
            }
            bytes = bos.toByteArray();
            out = new String(bytes, CharEncoding.UTF_8);
            gzip.close();
            bis.close();
            bos.flush();
            bos.close();
        } catch (Exception e) {
            log.error("解压出错：", e);
        } finally {
            IOUtils.closeQuietly(gzip);
            IOUtils.closeQuietly(bos);
        }
        return out;
    }
}