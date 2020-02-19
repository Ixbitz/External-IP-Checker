package com.ixbitz.utils;

import com.ixbitz.utils.classes.ResponsePair;
import com.ixbitz.utils.classes.endpoints.IEndpoint;
import com.ixbitz.utils.classes.utils.Utils;
import com.ixbitz.utils.exceptions.HttpException;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class App {
    private static final Marker IP = MarkerFactory.getMarker("IP");
    private static final Marker ERROR = MarkerFactory.getMarker("ERROR");
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.ixbitz.utils");
        Set<Class<? extends IEndpoint>> classes = reflections.getSubTypesOf(IEndpoint.class);

        for (Class<? extends IEndpoint> aClass : classes) {
            String name = "UNKNOWN";
            try {
                Method getNameMethod = aClass.getMethod("getName");
                name = (String) getNameMethod.invoke(aClass.getDeclaredConstructor().newInstance());

                Method getUrlMethod = aClass.getMethod("getUrl");
                Method handleResponseMethod = aClass.getMethod("handleResponse", ResponsePair.class);

                String url = (String) getUrlMethod.invoke(aClass.getDeclaredConstructor().newInstance());
                String ipAddress = (String) handleResponseMethod.invoke(aClass.getDeclaredConstructor().newInstance(),Utils.doHttpRequest(url));

                LOGGER.info(IP, "{}: {}", name, ipAddress);
                break;
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | HttpException | InvocationTargetException e) {
                LOGGER.error(ERROR, "Error while retrieving IP from {}", name);
            }
        }
    }
}
