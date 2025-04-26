package com.laiwenqiang.util;

import java.io.File;

/**
 * @author Lion
 * @date 2025/4/25 21:25
 */
public enum Switcher {
    PAYMENT_SWITCH("switch.payment.enabled", SwitchSource.FILE),
    SKIP_C3("switch.skip.c3", SwitchSource.DATABASE);

    private final String key;
    private final SwitchSource switchSource;

    Switcher(String key, SwitchSource switchSource) {
        this.key = key;
        this.switchSource = switchSource;
    }

    public boolean isOpen() {
        return switchSource.getChecker().isEnabled(key);
    }

    // --------------------------------------------------------
    // 开关存储源
    enum SwitchSource {
        FILE {
            @Override
            SwitchChecker getChecker() {
                return FileChecker.INSTANCE;
            }
        },
        DATABASE {
            @Override
            SwitchChecker getChecker() {
                return DatabaseChecker.INSTANCE;
            }
        };

        abstract SwitchChecker getChecker();
    }

    // 开关检查器接口
    interface SwitchChecker {
        boolean isEnabled(String key);
    }

    // 文件开关检查器
    static class FileChecker implements SwitchChecker {
        private static final FileChecker INSTANCE = new FileChecker();

        private FileChecker() {}

        @Override
        public boolean isEnabled(String key) {
            return new File(key).exists();
        }
    }

    // 数据库开关检查器
    static class DatabaseChecker implements SwitchChecker {
        private static final DatabaseChecker INSTANCE = new DatabaseChecker();

        private DatabaseChecker() {}

        @Override
        public boolean isEnabled(String key) {
            return false; // 数据库实现待完成
        }
    }
}
