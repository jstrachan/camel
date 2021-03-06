/**
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
package org.apache.camel.impl;

import java.util.Date;

import org.apache.camel.MessageHistory;
import org.apache.camel.NamedNode;
import org.apache.camel.util.StopWatch;

/**
 * Default {@link org.apache.camel.MessageHistory}.
 */
public class DefaultMessageHistory implements MessageHistory {

    private final String routeId;
    private final NamedNode node;
    private final String nodeId;
    private final Date timestamp;
    private final StopWatch stopWatch;

    public DefaultMessageHistory(String routeId, NamedNode node, Date timestamp) {
        this.routeId = routeId;
        this.node = node;
        this.nodeId = node.getId();
        this.timestamp = timestamp;
        this.stopWatch = new StopWatch();
    }

    public String getRouteId() {
        return routeId;
    }

    public NamedNode getNode() {
        return node;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public long getElapsed() {
        return stopWatch.taken();
    }

    public void nodeProcessingDone() {
        stopWatch.stop();
    }

    @Override
    public String toString() {
        return "DefaultMessageHistory["
                + "routeId=" + routeId
                + ", node=" + nodeId
                + ']';
    }
}
