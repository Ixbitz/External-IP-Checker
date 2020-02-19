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
 * WhatIsMyIPAddress Implementation of the {@link IEndpoint} interface
 *
 * @since 1.0-SNAPSHOT
 */
public class WhatIsMyIPAddressEndpoint implements IEndpoint {
    String name;
    String url;

    public WhatIsMyIPAddressEndpoint() {
        name = "WhatIsMyIPAdddress";
        url = "http://www.mocky.io/v2/5e4bf6083100005500d8bb24";
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
