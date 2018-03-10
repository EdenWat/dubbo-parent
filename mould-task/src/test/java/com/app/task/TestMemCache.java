package com.app.task;

import com.app.core.BaseTestCase;
import com.app.core.util.MemCachedUtil;
import org.junit.Test;

public class TestMemCache extends BaseTestCase {
    @Test
    public void test() {
        String a1101 = (String) MemCachedUtil.get("a1102");
        System.out.println(a1101);

        boolean b = MemCachedUtil.add("a1102", "hello world!");
        System.out.println(b);


        a1101 = MemCachedUtil.get("a1102").toString();
        System.out.println(a1101);

        boolean b1 = MemCachedUtil.flashAll();
        System.out.println(b1);

    }
}
