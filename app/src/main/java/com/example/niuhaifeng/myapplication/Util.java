package com.example.niuhaifeng.myapplication;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Util {
    public static String readFromResource(Context context, int id) {
        try (InputStream in = context.getResources().openRawResource(id);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buf = new byte[4096];
            for (; ; ) {
                int i = in.read(buf);
                if (i < 0)
                    break;
                out.write(buf, 0, i);
            }
            return out.toString("UTF-8");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
