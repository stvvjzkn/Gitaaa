package factory;

import java.util.ResourceBundle;

/**
 * 工厂设计模式
 */
public class Factory{
    // 加载配置文件
    private static ResourceBundle bundle;
    static {
        bundle = ResourceBundle.getBundle("instance");
    }

    /**
     * 泛型方法
     * @param key
     *
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static<T>T getInstance(String key) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class className=Class.forName(bundle.getString(key));
        return (T) className.newInstance();
    }
}
