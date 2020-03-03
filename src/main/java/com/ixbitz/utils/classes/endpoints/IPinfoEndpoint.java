/*
 * Project: External-IP-Checker
 *
 * Author: Job Putters
 *
 */
package com.ixbitz.utils.classes.endpoints;

import com.ixbitz.utils.classes.ResponsePair;
import com.ixbitz.utils.exceptions.UnexpectedResponseException;

/**
 * IpInfo.io Implementation of the {@link IEndpoint} interface
 *
 * @since 1.0-SNAPSHOT
 */
public class IPinfoEndpoint implements IEndpoint {
    private String name;
    private String url;

    public IPinfoEndpoint() {
        name = "IPInfo";
        url = "http://ipinfo.io/ip";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String handleResponse(ResponsePair responsePair) throws UnexpectedResponseException {
        if (responsePair.getResponseCode() == 200) {
            return responsePair.getResponseBody();
        } else {
            throw new UnexpectedResponseException();
        }
    }
}
