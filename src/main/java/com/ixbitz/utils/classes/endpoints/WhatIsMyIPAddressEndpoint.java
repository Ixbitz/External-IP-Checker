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
        url = "https://bot.whatismyipaddress.com/";
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
