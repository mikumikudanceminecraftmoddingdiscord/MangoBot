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

package org.mangorage.mangobotapi.core.util;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.exceptions.InvalidTokenException;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class BotUtil {
    public static boolean isValidBotToken(String token) {
        var bot = JDABuilder.createDefault(token);
        JDA jda = null;
        try {
            jda = bot.build();
        } catch (InvalidTokenException e) {
            return false;
        } finally {
            if (jda != null && jda.getStatus() != JDA.Status.DISCONNECTED)
                jda.shutdownNow();
        }

        return true;
    }

    @SuppressWarnings("all")
    public static List<File> getFilesInDir(String dir) {
        File file = new File(dir);
        if (file.isDirectory() && file.listFiles() != null)
            return Arrays.asList(file.listFiles());
        return List.of();
    }
}
