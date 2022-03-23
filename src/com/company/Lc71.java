package com.company;

/*
 * 71. Simplify Path
 *
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 */

import java.util.Deque;
import java.util.LinkedList;

public class Lc71 implements Answer {
    @Override
    public int getIndex() {
        return 71;
    }

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String txt[] = path.split("/");

        for(String t : txt){
            if(!(t.equals("") || t.equals(".") || t.equals(".."))) {
                stack.push(t);
            }else if(!stack.isEmpty() && t.equals("..")){
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}
