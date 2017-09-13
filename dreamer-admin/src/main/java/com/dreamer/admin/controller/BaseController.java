package com.dreamer.admin.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by J.W on 2017/8/8 0008.
 */
public abstract class BaseController {

    protected static final String REDIRECT = "redirect:";

    protected static final String PAGE_URL_PREFIX = "/backend/";

    /**
     * 返回字节流
     *
     * @param bytes
     */
    protected void writeResponse(HttpServletResponse response, byte[] bytes) throws IOException {
        response.setContentType("image/jpg"); //设置返回的文件类型
        try (OutputStream os = response.getOutputStream()) {
            os.write(bytes);
            os.flush();
            os.close();
        } catch (IOException e) {
            throw e;
        }
    }

}
