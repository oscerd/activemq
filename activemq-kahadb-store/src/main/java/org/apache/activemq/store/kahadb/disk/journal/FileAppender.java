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
package org.apache.activemq.store.kahadb.disk.journal;

import org.apache.activemq.util.ByteSequence;

import java.io.IOException;

public interface FileAppender {
    public static final String PROPERTY_LOG_WRITE_STAT_WINDOW = "org.apache.kahadb.journal.appender.WRITE_STAT_WINDOW";
    public static final int maxStat = Integer.parseInt(System.getProperty(PROPERTY_LOG_WRITE_STAT_WINDOW, "0"));

    Location storeItem(ByteSequence data, byte type, boolean sync) throws IOException;

    Location storeItem(ByteSequence data, byte type, Runnable onComplete) throws IOException;

    void close() throws IOException;
}
