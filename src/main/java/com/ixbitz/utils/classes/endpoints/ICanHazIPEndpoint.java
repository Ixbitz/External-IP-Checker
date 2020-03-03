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
 * ICanHazIP Implementation of the {@link IEndpoint} interface
 *
 * @since 1.0-SNAPSHOT
 */
public class ICanHazIPEndpoint implements IEndpoint {
    private String name;
    private String url;

    public ICanHazIPEndpoint() {
        name = "ICanHazIP";
        url = "http://icanhazip.com/";
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
            //ICanHazIP returns trailing whitespaces, so we trim it
            return responsePair.getResponseBody().trim();
        } else {
            throw new UnexpectedResponseException();
        }
    }
}
