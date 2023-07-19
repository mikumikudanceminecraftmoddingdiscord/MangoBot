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

package org.mangorage.mangobot.core.permissions;

import net.dv8tion.jda.api.entities.Member;

import java.util.HashMap;
import java.util.List;


// TODO: Make a Save/Load system at some point!
public class PermissionManager {
    private static final HashMap<String, PermissionManager> MANAGERS = new HashMap<>();

    public static PermissionManager getInstance(String guildID) {
        PermissionManager manager = MANAGERS.getOrDefault(guildID, new PermissionManager());
        if (!MANAGERS.containsKey(guildID))
            MANAGERS.put(guildID, manager);
        return manager;
    }

    private final HashMap<String, List<String>> COMMAND_PERMISSIONS = new HashMap<>();


    public boolean hasPermission(Member member, String command) {
        return false;
    }
}
