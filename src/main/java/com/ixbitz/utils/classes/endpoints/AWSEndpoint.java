/*
 * Project: External-IP-Checker
 *
 * COPYRIGHT: Copyright 2019 AMPLEXOR Netherlands.
 * All Rights Reserved.
 *
 */
package com.ixbitz.utils.classes.endpoints;

import com.ixbitz.utils.classes.ResponsePair;
import com.ixbitz.utils.exceptions.UnexpectedResponseException;

/**
 * Amazon Web Services Implementation of the {@link IEndpoint} interface
 *
 * @since 1.0-SNAPSHOT
 */
public class AWSEndpoint implements IEndpoint {
    private String name;
    private String url;

    public AWSEndpoint() {
        name = "AWS";
        url = "http://checkip.amazonaws.com/";
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
            //AWS returns trailing whitespaces, so we trim it
            return responsePair.getResponseBody().trim();
        } else {
            throw new UnexpectedResponseException();
        }
    }
}
