/*
 * Project: External-IP-Checker
 *
 * COPYRIGHT: Copyright 2019 AMPLEXOR Netherlands.
 * All Rights Reserved.
 *
 */
package com.ixbitz.utils.classes.utils;

import com.ixbitz.utils.classes.ResponsePair;
import com.ixbitz.utils.exceptions.HttpException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Utility class
 *
 * @since 1.0-SNAPSHOT
 */
public class Utils {
    private Utils() {

    }

    public static ResponsePair doHttpRequest(String inputUrl) throws HttpException {
        try {
            URL url = new URL(inputUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setInstanceFollowRedirects(true);

            StringBuilder content = new StringBuilder();
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
                bufferedReader.lines().forEach(content::append);
            }

            httpURLConnection.disconnect();

            return new ResponsePair(httpURLConnection.getResponseCode(), content.toString());
        } catch (IOException e) {
            throw new HttpException("HttpRequest Error", e);
        }
    }
}
