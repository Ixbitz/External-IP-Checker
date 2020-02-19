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

public interface IEndpoint {
    /**
     * Gets the name of an endpoint
     * @return name of the endpoint
     */
    String getName();

    /**
     * Gets the url of an endpoint
     * @return url of the endpoint
     */
    String getUrl();

    /**
     * Used to convert a domain specific http response to just an IP address
     * @param responsePair responseCode and body
     * @return an ip address
     * @throws UnexpectedResponseException when there is not a successful result
     */
    String handleResponse(ResponsePair responsePair) throws UnexpectedResponseException;
}
