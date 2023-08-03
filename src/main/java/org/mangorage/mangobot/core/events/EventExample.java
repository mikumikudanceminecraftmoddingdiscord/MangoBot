/*
 * Copyright (c) 2023. MangoRage
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.mangorage.mangobot.core.events;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class EventExample {
    public static final EventBus EVENT_BUS = EventBus.create(EventPriority.NORMAL); // Example Bus for testing purpose!
    public static final EventExample example;

    static {
        example = new EventExample();
        CommandEvent.addListener(EVENT_BUS, commandEvent -> {
            System.out.println("Woooh! 1");
        });

        EVENT_BUS.get(MessageReceivedEvent.class).addListener(event -> {

        });

        CommandEvent.addListener(EVENT_BUS, EventExample::test);

        EVENT_BUS.register(EventExample.class);
        EVENT_BUS.register(example);

        System.out.println("Posted First");
        EVENT_BUS.post(new CommandEvent());

        EVENT_BUS.unregister(example);
        EVENT_BUS.unregister(EventExample.class);


        System.out.println("Posted Second");
        EVENT_BUS.post(new CommandEvent());
    }

    public static void main(String[] args) {
    }

    public static void test(CommandEvent event) {
        System.out.println("Woooh! 2");
    }

    public EventExample() {
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void annotationTest(CommandEvent event) {
        System.out.println("Woooh! 3");
    }
}
