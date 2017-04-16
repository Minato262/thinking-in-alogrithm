/*
 * Copyright 2017-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kay.com.collection.array;

import org.junit.Test;

/**
 * Message Test.
 *
 * @author kay
 * @version v0.0.1
 */
public class MessageTest {

    @Test
    public void Test1() {
        MessageBean messageBean = new MessageBean();
        System.out.println(messageBean.getMessage());

        MessageBean messageBean1 = new MessageBean(Message.SUCCESS);
        System.out.println(messageBean1.getCode());
    }
}

class MessageBean {
    private String message;
    private String code;

    MessageBean(Message message) {
        this.message = message.getMessage();
        this.code = message.getCode();
    }

    MessageBean() {
        this(Message.ERROR);
    }

    String getMessage() {
        return this.message;
    }

    String getCode() {
        return this.code;
    }
}

enum Message {
    SUCCESS("success", "200"), ERROR("error", "401");

    private String message;
    private String code;

    Message(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }
}
