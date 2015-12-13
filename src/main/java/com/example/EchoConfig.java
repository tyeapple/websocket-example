/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class EchoConfig implements ServerApplicationConfig {

    private static Logger logger = Logger.getLogger("root");

    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(
            Set<Class<? extends Endpoint>> scanned) {

        logger.info("AAAAAAAA");
        Set<ServerEndpointConfig> result = new HashSet<ServerEndpointConfig>();

//        if (scanned.contains(EchoEndpoint.class)) {
//            result.add(ServerEndpointConfig.Builder.create(
//                    EchoEndpoint.class,
//                    "/websocket/echo").build());
//        }

        logger.info("programatic");
        return result;
    }

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
        // Deploy all WebSocket endpoints defined by annotations in the examples
        // web application. Filter out all others to avoid issues when running
        // tests on Gump
        logger.info("XXXXXXXXXXXXXXXXX");
        Set<Class<?>> results = new HashSet<Class<?>>();
        for (Class<?> clazz : scanned) {
            logger.info("class name:"+clazz.getPackage().getName());
            if (clazz.getPackage().getName().startsWith("com.example.server")) {
                results.add(clazz);
                logger.info("ExamplesConfig, added class :"+clazz.getName());
            }
        }
        return results;
    }
}
