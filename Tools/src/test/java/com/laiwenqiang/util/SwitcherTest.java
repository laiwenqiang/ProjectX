package com.laiwenqiang.util;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Switcher 类的单元测试
 */
public class SwitcherTest {

    @Test
    public void testFileSwitch_WhenFileExists() throws Exception {
        new File("switch.payment.enabled").createNewFile();
        assertTrue(Switcher.PAYMENT_SWITCH.isOpen());
    }

    @Test
    public void testFileSwitch_WhenFileNotExists() throws Exception {
        new File("switch.payment.enabled").delete();
        assertFalse(Switcher.PAYMENT_SWITCH.isOpen());
    }
}