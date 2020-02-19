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
    String getName();
    String getUrl();

    /**
     * Used to convert a domain specific http response to just an IP address
     * @param responsePair responseCode and body
     * @return an ip address
     * @throws UnexpectedResponseException when there is not a successful result
     */
    String handleResponse(ResponsePair responsePair) throws UnexpectedResponseException;
}
